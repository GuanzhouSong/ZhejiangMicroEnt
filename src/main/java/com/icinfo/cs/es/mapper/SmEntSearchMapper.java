/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2017年05月03日
 * @version 2.0
 */
package com.icinfo.cs.es.mapper;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.es.dto.SmEntSearchDto;
import com.icinfo.cs.es.model.SmEntSearch;
import com.icinfo.framework.mybatis.mapper.common.Mapper;

/**
 * 描述:    sm_ent_search 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2017年05月03日
 */
public interface SmEntSearchMapper extends Mapper<SmEntSearch> {
	/**
	 * 描述：获取小微企业信息最大id
	 * @author baifangfang
	 * @date 2017年5月3日
	 * @return
	 */
	int selectMaxId();

	/**
	 * 描述：根据id查询小微企业列表
	 * @author baifangfang
	 * @date 2017年5月3日
	 * @param paramMap
	 * @return
	 */
	List<SmEntSearchDto> selectIndexListById(Map<String, Object> paramMap);
}