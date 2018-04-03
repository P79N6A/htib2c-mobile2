
package com.htichina.wsclient.payment;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>paymentHandlerService complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="paymentHandlerService">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="transNum" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="payresult" type="{http://payment.ws.htichina.com/}paymentResultMessage" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "paymentHandlerService", propOrder = {
    "transNum",
    "payresult"
})
public class PaymentHandlerService {

    protected String transNum;
    protected PaymentResultMessage payresult;

    /**
     * 获取transNum属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransNum() {
        return transNum;
    }

    /**
     * 设置transNum属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransNum(String value) {
        this.transNum = value;
    }

    /**
     * 获取payresult属性的值。
     * 
     * @return
     *     possible object is
     *     {@link PaymentResultMessage }
     *     
     */
    public PaymentResultMessage getPayresult() {
        return payresult;
    }

    /**
     * 设置payresult属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentResultMessage }
     *     
     */
    public void setPayresult(PaymentResultMessage value) {
        this.payresult = value;
    }

}
