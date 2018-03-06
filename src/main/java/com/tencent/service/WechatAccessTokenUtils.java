package com.tencent.service;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alipay.util.UtilDate;
import com.htichina.common.web.ConfigureInfo;
import com.htichina.common.web.Constant;
import com.htichina.web.common.B2CUtils;

/**
 * Tommy,2018-2-28,调整微信token的获取方式
 */
public class WechatAccessTokenUtils{
	static String access_token;
	static Date generate_date;
	static Logger logger = Logger.getLogger(WechatAccessTokenUtils.class.getName());
	
	public synchronized static String getWechatToken()
			throws ClientProtocolException, IOException {
		//获取token生成的时间频率的配置信息
		String token_interval = B2CUtils.getPropertyFromFile(Constant.WECHAT_TOKEN_GENERATE_INTERVAL);
		int token_generate_interval = StringUtils.isEmpty(token_interval)?0:Integer.valueOf(token_interval);
		
		Date newDate = new Date();
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		logger.info("-------one request needs token，the time is ："+sf.format(newDate)+"--------");
		//如果access_token已经生成过，而且此刻距离上次生成时间不超过指定时间，则继续使用之前的token
		if(!StringUtils.isEmpty(access_token)){
			logger.info("-------There is one token already generated before, and the generated time is:"+sf.format(generate_date));
			logger.info("-------According to system settings, the time interval to generate new token is："+token_generate_interval+" minutes.");
			int gapMinutes = UtilDate.getGapMinutes(generate_date, newDate);
			if(gapMinutes<token_generate_interval){
				logger.info("-------It isn't time to generate new token, so reuse the last token:----"+access_token);
				return access_token;
			}else{
				logger.info("-------It's time to generate new token.-------");
			}
		}else{
			logger.info("-------There is no token generated before, so system will generate a new token immediately.-------");
		}
		
		String wechatToken = getNewToken();
		logger.info("----------The new token is:-------------"+wechatToken);
		access_token = wechatToken;
		generate_date = newDate;
		
		return access_token; 
	}
	
	private static String getNewToken()
			throws ClientProtocolException, IOException {
		String appid = ConfigureInfo.getWechatAppid();
        String appsecret = ConfigureInfo.getWechatAppSecret();
		logger.info("appid="+appid+";appsecret="+appsecret);
		
		String token = "";
		String weChatTokenKey = "access_token";
		HttpClient httpclient = new DefaultHttpClient();
		HttpGet httpgets = new HttpGet("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="
				+ appid + "&secret=" + appsecret + "");
		HttpResponse response = httpclient.execute(httpgets);
		String jsonStr = EntityUtils.toString(response.getEntity(), "UTF-8");

		JSONObject jsonObj = JSON.parseObject(jsonStr);
		token = jsonObj.getString(weChatTokenKey);
		return token;
	}
	
	/*public static String getWechatTokenTemp() throws ClientProtocolException, IOException{
		String appid = PropertyReadUtil.getValue(TagGenerationJobConstants.WECHAT_APP_ID);
		String appsecret = PropertyReadUtil.getValue(TagGenerationJobConstants.WECHAT_APP_SECRET);
		logger.info("appid="+appid+";appsecret="+appsecret);
		String wechatToken = WechatTagUtils.getWechatToken(appid, appsecret);
		logger.info("----到达微信token临界点 且 原来token已无效 的情况下------生成新的token-------------"+wechatToken);
		access_token = wechatToken;
		generate_date = new Date();
		return access_token; 
	}*/
	
	
}

