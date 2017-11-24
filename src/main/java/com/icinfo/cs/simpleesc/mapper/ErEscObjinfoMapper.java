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

import com.icinfo.cs.simpleesc.dto.ErEscObjinfoDto;
import com.icinfo.cs.simpleesc.model.ErEscObjinfo;
import com.icinfo.framework.mybatis.mapper.common.Mapper;

/**
 * 描述:    er_esc_objinfo 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2017年02月13日
 */
public interface ErEscObjinfoMapper extends Mapper<ErEscObjinfo> {

	/**
	 * 描述：根据priPID查询异议信息JSON数据列表
	 *
	 * @author baifangfang
	 * @date 2017年2月13日
	 * @param params
	 * @return
	 * @throws Exception
	 */
	List<ErEscObjinfoDto> queryPageResultByPriPID(Map<String, Object> params);
}