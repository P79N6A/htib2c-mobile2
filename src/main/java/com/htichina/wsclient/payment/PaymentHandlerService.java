
package com.htichina.wsclient.payment;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for paymentHandlerService complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
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
     * Gets the value of the transNum property.
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
     * Sets the value of the transNum property.
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
     * Gets the value of the payresult property.
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
     * Sets the value of the payresult property.
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
