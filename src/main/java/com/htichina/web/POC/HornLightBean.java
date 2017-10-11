package com.htichina.web.POC;

import com.google.common.base.Strings;
import com.htichina.common.web.Constant;
import com.htichina.web.PaymentServiceClient;
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
 * The main class for handling the HornLight
 * Created by liuyan on 2017/5/15.
 */
@Component
@Scope("session")
public class HornLightBean implements Serializable {
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
        if(Strings.isNullOrEmpty(accountNum)){
            accountNum = PaymentServiceClient.getInstance().getActiveAccountByOpenId(openId);
        }
        boolean flag = PaymentServiceClient.getInstance().validateLogin(accountNum, pin, openId, null);
        /*flag = true;*/
        if(flag){
            pinFlag = "T";
        }
        return ViewPage.LINK2HORNLIGHT;
    }

    /**
     * 根据用户信息发送hornLight请求
     * param null
     * return String 跳转页面
     */
    public String hornLight() throws Exception {
        flag = "F";
        HttpsURLRequest request = new HttpsURLRequest();
        Map<String,String> param = new HashMap<>();
        param.put(Constant.HTTPS_ACCOUNTNUM,accountNum);
        logger.info("param ="+ ESAPI.encoder().encodeForHTML(param.toString()));
        ResultBean result = request.NoSecurityPost(Constant.HTTPS_HORNLIGHT,param);
        if(result != null){
            logger.info("result = "+ESAPI.encoder().encodeForHTML(result.toString()));
        }
        if(result != null){
            if(result.isFlag()){
                flag = "T";
            }
            else{
                logger.info("hornLight failed message = "+ESAPI.encoder().encodeForHTML(result.getMessage()));
            }

        }
        return ViewPage.LINK2HORNLIGHT;
    }

    public void dataRest(){
        System.out.println("dataRest");
        flag = null;
        openId = null;
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
