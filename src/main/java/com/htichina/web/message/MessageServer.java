package com.htichina.web.message;

import com.google.common.base.Strings;
import com.htichina.common.web.ConfigureInfo;
import com.htichina.common.web.Constant;
import com.htichina.web.POC.ResultBean;
import com.htichina.web.PaymentServiceClient;
import com.htichina.web.util.MessageUtil;
import com.tencent.service.HttpsURLRequest;
import com.tencent.service.WechatAccessTokenUtils;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.owasp.esapi.ESAPI;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by yaliu on 2017/5/2.
 */
public class MessageServer {
    private static Logger logger = Logger.getLogger(MessageServer.class.getName());
    /**
     * 处理微信发来的请求
     *
     * @param request
     * @return
     */
    public  String processRequest(HttpServletRequest request) throws UnsupportedEncodingException {
        /*request.setCharacterEncoding("UTF-8");*/
        String respMessage = "success";
        try {
            String poiName="";
            // 默认返回的文本消息内容
            String respContent = "";

            // xml请求解析
            Map<String, String> requestMap = MessageUtil.parseXml(request);

            // 发送方帐号（open_id）
            String fromUserName = requestMap.get("FromUserName");
            // 公众帐号
            String toUserName = requestMap.get("ToUserName");
            // 消息类型
            String msgType = requestMap.get("MsgType");
            //消息
            String event = requestMap.get("Event");
            logger.info("msgType=============="+msgType);
            logger.info("event=============="+event);
            if (event!=null&&event.equals(MessageUtil.EVENT_TYPE_LOCSELECT)&&msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)) {
                logger.info("send poi");
                // 经度
                String longitude = requestMap.get("Location_Y");
                // 纬度
                String latitude = requestMap.get("Location_X");
                poiName = requestMap.get("Poiname");
                logger.info("poiName ================ " + poiName);
                logger.info("latitude ================ " + latitude);
                logger.info("longitude ================ " + longitude);
                // PoiName
                if (Strings.isNullOrEmpty(poiName)) {
                    poiName = Constant.DEFAULT_POINAME;
                }
                // openId
                String openId = requestMap.get("FromUserName");
                String accountNum =  PaymentServiceClient.getInstance().getActiveAccountByOpenId(openId);
//                String accountNum = "10631849";
                logger.info("accountNum = " +accountNum);
                if (Strings.isNullOrEmpty(accountNum)) {
                    respContent = Constant.SENDPOI_NULLACCOUNT;
                    logger.info("get accountNum failed");
                } else {
                    // request
                    HttpsURLRequest req = new HttpsURLRequest();
                    // 参数
                    Map<String, String> param = new HashMap<>();
                    param.put(Constant.HTTPS_ACCOUNTNUM, accountNum);
                    param.put(Constant.HTTPS_LATITUDE, latitude);
                    param.put(Constant.HTTPS_LONGITUDE, longitude);
                    param.put(Constant.HTTPS_POINAME, poiName);
                    logger.info("param = " + ESAPI.encoder().encodeForHTML(param.toString()));
                    ResultBean result = req.NoSecurityPost(Constant.HTTPS_SENDPOI, param);
                    if (result != null) {
                        logger.info("result = " + result.toString());
                    }
                    if (result != null) {
                        if (result.isFlag()) {
                            respContent = Constant.SENDPOI_SUCCESS;
                            logger.info("send POI Success");

                        } else {
                            respContent = Constant.SENDPOI_FAILED;
                            logger.info("send POI failed message = " + result.getMessage());

                        }

                    }
                }

                logger.info("respContent ============= " + respContent);
                sendMessage(respContent,openId);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return respMessage;
    }

    private void sendMessage(String body , String openid) throws IOException {
        String access_token = WechatAccessTokenUtils.getWechatToken();
        JSONObject jsobj = new JSONObject();
        jsobj.put("touser", openid);
        jsobj.put("msgtype", "text");
        JSONObject jsobj2 = new JSONObject();
        jsobj2.put("content", body);
        jsobj.put("text", jsobj2);
        HttpsURLRequest httpsURLRequest  =new HttpsURLRequest();
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
