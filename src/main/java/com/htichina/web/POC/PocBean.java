package com.htichina.web.POC;

import com.htichina.common.web.Constant;
import com.htichina.web.common.ViewPage;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * The main class for handling the POC
 * Created by liuyan on 2017/5/15.
 */
@Component
@Scope("session")
public class PocBean implements Serializable {
    private static Logger logger = Logger.getLogger(PocBean.class.getName());
    // 微信用户openId
    private String openId;
    // 目标页面
    private String targetPage;
    // 车架号
    private String vin;
    /**
     * 根据用户在key页面点击按钮跳转到相应页面
     * param null
     * return String 跳转页面
     */
    public String turnPage(){
        dataRest();
        /*vin = "1234";*/
        if("hornLight".equals(targetPage)){
            logger.info("to hornLight");
            return ViewPage.LINK2HORNLIGHT;
        }
        else if("enLock".equals(targetPage)){
            logger.info("to enLock");
            return ViewPage.LINK2UNLOCK;
        }
        else if("lock".equals(targetPage)){
            logger.info("to lock");
            return ViewPage.LINK2LOCK;
        }
        else if("location".equals(targetPage)){
            logger.info("to location");
            return ViewPage.LINK2LOCATION;
        }
        return ViewPage.LINK2KEY;
    }

    public void dataRest(){
        openId = null;
        vin = null;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getTargetPage() {
        return targetPage;
    }

    public void setTargetPage(String targetPage) {
        this.targetPage = targetPage;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }
}
