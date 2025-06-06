
package at.erpel.schemas._1p0.documents;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import at.erpel.schemas._1p0.documents.ext.ConsignmentItemInformationExtensionType;


/**
 * <p>Java class for ConsignmentPackagingSequenceType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ConsignmentPackagingSequenceType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="HierarchicalId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="HierarchicalParentId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="PackagingLevel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ConsignmentItemInformation" maxOccurs="unbounded" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="TypeOfPackaging" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *                   &lt;element name="AmountOfPackagingLevels" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *                   &lt;element name="NVE" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                   &lt;element name="ParentNVE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *                   &lt;element name="GrossVolume" type="{http://erpel.at/schemas/1p0/documents}UnitType" minOccurs="0"/&gt;
 *                   &lt;element ref="{http://erpel.at/schemas/1p0/documents}NetWeight" minOccurs="0"/&gt;
 *                   &lt;element ref="{http://erpel.at/schemas/1p0/documents}GrossWeight" minOccurs="0"/&gt;
 *                   &lt;element ref="{http://erpel.at/schemas/1p0/documents}TareWeight" minOccurs="0"/&gt;
 *                   &lt;element name="DeliveredAmount" type="{http://erpel.at/schemas/1p0/documents}UnitType" minOccurs="0"/&gt;
 *                   &lt;element name="ContainedPackagingItems" minOccurs="0"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;simpleContent&gt;
 *                         &lt;extension base="&lt;http://erpel.at/schemas/1p0/documents&gt;Decimal4Type"&gt;
 *                           &lt;attribute ref="{http://erpel.at/schemas/1p0/documents}Unit"/&gt;
 *                           &lt;attribute ref="{http://erpel.at/schemas/1p0/documents}SupplierUnit"/&gt;
 *                         &lt;/extension&gt;
 *                       &lt;/simpleContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="GTIN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *                   &lt;element ref="{http://erpel.at/schemas/1p0/documents}PackagingDescriptionCode" minOccurs="0"/&gt;
 *                   &lt;element ref="{http://erpel.at/schemas/1p0/documents}PackagingConditionsCode" minOccurs="0"/&gt;
 *                   &lt;element ref="{http://erpel.at/schemas/1p0/documents}MarkingTypeCode" minOccurs="0"/&gt;
 *                   &lt;element ref="{http://erpel.at/schemas/1p0/documents}QuantityPerPack" minOccurs="0"/&gt;
 *                   &lt;element ref="{http://erpel.at/schemas/1p0/documents/ext}ConsignmentItemInformationExtension" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element ref="{http://erpel.at/schemas/1p0/documents}ListLineItem" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConsignmentPackagingSequenceType", propOrder = {
    "hierarchicalId",
    "hierarchicalParentId",
    "packagingLevel",
    "consignmentItemInformation",
    "listLineItem"
})
public class ConsignmentPackagingSequenceType {

    @XmlElement(name = "HierarchicalId")
    protected String hierarchicalId;
    @XmlElement(name = "HierarchicalParentId")
    protected String hierarchicalParentId;
    @XmlElement(name = "PackagingLevel")
    protected String packagingLevel;
    @XmlElement(name = "ConsignmentItemInformation")
    protected List<ConsignmentPackagingSequenceType.ConsignmentItemInformation> consignmentItemInformation;
    @XmlElement(name = "ListLineItem")
    protected List<ListLineItemType> listLineItem;

    /**
     * Gets the value of the hierarchicalId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHierarchicalId() {
        return hierarchicalId;
    }

    /**
     * Sets the value of the hierarchicalId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHierarchicalId(String value) {
        this.hierarchicalId = value;
    }

    /**
     * Gets the value of the hierarchicalParentId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHierarchicalParentId() {
        return hierarchicalParentId;
    }

    /**
     * Sets the value of the hierarchicalParentId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHierarchicalParentId(String value) {
        this.hierarchicalParentId = value;
    }

    /**
     * Gets the value of the packagingLevel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPackagingLevel() {
        return packagingLevel;
    }

    /**
     * Sets the value of the packagingLevel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPackagingLevel(String value) {
        this.packagingLevel = value;
    }

    /**
     * Gets the value of the consignmentItemInformation property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the consignmentItemInformation property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getConsignmentItemInformation().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ConsignmentPackagingSequenceType.ConsignmentItemInformation }
     * 
     * 
     */
    public List<ConsignmentPackagingSequenceType.ConsignmentItemInformation> getConsignmentItemInformation() {
        if (consignmentItemInformation == null) {
            consignmentItemInformation = new ArrayList<ConsignmentPackagingSequenceType.ConsignmentItemInformation>();
        }
        return this.consignmentItemInformation;
    }

    /**
     * A list line item describing a certain product/service in a consignment item in further detail. Note, that this element's structure is identical to ItemList/LiteLineItem.	Gets the value of the listLineItem property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the listLineItem property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getListLineItem().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ListLineItemType }
     * 
     * 
     */
    public List<ListLineItemType> getListLineItem() {
        if (listLineItem == null) {
            listLineItem = new ArrayList<ListLineItemType>();
        }
        return this.listLineItem;
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
     *       &lt;sequence&gt;
     *         &lt;element name="TypeOfPackaging" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
     *         &lt;element name="AmountOfPackagingLevels" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
     *         &lt;element name="NVE" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/&gt;
     *         &lt;element name="ParentNVE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
     *         &lt;element name="GrossVolume" type="{http://erpel.at/schemas/1p0/documents}UnitType" minOccurs="0"/&gt;
     *         &lt;element ref="{http://erpel.at/schemas/1p0/documents}NetWeight" minOccurs="0"/&gt;
     *         &lt;element ref="{http://erpel.at/schemas/1p0/documents}GrossWeight" minOccurs="0"/&gt;
     *         &lt;element ref="{http://erpel.at/schemas/1p0/documents}TareWeight" minOccurs="0"/&gt;
     *         &lt;element name="DeliveredAmount" type="{http://erpel.at/schemas/1p0/documents}UnitType" minOccurs="0"/&gt;
     *         &lt;element name="ContainedPackagingItems" minOccurs="0"&gt;
     *           &lt;complexType&gt;
     *             &lt;simpleContent&gt;
     *               &lt;extension base="&lt;http://erpel.at/schemas/1p0/documents&gt;Decimal4Type"&gt;
     *                 &lt;attribute ref="{http://erpel.at/schemas/1p0/documents}Unit"/&gt;
     *                 &lt;attribute ref="{http://erpel.at/schemas/1p0/documents}SupplierUnit"/&gt;
     *               &lt;/extension&gt;
     *             &lt;/simpleContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="GTIN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
     *         &lt;element ref="{http://erpel.at/schemas/1p0/documents}PackagingDescriptionCode" minOccurs="0"/&gt;
     *         &lt;element ref="{http://erpel.at/schemas/1p0/documents}PackagingConditionsCode" minOccurs="0"/&gt;
     *         &lt;element ref="{http://erpel.at/schemas/1p0/documents}MarkingTypeCode" minOccurs="0"/&gt;
     *         &lt;element ref="{http://erpel.at/schemas/1p0/documents}QuantityPerPack" minOccurs="0"/&gt;
     *         &lt;element ref="{http://erpel.at/schemas/1p0/documents/ext}ConsignmentItemInformationExtension" minOccurs="0"/&gt;
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
        "typeOfPackaging",
        "amountOfPackagingLevels",
        "nve",
        "parentNVE",
        "grossVolume",
        "netWeight",
        "grossWeight",
        "tareWeight",
        "deliveredAmount",
        "containedPackagingItems",
        "gtin",
        "packagingDescriptionCode",
        "packagingConditionsCode",
        "markingTypeCode",
        "quantityPerPack",
        "consignmentItemInformationExtension"
    })
    public static class ConsignmentItemInformation {

        @XmlElement(name = "TypeOfPackaging")
        protected String typeOfPackaging;
        @XmlElement(name = "AmountOfPackagingLevels")
        protected String amountOfPackagingLevels;
        @XmlElement(name = "NVE")
        protected List<String> nve;
        @XmlElement(name = "ParentNVE")
        protected String parentNVE;
        @XmlElement(name = "GrossVolume")
        protected UnitType grossVolume;
        @XmlElement(name = "NetWeight")
        protected UnitType netWeight;
        @XmlElement(name = "GrossWeight")
        protected UnitType grossWeight;
        @XmlElement(name = "TareWeight")
        protected UnitType tareWeight;
        @XmlElement(name = "DeliveredAmount")
        protected UnitType deliveredAmount;
        @XmlElement(name = "ContainedPackagingItems")
        protected ConsignmentPackagingSequenceType.ConsignmentItemInformation.ContainedPackagingItems containedPackagingItems;
        @XmlElement(name = "GTIN")
        protected String gtin;
        @XmlElement(name = "PackagingDescriptionCode")
        protected String packagingDescriptionCode;
        @XmlElement(name = "PackagingConditionsCode")
        protected String packagingConditionsCode;
        @XmlElement(name = "MarkingTypeCode")
        protected String markingTypeCode;
        @XmlElement(name = "QuantityPerPack")
        protected ConditionalUnitType quantityPerPack;
        @XmlElement(name = "ConsignmentItemInformationExtension", namespace = "http://erpel.at/schemas/1p0/documents/ext")
        protected ConsignmentItemInformationExtensionType consignmentItemInformationExtension;

        /**
         * Gets the value of the typeOfPackaging property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTypeOfPackaging() {
            return typeOfPackaging;
        }

        /**
         * Sets the value of the typeOfPackaging property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTypeOfPackaging(String value) {
            this.typeOfPackaging = value;
        }

        /**
         * Gets the value of the amountOfPackagingLevels property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getAmountOfPackagingLevels() {
            return amountOfPackagingLevels;
        }

        /**
         * Sets the value of the amountOfPackagingLevels property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setAmountOfPackagingLevels(String value) {
            this.amountOfPackagingLevels = value;
        }

        /**
         * Gets the value of the nve property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the nve property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getNVE().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getNVE() {
            if (nve == null) {
                nve = new ArrayList<String>();
            }
            return this.nve;
        }

        /**
         * Gets the value of the parentNVE property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getParentNVE() {
            return parentNVE;
        }

        /**
         * Sets the value of the parentNVE property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setParentNVE(String value) {
            this.parentNVE = value;
        }

        /**
         * Gets the value of the grossVolume property.
         * 
         * @return
         *     possible object is
         *     {@link UnitType }
         *     
         */
        public UnitType getGrossVolume() {
            return grossVolume;
        }

        /**
         * Sets the value of the grossVolume property.
         * 
         * @param value
         *     allowed object is
         *     {@link UnitType }
         *     
         */
        public void setGrossVolume(UnitType value) {
            this.grossVolume = value;
        }

        /**
         * The net weight of the consignment item.	
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
         * The gross weight of the consignment item.	
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
         * The tare weight of the consignment item's packaging. Gross weight - tare weight = net weight.
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
         * Gets the value of the deliveredAmount property.
         * 
         * @return
         *     possible object is
         *     {@link UnitType }
         *     
         */
        public UnitType getDeliveredAmount() {
            return deliveredAmount;
        }

        /**
         * Sets the value of the deliveredAmount property.
         * 
         * @param value
         *     allowed object is
         *     {@link UnitType }
         *     
         */
        public void setDeliveredAmount(UnitType value) {
            this.deliveredAmount = value;
        }

        /**
         * Gets the value of the containedPackagingItems property.
         * 
         * @return
         *     possible object is
         *     {@link ConsignmentPackagingSequenceType.ConsignmentItemInformation.ContainedPackagingItems }
         *     
         */
        public ConsignmentPackagingSequenceType.ConsignmentItemInformation.ContainedPackagingItems getContainedPackagingItems() {
            return containedPackagingItems;
        }

        /**
         * Sets the value of the containedPackagingItems property.
         * 
         * @param value
         *     allowed object is
         *     {@link ConsignmentPackagingSequenceType.ConsignmentItemInformation.ContainedPackagingItems }
         *     
         */
        public void setContainedPackagingItems(ConsignmentPackagingSequenceType.ConsignmentItemInformation.ContainedPackagingItems value) {
            this.containedPackagingItems = value;
        }

        /**
         * Gets the value of the gtin property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getGTIN() {
            return gtin;
        }

        /**
         * Sets the value of the gtin property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setGTIN(String value) {
            this.gtin = value;
        }

        /**
         * Packaging related description code. Please use EDIFACT code list values. (PAC 7233)
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPackagingDescriptionCode() {
            return packagingDescriptionCode;
        }

        /**
         * Sets the value of the packagingDescriptionCode property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPackagingDescriptionCode(String value) {
            this.packagingDescriptionCode = value;
        }

        /**
         * Packaging terms and conditions code (Who is the owner, is it returnable..). Please use EDIFACT code list values. (PAC 7073)
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPackagingConditionsCode() {
            return packagingConditionsCode;
        }

        /**
         * Sets the value of the packagingConditionsCode property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPackagingConditionsCode(String value) {
            this.packagingConditionsCode = value;
        }

        /**
         * Marking type code. Please use EDIFACT code list values or VDA codes. e.g. 33E=Marked with packaging label number (GS1 PCI 7511), G/M/S (VDA4913 715/13)
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getMarkingTypeCode() {
            return markingTypeCode;
        }

        /**
         * Sets the value of the markingTypeCode property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setMarkingTypeCode(String value) {
            this.markingTypeCode = value;
        }

        /**
         * Quantity per packaging item with optional unit.
         * 
         * @return
         *     possible object is
         *     {@link ConditionalUnitType }
         *     
         */
        public ConditionalUnitType getQuantityPerPack() {
            return quantityPerPack;
        }

        /**
         * Sets the value of the quantityPerPack property.
         * 
         * @param value
         *     allowed object is
         *     {@link ConditionalUnitType }
         *     
         */
        public void setQuantityPerPack(ConditionalUnitType value) {
            this.quantityPerPack = value;
        }

        /**
         * Gets the value of the consignmentItemInformationExtension property.
         * 
         * @return
         *     possible object is
         *     {@link ConsignmentItemInformationExtensionType }
         *     
         */
        public ConsignmentItemInformationExtensionType getConsignmentItemInformationExtension() {
            return consignmentItemInformationExtension;
        }

        /**
         * Sets the value of the consignmentItemInformationExtension property.
         * 
         * @param value
         *     allowed object is
         *     {@link ConsignmentItemInformationExtensionType }
         *     
         */
        public void setConsignmentItemInformationExtension(ConsignmentItemInformationExtensionType value) {
            this.consignmentItemInformationExtension = value;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType&gt;
         *   &lt;simpleContent&gt;
         *     &lt;extension base="&lt;http://erpel.at/schemas/1p0/documents&gt;Decimal4Type"&gt;
         *       &lt;attribute ref="{http://erpel.at/schemas/1p0/documents}Unit"/&gt;
         *       &lt;attribute ref="{http://erpel.at/schemas/1p0/documents}SupplierUnit"/&gt;
         *     &lt;/extension&gt;
         *   &lt;/simpleContent&gt;
         * &lt;/complexType&gt;
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "value"
        })
        public static class ContainedPackagingItems {

            @XmlValue
            protected BigDecimal value;
            @XmlAttribute(name = "Unit", namespace = "http://erpel.at/schemas/1p0/documents")
            protected String unit;
            @XmlAttribute(name = "SupplierUnit", namespace = "http://erpel.at/schemas/1p0/documents")
            protected String supplierUnit;

            /**
             * Gets the value of the value property.
             * 
             * @return
             *     possible object is
             *     {@link BigDecimal }
             *     
             */
            public BigDecimal getValue() {
                return value;
            }

            /**
             * Sets the value of the value property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigDecimal }
             *     
             */
            public void setValue(BigDecimal value) {
                this.value = value;
            }

            /**
             * Packaging unit type of the contained packages. If customer's and supplier's packaging unit type is different this should be used for customer's packaging unit type.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getUnit() {
                return unit;
            }

            /**
             * Sets the value of the unit property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setUnit(String value) {
                this.unit = value;
            }

            /**
             * Packaging unit type used by the supplier. If customer's and supplier's packaging unit type is different this should be used for suppliers's packaging unit type.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getSupplierUnit() {
                return supplierUnit;
            }

            /**
             * Sets the value of the supplierUnit property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setSupplierUnit(String value) {
                this.supplierUnit = value;
            }

        }

    }

}
