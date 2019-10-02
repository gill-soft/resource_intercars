package com.gillsoft;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.Callable;

import org.apache.commons.lang.time.DateUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.joda.time.Days;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RestController;

import com.gillsoft.abstract_rest_service.SimpleAbstractTripSearchService;
import com.gillsoft.cache.CacheHandler;
import com.gillsoft.client.Config;
import com.gillsoft.client.ResponseError;
import com.gillsoft.client.RestClient;
import com.gillsoft.client.TariffType;
import com.gillsoft.client.TripIdModel;
import com.gillsoft.client.TripPackage;
import com.gillsoft.model.ArrayOfExternalPrice;
import com.gillsoft.model.Currency;
import com.gillsoft.model.Document;
import com.gillsoft.model.ExternalPrice;
import com.gillsoft.model.Lang;
import com.gillsoft.model.Locality;
import com.gillsoft.model.Organisation;
import com.gillsoft.model.PathL;
import com.gillsoft.model.Price;
import com.gillsoft.model.RequiredField;
import com.gillsoft.model.RestError;
import com.gillsoft.model.ReturnCondition;
import com.gillsoft.model.Route;
import com.gillsoft.model.RoutePoint;
import com.gillsoft.model.Seat;
import com.gillsoft.model.SeatsScheme;
import com.gillsoft.model.Segment;
import com.gillsoft.model.StopPath;
import com.gillsoft.model.Tariff;
import com.gillsoft.model.Trip;
import com.gillsoft.model.TripContainer;
import com.gillsoft.model.Vehicle;
import com.gillsoft.model.request.TripSearchRequest;
import com.gillsoft.model.response.TripSearchResponse;
import com.gillsoft.util.StringUtil;

@RestController
public class SearchServiceController extends SimpleAbstractTripSearchService<TripPackage> {

	private static Logger LOGGER = LogManager.getLogger(SearchServiceController.class);
	
	@Autowired
	private RestClient client;
	
	@Autowired
	@Qualifier("MemoryCacheHandler")
	private CacheHandler cache;

	@Override
	public List<ReturnCondition> getConditionsResponse(String arg0, String arg1) {
		throw RestClient.createUnavailableMethod();
	}

	@Override
	public List<Document> getDocumentsResponse(String arg0) {
		throw RestClient.createUnavailableMethod();
	}

	@Override
	public List<Tariff> getTariffsResponse(String arg0) {
		List<Tariff> listTariff = new ArrayList<>();
		TripIdModel idModel = new TripIdModel().create(arg0);
		for (TariffType tariffType : TariffType.values()) {
			Tariff tariff = new Tariff();
			tariff.setId(String.valueOf(tariffType.getId()));
			tariff.setDescription(tariffType.getName());
			tariff.setMinAge(tariffType.getMinAge());
			tariff.setMaxAge(tariffType.getMaxAge());
			switch (tariffType) {
			case CHILD:
				tariff.setValue(idModel.getDtar());
				break;
			case TEEN:
			case SENIOR:
				tariff.setValue(idModel.getEtar());
				break;
			default:
				tariff.setValue(idModel.getPtar());
			}
			listTariff.add(tariff);
		}
		return listTariff;
	}

	@Override
	public List<RequiredField> getRequiredFieldsResponse(String arg0) {
		return Arrays.asList(RequiredField.NAME, RequiredField.SURNAME, RequiredField.PHONE, RequiredField.EMAIL);
	}

	@Override
	public Route getRouteResponse(String arg0) {
		throw RestClient.createUnavailableMethod();
	}

	@Override
	public SeatsScheme getSeatsSchemeResponse(String arg0) {
		throw RestClient.createUnavailableMethod();
	}
	
	@Override
	public List<Seat> updateSeatsResponse(String arg0, List<Seat> arg1) {
		throw RestClient.createUnavailableMethod();
	}
	
	@Override
	public List<Seat> getSeatsResponse(String tripId) {
		throw RestClient.createUnavailableMethod();
	}

	@Override
	public TripSearchResponse initSearchResponse(TripSearchRequest request) {
		return simpleInitSearchResponse(cache, request);
	}
	
	@Override
	public void addInitSearchCallables(List<Callable<TripPackage>> callables, String[] pair, Date date) {
		callables.add(() -> {
			try {
				validateSearchParams(pair, date);
				TripPackage tripPackage = client.getCachedTrips(pair[0], pair[1], date);
				if (tripPackage == null) {
					throw new ResponseError("Empty result");
				}
				tripPackage.setRequest(TripSearchRequest.createRequest(pair, date));
				return tripPackage;
			} catch (ResponseError e) {
				TripPackage tripPackage = new TripPackage();
				tripPackage.setError(e);
				tripPackage.setRequest(TripSearchRequest.createRequest(pair, date));
				return tripPackage;
			} catch (Exception e) {
				return null;
			}
		});
	}
	
