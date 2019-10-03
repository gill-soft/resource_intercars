package com.gillsoft.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for BusStopModel complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BusStopModel">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="BusStopId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="BusStopName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TypeStop" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BusStopModel", propOrder = {
    "busStopId",
    "busStopName",
    "typeStop"
})
public class BusStopModel {

    @XmlElement(name = "BusStopId", required = true, type = Integer.class, nillable = true)
    protected Integer busStopId;
    @XmlElement(name = "BusStopName")
    protected String busStopName;
    @XmlElement(name = "TypeStop")
    protected String typeStop;

    /**
     * Gets the value of the busStopId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getBusStopId() {
        return busStopId;
    }

    /**
     * Sets the value of the busStopId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setBusStopId(Integer value) {
        this.busStopId = value;
    }

    /**
     * Gets the value of the busStopName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBusStopName() {
        return busStopName;
    }

    /**
     * Sets the value of the busStopName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBusStopName(String value) {
        this.busStopName = value;
    }

    /**
     * Gets the value of the typeStop property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTypeStop() {
        return typeStop;
    }

    /**
     * Sets the value of the typeStop property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTypeStop(String value) {
        this.typeStop = value;
    }

}
