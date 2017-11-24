/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.webservice.service;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.webservice.model.WsMidMember;
import com.icinfo.framework.core.service.BaseService;

/**
 * 描述:    cs_mid_member 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2017年02月17日
 */
public interface IWsMidMemberService extends BaseService {
	
	
	/**
     *  按照条件返回WsMidMember的列表
     * @param params
     * @author ylr
     * @return
     * @throws Exception
     */
    public List<WsMidMember> doGetWsMidMemberListByContion(Map<String, Object> params) throws Exception;
    
    /**
     *  按照条件返回WsMidMember数量
     * @param params
     * @author ylr
     * @return
     * @throws Exception
     */
    public Integer doGetWsMidMemberCountByContion(Map<String, Object> params) throws Exception;
    
    /**
     *  按照pripid条件返回WsMidMember的列表
     * @param pripid
     * @author ylr
     * @return
     * @throws Exception
     */
    public List<WsMidMember> doGetWsMidMemberListByPripid(String pripid) throws Exception;
    
    /**
     *  按照条件返回WsMidMember的maxID
     * @param params
     * @author ylr
     * @return
     * @throws Exception
     */
    public Integer doGetWsMidMemberMaxId(Map<String, Object> params) throws Exception;
    
    /**
     *  按照条件返回WsMidMember的minId
     * @param params
     * @author ylr
     * @return
     * @throws Exception
     */
    public Integer doGetWsMidMemberMinId(Map<String, Object> params) throws Exception;
    
}