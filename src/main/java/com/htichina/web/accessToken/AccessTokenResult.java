package com.htichina.web.accessToken;

import javax.xml.crypto.Data;
import java.util.Date;

/**
 * Created by 刘宁 on 2018/12/13.
 */
public class AccessTokenResult {
    String result;
    String message="success";
    Date getTime;

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

    public Date getGetTime() {
        return getTime;
    }

    public void setGetTime(Date getTime) {
        this.getTime = getTime;
    }
}
