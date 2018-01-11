package com.htichina.web.order;

import java.io.Serializable;
import java.lang.Exception;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import com.htichina.wsclient.payment.*;

import org.apache.log4j.Logger;
import org.owasp.esapi.ESAPI;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.alipay.config.AlipayConfig;
import com.alipay.util.AlipaySubmit;
import com.alipay.util.UtilDate;
import com.google.common.base.Strings;
import com.htichina.common.web.ConfigureInfo;
import com.htichina.common.web.Constant;
import com.htichina.web.PaymentServiceClient;
import com.htichina.web.common.FacesUtils;
import com.htichina.web.common.MessageBundle;
import com.htichina.web.common.ViewPage;
import com.htichina.web.wechat.Demo;
import com.htichina.web.wechat.WxPayDto;


/**
 * The main class for handling the ordering request from the page
 * Created by yiming on 2015/7/7.
 */
@Component
@Scope("session")

public class OrderBackingBean implements Serializable {
    private static Logger logger = Logger.getLogger(OrderBackingBean.class.getName());
    PaymentServiceClient client = PaymentServiceClient.getInstance();

    private String paymentPlatform;
    private boolean wifiFlag;

    private String openId;
    private String targetPage;

    // order entry
    private String accountNum;
    private String vin;
    private String mobilePhone;
    private boolean termsAgreed;
    
    /* 2017-11-10,Tommy Liu, CR82_Part II, 套餐升级的请求和响应 */
    private PackageUpgradeRequest upgradeRequest;
    private PackageUpgradeResponse upgradeResponse;
    private String toInvoiceEntry = ViewPage.LINK2ApplyInvoice;

    // select base package
//    private String selectBasePackageShortName;
//    private String selectBasePackageDuration;
//    private List<SelectItem> selectBasePackageShortNameItem;
//    private List<SelectItem> selectBasePackageDurationItem;
//    private double basePrice;
//    private double basePromotionPrice;

    // select wifi package
//    private String selectWifiPackageShortName;
//    private String selectWifiPackageDuration;
//    private List<SelectItem> selectWifiPackageShortNameItem;
//    private List<SelectItem> selectWifiPackageDurationItem;
//    private double wifiPrice;
//    private double wifiPromotionPrice;

    // information list
    private List<VehicleInfoResponse> vehicles;
    private ProductInfoResponse productInfo;
    private AccountInfoResponse accountInfo;



    // user selection
    private VehicleInfoResponse selectedVehicle;
    private ProductInfo selectedBaseProduct;
    private ProductInfo selectedWifiProduct;


    // order information
    private String WIDout_trade_no;
    private String WIDsubject;
    private double WIDtotal_fee;

    // wechat transaction
    private String wechatPrepayResponse;

    private String wechatNotifyUrl = ConfigureInfo.getWechatNotifyUrl();

    private String wechatPayFailedUrl = ConfigureInfo.getWechatPayFailedUrl();

    // alipay transaction
    private String alipayRequest;

    // 各页面弹窗用提示语
    private String orderPackagePop;
    private String orderEntryPop;
    private String orderVehiclePop;
    private String orderAccountInfoPop;
    /* 2017-11-10,Tommy Liu, CR82_Part II, 套餐升级的信息提示 */
    private String myAccountPop;
    private String orderUpgradePop;

    private String selectVin;

    private String selectBaseProdId;

    // CR147新套餐包
    private List<PromotionInfoResponse> prods;
    // CR147 选定套餐id
    private String selectProdId;
    // CR147 选定套餐
    private PromotionInfoWS selectProd;
    // CR147选定套餐类型
    private String sPkgId;
    //CR389 是否出现抽奖按钮
    private int hasLuckyDrawLink;

    public String toOrderEntry(String oId) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss S");
        Date date2 = new Date();
        openId = oId;
        targetPage = ViewPage.LINK2MyAccount;
        String an = PaymentServiceClient.getInstance().getActiveAccountByOpenId(openId);

