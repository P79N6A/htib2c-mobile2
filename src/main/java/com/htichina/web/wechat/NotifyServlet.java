package com.htichina.web.wechat;

import com.htichina.common.web.ConfigureInfo;
import com.htichina.web.PaymentServiceClient;
import com.htichina.web.common.ViewPage;
import com.htichina.wsclient.payment.PaymentResponse;
import com.htichina.wsclient.payment.PaymentResultMessage;
import com.tencent.common.RequestHandler;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import org.owasp.esapi.ESAPI;
import org.xml.sax.InputSource;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

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
//		System.out.println(order);
		logger.info("order: " + ESAPI.encoder().encodeForHTML(order));
//		request.getSession().setAttribute("order", order);
		request.getRequestDispatcher(ViewPage.LINK2OrderSuccess).forward(request,
				response);
		if(request.getContentLength()!=-1){
			
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
			logger.info("Notify: " + ESAPI.encoder().encodeForHTML(notifyXml));
			if(notifyXml != "" && notifyXml != null){
				SortedMap<String, String> m = parseXmlToList2(notifyXml);
				WxPayResult wpr = new WxPayResult();
				wpr.setSign(m.get("sign").toString());
				wpr.setOutTradeNo(m.get("out_trade_no").toString());
				m.put("sign", "");

				String neworder = wpr.getOutTradeNo().substring(0, 13);
//			System.out.println(neworder);
				logger.info(ESAPI.encoder().encodeForHTML(neworder));
				PaymentServiceClient client = PaymentServiceClient.getInstance();

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

						order = neworder;
//				System.out.println(order);
						logger.info(ESAPI.encoder().encodeForHTML(order));
//				System.out.println(resXml);
						logger.info(ESAPI.encoder().encodeForHTML(resXml));
						this.sendMessage(wpr.getOutTradeNo().substring(13), wpr.getOpenid());

						PaymentResultMessage paymentResultMessage = new PaymentResultMessage();
						paymentResultMessage.setPaymentTransNo(order);
						String respCode = "-1";
//				System.out.println("wpr.getReturnCode()=" + wpr.getReturnCode());
						logger.info("wpr.getReturnCode()=" + ESAPI.encoder().encodeForHTML(wpr.getReturnCode()));
						if(wpr.getReturnCode().equalsIgnoreCase("SUCCESS")) {
							respCode = "00";
						}
						paymentResultMessage.setRespCode(respCode);
						paymentResultMessage.setRespMsg(wpr.getResultCode());
						paymentResultMessage.setTransMsg(notifyXml);

						PaymentResponse paymentResponse = client.paymentHandlerService(order, paymentResultMessage);
						if(paymentResponse.getRespCode().equals("00")) {
							// todo: show message the data plan was applied.
//					System.out.println("the data plan was applied");
							logger.info("the data plan was applied");
						} else {
//					System.out.println("error message: " + paymentResponse.getRespMsg());
							logger.error("error message: " + ESAPI.encoder().encodeForHTML(paymentResponse.getRespMsg()));
						}

//				System.out.println("Notify End..");
						logger.info("Notify End..");

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

	@SuppressWarnings("rawtypes")
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

	private void sendMessage(String order, String openid) throws IOException {
		HttpClient httpclient = new DefaultHttpClient();
		HttpGet httpgets = new HttpGet(
				"https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="
						+ ConfigureInfo.getWechatAppid() + "&secret=" + ConfigureInfo.getWechatAppSecret() + "&");
		HttpResponse response = httpclient.execute(httpgets);
		HttpEntity entity = response.getEntity();
		if (entity != null) {
			InputStream instreams = entity.getContent();
			String str = convertStreamToString(instreams);

			int i = str.indexOf("access_token");
			int j = str.indexOf("expires_in");
			String access_token = str.substring(i + 15, j - 3);

			HttpPost httpost = new HttpPost(
					"https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token="
							+ access_token + "");
			String msg = "{\"touser\":\""
					+ openid
					+ "\",\"msgtype\":\"text\",\"text\":{\"content\":\"您订购的套餐已完成支付，订单号为"
					+ order + "。我们会尽快为您开通服务，请关注开通短信通知，谢谢！\"}}";
			httpost.setEntity(new StringEntity(msg, "UTF-8"));
			HttpResponse resp = httpclient.execute(httpost);
			String jsonStr = EntityUtils.toString(resp.getEntity(), "UTF-8");
//			System.out.println(jsonStr);
			logger.info(ESAPI.encoder().encodeForHTML(jsonStr));
		}

	}

	public static String convertStreamToString(InputStream is) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		StringBuilder sb = new StringBuilder();

		String line = null;
		try {
			while ((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return sb.toString();
	}

}
