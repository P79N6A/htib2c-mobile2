
package com.htichina.wsclient.payment;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>accountInfoResponse complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
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
     * ��ȡaccountNum���Ե�ֵ��
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
     * ����accountNum���Ե�ֵ��
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
     * ��ȡaccountStatus���Ե�ֵ��
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
     * ����accountStatus���Ե�ֵ��
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
     * ��ȡaccountType���Ե�ֵ��
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
     * ����accountType���Ե�ֵ��
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
     * ��ȡfullName���Ե�ֵ��
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
     * ����fullName���Ե�ֵ��
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
     * ��ȡisReceiveDidiForFirstLogin���Ե�ֵ��
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
     * ����isReceiveDidiForFirstLogin���Ե�ֵ��
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
     * ��ȡisReceiveDidiForRenew���Ե�ֵ��
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
     * ����isReceiveDidiForRenew���Ե�ֵ��
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
     * ��ȡmileageResponse���Ե�ֵ��
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
     * ����mileageResponse���Ե�ֵ��
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
     * ��ȡmobilePhone���Ե�ֵ��
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
     * ����mobilePhone���Ե�ֵ��
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
     * ��ȡvin���Ե�ֵ��
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
     * ����vin���Ե�ֵ��
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
