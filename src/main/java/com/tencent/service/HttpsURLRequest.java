package com.tencent.service;

import static java.lang.Thread.sleep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.UnrecoverableKeyException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.stereotype.Component;

import com.htichina.common.web.ConfigureInfo;
import com.htichina.common.web.Constant;
import com.htichina.web.POC.ResultBean;

/**
 * User: liuning
 * Date: 2017/06/23
 */
@Component
public class HttpsURLRequest  {
    //连接超时时间，默认10秒
    private int socketTimeout = 10000;

    //传输超时时间，默认30秒
    private int connectTimeout = 30000;

    //定位请求次数，默认5次
    private int locateTimes = 50;

    //定位请求时间间隔,默认2秒
    private int locatedurat = 2000;

    //请求器的配置
    private RequestConfig requestConfig;

    //表示请求器是否已经做了初始化工作
    private boolean hasInit = false;

    //主数据
    private String DATA = "Data";

    //头数据
    private String HEADER = "header";

    //成功返回值
    private String RESPONSEDESCRIPTION = "Success";
    private String RESPONSECODE = "2000";

    //HTTP请求器
    private CloseableHttpClient httpClient = HttpClients.createDefault();

    private static String getUserInfoUrl =ConfigureInfo.getGetUserInfoUrl();
    private static String flashlightsUrl =ConfigureInfo.getFlashlightsUrl();
    private static String locatevehicleUrl =ConfigureInfo.getLocatevehicleUrl();
    private static String locatevehiclefinalreqUrl =ConfigureInfo.getLocatevehiclefinalreqUrl();
    private static String doorlockunlockurl =ConfigureInfo.getDoorlockunlockurl();
    private static String senddestinationUrl =ConfigureInfo.getSenddestinationUrl();


    public HttpsURLRequest() {
        init();
    }
    private void init(){
        //根据默认超时限制初始化requestConfig
        requestConfig = RequestConfig.custom().setSocketTimeout(socketTimeout).setConnectTimeout(connectTimeout).build();

        hasInit = true;
    }

