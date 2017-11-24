/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.sccheck.service;

import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import com.icinfo.cs.sccheck.dto.PubScPlanTaskDto;
import com.icinfo.cs.sccheck.model.PubScPlanTask;
import com.icinfo.cs.sccheck.model.PubSccheckType;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_pub_scplan_task 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2017年05月17日
 */
public interface IPubScPlanTaskService extends BaseService {
	
	/**
	 * 
	 * 描述   保存
	 * @author 赵祥江
	 * @date 2017年5月17日 上午9:34:19 
	 * @param 
	 * @return int
	 * @throws
	 */
	public int insertPubScPlanTask(PubScPlanTask pubScPlanTask) throws Exception;
	
	/**
	 * 
	 * 描述   根据uid查询
	 * @author 赵祥江
	 * @date 2017年5月17日 上午9:40:00 
	 * @param 
	 * @return PubScPlanTask
	 * @throws
	 */
	public PubScPlanTask selectPubScPlanTaskByUid(String uid) throws Exception;
	
	/**
	 * 
	 * 描述   根据主键uid更新
	 * @author 赵祥江
	 * @date 2017年5月17日 上午9:40:32 
	 * @param 
	 * @return int
	 * @throws
	 */
	public int updatePubScPlanTaskByUid(PubScPlanTask PubScPlanTask) throws Exception;
	
	
	/**
	 * 
	 * 描述   锁定任务
	 * @author 陈鑫
	 * @date 2017年5月17日 上午9:40:32
	 * @param 
	 * @return int
	 * @throws
	 */
	public boolean lockPubScPlanTaskByUid(SysUserDto sysUser,String taskUid) throws Exception;
	
	/**
	 * 
	 * 描述   根据uid删除
	 * @author 赵祥江
	 * @date 2017年5月17日 上午9:41:20 
	 * @param 
	 * @return int
	 * @throws
	 */
	public int deletePubScPlanTaskByUid(String uid) throws Exception;
	
	/**
	 * 
	 * 描述   分页查询工作计划
	 * @author 赵祥江
	 * @date 2017年5月17日 上午9:44:21 
	 * @param 
	 * @return List<PubScPlanTaskDto>
	 * @throws
	 */
	public List<PubScPlanTaskDto> queryPubScPlanTaskListJSON(PageRequest request)throws Exception;
	
	/**
	 * 
	 * 描述   根据任务名称查询
	 * @author 赵祥江
	 * @date 2017年5月18日 上午10:21:29 
	 * @param 
	 * @return List<PubScPlanTask>
	 * @throws
	 */
	public List<PubScPlanTask> selectPubScPlanTaskByTaskName(String taskName)throws Exception;
	
	/**
	 * 
	 * 描述   根据任务编号查询
	 * @author 陈鑫
	 * @date 2017年5月18日 上午10:21:29 
	 * @param 
	 * @return List<PubScPlanTask>
	 * @throws
	 */
	public List<PubScPlanTask> selectPubScPlanTaskByTaskCode(String taskCode)throws Exception;
	
	
	/**
	 * 
	 * 描述   获取所有检查事项
	 * @author 赵祥江
	 * @date 2017年5月18日 下午4:35:16 
	 * @param 
	 * @return List<PubSccheckType>
	 * @throws
	 */
	public List<PubSccheckType> queryPubSccheckTypeListJSON(PageRequest request)throws Exception;
	
	/**
	 * 
	 * 描述:检查人员随机收取任务列表
	 * @auther gaojinling
	 * @date 2017年5月19日 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<PubScPlanTaskDto> selectPubScPlanTaskAndDeptList(PageRequest request) throws Exception;
	
	
	/**
	 * 
	 * 描述   获取文号
	 * @author 赵祥江
	 * @date 2017年5月31日 下午5:48:42 
	 * @param 
	 * @return Integer
	 * @throws
	 */
	public Integer selectDocNumBydeptShortName(String deptShortName,Integer seqYear) throws Exception;
	
	
	/**
	 * 
	 * 描述:单个任务抽取情况
	 * @auther gaojinling
	 * @date 2017年5月19日 
	 * @param sysUser
	 * @return
	 * @throws Exception
	 */
	public PubScPlanTaskDto selectPubScPlanTaskAndDeptListNotPage(String taskuid,SysUserDto sysUser) throws Exception;

