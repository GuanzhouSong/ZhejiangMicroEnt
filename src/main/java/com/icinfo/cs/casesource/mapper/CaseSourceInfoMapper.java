/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2017年11月23日
 * @version 2.0
 */
package com.icinfo.cs.casesource.mapper;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.casesource.dto.CaseSourceInfoDto;
import com.icinfo.cs.casesource.model.CaseSourceInfo;
import com.icinfo.framework.mybatis.mapper.common.Mapper;

/**
 * 描述:    cs_case_source_info 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2017年11月23日
 */
public interface CaseSourceInfoMapper extends Mapper<CaseSourceInfo> {
    
	/**
	 * 描述：查询案源管理列表
	 *
	 * @author yujingwei
	 * @date 2017年10月27日
	 * @param request
	 * @return pageResponse
	 * @throws Exception
	 */
	List<CaseSourceInfoDto> selectCaseSourceInfoList(Map<String, Object> params);
}