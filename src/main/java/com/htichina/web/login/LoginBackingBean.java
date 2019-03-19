package com.htichina.web.login;

import com.google.common.base.Strings;
import com.htichina.common.web.ConfigureInfo;
import com.htichina.common.web.Constant;
import com.htichina.web.LoginFilter;
import com.htichina.web.POC.MobileBean;
import com.htichina.web.PaymentServiceClient;
import com.htichina.web.common.FacesUtils;
import com.htichina.web.common.ViewPage;
import com.htichina.web.luckDraw.LuckDrawBean;
import com.htichina.web.tag.TagBean;
import com.htichina.wsclient.payment.AccountInfoResponse;
import com.htichina.wsclient.payment.LuckyDrawReponse;
import com.htichina.wsclient.payment.WechatUserDataResponse;
import com.tencent.common.RandomStringGenerator;
import com.tencent.service.MobileDeviceRegistrationService;
import com.tencent.service.WechatAccessTokenUtils;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.owasp.esapi.ESAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * The main class for handling the wechat login
 * Created by yiming on 2015/7/7.1
 */
@Component
@Scope("session")
public class LoginBackingBean implements Serializable {
//    @Autowired
    private static Logger logger = Logger.getLogger(LoginBackingBean.class.getName());

    //    private String paymentPlatform;
//    private String openId;
//    private String userInfo;
    private String accountNum;
    private String pin;
    private String openId;

    private String targetPg;

    private AccountInfoResponse accountInfo;

    private String toInvoiceEntry = ViewPage.LINK2ApplyInvoice;

    private String repMessage;
    /* 2017-11-28,Tommy Liu, CR82_Part II, 套餐升级的信息提示 */
    private String myAccountPop;
    private String orderUpgradePage;

    private String aToken;

    // 符合renewDIDI条件Flag;
    private String renewFlag;
    // 符合 firstLoginDIDI条件Flag;
    private String firstLoginFlag;
    // 符合 newFlowDIDI条件Flag
    private String newFollowFlag;
    // new follower 输入手机号
    private String newFollowTel;

    // POC登录时校验短信手机号
    private List<MobileBean> POCMobile = new ArrayList<>();
    // POC短信校验接收手机Token
    private String communicationToken;
    // POC短信发送成功Flag
    private String POCMessageFlag;
    // POC短信验证用户填写的短信
    private String registrationCode;
    //luckyDraw Link
//    private int luckyDrawAmount=0;


