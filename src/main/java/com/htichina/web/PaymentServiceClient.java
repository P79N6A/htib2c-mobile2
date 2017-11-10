package com.htichina.web;

import java.util.List;

import org.apache.log4j.Logger;

import com.htichina.common.web.Constant;
import com.htichina.wsclient.payment.AccountInfoResponse;
import com.htichina.wsclient.payment.InvoiceInfoRequest;
import com.htichina.wsclient.payment.PackageUpgradeRequest;
import com.htichina.wsclient.payment.PackageUpgradeResponse;
import com.htichina.wsclient.payment.PaymentOrderResponse;
import com.htichina.wsclient.payment.PaymentResponse;
import com.htichina.wsclient.payment.PaymentResultMessage;
import com.htichina.wsclient.payment.PaymentService;
import com.htichina.wsclient.payment.PaymentServiceService;
import com.htichina.wsclient.payment.ProductInfoResponse;
import com.htichina.wsclient.payment.PromotionInfoResponse;
import com.htichina.wsclient.payment.PurchaseProductResponse;
import com.htichina.wsclient.payment.QueryChildOrdersByParentOrderNumResponse;
import com.htichina.wsclient.payment.QueryOrderByParentOrderNumResponse;
import com.htichina.wsclient.payment.TransactionRequest;
import com.htichina.wsclient.payment.TransactionResponse;
import com.htichina.wsclient.payment.VehicleInfoResponse;
import com.htichina.wsclient.payment.WechatUserDataResponse;

/**
 * Created by yiming on 2015/7/1.
 * d:\java\jdk1.7.0_79\bin\wsimport -extension -keep -p com.htichina.wsclient.payment http://localhost:8080/b2c_portal/ws/paymentService?wsdl
 */
public class PaymentServiceClient {
  private static Logger logger = Logger.getLogger(PaymentServiceClient.class.getName());

  private static PaymentServiceClient instance = null;

  private static PaymentService service;

  private PaymentServiceClient() {
    service = new PaymentServiceService().getPort(PaymentService.class);
  }

  public static PaymentServiceClient getInstance(){
    try{
      if(instance==null){
        synchronized(PaymentServiceClient.class){
          if(instance==null){
            instance=new PaymentServiceClient();
          }
        }
      }
      return instance;
    }
    catch (Exception exception) {
      exception.printStackTrace();
      return null;
    }
  }

  public List<VehicleInfoResponse> getVehicleInfo(String vin, String accountNum, String mobilePhone) {
    try {
      return service.getVehicleInfo(vin, accountNum, mobilePhone);
    }
    catch (Exception exception) {
      exception.printStackTrace();
      return null;
    }

  }

  public PaymentOrderResponse createPaymentOrder(String packageId, double price,String proCategoryId,
                                                 String accountNum, String vin, String channel, String openId) {
    try {
      return service.createPaymentOrder(packageId, price,proCategoryId,accountNum,vin,channel,openId);
    }
    catch (Exception exception) {
      exception.printStackTrace();
      return null;
    }
  }
  /*public PaymentOrderResponse createPaymentOrder(String baseProdId,double baseProdPrice,String wifiProdId,double wifiProdPrice,String accountNum,String vin,String  paymentPlatform, String oId) {
    try {
      *//*return service.createPaymentOrder(baseProdId, baseProdPrice,wifiProdId,wifiProdPrice,accountNum,vin,paymentPlatform,oId);*//*
      return null;
    }
    catch (Exception exception) {
      exception.printStackTrace();
      return null;
    }
  }*/

  public ProductInfoResponse getProdInfo(String accountNum) {
    try {
      return service.getProdInfo(Constant.DB_PACKAGE_CHANNEL_WE_CHAT, accountNum);
    }
    catch (Exception exception) {
      exception.printStackTrace();
      return null;
    }
  }

  public ProductInfoResponse getPromotionProdInfo() {
//    return service.getProdInfo(Constant.DB_PACKAGE_TYPE_PROMOTION, Constant.DB_PACKAGE_CHANNEL_WE_CHAT);
    try {
      return service.getProdInfo(Constant.DB_PACKAGE_TYPE_WIFI, Constant.DB_PACKAGE_CHANNEL_WE_CHAT);
    }
    catch (Exception exception) {
      exception.printStackTrace();
      return null;
    }
  }

  public TransactionResponse createTransaction(String orderNum, TransactionRequest transactionRequest) {
    try {
      return service.createTransaction(orderNum, transactionRequest);
    }
    catch (Exception exception) {
      exception.printStackTrace();
      return null;
    }
  }

  public PaymentResponse paymentHandlerService(String transactionNo, PaymentResultMessage payResult) {
    try {
      return service.paymentHandlerService(transactionNo, payResult);
    }
    catch (Exception exception) {
      exception.printStackTrace();
      return null;
    }
  }

