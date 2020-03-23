package com.gillsoft.client;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.gillsoft.model.Customer;

public class OrderIdModelObject implements Serializable {

	private static final long serialVersionUID = 8773013876601701702L;

	private Customer customer;

	private Integer tariffId;

	private Integer currencyId;
	
	private String ticketNumber;

	@JsonProperty(access = Access.WRITE_ONLY)
	private Boolean createTicketResult;

	@JsonProperty(access = Access.WRITE_ONLY)
	private String createTicketError;

	@JsonProperty(access = Access.WRITE_ONLY)
	private Boolean cancelationTicketResult;

	@JsonProperty(access = Access.WRITE_ONLY)
	private String cancellationTicketError;

	@JsonProperty(access = Access.WRITE_ONLY)
	private Double returnPrice;

	public OrderIdModelObject() {

	}

	public OrderIdModelObject(Customer customer) {
		this.customer = customer;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Integer getTariffId() {
		return tariffId;
	}

	public void setTariffId(Integer tariffId) {
		this.tariffId = tariffId;
	}

	public Integer getCurrencyId() {
		return currencyId;
	}

	public void setCurrencyId(Integer currencyId) {
		this.currencyId = currencyId;
	}

	public Boolean getCreateTicketResult() {
		return createTicketResult;
	}

	public void setCreateTicketResult(Boolean createTicketResult) {
		this.createTicketResult = createTicketResult;
	}

	public Boolean getCancellationTicketResult() {
		return cancelationTicketResult;
	}

	public void setCancellationTicketResult(Boolean cancelationTicketResult) {
		this.cancelationTicketResult = cancelationTicketResult;
	}

	public Double getReturnPrice() {
		return returnPrice;
	}

	public void setReturnPrice(Double returnPrice) {
		this.returnPrice = returnPrice;
	}

	public String getCreateTicketError() {
		return createTicketError;
	}

	public void setCreateTicketError(String createTicketError) {
		this.createTicketError = createTicketError;
	}

	public String getCancellationTicketError() {
		return cancellationTicketError;
	}

	public void setCancellationTicketError(String cancellationTicketError) {
		this.cancellationTicketError = cancellationTicketError;
	}

	public String getTicketNumber() {
		return ticketNumber;
	}

	public void setTicketNumber(String ticketNumber) {
		this.ticketNumber = ticketNumber;
	}

}
