package com.icinfo.cs.common.utils;

import java.security.MessageDigest;

import com.icinfo.framework.tools.utils.Md5Utils;;

/** 
 * 描述: MD5加密封装类
 * @author ZhouYan
 * @date 2016年9月8日  
 */
public class MD5Util extends Md5Utils{
	/** 
	 * 描述: MD5加密字符串
	 * @auther ZhouYan
	 * @date 2016年9月8日 
	 * @param str
	 * @return 
	 */
	public static String Encoder(String str) {
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			char[] strChars = str.toCharArray();
			byte[] strBytes = new byte[strChars.length];
			for (int i = 0; i < strChars.length; i++)
				strBytes[i] = (byte) strChars[i];
			byte[] md5Bytes = md5.digest(strBytes);
			StringBuffer hexValue = new StringBuffer();
			for (int i = 0; i < md5Bytes.length; i++) {
				int val = ((int) md5Bytes[i]) & 0xff;
				if (val < 16)
					hexValue.append("0");
				hexValue.append(Integer.toHexString(val));
			}
			return hexValue.toString();
		} catch (Exception ex) {
			ex.printStackTrace();
			return "";
		}
	}

	public static void main(String[] args) {
		System.out.println(MD5Util.Encoder("abc"));
	}
}
