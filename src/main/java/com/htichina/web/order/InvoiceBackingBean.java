package com.htichina.web.order;

import com.google.common.base.Strings;
import com.htichina.common.web.Constant;
import com.htichina.web.PaymentServiceClient;
import com.htichina.web.common.FacesUtils;
import com.htichina.web.common.MessageBundle;
import com.htichina.web.common.ViewPage;
import com.htichina.wsclient.payment.InvoiceInfoRequest;
import com.htichina.wsclient.payment.QueryChildOrdersByParentOrderNumResponse;
import com.htichina.wsclient.payment.QueryOrderByParentOrderNumResponse;
import org.apache.log4j.Logger;
import org.owasp.esapi.ESAPI;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * The main class for handling the invoice request from the page
 * Created by user on 2016/4/6.
 */
@Component
@Scope("session")

public class InvoiceBackingBean implements Serializable {
    private static Logger logger = Logger.getLogger(InvoiceBackingBean.class.getName());
    PaymentServiceClient client = PaymentServiceClient.getInstance();


    private String paymentPlatform;

    // invoice order details
    private String vin;
    private String parentOrderNum;
    private double parentOrderPrice;
    private String parentOrderStartDt;
    private String shortPackageName;
    private String marketName;
    private double price;
    private double quanti;
    private String childOrderStartDt;


    //invoice customer details
    private String city;
    private String created;

    private String createdBy;
    private String district;
    private String email;

    private String invoiceAccount;

    private String invoiceContact;

    private String invoiceType;

    private String invoiceVatType;

    private String lastUpd;

    private String lastUpdBy;

    private String mailTo;

    private String orderNum;
    private String phone;
    private String province;
    private String street;
    private String zipcode;

    // 页面用弹窗信息
    private String applyInvoicePop;
    private String invoiceConfirmPop;
    private String invoiceSpecialPop;
    private String invoiceCommonPop;

    // select base package
    private List<QueryChildOrdersByParentOrderNumResponse> childorders;

    // select wifi package


    private boolean validateParentOrderEntryInput() {

        logger.debug("validating user input...");
        FacesContext context = FacesContext.getCurrentInstance();
        logger.info("parentOrderNum=" + ESAPI.encoder().encodeForHTML(parentOrderNum));
        if (Strings.isNullOrEmpty(parentOrderNum)) {
            applyInvoicePop = "请输入订单编号！";
            context.addMessage(null, new FacesMessage(
                    FacesMessage.SEVERITY_ERROR, "请输入订单编号！", ""));
            return false;
        }
        return true;
    }

    private boolean validateEmailInput() {

        logger.debug("validating user input...");
        FacesContext context = FacesContext.getCurrentInstance();
        logger.info("email=" + ESAPI.encoder().encodeForHTML(email));
        if (Strings.isNullOrEmpty(email)) {
            invoiceSpecialPop = "请输入需要寄送的邮箱地址！";
            invoiceCommonPop = "请输入需要寄送的邮箱地址！";
            context.addMessage(null, new FacesMessage(
                    FacesMessage.SEVERITY_ERROR, "请输入需要寄送的邮箱地址！", ""));
            return false;
        }
        return true;
    }


