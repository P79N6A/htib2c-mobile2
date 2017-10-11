package com.htichina.web.POC;

import java.util.Map;

/**
 * Created by 刘宁 on 2017/6/29.
 */
public class ResultBean {
    //状态
    private boolean flag;
    //    数据
    private Map<Object,Object> data;
    //消息
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public Map<Object, Object> getData() {
        return data;
    }

    public void setData(Map<Object, Object> data) {
        this.data = data;
    }
}