	/**
	 * 
	 * 描述: 抽查任务情况统计
	 * @auther chenxin
	 * @date 2017年6月27日 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<PubScPlanTaskDto> selectScPubScPlanTaskCount(PageRequest request)throws Exception;

	/**
	 * 
	 * 描述: 查询任务
	 * @auther chenxin
	 * @date 2017年6月27日 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<PubScPlanTask> selectTaskNames(String deptCodeLike);
    
	/**
	 * 
	 * 描述: 查询任务
	 * @auther chenxin
	 * @date 2017年6月27日 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<PubScPlanTask> selectTaskNamesByParams(Map<String,Object> params);
	
	/**
	 * 描述  ：查询任务列表(台州双随机接口)
	 * @author yujingwei
	 * @date 2017年08月01日 
	 * @param moduleid，userCode，pageNo，pageSize
	 * @return JSONObject
	 * @throws Exception
	 */
	public JSONObject doGetScentCheckTaskListForTz(String moduleid, String userCode, int pageNo, int pageSize) throws Exception;
    
	/**
	 * 描述  ：查询任务详情(台州双随机接口)
	 * @author yujingwei
	 * @param pageNo 
	 * @date 2017年08月01日 
	 * @param userCode，apprivalid，moduleid
	 * @return JSONObject
	 * @throws Exception
	 */
	public JSONObject doGetScentCheckTaskDetailsForTz(String userCode, String apprivalid, String moduleid) throws Exception;
    
	/**
	 * 描述  ：查询任务个数(台州双随机接口)
	 * @author yujingwei
	 * @date 2017年08月01日 
	 * @param userCode
	 * @return JSONObject
	 * @throws Exception
	 */
	public JSONObject doGetScentCheckTaskTotalForTz(String userCode) throws Exception;
    
	/**
	 * 描述  ：查询检查人员待抽取任务数（首页待办事项）
	 * 
	 * @author yujingwei
	 * @date 2017年08月01日 
	 * @param userCode
	 * @return JSONObject
	 * @throws Exception
	 */
	public Integer selectPubScPlanTaskToExtractCount(SysUserDto sysUserDto) throws Exception;
     
	/**
	 * 描述:抽查任务公告
	 * 
	 * @author yujingwei
	 * @date 2017-10-23
	 * @param request
	 * @return List<PubScPlanTaskDto>
	 * @throws Exception
	 */
	public List<PubScPlanTaskDto> selectScPlanTaskForBulletin(PageRequest request) throws Exception;
    
	/**
	 * 描述:抽查计划公告
	 * 
	 * @author yujingwei
	 * @date 2017-10-23
	 * @param request
	 * @return List<PubScPlanTaskDto>
	 * @throws Exception
	 */
	public List<PubScPlanTaskDto> selectScWorkPlanForBulletin(PageRequest request) throws Exception;
	
	/**
	 * 描述:抽查结果公告
	 * 
	 * @author yujingwei
	 * @date 2017-10-23
	 * @param uID
	 * @return List<PubScPlanTaskDto>
	 * @throws Exception
	 */
	public List<PubScPlanTaskDto> selectScResultForBulletin(PageRequest request) throws Exception;
    
	/**
	 * 描述:公告详情
	 * 
	 * @author yujingwei
	 * @date 2017-10-23
	 * @param uID
	 * @return List<PubScPlanTaskDto>
	 * @throws Exception
	 */
	public List<PubScPlanTaskDto> selectScentTaskForBulletin(String uID) throws Exception;

	 /**
	  * 
	  * 描述   统计
	  * @author chenxin
	  * @date 2017年5月17日 上午11:15:46 
	  * @param queryMap
	  * @return PubScPlanTaskDto
	  * @throws
	  */
	public PubScPlanTaskDto selectCountAll(Map<String, Object> queryMap) throws Exception;
	
	/**
	 * 
	 * 描述: 可视化抽查任务统计
	 * @auther gaojinling
	 * @date 2017年11月8日 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<PubScPlanTaskDto> selectScPlanTaskChartsCount(Map<String, Object> map)throws Exception;
}