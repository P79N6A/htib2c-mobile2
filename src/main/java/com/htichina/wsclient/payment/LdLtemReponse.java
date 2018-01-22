
package com.htichina.wsclient.payment;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ldLtemReponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
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
    "wifiPrizeSize"
})
public class LdLtemReponse {

    protected int allAmount;
    protected int basePrizeSize;
    protected LdItem ldItem;
    protected int leftAmount;
    protected int otherPrizeSize;
    protected int wifiPrizeSize;

    /**
     * Gets the value of the allAmount property.
     * 
     */
    public int getAllAmount() {
        return allAmount;
    }

    /**
     * Sets the value of the allAmount property.
     * 
     */
    public void setAllAmount(int value) {
        this.allAmount = value;
    }

    /**
     * Gets the value of the basePrizeSize property.
     * 
     */
    public int getBasePrizeSize() {
        return basePrizeSize;
    }

    /**
     * Sets the value of the basePrizeSize property.
     * 
     */
    public void setBasePrizeSize(int value) {
        this.basePrizeSize = value;
    }

    /**
     * Gets the value of the ldItem property.
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
     * Sets the value of the ldItem property.
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
     * Gets the value of the leftAmount property.
     * 
     */
    public int getLeftAmount() {
        return leftAmount;
    }

    /**
     * Sets the value of the leftAmount property.
     * 
     */
    public void setLeftAmount(int value) {
        this.leftAmount = value;
    }

    /**
     * Gets the value of the otherPrizeSize property.
     * 
     */
    public int getOtherPrizeSize() {
        return otherPrizeSize;
    }

    /**
     * Sets the value of the otherPrizeSize property.
     * 
     */
    public void setOtherPrizeSize(int value) {
        this.otherPrizeSize = value;
    }

    /**
     * Gets the value of the wifiPrizeSize property.
     * 
     */
    public int getWifiPrizeSize() {
        return wifiPrizeSize;
    }

    /**
     * Sets the value of the wifiPrizeSize property.
     * 
     */
    public void setWifiPrizeSize(int value) {
        this.wifiPrizeSize = value;
    }

}
