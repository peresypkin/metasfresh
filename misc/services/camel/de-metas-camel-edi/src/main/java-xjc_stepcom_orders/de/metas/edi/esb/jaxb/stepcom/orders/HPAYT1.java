
package de.metas.edi.esb.jaxb.stepcom.orders;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HPAYT1 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HPAYT1"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="DOCUMENTID" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="TERMSQUAL" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="TIMEREFERENCE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="TIMERELATION" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="TIMEPERIODTYPE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="TIMEPERIODQUANTITY" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="PAYMENTMETHODE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="TERMSDATEFROM" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="TERMSDATETO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="DISCOUNTPERCENT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="DISCOUNTAMOUNT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="PAYMENTDESC" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HPAYT1", propOrder = {
    "documentid",
    "termsqual",
    "timereference",
    "timerelation",
    "timeperiodtype",
    "timeperiodquantity",
    "paymentmethode",
    "termsdatefrom",
    "termsdateto",
    "discountpercent",
    "discountamount",
    "paymentdesc"
})
public class HPAYT1 {

    @XmlElement(name = "DOCUMENTID", required = true)
    protected String documentid;
    @XmlElement(name = "TERMSQUAL", required = true)
    protected String termsqual;
    @XmlElement(name = "TIMEREFERENCE")
    protected String timereference;
    @XmlElement(name = "TIMERELATION")
    protected String timerelation;
    @XmlElement(name = "TIMEPERIODTYPE")
    protected String timeperiodtype;
    @XmlElement(name = "TIMEPERIODQUANTITY")
    protected String timeperiodquantity;
    @XmlElement(name = "PAYMENTMETHODE")
    protected String paymentmethode;
    @XmlElement(name = "TERMSDATEFROM")
    protected String termsdatefrom;
    @XmlElement(name = "TERMSDATETO")
    protected String termsdateto;
    @XmlElement(name = "DISCOUNTPERCENT")
    protected String discountpercent;
    @XmlElement(name = "DISCOUNTAMOUNT")
    protected String discountamount;
    @XmlElement(name = "PAYMENTDESC")
    protected String paymentdesc;

    /**
     * Gets the value of the documentid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDOCUMENTID() {
        return documentid;
    }

    /**
     * Sets the value of the documentid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDOCUMENTID(String value) {
        this.documentid = value;
    }

    /**
     * Gets the value of the termsqual property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTERMSQUAL() {
        return termsqual;
    }

    /**
     * Sets the value of the termsqual property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTERMSQUAL(String value) {
        this.termsqual = value;
    }

    /**
     * Gets the value of the timereference property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTIMEREFERENCE() {
        return timereference;
    }

    /**
     * Sets the value of the timereference property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTIMEREFERENCE(String value) {
        this.timereference = value;
    }

    /**
     * Gets the value of the timerelation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTIMERELATION() {
        return timerelation;
    }

    /**
     * Sets the value of the timerelation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTIMERELATION(String value) {
        this.timerelation = value;
    }

    /**
     * Gets the value of the timeperiodtype property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTIMEPERIODTYPE() {
        return timeperiodtype;
    }

    /**
     * Sets the value of the timeperiodtype property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTIMEPERIODTYPE(String value) {
        this.timeperiodtype = value;
    }

    /**
     * Gets the value of the timeperiodquantity property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTIMEPERIODQUANTITY() {
        return timeperiodquantity;
    }

    /**
     * Sets the value of the timeperiodquantity property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTIMEPERIODQUANTITY(String value) {
        this.timeperiodquantity = value;
    }

    /**
     * Gets the value of the paymentmethode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPAYMENTMETHODE() {
        return paymentmethode;
    }

    /**
     * Sets the value of the paymentmethode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPAYMENTMETHODE(String value) {
        this.paymentmethode = value;
    }

    /**
     * Gets the value of the termsdatefrom property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTERMSDATEFROM() {
        return termsdatefrom;
    }

    /**
     * Sets the value of the termsdatefrom property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTERMSDATEFROM(String value) {
        this.termsdatefrom = value;
    }

    /**
     * Gets the value of the termsdateto property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTERMSDATETO() {
        return termsdateto;
    }

    /**
     * Sets the value of the termsdateto property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTERMSDATETO(String value) {
        this.termsdateto = value;
    }

    /**
     * Gets the value of the discountpercent property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDISCOUNTPERCENT() {
        return discountpercent;
    }

    /**
     * Sets the value of the discountpercent property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDISCOUNTPERCENT(String value) {
        this.discountpercent = value;
    }

    /**
     * Gets the value of the discountamount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDISCOUNTAMOUNT() {
        return discountamount;
    }

    /**
     * Sets the value of the discountamount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDISCOUNTAMOUNT(String value) {
        this.discountamount = value;
    }

    /**
     * Gets the value of the paymentdesc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPAYMENTDESC() {
        return paymentdesc;
    }

    /**
     * Sets the value of the paymentdesc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPAYMENTDESC(String value) {
        this.paymentdesc = value;
    }

}
