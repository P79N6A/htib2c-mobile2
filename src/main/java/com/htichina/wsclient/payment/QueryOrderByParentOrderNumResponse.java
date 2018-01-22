
package com.htichina.wsclient.payment;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for queryOrderByParentOrderNumResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="queryOrderByParentOrderNumResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="accountNum" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="insurancePresentOrder" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="luckyDrawOrder" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="order_status" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="price" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="start_dt" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="vin" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "queryOrderByParentOrderNumResponse", propOrder = {
    "accountNum",
    "insurancePresentOrder",
    "luckyDrawOrder",
    "orderStatus",
    "price",
    "startDt",
    "vin"
})
public class QueryOrderByParentOrderNumResponse {

    protected String accountNum;
    protected boolean insurancePresentOrder;
    protected boolean luckyDrawOrder;
    @XmlElement(name = "order_status")
    protected String orderStatus;
    protected double price;
    @XmlElement(name = "start_dt")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar startDt;
    protected String vin;

    /**
     * Gets the value of the accountNum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccountNum() {
        return accountNum;
    }

    /**
     * Sets the value of the accountNum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccountNum(String value) {
        this.accountNum = value;
    }

    /**
     * Gets the value of the insurancePresentOrder property.
     * 
     */
    public boolean isInsurancePresentOrder() {
        return insurancePresentOrder;
    }

    /**
     * Sets the value of the insurancePresentOrder property.
     * 
     */
    public void setInsurancePresentOrder(boolean value) {
        this.insurancePresentOrder = value;
    }

    /**
     * Gets the value of the luckyDrawOrder property.
     * 
     */
    public boolean isLuckyDrawOrder() {
        return luckyDrawOrder;
    }

    /**
     * Sets the value of the luckyDrawOrder property.
     * 
     */
    public void setLuckyDrawOrder(boolean value) {
        this.luckyDrawOrder = value;
    }

    /**
     * Gets the value of the orderStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrderStatus() {
        return orderStatus;
    }

    /**
     * Sets the value of the orderStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrderStatus(String value) {
        this.orderStatus = value;
    }

    /**
     * Gets the value of the price property.
     * 
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets the value of the price property.
     * 
     */
    public void setPrice(double value) {
        this.price = value;
    }

    /**
     * Gets the value of the startDt property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getStartDt() {
        return startDt;
    }

    /**
     * Sets the value of the startDt property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setStartDt(XMLGregorianCalendar value) {
        this.startDt = value;
    }

    /**
     * Gets the value of the vin property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVin() {
        return vin;
    }

    /**
     * Sets the value of the vin property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVin(String value) {
        this.vin = value;
    }

}
