package com.gillsoft;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.gillsoft.abstract_rest_service.AbstractOrderService;
import com.gillsoft.client.OrderIdModel;
import com.gillsoft.client.OrderIdModelObject;
import com.gillsoft.client.ResponseError;
import com.gillsoft.client.RestClient;
import com.gillsoft.client.TariffType;
import com.gillsoft.client.TripIdModel;
import com.gillsoft.model.Currency;
import com.gillsoft.model.Customer;
import com.gillsoft.model.Price;
import com.gillsoft.model.RestError;
import com.gillsoft.model.Segment;
import com.gillsoft.model.ServiceItem;
import com.gillsoft.model.request.OrderRequest;
import com.gillsoft.model.response.OrderResponse;

@RestController
public class OrderServiceController extends AbstractOrderService {
	
	@Autowired
	private RestClient client;

	@Override
	public OrderResponse addServicesResponse(OrderRequest request) {
		throw RestClient.createUnavailableMethod();
	}

	@Override
	public OrderResponse bookingResponse(String orderId) {
		throw RestClient.createUnavailableMethod();
	}

	@Override
	public OrderResponse cancelResponse(String orderId) {
		// формируем ответ
		OrderResponse response = new OrderResponse();
		List<ServiceItem> resultItems = new ArrayList<>();
		// преобразовываем ид заказа в объект
		OrderIdModel orderIdModel = new OrderIdModel().create(orderId);
		client.cancelationTicket(orderIdModel);
		addServiceItems(resultItems, orderIdModel);
		response.setOrderId(orderIdModel.asString());
		response.setServices(resultItems);
		return response;
	}

	@Override
	public OrderResponse createResponse(OrderRequest request) {
		// формируем ответ
		OrderResponse response = new OrderResponse();
		response.setCustomers(request.getCustomers());
		// копия для определения пассажиров
		List<ServiceItem> items = new ArrayList<>();
		items.addAll(request.getServices());
		// список билетов
		OrderIdModel orderId = new OrderIdModel();
		Map<String, List<OrderIdModelObject>> serviceMap = new HashMap<>();
		for (ServiceItem service : request.getServices()) {
			List<OrderIdModelObject> customers = serviceMap.get(service.getSegment().getId());
			if (customers == null) {
				customers = new ArrayList<>();
				serviceMap.put(service.getSegment().getId(), customers);
			}
			Customer customer = request.getCustomers().get(service.getCustomer().getId());
			if (customer != null) {
				customer.setId(service.getCustomer().getId());
				OrderIdModelObject orderIdModelObject = new OrderIdModelObject(customer);
				if (service.getPrice() != null && service.getPrice().getTariff() != null && service.getPrice().getTariff().getId() != null) {
					orderIdModelObject.setTariffId(Integer.parseInt(service.getPrice().getTariff().getId()));
				} else {
					orderIdModelObject.setTariffId(TariffType.ADULT.getId());
				}
				TripIdModel tripIdModel = new TripIdModel().create(service.getSegment().getId());
				orderIdModelObject.setCurrencyId(tripIdModel.getCurrency());
				customers.add(orderIdModelObject);
			}
		}
		response.setServices(request.getServices());
		try {
			client.bookingTicket(serviceMap, orderId);
		} catch (ResponseError e) {
			e.printStackTrace();
			response.getServices().stream().forEach(c -> c.setConfirmed(false));
		}
		response.setOrderId(orderId.asString());
		return response;
	}

	@Override
	public OrderResponse getPdfDocumentsResponse(OrderRequest request) {
		throw RestClient.createUnavailableMethod();
	}

	@Override
	public OrderResponse getResponse(String orderId) {
		throw RestClient.createUnavailableMethod();
	}

	@Override
	public OrderResponse getServiceResponse(String serviceId) {
		throw RestClient.createUnavailableMethod();
	}

	@Override
	public OrderResponse confirmResponse(String orderId) {
		// формируем ответ
		OrderResponse response = new OrderResponse();
		List<ServiceItem> resultItems = new ArrayList<>();
		// преобразовываем ид заказа в объект
		OrderIdModel orderIdModel = new OrderIdModel().create(orderId);
		// выкупаем заказы и формируем ответ
		client.createTicket(orderIdModel);
		addServiceItems(resultItems, orderIdModel);
		response.setOrderId(orderIdModel.asString());
		response.setServices(resultItems);
		return response;
	}

	private void addServiceItems(List<ServiceItem> resultItems, OrderIdModel orderIdModel) {
		for (String key : orderIdModel.getServices().keySet()) {
			TripIdModel tripModel = new TripIdModel().create(key);
			for (OrderIdModelObject service : orderIdModel.getServices().get(key)) {
				ServiceItem serviceItem = new ServiceItem();
				serviceItem.setCustomer(service.getCustomer());
				serviceItem.setSegment(new Segment(key));
				if (service.getCreateTicketResult() != null) {
					serviceItem.setConfirmed(service.getCreateTicketResult());
					serviceItem.setError(serviceItem.getConfirmed() ? null : new RestError(service.getCreateTicketError()));
					serviceItem.setPrice(getPrice(tripModel, service));
				} else if (service.getCancellationTicketResult() != null) {
					serviceItem.setConfirmed(service.getCancellationTicketResult());
					serviceItem.setError(serviceItem.getConfirmed() ? null : new RestError(service.getCancellationTicketError()));
					if (service.getReturnPrice() != null) {
						serviceItem.setPrice(new Price());
						serviceItem.getPrice().setAmount(new BigDecimal(service.getReturnPrice()));
						serviceItem.getPrice().setCurrency(Currency.valueOf(tripModel.getCurrencyName()));
					}
				}
				resultItems.add(serviceItem);
			}
		}
	}

	@Override
	public OrderResponse removeServicesResponse(OrderRequest request) {
		throw RestClient.createUnavailableMethod();
	}

	@Override
	public OrderResponse returnServicesResponse(OrderRequest request) {
		throw RestClient.createUnavailableMethod();
	}

	@Override
	public OrderResponse updateCustomersResponse(OrderRequest request) {
		throw RestClient.createUnavailableMethod();
	}

	@Override
	public OrderResponse prepareReturnServicesResponse(OrderRequest request) {
		throw RestClient.createUnavailableMethod();
	}

	private Price getPrice(TripIdModel tripModel, OrderIdModelObject service) {
		Price price = new Price();
		switch (service.getTariffId()) {
		case 1:
			price.setAmount(tripModel.getDtar());
			break;
		case 3:
		case 4:
			price.setAmount(tripModel.getPtar());
			break;
		default:
			price.setAmount(tripModel.getEtar());
			break;
		}
		price.setCurrency(Currency.valueOf(tripModel.getCurrencyName()));
		return price;
	}
}