  public boolean CheckTransaction(String orderNum) {
    try {
      return service.checkTransaction(orderNum);
    }
    catch (Exception exception) {
      exception.printStackTrace();
      return false;
    }
  }
  public List<Transaction> checkTransactionPaied(String orderNum) {
    try {
      return service.checkTransactionPaied(orderNum);
    }
    catch (Exception exception) {
      exception.printStackTrace();
      return null;
    }
  }

  public PurchaseProductResponse checkPurchaseProduct(String vin, String productType) {
    try {
      return service.checkPurchaseProduct(vin, productType);
    }
    catch (Exception exception) {
      exception.printStackTrace();
      return null;
    }
  }

  public String getActiveAccountByOpenId(String openId) {
    try {
      return service.getActiveAccountByOpenId(openId);
    }
    catch (Exception exception) {
      exception.printStackTrace();
      return null;
    }
  }

  public boolean validateLogin(String accountNum, String pin, String openId, String userInfo) {
    try {
      return service.validateLogin(accountNum, pin, openId, userInfo);
    }
    catch (Exception exception) {
      exception.printStackTrace();
      return false;
    }
  }

  public AccountInfoResponse getCurrentAccountInfo(String accountNum) {
    try {
      return service.getCurrentAccountInfo(accountNum);
    }
    catch (Exception exception) {
      exception.printStackTrace();
      return null;
    }
  }

  public boolean logoff(String openId) {
    try {
      return service.logoff(openId);
    }
    catch (Exception exception) {
      exception.printStackTrace();
      return false;
    }
  }

  public QueryOrderByParentOrderNumResponse queryOrderByParentOrderNum(String parentOrderNum, String accountNum) {
    try {
      return service.getParentOrderInfo(parentOrderNum, accountNum);
    }
    catch (Exception exception) {
      exception.printStackTrace();
      return null;
    }
  }

  public List<QueryChildOrdersByParentOrderNumResponse> queryChildOrdersByParentOrderNum(String parentOrderNum) {
    try {
      return service.getChildOrderInfo(parentOrderNum, Constant.DB_LANGUAGE_ZH);
    }
    catch (Exception exception) {
      exception.printStackTrace();
      return null;
    }
  }
  public boolean InsertInvoice(InvoiceInfoRequest invoiceInfoRequest) {
    try {
      return service.insertInvoiceInfo(invoiceInfoRequest);
    }
    catch (Exception exception) {
      exception.printStackTrace();
      return false;
    }
  }

  public boolean SendInvoiceEmail(InvoiceInfoRequest invoiceInfoRequest){
    try {
      return service.sendInvoiceEmail(invoiceInfoRequest);
    }
    catch (Exception exception) {
      exception.printStackTrace();
      return false;
    }
  }

  public InvoiceInfoRequest getInvoiceInformation(String parentOrderNum){
    try {
      return service.getInvoiceInformation(parentOrderNum);
    }
    catch (Exception exception) {
      exception.printStackTrace();
      return null;
    }
  }

  public WechatUserDataResponse getWechatUserDataByAcccountNum(String accountNum){
    try {
      return service.getWechatUserDataByAccountNum(accountNum);
    }
    catch (Exception exception) {
      exception.printStackTrace();
      return null;
    }
  }

  public void updateLoginTimes(String accountNum){
    try {
      service.updateLoginTimes(accountNum);
    }
    catch (Exception exception) {
      exception.printStackTrace();
    }
  }

  public boolean setReceiveDidi(String accountKey,String didiType){
    try {
      return service.isReceiveDidi(accountKey,didiType);
    }
    catch (Exception exception) {
      exception.printStackTrace();
      return false;
    }
  }
  public String isNewFollowReciveDidi(String cellphone){
    try {
      return service.isNewFollowReciveDidi(cellphone);
      /*return null;*/
    }
    catch (Exception exception) {
      exception.printStackTrace();
      return null;
    }
  }

  public List<PromotionInfoResponse> getPromotionInfo(String accountNum){
    try {
      return service.getPromotionInfo(Constant.DB_PACKAGE_CHANNEL_WE_CHAT,accountNum);
      /*return null;*/
    }
    catch (Exception exception) {
      exception.printStackTrace();
      return null;
    }
    /*return null;*/
  }

  public boolean createWechatUserProfile(String accountNum, String pin, String openId, String userInfo){
    try {
      return service.createWechatUserProfile(accountNum,pin,openId,userInfo);
     /* return false;*/
    }
    catch (Exception exception) {
      exception.printStackTrace();
      return false;
    }
    /*return false;*/
  }
  
  /* 2017-11-10,Tommy Liu, CR82_Part II, 获取 升级-目标套餐 的信息 */
  public PackageUpgradeResponse getNewPackageAfterUpgrade(PackageUpgradeRequest request){
	  return service.getNewPackageAfterUpgrade(request);
  }  
  
  /* 2017-11-10,Tommy Liu, CR82_Part II, 创建升级订单信息 */
  public PackageUpgradeResponse createUpgradePaymentOrder(PackageUpgradeRequest request) {
	  return service.createUpgradePaymentOrder(request);
  }
  
}


