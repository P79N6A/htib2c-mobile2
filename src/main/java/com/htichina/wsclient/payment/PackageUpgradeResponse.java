
package com.htichina.wsclient.payment;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for packageUpgradeResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="packageUpgradeResponse">
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
 *         &lt;element name="originalPrice" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="originalServiceOrderNum" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="respCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="respMsg" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="startDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="upgradeGapPrice" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="upgratedParentOrderNum" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "packageUpgradeResponse", propOrder = {
    "accountNum",
    "calculateByActivePkg",
    "endDate",
    "newPackageId",
    "newPackageName",
    "openId",
    "originalPackageId",
    "originalPackageName",
    "originalPrice",
    "originalServiceOrderNum",
    "respCode",
    "respMsg",
    "startDate",
    "upgradeGapPrice",
    "upgratedParentOrderNum"
})
public class PackageUpgradeResponse {

    protected String accountNum;
    protected boolean calculateByActivePkg;
    protected String endDate;
    protected String newPackageId;
    protected String newPackageName;
    protected String openId;
    protected String originalPackageId;
    protected String originalPackageName;
    protected Double originalPrice;
    protected String originalServiceOrderNum;
    protected String respCode;
    protected String respMsg;
    protected String startDate;
    protected Double upgradeGapPrice;
    protected String upgratedParentOrderNum;

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
     * Gets the value of the respCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRespCode() {
        return respCode;
    }

    /**
     * Sets the value of the respCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRespCode(String value) {
        this.respCode = value;
    }

    /**
     * Gets the value of the respMsg property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRespMsg() {
        return respMsg;
    }

    /**
     * Sets the value of the respMsg property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRespMsg(String value) {
        this.respMsg = value;
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
     * Gets the value of the upgratedParentOrderNum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUpgratedParentOrderNum() {
        return upgratedParentOrderNum;
    }

    /**
     * Sets the value of the upgratedParentOrderNum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUpgratedParentOrderNum(String value) {
        this.upgratedParentOrderNum = value;
    }

}
