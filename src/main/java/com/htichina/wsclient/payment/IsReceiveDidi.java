
package com.htichina.wsclient.payment;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for isReceiveDidi complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="isReceiveDidi">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="accountKey" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="didiType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "isReceiveDidi", propOrder = {
    "accountKey",
    "didiType"
})
public class IsReceiveDidi {

    protected String accountKey;
    protected String didiType;

    /**
     * Gets the value of the accountKey property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccountKey() {
        return accountKey;
    }

    /**
     * Sets the value of the accountKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccountKey(String value) {
        this.accountKey = value;
    }

    /**
     * Gets the value of the didiType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDidiType() {
        return didiType;
    }

    /**
     * Sets the value of the didiType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDidiType(String value) {
        this.didiType = value;
    }

}
