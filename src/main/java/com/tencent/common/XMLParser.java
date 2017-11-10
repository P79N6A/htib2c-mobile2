package com.tencent.common;

import com.tencent.protocol.refund_query_protocol.RefundOrderData;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: rizenguo 
 * Date: 2014/11/1 
 * Time: 14:06
 */
public class XMLParser {
	/*2017-10-25;Alex:优化代码，优化XMLParser的输出流，避免出错;CR-代码规范*/
	/**
	 * 从RefunQueryResponseString里面解析出退款订单数据
	 * 
	 * @param refundQueryResponseString
	 *            RefundQuery API返回的数据
	 * @return 因为订单数据有可能是多个，所以返回一个列表
	 */
	public static List<RefundOrderData> getRefundOrderList(String refundQueryResponseString) throws IOException,
			SAXException, ParserConfigurationException {
		List list = new ArrayList();

		Map<String, Object> map = XMLParser.getMapFromXML(refundQueryResponseString);

		int count = Integer.parseInt((String) map.get("refund_count"));
		Util.log("count:" + count);

		if (count < 1) {
			return list;
		}

		RefundOrderData refundOrderData;

		for (int i = 0; i < count; i++) {
			refundOrderData = new RefundOrderData();

			refundOrderData.setOutRefundNo(Util.getStringFromMap(map, "out_refund_no_" + i, ""));
			refundOrderData.setRefundID(Util.getStringFromMap(map, "refund_id_" + i, ""));
			refundOrderData.setRefundChannel(Util.getStringFromMap(map, "refund_channel_" + i, ""));
			refundOrderData.setRefundFee(Util.getIntFromMap(map, "refund_fee_" + i));
			refundOrderData.setCouponRefundFee(Util.getIntFromMap(map, "coupon_refund_fee_" + i));
			refundOrderData.setRefundStatus(Util.getStringFromMap(map, "refund_status_" + i, ""));
			list.add(refundOrderData);
		}

		return list;
	}

	public static Map<String, Object> getMapFromXML(String xmlString) throws ParserConfigurationException, IOException,
			SAXException {
		// 这里用Dom的方式解析回包的最主要目的是防止API新增回包字段
		NodeList allNodes = null;
		// 阻止xml实体注入
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		String FEATURE = null;
		try {
			// This is the PRIMARY defense. If DTDs (doctypes) are disallowed,
			// almost all XML entity attacks are prevented
			// Xerces 2 only - http://xerces.apache.org/xerces2-j/features.html#disallow-doctype-decl
			FEATURE = "http://apache.org/xml/features/disallow-doctype-decl";
			dbf.setFeature(FEATURE, true);
			// If you can't completely disable DTDs, then at least do the
			// following:
			// Xerces 1 - http://xerces.apache.org/xerces-j/features.html#external-general-entities
			// Xerces 2 - http://xerces.apache.org/xerces2-j/features.html#external-general-entities
			// JDK7+ - http://xml.org/sax/features/external-general-entities
			FEATURE = "http://xml.org/sax/features/external-general-entities";
			dbf.setFeature(FEATURE, false);
			// Xerces 1 - http://xerces.apache.org/xerces-j/features.html#external-parameter-entities
			// Xerces 2 - http://xerces.apache.org/xerces2-j/features.html#external-parameter-entities
			// JDK7+ - http://xml.org/sax/features/external-parameter-entities
			FEATURE = "http://xml.org/sax/features/external-parameter-entities";
			dbf.setFeature(FEATURE, false);
			// Disable external DTDs as well
			FEATURE = "http://apache.org/xml/features/nonvalidating/load-external-dtd";
			dbf.setFeature(FEATURE, false);
			// and these as well, per Timothy Morgan's 2014 paper:
			// "XML Schema, DTD, and Entity Attacks"
			dbf.setXIncludeAware(false);
			dbf.setExpandEntityReferences(false);
			DocumentBuilder builder = dbf.newDocumentBuilder();
			InputStream is = Util.getStringStream(xmlString);
			Document document = builder.parse(is);
			// 获取到document里面的全部结点
			allNodes = document.getFirstChild().getChildNodes();
		} catch (ParserConfigurationException e) {
			Util.log("ParserConfigurationException was thrown. The feature " + FEATURE
					+ " is probably not supported by your XML processor.");
		} catch (SAXException e) {
			Util.log("A DOCTYPE was passed into the XML document");
		} catch (IOException e) {
			Util.log("IOException occurred, XXE may still possible: ");
		}
		Node node;
		Map<String, Object> map = new HashMap<String, Object>();
		int i = 0;
		if (allNodes != null) {
			while (i < allNodes.getLength()) {
				node = allNodes.item(i);
				if (node instanceof Element) {
					map.put(node.getNodeName(), node.getTextContent());
				}
				i++;
			}
		}
		return map;
	}
}
