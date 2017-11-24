/**
 * Copyright© 2003-2014 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 身份证识别证件信息
 * @author 陈鑫
 * @date 2017-3-2
 * @version 1.0
 */
package com.icinfo.cs.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Calendar;  
import java.util.GregorianCalendar;  
import java.util.Hashtable;  
import java.util.regex.Matcher;  
import java.util.regex.Pattern;

import com.icinfo.framework.tools.utils.StringUtils;  
/**
 * 描述: 身份证识别证件识别
 * 
 * @author 陈鑫
 * @date 2015-3-2
 */
public class CardUtil {
	 /** 
     * 描述：根据身份证的号码算出当前身份证持有者的性别和年龄 18位身份证 
     * @author chenxin
     * @date 2017-03-22
     * @return 
     * @throws Exception 
     */  
    public static Map<String, Object> getCarInfo(String CardCode)  
            throws Exception {  
        Map<String, Object> map = new HashMap<String, Object>();  
        String year = CardCode.substring(6).substring(0, 4);// 得到年份  
        String yue = CardCode.substring(10).substring(0, 2);// 得到月份  
         String day=CardCode.substring(12).substring(0,2);//得到日  
        String sex;  
        if (Integer.parseInt(CardCode.substring(16).substring(0, 1)) % 2 == 0) {// 判断性别  
            sex = "女";  
        } else {  
            sex = "男";  
        }  
        Date date = new Date();// 得到当前的系统时间  
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");  
        String fyear = format.format(date).substring(0, 4);// 当前年份  
        String fyue = format.format(date).substring(5, 7);// 月份  
//         String fday=format.format(date).substring(8,10);  
        int age = 0;  
        if (Integer.parseInt(yue) <= Integer.parseInt(fyue)) { // 当前月份大于用户出身的月份表示已过生  
            age = Integer.parseInt(fyear) - Integer.parseInt(year) + 1;  
        } else {// 当前用户还没过生  
            age = Integer.parseInt(fyear) - Integer.parseInt(year);  
        }  
        map.put("sex", sex);  
        map.put("age", age+"");  
        map.put("birthDay", year+"-"+yue+"-"+day);
        return map;  
    }  
  
    /** 
     * 获取身份证件信息
     * @author chenxin
     * @date 2017-03-22
     * @param 
     * @throws Exception 
     */
    public static Map<String,Object> getCertNOInfo(String card){
    	try{
    		if(card.length() == 15){
    			return getCarInfo15W(card);
    		}else if(card.length() == 18){
    			return getCarInfo(card);
    		}else{
    			return null;
    		}
    	}catch(Exception e){
    		return null;
    	}
    }
    
    /** 
     * 15位身份证的验证 
     * @author chenxin
     * @date 2017-03-22
     * @param 
     * @throws Exception 
     */  
    public static Map<String, Object> getCarInfo15W(String card)  
            throws Exception {  
        Map<String, Object> map = new HashMap<String, Object>();  
        String uyear = "19" + card.substring(6, 8);// 年份  
        String uyue = card.substring(8, 10);// 月份  
        String uday=card.substring(10, 12);//日  
        String usex = card.substring(14, 15);// 用户的性别  
        String sex;  
        if (Integer.parseInt(usex) % 2 == 0) {  
            sex = "女";  
        } else {  
            sex = "男";  
        }  
        Date date = new Date();// 得到当前的系统时间  
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");  
        String fyear = format.format(date).substring(0, 4);// 当前年份  
        String fyue = format.format(date).substring(5, 7);// 月份  
        // String fday=format.format(date).substring(8,10);  
        int age = 0;  
        if (Integer.parseInt(uyue) <= Integer.parseInt(fyue)) { // 当前月份大于用户出身的月份表示已过生  
            age = Integer.parseInt(fyear) - Integer.parseInt(uyear) + 1;  
        } else {// 当前用户还没过生  
            age = Integer.parseInt(fyear) - Integer.parseInt(uyear);  
        }  
        map.put("sex", sex);  
        map.put("age", age+"");  
        map.put("birthDay", uyear+"-"+uyue+"-"+uday);
        return map;  
    }  
    
