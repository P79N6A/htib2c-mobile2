package com.htichina.web.luckDraw;

import com.htichina.common.web.Constant;
import com.htichina.web.POC.PocBean;
import com.htichina.web.PaymentServiceClient;
import com.htichina.web.common.FacesUtils;
import com.htichina.wsclient.payment.LdLtemReponse;
import com.htichina.wsclient.payment.LuckyDrawData;
import com.htichina.wsclient.payment.LuckyDrawReponse;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

/**
 * The main class for handling the Lock
 * Created by 刘宁 on 2017/5/5.
 */
@Component
@Scope("session")
public class LuckDrawBean implements Serializable {
    private static Logger logger = Logger.getLogger(PocBean.class.getName());

    PaymentServiceClient client = PaymentServiceClient.getInstance();
    private String itemName;
    private int allAmount;
    private int leftAmount;
    private String openId;
    private String prize;
    private String accountNum;
    private String paymentPlatform;
    private LdLtemReponse ldLtemReponse;
    private List<LuckyDrawData> dataMessage;


    /**
     * 点击抽奖
     * @return
     */
    public boolean doLuckDraw(){
        boolean flag =true;
        openId = (String) FacesUtils.getManagedBeanInSession(Constant.OPEN_ID);
        accountNum  = (String) FacesUtils.getManagedBeanInSession(Constant.ACCOUNT_NUM);
        paymentPlatform = (String) FacesUtils.getManagedBeanInSession(Constant.PAYMENT_PLATFORM);
        ldLtemReponse = client.doLuckDraw(accountNum,openId,paymentPlatform);
        //总数量
        allAmount = ldLtemReponse.getAllAmount();
        //剩余数量
        leftAmount = ldLtemReponse.getLeftAmount();
        prize = ldLtemReponse.getPrize();
        dataMessage = ldLtemReponse.getLuckyDrawDataList();
        return  flag;

    }

    public boolean checkCustemerLuckyDraw(String accountNum){
        boolean flag;
        LuckyDrawReponse luckyDrawReponse = client.checkCustemerLuckyDraw(accountNum);
        flag = luckyDrawReponse.isSuccess();
        if(flag){
            allAmount = luckyDrawReponse.getAllAmount();
            leftAmount = luckyDrawReponse.getLeftAmount();
        }
        dataMessage = luckyDrawReponse.getDataMessage();
        return flag;
    }


    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
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

    public String getPrize() {
        return prize;
    }

    public void setPrize(String prize) {
        this.prize = prize;
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
}
