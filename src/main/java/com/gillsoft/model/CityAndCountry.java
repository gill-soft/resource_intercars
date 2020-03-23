package com.gillsoft.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CityAndCountry complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CityAndCountry">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="NameRus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NameEng" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CountryName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CityAndCountry", propOrder = {
    "id",
    "nameRus",
    "nameEng",
    "countryName"
})
public class CityAndCountry {

    @XmlElement(name = "Id")
    protected int id;
    @XmlElement(name = "NameRus")
    protected String nameRus;
    @XmlElement(name = "NameEng")
    protected String nameEng;
    @XmlElement(name = "CountryName")
    protected String countryName;

    /**
     * Gets the value of the id property.
     * 
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     */
    public void setId(int value) {
        this.id = value;
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
     * Gets the value of the countryName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCountryName() {
        return countryName;
    }

    /**
     * Sets the value of the countryName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCountryName(String value) {
        this.countryName = value;
    }

}
