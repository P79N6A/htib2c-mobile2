package com.htichina.web.wechat;

import com.alibaba.fastjson.JSONArray;
import com.htichina.web.message.MessageServer;
import com.htichina.web.message.PoiModel;
import com.htichina.web.util.SignUtil;
import com.tencent.common.http.http;
import org.apache.log4j.Logger;
import org.owasp.esapi.ESAPI;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


/**
 * Created by yaliu on 2017/4/27.
 */
@WebServlet(name = "wechatMassageServlet")
public class wechatMassageServlet extends HttpServlet {
    private static Logger logger = Logger.getLogger(wechatMassageServlet.class.getName());
    /**
     * 确认请求来自微信服务器
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("wechatMassageServlet--->doGet");
        // 微信加密签名
        String signature = request.getParameter("signature");
        // 时间戳
        String timestamp = request.getParameter("timestamp");
        // 随机数
        String nonce = request.getParameter("nonce");
        // 随机字符串
        String echostr = request.getParameter("echostr");

        PrintWriter out = response.getWriter();
        // 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败
        if (SignUtil.checkSignature(signature, timestamp, nonce)) {
        	/*2017-10-25;Alex:优化代码，安全加密输出内容;CR-代码规范*/
            out.print(ESAPI.encoder().encodeForHTML(echostr));
        }
        out.close();
        out = null;
    }

    /**
     * 处理微信服务器发来的消息
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("乱码测试luanmaceshi");
        logger.info("wechatMassageServlet--->doPost");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
//        logger.info("String=============="+1111);
//        String String = new http().doPost("http://10.198.107.128:8000/htib2c-mobile/wechatUser");
//        logger.info("String=============="+String);
////        JSONObject jsStr = JSONObject.parseObject(String);
//        MessageServer.user = (List<PoiModel>) JSONArray.parseArray(String, PoiModel.class);
//        logger.info("user=============="+MessageServer.user);
        // 调用核心业务类接收消息、处理消息
        MessageServer messageServer = new MessageServer();
        String respMessage = messageServer.processRequest(request);
        logger.info("respMessage---->"+ respMessage);
        // 响应消息
        PrintWriter out = response.getWriter();
        out.print(respMessage);
        out.close();
    }
}
