/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.service;

import java.util.Date;

import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.framework.core.service.BaseService;

/** 
 * 描述: 年报提交Service接口
 * @author ZhouYan
 * @date 2016年9月14日  
 */
public interface IYrCommitService extends BaseService {

	/** 
	 * 描述: 提交年报
	 * @auther ZhouYan
	 * @date 2016年9月23日 
	 * @param pripid
	 * @param year
	 * @param loginType
	 * @param subIp
	 * @throws Exception 
	 */
	void doCommitYearReport(String pripid, Integer year, String loginType, String subIp, String repType, String entTypeCatg) throws Exception;
	
	/**
	 * 
	 * 描述: 个体户纸质补录
	 * @auther gaojinling
	 * @date 2017年3月9日 
	 * @param pripid
	 * @param year
	 * @param curDate
	 * @param sysUser
	 * @throws Exception
	 */
	public void doCommitPbaddRecInfo(String pripid, String year, Date curDate,SysUserDto sysUser) throws Exception ;

}