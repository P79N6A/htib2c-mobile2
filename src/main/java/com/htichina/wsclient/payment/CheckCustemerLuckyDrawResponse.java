
package com.htichina.wsclient.payment;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>checkCustemerLuckyDrawResponse complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="checkCustemerLuckyDrawResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="return" type="{http://payment.ws.htichina.com/}luckyDrawReponse" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "checkCustemerLuckyDrawResponse", propOrder = {
    "_return"
})
public class CheckCustemerLuckyDrawResponse {

    @XmlElement(name = "return")
    protected LuckyDrawReponse _return;

    /**
     * ��ȡreturn���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link LuckyDrawReponse }
     *     
     */
    public LuckyDrawReponse getReturn() {
        return _return;
    }

    /**
     * ����return���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link LuckyDrawReponse }
     *     
     */
    public void setReturn(LuckyDrawReponse value) {
        this._return = value;
    }

}
