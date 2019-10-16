package com.gillsoft;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
import com.gillsoft.model.Document;
import com.gillsoft.model.DocumentType;
import com.gillsoft.model.Price;
import com.gillsoft.model.RestError;
import com.gillsoft.model.Segment;
import com.gillsoft.model.ServiceItem;
import com.gillsoft.model.Tariff;
import com.gillsoft.model.request.OrderRequest;
import com.gillsoft.model.response.OrderResponse;

@RestController
public class OrderServiceController extends AbstractOrderService {

	private static Logger LOGGER = LogManager.getLogger(OrderServiceController.class);

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
		response.setServices(new ArrayList<>());
		response.setCustomers(new HashMap<>());
		// преобразовываем ид заказа в объект
		OrderIdModel orderIdModel = new OrderIdModel().create(orderId);
		client.cancelationTicket(orderIdModel);
		addServiceItems(response.getServices(), orderIdModel);
		response.setOrderId(orderId);
		response.getServices().forEach(service -> {
			if (!response.getCustomers().containsKey(service.getCustomer().getId())) {
				response.getCustomers().put(service.getCustomer().getId(), service.getCustomer());
			}
			Optional<OrderIdModelObject> optional = orderIdModel.getServices().get(service.getSegment().getId()).stream()
					.filter(serviceModel -> serviceModel.getCustomer().getId().equals(service.getCustomer().getId()))
					.findFirst();
			if (optional.isPresent()) {
				service.setId(optional.get().getTicketNumber());
			}
			service.setCustomer(new Customer(service.getCustomer().getId()));
		});
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
				if (service.getPrice() == null || service.getPrice().getTariff() == null || service.getPrice().getTariff().getId() == null) {
					orderIdModelObject.setTariffId(TariffType.ADULT.getId());
				} else {
					orderIdModelObject.setTariffId(Integer.parseInt(service.getPrice().getTariff().getId()));
				}
				TripIdModel tripIdModel = new TripIdModel().create(service.getSegment().getId());
				orderIdModelObject.setCurrencyId(tripIdModel.getCurrency());
				customers.add(orderIdModelObject);
			}
		}
		response.setServices(request.getServices());
		response.getServices().forEach(s -> s.setPrice(null));
		try {
			client.bookingTicket(serviceMap, orderId);
			request.getServices().forEach(service -> {
				Optional<OrderIdModelObject> optional = orderId.getServices().get(service.getSegment().getId()).stream()
						.filter(serviceModel -> serviceModel.getCustomer().getId().equals(service.getCustomer().getId()))
						.findFirst();
				if (optional.isPresent()) {
					service.setId(optional.get().getTicketNumber());
				} else {
					service.setConfirmed(false);
				}
			});
		} catch (ResponseError e) {
			LOGGER.error(e);
			response.getServices().stream().forEach(c -> c.setConfirmed(false));
		}
		response.setOrderId(orderId.asString());
		return response;
	}

	@Override
	public OrderResponse getPdfDocumentsResponse(OrderRequest request) {
		OrderResponse response = new OrderResponse();
		response.setOrderId(request.getOrderId());
		response.setServices(request.getServices());
		OrderIdModel orderIdModel = new OrderIdModel().create(request.getOrderId());
		request.getServices().forEach(service -> {
			Optional<OrderIdModelObject> optional = orderIdModel.getServices().get(service.getSegment().getId()).stream()
					.filter(serviceModel -> serviceModel.getCustomer().getId().equals(service.getCustomer().getId()))
					.findFirst();
			if (optional.isPresent()) {
				try {
					Document document = new Document();
					document.setType(DocumentType.TICKET);
					document.setBase64(client.getTicketPdf(optional.get().getTicketNumber()));
					service.setDocuments(Arrays.asList(document));
				} catch (Exception e) {
					service.setError(new RestError(e.getMessage()));
				}
			} else {
				service.setError(new RestError("Service with such customer not found"));
			}
		});
		return response;
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
				serviceItem.setId(service.getTicketNumber());
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
						serviceItem.getPrice().setAmount(BigDecimal.valueOf(service.getReturnPrice()));
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
		OrderResponse response = new OrderResponse();
		response.setOrderId(request.getOrderId());
		response.setServices(request.getServices());
		OrderIdModel orderIdModel = new OrderIdModel().create(request.getOrderId());
		request.getServices().forEach(service -> {
			Optional<OrderIdModelObject> optional = orderIdModel.getServices().get(service.getSegment().getId()).stream()
					.filter(serviceModel -> serviceModel.getCustomer().getId().equals(service.getCustomer().getId()))
					.findFirst();
			if (optional.isPresent()) {
				try {
					BigDecimal returnAmount = client.returnTicket(optional.get().getTicketNumber());
					service.setId(optional.get().getTicketNumber());
					service.setConfirmed(true);
					service.setPrice(new Price());
					service.getPrice().setAmount(returnAmount);
					service.getPrice().setCurrency(service.getPrice() != null ? service.getPrice().getCurrency() : null);
					service.getPrice().setTariff(new Tariff());
					service.getPrice().getTariff().setValue(returnAmount);
				} catch (Exception e) {
					service.setConfirmed(false);
					service.setError(new RestError(e.getMessage()));
				}
			} else {
				service.setConfirmed(false);
				service.setError(new RestError("Service with such customer not found"));
			}
		});
		return response;
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
