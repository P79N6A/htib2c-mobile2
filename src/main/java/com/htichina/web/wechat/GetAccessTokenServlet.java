package com.htichina.web.wechat;

import com.alipay.util.DESUtil;
import com.google.gson.Gson;
import com.htichina.common.web.Constant;
import com.htichina.web.PaymentServiceClient;
import com.htichina.web.accessToken.AccessTokenResult;
import com.htichina.web.luckDraw.resultBean;
import com.tencent.service.WechatAccessTokenUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by ln on 2018/05/24.
 */
@Component("GetAccessTokenServlet")
public class GetAccessTokenServlet extends HttpServlet {
	private static Logger logger = Logger.getLogger(GetAccessTokenServlet.class.getName());

private static Integer num=1000;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		num=num-1;
		AccessTokenResult accessTokenResult = new AccessTokenResult();
		if(num>0) {
			 String token = WechatAccessTokenUtils.getWechatToken();
			try {
				//加密
				String result = DESUtil.encrypt(token);
				accessTokenResult.setResult(result);
				accessTokenResult.setGetTime(WechatAccessTokenUtils.generate_date);
			} catch (Exception e) {
				accessTokenResult.setMessage("error");
			}
		}else{
			accessTokenResult.setMessage("Exceeding the upper limit!");
		}
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out;
		out = resp.getWriter();
		Gson gson = new Gson();
		String str = gson.toJson(accessTokenResult);
		logger.info("locate result = "+str);
		out.write(str);
		out.flush();
		out.close();
	}
}
