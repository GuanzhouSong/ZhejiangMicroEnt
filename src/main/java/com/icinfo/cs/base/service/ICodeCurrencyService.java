/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.base.service;

import com.icinfo.cs.base.model.CodeCurrency;
import com.icinfo.framework.core.service.BaseService;

/**
 * 描述:    cs_code_currency 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2016年09月24日
 */
public interface ICodeCurrencyService extends BaseService {
	/**
	 * 
	 * 描述   根据编码获取币种
	 * @author 赵祥江
	 * @date 2016年9月24日 下午3:11:55 
	 * @param 
	 * @return CodeCurrency
	 * @throws
	 */
	public CodeCurrency selectCodeCurrencyByCode(String code);
}