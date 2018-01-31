
package com.htichina.wsclient.payment;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>productInfoResponse complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="productInfoResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="baseProductDurationSet" type="{http://www.w3.org/2001/XMLSchema}int" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="baseProductList" type="{http://payment.ws.htichina.com/}productInfo" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="baseProductShortNameSet" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="earlybirdProductList" type="{http://payment.ws.htichina.com/}productInfo" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="wifiProductDurationSet" type="{http://www.w3.org/2001/XMLSchema}int" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="wifiProductList" type="{http://payment.ws.htichina.com/}productInfo" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="wifiProductShortNameSet" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="winbackProductList" type="{http://payment.ws.htichina.com/}productInfo" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "productInfoResponse", propOrder = {
    "baseProductDurationSet",
    "baseProductList",
    "baseProductShortNameSet",
    "earlybirdProductList",
    "wifiProductDurationSet",
    "wifiProductList",
    "wifiProductShortNameSet",
    "winbackProductList"
})
public class ProductInfoResponse {

    @XmlElement(nillable = true)
    protected List<Integer> baseProductDurationSet;
    @XmlElement(nillable = true)
    protected List<ProductInfo> baseProductList;
    @XmlElement(nillable = true)
    protected List<String> baseProductShortNameSet;
    @XmlElement(nillable = true)
    protected List<ProductInfo> earlybirdProductList;
    @XmlElement(nillable = true)
    protected List<Integer> wifiProductDurationSet;
    @XmlElement(nillable = true)
    protected List<ProductInfo> wifiProductList;
    @XmlElement(nillable = true)
    protected List<String> wifiProductShortNameSet;
    @XmlElement(nillable = true)
    protected List<ProductInfo> winbackProductList;

    /**
     * Gets the value of the baseProductDurationSet property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the baseProductDurationSet property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBaseProductDurationSet().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Integer }
     * 
     * 
     */
    public List<Integer> getBaseProductDurationSet() {
        if (baseProductDurationSet == null) {
            baseProductDurationSet = new ArrayList<Integer>();
        }
        return this.baseProductDurationSet;
    }

    /**
     * Gets the value of the baseProductList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the baseProductList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBaseProductList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ProductInfo }
     * 
     * 
     */
    public List<ProductInfo> getBaseProductList() {
        if (baseProductList == null) {
            baseProductList = new ArrayList<ProductInfo>();
        }
        return this.baseProductList;
    }

    /**
     * Gets the value of the baseProductShortNameSet property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the baseProductShortNameSet property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBaseProductShortNameSet().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getBaseProductShortNameSet() {
        if (baseProductShortNameSet == null) {
            baseProductShortNameSet = new ArrayList<String>();
        }
        return this.baseProductShortNameSet;
    }

    /**
     * Gets the value of the earlybirdProductList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the earlybirdProductList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEarlybirdProductList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ProductInfo }
     * 
     * 
     */
    public List<ProductInfo> getEarlybirdProductList() {
        if (earlybirdProductList == null) {
            earlybirdProductList = new ArrayList<ProductInfo>();
        }
        return this.earlybirdProductList;
    }

    /**
     * Gets the value of the wifiProductDurationSet property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the wifiProductDurationSet property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getWifiProductDurationSet().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Integer }
     * 
     * 
     */
    public List<Integer> getWifiProductDurationSet() {
        if (wifiProductDurationSet == null) {
            wifiProductDurationSet = new ArrayList<Integer>();
        }
        return this.wifiProductDurationSet;
    }

    /**
     * Gets the value of the wifiProductList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the wifiProductList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getWifiProductList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ProductInfo }
     * 
     * 
     */
    public List<ProductInfo> getWifiProductList() {
        if (wifiProductList == null) {
            wifiProductList = new ArrayList<ProductInfo>();
        }
        return this.wifiProductList;
    }

    /**
     * Gets the value of the wifiProductShortNameSet property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the wifiProductShortNameSet property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getWifiProductShortNameSet().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getWifiProductShortNameSet() {
        if (wifiProductShortNameSet == null) {
            wifiProductShortNameSet = new ArrayList<String>();
        }
        return this.wifiProductShortNameSet;
    }

    /**
     * Gets the value of the winbackProductList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the winbackProductList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getWinbackProductList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ProductInfo }
     * 
     * 
     */
    public List<ProductInfo> getWinbackProductList() {
        if (winbackProductList == null) {
            winbackProductList = new ArrayList<ProductInfo>();
        }
        return this.winbackProductList;
    }

}
