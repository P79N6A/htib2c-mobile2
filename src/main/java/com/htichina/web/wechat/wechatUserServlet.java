package com.htichina.web.wechat;

import com.alipay.util.DESUtil;
import com.alipay.util.UtilDate;
import com.google.gson.Gson;
import com.htichina.web.accessToken.AccessTokenResult;
import com.htichina.web.message.MessageServer;
import com.tencent.service.WechatAccessTokenUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by ln on 2018/05/24.
 */
@Component("wechatUserServlet")
public class wechatUserServlet extends HttpServlet {
	private static Logger logger = Logger.getLogger(wechatUserServlet.class.getName());


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setHeader("Access-Control-Allow-Origin", "*");
		Date now = new Date();
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out;
		out = resp.getWriter();
		Gson gson = new Gson();
		String str = gson.toJson(MessageServer.user);
		logger.info("locate result = "+str);

		out.write(str);
		out.flush();
		out.close();
	}
}
