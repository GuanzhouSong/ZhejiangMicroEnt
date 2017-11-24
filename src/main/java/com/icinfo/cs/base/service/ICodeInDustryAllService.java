/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.base.service;
import com.icinfo.framework.core.service.BaseService;
import java.util.List;
import java.util.Map;

/**
 * 描述:    cs_code_industry 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2016年10月17日
 */
public interface ICodeInDustryAllService extends BaseService {

    List<Map<String,Object>> selectToTreeMap();
    
}