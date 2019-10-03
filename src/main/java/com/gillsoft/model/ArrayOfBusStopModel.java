package com.gillsoft.model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfBusStopModel complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfBusStopModel">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="BusStopModel" type="{http://tempuri.org/}BusStopModel" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfBusStopModel", propOrder = {
    "busStopModel"
})
public class ArrayOfBusStopModel {

    @XmlElement(name = "BusStopModel", nillable = true)
    protected List<BusStopModel> busStopModel;

    /**
     * Gets the value of the busStopModel property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the busStopModel property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBusStopModel().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BusStopModel }
     * 
     * 
     */
    public List<BusStopModel> getBusStopModel() {
        if (busStopModel == null) {
            busStopModel = new ArrayList<BusStopModel>();
        }
        return this.busStopModel;
    }

}