    /*2017-10-25;Alex:优化代码，日志安全加密;CR-代码规范*/
    public String login(HttpSession session, String From, String oId, String targetPage) throws IOException {

        FacesContext context = FacesContext.getCurrentInstance();
        logger.info("context ===>"+context);
        if (!(From.indexOf("xhtml") > -1)){
            aToken = From;
        }

        logger.info("loginbackingbean.login From"+ESAPI.encoder().encodeForHTML(From));
        /*try {
            throw new Exception("记录调用位置");
        }catch(Exception e) {
            e.printStackTrace();
        }*/
        dataReset();
        targetPg = targetPage;
        String an = null;
        logger.info("Login bakcing oId ==>"+ESAPI.encoder().encodeForHTML(oId) );
        if(!Strings.isNullOrEmpty(oId)){
           openId=oId;
           logger.info("openId111111111111111111111111 ==>"+ESAPI.encoder().decodeForHTML(openId));
           an = PaymentServiceClient.getInstance().getActiveAccountByOpenId(oId);//根据openid获取账号
           logger.info("Login bakcing an ==>"+ESAPI.encoder().decodeForHTML(an));
        }
        else {
            logger.info("return to login");
            return ViewPage.LINK2Login;
        }
        // this openId has already binded to an account
        if(!Strings.isNullOrEmpty(an)) {
            accountInfo = PaymentServiceClient.getInstance().getCurrentAccountInfo(an);
            logger.info("Login bakcing accountInfo.getAccountNum() ==>"+accountInfo.getAccountNum());
            /*context.getExternalContext().getSessionMap()
                    .put(LoginFilter.CURRENT_USER,accountInfo.getAccountNum());*/
//            luckyDrawAmount = PaymentServiceClient.getInstance().hasLuckyDrawLinkByAccountNum(accountInfo.getAccountNum());
            if(session != null){
                session.putValue(LoginFilter.CURRENT_USER,accountInfo.getAccountNum());
            }
            logger.info("Login bakcing accountInfo ==>"+accountInfo);
            if (!Strings.isNullOrEmpty(openId) && openId.matches(".*[a-zA-z].*")){
                renewFlag = accountInfo.getIsReceiveDidiForRenew();
                firstLoginFlag = accountInfo.getIsReceiveDidiForFirstLogin();
            }
            logger.info("Login bakcing flag ==>");
            /*logger.debug("fullName="+accountInfo.getFullName());*/
            repMessage = null;
            logger.info("Login bakcing targetPage ==>"+ESAPI.encoder().encodeForHTML(targetPage));
            if(ViewPage.LINK2MyAccount2.equals(targetPage)
            		&& (accountInfo.getCurrentCanBeUpgratedPackages()==null || accountInfo.getCurrentCanBeUpgratedPackages().size()==0) ){
            	myAccountPop = "暂无可以升级的套餐";
            }
//            if(ViewPage.LINK2LUCKDRAW.equals(targetPage)){
//                System.out.print("===================================accountNum="+accountInfo.getAccountNum());
//                String flag = luckDrawBean.checkCustemerLuckyDraw(accountInfo.getAccountNum());
//                System.out.print("===================================flag="+flag);
//                if("3".equals(flag)){
//                    return targetPage;
//                }
//                else if("2".equals(flag)){
//                    return ViewPage.LINK2LUCKDRAWPACKAGE;
//                }
//                else if("1".equals(flag)){
//                    return ViewPage.LINK2LUCKDRAWERRER;
//                }
//                else if("4".equals(flag)){
//                    return ViewPage.LINK2LUCKDRAWOVER;
//                }
//                else if("5".equals(flag)){
//                    return ViewPage.LINK2LUCKYDRAWCONTINUE;
//                }
//            }

//            if(ViewPage.LINK2LUCKDRAW.equals(targetPage)) {
//                return "/htib2c-mobile/views/luckyDraw.xhtml?showwxpaytitle=1";
//            }
            return targetPage;

        } else {
            if(ViewPage.LINK2KEY.equals(targetPage)){
                targetPg= ViewPage.LINK2CHECKTEL;
            }
//            if(ViewPage.LINK2LUCKDRAW.equals(targetPage)){
//                return ViewPage.LINK2LUCKDRAWLOGIN;
//            }
            logger.debug(ESAPI.encoder().encodeForHTML(oId) + " haven't active account, redirect to login page");
            logger.info("targetPage========================="+targetPage);
//            if(ViewPage.LINK2LUCKDRAW.equals(targetPage)) {
//                return "/htib2c-mobile/views/accountLogin.xhtml?showwxpaytitle=1";
//            }
            return ViewPage.LINK2Login;
        }

    }
    private void dataReset() {
        logger.debug("in dataReset");
        repMessage = null;
        myAccountPop = null;
        accountNum = null;
        pin = null;
        openId = null;
        targetPg = null;
    }

