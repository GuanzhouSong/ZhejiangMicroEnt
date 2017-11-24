package com.icinfo.cs.es.util;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import cn.gov.zj.gsj.v2.api.DefaultGsjClient;

@Component
public class EsGsClientFactory implements FactoryBean<DefaultGsjClient>{
	
	//服务器地址
	@Value("${es.gs.server.url}")
	private String serverUrl;
	
	// 要操作的数据库用户名
	@Value("${es.gs.username}")
	private String username;
	
	// 数据库密码
	@Value("${es.gs.password}")
	private String password;

	@Override
	public DefaultGsjClient getObject() throws Exception {
		return new DefaultGsjClient(serverUrl,username,password);
	}

	@Override
	public Class<?> getObjectType() {
		return DefaultGsjClient.class;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}

	public void setServerUrl(String serverUrl) {
		this.serverUrl = serverUrl;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
