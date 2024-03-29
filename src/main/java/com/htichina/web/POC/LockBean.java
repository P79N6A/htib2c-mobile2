package com.htichina.web.POC;

import com.google.common.base.Strings;
import com.htichina.common.web.Constant;
import com.htichina.web.PaymentServiceClient;
import com.htichina.web.common.FacesUtils;
import com.htichina.web.common.ViewPage;
import com.tencent.service.HttpsURLRequest;

import org.apache.log4j.Logger;
import org.owasp.esapi.ESAPI;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * The main class for handling the Lock
 * Created by liuyan on 2017/5/5.
 */
@Component
@Scope("session")
public class LockBean implements Serializable {
    private static Logger logger = Logger.getLogger(PocBean.class.getName());
    private String flag;
    private String openId;

    private String accountNum;
    private String pin;
    private String pinFlag;

    /**
     * 检查输密码是否正确
     * param null
     * return String 跳转页面
     */
    public String checkPin(){
        pinFlag = "F";
        openId = (String) FacesUtils.getManagedBeanInSession(Constant.OPEN_ID);
        if(Strings.isNullOrEmpty(accountNum)){
        	openId = (String) FacesUtils.getManagedBeanInSession(Constant.OPEN_ID);
            accountNum = PaymentServiceClient.getInstance().getActiveAccountByOpenId(openId);
        }
        boolean flag = PaymentServiceClient.getInstance().validateLogin(accountNum, pin, openId, null);
        /*flag = true;*/
        if(flag){
            pinFlag = "T";
        }
        return ViewPage.LINK2LOCK;
    }

    /**
     * 根据用户信息发送Lock请求
     * param null
     * return String 跳转页面
     */
    public String Lock() throws Exception{
        flag = "F";
        HttpsURLRequest request = new HttpsURLRequest();
        Map<String,String> param = new HashMap<>();
        param.put(Constant.ACCOUNT_NUM,accountNum);
        param.put(Constant.HTTPS_PIN,pin);
        logger.info("param ="+ ESAPI.encoder().encodeForHTML(param.toString()));
        ResultBean result = request.NoSecurityPost(Constant.HTTPS_LOCK,param);
        if(result != null){
            logger.info("result ="+ESAPI.encoder().encodeForHTML(result.toString()));
        }
        if(result != null){
            if(result.isFlag()){
                flag = "T";
            }
            else{
                logger.info("lock failed message = "+ESAPI.encoder().encodeForHTML(result.getMessage()));
            }

        }
        return ViewPage.LINK2LOCK;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }
    public String getFlag() {
        String temp = flag;
        flag = null;
        return temp;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getAccountNum() {
        return accountNum;
    }

    public void setAccountNum(String accountNum) {
        this.accountNum = accountNum;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getPinFlag() {
        String temp;
        temp = pinFlag;
        pinFlag = null;
        return temp;
    }

    public void setPinFlag(String pinFlag) {
        this.pinFlag = pinFlag;
    }
}
