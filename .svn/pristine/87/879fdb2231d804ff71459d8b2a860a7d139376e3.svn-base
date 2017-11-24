package com.icinfo.cs.common.utils;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 描述：
 *
 * @author: wangjin
 * @date：2017-11-22
 */
public class CsStringUtil {
    /**
     * 描述: 去空格
     * @auther wangjin
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
     *@描述： 为空判断
     *@author: wangjin
     *@date 2017-09-14 11:03
     *@return
     */
    public static boolean isBlank(CharSequence cs) {
        int strLen;
        if(cs != null && (strLen = cs.length()) != 0) {
            for(int i = 0; i < strLen; ++i) {
                if(!Character.isWhitespace(cs.charAt(i))) {
                    return false;
                }
            }
            return true;
        } else {
            return true;
        }
    }
    /**
     *@描述： 不为空判断
     *@author: wangjin
     *@date 2017-09-14 11:03
     *@return
     */
    public static boolean isNotBlank(CharSequence cs) {
        return !isBlank(cs);
    }

    /**
     *@描述：去掉参数的左右空格
     *@author: wangjin
     *@date 2017-09-14 16:40
     *@return
     */
    @SuppressWarnings("rawtypes")
    public static Map<String,Object> paramTrim(Map<String, Object> dataMap) throws Exception {
        if(dataMap!=null){
            Iterator i=dataMap.entrySet().iterator();
            while(i.hasNext()){
                Map.Entry e=(Map.Entry)i.next();
                if(e.getValue()!=null&&!"".equals(e.getValue())){
                    dataMap.put(e.getKey().toString(), e.getValue().toString().trim());
                }
            }
        }
        return dataMap;
    }

    /**
     *@描述： 组装 sql in 查询
     *@author: wangjin
     *@date 2017-09-14 16:42
     *@return
     */
    /*使用方法：
       String sql ="1,2,3,4,5,6,7,8";
       System.out.println(doSplitStringToSqlFormat(sql,",")); //'1','2','3','4','5','6','7','8'
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
     *@描述： 判断两个参数是否相同
     *@author: wangjin
     *@date 2017-09-15 15:25
     *@return
     */
    public static boolean equals(String str1, String str2) {
        return StringUtils.equals(str1, str2);
    }


    /**
     *@描述： 判断两个参数是否相同  忽略大小写
     *@author: wangjin
     *@date 2017-09-15 15:25
     *@return
     */
    public static boolean equalsIgnoreCase(String str1, String str2) {
        return StringUtils.equalsIgnoreCase(str1, str2);
    }

    /**
     *@描述： uid的生成
     *@author: wangjin
     *@date 2017-09-18 9:50
     *@return
     */
    public static String uid(){
        DateFormat df=new SimpleDateFormat("yyyyMMddHHmmss");
        return   UUID.randomUUID().toString().replaceAll("-", "").toUpperCase()+df.format(new Date());
    }

    /**
     *@描述： 生成当前时间戳
     *@author: wangjin
     *@date 2017-09-18 9:50
     *@return
     */
    public static String getTimeStamp() {
        Date date = new Date();
        DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
        return df.format(date);
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




    //获取Map集合对象
    public static Map<String, Object> getMapParams(Map<String, Object> map) throws Exception {
        Map<String, Object> searchMap = new HashMap<>();
        if (map!= null) {
            searchMap.putAll(map);
            StringUtil.paramTrim(map);
        }
        return searchMap;
    }

    /**
     *@描述：获取网络IP
     *@author: wangjin
     *@date 2017-10-24 10:56
     *@return
     */
    public static String getIpAddr(HttpServletRequest request){
        String ipAddress = request.getHeader("x-forwarded-for");
        if(ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("Proxy-Client-IP");
        }
        if(ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("WL-Proxy-Client-IP");
        }
        if(ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getRemoteAddr();
            if(ipAddress.equals("127.0.0.1") || ipAddress.equals("0:0:0:0:0:0:0:1")){
                //根据网卡取本机配置的IP
                InetAddress inet=null;
                try {
                    inet = InetAddress.getLocalHost();
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                }
                ipAddress= inet.getHostAddress();
            }
        }
        //对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
        if(ipAddress!=null && ipAddress.length()>15){ //"***.***.***.***".length() = 15
            if(ipAddress.indexOf(",")>0){
                ipAddress = ipAddress.substring(0,ipAddress.indexOf(","));
            }
        }
        return ipAddress;
    }







    public static void main(String[] args) {

        System.out.println(getRandomString(6));




    }


}
