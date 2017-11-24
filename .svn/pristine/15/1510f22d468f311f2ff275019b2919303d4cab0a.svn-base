package com.icinfo.cs.common.utils;

import java.util.List;

/** 
 * 描述: 发送短信相关验证类
 * @author ZhouYan
 * @date 2016年9月8日  
 */
public class SmsUtil {
	/** 
	 * 描述: 验证参数是否有效
	 * @auther ZhouYan
	 * @date 2016年9月8日 
	 * @param phoneList
	 * @param message
	 * @return
	 * @throws Exception 
	 */
	public static boolean validateParams(List<String> phoneList, String message)
			throws Exception {
		if (phoneList.isEmpty() || message == null || "".equals(message))
			return false;
		return true;
	}

	/** 
	 * 描述: 简单验证是否为手机号11位，并且以“1”开头的数字
	 * @auther ZhouYan
	 * @date 2016年9月8日 
	 * @param phone
	 * @return 
	 */
	public static boolean validateIsPhone(String phone) {
		if (StringUtil.isBlank(phone))
			return false;
		for (int i = 0; i < phone.length(); i++) {
			if (!Character.isDigit(phone.charAt(i))) {
				return false;
			}
		}
		return phone.length() == 11 && phone.startsWith("1");
	}

	/** 
	 * 描述: 验证是否是移动号段
	 * @auther ZhouYan
	 * @date 2016年9月8日 
	 * @param phone
	 * @return 
	 */
	public static boolean validateIsMobile(String phone) {
		String[] ltd = { "134", "135", "136", "137", "138", "139", 
				"147","150", "151", "152", "157", "158", "159",
				 "178", "182", "183", "184", "187", "188"};
		for (int i = 0; i < ltd.length; i++) {
			if (phone.substring(0, 3).equalsIgnoreCase(ltd[i])) {
				return true;
			}
		}
		return false;
	}

	/** 
	 * 描述: 验证是否是联通号段
	 * @auther ZhouYan
	 * @date 2016年9月8日 
	 * @param phone
	 * @return 
	 */
	public static boolean validateIsUnicom(String phone) {
		String[] ltd = { "130", "131", "132", "145",
				"155", "156", "176", "185", "186"};
		for (int i = 0; i < ltd.length; i++) {
			if (phone.substring(0, 3).equalsIgnoreCase(ltd[i])) {
				return true;
			}
		}
		return false;
	}
	
	/** 
	 * 描述: 验证是否是电信号段
	 * @auther ZhouYan
	 * @date 2016年9月8日 
	 * @param phone
	 * @return 
	 */
	public static boolean validateIsChinaNet(String phone) {
		String[] ltd = { "133", "153",  "177", "180", "181", "189"};
		for (int i = 0; i < ltd.length; i++) {
			if (phone.substring(0, 3).equalsIgnoreCase(ltd[i])) {
				return true;
			}
		}
		return false;
	}
}
