/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.simpleesc.service;

import java.util.List;

import com.icinfo.cs.simpleesc.dto.ErEscObjinfoDto;
import com.icinfo.cs.simpleesc.model.ErEscObjinfo;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    er_esc_objinfo 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2017年02月13日
 */
public interface IErEscObjinfoService extends BaseService {

	/**
	 * 描述：根据priPID查询异议信息JSON数据列表
	 *
	 * @author baifangfang
	 * @date 2017年2月13日
	 * @param request
	 * @return
	 * @throws Exception
	 */
	List<ErEscObjinfoDto> queryPageResult(PageRequest request);

	/**
	 * 描述：保存异议信息
	 *
	 * @author baifangfang
	 * @date 2017年2月15日
	 * @param erEscObjinfo
	 * @return
	 * @throws Exception
	 */
	int saveErEscObjinfo(ErEscObjinfo erEscObjinfo);

	/**
	 * 描述：删除异议信息
	 *
	 * @author baifangfang
	 * @date 2017年2月17日
	 * @param erEscObjinfo
	 * @return
	 * @throws Exception
	 */
	int deleteErEscObjinfo(ErEscObjinfoDto erEscObjinfo);
}