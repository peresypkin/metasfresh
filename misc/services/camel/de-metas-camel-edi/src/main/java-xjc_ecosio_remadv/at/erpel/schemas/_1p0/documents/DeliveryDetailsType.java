
package at.erpel.schemas._1p0.documents;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import at.erpel.schemas._1p0.documents.ext.DeliveryDetailsExtensionType;


/**
 * <p>Java class for DeliveryDetailsType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DeliveryDetailsType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://erpel.at/schemas/1p0/documents}DeliveryID" minOccurs="0"/&gt;
 *         &lt;choice&gt;
 *           &lt;element ref="{http://erpel.at/schemas/1p0/documents}Date" minOccurs="0"/&gt;
 *           &lt;element ref="{http://erpel.at/schemas/1p0/documents}Period" minOccurs="0"/&gt;
 *         &lt;/choice&gt;
 *         &lt;element ref="{http://erpel.at/schemas/1p0/documents}DeliveryDateConfirmed" minOccurs="0"/&gt;
 *         &lt;element ref="{http://erpel.at/schemas/1p0/documents}ShippingDate" minOccurs="0"/&gt;
 *         &lt;element ref="{http://erpel.at/schemas/1p0/documents}Description" minOccurs="0"/&gt;
 *         &lt;element ref="{http://erpel.at/schemas/1p0/documents}NetWeight" minOccurs="0"/&gt;
 *         &lt;element ref="{http://erpel.at/schemas/1p0/documents}GrossWeight" minOccurs="0"/&gt;
 *         &lt;element ref="{http://erpel.at/schemas/1p0/documents}TareWeight" minOccurs="0"/&gt;
 *         &lt;element ref="{http://erpel.at/schemas/1p0/documents}Incoterm" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://erpel.at/schemas/1p0/documents}TransportDetail" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://erpel.at/schemas/1p0/documents}TourNumber" minOccurs="0"/&gt;
 *         &lt;element ref="{http://erpel.at/schemas/1p0/documents}SerialShippingContainerCode" minOccurs="0"/&gt;
 *         &lt;element ref="{http://erpel.at/schemas/1p0/documents}ModeOfDispatch" minOccurs="0"/&gt;
 *         &lt;element ref="{http://erpel.at/schemas/1p0/documents}NumberOfPackages" minOccurs="0"/&gt;
 *         &lt;element ref="{http://erpel.at/schemas/1p0/documents}NameOfDriver" minOccurs="0"/&gt;
 *         &lt;element ref="{http://erpel.at/schemas/1p0/documents}TransportVehicleLicenseNumber" minOccurs="0"/&gt;
 *         &lt;element ref="{http://erpel.at/schemas/1p0/documents/ext}DeliveryDetailsExtension" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DeliveryDetailsType", propOrder = {
    "deliveryID",
    "date",
    "period",
    "deliveryDateConfirmed",
    "shippingDate",
    "description",
    "netWeight",
    "grossWeight",
    "tareWeight",
    "incoterm",
    "transportDetail",
    "tourNumber",
    "serialShippingContainerCode",
    "modeOfDispatch",
    "numberOfPackages",
    "nameOfDriver",
    "transportVehicleLicenseNumber",
    "deliveryDetailsExtension"
})
public class DeliveryDetailsType {

    @XmlElement(name = "DeliveryID")
    protected String deliveryID;
    @XmlElement(name = "Date")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar date;
    @XmlElement(name = "Period")
    protected PeriodType period;
    @XmlElement(name = "DeliveryDateConfirmed")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar deliveryDateConfirmed;
    @XmlElement(name = "ShippingDate")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar shippingDate;
    @XmlElement(name = "Description")
    protected DescriptionType description;
    @XmlElement(name = "NetWeight")
    protected UnitType netWeight;
    @XmlElement(name = "GrossWeight")
    protected UnitType grossWeight;
    @XmlElement(name = "TareWeight")
    protected UnitType tareWeight;
    @XmlElement(name = "Incoterm")
    protected List<IncotermType> incoterm;
    @XmlElement(name = "TransportDetail")
    protected List<TransportDetailType> transportDetail;
    @XmlElement(name = "TourNumber")
    protected String tourNumber;
    @XmlElement(name = "SerialShippingContainerCode")
    protected String serialShippingContainerCode;
    @XmlElement(name = "ModeOfDispatch")
    protected String modeOfDispatch;
    @XmlElement(name = "NumberOfPackages")
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger numberOfPackages;
    @XmlElement(name = "NameOfDriver")
    protected String nameOfDriver;
    @XmlElement(name = "TransportVehicleLicenseNumber")
    protected String transportVehicleLicenseNumber;
    @XmlElement(name = "DeliveryDetailsExtension", namespace = "http://erpel.at/schemas/1p0/documents/ext")
    protected DeliveryDetailsExtensionType deliveryDetailsExtension;

    /**
     * The ID of the delivery.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeliveryID() {
        return deliveryID;
    }

    /**
     * Sets the value of the deliveryID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeliveryID(String value) {
        this.deliveryID = value;
    }

    /**
     * 						
     * 						Note that either Date or Period may be specified, but not both.
     * 						Depending on the message type, the meaning of Date varies. 
     * 						Order: requested delivery date. 
     * 						OrderConfirmation: confirmed delivery date.
     * 						DispatchAdvice: actual delivery date; 
     * 						Invoice: actual delivery date;
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDate() {
        return date;
    }

    /**
     * Sets the value of the date property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDate(XMLGregorianCalendar value) {
        this.date = value;
    }

    /**
     * 		
     * 						Note that either Date or Period may be specified, but not both.
     * 						Depending on the message type, the meaning of Period varies. 
     * 						Order: requested delivery period. 
     * 						OrderConfirmation: confirmed delivery period.
     * 						DispatchAdvice: use Date; 
     * 						Invoice: use Date;
     * 
     * @return
     *     possible object is
     *     {@link PeriodType }
     *     
     */
    public PeriodType getPeriod() {
        return period;
    }

    /**
     * Sets the value of the period property.
     * 
     * @param value
     *     allowed object is
     *     {@link PeriodType }
     *     
     */
    public void setPeriod(PeriodType value) {
        this.period = value;
    }

    /**
     * Not commonly used. Use this element in DispatchAdvices when both the actual and the confirmed delivery dates must be supplied. 
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDeliveryDateConfirmed() {
        return deliveryDateConfirmed;
    }

    /**
     * Sets the value of the deliveryDateConfirmed property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDeliveryDateConfirmed(XMLGregorianCalendar value) {
        this.deliveryDateConfirmed = value;
    }

    /**
     * The date when shipping of goods takes place. The delivery date is the date when the goods/serivces arrive at the premises of the customer. The shipping date is the date when the goods/services leave the suppliers premises/warehouse.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getShippingDate() {
        return shippingDate;
    }

    /**
     * Sets the value of the shippingDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setShippingDate(XMLGregorianCalendar value) {
        this.shippingDate = value;
    }

    /**
     * Free-text description of the delivery.
     * 
     * @return
     *     possible object is
     *     {@link DescriptionType }
     *     
     */
    public DescriptionType getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link DescriptionType }
     *     
     */
    public void setDescription(DescriptionType value) {
        this.description = value;
    }

    /**
     * The net weight of the delivery.
     * 
     * @return
     *     possible object is
     *     {@link UnitType }
     *     
     */
    public UnitType getNetWeight() {
        return netWeight;
    }

    /**
     * Sets the value of the netWeight property.
     * 
     * @param value
     *     allowed object is
     *     {@link UnitType }
     *     
     */
    public void setNetWeight(UnitType value) {
        this.netWeight = value;
    }

    /**
     * The gross weight of the delivery.
     * 
     * @return
     *     possible object is
     *     {@link UnitType }
     *     
     */
    public UnitType getGrossWeight() {
        return grossWeight;
    }

    /**
     * Sets the value of the grossWeight property.
     * 
     * @param value
     *     allowed object is
     *     {@link UnitType }
     *     
     */
    public void setGrossWeight(UnitType value) {
        this.grossWeight = value;
    }

    /**
     * The tare weight. Tare weight is the weight of the containment (e.g. container, ), where the actual goods are stored in. Gross weight - tare weight = net weight.
     * 
     * @return
     *     possible object is
     *     {@link UnitType }
     *     
     */
    public UnitType getTareWeight() {
        return tareWeight;
    }

    /**
     * Sets the value of the tareWeight property.
     * 
     * @param value
     *     allowed object is
     *     {@link UnitType }
     *     
     */
    public void setTareWeight(UnitType value) {
        this.tareWeight = value;
    }

    /**
     * Further details about the incoterms.Gets the value of the incoterm property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the incoterm property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIncoterm().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IncotermType }
     * 
     * 
     */
    public List<IncotermType> getIncoterm() {
        if (incoterm == null) {
            incoterm = new ArrayList<IncotermType>();
        }
        return this.incoterm;
    }

    /**
     * Further details about the transport.Gets the value of the transportDetail property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the transportDetail property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTransportDetail().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TransportDetailType }
     * 
     * 
     */
    public List<TransportDetailType> getTransportDetail() {
        if (transportDetail == null) {
            transportDetail = new ArrayList<TransportDetailType>();
        }
        return this.transportDetail;
    }

    /**
     * The tour number of a certain delivery, e.g., the tour number of a delivery truck.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTourNumber() {
        return tourNumber;
    }

    /**
     * Sets the value of the tourNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTourNumber(String value) {
        this.tourNumber = value;
    }

    /**
     * A unique identifier used for the shipment according to the SSCC specification of GS1.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSerialShippingContainerCode() {
        return serialShippingContainerCode;
    }

    /**
     * Sets the value of the serialShippingContainerCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSerialShippingContainerCode(String value) {
        this.serialShippingContainerCode = value;
    }

    /**
     * The mode of despatch in free-text. E.g., "standard international shipping", "express international shipping", etc.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getModeOfDispatch() {
        return modeOfDispatch;
    }

    /**
     * Sets the value of the modeOfDispatch property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setModeOfDispatch(String value) {
        this.modeOfDispatch = value;
    }

    /**
     * The number of packages in the given delivery.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getNumberOfPackages() {
        return numberOfPackages;
    }

    /**
     * Sets the value of the numberOfPackages property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setNumberOfPackages(BigInteger value) {
        this.numberOfPackages = value;
    }

    /**
     * The name of the driver performing the delivery.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNameOfDriver() {
        return nameOfDriver;
    }

    /**
     * Sets the value of the nameOfDriver property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNameOfDriver(String value) {
        this.nameOfDriver = value;
    }

    /**
     * The license plate number of the vehicle performing the delivery.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransportVehicleLicenseNumber() {
        return transportVehicleLicenseNumber;
    }

    /**
     * Sets the value of the transportVehicleLicenseNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransportVehicleLicenseNumber(String value) {
        this.transportVehicleLicenseNumber = value;
    }

    /**
     * Gets the value of the deliveryDetailsExtension property.
     * 
     * @return
     *     possible object is
     *     {@link DeliveryDetailsExtensionType }
     *     
     */
    public DeliveryDetailsExtensionType getDeliveryDetailsExtension() {
        return deliveryDetailsExtension;
    }

    /**
     * Sets the value of the deliveryDetailsExtension property.
     * 
     * @param value
     *     allowed object is
     *     {@link DeliveryDetailsExtensionType }
     *     
     */
    public void setDeliveryDetailsExtension(DeliveryDetailsExtensionType value) {
        this.deliveryDetailsExtension = value;
    }

}
