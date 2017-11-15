
package com.htichina.wsclient.payment;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for promotionInfoResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="promotionInfoResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="productCategoryId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="productCategoryList" type="{http://payment.ws.htichina.com/}promotionCategoryResult" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="productCategoryName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "promotionInfoResponse", propOrder = {
    "productCategoryId",
    "productCategoryList",
    "productCategoryName"
})
public class PromotionInfoResponse {

    protected String productCategoryId;
    @XmlElement(nillable = true)
    protected List<PromotionCategoryResult> productCategoryList;
    protected String productCategoryName;

    /**
     * Gets the value of the productCategoryId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProductCategoryId() {
        return productCategoryId;
    }

    /**
     * Sets the value of the productCategoryId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProductCategoryId(String value) {
        this.productCategoryId = value;
    }

    /**
     * Gets the value of the productCategoryList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the productCategoryList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProductCategoryList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PromotionCategoryResult }
     * 
     * 
     */
    public List<PromotionCategoryResult> getProductCategoryList() {
        if (productCategoryList == null) {
            productCategoryList = new ArrayList<PromotionCategoryResult>();
        }
        return this.productCategoryList;
    }

    /**
     * Gets the value of the productCategoryName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProductCategoryName() {
        return productCategoryName;
    }

    /**
     * Sets the value of the productCategoryName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProductCategoryName(String value) {
        this.productCategoryName = value;
    }

}
