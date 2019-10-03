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
 *         &lt;element name="GetRoutesResult" type="{http://tempuri.org/}RouteCommonModel" minOccurs="0"/>
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
    "getRoutesResult"
})
@XmlRootElement(name = "GetRoutesResponse")
public class GetRoutesResponse {

    @XmlElement(name = "GetRoutesResult")
    protected RouteCommonModel getRoutesResult;

    /**
     * Gets the value of the getRoutesResult property.
     * 
     * @return
     *     possible object is
     *     {@link RouteCommonModel }
     *     
     */
    public RouteCommonModel getGetRoutesResult() {
        return getRoutesResult;
    }

    /**
     * Sets the value of the getRoutesResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link RouteCommonModel }
     *     
     */
    public void setGetRoutesResult(RouteCommonModel value) {
        this.getRoutesResult = value;
    }

}
