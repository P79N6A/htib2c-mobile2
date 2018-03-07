package com.htichina.web.POC;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.htichina.common.web.Constant;
import com.htichina.web.LoginFilter;
import com.htichina.web.PaymentServiceClient;
import com.htichina.web.common.FacesUtils;
import com.htichina.web.common.ViewPage;
import com.htichina.web.login.LoginBackingBean;

import java.io.Serializable;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@Component
@Scope("session")
public class MobileBean implements Serializable {
	@Autowired
	private static Logger logger = Logger.getLogger(LoginBackingBean.class.getName());

    private static final long serialVersionUID = -7784214551830400323L;

    public String number;

    public String communicationToken;

    public String primaryContactIndicator;
    
    private String newCellPhone;
    private String repMessage=null;
    //更新手机号或者座机号
    /**
	 * 更新联系人方式
	 * @param accountNum
	 * @return
	 */
	public String updateNewCellPhoneByAccountNum(){
		FacesContext context = FacesContext.getCurrentInstance();
		String regex= "^((0\\d{2,3}\\d{7,8})|(((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(18[0,5-9]))\\d{8}))$";
		boolean isf = Pattern.matches(regex, newCellPhone);
		String accountNum=(String) FacesUtils.getManagedBeanInSession(LoginFilter.CURRENT_USER);
		logger.info("newCellPhone+accountNum ===>"+newCellPhone+"==="+accountNum);
		if(isf) {
			String phoneByAccountNum=null;
			if(null!=accountNum) {
				//根据账户查询联系方式
				phoneByAccountNum= PaymentServiceClient.getInstance().getCallPhoneByAccountNum(accountNum);				
			}
			if(phoneByAccountNum!=null&&newCellPhone.equals(phoneByAccountNum)) {
				repMessage="您已经更改过最新联系方式，如需修改请重新输入新的联系方式！";
			}else {				
				if(null!=accountNum && newCellPhone!=null) {
					//调用接口保存
					boolean f = PaymentServiceClient.getInstance().updateNewCallPhoneByAccountNum(accountNum,newCellPhone);
					if(f) {
						repMessage="您的请求已成功提交！";
					} 								
				}			
			}
		}else {
			repMessage="错误提示：输入有误，请检查后重新输入！";
		}
		logger.info("newCellPhone+accountNum ===>"+repMessage);
		context.addMessage(null, new FacesMessage(
				FacesMessage.SEVERITY_ERROR, repMessage, ""));
		return ViewPage.LINK2UPDATEPHONE;
	}

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCommunicationToken() {
        return communicationToken;
    }

    public void setCommunicationToken(String communicationToken) {
        this.communicationToken = communicationToken;
    }

    public String getPrimaryContactIndicator() {
        return primaryContactIndicator;
    }

    public void setPrimaryContactIndicator(String primaryContactIndicator) {
        this.primaryContactIndicator = primaryContactIndicator;
    }

	public String getNewCellPhone() {
		return newCellPhone;
	}

	public void setNewCellPhone(String newCellPhone) {
		this.newCellPhone = newCellPhone;
	}

	public String getRepMessage() {
		return repMessage;
	}

	public void setRepMessage(String repMessage) {
		this.repMessage = repMessage;
	}
    
}
