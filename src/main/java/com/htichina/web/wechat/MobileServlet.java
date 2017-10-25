package com.htichina.web.wechat;

import com.tencent.common.GetWxOrderno;
import com.tencent.common.MD5Util;
import com.tencent.common.Sha1Util;
import org.apache.log4j.Logger;
import org.owasp.esapi.ESAPI;
import org.richfaces.json.JSONException;
import org.richfaces.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by yiming on 2015/5/4.
 */
public class MobileServlet extends HttpServlet {
	private static Logger logger = Logger.getLogger(MobileServlet.class
			.getName());

	String APP_ID = "wx0d80eb9179924a76";
	String PARTNER_ID = "1312468101";
	String PARTNER_KEY = "66jkjdas2qda213523sd2e12jlkjo432";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		logger.debug("in MobileServlet");
		// clear the session
		req.getSession().invalidate();
		// String pkg="";
		String acct = req.getParameter("acct");
		logger.info("acct=" + ESAPI.encoder().encodeForHTML(acct));
		String pkg = req.getParameter("pkg");
		logger.info("pkg=" + ESAPI.encoder().encodeForHTML(pkg));
		String price = req.getParameter("price");
		logger.info("price=" + ESAPI.encoder().encodeForHTML(price));
		
		String pkgname;
		/*2017-10-25;Alex:==换成equal，去掉;CR-代码规范-->*/
		if("1".equals(pkg)){
			pkgname="乐享套餐";
		}else{
			pkgname="尊享套餐";
		}

		Demo demo = new Demo();
		String url = "https://stgchina.cntelematics.com/htib2c-mobile/notifyServlet";

		String nonceStr = demo.getNonceStr();
		SortedMap<String, String> packageParams = new TreeMap<String, String>();
		packageParams.put("appid", APP_ID);
		packageParams.put("mch_id", PARTNER_ID);
		packageParams.put("nonce_str", nonceStr);
		packageParams.put("body", pkgname);
		packageParams.put("out_trade_no", nonceStr);
		packageParams.put("total_fee", price);
		packageParams.put("spbill_create_ip", "127.0.0.1");
		packageParams.put("notify_url", url);
		packageParams.put("trade_type", "APP");
		String sign = createSign(packageParams);
		logger.info("sign: " + ESAPI.encoder().encodeForHTML(sign));

		String xml = "<xml>" + "<appid>" + APP_ID + "</appid>" + "<mch_id>"
				+ PARTNER_ID + "</mch_id>" + "<nonce_str>" + nonceStr
				+ "</nonce_str>" + "<sign>" + sign + "</sign>" + "<body>"
				+ pkgname + "</body>" + "<out_trade_no>" + nonceStr
				+ "</out_trade_no>" + "<total_fee>" + price + "</total_fee>"
				+ "<spbill_create_ip>" + "127.0.0.1" + "</spbill_create_ip>"
				+ "<notify_url>" + url + "</notify_url>"
				+ "<trade_type>" + "APP" + "</trade_type>" + "</xml>";

		logger.info(ESAPI.encoder().encodeForHTML(xml));
		String createOrderURL = "https://api.mch.weixin.qq.com/pay/unifiedorder";
		String prepay_id = new GetWxOrderno().getPayNo(createOrderURL, xml);
		// System.out.println(" prepayid :" + prepay_id);
		logger.info("prepayid :" + ESAPI.encoder().encodeForHTML(prepay_id));
		
		SortedMap<String, String> finalpackage = new TreeMap<String, String>();
		String timestamp = Sha1Util.getTimeStamp();
     	finalpackage.put("appid", APP_ID);
		finalpackage.put("partnerid", PARTNER_ID);
		finalpackage.put("prepayid", prepay_id);
		finalpackage.put("noncestr", nonceStr);
		finalpackage.put("timestamp", timestamp);
		finalpackage.put("package", "Sign=WXPay");
		String finalsign = createSign(finalpackage);
		
		JSONObject json = new JSONObject();
		try {
			json.put("prepayid", prepay_id);
			json.put("appid", APP_ID);
			json.put("partnerid", PARTNER_ID);
			json.put("noncestr", nonceStr);
			json.put("timestamp", timestamp);
			json.put("package", "Sign=WXPay");
			json.put("sign", finalsign);
			
			resp.getWriter().print(json.toString());
			return;
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String createSign(SortedMap<String, String> packageParams) {
		StringBuffer sb = new StringBuffer();
		Set es = packageParams.entrySet();
		Iterator it = es.iterator();
		while (it.hasNext()) {
			Map.Entry entry = (Map.Entry) it.next();
			String k = (String) entry.getKey();
			String v = (String) entry.getValue();
			if (null != v && !"".equals(v) && !"sign".equals(k)
					&& !"key".equals(k)) {
				sb.append(k + "=" + v + "&");
			}
		}
		sb.append("key=" + PARTNER_KEY);
		String sign = MD5Util.MD5Encode(sb.toString(), "UTF-8").toUpperCase();
		return sign;

	}

	public static String convertStreamToString(InputStream is) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		StringBuilder sb = new StringBuilder();

		String line = null;
		try {
			while ((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return sb.toString();
	}
}
