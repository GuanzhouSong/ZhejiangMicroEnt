/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.drcheck.service;

import java.util.List;

import com.icinfo.cs.drcheck.dto.PubSctaskAgentDto;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:  cs_pub_sctask_agent 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2016年10月26日
 */
public interface IPubSctaskAgentService extends BaseService {

	/**
	 * 描述：分页查询已抽取执法人员列表
	 * @author chenxin
	 * @date 2016-11-07
	 * @param request
	 * @return
	 */
	public List<PubSctaskAgentDto> queryPubSctaskAgentDtoPage(PageRequest request)throws Exception;
	
	/**
	 * 描述：查询执法人员以逗号分开
	 * @author chenxin
	 * @date 2016-11-07
	 * @param request
	 * @return
	 */
	public String selectPubSctaskAgentDtoListToStr(String taskNO)throws Exception;

	/**
	 * 描述：通过主任务表taskNO清除已选中执法人员
     * @author chenxin
     * @date 2016-11-07
	 * @param taskNO
	 * @throws Exception
	 */
	public void cleanPubSctaskAgentByTaskNO(String taskNO);
	
	/**
	 * 描述：随机抽取执法人员
	 * @author chenxin
	 * @date 2016-11-07
	 * @param deptTaskNO
	 * @param taskNO
	 * @param total
	 * @param number
	 * @param scTypeWay
	 * @throws Exception
	 */
	public boolean randomPubSctaskAgentByTaskNO(String deptTaskNO,String taskNO,int total,int number,String scTypeWay,int groupAgentNumber)throws Exception;
	
	/**
	 * 描述：统计抽取执法人员
	 * @author chenxin
	 * @date 2016-11-07
	 * @param taskNO
	 * @throws Exception
	 */
	public int countPubSctaskAgentByTaskNO(String taskNO)throws Exception;
	
	/**
	 * 描述：将随机抽取的本次任务中的企业均匀分配给执法人员
	 * @author chenxin
	 * @date 2016-11-23
	 * @param taskNO
	 * @param deptTaskNO
	 * @throws Exception
	 */
	public boolean assignEntToAgent(String taskNO,String deptTaskNO,String scTypeWay,int groupAgentNumber)throws Exception;
}