
package com.htichina.wsclient.payment;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>invoiceInfoRequest complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="invoiceInfoRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="city" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="created" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="created_by" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="district" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="email" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="invoice_account" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="invoice_contact" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="invoice_type" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="invoice_vat_type" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="last_upd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="last_upd_by" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="mail_to" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="order_num" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="phone" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="province" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="street" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="zipcode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "invoiceInfoRequest", propOrder = {
    "city",
    "created",
    "createdBy",
    "district",
    "email",
    "invoiceAccount",
    "invoiceContact",
    "invoiceType",
    "invoiceVatType",
    "lastUpd",
    "lastUpdBy",
    "mailTo",
    "orderNum",
    "phone",
    "province",
    "street",
    "zipcode"
})
public class InvoiceInfoRequest {

    protected String city;
    protected String created;
    @XmlElement(name = "created_by")
    protected String createdBy;
    protected String district;
    protected String email;
    @XmlElement(name = "invoice_account")
    protected String invoiceAccount;
    @XmlElement(name = "invoice_contact")
    protected String invoiceContact;
    @XmlElement(name = "invoice_type")
    protected String invoiceType;
    @XmlElement(name = "invoice_vat_type")
    protected String invoiceVatType;
    @XmlElement(name = "last_upd")
    protected String lastUpd;
    @XmlElement(name = "last_upd_by")
    protected String lastUpdBy;
    @XmlElement(name = "mail_to")
    protected String mailTo;
    @XmlElement(name = "order_num")
    protected String orderNum;
    protected String phone;
    protected String province;
    protected String street;
    protected String zipcode;

    /**
     * 获取city属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCity() {
        return city;
    }

    /**
     * 设置city属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCity(String value) {
        this.city = value;
    }

    /**
     * 获取created属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreated() {
        return created;
    }

    /**
     * 设置created属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreated(String value) {
        this.created = value;
    }

    /**
     * 获取createdBy属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreatedBy() {
        return createdBy;
    }

    /**
     * 设置createdBy属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreatedBy(String value) {
        this.createdBy = value;
    }

    /**
     * 获取district属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDistrict() {
        return district;
    }

    /**
     * 设置district属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDistrict(String value) {
        this.district = value;
    }

    /**
     * 获取email属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置email属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmail(String value) {
        this.email = value;
    }

    /**
     * 获取invoiceAccount属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInvoiceAccount() {
        return invoiceAccount;
    }

    /**
     * 设置invoiceAccount属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInvoiceAccount(String value) {
        this.invoiceAccount = value;
    }

    /**
     * 获取invoiceContact属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInvoiceContact() {
        return invoiceContact;
    }

    /**
     * 设置invoiceContact属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInvoiceContact(String value) {
        this.invoiceContact = value;
    }

    /**
     * 获取invoiceType属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInvoiceType() {
        return invoiceType;
    }

    /**
     * 设置invoiceType属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInvoiceType(String value) {
        this.invoiceType = value;
    }

    /**
     * 获取invoiceVatType属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInvoiceVatType() {
        return invoiceVatType;
    }

    /**
     * 设置invoiceVatType属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInvoiceVatType(String value) {
        this.invoiceVatType = value;
    }

    /**
     * 获取lastUpd属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLastUpd() {
        return lastUpd;
    }

    /**
     * 设置lastUpd属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastUpd(String value) {
        this.lastUpd = value;
    }

    /**
     * 获取lastUpdBy属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLastUpdBy() {
        return lastUpdBy;
    }

    /**
     * 设置lastUpdBy属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastUpdBy(String value) {
        this.lastUpdBy = value;
    }

    /**
     * 获取mailTo属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMailTo() {
        return mailTo;
    }

    /**
     * 设置mailTo属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMailTo(String value) {
        this.mailTo = value;
    }

    /**
     * 获取orderNum属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrderNum() {
        return orderNum;
    }

    /**
     * 设置orderNum属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrderNum(String value) {
        this.orderNum = value;
    }

    /**
     * 获取phone属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置phone属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPhone(String value) {
        this.phone = value;
    }

    /**
     * 获取province属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProvince() {
        return province;
    }

    /**
     * 设置province属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProvince(String value) {
        this.province = value;
    }

    /**
     * 获取street属性的值。
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
     * 设置street属性的值。
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
     * 获取zipcode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZipcode() {
        return zipcode;
    }

    /**
     * 设置zipcode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZipcode(String value) {
        this.zipcode = value;
    }

}
