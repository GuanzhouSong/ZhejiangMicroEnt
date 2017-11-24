/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.specialrec.service;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.specialrec.dto.SpecialRecResultDto;
import com.icinfo.cs.specialrec.model.SpecialRecResult;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_special_rec_result 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2017年11月02日
 */
public interface ISpecialRecResultService extends BaseService {
    
	/**
	 * 描述：查询专项整治结果列表
	 *
	 * @author yujingwei
	 * @date 2017年10月27日
	 * @param request
	 * @return pageResponse
	 * @throws Exception
	 */
	public List<SpecialRecResultDto> querySpecialrecResultList(PageRequest request) throws Exception;
    
	/**
	 * 描述：通过任务Id查询结果信息
	 *
	 * @author yujingwei
	 * @date 2017年10月27日
	 * @param recTaskUid
	 * @return List
	 * @throws Exception
	 */
	public List<SpecialRecResult> selectSpecialRecResultInfoByTaskUid(String recTaskUid);
    
	/**
	 * 描述：通过uid查询结果信息
	 *
	 * @author yujingwei
	 * @date 2017年10月27日
	 * @param resultUid
	 * @return List
	 * @throws Exception
	 */
	public SpecialRecResultDto selectSpecialRecResultDtoInfo(String resultUid) throws Exception;
    
	/**
	 * 描述：检查结果录入修改
	 * 
	 * @author yujingwei
	 * @param sysUser 
	 * @param commitWay 
	 * @date 2017年11月03日
	 * @return
	 * @throws Exception
	 */
	public int doEnterRecResultInfo(Map<String, Object> map, SysUserDto sysUser, String commitWay) throws Exception;
    
	/**
	 * 描述：查询专项整治录入完结个数
	 *
	 * @author yujingwei
	 * @date 2017年10月27日
	 * @param request
	 * @return pageResponse
	 * @throws Exception
	 */
	public SpecialRecResultDto selectSpecialRecResultDtoForCount(PageRequest request) throws Exception;
    
	/**
	 * 描述：名单指派
	 *
	 * @author yujingwei
	 * @date 2017年10月27日
	 * @param uids
	 * @param appointLocalAdm
	 * @return pageResponse
	 * @throws Exception
	 */
	public boolean doAppointEnts(String uids, String appointLocalAdm,SysUserDto sysUserDto) throws Exception;
}