//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.02.21 at 06:08:01 AM IST 
//


package com.createpocartproducer.createpo;

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
 *         &lt;element name="poreq" type="{http://www.createpocartproducer.com/createpo}poreq"/>
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
    "poreq"
})
@XmlRootElement(name = "AddPODetailsRequest")
public class AddPODetailsRequest {

    @XmlElement(required = true)
    protected Poreq poreq;

    /**
     * Gets the value of the poreq property.
     * 
     * @return
     *     possible object is
     *     {@link Poreq }
     *     
     */
    public Poreq getPoreq() {
        return poreq;
    }

    /**
     * Sets the value of the poreq property.
     * 
     * @param value
     *     allowed object is
     *     {@link Poreq }
     *     
     */
    public void setPoreq(Poreq value) {
        this.poreq = value;
    }

}
