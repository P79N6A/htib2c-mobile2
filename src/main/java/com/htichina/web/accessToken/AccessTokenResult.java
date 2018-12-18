package com.htichina.web.accessToken;

import javax.xml.crypto.Data;
import java.util.Date;

/**
 * Created by 刘宁 on 2018/12/13.
 */
public class AccessTokenResult {
    String result;
    String message="success";
    String getTime;
    String leftTimes;
    String remainTime;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getGetTime() {
        return getTime;
    }

    public void setGetTime(String getTime) {
        this.getTime = getTime;
    }

    public String getLeftTimes() {
        return leftTimes;
    }

    public void setLeftTimes(String leftTimes) {
        this.leftTimes = leftTimes;
    }

    public String getRemainTime() {
        return remainTime;
    }

    public void setRemainTime(String remainTime) {
        this.remainTime = remainTime;
    }
}
