/*
 * Copyright? 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.dzdtinfo.service;

import java.util.List;

import com.icinfo.cs.dzdtinfo.model.HzDzhyHscyry;
import com.icinfo.framework.core.service.BaseService;

/**
 * 描述:    CS_HZ_DZHY_HSCYRY 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2017年06月14日
 */
public interface IHzDzhyHscyryService extends BaseService {
	/**
	 * 
	 * 描述   根据主体身份代码查询
	 * @author 赵祥江
	 * @date 2017年6月15日 下午3:08:54 
	 * @param 
	 * @return HzDzhyHscyry
	 * @throws
	 */
	public List<HzDzhyHscyry> selectHzDzhyHscyryByPriPid(String priPid)throws Exception;

}