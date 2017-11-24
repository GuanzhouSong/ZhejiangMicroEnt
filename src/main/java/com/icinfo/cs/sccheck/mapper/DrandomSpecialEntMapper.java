/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2017年09月13日
 * @version 2.0
 */
package com.icinfo.cs.sccheck.mapper;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.sccheck.dto.DrandomSpecialEntDto;
import com.icinfo.cs.sccheck.model.DrandomSpecialEnt;
import com.icinfo.framework.mybatis.mapper.common.Mapper;

/**
 * 描述:    cs_drandom_special_ent 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2017年09月13日
 */
public interface DrandomSpecialEntMapper extends Mapper<DrandomSpecialEnt> {

	/**
	 * 描述：跨部门专项库列表
	 *
	 * @author chenxin
	 * @date 2017年9月13日
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public List<DrandomSpecialEntDto> selectDrandomSpecialEntDtoList(Map<String, Object> params)throws Exception;
	
	/**
	 * 描述：统计
	 *
	 * @author chenxin
	 * @date 2017年9月13日
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public List<DrandomSpecialEntDto> selectSpecialCount(Map<String, Object> params)throws Exception;
	
	  /**
     * 描述: 查询一家企业涉及的所有检查事项
	 * @auther chenxin
	 * @date 2017年4月19日
     * @param priPID
     * @return
     */
	public List<String> selectCheckCodeList(String priPID)throws Exception;
}