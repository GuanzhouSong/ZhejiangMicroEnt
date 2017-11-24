package com.icinfo.cs.common.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sgs.service.ServiceClient;

@Component("RestFulClient")
public class RestFulClient {
    
	@Autowired
	ServiceClient client;
	
	
	/**
	 * 调用远程服务(简易注销调用接口)
	 * @author yujingwei
	 * @param  parameterForSend
	 * @return string
	 */
	public  String callRemoteService(String parameterForSend) {
		return client.callRemoteService("SimpleWriteOff", parameterForSend);
	}
	
	/**
	 * 调用远程服务（司法协助调用接口）
	 * @author yujingwei
	 * @param  parameterForSend
	 * @return string
	 */
	public  String callRemoteForEquityFreezeService(String parameterForSend) {
		return client.callRemoteService("EquityFreeze", parameterForSend);
	}
	
	/**
	 * 调用远程服务(判断是否含有电子营业执照)
	 * @author yujingwei
	 * @param  parameterForSend
	 * @return string
	 */
	public  String callRemoteForBusinessLicService(String parameterForSend) {
		return client.callRemoteService("QcdzWsdjData", parameterForSend);
	}
}
