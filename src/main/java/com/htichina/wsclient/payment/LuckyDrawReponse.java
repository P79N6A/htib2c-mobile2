
package com.htichina.wsclient.payment;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>luckyDrawReponse complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="luckyDrawReponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="allAmount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="dataMessage" type="{http://payment.ws.htichina.com/}luckyDrawData" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="leftAmount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="luckyDrawFlag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="prizeList" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "luckyDrawReponse", propOrder = {
    "allAmount",
    "dataMessage",
    "leftAmount",
    "luckyDrawFlag",
    "prizeList"
})
public class LuckyDrawReponse {

    protected int allAmount;
    @XmlElement(nillable = true)
    protected List<LuckyDrawData> dataMessage;
    protected int leftAmount;
    protected String luckyDrawFlag;
    @XmlElement(nillable = true)
    protected List<String> prizeList;

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
     * Gets the value of the dataMessage property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dataMessage property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDataMessage().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LuckyDrawData }
     * 
     * 
     */
    public List<LuckyDrawData> getDataMessage() {
        if (dataMessage == null) {
            dataMessage = new ArrayList<LuckyDrawData>();
        }
        return this.dataMessage;
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
     * 获取luckyDrawFlag属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLuckyDrawFlag() {
        return luckyDrawFlag;
    }

    /**
     * 设置luckyDrawFlag属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLuckyDrawFlag(String value) {
        this.luckyDrawFlag = value;
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

}
