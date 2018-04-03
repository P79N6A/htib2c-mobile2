
package com.htichina.wsclient.payment;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>ldLtemReponse complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
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
     * ��ȡallAmount���Ե�ֵ��
     * 
     */
    public int getAllAmount() {
        return allAmount;
    }

    /**
     * ����allAmount���Ե�ֵ��
     * 
     */
    public void setAllAmount(int value) {
        this.allAmount = value;
    }

    /**
     * ��ȡbasePrizeSize���Ե�ֵ��
     * 
     */
    public int getBasePrizeSize() {
        return basePrizeSize;
    }

    /**
     * ����basePrizeSize���Ե�ֵ��
     * 
     */
    public void setBasePrizeSize(int value) {
        this.basePrizeSize = value;
    }

    /**
     * ��ȡldItem���Ե�ֵ��
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
     * ����ldItem���Ե�ֵ��
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
     * ��ȡleftAmount���Ե�ֵ��
     * 
     */
    public int getLeftAmount() {
        return leftAmount;
    }

    /**
     * ����leftAmount���Ե�ֵ��
     * 
     */
    public void setLeftAmount(int value) {
        this.leftAmount = value;
    }

    /**
     * ��ȡotherPrizeSize���Ե�ֵ��
     * 
     */
    public int getOtherPrizeSize() {
        return otherPrizeSize;
    }

    /**
     * ����otherPrizeSize���Ե�ֵ��
     * 
     */
    public void setOtherPrizeSize(int value) {
        this.otherPrizeSize = value;
    }

    /**
     * ��ȡwifiPrizeSize���Ե�ֵ��
     * 
     */
    public int getWifiPrizeSize() {
        return wifiPrizeSize;
    }

    /**
     * ����wifiPrizeSize���Ե�ֵ��
     * 
     */
    public void setWifiPrizeSize(int value) {
        this.wifiPrizeSize = value;
    }

}
