package com.htichina.web.wechat;

import java.util.SortedMap;
import java.util.TreeMap;

import com.htichina.common.web.ConfigureInfo;
import com.htichina.web.common.B2CUtils;
import com.tencent.common.*;
import org.apache.log4j.Logger;
import org.owasp.esapi.ESAPI;


/**
 * @author ex_yangxiaoyi
 * 
 */
public class Demo {
	private static Logger logger = Logger.getLogger(Demo.class.getName());

	private static String appid = ConfigureInfo.getWechatAppid();
	private static String appsecret = ConfigureInfo.getWechatAppSecret();
	private static String partner = ConfigureInfo.getWechatPartner();
	private static String partnerkey = ConfigureInfo.getWechatPartnerKey();
	private static String openId = "";
	private static String notifyurl = ConfigureInfo.getWechatNotifyUrl();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//微信支付jsApi
		WxPayDto tpWxPay = new WxPayDto();
		tpWxPay.setOpenId(openId);
		tpWxPay.setBody("商品信息");
		tpWxPay.setOrderId(getNonceStr());
		tpWxPay.setSpbillCreateIp("127.0.0.1");
		tpWxPay.setTotalFee("0.01");
	    getPackage(tpWxPay);

	    //扫码支付
	    WxPayDto tpWxPay1 = new WxPayDto();
	    tpWxPay1.setBody("商品信息");
	    tpWxPay1.setOrderId(getNonceStr());
	    tpWxPay1.setSpbillCreateIp("127.0.0.1");
	    tpWxPay1.setTotalFee("0.01");
		getCodeurl(tpWxPay1);
	}

	/**
	 * 获取微信扫码支付二维码连??
	 */
	public static String getCodeurl(WxPayDto tpWxPayDto){


		String orderId = tpWxPayDto.getOrderId();
		String attach = "";

		String totalFee = getMoney(tpWxPayDto.getTotalFee());

		String spbill_create_ip = tpWxPayDto.getSpbillCreateIp();
		String notify_url = notifyurl;
		String trade_type = "NATIVE";


		String mch_id = partner;

		String nonce_str = getNonceStr();

		String body = tpWxPayDto.getBody();

		String out_trade_no = orderId;

		SortedMap<String, String> packageParams = new TreeMap<String, String>();
		packageParams.put("appid", appid);
		packageParams.put("mch_id", mch_id);
		packageParams.put("nonce_str", nonce_str);
		packageParams.put("body", body);
		packageParams.put("attach", attach);
		packageParams.put("out_trade_no", out_trade_no);

		// 这里写的金额?? 分到时修??
		packageParams.put("total_fee", totalFee);
		packageParams.put("spbill_create_ip", spbill_create_ip);
		packageParams.put("notify_url", notify_url);

		packageParams.put("trade_type", trade_type);

		RequestHandler reqHandler = new RequestHandler(null, null);
		reqHandler.init(appid, appsecret, partnerkey);

		String sign = reqHandler.createSign(packageParams);
		String xml = "<xml>" + "<appid>" + appid + "</appid>" + "<mch_id>"
				+ mch_id + "</mch_id>" + "<nonce_str>" + nonce_str
				+ "</nonce_str>" + "<sign>" + sign + "</sign>"
				+ "<body><![CDATA[" + body + "]]></body>"
				+ "<out_trade_no>" + out_trade_no
				+ "</out_trade_no>" + "<attach>" + attach + "</attach>"
				+ "<total_fee>" + totalFee + "</total_fee>"
				+ "<spbill_create_ip>" + spbill_create_ip
				+ "</spbill_create_ip>" + "<notify_url>" + notify_url
				+ "</notify_url>" + "<trade_type>" + trade_type
				+ "</trade_type>" + "</xml>";
		String code_url = "";
		String createOrderURL = "https://api.mch.weixin.qq.com/pay/unifiedorder";


		code_url = new GetWxOrderno().getCodeUrl(createOrderURL, xml);
//		System.out.println("code_url----------------"+code_url);
		logger.info("code_url----------------"+ ESAPI.encoder().encodeForHTML(code_url));


		return code_url;
	}


	/**
	 * 获取请求预支付id报文
	 * @return
	 */
	@SuppressWarnings("static-access")
	public static String getPackage(WxPayDto tpWxPayDto) {

		String openId = tpWxPayDto.getOpenId();

		String orderId = tpWxPayDto.getOrderId();

		String attach = "";

		String totalFee = getMoney(tpWxPayDto.getTotalFee());

		String spbill_create_ip = tpWxPayDto.getSpbillCreateIp();

		String notify_url = notifyurl;
		String trade_type = "JSAPI";


		String mch_id = partner;
		String nonce_str = getNonceStr();

		String body = tpWxPayDto.getBody();

		String out_trade_no = orderId;

		SortedMap<String, String> packageParams = new TreeMap<String, String>();
		packageParams.put("appid", appid);
		packageParams.put("mch_id", mch_id);
		packageParams.put("nonce_str", nonce_str);
		packageParams.put("body", body);
		packageParams.put("attach", attach);
		packageParams.put("out_trade_no", out_trade_no);
		packageParams.put("total_fee", totalFee);
		packageParams.put("spbill_create_ip", spbill_create_ip);
		packageParams.put("notify_url", notify_url);
		packageParams.put("trade_type", trade_type);
		packageParams.put("openid", openId);

		RequestHandler reqHandler = new RequestHandler(null, null);
		reqHandler.init(appid, appsecret, partnerkey);

		String sign = reqHandler.createSign(packageParams);
		String xml = "<xml>" + "<appid>" + appid + "</appid>" + "<mch_id>"
				+ mch_id + "</mch_id>" + "<nonce_str>" + nonce_str
				+ "</nonce_str>" + "<sign>" + sign + "</sign>"
				+ "<body><![CDATA[" + body + "]]></body>"
				+ "<out_trade_no>" + out_trade_no
				+ "</out_trade_no>" + "<attach>" + attach + "</attach>"
				+ "<total_fee>" + totalFee + "</total_fee>"
				+ "<spbill_create_ip>" + spbill_create_ip
				+ "</spbill_create_ip>" + "<notify_url>" + notify_url
				+ "</notify_url>" + "<trade_type>" + trade_type
				+ "</trade_type>" + "<openid>" + openId + "</openid>"
				+ "</xml>";
//		System.out.println(xml);
		String prepay_id = "";
		String createOrderURL = "https://api.mch.weixin.qq.com/pay/unifiedorder";
		prepay_id = new GetWxOrderno().getPayNo(createOrderURL, xml);
//		System.out.println("prepayid :" + prepay_id);
		logger.info("xml-----------------------"+xml);
		logger.info("appid-----------------------"+appid);
		logger.info("mch_id-----------------------"+mch_id);
		logger.info("nonce_str-----------------------"+nonce_str);
		logger.info("sign-----------------------"+sign);
		logger.info("body-----------------------"+body);
		logger.info("out_trade_no-----------------------"+out_trade_no);
		logger.info("attach-----------------------"+attach);
		logger.info("totalFee-----------------------"+totalFee);
		logger.info("spbill_create_ip-----------------------"+spbill_create_ip);
		logger.info("notify_url-----------------------"+notify_url);
		logger.info("trade_type-----------------------"+trade_type);
		logger.info("openId-----------------------"+openId);

		logger.info("prepay_id-----------------------"+prepay_id);


		SortedMap<String, String> finalpackage = new TreeMap<String, String>();
		String timestamp = Sha1Util.getTimeStamp();
		String packages = "prepay_id="+prepay_id;
		finalpackage.put("appId", appid);
		finalpackage.put("timeStamp", timestamp);
		finalpackage.put("nonceStr", nonce_str);
		finalpackage.put("package", packages);
		finalpackage.put("signType", "MD5");

		String finalsign = reqHandler.createSign(finalpackage);

		String finaPackage = "\"appId\":\"" + appid + "\",\"timeStamp\":\"" + timestamp
		+ "\",\"nonceStr\":\"" + nonce_str + "\",\"package\":\""
		+ packages + "\",\"signType\" : \"MD5" + "\",\"paySign\":\""
		+ finalsign + "\"";

//		System.out.println("V3 jsApi package:"+finaPackage);
//		logger.info("V3 jsApi package:"+ESAPI.encoder().encodeForHTML(finaPackage));
		return finaPackage;
	}

	/**
	 * 获取随机字符??
	 * @return
	 */
	public static String getNonceStr() {
		// 随机??
		String currTime = TenpayUtil.getCurrTime();
		// 8位日??
		String strTime = currTime.substring(8, currTime.length());
		// 四位随机??
		String strRandom = TenpayUtil.buildRandom(4) + "";
		// 10位序列号,可以自行调整??
		return strTime + strRandom;
	}

	/**
	 * 元转换成??
	 * @param money
	 * @return
	 */
	public static String getMoney(String amount) {
		if(amount==null){
			return "";
		}
		// 金额转化为分为单??
		String currency =  amount.replaceAll("\\$|\\￥|\\,", "");  //处理包含, ??或??$的金??
        int index = currency.indexOf(".");  
        int length = currency.length();  
        Long amLong = 0l;  
        if(index == -1){  
            amLong = Long.valueOf(currency+"00");  
        }else if(length - index >= 3){  
            amLong = Long.valueOf((currency.substring(0, index+3)).replace(".", ""));  
        }else if(length - index == 2){  
            amLong = Long.valueOf((currency.substring(0, index+2)).replace(".", "")+0);  
        }else{  
            amLong = Long.valueOf((currency.substring(0, index+1)).replace(".", "")+"00");  
        }  
        return amLong.toString(); 
	}

}
