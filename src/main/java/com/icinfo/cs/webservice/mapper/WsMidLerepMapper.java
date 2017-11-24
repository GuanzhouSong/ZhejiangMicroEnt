/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2017年02月16日
 * @version 2.0
 */
package com.icinfo.cs.webservice.mapper;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.webservice.model.WsMidLerep;
import com.icinfo.framework.mybatis.mapper.common.Mapper;

/**
 * 描述:    cs_mid_lerep 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2017年02月16日
 */
public interface WsMidLerepMapper extends Mapper<WsMidLerep> {
	
	List<WsMidLerep> selectWsMidLerepListByContion(Map<String, Object> params);
	
	Integer selectWsMidLerepCountByContion(Map<String, Object> params);
	
	Integer selectWsMidLerepMaxId(Map<String, Object> params);
	
	Integer selectWsMidLerepMinId(Map<String, Object> params);
	
	
}