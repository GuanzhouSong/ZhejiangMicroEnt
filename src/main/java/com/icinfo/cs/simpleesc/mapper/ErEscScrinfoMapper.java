/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2017年02月13日
 * @version 2.0
 */
package com.icinfo.cs.simpleesc.mapper;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.simpleesc.dto.ErEscScrinfoDto;
import com.icinfo.cs.simpleesc.model.ErEscScrinfo;
import com.icinfo.framework.mybatis.mapper.common.Mapper;

/**
 * 描述:    er_esc_scrinfo 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2017年02月13日
 */
public interface ErEscScrinfoMapper extends Mapper<ErEscScrinfo> {

	/**
	 * 描述：根据priPID查询简易注销结果信息JSON数据列表
	 *
	 * @author baifangfang
	 * @date 2017年2月13日
	 * @param params
	 * @return
	 * @throws Exception
	 */
	List<ErEscScrinfoDto> queryPageResultByPriPID(Map<String, Object> params);
	
	/**
	 * 
	 * 描述   分页查询简易注销结果
	 * @author 赵祥江
	 * @date 2017年2月21日 下午3:36:24 
	 * @param 
	 * @return List<ErEscScrinfoDto>
	 * @throws
	 */
	List<ErEscScrinfoDto> selectErEscScrinfoPageResult(Map<String, Object> params);

	/**
	 * 描述：查询简易注销结果信息
	 * @author baifangfang
	 * @date 2017年9月27日
	 * @param queryMap
	 * @return
	 */
	ErEscScrinfoDto queryResultByPriPID(Map<String, Object> queryMap); 
	
}