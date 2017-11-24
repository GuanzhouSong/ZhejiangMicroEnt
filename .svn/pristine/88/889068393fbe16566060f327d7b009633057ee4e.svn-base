/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2016年09月24日
 * @version 2.0
 */
package com.icinfo.cs.yr.mapper;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.yr.dto.IndividQueMainDto;
import com.icinfo.cs.yr.model.IndividQueMain;
import com.icinfo.framework.mybatis.mapper.common.Mapper;

/**
 * 描述:    cs_individ_quemain 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2016年09月24日
 */
public interface IndividQueMainMapper extends Mapper<IndividQueMain> {

	List<IndividQueMain> selectQueMainInfo(Map<String, Object> params);

	/**
	 * 描述：个转企调查表统计按增长率
	 * @author baifangfang
	 * @date 2017年4月24日
	 * @param params
	 * @return
	 */
	IndividQueMainDto selectQueMainCount(Map<String, Object> params);

	/**
	 * 描述：个转企调查表统计按调查量
	 * @author baifangfang
	 * @date 2017年4月26日
	 * @param request
	 * @return
	 */
	List<IndividQueMainDto> selectSurQuantity(Map<String, Object> params);
}