package com.gillsoft.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfExternalPrice complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfExternalPrice">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ExternalPrice" type="{http://tempuri.org/}ExternalPrice" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfExternalPrice", propOrder = {
    "externalPrice"
})
public class ArrayOfExternalPrice implements Serializable {

	private static final long serialVersionUID = 5395962956777075055L;

	@XmlElement(name = "ExternalPrice", nillable = true)
    protected List<ExternalPrice> externalPrice;

    /**
     * Gets the value of the externalPrice property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the externalPrice property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getExternalPrice().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ExternalPrice }
     * 
     * 
     */
    public List<ExternalPrice> getExternalPrice() {
        if (externalPrice == null) {
            externalPrice = new ArrayList<ExternalPrice>();
        }
        return this.externalPrice;
    }

}
