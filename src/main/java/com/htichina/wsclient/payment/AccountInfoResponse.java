
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
 *         &lt;element name="fullName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="isReceiveDidiForFirstLogin" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="isReceiveDidiForRenew" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="mobilePhone" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "fullName",
    "isReceiveDidiForFirstLogin",
    "isReceiveDidiForRenew",
    "mobilePhone",
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
    protected String fullName;
    protected String isReceiveDidiForFirstLogin;
    protected String isReceiveDidiForRenew;
    protected String mobilePhone;
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