    public String validateLogin(String targetPage) throws IOException, ParseException {
        PaymentServiceClient client = PaymentServiceClient.getInstance();
        targetPg = targetPage;
//        luckyDrawAmount = PaymentServiceClient.getInstance().hasLuckyDrawLinkByAccountNum(accountNum);

        System.out.println("validateLogin");
        logger.info("loginbean........validateLogin()........targetPage="+targetPage);
        
        FacesContext context = FacesContext.getCurrentInstance();
        logger.info("context ===>"+context);
        openId = (String) FacesUtils.getManagedBeanInSession(Constant.OPEN_ID);
        logger.info("validateLogin openId="+ESAPI.encoder().encodeForHTML(openId));
        if(Strings.isNullOrEmpty(targetPage)){
        	logger.info("loginbean........validateLogin()........targetPage is null");
        }else{
        	logger.info("loginbean........validateLogin()........targetPage is not null, = "+targetPage);
        }

        String userInfo = (String) FacesUtils.getManagedBeanInSession(Constant.WECHAT_USER_INFO);

        accountInfo = client.getCurrentAccountInfo(accountNum);
        logger.info("validateLogin accountNum="+ESAPI.encoder().encodeForHTML(accountNum));
        if(accountInfo != null){
            logger.info("validateLogin accountInfo="+ESAPI.encoder().encodeForHTML(accountInfo.toString()));
        }

        if(Strings.isNullOrEmpty(accountNum) || Strings.isNullOrEmpty(pin)){
            repMessage = "请您输入智能互联客户编号和个人密码后再次尝试";
            context.addMessage(null, new FacesMessage(
                    FacesMessage.SEVERITY_ERROR, "请您输入智能互联客户编号和个人密码后再次尝试", ""));
            return ViewPage.LINK2Login;
        }

        if(accountInfo == null || Strings.isNullOrEmpty(accountInfo.getAccountType())) {
            repMessage = "非常抱歉，根据您输入的智能互联客户编号没有找到您的账户信息，请确认信息后再次尝试。";
            context.addMessage(null, new FacesMessage(
                    FacesMessage.SEVERITY_ERROR, "非常抱歉，根据您输入的智能互联客户编号没有找到您的账户信息，" +
                    "请确认信息后再次尝试。", ""));
            return ViewPage.LINK2Login;
        }

        if(accountInfo.getAccountType().equalsIgnoreCase(Constant.DB_ACCOUNT_TYPE_OEM)) {
            repMessage = "您的账户尚未注册，请按车内【i】按钮注册账户";
            context.addMessage(null, new FacesMessage(
                    FacesMessage.SEVERITY_ERROR, "您的账户尚未注册，请按车内【i】按钮注册账户", ""));
            return ViewPage.LINK2Login;
        }
        if(accountInfo.getAccountStatus().equalsIgnoreCase(Constant.DB_ACCOUNT_STATUS_CLOSED) ||
                accountInfo.getAccountStatus().equalsIgnoreCase(Constant.DB_ACCOUNT_STATUS_DECLINED)
                ) {
            repMessage = "您的账户已注销，请按车内【i】按钮注册新账户。";
            context.addMessage(null, new FacesMessage(
                    FacesMessage.SEVERITY_ERROR, "您的账户已注销，请按车内【i】按钮注册新账户。", ""));
            return ViewPage.LINK2Login;
        }

        if(accountInfo.getAccountStatus().equalsIgnoreCase(Constant.DB_ACCOUNT_STATUS_INACTIVE)) {
            repMessage = "overTime";
            context.addMessage(null, new FacesMessage(
                    FacesMessage.SEVERITY_ERROR, "您的账户已过期。", ""));
            return ViewPage.LINK2Login;
        }

        boolean valid = client.validateLogin(accountNum, pin, openId, userInfo);
        if(valid) {
        	logger.info("put account into session");
            context.getExternalContext().getSessionMap()
                    .put(LoginFilter.CURRENT_USER, accountNum);
            logger.info("openId======================"+openId);
            logger.info("accountNum======================"+accountNum);
            logger.info("pin======================"+pin);
            logger.info("client======================"+client);
            if(targetPage!=null&&!ViewPage.LINK2CHECKTEL.equals(targetPage)){
                boolean flag = client.createWechatUserProfile(accountNum, pin, openId, userInfo,"");//保存绑定信息
                if(flag){
                    logger.info("createWechatUserProfileFlag = true");
                }
            }
            logger.info("validateLogin targetPage"+ESAPI.encoder().encodeForHTML(targetPage));
            WechatUserDataResponse rep = client.getWechatUserDataByAcccountNum(accountNum);
            setTagtoWechatUser(rep,openId);
            logger.info("setTagtoWechatUser done");
            // 更新登陆成功次数
            client.updateLoginTimes(accountNum);
            if (!Strings.isNullOrEmpty(openId) && openId.matches(".*[a-zA-z].*")){
                renewFlag = accountInfo.getIsReceiveDidiForRenew();
                firstLoginFlag = accountInfo.getIsReceiveDidiForFirstLogin();
            }
            if("0".equals(firstLoginFlag)){
                // 设置第一次登陆已领取
                setReceivedDidi("firstLogin",accountNum);
                return ViewPage.Didi_FirstLogin;
            }
            if(Strings.isNullOrEmpty(targetPage)){
                return ViewPage.LINK2MyAccount;
            }
            if(ViewPage.LINK2MyAccount2.contains(targetPage)){
            	logger.info("loginbean........validateLogin()........return to myAccount2.xhtml");
            	return ViewPage.LINK2MyAccount2;
            }
            if(ViewPage.LINK2CHECKTEL.equals(targetPage)){
                logger.info("return to LINK2CHECKTEL");
                POCMobile = MobileDeviceRegistrationService.getDeliveryMethods(accountNum);
                if(POCMobile != null){
                    logger.info("POCMobile ="+ESAPI.encoder().encodeForHTML(POCMobile.toString()));
                }

            }
            if(ViewPage.LINK2UPDATEPHONE.equals(targetPage)) {
            	logger.info("return to LINK2UPDATEPHONE");
                context.getExternalContext().redirect(
                        "/htib2c-mobile/views/updateNewCellPhone.xhtml");
                return null;
            }
            
            if(ViewPage.LINK2VARIFLIGHT.equals(targetPage)) {
                context.getExternalContext().redirect(
                		"/htib2c-mobile/views/variflight.xhtml");
                return null;
            }
            
//            if(ViewPage.LINK2LUCKDRAW1.equals(targetPage)) {
//
//                context.getExternalContext().redirect(
//                        ConfigureInfo.getWechatLuckDraw1());
//                return null;
//            }if(ViewPage.LINK2LUCKDRAW2.equals(targetPage)) {
//                context.getExternalContext().redirect(
//                        ConfigureInfo.getWechatLuckDraw2());
//                return null;
//            }else {
//
//                return targetPage;
//            }
            if(ViewPage.LINK2LUCKDRAW1.equals(targetPage)) {

                context.getExternalContext().redirect(
                        ConfigureInfo.getWechatLuckDraw1());
                return null;
            }if(ViewPage.LINK2LUCKDRAW2.equals(targetPage)) {
                context.getExternalContext().redirect(
                        ConfigureInfo.getWechatLuckDraw2());
                return null;
            }if(ViewPage.LINK2LUCKDRAW3.equals(targetPage)) {
                context.getExternalContext().redirect(
                        ConfigureInfo.getWechatLuckDraw3());
                return null;
            }if(ViewPage.LINK2LUCKDRAW4.equals(targetPage)) {
                context.getExternalContext().redirect(
                        ConfigureInfo.getWechatLuckDraw4());
                return null;
            }else {

                return targetPage;
            }
        } else {
            logger.debug("login information is invalid!");
            repMessage = "用户名和密码输入有误";
            return ViewPage.LINK2Login;
        }
    }
    public void setTagtoWechatUser(WechatUserDataResponse rep,String openId) throws IOException, ParseException {
        logger.info("inSetTagtoWechatUser aToken=="+ESAPI.encoder().encodeForHTML(aToken));
        boolean delTagFlag;
        boolean setTagFlag;
        WebApplicationContext context = null;
        TagBean tagBean = new TagBean();
      //2018-2-28,Tommy,调整微信access_token的获取方式，减少新token的生成以避免不够使用--------begin
//        String wToken = getWManAccessToken();
        String wToken = WechatAccessTokenUtils.getWechatToken();
      //2018-2-28,Tommy,调整微信access_token的获取方式，减少新token的生成以避免不够使用--------end
        String[] tags = tagBean.getTagsByOpenId(wToken,openId);
        if(tags != null){
            logger.info("inSetTagtoWechatUser getTags"+ESAPI.encoder().encodeForHTML(tags.toString()));
        }

        if(tags != null){
            for(int i=0; i < tags.length; i++){
                /*if(tags[i].contains("支持")||tags[i].contains("到期")||tags[i].contains("Class")||tags[i].contains("Maybach")){
                    delTagFlag = tagBean.delTag(tags[i],wToken,openId);
                }*/
                if(tags[i].contains("支持")){
                    delTagFlag = tagBean.delTag("WIFI支持",tags[i],wToken,openId);
                }
                else if(tags[i].contains("到期")){
                    delTagFlag = tagBean.delTag("生命周期",tags[i],wToken,openId);
                }
                else if(tags[i].contains("Class")||tags[i].contains("Maybach")){
                    delTagFlag = tagBean.delTag("车型",tags[i],wToken,openId);
                }
            }
        }
        logger.info("inSetTagtoWechatUser delTags");
        if(rep.getAttrib02() != null && rep.getAttrib02() != ""){
            if("1".equals(rep.getAttrib02())){
                boolean flag = tagBean.setTag("WIFI支持","支持WIFI",wToken,openId);
                if(!flag){setTagFlag = false;}
            }
            else if("0".equals(rep.getAttrib02())){
                boolean flag = tagBean.setTag("WIFI支持","不支持WIFI",wToken,openId);
                if(!flag){setTagFlag = false;}
            }
        }
        if(rep.getEndDt() != null && rep.getEndDt() != ""){
            SimpleDateFormat sdf =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = sdf.parse(rep.getEndDt());
            SimpleDateFormat sdf1 =   new SimpleDateFormat("yyyyMM");
            String str = sdf1.format(date);
            boolean flag = tagBean.setTag("生命周期",str+"到期",wToken,openId);
            if(!flag){setTagFlag = false;}
        }
        if(rep.getModel() != null && rep.getModel() != ""){
            String model = rep.getModel();
            if(model.indexOf("AMG") > -1){
                boolean flag = tagBean.setTag("车型","AMG-Class",wToken,openId);
                model = model.replaceAll("Mercedes-AMG","");
            }
            if(model.indexOf("Maybach") > -1){
                boolean flag = tagBean.setTag("车型","Maybach",wToken,openId);
                model = model.replaceAll("Mercedes-Maybach","");
            }
            String[] strs=model.split("[\\d]");

            int index = strs[0].length();
            String num = model.substring(index);
            model = model.replaceAll(num,"");
            model = model.trim();

            boolean flag = tagBean.setTag("车型",model+"-Class",wToken,openId);
            if(!flag){setTagFlag = false;}
        }
        logger.info("inSetTagtoWechatUser end");
    }


