/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.casesource.service;

import java.util.List;

import com.icinfo.cs.casesource.dto.CaseSourceInfoDto;
import com.icinfo.cs.casesource.model.CaseSourceInfo;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_case_source_info 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2017年11月23日
 */
public interface ICaseSourceInfoService extends BaseService {
    
	/**
	 * 描述：查询案源管理列表
	 *
	 * @author yujingwei
	 * @date 2017年10月27日
	 * @param request
	 * @return List
	 * @throws Exception
	 */
	public List<CaseSourceInfoDto> queryCaseSourceInfoList(PageRequest request) throws Exception;
    
	/**
	 * 描述：通过uid查询案源信息
	 *
	 * @author yujingwei
	 * @date 2017年10月27日
	 * @param uid
	 * @return CaseSourceInfo
	 * @throws Exception
	 */
	public CaseSourceInfo doGetCaseSourceInfoByUid(String uid) throws Exception;
	
	/**
	 * 描述：通过uid删除案源信息
	 *
	 * @author yujingwei
	 * @date 2017年10月27日
	 * @param uid
	 * @return int
	 * @throws Exception
	 */
	public int deleteCaseSourceInfoByUid(String uid) throws Exception;
    
	/**
	 * 描述：保存或修改案源信息
	 * 
	 * @author yujingwei
	 * @date 2017年3月8日 
	 * @param request
	 * @throws Exception
	 */
	public boolean doSaveCaseSourceInfo(CaseSourceInfo caseSourceInfo,SysUserDto sysUser) throws Exception;
}