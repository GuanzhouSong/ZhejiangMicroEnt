/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2017年10月09日
 * @version 2.0
 */
package com.icinfo.cs.base.mapper;

import java.util.List;

import com.icinfo.cs.base.model.CodeChgType;
import com.icinfo.framework.mybatis.mapper.common.Mapper;

/**
 * 描述:    cs_code_chgtype 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2017年10月09日
 */
public interface CodeChgTypeMapper extends Mapper<CodeChgType> {

	/**
	 * 描述：根据事项编码查询检查事项编码表
	 * @author baifangfang
	 * @date 2017年10月9日
	 * @param altItem
	 * @return
	 */
	List<CodeChgType> selectCodeChgTypeListByAltItem(String altItem);
}