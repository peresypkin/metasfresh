
package de.metas.payment.camt054_001_06;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PaymentContext3 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PaymentContext3"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="CardPres" type="{urn:iso:std:iso:20022:tech:xsd:camt.054.001.06}TrueFalseIndicator" minOccurs="0"/&gt;
 *         &lt;element name="CrdhldrPres" type="{urn:iso:std:iso:20022:tech:xsd:camt.054.001.06}TrueFalseIndicator" minOccurs="0"/&gt;
 *         &lt;element name="OnLineCntxt" type="{urn:iso:std:iso:20022:tech:xsd:camt.054.001.06}TrueFalseIndicator" minOccurs="0"/&gt;
 *         &lt;element name="AttndncCntxt" type="{urn:iso:std:iso:20022:tech:xsd:camt.054.001.06}AttendanceContext1Code" minOccurs="0"/&gt;
 *         &lt;element name="TxEnvt" type="{urn:iso:std:iso:20022:tech:xsd:camt.054.001.06}TransactionEnvironment1Code" minOccurs="0"/&gt;
 *         &lt;element name="TxChanl" type="{urn:iso:std:iso:20022:tech:xsd:camt.054.001.06}TransactionChannel1Code" minOccurs="0"/&gt;
 *         &lt;element name="AttndntMsgCpbl" type="{urn:iso:std:iso:20022:tech:xsd:camt.054.001.06}TrueFalseIndicator" minOccurs="0"/&gt;
 *         &lt;element name="AttndntLang" type="{urn:iso:std:iso:20022:tech:xsd:camt.054.001.06}ISO2ALanguageCode" minOccurs="0"/&gt;
 *         &lt;element name="CardDataNtryMd" type="{urn:iso:std:iso:20022:tech:xsd:camt.054.001.06}CardDataReading1Code"/&gt;
 *         &lt;element name="FllbckInd" type="{urn:iso:std:iso:20022:tech:xsd:camt.054.001.06}TrueFalseIndicator" minOccurs="0"/&gt;
 *         &lt;element name="AuthntcnMtd" type="{urn:iso:std:iso:20022:tech:xsd:camt.054.001.06}CardholderAuthentication2" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PaymentContext3", propOrder = {
    "cardPres",
    "crdhldrPres",
    "onLineCntxt",
    "attndncCntxt",
    "txEnvt",
    "txChanl",
    "attndntMsgCpbl",
    "attndntLang",
    "cardDataNtryMd",
    "fllbckInd",
    "authntcnMtd"
})
public class PaymentContext3 {

    @XmlElement(name = "CardPres")
    protected Boolean cardPres;
    @XmlElement(name = "CrdhldrPres")
    protected Boolean crdhldrPres;
    @XmlElement(name = "OnLineCntxt")
    protected Boolean onLineCntxt;
    @XmlElement(name = "AttndncCntxt")
    @XmlSchemaType(name = "string")
    protected AttendanceContext1Code attndncCntxt;
    @XmlElement(name = "TxEnvt")
    @XmlSchemaType(name = "string")
    protected TransactionEnvironment1Code txEnvt;
    @XmlElement(name = "TxChanl")
    @XmlSchemaType(name = "string")
    protected TransactionChannel1Code txChanl;
    @XmlElement(name = "AttndntMsgCpbl")
    protected Boolean attndntMsgCpbl;
    @XmlElement(name = "AttndntLang")
    protected String attndntLang;
    @XmlElement(name = "CardDataNtryMd", required = true)
    @XmlSchemaType(name = "string")
    protected CardDataReading1Code cardDataNtryMd;
    @XmlElement(name = "FllbckInd")
    protected Boolean fllbckInd;
    @XmlElement(name = "AuthntcnMtd")
    protected CardholderAuthentication2 authntcnMtd;

