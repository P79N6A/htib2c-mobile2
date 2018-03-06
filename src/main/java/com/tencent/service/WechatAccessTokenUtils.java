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
		logger.info("-------有功能发出需要token的请求，当前时间："+sf.format(newDate)+"--------");
		//如果access_token已经生成过，而且此刻距离上次生成时间不超过指定时间，则继续使用之前的token
		if(!StringUtils.isEmpty(access_token)){
			logger.info("-------上次生成token时间："+sf.format(generate_date));
			logger.info("-------指定的生成token的时间频率：满"+token_generate_interval+"分钟生成一次-------");
			int gapMinutes = UtilDate.getGapMinutes(generate_date, newDate);
			if(gapMinutes<token_generate_interval){
				logger.info("-------没有到下一次触发时间，继续使用之前的token----"+access_token);
				return access_token;
			}else{
				logger.info("-------触发时间到了，马上生成新的token-------");
			}
		}else{
			logger.info("-------当前时间是第一次获取token，马上生成新的token-------");
		}
		
		String wechatToken = getNewToken();
		logger.info("----------生成新的token-------------"+wechatToken);
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

