/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.sccheck.service;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.sccheck.dto.PubScWorkPlanDto;
import com.icinfo.cs.sccheck.model.PubScWorkPlan;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_pub_scwork_plan 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2017年05月17日
 */
public interface IPubScWorkPlanService extends BaseService {
	
	/**
	 * 
	 * 描述   保存
	 * @author 赵祥江
	 * @date 2017年5月17日 上午9:34:19 
	 * @param 
	 * @return int
	 * @throws
	 */
	public int insertPubScWorkPlan(PubScWorkPlan pubScWorkPlan) throws Exception;
	
	/**
	 * 
	 * 描述   根据uid查询
	 * @author 赵祥江
	 * @date 2017年5月17日 上午9:40:00 
	 * @param 
	 * @return PubScWorkPlan
	 * @throws
	 */
	public PubScWorkPlan selectPubScWorkPlanByUid(String uid) throws Exception;
	
	/**
	 * 
	 * 描述   根据活动名称查询
	 * @author 赵祥江
	 * @date 2017年5月17日 下午3:44:18 
	 * @param 
	 * @return List<PubScWorkPlan>
	 * @throws
	 */
	public List<PubScWorkPlan> selectPubScWorkPlanByPlanName(String planName) throws Exception;
	
	/**
	 * 
	 * 描述   根据主键uid更新
	 * @author 赵祥江
	 * @date 2017年5月17日 上午9:40:32 
	 * @param 
	 * @return int
	 * @throws
	 */
	public int updatePubScWorkPlanByUid(PubScWorkPlan pubScWorkPlan) throws Exception;
	
	/**
	 * 
	 * 描述   根据uid删除
	 * @author 赵祥江
	 * @date 2017年5月17日 上午9:41:20 
	 * @param 
	 * @return int
	 * @throws
	 */
	public int deletePubScWorkPlanByUid(String uid) throws Exception;
	
	/**
	 * 
	 * 描述   分页查询工作计划
	 * @author 赵祥江
	 * @date 2017年5月17日 上午9:44:21 
	 * @param 
	 * @return List<PubScWorkPlanDto>
	 * @throws
	 */
	public List<PubScWorkPlanDto> queryPubScWorkPlanListJSON(PageRequest request)throws Exception;
	
	 /**
	  * 
	  * 描述   统计
	  * @author chenxin
	  * @date 2017年5月17日 上午11:15:46 
	  * @param queryMap
	  * @return PubScWorkPlanDto
	  * @throws
	  */
	 public PubScWorkPlanDto selectCountAll(Map<String,Object> queryMap)throws Exception ;
}