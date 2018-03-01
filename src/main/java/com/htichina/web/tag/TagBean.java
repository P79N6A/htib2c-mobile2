package com.htichina.web.tag;

import com.htichina.common.web.Constant;
import com.htichina.web.common.ViewPage;
import net.sf.json.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.owasp.esapi.ESAPI;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The main class for handling the wechat tag
 * Created by liuyan on 2017/4/5.
 */
@Component
@Scope("session")
public class TagBean implements Serializable {
    private static Logger logger = Logger.getLogger(TagBean.class.getName());

    private String openId;
    private String accountName;

    private String tagId;
    private String tagName;

    private boolean flag;

    private String token;

    private String tagRep;
    /**
     * 得到微信原生后台access_Token对应公众号已有全部标签
     * param null
     * return String 查询结果
     * throws IOException
     */
    public String getAllTags() throws IOException {
//        String token =  "UGPTil07LmyV_jneBWFaSqTBGgbKYBdxJvOVeNDmmJzxQEQTV47RllA8uXXKYtvl6M0YTv_Dcc9rT1KXYQeqq8IG-PideIj3Ndtj2DE6zkNGDyYuieX7ztyfsBsGu42LXFYgADAPXQ";
        HttpClient httpclient = new DefaultHttpClient();
        HttpGet httpgets = new HttpGet(
                "https://api.weixin.qq.com/cgi-bin/tags/get?"
                        + "access_token=" + token + "");
        HttpResponse response = httpclient.execute(httpgets);
        String jsonStr = EntityUtils.toString(response.getEntity(), "UTF-8");
        return jsonStr;

    }
    /**
     * 通过openId获得该用户tag
     * param null
     * return String 返回页面
     * throws IOException
     */
    public String[] getTagsByOpenId(String atoken, String oId) throws IOException{
        token = atoken;
        openId = oId;
        logger.info("ingetTagsByOpenId---getWechatTag=="+ ESAPI.encoder().encodeForHTML(atoken)+"++"+ESAPI.encoder().encodeForHTML(oId));
        String wechatTag = getWechatTag(atoken,oId);
        logger.info("ingetTagsByOpenId--->wechatTag=="+ESAPI.encoder().encodeForHTML(wechatTag));
        String[] wechatTags = parseToTagsWE(wechatTag);
        String WManTag = getWundermanTag(oId);
        logger.info("ingetTagsByOpenId--->WManTag=="+ESAPI.encoder().encodeForHTML(WManTag));
        String[] wmanTags = parseToTagsWM(WManTag);
        if(wmanTags != null){
            logger.info("ingetTagsByOpenId--->wmanTags=="+ESAPI.encoder().encodeForHTML(wmanTags.toString()));
        }
        if(wechatTags == null || wmanTags == null){
            return null;
        }
        String[] tags = new String[wechatTags.length+wmanTags.length];
        for(int i = 0; i < wechatTags.length; i++){
            tags[i] = wechatTags[i];
        }
        for(int i = wechatTags.length,j = 0; i < tags.length; i++,j++){
            tags[i] = wmanTags[j];
        }
        if(tags != null){
            logger.info("ingetTagsByOpenId--->tags=="+ESAPI.encoder().encodeForHTML(tags.toString()));
        }

        tagName = "wunder标签："+WManTag+"+微信原生后台标签："+wechatTag;
        return tags;
    }
    /**
     * 转换WunderMan标签为数组
     */
    public String[] parseToTagsWM(String tagStr)throws IOException {
        if(tagStr==null||"".equals(tagStr)||tagStr.indexOf("errors")>-1){
            logger.info("null!!!");
            return null;
        }
        logger.info("parseToTagsWM");
        List<Tag> list=new ArrayList<Tag>();
        tagStr=tagStr.trim();
        tagStr=tagStr.replaceAll("\"|\\{|\\}", "");//去掉双引号，大括号
        int beginIndex=tagStr.indexOf('[')+1;//获取[]的两个坐标
        tagStr=tagStr.substring(beginIndex);//截取需求数据
        String temp[]=tagStr.split(",");//按,分割
        String str[] = new String[temp.length/2];
        for(int i=0,j = 0;i<temp.length;i=i+2,j++)
        {
            str[j] = temp[i].split(":")[1];
        }
        return str;
    }
    /**
     * 转换微信标签为数组
     */
    public String[] parseToTagsWE(String tagStr) throws IOException {
        if(tagStr==null||"".equals(tagStr)||tagStr.indexOf("errcode")>-1){
            logger.info("return null");
            return null;
        }
        logger.info("in parseToTagsWE");
        tagStr=tagStr.trim();
        tagStr=tagStr.replaceAll("\"|\\{|\\}", "");//去掉双引号，大括号
        int beginIndex=tagStr.indexOf('[')+1;//获取[]的两个坐标
        int endIndex=tagStr.indexOf(']');
        tagStr=tagStr.substring(beginIndex, endIndex);//截取需求数据
        String temp[]=tagStr.split(",");//按,分割
        String str = getAllTags();
        if(str==null||"".equals(str)||str.indexOf("errcode")>-1) {
            return null;
        }
        List<Tag> tagList = getTagList(str);
        for(int j = 0; j < temp.length; j++){
            for(int i = 0; i < tagList.size(); i++){
                if(temp[j].equals(tagList.get(i).getId())){
                    temp[j] = tagList.get(i).getName();
                }
            }
        }
        return temp;
    }
    /**
     * 获取微信原生后台openId所有标签
     * param null
     * return String 微信原生后台openId所有标签
     * throws IOException
     */
    public String getWechatTag(String atoken,String oId) throws IOException {
        token = atoken;
        openId = oId;
        HttpClient httpclient = new DefaultHttpClient();
//        String token =  "UGPTil07LmyV_jneBWFaSqTBGgbKYBdxJvOVeNDmmJzxQEQTV47RllA8uXXKYtvl6M0YTv_Dcc9rT1KXYQeqq8IG-PideIj3Ndtj2DE6zkNGDyYuieX7ztyfsBsGu42LXFYgADAPXQ";
        HttpPost httpost = new HttpPost(
                "https://api.weixin.qq.com/cgi-bin/tags/getidlist?access_token="
                        + atoken + "");
        Map<String, String> map = new HashMap<String, String>();
        map.put("openid",oId);
        JSONObject jsonObject = JSONObject.fromObject(map);
        String param = jsonObject.toString();
        httpost.setEntity(new StringEntity(param, "UTF-8"));
        HttpResponse resp = httpclient.execute(httpost);
        String jsonStr = EntityUtils.toString(resp.getEntity(), "UTF-8");
        return jsonStr;
    }
    /**
     * 获取WunderMan平台openId所有标签
     * param null
     * return String WunderMan平台openId所有标签
     * throws IOException
     */
    public String getWundermanTag(String oId) throws IOException{
        String wManToken = getWManAccessToken();
        String fhtToken = Constant.WMAN_FHT_TOKEN;
        HttpClient httpclient = new DefaultHttpClient();
        HttpPost httpost = new HttpPost(
                "http://api.parllay.cn/v1.1/user/"+fhtToken+"/get?access_token="+wManToken+"");
        String param = "[\""+oId+"\"]";
        httpost.setEntity(new StringEntity(param, "UTF-8"));
        HttpResponse resp = httpclient.execute(httpost);
        String jsonStr = EntityUtils.toString(resp.getEntity(), "UTF-8");
        String result = parseWManTag(jsonStr);
        return result;
    }
    /**
     * 获取WunderMan接口所需AccessToken
     * param null
     * return String WunderMan接口所需AccessToken
     * throws IOException
     */
    public String getWManAccessToken() throws IOException{
        String id = Constant.WMAN_APP_ID;
        String secret = Constant.WMAN_APP_SECRET;
        HttpClient httpclient = new DefaultHttpClient();
        HttpGet httpgets = new HttpGet(
                "http://api.parllay.cn/v1.1/token/get?app_id="+id+"&app_secret="+secret+"");
        HttpResponse response = httpclient.execute(httpgets);
        String jsonStr = EntityUtils.toString(response.getEntity(), "UTF-8");
        if(jsonStr.indexOf("errors") > -1){
            return null;
        }
        jsonStr=jsonStr.replaceAll("\"|\\{|\\}", "");
        jsonStr=jsonStr.replaceAll("access_token", "");
        jsonStr=jsonStr.replaceAll(":", "");
        return jsonStr;
    }
    /**
     * 向wunderman和wechat同时打标签操作
     * param null
     * return String 返回页面
     * throws IOException
     */
    public boolean setTag(String groupName,String tName,String aToken, String oId) throws IOException {
        token = aToken;
        openId = oId;
        boolean weFlag = setWechatTag(tName,aToken,oId);
        logger.info("to setWManTag");
        boolean wmFlag = setWManTag(groupName,tName,oId);
        if(wmFlag){
            logger.info("setWManTag flag = true");
        }

        tagRep = getRep(weFlag,wmFlag);
        return weFlag & wmFlag;
    }
    /**
     * 向微信原生后台为指定用户打指定标签
     * param null
     * return Boolean 操作结果
     * throws IOException
     */
    public Boolean setWechatTag(String tName,String aToken, String oId) throws IOException{
        token = aToken;
        openId = oId;
        tagId  = null;
        HttpClient httpclient = new DefaultHttpClient();
//        String token =  "UGPTil07LmyV_jneBWFaSqTBGgbKYBdxJvOVeNDmmJzxQEQTV47RllA8uXXKYtvl6M0YTv_Dcc9rT1KXYQeqq8IG-PideI？j3Ndtj2DE6zkNGDyYuieX7ztyfsBsGu42LXFYgADAPXQ";
        String tagStr = getAllTags();
        if(tagStr==null||"".equals(tagStr)||tagStr.indexOf("errcode")>-1) {
            return false;
        }
        List<Tag> tagList = getTagList(tagStr);
        for(int i = 0; i < tagList.size(); i++){
            if(tName.equals(tagList.get(i).getName())){
                tagId = tagList.get(i).getId();
                break;
            }
        }
        if(tagId != null){
            HttpPost httpost = new HttpPost(
                    "https://api.weixin.qq.com/cgi-bin/tags/members/batchtagging?access_token="
                            + aToken + "");
            String param =  "{\"openid_list\":[\""+oId+"\"],\"tagid\":"+tagId+"}";
            httpost.setEntity(new StringEntity(param, "UTF-8"));
            HttpResponse resp = httpclient.execute(httpost);
            String jsonStr = EntityUtils.toString(resp.getEntity(), "UTF-8");
            if (jsonStr.indexOf("ok") > -1){
                return  true;
            }
        }
        return false;
    }
    /**
     * 向Wunderman平台为指定用户打指定标签
     * param null
     * return Boolean 操作结果
     * throws IOException
     */
    public String setWManTag1() throws IOException{
        Boolean mFlag = false;
        String fhtToken = Constant.WMAN_FHT_TOKEN;
        String token = getWManAccessToken();
        HttpClient httpclient = new DefaultHttpClient();
        HttpPost httpost = new HttpPost(
                "http://api.parllay.cn/v1.1/tag/"+fhtToken+"/"+tagName+"?access_token="+token+"&group=");
        String param1 = "[\""+openId+"\"]";
        httpost.setEntity(new StringEntity(param1, "UTF-8"));
        HttpResponse response = httpclient.execute(httpost);
        /*HttpResponse response = httpclient.execute(httpgets)*/;
        String jsonStr = EntityUtils.toString(response.getEntity(), "UTF-8");
        if (!(jsonStr.indexOf("errors") > -1)){
            flag = true;
        }
        return ViewPage.LINK2TAGTEST;

    }
    public Boolean setWManTag(String groupName,String tNane,String oId) throws IOException{
        String fhtToken = Constant.WMAN_FHT_TOKEN;
        String token = getWManAccessToken();
        HttpClient httpclient = new DefaultHttpClient();
        logger.info("set WManTag fhtToken="+ESAPI.encoder().encodeForHTML(fhtToken));
        logger.info("set WManTag aToken="+ESAPI.encoder().encodeForHTML(token));
        logger.info("set WManTag openId="+ESAPI.encoder().encodeForHTML(oId));
        logger.info("set WManTag tName="+ESAPI.encoder().encodeForHTML(tNane));
        try {
            HttpGet httpget = new HttpGet(
                    "http://api.parllay.cn/v1.1/tag/" + fhtToken + "/" + tNane + "?access_token=" + token +"&group="+groupName+ "&openid=" + oId + "");
            HttpResponse response = httpclient.execute(httpget);
            logger.info("httpGet ="+ESAPI.encoder().encodeForHTML(httpget.getURI().toString()));
            String jsonStr = EntityUtils.toString(response.getEntity(), "UTF-8");
            if (!(jsonStr.indexOf("errors") > -1)){
                logger.info("setWManTag success");
                return true;
            }
            logger.info("setWManTag Failed");
        }
        catch(Exception e){
            logger.info("set WManTagFaile...");
            return false;
        }
        return false;

    }
    /**
     * 向wunderman和wechat同时取消标签操作
     * param null
     * return String 返回页面
     * throws IOException
     */
    public boolean delTag(String groupName,String tName,String aToken,String oId) throws IOException {
        token = aToken;
        openId = oId;
        boolean weFlag = delWechatTag(tName,aToken,oId);
        boolean wmFlag = delWManTag(groupName,tName,oId);
        tagRep = getRep(weFlag,wmFlag);
        return weFlag & wmFlag;
    }

