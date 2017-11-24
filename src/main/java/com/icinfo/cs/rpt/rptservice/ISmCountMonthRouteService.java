/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.rpt.rptservice;

import com.alibaba.fastjson.JSONObject;
import com.icinfo.cs.rpt.rptmodel.SmCountMonthRoute;
import com.icinfo.framework.core.service.BaseService;

import java.util.List;

/**
 * 描述:    sm_count_month_route 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2017年06月15日
 */
public interface ISmCountMonthRouteService extends BaseService {

	/**
	 * 在测数据
	 * 
	 * @return
	 * @throws Exception
	 */
    public JSONObject selectAllByZC() throws  Exception;
    
    /**
     * 新设数据
     * 
     * @return
     * @throws Exception
     */
    public JSONObject selectAllByXS() throws  Exception;
    
    /**
     * 注销数据
     * 
     * @return
     * @throws Exception
     */
    public JSONObject selectAllByZX() throws  Exception;

}