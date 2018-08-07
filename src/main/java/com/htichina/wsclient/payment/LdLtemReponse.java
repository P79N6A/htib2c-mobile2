
package com.htichina.wsclient.payment;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>ldLtemReponse complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="ldLtemReponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="allAmount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="basePrizeSize" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ldItem" type="{http://payment.ws.htichina.com/}ldItem" minOccurs="0"/>
 *         &lt;element name="leftAmount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="otherPrizeSize" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="prizeList" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="wifiPrizeSize" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ldLtemReponse", propOrder = {
    "allAmount",
    "basePrizeSize",
    "ldItem",
    "leftAmount",
    "otherPrizeSize",
    "prizeList",
    "wifiPrizeSize"
})
public class LdLtemReponse {

    protected int allAmount;
    protected int basePrizeSize;
    protected LdItem ldItem;
    protected int leftAmount;
    protected int otherPrizeSize;
    @XmlElement(nillable = true)
    protected List<String> prizeList;
    protected int wifiPrizeSize;

    /**
     * 获取allAmount属性的值。
     * 
     */
    public int getAllAmount() {
        return allAmount;
    }

    /**
     * 设置allAmount属性的值。
     * 
     */
    public void setAllAmount(int value) {
        this.allAmount = value;
    }

    /**
     * 获取basePrizeSize属性的值。
     * 
     */
    public int getBasePrizeSize() {
        return basePrizeSize;
    }

    /**
     * 设置basePrizeSize属性的值。
     * 
     */
    public void setBasePrizeSize(int value) {
        this.basePrizeSize = value;
    }

    /**
     * 获取ldItem属性的值。
     * 
     * @return
     *     possible object is
     *     {@link LdItem }
     *     
     */
    public LdItem getLdItem() {
        return ldItem;
    }

    /**
     * 设置ldItem属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link LdItem }
     *     
     */
    public void setLdItem(LdItem value) {
        this.ldItem = value;
    }

    /**
     * 获取leftAmount属性的值。
     * 
     */
    public int getLeftAmount() {
        return leftAmount;
    }

    /**
     * 设置leftAmount属性的值。
     * 
     */
    public void setLeftAmount(int value) {
        this.leftAmount = value;
    }

    /**
     * 获取otherPrizeSize属性的值。
     * 
     */
    public int getOtherPrizeSize() {
        return otherPrizeSize;
    }

    /**
     * 设置otherPrizeSize属性的值。
     * 
     */
    public void setOtherPrizeSize(int value) {
        this.otherPrizeSize = value;
    }

    /**
     * Gets the value of the prizeList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the prizeList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPrizeList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getPrizeList() {
        if (prizeList == null) {
            prizeList = new ArrayList<String>();
        }
        return this.prizeList;
    }

    /**
     * 获取wifiPrizeSize属性的值。
     * 
     */
    public int getWifiPrizeSize() {
        return wifiPrizeSize;
    }

    /**
     * 设置wifiPrizeSize属性的值。
     * 
     */
    public void setWifiPrizeSize(int value) {
        this.wifiPrizeSize = value;
    }

}
