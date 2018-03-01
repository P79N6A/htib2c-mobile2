package com.htichina.web.POC;

import com.google.common.base.Strings;
import com.htichina.common.web.Constant;
import com.htichina.web.PaymentServiceClient;
import com.htichina.web.common.FacesUtils;
import com.htichina.web.common.ViewPage;
import com.tencent.service.HttpsURLRequest;

import org.apache.log4j.Logger;
import org.owasp.esapi.ESAPI;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.faces.context.FacesContext;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * The main class for handling the HornLight
 * Created by liuyan on 2017/5/15.
 */
@Component
@Scope("session")
public class LocationBean implements Serializable {
    private static Logger logger = Logger.getLogger(PocBean.class.getName());
    private String flag;
    private String openId;
    // 车辆位置经度
    private String locX;
    // 车辆位置纬度
    private String locY;
    private String mapKey;
    private String locationName;
    // 微信当前位置经度
    private String longitude;
    // 微信当前位置纬度
    private String latitude;
    // tcuType
    private String tcuType;
    // tcuId
    private String tcuId;

    private String accountNum;
    private String pin;
    private String pinFlag;

    private String locXSessionKey = "locX_in_session";
    private String locYSessionKey = "locY_in_session";

    // TransactionId
    private String tId;
    // 时间
    private String tTime;
    /**
     * 检查输密码是否正确
     * param null
     * return String 跳转页面
     */
    public String checkPin(){
        //第一次进来，先清空掉X,Y的坐标
        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().getSessionMap().remove(locXSessionKey);
        context.getExternalContext().getSessionMap().remove(locYSessionKey);

        pinFlag = "F";
        openId = (String) FacesUtils.getManagedBeanInSession(Constant.OPEN_ID);
        if(Strings.isNullOrEmpty(accountNum)){
        	openId = (String) FacesUtils.getManagedBeanInSession(Constant.OPEN_ID);
            accountNum = PaymentServiceClient.getInstance().getActiveAccountByOpenId(openId);
        }
        boolean flag = PaymentServiceClient.getInstance().validateLogin(accountNum, pin, openId, null);
        /*flag = true;*/
        if(flag){
            pinFlag = "T";
        }
        logger.info("pinFlag = "+ ESAPI.encoder().encodeForHTML(pinFlag));
        return ViewPage.LINK2LOCATION;
    }
    /**
     * 根据用户信息发送Location请求第一步
     * param null
     * return String 跳转页面
     */
    public String locationA() throws Exception{

        mapKey = Constant.MAP_KEY;
        locationName = Constant.LOCATION_NAME;
        HttpsURLRequest request = new HttpsURLRequest();
        Map<String,String> param = new HashMap<>();
        param.put(Constant.HTTPS_ACCOUNTNUM,accountNum);
        param.put(Constant.HTTPS_LATITUDE,latitude);
        param.put(Constant.HTTPS_LONGITUDE,longitude);
        ResultBean result = request.postForlocate(param);
        if(result != null){
            if(result.isFlag()){
                tId = (String) result.getData().get(Constant.HTTPS_TRANSACTIONID);
                tTime = (String) result.getData().get(Constant.HTTPS_TIMESTAMP);
                tcuId = (String) result.getData().get(Constant.HTTPS_TCUID);
                tcuType= (String) result.getData().get(Constant.HTTPS_TCUTYPE);
                latitude = (String) result.getData().get(Constant.HTTPS_LATITUDE);
                longitude= (String) result.getData().get(Constant.HTTPS_LONGITUDE);
                flag = "T1";
            }
            else{
                flag = "F";
            }
        }
        else{
            flag = "F";
        }
        return ViewPage.LINK2LOCATION;
    }

