package com.htichina.web.wechat;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.owasp.esapi.ESAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import com.alipay.util.UtilDate;
import com.google.gson.Gson;
import com.htichina.common.web.Constant;
import com.htichina.web.PaymentServiceClient;
import com.htichina.wsclient.payment.Coupon;
import com.htichina.wsclient.payment.CouponHistory;

/**
 * Created by cfq on 2018/3/23.
 */
@Component("CouponSaveServlet")
public class CouponSaveServlet extends HttpServlet {
	private static Logger logger = Logger.getLogger(CouponSaveServlet.class.getName());
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
		Integer drawTag=0;//未领取
		try {
//			String couponId=req.getParameter("couponId");
			String couponId="1";
			PaymentServiceClient client = PaymentServiceClient.getInstance();
//			Coupon coupon=client.findCouponsById(couponId);
//			String accountNum = (String) req.getSession().getAttribute(Constant.ACCOUNT_NUM);
			String accountNum="10577513";
			if(couponId!=null){
				CouponHistory history=new CouponHistory();
				history.setCouponId(couponId);
				history.setCoustomerId(accountNum);
				String currTime=UtilDate.getDateFormatter();
				history.setCreatedTime(currTime);
				history.setIsUsed("0");
				history.setReserveAddress("北京市");
				history.setReserveName("褚夫强");
				history.setReserveTel("18815581557");
				drawTag =client.saveDrawCouponHistory(history);
			}
			resp.setContentType("text/html;charset=utf-8");
	        PrintWriter out;
            out = resp.getWriter();
            Gson gson = new Gson();
            String str = gson.toJson(drawTag);
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
