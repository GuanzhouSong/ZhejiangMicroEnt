/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2017年02月13日
 * @version 2.0
 */
package com.icinfo.cs.base.mapper;

import java.util.List;

import com.icinfo.cs.base.model.CodeObjection;
import com.icinfo.framework.mybatis.mapper.common.Mapper;

/**
 * 描述:    cs_code_objection 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2017年02月13日
 */
public interface CodeObjectionMapper extends Mapper<CodeObjection> {

	/**
	 * 描述：获取异议内容编码列表
	 * 
	 * @author baifangfang
	 * @date 2017-02-14
	 * @return
	 */
	List<CodeObjection> selectListResultAll();
}