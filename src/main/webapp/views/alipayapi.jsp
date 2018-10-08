﻿<%
/* *
 *功能：手机网页支付接入页
 *版本：3.3
 *日期：2012-08-14
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。

 *************************注意*****************
 *如果您在接口集成过程中遇到问题，可以按照下面的途径来解决
 *1、商户服务中心（https://b.alipay.com/support/helperApply.htm?action=consultationApply），提交申请集成协助，我们会有专业的技术工程师主动联系您协助解决
 *2、商户帮助中心（http://help.alipay.com/support/232511-16307/0-16307.htm?sh=Y&info_type=9）
 *3、支付宝论坛（http://club.alipay.com/read-htm-tid-8681712.html）
 *如果不想使用扩展功能请把扩展功能参数赋空值。
 **********************************************
 */
%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.alipay.config.*"%>
<%@ page import="com.alipay.util.*"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="java.util.Map"%>
<%@ page import="java.net.URLDecoder"%>
<%@ page import="com.htichina.common.web.ConfigureInfo" %>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.htichina.web.order.OrderBackingBean" %>
<%@ page import="org.owasp.esapi.ESAPI" %>
<%@ page import="com.htichina.web.PaymentServiceClient" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>支付宝手机网页支付</title>
	</head>
	<%
		Logger logger = Logger.getLogger(OrderBackingBean.class.getName());
		//支付宝网关地址
		String ALIPAY_GATEWAY_NEW = "http://wappaygw.alipay.com/service/rest.htm?";
		PaymentServiceClient client = PaymentServiceClient.getInstance();

		////////////////////////////////////调用授权接口alipay.wap.trade.create.direct获取授权码token//////////////////////////////////////
		
		//返回格式
		String format = "xml";
		//必填，不需要修改
		
		//返回格式
		String v = "2.0";
		//必填，不需要修改
		
		//请求号
		String req_id = UtilDate.getOrderNum();
		//必填，须保证每次请求都是唯一
		
		//req_data详细信息
		
		//服务器异步通知页面路径
		String notify_url = ConfigureInfo.getAlipayNotifyUrl();
		//需http://格式的完整路径，不能加?id=123这类自定义参数

		//页面跳转同步通知页面路径
		String call_back_url = ConfigureInfo.getAlipayCallbackUrl();
		//需http://格式的完整路径，不能加?id=123这类自定义参数，不能写成http://localhost/

		//操作中断返回地址
		String merchant_url = ConfigureInfo.getAlipayPayFailedUrl();
		//用户付款中途退出返回商户的地址。需http://格式的完整路径，不允许加?id=123这类自定义参数

		//商户订单号
		String out_trade_no = new String(request.getParameter("WIDout_trade_no").getBytes("ISO-8859-1"),"UTF-8");
		logger.info("out_trade_no = "+ ESAPI.encoder().encodeForHTML(out_trade_no));
		//商户网站订单系统中唯一订单号，必填
        
		//订单名称
		String subject = new String(request.getParameter("WIDsubject"));
		//String subject = new String(request.getParameter("WIDsubject").getBytes("ISO-8859-1"),"UTF-8");
		
		//必填

		//付款金额
		String total_fee = new String(request.getParameter("WIDtotal_fee").getBytes("ISO-8859-1"),"UTF-8");
		//商品订单号
        String orderNumber = new String(request.getParameter("orderNumber").getBytes("ISO-8859-1"),"UTF-8");
		//couponIds
		String couponIds = new String(request.getParameter("couponIds").getBytes("ISO-8859-1"),"UTF-8");
		String accountNum = new String(request.getParameter("accountNum").getBytes("ISO-8859-1"),"UTF-8");
		//必填
		System.out.println("--------------:"+request.getParameter("WIDsubject"));
		System.out.println("订单名称:"+subject);
		System.out.println("总体费用:"+total_fee);
		System.out.println("商户订单号:"+out_trade_no);
		//请求业务参数详细
		String req_dataToken = "<direct_trade_create_req><notify_url>" + notify_url + "</notify_url><call_back_url>" + call_back_url + "</call_back_url><seller_account_name>" + AlipayConfig.seller_email + "</seller_account_name><out_trade_no>" + out_trade_no + "</out_trade_no><subject>" + subject + "</subject><total_fee>" + total_fee + "</total_fee><merchant_url>" + merchant_url + "</merchant_url></direct_trade_create_req>";
		//必填
		System.out.println(req_dataToken);
		//////////////////////////////////////////////////////////////////////////////////
		
		//把请求参数打包成数组
		Map<String, String> sParaTempToken = new HashMap<String, String>();
		sParaTempToken.put("service", "alipay.wap.trade.create.direct");
		sParaTempToken.put("partner", AlipayConfig.partner);
		sParaTempToken.put("_input_charset", AlipayConfig.input_charset);
		sParaTempToken.put("sec_id", AlipayConfig.sign_type);
		sParaTempToken.put("format", format);
		sParaTempToken.put("v", v);
		sParaTempToken.put("req_id", req_id);
		sParaTempToken.put("req_data", req_dataToken);

		System.out.println("获取授权码token...");
		//修改订单
		boolean parentResult=client.updateParentOrderAmount(orderNumber, total_fee);
        boolean serviceResult= client.updateServiceOrderAmount(orderNumber, total_fee);
        boolean transActionResult= client.updateTransactionPrice(orderNumber, total_fee);
        //修改优惠券使用状态
        String[] couponIdArray=couponIds.split(",");
        for(String s:couponIdArray){
        	boolean couponHistoryResult=client.updateCouponHistory(orderNumber, s, accountNum);
        	logger.info("couponHistoryResult=" + couponHistoryResult);
        }
		//建立请求
		String sHtmlTextToken = AlipaySubmit.buildRequest(ALIPAY_GATEWAY_NEW,"", "",sParaTempToken);
		//URLDECODE返回的信息
		sHtmlTextToken = URLDecoder.decode(sHtmlTextToken,AlipayConfig.input_charset);
		//获取token
		System.out.println("---------------test---------------"+sHtmlTextToken);
		       logger.info("---------------test---------------"+sHtmlTextToken);
		String request_token = AlipaySubmit.getRequestToken(sHtmlTextToken);
		System.out.println("request_token=" + request_token);
		logger.info("toAlipay request_token="+ESAPI.encoder().encodeForHTML(request_token));
		//out.println(request_token);
		
		////////////////////////////////////根据授权码token调用交易接口alipay.wap.auth.authAndExecute//////////////////////////////////////

		System.out.println("根据授权码token调用交易接口...");
		//业务详细
		String req_data = "<auth_and_execute_req><request_token>" + request_token + "</request_token></auth_and_execute_req>";
		//必填
		
		//把请求参数打包成数组
		Map<String, String> sParaTemp = new HashMap<String, String>();
		sParaTemp.put("service", "alipay.wap.auth.authAndExecute");
		sParaTemp.put("partner", AlipayConfig.partner);
		sParaTemp.put("_input_charset", AlipayConfig.input_charset);
		sParaTemp.put("sec_id", AlipayConfig.sign_type);
		sParaTemp.put("format", format);
		sParaTemp.put("v", v);
		sParaTemp.put("req_data", req_data);
		logger.info("toAlipay sParaTemp="+ESAPI.encoder().encodeForHTML(sParaTemp.toString()));
		//建立请求
		String sHtmlText = AlipaySubmit.buildRequest(ALIPAY_GATEWAY_NEW, sParaTemp, "get", "确认");
		out.println(sHtmlText);
	%>
	<body>
	</body>
</html>
