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

import com.icinfo.cs.sccheck.dto.CodeMarkTypeDto;
import com.icinfo.cs.sccheck.model.CodeMarkType;
import com.icinfo.framework.mybatis.mapper.common.Mapper;

/**
 * 描述:    cs_code_mark_type 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2017年09月15日
 */
public interface CodeMarkTypeMapper extends Mapper<CodeMarkType> {

	/**
	 * 描述：根据职能部门查询标签列表
	 * 
	 * @author chenxin
	 * @date 2017-09-15
	 * @param params
	 * @return
	 * @throws Exception
	 */
	List<CodeMarkType> selectListByParams(Map<String, Object> params);

	/**
	 * 描述：分页查询标签列表
	 * 
	 * @author chenxin
	 * @date 2017-09-22
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public List<CodeMarkTypeDto> selectByParams(Map<String, Object> params)throws Exception;

	/**
	 * 描述：获取最大markCode
	 * 
	 * @author chenxin
	 * @date 2017-09-22
	 * @param dutyDeptCode
	 * @return
	 * @throws Exception
	 */
	String selectMaxMarkCode(String dutyDeptCode)throws Exception;
}