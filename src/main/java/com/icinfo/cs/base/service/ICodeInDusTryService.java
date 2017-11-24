/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.base.service;

import com.icinfo.cs.base.model.CodeInDusTry;
import com.icinfo.framework.core.service.BaseService;

import java.util.List;
import java.util.Map;

/**
 * 描述:    cs_code_industry 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2016年10月17日
 */
public interface ICodeInDusTryService extends BaseService {
	/**
	 * 
	 * 描述   根据行业编码查询
	 * @author 赵祥江
	 * @date 2016年10月17日 下午7:22:34 
	 * @param 
	 * @return CodeInDusTry
	 * @throws
	 */
	public CodeInDusTry selectCodeInDusTryByCode(String code) throws Exception;

    public List<Map<String,Object>> selectToTreeMap(Map<String, Object> map);
    
	/**
	 * 获取小微企业行业树json
	 * @return
	 */
	public List<Map<String, Object>> selectToSmTreeMap(Map<String,Object> map);
}