    /**
     * Gets the value of the cardPres property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isCardPres() {
        return cardPres;
    }

    /**
     * Sets the value of the cardPres property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCardPres(Boolean value) {
        this.cardPres = value;
    }

    /**
     * Gets the value of the crdhldrPres property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isCrdhldrPres() {
        return crdhldrPres;
    }

    /**
     * Sets the value of the crdhldrPres property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCrdhldrPres(Boolean value) {
        this.crdhldrPres = value;
    }

    /**
     * Gets the value of the onLineCntxt property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isOnLineCntxt() {
        return onLineCntxt;
    }

    /**
     * Sets the value of the onLineCntxt property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setOnLineCntxt(Boolean value) {
        this.onLineCntxt = value;
    }

    /**
     * Gets the value of the attndncCntxt property.
     * 
     * @return
     *     possible object is
     *     {@link AttendanceContext1Code }
     *     
     */
    public AttendanceContext1Code getAttndncCntxt() {
        return attndncCntxt;
    }

    /**
     * Sets the value of the attndncCntxt property.
     * 
     * @param value
     *     allowed object is
     *     {@link AttendanceContext1Code }
     *     
     */
    public void setAttndncCntxt(AttendanceContext1Code value) {
        this.attndncCntxt = value;
    }

    /**
     * Gets the value of the txEnvt property.
     * 
     * @return
     *     possible object is
     *     {@link TransactionEnvironment1Code }
     *     
     */
    public TransactionEnvironment1Code getTxEnvt() {
        return txEnvt;
    }

    /**
     * Sets the value of the txEnvt property.
     * 
     * @param value
     *     allowed object is
     *     {@link TransactionEnvironment1Code }
     *     
     */
    public void setTxEnvt(TransactionEnvironment1Code value) {
        this.txEnvt = value;
    }

    /**
     * Gets the value of the txChanl property.
     * 
     * @return
     *     possible object is
     *     {@link TransactionChannel1Code }
     *     
     */
    public TransactionChannel1Code getTxChanl() {
        return txChanl;
    }

    /**
     * Sets the value of the txChanl property.
     * 
     * @param value
     *     allowed object is
     *     {@link TransactionChannel1Code }
     *     
     */
    public void setTxChanl(TransactionChannel1Code value) {
        this.txChanl = value;
    }

    /**
     * Gets the value of the attndntMsgCpbl property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAttndntMsgCpbl() {
        return attndntMsgCpbl;
    }

    /**
     * Sets the value of the attndntMsgCpbl property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAttndntMsgCpbl(Boolean value) {
        this.attndntMsgCpbl = value;
    }

    /**
     * Gets the value of the attndntLang property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAttndntLang() {
        return attndntLang;
    }

    /**
     * Sets the value of the attndntLang property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAttndntLang(String value) {
        this.attndntLang = value;
    }

    /**
     * Gets the value of the cardDataNtryMd property.
     * 
     * @return
     *     possible object is
     *     {@link CardDataReading1Code }
     *     
     */
    public CardDataReading1Code getCardDataNtryMd() {
        return cardDataNtryMd;
    }

    /**
     * Sets the value of the cardDataNtryMd property.
     * 
     * @param value
     *     allowed object is
     *     {@link CardDataReading1Code }
     *     
     */
    public void setCardDataNtryMd(CardDataReading1Code value) {
        this.cardDataNtryMd = value;
    }

    /**
     * Gets the value of the fllbckInd property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isFllbckInd() {
        return fllbckInd;
    }

    /**
     * Sets the value of the fllbckInd property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setFllbckInd(Boolean value) {
        this.fllbckInd = value;
    }

    /**
     * Gets the value of the authntcnMtd property.
     * 
     * @return
     *     possible object is
     *     {@link CardholderAuthentication2 }
     *     
     */
    public CardholderAuthentication2 getAuthntcnMtd() {
        return authntcnMtd;
    }

    /**
     * Sets the value of the authntcnMtd property.
     * 
     * @param value
     *     allowed object is
     *     {@link CardholderAuthentication2 }
     *     
     */
    public void setAuthntcnMtd(CardholderAuthentication2 value) {
        this.authntcnMtd = value;
    }

}
