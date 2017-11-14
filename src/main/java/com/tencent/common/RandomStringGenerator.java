package com.tencent.common;

import java.security.SecureRandom;

import com.htichina.common.web.Constant;

/**
 * User: rizenguo
 * Date: 2014/10/29
 * Time: 14:18
 */
public class RandomStringGenerator {

    /**
     * 获取一定长度的随机字符串
     * @param length 指定字符串长度
     * @return 一定长度的字符串
     */
    public static String getRandomStringByLength(int length) {
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        /*2017-10-25;Alex:将random变成SecureRandom;CR-代码规范-->*/
        SecureRandom random = new SecureRandom();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }

    public static String getCSRFToken(){
    	SecureRandom rm = new SecureRandom();
		int i = rm.nextInt(Constant.TOKENLIST.size()-1);
		return Constant.TOKENLIST.get(i);
    }
}
