/*
package com.htichina.web.luckDraw;

import com.htichina.common.web.Constant;
import com.htichina.web.POC.PocBean;
import com.htichina.web.PaymentServiceClient;
import com.htichina.web.common.FacesUtils;
import com.htichina.web.common.ViewPage;
import com.htichina.web.login.LoginBackingBean;
import com.htichina.wsclient.payment.LdItem;
import com.htichina.wsclient.payment.LdLtemReponse;
import com.htichina.wsclient.payment.LuckyDrawReponse;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.Serializable;

*/
/**
 *
 * Created by 刘宁 on 2017/5/5.
 *//*

@Component
@Scope("session")
public class LuckDrawBean2 implements Serializable {
    private static Logger logger = Logger.getLogger(PocBean.class.getName());

    PaymentServiceClient client = PaymentServiceClient.getInstance();
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

    */
/**
     * 点击抽奖
     * @return
     *//*

    public String doLuckDraw(){
        luckyDrawNotice=null;
        luckyDrawNoticeType=null;
        ts=null;
        openId = (String) FacesUtils.getManagedBeanInSession(Constant.OPEN_ID);
        accountNum = "10631819";
//        accountNum = client.getActiveAccountByOpenId(openId);
//        accountNum  = (String) FacesUtils.getManagedBeanInSession(Constant.ACCOUNT_NUM);
        paymentPlatform = (String) FacesUtils.getManagedBeanInSession(Constant.PAYMENT_PLATFORM);
        logger.info("openId============================"+openId);
        logger.info("accountNum============================"+accountNum);
        logger.info("paymentPlatform============================"+paymentPlatform);
        //判断是否符合资格
        if(accountNum==null){
            luckyDrawNotice="参与此活动，需要您先登录参与活动的账号，请点击前往";
            luckyDrawNoticeType="1";
            return ViewPage.LINK2LUCKDRAW2;
        }
        String flag= checkCustemerLuckyDraw(accountNum);
        if("2".equals(flag)){
            luckyDrawNotice="您购买的套餐不在活动范围，是否愿意前往购买活动套餐？";
            ts="1";
            return ViewPage.LINK2LUCKDRAW2;
        }
        else if("1".equals(flag)){
            luckyDrawNotice="您暂时不符合参加此次抽奖活动的的资格";
            luckyDrawNoticeType="3";
            return ViewPage.LINK2LUCKDRAW2;
        }
        else if("4".equals(flag)){
            luckyDrawNotice="您的抽奖次数已经使用完毕，感谢您的参与";
            luckyDrawNoticeType="4";
            return ViewPage.LINK2LUCKDRAW2;
        }

        ldLtemReponse = client.doLuckDraw(accountNum,openId,paymentPlatform);
        //总数量
        allAmount = ldLtemReponse.getAllAmount();
        //剩余数量
        num = ldLtemReponse.getLeftAmount();
        //中奖内容
        ldItem = ldLtemReponse.getLdItem();
        if(allAmount==0){
            luckyDrawNoticeType="3";
            return ViewPage.LINK2LUCKDRAW2;
        }
        //中奖了 非最后一次 num ts txt tn
        if (num > 0 && !Constant.ITEM_TYPE_0.equals(ldItem.getSubType())) {
            txt = ldLtemReponse.getLdItem().getName();
            ts = Constant.TX_5;
            checkPrizLevel();
        }
        //中奖了 最后一次 ts txt tn tt1
        if(num==0 && !Constant.ITEM_TYPE_0.equals(ldItem.getSubType())){
            ts = Constant.TX_6;
            txt = ldLtemReponse.getLdItem().getName();
            checkPrizeList();
        }
        //未中奖 非最后一次 num ts
        if (num > 0 && Constant.ITEM_TYPE_0.equals(ldItem.getSubType())) {
            ts = Constant.TX_2;
        }
        //未中奖，最后一次
        if(num==0 && Constant.ITEM_TYPE_0.equals(ldItem.getSubType())){
            boolean prizflag = checkPrizeList();
            //无累积奖品
            if(!prizflag){
                ts = Constant.TX_3;
            }else{
                //有累计奖品 tt1
                ts = Constant.TX_4;
            }
        }
        return null;
    }


    public String checkCustemerLuckyDraw(String accountNum){
        String flag="1";
        LuckyDrawReponse luckyDrawReponse = client.checkCustemerLuckyDraw(accountNum,null);
        flag = luckyDrawReponse.getLuckyDrawFlag();
        return flag;
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

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
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


    public LdItem getLdItem() {
        return ldItem;
    }

    public void setLdItem(LdItem ldItem) {
        this.ldItem = ldItem;
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

    */
/**
     * 判断是否累计中奖，并赋值
     * @return
     *//*

    public boolean checkPrizeList(){
        boolean flag =false;
        if(ldLtemReponse.getPrizeList()!=null&&ldLtemReponse.getPrizeList().size()>0) {
            flag =true;
            int size = ldLtemReponse.getPrizeList().size();
            switch (size){
                case 1:tt1 = ldLtemReponse.getPrizeList().get(0);
                case 2:tt2 = ldLtemReponse.getPrizeList().get(1);
                case 3:tt3 = ldLtemReponse.getPrizeList().get(2);
                case 4:tt4 = ldLtemReponse.getPrizeList().get(3);
            }
        }
        return  flag;
    }
    */
/**
     * 判断当前中奖等级
     * @return
     *//*

    public void checkPrizLevel(){
        String prizeType = ldItem.getSubType();
        switch (prizeType){
            case "5":tn = "1";
            case "6":tn = "2";
            case "7":tn = "3";
            case "8":tn = "4";
        }
    }
}
*/
