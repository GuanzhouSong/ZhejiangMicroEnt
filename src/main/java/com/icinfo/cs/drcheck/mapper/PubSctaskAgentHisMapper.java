/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2016年10月26日
 * @version 2.0
 */
package com.icinfo.cs.drcheck.mapper;

import java.util.List;

import com.icinfo.cs.drcheck.model.PubSctaskAgentHis;
import com.icinfo.framework.mybatis.mapper.common.Mapper;

/**
 * 描述:  cs_pub_sctask_agent_his 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2016年10月26日
 */
public interface PubSctaskAgentHisMapper extends Mapper<PubSctaskAgentHis> {
	
	/**
	 * 描述:（排序后）批量插入历史记录表
	 * @author chenxin
	 * @date 2016-11-06
	 * @param list
	 */
	public int insertBatch(List<PubSctaskAgentHis> list);
	
	/**
	 * 描述：根据实施部门UID查询数据（排序）
	 * @author chenxin
	 * @date 2016-11-06
	 * @param request
	 * @return
	 */
	public List<PubSctaskAgentHis> selectOrderPubSctaskAgentBack(String taskNO);
}