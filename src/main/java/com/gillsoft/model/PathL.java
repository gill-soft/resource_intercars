package com.gillsoft.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PathL complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PathL">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Path" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TimeOut" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TimeIn" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CountFreeTickets" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="StopNameOut" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="StopNameIn" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Carrier" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PathId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IsWiFi" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="IsWC" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="IsAirConditiong" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="RouteId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Prices" type="{http://tempuri.org/}ArrayOfExternalPrice" minOccurs="0"/>
 *         &lt;element name="AllStops" type="{http://tempuri.org/}ArrayOfStopping" minOccurs="0"/>
 *         &lt;element name="Platforma" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Error" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PathL", propOrder = {
    "path",
    "timeOut",
    "timeIn",
    "countFreeTickets",
    "stopNameOut",
    "stopNameIn",
    "carrier",
    "pathId",
    "isWiFi",
    "isWC",
    "isAirConditiong",
    "routeId",
    "prices",
    "allStops",
    "platforma",
    "error"
})
public class PathL implements Serializable {

	private static final long serialVersionUID = 372330164229782014L;

	@XmlElement(name = "Path")
    protected String path;
    @XmlElement(name = "TimeOut")
    protected String timeOut;
    @XmlElement(name = "TimeIn")
    protected String timeIn;
    @XmlElement(name = "CountFreeTickets")
    protected String countFreeTickets;
    @XmlElement(name = "StopNameOut")
    protected String stopNameOut;
    @XmlElement(name = "StopNameIn")
    protected String stopNameIn;
    @XmlElement(name = "Carrier")
    protected String carrier;
    @XmlElement(name = "PathId")
    protected String pathId;
    @XmlElement(name = "IsWiFi")
    protected boolean isWiFi;
    @XmlElement(name = "IsWC")
    protected boolean isWC;
    @XmlElement(name = "IsAirConditiong")
    protected boolean isAirConditiong;
    @XmlElement(name = "RouteId")
    protected int routeId;
    @XmlElement(name = "Prices")
    protected ArrayOfExternalPrice prices;
    @XmlElement(name = "AllStops")
    protected ArrayOfStopping allStops;
    @XmlElement(name = "Platforma")
    protected String platforma;
    @XmlElement(name = "Error")
    protected String error;

    /**
     * Gets the value of the path property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPath() {
        return path;
    }

    /**
     * Sets the value of the path property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPath(String value) {
        this.path = value;
    }

    /**
     * Gets the value of the timeOut property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTimeOut() {
        return timeOut;
    }

    /**
     * Sets the value of the timeOut property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTimeOut(String value) {
        this.timeOut = value;
    }

    /**
     * Gets the value of the timeIn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTimeIn() {
        return timeIn;
    }

    /**
     * Sets the value of the timeIn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTimeIn(String value) {
        this.timeIn = value;
    }

    /**
     * Gets the value of the countFreeTickets property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCountFreeTickets() {
        return countFreeTickets;
    }

    /**
     * Sets the value of the countFreeTickets property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCountFreeTickets(String value) {
        this.countFreeTickets = value;
    }

    /**
     * Gets the value of the stopNameOut property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStopNameOut() {
        return stopNameOut;
    }

    /**
     * Sets the value of the stopNameOut property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStopNameOut(String value) {
        this.stopNameOut = value;
    }

    /**
     * Gets the value of the stopNameIn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStopNameIn() {
        return stopNameIn;
    }

    /**
     * Sets the value of the stopNameIn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStopNameIn(String value) {
        this.stopNameIn = value;
    }

    /**
     * Gets the value of the carrier property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCarrier() {
        return carrier;
    }

    /**
     * Sets the value of the carrier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCarrier(String value) {
        this.carrier = value;
    }

    /**
     * Gets the value of the pathId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPathId() {
        return pathId;
    }

    /**
     * Sets the value of the pathId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPathId(String value) {
        this.pathId = value;
    }

    /**
     * Gets the value of the isWiFi property.
     * 
     */
    public boolean isIsWiFi() {
        return isWiFi;
    }

    /**
     * Sets the value of the isWiFi property.
     * 
     */
    public void setIsWiFi(boolean value) {
        this.isWiFi = value;
    }

    /**
     * Gets the value of the isWC property.
     * 
     */
    public boolean isIsWC() {
        return isWC;
    }

    /**
     * Sets the value of the isWC property.
     * 
     */
    public void setIsWC(boolean value) {
        this.isWC = value;
    }

    /**
     * Gets the value of the isAirConditiong property.
     * 
     */
    public boolean isIsAirConditiong() {
        return isAirConditiong;
    }

    /**
     * Sets the value of the isAirConditiong property.
     * 
     */
    public void setIsAirConditiong(boolean value) {
        this.isAirConditiong = value;
    }

    /**
     * Gets the value of the routeId property.
     * 
     */
    public int getRouteId() {
        return routeId;
    }

    /**
     * Sets the value of the routeId property.
     * 
     */
    public void setRouteId(int value) {
        this.routeId = value;
    }

    /**
     * Gets the value of the prices property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfExternalPrice }
     *     
     */
    public ArrayOfExternalPrice getPrices() {
        return prices;
    }

    /**
     * Sets the value of the prices property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfExternalPrice }
     *     
     */
    public void setPrices(ArrayOfExternalPrice value) {
        this.prices = value;
    }

    /**
     * Gets the value of the allStops property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfStopping }
     *     
     */
    public ArrayOfStopping getAllStops() {
        return allStops;
    }

    /**
     * Sets the value of the allStops property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfStopping }
     *     
     */
    public void setAllStops(ArrayOfStopping value) {
        this.allStops = value;
    }

    /**
     * Gets the value of the platforma property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPlatforma() {
        return platforma;
    }

    /**
     * Sets the value of the platforma property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPlatforma(String value) {
        this.platforma = value;
    }

    /**
     * Gets the value of the error property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getError() {
        return error;
    }

    /**
     * Sets the value of the error property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setError(String value) {
        this.error = value;
    }

}
