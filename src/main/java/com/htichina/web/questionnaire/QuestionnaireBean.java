package com.htichina.web.questionnaire;

import java.io.Serializable;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.htichina.common.web.Constant;
import com.htichina.web.PaymentServiceClient;
import com.htichina.web.common.FacesUtils;
import com.htichina.web.common.ViewPage;

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
	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger(QuestionnaireBean.class.getName());
	PaymentServiceClient client = PaymentServiceClient.getInstance();
	
	private int questionnaireId;
	private String openId;
	private String account;
	private String questionnaireNotice;
	public String doAnswer(int questionnaireId){
		openId = (String) FacesUtils.getManagedBeanInSession(Constant.OPEN_ID);
		account = client.getActiveAccountByOpenId(openId);
		if(account==null){
			account="";
		}
		String answerStatus=client.answerStatus(account, openId, questionnaireId);
		if(answerStatus.equals("")){
			questionnaireNotice="该问卷一不存在，请联系客服。";
			return ViewPage.ERRORMESSAGE;
		}else if(answerStatus.equals("0")){
			//开始答题第一题开始答
			
			return ViewPage.LINK2QUESTIONNAIRESTART;
		}
		return ViewPage.LINK2QUESTIONNAIRESTART;
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

}