    /**
     * @param URL 请求的URL
     * @param json 请求的json参数
     * @param headerMap 请求的头信息
     * @return
     * @throws UnrecoverableKeyException
     * @throws KeyManagementException
     * @throws NoSuchAlgorithmException
     * @throws KeyStoreException
     * @throws IOException
     */
    public JSONObject postUrl(String URL, JSONObject json, Map<String,String> headerMap) throws UnrecoverableKeyException, KeyManagementException, NoSuchAlgorithmException, KeyStoreException, IOException, URISyntaxException {
        if (!hasInit) {
            init();
        }
        HttpPost post = new HttpPost(URL);
        //设置请求器的配置
//        post.setHeader("Content-Type", "application/json");
        if(headerMap!=null){
            for(String key : headerMap.keySet()){
                post.addHeader(key,headerMap.get(key));
            }
        }
        try {
            if(json!=null) {
                String a = json.toString();
                StringEntity s = new StringEntity(json.toString(), "utf-8");
                s.setContentEncoding("UTF-8");
                s.setContentType("application/json");
                post.setEntity(s);
            }
            System.out.println("------------------------begin-----------------------------");
            System.out.println("请求url为：");
            System.out.println(URL);
            System.out.println("请求参数为：");
            System.out.println(json);
            //设置请求器的配置
            post.setConfig(requestConfig);
            // 发送请求
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpResponse httpResponse = httpClient.execute(post);
            // 获取响应输入流
            /*2017-10-25;Alex:优化代码，关闭IO流等;CR-代码规范*/
            InputStream inStream = httpResponse.getEntity().getContent();
            InputStreamReader ip_reader = new InputStreamReader(inStream, "utf-8");
            BufferedReader bf_reader = new BufferedReader(ip_reader);
            StringBuilder strber = new StringBuilder();
            String line = null;
            while ((line = bf_reader.readLine()) != null){
            	strber.append(line + "\n");
            }
            bf_reader.close();
            ip_reader.close();
            inStream.close();
            String result = strber.toString();
            //string转Json
//            //取头信息
//            Header[] headers = httpResponse.getAllHeaders();
//            JSONObject headerJson = new JSONObject();
//            for(int i=0;i<headers.length;i++) {
//                headerJson.put(headers[i].getName(),headers[i].getValue());
//            }
//            jsStr.put(HEADER,headerJson);

            JSONObject jsStr = null;
            if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                System.out.println("请求服务器成功，返回：");
            } else {
                System.out.println("请求服务端失败");
                jsStr=null;
                return jsStr;
            }
            jsStr = JSONObject.fromObject(result);
            //返回数据
            System.out.println(jsStr.toString());
            System.out.println("-----------------------end------------------------------");
            return jsStr;
        } catch (Exception e) {
            System.out.println("请求异常");
            System.out.println(e);
            throw new RuntimeException(e);
        }

    }

    /**
     * 绕过安全验证发送请求
     * @param key 第三步 标识
     * @param params 第三步参数
     * @throws UnrecoverableKeyException
     * @throws IOException
     * @throws NoSuchAlgorithmException
     * @throws KeyStoreException
     * @throws KeyManagementException
     */
    public ResultBean NoSecurityPost(String key, Map<String,String> params) throws UnrecoverableKeyException, IOException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException, URISyntaxException {
        ResultBean resultBean = new ResultBean();

        //用户账号
        String accountNum = null;
        if(params!=null) {
            accountNum = params.get(Constant.HTTPS_ACCOUNTNUM);
            if(accountNum==null){
                resultBean.setFlag(false);
                resultBean.setMessage("accountNum not null!");
                return resultBean;
            }
        }else{
            resultBean.setFlag(false);
            resultBean.setMessage("params not null!");
            return resultBean;
        }
        //时间获取方法
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        String time = sdf.format(new Date());

        JSONObject jsobj1 = new JSONObject();
        JSONObject jsobj2 = new JSONObject();
        jsobj2.put("TraceTimestamp", time);
        jsobj2.put("TraceID",  getTransactionId());
        jsobj2.put("AccountID",accountNum );
        jsobj1.put("Data",jsobj2);
        //获取用户数据
        JSONObject userInfoJson =postUrl(getUserInfoUrl,jsobj1,null);
        //解析返回值
        if(!RESPONSEDESCRIPTION.equals(((JSONObject)userInfoJson.get("Response")).get("ResponseStatus").toString())){
            resultBean.setFlag(false);
            return resultBean;
        }
        JSONObject userInfo = (JSONObject)userInfoJson.get(DATA);
        if(userInfo==null){
            resultBean.setFlag(false);
            return resultBean;
        }

        JSONObject noscObject =null;
        //闪灯鸣笛
        if(key.equals(Constant.HTTPS_HORNLIGHT)){
            JSONObject paramters = getParamters(userInfo,key,params);
            noscObject =  postUrl(flashlightsUrl,paramters,null);
            if(noscObject!=null) {
                String responseCode = (String) ((JSONObject) noscObject.get("Response")).get("ResponseCode");
                if (noscObject != null && RESPONSECODE.equals(responseCode)) {
                    resultBean.setFlag(true);
                    return resultBean;
                }
            }
        }
        //车辆定位 todo
        else if(key.equals(Constant.HTTPS_LOCATEVEHICLE)){
            String latitude = params.get(Constant.HTTPS_LATITUDE);
            String longitude = params.get(Constant.HTTPS_LONGITUDE);
            if(latitude==null||longitude==null){
                resultBean.setFlag(false);
                resultBean.setMessage("latitude or longitude not null!");
                return resultBean;
            }
            JSONObject paramters1 = getParamters(userInfo,key,params);
            JSONObject SOnnoscObject_locate = postUrl(locatevehicleUrl,paramters1,null);
            if(SOnnoscObject_locate!=null&&SOnnoscObject_locate.get("responseDescription")!=null&&((String)SOnnoscObject_locate.get("responseDescription")).indexOf(RESPONSEDESCRIPTION)!=-1) {
                for (int i = 0; i < locateTimes; i++) {
                    try {
                        sleep(locatedurat);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("--------->>"+(i+1)+"次");
                    noscObject = postUrl(locatevehiclefinalreqUrl,paramters1,null);
                    String a = (String)noscObject.get("description");
                    if (noscObject != null&&noscObject.get("description")!=null&&((String)noscObject.get("description")).indexOf(RESPONSEDESCRIPTION)!=-1) {
                        //获取经纬度 todo
                        Map<Object, Object> reuslt = new HashMap<>();
                        reuslt.put(Constant.HTTPS_LATITUDE, noscObject.get(Constant.HTTPS_LATITUDE));
                        reuslt.put(Constant.HTTPS_LONGITUDE, noscObject.get(Constant.HTTPS_LONGITUDE));
                        resultBean.setData(reuslt);
                        resultBean.setFlag(true);
                        return resultBean;
                    }
                }
            }
        }
        //车辆上锁
        else if(key.equals(Constant.HTTPS_LOCK)){
            String pin = params.get(Constant.HTTPS_PIN);
            if(pin==null){
                resultBean.setFlag(false);
                resultBean.setMessage("pin not null!");
                return resultBean;
            }
            JSONObject paramters = getParamters(userInfo,key,params);
            noscObject = postUrl(doorlockunlockurl,paramters,null);
            if(noscObject!=null) {
                String responseCode = (String) ((JSONObject) noscObject.get("Response")).get("ResponseCode");
                if (noscObject != null && RESPONSECODE.equals(responseCode)) {
                    resultBean.setFlag(true);
                    return resultBean;
                }
            }

        }
        //车辆解锁
        else if(key.equals(Constant.HTTPS_UNLOCK)){
            String pin = params.get(Constant.HTTPS_PIN);
            if(pin==null){
                resultBean.setFlag(false);
                resultBean.setMessage("pin not null!");
                return resultBean;
            }
            JSONObject paramters = getParamters(userInfo,key,params);
            noscObject = postUrl(doorlockunlockurl,paramters,null);
            if(noscObject!=null) {
                String responseCode = (String) ((JSONObject) noscObject.get("Response")).get("ResponseCode");
                if (noscObject != null && RESPONSECODE.equals(responseCode)) {
                    resultBean.setFlag(true);
                    return resultBean;
                }
            }

        }
        else if (key.equals(Constant.HTTPS_SENDPOI)){
            String latitude = params.get(Constant.HTTPS_LATITUDE);
            String longitude = params.get(Constant.HTTPS_LONGITUDE);
            String poiName = params.get(Constant.HTTPS_POINAME);
            if(latitude==null ||longitude==null||poiName==null){
                resultBean.setFlag(false);
                resultBean.setMessage("latitude or longitude or poiName not null!");
                return resultBean;
            }
            JSONObject paramters = getParamters(userInfo,key,params);
            noscObject = postUrl(senddestinationUrl,paramters,null);
            if(noscObject!=null&&((String)noscObject.get("responseDescription")).indexOf(RESPONSEDESCRIPTION)!=-1){
                resultBean.setFlag(true);
                return  resultBean;
            }
        }

        resultBean.setFlag(false);
        resultBean.setMessage("error");
        System.out.println("结果:"+resultBean.isFlag());
        return  resultBean;
    }

    /**
     * 获取唯一的TransactionId
     * @return
     */
    public static String getTransactionId() {

        final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        /*2017-10-25;Alex:将random替换成SecureRandom;CR-代码规范-->*/
        SecureRandom rnd = new SecureRandom();
        StringBuilder transactionId = new StringBuilder(15);
        for (int i = 0; i < 15; i++)
            transactionId.append(AB.charAt(rnd.nextInt(AB.length())));
        return "000MBCHINA00000" + transactionId.toString();
    }

    public JSONObject getParamters(JSONObject userInfo,String key,Map<String,String> params){
        JSONObject result = new JSONObject();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        String time = sdf.format(new Date());
        String tcuId = (String) userInfo.get("DeviceID");
        String tcuType = (String) userInfo.get("DeviceType");
        String vin = (String) userInfo.get("VIN");
//        String email = (String)((JSONObject)((JSONArray)((JSONObject) userInfo.get("Emails")).get("Email")).get(0)).get("Address");
        JSONObject emailObject = (JSONObject) userInfo.get("Emails");
        String email = "";
        if(emailObject.size()>0&&((JSONArray)((JSONObject) userInfo.get("Emails")).get("Email")).size()>0){
            email = (String)((JSONObject)((JSONArray)((JSONObject) userInfo.get("Emails")).get("Email")).get(0)).get("Address");
        }
        String accountNum = (String) userInfo.get("AccountID");

        JSONObject jsobjContext = new JSONObject();
        jsobjContext.put("SourceName", Constant.SOURCE_NAME);
        jsobjContext.put("TransactionId", getTransactionId());
        jsobjContext.put("Timestamp", time);
        jsobjContext.put("Organization", Constant.OEM);
        jsobjContext.put("Region", Constant.REGION);
        jsobjContext.put("ApplicationName", Constant.APPLICATION_NAME);
        result.put("context", jsobjContext);
        if(key.equals(Constant.HTTPS_HORNLIGHT)){
            JSONObject jsobjdata = new JSONObject();
            JSONObject jsobjFL = new JSONObject();
            jsobjFL.put("flashTime", Constant.FLASHTIME);
            jsobjFL.put("serviceDuration", Constant.SERVICEDURATION);
            jsobjFL.put("serviceOperationCode", "HonkAndFlash");
            jsobjdata.put("InvokeFlashLightsCommand",jsobjFL);
            jsobjdata.put("AccountId",accountNum);
            jsobjdata.put("EmailId",email);
            jsobjdata.put("TCUID",tcuId);
            jsobjdata.put("VIN",vin);
            result.put("Data",jsobjdata);
        }
        else if(key.equals(Constant.HTTPS_LOCATEVEHICLE)){
            JSONObject jsobj8 = new JSONObject();
            jsobj8.put("timeStamp", time);
            jsobj8.put("organization", Constant.OEM);
            jsobj8.put("region", Constant.REGION);
            jsobj8.put("sourceName", "MAPP");
            jsobj8.put("applicationName", "Connect");
            String latitude = params.get(Constant.HTTPS_LATITUDE);
            String longitude = params.get(Constant.HTTPS_LONGITUDE);
            jsobj8.put("transactionId",getTransactionId());//todo
            jsobj8.put("tcuType", tcuType);
            jsobj8.put("latitude", latitude);
            jsobj8.put("longitude", longitude);
//            jsobj8.put("accountId", accountNum);
            jsobj8.put("tcuId", tcuId);
            return jsobj8;
        }
        else if(key.equals(Constant.HTTPS_LOCK)){
            JSONObject jsobjdata = new JSONObject();
            jsobjdata.put("UserId", email);
            jsobjdata.put("courtesyCallFlag", false);
            jsobjdata.put("doorTypeParam", "Door Lock");
            jsobjdata.put("mode","UNVERIFIED");//唯一的字符串
            jsobjdata.put("tcuType",tcuType);
            jsobjdata.put("timeToUnlock",0);
            jsobjdata.put("tcuId",tcuId);
            jsobjdata.put("AccountId",accountNum);
            jsobjdata.put("vin",vin);
            result.put("Data",jsobjdata);
        }
        else if(key.equals(Constant.HTTPS_UNLOCK)){
            JSONObject jsobjdata = new JSONObject();
            jsobjdata.put("UserId", email);
            jsobjdata.put("courtesyCallFlag", false);
            jsobjdata.put("doorTypeParam", "Door Unlock");
            jsobjdata.put("mode","UNVERIFIED");//唯一的字符串
            jsobjdata.put("tcuType",tcuType);
            jsobjdata.put("timeToUnlock",0);
            jsobjdata.put("tcuId",tcuId);
            jsobjdata.put("AccountId",accountNum);
            jsobjdata.put("vin",vin);
            result.put("Data",jsobjdata);
        }
        else if(key.equals(Constant.HTTPS_SENDPOI)){
            JSONObject jsobj8 = new JSONObject();
            jsobj8.put("timeStamp", time);
            jsobj8.put("organization", Constant.OEM);
            jsobj8.put("region", Constant.REGION);
            jsobj8.put("sourceName", Constant.SOURCE_NAME);
            jsobj8.put("applicationName", Constant.APPLICATION_NAME);
            jsobj8.put("website", Constant.WEBSITE);
            jsobj8.put("accountId", accountNum);
            jsobj8.put("oem", Constant.OEM);
            jsobj8.put("poiAddress", "");
            jsobj8.put("poiCity", "");
            jsobj8.put("poiState", "");
            jsobj8.put("poiZip", "");
            jsobj8.put("poiCountry", "");

            String latitude = params.get(Constant.HTTPS_LATITUDE);
            String longitude = params.get(Constant.HTTPS_LONGITUDE);
            String poiName = params.get(Constant.HTTPS_POINAME);
            jsobj8.put("transactionId", getTransactionId());//todo
            jsobj8.put("uiLanguage", "ENU");//todo
            jsobj8.put("latitude", latitude);
            jsobj8.put("longitude", longitude);
            jsobj8.put("poiName", poiName);
            return jsobj8;
        }

        return result;
    }


    public static void main(String[] args) throws UnrecoverableKeyException, IOException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException, URISyntaxException {
        Map<String,String> params = new HashMap<>();
        params.put(Constant.HTTPS_ACCOUNTNUM,"12345547");
        params.put(Constant.HTTPS_LATITUDE,"40.00288");
        params.put(Constant.HTTPS_LONGITUDE,"116.48836");
        params.put(Constant.HTTPS_PIN,"1234");
        params.put(Constant.HTTPS_POINAME,"hospital");
//        params.put(Constant.HTTPS_POINAME,"hospital");
        //绕过安全验证的方法
        new HttpsURLRequest().NoSecurityPost(Constant.HTTPS_UNLOCK ,params);
    }


    /**
     * 车辆定位发送定位请求
     * @param paramMap 参数
     * @return
     * @throws UnrecoverableKeyException
     * @throws NoSuchAlgorithmException
     * @throws KeyManagementException
     * @throws KeyStoreException
     * @throws URISyntaxException
     * @throws IOException
     */
    public ResultBean postForlocate(Map<String,String> paramMap) throws UnrecoverableKeyException, NoSuchAlgorithmException, KeyManagementException, KeyStoreException, URISyntaxException, IOException {
        ResultBean resultBean = new ResultBean();
        resultBean.setFlag(false);
        //用户账号
        String accountNum = null;
        if(paramMap!=null) {
            accountNum = paramMap.get(Constant.HTTPS_ACCOUNTNUM);
            if(accountNum==null){
                resultBean.setFlag(false);
                resultBean.setMessage("accountNum not null!");
                return resultBean;
            }
        }else{
            resultBean.setFlag(false);
            resultBean.setMessage("params not null!");
            return resultBean;
        }
        //时间获取方法
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        String time = sdf.format(new Date());

        JSONObject jsobj1 = new JSONObject();
        JSONObject jsobj2 = new JSONObject();
        jsobj2.put("TraceTimestamp", time);
        jsobj2.put("TraceID",  getTransactionId());
        jsobj2.put("AccountID",accountNum );
        jsobj1.put("Data",jsobj2);
        //获取用户数据
        JSONObject userInfoJson =postUrl(getUserInfoUrl,jsobj1,null);
        //解析返回值
        if(!RESPONSEDESCRIPTION.equals(((JSONObject)userInfoJson.get("Response")).get("ResponseStatus").toString())){
            resultBean.setFlag(false);
            return resultBean;
        }
        JSONObject userInfo = (JSONObject)userInfoJson.get(DATA);
        if(userInfo==null){
            resultBean.setFlag(false);
            return resultBean;
        }

        String latitude = paramMap.get(Constant.HTTPS_LATITUDE);
        String longitude = paramMap.get(Constant.HTTPS_LONGITUDE);
        if(latitude==null||longitude==null){
            resultBean.setFlag(false);
            resultBean.setMessage("latitude or longitude not null!");
            return resultBean;
        }
        paramMap.put(Constant.HTTPS_TCUID,(String) userInfo.get("DeviceID"));
        paramMap.put(Constant.HTTPS_TCUTYPE,(String) userInfo.get("DeviceType"));
        JSONObject paramters1 = getparamterForLocate(paramMap);
        JSONObject SOnnoscObject_locate = postUrl(locatevehicleUrl,paramters1,null);
        if(SOnnoscObject_locate!=null&&SOnnoscObject_locate.get("responseDescription")!=null&&((String)SOnnoscObject_locate.get("responseDescription")).indexOf(RESPONSEDESCRIPTION)!=-1) {
            resultBean.setData(paramters1);
            resultBean.setFlag(true);
            return resultBean;
        }
        return resultBean;
    }

    /**
     * 获取经纬度
     * @param paramMap
     * @return
     */
    public ResultBean postForlocateFinal(Map<String,String> paramMap) throws UnrecoverableKeyException, NoSuchAlgorithmException, KeyManagementException, KeyStoreException, URISyntaxException, IOException {
        ResultBean resultBean = new ResultBean();
        resultBean.setFlag(false);
        if(paramMap==null||paramMap.get(Constant.HTTPS_LATITUDE)==null
                ||paramMap.get(Constant.HTTPS_LONGITUDE)==null
                ||paramMap.get(Constant.HTTPS_TRANSACTIONID)==null
                ||paramMap.get(Constant.HTTPS_TIMESTAMP)==null
                ||paramMap.get(Constant.HTTPS_TCUTYPE)==null
                ||paramMap.get(Constant.HTTPS_TCUID)==null
                ){
            resultBean.setMessage("paramters not complete!");
            return resultBean;
        }
        JSONObject paramter = getparamterForLocate(paramMap);
        JSONObject noscObject = postUrl(locatevehiclefinalreqUrl,paramter,null);
        if (noscObject != null&&noscObject.get("description")!=null&&((String)noscObject.get("description")).indexOf(RESPONSEDESCRIPTION)!=-1) {
            //获取经纬度
            Map<Object, Object> reuslt = new HashMap<>();
            reuslt.put(Constant.HTTPS_LATITUDE, noscObject.get(Constant.HTTPS_LATITUDE));
            reuslt.put(Constant.HTTPS_LONGITUDE, noscObject.get(Constant.HTTPS_LONGITUDE));
            resultBean.setData(reuslt);
            resultBean.setFlag(true);
            return resultBean;
        }
        return resultBean;
    }


    /**
     * 车辆定位使用的获取参数方法
     * @param paramMap 参数===》1，发送定位请求：经纬度；2：查询返回的经纬度：经纬度+trasaationId+tcuId+tcuType
     * @return
     */
    private JSONObject getparamterForLocate(Map<String,String> paramMap){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        String latitude = paramMap.get(Constant.HTTPS_LATITUDE);
        String longitude = paramMap.get(Constant.HTTPS_LONGITUDE);
        String tcuType = paramMap.get(Constant.HTTPS_TCUTYPE);
        String tcuId = paramMap.get(Constant.HTTPS_TCUID);
        String transactionId = paramMap.get(Constant.HTTPS_TRANSACTIONID)!=null?paramMap.get(Constant.HTTPS_TRANSACTIONID):getTransactionId();
        String time = paramMap.get(Constant.HTTPS_TIMESTAMP)!=null?paramMap.get(Constant.HTTPS_TIMESTAMP):sdf.format(new Date());
        JSONObject jsobj = new JSONObject();
        jsobj.put("timeStamp", time);
        jsobj.put("organization", Constant.OEM);
        jsobj.put("region", Constant.REGION);
        jsobj.put("sourceName", "MAPP");
        jsobj.put("applicationName", "Connect");
        jsobj.put("transactionId",transactionId);//todo
        jsobj.put("tcuType", tcuType);
        jsobj.put("latitude", latitude);
        jsobj.put("longitude", longitude);
        jsobj.put("tcuId", tcuId);
        return jsobj;
    }
}
