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
 *         &lt;element name="login" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="pass" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="numberTicket" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="city1" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="city2" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="dateDepart" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dateReturn" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tarif" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="currency" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="clientFirstName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="clientLastName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="clientPasport" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="clientPhone" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="clientEmail" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MiddleName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BirthDay" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "login",
    "pass",
    "numberTicket",
    "city1",
    "city2",
    "dateDepart",
    "dateReturn",
    "tarif",
    "currency",
    "clientFirstName",
    "clientLastName",
    "clientPasport",
    "clientPhone",
    "clientEmail",
    "middleName",
    "birthDay"
})
@XmlRootElement(name = "CreateTicket")
public class CreateTicket {

    protected String login;
    protected String pass;
    protected String numberTicket;
    protected int city1;
    protected int city2;
    protected String dateDepart;
    protected String dateReturn;
    protected int tarif;
    protected int currency;
    protected String clientFirstName;
    protected String clientLastName;
    protected String clientPasport;
    protected String clientPhone;
    protected String clientEmail;
    @XmlElement(name = "MiddleName")
    protected String middleName;
    @XmlElement(name = "BirthDay")
    protected String birthDay;

    /**
     * Gets the value of the login property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLogin() {
        return login;
    }

    /**
     * Sets the value of the login property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLogin(String value) {
        this.login = value;
    }

    /**
     * Gets the value of the pass property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPass() {
        return pass;
    }

    /**
     * Sets the value of the pass property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPass(String value) {
        this.pass = value;
    }

    /**
     * Gets the value of the numberTicket property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumberTicket() {
        return numberTicket;
    }

    /**
     * Sets the value of the numberTicket property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumberTicket(String value) {
        this.numberTicket = value;
    }

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
     * Gets the value of the tarif property.
     * 
     */
    public int getTarif() {
        return tarif;
    }

    /**
     * Sets the value of the tarif property.
     * 
     */
    public void setTarif(int value) {
        this.tarif = value;
    }

    /**
     * Gets the value of the currency property.
     * 
     */
    public int getCurrency() {
        return currency;
    }

    /**
     * Sets the value of the currency property.
     * 
     */
    public void setCurrency(int value) {
        this.currency = value;
    }

    /**
     * Gets the value of the clientFirstName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClientFirstName() {
        return clientFirstName;
    }

    /**
     * Sets the value of the clientFirstName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClientFirstName(String value) {
        this.clientFirstName = value;
    }

    /**
     * Gets the value of the clientLastName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClientLastName() {
        return clientLastName;
    }

    /**
     * Sets the value of the clientLastName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClientLastName(String value) {
        this.clientLastName = value;
    }

    /**
     * Gets the value of the clientPasport property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClientPasport() {
        return clientPasport;
    }

    /**
     * Sets the value of the clientPasport property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClientPasport(String value) {
        this.clientPasport = value;
    }

    /**
     * Gets the value of the clientPhone property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClientPhone() {
        return clientPhone;
    }

    /**
     * Sets the value of the clientPhone property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClientPhone(String value) {
        this.clientPhone = value;
    }

    /**
     * Gets the value of the clientEmail property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClientEmail() {
        return clientEmail;
    }

    /**
     * Sets the value of the clientEmail property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClientEmail(String value) {
        this.clientEmail = value;
    }

    /**
     * Gets the value of the middleName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMiddleName() {
        return middleName;
    }

    /**
     * Sets the value of the middleName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMiddleName(String value) {
        this.middleName = value;
    }

    /**
     * Gets the value of the birthDay property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBirthDay() {
        return birthDay;
    }

    /**
     * Sets the value of the birthDay property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBirthDay(String value) {
        this.birthDay = value;
    }

}
