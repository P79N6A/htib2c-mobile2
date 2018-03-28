package com.htichina.web.wechat;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
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

import com.alipay.util.UtilDate;
import com.google.gson.Gson;
import com.htichina.common.web.Constant;
import com.htichina.web.PaymentServiceClient;
import com.htichina.web.common.FacesUtils;
import com.htichina.web.order.OrderBackingBean;
import com.htichina.web.questionnaire.QuestionnaireBean;
import com.htichina.wsclient.payment.QuestionAnswer;
import com.htichina.wsclient.payment.QuestionOptions;
import com.htichina.wsclient.payment.Questions;

/**
 * Created by cfq on 2018/3/23.
 */
@Component("QuestionnaireSaveServlet")
public class QuestionnaireSaveServlet extends HttpServlet {
	private static Logger logger = Logger.getLogger(QuestionnaireSaveServlet.class.getName());
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
			String questionnaireId=req.getParameter("questionnaireId");
	        String questionId=req.getParameter("queId");
			String ansStr=req.getParameter("answers");
//			String openId = (String) FacesUtils.getManagedBeanInSession(Constant.OPEN_ID);
			String openId="123123";
			
//			logger.debug("openId------"+openId);
//			String account = client.getActiveAccountByOpenId(openId);
			String account="1232131";
//			logger.debug("account------"+account);
			PaymentServiceClient client = PaymentServiceClient.getInstance();
			QuestionAnswer answer=new QuestionAnswer();
			answer.setQuestionnaireId(questionnaireId);
			answer.setQuestionId(questionId);
			answer.setAnswers(ansStr);
			answer.setAccount(account);
			answer.setOpenId(openId);
			String currTime=UtilDate.getDateFormatter();
			answer.setAnswersTime(currTime);
			Integer result=client.saveAnswer(answer);
			resp.setContentType("text/html;charset=utf-8");
	        PrintWriter out;
            out = resp.getWriter();
            Gson gson = new Gson();
            String str = gson.toJson(result);
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
