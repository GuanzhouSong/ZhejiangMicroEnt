/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2017年05月17日
 * @version 2.0
 */
package com.icinfo.cs.sccheck.mapper;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.sccheck.dto.PubScPlanTaskDto;
import com.icinfo.cs.sccheck.model.PubScPlanTask;
import com.icinfo.framework.mybatis.mapper.common.Mapper;

/**
 * 描述:    cs_pub_scplan_task 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2017年05月17日
 */
public interface PubScPlanTaskMapper extends Mapper<PubScPlanTask> {
	
	/**
	 * 
	 * 描述   分页查询
	 * @author 赵祥江
	 * @date 2017年5月18日 上午10:40:18 
	 * @param 
	 * @return List<PubScPlanTaskDto>
	 * @throws
	 */
	public List<PubScPlanTaskDto> selectPubScPlanTaskList(Map<String,Object> queryMap)throws Exception;

	/**
	 * 
	 * 描述   获取文号
	 * @author 赵祥江
	 * @date 2017年5月31日 下午5:51:28 
	 * @param 
	 * @return Integer
	 * @throws
	 */
	public Integer selectDocNumBydeptShortName(Map<String,Object> queryMap)throws Exception; 
	
	/**
	 * 
	 * 描述:检查人员随机收取任务列表
	 * @auther gaojinling
	 * @date 2017年5月19日 
	 * @param queryMap
	 * @return
	 * @throws Exception
	 */
	public List<PubScPlanTaskDto> selectPubScPlanTaskAndDeptList(Map<String,Object> queryMap)throws Exception;

	/**
	 * 
	 * 描述: 抽查任务情况统计
	 * @auther chenxin
	 * @date 2017年6月27日 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<PubScPlanTaskDto> selectScPlanTaskCount(Map<String, Object> parmMap);

	/**
	 * 
	 * 描述: 查询任务
	 * @auther chenxin
	 * @date 2017年6月27日 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<PubScPlanTask> selectTaskNames(Map<String, Object> parmMap);
    
	
	/**
	 * 
	 * 描述: 查询任务
	 * @auther chenxin
	 * @date 2017年6月27日 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<PubScPlanTask> selectTaskNamesByParams(Map<String, Object> parmMap);
	
	/**
	 * 描述  ：通过执法人员手机号查询任务列表
	 * @author yujingwei
	 * @date 2017年08月01日 
	 * @param parmMap
	 * @return List<PubScPlanTaskDto>
	 * @throws Exception
	 */
	public List<PubScPlanTaskDto> selectScentCheckTaskListForTz(Map<String, Object> parmMap);
    
	/**
	 * 描述  ：通过执法人员手机号查询任务个数总量
	 * @author yujingwei
	 * @date 2017年08月01日 
	 * @param parmMap
	 * @return Integer
	 * @throws Exception
	 */
	public Integer selectScentCheckTaskListTotalForTz(Map<String, Object> searchMap);
    
	/**
	 * 描述  ：通过任务uid查询抽查任务公告
	 * @author yujingwei
	 * @date 2017年08月01日 
	 * @param uID
	 * @return List<PubScPlanTaskDto> 
	 * @throws Exception
	 */
	public List<PubScPlanTaskDto> selectScentTaskForBulletin(String uID);
    
	/**
	 * 描述  ：查询检查人员待抽取任务数（首页待办事项）
	 * 
	 * @author yujingwei
	 * @date 2017年08月01日 
	 * @param sysUserDto
	 * @return Integer
	 * @throws Exception
	 */
	public Integer selectPubScPlanTaskToExtractCount(Map<String, Object> qryMap);
    
	/**
	 * 描述:抽查任务公告
	 * 
	 * @author yujingwei
	 * @date 2017-10-23
	 * @param request
	 * @return PageResponse
	 * @throws Exception
	 */
	public List<PubScPlanTaskDto> selectScPlanTaskForBulletin(Map<String, Object> params) throws Exception;
    
	/**
	 * 描述:抽查计划公告
	 * 
	 * @author yujingwei
	 * @date 2017-10-23
	 * @param request
	 * @return PageResponse
	 * @throws Exception
	 */
	public List<PubScPlanTaskDto> selectScWorkPlanForBulletin(Map<String, Object> params) throws Exception;
    
	/**
	 * 描述:抽查计划公告
	 * 
	 * @author yujingwei
	 * @date 2017-10-23
	 * @param request
	 * @return PageResponse
	 * @throws Exception
	 */
	public List<PubScPlanTaskDto> selectScResultForBulletin(Map<String, Object> params) throws Exception;

 	/**
 	 * 描述：查询最大国家局内部序号
 	 * @author chenxin
 	 * @date 2017-10-23
 	 * @param innerCodeLike
 	 * @return
 	 */
	public String selectMaxInnerCode(String innerCodeLike)throws Exception;

	/**
	  * 
	  * 描述   统计
	  * @author chenxin
	  * @date 2017年5月17日 上午11:15:46 
	  * @param queryMap
	  * @return PubScPlanTaskDto
	  * @throws
	  */
	public PubScPlanTaskDto selectCountAll(Map<String, Object> queryMap)throws Exception;
	
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