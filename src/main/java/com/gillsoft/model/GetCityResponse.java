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
 *         &lt;element name="GetCityResult" type="{http://tempuri.org/}ArrayOfCityS" minOccurs="0"/>
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
    "getCityResult"
})
@XmlRootElement(name = "GetCityResponse")
public class GetCityResponse {

    @XmlElement(name = "GetCityResult")
    protected ArrayOfCityS getCityResult;

    /**
     * Gets the value of the getCityResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfCityS }
     *     
     */
    public ArrayOfCityS getGetCityResult() {
        return getCityResult;
    }

    /**
     * Sets the value of the getCityResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfCityS }
     *     
     */
    public void setGetCityResult(ArrayOfCityS value) {
        this.getCityResult = value;
    }

}
