/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2017年09月26日
 * @version 2.0
 */
package com.icinfo.cs.ext.mapper;

import java.util.List;

import com.icinfo.cs.ext.model.MidBaseinfoDel;
import com.icinfo.framework.mybatis.mapper.common.Mapper;

/**
 * 描述:    cs_mid_baseinfo_del 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2017年09月26日
 */
public interface MidBaseinfoDelMapper extends Mapper<MidBaseinfoDel> {

	/**
	 * 描述：查询列表
	 * @author baifangfang
	 * @date 2017年9月26日
	 * @return
	 */
	List<MidBaseinfoDel> selectMidBaseinfoDelList();
}