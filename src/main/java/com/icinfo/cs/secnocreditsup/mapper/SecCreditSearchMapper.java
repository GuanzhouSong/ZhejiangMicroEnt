/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2016年11月25日
 * @version 2.0
 */
package com.icinfo.cs.secnocreditsup.mapper;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.secnocreditsup.dto.SecNoCreditSearchDto;
import com.icinfo.framework.mybatis.mapper.common.Mapper;

/**
 *
 * @date 2016年11月25日
 */
public interface SecCreditSearchMapper extends Mapper<SecNoCreditSearchDto> {
	/**
	 * 获取查询数据
	 * @author zjj 
	 * @param qryMap
	 * @return
	 */
	List<SecNoCreditSearchDto> selectSecCreditSearchList(Map<String,Object> qryMap);
}