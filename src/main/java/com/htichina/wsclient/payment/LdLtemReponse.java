
package com.htichina.wsclient.payment;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
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
