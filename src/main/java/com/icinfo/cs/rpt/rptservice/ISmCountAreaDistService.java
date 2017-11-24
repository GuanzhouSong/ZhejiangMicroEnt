/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.rpt.rptservice;

import com.alibaba.fastjson.JSONArray;
import com.icinfo.cs.rpt.rptmodel.SmCountAreaDist;
import com.icinfo.framework.core.service.BaseService;

import java.util.List;

/**
 * 描述:    sm_count_area_dist 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2017年06月15日
 */
public interface ISmCountAreaDistService extends BaseService {

    public JSONArray selectAll() throws Exception;
}