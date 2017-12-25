
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
 *         &lt;element name="success" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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
    "success"
})
public class LuckyDrawReponse {

    protected int allAmount;
    @XmlElement(nillable = true)
    protected List<LuckyDrawData> dataMessage;
    protected int leftAmount;
    protected boolean success;

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
     * 获取success属性的值。
     * 
     */
    public boolean isSuccess() {
        return success;
    }

    /**
     * 设置success属性的值。
     * 
     */
    public void setSuccess(boolean value) {
        this.success = value;
    }

}
