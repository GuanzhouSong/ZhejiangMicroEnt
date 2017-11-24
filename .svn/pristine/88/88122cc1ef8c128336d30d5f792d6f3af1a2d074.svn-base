package com.icinfo.cs.common.utils;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.sgs.service.ServiceClient;

@Component
public class ServiceClientFactory implements FactoryBean<ServiceClient>{
	
	@Value("${esc.appCode}")
	private  String appCode;// 应用名称

	@Value("${esc.userName}")
	private  String userName;// AIC服务的登录账户
	
	@Value("${esc.passWord}")
	private  String passWord;// AIC服务的登录密码
	
	@Value("${esc.serverIp}")
	private String serverIp;// AIC服务IP
	
	@Value("${esc.caches}")
	private String caches;// 缓存集群的地址
	
	@Value("${cloudModel}")
	private String cloudModel;//云模式
    
	@Override
	public ServiceClient getObject() throws Exception {
		if("Y".equals(cloudModel)){
			return new ServiceClient(appCode, userName, passWord, serverIp, caches);
		}
		return null;
	}

	@Override
	public Class<?> getObjectType() {
		return ServiceClient.class;
	}

	@Override
	public boolean isSingleton() {
		// TODO Auto-generated method stub
		return true;
	}

	public String getAppCode() {
		return appCode;
	}

	public void setAppCode(String appCode) {
		this.appCode = appCode;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getServerIp() {
		return serverIp;
	}

	public void setServerIp(String serverIp) {
		this.serverIp = serverIp;
	}

	public String getCaches() {
		return caches;
	}

	public void setCaches(String caches) {
		this.caches = caches;
	}
	
	
}