    /**
     * 获取微信AccessToken
     * param null
     * return String 微信AccessToken
     * throws IOException
     */

    @Deprecated
    public String getWManAccessToken() throws IOException{
        String id = ConfigureInfo.getWechatAppid();
        String secret = ConfigureInfo.getWechatAppSecret();
        HttpClient httpclient = new DefaultHttpClient();
        HttpGet httpgets = new HttpGet(
                "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="+id+"&secret="+secret+"");
        HttpResponse response = httpclient.execute(httpgets);
        String jsonStr = EntityUtils.toString(response.getEntity(), "UTF-8");
        jsonStr=jsonStr.replaceAll("\"|\\{|\\}", "");
        int beginIndex = jsonStr.indexOf(":");
        int endIndex = jsonStr.indexOf(",");
        String wToken = jsonStr.substring(beginIndex+1,endIndex);
        return wToken;
    }

    public String logout() {
        logger.info("logout targetPage="+ESAPI.encoder().encodeForHTML(targetPg));
        String openId = (String) FacesUtils.getManagedBeanInSession(Constant.OPEN_ID);
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpSession Session = (HttpSession) fc.getExternalContext().getSession(
                false);
        Session.invalidate();
        if(PaymentServiceClient.getInstance().logoff(openId)) {
            FacesUtils.resetManagedBean(Constant.ACCOUNT_NUM);
            String sToken = RandomStringGenerator.getCSRFToken();
            HttpSession Session1 = (HttpSession) fc.getExternalContext().getSession(true);
            Session1.setAttribute(Constant.CSRFTOKEN,sToken); 
            Session1.setAttribute("openId", openId);
            Session1.setAttribute(Constant.PAYMENT_PLATFORM, Constant.DB_ORDER_PAYMENT_TYPE_WEIXINPAY);
            return ViewPage.LINK2Login;
        } else {
            logger.debug("logoff failed!");
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(
                    FacesMessage.SEVERITY_ERROR, "退出登录时遇到问题", ""));
            repMessage = null;
            return ViewPage.LINK2MyAccount;
        }
    }

    public String checkAccount(HttpServletRequest req) {
        if(Strings.isNullOrEmpty(accountNum)) {
            accountNum = (String) req.getSession().getAttribute(Constant.ACCOUNT_NUM);
        }
        if(Strings.isNullOrEmpty(accountNum)) {
            String openId = (String) req.getSession().getAttribute(Constant.OPEN_ID);
            accountNum = PaymentServiceClient.getInstance().getActiveAccountByOpenId(openId);
        }
        if(Strings.isNullOrEmpty(accountNum)) {
            repMessage = null;
            return ViewPage.LINK2OrderEntry;
        } else {
            req.getSession().setAttribute(Constant.ACCOUNT_NUM, accountNum);
            repMessage = null;
            return ViewPage.LINK2OrderPackage;
        }
    }
    // 跳转到关闭浏览器用页面
    public String closeBrowser() {
        logger.info("to closeBrowser.xhtml");
        return ViewPage.CLOSEBROWSER;
    }
    // 校验newFollow输入手机号是否合法
    public void checkNewFollow(){
        String flag = null;
        if(!Strings.isNullOrEmpty(newFollowTel)){
            flag = PaymentServiceClient.getInstance().isNewFollowReciveDidi(newFollowTel);
            if("1".equals(flag)){
                newFollowFlag = "false";
            }
            else if("0".equals(flag)){
                newFollowFlag = "true";
                setReceivedDidi("newFollow",newFollowTel);
            }
            else{
                newFollowFlag = "wrong";
            }
        }
        else{
            newFollowFlag = "wrong";
        }
    }
    // 设置账号领取过滴滴礼券了
    public void setReceivedDidi(String type,String key){
        String accountKey = key;
        String didiType = null;
        if("renew".equals(type)){
            didiType = "1";
            // 设置跳转
            renewFlag = "OK";
        }
        else if("newFollow".equals(type)){
            didiType = "2";
        }
        else if("firstLogin".equals(type)){
            didiType = "3";
        }
        logger.info("setReceivedDidi accountKey="+ESAPI.encoder().encodeForHTML(accountKey));
        logger.info("setReceivedDidi didiType="+ESAPI.encoder().encodeForHTML(didiType));
        boolean setReceivedDidiFlag = PaymentServiceClient.getInstance().setReceiveDidi(accountKey,didiType);
        if(setReceivedDidiFlag){
            logger.info("setReceivedDidiFlag = true");
        }

    }
    // 向用户选中手机号发送短息
    public void sendMessage(){
        boolean flag = MobileDeviceRegistrationService.registration(accountNum,communicationToken);
        if(flag){
            POCMessageFlag = "sendOk";
        }
        else{
            POCMessageFlag = "sendFaile";
        }
    }
    // 检查用户填写的短信验证码是否正确
    public void checkMessage(){
        boolean flag = MobileDeviceRegistrationService.validateRegistration(accountNum,registrationCode);
        if(flag){
            String userInfo = (String) FacesUtils.getManagedBeanInSession(Constant.WECHAT_USER_INFO);
            boolean cFlag = PaymentServiceClient.getInstance().createWechatUserProfile(accountNum, pin, openId, userInfo,"");
            if(cFlag){
                logger.info("createWechatUserProfileFlag = true");
            }
            POCMessageFlag = "checkOk";

        }
        else{
            POCMessageFlag = "checkFaile";
        }
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

    public AccountInfoResponse getAccountInfo() {
        return accountInfo;
    }

    public void setAccountInfo(AccountInfoResponse accountInfo) {
        this.accountInfo = accountInfo;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getTargetPg() {
        return targetPg;
    }

    public void setTargetPg(String targetPg) {
        this.targetPg = targetPg;
    }

    public void setToInvoiceEntry(String toInvoiceEntry){
        this.toInvoiceEntry = toInvoiceEntry;
    }

    public String getToInvoiceEntry(){
        return toInvoiceEntry;
    }

    public void setRepMessage(String repMessage){
        this.repMessage = repMessage;
    }

    public String getRepMessage(){
        String temp = repMessage;
        repMessage = null;
        return temp;
    }
    
    public String getMyAccountPop() {
    	String temp = myAccountPop;
    	myAccountPop = null;
        return temp;
	}
    
	public void setMyAccountPop(String myAccountPop) {
		this.myAccountPop = myAccountPop;
	}
	
	public String getNewFollowFlag() {
        String temp = newFollowFlag;
        newFollowFlag = null;
        return temp;
    }

    public void setNewFollowFlag(String newFollowFlag) {
        this.newFollowFlag = newFollowFlag;
    }

    public String getFirstLoginFlag() {
        return firstLoginFlag;
    }

    public void setFirstLoginFlag(String firstLoginFlag) {
        this.firstLoginFlag = firstLoginFlag;
    }

    public String getRenewFlag() {
        return renewFlag;
    }

    public void setRenewFlag(String renewFlag) {
        this.renewFlag = renewFlag;
    }

    public String getNewFollowTel() {
        String temp = newFollowTel;
        newFollowTel = null;
        return newFollowTel;
    }

    public void setNewFollowTel(String newFollowTel) {
        this.newFollowTel = newFollowTel;
    }

    public List<MobileBean> getPOCMobile() {
        return POCMobile;
    }

    public void setPOCMobile(List<MobileBean> POCMobile) {
        this.POCMobile = POCMobile;
    }

    public String getCommunicationToken() {
        String temp = communicationToken;
        communicationToken = null;
        return temp;
    }

    public void setCommunicationToken(String communicationToken) {
        this.communicationToken = communicationToken;
    }
    public String getPOCMessageFlag() {
        String temp = POCMessageFlag;
        POCMessageFlag = null;
        return temp;
    }

    public void setPOCMessageFlag(String POCMessageFlag) {
        this.POCMessageFlag = POCMessageFlag;
    }

    public String getRegistrationCode() {
        String temp = registrationCode;
        registrationCode = null;
        return temp;
    }

    public void setRegistrationCode(String registrationCode) {
        this.registrationCode = registrationCode;
    }
	public String getOrderUpgradePage() {
		return orderUpgradePage;
	}
	public void setOrderUpgradePage(String orderUpgradePage) {
		this.orderUpgradePage = orderUpgradePage;
	}

//    public int getLuckyDrawAmount() {
//        return luckyDrawAmount;
//    }
//
//    public void setLuckyDrawAmount(int luckyDrawAmount) {
//        this.luckyDrawAmount = luckyDrawAmount;
//    }
}
