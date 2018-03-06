
package com.htichina.wsclient.payment;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>promotionRule complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
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
     * 获取attrib01属性的值。
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
     * 设置attrib01属性的值。
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
     * 获取attrib02属性的值。
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
     * 设置attrib02属性的值。
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
     * 获取created属性的值。
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
     * 设置created属性的值。
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
     * 获取factor1属性的值。
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
     * 设置factor1属性的值。
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
     * 获取factor2属性的值。
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
     * 设置factor2属性的值。
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
     * 获取giftPkgId属性的值。
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
     * 设置giftPkgId属性的值。
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
     * 获取lastUpd属性的值。
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
     * 设置lastUpd属性的值。
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
     * 获取promotionChannelList属性的值。
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
     * 设置promotionChannelList属性的值。
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
     * 获取promotionDiscount属性的值。
     * 
     */
    public double getPromotionDiscount() {
        return promotionDiscount;
    }

    /**
     * 设置promotionDiscount属性的值。
     * 
     */
    public void setPromotionDiscount(double value) {
        this.promotionDiscount = value;
    }

    /**
     * 获取promotionDiscountPrice属性的值。
     * 
     */
    public double getPromotionDiscountPrice() {
        return promotionDiscountPrice;
    }

    /**
     * 设置promotionDiscountPrice属性的值。
     * 
     */
    public void setPromotionDiscountPrice(double value) {
        this.promotionDiscountPrice = value;
    }

    /**
     * 获取promotionEndDate属性的值。
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
     * 设置promotionEndDate属性的值。
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
     * 获取promotionName属性的值。
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
     * 设置promotionName属性的值。
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
     * 获取promotionNo属性的值。
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
     * 设置promotionNo属性的值。
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
     * 获取promotionPkgList属性的值。
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
     * 设置promotionPkgList属性的值。
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
     * 获取promotionPkgTypeList属性的值。
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
     * 设置promotionPkgTypeList属性的值。
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
     * 获取promotionStartDate属性的值。
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
     * 设置promotionStartDate属性的值。
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
     * 获取promotionStatus属性的值。
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
     * 设置promotionStatus属性的值。
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
