
package com.htichina.wsclient.payment;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>packageInfoResponse complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="packageInfoResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="balance" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="base" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="canBeUpgrated" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="endDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="packageName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="packageStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="startDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="subscriptionName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="webSubscriptionId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "packageInfoResponse", propOrder = {
    "balance",
    "base",
    "canBeUpgrated",
    "endDate",
    "packageName",
    "packageStatus",
    "startDate",
    "subscriptionName",
    "webSubscriptionId"
})
public class PackageInfoResponse {

    protected double balance;
    protected boolean base;
    protected boolean canBeUpgrated;
    protected String endDate;
    protected String packageName;
    protected String packageStatus;
    protected String startDate;
    protected String subscriptionName;
    protected String webSubscriptionId;

    /**
     * ��ȡbalance���Ե�ֵ��
     * 
     */
    public double getBalance() {
        return balance;
    }

    /**
     * ����balance���Ե�ֵ��
     * 
     */
    public void setBalance(double value) {
        this.balance = value;
    }

    /**
     * ��ȡbase���Ե�ֵ��
     * 
     */
    public boolean isBase() {
        return base;
    }

    /**
     * ����base���Ե�ֵ��
     * 
     */
    public void setBase(boolean value) {
        this.base = value;
    }

    /**
     * ��ȡcanBeUpgrated���Ե�ֵ��
     * 
     */
    public boolean isCanBeUpgrated() {
        return canBeUpgrated;
    }

    /**
     * ����canBeUpgrated���Ե�ֵ��
     * 
     */
    public void setCanBeUpgrated(boolean value) {
        this.canBeUpgrated = value;
    }

    /**
     * ��ȡendDate���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEndDate() {
        return endDate;
    }

    /**
     * ����endDate���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEndDate(String value) {
        this.endDate = value;
    }

    /**
     * ��ȡpackageName���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPackageName() {
        return packageName;
    }

    /**
     * ����packageName���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPackageName(String value) {
        this.packageName = value;
    }

    /**
     * ��ȡpackageStatus���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPackageStatus() {
        return packageStatus;
    }

    /**
     * ����packageStatus���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPackageStatus(String value) {
        this.packageStatus = value;
    }

    /**
     * ��ȡstartDate���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStartDate() {
        return startDate;
    }

    /**
     * ����startDate���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStartDate(String value) {
        this.startDate = value;
    }

    /**
     * ��ȡsubscriptionName���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubscriptionName() {
        return subscriptionName;
    }

    /**
     * ����subscriptionName���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubscriptionName(String value) {
        this.subscriptionName = value;
    }

    /**
     * ��ȡwebSubscriptionId���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWebSubscriptionId() {
        return webSubscriptionId;
    }

    /**
     * ����webSubscriptionId���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWebSubscriptionId(String value) {
        this.webSubscriptionId = value;
    }

}