    public String toInvoiceOrderInfo() {
        logger.debug("in toOrderAccountInfo...");
        FacesContext context = FacesContext.getCurrentInstance();


        if (validateParentOrderEntryInput()) {
            paymentPlatform = (String) FacesUtils.getManagedBeanInSession(Constant.PAYMENT_PLATFORM);
            logger.info("payment_platform=" + ESAPI.encoder().encodeForHTML(paymentPlatform));

            logger.info("parent order number:" + ESAPI.encoder().encodeForHTML(parentOrderNum));
            childorders = new ArrayList<QueryChildOrdersByParentOrderNumResponse>();
            childorders = client.queryChildOrdersByParentOrderNum(parentOrderNum);
            XMLGregorianToDateConverter xmlGregorianToDateConverter = new XMLGregorianToDateConverter();
            Date date = new Date();

            /*logger.info("child order size = " + childorders.size());*/
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            QueryOrderByParentOrderNumResponse parentrderinfo;

            String openId = (String) FacesUtils.getManagedBeanInSession(Constant.OPEN_ID);
            String accountNum = client.getActiveAccountByOpenId(openId);

            parentrderinfo = client.queryOrderByParentOrderNum(parentOrderNum, "");
            if(parentrderinfo.isInsurancePresentOrder()){
                applyInvoicePop = "您的订单为赠品，无需开具发票。如需帮助，请按车内i按钮或致电400-898-0050，详询梅赛德斯-奔驰 智能互联服务中心";
                context.addMessage(null, new FacesMessage(
                        FacesMessage.SEVERITY_ERROR, "您的订单为赠品，无需开具发票。如需帮助，请按车内i按钮或致电400-898-0050，详询梅赛德斯-奔驰 智能互联服务中心", ""));
                return ViewPage.LINK2ApplyInvoice;
            }

            if (parentrderinfo == null  || childorders.size() == 0 || Strings.isNullOrEmpty(parentrderinfo.getOrderStatus())) {
                applyInvoicePop = "请确认您的订单号是否准确。如需帮助，请按车内【i】按钮或致电400-898-0050";
                context.addMessage(null, new FacesMessage(
                        FacesMessage.SEVERITY_ERROR, "请确认您的订单号是否准确。如需帮助，请按车内【i】按钮或致电400-898-0050", ""));
                return ViewPage.LINK2ApplyInvoice;
            }

            if(!parentrderinfo.getOrderStatus().equalsIgnoreCase(Constant.DB_ORDER_STATUS_COMPLETED)) {
                applyInvoicePop = "订单尚未完成，请稍后再试。如需帮助，请按车内【i】按钮或致电400-898-0050";
                context.addMessage(null, new FacesMessage(
                        FacesMessage.SEVERITY_ERROR, "订单尚未完成，请稍后再试。如需帮助，请按车内【i】按钮或致电400-898-0050", ""));
                return ViewPage.LINK2ApplyInvoice;
            }

            if(parentrderinfo.getPrice() <= 0) {
                applyInvoicePop = "抱歉，非付费订单无法开具发票。如需帮助，请按车内【i】按钮或致电400-898-0050";
                context.addMessage(null, new FacesMessage(
                        FacesMessage.SEVERITY_ERROR, "很抱歉，非付费订单无法开具发票。如需帮助，请按车内【i】按钮或致电400-898-0050", ""));
                return ViewPage.LINK2ApplyInvoice;
            }

            if(Strings.isNullOrEmpty(accountNum)) {
                applyInvoicePop = "请点击菜单“在线订购”->“我的账户”登录成功后进行发票申请。 如需帮助，请按车内【i】按钮或致电400-898-0050。";
//                context.addMessage(null, new FacesMessage(
//                        FacesMessage.SEVERITY_ERROR, "无法获知您的智能互联客户编号。请点击菜单“在线订购”-> “我的账户”进行登录之后再试。如需帮助，请按车内【i】按钮或致电4008980050", ""));
                context.addMessage(null, new FacesMessage(
                        FacesMessage.SEVERITY_ERROR, "请点击菜单“在线订购”->“我的账户”登录成功后进行发票申请。 如需帮助，请按车内【i】按钮或致电400-898-0050。", ""));
                return ViewPage.LINK2ApplyInvoice;
            }

            if(!Strings.isNullOrEmpty(accountNum) && !accountNum.equalsIgnoreCase(parentrderinfo.getAccountNum())) {
                applyInvoicePop = "请点击菜单“在线订购”->“我的账户”请成功登录完成该订单所用账号后进行发票申请。 如需帮助，请按车内【i】按钮或致电400-898-0050。";
//                context.addMessage(null, new FacesMessage(
//                        FacesMessage.SEVERITY_ERROR, "您的智能互联客户编号与订单所属的客户编号不符。请点击菜单“在线订购”-> “我的账户”进行登录之后再试。如需帮助，请按车内【i】按钮或致电4008980050", ""));
                context.addMessage(null, new FacesMessage(
                        FacesMessage.SEVERITY_ERROR, "请点击菜单“在线订购”->“我的账户”登录成功后进行发票申请。 如需帮助，请按车内【i】按钮或致电400-898-0050。", ""));
                return ViewPage.LINK2ApplyInvoice;
            }

            InvoiceInfoRequest invoiceInfoRequest;
            invoiceInfoRequest=client.getInvoiceInformation(parentOrderNum);
            if(invoiceInfoRequest != null){
                logger.info("invoice :"+ESAPI.encoder().encodeForHTML(invoiceInfoRequest.toString()));
            }

            if (invoiceInfoRequest.getOrderNum() != null) {
                return ViewPage.LINK2ShipedInvoice;

            } else {
                try {
                    int dateDiff = xmlGregorianToDateConverter.stringDaysBetween(xmlGregorianToDateConverter.xmlDate2Date(parentrderinfo.getStartDt()), simpleDateFormat.format(date));
                    if (dateDiff > 30) {
                        applyInvoicePop = "您的订单已超出发票申请期限。请在订单支付完成后的30天之内提交发票开具申请。 如需帮助，请按车内【i】按钮或致电400-898-0050。";
                        context.addMessage(null, new FacesMessage(
                                FacesMessage.SEVERITY_ERROR, "您的订单已超出发票申请期限。请在订单支付完成后的30天之内提交发票开具申请。" +
                                "如需帮助，请按车内【i】按钮或致电400-898-0050", ""));
                        return ViewPage.LINK2ApplyInvoice;
                    }
                    parentOrderPrice = parentrderinfo.getPrice();
                    parentOrderStartDt = xmlGregorianToDateConverter.xmlDate2Date(parentrderinfo.getStartDt());
                    vin = parentrderinfo.getVin();
                    for (QueryChildOrdersByParentOrderNumResponse childorder : childorders) {
                        shortPackageName = childorder.getShortMarketName();
                        marketName = childorder.getMarketName();
                        price = childorder.getPrice();
                        quanti = childorder.getQuanti();
                        childOrderStartDt = xmlGregorianToDateConverter.xmlDate2Date(childorder.getStartDt());
                        logger.info("childOrders marketname:"+ESAPI.encoder().encodeForHTML(childorder.getMarketName()));
                    }

                } catch (ParseException e) {
                    e.printStackTrace();
                }

                return ViewPage.LINK2InvoiceOrder;
            }

        }
        return ViewPage.LINK2ApplyInvoice;
    }

