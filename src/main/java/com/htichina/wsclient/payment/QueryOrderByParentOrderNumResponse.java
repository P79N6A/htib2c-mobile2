
package com.htichina.wsclient.payment;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>queryOrderByParentOrderNumResponse complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
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
     * 获取accountNum属性的值。
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
     * 设置accountNum属性的值。
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
     * 获取insurancePresentOrder属性的值。
     * 
     */
    public boolean isInsurancePresentOrder() {
        return insurancePresentOrder;
    }

    /**
     * 设置insurancePresentOrder属性的值。
     * 
     */
    public void setInsurancePresentOrder(boolean value) {
        this.insurancePresentOrder = value;
    }

    /**
     * 获取luckyDrawOrder属性的值。
     * 
     */
    public boolean isLuckyDrawOrder() {
        return luckyDrawOrder;
    }

    /**
     * 设置luckyDrawOrder属性的值。
     * 
     */
    public void setLuckyDrawOrder(boolean value) {
        this.luckyDrawOrder = value;
    }

    /**
     * 获取orderStatus属性的值。
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
     * 设置orderStatus属性的值。
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
     * 获取price属性的值。
     * 
     */
    public double getPrice() {
        return price;
    }

    /**
     * 设置price属性的值。
     * 
     */
    public void setPrice(double value) {
        this.price = value;
    }

    /**
     * 获取startDt属性的值。
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
     * 设置startDt属性的值。
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
     * 获取vin属性的值。
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
     * 设置vin属性的值。
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
