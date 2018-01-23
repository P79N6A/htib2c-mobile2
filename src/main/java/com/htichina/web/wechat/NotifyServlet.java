package com.htichina.web.wechat;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import org.owasp.esapi.ESAPI;
import org.xml.sax.InputSource;

import com.google.common.base.Strings;
import com.htichina.common.web.ConfigureInfo;
import com.htichina.web.PaymentServiceClient;
import com.htichina.web.common.ViewPage;
import com.htichina.wsclient.payment.PaymentResponse;
import com.htichina.wsclient.payment.PaymentResultMessage;
import com.htichina.wsclient.payment.QueryChildOrdersByParentOrderNumResponse;
import com.tencent.common.RequestHandler;
import com.tencent.service.HttpsURLRequest;

public class NotifyServlet extends HttpServlet {
	private static Logger logger = Logger.getLogger(NotifyServlet.class.getName());

	String order = "";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		this.doPost(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest request,
						  HttpServletResponse response) throws ServletException, IOException {

		request.setAttribute("order", order);
		request.getRequestDispatcher(ViewPage.LINK2OrderSuccess).forward(request,
				response);
		if(request.getContentLength()!=-1){
		logger.info("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
			String inputLine;
			String notifyXml = "";
			String resXml = "";

			try {
				while ((inputLine = request.getReader().readLine()) != null) {
					notifyXml += inputLine;
				}
				request.getReader().close();
			} catch (Exception e) {
				e.printStackTrace();
			}

//			System.out.println("Notify: " + notifyXml);
			logger.info("notifyXml-------------------"+notifyXml);
			if(!StringUtils.isEmpty(notifyXml)){
				SortedMap<String, String> m = parseXmlToList2(notifyXml);
				WxPayResult wpr = new WxPayResult();
				wpr.setSign(m.get("sign").toString());
				wpr.setOutTradeNo(m.get("out_trade_no").toString());
				m.put("sign", "");
				PaymentServiceClient client = PaymentServiceClient.getInstance();
				String neworder = "";
				logger.info("wpr.getOutTradeNo()=============================="+wpr.getOutTradeNo());
				if(wpr.getOutTradeNo().length()>13){
					neworder = wpr.getOutTradeNo().substring(0, 13);
				}
				logger.info("order======================>"+order);
				logger.info("neworder======================>"+neworder);
				logger.info("client.CheckTransaction(neworder)======================================>"+client.CheckTransaction(neworder));
				if (!order.equals(neworder)&&(!client.CheckTransaction(neworder))) {

//			System.out.println("in NotifyServlet");
					logger.info("in NotifyServlet");

					// String xml =
					// "<xml><appid><![CDATA[wxb4dc385f953b356e]]></appid><bank_type><![CDATA[CCB_CREDIT]]></bank_type><cash_fee><![CDATA[1]]></cash_fee><fee_type><![CDATA[CNY]]></fee_type><is_subscribe><![CDATA[Y]]></is_subscribe><mch_id><![CDATA[1228442802]]></mch_id><nonce_str><![CDATA[1002477130]]></nonce_str><openid><![CDATA[o-HREuJzRr3moMvv990VdfnQ8x4k]]></openid><out_trade_no><![CDATA[1000000000051249]]></out_trade_no><result_code><![CDATA[SUCCESS]]></result_code><return_code><![CDATA[SUCCESS]]></return_code><sign><![CDATA[1269E03E43F2B8C388A414EDAE185CEE]]></sign><time_end><![CDATA[20150324100405]]></time_end><total_fee>1</total_fee><trade_type><![CDATA[JSAPI]]></trade_type><transaction_id><![CDATA[1009530574201503240036299496]]></transaction_id></xml>";

					RequestHandler reqHandler = new RequestHandler(null, null);
					String sign = reqHandler.createSign(m);

					if (sign.equals(wpr.getSign())) {

						wpr.setAppid(m.get("appid").toString());
						wpr.setBankType(m.get("bank_type").toString());
						wpr.setCashFee(m.get("cash_fee").toString());
						wpr.setFeeType(m.get("fee_type").toString());
						wpr.setIsSubscribe(m.get("is_subscribe").toString());
						wpr.setMchId(m.get("mch_id").toString());
						wpr.setNonceStr(m.get("nonce_str").toString());
						wpr.setOpenid(m.get("openid").toString());
						wpr.setTransactionId(m.get("transaction_id").toString());
						wpr.setResultCode(m.get("result_code").toString());
						wpr.setReturnCode(m.get("return_code").toString());
						wpr.setTimeEnd(m.get("time_end").toString());
						wpr.setTotalFee(m.get("total_fee").toString());
						wpr.setTradeType(m.get("trade_type").toString());

						if ("SUCCESS".equals(wpr.getResultCode())) {
							// 支付成功
							resXml = "<xml>"
									+ "<return_code><![CDATA[SUCCESS]]></return_code>"
									+ "<return_msg><![CDATA[OK]]></return_msg>"
									+ "</xml> ";
						} else {
							resXml = "<xml>"
									+ "<return_code><![CDATA[FAIL]]></return_code>"
									+ "<return_msg><![CDATA[报文为空]]></return_msg>"
									+ "</xml> ";
						}
						/*2017-10-25;Alex:优化代码，线程同步;CR-代码规范*/
						synchronized (this) {
							order = neworder;
						}
//				System.out.println(order);
						logger.info(ESAPI.encoder().encodeForHTML(order));
//				System.out.println(resXml);
						logger.info(ESAPI.encoder().encodeForHTML(resXml));
//						this.sendMessage(wpr.getOutTradeNo().substring(13), wpr.getOpenid());


						String orderNum = wpr.getOutTradeNo().substring(13, 19);
						String body = "";
						List<QueryChildOrdersByParentOrderNumResponse> list1 = client.queryChildOrdersByParentOrderNum(orderNum);
						if(wpr.getOutTradeNo().length()>13){
							for(QueryChildOrdersByParentOrderNumResponse queryChildOrdersByParentOrderNumResponse:list1){
								if(Strings.isNullOrEmpty(body)) {
									body += queryChildOrdersByParentOrderNumResponse.getShortMarketName();
								} else {
									body += "和" + queryChildOrdersByParentOrderNumResponse.getShortMarketName();
								}
							}
						}

						logger.info(" wpr.getOpenid()-------------------"+ wpr.getOpenid());

						PaymentResponse paymentResponse = new PaymentResponse();
						PaymentResultMessage paymentResultMessage1 = new PaymentResultMessage();
						paymentResultMessage1.setPaymentTransNo(order);
						String respCode = "-1";
//				System.out.println("wpr.getReturnCode()=" + wpr.getReturnCode());
						if (wpr.getReturnCode().equalsIgnoreCase("SUCCESS")) {
							respCode = "00";
						}
						paymentResultMessage1.setRespCode(respCode);
						paymentResultMessage1.setRespMsg(wpr.getResultCode());
						paymentResultMessage1.setTransMsg(notifyXml);

						paymentResponse = client.paymentHandlerService(order, paymentResultMessage1);
						if(paymentResponse.getRespCode().equals("00")) {
							// todo: show message the data plan was applied.
//					System.out.println("the data plan was applied");
							logger.info("the data plan was applied");
						} else {
//					System.out.println("error message: " + paymentResponse.getRespMsg());
							logger.error("error message: " + ESAPI.encoder().encodeForHTML(paymentResponse.getRespMsg()));
						}

//				System.out.println("Notify End..");
						
						this.sendMessage(body,orderNum, wpr.getOpenid());
						//更新
						client.updatewechatMessage(wpr.getOpenid(),wpr.getOutTradeNo().substring(13, 19));

						response.setContentType("text/html;charset=UTF-8");
						BufferedOutputStream out = new BufferedOutputStream(
								response.getOutputStream());
						out.write(resXml.getBytes());
						out.flush();
						out.close();
						// response.getWriter().write(resXml);

					}
				}


			}}

	}

	/**
	 * description: 解析微信通知xml
	 *
	 * @param xml
	 * @return
	 * @author ex_yangxiaoyi
	 * @see
	 */

	private static SortedMap<String, String> parseXmlToList2(String xml) {
		// Map retMap = new HashMap();
		SortedMap<String, String> retMap = new TreeMap<String, String>();
		try {
			StringReader read = new StringReader(xml);
			InputSource source = new InputSource(read);
			SAXBuilder sb = new SAXBuilder();
			Document doc = (Document) sb.build(source);
			Element root = doc.getRootElement();// 指向根节
			List<Element> es = root.getChildren();
			if (es != null && es.size() != 0) {
				for (Element element : es) {
					retMap.put(element.getName(), element.getValue());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return retMap;
	}

	private void sendMessage(String body ,String order, String openid) throws IOException {
		HttpClient httpclient = new DefaultHttpClient();
		HttpGet httpgets = new HttpGet(
				"https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="
						+ ConfigureInfo.getWechatAppid() + "&secret=" + ConfigureInfo.getWechatAppSecret() + "&");
		HttpResponse response = httpclient.execute(httpgets);
		String jsonStr = EntityUtils.toString(response.getEntity(), "UTF-8");
		jsonStr=jsonStr.replaceAll("\"|\\{|\\}", "");
		int beginIndex = jsonStr.indexOf(":");
		int endIndex = jsonStr.indexOf(",");
		String access_token = jsonStr.substring(beginIndex+1,endIndex);
			String title = "订购成功\n";

			String time =new SimpleDateFormat("MM月dd日").format(System.currentTimeMillis())+"\n" ;
			String link = ConfigureInfo.getWechatLinkLogin();
			String message = title+time+"尊敬的梅赛德斯-奔驰 智能互联客户，您选购的"+body+"订购成功，订单号"+order+"，请等待开通。点击查看详情。\n"
					+" 有任何疑问请随时使用车内【i】按钮或者400 898 0050联系客服中心。智能互联 -- 智在安心，不止于此。\n <a href='" + link + "'>请点击前往</a>";
			JSONObject jsobj = new JSONObject();
			jsobj.put("touser", openid);
			jsobj.put("msgtype", "text");
			JSONObject jsobj2 = new JSONObject();
			jsobj2.put("content", message);
			jsobj.put("text", jsobj2);
			HttpsURLRequest httpsURLRequest  =new HttpsURLRequest();
			try {
				httpsURLRequest.postUrl("https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token="
						+ access_token + "", jsobj, null);
			} catch (UnrecoverableKeyException e) {
				e.printStackTrace();
			} catch (KeyManagementException e) {
				e.printStackTrace();
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			} catch (KeyStoreException e) {
				e.printStackTrace();
			} catch (URISyntaxException e) {
				e.printStackTrace();
		}

	}

	/*2017-10-25;Alex:优化代码，关闭IO流等;CR-代码规范*/
	public static String convertStreamToString(InputStream ip_stream) {
		InputStreamReader ip_reader = new InputStreamReader(ip_stream);
		BufferedReader bf_reader = new BufferedReader(ip_reader);
		StringBuilder sb = new StringBuilder();

		String line = null;
		try {
			while ((line = bf_reader.readLine()) != null) {
				sb.append(line + "\n");
			}
		} catch (IOException e) { 
			e.printStackTrace();
		} finally {
			try {
				bf_reader.close();
				ip_reader.close();
				ip_stream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return sb.toString();
	}
}