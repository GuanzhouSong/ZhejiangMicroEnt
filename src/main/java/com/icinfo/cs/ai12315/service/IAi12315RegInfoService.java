/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.ai12315.service;

import java.util.List;

import com.icinfo.cs.ai12315.dto.Ai12315RegInfoDto;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_ai_12315_reg_info 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2017年11月06日
 */
public interface IAi12315RegInfoService extends BaseService {
	/**
	 * 
	 * 描述   根据企业主体代码查询登记信息
	 * @author 赵祥江
	 * @date 2017年11月7日 下午3:36:18 
	 * @param 
	 * @return List<Ai12315RegInfoDto>
	 * @throws
	 */
	public List<Ai12315RegInfoDto>  selectAi12315RegInfoDtoListByPriPID(String priPID) throws Exception;

	/**
	 * 
	 * 描述   根据企业主体代码查询登记信息(分页)
	 * @author 赵祥江
	 * @date 2017年11月7日 下午4:07:04 
	 * @param 
	 * @return List<Ai12315RegInfoDto>
	 * @throws
	 */
	public List<Ai12315RegInfoDto>  selectAi12315RegInfoDtoList(PageRequest request) throws Exception;
}