/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2017年09月15日
 * @version 2.0
 */
package com.icinfo.cs.sccheck.mapper;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.sccheck.dto.CodeSpecialTypeDto;
import com.icinfo.cs.sccheck.model.CodeSpecialType;
import com.icinfo.framework.mybatis.mapper.common.Mapper;

/**
 * 描述:    cs_code_special_type 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2017年09月15日
 */
public interface CodeSpecialTypeMapper extends Mapper<CodeSpecialType> {

	/**
	 * 描述：根据职能部门查询专项库列表
	 * 
	 * @author chenxin
	 * @date 2017-09-15
	 * @param params
	 * @return
	 * @throws Exception
	 */
	List<CodeSpecialType> selectListByParams(Map<String,Object> params);

	/**
	 * 描述：根据职能部门查询专项库列表
	 * 
	 * @author chenxin
	 * @date 2017-09-15
	 * @param params
	 * @return
	 */
	List<CodeSpecialTypeDto> selectByParams(Map<String, Object> params);

	/**
	 * 查询最大编码
	 * @param dutyCode
	 * @return
	 * @throws Exception
	 */
	public String selectMaxSpecialCode(String dutyDeptCode)throws Exception;
}