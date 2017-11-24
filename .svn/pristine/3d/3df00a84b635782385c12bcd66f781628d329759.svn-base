package com.icinfo.cs.sment.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * 请求处理的工具类
 * 
 * @author zhuyong
 */
public class RequestUtil {

	/**
	 * 获取http request对象
	 * 
	 * @return
	 */
	public static HttpServletRequest getRequest() {
		ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		return attrs.getRequest();
	}

	/**
	 * 获取http session对象
	 * 
	 * @return
	 */
	public static HttpSession getSession() {
		HttpSession session = null;
		try {
			return getRequest().getSession();
		} catch (Exception e) {
			return session;
		}
	}
}
