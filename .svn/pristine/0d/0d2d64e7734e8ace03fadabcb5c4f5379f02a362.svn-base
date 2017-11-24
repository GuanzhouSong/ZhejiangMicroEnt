/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2016年08月30日
 * @version 2.0
 */
package com.icinfo.cs.yr.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.icinfo.cs.yr.model.SysForbidword;
import com.icinfo.framework.mybatis.mapper.common.Mapper;

/**
 * 描述:    cs_sys_forbidword 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2016年08月30日
 */
public interface SysForbidwordMapper extends Mapper<SysForbidword> {

	/**
	 * 描述：根据查询条件查询敏感词列表
	 * @author baifangfang
	 * @date 2016年9月13日
	 * @param params
	 * @return
	 */
	List<SysForbidword> queryPageResult(Map<String, Object> params);

	/**
	 * 描述：根据禁用文字查询敏感词列表
	 * @author baifangfang
	 * @date 2016年11月2日
	 * @param searchKeyWord
	 * @return
	 */
	List<SysForbidword> findSysForbidByBanLetter(@Param("banLetter") String banLetter);
}