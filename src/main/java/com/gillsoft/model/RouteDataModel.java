package com.gillsoft.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RouteDataModel complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RouteDataModel">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RouteId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="BusStops" type="{http://tempuri.org/}ArrayOfBusStopModel" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RouteDataModel", propOrder = {
    "routeId",
    "busStops"
})
public class RouteDataModel {

    @XmlElement(name = "RouteId")
    protected int routeId;
    @XmlElement(name = "BusStops")
    protected ArrayOfBusStopModel busStops;

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
     * Gets the value of the busStops property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfBusStopModel }
     *     
     */
    public ArrayOfBusStopModel getBusStops() {
        return busStops;
    }

    /**
     * Sets the value of the busStops property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfBusStopModel }
     *     
     */
    public void setBusStops(ArrayOfBusStopModel value) {
        this.busStops = value;
    }

}
