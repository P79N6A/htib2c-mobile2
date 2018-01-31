
package com.htichina.wsclient.payment;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>createPaymentOrder complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="createPaymentOrder">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="packageId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="price" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="proCategoryId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="accountNum" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="vin" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="channel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="openId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "createPaymentOrder", propOrder = {
    "packageId",
    "price",
    "proCategoryId",
    "accountNum",
    "vin",
    "channel",
    "openId"
})
public class CreatePaymentOrder {

    protected String packageId;
    protected double price;
    protected String proCategoryId;
    protected String accountNum;
    protected String vin;
    protected String channel;
    protected String openId;

    /**
     * 获取packageId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPackageId() {
        return packageId;
    }

    /**
     * 设置packageId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPackageId(String value) {
        this.packageId = value;
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
     * 获取proCategoryId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProCategoryId() {
        return proCategoryId;
    }

    /**
     * 设置proCategoryId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProCategoryId(String value) {
        this.proCategoryId = value;
    }

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

    /**
     * 获取channel属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChannel() {
        return channel;
    }

    /**
     * 设置channel属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChannel(String value) {
        this.channel = value;
    }

    /**
     * 获取openId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOpenId() {
        return openId;
    }

    /**
     * 设置openId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOpenId(String value) {
        this.openId = value;
    }

}
