
package com.htichina.wsclient.payment;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.FaultAction;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "PaymentService", targetNamespace = "http://payment.ws.htichina.com/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface PaymentService {


    /**
     * 
     * @param transactionNo
     * @param openIds
     * @param message
     * @return
     *     returns boolean
     * @throws Exception_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "insert", targetNamespace = "http://payment.ws.htichina.com/", className = "com.htichina.wsclient.payment.Insert")
    @ResponseWrapper(localName = "insertResponse", targetNamespace = "http://payment.ws.htichina.com/", className = "com.htichina.wsclient.payment.InsertResponse")
    @Action(input = "http://payment.ws.htichina.com/PaymentService/insertRequest", output = "http://payment.ws.htichina.com/PaymentService/insertResponse", fault = {
        @FaultAction(className = Exception_Exception.class, value = "http://payment.ws.htichina.com/PaymentService/insert/Fault/Exception")
    })
    public boolean insert(
        @WebParam(name = "openIds", targetNamespace = "")
        String openIds,
        @WebParam(name = "message", targetNamespace = "")
        String message,
        @WebParam(name = "transactionNo", targetNamespace = "")
        String transactionNo)
        throws Exception_Exception
    ;

    /**
     * 
     * @param accountNum
     * @return
     *     returns java.util.List<java.lang.String>
     * @throws Exception_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getOpenIdByAccountNum", targetNamespace = "http://payment.ws.htichina.com/", className = "com.htichina.wsclient.payment.GetOpenIdByAccountNum")
    @ResponseWrapper(localName = "getOpenIdByAccountNumResponse", targetNamespace = "http://payment.ws.htichina.com/", className = "com.htichina.wsclient.payment.GetOpenIdByAccountNumResponse")
    @Action(input = "http://payment.ws.htichina.com/PaymentService/getOpenIdByAccountNumRequest", output = "http://payment.ws.htichina.com/PaymentService/getOpenIdByAccountNumResponse", fault = {
        @FaultAction(className = Exception_Exception.class, value = "http://payment.ws.htichina.com/PaymentService/getOpenIdByAccountNum/Fault/Exception")
    })
    public List<String> getOpenIdByAccountNum(
        @WebParam(name = "accountNum", targetNamespace = "")
        String accountNum)
        throws Exception_Exception
    ;

    /**
     * 
     * @param openId
     * @param orderNum
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "updateTransaction", targetNamespace = "http://payment.ws.htichina.com/", className = "com.htichina.wsclient.payment.UpdateTransaction")
    @ResponseWrapper(localName = "updateTransactionResponse", targetNamespace = "http://payment.ws.htichina.com/", className = "com.htichina.wsclient.payment.UpdateTransactionResponse")
    @Action(input = "http://payment.ws.htichina.com/PaymentService/updateTransactionRequest", output = "http://payment.ws.htichina.com/PaymentService/updateTransactionResponse")
    public boolean updateTransaction(
        @WebParam(name = "orderNum", targetNamespace = "")
        String orderNum,
        @WebParam(name = "openId", targetNamespace = "")
        String openId);

    /**
     * 
     * @param orderNum
     * @param tranNo
     * @param openIds
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "updateOrderStatus", targetNamespace = "http://payment.ws.htichina.com/", className = "com.htichina.wsclient.payment.UpdateOrderStatus")
    @ResponseWrapper(localName = "updateOrderStatusResponse", targetNamespace = "http://payment.ws.htichina.com/", className = "com.htichina.wsclient.payment.UpdateOrderStatusResponse")
    @Action(input = "http://payment.ws.htichina.com/PaymentService/updateOrderStatusRequest", output = "http://payment.ws.htichina.com/PaymentService/updateOrderStatusResponse")
    public boolean updateOrderStatus(
        @WebParam(name = "orderNum", targetNamespace = "")
        String orderNum,
        @WebParam(name = "tranNo", targetNamespace = "")
        String tranNo,
        @WebParam(name = "openIds", targetNamespace = "")
        String openIds);

    /**
     * 
     * @param transactionNo
     * @param openIds
     * @return
     *     returns boolean
     * @throws Exception_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "updateWechatMessageHistory", targetNamespace = "http://payment.ws.htichina.com/", className = "com.htichina.wsclient.payment.UpdateWechatMessageHistory")
    @ResponseWrapper(localName = "updateWechatMessageHistoryResponse", targetNamespace = "http://payment.ws.htichina.com/", className = "com.htichina.wsclient.payment.UpdateWechatMessageHistoryResponse")
    @Action(input = "http://payment.ws.htichina.com/PaymentService/updateWechatMessageHistoryRequest", output = "http://payment.ws.htichina.com/PaymentService/updateWechatMessageHistoryResponse", fault = {
        @FaultAction(className = Exception_Exception.class, value = "http://payment.ws.htichina.com/PaymentService/updateWechatMessageHistory/Fault/Exception")
    })
    public boolean updateWechatMessageHistory(
        @WebParam(name = "openIds", targetNamespace = "")
        String openIds,
        @WebParam(name = "transactionNo", targetNamespace = "")
        String transactionNo)
        throws Exception_Exception
    ;

    /**
     * 
     * @param accountNum
     * @return
     *     returns com.htichina.wsclient.payment.LuckyDrawReponse
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "checkCustemerLuckyDraw", targetNamespace = "http://payment.ws.htichina.com/", className = "com.htichina.wsclient.payment.CheckCustemerLuckyDraw")
    @ResponseWrapper(localName = "checkCustemerLuckyDrawResponse", targetNamespace = "http://payment.ws.htichina.com/", className = "com.htichina.wsclient.payment.CheckCustemerLuckyDrawResponse")
    @Action(input = "http://payment.ws.htichina.com/PaymentService/checkCustemerLuckyDrawRequest", output = "http://payment.ws.htichina.com/PaymentService/checkCustemerLuckyDrawResponse")
    public LuckyDrawReponse checkCustemerLuckyDraw(
        @WebParam(name = "accountNum", targetNamespace = "")
        String accountNum);

    /**
     * 
     * @param ordernum
     * @param lang
     * @return
     *     returns java.util.List<com.htichina.wsclient.payment.QueryChildOrdersByParentOrderNumResponse>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getChildOrderInfo", targetNamespace = "http://payment.ws.htichina.com/", className = "com.htichina.wsclient.payment.GetChildOrderInfo")
    @ResponseWrapper(localName = "getChildOrderInfoResponse", targetNamespace = "http://payment.ws.htichina.com/", className = "com.htichina.wsclient.payment.GetChildOrderInfoResponse")
    @Action(input = "http://payment.ws.htichina.com/PaymentService/getChildOrderInfoRequest", output = "http://payment.ws.htichina.com/PaymentService/getChildOrderInfoResponse")
    public List<QueryChildOrdersByParentOrderNumResponse> getChildOrderInfo(
        @WebParam(name = "ordernum", targetNamespace = "")
        String ordernum,
        @WebParam(name = "lang", targetNamespace = "")
        String lang);

    /**
     * 
     * @param accountNum
     * @param price
     * @param openId
     * @param proCategoryId
     * @param packageId
     * @param channel
     * @param vin
     * @return
     *     returns com.htichina.wsclient.payment.PaymentOrderResponse
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "createPaymentOrder", targetNamespace = "http://payment.ws.htichina.com/", className = "com.htichina.wsclient.payment.CreatePaymentOrder")
    @ResponseWrapper(localName = "createPaymentOrderResponse", targetNamespace = "http://payment.ws.htichina.com/", className = "com.htichina.wsclient.payment.CreatePaymentOrderResponse")
    @Action(input = "http://payment.ws.htichina.com/PaymentService/createPaymentOrderRequest", output = "http://payment.ws.htichina.com/PaymentService/createPaymentOrderResponse")
    public PaymentOrderResponse createPaymentOrder(
        @WebParam(name = "packageId", targetNamespace = "")
        String packageId,
        @WebParam(name = "price", targetNamespace = "")
        double price,
        @WebParam(name = "proCategoryId", targetNamespace = "")
        String proCategoryId,
        @WebParam(name = "accountNum", targetNamespace = "")
        String accountNum,
        @WebParam(name = "vin", targetNamespace = "")
        String vin,
        @WebParam(name = "channel", targetNamespace = "")
        String channel,
        @WebParam(name = "openId", targetNamespace = "")
        String openId);

    /**
     * 
     * @param ordernum
     * @return
     *     returns com.htichina.wsclient.payment.InvoiceInfoRequest
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getInvoiceInformation", targetNamespace = "http://payment.ws.htichina.com/", className = "com.htichina.wsclient.payment.GetInvoiceInformation")
    @ResponseWrapper(localName = "getInvoiceInformationResponse", targetNamespace = "http://payment.ws.htichina.com/", className = "com.htichina.wsclient.payment.GetInvoiceInformationResponse")
    @Action(input = "http://payment.ws.htichina.com/PaymentService/getInvoiceInformationRequest", output = "http://payment.ws.htichina.com/PaymentService/getInvoiceInformationResponse")
    public InvoiceInfoRequest getInvoiceInformation(
        @WebParam(name = "ordernum", targetNamespace = "")
        String ordernum);

    /**
     * 
     * @param acctNum
     * @param orderNum
     * @param vin
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "syncAMPWifiAccount", targetNamespace = "http://payment.ws.htichina.com/", className = "com.htichina.wsclient.payment.SyncAMPWifiAccount")
    @ResponseWrapper(localName = "syncAMPWifiAccountResponse", targetNamespace = "http://payment.ws.htichina.com/", className = "com.htichina.wsclient.payment.SyncAMPWifiAccountResponse")
    @Action(input = "http://payment.ws.htichina.com/PaymentService/syncAMPWifiAccountRequest", output = "http://payment.ws.htichina.com/PaymentService/syncAMPWifiAccountResponse")
    public boolean syncAMPWifiAccount(
        @WebParam(name = "orderNum", targetNamespace = "")
        String orderNum,
        @WebParam(name = "acctNum", targetNamespace = "")
        String acctNum,
        @WebParam(name = "VIN", targetNamespace = "")
        String vin);

    /**
     * 
     * @param accountNum
     * @param orderNum
     * @return
     *     returns com.htichina.wsclient.payment.QueryOrderByParentOrderNumResponse
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getParentOrderInfo", targetNamespace = "http://payment.ws.htichina.com/", className = "com.htichina.wsclient.payment.GetParentOrderInfo")
    @ResponseWrapper(localName = "getParentOrderInfoResponse", targetNamespace = "http://payment.ws.htichina.com/", className = "com.htichina.wsclient.payment.GetParentOrderInfoResponse")
    @Action(input = "http://payment.ws.htichina.com/PaymentService/getParentOrderInfoRequest", output = "http://payment.ws.htichina.com/PaymentService/getParentOrderInfoResponse")
    public QueryOrderByParentOrderNumResponse getParentOrderInfo(
        @WebParam(name = "orderNum", targetNamespace = "")
        String orderNum,
        @WebParam(name = "accountNum", targetNamespace = "")
        String accountNum);

    /**
     * 
     * @param arg0
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "insertInvoiceInfo", targetNamespace = "http://payment.ws.htichina.com/", className = "com.htichina.wsclient.payment.InsertInvoiceInfo")
    @ResponseWrapper(localName = "insertInvoiceInfoResponse", targetNamespace = "http://payment.ws.htichina.com/", className = "com.htichina.wsclient.payment.InsertInvoiceInfoResponse")
    @Action(input = "http://payment.ws.htichina.com/PaymentService/insertInvoiceInfoRequest", output = "http://payment.ws.htichina.com/PaymentService/insertInvoiceInfoResponse")
    public boolean insertInvoiceInfo(
        @WebParam(name = "arg0", targetNamespace = "")
        InvoiceInfoRequest arg0);

    /**
     * 
     * @param request
     * @param orderNum
     * @return
     *     returns com.htichina.wsclient.payment.TransactionResponse
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "createTransaction", targetNamespace = "http://payment.ws.htichina.com/", className = "com.htichina.wsclient.payment.CreateTransaction")
    @ResponseWrapper(localName = "createTransactionResponse", targetNamespace = "http://payment.ws.htichina.com/", className = "com.htichina.wsclient.payment.CreateTransactionResponse")
    @Action(input = "http://payment.ws.htichina.com/PaymentService/createTransactionRequest", output = "http://payment.ws.htichina.com/PaymentService/createTransactionResponse")
    public TransactionResponse createTransaction(
        @WebParam(name = "orderNum", targetNamespace = "")
        String orderNum,
        @WebParam(name = "request", targetNamespace = "")
        TransactionRequest request);

    /**
     * 
     * @param cellphone
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "isNewFollowReciveDidi", targetNamespace = "http://payment.ws.htichina.com/", className = "com.htichina.wsclient.payment.IsNewFollowReciveDidi")
    @ResponseWrapper(localName = "isNewFollowReciveDidiResponse", targetNamespace = "http://payment.ws.htichina.com/", className = "com.htichina.wsclient.payment.IsNewFollowReciveDidiResponse")
    @Action(input = "http://payment.ws.htichina.com/PaymentService/isNewFollowReciveDidiRequest", output = "http://payment.ws.htichina.com/PaymentService/isNewFollowReciveDidiResponse")
    public String isNewFollowReciveDidi(
        @WebParam(name = "cellphone", targetNamespace = "")
        String cellphone);

    /**
     * 
     * @param userInfo
     * @param accountNum
     * @param pin
     * @param openId
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "closeWechatUserProfile", targetNamespace = "http://payment.ws.htichina.com/", className = "com.htichina.wsclient.payment.CloseWechatUserProfile")
    @ResponseWrapper(localName = "closeWechatUserProfileResponse", targetNamespace = "http://payment.ws.htichina.com/", className = "com.htichina.wsclient.payment.CloseWechatUserProfileResponse")
    @Action(input = "http://payment.ws.htichina.com/PaymentService/closeWechatUserProfileRequest", output = "http://payment.ws.htichina.com/PaymentService/closeWechatUserProfileResponse")
    public boolean closeWechatUserProfile(
        @WebParam(name = "accountNum", targetNamespace = "")
        String accountNum,
        @WebParam(name = "pin", targetNamespace = "")
        String pin,
        @WebParam(name = "openId", targetNamespace = "")
        String openId,
        @WebParam(name = "userInfo", targetNamespace = "")
        String userInfo);

    /**
     * 
     * @param openId
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getLastLoginUserByOpenId", targetNamespace = "http://payment.ws.htichina.com/", className = "com.htichina.wsclient.payment.GetLastLoginUserByOpenId")
    @ResponseWrapper(localName = "getLastLoginUserByOpenIdResponse", targetNamespace = "http://payment.ws.htichina.com/", className = "com.htichina.wsclient.payment.GetLastLoginUserByOpenIdResponse")
    @Action(input = "http://payment.ws.htichina.com/PaymentService/getLastLoginUserByOpenIdRequest", output = "http://payment.ws.htichina.com/PaymentService/getLastLoginUserByOpenIdResponse")
    public String getLastLoginUserByOpenId(
        @WebParam(name = "openId", targetNamespace = "")
        String openId);

    /**
     * 
     * @param accountNum
     * @return
     *     returns com.htichina.wsclient.payment.WechatUserDataResponse
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getWechatUserDataByAccountNum", targetNamespace = "http://payment.ws.htichina.com/", className = "com.htichina.wsclient.payment.GetWechatUserDataByAccountNum")
    @ResponseWrapper(localName = "getWechatUserDataByAccountNumResponse", targetNamespace = "http://payment.ws.htichina.com/", className = "com.htichina.wsclient.payment.GetWechatUserDataByAccountNumResponse")
    @Action(input = "http://payment.ws.htichina.com/PaymentService/getWechatUserDataByAccountNumRequest", output = "http://payment.ws.htichina.com/PaymentService/getWechatUserDataByAccountNumResponse")
    public WechatUserDataResponse getWechatUserDataByAccountNum(
        @WebParam(name = "accountNum", targetNamespace = "")
        String accountNum);

    /**
     * 
     * @param transNum
     * @param payresult
     * @return
     *     returns com.htichina.wsclient.payment.PaymentResponse
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "paymentHandlerService", targetNamespace = "http://payment.ws.htichina.com/", className = "com.htichina.wsclient.payment.PaymentHandlerService")
    @ResponseWrapper(localName = "paymentHandlerServiceResponse", targetNamespace = "http://payment.ws.htichina.com/", className = "com.htichina.wsclient.payment.PaymentHandlerServiceResponse")
    @Action(input = "http://payment.ws.htichina.com/PaymentService/paymentHandlerServiceRequest", output = "http://payment.ws.htichina.com/PaymentService/paymentHandlerServiceResponse")
    public PaymentResponse paymentHandlerService(
        @WebParam(name = "transNum", targetNamespace = "")
        String transNum,
        @WebParam(name = "payresult", targetNamespace = "")
        PaymentResultMessage payresult);

    /**
     * 
     * @param arg0
     * @return
     *     returns com.htichina.wsclient.payment.PackageUpgradeResponse
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "createUpgradePaymentOrder", targetNamespace = "http://payment.ws.htichina.com/", className = "com.htichina.wsclient.payment.CreateUpgradePaymentOrder")
    @ResponseWrapper(localName = "createUpgradePaymentOrderResponse", targetNamespace = "http://payment.ws.htichina.com/", className = "com.htichina.wsclient.payment.CreateUpgradePaymentOrderResponse")
    @Action(input = "http://payment.ws.htichina.com/PaymentService/createUpgradePaymentOrderRequest", output = "http://payment.ws.htichina.com/PaymentService/createUpgradePaymentOrderResponse")
    public PackageUpgradeResponse createUpgradePaymentOrder(
        @WebParam(name = "arg0", targetNamespace = "")
        PackageUpgradeRequest arg0);

    /**
     * 
     * @param openId
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getActiveAccountByOpenId", targetNamespace = "http://payment.ws.htichina.com/", className = "com.htichina.wsclient.payment.GetActiveAccountByOpenId")
    @ResponseWrapper(localName = "getActiveAccountByOpenIdResponse", targetNamespace = "http://payment.ws.htichina.com/", className = "com.htichina.wsclient.payment.GetActiveAccountByOpenIdResponse")
    @Action(input = "http://payment.ws.htichina.com/PaymentService/getActiveAccountByOpenIdRequest", output = "http://payment.ws.htichina.com/PaymentService/getActiveAccountByOpenIdResponse")
    public String getActiveAccountByOpenId(
        @WebParam(name = "openId", targetNamespace = "")
        String openId);

    /**
     * 
     * @param userInfo
     * @param accountNum
     * @param pin
     * @param openId
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "createWechatUserProfile", targetNamespace = "http://payment.ws.htichina.com/", className = "com.htichina.wsclient.payment.CreateWechatUserProfile")
    @ResponseWrapper(localName = "createWechatUserProfileResponse", targetNamespace = "http://payment.ws.htichina.com/", className = "com.htichina.wsclient.payment.CreateWechatUserProfileResponse")
    @Action(input = "http://payment.ws.htichina.com/PaymentService/createWechatUserProfileRequest", output = "http://payment.ws.htichina.com/PaymentService/createWechatUserProfileResponse")
    public boolean createWechatUserProfile(
        @WebParam(name = "accountNum", targetNamespace = "")
        String accountNum,
        @WebParam(name = "pin", targetNamespace = "")
        String pin,
        @WebParam(name = "openId", targetNamespace = "")
        String openId,
        @WebParam(name = "userInfo", targetNamespace = "")
        String userInfo);

    /**
     * 
     * @param arg0
     * @return
     *     returns java.lang.Integer
     * @throws Exception_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "isWinBackOrEarlyBird", targetNamespace = "http://payment.ws.htichina.com/", className = "com.htichina.wsclient.payment.IsWinBackOrEarlyBird")
    @ResponseWrapper(localName = "isWinBackOrEarlyBirdResponse", targetNamespace = "http://payment.ws.htichina.com/", className = "com.htichina.wsclient.payment.IsWinBackOrEarlyBirdResponse")
    @Action(input = "http://payment.ws.htichina.com/PaymentService/isWinBackOrEarlyBirdRequest", output = "http://payment.ws.htichina.com/PaymentService/isWinBackOrEarlyBirdResponse", fault = {
        @FaultAction(className = Exception_Exception.class, value = "http://payment.ws.htichina.com/PaymentService/isWinBackOrEarlyBird/Fault/Exception")
    })
    public Integer isWinBackOrEarlyBird(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0)
        throws Exception_Exception
    ;

    /**
     * 
     * @param orderNum
     * @return
     *     returns java.util.List<com.htichina.wsclient.payment.Transaction>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getTransactionByOrderNum", targetNamespace = "http://payment.ws.htichina.com/", className = "com.htichina.wsclient.payment.GetTransactionByOrderNum")
    @ResponseWrapper(localName = "getTransactionByOrderNumResponse", targetNamespace = "http://payment.ws.htichina.com/", className = "com.htichina.wsclient.payment.GetTransactionByOrderNumResponse")
    @Action(input = "http://payment.ws.htichina.com/PaymentService/getTransactionByOrderNumRequest", output = "http://payment.ws.htichina.com/PaymentService/getTransactionByOrderNumResponse")
    public List<Transaction> getTransactionByOrderNum(
        @WebParam(name = "OrderNum", targetNamespace = "")
        String orderNum);

    /**
     * 
     * @param arg0
     * @return
     *     returns com.htichina.wsclient.payment.PackageUpgradeResponse
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getNewPackageAfterUpgrade", targetNamespace = "http://payment.ws.htichina.com/", className = "com.htichina.wsclient.payment.GetNewPackageAfterUpgrade")
    @ResponseWrapper(localName = "getNewPackageAfterUpgradeResponse", targetNamespace = "http://payment.ws.htichina.com/", className = "com.htichina.wsclient.payment.GetNewPackageAfterUpgradeResponse")
    @Action(input = "http://payment.ws.htichina.com/PaymentService/getNewPackageAfterUpgradeRequest", output = "http://payment.ws.htichina.com/PaymentService/getNewPackageAfterUpgradeResponse")
    public PackageUpgradeResponse getNewPackageAfterUpgrade(
        @WebParam(name = "arg0", targetNamespace = "")
        PackageUpgradeRequest arg0);

    /**
     * 
     * @param vin
     * @param productType
     * @return
     *     returns com.htichina.wsclient.payment.PurchaseProductResponse
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "checkPurchaseProduct", targetNamespace = "http://payment.ws.htichina.com/", className = "com.htichina.wsclient.payment.CheckPurchaseProduct")
    @ResponseWrapper(localName = "checkPurchaseProductResponse", targetNamespace = "http://payment.ws.htichina.com/", className = "com.htichina.wsclient.payment.CheckPurchaseProductResponse")
    @Action(input = "http://payment.ws.htichina.com/PaymentService/checkPurchaseProductRequest", output = "http://payment.ws.htichina.com/PaymentService/checkPurchaseProductResponse")
    public PurchaseProductResponse checkPurchaseProduct(
        @WebParam(name = "vin", targetNamespace = "")
        String vin,
        @WebParam(name = "product_type", targetNamespace = "")
        String productType);

    /**
     * 
     * @param accountNum
     * @return
     *     returns com.htichina.wsclient.payment.AccountInfoResponse
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getCurrentAccountInfo", targetNamespace = "http://payment.ws.htichina.com/", className = "com.htichina.wsclient.payment.GetCurrentAccountInfo")
    @ResponseWrapper(localName = "getCurrentAccountInfoResponse", targetNamespace = "http://payment.ws.htichina.com/", className = "com.htichina.wsclient.payment.GetCurrentAccountInfoResponse")
    @Action(input = "http://payment.ws.htichina.com/PaymentService/getCurrentAccountInfoRequest", output = "http://payment.ws.htichina.com/PaymentService/getCurrentAccountInfoResponse")
    public AccountInfoResponse getCurrentAccountInfo(
        @WebParam(name = "accountNum", targetNamespace = "")
        String accountNum);

    /**
     * 
     * @param acctNum
     * @param vin
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "syncAccnt", targetNamespace = "http://payment.ws.htichina.com/", className = "com.htichina.wsclient.payment.SyncAccnt")
    @ResponseWrapper(localName = "syncAccntResponse", targetNamespace = "http://payment.ws.htichina.com/", className = "com.htichina.wsclient.payment.SyncAccntResponse")
    @Action(input = "http://payment.ws.htichina.com/PaymentService/syncAccntRequest", output = "http://payment.ws.htichina.com/PaymentService/syncAccntResponse")
    public boolean syncAccnt(
        @WebParam(name = "acctNum", targetNamespace = "")
        String acctNum,
        @WebParam(name = "VIN", targetNamespace = "")
        String vin);

    /**
     * 
     * @param accountNum
     * @param productChannel
     * @return
     *     returns com.htichina.wsclient.payment.ProductInfoResponse
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getProdInfo", targetNamespace = "http://payment.ws.htichina.com/", className = "com.htichina.wsclient.payment.GetProdInfo")
    @ResponseWrapper(localName = "getProdInfoResponse", targetNamespace = "http://payment.ws.htichina.com/", className = "com.htichina.wsclient.payment.GetProdInfoResponse")
    @Action(input = "http://payment.ws.htichina.com/PaymentService/getProdInfoRequest", output = "http://payment.ws.htichina.com/PaymentService/getProdInfoResponse")
    public ProductInfoResponse getProdInfo(
        @WebParam(name = "product_channel", targetNamespace = "")
        String productChannel,
        @WebParam(name = "accountNum", targetNamespace = "")
        String accountNum);

    /**
     * 
     * @param userInfo
     * @param accountNum
     * @param pin
     * @param openId
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "validateLogin", targetNamespace = "http://payment.ws.htichina.com/", className = "com.htichina.wsclient.payment.ValidateLogin")
    @ResponseWrapper(localName = "validateLoginResponse", targetNamespace = "http://payment.ws.htichina.com/", className = "com.htichina.wsclient.payment.ValidateLoginResponse")
    @Action(input = "http://payment.ws.htichina.com/PaymentService/validateLoginRequest", output = "http://payment.ws.htichina.com/PaymentService/validateLoginResponse")
    public boolean validateLogin(
        @WebParam(name = "accountNum", targetNamespace = "")
        String accountNum,
        @WebParam(name = "pin", targetNamespace = "")
        String pin,
        @WebParam(name = "openId", targetNamespace = "")
        String openId,
        @WebParam(name = "userInfo", targetNamespace = "")
        String userInfo);

    /**
     * 
     * @param orderNum
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "checkTransaction", targetNamespace = "http://payment.ws.htichina.com/", className = "com.htichina.wsclient.payment.CheckTransaction")
    @ResponseWrapper(localName = "checkTransactionResponse", targetNamespace = "http://payment.ws.htichina.com/", className = "com.htichina.wsclient.payment.CheckTransactionResponse")
    @Action(input = "http://payment.ws.htichina.com/PaymentService/checkTransactionRequest", output = "http://payment.ws.htichina.com/PaymentService/checkTransactionResponse")
    public boolean checkTransaction(
        @WebParam(name = "orderNum", targetNamespace = "")
        String orderNum);

    /**
     * 
     * @param openId
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "logoff", targetNamespace = "http://payment.ws.htichina.com/", className = "com.htichina.wsclient.payment.Logoff")
    @ResponseWrapper(localName = "logoffResponse", targetNamespace = "http://payment.ws.htichina.com/", className = "com.htichina.wsclient.payment.LogoffResponse")
    @Action(input = "http://payment.ws.htichina.com/PaymentService/logoffRequest", output = "http://payment.ws.htichina.com/PaymentService/logoffResponse")
    public boolean logoff(
        @WebParam(name = "openId", targetNamespace = "")
        String openId);

    /**
     * 
     * @param transactionNo
     * @return
     *     returns java.util.List<com.htichina.wsclient.payment.ServiceOrder>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "checkOrderPaied", targetNamespace = "http://payment.ws.htichina.com/", className = "com.htichina.wsclient.payment.CheckOrderPaied")
    @ResponseWrapper(localName = "checkOrderPaiedResponse", targetNamespace = "http://payment.ws.htichina.com/", className = "com.htichina.wsclient.payment.CheckOrderPaiedResponse")
    @Action(input = "http://payment.ws.htichina.com/PaymentService/checkOrderPaiedRequest", output = "http://payment.ws.htichina.com/PaymentService/checkOrderPaiedResponse")
    public List<ServiceOrder> checkOrderPaied(
        @WebParam(name = "transactionNo", targetNamespace = "")
        String transactionNo);

    /**
     * 
     * @param accountNum
     */
    @WebMethod
    @RequestWrapper(localName = "updateLoginTimes", targetNamespace = "http://payment.ws.htichina.com/", className = "com.htichina.wsclient.payment.UpdateLoginTimes")
    @ResponseWrapper(localName = "updateLoginTimesResponse", targetNamespace = "http://payment.ws.htichina.com/", className = "com.htichina.wsclient.payment.UpdateLoginTimesResponse")
    @Action(input = "http://payment.ws.htichina.com/PaymentService/updateLoginTimesRequest", output = "http://payment.ws.htichina.com/PaymentService/updateLoginTimesResponse")
    public void updateLoginTimes(
        @WebParam(name = "accountNum", targetNamespace = "")
        String accountNum);

    /**
     * 
     * @param didiType
     * @param accountKey
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "isReceiveDidi", targetNamespace = "http://payment.ws.htichina.com/", className = "com.htichina.wsclient.payment.IsReceiveDidi")
    @ResponseWrapper(localName = "isReceiveDidiResponse", targetNamespace = "http://payment.ws.htichina.com/", className = "com.htichina.wsclient.payment.IsReceiveDidiResponse")
    @Action(input = "http://payment.ws.htichina.com/PaymentService/isReceiveDidiRequest", output = "http://payment.ws.htichina.com/PaymentService/isReceiveDidiResponse")
    public boolean isReceiveDidi(
        @WebParam(name = "accountKey", targetNamespace = "")
        String accountKey,
        @WebParam(name = "didiType", targetNamespace = "")
        String didiType);

    /**
     * 
     * @param accountNum
     * @param productChannel
     * @return
     *     returns java.util.List<com.htichina.wsclient.payment.PromotionInfoResponse>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getPromotionInfo", targetNamespace = "http://payment.ws.htichina.com/", className = "com.htichina.wsclient.payment.GetPromotionInfo")
    @ResponseWrapper(localName = "getPromotionInfoResponse", targetNamespace = "http://payment.ws.htichina.com/", className = "com.htichina.wsclient.payment.GetPromotionInfoResponse")
    @Action(input = "http://payment.ws.htichina.com/PaymentService/getPromotionInfoRequest", output = "http://payment.ws.htichina.com/PaymentService/getPromotionInfoResponse")
    public List<PromotionInfoResponse> getPromotionInfo(
        @WebParam(name = "product_channel", targetNamespace = "")
        String productChannel,
        @WebParam(name = "accountNum", targetNamespace = "")
        String accountNum);

    /**
     * 
     * @param arg3
     * @param arg2
     * @param arg4
     * @param arg1
     * @param arg0
     * @return
     *     returns com.htichina.wsclient.payment.PaymentOrderResponse
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "createLuckyOrder", targetNamespace = "http://payment.ws.htichina.com/", className = "com.htichina.wsclient.payment.CreateLuckyOrder")
    @ResponseWrapper(localName = "createLuckyOrderResponse", targetNamespace = "http://payment.ws.htichina.com/", className = "com.htichina.wsclient.payment.CreateLuckyOrderResponse")
    @Action(input = "http://payment.ws.htichina.com/PaymentService/createLuckyOrderRequest", output = "http://payment.ws.htichina.com/PaymentService/createLuckyOrderResponse")
    public PaymentOrderResponse createLuckyOrder(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        String arg2,
        @WebParam(name = "arg3", targetNamespace = "")
        String arg3,
        @WebParam(name = "arg4", targetNamespace = "")
        String arg4);

    /**
     * 
     * @param accountNum
     * @param openId
     * @param channel
     * @return
     *     returns com.htichina.wsclient.payment.LdLtemReponse
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "doLuckDraw", targetNamespace = "http://payment.ws.htichina.com/", className = "com.htichina.wsclient.payment.DoLuckDraw")
    @ResponseWrapper(localName = "doLuckDrawResponse", targetNamespace = "http://payment.ws.htichina.com/", className = "com.htichina.wsclient.payment.DoLuckDrawResponse")
    @Action(input = "http://payment.ws.htichina.com/PaymentService/doLuckDrawRequest", output = "http://payment.ws.htichina.com/PaymentService/doLuckDrawResponse")
    public LdLtemReponse doLuckDraw(
        @WebParam(name = "accountNum", targetNamespace = "")
        String accountNum,
        @WebParam(name = "openId", targetNamespace = "")
        String openId,
        @WebParam(name = "channel", targetNamespace = "")
        String channel);

    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "sendMessage", targetNamespace = "http://payment.ws.htichina.com/", className = "com.htichina.wsclient.payment.SendMessage")
    @ResponseWrapper(localName = "sendMessageResponse", targetNamespace = "http://payment.ws.htichina.com/", className = "com.htichina.wsclient.payment.SendMessageResponse")
    @Action(input = "http://payment.ws.htichina.com/PaymentService/sendMessageRequest", output = "http://payment.ws.htichina.com/PaymentService/sendMessageResponse")
    public boolean sendMessage(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1);

    /**
     * 
     * @param arg0
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "sendInvoiceEmail", targetNamespace = "http://payment.ws.htichina.com/", className = "com.htichina.wsclient.payment.SendInvoiceEmail")
    @ResponseWrapper(localName = "sendInvoiceEmailResponse", targetNamespace = "http://payment.ws.htichina.com/", className = "com.htichina.wsclient.payment.SendInvoiceEmailResponse")
    @Action(input = "http://payment.ws.htichina.com/PaymentService/sendInvoiceEmailRequest", output = "http://payment.ws.htichina.com/PaymentService/sendInvoiceEmailResponse")
    public boolean sendInvoiceEmail(
        @WebParam(name = "arg0", targetNamespace = "")
        InvoiceInfoRequest arg0);

    /**
     * 
     * @param mobileNum
     * @param acctNum
     * @param vin
     * @return
     *     returns java.util.List<com.htichina.wsclient.payment.VehicleInfoResponse>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getVehicleInfo", targetNamespace = "http://payment.ws.htichina.com/", className = "com.htichina.wsclient.payment.GetVehicleInfo")
    @ResponseWrapper(localName = "getVehicleInfoResponse", targetNamespace = "http://payment.ws.htichina.com/", className = "com.htichina.wsclient.payment.GetVehicleInfoResponse")
    @Action(input = "http://payment.ws.htichina.com/PaymentService/getVehicleInfoRequest", output = "http://payment.ws.htichina.com/PaymentService/getVehicleInfoResponse")
    public List<VehicleInfoResponse> getVehicleInfo(
        @WebParam(name = "vin", targetNamespace = "")
        String vin,
        @WebParam(name = "acctNum", targetNamespace = "")
        String acctNum,
        @WebParam(name = "mobileNum", targetNamespace = "")
        String mobileNum);

}
