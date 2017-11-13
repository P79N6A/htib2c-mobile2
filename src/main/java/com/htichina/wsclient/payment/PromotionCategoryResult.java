
package com.htichina.wsclient.payment;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for promotionCategoryResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="promotionCategoryResult">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="promotionCategoryList" type="{http://payment.ws.htichina.com/}promotionInfoWS" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="promotionCategoryName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "promotionCategoryResult", propOrder = {
    "promotionCategoryList",
    "promotionCategoryName"
})
public class PromotionCategoryResult {

    @XmlElement(nillable = true)
    protected List<PromotionInfoWS> promotionCategoryList;
    protected String promotionCategoryName;

    /**
     * Gets the value of the promotionCategoryList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the promotionCategoryList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPromotionCategoryList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PromotionInfoWS }
     * 
     * 
     */
    public List<PromotionInfoWS> getPromotionCategoryList() {
        if (promotionCategoryList == null) {
            promotionCategoryList = new ArrayList<PromotionInfoWS>();
        }
        return this.promotionCategoryList;
    }

    /**
     * Gets the value of the promotionCategoryName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPromotionCategoryName() {
        return promotionCategoryName;
    }

    /**
     * Sets the value of the promotionCategoryName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPromotionCategoryName(String value) {
        this.promotionCategoryName = value;
    }

}
