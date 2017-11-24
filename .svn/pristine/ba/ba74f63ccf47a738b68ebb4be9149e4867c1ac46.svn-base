/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.webservice.service.impl;
import com.icinfo.cs.webservice.mapper.WsMidAltitemMapper;
import com.icinfo.cs.webservice.model.WsMidAltitem;
import com.icinfo.cs.webservice.service.IWsMidAltitemService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:    cs_mid_altitem 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年02月17日
 */
@Service
public class WsMidAltitemServiceImpl extends MyBatisServiceSupport implements IWsMidAltitemService {
	
	/**
	 * 日志记录器
	 */
	private static final Logger logger = LoggerFactory.getLogger(WsMidAltitemServiceImpl.class);
	
	@Autowired
	private WsMidAltitemMapper wsMidAltitemMapper;
	
	/**
     *  按照条件返回WsMidAltitem的列表
     * @param params
     * @author ylr
     * @return
     * @throws Exception
     */
    public List<WsMidAltitem> doGetWsMidAltitemListByContion(Map<String, Object> params) throws Exception{
		return wsMidAltitemMapper.selectWsMidAltitemListByContion(params);
    }
    
    /**
     *  按照条件返回WsMidAltitem数量
     * @param params
     * @author ylr
     * @return
     * @throws Exception
     */
    public Integer doGetWsMidAltitemCountByContion(Map<String, Object> params) throws Exception{
    	return wsMidAltitemMapper.selectWsMidAltitemCountByContion(params);
    }
    
    /**
     *  按照条件返回WsMidAltitem--最大id
     * @param params
     * @author ylr
     * @return
     * @throws Exception
     */
    public Integer doGetWsMidAltitemMaxId(Map<String, Object> params) throws Exception{
    	return wsMidAltitemMapper.selectWsMidAltitemMaxId(params);
    }
    
    /**
     *  按照条件返回WsMidAltitem--最小id
     * @param params
     * @author ylr
     * @return
     * @throws Exception
     */
    public Integer doGetWsMidAltitemMinId(Map<String, Object> params) throws Exception{
    	return wsMidAltitemMapper.selectWsMidAltitemMinId(params);
    }
}