/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2016年10月20日
 * @version 2.0
 */
package com.icinfo.cs.risk.mapper;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.risk.dto.CsEntWarnDto;
import com.icinfo.cs.risk.model.CsEntWarn;
import com.icinfo.framework.mybatis.mapper.common.Mapper;

/**
 * 描述:    cs_ent_warn 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2016年10月20日
 */
public interface CsEntWarnMapper extends Mapper<CsEntWarn> {
	
	List<CsEntWarnDto> selectEntWarnList(Map<String,Object> qryMap);
	
	List<CsEntWarnDto> selectEntWarnCheckList(Map<String,Object> qryMap);
	
	List<CsEntWarnDto> selectEntWarnListForView(Map<String,Object> qryMap);

	/**
	 * 描述：获取风险预警提示标签
	 * @author baifangfang
	 * @date 2017年7月21日
	 * @return
	 */
	List<CsEntWarnDto> selectCsEntWarnMarks(Map<String, Object> params);
}