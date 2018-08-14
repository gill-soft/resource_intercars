package com.gillsoft.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for StopPath complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="StopPath">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Punkt" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="City" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TimeIn" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TimeOut" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NameStop" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Data" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StopPath", propOrder = {
    "punkt",
    "city",
    "timeIn",
    "timeOut",
    "nameStop",
    "data"
})
public class StopPath implements Serializable {

	private static final long serialVersionUID = -8276717931241461799L;

	@XmlElement(name = "Punkt")
    protected int punkt;
    @XmlElement(name = "City")
    protected String city;
    @XmlElement(name = "TimeIn")
    protected String timeIn;
    @XmlElement(name = "TimeOut")
    protected String timeOut;
    @XmlElement(name = "NameStop")
    protected String nameStop;
    @XmlElement(name = "Data")
    protected String data;

    /**
     * Gets the value of the punkt property.
     * 
     */
    public int getPunkt() {
        return punkt;
    }

    /**
     * Sets the value of the punkt property.
     * 
     */
    public void setPunkt(int value) {
        this.punkt = value;
    }

    /**
     * Gets the value of the city property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets the value of the city property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCity(String value) {
        this.city = value;
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
     * Gets the value of the nameStop property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNameStop() {
        return nameStop;
    }

    /**
     * Sets the value of the nameStop property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNameStop(String value) {
        this.nameStop = value;
    }

    /**
     * Gets the value of the data property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getData() {
        return data;
    }

    /**
     * Sets the value of the data property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setData(String value) {
        this.data = value;
    }

}
