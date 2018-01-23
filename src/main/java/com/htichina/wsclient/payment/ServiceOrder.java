
package com.htichina.wsclient.payment;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for serviceOrder complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
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
     * Gets the value of the accntNum property.
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
     * Sets the value of the accntNum property.
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
     */
    public boolean isAttrib02() {
        return attrib02;
    }

    /**
     * Sets the value of the attrib02 property.
     * 
     */
    public void setAttrib02(boolean value) {
        this.attrib02 = value;
    }

    /**
     * Gets the value of the attrib03 property.
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
     * Sets the value of the attrib03 property.
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
     * Gets the value of the attrib04 property.
     * 
     */
    public double getAttrib04() {
        return attrib04;
    }

    /**
     * Sets the value of the attrib04 property.
     * 
     */
    public void setAttrib04(double value) {
        this.attrib04 = value;
    }

    /**
     * Gets the value of the attrib05 property.
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
     * Sets the value of the attrib05 property.
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
     * Gets the value of the attrib06 property.
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
     * Sets the value of the attrib06 property.
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
     * Gets the value of the endDt property.
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
     * Sets the value of the endDt property.
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
     * Gets the value of the lang property.
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
     * Sets the value of the lang property.
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
     * Gets the value of the newEndDt property.
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
     * Sets the value of the newEndDt property.
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
     * Gets the value of the newStartDt property.
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
     * Sets the value of the newStartDt property.
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
     * Gets the value of the oldEndDt property.
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
     * Sets the value of the oldEndDt property.
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
     * Gets the value of the oldStartDt property.
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
     * Sets the value of the oldStartDt property.
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
     * Gets the value of the orderChannel property.
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
     * Sets the value of the orderChannel property.
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
     * Gets the value of the orderNum property.
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
     * Sets the value of the orderNum property.
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
     * Gets the value of the orderStat property.
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
     * Sets the value of the orderStat property.
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
     * Gets the value of the orderType property.
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
     * Sets the value of the orderType property.
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
     * Gets the value of the parentNum property.
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
     * Sets the value of the parentNum property.
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
     * Gets the value of the paymentOfflineNum property.
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
     * Sets the value of the paymentOfflineNum property.
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
     * Gets the value of the paymentStat property.
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
     * Sets the value of the paymentStat property.
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
     * Gets the value of the paymentTransNum property.
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
     * Sets the value of the paymentTransNum property.
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
     * Gets the value of the paymentTs property.
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
     * Sets the value of the paymentTs property.
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
     * Gets the value of the paymentType property.
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
     * Sets the value of the paymentType property.
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
     * Gets the value of the pkgId property.
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
     * Sets the value of the pkgId property.
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
     * Gets the value of the price property.
     * 
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets the value of the price property.
     * 
     */
    public void setPrice(double value) {
        this.price = value;
    }

    /**
     * Gets the value of the quanti property.
     * 
     */
    public int getQuanti() {
        return quanti;
    }

    /**
     * Sets the value of the quanti property.
     * 
     */
    public void setQuanti(int value) {
        this.quanti = value;
    }

    /**
     * Gets the value of the startDt property.
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
     * Sets the value of the startDt property.
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
     * Gets the value of the upgradeGapPrice property.
     * 
     */
    public double getUpgradeGapPrice() {
        return upgradeGapPrice;
    }

    /**
     * Sets the value of the upgradeGapPrice property.
     * 
     */
    public void setUpgradeGapPrice(double value) {
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

}
