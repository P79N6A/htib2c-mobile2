
package com.htichina.wsclient.payment;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>insertHistory complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="insertHistory">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="couPonHistory" type="{http://payment.ws.htichina.com/}couponHistory" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "insertHistory", propOrder = {
    "couPonHistory"
})
public class InsertHistory {

    protected CouponHistory couPonHistory;

    /**
     * 获取couPonHistory属性的值。
     * 
     * @return
     *     possible object is
     *     {@link CouponHistory }
     *     
     */
    public CouponHistory getCouPonHistory() {
        return couPonHistory;
    }

    /**
     * 设置couPonHistory属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CouponHistory }
     *     
     */
    public void setCouPonHistory(CouponHistory value) {
        this.couPonHistory = value;
    }

}
