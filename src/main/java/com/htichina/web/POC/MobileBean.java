package com.htichina.web.POC;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.htichina.common.web.Constant;
import com.htichina.web.LoginFilter;
import com.htichina.web.PaymentServiceClient;
import com.htichina.web.common.FacesUtils;
import com.htichina.web.login.LoginBackingBean;

import java.io.Serializable;

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
    private String repMessage="fail";
    //更新手机号或者座机号
    /**
	 * 更新联系人方式
	 * @param accountNum
	 * @return
	 */
	public void updateNewCellPhoneByAccountNum(){
		
		String accountNum=(String) FacesUtils.getManagedBeanInSession(LoginFilter.CURRENT_USER);
		String alreadyUpdatePhone = (String)FacesUtils.getManagedBeanInSession(Constant.NEWCELLPHONE);
		logger.info("newCellPhone+accountNum ===>"+newCellPhone+"==="+accountNum);
		if(null!=alreadyUpdatePhone && newCellPhone.equals(alreadyUpdatePhone)){
			repMessage=Constant.ALREADYUPDATE;
		}else {
			if(null!=accountNum && newCellPhone!=null) {
				//调用接口保存
				boolean f = PaymentServiceClient.getInstance().updateNewCallPhoneByAccountNum(accountNum,newCellPhone);
				if(f) {
					FacesUtils.setManagedBeanInSession(Constant.NEWCELLPHONE, newCellPhone);
					repMessage=Constant.SUCCESS;
				} 
			}			
		}
		logger.info("newCellPhone+accountNum ===>"+repMessage);
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
