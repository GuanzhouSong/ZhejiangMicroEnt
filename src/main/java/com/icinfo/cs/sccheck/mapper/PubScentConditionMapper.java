/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2017年05月17日
 * @version 2.0
 */
package com.icinfo.cs.sccheck.mapper;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.sccheck.dto.PubScentConditionDto;
import com.icinfo.cs.sccheck.model.PubScentCondition;
import com.icinfo.framework.mybatis.mapper.common.Mapper;

/**
 * 描述:    cs_pub_scent_condition 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2017年05月17日
 */
public interface PubScentConditionMapper extends Mapper<PubScentCondition> {

	/**
	 * 描述：统计待抽检库结果
	 * @author chenxin
     * @date 2017-05-17
	 * @param request
	 * @return List<PubScentConditionDto>
	 * @throws Exception
	 */
	public List<PubScentConditionDto> selectPubScentConditionDtoList(Map<String, Object> params);
}