package com.htichina.web.wechat;

import com.alibaba.fastjson.JSONArray;
import com.alipay.util.UtilDate;
import com.google.gson.Gson;
import com.htichina.common.web.Constant;
import com.htichina.web.PaymentServiceClient;
import com.htichina.web.common.FacesUtils;
import com.htichina.web.common.ViewPage;
import com.htichina.web.luckDraw.resultBean;
import com.htichina.wsclient.payment.LdItem;
import com.htichina.wsclient.payment.LdLtemReponse;
import com.htichina.wsclient.payment.LuckyDrawReponse;
import com.htichina.wsclient.payment.QuestionAnswer;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.owasp.esapi.ESAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ln on 2018/05/24.
 */
@Component("LuckyDraw2Servlet")
public class LuckyDraw2Servlet extends HttpServlet {
    private static Logger logger = Logger.getLogger(LuckyDraw2Servlet.class.getName());


    @Autowired(required = true)
    WebApplicationContext context;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String openId = (String) req.getSession().getAttribute(Constant.OPEN_ID);
        logger.debug("openId------" + openId);
        resultBean resultBean = doLuckDraw(req);
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out;
        out = resp.getWriter();
        Gson gson = new Gson();
        String str = gson.toJson(resultBean);
        logger.info("locate result = " + str);
        out.write(str);
        out.flush();
        out.close();
    }

    /**
     * 点击抽奖
     *
     * @return
     */
    public resultBean doLuckDraw(HttpServletRequest req) {
        PaymentServiceClient client = PaymentServiceClient.getInstance();
        resultBean resultBean = new resultBean();
        String openId = (String) req.getSession().getAttribute(Constant.OPEN_ID);
//		String accountNum = "10631821";
        String accountNum = client.getActiveAccountByOpenId(openId);
        String paymentPlatform = (String) req.getSession().getAttribute(Constant.PAYMENT_PLATFORM);
//		logger.info("openId============================"+openId);
        logger.info("accountNum============================" + accountNum);
        logger.info("paymentPlatform============================" + paymentPlatform);
        //判断是否符合资格
        if (accountNum == null) {
            resultBean.setLuckyDrawNotice("参与此活动，需要您先登录参与活动的账号，请点击前往");
            resultBean.setLuckyDrawNoticeType("1");
            return resultBean;
        }
        String type = req.getParameter("type");
        if ("1".equals(type)) {
            LuckyDrawReponse luckyDrawReponse = client.checkCustemerLuckyDraw(accountNum, null);
            String flag = luckyDrawReponse.getLuckyDrawFlag();
            if (flag != null) {
                if ("2".equals(flag)) {
                    resultBean.setLuckyDrawNotice("您购买的套餐不在活动范围，是否愿意前往购买活动套餐？");
                    resultBean.setLuckyDrawNoticeType("2");
                    resultBean.setTs("1");
                    return resultBean;
                } else if ("1".equals(flag)) {
                    resultBean.setLuckyDrawNotice("您暂时不符合参加此次抽奖活动的的资格");
                    resultBean.setLuckyDrawNoticeType("3");
                    return resultBean;
                } else if ("4".equals(flag)) {
                    resultBean.setLuckyDrawNotice("您的抽奖次数已经使用完毕，感谢您的参与");
                    resultBean.setLuckyDrawNoticeType("4");
                    return resultBean;
                }
                //再进入状态
                //本次无奖 总计有奖
                else if ("6".equals(flag)) {
                    boolean prizflag = checkPrizeList(luckyDrawReponse.getPrizeList(), resultBean);
                    resultBean.setLuckyDrawNoticeType("6");
                    resultBean.setTs(Constant.TX_4);
                    return resultBean;
                }
                //本次没中奖，总计无奖
                else if ("7".equals(flag)) {
                    boolean prizflag = checkPrizeList(luckyDrawReponse.getPrizeList(), resultBean);
                    resultBean.setLuckyDrawNoticeType("7");
                    resultBean.setTs(Constant.TX_3);
                    return resultBean;
                }
                //中奖了 最后一次
                else if ("8".equals(flag)) {
                    boolean prizflag = checkPrizeList(luckyDrawReponse.getPrizeList(), resultBean);
                    resultBean.setLuckyDrawNoticeType("8");
                    resultBean.setTs(Constant.TX_6);
                    resultBean.setTxt(luckyDrawReponse.getPrizeList().get(0));
                    LdItem ldItem = new LdItem();
                    ldItem.setSubType(luckyDrawReponse.getPrizeList().get(0));
                    checkPrizLevel(ldItem, resultBean);
                    return resultBean;
                }
            }else {
                resultBean.setLuckyDrawNotice("您暂时不符合参加此次抽奖活动的的资格");
                resultBean.setLuckyDrawNoticeType("3");
            }
            return resultBean;
        }

        LdLtemReponse ldLtemReponse = client.doLuckDraw(accountNum, openId, paymentPlatform);
        //总数量
        resultBean.setAllAmount(ldLtemReponse.getAllAmount());
        //剩余数量
        resultBean.setNum(ldLtemReponse.getLeftAmount());
        //中奖内容
        resultBean.setLdItem(ldLtemReponse.getLdItem());
        int allAmount = resultBean.getAllAmount();
        int num = resultBean.getNum();
        LdItem ldItem = ldLtemReponse.getLdItem();
        if (allAmount == 0) {
            resultBean.setLuckyDrawNoticeType("3");
            return resultBean;
        }
        //中奖了 非最后一次 num ts txt tn
        if (num > 0 && !Constant.ITEM_TYPE_0.equals(ldItem.getSubType())) {
            resultBean.setTxt(ldLtemReponse.getLdItem().getName());
            resultBean.setTs(Constant.TX_5);
            checkPrizLevel(ldItem, resultBean);
        }
        //中奖了 最后一次 ts txt tn tt1
        if (num == 0 && !Constant.ITEM_TYPE_0.equals(ldItem.getSubType())) {
            resultBean.setTs(Constant.TX_6);
            resultBean.setTxt(ldLtemReponse.getLdItem().getName());
            checkPrizeList(ldLtemReponse.getPrizeList(), resultBean);
            checkPrizLevel(ldItem, resultBean);
        }
        //未中奖 非最后一次 num ts
        if (num > 0 && Constant.ITEM_TYPE_0.equals(ldItem.getSubType())) {
            resultBean.setTs(Constant.TX_2);
        }
        //未中奖，最后一次
        if (num == 0 && Constant.ITEM_TYPE_0.equals(ldItem.getSubType())) {
            boolean prizflag = checkPrizeList(ldLtemReponse.getPrizeList(), resultBean);
            //无累积奖品
            if (!prizflag) {
//				ts = Constant.TX_3;
                resultBean.setTs(Constant.TX_3);
            } else {
                //有累计奖品 tt1
//				ts = Constant.TX_4;
                resultBean.setTs(Constant.TX_4);
            }
        }
        return resultBean;
    }

    public String checkCustemerLuckyDraw(String accountNum, PaymentServiceClient client) {
        String flag = "1";
        LuckyDrawReponse luckyDrawReponse = client.checkCustemerLuckyDraw(accountNum, null);
        flag = luckyDrawReponse.getLuckyDrawFlag();
        return flag;
    }

    /**
     * 判断是否累计中奖，并赋值
     *
     * @return
     */
    public boolean checkPrizeList(List<String> resultList, resultBean resultBean) {
        boolean flag = false;
        List<String> list = new ArrayList<String>();
        Map<String, Integer> result = new HashMap<String, Integer>();
        if (resultList != null && resultList.size() > 0) {
            for (String a : resultList) {
                if (result.containsKey(a)) {
                    result.put(a, result.get(a) + 1);
                } else {
                    result.put(a, 1);
                }
            }
            flag = true;
            for (Map.Entry<String, Integer> entry : result.entrySet()) {
                list.add(entry.getKey() + "*" + entry.getValue());
            }
            int size = list.size();
            switch (size) {
                case 1:
                    resultBean.setTt1(list.get(0));
                    break;
                case 2:
                    resultBean.setTt1(list.get(0));
                    resultBean.setTt2(list.get(1));
                    break;
                case 3:
                    resultBean.setTt1(list.get(0));
                    resultBean.setTt2(list.get(1));
                    resultBean.setTt3(list.get(2));
                    break;
                case 4:
                    resultBean.setTt1(list.get(0));
                    resultBean.setTt2(list.get(1));
                    resultBean.setTt3(list.get(2));
                    resultBean.setTt4(list.get(3));
                    break;
            }
        }
        return flag;
    }

    /**
     * 判断当前中奖等级
     *
     * @return
     */
    public void checkPrizLevel(LdItem ldItem, resultBean resultBean) {
        String prizeType = ldItem.getSubType();
        switch (prizeType) {
            case "9":
                resultBean.setTn("3");
                break;
            case "10":
                resultBean.setTn("2");
                break;
            case "11":
                resultBean.setTn("1");
                break;
//			case "8":resultBean.setTn("4");break;

        }
    }
}
