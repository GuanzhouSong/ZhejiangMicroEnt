package com.icinfo.cs.common.utils;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.icinfo.cs.pbapp.service.impl.TokenManager;
import com.icinfo.cs.sment.mapper.SmLogMapper;
import com.icinfo.cs.sment.service.ISmLogService;
import com.icinfo.cs.sment.service.impl.SmLogServiceImpl;
import com.icinfo.cs.system.mapper.SysLogMapper;
import com.icinfo.cs.system.service.IRegIndexService;
import com.icinfo.cs.system.service.ISysLogService;
import com.icinfo.cs.system.service.ISysUserService;
import com.icinfo.cs.system.service.impl.RegIndexServiceImpl;
import com.icinfo.cs.system.service.impl.SysLoginServiceImpl;
import com.icinfo.cs.yr.service.IDepartMentService;
import com.icinfo.cs.yr.service.impl.DepartMentServiceImpl;

/**  
 * Copyright 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 统一用户登录工具类
 * @author: 赵祥江 
 * @date: 2017年6月9日 下午3:37:15
 * @version: V1.0  
 */
public class SysUnifiedServiceUtil implements ApplicationContextAware{
 	 static ApplicationContext 	 ctx =null; /*new ClassPathXmlApplicationContext("/entry/dev/spring-entry.xml");*/// 读取bean.xml中的内容  
	 
//	 ISysUserService sysUserService = (ISysUserService) ctx.getBean(SysUserServiceImpl.class);
//	 IDepartMentService departMentService = (IDepartMentService) ctx.getBean(DepartMentServiceImpl.class); 
//	 ISysLogService sysLogService = (ISysLogService) ctx.getBean(SysLogServiceImpl.class);
//	 IRegIndexService regIndexService = (IRegIndexService) ctx.getBean(RegIndexServiceImpl.class);
//	 ShiroSecurityService csSysLoginService = (ShiroSecurityService) ctx.getBean(SysLoginServiceImpl.class);
//	 TokenManager tokenManager = (TokenManager) ctx.getBean(TokenManager.class); 
// TokenManager regIndexService = (TokenManager) ctx.getBean(TokenManager.class); 
// ShiroSecurityService csSysLoginService; 
	  
	public SysLogMapper getSysLogMapper() {
		return (SysLogMapper) ctx.getBean(SysLogMapper.class);
	} 
	 

	public IDepartMentService getDepartMentService() {
		return (IDepartMentService) ctx.getBean(DepartMentServiceImpl.class);
	}
	
	public SmLogMapper getSmLogMapper() {
		return (SmLogMapper) ctx.getBean(SmLogMapper.class);
	}

	public TokenManager getTokenManager() {
		return (TokenManager) ctx.getBean(TokenManager.class);
	}

	public ISysLogService getSysLogService() { 
		return (ISysLogService) ctx.getBean(SysLoginServiceImpl.class);
	}

	public IRegIndexService getRegIndexService() {
		return (IRegIndexService) ctx.getBean(RegIndexServiceImpl.class);
	}

	public   ISysUserService getSysUserService() {
		return (ISysUserService) ctx.getBean("sysUserService");
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException { 
		SysUnifiedServiceUtil.ctx=applicationContext;
	}
	
}
