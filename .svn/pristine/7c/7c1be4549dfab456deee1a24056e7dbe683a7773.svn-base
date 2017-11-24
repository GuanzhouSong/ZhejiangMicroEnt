/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2016年10月18日
 * @version 2.0
 */
package com.icinfo.cs.inforece.mapper;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.secnocreditsup.dto.SecNoCreditSearchDto;
import com.icinfo.framework.mybatis.mapper.common.Mapper;

public interface SecNoCreditMapper extends Mapper<SecNoCreditSearchDto> {
	
	/**
	 * 获取严违失信名单数据
	 * @author zjj
	 * 20161129
	 */
	List<SecNoCreditSearchDto> selectSecNoCreditListSearch(Map<String,Object> map);
	
	/**
	 * 获取已下载数据
	 * @author zjj
	 */
	List<SecNoCreditSearchDto> selectDownList(SecNoCreditSearchDto secNoCreditSearchDto);
}