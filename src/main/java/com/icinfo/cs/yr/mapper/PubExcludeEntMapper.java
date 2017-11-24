/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2016年08月30日
 * @version 2.0
 */
package com.icinfo.cs.yr.mapper;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.yr.dto.PubExcludeEntDto;
import com.icinfo.cs.yr.model.PubExcludeEnt;
import com.icinfo.framework.mybatis.mapper.common.Mapper;

/**
 * 描述: cs_pub_excludeent 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2016年08月30日
 */
public interface PubExcludeEntMapper extends Mapper<PubExcludeEnt> {

	/**
	 * 描述：获取未进入限制公示的企业名单列表
	 * 
	 * @author baifangfang
	 * @date 2016年9月10日
	 * @param params
	 * @return
	 */
	List<PubExcludeEntDto> selectNotPubExcludeEntResult(Map<String, Object> params);

	/**
	 * 描述：获取限制公示企业名单列表
	 * 
	 * @author baifangfang
	 * @date 2016年9月11日
	 * @param params
	 * @return
	 */
	List<PubExcludeEntDto> selectPubExcludeEntResult(Map<String, Object> params);

}