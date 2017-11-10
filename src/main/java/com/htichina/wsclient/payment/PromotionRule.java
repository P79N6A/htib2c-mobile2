
package com.htichina.wsclient.payment;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for promotionRule complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="promotionRule">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="attrib01" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="attrib02" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="created" type="{http://payment.ws.htichina.com/}timestamp" minOccurs="0"/>
 *         &lt;element name="created_by" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="factor1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="factor2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="giftPkgId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="last_upd" type="{http://payment.ws.htichina.com/}timestamp" minOccurs="0"/>
 *         &lt;element name="last_upd_by" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="promotionChannelList" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="promotionDiscount" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="promotionDiscountPrice" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="promotionEndDate" type="{http://payment.ws.htichina.com/}timestamp" minOccurs="0"/>
 *         &lt;element name="promotionName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="promotionNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="promotionPkgList" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="promotionPkgTypeList" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="promotionStartDate" type="{http://payment.ws.htichina.com/}timestamp" minOccurs="0"/>
 *         &lt;element name="promotionStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "promotionRule", propOrder = {
    "attrib01",
    "attrib02",
    "created",
    "createdBy",
    "factor1",
    "factor2",
    "giftPkgId",
    "lastUpd",
    "lastUpdBy",
    "promotionChannelList",
    "promotionDiscount",
    "promotionDiscountPrice",
    "promotionEndDate",
    "promotionName",
    "promotionNo",
    "promotionPkgList",
    "promotionPkgTypeList",
    "promotionStartDate",
    "promotionStatus"
})
public class PromotionRule {

    protected String attrib01;
    protected String attrib02;
    protected Timestamp created;
    @XmlElement(name = "created_by")
    protected String createdBy;
    protected String factor1;
    protected String factor2;
    protected String giftPkgId;
    @XmlElement(name = "last_upd")
    protected Timestamp lastUpd;
    @XmlElement(name = "last_upd_by")
    protected String lastUpdBy;
    protected String promotionChannelList;
    protected double promotionDiscount;
    protected double promotionDiscountPrice;
    protected Timestamp promotionEndDate;
    protected String promotionName;
    protected String promotionNo;
    protected String promotionPkgList;
    protected String promotionPkgTypeList;
    protected Timestamp promotionStartDate;
    protected String promotionStatus;

    /**
     * Gets the value of the attrib01 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAttrib01() {
        return attrib01;
    }

    /**
     * Sets the value of the attrib01 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAttrib01(String value) {
        this.attrib01 = value;
    }

    /**
     * Gets the value of the attrib02 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAttrib02() {
        return attrib02;
    }

    /**
     * Sets the value of the attrib02 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAttrib02(String value) {
        this.attrib02 = value;
    }

    /**
     * Gets the value of the created property.
     * 
     * @return
     *     possible object is
     *     {@link Timestamp }
     *     
     */
    public Timestamp getCreated() {
        return created;
    }

    /**
     * Sets the value of the created property.
     * 
     * @param value
     *     allowed object is
     *     {@link Timestamp }
     *     
     */
    public void setCreated(Timestamp value) {
        this.created = value;
    }

    /**
     * Gets the value of the createdBy property.
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
     * Sets the value of the createdBy property.
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
     * Gets the value of the factor1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFactor1() {
        return factor1;
    }

    /**
     * Sets the value of the factor1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFactor1(String value) {
        this.factor1 = value;
    }

    /**
     * Gets the value of the factor2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFactor2() {
        return factor2;
    }

    /**
     * Sets the value of the factor2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFactor2(String value) {
        this.factor2 = value;
    }

    /**
     * Gets the value of the giftPkgId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGiftPkgId() {
        return giftPkgId;
    }

    /**
     * Sets the value of the giftPkgId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGiftPkgId(String value) {
        this.giftPkgId = value;
    }

    /**
     * Gets the value of the lastUpd property.
     * 
     * @return
     *     possible object is
     *     {@link Timestamp }
     *     
     */
    public Timestamp getLastUpd() {
        return lastUpd;
    }

    /**
     * Sets the value of the lastUpd property.
     * 
     * @param value
     *     allowed object is
     *     {@link Timestamp }
     *     
     */
    public void setLastUpd(Timestamp value) {
        this.lastUpd = value;
    }

    /**
     * Gets the value of the lastUpdBy property.
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
     * Sets the value of the lastUpdBy property.
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
     * Gets the value of the promotionChannelList property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPromotionChannelList() {
        return promotionChannelList;
    }

    /**
     * Sets the value of the promotionChannelList property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPromotionChannelList(String value) {
        this.promotionChannelList = value;
    }

    /**
     * Gets the value of the promotionDiscount property.
     * 
     */
    public double getPromotionDiscount() {
        return promotionDiscount;
    }

    /**
     * Sets the value of the promotionDiscount property.
     * 
     */
    public void setPromotionDiscount(double value) {
        this.promotionDiscount = value;
    }

    /**
     * Gets the value of the promotionDiscountPrice property.
     * 
     */
    public double getPromotionDiscountPrice() {
        return promotionDiscountPrice;
    }

    /**
     * Sets the value of the promotionDiscountPrice property.
     * 
     */
    public void setPromotionDiscountPrice(double value) {
        this.promotionDiscountPrice = value;
    }

    /**
     * Gets the value of the promotionEndDate property.
     * 
     * @return
     *     possible object is
     *     {@link Timestamp }
     *     
     */
    public Timestamp getPromotionEndDate() {
        return promotionEndDate;
    }

    /**
     * Sets the value of the promotionEndDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link Timestamp }
     *     
     */
    public void setPromotionEndDate(Timestamp value) {
        this.promotionEndDate = value;
    }

    /**
     * Gets the value of the promotionName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPromotionName() {
        return promotionName;
    }

    /**
     * Sets the value of the promotionName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPromotionName(String value) {
        this.promotionName = value;
    }

    /**
     * Gets the value of the promotionNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPromotionNo() {
        return promotionNo;
    }

    /**
     * Sets the value of the promotionNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPromotionNo(String value) {
        this.promotionNo = value;
    }

    /**
     * Gets the value of the promotionPkgList property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPromotionPkgList() {
        return promotionPkgList;
    }

    /**
     * Sets the value of the promotionPkgList property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPromotionPkgList(String value) {
        this.promotionPkgList = value;
    }

    /**
     * Gets the value of the promotionPkgTypeList property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPromotionPkgTypeList() {
        return promotionPkgTypeList;
    }

    /**
     * Sets the value of the promotionPkgTypeList property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPromotionPkgTypeList(String value) {
        this.promotionPkgTypeList = value;
    }

    /**
     * Gets the value of the promotionStartDate property.
     * 
     * @return
     *     possible object is
     *     {@link Timestamp }
     *     
     */
    public Timestamp getPromotionStartDate() {
        return promotionStartDate;
    }

    /**
     * Sets the value of the promotionStartDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link Timestamp }
     *     
     */
    public void setPromotionStartDate(Timestamp value) {
        this.promotionStartDate = value;
    }

    /**
     * Gets the value of the promotionStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPromotionStatus() {
        return promotionStatus;
    }

    /**
     * Sets the value of the promotionStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPromotionStatus(String value) {
        this.promotionStatus = value;
    }

}
