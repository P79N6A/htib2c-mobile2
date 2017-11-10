
package com.htichina.wsclient.payment;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for packageUpgradeRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="packageUpgradeRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="accountNum" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="calculateByActivePkg" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="endDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="newPackageId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="newPackageName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="openId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="originalPackageId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="originalPackageName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="originalPackageState" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="originalPrice" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="originalServiceOrderNum" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="paymentChannel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="startDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="subscriptionName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="upgradeGapPrice" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="vin" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
@XmlType(name = "packageUpgradeRequest", propOrder = {
    "accountNum",
    "calculateByActivePkg",
    "endDate",
    "newPackageId",
    "newPackageName",
    "openId",
    "originalPackageId",
    "originalPackageName",
    "originalPackageState",
    "originalPrice",
    "originalServiceOrderNum",
    "paymentChannel",
    "startDate",
    "subscriptionName",
    "upgradeGapPrice",
    "vin",
    "webSubscriptionId"
})
public class PackageUpgradeRequest {

    protected String accountNum;
    protected boolean calculateByActivePkg;
    protected String endDate;
    protected String newPackageId;
    protected String newPackageName;
    protected String openId;
    protected String originalPackageId;
    protected String originalPackageName;
    protected String originalPackageState;
    protected Double originalPrice;
    protected String originalServiceOrderNum;
    protected String paymentChannel;
    protected String startDate;
    protected String subscriptionName;
    protected Double upgradeGapPrice;
    protected String vin;
    protected String webSubscriptionId;

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
     * Gets the value of the calculateByActivePkg property.
     * 
     */
    public boolean isCalculateByActivePkg() {
        return calculateByActivePkg;
    }

    /**
     * Sets the value of the calculateByActivePkg property.
     * 
     */
    public void setCalculateByActivePkg(boolean value) {
        this.calculateByActivePkg = value;
    }

    /**
     * Gets the value of the endDate property.
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
     * Sets the value of the endDate property.
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
     * Gets the value of the newPackageId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNewPackageId() {
        return newPackageId;
    }

    /**
     * Sets the value of the newPackageId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNewPackageId(String value) {
        this.newPackageId = value;
    }

    /**
     * Gets the value of the newPackageName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNewPackageName() {
        return newPackageName;
    }

    /**
     * Sets the value of the newPackageName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNewPackageName(String value) {
        this.newPackageName = value;
    }

    /**
     * Gets the value of the openId property.
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
     * Sets the value of the openId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOpenId(String value) {
        this.openId = value;
    }

    /**
     * Gets the value of the originalPackageId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOriginalPackageId() {
        return originalPackageId;
    }

    /**
     * Sets the value of the originalPackageId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOriginalPackageId(String value) {
        this.originalPackageId = value;
    }

    /**
     * Gets the value of the originalPackageName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOriginalPackageName() {
        return originalPackageName;
    }

    /**
     * Sets the value of the originalPackageName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOriginalPackageName(String value) {
        this.originalPackageName = value;
    }

    /**
     * Gets the value of the originalPackageState property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOriginalPackageState() {
        return originalPackageState;
    }

    /**
     * Sets the value of the originalPackageState property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOriginalPackageState(String value) {
        this.originalPackageState = value;
    }

    /**
     * Gets the value of the originalPrice property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getOriginalPrice() {
        return originalPrice;
    }

    /**
     * Sets the value of the originalPrice property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setOriginalPrice(Double value) {
        this.originalPrice = value;
    }

    /**
     * Gets the value of the originalServiceOrderNum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOriginalServiceOrderNum() {
        return originalServiceOrderNum;
    }

    /**
     * Sets the value of the originalServiceOrderNum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOriginalServiceOrderNum(String value) {
        this.originalServiceOrderNum = value;
    }

    /**
     * Gets the value of the paymentChannel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaymentChannel() {
        return paymentChannel;
    }

    /**
     * Sets the value of the paymentChannel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaymentChannel(String value) {
        this.paymentChannel = value;
    }

    /**
     * Gets the value of the startDate property.
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
     * Sets the value of the startDate property.
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
     * Gets the value of the subscriptionName property.
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
     * Sets the value of the subscriptionName property.
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
     * Gets the value of the upgradeGapPrice property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getUpgradeGapPrice() {
        return upgradeGapPrice;
    }

    /**
     * Sets the value of the upgradeGapPrice property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setUpgradeGapPrice(Double value) {
        this.upgradeGapPrice = value;
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

    /**
     * Gets the value of the webSubscriptionId property.
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
     * Sets the value of the webSubscriptionId property.
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