	/*@Override
	public void addInitSearchCallables(List<Callable<TripPackage>> callables, TripSearchRequest request) {
		callables.add(() -> {
			try {
				validateSearchParams(request.getLocalityPairs().get(0), request.getDates().get(0));
				TripPackage tripPackage = client.getCachedTrips(request.getLocalityPairs().get(0)[0],
						request.getLocalityPairs().get(0)[1], request.getDates().get(0));
				if (tripPackage == null) {
					throw new ResponseError("Empty result");
				}
				//tripPackage.setRequest(TripSearchRequest.createRequest(request.getLocalityPairs().get(0), request.getDates().get(0)));
				tripPackage.setRequest(request);
				return tripPackage;
			} catch (ResponseError e) {
				LOGGER.error(e);
				TripPackage tripPackage = new TripPackage(request, e);
				//tripPackage.setRequest(TripSearchRequest.createRequest(request.getLocalityPairs().get(0), request.getDates().get(0)));
				return tripPackage;
			} catch (Exception e) {
				LOGGER.error(e);
				return null;
			}
		});
	}*/
	
	private static void validateSearchParams(String[] pair, Date date) throws ResponseError {
		if (date == null
				|| date.getTime() < DateUtils.truncate(new Date(), Calendar.DATE).getTime()) {
			throw new ResponseError("Invalid parameter \"date\"");
		}
		if (pair == null || pair.length < 2) {
			throw new ResponseError("Invalid parameter \"pair\"");
		}
	}
	
	@Override
	public TripSearchResponse getSearchResultResponse(String searchId) {
		return simpleGetSearchResponse(cache, searchId);
	}
	
	@Override
	public void addNextGetSearchCallablesAndResult(List<Callable<TripPackage>> callables, Map<String, Vehicle> vehicles,
			Map<String, Locality> localities, Map<String, Organisation> organisations, Map<String, Segment> segments,
			List<TripContainer> containers, TripPackage tripPackage) {
		if (!tripPackage.isContinueSearch()) {
			addResult(vehicles, localities, organisations, segments, containers, tripPackage);
		} else if (tripPackage.getRequest() != null) {
			addInitSearchCallables(callables, tripPackage.getRequest().getLocalityPairs().get(0),
					tripPackage.getRequest().getDates().get(0));
		}
	}
	
	private void addResult(Map<String, Vehicle> vehicles, Map<String, Locality> localities,
			Map<String, Organisation> organisations, Map<String, Segment> segments, List<TripContainer> containers, TripPackage tripPackage) {
		TripContainer container = new TripContainer();
		container.setRequest(tripPackage.getRequest());
		if (tripPackage != null && tripPackage.getPathList() != null
				&& !tripPackage.getPathList().isEmpty()) {
			List<Trip> trips = new ArrayList<>();
			Locality departure = null;
			Locality arrival = null;
			if (tripPackage.getStopPath() != null && tripPackage.getStopPath().getStopPath() != null
					&& !tripPackage.getStopPath().getStopPath().isEmpty()) {
				departure = getStation(tripPackage.getStopPath().getStopPath().get(0).getCity(), localities);
				arrival = getStation(tripPackage.getStopPath().getStopPath()
						.get(tripPackage.getStopPath().getStopPath().size() - 1).getCity(), localities);
			}
			for (PathL pathL : tripPackage.getPathList()) {
				Date departureDate = null;
				try {
					departureDate = RestClient.dateFormatFull.parse(pathL.getTimeOut());
				} catch (Exception e) {}
				if ((departure == null || arrival == null) && pathL.getAllStops() != null
						&& pathL.getAllStops().getStopping() != null && !pathL.getAllStops().getStopping().isEmpty()) {
					departure = getStation(pathL.getAllStops().getStopping().get(0).getCityEng(), localities);
					arrival = getStation(pathL.getAllStops().getStopping()
							.get(pathL.getAllStops().getStopping().size() - 1).getCityEng(), localities);
				}
				Trip tmpTrip = new Trip();
				ExternalPrice price = getPrice(pathL.getPrices(), tripPackage.getRequest().getCurrency());
				tmpTrip.setId(new TripIdModel(pathL.getPathId(), Integer.valueOf(departure.getId()), Integer.valueOf(arrival.getId()), departureDate, price).asString());
				trips.add(tmpTrip);
				String segmentId = tmpTrip.getId();
				Segment segment = segments.get(segmentId);
				if (segment == null) {
					segment = new Segment();
					segment.setId(tmpTrip.getId());
					segment.setNumber(String.valueOf(pathL.getRouteId()));
					try {
						segment.setDepartureDate(departureDate);
						segment.setArrivalDate(RestClient.dateFormatFull.parse(pathL.getTimeIn()));
					} catch (Exception e) { }
					segment.setFreeSeatsCount(1);
					segments.put(segmentId, segment);
				}
				if (departure != null) {
					segment.setDeparture(departure);
					segment.setArrival(arrival);
					segment.setRoute(createRoute(tripPackage, pathL, localities));
					segment.setCarrier(getCarrier(pathL.getCarrier(), organisations));
				}
				addPrice(segment, price);
			}
			container.setTrips(trips);
		}
		if (tripPackage.getError() != null) {
			container.setError(new RestError(tripPackage.getError().getMessage()));
		}
		containers.add(container);
	}

