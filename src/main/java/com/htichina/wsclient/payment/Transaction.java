
package com.htichina.wsclient.payment;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for transaction complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="transaction">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="amount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="bankaddress" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="bankcardno" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="bankphoneno" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cardtype" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="created" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idcardaddress" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idcardname" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idcardno" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="lastuptime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="operatorid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="orderNum" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="orderdescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="orderno" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="orderstate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="remark" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="respcode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="respmsg" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="response" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="serialno" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="transchannel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="transtime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="transtype" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "transaction", propOrder = {
    "amount",
    "bankaddress",
    "bankcardno",
    "bankphoneno",
    "cardtype",
    "created",
    "id",
    "idcardaddress",
    "idcardname",
    "idcardno",
    "lastuptime",
    "operatorid",
    "orderNum",
    "orderdescription",
    "orderno",
    "orderstate",
    "remark",
    "respcode",
    "respmsg",
    "response",
    "serialno",
    "transchannel",
    "transtime",
    "transtype"
})
public class Transaction {

    protected String amount;
    protected String bankaddress;
    protected String bankcardno;
    protected String bankphoneno;
    protected String cardtype;
    protected String created;
    protected String id;
    protected String idcardaddress;
    protected String idcardname;
    protected String idcardno;
    protected String lastuptime;
    protected String operatorid;
    protected String orderNum;
    protected String orderdescription;
    protected String orderno;
    protected String orderstate;
    protected String remark;
    protected String respcode;
    protected String respmsg;
    protected String response;
    protected String serialno;
    protected String transchannel;
    protected String transtime;
    protected String transtype;

    /**
     * Gets the value of the amount property.
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
     * Sets the value of the amount property.
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
     * Gets the value of the bankaddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBankaddress() {
        return bankaddress;
    }

    /**
     * Sets the value of the bankaddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBankaddress(String value) {
        this.bankaddress = value;
    }

    /**
     * Gets the value of the bankcardno property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBankcardno() {
        return bankcardno;
    }

    /**
     * Sets the value of the bankcardno property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBankcardno(String value) {
        this.bankcardno = value;
    }

    /**
     * Gets the value of the bankphoneno property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBankphoneno() {
        return bankphoneno;
    }

    /**
     * Sets the value of the bankphoneno property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBankphoneno(String value) {
        this.bankphoneno = value;
    }

    /**
     * Gets the value of the cardtype property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCardtype() {
        return cardtype;
    }

    /**
     * Sets the value of the cardtype property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCardtype(String value) {
        this.cardtype = value;
    }

    /**
     * Gets the value of the created property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreated() {
        return created;
    }

    /**
     * Sets the value of the created property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreated(String value) {
        this.created = value;
    }

    /**
     * Gets the value of the id property.
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
     * Sets the value of the id property.
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
     * Gets the value of the idcardaddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdcardaddress() {
        return idcardaddress;
    }

    /**
     * Sets the value of the idcardaddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdcardaddress(String value) {
        this.idcardaddress = value;
    }

    /**
     * Gets the value of the idcardname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdcardname() {
        return idcardname;
    }

    /**
     * Sets the value of the idcardname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdcardname(String value) {
        this.idcardname = value;
    }

    /**
     * Gets the value of the idcardno property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdcardno() {
        return idcardno;
    }

    /**
     * Sets the value of the idcardno property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdcardno(String value) {
        this.idcardno = value;
    }

    /**
     * Gets the value of the lastuptime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLastuptime() {
        return lastuptime;
    }

    /**
     * Sets the value of the lastuptime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastuptime(String value) {
        this.lastuptime = value;
    }

    /**
     * Gets the value of the operatorid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOperatorid() {
        return operatorid;
    }

    /**
     * Sets the value of the operatorid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOperatorid(String value) {
        this.operatorid = value;
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
     * Gets the value of the orderdescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrderdescription() {
        return orderdescription;
    }

    /**
     * Sets the value of the orderdescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrderdescription(String value) {
        this.orderdescription = value;
    }

    /**
     * Gets the value of the orderno property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrderno() {
        return orderno;
    }

    /**
     * Sets the value of the orderno property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrderno(String value) {
        this.orderno = value;
    }

    /**
     * Gets the value of the orderstate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrderstate() {
        return orderstate;
    }

    /**
     * Sets the value of the orderstate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrderstate(String value) {
        this.orderstate = value;
    }

    /**
     * Gets the value of the remark property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRemark() {
        return remark;
    }

    /**
     * Sets the value of the remark property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRemark(String value) {
        this.remark = value;
    }

    /**
     * Gets the value of the respcode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRespcode() {
        return respcode;
    }

    /**
     * Sets the value of the respcode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRespcode(String value) {
        this.respcode = value;
    }

    /**
     * Gets the value of the respmsg property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRespmsg() {
        return respmsg;
    }

    /**
     * Sets the value of the respmsg property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRespmsg(String value) {
        this.respmsg = value;
    }

    /**
     * Gets the value of the response property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResponse() {
        return response;
    }

    /**
     * Sets the value of the response property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResponse(String value) {
        this.response = value;
    }

    /**
     * Gets the value of the serialno property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSerialno() {
        return serialno;
    }

    /**
     * Sets the value of the serialno property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSerialno(String value) {
        this.serialno = value;
    }

    /**
     * Gets the value of the transchannel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTranschannel() {
        return transchannel;
    }

    /**
     * Sets the value of the transchannel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTranschannel(String value) {
        this.transchannel = value;
    }

    /**
     * Gets the value of the transtime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTranstime() {
        return transtime;
    }

    /**
     * Sets the value of the transtime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTranstime(String value) {
        this.transtime = value;
    }

    /**
     * Gets the value of the transtype property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTranstype() {
        return transtype;
    }

    /**
     * Sets the value of the transtype property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTranstype(String value) {
        this.transtype = value;
    }

}