        AccountInfoResponse aInfo = PaymentServiceClient.getInstance().getCurrentAccountInfo(an);
        if(aInfo != null){
            mobilePhone = aInfo.getMobilePhone();
            accountNum = aInfo.getAccountNum();
            vin = aInfo.getVin();
        }
        Date date4 = new Date();
        String time4 = sdf.format(date4);
        return ViewPage.LINK2OrderEntry;
    }

    public String toOrderAccountInfo(String type,String id) {
        selectProdId = id;
        logger.debug("in toOrderAccountInfo...");
        if(validateOrderPackageInput()) {
            paymentPlatform = (String) FacesUtils.getManagedBeanInSession(Constant.PAYMENT_PLATFORM);
//            paymentPlatform = Constant.DB_ORDER_PAYMENT_TYPE_WEIXINPAY;//通过浏览器临时测试时使用
            selectProdId = id;
            if(!Strings.isNullOrEmpty(selectProdId)){
                for(PromotionInfoResponse promotionInfoResponse : this.prods){
                    for(PromotionCategoryResult promotionCategoryResult : promotionInfoResponse.getProductCategoryList()){
                        for(PromotionInfoWS promotionInfoWS : promotionCategoryResult.getPromotionCategoryList()){
                            if(String.valueOf(promotionInfoWS.getPkgId()).equalsIgnoreCase(selectProdId)){
                                selectProd = promotionInfoWS;
                                sPkgId = promotionInfoResponse.getProductCategoryId();
                            }
                        }
                    }
                }
            }

            accountNum = (String) FacesUtils.getManagedBeanInSession(Constant.ACCOUNT_NUM);
            if(Strings.isNullOrEmpty(accountNum)) {
                String openId = (String) FacesUtils.getManagedBeanInSession(Constant.OPEN_ID);
                accountNum = PaymentServiceClient.getInstance().getActiveAccountByOpenId(openId);
            }
            if(Strings.isNullOrEmpty(accountNum)) {
                return ViewPage.LINK2OrderEntry;
            } else {
                FacesUtils.setManagedBeanInSession(Constant.ACCOUNT_NUM, accountNum);
            }

            FacesContext context = FacesContext.getCurrentInstance();
            double amount = 0;
            if(selectProd != null){
                amount = selectProd.getPromotionPrice();
            }
            if(Constant.DB_ORDER_PAYMENT_TYPE_WEIXINPAY.equalsIgnoreCase(paymentPlatform)) {
                if (amount >= 3000) {
                    orderPackagePop = "3000limit";
                    context.addMessage(null, new FacesMessage(
                            FacesMessage.SEVERITY_ERROR, "由于微信当日支付限额为3000元，" +
                            "建议您按下车内【i】按钮或致电400-898-0050，" +
                            "我们的客服人员将协助您通过其他支付渠道完成此订单。" +
                            "我们正努力解决支付限额问题，感谢您的支持和信任！", ""));
                    return ViewPage.LINK2OrderPackage0;
                }
            }


            return toOrderPayment();


        }
        return ViewPage.LINK2OrderPackage0;
    }

    public String toOrderPackage() {
        logger.debug("in toOrderPackage...");
        FacesContext context = FacesContext.getCurrentInstance();

        paymentPlatform = (String) FacesUtils.getManagedBeanInSession(Constant.PAYMENT_PLATFORM);
        /*logger.info("paymentPlatform = " + paymentPlatform);*/
        if(validateOrderEntryInput()) {
            if(!Strings.isNullOrEmpty(accountNum)) {
                if (accountNum.indexOf("*") > -1)
                {
                    orderEntryPop = "如您对默认信息进行了修改，请输入完整信息不要包含*号";
                    context.addMessage(null, new FacesMessage(
                            FacesMessage.SEVERITY_ERROR, "如您对默认信息进行了修改，请输入完整信息不要包含*号", ""));
                    return ViewPage.LINK2OrderEntry;
                }
                accountInfo = client.getCurrentAccountInfo(accountNum);
                if(accountInfo != null){
                    if(Strings.isNullOrEmpty(accountInfo.getVin())) {
                        orderEntryPop = "非常抱歉，根据您的输入条件没有找到您的账户信息，" +
                                "请确认信息后再次尝试。如果有任何疑问请按车内 【i】按钮或" +
                                "拨打<span style=\"text-decoration: underline;\" class=\"span2\">400-898-0050</span>联系在线客服，谢谢！";
                        context.addMessage(null, new FacesMessage(
                                FacesMessage.SEVERITY_ERROR, "非常抱歉，根据您的输入条件没有找到您的账户信息，" +
                                "请确认信息后再次尝试。如果有任何疑问请按车内 【i】按钮或" +
                                "拨打400-898-0050联系在线客服，谢谢！", ""));
                        return ViewPage.LINK2OrderEntry;
                    }
                }

                /*logger.info("accountInfo.getVin() = " + accountInfo.getVin());*/
                List<VehicleInfoResponse> tmpVehicleList = client.getVehicleInfo(accountInfo.getVin(), "", "");
                if(tmpVehicleList == null || tmpVehicleList.size() == 0) {
                    orderEntryPop = "非常抱歉，根据您输入的客户编号没有找到您的爱车，" +
                            "请确认信息后再次尝试。如果有任何疑问请按车内 【i】按钮或" +
                            "拨打<span style=\"text-decoration: underline;\" class=\"span2\">400-898-0050</span>联系在线客服，谢谢！";
                    context.addMessage(null, new FacesMessage(
                            FacesMessage.SEVERITY_ERROR, "非常抱歉，根据您输入的客户编号没有找到您的爱车，" +
                            "请确认信息后再次尝试。如果有任何疑问请按车内 【i】按钮或" +
                            "拨打400-898-0050联系在线客服，谢谢！", ""));
                    return ViewPage.LINK2OrderEntry;
                }
                selectedVehicle = tmpVehicleList.get(0);

            } else {
                if ((vin.indexOf("*") > -1) || (mobilePhone.indexOf("*") > -1))
                {
                    orderEntryPop = "如您对默认信息进行了修改，请输入完整信息不要包含*号";
                    context.addMessage(null, new FacesMessage(
                            FacesMessage.SEVERITY_ERROR, "如您对默认信息进行了修改，请输入完整信息不要包含*号", ""));
                    return ViewPage.LINK2OrderEntry;
                }
                vehicles = new ArrayList<VehicleInfoResponse>();
                vehicles = client.getVehicleInfo(vin, "", mobilePhone);
                if(vehicles == null || vehicles.size() == 0) {
                    orderEntryPop = "非常抱歉，根据您的输入条件没有找到您的爱车，" +
                            "请确认信息后再次尝试。如果有任何疑问请按车内 【i】按钮或" +
                            "拨打<span style=\"text-decoration: underline;\" class=\"span2\">400-898-0050</span>联系在线客服，谢谢！";
                    context.addMessage(null, new FacesMessage(
                            FacesMessage.SEVERITY_ERROR, "非常抱歉，根据您的输入条件没有找到您的爱车，" +
                            "请确认信息后再次尝试。如果有任何疑问请按车内 【i】按钮或" +
                            "拨打400-898-0050联系在线客服，谢谢！", ""));
                    return ViewPage.LINK2OrderEntry;
                }

                if(vehicles.size() > 1) {
                    /*context.addMessage(null, new FacesMessage(
                            FacesMessage.SEVERITY_ERROR, "您的手机号可能关联多辆车，请尝试提供对应的智能互联编号或车架号(VIN)", ""));
                    return ViewPage.LINK2OrderEntry;*/
                    /*List<VehicleInfoResponse> tvehicles = new ArrayList<>();
                    tvehicles.add(vehicles.get(0));
                    vehicles = tvehicles;*/
                    return ViewPage.LINK2OrderVehicle;
                }

                selectedVehicle = vehicles.get(0);
                wifiFlag = selectedVehicle.getWifiFlag() == 1;

                FacesUtils.setManagedBeanInSession(Constant.ACCOUNT_NUM, String.valueOf(selectedVehicle.getAcctNum()));
                accountNum = String.valueOf(selectedVehicle.getAcctNum());
                ///检查账户类型及账户状态
                if(accountInfo == null) {
                    accountInfo = client.getCurrentAccountInfo(String.valueOf(selectedVehicle.getAcctNum()));
                }

            }

            FacesUtils.setManagedBeanInSession(Constant.ACCOUNT_NUM, String.valueOf(accountNum));

            String accountStatus = accountInfo.getAccountStatus();
            String accountType = accountInfo.getAccountType();

            boolean eligable = true;

            // account type = OEM, account status = Active
            if (accountType.equalsIgnoreCase(Constant.DB_ACCOUNT_TYPE_OEM) &&
                    accountStatus.equalsIgnoreCase(Constant.DB_ACCOUNT_STATUS_ACTIVE)) {
                eligable = false;
                orderEntryPop = "非Subscriber类型账户";
                context.addMessage(null, new FacesMessage(
                        FacesMessage.SEVERITY_ERROR, "非Subscriber类型账户", ""));
            }


            // account type = subscriber, account status = closed or declined
            if (accountType.equalsIgnoreCase(Constant.DB_ACCOUNT_TYPE_SUBSCRIBER) &&
                    (accountStatus.equalsIgnoreCase(Constant.DB_ACCOUNT_STATUS_CLOSED) ||
                            accountStatus.equalsIgnoreCase(Constant.DB_ACCOUNT_STATUS_DECLINED))) {
                eligable = false;
                orderEntryPop = "您的账户已注销";
                context.addMessage(null, new FacesMessage(
                        FacesMessage.SEVERITY_ERROR, "您的账户已注销，请按车内【i】按钮注册新账户。", ""));
            }

            // if account type = demo or test
            if(accountType.equalsIgnoreCase(Constant.DB_ACCOUNT_TYPE_DEMO) ||
                    accountStatus.equalsIgnoreCase(Constant.DB_ACCOUNT_TYPE_TEST)) {
                eligable = false;
                orderEntryPop = "这是一个Demo或者是Test 类型车辆，请联系现场主管";
                context.addMessage(null, new FacesMessage(
                        FacesMessage.SEVERITY_ERROR, "这是一个Demo或者是Test 类型车辆，请联系现场主管", ""));
            }


            if(!eligable) {
                return ViewPage.LINK2OrderEntry;
            }



            /*logger.info("selectedVehicle = " + selectedVehicle.getVin())*/;
            int baseServiceStatus = selectedVehicle.getBaseSeviceStatus();
            wifiFlag = selectedVehicle.getWifiFlag() == 1;
            /*logger.info("baseServiceStatus = " + baseServiceStatus);
            logger.info("wifiFlag = " + wifiFlag);*/
            prods = getProd();
            return ViewPage.LINK2OrderPackage0;

        }
        return ViewPage.LINK2OrderEntry;
    }

    private boolean checkOneCentPromotionTaken(VehicleInfoResponse vehicle) {
        logger.debug("in checkOneCentPromotionTaken...");
        boolean taken = false;
        String state = (String) FacesUtils.getManagedBeanInSession(Constant.WECHAT_STATE);
        /*logger.debug("state = " + state);*/
        if(Constant.WECHAT_STATE_PROMOTION.equalsIgnoreCase(state)) {
            PurchaseProductResponse response = client.checkPurchaseProduct(vehicle.getVin(), Constant.DB_PACKAGE_TYPE_WIFI_PROMOTION);
            if(Constant.SERVICE_B2C_PAYMENT_RESPONSE_CODE_SUCCESS.equalsIgnoreCase(response.getRespCode())) {
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage(null, new FacesMessage(
                        FacesMessage.SEVERITY_ERROR, "非常抱歉，您的爱车已经参加过一元钱专享活动，" +
                        "不能再次参加。如有任何疑问请按车内【i】按钮或" +
                        "拨打400-898-0050联系在线客服，谢谢！", ""));
                taken = true;
            }
        }
        return taken;
    }

    public String toVehicleSelection() {
        logger.debug("in toVehicleSelection...");
        FacesContext context = FacesContext.getCurrentInstance();
        if(validateVehicleSelectionInput()) {
            /*String selectVin = FacesUtils.getRequestParameter("selectVin");*/
            logger.info("selected vin = " + ESAPI.encoder().encodeForHTML(selectVin));
            for(VehicleInfoResponse vehicleInfo  : vehicles) {
                if(vehicleInfo.getVin().equalsIgnoreCase(selectVin)) {
                    selectedVehicle = vehicleInfo;
                    break;
                }
            }

            FacesUtils.setManagedBeanInSession(Constant.ACCOUNT_NUM, String.valueOf(selectedVehicle.getAcctNum()));
            accountNum = String.valueOf(selectedVehicle.getAcctNum());
            prods = client.getPromotionInfo(accountNum);
            ///检查账户类型及账户状态
            if(accountInfo == null) {
                accountInfo = client.getCurrentAccountInfo(String.valueOf(selectedVehicle.getAcctNum()));
            }
            String accountStatus = accountInfo.getAccountStatus();
            String accountType = accountInfo.getAccountType();
            boolean eligable = true;

            // account type = OEM, account status = Active
            if (accountType.equalsIgnoreCase(Constant.DB_ACCOUNT_TYPE_OEM) &&
                    accountStatus.equalsIgnoreCase(Constant.DB_ACCOUNT_STATUS_ACTIVE)) {
                eligable = false;
                orderVehiclePop = MessageBundle.getValue("web.b2c.order.error.account.type");
                context.addMessage(null, new FacesMessage(
                        FacesMessage.SEVERITY_ERROR, MessageBundle.getValue("web.b2c.order.error.account.type"), ""));
            }

            // account type = subscriber, account status = closed or declined
            if (accountType.equalsIgnoreCase(Constant.DB_ACCOUNT_TYPE_SUBSCRIBER) &&
                    (accountStatus.equalsIgnoreCase(Constant.DB_ACCOUNT_STATUS_CLOSED) ||
                            accountStatus.equalsIgnoreCase(Constant.DB_ACCOUNT_STATUS_DECLINED))) {
                eligable = false;
                orderVehiclePop = MessageBundle.getValue("web.b2c.order.error.account.status");
                context.addMessage(null, new FacesMessage(
                        FacesMessage.SEVERITY_ERROR, MessageBundle.getValue("web.b2c.order.error.account.status"), ""));
            }

            // if account type = demo or test
            if(accountType.equalsIgnoreCase(Constant.DB_ACCOUNT_TYPE_DEMO) ||
                    accountStatus.equalsIgnoreCase(Constant.DB_ACCOUNT_TYPE_TEST)) {
                eligable = false;
                orderVehiclePop = MessageBundle.getValue("info.onlinepro.demotest");
                context.addMessage(null, new FacesMessage(
                        FacesMessage.SEVERITY_ERROR, MessageBundle.getValue("info.onlinepro.demotest"), ""));
            }


            if(!eligable) {
                return ViewPage.LINK2OrderVehicle;
            }



            /*logger.info("selectedVehicle = " + selectedVehicle.getVin());*/
            int baseServiceStatus = selectedVehicle.getBaseSeviceStatus();
            wifiFlag = selectedVehicle.getWifiFlag() == 1;
            /*logger.info("baseServiceStatus = " + baseServiceStatus);
            logger.info("wifiFlag = " + wifiFlag);*/

            return ViewPage.LINK2OrderPackage0;
        }
        return ViewPage.LINK2OrderVehicle;
    }

    public String toOrderPayment() {
        logger.debug("in toOrderPayment...");
        FacesContext context = FacesContext.getCurrentInstance();

        // create new order
        logger.debug("creating order...");
        String sProdId = "";
        double sProdPrice = 0;
        if(selectProd != null){
            sProdId = String.valueOf(selectProd.getPkgId());
            sProdPrice = selectProd.getPromotionPrice();
        }
        String oId = (String) FacesUtils.getManagedBeanInSession(Constant.OPEN_ID);
        logger.info("sPkgId  == "+ESAPI.encoder().encodeForHTML(sPkgId));
        logger.info("sProdPrice =="+ESAPI.encoder().encodeForHTML(sProdPrice+""));
        logger.info("sProdId ==>"+ESAPI.encoder().encodeForHTML(sProdId));
        logger.info("accountNum ==>"+ESAPI.encoder().encodeForHTML(String.valueOf(selectedVehicle.getAcctNum())));
        logger.info("vin ==>"+ESAPI.encoder().encodeForHTML(selectedVehicle.getVin()));
        logger.info("paymentPlatform ==>"+ESAPI.encoder().encodeForHTML(paymentPlatform));
        logger.info("oId ==>"+ESAPI.encoder().encodeForHTML(oId));
        PaymentOrderResponse paymentOrderResponse = client.createPaymentOrder(
                sProdId,
                sProdPrice,
                sPkgId,
                String.valueOf(selectedVehicle.getAcctNum()),
                selectedVehicle.getVin(),
                paymentPlatform,
                oId
        );
        // if create new order failed
        if(!paymentOrderResponse.getRespCode().equals(Constant.SERVICE_B2C_PAYMENT_RESPONSE_CODE_SUCCESS)) {
            /*orderAccountInfoPop = "创建订单失败，原因："+paymentOrderResponse.getRespMsg()+"请重试或致电400-898-0050联系梅赛德斯-奔驰智能互联服务中心寻求帮助";*/
            context.addMessage(null, new FacesMessage(
                    FacesMessage.SEVERITY_ERROR, "创建订单失败，原因：" + paymentOrderResponse.getRespMsg(), ""));
            /*return ViewPage.LINK2OrderAccountInfo;*/
            orderPackagePop = "创建订单失败，原因："+paymentOrderResponse.getRespMsg()+"请重试或致电<span style=\"text-decoration: underline;\" class=\"span2\">400-898-0050</span>联系梅赛德斯-奔驰智能互联服务中心寻求帮助";
            return ViewPage.LINK2OrderPackage0;
        }

        // create transaction
        String transactionNo = getTransactionNo();
        String serialNo = getSerialNo();
        String transChannel = null;
        if(isWechatPay()) {
            transChannel = "03";
        } else if(isAlipay()) {
            transChannel = "04";
        }
        double amount = 0;
        String orderDesc = "";
        if(selectProd != null){
            amount = selectProd.getPromotionPrice();
            if(Strings.isNullOrEmpty(orderDesc)) {
                orderDesc += selectProd.getShortMarketName();
            } else {
                orderDesc += "和" + selectProd.getShortMarketName();
            }
        }
        TransactionRequest transactionRequest = new TransactionRequest();
        transactionRequest.setAmoumt(String.valueOf(amount));
        transactionRequest.setChannel(transChannel);
        transactionRequest.setOrderDescription(orderDesc);
        transactionRequest.setPaymentno(transactionNo);
        transactionRequest.setRemark("微信支付，OpenID:" + FacesUtils.getManagedBeanInSession(Constant.OPEN_ID));
        transactionRequest.setRespcode("00A4");
        transactionRequest.setResponse("已下单，等待支付");
        transactionRequest.setSeraialno(serialNo);
        logger.debug("creating transaction");
        TransactionResponse transactionResponse = client.createTransaction(paymentOrderResponse.getOrderNum(), transactionRequest);;
        if(!transactionResponse.getRespcode().equals(Constant.SERVICE_B2C_PAYMENT_RESPONSE_CODE_SUCCESS)) {
            logger.error("create new transaction failed, error message: " + ESAPI.encoder().encodeForHTML(transactionResponse.getRespMsg()));
            /*orderAccountInfoPop = "创建交易失败，原因：" + transactionResponse.getRespMsg();*/
            context.addMessage(null, new FacesMessage(
                    FacesMessage.SEVERITY_ERROR, "创建交易失败，原因：" + transactionResponse.getRespMsg()+"<br>请重试或致电<span class='span2'>400-898-0050</span>联系<br>梅赛德斯-奔驰智能互联<br>服务中心寻求帮助", ""));
            /*return ViewPage.LINK2OrderAccountInfo;*/
            orderPackagePop = "创建订单失败，原因："+transactionResponse.getRespMsg()+"请重试或致电<span style=\"text-decoration: underline;\" class=\"span2\">400-898-0050</span>联系梅赛德斯-奔驰智能互联服务中心寻求帮助";
            return ViewPage.LINK2OrderPackage0;

        }

        if(isWechatPay()) {
            // Do not need the rest
            WxPayDto tpWxPay = new WxPayDto();
            Demo demo = new Demo();
            tpWxPay.setOpenId((String) FacesUtils.getManagedBeanInSession(Constant.OPEN_ID));
            logger.debug("open_id=" + ESAPI.encoder().encodeForHTML(FacesUtils.getManagedBeanInSession(Constant.OPEN_ID).toString()));
            tpWxPay.setBody(orderDesc);
            logger.debug("prodName=" + ESAPI.encoder().encodeForHTML(orderDesc));
//                tpWxPay.setOrderId(paymentOrderResponse.getOrderNum());
            tpWxPay.setOrderId(transactionNo+paymentOrderResponse.getOrderNum());
            logger.debug("orderId=" + ESAPI.encoder().encodeForHTML(transactionNo + paymentOrderResponse.getOrderNum()));
            tpWxPay.setSpbillCreateIp("127.0.0.1");
            tpWxPay.setTotalFee(String.valueOf(amount));
            logger.debug("totalFee=" + ESAPI.encoder().encodeForHTML(String.valueOf(amount)));
            wechatPrepayResponse = demo.getPackage(tpWxPay);
            logger.info("wechatPrepayResponse=" + ESAPI.encoder().encodeForHTML(wechatPrepayResponse));
//            logger.infoln("wechatPrepayResponse=" + wechatPrepayResponse);
        }

        // setting order information
        WIDout_trade_no = transactionNo+paymentOrderResponse.getOrderNum();
        WIDsubject = orderDesc;
        WIDtotal_fee = amount;
        //CR389 lucky draw
        hasLuckyDrawLink = client.hasLuckyDrawLink(WIDout_trade_no.substring(13));

        return ViewPage.LINK2OrderPayment;
    }

    public String toOneCentPromotion() {
        // TODO: changed for compile
        logger.info("in toOneCentPromotion..");
        paymentPlatform = (String) FacesUtils.getManagedBeanInSession(Constant.PAYMENT_PLATFORM);
        logger.info("paymentPlatform = " + ESAPI.encoder().encodeForHTML(paymentPlatform));
        productInfo = client.getPromotionProdInfo();
        if(productInfo.getBaseProductList().size() > 0) {
            selectedBaseProduct = productInfo.getBaseProductList().get(0);
            logger.info("selectedBaseProduct=" + ESAPI.encoder().encodeForHTML(selectedBaseProduct.getProdId()+""));
        }
        return ViewPage.LINK2OrderEntry;
    }

    public void dataReset() {
        this.selectedBaseProduct = null;
        this.selectedVehicle = null;
        termsAgreed = false;
    }

    public static String getTransactionNo() {
        return String.valueOf(System.currentTimeMillis());
    }

    private String getSerialNo() {
        Long radom = Math.round(Math.random() * 1000000);
        while(radom < 100000) {
            radom = Math.round(Math.random()*1000000);
        }
        return String.valueOf(radom);
    }

    private boolean validateOrderEntryInput() {
        logger.debug("validating user input...");
        FacesContext context = FacesContext.getCurrentInstance();
        logger.info("accountNum=" + ESAPI.encoder().encodeForHTML(accountNum));
        logger.info("mobilePhone=" + ESAPI.encoder().encodeForHTML(mobilePhone));
        logger.info("vin=" + ESAPI.encoder().encodeForHTML(vin));
        if(Strings.isNullOrEmpty(accountNum) && Strings.isNullOrEmpty(mobilePhone) && Strings.isNullOrEmpty(vin)) {
            orderEntryPop = "请输入智能互联客户编号或者智能互联关联手机号码或者车架号！";
            context.addMessage(null, new FacesMessage(
                    FacesMessage.SEVERITY_ERROR, "请输入智能互联客户编号或者智能互联关联手机号码或者车架号！", ""));
            return false;
        }
        return true;
    }

    private boolean validateOrderPackageInput() {

        FacesContext context = FacesContext.getCurrentInstance();
        if(accountInfo == null) {
            accountInfo = client.getCurrentAccountInfo(accountNum);
        }
        if(Strings.isNullOrEmpty(selectProdId) &&
                !Constant.DB_ACCOUNT_STATUS_ACTIVE.equalsIgnoreCase(accountInfo.getAccountStatus())) {
            orderPackagePop = "您的智能互联服务套餐已过期，请选择智能互联服务套餐";
            context.addMessage(null, new FacesMessage(
                    FacesMessage.SEVERITY_ERROR, "您的智能互联服务套餐已过期，请选择智能互联服务套餐", ""));
            return false;
        }
        return true;
    }

    private boolean validateVehicleSelectionInput() {
        FacesContext context = FacesContext.getCurrentInstance();
        /*String selectVin = FacesUtils.getRequestParameter("selectVin");*/
        if(Strings.isNullOrEmpty(selectVin)) {
            orderVehiclePop = "请选择您要订购套餐的车辆！";
            context.addMessage(null, new FacesMessage(
                    FacesMessage.SEVERITY_ERROR, "请选择您要订购套餐的车辆！", ""));
            return false;
        }
        return true;
    }

    public String getPaymentPlatform() {
        return paymentPlatform;
    }

    public void setPaymentPlatform(String paymentPlatform) {
        this.paymentPlatform = paymentPlatform;
    }

    public boolean isWechatPay() {
        return Constant.DB_ORDER_PAYMENT_TYPE_WEIXINPAY.equals(paymentPlatform);
    }


    public boolean isAlipay() {
        return Constant.DB_ORDER_PAYMENT_TYPE_ALIPAY.equals(paymentPlatform);
    }


    public String getAccountNum() {
        return accountNum;
    }

    public void setAccountNum(String accountNum) {
        this.accountNum = accountNum;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public List<VehicleInfoResponse> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<VehicleInfoResponse> vehicles) {
        this.vehicles = vehicles;
    }

    public ProductInfoResponse getProductInfo() {
        if(productInfo == null) {
            if(Strings.isNullOrEmpty(accountNum)) {
                accountNum = (String) FacesUtils.getManagedBeanInSession(Constant.ACCOUNT_NUM);
            }
            String state = (String) FacesUtils.getManagedBeanInSession(Constant.WECHAT_STATE);
            if (Constant.WECHAT_STATE_PROMOTION.equalsIgnoreCase(state)) {
//                productInfo = client.getPromotionProdInfo();
                productInfo = client.getProdInfo(accountNum);
                /*prods = client.getPromotionInfo(accountNum);*/
            } else {
                productInfo = client.getProdInfo(accountNum);
                /*prods = client.getPromotionInfo(accountNum);*/
            }
            List<VehicleInfoResponse> vehicles = client.getVehicleInfo("", accountNum, "");
            if (vehicles != null && vehicles.size() > 0) {
                wifiFlag = vehicles.get(0).getWifiFlag() == 1;
            }
        }
        if(productInfo != null){
            Collections.sort(productInfo.getBaseProductList(), new Comparator<ProductInfo>() {
                @Override
                public int compare(ProductInfo o1, ProductInfo o2) {
                    int prodId1 = o1.getProdId();
                    int prodId2 = o2.getProdId();
                    return prodId1-prodId2;
                }
            });
        }
        return productInfo;
    }


    public void claanProductInfo(){
        productInfo = null;
    }




