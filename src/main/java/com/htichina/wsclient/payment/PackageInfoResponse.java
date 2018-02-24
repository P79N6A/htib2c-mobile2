
package com.htichina.wsclient.payment;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>packageInfoResponse complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="packageInfoResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="balance" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="base" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="canBeUpgrated" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="endDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="packageName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="packageStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="startDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="subscriptionName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="webSubscriptionId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "packageInfoResponse", propOrder = {
    "balance",
    "base",
    "canBeUpgrated",
    "endDate",
    "packageName",
    "packageStatus",
    "startDate",
    "subscriptionName",
    "webSubscriptionId"
})
public class PackageInfoResponse {

    protected double balance;
    protected boolean base;
    protected boolean canBeUpgrated;
    protected String endDate;
    protected String packageName;
    protected String packageStatus;
    protected String startDate;
    protected String subscriptionName;
    protected String webSubscriptionId;

    /**
     * 获取balance属性的值。
     * 
     */
    public double getBalance() {
        return balance;
    }

    /**
     * 设置balance属性的值。
     * 
     */
    public void setBalance(double value) {
        this.balance = value;
    }

    /**
     * 获取base属性的值。
     * 
     */
    public boolean isBase() {
        return base;
    }

    /**
     * 设置base属性的值。
     * 
     */
    public void setBase(boolean value) {
        this.base = value;
    }

    /**
     * 获取canBeUpgrated属性的值。
     * 
     */
    public boolean isCanBeUpgrated() {
        return canBeUpgrated;
    }

    /**
     * 设置canBeUpgrated属性的值。
     * 
     */
    public void setCanBeUpgrated(boolean value) {
        this.canBeUpgrated = value;
    }

    /**
     * 获取endDate属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEndDate() {
        return endDate;
    }

    /**
     * 设置endDate属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEndDate(String value) {
        this.endDate = value;
    }

    /**
     * 获取packageName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPackageName() {
        return packageName;
    }

    /**
     * 设置packageName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPackageName(String value) {
        this.packageName = value;
    }

    /**
     * 获取packageStatus属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPackageStatus() {
        return packageStatus;
    }

    /**
     * 设置packageStatus属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPackageStatus(String value) {
        this.packageStatus = value;
    }

    /**
     * 获取startDate属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStartDate() {
        return startDate;
    }

    /**
     * 设置startDate属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStartDate(String value) {
        this.startDate = value;
    }

    /**
     * 获取subscriptionName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubscriptionName() {
        return subscriptionName;
    }

    /**
     * 设置subscriptionName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubscriptionName(String value) {
        this.subscriptionName = value;
    }

    /**
     * 获取webSubscriptionId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWebSubscriptionId() {
        return webSubscriptionId;
    }

    /**
     * 设置webSubscriptionId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWebSubscriptionId(String value) {
        this.webSubscriptionId = value;
    }

}
