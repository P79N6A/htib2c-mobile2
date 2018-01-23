
package com.htichina.wsclient.payment;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for updateWechatMessageHistory complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="updateWechatMessageHistory">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="openIds" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="transactionNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "updateWechatMessageHistory", propOrder = {
    "openIds",
    "transactionNo"
})
public class UpdateWechatMessageHistory {

    protected String openIds;
    protected String transactionNo;

    /**
     * Gets the value of the openIds property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOpenIds() {
        return openIds;
    }

    /**
     * Sets the value of the openIds property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOpenIds(String value) {
        this.openIds = value;
    }

    /**
     * Gets the value of the transactionNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransactionNo() {
        return transactionNo;
    }

    /**
     * Sets the value of the transactionNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransactionNo(String value) {
        this.transactionNo = value;
    }

}
