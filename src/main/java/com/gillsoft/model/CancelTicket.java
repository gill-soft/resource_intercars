package com.gillsoft.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CancelTicket complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CancelTicket">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Error" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ReturnPrice" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="Success" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CancelTicket", propOrder = {
    "error",
    "returnPrice",
    "success"
})
public class CancelTicket {

    @XmlElement(name = "Error")
    protected String error;
    @XmlElement(name = "ReturnPrice")
    protected double returnPrice;
    @XmlElement(name = "Success")
    protected boolean success;

    /**
     * Gets the value of the error property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getError() {
        return error;
    }

    /**
     * Sets the value of the error property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setError(String value) {
        this.error = value;
    }

    /**
     * Gets the value of the returnPrice property.
     * 
     */
    public double getReturnPrice() {
        return returnPrice;
    }

    /**
     * Sets the value of the returnPrice property.
     * 
     */
    public void setReturnPrice(double value) {
        this.returnPrice = value;
    }

    /**
     * Gets the value of the success property.
     * 
     */
    public boolean isSuccess() {
        return success;
    }

    /**
     * Sets the value of the success property.
     * 
     */
    public void setSuccess(boolean value) {
        this.success = value;
    }

}
