
package com.htichina.wsclient.payment;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for updateOrderStatus complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="updateOrderStatus">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="orderNum" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tranNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="openIds" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "updateOrderStatus", propOrder = {
    "orderNum",
    "tranNo",
    "openIds"
})
public class UpdateOrderStatus {

    protected String orderNum;
    protected String tranNo;
    protected String openIds;

    /**
     * Gets the value of the orderNum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrderNum() {
        return orderNum;
    }

    /**
     * Sets the value of the orderNum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrderNum(String value) {
        this.orderNum = value;
    }

    /**
     * Gets the value of the tranNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTranNo() {
        return tranNo;
    }

    /**
     * Sets the value of the tranNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTranNo(String value) {
        this.tranNo = value;
    }

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

}
