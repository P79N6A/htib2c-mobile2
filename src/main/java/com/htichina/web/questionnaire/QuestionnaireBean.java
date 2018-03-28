package com.htichina.web.questionnaire;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.htichina.common.web.Constant;
import com.htichina.web.PaymentServiceClient;
import com.htichina.web.common.FacesUtils;
import com.htichina.web.common.ViewPage;
import com.htichina.wsclient.payment.Questions;

/**
*
* Created by 褚夫强 on 2018/3/22.
*/
@Component
@Scope("session")
public class QuestionnaireBean implements Serializable {
    /**
	 * 
	 */
	private static Logger logger = Logger.getLogger(QuestionnaireBean.class.getName());
	PaymentServiceClient client = PaymentServiceClient.getInstance();
	
	private int questionnaireId;
	private String openId;
	private String account;
	private Integer answeredIndex=-1;
	private String answerStatus;//0未回答或未回答完毕1已回答完毕2已结束3错误
	public String doAnswer(int questionnaireId){
		this.questionnaireId=questionnaireId;
		logger.debug("questionnaireId------"+questionnaireId);
		openId = (String) FacesUtils.getManagedBeanInSession(Constant.OPEN_ID);
		logger.debug("openId------"+openId);
		account = client.getActiveAccountByOpenId(openId);
		logger.debug("account------"+account);
		if(account==null){
			account="";
		}
		String status=client.answerStatus(account, openId, questionnaireId);
		this.answerStatus=status;
		if(status.equals("start")){
			//0未回答或未回答完毕
			//开始答题
			int index=client.getAnswerCount(questionnaireId, account, openId);
			if(index!=0){
				answeredIndex=index;
			}
		}
		return ViewPage.LINK2QUESTIONNAIRE;
	}
	public List<Questions> queryQuestions(int questionnaireId){
		List<Questions> qsList=client.getQuestions(questionnaireId);
		return qsList;
	}
	public int getQuestionnaireId() {
		return questionnaireId;
	}
	public void setQuestionnaireId(int questionnaireId) {
		this.questionnaireId = questionnaireId;
	}
	public String getOpenId() {
		return openId;
	}
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	public Integer getAnsweredIndex() {
		return answeredIndex;
	}
	public void setAnsweredIndex(Integer answeredIndex) {
		this.answeredIndex = answeredIndex;
	}
	public String getAnswerStatus() {
		return answerStatus;
	}
	public void setAnswerStatus(String answerStatus) {
		this.answerStatus = answerStatus;
	}

}
