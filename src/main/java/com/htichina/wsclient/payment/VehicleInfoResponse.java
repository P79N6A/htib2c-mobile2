
package com.htichina.wsclient.payment;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>vehicleInfoResponse complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
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
     * ��ȡacctNum���Ե�ֵ��
     * 
     */
    public int getAcctNum() {
        return acctNum;
    }

    /**
     * ����acctNum���Ե�ֵ��
     * 
     */
    public void setAcctNum(int value) {
        this.acctNum = value;
    }

    /**
     * ��ȡbaseSeviceStatus���Ե�ֵ��
     * 
     */
    public int getBaseSeviceStatus() {
        return baseSeviceStatus;
    }

    /**
     * ����baseSeviceStatus���Ե�ֵ��
     * 
     */
    public void setBaseSeviceStatus(int value) {
        this.baseSeviceStatus = value;
    }

    /**
     * ��ȡcellphone���Ե�ֵ��
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
     * ����cellphone���Ե�ֵ��
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
     * ��ȡcolor���Ե�ֵ��
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
     * ����color���Ե�ֵ��
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
     * ��ȡmodel���Ե�ֵ��
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
     * ����model���Ե�ֵ��
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
     * ��ȡname���Ե�ֵ��
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
     * ����name���Ե�ֵ��
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

    /**
     * ��ȡwifiFlag���Ե�ֵ��
     * 
     */
    public int getWifiFlag() {
        return wifiFlag;
    }

    /**
     * ����wifiFlag���Ե�ֵ��
     * 
     */
    public void setWifiFlag(int value) {
        this.wifiFlag = value;
    }

}
