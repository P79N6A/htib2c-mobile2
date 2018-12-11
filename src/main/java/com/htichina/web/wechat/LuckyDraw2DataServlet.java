package com.htichina.web.wechat;

import com.google.gson.Gson;
import com.htichina.common.web.Constant;
import com.htichina.web.PaymentServiceClient;
import com.htichina.web.luckDraw.resultBean;
import com.htichina.wsclient.payment.LdItem;
import com.htichina.wsclient.payment.LdLtemReponse;
import com.htichina.wsclient.payment.LuckyDrawReponse;
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
@Component("LuckyDraw2DataServlet")
public class LuckyDraw2DataServlet extends HttpServlet {
	private static Logger logger = Logger.getLogger(LuckyDraw2DataServlet.class.getName());


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
		PaymentServiceClient client = PaymentServiceClient.getInstance();
		String name=req.getParameter("name");
		String telNum=req.getParameter("telNum");
		String address=req.getParameter("address");
		String openId =(String)req.getSession().getAttribute(Constant.OPEN_ID);
//		String accountNum = "10631821";
        String accountNum = client.getActiveAccountByOpenId(openId);
		String resultBean = winUserInfo(client,accountNum,name,telNum,address);
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out;
		out = resp.getWriter();
		Gson gson = new Gson();
		String str = gson.toJson(resultBean);
		logger.info("locate result = "+str);
		out.write(str);
		out.flush();
		out.close();
	}
	/**
	 * 点击抽奖
	 * @return
	 */
	public String winUserInfo(PaymentServiceClient client,String accountNum,String name,String telNum,String address){
		resultBean resultBean = new resultBean();
		//判断是否符合资格
		if(accountNum==null){
			resultBean.setLuckyDrawNotice("参与此活动，需要您先登录参与活动的账号，请点击前往");
			resultBean.setLuckyDrawNoticeType("1");
			return "0";
		}


		boolean result = client.winUserInfo(accountNum,name,telNum,address);
		if(result){
			return "1";
		}else{
			return "0";
		}

	}

}
