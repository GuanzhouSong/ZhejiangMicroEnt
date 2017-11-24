/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.webservice.service.impl;

import com.icinfo.cs.webservice.mapper.WsPubOpadetailMapper;
import com.icinfo.cs.webservice.model.WsPubOpadetail;
import com.icinfo.cs.webservice.service.IWsPubOpadetailService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:    cs_pub_opadetail 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年02月22日
 */
@Service
public class WsPubOpadetailServiceImpl extends MyBatisServiceSupport implements IWsPubOpadetailService {
	/**
	 * 日志记录器
	 */
	private static final Logger logger = LoggerFactory.getLogger(WsPubOpadetailServiceImpl.class);
	
	@Autowired
	private WsPubOpadetailMapper wsPubOpadetailMapper;
	
	/**
     *  按照条件返回WsPubOpadetail的列表
     * @param params
     * @author ylr
     * @return
     * @throws Exception
     */
    public List<WsPubOpadetail> doGetWsPubOpadetailListByContion(Map<String, Object> params) throws Exception{
		return wsPubOpadetailMapper.selectWsPubOpadetailListByContion(params);
    }
    
    /**
     *  按照条件返回WsPubOpadetail数量
     * @param params
     * @author ylr
     * @return
     * @throws Exception
     */
    public Integer doGetWsPubOpadetailCountByContion(Map<String, Object> params) throws Exception{
    	return wsPubOpadetailMapper.selectWsPubOpadetailCountByContion(params);
    }
    
    /**
     *  按照条件返回WsPubOpadetail的maxId
     * @param params
     * @author ylr
     * @return
     * @throws Exception
     */
    public Integer doGetWsPubOpadetailMaxId(Map<String, Object> params) throws Exception{
    	return wsPubOpadetailMapper.selectWsPubOpadetailMaxId(params);
    }
    
    /**
     *  按照条件返回WsPubOpadetail的minId
     * @param params
     * @author ylr
     * @return
     * @throws Exception
     */
    public Integer doGetWsPubOpadetailMinId(Map<String, Object> params) throws Exception{
    	return wsPubOpadetailMapper.selectWsPubOpadetailMinId(params);
    }
}