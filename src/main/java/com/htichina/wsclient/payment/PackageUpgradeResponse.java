
package com.htichina.wsclient.payment;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>packageUpgradeResponse complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="packageUpgradeResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="accountNum" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="calculateByActivePkg" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="endDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="newPackageId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="newPackageName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="openId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="originalPackageId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="originalPackageName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="originalPrice" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="originalServiceOrderNum" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="respCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="respMsg" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="startDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="upgradeGapPrice" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="upgratedParentOrderNum" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "packageUpgradeResponse", propOrder = {
    "accountNum",
    "calculateByActivePkg",
    "endDate",
    "newPackageId",
    "newPackageName",
    "openId",
    "originalPackageId",
    "originalPackageName",
    "originalPrice",
    "originalServiceOrderNum",
    "respCode",
    "respMsg",
    "startDate",
    "upgradeGapPrice",
    "upgratedParentOrderNum"
})
public class PackageUpgradeResponse {

    protected String accountNum;
    protected boolean calculateByActivePkg;
    protected String endDate;
    protected String newPackageId;
    protected String newPackageName;
    protected String openId;
    protected String originalPackageId;
    protected String originalPackageName;
    protected Double originalPrice;
    protected String originalServiceOrderNum;
    protected String respCode;
    protected String respMsg;
    protected String startDate;
    protected Double upgradeGapPrice;
    protected String upgratedParentOrderNum;

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
     * ��ȡcalculateByActivePkg���Ե�ֵ��
     * 
     */
    public boolean isCalculateByActivePkg() {
        return calculateByActivePkg;
    }

    /**
     * ����calculateByActivePkg���Ե�ֵ��
     * 
     */
    public void setCalculateByActivePkg(boolean value) {
        this.calculateByActivePkg = value;
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
     * ��ȡnewPackageId���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNewPackageId() {
        return newPackageId;
    }

    /**
     * ����newPackageId���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNewPackageId(String value) {
        this.newPackageId = value;
    }

    /**
     * ��ȡnewPackageName���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNewPackageName() {
        return newPackageName;
    }

    /**
     * ����newPackageName���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNewPackageName(String value) {
        this.newPackageName = value;
    }

    /**
     * ��ȡopenId���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOpenId() {
        return openId;
    }

    /**
     * ����openId���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOpenId(String value) {
        this.openId = value;
    }

    /**
     * ��ȡoriginalPackageId���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOriginalPackageId() {
        return originalPackageId;
    }

    /**
     * ����originalPackageId���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOriginalPackageId(String value) {
        this.originalPackageId = value;
    }

    /**
     * ��ȡoriginalPackageName���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOriginalPackageName() {
        return originalPackageName;
    }

    /**
     * ����originalPackageName���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOriginalPackageName(String value) {
        this.originalPackageName = value;
    }

    /**
     * ��ȡoriginalPrice���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getOriginalPrice() {
        return originalPrice;
    }

    /**
     * ����originalPrice���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setOriginalPrice(Double value) {
        this.originalPrice = value;
    }

    /**
     * ��ȡoriginalServiceOrderNum���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOriginalServiceOrderNum() {
        return originalServiceOrderNum;
    }

    /**
     * ����originalServiceOrderNum���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOriginalServiceOrderNum(String value) {
        this.originalServiceOrderNum = value;
    }

    /**
     * ��ȡrespCode���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRespCode() {
        return respCode;
    }

    /**
     * ����respCode���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRespCode(String value) {
        this.respCode = value;
    }

    /**
     * ��ȡrespMsg���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRespMsg() {
        return respMsg;
    }

    /**
     * ����respMsg���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRespMsg(String value) {
        this.respMsg = value;
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
     * ��ȡupgradeGapPrice���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getUpgradeGapPrice() {
        return upgradeGapPrice;
    }

    /**
     * ����upgradeGapPrice���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setUpgradeGapPrice(Double value) {
        this.upgradeGapPrice = value;
    }

    /**
     * ��ȡupgratedParentOrderNum���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUpgratedParentOrderNum() {
        return upgratedParentOrderNum;
    }

    /**
     * ����upgratedParentOrderNum���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUpgratedParentOrderNum(String value) {
        this.upgratedParentOrderNum = value;
    }

}
