/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.webservice.service.impl;

import com.icinfo.cs.webservice.mapper.WsMidLerepMapper;
import com.icinfo.cs.webservice.model.WsMidLerep;
import com.icinfo.cs.webservice.service.IWsMidLerepService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:    cs_mid_lerep 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年02月16日
 */
@Service
public class WsMidLerepServiceImpl extends MyBatisServiceSupport implements IWsMidLerepService {
	/**
	 * 日志记录器
	 */
	private static final Logger logger = LoggerFactory.getLogger(WsMidLerepServiceImpl.class);
	
	@Autowired
	private WsMidLerepMapper wsMidLerepMapper;
	
	/**
     *  按照条件返回WsMidLerep的列表
     * @param params
     * @author ylr
     * @return
     * @throws Exception
     */
    public List<WsMidLerep> doGetWsMidLerepListByContion(Map<String, Object> params) throws Exception{
		return wsMidLerepMapper.selectWsMidLerepListByContion(params);
    }
    
    /**
     *  按照条件返回WsMidLerep数量
     * @param params
     * @author ylr
     * @return
     * @throws Exception
     */
    public Integer doGetWsMidLerepCountByContion(Map<String, Object> params) throws Exception{
    	return wsMidLerepMapper.selectWsMidLerepCountByContion(params);
    }
    
    /**
     *  按照条件返回WsMidLerep的MaxId
     * @param params
     * @author ylr
     * @return
     * @throws Exception
     */
    public Integer doGetWsMidLerepMaxId(Map<String, Object> params) throws Exception{
    	return wsMidLerepMapper.selectWsMidLerepMaxId(params);
    }
    
    /**
     *  按照条件返回WsMidLerep的MinId
     * @param params
     * @author ylr
     * @return
     * @throws Exception
     */
    public Integer doGetWsMidLerepMinId(Map<String, Object> params) throws Exception{
    	return wsMidLerepMapper.selectWsMidLerepMinId(params);
    }
}