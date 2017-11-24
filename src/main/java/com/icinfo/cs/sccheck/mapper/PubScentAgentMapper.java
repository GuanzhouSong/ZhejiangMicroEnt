/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2017年05月19日
 * @version 2.0
 */
package com.icinfo.cs.sccheck.mapper;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.sccheck.dto.PubScentAgentDto;
import com.icinfo.cs.sccheck.model.PubScentAgent;
import com.icinfo.framework.mybatis.mapper.common.Mapper;

/**
 * 描述:    cs_pub_scent_agent 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2017年05月19日
 */
public interface PubScentAgentMapper extends Mapper<PubScentAgent> {

	/**
	 * 描述：查看企业匹配的执法人员
	 * @author chenxin
	 * @date 2017-05-22
	 * @param deptTaskUid
	 * @param priPID
	 * @return
	 * @throws Exception
	 */
	public List<String> selectEntAgents(Map<String, Object> params);

	/**
	 * 描述：查看企业匹配的执行部门
	 * @author baifangfang
	 * @date 2017-06-2
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public List<String> selectDeptNames(Map<String, Object> params);

	/**
	 * 描述：查询当前账号可以调整的企业对应执法人员的记录
	 * @author chenxin
	 * @date 2017-06-2 
	 * @param params
	 * @return
	 */
	public List<PubScentAgentDto> selectPubScentAgentDtoList(Map<String, Object> params);
	
	/**
	 * 描述：检查名单与人员查询
	 * @author chenxin
	 * @date 2017-06-2 
	 * @param params
	 * @return
	 */
	public List<PubScentAgentDto> selectSearchList(Map<String, Object> params);
	
	
	/**
	 * 
	 * 描述: 可视化检察人员统计
	 * @auther gaojinling
	 * @date 2017年11月8日 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<PubScentAgentDto> selectPubScentAgentChartsCount(Map<String, Object> map) throws Exception;
}