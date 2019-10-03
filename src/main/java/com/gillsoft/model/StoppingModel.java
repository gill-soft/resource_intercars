package com.gillsoft.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for StoppingModel complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="StoppingModel">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DepartName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ArriveName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DepartTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ArriveTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CountDays" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StoppingModel", propOrder = {
    "departName",
    "arriveName",
    "departTime",
    "arriveTime",
    "countDays"
})
public class StoppingModel {

    @XmlElement(name = "DepartName")
    protected String departName;
    @XmlElement(name = "ArriveName")
    protected String arriveName;
    @XmlElement(name = "DepartTime")
    protected String departTime;
    @XmlElement(name = "ArriveTime")
    protected String arriveTime;
    @XmlElement(name = "CountDays")
    protected int countDays;

    /**
     * Gets the value of the departName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDepartName() {
        return departName;
    }

    /**
     * Sets the value of the departName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDepartName(String value) {
        this.departName = value;
    }

    /**
     * Gets the value of the arriveName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getArriveName() {
        return arriveName;
    }

    /**
     * Sets the value of the arriveName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArriveName(String value) {
        this.arriveName = value;
    }

    /**
     * Gets the value of the departTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDepartTime() {
        return departTime;
    }

    /**
     * Sets the value of the departTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDepartTime(String value) {
        this.departTime = value;
    }

    /**
     * Gets the value of the arriveTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getArriveTime() {
        return arriveTime;
    }

    /**
     * Sets the value of the arriveTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArriveTime(String value) {
        this.arriveTime = value;
    }

    /**
     * Gets the value of the countDays property.
     * 
     */
    public int getCountDays() {
        return countDays;
    }

    /**
     * Sets the value of the countDays property.
     * 
     */
    public void setCountDays(int value) {
        this.countDays = value;
    }

}
