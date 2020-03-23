package com.gillsoft.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ExternalPrice complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ExternalPrice">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ptas" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="ptar" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="etas" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="etar" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="dtas" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="dtar" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="currency" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="currencyName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ExternalPrice", propOrder = {
    "ptas",
    "ptar",
    "etas",
    "etar",
    "dtas",
    "dtar",
    "currency",
    "currencyName"
})
public class ExternalPrice implements Serializable {

	private static final long serialVersionUID = 9187945517815589698L;

	@XmlElement(required = true)
    protected BigDecimal ptas;
    @XmlElement(required = true)
    protected BigDecimal ptar;
    @XmlElement(required = true)
    protected BigDecimal etas;
    @XmlElement(required = true)
    protected BigDecimal etar;
    @XmlElement(required = true)
    protected BigDecimal dtas;
    @XmlElement(required = true)
    protected BigDecimal dtar;
    protected int currency;
    protected String currencyName;

    /**
     * Gets the value of the ptas property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPtas() {
        return ptas;
    }

    /**
     * Sets the value of the ptas property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPtas(BigDecimal value) {
        this.ptas = value;
    }

    /**
     * Gets the value of the ptar property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPtar() {
        return ptar;
    }

    /**
     * Sets the value of the ptar property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPtar(BigDecimal value) {
        this.ptar = value;
    }

    /**
     * Gets the value of the etas property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getEtas() {
        return etas;
    }

    /**
     * Sets the value of the etas property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setEtas(BigDecimal value) {
        this.etas = value;
    }

    /**
     * Gets the value of the etar property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getEtar() {
        return etar;
    }

    /**
     * Sets the value of the etar property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setEtar(BigDecimal value) {
        this.etar = value;
    }

    /**
     * Gets the value of the dtas property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getDtas() {
        return dtas;
    }

    /**
     * Sets the value of the dtas property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setDtas(BigDecimal value) {
        this.dtas = value;
    }

    /**
     * Gets the value of the dtar property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getDtar() {
        return dtar;
    }

    /**
     * Sets the value of the dtar property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setDtar(BigDecimal value) {
        this.dtar = value;
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
     * Gets the value of the currencyName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrencyName() {
        return currencyName;
    }

    /**
     * Sets the value of the currencyName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrencyName(String value) {
        this.currencyName = value;
    }

}
