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
 *         &lt;element name="GetStopPathResult" type="{http://tempuri.org/}ArrayOfStopPath" minOccurs="0"/>
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
    "getStopPathResult"
})
@XmlRootElement(name = "GetStopPathResponse")
public class GetStopPathResponse {

    @XmlElement(name = "GetStopPathResult")
    protected ArrayOfStopPath getStopPathResult;

    /**
     * Gets the value of the getStopPathResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfStopPath }
     *     
     */
    public ArrayOfStopPath getGetStopPathResult() {
        return getStopPathResult;
    }

    /**
     * Sets the value of the getStopPathResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfStopPath }
     *     
     */
    public void setGetStopPathResult(ArrayOfStopPath value) {
        this.getStopPathResult = value;
    }

}
