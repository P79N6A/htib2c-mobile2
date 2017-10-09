package com.htichina.web.wechat;

import com.google.gson.Gson;
import com.htichina.common.web.Constant;
import com.htichina.web.POC.ResultBean;
import com.tencent.service.HttpsURLRequest;
import org.apache.log4j.Logger;
import org.owasp.esapi.ESAPI;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Console;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 刘宁 on 2017/7/31.
 */
public class WechatLocateServlet extends HttpServlet {
    private static Logger logger = Logger.getLogger(WechatLocateServlet.class.getName());
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("in WechatLocateServlet");
        String latitude = request.getParameter(Constant.HTTPS_LATITUDE);
        String longitude = request.getParameter(Constant.HTTPS_LONGITUDE);
        String tcuType = request.getParameter(Constant.HTTPS_TCUTYPE);
        String tcuId = request.getParameter(Constant.HTTPS_TCUID);
        String transactionId = request.getParameter(Constant.HTTPS_TRANSACTIONID);
        String time = request.getParameter(Constant.HTTPS_TIMESTAMP);
        Map<String,String> paramMap = new HashMap<String,String>();
        logger.info("locate paramMap = "+ ESAPI.encoder().encodeForHTML(paramMap.toString()));
        paramMap.put(Constant.HTTPS_LATITUDE,latitude);
        paramMap.put(Constant.HTTPS_LONGITUDE,longitude);
        paramMap.put(Constant.HTTPS_TCUTYPE,tcuType);
        paramMap.put(Constant.HTTPS_TCUID,tcuId);
        paramMap.put(Constant.HTTPS_TRANSACTIONID,transactionId);
        paramMap.put(Constant.HTTPS_TIMESTAMP,time);

        HttpsURLRequest httpsURLRequest = new HttpsURLRequest();
        ResultBean resultBean = null;
        try {
            resultBean  =httpsURLRequest.postForlocateFinal(paramMap);
        } catch (UnrecoverableKeyException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        } catch (KeyStoreException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out;
        try {
            out = response.getWriter();
            Gson gson = new Gson();
            String str = gson.toJson(resultBean);
            logger.info("locate result = "+ESAPI.encoder().encodeForHTML(str));
            out.write(str);
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
