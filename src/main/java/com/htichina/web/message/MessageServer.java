package com.htichina.web.message;
import com.google.common.base.Strings;
import com.htichina.common.web.Constant;
import com.htichina.web.POC.ResultBean;
import com.htichina.web.PaymentServiceClient;
import com.htichina.web.util.MessageUtil;
import com.tencent.service.HttpsURLRequest;
import org.apache.log4j.Logger;
import org.owasp.esapi.ESAPI;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by yaliu on 2017/5/2.
 */
public class MessageServer {
    private static Logger logger = Logger.getLogger(MessageServer.class.getName());
    private static String poiName;
    /**
     * 处理微信发来的请求
     *
     * @param request
     * @return
     */
    public static String processRequest(HttpServletRequest request) throws UnsupportedEncodingException {
        /*request.setCharacterEncoding("UTF-8");*/
        String respMessage = "success";
        try {
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

            // 回复文本消息
            TextReponse textMessage = new TextReponse();
            textMessage.setToUserName(fromUserName);
            textMessage.setFromUserName(toUserName);
            textMessage.setCreateTime(new Date().getTime());
            textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
            textMessage.setFuncFlag(0);

            // 文本消息
            if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) {
                // 文本消息暂不处理
            }
            // 图片消息
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_IMAGE)) {
                // 图片消息暂不处理
            }
            // 地理位置消息
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LOCATION)) {
                logger.info("send poi");
                // 经度
                String longitude = requestMap.get("Location_Y");
                // 纬度
                String latitude = requestMap.get("Location_X");
                logger.info("requestMap = "+ ESAPI.encoder().encodeForHTML(requestMap.toString()));
                // PoiName
                if(Strings.isNullOrEmpty(poiName)){
                    poiName = Constant.DEFAULT_POINAME;
                }
                logger.info("poiName = "+ESAPI.encoder().encodeForHTML(poiName));
                // openId
                String openId = requestMap.get("FromUserName");
                // accountNumber
                String accountNum =  PaymentServiceClient.getInstance().getActiveAccountByOpenId(openId);
                logger.info("accountNum = "+ ESAPI.encoder().encodeForHTML(accountNum));
                if(Strings.isNullOrEmpty(accountNum)){
                    respContent = Constant.SENDPOI_NULLACCOUNT;
                    logger.info("get accountNum failed");
                }
                else{
                    // request
                    HttpsURLRequest req = new HttpsURLRequest();
                    // 参数
                    Map<String,String> param = new HashMap<>();
                    param.put(Constant.HTTPS_ACCOUNTNUM,accountNum);
                    param.put(Constant.HTTPS_LATITUDE,latitude);
                    param.put(Constant.HTTPS_LONGITUDE,longitude);
                    param.put(Constant.HTTPS_POINAME,poiName);
                    logger.info("param = "+ESAPI.encoder().encodeForHTML(param.toString()));
                    ResultBean result = req.NoSecurityPost(Constant.HTTPS_SENDPOI,param);
                    if(result != null){
                        logger.info("result = "+ESAPI.encoder().encodeForHTML(result.toString()));
                    }
                    if(result != null){
                        if(result.isFlag()){
                            respContent = Constant.SENDPOI_SUCCESS;
                            logger.info("send POI Success");
                        }
                        else{
                            respContent = Constant.SENDPOI_FAILED;
                            logger.info("send POI failed message = "+ESAPI.encoder().encodeForHTML(result.getMessage()));
                        }

                    }
                }

                logger.info("msgType = "+ESAPI.encoder().encodeForHTML(msgType));
                logger.info("eventType = "+ESAPI.encoder().encodeForHTML(requestMap.get("Event")));
                textMessage.setContent(respContent);
                respMessage = MessageUtil.textMessageToXml(textMessage);
            }
            // 链接消息
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LINK)) {
                // 链接消息暂不处理
            }
            // 音频消息
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VOICE)) {
                // 音频消息暂不处理
            }
            // 事件推送
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)) {
                // 事件类型
                String eventType = requestMap.get("Event");
                // 订阅
                if (eventType.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) {
                    // 订阅事件暂不处理
                }
                // 取消订阅
                else if (eventType.equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) {
                    // TODO 取消订阅后用户再收不到公众号发送的消息，因此不需要回复消息
                }
                // 自定义菜单点击事件
                else if (eventType.equals(MessageUtil.EVENT_TYPE_CLICK)) {
                    // TODO 自定义菜单权没有开放，暂不处理该类消息
                }
                // 自定义菜单点击事件
                else if (eventType.equals(MessageUtil.EVENT_TYPE_LOCSELECT)) {
                    /*respContent = "位置选择select";*/
                    logger.info("requestMap = "+ ESAPI.encoder().encodeForHTML(requestMap.toString()));
                    poiName = requestMap.get("Poiname");
                    logger.info("POINAME == "+ESAPI.encoder().encodeForHTML(poiName));
                }
                // 自定义菜单点击事件
                else if (eventType.equals(MessageUtil.EVENT_TYPE_LOCATION)) {
                    /*respContent = "位置事件location";*/
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return respMessage;
}
}
