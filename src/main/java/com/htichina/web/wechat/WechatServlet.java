package com.htichina.web.wechat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.log4j.Logger;
import org.owasp.esapi.ESAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import com.htichina.common.web.ConfigureInfo;
import com.htichina.common.web.Constant;
import com.htichina.web.common.ViewPage;
import com.htichina.web.login.LoginBackingBean;
import com.htichina.web.order.OrderBackingBean;
import com.htichina.web.questionnaire.QuestionnaireBean;
import com.htichina.web.util.UUIDUtils;
import com.tencent.common.RandomStringGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by yiming on 2015/5/4.
 */
@Component("wechatServlet")
public class WechatServlet extends HttpServlet {
	private static Logger logger = Logger.getLogger(WechatServlet.class.getName());
	@Autowired(required = true)
	WebApplicationContext context;
	String oId;
	//	@Autowired(required = true)
	/*private LoginBackingBean loginBackingBean = new LoginBackingBean();
	private OrderBackingBean orderBackingBean = new OrderBackingBean();*/

//	@Autowired(required = true)
//	private OrderBackingBean orderBackingBean;

//	@Override
//	public void init(ServletConfig servletConfig) throws ServletException {
//		super.init(servletConfig);
////		ServletContext servletContext = this .getServletContext();
//////		ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
////		context = WebApplicationContextUtils.getWebApplicationContext(servletContext);
//
//		ServletContext servletContext = servletConfig.getServletContext();
//		WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
//		AutowireCapableBeanFactory autowireCapableBeanFactory = webApplicationContext.getAutowireCapableBeanFactory();
//		loginBackingBean = (LoginBackingBean) autowireCapableBeanFactory.configureBean(this, "loginBackingBean");
//	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String accessToken = null;
//		logger.infoln("in WeChatServlet");
		logger.debug("in WeChatServlet");

//		clear the session
		req.getSession().invalidate();
//		String pkg="";
		
		req.getSession().setAttribute(Constant.CSRFTOKEN, RandomStringGenerator.getCSRFToken());
		//req.getSession().setAttribute(Constant.CSRFTOKEN,  UUIDUtils.uuid()+UUIDUtils.uuid()+UUIDUtils.uuid()); 
		
		
		
