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
 *         &lt;element name="GetPriceResult" type="{http://tempuri.org/}PriceCLient"/>
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
    "getPriceResult"
})
@XmlRootElement(name = "GetPriceResponse")
public class GetPriceResponse {

    @XmlElement(name = "GetPriceResult", required = true)
    protected PriceCLient getPriceResult;

    /**
     * Gets the value of the getPriceResult property.
     * 
     * @return
     *     possible object is
     *     {@link PriceCLient }
     *     
     */
    public PriceCLient getGetPriceResult() {
        return getPriceResult;
    }

    /**
     * Sets the value of the getPriceResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link PriceCLient }
     *     
     */
    public void setGetPriceResult(PriceCLient value) {
        this.getPriceResult = value;
    }

}
