/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.drcheck.service;

import java.util.List;

import com.icinfo.cs.drcheck.model.PubSctaskAgentHis;
import com.icinfo.framework.core.service.BaseService;

/**
 * 描述:  cs_pub_sctask_agent_his 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2016年10月26日
 */
public interface IPubSctaskAgentHisService extends BaseService {
	/**
	 * 描述：根据实施部门UID查询数据（排序）
	 * @author chenxin
	 * @date 2016-11-06
	 * @param request
	 * @return
	 */
	public List<PubSctaskAgentHis> selectOrderPubSctaskAgentBack(String taskNO);
	
	/**
	 * 描述：批量插入记录
	 * @author chenxin
	 * @date 2016-11-07
	 * @param list
	 * @throws Exception
	 */
	public void insertBatch(List<PubSctaskAgentHis> list)throws Exception;
	
	/**
	 * 描述：删除
	 * @author chenxin
	 * @date 2016-11-07
	 * @param taskNO
	 * @throws Exception
	 */
	public int deleteByTaskNO(String taskNO)throws Exception;
	
	/**
	 * 描述：数量
	 * @author chenxin
	 * @date 2016-11-07
	 * @param taskNO
	 * @throws Exception
	 */
	public int selectCountByTaskNO(String taskNO)throws Exception;
}