
package com.htichina.wsclient.payment;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>ldItem complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="ldItem">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="amount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="created_by" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="created_time" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="last_upd_by" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="last_upd_time" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="luck_draw" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="packageId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="probability" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sub_type" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="wifi_duration" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ldItem", propOrder = {
    "amount",
    "createdBy",
    "createdTime",
    "id",
    "lastUpdBy",
    "lastUpdTime",
    "luckDraw",
    "name",
    "packageId",
    "probability",
    "subType",
    "type",
    "wifiDuration"
})
public class LdItem {

    protected String amount;
    @XmlElement(name = "created_by")
    protected String createdBy;
    @XmlElement(name = "created_time")
    protected String createdTime;
    protected String id;
    @XmlElement(name = "last_upd_by")
    protected String lastUpdBy;
    @XmlElement(name = "last_upd_time")
    protected String lastUpdTime;
    @XmlElement(name = "luck_draw")
    protected String luckDraw;
    protected String name;
    protected String packageId;
    protected String probability;
    @XmlElement(name = "sub_type")
    protected String subType;
    protected String type;
    @XmlElement(name = "wifi_duration")
    protected String wifiDuration;

    /**
     * 获取amount属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAmount() {
        return amount;
    }

    /**
     * 设置amount属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAmount(String value) {
        this.amount = value;
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
     * 获取createdTime属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreatedTime() {
        return createdTime;
    }

    /**
     * 设置createdTime属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreatedTime(String value) {
        this.createdTime = value;
    }

    /**
     * 获取id属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * 设置id属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
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
     * 获取lastUpdTime属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLastUpdTime() {
        return lastUpdTime;
    }

    /**
     * 设置lastUpdTime属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastUpdTime(String value) {
        this.lastUpdTime = value;
    }

    /**
     * 获取luckDraw属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLuckDraw() {
        return luckDraw;
    }

    /**
     * 设置luckDraw属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLuckDraw(String value) {
        this.luckDraw = value;
    }

    /**
     * 获取name属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * 设置name属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

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
     * 获取probability属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProbability() {
        return probability;
    }

    /**
     * 设置probability属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProbability(String value) {
        this.probability = value;
    }

    /**
     * 获取subType属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubType() {
        return subType;
    }

    /**
     * 设置subType属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubType(String value) {
        this.subType = value;
    }

    /**
     * 获取type属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * 设置type属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

    /**
     * 获取wifiDuration属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWifiDuration() {
        return wifiDuration;
    }

    /**
     * 设置wifiDuration属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWifiDuration(String value) {
        this.wifiDuration = value;
    }

}
