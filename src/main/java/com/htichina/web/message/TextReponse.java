package com.htichina.web.message;

/**
 * Created by yaliu on 2017/5/3.
 * 回复文本消息
 */
public class TextReponse extends BaseRepMessage{
    // 回复的消息内容
    private String Content;

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }
}
