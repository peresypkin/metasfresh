//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2025.03.25 at 12:58:13 PM EET 
//


package de.metas.edi.esb.jaxb.metasfreshinhousev2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for EDI_Exp_DesadvLineWithNoPackType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="EDI_Exp_DesadvLineWithNoPackType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="EDI_DesadvLine_ID" type="{}EDI_Exp_DesadvLineType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EDI_Exp_DesadvLineWithNoPackType", propOrder = {
    "ediDesadvLineID"
})
public class EDIExpDesadvLineWithNoPackType {

    @XmlElement(name = "EDI_DesadvLine_ID")
    protected EDIExpDesadvLineType ediDesadvLineID;

    /**
     * Gets the value of the ediDesadvLineID property.
     * 
     * @return
     *     possible object is
     *     {@link EDIExpDesadvLineType }
     *     
     */
    public EDIExpDesadvLineType getEDIDesadvLineID() {
        return ediDesadvLineID;
    }

    /**
     * Sets the value of the ediDesadvLineID property.
     * 
     * @param value
     *     allowed object is
     *     {@link EDIExpDesadvLineType }
     *     
     */
    public void setEDIDesadvLineID(EDIExpDesadvLineType value) {
        this.ediDesadvLineID = value;
    }

}
