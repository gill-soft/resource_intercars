package com.gillsoft.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfStopPath complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfStopPath">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="StopPath" type="{http://tempuri.org/}StopPath" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfStopPath", propOrder = {
    "stopPath"
})
public class ArrayOfStopPath implements Serializable {

	private static final long serialVersionUID = -795708113264853817L;

	@XmlElement(name = "StopPath", nillable = true)
    protected List<StopPath> stopPath;

    /**
     * Gets the value of the stopPath property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the stopPath property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getStopPath().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link StopPath }
     * 
     * 
     */
    public List<StopPath> getStopPath() {
        if (stopPath == null) {
            stopPath = new ArrayList<StopPath>();
        }
        return this.stopPath;
    }

}
