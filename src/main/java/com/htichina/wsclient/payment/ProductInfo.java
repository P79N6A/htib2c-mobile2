
package com.htichina.wsclient.payment;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>productInfo complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
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
     * ��ȡduration���Ե�ֵ��
     * 
     */
    public int getDuration() {
        return duration;
    }

    /**
     * ����duration���Ե�ֵ��
     * 
     */
    public void setDuration(int value) {
        this.duration = value;
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
     * ��ȡprodDesc���Ե�ֵ��
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
     * ����prodDesc���Ե�ֵ��
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
     * ��ȡprodId���Ե�ֵ��
     * 
     */
    public int getProdId() {
        return prodId;
    }

    /**
     * ����prodId���Ե�ֵ��
     * 
     */
    public void setProdId(int value) {
        this.prodId = value;
    }

    /**
     * ��ȡprodName���Ե�ֵ��
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
     * ����prodName���Ե�ֵ��
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
     * ��ȡprodShortName���Ե�ֵ��
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
     * ����prodShortName���Ե�ֵ��
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
     * ��ȡpromotionPrice���Ե�ֵ��
     * 
     */
    public double getPromotionPrice() {
        return promotionPrice;
    }

    /**
     * ����promotionPrice���Ե�ֵ��
     * 
     */
    public void setPromotionPrice(double value) {
        this.promotionPrice = value;
    }

    /**
     * ��ȡpromotionRule���Ե�ֵ��
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
     * ����promotionRule���Ե�ֵ��
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
     * ��ȡvol���Ե�ֵ��
     * 
     */
    public double getVol() {
        return vol;
    }

    /**
     * ����vol���Ե�ֵ��
     * 
     */
    public void setVol(double value) {
        this.vol = value;
    }

}
