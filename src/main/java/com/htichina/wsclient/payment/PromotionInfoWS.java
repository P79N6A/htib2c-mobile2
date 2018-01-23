
package com.htichina.wsclient.payment;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for promotionInfoWS complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="promotionInfoWS">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="pkg_id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="promotionPrice" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="promotion_desc1_a" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="promotion_desc1_b" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="promotion_desc2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="promotion_desc3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="promotion_desc4" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="promotion_desc5_a" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="promotion_desc5_b" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="promotion_desc6" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="promotion_theme" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="shortMarketName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "promotionInfoWS", propOrder = {
    "pkgId",
    "promotionPrice",
    "promotionDesc1A",
    "promotionDesc1B",
    "promotionDesc2",
    "promotionDesc3",
    "promotionDesc4",
    "promotionDesc5A",
    "promotionDesc5B",
    "promotionDesc6",
    "promotionTheme",
    "shortMarketName"
})
public class PromotionInfoWS {

    @XmlElement(name = "pkg_id")
    protected String pkgId;
    protected Double promotionPrice;
    @XmlElement(name = "promotion_desc1_a")
    protected String promotionDesc1A;
    @XmlElement(name = "promotion_desc1_b")
    protected String promotionDesc1B;
    @XmlElement(name = "promotion_desc2")
    protected String promotionDesc2;
    @XmlElement(name = "promotion_desc3")
    protected String promotionDesc3;
    @XmlElement(name = "promotion_desc4")
    protected String promotionDesc4;
    @XmlElement(name = "promotion_desc5_a")
    protected String promotionDesc5A;
    @XmlElement(name = "promotion_desc5_b")
    protected String promotionDesc5B;
    @XmlElement(name = "promotion_desc6")
    protected String promotionDesc6;
    @XmlElement(name = "promotion_theme")
    protected String promotionTheme;
    protected String shortMarketName;

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
     * Gets the value of the promotionPrice property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getPromotionPrice() {
        return promotionPrice;
    }

    /**
     * Sets the value of the promotionPrice property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setPromotionPrice(Double value) {
        this.promotionPrice = value;
    }

    /**
     * Gets the value of the promotionDesc1A property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPromotionDesc1A() {
        return promotionDesc1A;
    }

    /**
     * Sets the value of the promotionDesc1A property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPromotionDesc1A(String value) {
        this.promotionDesc1A = value;
    }

    /**
     * Gets the value of the promotionDesc1B property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPromotionDesc1B() {
        return promotionDesc1B;
    }

    /**
     * Sets the value of the promotionDesc1B property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPromotionDesc1B(String value) {
        this.promotionDesc1B = value;
    }

    /**
     * Gets the value of the promotionDesc2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPromotionDesc2() {
        return promotionDesc2;
    }

    /**
     * Sets the value of the promotionDesc2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPromotionDesc2(String value) {
        this.promotionDesc2 = value;
    }

    /**
     * Gets the value of the promotionDesc3 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPromotionDesc3() {
        return promotionDesc3;
    }

    /**
     * Sets the value of the promotionDesc3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPromotionDesc3(String value) {
        this.promotionDesc3 = value;
    }

    /**
     * Gets the value of the promotionDesc4 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPromotionDesc4() {
        return promotionDesc4;
    }

    /**
     * Sets the value of the promotionDesc4 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPromotionDesc4(String value) {
        this.promotionDesc4 = value;
    }

    /**
     * Gets the value of the promotionDesc5A property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPromotionDesc5A() {
        return promotionDesc5A;
    }

    /**
     * Sets the value of the promotionDesc5A property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPromotionDesc5A(String value) {
        this.promotionDesc5A = value;
    }

    /**
     * Gets the value of the promotionDesc5B property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPromotionDesc5B() {
        return promotionDesc5B;
    }

    /**
     * Sets the value of the promotionDesc5B property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPromotionDesc5B(String value) {
        this.promotionDesc5B = value;
    }

    /**
     * Gets the value of the promotionDesc6 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPromotionDesc6() {
        return promotionDesc6;
    }

    /**
     * Sets the value of the promotionDesc6 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPromotionDesc6(String value) {
        this.promotionDesc6 = value;
    }

    /**
     * Gets the value of the promotionTheme property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPromotionTheme() {
        return promotionTheme;
    }

    /**
     * Sets the value of the promotionTheme property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPromotionTheme(String value) {
        this.promotionTheme = value;
    }

    /**
     * Gets the value of the shortMarketName property.
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
     * Sets the value of the shortMarketName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShortMarketName(String value) {
        this.shortMarketName = value;
    }

}
