
package com.htichina.wsclient.payment;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>serviceOrder complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
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
     * ��ȡaccntNum���Ե�ֵ��
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
     * ����accntNum���Ե�ֵ��
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
     */
    public boolean isAttrib02() {
        return attrib02;
    }

    /**
     * ����attrib02���Ե�ֵ��
     * 
     */
    public void setAttrib02(boolean value) {
        this.attrib02 = value;
    }

    /**
     * ��ȡattrib03���Ե�ֵ��
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
     * ����attrib03���Ե�ֵ��
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
     * ��ȡattrib04���Ե�ֵ��
     * 
     */
    public double getAttrib04() {
        return attrib04;
    }

    /**
     * ����attrib04���Ե�ֵ��
     * 
     */
    public void setAttrib04(double value) {
        this.attrib04 = value;
    }

    /**
     * ��ȡattrib05���Ե�ֵ��
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
     * ����attrib05���Ե�ֵ��
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
     * ��ȡattrib06���Ե�ֵ��
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
     * ����attrib06���Ե�ֵ��
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
     * ��ȡendDt���Ե�ֵ��
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
     * ����endDt���Ե�ֵ��
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
     * ��ȡlang���Ե�ֵ��
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
     * ����lang���Ե�ֵ��
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
     * ��ȡnewEndDt���Ե�ֵ��
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
     * ����newEndDt���Ե�ֵ��
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
     * ��ȡnewStartDt���Ե�ֵ��
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
     * ����newStartDt���Ե�ֵ��
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
     * ��ȡoldEndDt���Ե�ֵ��
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
     * ����oldEndDt���Ե�ֵ��
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
     * ��ȡoldStartDt���Ե�ֵ��
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
     * ����oldStartDt���Ե�ֵ��
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
     * ��ȡorderChannel���Ե�ֵ��
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
     * ����orderChannel���Ե�ֵ��
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
     * ��ȡorderNum���Ե�ֵ��
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
     * ����orderNum���Ե�ֵ��
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
     * ��ȡorderStat���Ե�ֵ��
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
     * ����orderStat���Ե�ֵ��
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
     * ��ȡorderType���Ե�ֵ��
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
     * ����orderType���Ե�ֵ��
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
     * ��ȡparentNum���Ե�ֵ��
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
     * ����parentNum���Ե�ֵ��
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
     * ��ȡpaymentChannel���Ե�ֵ��
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
     * ����paymentChannel���Ե�ֵ��
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
     * ��ȡpaymentOfflineNum���Ե�ֵ��
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
     * ����paymentOfflineNum���Ե�ֵ��
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
     * ��ȡpaymentStat���Ե�ֵ��
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
     * ����paymentStat���Ե�ֵ��
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
     * ��ȡpaymentTransNum���Ե�ֵ��
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
     * ����paymentTransNum���Ե�ֵ��
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
     * ��ȡpaymentTs���Ե�ֵ��
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
     * ����paymentTs���Ե�ֵ��
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
     * ��ȡpaymentType���Ե�ֵ��
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
     * ����paymentType���Ե�ֵ��
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
     * ��ȡpkgId���Ե�ֵ��
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
     * ����pkgId���Ե�ֵ��
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
     * ��ȡprice���Ե�ֵ��
     * 
     */
    public double getPrice() {
        return price;
    }

    /**
     * ����price���Ե�ֵ��
     * 
     */
    public void setPrice(double value) {
        this.price = value;
    }

    /**
     * ��ȡquanti���Ե�ֵ��
     * 
     */
    public int getQuanti() {
        return quanti;
    }

    /**
     * ����quanti���Ե�ֵ��
     * 
     */
    public void setQuanti(int value) {
        this.quanti = value;
    }

    /**
     * ��ȡstartDt���Ե�ֵ��
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
     * ����startDt���Ե�ֵ��
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
     * ��ȡupgradeGapPrice���Ե�ֵ��
     * 
     */
    public double getUpgradeGapPrice() {
        return upgradeGapPrice;
    }

    /**
     * ����upgradeGapPrice���Ե�ֵ��
     * 
     */
    public void setUpgradeGapPrice(double value) {
        this.upgradeGapPrice = value;
    }

    /**
     * ��ȡvin���Ե�ֵ��
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
     * ����vin���Ե�ֵ��
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
