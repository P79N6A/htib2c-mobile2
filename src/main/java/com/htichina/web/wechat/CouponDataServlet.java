package com.htichina.web.wechat;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.owasp.esapi.ESAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import com.google.gson.Gson;
import com.htichina.common.web.Constant;
import com.htichina.web.PaymentServiceClient;
import com.htichina.wsclient.payment.Coupon;

/**
 * Created by cfq on 2018/3/23.
 */
@Component("CouponDataServlet")
public class CouponDataServlet extends HttpServlet {
	private static Logger logger = Logger.getLogger(CouponDataServlet.class.getName());
	@Autowired(required = true)
	WebApplicationContext context;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		try {
			String promotionId=req.getParameter("promotionId");
			PaymentServiceClient client = PaymentServiceClient.getInstance();
//			String accountNum = (String) req.getSession().getAttribute(Constant.ACCOUNT_NUM);
			String accountNum="10577513";
			List<Coupon> couponList=client.findCouponsByPromotionId(accountNum, promotionId);
			resp.setContentType("text/html;charset=utf-8");
	        PrintWriter out;
            out = resp.getWriter();
            Gson gson = new Gson();
            String str = gson.toJson(couponList);
            logger.info("locate result = "+str);
            out.write(str);
            out.flush();
            out.close();
        } catch (IOException e) {
        	logger.info(ESAPI.encoder().encodeForHTML(e.getMessage()));
            //e.printStackTrace();
        }
	}

	
}
