/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 *
 * @author framework generator
 * @date 2016年09月26日
 * @version 2.0
 */
package com.icinfo.cs.yr.mapper;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.yr.dto.FoodstorageInfoDto;
import com.icinfo.cs.yr.model.FoodstorageInfo;
import com.icinfo.framework.mybatis.mapper.common.Mapper;

/**
 * 描述:    cs_foodstorage_info 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2016年09月26日
 */
public interface FoodstorageInfoMapper extends Mapper<FoodstorageInfo> {
	/**
	 * 描述：查询仓库信息
	 * @author chenxin
	 * @date 2016-09-14
	 * @param map
	 * @return
	 */
	public FoodstorageInfoDto selectFoodstorageInfoDtoById(Map<String, Object> map);
    
	/**
	 * 描述：查询仓库信息
	 * @author chenxin
	 * @date 2016-09-14
	 * @param map
	 * @return
	 */
	public List<FoodstorageInfoDto> selectFoodstorageInfoDto(Map<String, Object> params);
	
}