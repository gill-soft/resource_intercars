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
 *         &lt;element name="FindPathResult" type="{http://tempuri.org/}ArrayOfPathL" minOccurs="0"/>
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
    "findPathResult"
})
@XmlRootElement(name = "FindPathResponse")
public class FindPathResponse {

    @XmlElement(name = "FindPathResult")
    protected ArrayOfPathL findPathResult;

    /**
     * Gets the value of the findPathResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfPathL }
     *     
     */
    public ArrayOfPathL getFindPathResult() {
        return findPathResult;
    }

    /**
     * Sets the value of the findPathResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfPathL }
     *     
     */
    public void setFindPathResult(ArrayOfPathL value) {
        this.findPathResult = value;
    }

}
