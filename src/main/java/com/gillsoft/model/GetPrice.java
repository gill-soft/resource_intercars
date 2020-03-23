package com.gillsoft.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="city1" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="city2" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="date" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="currency" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="routeId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "city1",
    "city2",
    "date",
    "currency",
    "type",
    "routeId"
})
@XmlRootElement(name = "GetPrice")
public class GetPrice {

    protected int city1;
    protected int city2;
    protected String date;
    protected int currency;
    protected int type;
    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer routeId;

    /**
     * Gets the value of the city1 property.
     * 
     */
    public int getCity1() {
        return city1;
    }

    /**
     * Sets the value of the city1 property.
     * 
     */
    public void setCity1(int value) {
        this.city1 = value;
    }

    /**
     * Gets the value of the city2 property.
     * 
     */
    public int getCity2() {
        return city2;
    }

    /**
     * Sets the value of the city2 property.
     * 
     */
    public void setCity2(int value) {
        this.city2 = value;
    }

    /**
     * Gets the value of the date property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDate() {
        return date;
    }

    /**
     * Sets the value of the date property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDate(String value) {
        this.date = value;
    }

    /**
     * Gets the value of the currency property.
     * 
     */
    public int getCurrency() {
        return currency;
    }

    /**
     * Sets the value of the currency property.
     * 
     */
    public void setCurrency(int value) {
        this.currency = value;
    }

    /**
     * Gets the value of the type property.
     * 
     */
    public int getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     */
    public void setType(int value) {
        this.type = value;
    }

    /**
     * Gets the value of the routeId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getRouteId() {
        return routeId;
    }

    /**
     * Sets the value of the routeId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setRouteId(Integer value) {
        this.routeId = value;
    }

}
