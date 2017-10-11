package com.htichina.web.util;

import com.htichina.web.message.TextReponse;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;
import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.owasp.esapi.ESAPI;

import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;
import java.io.Writer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yaliu on 2017/5/2.
 * 消息工具类
 */
public class MessageUtil {
    private static Logger logger = Logger.getLogger(MessageUtil.class.getName());
    /**
     * 返回消息类型：文本
     */
    public static final String RESP_MESSAGE_TYPE_TEXT = "text";

    /**
     * 返回消息类型：音乐
     */
    public static final String RESP_MESSAGE_TYPE_MUSIC = "music";

    /**
     * 返回消息类型：图文
     */
    public static final String RESP_MESSAGE_TYPE_NEWS = "news";

    /**
     * 请求消息类型：文本
     */
    public static final String REQ_MESSAGE_TYPE_TEXT = "text";

    /**
     * 请求消息类型：图片
     */
    public static final String REQ_MESSAGE_TYPE_IMAGE = "image";

    /**
     * 请求消息类型：链接
     */
    public static final String REQ_MESSAGE_TYPE_LINK = "link";

    /**
     * 请求消息类型：地理位置
     */
    public static final String REQ_MESSAGE_TYPE_LOCATION = "location";

    /**
     * 请求消息类型：音频
     */
    public static final String REQ_MESSAGE_TYPE_VOICE = "voice";

    /**
     * 请求消息类型：推送
     */
    public static final String REQ_MESSAGE_TYPE_EVENT = "event";

    /**
     * 事件类型：subscribe(订阅)
     */
    public static final String EVENT_TYPE_SUBSCRIBE = "subscribe";

    /**
     * 事件类型：unsubscribe(取消订阅)location_select
     */
    public static final String EVENT_TYPE_UNSUBSCRIBE = "unsubscribe";
    /**
     * 事件类型：unsubscribe(位置选择)
     */
    public static final String EVENT_TYPE_LOCSELECT = "location_select";
    /**
     * 事件类型：unsubscribe(位置)
     */
    public static final String EVENT_TYPE_LOCATION = "LOCATION";


    /**
     * 事件类型：CLICK(自定义菜单点击事件)
     */
    public static final String EVENT_TYPE_CLICK = "CLICK";
    /**
     * 解析微信发来的请求（XML）
     *
     * @param request
     * @return
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    public static Map<String, String> parseXml(HttpServletRequest request) throws Exception {
        /*request.setCharacterEncoding("UTF-8");*/
        // 将解析结果存储在HashMap中
        Map<String, String> map = new HashMap<String, String>();

        // 从request中取得输入流
        InputStream inputStream = request.getInputStream();
        // 读取输入流
        SAXReader reader = new SAXReader();
        reader.setEncoding("utf-8");
        Document document = reader.read(inputStream);
        document.setXMLEncoding("utf-8");
        // 得到xml根元素
        Element root = document.getRootElement();
        // 得到根元素的所有子节点
        List<Element> elementList = root.elements();


        // 遍历所有子节点
        for (Element e : elementList){
            if("SendLocationInfo".equals(e.getName())){
                List<Element> eList = e.elements();
                for(Element t : eList){
                    if("CreateTime".equals(t.getName())){
                        logger.info("CreateTime-->"+ ESAPI.encoder().encodeForHTML(t.getText()));
                        String text = new String(formatTime(t.getText()).getBytes("UTF-8"),"UTF-8");
                        map.put(t.getName(),text);
                    }
                    else {
                        String text = new String(t.getText().getBytes("UTF-8"),"UTF-8");
                        map.put(t.getName(),text);
                    }
                }
            }
            else {
                if("CreateTime".equals(e.getName())){
                    map.put(e.getName(), formatTime(e.getText()));
                }
                else {
                    String text = new String(e.getText().getBytes("UTF-8"),"UTF-8");
                    map.put(e.getName(),text);
                }
            }
        }


        // 释放资源
        inputStream.close();
        inputStream = null;

        return map;
    }
    /**
     * 将微信消息中的CreateTime转换成标准格式的时间（yyyy-MM-dd HH:mm:ss）
     *
     * @param createTime 消息创建时间
     * @return
     */
    public static String formatTime(String createTime) {
        // 将微信传入的CreateTime转换成long类型，再乘以1000
        long msgCreateTime = Long.parseLong(createTime) * 1000L;
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(new Date(msgCreateTime));
    }
    /**
     * 扩展xstream，使其支持CDATA块
     *
     * @date 2013-05-19
     */
    private static XStream xstream = new XStream(new XppDriver() {
        public HierarchicalStreamWriter createWriter(Writer out) {
            return new PrettyPrintWriter(out) {
                // 对所有xml节点的转换都增加CDATA标记
                boolean cdata = true;

                @SuppressWarnings("unchecked")
                public void startNode(String name, Class clazz) {
                    super.startNode(name, clazz);
                }

                protected void writeText(QuickWriter writer, String text) {
                    if (cdata) {
                        writer.write("<![CDATA[");
                        writer.write(text);
                        writer.write("]]>");
                    } else {
                        writer.write(text);
                    }
                }
            };
        }
    });
    /**
     * 文本消息对象转换成xml
     *
     * @param textMessage 文本消息对象
     * @return xml
     */
    public static String textMessageToXml(TextReponse textMessage) {
        /*xstream.alias("xml", textMessage.getClass());
        return xstream.toXML(textMessage);*/
        String result = "<xml>\n" +
                "<ToUserName><![CDATA["+textMessage.getToUserName()+"]]></ToUserName>\n" +
                "<FromUserName><![CDATA["+textMessage.getFromUserName()+"]]></FromUserName>\n" +
                "<CreateTime>"+textMessage.getCreateTime()+"</CreateTime>\n" +
                "<MsgType><![CDATA["+textMessage.getMsgType()+"]]></MsgType>\n" +
                "<Content><![CDATA["+textMessage.getContent()+"]]></Content>\n" +
                "</xml>";
        return result;
    }
    /**
     * 文本消息对象转换成json
     *
     * @param textMessage 文本消息对象
     * @return xml
     */
    public static String textMessageToJson(TextReponse textMessage) {
        String result = "success";
        result = "{\n" +
                "    \"touser\":\""+textMessage.getToUserName()+"\",\n" +
                "    \"msgtype\":\"text\",\n" +
                "    \"text\":\n" +
                "    {\n" +
                "         \"content\":\"POI已发送到车辆\"\n" +
                "    }\n" +
                "}";
        return result;
    }

    
}
