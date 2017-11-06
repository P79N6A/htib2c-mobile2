package com.htichina.common.web;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

/**
 * Created by yiming on 2014/8/6.
 */
public class Constant {
    public static final String WEB_SELECT_ACCOUNT_NUM = "accountNum";
    public static final String WEB_SELECT_VIN = "vin";

    public static final String WEB_WIFI_FLAG_Y = "Y";
    public static final String WEB_WIFI_FLAG_N = "N";

    public static final String SERVICE_ON = "ON";
    public static final String SERVICE_OFF = "OFF";

    public static final String DB_ACCOUNT_TYPE_SUBSCRIBER = "Subscriber";
    public static final String DB_ACCOUNT_TYPE_OEM = "OEM";
    public static final String DB_ACCOUNT_TYPE_TEST = "Test";
    public static final String DB_ACCOUNT_TYPE_DEMO = "Demo";

    public static final String DB_ACCOUNT_STATUS_ACTIVE = "Active";
    public static final String DB_ACCOUNT_STATUS_INACTIVE = "Inactive";
    public static final String DB_ACCOUNT_STATUS_CLOSED = "Closed";
    public static final String DB_ACCOUNT_STATUS_DECLINED = "Declined";

    public static final String DB_PACKAGE_ID_ONE = "1";
    public static final String DB_PACKAGE_ID_TWO = "2";
    public static final String DB_PACKAGE_ID_THREE = "3";

    public static final String DB_LANGUAGE_EN = "en";
    public static final String DB_LANGUAGE_ZH = "zh";

    public static final String DB_DATE_TYPE_DAY = "D";
    public static final String DB_DATE_TYPE_MONTH = "M";
    public static final String DB_DATE_TYPE_YEAR = "Y";

    public static final String WEB_DATE_FORMAT_DEFAULT = "yyyy-MM-dd HH:mm:ss";
    public static final String WEB_DATE_FORMAT_ID = "yyyyMMddHHmmss";
    public static final String DB_DATE_FORMAT_DEFAULT = "yyyy-MM-dd HH24:mi:ss";
    public static final SimpleDateFormat WEB_DATE_FORMATTER_DEFAULT = new SimpleDateFormat(WEB_DATE_FORMAT_DEFAULT);
    public static final SimpleDateFormat WEB_DATE_FORMATTER_ID = new SimpleDateFormat(WEB_DATE_FORMAT_ID);

    public static final String DEFAULT_WEB_MONEY_FORMAT = "##,###.00";
    public static final DecimalFormat WEB_MONEY_FORMATTER = new DecimalFormat(DEFAULT_WEB_MONEY_FORMAT);


    public static final String DB_ORDER_TYPE_B2C = "112002";


    public static final String DB_ORDER_STATUS_NEW = "105000";
    public static final String DB_ORDER_STATUS_PENDING_PAYMENT = "105001";
    public static final String DB_ORDER_STATUS_PAYMENT_FAILED = "105002";
    public static final String DB_ORDER_STATUS_PENDING_PROVISIONING = "105004";
    public static final String DB_ORDER_STATUS_PENDING_BASE_ORDER = "105006";
    public static final String DB_ORDER_STATUS_COMPLETED = "105008";
    public static final String DB_ORDER_STATUS_PENDING_FINANCE_APPROVAL = "105009";
    public static final String DB_ORDER_STATUS_FINANCE_REJECT = "105010";

    public static final String DB_EVENT_ACTIVITY_TYPE_CONFIGMBAPPS = "101013";
    public static final String DB_EVENT_ACTIVITY_TYPE_REQUEST_PAY = "101014";
    public static final String DB_EVENT_ACTIVITY_TYPE_REQUEST_FINANCE_APPROVAL = "101015";

    public static final String DB_EVENT_ACTIVITY_STATUS_SUCCESS = "115001";
    public static final String DB_EVENT_ACTIVITY_STATUS_FAILED = "115002";

    public static final int DB_ORDER_QUANTITY_DEFAULT = 1;

    public static final String DB_INVOICE_TYPE_PERSONAL = "1";
    public static final String DB_INVOICE_TYPE_COMPANY = "2";

