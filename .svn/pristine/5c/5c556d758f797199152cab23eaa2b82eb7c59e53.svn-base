/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2016年08月31日
 * @version 2.0
 */
package com.icinfo.cs.yr.mapper;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.yr.model.YrOtherInfo;
import com.icinfo.framework.mybatis.mapper.common.Mapper;

/**
 * 描述: cs_yr_otherinfo 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2016年08月31日
 */
public interface YrOtherInfoMapper extends Mapper<YrOtherInfo> {

	/**
	 * 
	 * 描述: 条件查询
	 * 
	 * @auther gaojinling
	 * @date 2016年8月31日
	 * @param params
	 * @return
	 */
	List<YrOtherInfo> selectYrOtherInfoBysearch_queryPage(Map<String, Object> params);

	/**
	 * 更新
	 * 
	 * @autor:wangjin
	 * @param param
	 * @return
	 */
	int updateParSetTime(Map<String, String> param);

	/**
	 * 根据 年份和身份主体代码集查询当前对象集合
	 * 
	 * @author zhuyong
	 * @param year
	 * @param pripid
	 * @return
	 */
	List<YrOtherInfo> selectByYearAndPripidList(Map<String, Object> params);
}