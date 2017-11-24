/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.specialrec.service;

import java.util.List;

import com.icinfo.cs.specialrec.dto.SpecialRecTaskDto;
import com.icinfo.cs.specialrec.model.SpecialRecTask;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_special_rec_task 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2017年11月01日
 */
public interface ISpecialRecTaskService extends BaseService {
    
	/**
	 * 描述：查询专项整治任务列表
	 *
	 * @author yujingwei
	 * @date 2017年10月27日
	 * @param request
	 * @return pageResponse
	 * @throws Exception
	 */
	public List<SpecialRecTaskDto> querySpecialrecTaskList(PageRequest request) throws Exception;

	/**
	 * 描述：保存专项整治任务信息
	 * 
	 * @author yujingwei
	 * @date 2017年11月01日
	 * @param specialRecTask
	 * @return AjaxResult
	 * @throws Exception
	 */
	public boolean doCommitSpecialRecTaskInfo(SpecialRecTask specialRecTask,SysUserDto sysUser) throws Exception;
    
	/**
	 * 描述：通过uid查询检查任务信息
	 * 
	 * @author yujingwei
	 * @date 2017年11月01日
	 * @param recTaskUid
	 * @return SpecialRecTask
	 * @throws Exception
	 */
	public SpecialRecTask selectSpecialRecTaskInfoByUid(String recTaskUid) throws Exception;
    
	/**
	 * 描述：通过uid删除检查任务信息
	 * 
	 * @author yujingwei
	 * @date 2017年11月01日
	 * @param recTaskUid
	 * @return int
	 * @throws Exception
	 */
	public int doDelSpecialRecTaskInfo(String recTaskUid) throws Exception;
    
	/**
	 * 描述：生成最大序号
	 * 
	 * @author yujingwei
	 * @date 2017年11月01日
	 * @param docShortName
	 * @return int
	 * @throws Exception
	 */
	public Integer selectDocNumBydeptShortName(String docShortName, int parseInt) throws Exception;
    
	/**
	 * 描述：通过任务名称查询
	 * 
	 * @author yujingwei
	 * @date 2017年11月01日
	 * @param taskName
	 * @return List
	 * @throws Exception
	 */
	public List<SpecialRecTask> selectSpecialRecTaskInfoByTaskName(String taskName) throws Exception;
    
	/**
	 * 描述：任务个数统计
	 * 
	 * @author yujingwei
	 * @date 2017年11月01日
	 * @param request
	 * @return SpecialRecTaskDto
	 * @throws Exception
	 */
	public SpecialRecTaskDto selectSpecialRecTaskInfoForCount(PageRequest request) throws Exception;
}