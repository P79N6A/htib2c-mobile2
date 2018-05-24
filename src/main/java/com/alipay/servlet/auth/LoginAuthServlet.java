/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.servlet.auth;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.owasp.esapi.ESAPI;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.request.AlipaySystemOauthTokenRequest;
import com.alipay.api.request.AlipayUserUserinfoShareRequest;
import com.alipay.api.response.AlipaySystemOauthTokenResponse;
import com.alipay.api.response.AlipayUserUserinfoShareResponse;
import com.alipay.constants.AlipayServiceEnvConstants;
import com.alipay.factory.AlipayAPIClientFactory;
import com.alipay.util.RequestUtil;
import com.htichina.common.web.Constant;
import com.htichina.web.common.ViewPage;
import com.tencent.common.RandomStringGenerator;

/**
 * 用户信息共享（获取用户信息）
 *
 * @author taixu.zqq
 * @version $Id: LoginAuthServlet.java, v 0.1 2014年7月25日 下午5:13:03 taixu.zqq Exp $
 */
public class LoginAuthServlet extends HttpServlet {

    private static Logger logger = Logger.getLogger(LoginAuthServlet.class.getName());

    /**  */
    private static final long serialVersionUID = -6807693807426739985L;

    /**
     * 业务处理
     * @see HttpServlet#doGet(HttpServletRequest, HttpServletResponse)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
                                                                                  throws ServletException,
                                                                                  IOException {
        //1. 解析请求参数
        Map<String, String> params = RequestUtil.getRequestParams(request);
        //2. 获得authCode
        String authCode = params.get("auth_code");

        String state = params.get("state");
        request.getSession().invalidate();
        request.getSession().setAttribute(Constant.CSRFTOKEN, RandomStringGenerator.getCSRFToken());

        try {
            //3. 利用authCode获得authToken
            AlipaySystemOauthTokenRequest oauthTokenRequest = new AlipaySystemOauthTokenRequest();
            oauthTokenRequest.setCode(authCode);
            oauthTokenRequest.setGrantType(AlipayServiceEnvConstants.GRANT_TYPE);
            AlipayClient alipayClient = AlipayAPIClientFactory.getAlipayClient();
            AlipaySystemOauthTokenResponse oauthTokenResponse = alipayClient
                .execute(oauthTokenRequest);

            //成功获得authToken
            if (null != oauthTokenResponse && oauthTokenResponse.isSuccess()) {



                //4. 利用authToken获取用户信息
                AlipayUserUserinfoShareRequest userinfoShareRequest = new AlipayUserUserinfoShareRequest();
                AlipayUserUserinfoShareResponse userinfoShareResponse = alipayClient.execute(
                    userinfoShareRequest, oauthTokenResponse.getAccessToken());

                //成功获得用户信息
                if (null != userinfoShareResponse && userinfoShareResponse.isSuccess()) {
                    //这里仅是简单打印， 请开发者按实际情况自行进行处理
//                    System.out.println("获取用户信息成功：" + userinfoShareResponse.getBody());
                    logger.info("获取用户信息成功：" + ESAPI.encoder().encodeForHTML(userinfoShareResponse.getBody()));

                } else {
                    //这里仅是简单打印， 请开发者按实际情况自行进行处理
//                    System.out.println("获取用户信息失败");
                    logger.error("获取用户信息失败");

                }
                logger.info("淘宝用户ID:" + ESAPI.encoder().encodeForHTML(oauthTokenResponse.getAlipayUserId()));
                request.getSession().setAttribute(Constant.OPEN_ID, oauthTokenResponse.getAlipayUserId());
                request.getSession().setAttribute(Constant.PAYMENT_PLATFORM, Constant.DB_ORDER_PAYMENT_TYPE_ALIPAY);
//                System.out.println("payment platform: " + Constant.DB_ORDER_PAYMENT_TYPE_ALIPAY);
                logger.info("payment platform: " + ESAPI.encoder().encodeForHTML(Constant.DB_ORDER_PAYMENT_TYPE_ALIPAY));

                if(state.equalsIgnoreCase(Constant.WECHAT_STATE_ORDER)) {
                    request.getRequestDispatcher(ViewPage.LINK2OrderEntry).forward(request, response);
                } else if(state.equalsIgnoreCase(Constant.WECHAT_STATE_PROMOTION)){
                    request.getRequestDispatcher(ViewPage.LINK2Promotion).forward(request, response);
                } else if(state.equalsIgnoreCase(Constant.ALIPAY_STATE_PROMOTION)){
                    request.getRequestDispatcher(ViewPage.LINK2AlipayPromotion).forward(request, response);
                }  else if(state.equalsIgnoreCase(Constant.WECHAT_STATE_LOGIN)){
                    logger.debug("LoginAuthServlet start login");
                    request.getRequestDispatcher(ViewPage.LINK2Login).forward(request, response);
                }  else if(state.equalsIgnoreCase(Constant.WECHAT_STATE_APPLY_INVOICE)){
                    request.getRequestDispatcher(ViewPage.LINK2ApplyInvoice).forward(request, response);
                }
                /* 2017-11-10,Tommy Liu, CR82_Part II, 增加 套餐升级 菜单 */
                else if(state.equalsIgnoreCase(Constant.WECHAT_STATE_UPGRADE)){
        			logger.info("1231233412334123412334LoginAuthServlet start startUpgradeOrder");
        			request.setAttribute("orderUpgradePage", ViewPage.LINK2MyAccount2);
        			request.getRequestDispatcher(ViewPage.LINK2Login).forward(request, response);
//        			request.getRequestDispatcher(ViewPage.LINK2MyAccount2).forward(request, response);
        		}
                else if(state.equalsIgnoreCase(Constant.WECHAT_LUCKYDRAW)){
//				req.getRequestDispatcher(loginBackingBean.login(req.getSession(), accessToken,oId,ViewPage.LINK2LUCKDRAW)).redirect(req, resp);
//				logger.info("======================"+loginBackingBean.login(req.getSession(), accessToken,oId,ViewPage.LINK2LUCKDRAW));
//				LoginBackingBean loginBackingBean = new LoginBackingBean();
                    response.sendRedirect("/htib2c-mobile/views/luckyDraw2.xhtml?showwxpaytitle=1");
                }


            } else {
                //这里仅是简单打印， 请开发者按实际情况自行进行处理
//                System.out.println("authCode换取authToken失败");
                logger.error("authCode换取authToken失败");
            }
        } catch (AlipayApiException alipayApiException) {
            //自行处理异常
            alipayApiException.printStackTrace();
        }
    }

}
