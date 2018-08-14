package com.gillsoft.client;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.logging.log4j.core.util.datetime.FastDateFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;

import com.gillsoft.cache.CacheHandler;
import com.gillsoft.cache.IOCacheException;
import com.gillsoft.cache.RedisMemoryCache;
import com.gillsoft.model.ArrayOfCityS;
import com.gillsoft.model.ArrayOfStopPath;
import com.gillsoft.model.ArrayOfString;
import com.gillsoft.model.CancelTicket;
import com.gillsoft.model.PathL;
import com.gillsoft.model.WebServiceExternal;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class RestClient {

	public static final String STATIONS_CACHE_KEY = "intercars.stations.";
	public static final String TRIPS_CACHE_KEY = "intercars.trips.";

	public static final String DATE_FORMAT = "dd.MM.yyyy";
	public static final String DATE_FORMAT_FULL = "dd.MM.yyyy HH:mm";
	public final static FastDateFormat dateFormat = FastDateFormat.getInstance(DATE_FORMAT);
	public final static FastDateFormat dateFormatFull = FastDateFormat.getInstance(DATE_FORMAT_FULL);

	private final static String emptyString = "";

	@Autowired
	@Qualifier("RedisMemoryCache")
	private CacheHandler cache;

	private static final WebServiceExternal webService = new WebServiceExternal();

	public RestClient() {

	}

	/****************** STATIONS ********************/
	public ArrayOfCityS getCachedStations() throws IOCacheException {
		Map<String, Object> params = new HashMap<>();
		params.put(RedisMemoryCache.OBJECT_NAME, RestClient.STATIONS_CACHE_KEY);
		params.put(RedisMemoryCache.IGNORE_AGE, true);
		params.put(RedisMemoryCache.UPDATE_DELAY, Config.getCacheStationsUpdateDelay());
		params.put(RedisMemoryCache.UPDATE_TASK, new StationsUpdateTask());
		return (ArrayOfCityS) cache.read(params);
	}

	public ArrayOfCityS getAllStations() throws ResponseError {
		try {
			return RestClient.webService.getWebServiceExternalSoap().getCity();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ResponseError(e.getMessage(), e);
		}
	}

	/****************** TRIPS ********************/
	public TripPackage getCachedTrips(String from, String to, Date dispatch) throws ResponseError {
		TripsTaskKey key = new TripsTaskKey(from, to, dispatch);
		Map<String, Object> params = new HashMap<>();
		params.put(RedisMemoryCache.OBJECT_NAME, key.toString());
		params.put(RedisMemoryCache.UPDATE_TASK, new GetTripsTask(key));
		try {
			return (TripPackage) cache.read(params);
		} catch (IOCacheException e) {
			e.printStackTrace();
			// ставим пометку, что кэш еще формируется
			TripPackage tripPackage = new TripPackage();
			tripPackage.setContinueSearch(true);
			return tripPackage;
		} catch (Exception e) {
			throw new ResponseError(e.getMessage());
		}
	}

	public TripPackage findPath(TripsTaskKey key) throws ResponseError {
		try {
			List<PathL> pathList = RestClient.webService.getWebServiceExternalSoap()
					.findPath(key.getCityStartInt(), key.getCityEndInt(), dateFormat.format(key.getDate())).getPathL();
			ArrayOfStopPath stopPath = RestClient.webService.getWebServiceExternalSoap()
					.getStopPath(key.getCityStartInt(), key.getCityEndInt(), dateFormat.format(key.getDate()));
			return new TripPackage(pathList, stopPath);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ResponseError(e.getMessage(), e);
		}
	}

	/****************** RESERVATION/PAY/CANCEL ********************/
	public void bookingTicket(Map<String, List<OrderIdModelObject>> serviceMap, OrderIdModel orderIdModel)
			throws ResponseError {
		for (Entry<String, List<OrderIdModelObject>> mapEntry : serviceMap.entrySet()) {
			TripIdModel tripModel = new TripIdModel().create(mapEntry.getKey());
			for (OrderIdModelObject orderIdModelObject : mapEntry.getValue()) {
				ArrayOfString bookingResult = RestClient.webService.getWebServiceExternalSoap().bookingTicket(
						Config.getLogin(), Config.getPassword(), tripModel.getCityStart(), tripModel.getCityEnd(), 1,
						dateFormat.format(tripModel.getDateDepart()),
						tripModel.getDateReturn() == null ? "CLOSE" : dateFormat.format(tripModel.getDateReturn()),
						tripModel.getPathId(),
						tripModel.getPathIdReturn() == null ? RestClient.emptyString : tripModel.getPathIdReturn());
				List<OrderIdModelObject> list = orderIdModel.getServices().get(mapEntry.getKey());
				if (list == null) {
					list = new ArrayList<>();
					orderIdModel.getServices().put(mapEntry.getKey(), list);
				}
				orderIdModelObject.setTicketNumber(bookingResult.getString().get(0));
				list.add(orderIdModelObject);
			}
		}
	}

	public void createTicket(OrderIdModel orderIdModel) {
		for (String key : orderIdModel.getServices().keySet()) {
			TripIdModel tripModel = new TripIdModel().create(key);
			for (OrderIdModelObject service : orderIdModel.getServices().get(key)) {
				try {
					Boolean createTicketResult = RestClient.webService.getWebServiceExternalSoap().createTicket(
							Config.getLogin(), Config.getPassword(), service.getTicketNumber(),
							tripModel.getCityStart(), tripModel.getCityEnd(),
							dateFormat.format(tripModel.getDateDepart()),
							tripModel.getDateReturn() == null ? "CLOSE" : dateFormat.format(tripModel.getDateReturn()),
							service.getTariffId(), service.getCurrencyId(), service.getCustomer().getName(),
							service.getCustomer().getSurname(),
							service.getCustomer().getDocumentSeries() != null
									&& service.getCustomer().getDocumentNumber() != null
											? service.getCustomer().getDocumentSeries()
													+ service.getCustomer().getDocumentNumber()
											: RestClient.emptyString,
							service.getCustomer().getPhone() == null ? RestClient.emptyString
									: service.getCustomer().getPhone(),
							Config.getTicketEmail() == null || Config.getTicketEmail().isEmpty()
									? service.getCustomer().getEmail() == null ? RestClient.emptyString
											: service.getCustomer().getEmail()
									: Config.getTicketEmail(),
							service.getCustomer().getPatronymic() == null ? RestClient.emptyString
									: service.getCustomer().getPatronymic(),
							service.getCustomer().getBirthday() == null ? RestClient.emptyString
									: dateFormat.format(service.getCustomer().getBirthday()));
					service.setCreateTicketResult(createTicketResult);
				} catch (Exception e) {
					service.setCreateTicketResult(false);
					service.setCreateTicketError(e.getMessage());
				}
			}
		}
	}

	public void cancelationTicket(OrderIdModel orderIdModel) {
		for (String key : orderIdModel.getServices().keySet()) {
			for (OrderIdModelObject orderIdModelObject : orderIdModel.getServices().get(key)) {
				try {
					CancelTicket cancelTicket = RestClient.webService.getWebServiceExternalSoap()
							.cancelationTicket(Config.getLogin(), Config.getPassword(), orderIdModelObject.getTicketNumber());
					if (!cancelTicket.isSuccess()) {
						throw new Exception(cancelTicket.getError());
					}
					orderIdModelObject.setCancellationTicketResult(true);
					orderIdModelObject.setReturnPrice(cancelTicket.getReturnPrice());
				} catch (Exception e) {
					e.printStackTrace();
					orderIdModelObject.setCancellationTicketResult(false);
					orderIdModelObject.setCancellationTicketError(e.getMessage());
				}
			}
		}
	}

	public CacheHandler getCache() {
		return cache;
	}

	public static RestClientException createUnavailableMethod() {
		return new RestClientException("Method is unavailable");
	}

}