    /**
     * 从微信原生后台为指定用户取消指定标签
     * param null
     * return Boolean 操作结果
     * throws IOException
     */

    public Boolean delWechatTag(String tName,String aToken,String oId) throws IOException{
        token = aToken;
        openId = oId;
        tagId  = null;
        HttpClient httpclient = new DefaultHttpClient();
//        String token =  "UGPTil07LmyV_jneBWFaSqTBGgbKYBdxJvOVeNDmmJzxQEQTV47RllA8uXXKYtvl6M0YTv_Dcc9rT1KXYQeqq8IG-PideIj3Ndtj2DE6zkNGDyYuieX7ztyfsBsGu42LXFYgADAPXQ";
        String tagStr = getAllTags();
        if(tagStr==null||"".equals(tagStr)||tagStr.indexOf("errcode")>-1) {
            return false;
        }
        List<Tag> tagList = getTagList(tagStr);
        for(int i = 0; i < tagList.size(); i++){
            if(tName.endsWith(tagList.get(i).getName())){
                tagId = tagList.get(i).getId();
                break;
            }
        }
        if(tagId != null){
            HttpPost httpost = new HttpPost(
                    "https://api.weixin.qq.com/cgi-bin/tags/members/batchuntagging?access_token="
                            + aToken + "");
            String param =  "{\"openid_list\":[\""+oId+"\"],\"tagid\":"+tagId+"}";
            httpost.setEntity(new StringEntity(param, "UTF-8"));
            HttpResponse resp = httpclient.execute(httpost);
            String jsonStr = EntityUtils.toString(resp.getEntity(), "UTF-8");
            if (jsonStr.indexOf("ok") > -1){
                return true;
            }
        }
        return false;
    }
    /**
     * 从Wunderman后台为指定用户取消指定标签
     * param null
     * return Boolean 操作结果
     * throws IOException
     */
    public Boolean delWManTag(String groupName,String tName,String oId)throws IOException{
        Boolean mFlag = false;
        String fhtToken = Constant.WMAN_FHT_TOKEN;
        String token = getWManAccessToken();
        HttpClient httpclient = new DefaultHttpClient();
        HttpGet httpget = new HttpGet(
                "http://api.parllay.cn/v1.1/untag/"+fhtToken+"/"+tName+"?access_token="+token+"&group"+groupName+"&openid="+oId+"");
        HttpResponse response = httpclient.execute(httpget);
        String jsonStr = EntityUtils.toString(response.getEntity(), "UTF-8");
        if (!(jsonStr.indexOf("errors") > -1)){
            return true;
        }
        return false;

    }
    //获得操作结果
    public String getRep(Boolean weFlag,Boolean wmFlag){
        String rep = null;
        if(weFlag && wmFlag){
            rep = "操作成功";
        }
        else if(!weFlag && !wmFlag){
            rep = "操作失败";
        }
        else{
            if(!weFlag){
                rep +="微信操作失败";
            }
            else{
                rep +="微信操作成功";
            }
            if(!wmFlag){
                rep +="WunderMan操作失败";
            }
            else{
                rep +="WunderMan操作成功";
            }
        }
        return rep;
    }

