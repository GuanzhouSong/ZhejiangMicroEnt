/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.registmanage.service;

import java.util.List;

import com.icinfo.cs.registmanage.dto.InvManagerCount;
import com.icinfo.cs.registmanage.dto.InvManagerDto;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述: cs_inv_manager 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2017年11月22日
 */
public interface IInvManagerService extends BaseService {

	/**
	 * 
	 * 描述：公示出资到期管理json数据
	 * 
	 * @author baifangfang
	 * @date 2017年11月22日
	 * @param request
	 * @return
	 */
	List<InvManagerDto> selectLicenceInvalidMgrJSON(PageRequest request);

	/**
	 * 描述：公示出资到期管理数据统计
	 * @author baifangfang
	 * @date 2017年11月22日
	 * @param request
	 * @return
	 */
	InvManagerCount queryInvManagerCount(PageRequest request);

	InvManagerCount selectYrinfo(String priPID) throws Exception;
}