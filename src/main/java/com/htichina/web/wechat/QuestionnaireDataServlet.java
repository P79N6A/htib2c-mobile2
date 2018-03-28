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

import com.google.gson.Gson;
import com.htichina.web.PaymentServiceClient;
import com.htichina.web.questionnaire.QuestionnaireBean;
import com.htichina.wsclient.payment.QuestionOptions;
import com.htichina.wsclient.payment.Questions;

/**
 * Created by cfq on 2018/3/23.
 */
@Component("QuestionnaireDataServlet")
public class QuestionnaireDataServlet extends HttpServlet {
	private static Logger logger = Logger.getLogger(QuestionnaireDataServlet.class.getName());
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
			int qId=0;
			if(questionnaireId!=null){
				qId=Integer.parseInt(questionnaireId);
			}
			PaymentServiceClient client = PaymentServiceClient.getInstance();
			List<Questions> qusList=client.getQuestions(qId);
			List<Map<String, Object>> questionList=new ArrayList<>();
			for(Questions q:qusList){
				Map<String, Object> quetionMap=new HashMap<String, Object>();
				if(q.getType().equals("0")){//单选
					quetionMap.put("type", "cb");
				}else if(q.getType().equals("1")){
					quetionMap.put("type", "cb_");
				}else if(q.getType().equals("2")){
					quetionMap.put("type", "sel");
				}else {
					quetionMap.put("type", "area");
				}
				quetionMap.put("que",q.getContent());
				String qustionId=q.getId();
				quetionMap.put("questionId", qustionId);
				List<String> optionList=new ArrayList<>();
				List<QuestionOptions> optionsList=client.getQuestionOptions(Integer.parseInt(qustionId));
				if(optionsList!=null&&optionsList.size()>0){
					for(QuestionOptions qos:optionsList){
						    optionList.add(qos.getContent());
					}
				}
				quetionMap.put("ans", optionList);
				quetionMap.put("qusId", q.getId());
				if(q.getSkip()!=null&&q.getSkip().equals("0")){
					quetionMap.put("skip", true);
				}else{
					quetionMap.put("skip", false);
				}
				
				questionList.add(quetionMap);
			}
			
			
			resp.setContentType("text/html;charset=utf-8");
	        PrintWriter out;
        
            out = resp.getWriter();
            Gson gson = new Gson();
            String str = gson.toJson(questionList);
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
