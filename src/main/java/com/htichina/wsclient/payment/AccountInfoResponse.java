
package com.htichina.wsclient.payment;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>accountInfoResponse complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="accountInfoResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="accountNum" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="accountStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="accountType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="currentCanBeUpgratedPackages" type="{http://payment.ws.htichina.com/}packageInfoResponse" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="currentPackages" type="{http://payment.ws.htichina.com/}packageInfoResponse" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="expiredCoupons" type="{http://payment.ws.htichina.com/}coupon" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="fullName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="isReceiveDidiForFirstLogin" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="isReceiveDidiForRenew" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="mileageResponse" type="{http://payment.ws.htichina.com/}mileageResponse" minOccurs="0"/>
 *         &lt;element name="mobilePhone" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="unUsedCoupons" type="{http://payment.ws.htichina.com/}coupon" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="usedCoupons" type="{http://payment.ws.htichina.com/}coupon" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="vin" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "accountInfoResponse", propOrder = {
    "accountNum",
    "accountStatus",
    "accountType",
    "currentCanBeUpgratedPackages",
    "currentPackages",
    "expiredCoupons",
    "fullName",
    "isReceiveDidiForFirstLogin",
    "isReceiveDidiForRenew",
    "mileageResponse",
    "mobilePhone",
    "unUsedCoupons",
    "usedCoupons",
    "vin"
})
public class AccountInfoResponse {

    protected String accountNum;
    protected String accountStatus;
    protected String accountType;
    @XmlElement(nillable = true)
    protected List<PackageInfoResponse> currentCanBeUpgratedPackages;
    @XmlElement(nillable = true)
    protected List<PackageInfoResponse> currentPackages;
    @XmlElement(nillable = true)
    protected List<Coupon> expiredCoupons;
    protected String fullName;
    protected String isReceiveDidiForFirstLogin;
    protected String isReceiveDidiForRenew;
    protected MileageResponse mileageResponse;
    protected String mobilePhone;
    @XmlElement(nillable = true)
    protected List<Coupon> unUsedCoupons;
    @XmlElement(nillable = true)
    protected List<Coupon> usedCoupons;
    protected String vin;

    /**
     * 获取accountNum属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccountNum() {
        return accountNum;
    }

    /**
     * 设置accountNum属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccountNum(String value) {
        this.accountNum = value;
    }

    /**
     * 获取accountStatus属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccountStatus() {
        return accountStatus;
    }

    /**
     * 设置accountStatus属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccountStatus(String value) {
        this.accountStatus = value;
    }

    /**
     * 获取accountType属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccountType() {
        return accountType;
    }

    /**
     * 设置accountType属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccountType(String value) {
        this.accountType = value;
    }

    /**
     * Gets the value of the currentCanBeUpgratedPackages property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the currentCanBeUpgratedPackages property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCurrentCanBeUpgratedPackages().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PackageInfoResponse }
     * 
     * 
     */
    public List<PackageInfoResponse> getCurrentCanBeUpgratedPackages() {
        if (currentCanBeUpgratedPackages == null) {
            currentCanBeUpgratedPackages = new ArrayList<PackageInfoResponse>();
        }
        return this.currentCanBeUpgratedPackages;
    }

    /**
     * Gets the value of the currentPackages property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the currentPackages property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCurrentPackages().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PackageInfoResponse }
     * 
     * 
     */
    public List<PackageInfoResponse> getCurrentPackages() {
        if (currentPackages == null) {
            currentPackages = new ArrayList<PackageInfoResponse>();
        }
        return this.currentPackages;
    }

    /**
     * Gets the value of the expiredCoupons property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the expiredCoupons property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getExpiredCoupons().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Coupon }
     * 
     * 
     */
    public List<Coupon> getExpiredCoupons() {
        if (expiredCoupons == null) {
            expiredCoupons = new ArrayList<Coupon>();
        }
        return this.expiredCoupons;
    }

    /**
     * 获取fullName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * 设置fullName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFullName(String value) {
        this.fullName = value;
    }

    /**
     * 获取isReceiveDidiForFirstLogin属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsReceiveDidiForFirstLogin() {
        return isReceiveDidiForFirstLogin;
    }

    /**
     * 设置isReceiveDidiForFirstLogin属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsReceiveDidiForFirstLogin(String value) {
        this.isReceiveDidiForFirstLogin = value;
    }

    /**
     * 获取isReceiveDidiForRenew属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsReceiveDidiForRenew() {
        return isReceiveDidiForRenew;
    }

    /**
     * 设置isReceiveDidiForRenew属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsReceiveDidiForRenew(String value) {
        this.isReceiveDidiForRenew = value;
    }

    /**
     * 获取mileageResponse属性的值。
     * 
     * @return
     *     possible object is
     *     {@link MileageResponse }
     *     
     */
    public MileageResponse getMileageResponse() {
        return mileageResponse;
    }

    /**
     * 设置mileageResponse属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link MileageResponse }
     *     
     */
    public void setMileageResponse(MileageResponse value) {
        this.mileageResponse = value;
    }

    /**
     * 获取mobilePhone属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMobilePhone() {
        return mobilePhone;
    }

    /**
     * 设置mobilePhone属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMobilePhone(String value) {
        this.mobilePhone = value;
    }

    /**
     * Gets the value of the unUsedCoupons property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the unUsedCoupons property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUnUsedCoupons().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Coupon }
     * 
     * 
     */
    public List<Coupon> getUnUsedCoupons() {
        if (unUsedCoupons == null) {
            unUsedCoupons = new ArrayList<Coupon>();
        }
        return this.unUsedCoupons;
    }

    /**
     * Gets the value of the usedCoupons property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the usedCoupons property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUsedCoupons().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Coupon }
     * 
     * 
     */
    public List<Coupon> getUsedCoupons() {
        if (usedCoupons == null) {
            usedCoupons = new ArrayList<Coupon>();
        }
        return this.usedCoupons;
    }

    /**
     * 获取vin属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVin() {
        return vin;
    }

    /**
     * 设置vin属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVin(String value) {
        this.vin = value;
    }

}
