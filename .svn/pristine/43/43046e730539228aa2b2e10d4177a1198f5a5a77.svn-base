/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.simpleesc.service;

import java.util.List;

import com.icinfo.cs.simpleesc.dto.ErEscScrinfoDto;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    er_esc_scrinfo 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2017年02月13日
 */
public interface IErEscScrinfoService extends BaseService {

	/**
	 * 描述：根据priPID查询简易注销结果信息JSON数据列表
	 *
	 * @author baifangfang
	 * @date 2017年2月13日
	 * @param request
	 * @return
	 * @throws Exception
	 */
	List<ErEscScrinfoDto> queryPageResult(PageRequest request);

	/**
	 * 描述：简易注销索引全量更新
	 *
	 * @author baifangfang
	 * @date 2017年2月20日
	 * @return
	 * @throws Exception
	 */
	void simpleEscUpdate();
	
	
	/**
	 * 
	 * 描述   分页查询简易注销结果
	 * @author 赵祥江
	 * @date 2017年2月21日 下午3:34:16 
	 * @param 
	 * @return List<ErEscScrinfoDto>
	 * @throws
	 */
	List<ErEscScrinfoDto> queryErEscScrinfoPageResult(PageRequest request);

	/**
	 * 描述：查询简易注销结果信息
	 * @author baifangfang
	 * @date 2017年9月27日
	 * @param priPID
	 * @return
	 */
	ErEscScrinfoDto getErEscScByPriPID(String priPID);
}