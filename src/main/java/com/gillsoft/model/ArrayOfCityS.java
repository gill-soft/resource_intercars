package com.gillsoft.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfCityS complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfCityS">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CityS" type="{http://tempuri.org/}CityS" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfCityS", propOrder = {
    "cityS"
})
public class ArrayOfCityS implements Serializable {

	private static final long serialVersionUID = 5501152316956910546L;

	@XmlElement(name = "CityS")
    protected List<CityS> cityS;

    /**
     * Gets the value of the cityS property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the cityS property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCityS().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CityS }
     * 
     * 
     */
    public List<CityS> getCityS() {
        if (cityS == null) {
            cityS = new ArrayList<CityS>();
        }
        return this.cityS;
    }

}