//    private String basePackageShortNameValue = null;
//    public void changeBasePackageShortName(ValueChangeEvent event) {
//        String componentId = event.getComponent().getId();
//        logger.debug("event.getComponent().getId() = " + componentId);
//        logger.debug("old value= " + event.getOldValue());
//        logger.debug("new value =  " + event.getNewValue());
//        String oldValue = (String) event.getOldValue();
//        String newValue = (String) event.getNewValue();
//        basePackageShortNameValue = newValue;
//
//        for(ProductInfo productInfo : this.productInfo.getBaseProductList()) {
//            if(productInfo.getProdShortName().equals(newValue)) {
//                if(!Strings.isNullOrEmpty(basePackageDurationValue)) {
//                    if (productInfo.getDuration() == Integer.valueOf(basePackageDurationValue)) {
//                        logger.debug("basePrice=" + basePrice);
//                        basePrice = productInfo.getPrice();
//                        logger.debug("basePromotionPrice=" + basePromotionPrice);
//                        basePromotionPrice = productInfo.getPromotionPrice();
//                    }
//                }
//            }
//        }
//    }

//    private String basePackageDurationValue = null;
//    public void changeBasePackageDuration(ValueChangeEvent event) {
//        String componentId = event.getComponent().getId();
//        logger.debug("event.getComponent().getId() = " + componentId);
//        logger.debug("old value= " + event.getOldValue());
//        logger.debug("new value =  " + event.getNewValue());
//        String oldValue = (String) event.getOldValue();
//        String newValue = (String) event.getNewValue();
//        basePackageDurationValue = newValue;
//
//        for(ProductInfo productInfo : this.productInfo.getBaseProductList()) {
//            if(productInfo.getDuration() == Integer.valueOf(newValue)) {
//                if(!Strings.isNullOrEmpty(basePackageShortNameValue)) {
//                    if (productInfo.getProdShortName().equals(basePackageShortNameValue)) {
//                        logger.debug("basePrice=" + basePrice);
//                        basePrice = productInfo.getPrice();
//                        logger.debug("basePromotionPrice=" + basePromotionPrice);
//                        basePromotionPrice = productInfo.getPromotionPrice();
//                    }
//                }
//            }
//        }
//    }

