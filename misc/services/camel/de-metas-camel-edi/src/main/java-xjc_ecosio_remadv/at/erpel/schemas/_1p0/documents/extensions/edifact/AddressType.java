
package at.erpel.schemas._1p0.documents.extensions.edifact;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AddressType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AddressType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://erpel.at/schemas/1p0/documents/extensions/edifact}Salutation" minOccurs="0"/&gt;
 *         &lt;element ref="{http://erpel.at/schemas/1p0/documents/extensions/edifact}Name" maxOccurs="unbounded"/&gt;
 *         &lt;element ref="{http://erpel.at/schemas/1p0/documents/extensions/edifact}Street" minOccurs="0"/&gt;
 *         &lt;element ref="{http://erpel.at/schemas/1p0/documents/extensions/edifact}POBox" minOccurs="0"/&gt;
 *         &lt;element ref="{http://erpel.at/schemas/1p0/documents/extensions/edifact}Town"/&gt;
 *         &lt;element ref="{http://erpel.at/schemas/1p0/documents/extensions/edifact}ZIP"/&gt;
 *         &lt;element ref="{http://erpel.at/schemas/1p0/documents/extensions/edifact}Country"/&gt;
 *         &lt;element ref="{http://erpel.at/schemas/1p0/documents/extensions/edifact}AddressExtension" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AddressType", propOrder = {
    "salutation",
    "name",
    "street",
    "poBox",
    "town",
    "zip",
    "country",
    "addressExtension"
})
public class AddressType {

    @XmlElement(name = "Salutation")
    protected String salutation;
    @XmlElement(name = "Name", required = true)
    protected List<String> name;
    @XmlElement(name = "Street")
    protected String street;
    @XmlElement(name = "POBox")
    protected String poBox;
    @XmlElement(name = "Town", required = true)
    protected String town;
    @XmlElement(name = "ZIP", required = true)
    protected String zip;
    @XmlElement(name = "Country", required = true)
    protected CountryType country;
    @XmlElement(name = "AddressExtension")
    protected List<String> addressExtension;

    /**
     * Salutation, e.g., Mr., Mrs., Company, etc.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSalutation() {
        return salutation;
    }

    /**
     * Sets the value of the salutation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSalutation(String value) {
        this.salutation = value;
    }

    /**
     * The name. Either first name + last name or the company name.Gets the value of the name property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the name property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getName().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getName() {
        if (name == null) {
            name = new ArrayList<String>();
        }
        return this.name;
    }

    /**
     * Street information.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStreet() {
        return street;
    }

    /**
     * Sets the value of the street property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStreet(String value) {
        this.street = value;
    }

    /**
     * Post-office box.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPOBox() {
        return poBox;
    }

    /**
     * Sets the value of the poBox property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPOBox(String value) {
        this.poBox = value;
    }

    /**
     * City information.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTown() {
        return town;
    }

    /**
     * Sets the value of the town property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTown(String value) {
        this.town = value;
    }

    /**
     * ZIP code.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZIP() {
        return zip;
    }

    /**
     * Sets the value of the zip property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZIP(String value) {
        this.zip = value;
    }

    /**
     * Country information.
     * 
     * @return
     *     possible object is
     *     {@link CountryType }
     *     
     */
    public CountryType getCountry() {
        return country;
    }

    /**
     * Sets the value of the country property.
     * 
     * @param value
     *     allowed object is
     *     {@link CountryType }
     *     
     */
    public void setCountry(CountryType value) {
        this.country = value;
    }

    /**
     * Any further elements or attributes which are necessary for an address may be provided here.
     * Note that extensions should be used with care and only those extensions shall be used, which are officially provided by ERPEL.
     * 					Gets the value of the addressExtension property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the addressExtension property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAddressExtension().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getAddressExtension() {
        if (addressExtension == null) {
            addressExtension = new ArrayList<String>();
        }
        return this.addressExtension;
    }

}
