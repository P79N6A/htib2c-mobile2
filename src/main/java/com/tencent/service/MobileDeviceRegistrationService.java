package com.tencent.service;


import com.htichina.common.web.ConfigureInfo;
import com.htichina.web.POC.MobileBean;
import com.tencent.common.http.HttpClientUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.log4j.Logger;
import org.owasp.esapi.ESAPI;

import java.text.SimpleDateFormat;
import java.util.*;

public class MobileDeviceRegistrationService {

	private static Logger logger = Logger.getLogger(MobileDeviceRegistrationService.class.getName());

	/**
	 * 获取用户信息
	 * @param accountID
	 * @return
	 */
	public static List<MobileBean> getDeliveryMethods(String accountID) {
		List<MobileBean> list=new ArrayList<MobileBean>();
		String url = ConfigureInfo.getDeliverymethodsUrl();
		String apiKey = ConfigureInfo.getMobiledeviceregistrationapikey();

		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/json");
		headers.put("api_key", apiKey);

		String str = "yyyy-MM-dd'T'HH:mm:ss.SSS";
		SimpleDateFormat sdf = new SimpleDateFormat(str);
		String traceTimeStamp = sdf.format(new Date()) + "Z";

		String body = "{" +
				"\"Data\": {" +
				"\"AccountID\": \"" + accountID + "\"," +
				"\"TraceID\": \"" + UUID.randomUUID().toString() + "\"," +
				"\"TraceTimestamp\": \"" + traceTimeStamp + "\"" +
				"}" +
				"}";
		logger.info("getDeliveryMethods's body : " + ESAPI.encoder().encodeForHTML(body));
		System.out.println("getDeliveryMethods's body : " + ESAPI.encoder().encodeForHTML(body));
		StringBuffer responseStr = new StringBuffer();
		HttpResponse httpResponse = HttpClientUtil.doSSLPost(url, headers, body, "utf-8", responseStr);
		if(httpResponse == null) {
			logger.error("getDeliveryMethods post error, httpResponse is null");
		} else if(httpResponse.getStatusLine().getStatusCode() == 200){
			System.out.println(responseStr);
			logger.info("getDeliveryMethods post success, responseStr : " + ESAPI.encoder().encodeForHTML(responseStr.toString()));
			JSONObject obj = JSONObject.fromObject(responseStr.toString());

			if(obj != null && obj.has("Response") && obj.getJSONObject("Response") != null && obj.getJSONObject("Response").has("ResponseCode") && obj.getJSONObject("Response").getString("ResponseCode") != null && "2000".equals(obj.getJSONObject("Response").getString("ResponseCode"))) {
				JSONObject data = obj.getJSONObject("Data");
				if(data != null) {
					JSONObject phones = data.getJSONObject("Phones");
					if(phones != null) {
						JSONArray phoneArr = phones.getJSONArray("Phone");
						if(phoneArr != null) {
							@SuppressWarnings("unchecked")
							Iterator<Object> it = phoneArr.iterator();

							while (it.hasNext()) {
								MobileBean vo = new MobileBean();
								JSONObject ob = (JSONObject) it.next();
								if(ob.getString("Number") !=null ){
									vo.setNumber(ob.getString("Number"));
								}
								if(ob.getString("CommunicationToken")!=null){
									vo.setCommunicationToken(ob.getString("CommunicationToken"));
								}
								if(ob.getString("PrimaryContactIndicator")!=null){
									vo.setPrimaryContactIndicator(ob.getString("PrimaryContactIndicator"));
								}

								list.add(vo);
							}
						}
					}
				}
			}
		} else {
			logger.error("getDeliveryMethods post error, responseStr : " + ESAPI.encoder().encodeForHTML(responseStr.toString()));
		}
		return list;
	}

