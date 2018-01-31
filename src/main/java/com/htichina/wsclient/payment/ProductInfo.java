
package com.htichina.wsclient.payment;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>productInfo complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="productInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="duration" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="price" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="prodDesc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="prodId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="prodName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="prodShortName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="promotionPrice" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="promotionRule" type="{http://payment.ws.htichina.com/}promotionRule" minOccurs="0"/>
 *         &lt;element name="vol" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "productInfo", propOrder = {
    "duration",
    "price",
    "prodDesc",
    "prodId",
    "prodName",
    "prodShortName",
    "promotionPrice",
    "promotionRule",
    "vol"
})
public class ProductInfo {

    protected int duration;
    protected double price;
    protected String prodDesc;
    protected int prodId;
    protected String prodName;
    protected String prodShortName;
    protected double promotionPrice;
    protected PromotionRule promotionRule;
    protected double vol;

    /**
     * 获取duration属性的值。
     * 
     */
    public int getDuration() {
        return duration;
    }

    /**
     * 设置duration属性的值。
     * 
     */
    public void setDuration(int value) {
        this.duration = value;
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
     * 获取prodDesc属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProdDesc() {
        return prodDesc;
    }

    /**
     * 设置prodDesc属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProdDesc(String value) {
        this.prodDesc = value;
    }

    /**
     * 获取prodId属性的值。
     * 
     */
    public int getProdId() {
        return prodId;
    }

    /**
     * 设置prodId属性的值。
     * 
     */
    public void setProdId(int value) {
        this.prodId = value;
    }

    /**
     * 获取prodName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProdName() {
        return prodName;
    }

    /**
     * 设置prodName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProdName(String value) {
        this.prodName = value;
    }

    /**
     * 获取prodShortName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProdShortName() {
        return prodShortName;
    }

    /**
     * 设置prodShortName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProdShortName(String value) {
        this.prodShortName = value;
    }

    /**
     * 获取promotionPrice属性的值。
     * 
     */
    public double getPromotionPrice() {
        return promotionPrice;
    }

    /**
     * 设置promotionPrice属性的值。
     * 
     */
    public void setPromotionPrice(double value) {
        this.promotionPrice = value;
    }

    /**
     * 获取promotionRule属性的值。
     * 
     * @return
     *     possible object is
     *     {@link PromotionRule }
     *     
     */
    public PromotionRule getPromotionRule() {
        return promotionRule;
    }

    /**
     * 设置promotionRule属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link PromotionRule }
     *     
     */
    public void setPromotionRule(PromotionRule value) {
        this.promotionRule = value;
    }

    /**
     * 获取vol属性的值。
     * 
     */
    public double getVol() {
        return vol;
    }

    /**
     * 设置vol属性的值。
     * 
     */
    public void setVol(double value) {
        this.vol = value;
    }

}
