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
 *         &lt;element name="GetTarifResult" type="{http://tempuri.org/}ArrayOfTarif" minOccurs="0"/>
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
    "getTarifResult"
})
@XmlRootElement(name = "GetTarifResponse")
public class GetTarifResponse {

    @XmlElement(name = "GetTarifResult")
    protected ArrayOfTarif getTarifResult;

    /**
     * Gets the value of the getTarifResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfTarif }
     *     
     */
    public ArrayOfTarif getGetTarifResult() {
        return getTarifResult;
    }

    /**
     * Sets the value of the getTarifResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfTarif }
     *     
     */
    public void setGetTarifResult(ArrayOfTarif value) {
        this.getTarifResult = value;
    }

}
