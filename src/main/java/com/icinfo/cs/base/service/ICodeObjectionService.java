/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.base.service;

import java.util.List;

import com.icinfo.cs.base.model.CodeObjection;
import com.icinfo.framework.core.service.BaseService;

/**
 * 描述: cs_code_objection 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2017年02月13日
 */
public interface ICodeObjectionService extends BaseService {

	/**
	 * 描述：获取异议内容编码列表
	 * 
	 * @author baifangfang
	 * @date 2017-02-14
	 * @return
	 */
	List<CodeObjection> findListResultAll();
	
	/**
	 * 
	 * 描述   根据编码获取异议内容
	 * @author 赵祥江
	 * @date 2017年3月7日 下午4:35:45 
	 * @param 
	 * @return CodeObjection
	 * @throws
	 */
	CodeObjection findCodeObjectionByCode(String code);
}