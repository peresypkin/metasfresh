
package at.erpel.schemas._1p0.documents.extensions.edifact;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for INVOICExtensionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="INVOICExtensionType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="InvoiceReference" type="{http://erpel.at/schemas/1p0/documents/extensions/edifact}ReferenceType" minOccurs="0"/&gt;
 *         &lt;element name="OrderReference" type="{http://erpel.at/schemas/1p0/documents/extensions/edifact}ReferenceType" minOccurs="0"/&gt;
 *         &lt;element name="DesadvReference" type="{http://erpel.at/schemas/1p0/documents/extensions/edifact}ReferenceType" minOccurs="0"/&gt;
 *         &lt;element name="RecadvReference" type="{http://erpel.at/schemas/1p0/documents/extensions/edifact}ReferenceType" minOccurs="0"/&gt;
 *         &lt;element name="InvoiceListReference" type="{http://erpel.at/schemas/1p0/documents/extensions/edifact}ReferenceType" minOccurs="0"/&gt;
 *         &lt;element name="ContractReference" type="{http://erpel.at/schemas/1p0/documents/extensions/edifact}ReferenceType" minOccurs="0"/&gt;
 *         &lt;element name="ValutaDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="BillingPeriod" type="{http://erpel.at/schemas/1p0/documents/extensions/edifact}PeriodType" minOccurs="0"/&gt;
 *         &lt;element ref="{http://erpel.at/schemas/1p0/documents/extensions/edifact}AdditionalBankAccount" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://erpel.at/schemas/1p0/documents/extensions/edifact}AdditionalChargesAndReductions" minOccurs="0"/&gt;
 *         &lt;element name="AdditionalCosts" type="{http://erpel.at/schemas/1p0/documents/extensions/edifact}AdditionalCostsType" minOccurs="0"/&gt;
 *         &lt;element ref="{http://erpel.at/schemas/1p0/documents/extensions/edifact}InvoiceFooter" minOccurs="0"/&gt;
 *         &lt;element name="InvoiceFooters" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence maxOccurs="unbounded"&gt;
 *                   &lt;element ref="{http://erpel.at/schemas/1p0/documents/extensions/edifact}InvoiceFooter" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element ref="{http://erpel.at/schemas/1p0/documents/extensions/edifact}TargetCurrency" minOccurs="0"/&gt;
 *         &lt;element ref="{http://erpel.at/schemas/1p0/documents/extensions/edifact}FreeText" minOccurs="0"/&gt;
 *         &lt;element name="SupplierOrderReference" type="{http://erpel.at/schemas/1p0/documents/extensions/edifact}ReferenceType" minOccurs="0"/&gt;
 *         &lt;element name="OrderedByPartyGLN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="AcceptingPartyGLN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ContractNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="AgreementNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="TimeForPayment" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/&gt;
 *         &lt;element name="OrdrspReference" type="{http://erpel.at/schemas/1p0/documents/extensions/edifact}ReferenceType" minOccurs="0"/&gt;
 *         &lt;element name="RelatedDocuments" type="{http://erpel.at/schemas/1p0/documents/extensions/edifact}RelatedDocumentsType" minOccurs="0"/&gt;
 *         &lt;element ref="{http://erpel.at/schemas/1p0/documents/extensions/edifact}ConsignmentReference" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "INVOICExtensionType", propOrder = {
    "invoiceReference",
    "orderReference",
    "desadvReference",
    "recadvReference",
    "invoiceListReference",
    "contractReference",
    "valutaDate",
    "billingPeriod",
    "additionalBankAccount",
    "additionalChargesAndReductions",
    "additionalCosts",
    "invoiceFooter",
    "invoiceFooters",
    "targetCurrency",
    "freeText",
    "supplierOrderReference",
    "orderedByPartyGLN",
    "acceptingPartyGLN",
    "contractNumber",
    "agreementNumber",
    "timeForPayment",
    "ordrspReference",
    "relatedDocuments",
    "consignmentReference"
})
public class INVOICExtensionType {

    @XmlElement(name = "InvoiceReference")
    protected ReferenceType invoiceReference;
    @XmlElement(name = "OrderReference")
    protected ReferenceType orderReference;
    @XmlElement(name = "DesadvReference")
    protected ReferenceType desadvReference;
    @XmlElement(name = "RecadvReference")
    protected ReferenceType recadvReference;
    @XmlElement(name = "InvoiceListReference")
    protected ReferenceType invoiceListReference;
    @XmlElement(name = "ContractReference")
    protected ReferenceType contractReference;
    @XmlElement(name = "ValutaDate")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar valutaDate;
    @XmlElement(name = "BillingPeriod")
    protected PeriodType billingPeriod;
    @XmlElement(name = "AdditionalBankAccount")
    protected List<AdditionalBankAccountType> additionalBankAccount;
    @XmlElement(name = "AdditionalChargesAndReductions")
    protected AdditionalChargesAndReductionsType additionalChargesAndReductions;
    @XmlElement(name = "AdditionalCosts")
    protected AdditionalCostsType additionalCosts;
    @XmlElement(name = "InvoiceFooter")
    protected InvoiceFooterType invoiceFooter;
    @XmlElement(name = "InvoiceFooters")
    protected INVOICExtensionType.InvoiceFooters invoiceFooters;
    @XmlElement(name = "TargetCurrency")
    protected TargetCurrencyType targetCurrency;
    @XmlElement(name = "FreeText")
    protected FreeTextType freeText;
    @XmlElement(name = "SupplierOrderReference")
    protected ReferenceType supplierOrderReference;
    @XmlElement(name = "OrderedByPartyGLN")
    protected String orderedByPartyGLN;
    @XmlElement(name = "AcceptingPartyGLN")
    protected String acceptingPartyGLN;
    @XmlElement(name = "ContractNumber")
    protected String contractNumber;
    @XmlElement(name = "AgreementNumber")
    protected String agreementNumber;
    @XmlElement(name = "TimeForPayment")
    protected BigInteger timeForPayment;
    @XmlElement(name = "OrdrspReference")
    protected ReferenceType ordrspReference;
    @XmlElement(name = "RelatedDocuments")
    protected RelatedDocumentsType relatedDocuments;
    @XmlElement(name = "ConsignmentReference")
    protected String consignmentReference;

    /**
     * Gets the value of the invoiceReference property.
     * 
     * @return
     *     possible object is
     *     {@link ReferenceType }
     *     
     */
    public ReferenceType getInvoiceReference() {
        return invoiceReference;
    }

    /**
     * Sets the value of the invoiceReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReferenceType }
     *     
     */
    public void setInvoiceReference(ReferenceType value) {
        this.invoiceReference = value;
    }

    /**
     * Gets the value of the orderReference property.
     * 
     * @return
     *     possible object is
     *     {@link ReferenceType }
     *     
     */
    public ReferenceType getOrderReference() {
        return orderReference;
    }

    /**
     * Sets the value of the orderReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReferenceType }
     *     
     */
    public void setOrderReference(ReferenceType value) {
        this.orderReference = value;
    }

    /**
     * Gets the value of the desadvReference property.
     * 
     * @return
     *     possible object is
     *     {@link ReferenceType }
     *     
     */
    public ReferenceType getDesadvReference() {
        return desadvReference;
    }

    /**
     * Sets the value of the desadvReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReferenceType }
     *     
     */
    public void setDesadvReference(ReferenceType value) {
        this.desadvReference = value;
    }

    /**
     * Gets the value of the recadvReference property.
     * 
     * @return
     *     possible object is
     *     {@link ReferenceType }
     *     
     */
    public ReferenceType getRecadvReference() {
        return recadvReference;
    }

    /**
     * Sets the value of the recadvReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReferenceType }
     *     
     */
    public void setRecadvReference(ReferenceType value) {
        this.recadvReference = value;
    }

    /**
     * Gets the value of the invoiceListReference property.
     * 
     * @return
     *     possible object is
     *     {@link ReferenceType }
     *     
     */
    public ReferenceType getInvoiceListReference() {
        return invoiceListReference;
    }

    /**
     * Sets the value of the invoiceListReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReferenceType }
     *     
     */
    public void setInvoiceListReference(ReferenceType value) {
        this.invoiceListReference = value;
    }

    /**
     * Gets the value of the contractReference property.
     * 
     * @return
     *     possible object is
     *     {@link ReferenceType }
     *     
     */
    public ReferenceType getContractReference() {
        return contractReference;
    }

    /**
     * Sets the value of the contractReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReferenceType }
     *     
     */
    public void setContractReference(ReferenceType value) {
        this.contractReference = value;
    }

    /**
     * Gets the value of the valutaDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getValutaDate() {
        return valutaDate;
    }

    /**
     * Sets the value of the valutaDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setValutaDate(XMLGregorianCalendar value) {
        this.valutaDate = value;
    }

    /**
     * Gets the value of the billingPeriod property.
     * 
     * @return
     *     possible object is
     *     {@link PeriodType }
     *     
     */
    public PeriodType getBillingPeriod() {
        return billingPeriod;
    }

    /**
     * Sets the value of the billingPeriod property.
     * 
     * @param value
     *     allowed object is
     *     {@link PeriodType }
     *     
     */
    public void setBillingPeriod(PeriodType value) {
        this.billingPeriod = value;
    }

    /**
     * Additional bank accounts.Gets the value of the additionalBankAccount property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the additionalBankAccount property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAdditionalBankAccount().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AdditionalBankAccountType }
     * 
     * 
     */
    public List<AdditionalBankAccountType> getAdditionalBankAccount() {
        if (additionalBankAccount == null) {
            additionalBankAccount = new ArrayList<AdditionalBankAccountType>();
        }
        return this.additionalBankAccount;
    }

    /**
     * Additional charges and reductions of the invoice.
     * 
     * @return
     *     possible object is
     *     {@link AdditionalChargesAndReductionsType }
     *     
     */
    public AdditionalChargesAndReductionsType getAdditionalChargesAndReductions() {
        return additionalChargesAndReductions;
    }

    /**
     * Sets the value of the additionalChargesAndReductions property.
     * 
     * @param value
     *     allowed object is
     *     {@link AdditionalChargesAndReductionsType }
     *     
     */
    public void setAdditionalChargesAndReductions(AdditionalChargesAndReductionsType value) {
        this.additionalChargesAndReductions = value;
    }

    /**
     * Gets the value of the additionalCosts property.
     * 
     * @return
     *     possible object is
     *     {@link AdditionalCostsType }
     *     
     */
    public AdditionalCostsType getAdditionalCosts() {
        return additionalCosts;
    }

    /**
     * Sets the value of the additionalCosts property.
     * 
     * @param value
     *     allowed object is
     *     {@link AdditionalCostsType }
     *     
     */
    public void setAdditionalCosts(AdditionalCostsType value) {
        this.additionalCosts = value;
    }

    /**
     * Invoice footer of the invoice.
     * 
     * @return
     *     possible object is
     *     {@link InvoiceFooterType }
     *     
     */
    public InvoiceFooterType getInvoiceFooter() {
        return invoiceFooter;
    }

    /**
     * Sets the value of the invoiceFooter property.
     * 
     * @param value
     *     allowed object is
     *     {@link InvoiceFooterType }
     *     
     */
    public void setInvoiceFooter(InvoiceFooterType value) {
        this.invoiceFooter = value;
    }

    /**
     * Gets the value of the invoiceFooters property.
     * 
     * @return
     *     possible object is
     *     {@link INVOICExtensionType.InvoiceFooters }
     *     
     */
    public INVOICExtensionType.InvoiceFooters getInvoiceFooters() {
        return invoiceFooters;
    }

    /**
     * Sets the value of the invoiceFooters property.
     * 
     * @param value
     *     allowed object is
     *     {@link INVOICExtensionType.InvoiceFooters }
     *     
     */
    public void setInvoiceFooters(INVOICExtensionType.InvoiceFooters value) {
        this.invoiceFooters = value;
    }

    /**
     * The target currency of the invoice.
     * 
     * @return
     *     possible object is
     *     {@link TargetCurrencyType }
     *     
     */
    public TargetCurrencyType getTargetCurrency() {
        return targetCurrency;
    }

    /**
     * Sets the value of the targetCurrency property.
     * 
     * @param value
     *     allowed object is
     *     {@link TargetCurrencyType }
     *     
     */
    public void setTargetCurrency(TargetCurrencyType value) {
        this.targetCurrency = value;
    }

    /**
     * Additional free text.
     * 
     * @return
     *     possible object is
     *     {@link FreeTextType }
     *     
     */
    public FreeTextType getFreeText() {
        return freeText;
    }

    /**
     * Sets the value of the freeText property.
     * 
     * @param value
     *     allowed object is
     *     {@link FreeTextType }
     *     
     */
    public void setFreeText(FreeTextType value) {
        this.freeText = value;
    }

    /**
     * Gets the value of the supplierOrderReference property.
     * 
     * @return
     *     possible object is
     *     {@link ReferenceType }
     *     
     */
    public ReferenceType getSupplierOrderReference() {
        return supplierOrderReference;
    }

    /**
     * Sets the value of the supplierOrderReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReferenceType }
     *     
     */
    public void setSupplierOrderReference(ReferenceType value) {
        this.supplierOrderReference = value;
    }

    /**
     * Gets the value of the orderedByPartyGLN property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrderedByPartyGLN() {
        return orderedByPartyGLN;
    }

    /**
     * Sets the value of the orderedByPartyGLN property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrderedByPartyGLN(String value) {
        this.orderedByPartyGLN = value;
    }

    /**
     * Gets the value of the acceptingPartyGLN property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAcceptingPartyGLN() {
        return acceptingPartyGLN;
    }

    /**
     * Sets the value of the acceptingPartyGLN property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAcceptingPartyGLN(String value) {
        this.acceptingPartyGLN = value;
    }

    /**
     * Gets the value of the contractNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContractNumber() {
        return contractNumber;
    }

    /**
     * Sets the value of the contractNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContractNumber(String value) {
        this.contractNumber = value;
    }

    /**
     * Gets the value of the agreementNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAgreementNumber() {
        return agreementNumber;
    }

    /**
     * Sets the value of the agreementNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAgreementNumber(String value) {
        this.agreementNumber = value;
    }

    /**
     * Gets the value of the timeForPayment property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getTimeForPayment() {
        return timeForPayment;
    }

    /**
     * Sets the value of the timeForPayment property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setTimeForPayment(BigInteger value) {
        this.timeForPayment = value;
    }

    /**
     * Gets the value of the ordrspReference property.
     * 
     * @return
     *     possible object is
     *     {@link ReferenceType }
     *     
     */
    public ReferenceType getOrdrspReference() {
        return ordrspReference;
    }

    /**
     * Sets the value of the ordrspReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReferenceType }
     *     
     */
    public void setOrdrspReference(ReferenceType value) {
        this.ordrspReference = value;
    }

    /**
     * Gets the value of the relatedDocuments property.
     * 
     * @return
     *     possible object is
     *     {@link RelatedDocumentsType }
     *     
     */
    public RelatedDocumentsType getRelatedDocuments() {
        return relatedDocuments;
    }

    /**
     * Sets the value of the relatedDocuments property.
     * 
     * @param value
     *     allowed object is
     *     {@link RelatedDocumentsType }
     *     
     */
    public void setRelatedDocuments(RelatedDocumentsType value) {
        this.relatedDocuments = value;
    }

    /**
     * Consignment reference of the invoice.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConsignmentReference() {
        return consignmentReference;
    }

    /**
     * Sets the value of the consignmentReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConsignmentReference(String value) {
        this.consignmentReference = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence maxOccurs="unbounded"&gt;
     *         &lt;element ref="{http://erpel.at/schemas/1p0/documents/extensions/edifact}InvoiceFooter" minOccurs="0"/&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "invoiceFooter"
    })
    public static class InvoiceFooters {

        @XmlElement(name = "InvoiceFooter")
        protected List<InvoiceFooterType> invoiceFooter;

        /**
         * Gets the value of the invoiceFooter property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the invoiceFooter property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getInvoiceFooter().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link InvoiceFooterType }
         * 
         * 
         */
        public List<InvoiceFooterType> getInvoiceFooter() {
            if (invoiceFooter == null) {
                invoiceFooter = new ArrayList<InvoiceFooterType>();
            }
            return this.invoiceFooter;
        }

    }

}