    public static final String WEB_PAYMENT_CHANNEL_CHINAPAY    = "ChinaPay";

    public static final String WEB_PAYMENT_INTEGRATION_MODE_CALLBACK = "01";
    public static final String WEB_PAYMENT_INTEGRATION_MODE_TRANSFER = "02";

    public static final String DB_PAYMENT_CARD_TYPE_CREDIT = "01";
    public static final String DB_PAYMENT_CARD_TYPE_DEBIT = "02";


    public static final String DB_ORDER_PAYMENT_STATUS_PENDING = "108001";
    public static final String DB_ORDER_PAYMENT_STATUS_PAID = "108002";

    public static final String DB_ORDER_PAYMENT_TYPE_ONLINE = "111001";
    public static final String DB_ORDER_PAYMENT_TYPE_OFFLINE = "111002";
    public static final String DB_ORDER_PAYMENT_TYPE_CHINAPAY = "111003";
    public static final String DB_ORDER_PAYMENT_TYPE_WIRETRANSFER = "111004";
    public static final String DB_ORDER_PAYMENT_TYPE_WEIXINPAY = "111005";
    public static final String DB_ORDER_PAYMENT_TYPE_ALIPAY    = "111006";


    public static final String DB_ORDER_CHANNEL_CALLCENTER = "109001";
    public static final String DB_ORDER_CHANNEL_CWP = "109002";
    public static final String DB_ORDER_CHANNEL_MOBILE = "109003";

    public static final String DB_ORDER_PAYMENT_CHANNEL_CALLBACK = "110001";
    public static final String DB_ORDER_PAYMENT_CHANNEL_TRANSFER = "110002";
    public static final String DB_ORDER_PAYMENT_CHANNEL_ONLINE = "110003";

    public static final String SERVICE_DNAPAY_RESPONSE_CODE_SUCCESS = "0000";
    public static final String SERVICE_DNAPAY_ORDER_STATE_PAID = "02";
    public static final String SERVICE_DNAPAY_ORDER_STATE_PAYFAILED = "05";


    public static final String SERVICE_B2C_PAYMENT_RESPONSE_CODE_SUCCESS = "00";

    public static final String DB_USER_ADMIN = "HTIDEV";

    public static final String DB_DATA_PLAN_STATUS_ACTIVE = "102001";
    public static final String DB_DATA_PLAN_STATUS_INACTIVE = "102002";

    public static final String DB_DATA_PLAN_TRANSACTION_TYPE_RECHARGE = "Recharge";
    public static final String DB_DATA_PLAN_TRANSACTION_TYPE_COMPENSATION = "Compensation";
    public static final String DB_DATA_PLAN_COMPENSATION_VOLUME_GENERAL = "20";
    public static final String DB_DATA_PLAN_COMPENSATION_VOLUME_LIVETRAFFIC = "21";

    public static final String DB_VEHICLE_WIFI_STATUS_ENABLE = "1";
    public static final String DB_VEHICLE_TRIAL_STATUS_ENABLE = "1";
    public static final String DB_VEHICLE_POOL_STATUS_ENABLE = "1";

    public static final String DB_PAYMENT_ID_TYPE_IDENTITY = "01";
    public static final String DB_PAYMENT_ID_TYPE_PASSPORT = "02";
    public static final String DB_PAYMENT_ID_TYPE_OFFICER = "03";
    public static final String DB_PAYMENT_ID_TYPE_TAIWAN = "04";

    public static final String DB_PACKAGE_TYPE_CE = "107004";
    public static final String DB_PACKAGE_TYPE_WIFI = "107003";
    public static final String DB_PACKAGE_TYPE_WIFI_PROMOTION = "107005";
    public static final String DB_PACKAGE_TYPE_BASE = "107006";
    public static final String DB_PACKAGE_TYPE_BASE_PROMOTION = "107007";
    public static final String DB_PACKAGE_TYPE_BASE_CUSTOMER_CARE = "107008";


    public static final String DB_SMS_TEMPLATE_TYPE_SMS = "sms";
    public static final String DB_SMS_TEMPLATE_TYPE_TXT = "txt";

