/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.ext.service;

import java.util.List;

import com.icinfo.cs.ext.dto.MidBranchDto;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_mid_branch 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2016年10月20日
 */
public interface IMidBranchService extends BaseService {

	/**
	 * 描述：根据priPID查询分支机构信息JSON数据列表
	 * @author baifangfang
	 * @date 2016年10月20日
	 * @param request
	 * @return
	 */
	List<MidBranchDto> queryPageResult(PageRequest request);

	/**
	 * 描述：根据priPID查询分支机构信息list数据列表
	 * @author baifangfang
	 * @date 2016年10月25日
	 * @param priPID
	 * @return
	 */
	List<MidBranchDto> queryListResult(String priPID);
    
	/**
	 * 描述：查询分支机构信息list数据列表（全景）
	 * @author yujingwei
	 * @date 2017年3月17日
	 * @param request
	 * @return List<MidBranchDto>
	 */
	List<MidBranchDto> queryListResult(PageRequest request);
}