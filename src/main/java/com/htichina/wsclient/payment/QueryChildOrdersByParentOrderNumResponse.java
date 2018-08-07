
package com.htichina.wsclient.payment;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>queryChildOrdersByParentOrderNumResponse complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="queryChildOrdersByParentOrderNumResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="market_name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="price" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="quanti" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="short_market_name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="start_dt" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
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
@XmlType(name = "queryChildOrdersByParentOrderNumResponse", propOrder = {
    "marketName",
    "price",
    "quanti",
    "shortMarketName",
    "startDt",
    "vin"
})
public class QueryChildOrdersByParentOrderNumResponse {

    @XmlElement(name = "market_name")
    protected String marketName;
    protected double price;
    protected int quanti;
    @XmlElement(name = "short_market_name")
    protected String shortMarketName;
    @XmlElement(name = "start_dt")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar startDt;
    protected String vin;

    /**
     * 获取marketName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMarketName() {
        return marketName;
    }

    /**
     * 设置marketName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMarketName(String value) {
        this.marketName = value;
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
     * 获取shortMarketName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShortMarketName() {
        return shortMarketName;
    }

    /**
     * 设置shortMarketName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShortMarketName(String value) {
        this.shortMarketName = value;
    }

    /**
     * 获取startDt属性的值。
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getStartDt() {
        return startDt;
    }

    /**
     * 设置startDt属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setStartDt(XMLGregorianCalendar value) {
        this.startDt = value;
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
