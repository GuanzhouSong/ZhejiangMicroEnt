/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.pbapp.service.impl;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.icinfo.framework.cache.CacheTemplate;

/**
 * 描述:   个体年报App.<br>
 *
 * @author framework generator
 * @date 2017年01月18日
 */
@Service
public class RedisManager  {

	@Resource(name="cacheTemplate")
	private CacheTemplate<String, String> cacheTemplate;
	
	//App 用户端token
	public static final String APP_TOKEN_KEY ="appUserToken";
	//App 用户端token
	public static final int APP_TOKEN_Timeout = 1800;
	
	//redis模板实现类
	@Resource(name="cacheTemplate")
	private CacheTemplate<String, List<Integer>> cacheListTemplate;
	
	//警示端统计token
	public static final String REG_COUNT_TOKEN_KEY ="regCountToken";
	//警示端统计token延时时间
	public static final int REG_COUNT_TOKEN_TIMEOUT = 3600;

	/**
	 * 
	 * 描述: 生成app端token
	 * @auther gaojinling
	 * @date 2017年3月3日 
	 * @param clientToken
	 * @param userId
	 * @throws Exception
	 */
	public void setClientToken(String appUserToken, String tel) throws Exception{
		cacheTemplate.set(APP_TOKEN_KEY+appUserToken, tel, APP_TOKEN_Timeout);
	}
	
	/**
	 * 
	 * 描述: 根据tokenkey的得到对应的value
	 * @auther gaojinling
	 * @date 2017年3月3日 
	 * @param clientToken
	 * @param userId
	 * @throws Exception
	 */
	public String getClientToken(String appUserToken) throws Exception{
		//如果key还存在
		if(cacheTemplate.hasKey(APP_TOKEN_KEY+appUserToken)){
			cacheTemplate.set(APP_TOKEN_KEY+appUserToken,cacheTemplate.get(APP_TOKEN_KEY+appUserToken),APP_TOKEN_Timeout);
		}
//		System.out.println(cacheTemplate.get(APP_TOKEN_KEY+appUserToken));
		return cacheTemplate.get(APP_TOKEN_KEY+appUserToken) == null ? "" :cacheTemplate.get(APP_TOKEN_KEY+appUserToken).toString();
	}
	
	
	/**
	 * 
	 * 描述: 删除app端token
	 * @auther gaojinling
	 * @date 2017年3月3日 
	 * @param appUserToken
	 * @throws Exception
	 */
	public void deleteClientToken(String appUserToken) throws Exception{
		cacheTemplate.delete(APP_TOKEN_KEY + appUserToken);
	}
	
	
	
	
    /**
     * 
     * 描述: 生成警示端首页统计token
     * @auther gaojinling
     * @date 2017年3月20日 
     * @param appUserToken
     * @param tel
     * @throws Exception
     */
	public void setCountToken(String userid, List<Integer> countList) throws Exception{
		cacheListTemplate.set(REG_COUNT_TOKEN_KEY+userid, countList, REG_COUNT_TOKEN_TIMEOUT);
	}
	
	
    /**
     * 
     * 描述: 根据用户id 获取
     * @auther gaojinling
     * @date 2017年3月20日 
     * @param userid
     * @return
     * @throws Exception
     */
	public List<Integer> getCountToken(String userid) throws Exception{
		//如果key还存在
		if(cacheListTemplate.hasKey(REG_COUNT_TOKEN_KEY+userid)){
			cacheListTemplate.set(REG_COUNT_TOKEN_KEY+userid,cacheListTemplate.get(REG_COUNT_TOKEN_KEY+userid),REG_COUNT_TOKEN_TIMEOUT);
		}
		return cacheListTemplate.get(REG_COUNT_TOKEN_KEY+userid);
	}
	
	
	/**
	 * 
	 * 描述: 删除警示首页端的统计token
	 * @auther gaojinling
	 * @date 2017年3月20日 
	 * @param userid
	 * @throws Exception
	 */
	public void deleteCountToken(String userid) throws Exception{
		cacheListTemplate.delete(REG_COUNT_TOKEN_KEY + userid);
	} 
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
}