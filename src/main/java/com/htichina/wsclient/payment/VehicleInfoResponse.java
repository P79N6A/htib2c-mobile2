
package com.htichina.wsclient.payment;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>vehicleInfoResponse complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="vehicleInfoResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="acctNum" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="base_sevice_status" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="cellphone" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="color" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="model" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="vin" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="wifi_flag" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "vehicleInfoResponse", propOrder = {
    "acctNum",
    "baseSeviceStatus",
    "cellphone",
    "color",
    "model",
    "name",
    "vin",
    "wifiFlag"
})
public class VehicleInfoResponse {

    protected int acctNum;
    @XmlElement(name = "base_sevice_status")
    protected int baseSeviceStatus;
    protected String cellphone;
    protected String color;
    protected String model;
    protected String name;
    protected String vin;
    @XmlElement(name = "wifi_flag")
    protected int wifiFlag;

    /**
     * 获取acctNum属性的值。
     * 
     */
    public int getAcctNum() {
        return acctNum;
    }

    /**
     * 设置acctNum属性的值。
     * 
     */
    public void setAcctNum(int value) {
        this.acctNum = value;
    }

    /**
     * 获取baseSeviceStatus属性的值。
     * 
     */
    public int getBaseSeviceStatus() {
        return baseSeviceStatus;
    }

    /**
     * 设置baseSeviceStatus属性的值。
     * 
     */
    public void setBaseSeviceStatus(int value) {
        this.baseSeviceStatus = value;
    }

    /**
     * 获取cellphone属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCellphone() {
        return cellphone;
    }

    /**
     * 设置cellphone属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCellphone(String value) {
        this.cellphone = value;
    }

    /**
     * 获取color属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getColor() {
        return color;
    }

    /**
     * 设置color属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setColor(String value) {
        this.color = value;
    }

    /**
     * 获取model属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getModel() {
        return model;
    }

    /**
     * 设置model属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setModel(String value) {
        this.model = value;
    }

    /**
     * 获取name属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * 设置name属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
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

    /**
     * 获取wifiFlag属性的值。
     * 
     */
    public int getWifiFlag() {
        return wifiFlag;
    }

    /**
     * 设置wifiFlag属性的值。
     * 
     */
    public void setWifiFlag(int value) {
        this.wifiFlag = value;
    }

}
