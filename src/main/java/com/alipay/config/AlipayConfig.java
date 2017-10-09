package com.alipay.config;

/* *
 *绫诲悕锛欰lipayConfig
 *鍔熻兘锛氬熀纭?閰嶇疆绫?
 *璇︾粏锛氳缃笎鎴锋湁鍏充俊鎭強杩斿洖璺緞
 *鐗堟湰锛?3.3
 *鏃ユ湡锛?2012-08-10
 *璇存槑锛?
 *浠ヤ笅浠ｇ爜鍙槸涓轰簡鏂逛究鍟嗘埛娴嬭瘯鑰屾彁渚涚殑鏍蜂緥浠ｇ爜锛屽晢鎴峰彲浠ユ牴鎹嚜宸辩綉绔欑殑闇?瑕侊紝鎸夌収鎶?鏈枃妗ｇ紪鍐?,骞堕潪涓?瀹氳浣跨敤璇ヤ唬鐮併??
 *璇ヤ唬鐮佷粎渚涘涔犲拰鐮旂┒鏀粯瀹濇帴鍙ｄ娇鐢紝鍙槸鎻愪緵涓?涓弬鑰冦??
	
 *鎻愮ず锛氬浣曡幏鍙栧畨鍏ㄦ牎楠岀爜鍜屽悎浣滆韩浠借?匢D
 *1.鐢ㄦ偍鐨勭绾︽敮浠樺疂璐﹀彿鐧诲綍鏀粯瀹濈綉绔?(www.alipay.com)
 *2.鐐瑰嚮鈥滃晢瀹舵湇鍔♀??(https://b.alipay.com/order/myOrder.htm)
 *3.鐐瑰嚮鈥滄煡璇㈠悎浣滆?呰韩浠?(PID)鈥濄?佲?滄煡璇㈠畨鍏ㄦ牎楠岀爜(Key)鈥?

 *瀹夊叏鏍￠獙鐮佹煡鐪嬫椂锛岃緭鍏ユ敮浠樺瘑鐮佸悗锛岄〉闈㈠憟鐏拌壊鐨勭幇璞★紝鎬庝箞鍔烇紵
 *瑙ｅ喅鏂规硶锛?
 *1銆佹鏌ユ祻瑙堝櫒閰嶇疆锛屼笉璁╂祻瑙堝櫒鍋氬脊妗嗗睆钄借缃?
 *2銆佹洿鎹㈡祻瑙堝櫒鎴栫數鑴戯紝閲嶆柊鐧诲綍鏌ヨ銆?
 */

import com.htichina.common.web.ConfigureInfo;
import com.htichina.web.common.B2CUtils;

public class AlipayConfig {
	
	//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓
	// 合作身份者ID，以2088开头由16位纯数字组成的字符串
//	public static String partner = "2088911512854510";
	public static String partner = ConfigureInfo.getAlipayPartner();

	//收款支付宝帐户
//	public static String seller_email = "botsali@chinatelematics.net";
	public static String seller_email = ConfigureInfo.getAlipaySellerEmail();

	// 交易安全检验码，由数字和字母组成的32位字符串
	// 如果签名方式设置为“MD5”时，请设置该参数
//	public static String key = "bjqth35ezgw71imzuvh1lxqa9k6kubaa";
	public static String key = "";

    // 商户的私钥
    // 如果签名方式设置为“0001”时，请设置该参数
//	public static String private_key = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBANK+khsn2H084Mee7IKDrBe7TEJcIl7C2cYg+Jsab+fFiXA89V+jcftWKiTdpdG+9e679fEUykDKXLvSeY2x0FfSjdu8eon43ujs6vpNC7YDRN8Wh3Fg5/3/ZSbgyNnO+cbUhFt2fcq2fVFh1iy7XcjkqrwR2Gycfuta8tr+EfHjAgMBAAECgYBSM6lT1E/6UbOvyYqhQfDvdMxDGiMB6Wj+gj/WaBJ8Si3YzL49Jsi/65UWuioCzUSqcUB2X9CgQw626FsnbNNBqMyojY2EHyYpiiSzKl1gIdSPSR5swRD0sEftu99hD3m64l/W5Kja83uJUaRc+6oJUB0vqTDqrmQ0NWsVI3P+EQJBAPX7Bub24L9d4exik5kLgTgrsUuP7Wri43Ujpq8QFdaTq1BJoX1Yd815MzHvkMRcHjd70qS1DC40nK7h8quFKnkCQQDbVB4B98WouM+jlgmtk3vvIi5ESPwHlpYdxdymW/O4hMSo8fqIEyvpFNBklIOrYxPlpl3hgCbstEEi56b+IGg7AkEApWSulWn2YHYdzLXTjJqBvmUShz41YyM/0amxEBD+vhL4o7l+jiuIEm6mD7OHYaCW6LOnRPw/Pmo92BEw/EdD8QJAFEKy+u+OfMWFuNDVWAl1u2Nm7rvnPDQ27c0nUt7Pps3s9MZVpFhRCBj6HzBw8VYXsnEp3vjdn6QPGFBZ5sPLnQJBAOUtkzgLa4GajB7sxP8zSpJHMtaQA1z/flCBchc0mZaa+RDTtzuWjjuVhArVISQsaadmuS2evnp6OcP9IDf61o4=";
	public static String private_key = ConfigureInfo.getAlipayAppPrivateKey();

    // 支付宝的公钥
    // 如果签名方式设置为“0001”时，请设置该参数
	// partner public key
//	public static String ali_public_key  = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCnxj/9qwVfgoUh/y2W89L6BkRAFljhNhgPdyPuBV64bfQNN1PjbCzkIM6qRdKBoLPXmKKMiFYnkd6rAoprih3/PrQEB/VsW8OoM8fxn67UDYuyBTqA23MML9q1+ilIZwBC2AQ2UBVOrFXfFl75p6/B5KsiNG9zpgmLCUYuLkxpLQIDAQAB";
	// open platform public key
//	public static String ali_public_key  = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDDI6d306Q8fIfCOaTXyiUeJHkrIvYISRcc73s3vF1ZT7XN8RNPwJxo8pWaJMmvyTn9N4HQ632qJBVHf8sxHi/fEsraprwCtzvzQETrNRwVxLO5jVmRGi60j8Ue1efIlzPXV9je9mkjzOmdssymZkh2QhUrCmZYI/FCEa3/cNMW0QIDAQAB";
	// wap public key
//	public static String ali_public_key  = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDEsNKVEN2e5tM3gEGnRDslJY2MXn81mpkPjX3l64kQj/3AnTHMAxSy77gSuGCWExSe+Lnwd8oA8f0zFHxjQ1+sK8VERIcwiCfkpKZCo9ZAcDd5D8muflGWIOUQ6iZQXFdw4THbr5AQapVCTO+qNlgg7Mra/OZMsRvj8NJhFI5yEQIDAQAB";
	public static String ali_public_key  = ConfigureInfo.getAlipayAliPublicKey();

	//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑


	// 调试用，创建TXT日志文件夹路径
	public static String log_path = "D:\\";

	// 字符编码格式 目前支持  utf-8
	public static String input_charset = "utf-8";

	// 签名方式，选择项：0001(RSA)、MD5
	public static String sign_type = "0001";
	// 无线的产品中，签名方式为rsa时，sign_type需赋值为0001而不是RSA

}
