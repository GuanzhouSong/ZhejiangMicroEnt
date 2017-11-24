/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.webservice.service.impl;

import com.icinfo.cs.webservice.mapper.WsMidSupMapper;
import com.icinfo.cs.webservice.model.WsMidSup;
import com.icinfo.cs.webservice.service.IWsMidSupService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:    cs_mid_sup 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年02月17日
 */
@Service
public class WsMidSupServiceImpl extends MyBatisServiceSupport implements IWsMidSupService {
	/**
	 * 日志记录器
	 */
	private static final Logger logger = LoggerFactory.getLogger(WsMidSupServiceImpl.class);
	
	@Autowired
	private WsMidSupMapper wsMidSupMapper;
	
	/**
     *  按照条件返回WsMidSup的列表
     * @param params
     * @author ylr
     * @return
     * @throws Exception
     */
    public List<WsMidSup> doGetWsMidSupListByContion(Map<String, Object> params) throws Exception{
		return wsMidSupMapper.selectWsMidSupListByContion(params);
    }
    
    /**
     *  按照条件返回WsMidSup数量
     * @param params
     * @author ylr
     * @return
     * @throws Exception
     */
    public Integer doGetWsMidSupCountByContion(Map<String, Object> params) throws Exception{
    	return wsMidSupMapper.selectWsMidSupCountByContion(params);
    }
    

    /**
     *  按照条件返回WsMidSup的maxId
     * @param params
     * @author ylr
     * @return
     * @throws Exception
     */
    public Integer doGetWsMidSupMaxId(Map<String, Object> params) throws Exception{
    	return wsMidSupMapper.selectWsMidSupMaxId(params);
    }
    
    /**
     *  按照条件返回WsMidSup的minId
     * @param params
     * @author ylr
     * @return
     * @throws Exception
     */
    public Integer doGetWsMidSupMinId(Map<String, Object> params) throws Exception{
    	return wsMidSupMapper.selectWsMidSupMinId(params);
    }
}