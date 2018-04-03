
package com.htichina.wsclient.payment;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>serviceOrder complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="serviceOrder">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="accnt_num" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="attrib_01" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="attrib_02" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="attrib_03" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="attrib_04" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="attrib_05" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="attrib_06" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="created" type="{http://payment.ws.htichina.com/}timestamp" minOccurs="0"/>
 *         &lt;element name="created_by" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="end_dt" type="{http://payment.ws.htichina.com/}timestamp" minOccurs="0"/>
 *         &lt;element name="lang" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="last_upd" type="{http://payment.ws.htichina.com/}timestamp" minOccurs="0"/>
 *         &lt;element name="last_upd_by" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="new_end_dt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="new_start_dt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="old_end_dt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="old_start_dt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="order_channel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="order_num" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="order_stat" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="order_type" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="parent_num" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="payment_channel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="payment_offline_num" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="payment_stat" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="payment_trans_num" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="payment_ts" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="payment_type" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="pkg_id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="price" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="quanti" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="start_dt" type="{http://payment.ws.htichina.com/}timestamp" minOccurs="0"/>
 *         &lt;element name="upgrade_gap_price" type="{http://www.w3.org/2001/XMLSchema}double"/>
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
@XmlType(name = "serviceOrder", propOrder = {
    "accntNum",
    "attrib01",
    "attrib02",
    "attrib03",
    "attrib04",
    "attrib05",
    "attrib06",
    "created",
    "createdBy",
    "endDt",
    "lang",
    "lastUpd",
    "lastUpdBy",
    "newEndDt",
    "newStartDt",
    "oldEndDt",
    "oldStartDt",
    "orderChannel",
    "orderNum",
    "orderStat",
    "orderType",
    "parentNum",
    "paymentChannel",
    "paymentOfflineNum",
    "paymentStat",
    "paymentTransNum",
    "paymentTs",
    "paymentType",
    "pkgId",
    "price",
    "quanti",
    "startDt",
    "upgradeGapPrice",
    "vin"
})
public class ServiceOrder {

    @XmlElement(name = "accnt_num")
    protected String accntNum;
    @XmlElement(name = "attrib_01")
    protected String attrib01;
    @XmlElement(name = "attrib_02")
    protected boolean attrib02;
    @XmlElement(name = "attrib_03")
    protected String attrib03;
    @XmlElement(name = "attrib_04")
    protected double attrib04;
    @XmlElement(name = "attrib_05")
    protected String attrib05;
    @XmlElement(name = "attrib_06")
    protected String attrib06;
    protected Timestamp created;
    @XmlElement(name = "created_by")
    protected String createdBy;
    @XmlElement(name = "end_dt")
    protected Timestamp endDt;
    protected String lang;
    @XmlElement(name = "last_upd")
    protected Timestamp lastUpd;
    @XmlElement(name = "last_upd_by")
    protected String lastUpdBy;
    @XmlElement(name = "new_end_dt")
    protected String newEndDt;
    @XmlElement(name = "new_start_dt")
    protected String newStartDt;
    @XmlElement(name = "old_end_dt")
    protected String oldEndDt;
    @XmlElement(name = "old_start_dt")
    protected String oldStartDt;
    @XmlElement(name = "order_channel")
    protected String orderChannel;
    @XmlElement(name = "order_num")
    protected String orderNum;
    @XmlElement(name = "order_stat")
    protected String orderStat;
    @XmlElement(name = "order_type")
    protected String orderType;
    @XmlElement(name = "parent_num")
    protected String parentNum;
    @XmlElement(name = "payment_channel")
    protected String paymentChannel;
    @XmlElement(name = "payment_offline_num")
    protected String paymentOfflineNum;
    @XmlElement(name = "payment_stat")
    protected String paymentStat;
    @XmlElement(name = "payment_trans_num")
    protected String paymentTransNum;
    @XmlElement(name = "payment_ts")
    protected String paymentTs;
    @XmlElement(name = "payment_type")
    protected String paymentType;
    @XmlElement(name = "pkg_id")
    protected String pkgId;
    protected double price;
    protected int quanti;
    @XmlElement(name = "start_dt")
    protected Timestamp startDt;
    @XmlElement(name = "upgrade_gap_price")
    protected double upgradeGapPrice;
    protected String vin;

    /**
     * 获取accntNum属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccntNum() {
        return accntNum;
    }

    /**
     * 设置accntNum属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccntNum(String value) {
        this.accntNum = value;
    }

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
     */
    public boolean isAttrib02() {
        return attrib02;
    }

    /**
     * 设置attrib02属性的值。
     * 
     */
    public void setAttrib02(boolean value) {
        this.attrib02 = value;
    }

    /**
     * 获取attrib03属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAttrib03() {
        return attrib03;
    }

    /**
     * 设置attrib03属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAttrib03(String value) {
        this.attrib03 = value;
    }

    /**
     * 获取attrib04属性的值。
     * 
     */
    public double getAttrib04() {
        return attrib04;
    }

    /**
     * 设置attrib04属性的值。
     * 
     */
    public void setAttrib04(double value) {
        this.attrib04 = value;
    }

    /**
     * 获取attrib05属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAttrib05() {
        return attrib05;
    }

    /**
     * 设置attrib05属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAttrib05(String value) {
        this.attrib05 = value;
    }

    /**
     * 获取attrib06属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAttrib06() {
        return attrib06;
    }

    /**
     * 设置attrib06属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAttrib06(String value) {
        this.attrib06 = value;
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
     * 获取endDt属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Timestamp }
     *     
     */
    public Timestamp getEndDt() {
        return endDt;
    }

    /**
     * 设置endDt属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Timestamp }
     *     
     */
    public void setEndDt(Timestamp value) {
        this.endDt = value;
    }

    /**
     * 获取lang属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLang() {
        return lang;
    }

    /**
     * 设置lang属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLang(String value) {
        this.lang = value;
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
     * 获取newEndDt属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNewEndDt() {
        return newEndDt;
    }

    /**
     * 设置newEndDt属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNewEndDt(String value) {
        this.newEndDt = value;
    }

    /**
     * 获取newStartDt属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNewStartDt() {
        return newStartDt;
    }

    /**
     * 设置newStartDt属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNewStartDt(String value) {
        this.newStartDt = value;
    }

    /**
     * 获取oldEndDt属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOldEndDt() {
        return oldEndDt;
    }

    /**
     * 设置oldEndDt属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOldEndDt(String value) {
        this.oldEndDt = value;
    }

    /**
     * 获取oldStartDt属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOldStartDt() {
        return oldStartDt;
    }

    /**
     * 设置oldStartDt属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOldStartDt(String value) {
        this.oldStartDt = value;
    }

    /**
     * 获取orderChannel属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrderChannel() {
        return orderChannel;
    }

    /**
     * 设置orderChannel属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrderChannel(String value) {
        this.orderChannel = value;
    }

    /**
     * 获取orderNum属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrderNum() {
        return orderNum;
    }

    /**
     * 设置orderNum属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrderNum(String value) {
        this.orderNum = value;
    }

    /**
     * 获取orderStat属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrderStat() {
        return orderStat;
    }

    /**
     * 设置orderStat属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrderStat(String value) {
        this.orderStat = value;
    }

    /**
     * 获取orderType属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrderType() {
        return orderType;
    }

    /**
     * 设置orderType属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrderType(String value) {
        this.orderType = value;
    }

    /**
     * 获取parentNum属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getParentNum() {
        return parentNum;
    }

    /**
     * 设置parentNum属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setParentNum(String value) {
        this.parentNum = value;
    }

    /**
     * 获取paymentChannel属性的值。
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
     * 设置paymentChannel属性的值。
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
     * 获取paymentOfflineNum属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaymentOfflineNum() {
        return paymentOfflineNum;
    }

    /**
     * 设置paymentOfflineNum属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaymentOfflineNum(String value) {
        this.paymentOfflineNum = value;
    }

    /**
     * 获取paymentStat属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaymentStat() {
        return paymentStat;
    }

    /**
     * 设置paymentStat属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaymentStat(String value) {
        this.paymentStat = value;
    }

    /**
     * 获取paymentTransNum属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaymentTransNum() {
        return paymentTransNum;
    }

    /**
     * 设置paymentTransNum属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaymentTransNum(String value) {
        this.paymentTransNum = value;
    }

    /**
     * 获取paymentTs属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaymentTs() {
        return paymentTs;
    }

    /**
     * 设置paymentTs属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaymentTs(String value) {
        this.paymentTs = value;
    }

    /**
     * 获取paymentType属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaymentType() {
        return paymentType;
    }

    /**
     * 设置paymentType属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaymentType(String value) {
        this.paymentType = value;
    }

    /**
     * 获取pkgId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPkgId() {
        return pkgId;
    }

    /**
     * 设置pkgId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPkgId(String value) {
        this.pkgId = value;
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
     * 获取quanti属性的值。
     * 
     */
    public int getQuanti() {
        return quanti;
    }

    /**
     * 设置quanti属性的值。
     * 
     */
    public void setQuanti(int value) {
        this.quanti = value;
    }

    /**
     * 获取startDt属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Timestamp }
     *     
     */
    public Timestamp getStartDt() {
        return startDt;
    }

    /**
     * 设置startDt属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Timestamp }
     *     
     */
    public void setStartDt(Timestamp value) {
        this.startDt = value;
    }

    /**
     * 获取upgradeGapPrice属性的值。
     * 
     */
    public double getUpgradeGapPrice() {
        return upgradeGapPrice;
    }

    /**
     * 设置upgradeGapPrice属性的值。
     * 
     */
    public void setUpgradeGapPrice(double value) {
        this.upgradeGapPrice = value;
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
