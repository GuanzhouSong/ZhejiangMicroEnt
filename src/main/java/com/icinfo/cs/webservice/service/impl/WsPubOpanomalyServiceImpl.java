/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.webservice.service.impl;

import com.icinfo.cs.webservice.mapper.WsPubOpanomalyMapper;
import com.icinfo.cs.webservice.model.WsPubOpanomaly;
import com.icinfo.cs.webservice.service.IWsPubOpanomalyService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:    cs_pub_opanomaly 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年02月22日
 */
@Service
public class WsPubOpanomalyServiceImpl extends MyBatisServiceSupport implements IWsPubOpanomalyService {
	/**
	 * 日志记录器
	 */
	private static final Logger logger = LoggerFactory.getLogger(WsPubOpanomalyServiceImpl.class);
	
	@Autowired
	private WsPubOpanomalyMapper wsPubOpanomalyMapper;
	
	/**
     *  按照条件返回WsPubOpanomaly的列表
     * @param params
     * @author ylr
     * @return
     * @throws Exception
     */
    public List<WsPubOpanomaly> doGetWsPubOpanomalyListByContion(Map<String, Object> params) throws Exception{
		return wsPubOpanomalyMapper.selectWsPubOpanomalyListByContion(params);
    }
    
    /**
     *  按照条件返回WsPubOpanomaly数量
     * @param params
     * @author ylr
     * @return
     * @throws Exception
     */
    public Integer doGetWsPubOpanomalyCountByContion(Map<String, Object> params) throws Exception{
    	return wsPubOpanomalyMapper.selectWsPubOpanomalyCountByContion(params);
    }
    
    /**
     *  按照条件返回WsPubOpanomaly的maxId
     * @param params
     * @author ylr
     * @return
     * @throws Exception
     */
    public Integer doGetWsPubOpanomalyMaxId(Map<String, Object> params) throws Exception{
    	return wsPubOpanomalyMapper.selectWsPubOpanomalyMaxId(params);
    }
    
    /**
     *  按照条件返回WsPubOpanomaly的minId
     * @param params
     * @author ylr
     * @return
     * @throws Exception
     */
    public Integer doGetWsPubOpanomalyMinId(Map<String, Object> params) throws Exception{
    	return wsPubOpanomalyMapper.selectWsPubOpanomalyMinId(params);
    }
}