/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.drcheck.service;

import java.util.List;

import com.icinfo.cs.drcheck.dto.PubScinfoAgentDto;
import com.icinfo.cs.drcheck.model.PubScinfoAgent;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_pub_scinfo_agent 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2016年11月17日
 */
public interface IPubScinfoAgentService extends BaseService {
    
	/**
	 * 描述:查询执法人员调整页面list数据
	 * @author yujingwei
	 * @date 2016-11-06
	 * @return PageResponse
	 * @throws Exception
	 */
	public List<PubScinfoAgentDto> selectScagentAdjustList(PageRequest request) throws Exception;
	
	/**
	 *描述：插入执法人员对应企业表
	 *@author chenxin
	 *@date 2016-11-23
	 * @param pubScinfoAgent
	 * @return
	 * @throws Exception
	 */
	public int savePubScinfoAgent(PubScinfoAgent pubScinfoAgent)throws Exception;
	
	/**
	 *描述：清空执法人员对应企业表
	 *@author chenxin
	 *@date 2016-11-23
	 * @param deptTaskNO
	 * @param taskNO
	 * @return
	 * @throws Exception
	 */
	public void cleanPubScinfoAgent(String deptTaskNO,String taskNO)throws Exception;
	
	/**
	 *描述：查询企业对应的执法人员
	 *@author chenxin
	 *@date 2016-11-24
	 * @param deptTaskNO
	 * @param taskNO
	 * @param priPID
	 * @return
	 * @throws Exception
	 */
	public String selectPubScinfoAgentDto(String deptTaskNO,String taskNO,String priPID)throws Exception;
    
	/**
	 * 描述:执法人员调整
	 * @author yujingwei
	 * @date 2016-11-06
	 * @param adjustUid,agentUids
	 * @return boolean
	 * @throws Exception
	 */
	public boolean doAdjustScagent(String adjustUid, String agentUids) throws Exception;
}