    /*********************************** 身份证验证开始 ****************************************/
    /**
     * 身份证号码验证 1、号码的结构 公民身份号码是特征组合码，由十七位数字本体码和一位校验码组成。排列顺序从左至右依次为：六位数字地址码，
     * 八位数字出生日期码，三位数字顺序码和一位数字校验码。 2、地址码(前六位数）
     * 表示编码对象常住户口所在县(市、旗、区)的行政区划代码，按GB/T2260的规定执行。 3、出生日期码（第七位至十四位）
     * 表示编码对象出生的年、月、日，按GB/T7408的规定执行，年、月、日代码之间不用分隔符。 4、顺序码（第十五位至十七位）
     * 表示在同一地址码所标识的区域范围内，对同年、同月、同日出生的人编定的顺序号， 顺序码的奇数分配给男性，偶数分配给女性。 5、校验码（第十八位数）
     * （1）十七位数字本体码加权求和公式 S = Sum(Ai * Wi), i = 0, ... , 16 ，先对前17位数字的权求和
     * Ai:表示第i位置上的身份证号码数字值 Wi:表示第i位置上的加权因子 Wi: 7 9 10 5 8 4 2 1 6 3 7 9 10 5 8 4 2 
     * （2）计算模 Y = mod(S, 11) （3）通过模得到对应的校验码 Y: 0 1 2 3 4 5 6 7 8 9 10 校验码: 1 0 X 9 8 7 6 5 4 3 2
     */