//    private String wifiPackageShortNameValue = null;
//    public void changeWifiPackageShortName(ValueChangeEvent event) {
//        String componentId = event.getComponent().getId();
//        logger.debug("event.getComponent().getId() = " + componentId);
//        logger.debug("old value= " + event.getOldValue());
//        logger.debug("new value =  " + event.getNewValue());
//        String oldValue = (String) event.getOldValue();
//        String newValue = (String) event.getNewValue();
//        wifiPackageShortNameValue = newValue;
//
//        for(ProductInfo productInfo : this.productInfo.getWifiProductList()) {
//            if(productInfo.getProdShortName().equals(newValue)) {
//                if(!Strings.isNullOrEmpty(wifiPackageDurationValue)) {
//                    if (productInfo.getDuration() == Integer.valueOf(wifiPackageDurationValue)) {
//                        logger.debug("wifiPrice=" + wifiPrice);
//                        wifiPrice = productInfo.getPrice();
//                        logger.debug("wifiPromotionPrice=" + wifiPromotionPrice);
//                        wifiPromotionPrice = productInfo.getPromotionPrice();
//                    }
//                }
//            }
//        }
//    }

//    private String wifiPackageDurationValue = null;
//    public void changeWifiPackageDuration(ValueChangeEvent event) {
//        String componentId = event.getComponent().getId();
//        logger.debug("event.getComponent().getId() = " + componentId);
//        logger.debug("old value= " + event.getOldValue());
//        logger.debug("new value =  " + event.getNewValue());
//        String oldValue = (String) event.getOldValue();
//        String newValue = (String) event.getNewValue();
//        wifiPackageDurationValue = newValue;
//
//        for(ProductInfo productInfo : this.productInfo.getWifiProductList()) {
//            if(productInfo.getDuration() == Integer.valueOf(newValue)) {
//                if(!Strings.isNullOrEmpty(wifiPackageShortNameValue)) {
//                    if (productInfo.getProdShortName().equals(wifiPackageShortNameValue)) {
//                        logger.debug("wifiPrice=" + wifiPrice);
//                        wifiPrice = productInfo.getPrice();
//                        logger.debug("wifiPromotionPrice=" + wifiPromotionPrice);
//                        wifiPromotionPrice = productInfo.getPromotionPrice();
//                    }
//                }
//            }
//        }
//    }

    public void setProductInfo(ProductInfoResponse productInfo) {
        this.productInfo = productInfo;
    }

    public VehicleInfoResponse getSelectedVehicle() {
        return selectedVehicle;
    }

    public void setSelectedVehicle(VehicleInfoResponse selectedVehicle) {
        this.selectedVehicle = selectedVehicle;
    }

    public String getWIDout_trade_no() {
        return WIDout_trade_no;
    }

    public void setWIDout_trade_no(String WIDout_trade_no) {
        this.WIDout_trade_no = WIDout_trade_no;
    }

    public String getWIDsubject() {
        return WIDsubject;
    }

    public void setWIDsubject(String WIDsubject) {
        this.WIDsubject = WIDsubject;
    }

    public double getWIDtotal_fee() {
        return WIDtotal_fee;
    }

    public void setWIDtotal_fee(double WIDtotal_fee) {
        this.WIDtotal_fee = WIDtotal_fee;
    }

    public String getWechatPrepayResponse() {
        return wechatPrepayResponse;
    }

    public void setWechatPrepayResponse(String wechatPrepayResponse) {
        this.wechatPrepayResponse = wechatPrepayResponse;
    }

    public String getWechatNotifyUrl() {
        return wechatNotifyUrl;
    }

    public void setWechatNotifyUrl(String wechatNotifyUrl) {
        this.wechatNotifyUrl = wechatNotifyUrl;
    }

    public String getWechatPayFailedUrl() {
        return wechatPayFailedUrl;
    }

    public void setWechatPayFailedUrl(String wechatPayFailedUrl) {
        this.wechatPayFailedUrl = wechatPayFailedUrl;
    }

    public boolean isTermsAgreed() {
        return termsAgreed;
    }

    public void setTermsAgreed(boolean termsAgreed) {
        this.termsAgreed = termsAgreed;
    }
    
    public String getToInvoiceEntry() {
		return toInvoiceEntry;
	}

	public void setToInvoiceEntry(String toInvoiceEntry) {
		this.toInvoiceEntry = toInvoiceEntry;
	}

	public ProductInfo getSelectedBaseProduct() {
        String state = (String) FacesUtils.getManagedBeanInSession(Constant.WECHAT_STATE);
        if(Constant.WECHAT_STATE_PROMOTION.equalsIgnoreCase(state)) {
            productInfo = client.getPromotionProdInfo();
            if (selectedBaseProduct == null && productInfo != null && productInfo.getBaseProductList().size() > 0) {
                selectedBaseProduct = productInfo.getBaseProductList().get(0);
            }
        }
        return selectedBaseProduct;
    }

    public void setSelectedBaseProduct(ProductInfo selectedBaseProduct) {
        this.selectedBaseProduct = selectedBaseProduct;
    }

