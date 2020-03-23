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
 *         &lt;element name="CreateTicketResult" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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
    "createTicketResult"
})
@XmlRootElement(name = "CreateTicketResponse")
public class CreateTicketResponse {

    @XmlElement(name = "CreateTicketResult")
    protected boolean createTicketResult;

    /**
     * Gets the value of the createTicketResult property.
     * 
     */
    public boolean isCreateTicketResult() {
        return createTicketResult;
    }

    /**
     * Sets the value of the createTicketResult property.
     * 
     */
    public void setCreateTicketResult(boolean value) {
        this.createTicketResult = value;
    }

}
