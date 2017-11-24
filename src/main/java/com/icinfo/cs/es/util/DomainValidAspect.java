package com.icinfo.cs.es.util;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.icinfo.cs.common.utils.StringUtil;

/**
 * @author baifangfang
 */
@Aspect
@Component
public class DomainValidAspect {

	@Autowired
	HttpServletRequest request;

	@Before("@annotation(DomainSecurity)")
	public void beforPoint(JoinPoint pjp) throws Exception {
		String refer = request.getHeader("Referer");
		if (!StringUtil.isEmpty(refer)) {
			if (refer.indexOf("localhost") > 0 || refer.indexOf("192.168.") > 0 || refer.indexOf("zj.gsxt.gov") > 0
					|| refer.indexOf("118.178.118") > 0 || refer.indexOf("gsxt.zjaic.gov") > 0
					|| refer.indexOf("127.0.0.1") > 0 || refer.indexOf("114.215.249.228") > 0
					|| refer.indexOf("114.215.249.229") > 0 || refer.indexOf("search.idinfo.cn") > 0) {

			} else {
				throw new Exception("illegal request");
			}
		}
	}
}
