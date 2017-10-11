
package com.htichina.wsclient.payment;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for productInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
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
     * Gets the value of the duration property.
     * 
     */
    public int getDuration() {
        return duration;
    }

    /**
     * Sets the value of the duration property.
     * 
     */
    public void setDuration(int value) {
        this.duration = value;
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
     * Gets the value of the prodDesc property.
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
     * Sets the value of the prodDesc property.
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
     * Gets the value of the prodId property.
     * 
     */
    public int getProdId() {
        return prodId;
    }

    /**
     * Sets the value of the prodId property.
     * 
     */
    public void setProdId(int value) {
        this.prodId = value;
    }

    /**
     * Gets the value of the prodName property.
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
     * Sets the value of the prodName property.
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
     * Gets the value of the prodShortName property.
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
     * Sets the value of the prodShortName property.
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
     * Gets the value of the promotionPrice property.
     * 
     */
    public double getPromotionPrice() {
        return promotionPrice;
    }

    /**
     * Sets the value of the promotionPrice property.
     * 
     */
    public void setPromotionPrice(double value) {
        this.promotionPrice = value;
    }

    /**
     * Gets the value of the promotionRule property.
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
     * Sets the value of the promotionRule property.
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
     * Gets the value of the vol property.
     * 
     */
    public double getVol() {
        return vol;
    }

    /**
     * Sets the value of the vol property.
     * 
     */
    public void setVol(double value) {
        this.vol = value;
    }

}
