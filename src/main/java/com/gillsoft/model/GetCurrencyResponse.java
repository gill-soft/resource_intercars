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
 *         &lt;element name="GetCurrencyResult" type="{http://tempuri.org/}ArrayOfValyta" minOccurs="0"/>
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
    "getCurrencyResult"
})
@XmlRootElement(name = "GetCurrencyResponse")
public class GetCurrencyResponse {

    @XmlElement(name = "GetCurrencyResult")
    protected ArrayOfValyta getCurrencyResult;

    /**
     * Gets the value of the getCurrencyResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfValyta }
     *     
     */
    public ArrayOfValyta getGetCurrencyResult() {
        return getCurrencyResult;
    }

    /**
     * Sets the value of the getCurrencyResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfValyta }
     *     
     */
    public void setGetCurrencyResult(ArrayOfValyta value) {
        this.getCurrencyResult = value;
    }

}