    public List<Tag> getTagList(String tagStr)
    {
        if(tagStr==null||"".equals(tagStr))
            return null;

        List<Tag> list=new ArrayList<Tag>();
        tagStr=tagStr.trim();
        tagStr=tagStr.replaceAll("\"|\\{|\\}", "");//去掉双引号，大括号
        int beginIndex=tagStr.indexOf('[')+1;//获取[]的两个坐标
        int endIndex=tagStr.indexOf(']');
        tagStr=tagStr.substring(beginIndex, endIndex);//截取需求数据
        String temp[]=tagStr.split(",");//按,分割
        //System.out.println(Arrays.toString(temp));
        for(int i=0;i<temp.length;i=i+3)
        {
            Tag strTemp=new Tag();
            strTemp.setId(temp[i].split(":")[1]);
            strTemp.setName(temp[i+1].split(":")[1]);
            strTemp.setCount(temp[i+2].split(":")[1]);
            list.add(strTemp);
        }
        return list;
    }

    /**
     * 转换Wunderman用户数据为tag
     * param Wunderman用户数据
     * return String Wunderman tag
     */

    public  String parseWManTag(String jsonStr){
        jsonStr = jsonStr.trim();
        if(jsonStr == null || "".equals(jsonStr) || jsonStr.indexOf("errors")>-1){
            return null;
        }
        jsonStr = jsonStr.replaceAll("\"|\\{|\\}", "");
        int beginIndex = jsonStr.indexOf("tags")+5;
        jsonStr = jsonStr.substring(beginIndex);
        int endIndex = jsonStr.indexOf("]");
        /*int endIndex = jsonStr.indexOf(",");*/
        jsonStr = jsonStr.substring(0,endIndex-1);
        return jsonStr;
    }

    public void dataReset(){
        openId = null;
        accountName = null;
        tagId = null;
        tagName = null;
    }

    public String getOpenId() {
        return openId;
    }
    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getAccountName() {
        return accountName;
    }
    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getTagName() {
        return tagName;
    }
    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public String getTagId() {
        return tagId;
    }
    public void setTagId(String tagId) {
        this.tagId = tagId;
    }

    public String getToken() {
        return token;
    }
    public void setToken(String token) {
        this.token = token;
    }

    public boolean getFlag(){return flag;}
    public void setFlag(boolean flag){this.flag = flag;}

    public String getTagRep() {
        String temp = null;
        temp = tagRep;
        tagRep = null;
        return temp;
    }

    public void setTagRep(String tagRep) {
        this.tagRep = tagRep;
    }
}
