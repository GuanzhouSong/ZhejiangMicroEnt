/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.webservice.service;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.webservice.model.WsPubOpanomaly;
import com.icinfo.framework.core.service.BaseService;

/**
 * 描述:    cs_pub_opanomaly 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2017年02月22日
 */
public interface IWsPubOpanomalyService extends BaseService {
	
	/**
     *  按照条件返回WsPubOpanomaly的列表
     * @param params
     * @author ylr
     * @return
     * @throws Exception
     */
    public List<WsPubOpanomaly> doGetWsPubOpanomalyListByContion(Map<String, Object> params) throws Exception;
    
    /**
     *  按照条件返回WsPubOpanomaly数量
     * @param params
     * @author ylr
     * @return
     * @throws Exception
     */
    public Integer doGetWsPubOpanomalyCountByContion(Map<String, Object> params) throws Exception;
    
    /**
     *  按照条件返回WsPubOpanomaly的maxId
     * @param params
     * @author ylr
     * @return
     * @throws Exception
     */
    public Integer doGetWsPubOpanomalyMaxId(Map<String, Object> params) throws Exception;
    
    /**
     *  按照条件返回WsPubOpanomaly的minId
     * @param params
     * @author ylr
     * @return
     * @throws Exception
     */
    public Integer doGetWsPubOpanomalyMinId(Map<String, Object> params) throws Exception;
    
    
}