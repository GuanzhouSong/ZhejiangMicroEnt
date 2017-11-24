package com.icinfo.cs.common.utils;

import java.util.Date;
import java.util.Random;

import org.apache.commons.lang3.StringUtils;

/**
 * code相关的工具类
 * 
 * @author zhuyong
 *
 */
public class CodeUtils {

	/**
	 * 产生code
	 * 
	 * @author zhuyong
	 * @param param
	 * @return
	 */
	public static String createCode(String param) {
		String timeStamp = DateUtil.dateToString(new Date(), "yyyyMMddHHmmss");
		int i = new Random().nextInt(800) + 100;
		if(StringUtils.isBlank(param))
			param = "DE";//默认
		return param.toUpperCase() + timeStamp + i;
	}
	
	public static void main(String[] args) {
		System.out.println(createCode("he"));
	}
}
