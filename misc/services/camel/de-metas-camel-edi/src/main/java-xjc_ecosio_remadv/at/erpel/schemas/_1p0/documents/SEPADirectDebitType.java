
package at.erpel.schemas._1p0.documents;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for SEPADirectDebitType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SEPADirectDebitType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://erpel.at/schemas/1p0/documents}Type" minOccurs="0"/&gt;
 *         &lt;element ref="{http://erpel.at/schemas/1p0/documents}BIC"/&gt;
 *         &lt;element ref="{http://erpel.at/schemas/1p0/documents}IBAN"/&gt;
 *         &lt;element ref="{http://erpel.at/schemas/1p0/documents}BankAccountOwner"/&gt;
 *         &lt;element ref="{http://erpel.at/schemas/1p0/documents}CreditorID"/&gt;
 *         &lt;element ref="{http://erpel.at/schemas/1p0/documents}MandateReference"/&gt;
 *         &lt;element ref="{http://erpel.at/schemas/1p0/documents}DebitCollectionDate"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SEPADirectDebitType", propOrder = {
    "type",
    "bic",
    "iban",
    "bankAccountOwner",
    "creditorID",
    "mandateReference",
    "debitCollectionDate"
})
public class SEPADirectDebitType {

    @XmlElement(name = "Type")
    @XmlSchemaType(name = "string")
    protected SEPADirectDebitTypeType type;
    @XmlElement(name = "BIC", required = true)
    protected String bic;
    @XmlElement(name = "IBAN", required = true)
    protected String iban;
    @XmlElement(name = "BankAccountOwner", required = true)
    protected String bankAccountOwner;
    @XmlElement(name = "CreditorID", required = true)
    protected String creditorID;
    @XmlElement(name = "MandateReference", required = true)
    protected String mandateReference;
    @XmlElement(name = "DebitCollectionDate", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar debitCollectionDate;

    /**
     * The type of SEPA direct debit.
     * 
     * @return
     *     possible object is
     *     {@link SEPADirectDebitTypeType }
     *     
     */
    public SEPADirectDebitTypeType getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link SEPADirectDebitTypeType }
     *     
     */
    public void setType(SEPADirectDebitTypeType value) {
        this.type = value;
    }

    /**
     * 
     * 						Bank identifier code
     * 					
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBIC() {
        return bic;
    }

    /**
     * Sets the value of the bic property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBIC(String value) {
        this.bic = value;
    }

    /**
     * 
     * 						International bank account number
     * 					
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIBAN() {
        return iban;
    }

    /**
     * Sets the value of the iban property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIBAN(String value) {
        this.iban = value;
    }

    /**
     * 
     * 						Owner of the bank account.
     * 					
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBankAccountOwner() {
        return bankAccountOwner;
    }

    /**
     * Sets the value of the bankAccountOwner property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBankAccountOwner(String value) {
        this.bankAccountOwner = value;
    }

    /**
     * 
     * 						The creditor ID of the SEPA direct debit.
     * 					
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreditorID() {
        return creditorID;
    }

    /**
     * Sets the value of the creditorID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreditorID(String value) {
        this.creditorID = value;
    }

    /**
     * 
     * 						The mandate reference of the SEPA direct debit.
     * 					
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMandateReference() {
        return mandateReference;
    }

    /**
     * Sets the value of the mandateReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMandateReference(String value) {
        this.mandateReference = value;
    }

    /**
     * 
     * 						The debit collection date.
     * 					
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDebitCollectionDate() {
        return debitCollectionDate;
    }

    /**
     * Sets the value of the debitCollectionDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDebitCollectionDate(XMLGregorianCalendar value) {
        this.debitCollectionDate = value;
    }

}
