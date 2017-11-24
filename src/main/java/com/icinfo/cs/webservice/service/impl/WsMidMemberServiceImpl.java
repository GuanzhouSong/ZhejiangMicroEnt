/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.webservice.service.impl;

import com.icinfo.cs.webservice.mapper.WsMidMemberMapper;
import com.icinfo.cs.webservice.model.WsMidMember;
import com.icinfo.cs.webservice.service.IWsMidMemberService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:    cs_mid_member 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年02月17日
 */
@Service
public class WsMidMemberServiceImpl extends MyBatisServiceSupport implements IWsMidMemberService {
	
	/**
	 * 日志记录器
	 */
	private static final Logger logger = LoggerFactory.getLogger(WsMidMemberServiceImpl.class);
	
	@Autowired
	private WsMidMemberMapper wsMidMemberMapper;
	
	/**
     *  按照条件返回WsMidMember的列表
     * @param params
     * @author ylr
     * @return
     * @throws Exception
     */
    public List<WsMidMember> doGetWsMidMemberListByContion(Map<String, Object> params) throws Exception{
		return wsMidMemberMapper.selectWsMidMemberListByContion(params);
    }
    
    /**
     *  按照条件返回WsMidMember数量
     * @param params
     * @author ylr
     * @return
     * @throws Exception
     */
    public Integer doGetWsMidMemberCountByContion(Map<String, Object> params) throws Exception{
    	return wsMidMemberMapper.selectWsMidMemberCountByContion(params);
    }
    
    /**
     *  按照pripid条件返回WsMidMember的列表
     * @param pripid
     * @author ylr
     * @return
     * @throws Exception
     */
    public List<WsMidMember> doGetWsMidMemberListByPripid(String pripid) throws Exception{
    	return wsMidMemberMapper.selectWsMidMemberListByPripid(pripid);
    }
    
    /**
     *  按照条件返回WsMidMember的maxID
     * @param params
     * @author ylr
     * @return
     * @throws Exception
     */
    public Integer doGetWsMidMemberMaxId(Map<String, Object> params) throws Exception{
    	return wsMidMemberMapper.selectWsMidMemberMaxId(params);
    }
    
    /**
     *  按照条件返回WsMidMember的minId
     * @param params
     * @author ylr
     * @return
     * @throws Exception
     */
    public Integer doGetWsMidMemberMinId(Map<String, Object> params) throws Exception{
    	return wsMidMemberMapper.selectWsMidMemberMinId(params);
    }
}