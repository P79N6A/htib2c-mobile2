package com.htichina.web.luckDraw;

import com.htichina.wsclient.payment.LdItem;
import com.htichina.wsclient.payment.LdLtemReponse;

/**
 * Created by 刘宁 on 2018/5/24.
 */
public class resultBean {
    private int allAmount;
    private int num;//不计本次的剩余次数
    private String openId;
    private LdItem ldItem;//当前中奖奖品
    private String accountNum;
    private String paymentPlatform;
    private LdLtemReponse ldLtemReponse;
    private String luckyDrawNotice;
    private String luckyDrawNoticeType;
    private String ts;
    private String tn;//奖品等级
    private String txt;//本次奖品名称
    private String tt1;//总计奖品列表第1项;
    private String tt2;//总计奖品列表第2项;
    private String tt3;//总计奖品列表第3项;
    private String tt4;//总计奖品列表第4项;

    public int getAllAmount() {
        return allAmount;
    }

    public void setAllAmount(int allAmount) {
        this.allAmount = allAmount;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public LdItem getLdItem() {
        return ldItem;
    }

    public void setLdItem(LdItem ldItem) {
        this.ldItem = ldItem;
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

    public String getLuckyDrawNotice() {
        return luckyDrawNotice;
    }

    public void setLuckyDrawNotice(String luckyDrawNotice) {
        this.luckyDrawNotice = luckyDrawNotice;
    }

    public String getLuckyDrawNoticeType() {
        return luckyDrawNoticeType;
    }

    public void setLuckyDrawNoticeType(String luckyDrawNoticeType) {
        this.luckyDrawNoticeType = luckyDrawNoticeType;
    }

    public String getTs() {
        return ts;
    }

    public void setTs(String ts) {
        this.ts = ts;
    }

    public String getTn() {
        return tn;
    }

    public void setTn(String tn) {
        this.tn = tn;
    }

    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }

    public String getTt1() {
        return tt1;
    }

    public void setTt1(String tt1) {
        this.tt1 = tt1;
    }

    public String getTt2() {
        return tt2;
    }

    public void setTt2(String tt2) {
        this.tt2 = tt2;
    }

    public String getTt3() {
        return tt3;
    }

    public void setTt3(String tt3) {
        this.tt3 = tt3;
    }

    public String getTt4() {
        return tt4;
    }

    public void setTt4(String tt4) {
        this.tt4 = tt4;
    }
}
