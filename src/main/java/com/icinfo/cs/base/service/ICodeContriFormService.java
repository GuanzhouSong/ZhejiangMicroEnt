/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.base.service;

import java.util.List;

import com.icinfo.cs.base.model.CodeContriForm;
import com.icinfo.framework.core.service.BaseService;

/**
 * 描述:    cs_code_contriform 对应的Service接口.<br>
 * 出资方式
 * @author framework generator   
 * @date 2016年08月30日
 */
public interface ICodeContriFormService extends BaseService {
	/**
	 * 
	 * 描述             : 根据编码获取出资方式对象
	 * @author: 赵祥江
	 * @date  : 2016年8月30日 下午12:30:26 
	 * @param :
	 * @return: CodeContriForm
	 * @throws
	 */
	public CodeContriForm selectCodeContriFormByCode(String code);
	
	/**
	 * 
	 * 描述             : 获取所有的出资方式
	 * @author: 赵祥江
	 * @date  : 2016年8月30日 下午12:47:45 
	 * @param :
	 * @return: List<CodeContriForm>
	 * @throws
	 */
	public List<CodeContriForm>  selectAllCodeContriForm();
}