//    public String getSelectBasePackageShortName() {
//        return selectBasePackageShortName;
//    }
//
//    public void setSelectBasePackageShortName(String selectBasePackageShortName) {
//        this.selectBasePackageShortName = selectBasePackageShortName;
//    }
//
//    public String getSelectBasePackageDuration() {
//        return selectBasePackageDuration;
//    }
//
//    public void setSelectBasePackageDuration(String selectBasePackageDuration) {
//        this.selectBasePackageDuration = selectBasePackageDuration;
//    }
//
//    public String getSelectWifiPackageShortName() {
//        return selectWifiPackageShortName;
//    }
//
//    public void setSelectWifiPackageShortName(String selectWifiPackageShortName) {
//        this.selectWifiPackageShortName = selectWifiPackageShortName;
//    }
//
//    public String getSelectWifiPackageDuration() {
//        return selectWifiPackageDuration;
//    }
//
//    public void setSelectWifiPackageDuration(String selectWifiPackageDuration) {
//        this.selectWifiPackageDuration = selectWifiPackageDuration;
//    }
//
//    public List<SelectItem> getSelectBasePackageShortNameItem() {
//        return selectBasePackageShortNameItem;
//    }
//
//    public void setSelectBasePackageShortNameItem(List<SelectItem> selectBasePackageShortNameItem) {
//        this.selectBasePackageShortNameItem = selectBasePackageShortNameItem;
//    }
//
//    public List<SelectItem> getSelectBasePackageDurationItem() {
//        return selectBasePackageDurationItem;
//    }
//
//    public void setSelectBasePackageDurationItem(List<SelectItem> selectBasePackageDurationItem) {
//        this.selectBasePackageDurationItem = selectBasePackageDurationItem;
//    }

    public ProductInfo getSelectedWifiProduct() {
        return selectedWifiProduct;
    }

    public void setSelectedWifiProduct(ProductInfo selectedWifiProduct) {
        this.selectedWifiProduct = selectedWifiProduct;
    }