    public static final String DB_SMS_TXT_SEND_STATUS_PENDING = "New";
    public static final String DB_SMS_TXT_SEND_STATUS_SENT = "Success";
    public static final String DB_SMS_TXT_SEND_STATUS_FAILED = "Failed";

    public static final String PAYMENT_PLATFORM = "paymentPlatform";
//    public final String PAYMENT_ALIPAY = "alipay";
//    public final String PAYMENT_WECHAT = "wechat";

    public static final String OPEN_ID = "openId";
    public static final String ACCOUNT_NUM = "accountNum";
    public static final String WECHAT_USER_INFO = "wechat_user_info";

    public static final String TARGET_PAGE = "targetPage";

    public static final String WECHAT_STATE = "state";
    public static final String WECHAT_STATE_ORDER = "startOrder";
    public static final String WECHAT_STATE_PROMOTION = "startPromotionOrder";
    public static final String ALIPAY_STATE_PROMOTION = "startAlipayPromotionOrder";
    public static final String WECHAT_STATE_LOGIN = "startLogin";
    public static final String WECHAT_STATE_APPLY_INVOICE = "startApplyInvoice";

    public static final String WECHAT_STATE_POC = "startPOC";
    public static final String VIOLATION_INQUIRY = "violationInquiry";


    public static final String DB_PACKAGE_CHANNEL_CALL_CENTER = "CC";
    public static final String DB_PACKAGE_CHANNEL_WE_CHAT = "WC";
    public static final String DB_PACKAGE_CHANNEL_ALIPAY = "AP";
//    public static void main(String[] args) {
//        double a = 1.3;
//        System.out.println(WEB_MONEY_FORMATTER.format(a));
//    }


//    public static final String WMAN_FHT_TOKEN = "16Ecf15rlg";//测试环境
    public static final String WMAN_FHT_TOKEN = "V9RDM4AzhK";
    public static final String WMAN_APP_ID = "fht30e981038f141b3c";
    public static final String WMAN_APP_SECRET = "b91826301c5b2d294876cff290f3d71f";

    //高德地图开发key
    public static final String MAP_KEY = "5951d0334cfd375f89a320bad75941f2";
    //车辆定位地图点名
    public static final String LOCATION_NAME = "车辆位置";
    // 发送POI成功返回提示
    public static final String SENDPOI_SUCCESS = "所选目标已发送成功";
    // 发送POI成功返回提示
    public static final String SENDPOI_FAILED = "发生错误，请重试。";
    // 发送POI无accountNumber提示
    public static final String SENDPOI_NULLACCOUNT = "发送位置失败，请登录账户再试。";
    // 默认poiName
    public static final String DEFAULT_POINAME = "目的地";


    //定位
    public static  final String HTTPS_LOCATEVEHICLE = "locatevehicle";
    //闪灯鸣笛表示
    public static  final String HTTPS_HORNLIGHT = "hornlight";
    //上锁
    public static  final String HTTPS_LOCK = "lock";
    //解锁
    public static  final String HTTPS_UNLOCK = "unlock";
    //发送POI
    public static  final String HTTPS_SENDPOI = "sendpoi";


    public static final String HTTPS_ACCOUNTNUM="accountNum";//必须有
    public static final String HTTPS_LATITUDE="latitude";//locate用
    public static final String HTTPS_LONGITUDE="longitude";//locate用
    public static final String HTTPS_PIN="pin";//开锁解锁用
    public static final String HTTPS_POINAME="poiName";


    public static final int FLASHTIME = 5;
    public static final int SERVICEDURATION = 10;
    public static final String OEM = "Mercedes-Benz";
    public static final String REGION = "China";// "US"; TODO update to china
    public static final String APPLICATION_NAME = "CWP";// "CWP";
    public static final String SOURCE_NAME = "WEB";//WEB
    public static final String WEBSITE = "MAPP";//MAPP

    public static final String HTTPS_TRANSACTIONID="transactionId";
    public static final String HTTPS_TIMESTAMP="timeStamp";
    public static final String HTTPS_TCUTYPE="tcuType";
    public static final String HTTPS_TCUID="tcuId";
    public static final String LOCATEPARAMTERKEY = "LOCATEPARAMTERKEY";
}