    public String toInvoiceChoose() {
        return ViewPage.LINK2InvoiceChoose;
    }


    public String toInvoiceDetailsInfo() {
        logger.info("invoice type:" + ESAPI.encoder().encodeForHTML(invoiceType));
        if(invoiceType.equalsIgnoreCase("个人")) {
            return ViewPage.LINK2InvoiceDetails;
        }
        if (invoiceType.equalsIgnoreCase("公司")) {
            return ViewPage.LINK2VatTypeChoose;
        }

        return "";
    }

    public String toInvoiceVatTypeSelected() {
        logger.info("invoice vat type:" + ESAPI.encoder().encodeForHTML(invoiceVatType));
        if(invoiceVatType.equalsIgnoreCase("增值税普通发票")) {
            return ViewPage.LINK2InvoiceCommon;
        }

        if(invoiceVatType.equalsIgnoreCase("增值税专用发票")) {
            return ViewPage.LINK2InvoiceSpecial;
        }
        return ViewPage.LINK2VatTypeChoose;
    }



    public String toInvoiceConfirm() {
        return ViewPage.LINK2InvoiceConfirm;
    }

    public String toInvoiceSuccess() {
        FacesContext context = FacesContext.getCurrentInstance();


        InvoiceInfoRequest invoiceInfoRequest = new InvoiceInfoRequest();
        invoiceInfoRequest.setStreet(street);
        invoiceInfoRequest.setCity(city);
        invoiceInfoRequest.setDistrict(district);
        invoiceInfoRequest.setOrderNum(parentOrderNum);
        invoiceInfoRequest.setInvoiceType(invoiceType);
        invoiceInfoRequest.setInvoiceVatType("1");
        invoiceInfoRequest.setInvoiceAccount(invoiceAccount);
        invoiceInfoRequest.setInvoiceContact(invoiceContact);
        invoiceInfoRequest.setPhone(phone);
        invoiceInfoRequest.setEmail(email);
        invoiceInfoRequest.setMailTo(mailTo);
        invoiceInfoRequest.setProvince(province);
        invoiceInfoRequest.setCity(city);
        invoiceInfoRequest.setDistrict(district);
        invoiceInfoRequest.setStreet(street);
        invoiceInfoRequest.setZipcode(zipcode);
        invoiceInfoRequest.setCreated(created);
        invoiceInfoRequest.setCreatedBy(createdBy);
        invoiceInfoRequest.setLastUpd(lastUpd);
        invoiceInfoRequest.setLastUpdBy(lastUpdBy);


        if(client.InsertInvoice(invoiceInfoRequest)) {
            logger.debug("Created new invoice successfully, order_num=" + ESAPI.encoder().encodeForHTML(parentOrderNum) + "Phone=" + ESAPI.encoder().encodeForHTML(phone));
            return ViewPage.LINK2InvoiceSuccess;
        } else {
            invoiceConfirmPop = MessageBundle.getValue("wechat.b2c.invoice.error.create",
                    new String[]{parentOrderNum});
            logger.warn("Failed Creating new invoice, order_num=" + ESAPI.encoder().encodeForHTML(parentOrderNum));
            context.addMessage(null, new FacesMessage(
                    FacesMessage.SEVERITY_ERROR, MessageBundle.getValue("wechat.b2c.invoice.error.create",
                    new String[]{parentOrderNum}), ""));
        }
        return ViewPage.LINK2InvoiceConfirm;
    }

