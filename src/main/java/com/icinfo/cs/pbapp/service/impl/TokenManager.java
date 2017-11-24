/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.pbapp.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icinfo.cs.common.utils.StringUtil;

/**
 * 描述:   token管理器.<br>
 *
 * @author framework generator
 * @date 2017年01月18日
 */
@Service
public class TokenManager  {
	
	@Autowired
	private RedisManager redisManager;

	
	
    /**
     * 
     * 描述: apptoken检查是否存在
     * @auther gaojinling
     * @date 2017年3月3日 
     * @param clientToken
     * @return
     * @throws Exception
     */
	public String getClientTokenValue(String appToken) throws Exception {
		// 1.appToken是否为空
		if (StringUtil.isBlank(appToken)) {
			return null;
		}

		// 2.redis缓存中是否有当前用户缓存信息
		return redisManager.getClientToken(appToken);
	}
	
	/**
	 * 
	 * 描述: 生成App端Token .
	 * @auther gaojinling
	 * @date 2017年3月3日 
	 * @param tel
	 * @return
	 * @throws Exception
	 */
	public String generateClientToken(String tel) throws Exception{
		// 1.缓存app端Token和用户的对应关系
		String clientToken = StringUtil.uuid();
		redisManager.setClientToken(clientToken, tel);
		return clientToken;
	}
	


	/**
	 * 
	 * 描述: 删除app端token-
	 * @auther gaojinling
	 * @date 2017年3月3日 
	 * @param appToken
	 * @throws Exception
	 */
	public void deleteClientToken(String appToken) throws Exception{
		redisManager.deleteClientToken(appToken);
	}
	
	
	



	/**
	 * 
	 * 描述:用用户id获取警示首页端统计token
	 * @auther gaojinling
	 * @date 2017年3月21日 
	 * @param userid
	 * @return
	 * @throws Exception
	 */
	public List<Integer> getRegCountList(String userid) throws Exception {
		if (StringUtil.isBlank(userid)) {
			return null;
		}

		return redisManager.getCountToken(userid);
	}
	
	/**
	 * 
	 * 描述: 生成警示首页端统计token
	 * @auther gaojinling
	 * @date 2017年3月21日 
	 * @param userid
	 * @param countList
	 * @throws Exception
	 */
	public void setRegCountToken(String userid,List<Integer> countList) throws Exception{
		redisManager.setCountToken(userid, countList);
	}
	


	/**
	 * 
	 * 描述: 删除警示首页端的token
	 * @auther gaojinling
	 * @date 2017年3月21日 
	 * @param appToken
	 * @throws Exception
	 */
	public void deleteRegCountToken(String userid) throws Exception{
		redisManager.deleteCountToken(userid);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
		
}