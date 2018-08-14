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
 *         &lt;element name="AnaluteTicketResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "analuteTicketResult"
})
@XmlRootElement(name = "AnaluteTicketResponse")
public class AnaluteTicketResponse {

    @XmlElement(name = "AnaluteTicketResult")
    protected String analuteTicketResult;

    /**
     * Gets the value of the analuteTicketResult property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAnaluteTicketResult() {
        return analuteTicketResult;
    }

    /**
     * Sets the value of the analuteTicketResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAnaluteTicketResult(String value) {
        this.analuteTicketResult = value;
    }

}