    public String toInvoiceSpecial(){
        FacesContext context = FacesContext.getCurrentInstance();
        InvoiceInfoRequest invoiceInfoRequest= new InvoiceInfoRequest();
        invoiceInfoRequest.setOrderNum(parentOrderNum);
        invoiceInfoRequest.setEmail(email);
        invoiceInfoRequest.setInvoiceType("2");
        logger.info(ESAPI.encoder().encodeForHTML(invoiceInfoRequest.getOrderNum()));

        invoiceInfoRequest.setInvoiceVatType("2");
        if(validateEmailInput()) {
            if (client.InsertInvoice(invoiceInfoRequest)) {
                if (client.SendInvoiceEmail(invoiceInfoRequest)) {
                    logger.debug("Created new invoice successfully, email=" + ESAPI.encoder().encodeForHTML(email));
                    return ViewPage.LINK2InvoiceSpecialSuccess;
                } else {
                    invoiceSpecialPop = MessageBundle.getValue("wechat.b2c.invoice.error.create",
                            new String[]{email});
                    logger.warn("Failed Creating new invoice, email=" + ESAPI.encoder().encodeForHTML(email));
                    context.addMessage(null, new FacesMessage(
                            FacesMessage.SEVERITY_ERROR, MessageBundle.getValue("wechat.b2c.invoice.error.create",
                            new String[]{email}), ""));
                }
            } else {
                invoiceSpecialPop = MessageBundle.getValue("wechat.b2c.invoice.error.create",
                        new String[]{parentOrderNum});
                logger.warn("Failed Creating new invoice, order_num=" + ESAPI.encoder().encodeForHTML(parentOrderNum));
                context.addMessage(null, new FacesMessage(
                        FacesMessage.SEVERITY_ERROR, MessageBundle.getValue("wechat.b2c.invoice.error.create",
                        new String[]{parentOrderNum}), ""));
            }
        }
        return null;
    }

    public String toInvoiceCommon(){
        FacesContext context = FacesContext.getCurrentInstance();
        InvoiceInfoRequest invoiceInfoRequest= new InvoiceInfoRequest();
        invoiceInfoRequest.setOrderNum(parentOrderNum);
        invoiceInfoRequest.setEmail(email);
        invoiceInfoRequest.setInvoiceType("2");
        logger.info(ESAPI.encoder().encodeForHTML(invoiceInfoRequest.getOrderNum()));

        invoiceInfoRequest.setInvoiceVatType("1");
        if(validateEmailInput()) {
            if (client.InsertInvoice(invoiceInfoRequest)) {
                if (client.SendInvoiceEmail(invoiceInfoRequest)) {
                    logger.debug("Created new invoice successfully, email=" + ESAPI.encoder().encodeForHTML(email));
                    return ViewPage.LINK2InvoiceSpecialSuccess;
                } else {
                    invoiceCommonPop = MessageBundle.getValue("wechat.b2c.invoice.error.create",
                            new String[]{email});
                    logger.warn("Failed Creating new invoice, email=" + ESAPI.encoder().encodeForHTML(email));
                    context.addMessage(null, new FacesMessage(
                            FacesMessage.SEVERITY_ERROR, MessageBundle.getValue("wechat.b2c.invoice.error.create",
                            new String[]{email}), ""));
                }
            } else {
                invoiceCommonPop = MessageBundle.getValue("wechat.b2c.invoice.error.create",
                        new String[]{parentOrderNum});
                logger.warn("Failed Creating new invoice, order_num=" + ESAPI.encoder().encodeForHTML(parentOrderNum));
                context.addMessage(null, new FacesMessage(
                        FacesMessage.SEVERITY_ERROR, MessageBundle.getValue("wechat.b2c.invoice.error.create",
                        new String[]{parentOrderNum}), ""));
            }
        }
        return null;
    }