	/**
	 * 发送手机验证码
	 * @param accountID
	 * @param communicationToken
	 * @return
	 */
	public static boolean registration(String accountID, String communicationToken) {
		boolean bool = false;
		String url = ConfigureInfo.getRegistrationUrl();
		String apiKey = ConfigureInfo.getMobiledeviceregistrationapikey();

		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/json");
		headers.put("api_key", apiKey);

		String str = "yyyy-MM-dd'T'HH:mm:ss.SSS";
		SimpleDateFormat sdf = new SimpleDateFormat(str);
		String timeStamp = sdf.format(new Date()) + "Z";

		String body = "{" +
				"\"Data\": {" +
				"\"CommunicationToken\": \"" + communicationToken + "\"," +
				"\"UserId\": \"" + accountID + "\"" +
				"}, " +
				"\"context\": {" +
				"\"ApplicationName\": \"iPhone\", " +
				"\"Organization\": \"Mercedes-Benz\", " +
				"\"Region\": \"China\", " +
				"\"SourceName\": \"MAPP\", " +
				"\"Timestamp\": \"" + timeStamp + "\", " +
				"\"TransactionId\": \"" + UUID.randomUUID().toString() + "\"" +
				"}" +
				"}";

		logger.info("registration's body : " + ESAPI.encoder().encodeForHTML(body));
		System.out.println("registration's body : " + ESAPI.encoder().encodeForHTML(body));

		StringBuffer responseStr = new StringBuffer();
		HttpResponse httpResponse = HttpClientUtil.doSSLPost(url, headers, body, "utf-8", responseStr);
		if(httpResponse == null) {
			logger.error("registration post error, httpResponse is null");
		} else if(httpResponse.getStatusLine().getStatusCode() == 200){
			System.out.println(responseStr);
			logger.info("registration post success, responseStr : " + ESAPI.encoder().encodeForHTML(responseStr.toString()));
			JSONObject obj = JSONObject.fromObject(responseStr.toString());

			if(obj != null && obj.has("Response") && obj.getJSONObject("Response") != null && obj.getJSONObject("Response").has("ResponseCode") && obj.getJSONObject("Response").getString("ResponseCode") != null && "2000".equals(obj.getJSONObject("Response").getString("ResponseCode"))) {
				bool = true;
			}
		} else {
			logger.error("registration post error, responseStr : " + ESAPI.encoder().encodeForHTML(responseStr.toString()));
		}
		return bool;
	}

	/**
	 * 验证手机验证码
	 * @param accountID
	 * @param registrationCode
	 * @return
	 */
	public static boolean validateRegistration (String accountID, String registrationCode) {
		boolean bool = false;
		String url = ConfigureInfo.getValidateregistrationUrl();
		String apiKey = ConfigureInfo.getMobiledeviceregistrationapikey();

		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/json");
		headers.put("api_key", apiKey);

		String str = "yyyy-MM-dd'T'HH:mm:ss.SSS";
		SimpleDateFormat sdf = new SimpleDateFormat(str);
		String timeStamp = sdf.format(new Date()) + "Z";

		String body = "{" +
				"\"Data\": {" +
				"\"CSR\": \"LQo=\", " +
				"\"DeviceName\": \"SRINI12345\", " +
				"\"RegistrationCode\": \"" + registrationCode + "\", " +
				"\"UserID\": \"" + accountID + "\"" +
				"}, " +
				"\"context\": {" +
				"\"ApplicationName\": \"iPhone\", " +
				"\"Organization\": \"Mercedes-Benz\", " +
				"\"Region\": \"China\", " +
				"\"SourceName\": \"MAPP\", " +
				"\"Timestamp\": \"" + timeStamp + "\", " +
				"\"TransactionId\": \"" + UUID.randomUUID().toString() + "\"" +
				"}" +
				"}";

		logger.info("validateRegistration's body : " + ESAPI.encoder().encodeForHTML(body));
		System.out.println("validateRegistration's body : " + ESAPI.encoder().encodeForHTML(body));

		StringBuffer responseStr = new StringBuffer();
		HttpResponse httpResponse = HttpClientUtil.doSSLPost(url, headers, body, "utf-8", responseStr);
		if(httpResponse == null) {
			logger.error("validateRegistration post error, httpResponse is null");
		} else if(httpResponse.getStatusLine().getStatusCode() == 200){
			System.out.println(responseStr);
			logger.info("validateRegistration post success, responseStr : " + ESAPI.encoder().encodeForHTML(responseStr.toString()));
			JSONObject obj = JSONObject.fromObject(responseStr.toString());

			if(obj != null && obj.has("Response") && obj.getJSONObject("Response") != null && obj.getJSONObject("Response").has("ResponseCode") && obj.getJSONObject("Response").getString("ResponseCode") != null && "2000".equals(obj.getJSONObject("Response").getString("ResponseCode"))) {
				bool = true;
			}
		} else {
			logger.error("validateRegistration post error, responseStr : " + ESAPI.encoder().encodeForHTML(responseStr.toString()));
		}
		return bool;
	}

	public static void main(String[] args) {

		MobileDeviceRegistrationService mdrs = new MobileDeviceRegistrationService();

		mdrs.getDeliveryMethods("10576849");

		//System.out.println(mdrs.registration("10576849", "3cc77512b22da526f2e6e538a5e3b8ce6abd2b8ec66299ec4f8ec640b78812c6"));

	}
}
