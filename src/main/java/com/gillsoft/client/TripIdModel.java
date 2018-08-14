package com.gillsoft.client;

import java.math.BigDecimal;
import java.util.Date;

import com.gillsoft.model.AbstractJsonModel;
import com.gillsoft.model.ExternalPrice;

public class TripIdModel extends AbstractJsonModel {

	private static final long serialVersionUID = -4570318053620484041L;

	private String pathId;

	private Integer cityStart;

	private Integer cityEnd;

	private Date dateDepart;

	private Date dateReturn;

	private String pathIdReturn;

	private BigDecimal ptar;

	private BigDecimal etar;

	private BigDecimal dtar;

	private Integer currency;
	
	private String currencyName;

	public TripIdModel() {

	}

	public TripIdModel(String pathId, Integer cityStart, Integer cityEnd, Date dateDepart, ExternalPrice price) {
		this.pathId = pathId;
		this.cityStart = cityStart;
		this.cityEnd = cityEnd;
		this.dateDepart = dateDepart;
		this.ptar = price.getPtar();
		this.etar = price.getEtar();
		this.dtar = price.getDtar();
		this.currency = price.getCurrency();
		this.currencyName = price.getCurrencyName();
	}
	
	public TripIdModel(String pathId, Integer cityStart, Integer cityEnd, Date dateDepart, ExternalPrice price, String pathIdReturn, Date dateReturn) {
		this(pathId, cityStart, cityEnd, dateDepart, price);
		this.pathIdReturn = pathIdReturn;
		this.dateReturn = dateReturn;
	}


	public String getPathId() {
		return pathId;
	}

	public void setPathId(String pathId) {
		this.pathId = pathId;
	}

	public Integer getCityStart() {
		return cityStart;
	}

	public void setCityStart(Integer cityStart) {
		this.cityStart = cityStart;
	}

	public Integer getCityEnd() {
		return cityEnd;
	}

	public void setCityEnd(Integer cityEnd) {
		this.cityEnd = cityEnd;
	}

	public Date getDateDepart() {
		return dateDepart;
	}

	public void setDateDepart(Date dateDepart) {
		this.dateDepart = dateDepart;
	}

	public Date getDateReturn() {
		return dateReturn;
	}

	public void setDateReturn(Date dateReturn) {
		this.dateReturn = dateReturn;
	}

	public String getPathIdReturn() {
		return pathIdReturn;
	}

	public void setPathIdReturn(String pathIdReturn) {
		this.pathIdReturn = pathIdReturn;
	}

	public BigDecimal getPtar() {
		return ptar;
	}

	public void setPtar(BigDecimal ptar) {
		this.ptar = ptar;
	}

	public BigDecimal getEtar() {
		return etar;
	}

	public void setEtar(BigDecimal etar) {
		this.etar = etar;
	}

	public BigDecimal getDtar() {
		return dtar;
	}

	public void setDtar(BigDecimal dtar) {
		this.dtar = dtar;
	}

	public Integer getCurrency() {
		return currency;
	}

	public void setCurrency(Integer currency) {
		this.currency = currency;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public TripIdModel create(String json) {
		return (TripIdModel) super.create(json);
	}

	public String getCurrencyName() {
		return currencyName;
	}

	public void setCurrencyName(String currencyName) {
		this.currencyName = currencyName;
	}
}