//    public double getBasePrice() {
//        return basePrice;
//    }
//
//    public void setBasePrice(double basePrice) {
//        this.basePrice = basePrice;
//    }
//
//    public List<SelectItem> getSelectWifiPackageShortNameItem() {
//        return selectWifiPackageShortNameItem;
//    }
//
//    public void setSelectWifiPackageShortNameItem(List<SelectItem> selectWifiPackageShortNameItem) {
//        this.selectWifiPackageShortNameItem = selectWifiPackageShortNameItem;
//    }
//
//    public List<SelectItem> getSelectWifiPackageDurationItem() {
//        return selectWifiPackageDurationItem;
//    }
//
//    public void setSelectWifiPackageDurationItem(List<SelectItem> selectWifiPackageDurationItem) {
//        this.selectWifiPackageDurationItem = selectWifiPackageDurationItem;
//    }
//
//    public double getWifiPrice() {
//        return wifiPrice;
//    }
//
//    public void setWifiPrice(double wifiPrice) {
//        this.wifiPrice = wifiPrice;
//    }
//
//    public double getBasePromotionPrice() {
//        return basePromotionPrice;
//    }
//
//    public void setBasePromotionPrice(double basePromotionPrice) {
//        this.basePromotionPrice = basePromotionPrice;
//    }
//
//    public double getWifiPromotionPrice() {
//        return wifiPromotionPrice;
//    }
//
//    public void setWifiPromotionPrice(double wifiPromotionPrice) {
//        this.wifiPromotionPrice = wifiPromotionPrice;
//    }

    public boolean isWifiFlag() {
        return wifiFlag;
    }

    public void setWifiFlag(boolean wifiFlag) {
        this.wifiFlag = wifiFlag;
    }

    public String toAlipay() throws Exception {
        try {
            //        FacesContext context = FacesContext.getCurrentInstance();
            //        Map<String, String> requestParams = context.getExternalContext().getRequestParameterMap();

            //支付宝网关地址
            String ALIPAY_GATEWAY_NEW = "http://wappaygw.alipay.com/service/rest.htm?";

            ////////////////////////////////////调用授权接口alipay.wap.trade.create.direct获取授权码token//////////////////////////////////////

            //返回格式
            String format = "xml";
            //必填，不需要修改

            //返回格式
            String v = "2.0";
            //必填，不需要修改

            //请求号
            String req_id = UtilDate.getOrderNum();
            //必填，须保证每次请求都是唯一

            //req_data详细信息

            //服务器异步通知页面路径
            String notify_url = ConfigureInfo.getAlipayNotifyUrl();
            //需http://格式的完整路径，不能加?id=123这类自定义参数

            //页面跳转同步通知页面路径
            String call_back_url = ConfigureInfo.getAlipayCallbackUrl();
            //需http://格式的完整路径，不能加?id=123这类自定义参数，不能写成http://localhost/

            //操作中断返回地址
            String merchant_url = ConfigureInfo.getAlipayPayFailedUrl();
            //用户付款中途退出返回商户的地址。需http://格式的完整路径，不允许加?id=123这类自定义参数

            //商户订单号
            //        String out_trade_no = new String(request.getParameter("WIDout_trade_no").getBytes("ISO-8859-1"),"UTF-8");
            String out_trade_no = new String(FacesUtils.getRequestParameter("WIDout_trade_no").getBytes("ISO-8859-1"),"UTF-8");

            //商户网站订单系统中唯一订单号，必填

            //订单名称
            //        String subject = new String(request.getParameter("WIDsubject").getBytes("ISO-8859-1"),"UTF-8");
            String subject = new String(FacesUtils.getRequestParameter("WIDsubject").getBytes("ISO-8859-1"),"UTF-8");
            //必填

            //付款金额
            //        String total_fee = new String(request.getParameter("WIDtotal_fee").getBytes("ISO-8859-1"),"UTF-8");
            String total_fee = new String(FacesUtils.getRequestParameter("WIDtotal_fee").getBytes("ISO-8859-1"),"UTF-8");

            //必填

            //请求业务参数详细
            String req_dataToken = "<direct_trade_create_req><notify_url>" + notify_url + "</notify_url><call_back_url>" + call_back_url + "</call_back_url><seller_account_name>" + AlipayConfig.seller_email + "</seller_account_name><out_trade_no>" + out_trade_no + "</out_trade_no><subject>" + subject + "</subject><total_fee>" + total_fee + "</total_fee><merchant_url>" + merchant_url + "</merchant_url></direct_trade_create_req>";
            //必填

            //////////////////////////////////////////////////////////////////////////////////

            //把请求参数打包成数组
            Map<String, String> sParaTempToken = new HashMap<String, String>();
            sParaTempToken.put("service", "alipay.wap.trade.create.direct");
            sParaTempToken.put("partner", AlipayConfig.partner);
            sParaTempToken.put("_input_charset", AlipayConfig.input_charset);
            sParaTempToken.put("sec_id", AlipayConfig.sign_type);
            sParaTempToken.put("format", format);
            sParaTempToken.put("v", v);
            sParaTempToken.put("req_id", req_id);
            sParaTempToken.put("req_data", req_dataToken);


            //建立请求
            String sHtmlTextToken = AlipaySubmit.buildRequest(ALIPAY_GATEWAY_NEW, "", "", sParaTempToken);
            //URLDECODE返回的信息
            sHtmlTextToken = URLDecoder.decode(sHtmlTextToken, AlipayConfig.input_charset);
            //获取token
            String request_token = AlipaySubmit.getRequestToken(sHtmlTextToken);
            //out.println(request_token);

            ////////////////////////////////////根据授权码token调用交易接口alipay.wap.auth.authAndExecute//////////////////////////////////////

            //业务详细
            String req_data = "<auth_and_execute_req><request_token>" + request_token + "</request_token></auth_and_execute_req>";
            //必填

            //把请求参数打包成数组
            Map<String, String> sParaTemp = new HashMap<String, String>();
            sParaTemp.put("service", "alipay.wap.auth.authAndExecute");
            sParaTemp.put("partner", AlipayConfig.partner);
            sParaTemp.put("_input_charset", AlipayConfig.input_charset);
            sParaTemp.put("sec_id", AlipayConfig.sign_type);
            sParaTemp.put("format", format);
            sParaTemp.put("v", v);
            sParaTemp.put("req_data", req_data);

            //建立请求
            String sHtmlText = AlipaySubmit.buildRequest(ALIPAY_GATEWAY_NEW, sParaTemp, "get", "确认");
//            out.println(sHtmlText);
            alipayRequest = sHtmlText;
            FacesUtils.getServletResponse().getWriter().println(sHtmlText);


        } catch (Exception e) {
            e.printStackTrace();
        }

//        return ViewPage.LINK2OrderAlipayRequest;
        return "";
    }
    
    /* 2017-11-10,Tommy Liu, CR82_Part II, 进入套餐升级页面 */
    public String toOrderUpgradeEntry(PackageInfoResponse currentPkg, AccountInfoResponse accountInfo, String openId, String fromFlag) {
    	this.accountInfo = accountInfo;
    	this.openId = openId;
    	this.targetPage = ViewPage.LINK2MyAccount;//支付成功后点击登陆进入的界面
    	
        String errorReturn = ViewPage.LINK2MyAccount;
        if("2".equals(fromFlag)){
        	errorReturn = ViewPage.LINK2MyAccount2;
        }

        FacesContext context = FacesContext.getCurrentInstance();
        if(!validateToBeUpgratedPkgSelection()){
        	return errorReturn;
        }else{
          paymentPlatform = (String) FacesUtils.getManagedBeanInSession(Constant.PAYMENT_PLATFORM);
//            paymentPlatform = Constant.DB_ORDER_PAYMENT_TYPE_WEIXINPAY;//通过浏览器临时测试时使用
        	upgradeRequest =new PackageUpgradeRequest();
        	upgradeRequest.setAccountNum(accountInfo.getAccountNum());
        	upgradeRequest.setVin(accountInfo.getVin());
        	upgradeRequest.setStartDate(currentPkg.getStartDate());
        	upgradeRequest.setEndDate(currentPkg.getEndDate());
        	upgradeRequest.setOriginalPackageName(currentPkg.getPackageName());
        	upgradeRequest.setOriginalPackageState(currentPkg.getPackageStatus());
        	upgradeRequest.setWebSubscriptionId(currentPkg.getWebSubscriptionId());
        	upgradeRequest.setPaymentChannel(paymentPlatform);
        	upgradeRequest.setOpenId(openId);
        	upgradeResponse = PaymentServiceClient.getInstance().getNewPackageAfterUpgrade(upgradeRequest);
        	if(!Constant.SERVICE_B2C_PAYMENT_RESPONSE_CODE_SUCCESS.equals(upgradeResponse.getRespCode())){
        		myAccountPop = upgradeResponse.getRespMsg() +
                        "请确认信息后再次尝试。如果有任何疑问请按车内 【i】按钮或" +
                        "拨打400-898-0050联系在线客服，谢谢！";
        		context.addMessage(null, new FacesMessage(
                        FacesMessage.SEVERITY_ERROR, upgradeResponse.getRespMsg() +
                        "请确认信息后再次尝试。如果有任何疑问请按车内 【i】按钮或" +
                        "拨打400-898-0050联系在线客服，谢谢！", ""));
        		return errorReturn;
        	}
        	upgradeRequest.setOriginalPackageId(upgradeResponse.getOriginalPackageId());
        	upgradeRequest.setOriginalPrice(upgradeResponse.getOriginalPrice());
        	upgradeRequest.setOriginalServiceOrderNum(upgradeResponse.getOriginalServiceOrderNum());
        	upgradeRequest.setNewPackageId(upgradeResponse.getNewPackageId());
        	upgradeRequest.setNewPackageName(upgradeResponse.getNewPackageName());
        	upgradeRequest.setUpgradeGapPrice(upgradeResponse.getUpgradeGapPrice());
        	upgradeRequest.setCalculateByActivePkg(upgradeResponse.isCalculateByActivePkg());
        	
        }
        return ViewPage.LINK2OrderPackageUpgrade;
    }
    
    private boolean validateToBeUpgratedPkgSelection() {
    	logger.debug("validating to be upgrated package selection...");
    	FacesContext context = FacesContext.getCurrentInstance();
    	if(accountInfo==null || Strings.isNullOrEmpty(accountInfo.getAccountNum()) && Strings.isNullOrEmpty(accountInfo.getVin())) {
    		myAccountPop = "非常抱歉，根据您的输入条件没有找到您的账户信息，" +
                    "请确认信息后再次尝试。如果有任何疑问请按车内 【i】按钮或" +
                    "拨打400-898-0050联系在线客服，谢谢！";
            context.addMessage(null, new FacesMessage(
                    FacesMessage.SEVERITY_ERROR, "非常抱歉，根据您的输入条件没有找到您的账户信息，" +
                    "请确认信息后再次尝试。如果有任何疑问请按车内 【i】按钮或" +
                    "拨打400-898-0050联系在线客服，谢谢！", ""));
            return false;
        }
    	logger.info("accountNum=" + ESAPI.encoder().encodeForHTML(accountInfo.getAccountNum()));
        logger.info("vin=" + ESAPI.encoder().encodeForHTML(accountInfo.getVin()));
        if (accountInfo.getAccountNum().indexOf("*") > -1 || accountInfo.getVin().indexOf("*") > -1)
        {
        	myAccountPop = "如您对默认信息进行了修改，请输入完整信息不要包含*号";
            context.addMessage(null, new FacesMessage(
                    FacesMessage.SEVERITY_ERROR, "如您对默认信息进行了修改，请输入完整信息不要包含*号", ""));
            return false;
        }
        vehicles = new ArrayList<VehicleInfoResponse>();
        vehicles = client.getVehicleInfo(accountInfo.getVin(), "", "");
        if(vehicles == null || vehicles.size() == 0) {
        	myAccountPop = "非常抱歉，根据您的输入条件没有找到您的爱车，" +
                    "请确认信息后再次尝试。如果有任何疑问请按车内 【i】按钮或" +
                    "拨打<span style=\"text-decoration: underline;\" class=\"span2\">400-898-0050</span>联系在线客服，谢谢！";
            context.addMessage(null, new FacesMessage(
                    FacesMessage.SEVERITY_ERROR, "非常抱歉，根据您的输入条件没有找到您的爱车，" +
                    "请确认信息后再次尝试。如果有任何疑问请按车内 【i】按钮或" +
                    "拨打400-898-0050联系在线客服，谢谢！", ""));
            return false;
        }

        selectedVehicle = vehicles.get(0);
        
        return true;
    }
    
    /* 2017-11-10,Tommy Liu, CR82_Part II, 进入套餐 确认升级 页面 */
    public String toOrderUpgradePayment() {
        FacesContext context = FacesContext.getCurrentInstance();

        // create upgrade order
        logger.debug("creating upgrade order...");
       
        String oId = (String) FacesUtils.getManagedBeanInSession(Constant.OPEN_ID);
        logger.info("upgrade....original PkgId  == "+ESAPI.encoder().encodeForHTML(upgradeResponse.getOriginalPackageId()));
        logger.info("upgrade....new PkgId  == "+ESAPI.encoder().encodeForHTML(upgradeResponse.getNewPackageId()));
        logger.info("upgrade...gap price =="+ESAPI.encoder().encodeForHTML(String.valueOf(upgradeResponse.getUpgradeGapPrice())));
        logger.info("paymentPlatform ==>"+ESAPI.encoder().encodeForHTML(paymentPlatform));
        logger.info("oId ==>"+ESAPI.encoder().encodeForHTML(oId));
        /*PackageUpgradeResponse paymentOrderResponse = client.createPaymentOrder(
                sProdId,
                sProdPrice,
                sPkgId,
                String.valueOf(selectedVehicle.getAcctNum()),
                selectedVehicle.getVin(),
                paymentPlatform,
                oId
        );*/
        upgradeResponse = client.createUpgradePaymentOrder(upgradeRequest);
        
        // if create new order failed
        if(!upgradeResponse.getRespCode().equals(Constant.SERVICE_B2C_PAYMENT_RESPONSE_CODE_SUCCESS)) {
            /*orderAccountInfoPop = "创建订单失败，原因："+paymentOrderResponse.getRespMsg()+"请重试或致电400-898-0050联系梅赛德斯-奔驰智能互联服务中心寻求帮助";*/
            context.addMessage(null, new FacesMessage(
                    FacesMessage.SEVERITY_ERROR, "创建订单失败，原因：" + upgradeResponse.getRespMsg(), ""));
            /*return ViewPage.LINK2OrderAccountInfo;*/
            orderUpgradePop = "创建订单失败，原因："+upgradeResponse.getRespMsg()+"请重试或致电<span style=\"text-decoration: underline;\" class=\"span2\">400-898-0050</span>联系梅赛德斯-奔驰智能互联服务中心寻求帮助";
            return ViewPage.LINK2OrderPackageUpgrade;
        }

        // create transaction
        String transactionNo = getTransactionNo();
        String serialNo = getSerialNo();
        String transChannel = null;
        if(isWechatPay()) {
            transChannel = "03";
        } else if(isAlipay()) {
            transChannel = "04";
        }
        double amount = upgradeRequest.getUpgradeGapPrice();
        String orderDesc = upgradeRequest.getNewPackageName();
       
        TransactionRequest transactionRequest = new TransactionRequest();
        transactionRequest.setAmoumt(String.valueOf(amount));
        transactionRequest.setChannel(transChannel);
        transactionRequest.setOrderDescription(orderDesc);
        transactionRequest.setPaymentno(transactionNo);
        transactionRequest.setRemark("微信支付，OpenID:" + FacesUtils.getManagedBeanInSession(Constant.OPEN_ID));
        transactionRequest.setRespcode("00A4");
        transactionRequest.setResponse("已下单，等待支付");
        transactionRequest.setSeraialno(serialNo);
        logger.debug("creating transaction");
        TransactionResponse transactionResponse = client.createTransaction(upgradeResponse.getUpgratedParentOrderNum(), transactionRequest);;
        if(!transactionResponse.getRespcode().equals(Constant.SERVICE_B2C_PAYMENT_RESPONSE_CODE_SUCCESS)) {
            logger.error("create new transaction failed, error message: " + ESAPI.encoder().encodeForHTML(transactionResponse.getRespMsg()));
            /*orderAccountInfoPop = "创建交易失败，原因：" + transactionResponse.getRespMsg();*/
            context.addMessage(null, new FacesMessage(
                    FacesMessage.SEVERITY_ERROR, "创建交易失败，原因：" + transactionResponse.getRespMsg()+"<br>请重试或致电<span class='span2'>400-898-0050</span>联系<br>梅赛德斯-奔驰智能互联<br>服务中心寻求帮助", ""));
            /*return ViewPage.LINK2OrderAccountInfo;*/
            orderUpgradePop = "创建订单失败，原因："+transactionResponse.getRespMsg()+"请重试或致电<span style=\"text-decoration: underline;\" class=\"span2\">400-898-0050</span>联系梅赛德斯-奔驰智能互联服务中心寻求帮助";
            return ViewPage.LINK2OrderPackageUpgrade;

        }

        if(isWechatPay()) {
            // Do not need the rest
            WxPayDto tpWxPay = new WxPayDto();
            Demo demo = new Demo();
            tpWxPay.setOpenId((String) FacesUtils.getManagedBeanInSession(Constant.OPEN_ID));
//            logger.debug("open_id=" + ESAPI.encoder().encodeForHTML(FacesUtils.getManagedBeanInSession(Constant.OPEN_ID).toString()));
            tpWxPay.setBody(orderDesc);
            logger.debug("prodName=" + ESAPI.encoder().encodeForHTML(orderDesc));
//                tpWxPay.setOrderId(paymentOrderResponse.getOrderNum());
            tpWxPay.setOrderId(transactionNo+upgradeResponse.getUpgratedParentOrderNum());
            logger.debug("orderId=" + ESAPI.encoder().encodeForHTML(transactionNo+upgradeResponse.getUpgratedParentOrderNum()));
            tpWxPay.setSpbillCreateIp("127.0.0.1");
            tpWxPay.setTotalFee(String.valueOf(amount));
            logger.debug("totalFee=" + ESAPI.encoder().encodeForHTML(String.valueOf(amount)));
            wechatPrepayResponse = demo.getPackage(tpWxPay);
            logger.info("wechatPrepayResponse=" + ESAPI.encoder().encodeForHTML(wechatPrepayResponse));
//            System.out.println("wechatPrepayResponse=" + wechatPrepayResponse);
        }

        // setting order information
        WIDout_trade_no = transactionNo+upgradeResponse.getUpgratedParentOrderNum();
        WIDsubject = orderDesc;
        WIDtotal_fee = amount;
        //CR389 lucky draw
        hasLuckyDrawLink = client.hasLuckyDrawLink(WIDout_trade_no.substring(13));

        return ViewPage.LINK2OrderUpgradePayment;
    }

    public String getAlipayRequest() {
        return alipayRequest;
    }

    public void setAlipayRequest(String alipayRequest) {
        this.alipayRequest = alipayRequest;
    }

    public String getOpenId(){return openId;}

    public void setOpenId(String openId){this.openId = openId;}

    public String getTargetPage(){return targetPage;}

    public void setTargetPage(String targetPage){this.targetPage = targetPage;}


    public String getOrderPackagePop() {
        String temp = orderPackagePop;
        orderPackagePop = null;
        return temp;
    }

    public void setOrderPackagePop(String orderPackagePop) {
        this.orderPackagePop = orderPackagePop;
    }

    public String getOrderEntryPop() {
        productInfo = null;
        String temp = orderEntryPop;
        orderEntryPop = null;
        return temp;
    }

    public void setOrderEntryPop(String orderEntryPop) {
        this.orderEntryPop = orderEntryPop;
    }

    public String getOrderVehiclePop() {
        String temp = orderVehiclePop;
        orderVehiclePop = null;
        return temp;
    }

    public void setOrderVehiclePop(String orderVehiclePop) {
        this.orderVehiclePop = orderVehiclePop;
    }

    public String getOrderAccountInfoPop() {
        String temp = orderAccountInfoPop;
        orderAccountInfoPop = null;
        return temp;
    }

    public void setOrderAccountInfoPop(String orderAccountInfoPop) {
        this.orderAccountInfoPop = orderAccountInfoPop;
    }
    
    public String getMyAccountPop() {
    	String temp = myAccountPop;
    	myAccountPop = null;
        return temp;
	}

	public void setMyAccountPop(String myAccountPop) {
		this.myAccountPop = myAccountPop;
	}

	public String getOrderUpgradePop() {
		String temp = orderUpgradePop;
		orderUpgradePop = null;
        return temp;
	}

	public void setOrderUpgradePop(String orderUpgradePop) {
		this.orderUpgradePop = orderUpgradePop;
	}

	public String getSelectVin() {
        return selectVin;
    }

    public void setSelectVin(String selectVin) {
        this.selectVin = selectVin;
    }

    public List<PromotionInfoResponse> getProd() {
        logger.info("getProds");
        if(Strings.isNullOrEmpty(accountNum)) {
            accountNum = (String) FacesUtils.getManagedBeanInSession(Constant.ACCOUNT_NUM);
        }
        String state = (String) FacesUtils.getManagedBeanInSession(Constant.WECHAT_STATE);
        if (Constant.WECHAT_STATE_PROMOTION.equalsIgnoreCase(state)) {
            prods = client.getPromotionInfo(accountNum);
        } else {
            prods = client.getPromotionInfo(accountNum);
        }
        List<VehicleInfoResponse> vehicles = client.getVehicleInfo("", accountNum, "");
        if (vehicles != null && vehicles.size() > 0) {
            wifiFlag = vehicles.get(0).getWifiFlag() == 1;
        }
        /*prods = initProds();*/
        return prods;
    }

    public List<PromotionInfoResponse> getProds(){
        /*prods = initProds();*/
        return prods;
    }
    
    /*public List<PromotionInfoResponse> initProds(){
        List<PromotionInfoResponse> prods = new ArrayList<>();
        PromotionInfoResponse promotionInfoResponse1 = new PromotionInfoResponse();
        promotionInfoResponse1.setProductCategoryName("测试一级菜单1");
        PromotionInfoResponse promotionInfoResponse3 = new PromotionInfoResponse();
        promotionInfoResponse3.setProductCategoryName("测试一级菜单3");
        PromotionInfoResponse promotionInfoResponse4 = new PromotionInfoResponse();
        promotionInfoResponse4.setProductCategoryName("测试一级菜单4");
        PromotionInfoResponse promotionInfoResponse2 = new PromotionInfoResponse();
        promotionInfoResponse2.setProductCategoryName("测试一级菜单2");
        List<PromotionCategoryResult> productCategoryLists1 = new ArrayList<>();
        List<PromotionCategoryResult> productCategoryLists2 = new ArrayList<>();
        List<PromotionCategoryResult> productCategoryLists3 = new ArrayList<>();
        PromotionCategoryResult productCategoryList1 = new PromotionCategoryResult();
        productCategoryList1.setPromotionCategoryName("二级测试菜单1");
        PromotionCategoryResult productCategoryList2 = new PromotionCategoryResult();
        productCategoryList2.setPromotionCategoryName("二级测试菜单2");
        PromotionCategoryResult productCategoryList3 = new PromotionCategoryResult();
        productCategoryList3.setPromotionCategoryName("二级测试菜单3");
        PromotionCategoryResult productCategoryList4 = new PromotionCategoryResult();
        productCategoryList4.setPromotionCategoryName("二级测试菜单4");
        PromotionCategoryResult productCategoryList5 = new PromotionCategoryResult();
        productCategoryList5.setPromotionCategoryName("二级测试菜单5");
        List<PromotionInfoWS> promotionCategoryLists1 = new ArrayList<>();
        List<PromotionInfoWS> promotionCategoryLists2 = new ArrayList<>();
        List<PromotionInfoWS> promotionCategoryLists3 = new ArrayList<>();
        List<PromotionInfoWS> promotionCategoryLists4 = new ArrayList<>();
        for(int i=1; i<=8; i++){
            PromotionInfoWS promotionInfoWS = new PromotionInfoWS();
            promotionInfoWS.setMarketName("测试包"+i);
            promotionInfoWS.setPkgId("00"+i);
            promotionInfoWS.setPromotionDesc1A(i+"折扣1A");
            promotionInfoWS.setPromotionDesc1B("送"+i+"G1B");
            promotionInfoWS.setPromotionDesc2("测试包"+i+"描述2");
            promotionInfoWS.setPromotionDesc3("测试包"+i+"描述3");
            promotionInfoWS.setPromotionDesc4("测试包"+i+"描述4");
            promotionInfoWS.setPromotionDesc5A(i+"元5A");
            promotionInfoWS.setPromotionDesc5B(i+"元5B");
            promotionInfoWS.setPromotionDesc6("测试包"+i+"描述6");
            if(i == 1 || i == 2){
                promotionCategoryLists1.add(promotionInfoWS);
            }
            if(i == 3 || i == 4){
                promotionCategoryLists2.add(promotionInfoWS);
            }
            if(i == 5 || i == 6){
                promotionCategoryLists3.add(promotionInfoWS);
            }
            if(i == 7 || i == 8){
                promotionCategoryLists4.add(promotionInfoWS);
            }
        }


        productCategoryList1.setPromotionCategoryList(promotionCategoryLists1);
        productCategoryList2.setPromotionCategoryList(promotionCategoryLists2);
        productCategoryList3.setPromotionCategoryList(promotionCategoryLists3);
        productCategoryList4.setPromotionCategoryList(promotionCategoryLists4);
        productCategoryLists1.add(productCategoryList1);
        *//*productCategoryLists1.add(productCategoryList2);*//*
        productCategoryLists2.add(productCategoryList3);
        productCategoryLists2.add(productCategoryList4);
        productCategoryLists2.add(productCategoryList5);
        promotionInfoResponse1.setProductCategoryList(productCategoryLists1);
        promotionInfoResponse1.setProductCategoryId("1");
        promotionInfoResponse2.setProductCategoryList(productCategoryLists2);
        promotionInfoResponse3.setProductCategoryList(productCategoryLists3);
        promotionInfoResponse2.setProductCategoryId("3");
        promotionInfoResponse3.setProductCategoryId("4");
        promotionInfoResponse4.setProductCategoryId("5");
        prods.add(promotionInfoResponse1);
        prods.add(promotionInfoResponse2);
        *//*prods.add(promotionInfoResponse3);*//*

        return prods;
    }*/

    public void setProds(List<PromotionInfoResponse> prods) {
        this.prods = prods;
    }

    public String getSelectProdId() {
        return selectProdId;
    }

    public void setSelectProdId(String selectProdId) {
        this.selectProdId = selectProdId;
    }

    public PromotionInfoWS getSelectProd() {
        return selectProd;
    }

    public void setSelectProd(PromotionInfoWS selectProd) {
        this.selectProd = selectProd;
    }

    public String getsPkgId() {
        return sPkgId;
    }

    public void setsPkgId(String sPkgId) {
        this.sPkgId = sPkgId;
    }

	public PackageUpgradeResponse getUpgradeResponse() {
		return upgradeResponse;
	}

	public void setUpgradeResponse(PackageUpgradeResponse upgradeResponse) {
		this.upgradeResponse = upgradeResponse;
	}

	public PackageUpgradeRequest getUpgradeRequest() {
		return upgradeRequest;
	}

	public void setUpgradeRequest(PackageUpgradeRequest upgradeRequest) {
		this.upgradeRequest = upgradeRequest;
	}
    
    //add by liuning CR345 20171023 begin

    public String toOrderPaymentForWechat(String parentOrderNum,String accountNum,String openId) {
        FacesContext context = FacesContext.getCurrentInstance();

        String orderDescs = "";
        String orderIds = "";
        String transactionType = "0";
//        List<Transaction> list = client.checkTransactionPaied(transactionNos.get(0));
        QueryOrderByParentOrderNumResponse queryOrderByParentOrderNumResponse = client.queryOrderByParentOrderNum(parentOrderNum,accountNum);
        List<QueryChildOrdersByParentOrderNumResponse> orders = client.queryChildOrdersByParentOrderNum(parentOrderNum);
        if (orders == null || orders.size() == 0) {
            //没创建订单
            transactionType = "1";
        }else{
            if (!queryOrderByParentOrderNumResponse.getOrderStatus().equals(Constant.DB_ORDER_STATUS_NEW)
                    &&!queryOrderByParentOrderNumResponse.getOrderStatus().equals(Constant.DB_ORDER_STATUS_PENDING_PAYMENT)
                    &&!queryOrderByParentOrderNumResponse.getOrderStatus().equals(Constant.DB_ORDER_STATUS_PAYMENT_FAILED)
                    &&!queryOrderByParentOrderNumResponse.getOrderStatus().equals(Constant.DB_ORDER_STATUS_PAYMENT_CANCELED)) {
                //订单已支付
                transactionType = "2";
            }
            if (queryOrderByParentOrderNumResponse.getOrderStatus().equals(Constant.DB_ORDER_STATUS_PAYMENT_CANCELED)) {
                //订单失效关闭
                transactionType = "3";
            }
            if(queryOrderByParentOrderNumResponse.getOrderStatus().equals(Constant.DB_ORDER_STATUS_PENDING_PAYMENT)){
                //订单待支付
                transactionType = "4";
            }
            if(queryOrderByParentOrderNumResponse.getOrderStatus().equals(Constant.DB_ORDER_STATUS_PAYMENT_FAILED)){
                //订单支付失败
                transactionType = "5";
            }
            if(queryOrderByParentOrderNumResponse.getOrderStatus().equals(Constant.DB_ORDER_STATUS_NEW)){
                //新订单
                transactionType = "6";
            }
        }
        logger.info("TranactionType================>"+transactionType);
        if("1".equals(transactionType)) {
          this.openId=openId;
          return ViewPage.ERRORMESSAGE;
        }
        if("6".equals(transactionType)){
            String transactionNo = getTransactionNo();
            client.updateOrderStatus(parentOrderNum, transactionNo, openId);
            String orderDesc = "";
            for (QueryChildOrdersByParentOrderNumResponse queryChildOrdersByParentOrderNumResponse : orders) {
                if (Strings.isNullOrEmpty(orderDesc)) {
                    orderDesc += queryChildOrdersByParentOrderNumResponse.getShortMarketName();
                } else {
                    orderDesc += "和" + queryChildOrdersByParentOrderNumResponse.getShortMarketName();
                }
            }
            String serialNo = getSerialNo();
            String transChannel = null;
            transChannel = "03";
            double amount = 0;
            amount = queryOrderByParentOrderNumResponse.getPrice();

            TransactionRequest transactionRequest = new TransactionRequest();
            transactionRequest.setAmoumt(String.valueOf(amount));
            transactionRequest.setChannel(transChannel);
            transactionRequest.setOrderDescription(orderDesc);
            transactionRequest.setPaymentno(transactionNo);
            transactionRequest.setRemark("微信支付，OpenID:" + openId);
            transactionRequest.setRespcode("00A4");
            transactionRequest.setResponse("已下单，等待支付");
            transactionRequest.setSeraialno(serialNo);
            logger.debug("creating transaction");
            TransactionResponse transactionResponse = client.createTransaction(parentOrderNum, transactionRequest);
            ;
            if (!transactionResponse.getRespcode().equals(Constant.SERVICE_B2C_PAYMENT_RESPONSE_CODE_SUCCESS)) {
//                  logger.error("create new transaction failed, error message: " + ESAPI.encoder().encodeForHTML(transactionResponse.getRespMsg()));
//                  context.addMessage(null, new FacesMessage(
//                          FacesMessage.SEVERITY_ERROR, "创建交易失败，原因：" + transactionResponse.getRespMsg() + "<br>请重试或致电<span class='span2'>400-898-0050</span>联系<br>梅赛德斯-奔驰智能互联<br>服务中心寻求帮助", ""));
                orderPackagePop = "创建订单失败，原因：" + transactionResponse.getRespMsg() + "请重试或致电<span style=\"text-decoration: underline;\" class=\"span2\">400-898-0050</span>联系梅赛德斯-奔驰智能互联服务中心寻求帮助";
                return ViewPage.LINK2OrderPackage0;

            }
      }
      if("4".equals(transactionType)||"5".equals(transactionType)){
          List<Transaction> transactionList = client.getTransactionByOrderNum(parentOrderNum);
          client.updateOrderStatus(parentOrderNum, transactionList.get(0).getOrderno(), openId);
          client.updateTransaction(parentOrderNum,openId);
      }

        //订单创建完毕
        if(orders!=null&&orders.size()>0){
            String packageName1 = "";
            String packageName2 = "";
            for(QueryChildOrdersByParentOrderNumResponse serviceOrderForQuery:orders){
                if(serviceOrderForQuery.getPrice()>0){
                    if("".equals(packageName1)) {
                        packageName1 = serviceOrderForQuery.getMarketName();
                    }else{
                        packageName2 = "和"+serviceOrderForQuery.getMarketName();
                    }
                }
            }

            orderDescs = packageName1+packageName2;
            List<Transaction> transactionList = client.getTransactionByOrderNum(parentOrderNum);
            orderIds = transactionList.get(0).getOrderno()+parentOrderNum;

        }
        //页面显示需要
        PromotionInfoWS promotionInfoWS = new PromotionInfoWS();
        promotionInfoWS.setShortMarketName(orderDescs);
        promotionInfoWS.setPromotionPrice(queryOrderByParentOrderNumResponse.getPrice());
        selectProd = promotionInfoWS;
        accountInfo = client.getCurrentAccountInfo(accountNum);
        VehicleInfoResponse vehicleInfoResponse = new VehicleInfoResponse();
        vehicleInfoResponse.setName(accountInfo.getFullName());
        vehicleInfoResponse.setAcctNum(Integer.valueOf(accountNum));
        vehicleInfoResponse.setCellphone(accountInfo.getMobilePhone());
        vehicleInfoResponse.setVin(accountInfo.getVin());
        selectedVehicle = vehicleInfoResponse;
//        if("0".equals(transactionType)){
//            return ViewPage.ERRORMESSAGE;
//        }
        if("2".equals(transactionType)){
            this.openId=openId;
            return ViewPage.HASBEENPAIED;
        }
        else if("3".equals(transactionType)){
            this.openId=openId;
            return ViewPage.HASBEENCANCELED;
        }
        logger.info("orderIds=================" + orderIds);
        logger.info("orderDescs=================" + orderDescs);
        WxPayDto tpWxPay = new WxPayDto();
        Demo demo = new Demo();
        tpWxPay.setOpenId(openId);
        tpWxPay.setOrderId(orderIds);
        tpWxPay.setBody(orderDescs);
        tpWxPay.setSpbillCreateIp("127.0.0.1");
        tpWxPay.setTotalFee(String.valueOf(queryOrderByParentOrderNumResponse.getPrice()));
        logger.debug("totalFee=" + ESAPI.encoder().encodeForHTML(String.valueOf(queryOrderByParentOrderNumResponse.getPrice())));
        wechatPrepayResponse = demo.getPackage(tpWxPay);
        WIDout_trade_no = orderIds;
        WIDsubject = orderDescs;
        WIDtotal_fee = queryOrderByParentOrderNumResponse.getPrice();
        //CR389 lucky draw
        hasLuckyDrawLink = client.hasLuckyDrawLink(WIDout_trade_no.substring(13));

        return ViewPage.LINK2OrderPaymentForWechat;
    }
    //add by liunig CR345 20171023 end

    public int getHasLuckyDrawLink() {
        return hasLuckyDrawLink;
    }

    public void setHasLuckyDrawLink(int hasLuckyDrawLink) {
        this.hasLuckyDrawLink = hasLuckyDrawLink;
    }
}
