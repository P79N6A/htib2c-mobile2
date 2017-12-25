
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
 *         &lt;element name="leftAmount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="luckyDrawDataList" type="{http://payment.ws.htichina.com/}luckyDrawData" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="prize" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "leftAmount",
    "luckyDrawDataList",
    "prize"
})
public class LdLtemReponse {

    protected int allAmount;
    protected int leftAmount;
    @XmlElement(nillable = true)
    protected List<LuckyDrawData> luckyDrawDataList;
    protected String prize;

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
     * Gets the value of the luckyDrawDataList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the luckyDrawDataList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLuckyDrawDataList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LuckyDrawData }
     * 
     * 
     */
    public List<LuckyDrawData> getLuckyDrawDataList() {
        if (luckyDrawDataList == null) {
            luckyDrawDataList = new ArrayList<LuckyDrawData>();
        }
        return this.luckyDrawDataList;
    }

    /**
     * 获取prize属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrize() {
        return prize;
    }

    /**
     * 设置prize属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrize(String value) {
        this.prize = value;
    }

}
