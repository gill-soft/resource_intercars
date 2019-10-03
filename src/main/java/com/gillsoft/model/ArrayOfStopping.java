package com.gillsoft.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfStopping complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfStopping">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Stopping" type="{http://tempuri.org/}Stopping" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfStopping", propOrder = {
    "stopping"
})
public class ArrayOfStopping implements Serializable {

	private static final long serialVersionUID = -2395051111706624459L;

	@XmlElement(name = "Stopping", nillable = true)
    protected List<Stopping> stopping;

    /**
     * Gets the value of the stopping property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the stopping property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getStopping().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Stopping }
     * 
     * 
     */
    public List<Stopping> getStopping() {
        if (stopping == null) {
            stopping = new ArrayList<Stopping>();
        }
        return this.stopping;
    }

}
