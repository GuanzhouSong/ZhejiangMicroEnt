/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.webservice.service.impl;

import com.icinfo.cs.webservice.mapper.WsMidInvMapper;
import com.icinfo.cs.webservice.model.WsMidInv;
import com.icinfo.cs.webservice.service.IWsMidInvService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:    cs_mid_inv 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年02月16日
 */
@Service
public class WsMidInvServiceImpl extends MyBatisServiceSupport implements IWsMidInvService {
	/**
	 * 日志记录器
	 */
	private static final Logger logger = LoggerFactory.getLogger(WsMidInvServiceImpl.class);
	
	@Autowired
	private WsMidInvMapper wsMidInvMapper;
	
	/**
     *  按照条件返回WsMidInv的列表
     * @param params
     * @author ylr
     * @return
     * @throws Exception
     */
    public List<WsMidInv> doGetWsMidInvListByContion(Map<String, Object> params) throws Exception{
		return wsMidInvMapper.selectWsMidInvListByContion(params);
    }
    
    /**
     *  按照条件返回WsMidInv数量
     * @param params
     * @author ylr
     * @return
     * @throws Exception
     */
    public Integer doGetWsMidInvCountByContion(Map<String, Object> params) throws Exception{
    	return wsMidInvMapper.selectWsMidInvCountByContion(params);
    }
    
    /**
     *  按照pripid条件返回WsMidInv的列表
     * @param pripid
     * @author ylr
     * @return
     * @throws Exception
     */
    public List<WsMidInv> doGetWsMidInvListByPripid(String pripid) throws Exception{
    	return wsMidInvMapper.selectWsMidInvCountByPripid(pripid);
    }
    
    /**
     *  按照条件返回WsMidInv的MaxId
     * @param params
     * @author ylr
     * @return
     * @throws Exception
     */
    public Integer doGetWsMidInvMaxId(Map<String, Object> params) throws Exception{
    	return wsMidInvMapper.selectWsMidInvMaxId(params);
    }
    /**
     *  按照条件返回WsMidInv的MinId
     * @param params
     * @author ylr
     * @return
     * @throws Exception
     */
    public Integer doGetWsMidInvMinId(Map<String, Object> params) throws Exception{
    	return wsMidInvMapper.selectWsMidInvMinId(params);
    }
}