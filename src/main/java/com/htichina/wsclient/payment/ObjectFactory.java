
package com.htichina.wsclient.payment;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.htichina.wsclient.payment package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ValidateLogin_QNAME = new QName("http://payment.ws.htichina.com/", "validateLogin");
    private final static QName _CloseWechatUserProfile_QNAME = new QName("http://payment.ws.htichina.com/", "closeWechatUserProfile");
    private final static QName _GetWechatUserDataByAccountNum_QNAME = new QName("http://payment.ws.htichina.com/", "getWechatUserDataByAccountNum");
    private final static QName _CreateUpgradePaymentOrderResponse_QNAME = new QName("http://payment.ws.htichina.com/", "createUpgradePaymentOrderResponse");
    private final static QName _GetLastLoginUserByOpenId_QNAME = new QName("http://payment.ws.htichina.com/", "getLastLoginUserByOpenId");
    private final static QName _CheckPurchaseProduct_QNAME = new QName("http://payment.ws.htichina.com/", "checkPurchaseProduct");
    private final static QName _LogoffResponse_QNAME = new QName("http://payment.ws.htichina.com/", "logoffResponse");
    private final static QName _PaymentHandlerServiceResponse_QNAME = new QName("http://payment.ws.htichina.com/", "paymentHandlerServiceResponse");
    private final static QName _GetActiveAccountByOpenId_QNAME = new QName("http://payment.ws.htichina.com/", "getActiveAccountByOpenId");
    private final static QName _InsertResponse_QNAME = new QName("http://payment.ws.htichina.com/", "insertResponse");
    private final static QName _UpdateOrderStatusResponse_QNAME = new QName("http://payment.ws.htichina.com/", "updateOrderStatusResponse");
    private final static QName _CheckTransactionResponse_QNAME = new QName("http://payment.ws.htichina.com/", "checkTransactionResponse");
    private final static QName _UpdateWechatMessageHistory_QNAME = new QName("http://payment.ws.htichina.com/", "updateWechatMessageHistory");
    private final static QName _GetVehicleInfoResponse_QNAME = new QName("http://payment.ws.htichina.com/", "getVehicleInfoResponse");
    private final static QName _IsWinBackOrEarlyBird_QNAME = new QName("http://payment.ws.htichina.com/", "isWinBackOrEarlyBird");
    private final static QName _CreatePaymentOrder_QNAME = new QName("http://payment.ws.htichina.com/", "createPaymentOrder");
    private final static QName _CreateWechatUserProfile_QNAME = new QName("http://payment.ws.htichina.com/", "createWechatUserProfile");
    private final static QName _GetParentOrderInfoResponse_QNAME = new QName("http://payment.ws.htichina.com/", "getParentOrderInfoResponse");
    private final static QName _GetInvoiceInformation_QNAME = new QName("http://payment.ws.htichina.com/", "getInvoiceInformation");
    private final static QName _SyncAMPWifiAccountResponse_QNAME = new QName("http://payment.ws.htichina.com/", "syncAMPWifiAccountResponse");
    private final static QName _GetOpenIdByAccountNumResponse_QNAME = new QName("http://payment.ws.htichina.com/", "getOpenIdByAccountNumResponse");
    private final static QName _Logoff_QNAME = new QName("http://payment.ws.htichina.com/", "logoff");
    private final static QName _CreateTransactionResponse_QNAME = new QName("http://payment.ws.htichina.com/", "createTransactionResponse");
    private final static QName _CreateUpgradePaymentOrder_QNAME = new QName("http://payment.ws.htichina.com/", "createUpgradePaymentOrder");
    private final static QName _UpdateLoginTimes_QNAME = new QName("http://payment.ws.htichina.com/", "updateLoginTimes");
    private final static QName _CheckTransaction_QNAME = new QName("http://payment.ws.htichina.com/", "checkTransaction");
    private final static QName _GetInvoiceInformationResponse_QNAME = new QName("http://payment.ws.htichina.com/", "getInvoiceInformationResponse");
    private final static QName _IsReceiveDidiResponse_QNAME = new QName("http://payment.ws.htichina.com/", "isReceiveDidiResponse");
    private final static QName _GetVehicleInfo_QNAME = new QName("http://payment.ws.htichina.com/", "getVehicleInfo");
    private final static QName _GetNewPackageAfterUpgradeResponse_QNAME = new QName("http://payment.ws.htichina.com/", "getNewPackageAfterUpgradeResponse");
    private final static QName _GetParentOrderInfo_QNAME = new QName("http://payment.ws.htichina.com/", "getParentOrderInfo");
    private final static QName _GetProdInfoResponse_QNAME = new QName("http://payment.ws.htichina.com/", "getProdInfoResponse");
    private final static QName _GetCurrentAccountInfo_QNAME = new QName("http://payment.ws.htichina.com/", "getCurrentAccountInfo");
    private final static QName _IsNewFollowReciveDidi_QNAME = new QName("http://payment.ws.htichina.com/", "isNewFollowReciveDidi");
    private final static QName _UpdateWechatMessageHistoryResponse_QNAME = new QName("http://payment.ws.htichina.com/", "updateWechatMessageHistoryResponse");
    private final static QName _CreateWechatUserProfileResponse_QNAME = new QName("http://payment.ws.htichina.com/", "createWechatUserProfileResponse");
    private final static QName _CloseWechatUserProfileResponse_QNAME = new QName("http://payment.ws.htichina.com/", "closeWechatUserProfileResponse");
    private final static QName _GetPromotionInfoResponse_QNAME = new QName("http://payment.ws.htichina.com/", "getPromotionInfoResponse");
    private final static QName _SyncAccntResponse_QNAME = new QName("http://payment.ws.htichina.com/", "syncAccntResponse");
    private final static QName _SendInvoiceEmail_QNAME = new QName("http://payment.ws.htichina.com/", "sendInvoiceEmail");
    private final static QName _CheckOrderPaied_QNAME = new QName("http://payment.ws.htichina.com/", "checkOrderPaied");
    private final static QName _ValidateLoginResponse_QNAME = new QName("http://payment.ws.htichina.com/", "validateLoginResponse");
    private final static QName _GetWechatUserDataByAccountNumResponse_QNAME = new QName("http://payment.ws.htichina.com/", "getWechatUserDataByAccountNumResponse");
    private final static QName _Insert_QNAME = new QName("http://payment.ws.htichina.com/", "insert");
    private final static QName _InsertInvoiceInfoResponse_QNAME = new QName("http://payment.ws.htichina.com/", "insertInvoiceInfoResponse");
    private final static QName _IsReceiveDidi_QNAME = new QName("http://payment.ws.htichina.com/", "isReceiveDidi");
    private final static QName _GetPromotionInfo_QNAME = new QName("http://payment.ws.htichina.com/", "getPromotionInfo");
    private final static QName _PaymentHandlerService_QNAME = new QName("http://payment.ws.htichina.com/", "paymentHandlerService");
    private final static QName _InsertInvoiceInfo_QNAME = new QName("http://payment.ws.htichina.com/", "insertInvoiceInfo");
    private final static QName _IsWinBackOrEarlyBirdResponse_QNAME = new QName("http://payment.ws.htichina.com/", "isWinBackOrEarlyBirdResponse");
    private final static QName _GetCurrentAccountInfoResponse_QNAME = new QName("http://payment.ws.htichina.com/", "getCurrentAccountInfoResponse");
    private final static QName _UpdateLoginTimesResponse_QNAME = new QName("http://payment.ws.htichina.com/", "updateLoginTimesResponse");
    private final static QName _CreateTransaction_QNAME = new QName("http://payment.ws.htichina.com/", "createTransaction");
    private final static QName _GetActiveAccountByOpenIdResponse_QNAME = new QName("http://payment.ws.htichina.com/", "getActiveAccountByOpenIdResponse");
    private final static QName _GetChildOrderInfoResponse_QNAME = new QName("http://payment.ws.htichina.com/", "getChildOrderInfoResponse");
    private final static QName _GetNewPackageAfterUpgrade_QNAME = new QName("http://payment.ws.htichina.com/", "getNewPackageAfterUpgrade");
    private final static QName _SyncAMPWifiAccount_QNAME = new QName("http://payment.ws.htichina.com/", "syncAMPWifiAccount");
    private final static QName _UpdateTransactionResponse_QNAME = new QName("http://payment.ws.htichina.com/", "updateTransactionResponse");
    private final static QName _GetProdInfo_QNAME = new QName("http://payment.ws.htichina.com/", "getProdInfo");
    private final static QName _IsNewFollowReciveDidiResponse_QNAME = new QName("http://payment.ws.htichina.com/", "isNewFollowReciveDidiResponse");
    private final static QName _GetOpenIdByAccountNum_QNAME = new QName("http://payment.ws.htichina.com/", "getOpenIdByAccountNum");
    private final static QName _Exception_QNAME = new QName("http://payment.ws.htichina.com/", "Exception");
    private final static QName _SendInvoiceEmailResponse_QNAME = new QName("http://payment.ws.htichina.com/", "sendInvoiceEmailResponse");
    private final static QName _GetTransactionByOrderNumResponse_QNAME = new QName("http://payment.ws.htichina.com/", "getTransactionByOrderNumResponse");
    private final static QName _UpdateOrderStatus_QNAME = new QName("http://payment.ws.htichina.com/", "updateOrderStatus");
    private final static QName _CheckPurchaseProductResponse_QNAME = new QName("http://payment.ws.htichina.com/", "checkPurchaseProductResponse");
    private final static QName _CreatePaymentOrderResponse_QNAME = new QName("http://payment.ws.htichina.com/", "createPaymentOrderResponse");
    private final static QName _GetTransactionByOrderNum_QNAME = new QName("http://payment.ws.htichina.com/", "getTransactionByOrderNum");
    private final static QName _GetChildOrderInfo_QNAME = new QName("http://payment.ws.htichina.com/", "getChildOrderInfo");
    private final static QName _SyncAccnt_QNAME = new QName("http://payment.ws.htichina.com/", "syncAccnt");
    private final static QName _UpdateTransaction_QNAME = new QName("http://payment.ws.htichina.com/", "updateTransaction");
    private final static QName _GetLastLoginUserByOpenIdResponse_QNAME = new QName("http://payment.ws.htichina.com/", "getLastLoginUserByOpenIdResponse");
    private final static QName _CheckOrderPaiedResponse_QNAME = new QName("http://payment.ws.htichina.com/", "checkOrderPaiedResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.htichina.wsclient.payment
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetVehicleInfoResponse }
     * 
     */
    public GetVehicleInfoResponse createGetVehicleInfoResponse() {
        return new GetVehicleInfoResponse();
    }

    /**
     * Create an instance of {@link UpdateWechatMessageHistory }
     * 
     */
    public UpdateWechatMessageHistory createUpdateWechatMessageHistory() {
        return new UpdateWechatMessageHistory();
    }

    /**
     * Create an instance of {@link IsWinBackOrEarlyBird }
     * 
     */
    public IsWinBackOrEarlyBird createIsWinBackOrEarlyBird() {
        return new IsWinBackOrEarlyBird();
    }

    /**
     * Create an instance of {@link GetActiveAccountByOpenId }
     * 
     */
    public GetActiveAccountByOpenId createGetActiveAccountByOpenId() {
        return new GetActiveAccountByOpenId();
    }

    /**
     * Create an instance of {@link CheckTransactionResponse }
     * 
     */
    public CheckTransactionResponse createCheckTransactionResponse() {
        return new CheckTransactionResponse();
    }

    /**
     * Create an instance of {@link UpdateOrderStatusResponse }
     * 
     */
    public UpdateOrderStatusResponse createUpdateOrderStatusResponse() {
        return new UpdateOrderStatusResponse();
    }

    /**
     * Create an instance of {@link InsertResponse }
     * 
     */
    public InsertResponse createInsertResponse() {
        return new InsertResponse();
    }

    /**
     * Create an instance of {@link CheckPurchaseProduct }
     * 
     */
    public CheckPurchaseProduct createCheckPurchaseProduct() {
        return new CheckPurchaseProduct();
    }

    /**
     * Create an instance of {@link LogoffResponse }
     * 
     */
    public LogoffResponse createLogoffResponse() {
        return new LogoffResponse();
    }

    /**
     * Create an instance of {@link CreateUpgradePaymentOrderResponse }
     * 
     */
    public CreateUpgradePaymentOrderResponse createCreateUpgradePaymentOrderResponse() {
        return new CreateUpgradePaymentOrderResponse();
    }

    /**
     * Create an instance of {@link GetLastLoginUserByOpenId }
     * 
     */
    public GetLastLoginUserByOpenId createGetLastLoginUserByOpenId() {
        return new GetLastLoginUserByOpenId();
    }

    /**
     * Create an instance of {@link GetWechatUserDataByAccountNum }
     * 
     */
    public GetWechatUserDataByAccountNum createGetWechatUserDataByAccountNum() {
        return new GetWechatUserDataByAccountNum();
    }

    /**
     * Create an instance of {@link PaymentHandlerServiceResponse }
     * 
     */
    public PaymentHandlerServiceResponse createPaymentHandlerServiceResponse() {
        return new PaymentHandlerServiceResponse();
    }

    /**
     * Create an instance of {@link CloseWechatUserProfile }
     * 
     */
    public CloseWechatUserProfile createCloseWechatUserProfile() {
        return new CloseWechatUserProfile();
    }

    /**
     * Create an instance of {@link ValidateLogin }
     * 
     */
    public ValidateLogin createValidateLogin() {
        return new ValidateLogin();
    }

    /**
     * Create an instance of {@link GetNewPackageAfterUpgradeResponse }
     * 
     */
    public GetNewPackageAfterUpgradeResponse createGetNewPackageAfterUpgradeResponse() {
        return new GetNewPackageAfterUpgradeResponse();
    }

    /**
     * Create an instance of {@link GetParentOrderInfo }
     * 
     */
    public GetParentOrderInfo createGetParentOrderInfo() {
        return new GetParentOrderInfo();
    }

    /**
     * Create an instance of {@link GetInvoiceInformationResponse }
     * 
     */
    public GetInvoiceInformationResponse createGetInvoiceInformationResponse() {
        return new GetInvoiceInformationResponse();
    }

    /**
     * Create an instance of {@link GetVehicleInfo }
     * 
     */
    public GetVehicleInfo createGetVehicleInfo() {
        return new GetVehicleInfo();
    }

    /**
     * Create an instance of {@link IsReceiveDidiResponse }
     * 
     */
    public IsReceiveDidiResponse createIsReceiveDidiResponse() {
        return new IsReceiveDidiResponse();
    }

    /**
     * Create an instance of {@link CreateUpgradePaymentOrder }
     * 
     */
    public CreateUpgradePaymentOrder createCreateUpgradePaymentOrder() {
        return new CreateUpgradePaymentOrder();
    }

    /**
     * Create an instance of {@link CreateTransactionResponse }
     * 
     */
    public CreateTransactionResponse createCreateTransactionResponse() {
        return new CreateTransactionResponse();
    }

    /**
     * Create an instance of {@link GetOpenIdByAccountNumResponse }
     * 
     */
    public GetOpenIdByAccountNumResponse createGetOpenIdByAccountNumResponse() {
        return new GetOpenIdByAccountNumResponse();
    }

    /**
     * Create an instance of {@link Logoff }
     * 
     */
    public Logoff createLogoff() {
        return new Logoff();
    }

    /**
     * Create an instance of {@link CheckTransaction }
     * 
     */
    public CheckTransaction createCheckTransaction() {
        return new CheckTransaction();
    }

    /**
     * Create an instance of {@link UpdateLoginTimes }
     * 
     */
    public UpdateLoginTimes createUpdateLoginTimes() {
        return new UpdateLoginTimes();
    }

    /**
     * Create an instance of {@link SyncAMPWifiAccountResponse }
     * 
     */
    public SyncAMPWifiAccountResponse createSyncAMPWifiAccountResponse() {
        return new SyncAMPWifiAccountResponse();
    }

    /**
     * Create an instance of {@link GetInvoiceInformation }
     * 
     */
    public GetInvoiceInformation createGetInvoiceInformation() {
        return new GetInvoiceInformation();
    }

    /**
     * Create an instance of {@link CreatePaymentOrder }
     * 
     */
    public CreatePaymentOrder createCreatePaymentOrder() {
        return new CreatePaymentOrder();
    }

    /**
     * Create an instance of {@link CreateWechatUserProfile }
     * 
     */
    public CreateWechatUserProfile createCreateWechatUserProfile() {
        return new CreateWechatUserProfile();
    }

    /**
     * Create an instance of {@link GetParentOrderInfoResponse }
     * 
     */
    public GetParentOrderInfoResponse createGetParentOrderInfoResponse() {
        return new GetParentOrderInfoResponse();
    }

    /**
     * Create an instance of {@link GetPromotionInfo }
     * 
     */
    public GetPromotionInfo createGetPromotionInfo() {
        return new GetPromotionInfo();
    }

    /**
     * Create an instance of {@link PaymentHandlerService }
     * 
     */
    public PaymentHandlerService createPaymentHandlerService() {
        return new PaymentHandlerService();
    }

    /**
     * Create an instance of {@link IsWinBackOrEarlyBirdResponse }
     * 
     */
    public IsWinBackOrEarlyBirdResponse createIsWinBackOrEarlyBirdResponse() {
        return new IsWinBackOrEarlyBirdResponse();
    }

    /**
     * Create an instance of {@link InsertInvoiceInfo }
     * 
     */
    public InsertInvoiceInfo createInsertInvoiceInfo() {
        return new InsertInvoiceInfo();
    }

    /**
     * Create an instance of {@link InsertInvoiceInfoResponse }
     * 
     */
    public InsertInvoiceInfoResponse createInsertInvoiceInfoResponse() {
        return new InsertInvoiceInfoResponse();
    }

    /**
     * Create an instance of {@link GetWechatUserDataByAccountNumResponse }
     * 
     */
    public GetWechatUserDataByAccountNumResponse createGetWechatUserDataByAccountNumResponse() {
        return new GetWechatUserDataByAccountNumResponse();
    }

    /**
     * Create an instance of {@link Insert }
     * 
     */
    public Insert createInsert() {
        return new Insert();
    }

    /**
     * Create an instance of {@link CheckOrderPaied }
     * 
     */
    public CheckOrderPaied createCheckOrderPaied() {
        return new CheckOrderPaied();
    }

    /**
     * Create an instance of {@link ValidateLoginResponse }
     * 
     */
    public ValidateLoginResponse createValidateLoginResponse() {
        return new ValidateLoginResponse();
    }

    /**
     * Create an instance of {@link IsReceiveDidi }
     * 
     */
    public IsReceiveDidi createIsReceiveDidi() {
        return new IsReceiveDidi();
    }

    /**
     * Create an instance of {@link SendInvoiceEmail }
     * 
     */
    public SendInvoiceEmail createSendInvoiceEmail() {
        return new SendInvoiceEmail();
    }

    /**
     * Create an instance of {@link CloseWechatUserProfileResponse }
     * 
     */
    public CloseWechatUserProfileResponse createCloseWechatUserProfileResponse() {
        return new CloseWechatUserProfileResponse();
    }

    /**
     * Create an instance of {@link GetPromotionInfoResponse }
     * 
     */
    public GetPromotionInfoResponse createGetPromotionInfoResponse() {
        return new GetPromotionInfoResponse();
    }

    /**
     * Create an instance of {@link SyncAccntResponse }
     * 
     */
    public SyncAccntResponse createSyncAccntResponse() {
        return new SyncAccntResponse();
    }

    /**
     * Create an instance of {@link CreateWechatUserProfileResponse }
     * 
     */
    public CreateWechatUserProfileResponse createCreateWechatUserProfileResponse() {
        return new CreateWechatUserProfileResponse();
    }

    /**
     * Create an instance of {@link GetProdInfoResponse }
     * 
     */
    public GetProdInfoResponse createGetProdInfoResponse() {
        return new GetProdInfoResponse();
    }

    /**
     * Create an instance of {@link GetCurrentAccountInfo }
     * 
     */
    public GetCurrentAccountInfo createGetCurrentAccountInfo() {
        return new GetCurrentAccountInfo();
    }

    /**
     * Create an instance of {@link IsNewFollowReciveDidi }
     * 
     */
    public IsNewFollowReciveDidi createIsNewFollowReciveDidi() {
        return new IsNewFollowReciveDidi();
    }

    /**
     * Create an instance of {@link UpdateWechatMessageHistoryResponse }
     * 
     */
    public UpdateWechatMessageHistoryResponse createUpdateWechatMessageHistoryResponse() {
        return new UpdateWechatMessageHistoryResponse();
    }

    /**
     * Create an instance of {@link GetChildOrderInfo }
     * 
     */
    public GetChildOrderInfo createGetChildOrderInfo() {
        return new GetChildOrderInfo();
    }

    /**
     * Create an instance of {@link GetTransactionByOrderNum }
     * 
     */
    public GetTransactionByOrderNum createGetTransactionByOrderNum() {
        return new GetTransactionByOrderNum();
    }

    /**
     * Create an instance of {@link CheckOrderPaiedResponse }
     * 
     */
    public CheckOrderPaiedResponse createCheckOrderPaiedResponse() {
        return new CheckOrderPaiedResponse();
    }

    /**
     * Create an instance of {@link GetLastLoginUserByOpenIdResponse }
     * 
     */
    public GetLastLoginUserByOpenIdResponse createGetLastLoginUserByOpenIdResponse() {
        return new GetLastLoginUserByOpenIdResponse();
    }

    /**
     * Create an instance of {@link SyncAccnt }
     * 
     */
    public SyncAccnt createSyncAccnt() {
        return new SyncAccnt();
    }

    /**
     * Create an instance of {@link UpdateTransaction }
     * 
     */
    public UpdateTransaction createUpdateTransaction() {
        return new UpdateTransaction();
    }

    /**
     * Create an instance of {@link GetProdInfo }
     * 
     */
    public GetProdInfo createGetProdInfo() {
        return new GetProdInfo();
    }

    /**
     * Create an instance of {@link IsNewFollowReciveDidiResponse }
     * 
     */
    public IsNewFollowReciveDidiResponse createIsNewFollowReciveDidiResponse() {
        return new IsNewFollowReciveDidiResponse();
    }

    /**
     * Create an instance of {@link CheckPurchaseProductResponse }
     * 
     */
    public CheckPurchaseProductResponse createCheckPurchaseProductResponse() {
        return new CheckPurchaseProductResponse();
    }

    /**
     * Create an instance of {@link CreatePaymentOrderResponse }
     * 
     */
    public CreatePaymentOrderResponse createCreatePaymentOrderResponse() {
        return new CreatePaymentOrderResponse();
    }

    /**
     * Create an instance of {@link GetTransactionByOrderNumResponse }
     * 
     */
    public GetTransactionByOrderNumResponse createGetTransactionByOrderNumResponse() {
        return new GetTransactionByOrderNumResponse();
    }

    /**
     * Create an instance of {@link UpdateOrderStatus }
     * 
     */
    public UpdateOrderStatus createUpdateOrderStatus() {
        return new UpdateOrderStatus();
    }

    /**
     * Create an instance of {@link Exception }
     * 
     */
    public Exception createException() {
        return new Exception();
    }

    /**
     * Create an instance of {@link SendInvoiceEmailResponse }
     * 
     */
    public SendInvoiceEmailResponse createSendInvoiceEmailResponse() {
        return new SendInvoiceEmailResponse();
    }

    /**
     * Create an instance of {@link GetOpenIdByAccountNum }
     * 
     */
    public GetOpenIdByAccountNum createGetOpenIdByAccountNum() {
        return new GetOpenIdByAccountNum();
    }

    /**
     * Create an instance of {@link GetChildOrderInfoResponse }
     * 
     */
    public GetChildOrderInfoResponse createGetChildOrderInfoResponse() {
        return new GetChildOrderInfoResponse();
    }

    /**
     * Create an instance of {@link GetNewPackageAfterUpgrade }
     * 
     */
    public GetNewPackageAfterUpgrade createGetNewPackageAfterUpgrade() {
        return new GetNewPackageAfterUpgrade();
    }

    /**
     * Create an instance of {@link UpdateTransactionResponse }
     * 
     */
    public UpdateTransactionResponse createUpdateTransactionResponse() {
        return new UpdateTransactionResponse();
    }

    /**
     * Create an instance of {@link SyncAMPWifiAccount }
     * 
     */
    public SyncAMPWifiAccount createSyncAMPWifiAccount() {
        return new SyncAMPWifiAccount();
    }

    /**
     * Create an instance of {@link UpdateLoginTimesResponse }
     * 
     */
    public UpdateLoginTimesResponse createUpdateLoginTimesResponse() {
        return new UpdateLoginTimesResponse();
    }

    /**
     * Create an instance of {@link GetCurrentAccountInfoResponse }
     * 
     */
    public GetCurrentAccountInfoResponse createGetCurrentAccountInfoResponse() {
        return new GetCurrentAccountInfoResponse();
    }

    /**
     * Create an instance of {@link GetActiveAccountByOpenIdResponse }
     * 
     */
    public GetActiveAccountByOpenIdResponse createGetActiveAccountByOpenIdResponse() {
        return new GetActiveAccountByOpenIdResponse();
    }

    /**
     * Create an instance of {@link CreateTransaction }
     * 
     */
    public CreateTransaction createCreateTransaction() {
        return new CreateTransaction();
    }

    /**
     * Create an instance of {@link ServiceOrder }
     * 
     */
    public ServiceOrder createServiceOrder() {
        return new ServiceOrder();
    }

    /**
     * Create an instance of {@link PromotionCategoryResult }
     * 
     */
    public PromotionCategoryResult createPromotionCategoryResult() {
        return new PromotionCategoryResult();
    }

    /**
     * Create an instance of {@link TransactionRequest }
     * 
     */
    public TransactionRequest createTransactionRequest() {
        return new TransactionRequest();
    }

    /**
     * Create an instance of {@link VehicleInfoResponse }
     * 
     */
    public VehicleInfoResponse createVehicleInfoResponse() {
        return new VehicleInfoResponse();
    }

    /**
     * Create an instance of {@link ProductInfo }
     * 
     */
    public ProductInfo createProductInfo() {
        return new ProductInfo();
    }

    /**
     * Create an instance of {@link PackageUpgradeRequest }
     * 
     */
    public PackageUpgradeRequest createPackageUpgradeRequest() {
        return new PackageUpgradeRequest();
    }

    /**
     * Create an instance of {@link PackageUpgradeResponse }
     * 
     */
    public PackageUpgradeResponse createPackageUpgradeResponse() {
        return new PackageUpgradeResponse();
    }

    /**
     * Create an instance of {@link Timestamp }
     * 
     */
    public Timestamp createTimestamp() {
        return new Timestamp();
    }

    /**
     * Create an instance of {@link ProductInfoResponse }
     * 
     */
    public ProductInfoResponse createProductInfoResponse() {
        return new ProductInfoResponse();
    }

    /**
     * Create an instance of {@link QueryOrderByParentOrderNumResponse }
     * 
     */
    public QueryOrderByParentOrderNumResponse createQueryOrderByParentOrderNumResponse() {
        return new QueryOrderByParentOrderNumResponse();
    }

    /**
     * Create an instance of {@link Transaction }
     * 
     */
    public Transaction createTransaction() {
        return new Transaction();
    }

    /**
     * Create an instance of {@link InvoiceInfoRequest }
     * 
     */
    public InvoiceInfoRequest createInvoiceInfoRequest() {
        return new InvoiceInfoRequest();
    }

    /**
     * Create an instance of {@link PackageInfoResponse }
     * 
     */
    public PackageInfoResponse createPackageInfoResponse() {
        return new PackageInfoResponse();
    }

    /**
     * Create an instance of {@link PaymentResponse }
     * 
     */
    public PaymentResponse createPaymentResponse() {
        return new PaymentResponse();
    }

    /**
     * Create an instance of {@link PaymentOrderResponse }
     * 
     */
    public PaymentOrderResponse createPaymentOrderResponse() {
        return new PaymentOrderResponse();
    }

    /**
     * Create an instance of {@link AccountInfoResponse }
     * 
     */
    public AccountInfoResponse createAccountInfoResponse() {
        return new AccountInfoResponse();
    }

    /**
     * Create an instance of {@link PaymentResultMessage }
     * 
     */
    public PaymentResultMessage createPaymentResultMessage() {
        return new PaymentResultMessage();
    }

    /**
     * Create an instance of {@link PromotionInfoWS }
     * 
     */
    public PromotionInfoWS createPromotionInfoWS() {
        return new PromotionInfoWS();
    }

    /**
     * Create an instance of {@link PromotionRule }
     * 
     */
    public PromotionRule createPromotionRule() {
        return new PromotionRule();
    }

    /**
     * Create an instance of {@link TransactionResponse }
     * 
     */
    public TransactionResponse createTransactionResponse() {
        return new TransactionResponse();
    }

    /**
     * Create an instance of {@link WechatUserDataResponse }
     * 
     */
    public WechatUserDataResponse createWechatUserDataResponse() {
        return new WechatUserDataResponse();
    }

    /**
     * Create an instance of {@link PromotionInfoResponse }
     * 
     */
    public PromotionInfoResponse createPromotionInfoResponse() {
        return new PromotionInfoResponse();
    }

    /**
     * Create an instance of {@link PurchaseProductResponse }
     * 
     */
    public PurchaseProductResponse createPurchaseProductResponse() {
        return new PurchaseProductResponse();
    }

    /**
     * Create an instance of {@link QueryChildOrdersByParentOrderNumResponse }
     * 
     */
    public QueryChildOrdersByParentOrderNumResponse createQueryChildOrdersByParentOrderNumResponse() {
        return new QueryChildOrdersByParentOrderNumResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ValidateLogin }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.ws.htichina.com/", name = "validateLogin")
    public JAXBElement<ValidateLogin> createValidateLogin(ValidateLogin value) {
        return new JAXBElement<ValidateLogin>(_ValidateLogin_QNAME, ValidateLogin.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CloseWechatUserProfile }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.ws.htichina.com/", name = "closeWechatUserProfile")
    public JAXBElement<CloseWechatUserProfile> createCloseWechatUserProfile(CloseWechatUserProfile value) {
        return new JAXBElement<CloseWechatUserProfile>(_CloseWechatUserProfile_QNAME, CloseWechatUserProfile.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetWechatUserDataByAccountNum }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.ws.htichina.com/", name = "getWechatUserDataByAccountNum")
    public JAXBElement<GetWechatUserDataByAccountNum> createGetWechatUserDataByAccountNum(GetWechatUserDataByAccountNum value) {
        return new JAXBElement<GetWechatUserDataByAccountNum>(_GetWechatUserDataByAccountNum_QNAME, GetWechatUserDataByAccountNum.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateUpgradePaymentOrderResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.ws.htichina.com/", name = "createUpgradePaymentOrderResponse")
    public JAXBElement<CreateUpgradePaymentOrderResponse> createCreateUpgradePaymentOrderResponse(CreateUpgradePaymentOrderResponse value) {
        return new JAXBElement<CreateUpgradePaymentOrderResponse>(_CreateUpgradePaymentOrderResponse_QNAME, CreateUpgradePaymentOrderResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLastLoginUserByOpenId }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.ws.htichina.com/", name = "getLastLoginUserByOpenId")
    public JAXBElement<GetLastLoginUserByOpenId> createGetLastLoginUserByOpenId(GetLastLoginUserByOpenId value) {
        return new JAXBElement<GetLastLoginUserByOpenId>(_GetLastLoginUserByOpenId_QNAME, GetLastLoginUserByOpenId.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckPurchaseProduct }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.ws.htichina.com/", name = "checkPurchaseProduct")
    public JAXBElement<CheckPurchaseProduct> createCheckPurchaseProduct(CheckPurchaseProduct value) {
        return new JAXBElement<CheckPurchaseProduct>(_CheckPurchaseProduct_QNAME, CheckPurchaseProduct.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LogoffResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.ws.htichina.com/", name = "logoffResponse")
    public JAXBElement<LogoffResponse> createLogoffResponse(LogoffResponse value) {
        return new JAXBElement<LogoffResponse>(_LogoffResponse_QNAME, LogoffResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PaymentHandlerServiceResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.ws.htichina.com/", name = "paymentHandlerServiceResponse")
    public JAXBElement<PaymentHandlerServiceResponse> createPaymentHandlerServiceResponse(PaymentHandlerServiceResponse value) {
        return new JAXBElement<PaymentHandlerServiceResponse>(_PaymentHandlerServiceResponse_QNAME, PaymentHandlerServiceResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetActiveAccountByOpenId }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.ws.htichina.com/", name = "getActiveAccountByOpenId")
    public JAXBElement<GetActiveAccountByOpenId> createGetActiveAccountByOpenId(GetActiveAccountByOpenId value) {
        return new JAXBElement<GetActiveAccountByOpenId>(_GetActiveAccountByOpenId_QNAME, GetActiveAccountByOpenId.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.ws.htichina.com/", name = "insertResponse")
    public JAXBElement<InsertResponse> createInsertResponse(InsertResponse value) {
        return new JAXBElement<InsertResponse>(_InsertResponse_QNAME, InsertResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateOrderStatusResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.ws.htichina.com/", name = "updateOrderStatusResponse")
    public JAXBElement<UpdateOrderStatusResponse> createUpdateOrderStatusResponse(UpdateOrderStatusResponse value) {
        return new JAXBElement<UpdateOrderStatusResponse>(_UpdateOrderStatusResponse_QNAME, UpdateOrderStatusResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckTransactionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.ws.htichina.com/", name = "checkTransactionResponse")
    public JAXBElement<CheckTransactionResponse> createCheckTransactionResponse(CheckTransactionResponse value) {
        return new JAXBElement<CheckTransactionResponse>(_CheckTransactionResponse_QNAME, CheckTransactionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateWechatMessageHistory }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.ws.htichina.com/", name = "updateWechatMessageHistory")
    public JAXBElement<UpdateWechatMessageHistory> createUpdateWechatMessageHistory(UpdateWechatMessageHistory value) {
        return new JAXBElement<UpdateWechatMessageHistory>(_UpdateWechatMessageHistory_QNAME, UpdateWechatMessageHistory.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetVehicleInfoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.ws.htichina.com/", name = "getVehicleInfoResponse")
    public JAXBElement<GetVehicleInfoResponse> createGetVehicleInfoResponse(GetVehicleInfoResponse value) {
        return new JAXBElement<GetVehicleInfoResponse>(_GetVehicleInfoResponse_QNAME, GetVehicleInfoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IsWinBackOrEarlyBird }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.ws.htichina.com/", name = "isWinBackOrEarlyBird")
    public JAXBElement<IsWinBackOrEarlyBird> createIsWinBackOrEarlyBird(IsWinBackOrEarlyBird value) {
        return new JAXBElement<IsWinBackOrEarlyBird>(_IsWinBackOrEarlyBird_QNAME, IsWinBackOrEarlyBird.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreatePaymentOrder }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.ws.htichina.com/", name = "createPaymentOrder")
    public JAXBElement<CreatePaymentOrder> createCreatePaymentOrder(CreatePaymentOrder value) {
        return new JAXBElement<CreatePaymentOrder>(_CreatePaymentOrder_QNAME, CreatePaymentOrder.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateWechatUserProfile }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.ws.htichina.com/", name = "createWechatUserProfile")
    public JAXBElement<CreateWechatUserProfile> createCreateWechatUserProfile(CreateWechatUserProfile value) {
        return new JAXBElement<CreateWechatUserProfile>(_CreateWechatUserProfile_QNAME, CreateWechatUserProfile.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetParentOrderInfoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.ws.htichina.com/", name = "getParentOrderInfoResponse")
    public JAXBElement<GetParentOrderInfoResponse> createGetParentOrderInfoResponse(GetParentOrderInfoResponse value) {
        return new JAXBElement<GetParentOrderInfoResponse>(_GetParentOrderInfoResponse_QNAME, GetParentOrderInfoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetInvoiceInformation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.ws.htichina.com/", name = "getInvoiceInformation")
    public JAXBElement<GetInvoiceInformation> createGetInvoiceInformation(GetInvoiceInformation value) {
        return new JAXBElement<GetInvoiceInformation>(_GetInvoiceInformation_QNAME, GetInvoiceInformation.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SyncAMPWifiAccountResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.ws.htichina.com/", name = "syncAMPWifiAccountResponse")
    public JAXBElement<SyncAMPWifiAccountResponse> createSyncAMPWifiAccountResponse(SyncAMPWifiAccountResponse value) {
        return new JAXBElement<SyncAMPWifiAccountResponse>(_SyncAMPWifiAccountResponse_QNAME, SyncAMPWifiAccountResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetOpenIdByAccountNumResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.ws.htichina.com/", name = "getOpenIdByAccountNumResponse")
    public JAXBElement<GetOpenIdByAccountNumResponse> createGetOpenIdByAccountNumResponse(GetOpenIdByAccountNumResponse value) {
        return new JAXBElement<GetOpenIdByAccountNumResponse>(_GetOpenIdByAccountNumResponse_QNAME, GetOpenIdByAccountNumResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Logoff }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.ws.htichina.com/", name = "logoff")
    public JAXBElement<Logoff> createLogoff(Logoff value) {
        return new JAXBElement<Logoff>(_Logoff_QNAME, Logoff.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateTransactionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.ws.htichina.com/", name = "createTransactionResponse")
    public JAXBElement<CreateTransactionResponse> createCreateTransactionResponse(CreateTransactionResponse value) {
        return new JAXBElement<CreateTransactionResponse>(_CreateTransactionResponse_QNAME, CreateTransactionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateUpgradePaymentOrder }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.ws.htichina.com/", name = "createUpgradePaymentOrder")
    public JAXBElement<CreateUpgradePaymentOrder> createCreateUpgradePaymentOrder(CreateUpgradePaymentOrder value) {
        return new JAXBElement<CreateUpgradePaymentOrder>(_CreateUpgradePaymentOrder_QNAME, CreateUpgradePaymentOrder.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateLoginTimes }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.ws.htichina.com/", name = "updateLoginTimes")
    public JAXBElement<UpdateLoginTimes> createUpdateLoginTimes(UpdateLoginTimes value) {
        return new JAXBElement<UpdateLoginTimes>(_UpdateLoginTimes_QNAME, UpdateLoginTimes.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckTransaction }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.ws.htichina.com/", name = "checkTransaction")
    public JAXBElement<CheckTransaction> createCheckTransaction(CheckTransaction value) {
        return new JAXBElement<CheckTransaction>(_CheckTransaction_QNAME, CheckTransaction.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetInvoiceInformationResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.ws.htichina.com/", name = "getInvoiceInformationResponse")
    public JAXBElement<GetInvoiceInformationResponse> createGetInvoiceInformationResponse(GetInvoiceInformationResponse value) {
        return new JAXBElement<GetInvoiceInformationResponse>(_GetInvoiceInformationResponse_QNAME, GetInvoiceInformationResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IsReceiveDidiResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.ws.htichina.com/", name = "isReceiveDidiResponse")
    public JAXBElement<IsReceiveDidiResponse> createIsReceiveDidiResponse(IsReceiveDidiResponse value) {
        return new JAXBElement<IsReceiveDidiResponse>(_IsReceiveDidiResponse_QNAME, IsReceiveDidiResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetVehicleInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.ws.htichina.com/", name = "getVehicleInfo")
    public JAXBElement<GetVehicleInfo> createGetVehicleInfo(GetVehicleInfo value) {
        return new JAXBElement<GetVehicleInfo>(_GetVehicleInfo_QNAME, GetVehicleInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetNewPackageAfterUpgradeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.ws.htichina.com/", name = "getNewPackageAfterUpgradeResponse")
    public JAXBElement<GetNewPackageAfterUpgradeResponse> createGetNewPackageAfterUpgradeResponse(GetNewPackageAfterUpgradeResponse value) {
        return new JAXBElement<GetNewPackageAfterUpgradeResponse>(_GetNewPackageAfterUpgradeResponse_QNAME, GetNewPackageAfterUpgradeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetParentOrderInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.ws.htichina.com/", name = "getParentOrderInfo")
    public JAXBElement<GetParentOrderInfo> createGetParentOrderInfo(GetParentOrderInfo value) {
        return new JAXBElement<GetParentOrderInfo>(_GetParentOrderInfo_QNAME, GetParentOrderInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetProdInfoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.ws.htichina.com/", name = "getProdInfoResponse")
    public JAXBElement<GetProdInfoResponse> createGetProdInfoResponse(GetProdInfoResponse value) {
        return new JAXBElement<GetProdInfoResponse>(_GetProdInfoResponse_QNAME, GetProdInfoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCurrentAccountInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.ws.htichina.com/", name = "getCurrentAccountInfo")
    public JAXBElement<GetCurrentAccountInfo> createGetCurrentAccountInfo(GetCurrentAccountInfo value) {
        return new JAXBElement<GetCurrentAccountInfo>(_GetCurrentAccountInfo_QNAME, GetCurrentAccountInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IsNewFollowReciveDidi }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.ws.htichina.com/", name = "isNewFollowReciveDidi")
    public JAXBElement<IsNewFollowReciveDidi> createIsNewFollowReciveDidi(IsNewFollowReciveDidi value) {
        return new JAXBElement<IsNewFollowReciveDidi>(_IsNewFollowReciveDidi_QNAME, IsNewFollowReciveDidi.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateWechatMessageHistoryResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.ws.htichina.com/", name = "updateWechatMessageHistoryResponse")
    public JAXBElement<UpdateWechatMessageHistoryResponse> createUpdateWechatMessageHistoryResponse(UpdateWechatMessageHistoryResponse value) {
        return new JAXBElement<UpdateWechatMessageHistoryResponse>(_UpdateWechatMessageHistoryResponse_QNAME, UpdateWechatMessageHistoryResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateWechatUserProfileResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.ws.htichina.com/", name = "createWechatUserProfileResponse")
    public JAXBElement<CreateWechatUserProfileResponse> createCreateWechatUserProfileResponse(CreateWechatUserProfileResponse value) {
        return new JAXBElement<CreateWechatUserProfileResponse>(_CreateWechatUserProfileResponse_QNAME, CreateWechatUserProfileResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CloseWechatUserProfileResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.ws.htichina.com/", name = "closeWechatUserProfileResponse")
    public JAXBElement<CloseWechatUserProfileResponse> createCloseWechatUserProfileResponse(CloseWechatUserProfileResponse value) {
        return new JAXBElement<CloseWechatUserProfileResponse>(_CloseWechatUserProfileResponse_QNAME, CloseWechatUserProfileResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPromotionInfoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.ws.htichina.com/", name = "getPromotionInfoResponse")
    public JAXBElement<GetPromotionInfoResponse> createGetPromotionInfoResponse(GetPromotionInfoResponse value) {
        return new JAXBElement<GetPromotionInfoResponse>(_GetPromotionInfoResponse_QNAME, GetPromotionInfoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SyncAccntResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.ws.htichina.com/", name = "syncAccntResponse")
    public JAXBElement<SyncAccntResponse> createSyncAccntResponse(SyncAccntResponse value) {
        return new JAXBElement<SyncAccntResponse>(_SyncAccntResponse_QNAME, SyncAccntResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SendInvoiceEmail }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.ws.htichina.com/", name = "sendInvoiceEmail")
    public JAXBElement<SendInvoiceEmail> createSendInvoiceEmail(SendInvoiceEmail value) {
        return new JAXBElement<SendInvoiceEmail>(_SendInvoiceEmail_QNAME, SendInvoiceEmail.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckOrderPaied }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.ws.htichina.com/", name = "checkOrderPaied")
    public JAXBElement<CheckOrderPaied> createCheckOrderPaied(CheckOrderPaied value) {
        return new JAXBElement<CheckOrderPaied>(_CheckOrderPaied_QNAME, CheckOrderPaied.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ValidateLoginResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.ws.htichina.com/", name = "validateLoginResponse")
    public JAXBElement<ValidateLoginResponse> createValidateLoginResponse(ValidateLoginResponse value) {
        return new JAXBElement<ValidateLoginResponse>(_ValidateLoginResponse_QNAME, ValidateLoginResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetWechatUserDataByAccountNumResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.ws.htichina.com/", name = "getWechatUserDataByAccountNumResponse")
    public JAXBElement<GetWechatUserDataByAccountNumResponse> createGetWechatUserDataByAccountNumResponse(GetWechatUserDataByAccountNumResponse value) {
        return new JAXBElement<GetWechatUserDataByAccountNumResponse>(_GetWechatUserDataByAccountNumResponse_QNAME, GetWechatUserDataByAccountNumResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Insert }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.ws.htichina.com/", name = "insert")
    public JAXBElement<Insert> createInsert(Insert value) {
        return new JAXBElement<Insert>(_Insert_QNAME, Insert.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertInvoiceInfoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.ws.htichina.com/", name = "insertInvoiceInfoResponse")
    public JAXBElement<InsertInvoiceInfoResponse> createInsertInvoiceInfoResponse(InsertInvoiceInfoResponse value) {
        return new JAXBElement<InsertInvoiceInfoResponse>(_InsertInvoiceInfoResponse_QNAME, InsertInvoiceInfoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IsReceiveDidi }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.ws.htichina.com/", name = "isReceiveDidi")
    public JAXBElement<IsReceiveDidi> createIsReceiveDidi(IsReceiveDidi value) {
        return new JAXBElement<IsReceiveDidi>(_IsReceiveDidi_QNAME, IsReceiveDidi.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPromotionInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.ws.htichina.com/", name = "getPromotionInfo")
    public JAXBElement<GetPromotionInfo> createGetPromotionInfo(GetPromotionInfo value) {
        return new JAXBElement<GetPromotionInfo>(_GetPromotionInfo_QNAME, GetPromotionInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PaymentHandlerService }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.ws.htichina.com/", name = "paymentHandlerService")
    public JAXBElement<PaymentHandlerService> createPaymentHandlerService(PaymentHandlerService value) {
        return new JAXBElement<PaymentHandlerService>(_PaymentHandlerService_QNAME, PaymentHandlerService.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertInvoiceInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.ws.htichina.com/", name = "insertInvoiceInfo")
    public JAXBElement<InsertInvoiceInfo> createInsertInvoiceInfo(InsertInvoiceInfo value) {
        return new JAXBElement<InsertInvoiceInfo>(_InsertInvoiceInfo_QNAME, InsertInvoiceInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IsWinBackOrEarlyBirdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.ws.htichina.com/", name = "isWinBackOrEarlyBirdResponse")
    public JAXBElement<IsWinBackOrEarlyBirdResponse> createIsWinBackOrEarlyBirdResponse(IsWinBackOrEarlyBirdResponse value) {
        return new JAXBElement<IsWinBackOrEarlyBirdResponse>(_IsWinBackOrEarlyBirdResponse_QNAME, IsWinBackOrEarlyBirdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCurrentAccountInfoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.ws.htichina.com/", name = "getCurrentAccountInfoResponse")
    public JAXBElement<GetCurrentAccountInfoResponse> createGetCurrentAccountInfoResponse(GetCurrentAccountInfoResponse value) {
        return new JAXBElement<GetCurrentAccountInfoResponse>(_GetCurrentAccountInfoResponse_QNAME, GetCurrentAccountInfoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateLoginTimesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.ws.htichina.com/", name = "updateLoginTimesResponse")
    public JAXBElement<UpdateLoginTimesResponse> createUpdateLoginTimesResponse(UpdateLoginTimesResponse value) {
        return new JAXBElement<UpdateLoginTimesResponse>(_UpdateLoginTimesResponse_QNAME, UpdateLoginTimesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateTransaction }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.ws.htichina.com/", name = "createTransaction")
    public JAXBElement<CreateTransaction> createCreateTransaction(CreateTransaction value) {
        return new JAXBElement<CreateTransaction>(_CreateTransaction_QNAME, CreateTransaction.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetActiveAccountByOpenIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.ws.htichina.com/", name = "getActiveAccountByOpenIdResponse")
    public JAXBElement<GetActiveAccountByOpenIdResponse> createGetActiveAccountByOpenIdResponse(GetActiveAccountByOpenIdResponse value) {
        return new JAXBElement<GetActiveAccountByOpenIdResponse>(_GetActiveAccountByOpenIdResponse_QNAME, GetActiveAccountByOpenIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetChildOrderInfoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.ws.htichina.com/", name = "getChildOrderInfoResponse")
    public JAXBElement<GetChildOrderInfoResponse> createGetChildOrderInfoResponse(GetChildOrderInfoResponse value) {
        return new JAXBElement<GetChildOrderInfoResponse>(_GetChildOrderInfoResponse_QNAME, GetChildOrderInfoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetNewPackageAfterUpgrade }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.ws.htichina.com/", name = "getNewPackageAfterUpgrade")
    public JAXBElement<GetNewPackageAfterUpgrade> createGetNewPackageAfterUpgrade(GetNewPackageAfterUpgrade value) {
        return new JAXBElement<GetNewPackageAfterUpgrade>(_GetNewPackageAfterUpgrade_QNAME, GetNewPackageAfterUpgrade.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SyncAMPWifiAccount }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.ws.htichina.com/", name = "syncAMPWifiAccount")
    public JAXBElement<SyncAMPWifiAccount> createSyncAMPWifiAccount(SyncAMPWifiAccount value) {
        return new JAXBElement<SyncAMPWifiAccount>(_SyncAMPWifiAccount_QNAME, SyncAMPWifiAccount.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateTransactionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.ws.htichina.com/", name = "updateTransactionResponse")
    public JAXBElement<UpdateTransactionResponse> createUpdateTransactionResponse(UpdateTransactionResponse value) {
        return new JAXBElement<UpdateTransactionResponse>(_UpdateTransactionResponse_QNAME, UpdateTransactionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetProdInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.ws.htichina.com/", name = "getProdInfo")
    public JAXBElement<GetProdInfo> createGetProdInfo(GetProdInfo value) {
        return new JAXBElement<GetProdInfo>(_GetProdInfo_QNAME, GetProdInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IsNewFollowReciveDidiResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.ws.htichina.com/", name = "isNewFollowReciveDidiResponse")
    public JAXBElement<IsNewFollowReciveDidiResponse> createIsNewFollowReciveDidiResponse(IsNewFollowReciveDidiResponse value) {
        return new JAXBElement<IsNewFollowReciveDidiResponse>(_IsNewFollowReciveDidiResponse_QNAME, IsNewFollowReciveDidiResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetOpenIdByAccountNum }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.ws.htichina.com/", name = "getOpenIdByAccountNum")
    public JAXBElement<GetOpenIdByAccountNum> createGetOpenIdByAccountNum(GetOpenIdByAccountNum value) {
        return new JAXBElement<GetOpenIdByAccountNum>(_GetOpenIdByAccountNum_QNAME, GetOpenIdByAccountNum.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Exception }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.ws.htichina.com/", name = "Exception")
    public JAXBElement<Exception> createException(Exception value) {
        return new JAXBElement<Exception>(_Exception_QNAME, Exception.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SendInvoiceEmailResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.ws.htichina.com/", name = "sendInvoiceEmailResponse")
    public JAXBElement<SendInvoiceEmailResponse> createSendInvoiceEmailResponse(SendInvoiceEmailResponse value) {
        return new JAXBElement<SendInvoiceEmailResponse>(_SendInvoiceEmailResponse_QNAME, SendInvoiceEmailResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTransactionByOrderNumResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.ws.htichina.com/", name = "getTransactionByOrderNumResponse")
    public JAXBElement<GetTransactionByOrderNumResponse> createGetTransactionByOrderNumResponse(GetTransactionByOrderNumResponse value) {
        return new JAXBElement<GetTransactionByOrderNumResponse>(_GetTransactionByOrderNumResponse_QNAME, GetTransactionByOrderNumResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateOrderStatus }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.ws.htichina.com/", name = "updateOrderStatus")
    public JAXBElement<UpdateOrderStatus> createUpdateOrderStatus(UpdateOrderStatus value) {
        return new JAXBElement<UpdateOrderStatus>(_UpdateOrderStatus_QNAME, UpdateOrderStatus.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckPurchaseProductResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.ws.htichina.com/", name = "checkPurchaseProductResponse")
    public JAXBElement<CheckPurchaseProductResponse> createCheckPurchaseProductResponse(CheckPurchaseProductResponse value) {
        return new JAXBElement<CheckPurchaseProductResponse>(_CheckPurchaseProductResponse_QNAME, CheckPurchaseProductResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreatePaymentOrderResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.ws.htichina.com/", name = "createPaymentOrderResponse")
    public JAXBElement<CreatePaymentOrderResponse> createCreatePaymentOrderResponse(CreatePaymentOrderResponse value) {
        return new JAXBElement<CreatePaymentOrderResponse>(_CreatePaymentOrderResponse_QNAME, CreatePaymentOrderResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTransactionByOrderNum }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.ws.htichina.com/", name = "getTransactionByOrderNum")
    public JAXBElement<GetTransactionByOrderNum> createGetTransactionByOrderNum(GetTransactionByOrderNum value) {
        return new JAXBElement<GetTransactionByOrderNum>(_GetTransactionByOrderNum_QNAME, GetTransactionByOrderNum.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetChildOrderInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.ws.htichina.com/", name = "getChildOrderInfo")
    public JAXBElement<GetChildOrderInfo> createGetChildOrderInfo(GetChildOrderInfo value) {
        return new JAXBElement<GetChildOrderInfo>(_GetChildOrderInfo_QNAME, GetChildOrderInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SyncAccnt }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.ws.htichina.com/", name = "syncAccnt")
    public JAXBElement<SyncAccnt> createSyncAccnt(SyncAccnt value) {
        return new JAXBElement<SyncAccnt>(_SyncAccnt_QNAME, SyncAccnt.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateTransaction }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.ws.htichina.com/", name = "updateTransaction")
    public JAXBElement<UpdateTransaction> createUpdateTransaction(UpdateTransaction value) {
        return new JAXBElement<UpdateTransaction>(_UpdateTransaction_QNAME, UpdateTransaction.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLastLoginUserByOpenIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.ws.htichina.com/", name = "getLastLoginUserByOpenIdResponse")
    public JAXBElement<GetLastLoginUserByOpenIdResponse> createGetLastLoginUserByOpenIdResponse(GetLastLoginUserByOpenIdResponse value) {
        return new JAXBElement<GetLastLoginUserByOpenIdResponse>(_GetLastLoginUserByOpenIdResponse_QNAME, GetLastLoginUserByOpenIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckOrderPaiedResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.ws.htichina.com/", name = "checkOrderPaiedResponse")
    public JAXBElement<CheckOrderPaiedResponse> createCheckOrderPaiedResponse(CheckOrderPaiedResponse value) {
        return new JAXBElement<CheckOrderPaiedResponse>(_CheckOrderPaiedResponse_QNAME, CheckOrderPaiedResponse.class, null, value);
    }

}
