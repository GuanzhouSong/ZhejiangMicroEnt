/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.drcheck.service;

import java.util.List;

import com.icinfo.cs.drcheck.dto.PubSctaskAgentBackDto;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:  cs_pub_sctask_agent_back 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2016年10月26日
 */
public interface IPubSctaskAgentBackService extends BaseService {
	
	/**
	 * 描述：添加到执法人员back表
	 * @author chenxin
	 * @date 2016-11-06
	 * @param deptTaskUid
	 * @param uidList
	 * @return
	 */
	public boolean addSctaskAgentBackList(String deptTaskUid,List<String> uidList)throws Exception;
	
	/**
	 * 描述：删除bck
	 * @author chenxin
	 * @date 2016-11-06
	 * @param id
	 * @return
	 */
	public boolean delSctaskAgentBackById(int id)throws Exception;

	/**
	 * 描述：查询back数据
	 * @author chenxin
	 * @date 2016-11-06
	 * @param request
	 * @return
	 */
	public List<PubSctaskAgentBackDto> queryPubSctaskAgentBackDtoPage(PageRequest request);
	
	/**
	 * 描述：删除备份表
	 * @author chenxin
	 * @date 2016-11-06
	 * @param taskNO
	 * @return
	 */
	public void delSctaskAgentBackByTaskNO(String taskNO)throws Exception;
	
	/**
	 * 描述：数量
	 * @author chenxin
	 * @date 2016-11-07
	 * @param taskNO
	 * @throws Exception
	 */
	public int selectCountByTaskNO(String taskNO)throws Exception;
}