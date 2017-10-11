package com.alipay.util;

import com.alipay.config.AlipayConfig;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.httpclient.methods.multipart.FilePartSource;
import org.apache.commons.httpclient.methods.multipart.PartSource;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/* *
 *绫诲悕锛欰lipayFunction
 *鍔熻兘锛氭敮浠樺疂鎺ュ彛鍏敤鍑芥暟绫?
 *璇︾粏锛氳绫绘槸璇锋眰銆侀?氱煡杩斿洖涓や釜鏂囦欢鎵?璋冪敤鐨勫叕鐢ㄥ嚱鏁版牳蹇冨鐞嗘枃浠讹紝涓嶉渶瑕佷慨鏀?
 *鐗堟湰锛?3.3
 *鏃ユ湡锛?2012-08-14
 *璇存槑锛?
 *浠ヤ笅浠ｇ爜鍙槸涓轰簡鏂逛究鍟嗘埛娴嬭瘯鑰屾彁渚涚殑鏍蜂緥浠ｇ爜锛屽晢鎴峰彲浠ユ牴鎹嚜宸辩綉绔欑殑闇?瑕侊紝鎸夌収鎶?鏈枃妗ｇ紪鍐?,骞堕潪涓?瀹氳浣跨敤璇ヤ唬鐮併??
 *璇ヤ唬鐮佷粎渚涘涔犲拰鐮旂┒鏀粯瀹濇帴鍙ｄ娇鐢紝鍙槸鎻愪緵涓?涓弬鑰冦??
 */

public class AlipayCore {

    /** 
     * 除去数组中的空值和签名参数
     * @param sArray 签名参数组
     * @return 去掉空值与签名参数后的新签名参数组
     */
    public static Map<String, String> paraFilter(Map<String, String> sArray) {

        Map<String, String> result = new HashMap<String, String>();

        if (sArray == null || sArray.size() <= 0) {
            return result;
        }

        for (String key : sArray.keySet()) {
            String value = sArray.get(key);
            if (value == null || value.equals("") || key.equalsIgnoreCase("sign")
                || key.equalsIgnoreCase("sign_type")) {
                continue;
            }
            result.put(key, value);
        }

        return result;
    }

    /**
     * 把数组所有元素排序，并按照“参数=参数值”的模式用“&”字符拼接成字符串
     * @param params 需要排序并参与字符拼接的参数组
     * @return 拼接后字符串
     */
    public static String createLinkString(Map<String, String> params) {

        List<String> keys = new ArrayList<String>(params.keySet());
        Collections.sort(keys);

        String prestr = "";

        for (int i = 0; i < keys.size(); i++) {
            String key = keys.get(i);
            String value = params.get(key);

            if (i == keys.size() - 1) {//拼接时，不包括最后一个&字符
                prestr = prestr + key + "=" + value;
            } else {
                prestr = prestr + key + "=" + value + "&";
            }
        }

        return prestr;
    }

    /**
     * 把数组所有元素按照固定参数排序，以“参数=参数值”的模式用“&”字符拼接成字符串
     * @param params 需要参与字符拼接的参数组
     * @return 拼接后字符串
     */
    public static String createLinkStringNoSort(Map<String, String> params) {

    	//手机网站支付MD5签名固定参数排序，顺序参照文档说明
    	StringBuilder gotoSign_params = new StringBuilder();
    	gotoSign_params.append("service="+params.get("service"));
    	gotoSign_params.append("&v="+params.get("v"));
    	gotoSign_params.append("&sec_id="+params.get("sec_id"));
    	gotoSign_params.append("&notify_data="+params.get("notify_data"));

    	return gotoSign_params.toString();
    }

    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(AlipayConfig.log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 生成文件摘要
     * @param strFilePath 文件路径
     * @param file_digest_type 摘要算法
     * @return 文件摘要结果
     */
    public static String getAbstract(String strFilePath, String file_digest_type) throws IOException {
        PartSource file = new FilePartSource(new File(strFilePath));
    	if(file_digest_type.equals("MD5")){
    		return DigestUtils.md5Hex(file.createInputStream());
    	}
    	else if(file_digest_type.equals("SHA")) {
    		return DigestUtils.sha256Hex(file.createInputStream());
    	}
    	else {
    		return "";
    	}
    }
}