		String code = req.getParameter("code");
//		logger.infoln(code);
		logger.info("code=" + ESAPI.encoder().encodeForHTML(code));
		String state = req.getParameter("state").split(",")[0];
		logger.info("state=" + ESAPI.encoder().encodeForHTML(state));
		HttpClient httpclient = new DefaultHttpClient();
		HttpGet httpgets = new HttpGet(
				"https://api.weixin.qq.com/sns/oauth2/access_token?"
						+ "appid=" + ConfigureInfo.getWechatAppid() + "&secret=" + ConfigureInfo.getWechatAppSecret()
						+ "&code=" + code + "&grant_type=authorization_code");
		HttpResponse response = httpclient.execute(httpgets);
		HttpEntity entity = response.getEntity();
		boolean F = true;
		if (entity != null) {
			InputStream instreams = entity.getContent();
			String str = convertStreamToString(instreams);
			//2017-10-25;Alex:优化代码，日志安全加密;CR-代码规范
			logger.info("str == "+ESAPI.encoder().encodeForHTML(str));
			if(str.indexOf("errcode") > -1){
				logger.debug("httpGet failed");
				F = false;
				LoginBackingBean loginBackingBean = (LoginBackingBean)context.getBean("loginBackingBean" );
				req.getRequestDispatcher(loginBackingBean.closeBrowser()).forward(req, resp);
			}
			else{
				logger.debug("Do something");
				logger.info(ESAPI.encoder().encodeForHTML(str));

				int m = str.indexOf("access_token");
				int n = str.indexOf("expires_in");

				accessToken = str.substring(m+15, n-3);
				logger.debug("accessToken=" + ESAPI.encoder().encodeForHTML(accessToken));

				int i = str.indexOf("openid");
				int j = str.indexOf("scope");
				String openId = str.substring(i + 9, j - 3);
//				oId = openId;
//			logger.infoln("openId: " + openId);
				//2017-10-25;Alex:优化代码，线程同步;CR-代码规范
				synchronized(this){
					oId = openId;
				}
//			System.out.println("openId: " + openId);
				logger.info("openId: " + ESAPI.encoder().encodeForHTML(openId));


				// get user base infor
//			String userInfoUrl = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=" + accessToken + "&openid="+ openId + "&lang=zh_CN";
				String userInfoUrl = "https://api.weixin.qq.com/sns/userinfo?access_token=" + accessToken + "&openid="+ openId + "&lang=zh_CN";
				logger.info("userInfoUrl= " + ESAPI.encoder().encodeForHTML(userInfoUrl));
				HttpGet httpgets2 = new HttpGet(userInfoUrl);
				HttpResponse response2 = httpclient.execute(httpgets2);
				HttpEntity entity2 = response2.getEntity();
				String userInfo = openId;
				String nickname = "";
				if (entity2 != null) {
					logger.info("entity2 is not null");
					InputStream instreams2 = entity2.getContent();
					String str2 = convertStreamToString(instreams2);
					logger.info(ESAPI.encoder().encodeForHTML(str2));
					userInfo = str2;
					int x = str2.indexOf("nickname");
					int y = str2.indexOf("\"sex\"");
					nickname = str2.substring(x + 11, y - 2);
					logger.info("nickname: " + ESAPI.encoder().encodeForHTML(nickname));
				}

//			FacesUtils.setManagedBeanInSession(Constant.OPEN_ID, openId);
//			FacesUtils.setManagedBeanInSession(Constant.PAYMENT_PLATFORM, Constant.DB_ORDER_PAYMENT_TYPE_WEIXINPAY);
				//2017-10-25;Alex:优化代码，安全加密输出内容;CR-代码规范
				if(openId!=null){
				  req.getSession().setAttribute(Constant.OPEN_ID, ESAPI.encoder().encodeForHTML(openId));
				}
				if(userInfo!=null){
				  req.getSession().setAttribute(Constant.WECHAT_USER_INFO, userInfo);
				}
				req.getSession().setAttribute(Constant.PAYMENT_PLATFORM, Constant.DB_ORDER_PAYMENT_TYPE_WEIXINPAY);
				if(state!=null){
				  req.getSession().setAttribute(Constant.WECHAT_STATE, ESAPI.encoder().encodeForHTML(state));
				}
//			System.out.println("payment platform: " + Constant.DB_ORDER_PAYMENT_TYPE_WEIXINPAY);
				logger.info("payment platform: " + ESAPI.encoder().encodeForHTML(Constant.DB_ORDER_PAYMENT_TYPE_WEIXINPAY));
			}

		}
		if(F){
			logger.debug("打印F====="+F);
			
			logger.debug("打印state====="+state);
			if(state.equalsIgnoreCase(Constant.WECHAT_STATE_ORDER)) {
				logger.debug("wechatServlet start Order");

				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss S");
				Date date1 = new Date();
				String time1 = sdf.format(date1);

				OrderBackingBean orderBackingBean = (OrderBackingBean)context.getBean("orderBackingBean" );
				req.getRequestDispatcher(orderBackingBean.toOrderEntry(oId)).forward(req, resp);
//			req.getRequestDispatcher(ViewPage.LINK2OrderEntry).forward(req, resp);
//			req.getRequestDispatcher(loginBackingBean.checkAccount(req)).forward(req, resp);
			} else if(state.equalsIgnoreCase(Constant.WECHAT_STATE_PROMOTION)){
				req.getRequestDispatcher(ViewPage.LINK2Promotion).forward(req, resp);
//			req.getRequestDispatcher(ViewPage.LINK2OrderAccountInfo).forward(req, resp);
			}  else if(state.equalsIgnoreCase(Constant.WECHAT_STATE_LOGIN)){
				logger.debug("wechatServlet start login");
				LoginBackingBean loginBackingBean = (LoginBackingBean)context.getBean("loginBackingBean" );
				req.getRequestDispatcher(loginBackingBean.login(req.getSession(),accessToken,oId,ViewPage.LINK2MyAccount)).forward(req, resp);
//			req.getRequestDispatcher(ViewPage.LINK2Login).forward(req, resp);
			}  else if(state.equalsIgnoreCase(Constant.WECHAT_STATE_APPLY_INVOICE)){
				logger.debug("wechatServlet start ApplyInvoice");
				LoginBackingBean loginBackingBean = (LoginBackingBean)context.getBean("loginBackingBean" );
				req.getRequestDispatcher(loginBackingBean.login(req.getSession(), accessToken,oId,ViewPage.LINK2ApplyInvoice)).forward(req, resp);
//			req.getRequestDispatcher(ViewPage.LINK2ApplyInvoice).forward(req, resp);
			}

			else if(state.equalsIgnoreCase(Constant.WECHAT_STATE_POC)){
				logger.debug("wechatServlet start POC");
				LoginBackingBean loginBackingBean = (LoginBackingBean)context.getBean("loginBackingBean" );
				req.getRequestDispatcher(loginBackingBean.login(req.getSession(), accessToken,oId,ViewPage.LINK2KEY)).forward(req, resp);
			}

			//违章查询
			else if(state.equalsIgnoreCase(Constant.VIOLATION_INQUIRY)){
				System.out.print("+++++++++"+state);
				logger.debug("wechatServlet start violation inquiry");
				LoginBackingBean loginBackingBean = (LoginBackingBean)context.getBean("loginBackingBean" );
				req.getRequestDispatcher(loginBackingBean.login(req.getSession(), accessToken,oId,ViewPage.LINK2VIOLATIONINQUIRY)).forward(req, resp);
			}  
      
			/* 2017-11-10,Tommy Liu, CR82_Part II, 增加 套餐升级 菜单 */
            else if(state.equalsIgnoreCase(Constant.WECHAT_STATE_UPGRADE)){
    			logger.debug("wechatServlet start startUpgradeOrder");
    			LoginBackingBean loginBackingBean = (LoginBackingBean)context.getBean("loginBackingBean" );
    			req.getRequestDispatcher(loginBackingBean.login(req.getSession(), accessToken,oId,ViewPage.LINK2MyAccount2)).forward(req, resp);
    		}
			
			else if(state.equalsIgnoreCase(Constant.WECHAT_PAYMENT)){
				OrderBackingBean orderBackingBean = (OrderBackingBean)context.getBean("orderBackingBean" );
				String orderNum = req.getParameter("state").split(",")[1];
				String accountNum = req.getParameter("state").split(",")[2];
				String link = orderBackingBean.toOrderPaymentForWechat( orderNum,accountNum,oId);
				req.getRequestDispatcher(link).forward(req, resp);

			}
			else if(state.equalsIgnoreCase(Constant.UPDATE_MOBILE)){
				logger.debug("wechatServlet start updatemobile");
				LoginBackingBean loginBackingBean = (LoginBackingBean)context.getBean("loginBackingBean" );
				req.getRequestDispatcher(loginBackingBean.login(req.getSession(), accessToken,oId,ViewPage.LINK2UPDATEPHONE)).forward(req, resp);	
			}
			else if(state.equalsIgnoreCase(Constant.WECHAT_LUCKYDRAWFORMENU)){
				resp.sendRedirect("/htib2c-mobile/views/luckyDraw.html?utm_source=WeChat&utm_medium=Menu&openId="+oId);

			}
			else if(state.equalsIgnoreCase(Constant.WECHAT_LUCKYDRAWFORJOIN)){
				resp.sendRedirect("/htib2c-mobile/views/luckyDraw.html?utm_source=WeChat&utm_medium=Join&openId="+oId);

			}
			else if(state.equalsIgnoreCase(Constant.WECHAT_LUCKYDRAWFORARTICLE)){
				resp.sendRedirect("/htib2c-mobile/views/luckyDraw.html?utm_source=WeChat&utm_medium=Article&openId="+oId);

			}
			else if(state.equalsIgnoreCase(Constant.WECHAT_LUCKYDRAWFORSUBHEAD)){
				resp.sendRedirect("/htib2c-mobile/views/luckyDraw.html?utm_source=WeChat&utm_medium=Subhead&openId="+oId);

			}
			else if(state.equalsIgnoreCase(Constant.WECHAT_LUCKYDRAW1)){
//				req.getRequestDispatcher(loginBackingBean.login(req.getSession(), accessToken,oId,ViewPage.LINK2LUCKDRAW)).redirect(req, resp);
//				logger.info("======================"+loginBackingBean.login(req.getSession(), accessToken,oId,ViewPage.LINK2LUCKDRAW));
//				LoginBackingBean loginBackingBean = new LoginBackingBean();
//				resp.sendRedirect("/htib2c-mobile/views/luckyDraw2.xhtml?openId="+oId+"&utm_source="+oId);
				resp.sendRedirect("/htib2c-mobile/views/luckyDraw.html?flag=1&utm_source=WeChat&utm_medium=Menu&openId="+oId);

			}
			else if(state.equalsIgnoreCase(Constant.WECHAT_LUCKYDRAW2)){
//				req.getRequestDispatcher(loginBackingBean.login(req.getSession(), accessToken,oId,ViewPage.LINK2LUCKDRAW)).redirect(req, resp);
//				logger.info("======================"+loginBackingBean.login(req.getSession(), accessToken,oId,ViewPage.LINK2LUCKDRAW));
//				LoginBackingBean loginBackingBean = new LoginBackingBean();
//				resp.sendRedirect("/htib2c-mobile/views/luckyDraw2.xhtml?openId="+oId+"&utm_source="+oId);
				resp.sendRedirect("/htib2c-mobile/views/luckyDraw.html?flag=1&utm_source=WeChat&utm_medium=Join&openId="+oId);

			}
			else if(state.equalsIgnoreCase(Constant.WECHAT_LUCKYDRAW3)){
//				req.getRequestDispatcher(loginBackingBean.login(req.getSession(), accessToken,oId,ViewPage.LINK2LUCKDRAW)).redirect(req, resp);
//				logger.info("======================"+loginBackingBean.login(req.getSession(), accessToken,oId,ViewPage.LINK2LUCKDRAW));
//				LoginBackingBean loginBackingBean = new LoginBackingBean();
//				resp.sendRedirect("/htib2c-mobile/views/luckyDraw2.xhtml?openId="+oId+"&utm_source="+oId);
				resp.sendRedirect("/htib2c-mobile/views/luckyDraw.html?flag=1&utm_source=WeChat&utm_medium=Article&openId="+oId);

			}
			else if(state.equalsIgnoreCase(Constant.WECHAT_LUCKYDRAW4)){
//				req.getRequestDispatcher(loginBackingBean.login(req.getSession(), accessToken,oId,ViewPage.LINK2LUCKDRAW)).redirect(req, resp);
//				logger.info("======================"+loginBackingBean.login(req.getSession(), accessToken,oId,ViewPage.LINK2LUCKDRAW));
//				LoginBackingBean loginBackingBean = new LoginBackingBean();
//				resp.sendRedirect("/htib2c-mobile/views/luckyDraw2.xhtml?openId="+oId+"&utm_source="+oId);
				resp.sendRedirect("/htib2c-mobile/views/luckyDraw.html?flag=1&utm_source=WeChat&utm_medium=Subhead&openId="+oId);

			}
			else if(state.equalsIgnoreCase(Constant.QUESTIONNAIRE)){
//				logger.debug("wechatServlet start updatemobile");
				String questionnaireId=req.getParameter("state").split(",")[1];
				logger.debug("questionnaireId-------"+questionnaireId);
				Integer qId=0;
				if(questionnaireId!=null){
					qId=Integer.parseInt(questionnaireId);
				}
				QuestionnaireBean questionnaireBean = (QuestionnaireBean)context.getBean("questionnaireBean" );
				req.getRequestDispatcher(questionnaireBean.doAnswer(qId,req,resp)).forward(req, resp);	
			}
			else if(state.equalsIgnoreCase(Constant.VARIFLIGHT)){
				logger.info("variflight start login");
				LoginBackingBean loginBackingBean = (LoginBackingBean)context.getBean("loginBackingBean" );
				String variFlight = "https://app.variflight.com/vipnew/getcardnew?channel=benchi";
				
				req.getRequestDispatcher(loginBackingBean.login(req.getSession(), accessToken,oId,ViewPage.LINK2VARIFLIGHT)).forward(req, resp);
			}  
		}
	}

	/*2017-10-25;Alex:优化代码，关闭IO流等;CR-代码规范*/
	public static String convertStreamToString(InputStream ip_stream) {
		InputStreamReader ip_reader = new InputStreamReader(ip_stream);
		BufferedReader bf_reader = new BufferedReader(ip_reader);
		StringBuilder sb = new StringBuilder();

		String line = null;
		try {
			while ((line = bf_reader.readLine()) != null) {
				sb.append(line + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bf_reader.close();
				ip_reader.close();
				ip_stream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return sb.toString();
	}
}