    public String getPaymentPlatform() {
        return paymentPlatform;
    }

    public void setPaymentPlatform(String paymentPlatform) {
        this.paymentPlatform = paymentPlatform;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getParentOrderNum() {
        return parentOrderNum;
    }

    public void setParentOrderNum(String parentOrderNum) {
        this.parentOrderNum = parentOrderNum;
    }

    public double getParentOrderPrice() {
        return parentOrderPrice;
    }

    public void setParentOrderPrice(double parentOrderPrice) {
        this.parentOrderPrice = parentOrderPrice;
    }

    public String getParentOrderStartDt() {
        return parentOrderStartDt;
    }

    public void setParentOrderStartDt(String parentOrderStartDt) {
        this.parentOrderStartDt = parentOrderStartDt;
    }

    public String getShortPackageName() {
        return shortPackageName;
    }

    public void setShortPackageName(String shortPackageName) {
        this.shortPackageName = shortPackageName;
    }

    public String getMarketName() {
        return marketName;
    }

    public void setMarketName(String marketName) {
        this.marketName = marketName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getQuanti() {
        return quanti;
    }

    public void setQuanti(double quanti) {
        this.quanti = quanti;
    }

    public String getChildOrderStartDt() {
        return childOrderStartDt;
    }

    public void setChildOrderStartDt(String childOrderStartDt) {
        this.childOrderStartDt = childOrderStartDt;
    }

    public List<QueryChildOrdersByParentOrderNumResponse> getChildorders() {
        return childorders;
    }

    public void setChildorders(List<QueryChildOrdersByParentOrderNumResponse> childorders) {
        this.childorders = childorders;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getInvoiceAccount() {
        return invoiceAccount;
    }

    public void setInvoiceAccount(String invoiceAccount) {
        this.invoiceAccount = invoiceAccount;
    }

    public String getInvoiceContact() {
        return invoiceContact;
    }

    public void setInvoiceContact(String invoiceContact) {
        this.invoiceContact = invoiceContact;
    }

    public String getInvoiceType() {
        return invoiceType;
    }

    public void setInvoiceType(String invoiceType) {
        this.invoiceType = invoiceType;
    }

    public String getInvoiceVatType() {
        return invoiceVatType;
    }

    public void setInvoiceVatType(String invoiceVatType) {
        this.invoiceVatType = invoiceVatType;
    }

    public String getLastUpd() {
        return lastUpd;
    }

    public void setLastUpd(String lastUpd) {
        this.lastUpd = lastUpd;
    }

    public String getLastUpdBy() {
        return lastUpdBy;
    }

    public void setLastUpdBy(String lastUpdBy) {
        this.lastUpdBy = lastUpdBy;
    }

    public String getMailTo() {
        return mailTo;
    }

    public void setMailTo(String mailTo) {
        this.mailTo = mailTo;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getApplyInvoicePop() {
        String temp;
        temp = applyInvoicePop;
        applyInvoicePop = null;
        return temp;
    }

    public void setApplyInvoicePop(String applyInvoicePop) {
        this.applyInvoicePop = applyInvoicePop;
    }

    public String getInvoiceConfirmPop() {
        String temp;
        temp = invoiceConfirmPop;
        invoiceConfirmPop = null;
        return temp;
    }

    public void setInvoiceConfirmPop(String invoiceConfirmPop) {
        this.invoiceConfirmPop = invoiceConfirmPop;
    }

    public String getInvoiceSpecialPop() {
        String temp;
        temp = invoiceSpecialPop;
        invoiceSpecialPop = null;
        return temp;
    }

    public void setInvoiceSpecialPop(String invoiceSpecialPop) {
        this.invoiceSpecialPop = invoiceSpecialPop;
    }

    public String getInvoiceCommonPop() {
        String temp;
        temp = invoiceCommonPop;
        invoiceCommonPop = null;
        return temp;
    }

    public void setInvoiceCommonPop(String invoiceCommonPop) {
        this.invoiceCommonPop = invoiceCommonPop;
    }
}
