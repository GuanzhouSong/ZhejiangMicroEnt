/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2017年05月20日
 * @version 2.0
 */
package com.icinfo.cs.sccheck.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.icinfo.cs.sccheck.dto.PubScentAgentBackDto;
import com.icinfo.cs.sccheck.model.PubScentAgentBack;
import com.icinfo.framework.mybatis.mapper.common.Mapper;

/**
 * 描述:    cs_pub_scent_agent_back 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2017年05月20日
 */
public interface PubScentAgentBackMapper extends Mapper<PubScentAgentBack> {
	
	
	/**
	 * 
	 * 描述: 查询当前部门任务下待抽取人员库列表 
	 * @auther gaojinling
	 * @date 2017年5月20日 
	 * @param params
	 * @return
	 */
	public List<PubScentAgentBackDto> selectPubScentAgentBackDtoList(Map<String, Object> params);
	
	/**
	 * 
	 * 描述: 查询总数
	 * @auther gaojinling
	 * @date 2017年5月26日 
	 * @param params
	 * @return
	 */
	public int selectPubScentAgentBackDtoCount(Map<String, Object> params);
	
	
	/**
	 * 
	 * 描述: 根据部门人员id和任务id批量删除
	 * @auther gaojinling
	 * @date 2017年5月21日 
	 * @param deptTaskUid
	 * @param agentUIds
	 * @throws Exception
	 */
	public void deleteInAgentUIdAndDeptTaskUid(@Param("deptTaskUid") String deptTaskUid,@Param("agentUIds")String agentUIds) throws Exception;

	 /**
		 * 描述：查询待抽检库执法人员数量
		 * @author chenxin
		 * @date 2017-08-25
		 * @param params
		 * @return
		 */
	public int SelectCountByDeptTaskUid(Map<String, Object> params);
}