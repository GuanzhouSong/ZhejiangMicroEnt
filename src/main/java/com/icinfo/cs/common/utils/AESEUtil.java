/**
 * Copyright© 2003-2014 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 加密解密帮助类
 * @author 徐建军
 * @date 2014-3-4
 * @version 1.0
 */
package com.icinfo.cs.common.utils;

import java.io.UnsupportedEncodingException;
import java.security.SecureRandom;
import java.util.Timer;
import java.util.TimerTask;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 * 描述: 加密解密帮助类
 * 
 * @author 徐建军
 * @date 2014-3-4
 */
public class AESEUtil {

	private static String accessCode;
	private static Timer timer;

	/** 
	 * 描述: 定时更新秘钥
	 * @author 徐建军
	 * @date 2016年9月23日  
	 */
	private static class ChangeTask extends TimerTask {
		@Override
		public void run() {
			accessCode = StringUtil.uuid();
		}
	}

	/** 
	 * 描述: 获取秘钥
	 * @author 徐建军
	 * @date 2016年9月23日 
	 * @return 
	 */
	public static String getAccessCode() {
		/*if (accessCode == null) {
			//延迟一天开始执行,每一天更新一次秘钥 1440 * 60 * 1000
			timer = new Timer();
			timer.schedule(new ChangeTask(), 1440 * 60 * 1000, 1440 * 60 * 1000);
			accessCode = StringUtil.uuid();
		}*/
		accessCode = "951753";
		return accessCode;
	}

	/**
	 * 描述: 加密
	 * 
	 * @author 徐建军
	 * @date 2014-3-4
	 * @param content
	 * @param password
	 * @return
	 */
	public static byte[] encrypt(String content, String password) {

		try {

			KeyGenerator kgen = KeyGenerator.getInstance("AES");

			SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
			secureRandom.setSeed(password.getBytes());

			kgen.init(128, secureRandom);

			SecretKey secretKey = kgen.generateKey();

			byte[] enCodeFormat = secretKey.getEncoded();

			SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");

			Cipher cipher = Cipher.getInstance("AES");// 创建密码器

			byte[] byteContent = content.getBytes("utf-8");

			cipher.init(Cipher.ENCRYPT_MODE, key);// 初始化

			byte[] result = cipher.doFinal(byteContent);

			return result; // 加密

		} catch (Exception e) {

			e.printStackTrace();

		}

		return null;

	}

	/**
	 * 描述: 解密
	 * 
	 * @author 徐建军
	 * @date 2014-3-4
	 * @param content
	 * @param password
	 * @return
	 */
	public static byte[] decrypt(byte[] content, String password) {

		try {

			KeyGenerator kgen = KeyGenerator.getInstance("AES");

			SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
			secureRandom.setSeed(password.getBytes());

			kgen.init(128, secureRandom);

			SecretKey secretKey = kgen.generateKey();

			byte[] enCodeFormat = secretKey.getEncoded();

			SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");

			Cipher cipher = Cipher.getInstance("AES");// 创建密码器

			cipher.init(Cipher.DECRYPT_MODE, key);// 初始化

			byte[] result = cipher.doFinal(content);

			return result; // 解密

		} catch (Exception e) {

			throw new RuntimeException("初始化密钥出现异常");

		}

	}

	/**
	 * 描述: 将二进制转换成16进制
	 * 
	 * @author 徐建军
	 * @date 2014-3-4
	 * @param buf
	 * @return
	 */
	public static String parseByte2HexStr(byte[] buf) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < buf.length; i++) {
			String hex = Integer.toHexString(buf[i] & 0xFF);
			if (hex.length() == 1) {
				hex = '0' + hex;
			}
			sb.append(hex.toUpperCase());
		}
		return sb.toString();
	}

	/**
	 * 描述: 将16进制转换为二进制
	 * 
	 * @author 徐建军
	 * @date 2014-3-4
	 * @param hexStr
	 * @return
	 */
	public static byte[] parseHexStr2Byte(String hexStr) {
		if (hexStr.length() < 1)
			return null;
		byte[] result = new byte[hexStr.length() / 2];
		for (int i = 0; i < hexStr.length() / 2; i++) {
			int high = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 1), 16);
			int low = Integer.parseInt(hexStr.substring(i * 2 + 1, i * 2 + 2), 16);
			result[i] = (byte) (high * 16 + low);
		}
		return result;
	}

	/**
	 * 描述: 数据解密
	 * 
	 * @author 徐建军
	 * @date 2014-9-22
	 * @return string
	 * @throws UnsupportedEncodingException
	 */
	public static String decodeCorpid(String corpid) throws UnsupportedEncodingException {
		return new String(AESEUtil.decrypt(AESEUtil.parseHexStr2Byte(corpid), getAccessCode()), "utf-8");
	}


	/**
	 * 描述: 数据加密
	 *
	 * @author 徐建军
	 * @date 2015-8-19
	 * @param corpid
	 * @return
	 */
	public static String encodeCorpid(String corpid) {
		return AESEUtil.parseByte2HexStr(AESEUtil.encrypt(corpid, getAccessCode()));
	}



	/**
	 * 描述: 数据解密（年报用）
	 * 
	 * @auther ZhouYan
	 * @date 2016年6月16日
	 * @param corpid
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static String decodeYearReportCorpid(String corpid) throws UnsupportedEncodingException {
		return new String(AESEUtil.decrypt(AESEUtil.parseHexStr2Byte(corpid), DateUtil.getCurrentSimpleDate()),
				"utf-8");
	}


	/**
	 * 描述: 年份数据加密 (年报填报专用)
	 * @author wangijn
	 * @param year
	 * @return string
	 */
	public static String encodeYear(String year) {
		return AESEUtil.parseByte2HexStr(AESEUtil.encrypt(year, getAccessCode()));
	}

	/**
	 * 描述: 年份数据解密 (年报填报专用)
	 * @author wangjin
	 * @return string
	 * @throws UnsupportedEncodingException
	 */
	public static String decodeYear(String year) throws UnsupportedEncodingException {
		return new String(AESEUtil.decrypt(AESEUtil.parseHexStr2Byte(year), getAccessCode()), "utf-8");
	}


	/**
	 * 描述: 测试
	 * 
	 * @author 徐建军
	 * @date 2014-3-5
	 * @param args
	 */
	public static void main(String[] args) throws UnsupportedEncodingException {
		timer = new Timer();
		timer.schedule(new ChangeTask(), 0, 2 * 1000);

	}
}