	private Route createRoute(TripPackage tripPackage, PathL pathL, Map<String, Locality> localities) {
		Route route = new Route();
		route.setPath(new ArrayList<>());
		if (tripPackage.getStopPath() != null && tripPackage.getStopPath().getStopPath() != null && !tripPackage.getStopPath().getStopPath().isEmpty()) {
			Date departureDate = null;
			try {
				departureDate = RestClient.dateFormatFull.parse(tripPackage.getStopPath().getStopPath().get(0).getData()
						+ ' ' + tripPackage.getStopPath().getStopPath().get(0).getTimeOut());
				for (StopPath stopPath : tripPackage.getStopPath().getStopPath()) {
					RoutePoint routePoint = new RoutePoint();
					try {
						routePoint.setArrivalDay(Days
								.daysBetween(new LocalDate(departureDate.getTime()),
										new LocalDate(RestClient.dateFormatFull
												.parse(stopPath.getData() + ' ' + stopPath.getTimeIn()).getTime()))
								.getDays());
					} catch (Exception e) {}
					routePoint.setLocality(getStation(stopPath.getCity(), localities));
					localities.get(routePoint.getLocality().getId()).setAddress(Lang.RU, stopPath.getNameStop());
					routePoint.setDepartureTime(stopPath.getData() + ' ' + stopPath.getTimeOut());
					route.getPath().add(routePoint);
				}
			} catch (Exception e) {}
		} else if (pathL.getAllStops() != null && pathL.getAllStops().getStopping() != null && !pathL.getAllStops().getStopping().isEmpty()) {
			try {
				final Date departureDate = RestClient.dateFormatFull.parse(pathL.getTimeOut());
				pathL.getAllStops().getStopping().forEach(stopping -> {
					RoutePoint routePoint = new RoutePoint();
					try {
						routePoint.setArrivalDay(Days.daysBetween(new LocalDate(departureDate.getTime()),
								new LocalDate(RestClient.dateFormatFull
										.parse(stopping.getDateArrive() + ' ' + stopping.getTimeArrive()).getTime()))
								.getDays());
					} catch (Exception e) {
					}
					routePoint.setArrivalTime(stopping.getTimeArrive());
					routePoint.setLocality(getStation(stopping.getCityEng(), localities));
					routePoint.getLocality().setAddress(Lang.RU, stopping.getNameRus());
					routePoint.getLocality().setAddress(Lang.EN, stopping.getNameEng());
					route.getPath().add(routePoint);
				});
			} catch (Exception e) {
				LOGGER.error(e);
			}
		}
		return route.getPath().isEmpty() ? null : route;
	}
	
	private ExternalPrice getPrice(ArrayOfExternalPrice prices, Currency currency) {
		Optional<ExternalPrice> optional = null;
		if (currency != null) {
			optional = prices.getExternalPrice().stream()
				.filter(f -> f.getCurrencyName().equals(String.valueOf(currency))).findFirst();
			if (optional.isPresent()) {
				return optional.get();
			}
		}
		if (Config.getCurrency() != null) {
			optional = prices.getExternalPrice().stream()
					.filter(f -> f.getCurrencyName().equals(Config.getCurrency())).findFirst();
			if (optional.isPresent()) {
				return optional.get();
			}
		}
		return prices.getExternalPrice().get(0);
	}

	private void addPrice(Segment segment, ExternalPrice price) {
		Price tripPrice = new Price();
		Tariff tariff = new Tariff();
		tariff.setValue(price.getPtar());
		tariff.setName(TariffType.ADULT.getName());
		tripPrice.setCurrency(Currency.valueOf(price.getCurrencyName()));
		tripPrice.setAmount(tariff.getValue());
		tripPrice.setTariff(tariff);
		segment.setPrice(tripPrice);
	}
	
	private Organisation getCarrier(String carrierName, Map<String, Organisation> organisations) {
		String carrierId = StringUtil.md5(carrierName);
		Organisation carrier = organisations.get(carrierId);
		if (carrier == null) {
			carrier = new Organisation(carrierId);
			carrier.setName(Lang.EN, carrierName);
			organisations.put(carrier.getId(), carrier);
		}
		return new Organisation(carrierId);
	}

	public static Locality getStation(String name, Map<String, Locality> localities) {
		Locality locality = LocalityServiceController.getLocalityByName(name);
		if (locality == null) {
			return null;
		}
		if (!localities.containsKey(locality.getId())) {
			localities.put(locality.getId(), locality);
		}
		return new Locality(locality.getId());
	}

}
