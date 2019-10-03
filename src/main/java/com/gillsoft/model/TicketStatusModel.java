package com.gillsoft.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TicketStatusModel complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TicketStatusModel">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Number" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Status" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DateDepart" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DateReturn" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Passanger" type="{http://tempuri.org/}ClientModel" minOccurs="0"/>
 *         &lt;element name="Tarif" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Price" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="Currency" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Created" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CityDepartId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="CityDepartName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CityArriveId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="CityArriveName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="StoppingDepart" type="{http://tempuri.org/}StoppingModel" minOccurs="0"/>
 *         &lt;element name="StoppingReturn" type="{http://tempuri.org/}StoppingModel" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TicketStatusModel", propOrder = {
    "number",
    "status",
    "dateDepart",
    "dateReturn",
    "passanger",
    "tarif",
    "price",
    "currency",
    "created",
    "cityDepartId",
    "cityDepartName",
    "cityArriveId",
    "cityArriveName",
    "stoppingDepart",
    "stoppingReturn"
})
public class TicketStatusModel {

    @XmlElement(name = "Number")
    protected String number;
    @XmlElement(name = "Status")
    protected String status;
    @XmlElement(name = "DateDepart")
    protected String dateDepart;
    @XmlElement(name = "DateReturn")
    protected String dateReturn;
    @XmlElement(name = "Passanger")
    protected ClientModel passanger;
    @XmlElement(name = "Tarif")
    protected String tarif;
    @XmlElement(name = "Price")
    protected double price;
    @XmlElement(name = "Currency")
    protected String currency;
    @XmlElement(name = "Created")
    protected String created;
    @XmlElement(name = "CityDepartId")
    protected int cityDepartId;
    @XmlElement(name = "CityDepartName")
    protected String cityDepartName;
    @XmlElement(name = "CityArriveId")
    protected int cityArriveId;
    @XmlElement(name = "CityArriveName")
    protected String cityArriveName;
    @XmlElement(name = "StoppingDepart")
    protected StoppingModel stoppingDepart;
    @XmlElement(name = "StoppingReturn")
    protected StoppingModel stoppingReturn;

    /**
     * Gets the value of the number property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumber() {
        return number;
    }

    /**
     * Sets the value of the number property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumber(String value) {
        this.number = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatus(String value) {
        this.status = value;
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

    /**
     * Gets the value of the dateReturn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDateReturn() {
        return dateReturn;
    }

    /**
     * Sets the value of the dateReturn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDateReturn(String value) {
        this.dateReturn = value;
    }

    /**
     * Gets the value of the passanger property.
     * 
     * @return
     *     possible object is
     *     {@link ClientModel }
     *     
     */
    public ClientModel getPassanger() {
        return passanger;
    }

    /**
     * Sets the value of the passanger property.
     * 
     * @param value
     *     allowed object is
     *     {@link ClientModel }
     *     
     */
    public void setPassanger(ClientModel value) {
        this.passanger = value;
    }

    /**
     * Gets the value of the tarif property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTarif() {
        return tarif;
    }

    /**
     * Sets the value of the tarif property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTarif(String value) {
        this.tarif = value;
    }

    /**
     * Gets the value of the price property.
     * 
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets the value of the price property.
     * 
     */
    public void setPrice(double value) {
        this.price = value;
    }

    /**
     * Gets the value of the currency property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * Sets the value of the currency property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrency(String value) {
        this.currency = value;
    }

    /**
     * Gets the value of the created property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreated() {
        return created;
    }

    /**
     * Sets the value of the created property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreated(String value) {
        this.created = value;
    }

    /**
     * Gets the value of the cityDepartId property.
     * 
     */
    public int getCityDepartId() {
        return cityDepartId;
    }

    /**
     * Sets the value of the cityDepartId property.
     * 
     */
    public void setCityDepartId(int value) {
        this.cityDepartId = value;
    }

    /**
     * Gets the value of the cityDepartName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCityDepartName() {
        return cityDepartName;
    }

    /**
     * Sets the value of the cityDepartName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCityDepartName(String value) {
        this.cityDepartName = value;
    }

    /**
     * Gets the value of the cityArriveId property.
     * 
     */
    public int getCityArriveId() {
        return cityArriveId;
    }

    /**
     * Sets the value of the cityArriveId property.
     * 
     */
    public void setCityArriveId(int value) {
        this.cityArriveId = value;
    }

    /**
     * Gets the value of the cityArriveName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCityArriveName() {
        return cityArriveName;
    }

    /**
     * Sets the value of the cityArriveName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCityArriveName(String value) {
        this.cityArriveName = value;
    }

    /**
     * Gets the value of the stoppingDepart property.
     * 
     * @return
     *     possible object is
     *     {@link StoppingModel }
     *     
     */
    public StoppingModel getStoppingDepart() {
        return stoppingDepart;
    }

    /**
     * Sets the value of the stoppingDepart property.
     * 
     * @param value
     *     allowed object is
     *     {@link StoppingModel }
     *     
     */
    public void setStoppingDepart(StoppingModel value) {
        this.stoppingDepart = value;
    }

    /**
     * Gets the value of the stoppingReturn property.
     * 
     * @return
     *     possible object is
     *     {@link StoppingModel }
     *     
     */
    public StoppingModel getStoppingReturn() {
        return stoppingReturn;
    }

    /**
     * Sets the value of the stoppingReturn property.
     * 
     * @param value
     *     allowed object is
     *     {@link StoppingModel }
     *     
     */
    public void setStoppingReturn(StoppingModel value) {
        this.stoppingReturn = value;
    }

}
