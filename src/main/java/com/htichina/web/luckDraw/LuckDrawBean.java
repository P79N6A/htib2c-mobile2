package com.htichina.web.luckDraw;

import com.htichina.common.web.Constant;
import com.htichina.web.POC.PocBean;
import com.htichina.web.PaymentServiceClient;
import com.htichina.web.common.FacesUtils;
import com.htichina.web.common.ViewPage;
import com.htichina.wsclient.payment.LdItem;
import com.htichina.wsclient.payment.LdLtemReponse;
import com.htichina.wsclient.payment.LuckyDrawReponse;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * The main class for handling the Lock
 * Created by 刘宁 on 2017/5/5.
 */
@Component
@Scope("session")
public class LuckDrawBean implements Serializable {
    private static Logger logger = Logger.getLogger(PocBean.class.getName());

    PaymentServiceClient client = PaymentServiceClient.getInstance();
    private int allAmount;
    private int leftAmount;
    private String openId;
    private String userLuckyDrawFlag;
    private int baseSize;
    private int wifiSize;
    private int otherSize;
    private LdItem ldItem;
    private String accountNum;
    private String paymentPlatform;
    private LdLtemReponse ldLtemReponse;

    private String flag;

    /**
     * 点击抽奖
     * @return
     */
    public void doLuckDraw(){
        openId = (String) FacesUtils.getManagedBeanInSession(Constant.OPEN_ID);
        accountNum  = (String) FacesUtils.getManagedBeanInSession(Constant.ACCOUNT_NUM);
        accountNum  = "10579675";
        paymentPlatform = (String) FacesUtils.getManagedBeanInSession(Constant.PAYMENT_PLATFORM);
        paymentPlatform="11111111";
        ldLtemReponse = client.doLuckDraw(accountNum,openId,paymentPlatform);
//        ldLtemReponse = new LdLtemReponse();
//        ldLtemReponse.setAllAmount(3);
//        ldLtemReponse.setLeftAmount(1);
//        ldLtemReponse.setPrize("一等奖品");
//        List<LuckyDrawData> luckyDrawDataList = new ArrayList<LuckyDrawData>();
//            LuckyDrawData luckyDrawData1 = new LuckyDrawData();
//            luckyDrawData1.setItemName("一等奖");
//            LuckyDrawData luckyDrawData2 = new LuckyDrawData();
//            luckyDrawData2.setItemName("二等奖");
//        luckyDrawDataList.add(luckyDrawData1);
//        luckyDrawDataList.add(luckyDrawData2);
        //总数量
        allAmount = ldLtemReponse.getAllAmount();
        //剩余数量
        leftAmount = ldLtemReponse.getLeftAmount();
        //中奖内容
        ldItem = ldLtemReponse.getLdItem();
        //中奖了 还有次数
        if(leftAmount>0 && !Constant.ITEM_TYPE_0.equals(ldItem.getSubType())){
            userLuckyDrawFlag = Constant.USERLUCKYDRAWFLAG_1;
            if(Constant.ITEM_TYPE_1.equals(ldItem.getSubType())) {
                baseSize = Integer.valueOf(ldItem.getAmount());
            }
            if(Constant.ITEM_TYPE_2.equals(ldItem.getSubType())) {
                wifiSize = Integer.valueOf(ldItem.getAmount());
            }else {
                otherSize = Integer.valueOf(ldItem.getAmount());
            }
        }
        //有剩余次数没中奖
        if(leftAmount>0 && Constant.ITEM_TYPE_0.equals(ldItem.getSubType())){
            userLuckyDrawFlag = Constant.USERLUCKYDRAWFLAG_3;
        }
        //无剩余次数中奖
        if(leftAmount==0 && !Constant.ITEM_TYPE_0.equals(ldItem.getSubType())){
            userLuckyDrawFlag = Constant.USERLUCKYDRAWFLAG_2;
            if(Constant.ITEM_TYPE_1.equals(ldItem.getSubType())) {
                baseSize = ldLtemReponse.getBasePrizeSize();
            }
            if(Constant.ITEM_TYPE_2.equals(ldItem.getSubType())) {
                wifiSize = ldLtemReponse.getWifiPrizeSize();
            }else {
                otherSize = ldLtemReponse.getOtherPrizeSize();
            }
        }
        //无剩余次数没中奖
        if(leftAmount==0 && Constant.ITEM_TYPE_0.equals(ldItem.getSubType())){
            userLuckyDrawFlag = Constant.USERLUCKYDRAWFLAG_4;;
        }

        flag = "1";
    }


    public String checkCustemerLuckyDraw(String accountNum){
        String flag="1";
        LuckyDrawReponse luckyDrawReponse = client.checkCustemerLuckyDraw(accountNum);
//        LuckyDrawReponse luckyDrawReponse  =new LuckyDrawReponse();
//        luckyDrawReponse.setAllAmount(3);
//        luckyDrawReponse.setLeftAmount(2);
//        luckyDrawReponse.setLuckyDrawFlag("3");
        flag = luckyDrawReponse.getLuckyDrawFlag();
        if(flag=="3"){
            allAmount = luckyDrawReponse.getAllAmount();
            leftAmount = luckyDrawReponse.getLeftAmount();
        }
        return flag;
    }

    /**
     * 跳转到登陆页面
     * @return
     */
    public String turnLogin() {
        return ViewPage.LINK2Login;
    }

    /**
     * 跳转到下单页面
     * @return
     */
    public String turnPackage() {
        return ViewPage.LINK2OrderEntry;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }


    public int getAllAmount() {
        return allAmount;
    }

    public void setAllAmount(int allAmount) {
        this.allAmount = allAmount;
    }

    public int getLeftAmount() {
        return leftAmount;
    }

    public void setLeftAmount(int leftAmount) {
        this.leftAmount = leftAmount;
    }



    public String getAccountNum() {
        return accountNum;
    }

    public void setAccountNum(String accountNum) {
        this.accountNum = accountNum;
    }

    public String getPaymentPlatform() {
        return paymentPlatform;
    }

    public void setPaymentPlatform(String paymentPlatform) {
        this.paymentPlatform = paymentPlatform;
    }

    public LdLtemReponse getLdLtemReponse() {
        return ldLtemReponse;
    }

    public void setLdLtemReponse(LdLtemReponse ldLtemReponse) {
        this.ldLtemReponse = ldLtemReponse;
    }

    public String getUserLuckyDrawFlag() {
        return userLuckyDrawFlag;
    }

    public void setUserLuckyDrawFlag(String userLuckyDrawFlag) {
        this.userLuckyDrawFlag = userLuckyDrawFlag;
    }

    public int getBaseSize() {
        return baseSize;
    }

    public void setBaseSize(int baseSize) {
        this.baseSize = baseSize;
    }

    public int getWifiSize() {
        return wifiSize;
    }

    public void setWifiSize(int wifiSize) {
        this.wifiSize = wifiSize;
    }

    public int getOtherSize() {
        return otherSize;
    }

    public void setOtherSize(int otherSize) {
        this.otherSize = otherSize;
    }

    public LdItem getLdItem() {
        return ldItem;
    }

    public void setLdItem(LdItem ldItem) {
        this.ldItem = ldItem;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }
}