    /**
     * 功能：身份证的有效验证
     * 
     * @param IDStr
     *            身份证号
     * @return 有效：返回"" 无效：返回String信息
     * @throws ParseException
     */
    @SuppressWarnings("unchecked")
    public static String IDCardValidate(String IDStr) throws Exception {
        String errorInfo = "";// 记录错误信息
        String[] ValCodeArr = { "1", "0", "x", "9", "8", "7", "6", "5", "4",
                "3", "2" };
        String[] Wi = { "7", "9", "10", "5", "8", "4", "2", "1", "6", "3", "7",
                "9", "10", "5", "8", "4", "2" };
        String Ai = "";
        // ================ 号码的长度 15位或18位 ================
        if (IDStr.length() != 15 && IDStr.length() != 18) {
            errorInfo = "身份证号码长度应该为15位或18位。";
            return errorInfo;
        }
        // =======================(end)========================

        // ================ 数字 除最后以为都为数字 ================
        if (IDStr.length() == 18) {
            Ai = IDStr.substring(0, 17);
        } else if (IDStr.length() == 15) {
            Ai = IDStr.substring(0, 6) + "19" + IDStr.substring(6, 15);
        }
        if (isNumeric(Ai) == false) {
            errorInfo = "身份证15位号码都应为数字 ; 18位号码除最后一位外，都应为数字。";
            return errorInfo;
        }
        // =======================(end)========================

        // ================ 出生年月是否有效 ================
        String strYear = Ai.substring(6, 10);// 年份
        String strMonth = Ai.substring(10, 12);// 月份
        String strDay = Ai.substring(12, 14);// 月份
        if (isDate(strYear + "-" + strMonth + "-" + strDay) == false) {
            errorInfo = "身份证生日无效。";
            return errorInfo;
        }
        GregorianCalendar gc = new GregorianCalendar();
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
        try {
            if ((gc.get(Calendar.YEAR) - Integer.parseInt(strYear)) > 150
                    || (gc.getTime().getTime() - s.parse(
                            strYear + "-" + strMonth + "-" + strDay).getTime()) < 0) {
                errorInfo = "身份证生日不在有效范围。";
                return errorInfo;
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }
        if (Integer.parseInt(strMonth) > 12 || Integer.parseInt(strMonth) == 0) {
            errorInfo = "身份证月份无效";
            return errorInfo;
        }
        if (Integer.parseInt(strDay) > 31 || Integer.parseInt(strDay) == 0) {
            errorInfo = "身份证日期无效";
            return errorInfo;
        }
        // =====================(end)=====================

        // ================ 地区码时候有效 ================
        Hashtable h = GetAreaCode();
        if (h.get(Ai.substring(0, 2)) == null) {
            errorInfo = "身份证地区编码错误。";
            return errorInfo;
        }
        // ==============================================

        // ================ 判断最后一位的值 ================
        int TotalmulAiWi = 0;
        for (int i = 0; i < 17; i++) {
            TotalmulAiWi = TotalmulAiWi
                    + Integer.parseInt(String.valueOf(Ai.charAt(i)))
                    * Integer.parseInt(Wi[i]);
        }
        int modValue = TotalmulAiWi % 11;
        String strVerifyCode = ValCodeArr[modValue];
        Ai = Ai + strVerifyCode;

        if (IDStr.length() == 18) {
            if (Ai.equals(IDStr) == false) {
                errorInfo = "身份证无效，不是合法的身份证号码";
                return errorInfo;
            }
        } else {
            return "";
        }
        // =====================(end)=====================
        return "";
    }

    /**
     * 功能：设置地区编码
     * 
     * @return Hashtable 对象
     */
    @SuppressWarnings("unchecked")
    private static Hashtable GetAreaCode() {
        Hashtable hashtable = new Hashtable();
        hashtable.put("11", "北京");
        hashtable.put("12", "天津");
        hashtable.put("13", "河北");
        hashtable.put("14", "山西");
        hashtable.put("15", "内蒙古");
        hashtable.put("21", "辽宁");
        hashtable.put("22", "吉林");
        hashtable.put("23", "黑龙江");
        hashtable.put("31", "上海");
        hashtable.put("32", "江苏");
        hashtable.put("33", "浙江");
        hashtable.put("34", "安徽");
        hashtable.put("35", "福建");
        hashtable.put("36", "江西");
        hashtable.put("37", "山东");
        hashtable.put("41", "河南");
        hashtable.put("42", "湖北");
        hashtable.put("43", "湖南");
        hashtable.put("44", "广东");
        hashtable.put("45", "广西");
        hashtable.put("46", "海南");
        hashtable.put("50", "重庆");
        hashtable.put("51", "四川");
        hashtable.put("52", "贵州");
        hashtable.put("53", "云南");
        hashtable.put("54", "西藏");
        hashtable.put("61", "陕西");
        hashtable.put("62", "甘肃");
        hashtable.put("63", "青海");
        hashtable.put("64", "宁夏");
        hashtable.put("65", "新疆");
        hashtable.put("71", "台湾");
        hashtable.put("81", "香港");
        hashtable.put("82", "澳门");
        hashtable.put("91", "国外");
        return hashtable;
    }

    /**
     * 功能：判断字符串是否为数字
     * 
     * @param str
     * @return
     */
    private static boolean isNumeric(String str) {
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(str);
        if (isNum.matches()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 功能：判断字符串是否为日期格式
     * 
     * @param str
     * @return
     */
    public static boolean isDate(String strDate) {
        Pattern pattern = Pattern
                .compile("^((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))(\\s(((0?[0-9])|([1-2][0-3]))\\:([0-5]?[0-9])((\\s)|(\\:([0-5]?[0-9])))))?$");
        Matcher m = pattern.matcher(strDate);
        if (m.matches()) {
            return true;
        } else {
            return false;
        }
    }

    
    /** 
     * 根据15位的身份证号码获得18位身份证号码 
     * @param fifteenIDCard 15位的身份证号码 
     * @return 升级后的18位身份证号码 
     * @throws Exception 如果不是15位的身份证号码，则抛出异常 
     */  
    public String getEighteenIDCard(String fifteenIDCard) throws Exception{  
        if(fifteenIDCard != null && fifteenIDCard.length() == 15){  
            StringBuilder sb = new StringBuilder();  
            sb.append(fifteenIDCard.substring(0, 6))  
              .append("19")  
              .append(fifteenIDCard.substring(6));  
            sb.append(getVerifyCode(sb.toString()));  
            return sb.toString();  
        } else {  
            throw new Exception("不是15位的身份证");  
        }  
    }  
      
    /** 
     * 获取校验码 
     * @param idCardNumber 不带校验位的身份证号码（17位） 
     * @return 校验码 
     * @throws Exception 如果身份证没有加上19，则抛出异常 
     */  
    public char getVerifyCode(String idCardNumber) throws Exception{  
        if(idCardNumber == null || idCardNumber.length() < 17) {  
            throw new Exception("不合法的身份证号码");  
        }  
        char[] Ai = idCardNumber.toCharArray();  
        int[] Wi = {7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};  
        char[] verifyCode = {'1','0', 'X', '9', '8', '7', '6', '5', '4', '3', '2'};  
        int S = 0;  
        int Y;  
        for(int i = 0; i < Wi.length; i++){  
            S += (Ai[i] - '0') * Wi[i];  
        }  
        Y = S % 11;  
        return verifyCode[Y];  
    }  
    
    /**
     * @param args
     * @throws ParseException
     */
    @SuppressWarnings("static-access")
    public static void main(String[] args) throws Exception {
        // String IDCardNum="210102820826411";
        // String IDCardNum="210102198208264114";
        String IDCardNum = "332627671222217";
        CardUtil cc = new CardUtil();
        System.out.println(cc.IDCardValidate(IDCardNum));
        // System.out.println(cc.isDate("1996-02-29"));
    }	
    
    /**
	 * 描述: 把字符串中的身份证用星号代替
	 * 
	 * @author 徐建军
	 * @date 2015-4-22
	 * @param data
	 * @return
	 */
    public static String getHide(String data) {
		if (StringUtils.isNotBlank(data)) {
			// 匹配身份证
			String regex = "\\d{14,17}[0-9a-zA-Z]";
			Pattern p = Pattern.compile(regex);
			Matcher m = p.matcher(data);
			while (m.find()) {
				if (!"".equals(m.group()))
					if (m.group().length() >= 15 && m.group().length() <= 18) {
						// 定义判别用户身份证号的正则表达式（要么是15位，要么是18位，最后一位可以为字母）
						Pattern idNumPattern = Pattern.compile(
								"(^[1-9]\\d{7}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}$)|(^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}[0-9a-zA-Z]$)");
						// 通过Pattern获得Matcher
						Matcher idNumMatcher = idNumPattern.matcher(m.group());
						// 判断用户输入是否为身份证号
						if (idNumMatcher.matches()) {
							data = data.replace(m.group(), "********");
						}
					}

			}

			// 匹配手机号码（手机号码不隐藏）
			Pattern phonePattern = Pattern.compile("([1]([3][0-9]{1}|59|58|88|89)[0-9]{8})");
			Matcher phonem = phonePattern.matcher(data);
			String phone = "";
			while (phonem.find()) {
				if (!"".equals(phonem.group()))
					if (phonem.group().length() == 11) {
						phone = phonem.group();
						data = data.replace(phonem.group(), "********");
					}
			}

			// 匹配护照
			/*
			 * 中国 (1[45][0-9]{7}|G[0-9]{8}|P[0-9]{7}|S[0-9]{7,8}|E[0-9]{8}) 8-9位
			 * 美国 9位数字 [0-9]{9} 9位 日本 T20149732
			 * ([a-zA-Z]{2}[0-9]{7}|[a-zA-Z]{1}[0-9]{8}) 9 位 韩国 M[0-9]{8}
			 * [a-zA-Z]{2}[0-9]{7} 9位 英国 [a-zA-Z0-9]{10} 没规律 10位 印度
			 * [a-zA-Z][0-9]{7} 8位 德国 C34P6F3LC  或者9位纯数字 9位 法国 2个数字+2个字母+5字母 9位
			 * 意大利 2字母+7位数字 9位
			 */
			String passPortRegx = "(^(1[45][0-9]{7}|G[0-9]{8}|P[0-9]{7}|S[0-9]{7,8}|E[0-9]{8})$)|(^[0-9]{9}$)|([a-zA-Z]{2}[0-9]{7}|[a-zA-Z]{1}[0-9]{8})|"
					+ "(M[0-9]{8}|[a-zA-Z]{2}[0-9]{7})|([a-zA-Z0-9]{10})|([a-zA-Z][0-9]{7})|([0-9]{9})|([0-9]{2}[a-zA-Z]{7})|([a-zA-Z]{2}[0-9]{7})";
			Pattern passPortPattern = Pattern.compile(passPortRegx);
			Matcher passPortMatcher = passPortPattern.matcher(data);
			while (passPortMatcher.find()) {
				if (!"".equals(passPortMatcher.group()))
					if (passPortMatcher.group().length() >= 8 && passPortMatcher.group().length() <= 10) {
						data = data.replace(passPortMatcher.group(), "********");
					}

			}

			// 匹配港澳通行证
			String haRegex = "([HMhm]{1}([0-9]{10}|[0-9]{8}))";
			Pattern haPattern = Pattern.compile(haRegex);
			Matcher ham = haPattern.matcher(data);
			while (ham.find()) {
				if (!"".equals(ham.group()))
					if (ham.group().length() >= 9 && ham.group().length() <= 11) {
						data = data.replace(ham.group(), "********");
					}
			}

			// 匹配台湾通行证 /^[0-9]{8}$/;var b=/^[0-9]{10}$/
			String taiRegex = "([0-9]{8}|[0-9]{10})";
			Pattern taiPattern = Pattern.compile(taiRegex);
			Matcher taiMatcher = taiPattern.matcher(data);
			while (taiMatcher.find()) {
				if (!"".equals(taiMatcher.group()))
					if (taiMatcher.group().length() >= 8 && taiMatcher.group().length() <= 10) {
						data = data.replace(taiMatcher.group(), "********");
					}
			}

			// 匹配外国人居留证/^[a-zA-Z]{3}[0-9]{12}$
			String foreignRegex = "([a-zA-Z]{3}[0-9]{12})";
			Pattern foreignPattern = Pattern.compile(foreignRegex);
			Matcher foreignMatcher = foreignPattern.matcher(data);
			while (foreignMatcher.find()) {
				if (!"".equals(foreignMatcher.group()))
					if (foreignMatcher.group().length() == 15) {
						data = data.replace(foreignMatcher.group(), "********");
					}
			}
			// 匹配军官证/^\d{8}$/
			String officerRegex = "([0-9]{8})";
			Pattern officerPattern = Pattern.compile(officerRegex);
			Matcher officerMatcher = officerPattern.matcher(data);
			while (officerMatcher.find()) {
				if (!"".equals(officerMatcher.group()))
					if (officerMatcher.group().length() == 8) {
						data = data.replace(officerMatcher.group(), "********");
					}
			}
			
		}
		return data;
	}
}