    /**
     * 根据用户信息发送Location请求B
     * param null
     * return String 跳转页面
     */
    public String locationB() throws Exception{
        logger.info("in locationBean location");
        flag = "F";
        FacesContext context = FacesContext.getCurrentInstance();
        String locX1 =(String) context.getExternalContext().getSessionMap().get(locXSessionKey);
        String locY1 = (String) context.getExternalContext().getSessionMap().get(locYSessionKey);
        logger.info("locX1 ="+ESAPI.encoder().encodeForHTML(locX1));
        logger.info("locY1 ="+ESAPI.encoder().encodeForHTML(locY1));

        //TODO
        //如果session中存在X.Y的坐标，说明微信自己可能已经二次跳转。如果没有，则继续查找
        if(locX1 !=null && locY1 !=null && !"".equals(locX1) && !"".equals(locY1)){
            locY = locY1;
            locX = locX1;
            logger.info("location not NULL!");
            flag = "T";
            return ViewPage.LINK2LOCATION;
        }else{
            //继续查找
            HttpsURLRequest request = new HttpsURLRequest();
            Map<String,String> param = new HashMap<>();
            param.put(Constant.HTTPS_ACCOUNTNUM,accountNum);
            param.put(Constant.HTTPS_LATITUDE,latitude);
            param.put(Constant.HTTPS_LONGITUDE,longitude);
            logger.info("param ="+ESAPI.encoder().encodeForHTML(param.toString()));
            //TODO
            //此处最好加一个进程守护，超过50秒立刻退出
            ResultBean result = request.NoSecurityPost(Constant.HTTPS_LOCATEVEHICLE,param);
            if(result != null){
                logger.info("result ="+ESAPI.encoder().encodeForHTML(result.toString()));
            }
            if(result != null){
                if(result.isFlag()){
                    String X = (String) result.getData().get(Constant.HTTPS_LATITUDE);
                    String Y = (String) result.getData().get(Constant.HTTPS_LONGITUDE);
                    logger.info("locY = "+ ESAPI.encoder().encodeForHTML(Y));
                    logger.info("locX = "+ESAPI.encoder().encodeForHTML(X));
                    mapKey = Constant.MAP_KEY;
                    locationName = Constant.LOCATION_NAME;
                    //如果查询出来XY坐标，则设置FLAG为T，然后将坐标保存到sessionMap中
                    //如果没有要么返回查询不到，要么微信自动再次刷新
                    if(!"".equals(locX) && !"".equals(locY)){
                        logger.info("result not NULL");
                        flag = "T";
                        logger.info("flag = T ");
                        locY = Y;
                        locX = X;
                        context.getExternalContext().getSessionMap().put(locXSessionKey,X);
                        context.getExternalContext().getSessionMap().put(locYSessionKey,Y);
                    }
                    return ViewPage.LINK2LOCATION;
                }
                else{
                    flag = "F";
                    logger.info("location failed message = "+ESAPI.encoder().encodeForHTML(result.getMessage()));
                    return ViewPage.LINK2LOCATION;
                }

            }


            return ViewPage.LINK2LOCATION;
        }




    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }
    public String getFlag() {
        String temp = flag;
        flag = null;
        return temp;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getLocX() {
        return locX;
    }

    public void setLocX(String locX) {
        this.locX = locX;
    }

    public String getLocY() {
        return locY;
    }

    public void setLocY(String locY) {
        this.locY = locY;
    }

    public String getMapKey() {
        return mapKey;
    }

    public void setMapKey(String mapKey) {
        this.mapKey = mapKey;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getAccountNum() {
        return accountNum;
    }

    public void setAccountNum(String accountNum) {
        this.accountNum = accountNum;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getPinFlag() {
        String temp;
        temp = pinFlag;
        pinFlag = null;
        return temp;
    }

    public void setPinFlag(String pinFlag) {
        this.pinFlag = pinFlag;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String gettId() {
        String temp;
        temp = tId;
        tId = null;
        return temp;
    }

    public void settId(String tId) {
        this.tId = tId;
    }

    public String gettTime() {
        String temp;
        temp = tTime;
        tTime = null;
        return temp;
    }

    public void settTime(String tTime) {
        this.tTime = tTime;
    }

    public String getTcuType() {
        String temp;
        temp = tcuType;
        tcuType = null;
        return temp;
    }

    public void setTcuType(String tcuType) {
        this.tcuType = tcuType;
    }

    public String getTcuId() {
        String temp;
        temp = tcuId;
        tcuId = null;
        return temp;
    }

    public void setTcuId(String tcuId) {
        this.tcuId = tcuId;
    }
}
