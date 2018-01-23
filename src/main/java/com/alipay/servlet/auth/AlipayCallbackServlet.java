/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.servlet.auth;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.request.AlipayMobilePublicMessageCustomSendRequest;
import com.alipay.api.response.AlipayMobilePublicMessageCustomSendResponse;
import com.alipay.factory.AlipayAPIClientFactory;
import com.alipay.util.AlipayNotify;
import com.google.common.base.Strings;
import com.htichina.common.web.ConfigureInfo;
import com.htichina.common.web.Constant;
import com.htichina.web.PaymentServiceClient;
import com.htichina.web.common.ViewPage;
import com.htichina.wsclient.payment.PaymentResponse;
import com.htichina.wsclient.payment.PaymentResultMessage;
import com.htichina.wsclient.payment.QueryChildOrdersByParentOrderNumResponse;
import com.htichina.wsclient.payment.ServiceOrder;
import com.tencent.service.HttpsURLRequest;

import net.sf.json.JSONObject;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.owasp.esapi.ESAPI;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class AlipayCallbackServlet extends HttpServlet {

    private static Logger logger = Logger.getLogger(AlipayCallbackServlet.class.getName());

    /**
     * 业务处理
     * @see HttpServlet#doGet(HttpServletRequest, HttpServletResponse)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
                                                                                  throws ServletException,
                                                                                  IOException {
        //获取支付宝GET过来反馈信息
        Map<String,String> params = new HashMap<String,String>();
        Map requestParams = request.getParameterMap();
        for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                        : valueStr + values[i] + ",";
            }
            //乱码解决，这段代码在出现乱码时使用。如果mysign和sign不相等也可以使用这段代码转化
            valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
            logger.info("requestParam " + ESAPI.encoder().encodeForHTML(name) + "=" + ESAPI.encoder().encodeForHTML(valueStr));
            params.put(name, valueStr);
        }

        //获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以下仅供参考)//
        //商户订单号
        String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"),"UTF-8");

        //支付宝交易号
        String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"),"UTF-8");

        //交易状态
        String result = new String(request.getParameter("result").getBytes("ISO-8859-1"),"UTF-8");

        //获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以上仅供参考)//

        //计算得出通知验证结果
        boolean verify_result = AlipayNotify.verifyReturn(params);

        if(verify_result){//验证成功
            //////////////////////////////////////////////////////////////////////////////////////////
            //请在这里加上商户的业务逻辑程序代码

            //——请根据您的业务逻辑来编写程序（以下代码仅作参考）——

            //判断该笔订单是否在商户网站中已经做过处理
            //如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
            //如果有做过处理，不执行商户的业务程序


            //该页面可做页面美工编辑
            logger.info("验证成功");
            //——请根据您的业务逻辑来编写程序（以上代码仅作参考）——

            Iterator iterator = params.entrySet().iterator();
            String transMsg = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
            transMsg += "<requestParams>";
            while(iterator.hasNext())
            {
                Map.Entry entry = (Map.Entry) iterator.next();
                String value =  (String) entry.getValue();
                String key = (String) entry.getKey();
                logger.info("返回参数: " + ESAPI.encoder().encodeForHTML(key) + "=" + ESAPI.encoder().encodeForHTML(value) + "<br/>");
                transMsg += "<" + key + ">" + value + "</" + key + ">";
            }
            transMsg += "</requestParams>";
            logger.info("商户订单号: " + ESAPI.encoder().encodeForHTML(out_trade_no) + "<br/>");
            logger.info("支付宝交易号: " + ESAPI.encoder().encodeForHTML(trade_no) + "<br/>");
            logger.info("交易结果: " + ESAPI.encoder().encodeForHTML(result) + "<br/>");

            PaymentServiceClient client = PaymentServiceClient.getInstance();
            PaymentResultMessage paymentResultMessage = new PaymentResultMessage();
            String transactionNo = out_trade_no.substring(0, 13);
            paymentResultMessage.setPaymentTransNo(transactionNo);
            String respCode = "-1";
            if(result.equalsIgnoreCase("SUCCESS")) {
                respCode = "00";
            }
            paymentResultMessage.setRespCode(respCode);
            paymentResultMessage.setRespMsg(result);
            paymentResultMessage.setTransMsg(transMsg);

            PaymentResponse paymentResponse = client.paymentHandlerService(transactionNo, paymentResultMessage);
            logger.info("paymentResponse.getRespCode = " + ESAPI.encoder().encodeForHTML(paymentResponse.getRespCode()));
            logger.info("paymentResponse.getRespMsg = " + ESAPI.encoder().encodeForHTML(paymentResponse.getRespMsg()));
            if(paymentResponse.getRespCode().equals("00")) {
                logger.info("交易结果处理成功");

                String openId = (String) request.getSession().getAttribute(Constant.OPEN_ID);
                sendSingleMessage(openId, out_trade_no.substring(13));

                //发送微信消息 begin
                String orderNum = out_trade_no.substring(13);
                String body = "";
                List<QueryChildOrdersByParentOrderNumResponse> list1 = client.queryChildOrdersByParentOrderNum(orderNum);
                for(QueryChildOrdersByParentOrderNumResponse queryChildOrdersByParentOrderNumResponse:list1){
                    if(Strings.isNullOrEmpty(body)) {
                        body += queryChildOrdersByParentOrderNumResponse.getShortMarketName();
                    } else {
                        body += "和" + queryChildOrdersByParentOrderNumResponse.getShortMarketName();
                    }
                }
                List<ServiceOrder> serviceOrders = client.checkOrderPaied(transactionNo);
                List<String> openIds = client.getOpenIdByAccountNum(serviceOrders.get(0).getAccntNum());
                this.sendMessage(body,orderNum, openIds);
                request.setAttribute("out_trade_no", out_trade_no);
                request.getRequestDispatcher(ViewPage.LINK2OrderAlipaySuccess).forward(request, response);
            } else {
                logger.info("交易结果处理失败");
                request.setAttribute("out_trade_no", out_trade_no);
                request.getRequestDispatcher(ViewPage.LINK2OrderAlipayFailed).forward(request, response);
            }

            //////////////////////////////////////////////////////////////////////////////////////////
        } else{
            //该页面可做页面美工编辑
            logger.info("验证失败");
            request.setAttribute("out_trade_no", out_trade_no);
            request.getRequestDispatcher(ViewPage.LINK2OrderAlipayFailed).forward(request, response);
        }
    }

    private void sendSingleMessage(String openId, String parentOrderNum) {
        AlipayClient alipayClient = AlipayAPIClientFactory.getAlipayClient();

        // 使用SDK，构建单发请求模型
        AlipayMobilePublicMessageCustomSendRequest request = new AlipayMobilePublicMessageCustomSendRequest();
        request.setBizContent(buildSingleTextMsg(openId, parentOrderNum));
        logger.info("sendSingleMessage to openid=" + ESAPI.encoder().encodeForHTML(openId) + ", parentOrderNum=" + ESAPI.encoder().encodeForHTML(parentOrderNum));
        try {
            // 使用SDK，调用单发接口发送纯文本消息
            AlipayMobilePublicMessageCustomSendResponse response = alipayClient.execute(request);
            //这里只是简单的打印，请开发者根据实际情况自行进行处理
            if (null != response && response.isSuccess()) {
                System.out.println("消息发送成功 : response = " + response.getBody());
            } else {

                System.out
                        .println("消息发送失败 code=" + response.getCode() + "msg=" + response.getMsg());
                System.out.println("response.getSubMsg()=" + response.getSubMsg());
            }

        } catch (AlipayApiException e) {
            e.printStackTrace();
            System.out.println("消息发送失败");
        }
    }

    public static String buildSingleTextMsg(String fromUserId, String parentOrderNum) {

        StringBuilder sb = new StringBuilder();

        //构建json格式单发纯文本消息体： 所有内容开发者请根据自有业务自行设置响应值，这里只是个样例
        sb.append("{'msgType':'text','text':{'content':'您订购的套餐已完成支付，订单号为" + parentOrderNum
                + "。我们会尽快为您开通服务，请关注开通短信通知，谢谢！"
                + "'}, 'toUserId':'" + fromUserId
                + "'}");

        return sb.toString();
    }

//    public static void main(String[] args) {
//        AlipayCallbackServlet servlet = new AlipayCallbackServlet();
//        servlet.sendSingleMessage("20881030927966431018599483015130", "204191");
//    }
private void sendMessage(String body ,String order, List<String> openids) throws IOException {
    HttpClient httpclient = new DefaultHttpClient();
    HttpGet httpgets = new HttpGet(
            "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="
                    + ConfigureInfo.getWechatAppid() + "&secret=" + ConfigureInfo.getWechatAppSecret() + "&");
    HttpResponse response = httpclient.execute(httpgets);
    String jsonStr = EntityUtils.toString(response.getEntity(), "UTF-8");
    jsonStr=jsonStr.replaceAll("\"|\\{|\\}", "");
    int beginIndex = jsonStr.indexOf(":");
    int endIndex = jsonStr.indexOf(",");
    String access_token = jsonStr.substring(beginIndex+1,endIndex);
    String title = "订购成功\n";

    String time =new SimpleDateFormat("MM月dd日").format(System.currentTimeMillis())+"\n" ;
    String link = ConfigureInfo.getWechatLinkLogin();
    String message = title+time+"尊敬的梅赛德斯-奔驰 智能互联客户，您选购的"+body+"订购成功，订单号"+order+"，请等待开通。点击查看详情。\n"
            +" 有任何疑问请随时使用车内【i】按钮或者400 898 0050联系客服中心。智能互联 -- 智在安心，不止于此。\n <a href='" + link + "'>请点击前往</a>";
    if(openids!=null&&openids.size()>0) {
        for(String openid:openids) {
            JSONObject jsobj = new JSONObject();
            jsobj.put("touser", openid);
            jsobj.put("msgtype", "text");
            JSONObject jsobj2 = new JSONObject();
            jsobj2.put("content", message);
            jsobj.put("text", jsobj2);
            HttpsURLRequest httpsURLRequest = new HttpsURLRequest();
            try {
                httpsURLRequest.postUrl("https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token="
                        + access_token + "", jsobj, null);
            } catch (UnrecoverableKeyException e) {
                e.printStackTrace();
            } catch (KeyManagementException e) {
                e.printStackTrace();
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            } catch (KeyStoreException e) {
                e.printStackTrace();
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }
    }
}
    /*2017-10-25;Alex:优化代码，关闭IO流等;CR-代码规范*/
    public static String convertStreamToString(InputStream ip_stream) {
        InputStreamReader ip_reader = new InputStreamReader(ip_stream);
        BufferedReader bf_reader = new BufferedReader(ip_reader);
        StringBuilder sb = new StringBuilder();

        String line = null;
        try {
            while ((line = bf_reader.readLine()) != null) {
                sb.append(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bf_reader.close();
                ip_reader.close();
                ip_stream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }
}
