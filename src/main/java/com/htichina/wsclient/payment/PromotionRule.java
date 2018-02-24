
package com.htichina.wsclient.payment;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>promotionRule complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
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
     * ��ȡattrib01���Ե�ֵ��
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
     * ����attrib01���Ե�ֵ��
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
     * ��ȡattrib02���Ե�ֵ��
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
     * ����attrib02���Ե�ֵ��
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
     * ��ȡcreated���Ե�ֵ��
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
     * ����created���Ե�ֵ��
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
     * ��ȡcreatedBy���Ե�ֵ��
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
     * ����createdBy���Ե�ֵ��
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
     * ��ȡfactor1���Ե�ֵ��
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
     * ����factor1���Ե�ֵ��
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
     * ��ȡfactor2���Ե�ֵ��
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
     * ����factor2���Ե�ֵ��
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
     * ��ȡgiftPkgId���Ե�ֵ��
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
     * ����giftPkgId���Ե�ֵ��
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
     * ��ȡlastUpd���Ե�ֵ��
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
     * ����lastUpd���Ե�ֵ��
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
     * ��ȡlastUpdBy���Ե�ֵ��
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
     * ����lastUpdBy���Ե�ֵ��
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
     * ��ȡpromotionChannelList���Ե�ֵ��
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
     * ����promotionChannelList���Ե�ֵ��
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
     * ��ȡpromotionDiscount���Ե�ֵ��
     * 
     */
    public double getPromotionDiscount() {
        return promotionDiscount;
    }

    /**
     * ����promotionDiscount���Ե�ֵ��
     * 
     */
    public void setPromotionDiscount(double value) {
        this.promotionDiscount = value;
    }

    /**
     * ��ȡpromotionDiscountPrice���Ե�ֵ��
     * 
     */
    public double getPromotionDiscountPrice() {
        return promotionDiscountPrice;
    }

    /**
     * ����promotionDiscountPrice���Ե�ֵ��
     * 
     */
    public void setPromotionDiscountPrice(double value) {
        this.promotionDiscountPrice = value;
    }

    /**
     * ��ȡpromotionEndDate���Ե�ֵ��
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
     * ����promotionEndDate���Ե�ֵ��
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
     * ��ȡpromotionName���Ե�ֵ��
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
     * ����promotionName���Ե�ֵ��
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
     * ��ȡpromotionNo���Ե�ֵ��
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
     * ����promotionNo���Ե�ֵ��
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
     * ��ȡpromotionPkgList���Ե�ֵ��
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
     * ����promotionPkgList���Ե�ֵ��
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
     * ��ȡpromotionPkgTypeList���Ե�ֵ��
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
     * ����promotionPkgTypeList���Ե�ֵ��
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
     * ��ȡpromotionStartDate���Ե�ֵ��
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
     * ����promotionStartDate���Ե�ֵ��
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
     * ��ȡpromotionStatus���Ե�ֵ��
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
     * ����promotionStatus���Ե�ֵ��
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
