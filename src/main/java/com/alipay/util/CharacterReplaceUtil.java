package com.alipay.util;

public class CharacterReplaceUtil {
	public static void main(String[] args) {
        String mobile = "dawdhgfhjfgjtykuewrtgrgwergt";
        mobile=formater(2, 4, mobile);
        System.out.println(mobile);
    }
	/**
	 * 
	 * @param position 替换位置0是前1是中间2是后
	 * @param frontLength 前面保留的字符长度 如果是0，标识不保留
	 * @param backeLength 后面面保留的字符长度 如果是0，标识不保留
	 * @param backeLength 被替换的字符串
	 * @return
	 */
	public static String formater(int frontLength,int backLength,String replaceStr){
		return replaceStr.replaceAll("(?<=.{"+frontLength+"}).(?=.{"+backLength+"})","*");
	}
}
