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
import java.util.Map;

import com.icinfo.cs.drcheck.dto.PubSctaskAgentBackDto;
import com.icinfo.cs.drcheck.model.PubSctaskAgentBack;
import com.icinfo.framework.mybatis.mapper.common.Mapper;

/**
 * 描述:  cs_pub_sctask_agent_back 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2016年10月26日
 */
public interface PubSctaskAgentBackMapper extends Mapper<PubSctaskAgentBack> {
	/**
	 * 描述： 批量插入
	 * @author chenxin
	 * @date 2016-11-04
	 * @param list
	 * @return
	 * @throws Exception
	 */
	public int insertBatch(List<PubSctaskAgentBack> list)throws Exception;

	/**
	 * 描述：查询待back列表数据
	 * @author chenxin
	 * @date 2016-11-06
	 * @param params
	 * @return
	 */
	public List<PubSctaskAgentBackDto> selectPubSctaskAgentBackDtoList(Map<String, Object> params);
}