
package com.htichina.wsclient.payment;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>selectPoiSendHistoryResponse complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="selectPoiSendHistoryResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="return" type="{http://payment.ws.htichina.com/}poiSendHistory" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "selectPoiSendHistoryResponse", propOrder = {
    "_return"
})
public class SelectPoiSendHistoryResponse {

    @XmlElement(name = "return")
    protected PoiSendHistory _return;

    /**
     * 获取return属性的值。
     * 
     * @return
     *     possible object is
     *     {@link PoiSendHistory }
     *     
     */
    public PoiSendHistory getReturn() {
        return _return;
    }

    /**
     * 设置return属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link PoiSendHistory }
     *     
     */
    public void setReturn(PoiSendHistory value) {
        this._return = value;
    }

}
