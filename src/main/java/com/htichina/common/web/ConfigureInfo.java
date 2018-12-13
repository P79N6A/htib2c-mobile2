package com.htichina.common.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class ConfigureInfo {
    private static ApplicationContext appContext;

    static {
        appContext = new ClassPathXmlApplicationContext(
                "classpath:/ws_env/beanProperties.xml");
        appContext.getBean(ConfigureInfo.class);

    }

    @Value("#{configProperties['B2C.PaymentServiceEndPoint']}")
    private static String B2CPaymentServiceEndPoint;

    @Value("#{configProperties['wechat.appid']}")
    private static String wechatAppid;

    @Value("#{configProperties['wechat.appsecret']}")
    private static String wechatAppSecret;


    @Value("#{configProperties['wechat.partner']}")
    private static String wechatPartner;


    @Value("#{configProperties['wechat.partnerkey']}")
    private static String wechatPartnerKey;


    @Value("#{configProperties['wechat.notifyUrl']}")
    private static String wechatNotifyUrl;


    @Value("#{configProperties['wechat.payFailedUrl']}")
    private static String wechatPayFailedUrl;




    @Value("#{configProperties['alipay.appid']}")
    private static String alipayAppid;

    @Value("#{configProperties['alipay.partner']}")
    private static String alipayPartner;

    @Value("#{configProperties['alipay.seller_email']}")
    private static String alipaySellerEmail;

    @Value("#{configProperties['alipay.app_private_key']}")
    private static String alipayAppPrivateKey;

    @Value("#{configProperties['alipay.app_public_key']}")
    private static String alipayAppPublicKey;


    @Value("#{configProperties['alipay.ali_public_key']}")
    private static String alipayAliPublicKey;

    @Value("#{configProperties['alipay.payment_public_key']}")
    private static String alipayPaymentPublicKey;

    @Value("#{configProperties['alipay.notifyUrl']}")
    private static String alipayNotifyUrl;

    @Value("#{configProperties['alipay.callbackUrl']}")
    private static String alipayCallbackUrl;

    @Value("#{configProperties['alipay.payFailedUrl']}")
    private static String alipayPayFailedUrl;

    @Value("#{configProperties['getUserInfo_url']}")
    private static String getUserInfoUrl;

    @Value("#{configProperties['flashlights_url']}")
    private static String flashlightsUrl;

    @Value("#{configProperties['locatevehicle_url']}")
    private static String locatevehicleUrl;

    @Value("#{configProperties['locatevehiclefinalreq_url']}")
    private static String locatevehiclefinalreqUrl;

    @Value("#{configProperties['doorlockunlock_url']}")
    private static String doorlockunlockurl;

    @Value("#{configProperties['senddestination_url']}")
    private static String senddestinationUrl;

    @Value("#{configProperties['deliverymethods_url']}")
    private static String deliverymethodsUrl;

    @Value("#{configProperties['registration_url']}")
    private static String registrationUrl;

    @Value("#{configProperties['validateregistration_url']}")
    private static String validateregistrationUrl;

    @Value("#{configProperties['mobiledeviceregistration_apikey']}")
    private static String mobiledeviceregistrationapikey;

    @Value("#{configProperties['WechatLinkLogin']}")
    private static String WechatLinkLogin;
    @Value("#{configProperties['WechatLuckDraw']}")
    private static String wechatLuckDraw;

    public static String getWechatLinkLogin() {
        return WechatLinkLogin;
    }

    public static void setWechatLinkLogin(String wechatLinkLogin) {
        WechatLinkLogin = wechatLinkLogin;
    }

    public static String getMobiledeviceregistrationapikey() {
        return mobiledeviceregistrationapikey;
    }

    public static void setMobiledeviceregistrationapikey(
            String mobiledeviceregistrationapikey) {
        ConfigureInfo.mobiledeviceregistrationapikey = mobiledeviceregistrationapikey;
    }

    public static String getDeliverymethodsUrl() {
        return deliverymethodsUrl;
    }

    public static void setDeliverymethodsUrl(String deliverymethodsUrl) {
        ConfigureInfo.deliverymethodsUrl = deliverymethodsUrl;
    }

    public static String getRegistrationUrl() {
        return registrationUrl;
    }

    public static void setRegistrationUrl(String registrationUrl) {
        ConfigureInfo.registrationUrl = registrationUrl;
    }

    public static String getValidateregistrationUrl() {
        return validateregistrationUrl;
    }

    public static void setValidateregistrationUrl(String validateregistrationUrl) {
        ConfigureInfo.validateregistrationUrl = validateregistrationUrl;
    }

    public static String getFlashlightsUrl() {
        return flashlightsUrl;
    }

    public static void setFlashlightsUrl(String flashlightsUrl) {
        ConfigureInfo.flashlightsUrl = flashlightsUrl;
    }

    public static String getLocatevehicleUrl() {
        return locatevehicleUrl;
    }

    public static void setLocatevehicleUrl(String locatevehicleUrl) {
        ConfigureInfo.locatevehicleUrl = locatevehicleUrl;
    }

    public static String getLocatevehiclefinalreqUrl() {
        return locatevehiclefinalreqUrl;
    }

    public static void setLocatevehiclefinalreqUrl(String locatevehiclefinalreqUrl) {
        ConfigureInfo.locatevehiclefinalreqUrl = locatevehiclefinalreqUrl;
    }

    public static String getDoorlockunlockurl() {
        return doorlockunlockurl;
    }

    public static void setDoorlockunlockurl(String doorlockunlockurl) {
        ConfigureInfo.doorlockunlockurl = doorlockunlockurl;
    }

    public static String getSenddestinationUrl() {
        return senddestinationUrl;
    }

    public static void setSenddestinationUrl(String senddestinationUrl) {
        ConfigureInfo.senddestinationUrl = senddestinationUrl;
    }

    public static String getGetUserInfoUrl() {
        return getUserInfoUrl;
    }

    public static void setGetUserInfoUrl(String getUserInfoUrl) {
        ConfigureInfo.getUserInfoUrl = getUserInfoUrl;
    }

    public static String getB2CPaymentServiceEndPoint() {
        return B2CPaymentServiceEndPoint;
    }

    public static void setB2CPaymentServiceEndPoint(String b2CPaymentServiceEndPoint) {
        B2CPaymentServiceEndPoint = b2CPaymentServiceEndPoint;
    }

    public static String getWechatAppid() {
        return wechatAppid;
    }

    public static void setWechatAppid(String wechatAppid) {
        ConfigureInfo.wechatAppid = wechatAppid;
    }

    public static String getWechatAppSecret() {
        return wechatAppSecret;
    }

    public static void setWechatAppSecret(String wechatAppSecret) {
        ConfigureInfo.wechatAppSecret = wechatAppSecret;
    }

    public static String getWechatPartner() {
        return wechatPartner;
    }

    public static void setWechatPartner(String wechatPartner) {
        ConfigureInfo.wechatPartner = wechatPartner;
    }

    public static String getWechatPartnerKey() {
        return wechatPartnerKey;
    }

    public static void setWechatPartnerKey(String wechatPartnerKey) {
        ConfigureInfo.wechatPartnerKey = wechatPartnerKey;
    }

    public static String getWechatNotifyUrl() {
        return wechatNotifyUrl;
    }

    public static void setWechatNotifyUrl(String wechatNotifyUrl) {
        ConfigureInfo.wechatNotifyUrl = wechatNotifyUrl;
    }

    public static String getWechatPayFailedUrl() {
        return wechatPayFailedUrl;
    }

    public static void setWechatPayFailedUrl(String wechatPayFailedUrl) {
        ConfigureInfo.wechatPayFailedUrl = wechatPayFailedUrl;
    }


    public static String getAlipayAppid() {
        return alipayAppid;
    }

    public static void setAlipayAppid(String alipayAppid) {
        ConfigureInfo.alipayAppid = alipayAppid;
    }

    public static String getAlipayPartner() {
        return alipayPartner;
    }

    public static void setAlipayPartner(String alipayPartner) {
        ConfigureInfo.alipayPartner = alipayPartner;
    }

    public static String getAlipaySellerEmail() {
        return alipaySellerEmail;
    }

    public static void setAlipaySellerEmail(String alipaySellerEmail) {
        ConfigureInfo.alipaySellerEmail = alipaySellerEmail;
    }

//    public static String getAlipayKey() {
//        return alipayKey;
//    }
//
//    public static void setAlipayKey(String alipayKey) {
//        ConfigureInfo.alipayKey = alipayKey;
//    }
//
//    public static String getAlipayPrivateKey() {
//        return alipayPrivateKey;
//    }
//
//    public static void setAlipayPrivateKey(String alipayPrivateKey) {
//        ConfigureInfo.alipayPrivateKey = alipayPrivateKey;
//    }


    public static String getAlipayAppPrivateKey() {
        return alipayAppPrivateKey;
    }

    public static void setAlipayAppPrivateKey(String alipayAppPrivateKey) {
        ConfigureInfo.alipayAppPrivateKey = alipayAppPrivateKey;
    }

    public static String getAlipayAppPublicKey() {
        return alipayAppPublicKey;
    }

    public static void setAlipayAppPublicKey(String alipayAppPublicKey) {
        ConfigureInfo.alipayAppPublicKey = alipayAppPublicKey;
    }

    public static String getAlipayAliPublicKey() {
        return alipayAliPublicKey;
    }

    public static void setAlipayAliPublicKey(String alipayAliPublicKey) {
        ConfigureInfo.alipayAliPublicKey = alipayAliPublicKey;
    }

    public static String getAlipayNotifyUrl() {
        return alipayNotifyUrl;
    }

    public static void setAlipayNotifyUrl(String alipayNotifyUrl) {
        ConfigureInfo.alipayNotifyUrl = alipayNotifyUrl;
    }

    public static String getAlipayCallbackUrl() {
        return alipayCallbackUrl;
    }

    public static void setAlipayCallbackUrl(String alipayCallbackUrl) {
        ConfigureInfo.alipayCallbackUrl = alipayCallbackUrl;
    }

    public static String getAlipayPayFailedUrl() {
        return alipayPayFailedUrl;
    }

    public static void setAlipayPayFailedUrl(String alipayPayFailedUrl) {
        ConfigureInfo.alipayPayFailedUrl = alipayPayFailedUrl;
    }

    public static String getAlipayPaymentPublicKey() {
        return alipayPaymentPublicKey;
    }

    public static void setAlipayPaymentPublicKey(String alipayPaymentPublicKey) {
        ConfigureInfo.alipayPaymentPublicKey = alipayPaymentPublicKey;
    }

    public static String getWechatLuckDraw() {
        return wechatLuckDraw;
    }

    public static void setWechatLuckDraw(String wechatLuckDraw) {
        ConfigureInfo.wechatLuckDraw = wechatLuckDraw;
    }
}
