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
 *         &lt;element name="login" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="pass" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="city1" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="city2" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="count" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="dateDepart" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dateReturn" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="pathId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="pathIdReturn" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "city1",
    "city2",
    "count",
    "dateDepart",
    "dateReturn",
    "pathId",
    "pathIdReturn"
})
@XmlRootElement(name = "BookingTicket")
public class BookingTicket {

    protected String login;
    protected String pass;
    protected int city1;
    protected int city2;
    protected int count;
    protected String dateDepart;
    protected String dateReturn;
    protected String pathId;
    protected String pathIdReturn;

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
     * Gets the value of the count property.
     * 
     */
    public int getCount() {
        return count;
    }

    /**
     * Sets the value of the count property.
     * 
     */
    public void setCount(int value) {
        this.count = value;
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
     * Gets the value of the pathId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPathId() {
        return pathId;
    }

    /**
     * Sets the value of the pathId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPathId(String value) {
        this.pathId = value;
    }

    /**
     * Gets the value of the pathIdReturn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPathIdReturn() {
        return pathIdReturn;
    }

    /**
     * Sets the value of the pathIdReturn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPathIdReturn(String value) {
        this.pathIdReturn = value;
    }

}
