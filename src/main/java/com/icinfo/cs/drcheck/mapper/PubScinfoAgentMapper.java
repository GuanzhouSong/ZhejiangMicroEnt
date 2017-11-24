/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2016年11月17日
 * @version 2.0
 */
package com.icinfo.cs.drcheck.mapper;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.drcheck.dto.PubScinfoAgentDto;
import com.icinfo.cs.drcheck.model.PubScinfoAgent;
import com.icinfo.framework.mybatis.mapper.common.Mapper;

/**
 * 描述:    cs_pub_scinfo_agent 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2016年11月17日
 */
public interface PubScinfoAgentMapper extends Mapper<PubScinfoAgent> {

	/**
	 * 描述:查询执法人员调整页面list数据
	 * @author yujingwei
	 * @date 2016-11-06
	 * @return PageResponse
	 * @throws Exception
	 */
	List<PubScinfoAgentDto> selectScagentAdjustList(Map<String, Object> params);

	/**
	 *描述：查询企业对应的执法人员
	 *@author chenxin
	 *@date 2016-11-24
	 * @param deptTaskNO
	 * @return
	 * @throws Exception
	 */
	List<PubScinfoAgentDto> selectPubScinfoAgentDto(Map<String, Object> params);
}