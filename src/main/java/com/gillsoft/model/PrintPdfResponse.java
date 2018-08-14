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
 *         &lt;element name="PrintPdfResult" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
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
    "printPdfResult"
})
@XmlRootElement(name = "PrintPdfResponse")
public class PrintPdfResponse {

    @XmlElement(name = "PrintPdfResult")
    protected byte[] printPdfResult;

    /**
     * Gets the value of the printPdfResult property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getPrintPdfResult() {
        return printPdfResult;
    }

    /**
     * Sets the value of the printPdfResult property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setPrintPdfResult(byte[] value) {
        this.printPdfResult = value;
    }

}
