package com.gillsoft.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Stopping complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Stopping">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DateArrive" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TimeArrive" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CityRus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CityEng" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NameEng" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NameRus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Stopping", propOrder = {
    "dateArrive",
    "timeArrive",
    "cityRus",
    "cityEng",
    "nameEng",
    "nameRus"
})
public class Stopping implements Serializable {

	private static final long serialVersionUID = 3384519998913842985L;

	@XmlElement(name = "DateArrive")
    protected String dateArrive;
    @XmlElement(name = "TimeArrive")
    protected String timeArrive;
    @XmlElement(name = "CityRus")
    protected String cityRus;
    @XmlElement(name = "CityEng")
    protected String cityEng;
    @XmlElement(name = "NameEng")
    protected String nameEng;
    @XmlElement(name = "NameRus")
    protected String nameRus;

    /**
     * Gets the value of the dateArrive property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDateArrive() {
        return dateArrive;
    }

    /**
     * Sets the value of the dateArrive property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDateArrive(String value) {
        this.dateArrive = value;
    }

    /**
     * Gets the value of the timeArrive property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTimeArrive() {
        return timeArrive;
    }

    /**
     * Sets the value of the timeArrive property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTimeArrive(String value) {
        this.timeArrive = value;
    }

    /**
     * Gets the value of the cityRus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCityRus() {
        return cityRus;
    }

    /**
     * Sets the value of the cityRus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCityRus(String value) {
        this.cityRus = value;
    }

    /**
     * Gets the value of the cityEng property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCityEng() {
        return cityEng;
    }

    /**
     * Sets the value of the cityEng property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCityEng(String value) {
        this.cityEng = value;
    }

    /**
     * Gets the value of the nameEng property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNameEng() {
        return nameEng;
    }

    /**
     * Sets the value of the nameEng property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNameEng(String value) {
        this.nameEng = value;
    }

    /**
     * Gets the value of the nameRus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNameRus() {
        return nameRus;
    }

    /**
     * Sets the value of the nameRus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNameRus(String value) {
        this.nameRus = value;
    }

}
