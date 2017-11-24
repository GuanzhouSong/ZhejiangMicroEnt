package com.icinfo.cs.common.utils;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import com.icinfo.framework.tools.utils.StringUtils;


/** 
 * 描述: 字符处理
 * @author ZhouYan
 * @date 2016年8月29日  
 */
public class StringUtil extends StringUtils{
	
	/** 
	 * 描述: 去空格
	 * @auther ZhouYan
	 * @date 2016年8月29日 
	 * @param str
	 * @return 
	 */
	public static String doReplaceBlank(String str) {
		String rstStr = "";
        String temp = "";
        char[] charArray = str.toCharArray();
        for(char a : charArray){
        	if(a!=(char)127){
        		temp = temp+a;
        	}else{
        	}
        }
        if (temp!=null) {
            Pattern p = Pattern.compile("\\r|\n");
            Matcher m = p.matcher(temp);
            rstStr = m.replaceAll("");
        }
        return rstStr.replaceAll("　", "").trim();
    }
	
	/** 
	 * 描述: 生成随机序号：4位地区编码+17位时间戳+corpid最后5位
	 * @auther ZhouYan
	 * @date 2014-6-19 
	 * @return 
	 */
	public  static String getRandomNumber(String corpid){
		Date date=new Date();
		DateFormat df=new SimpleDateFormat("yyyyMMddHHmmssSSS");
		return corpid.substring(0, 4) + df.format(date) + corpid.substring(corpid.length()-5, corpid.length());
	}
	
	/** 
	 * 描述: 生成随机序号：4位地区编码+17位时间戳+5位随机码
	 * @auther ZhouYan
	 * @date 2014-6-19 
	 * @return 
	 */
	public  static String getRandomNumberByRegOrg(String regOrg){
		Date date=new Date();
		DateFormat df=new SimpleDateFormat("yyyyMMddHHmmssSSS");
		return regOrg.substring(0, 4) + df.format(date) + NextInt(10000,99999);
	}
	
	/** 
	 * 描述: 生成流水号：8位时间戳（yyyyMMdd） + 注册号后4位 + 4位随机码
	 * @auther ZhouYan
	 * @date 2014年8月28日 
	 * @param regOrg
	 * @return 
	 */
	public  static String getSeqNumber(String regOrg){
		Date date=new Date();
		DateFormat df=new SimpleDateFormat("yyyyMMdd");
		return df.format(date) + regOrg.substring(regOrg.length()-4, regOrg.length()) + NextInt(1000,9999);
	}
	
	/** 
	 * 描述: 生成流水号：时间戳+3位随机数
	 * @auther ZhouYan
	 * @date 2014年9月15日 
	 * @return 
	 */
	public  static String getSeqNumber(){
		return getTimeStamp() + NextInt(100,999);
	}
	
	/** 
	 * 描述: 生成 min - max 范围的随机数
	 * @auther ZhouYan
	 * @date 2016年8月29日 
	 * @param min
	 * @param max
	 * @return 
	 */
	public static Integer NextInt(final int min, final int max){
	    int tmp = Math.abs(new Random().nextInt());
	    return tmp % (max - min + 1) + min;
	}
	
	/** 
	 * 描述: 生成时间戳
	 * @auther ZhouYan
	 * @date 2016年8月29日 
	 * @return 
	 */
	public static String getTimeStamp()
	{
		Date date = new Date();
		DateFormat df=new SimpleDateFormat("yyyyMMddHHmmssSSS");
		return df.format(date);
	}

	/**
	 * 描述：日期类型转换为字符串
	 * @auther wangjin
	 * @param date
	 * @param pattern
	 * @return 返回类型：String
	 */
	public static String formatDate(Date date, String pattern) {
		return date!=null? new SimpleDateFormat(pattern).format(date):"";
	}
	
	/** 
	 * 描述: 生成短信流水号
	 * @auther ZhouYan
	 * @date 2014年9月13日 
	 * @return 
	 */
	public static String getMessageId() {
		return getTimeStamp() + NextInt(10000,99999);
	}
	
	/** 
	 * 描述: 敏感词过滤内容
	 * @auther ZhouYan
	 * @date 2016年9月14日 
	 * @param str
	 * @return
	 * @throws PatternSyntaxException 
	 */
	public static String StringFilter(String str) throws PatternSyntaxException {
		// 只允许字母和数字
		// String regEx = "[^a-zA-Z0-9]";
		// 清除掉所有特殊字符
		String regEx = "[\\s`~!@#$%^&*()+|{}':;',//[//].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";
		Pattern p = Pattern.compile(regEx);
		Matcher m = p.matcher(str);
		return m.replaceAll("").trim();
	}

	/**
	 * 获取一个文件的后缀(带有点)
	 ** @autor:wangjin
	 * @param fileName
	 *   文件名
	 * @return 返回文件的后缀
	 */
	public static String getExt(String fileName) {
		int pos = fileName.lastIndexOf(".");
		if (pos == -1)
			return "";
		return fileName.substring(pos, fileName.length());
	}

	/**
	 * 获取一个文件的后缀(不带有点)
	 ** @autor:wangjin
	 * @param fileName
	 * 文件名
	 * @return 返回文件的后缀
	 */
	public static String getExtNoPoint(String fileName) {
		if (fileName.lastIndexOf(".") == -1)
			return "";
		int pos = fileName.lastIndexOf(".") + 1;
		return fileName.substring(pos, fileName.length());
	}

