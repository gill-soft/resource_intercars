package com.gillsoft.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *         &lt;element name="city1" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="city2" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="dateDepart" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "city1",
    "city2",
    "dateDepart"
})
@XmlRootElement(name = "GetStopPath")
public class GetStopPath {

    protected int city1;
    protected int city2;
    protected String dateDepart;

    /**
     * Gets the value of the city1 property.
     * 
     */
    public int getCity1() {
        return city1;
    }

    /**
     * Sets the value of the city1 property.
     * 
     */
    public void setCity1(int value) {
        this.city1 = value;
    }

    /**
     * Gets the value of the city2 property.
     * 
     */
    public int getCity2() {
        return city2;
    }

    /**
     * Sets the value of the city2 property.
     * 
     */
    public void setCity2(int value) {
        this.city2 = value;
    }

    /**
     * Gets the value of the dateDepart property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDateDepart() {
        return dateDepart;
    }

    /**
     * Sets the value of the dateDepart property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDateDepart(String value) {
        this.dateDepart = value;
    }

}
