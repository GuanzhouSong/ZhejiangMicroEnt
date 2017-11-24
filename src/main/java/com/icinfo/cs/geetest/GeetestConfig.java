package com.icinfo.cs.geetest;

/**
 * GeetestWeb配置文件
 * 
 *
 */
public class GeetestConfig {

	// 填入自己的captcha_id和private_key
	private static final String geetest_id = "44befb7eee731abf2c353515dd95c517";
	private static final String geetest_key = "fe2ef254c2d92b3035ab708d70177721";

	public static final String getGeetest_id() {
		return geetest_id;
	}

	public static final String getGeetest_key() {
		return geetest_key;
	}

}