	/**
	 * 判断一个字符串是否存在数组中
	 ** @autor:wangjin
	 * @param
	 * @return
	 */
	public static boolean isHave(String [] arr , String str) {
		int length = arr.length;
		for (int i = 0; i < length; i++) {
			if(arr[i]==null) {
				return false;
			}
			if (arr[i].equals(str)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 随即生产随即数，可以用来生产tocken字符串等.
	 ** @autor:wangjin
	 * @param length
	 *  生成长度
	 * @return 随即数字符串.
	 */
	public static String getRandomString(int length) {
		StringBuffer bu = new StringBuffer();
		String[] arr = { "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c",
				"d", "e", "f", "g", "h", "i", "j", "k", "m", "n", "p", "q",
				"r", "s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C",
				"D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "P",
				"Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z" };
		Random random = new Random();
		while (bu.length() < length) {
			String temp = arr[random.nextInt(57)];
			if (bu.indexOf(temp) == -1) {
				bu.append(temp);
			}
		}
		return bu.toString();
	}

	/***
	 * 字符串数组转换成字符串
	 * @autor:wangjin
	 * @param strings
	 * @return
	 */
	public static String arrToString(String[] strings, String separtor) {
		StringBuffer buffer = new StringBuffer();
		if (strings != null) {
			for (String string : strings) {
				buffer.append(string + separtor);
			}
			String result = buffer.toString();
			return result.substring(0, result.length() - 1);
		} else {
			return "";
		}
	}

	/**
	 * 描述：处理 外国人姓名中 带有点的处理方法
	 * @author：wnagjin
	 * @param str
	 * @return
     */
	public static String doHtm(String str) {
		str = str.replace("&middot;", "·");
		return str;
	}
	

	/**
	 *
	 * 描述: 元 转化为 万元
	 * @author: wangjin
	 * @return: BigDecimal
	 * @throws
	 */
	public static BigDecimal bigDecimalDivideWan(BigDecimal num){
		return  num==null?null:num.divide(new BigDecimal(10000));
	}

	/**
	 * 描述: 万元转换成元  保留两位小数
	 * @author: wangjin
	 * @return: BigDecimal
	 * @throws
	 */
	public static BigDecimal getBigDecimalDivideYuan(BigDecimal num) {
		return num == null ? null : num.multiply(new BigDecimal(10000)).setScale(2, BigDecimal.ROUND_HALF_UP);
	}

	/**
	 * 描述: 获取万元数据  并保留4位小数
	 * @author: wangjin
	 * @return: BigDecimal
	 * @throws
	 */
	public static BigDecimal getBigDecimalDivid(BigDecimal num) {
		return num == null ? null : num.multiply(new BigDecimal(10000)).setScale(4, BigDecimal.ROUND_HALF_UP);
	}

	/**
	 * 
	 * 描述   去掉参数的左右空格
	 * @author  赵祥江
	 * @date 2016年10月28日 下午4:26:31 
	 * @param  
	 * @throws
	 */
	@SuppressWarnings("rawtypes") 
	public static void paramTrim(Map<String, Object> dataMap) throws Exception {
		if(dataMap!=null){
			Iterator i=dataMap.entrySet().iterator();
			while(i.hasNext()){
				 Map.Entry e=(Map.Entry)i.next();
				 if(e.getValue()!=null&&!"".equals(e.getValue())){
					 dataMap.put(e.getKey().toString(), e.getValue().toString().trim());
				 } 
			} 
		}
	}
	
	/**
     * 将字符串按分隔符打散，并合并成符合SQL中in的格式
     *
     * @param string 要分割的字符串
     * @param pattern 分割关键字
     * @return result
     */
    public static String doSplitStringToSqlFormat(String string, String pattern) {
    	if(StringUtils.isBlank(string)) return "";
        StringBuilder result = new StringBuilder("");
        String arr[] = string.split(pattern);
        if (arr.length > 0) {
            for (int i = 0; i < arr.length; i++) {
                if ("".equals(result.toString())) {
                    result.append("'");
                    result.append(arr[i]);
                    result.append("'");
                } else {
                    result.append(",");
                    result.append("'");
                    result.append(arr[i]);
                    result.append("'");
                }
            }
        } else {
            result.append(string);
        }
        return result.toString();
    }

	/**
	 * 判断年份和身份主体代码是否为空或为null  年报专用
	 * @author ：wangjin
	 * @param year
	 * @param pripid
     * @return
     */
	public static Boolean checkYearAndPripid(String year,String pripid){
		boolean flag = false;
		if(StringUtil.isNotBlank(year)&&StringUtil.isNotBlank(pripid)){
			flag = true;
		}
		return flag;
	}
	public static Boolean checkYearAndPripid(Integer year,String pripid){
		boolean flag = false;
		if(year!=null&&StringUtil.isNotBlank(pripid)){
			flag = true;
		}
		return flag;
	}
	
	/**
	 * 补零
	 * 
	 * @param num  整数
	 * @param maxLength 需要补到多少位
	 * @return
	 */
	public static String addZero(int num,int maxLength){
		String str = num+"";
		String result = str;
		if(result.length() >= maxLength){
			return result;
		}
		for(int i = str.length();i<maxLength;i++){
			result = "0"+result;
		}
		return result;
	}
}