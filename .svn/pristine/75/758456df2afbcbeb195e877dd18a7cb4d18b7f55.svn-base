
package com.icinfo.cs.common.utils;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import java.net.InetAddress;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;


/**
 * 描述: 请求工具类
 *
 * @author ZhouYan
 * @date 2016年9月12日
 */
public class RequestUtil {

    private static final Logger logger = Logger.getLogger(RequestUtil.class);


    /**
     * 描述: 获取IP地址
     *
     * @param request
     * @return
     * @auther ZhouYan
     * @date 2016年9月12日
     */
    public static String getIpAddress(HttpServletRequest request) {
        if (request != null) {
            String ipAddress = request.getHeader("X-Forwarded-For");
            if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
                ipAddress = request.getHeader("Proxy-Client-IP");
            }
            if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
                ipAddress = request.getHeader("WL-Proxy-Client-IP");
            }
            if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
                ipAddress = request.getHeader("X-Real-IP");
            }
            if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
                ipAddress = request.getRemoteAddr();
            }
            return ipAddress;
        } else {
            return "";
        }
    }

    /**
     * 获取Http请求参数
     *
     * @param request http请求
     * @return 参数map集合
     */
    public static Map<String, Object> getHttpRequestParams(HttpServletRequest request) {
        Map<String, Object> tempMap = new HashMap<>();
        Enumeration enuParam = request.getParameterNames();
        while (enuParam.hasMoreElements()) {
            String paramName = (String) enuParam.nextElement();
            String[] arrParamValue = request.getParameterValues(paramName);
            String paramValue = StringUtil.arrToString(arrParamValue, ",");
            // 过滤掉空值
            if (paramValue != null && paramValue.length() > 0) {
                tempMap.put(paramName, paramValue);
            }
        }
        return tempMap;
    }
    
    
    /**
     * 获取服务器内网ip
     * 
     * @author zhuyong
     * @return
     */
    public static String getServerIpAddress() {
    	try {
    		String ip = "" + InetAddress.getLocalHost();
    		return (ip.length() > 100 ) ? ip.substring(0, 100) : ip;
		} catch (Exception e) {
			return "get error ip !";
		}
    }
    
}
