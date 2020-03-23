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
 *         &lt;element name="GetCityAndCountryResult" type="{http://tempuri.org/}ArrayOfCityAndCountry" minOccurs="0"/>
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
    "getCityAndCountryResult"
})
@XmlRootElement(name = "GetCityAndCountryResponse")
public class GetCityAndCountryResponse {

    @XmlElement(name = "GetCityAndCountryResult")
    protected ArrayOfCityAndCountry getCityAndCountryResult;

    /**
     * Gets the value of the getCityAndCountryResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfCityAndCountry }
     *     
     */
    public ArrayOfCityAndCountry getGetCityAndCountryResult() {
        return getCityAndCountryResult;
    }

    /**
     * Sets the value of the getCityAndCountryResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfCityAndCountry }
     *     
     */
    public void setGetCityAndCountryResult(ArrayOfCityAndCountry value) {
        this.getCityAndCountryResult = value;
    }

}
