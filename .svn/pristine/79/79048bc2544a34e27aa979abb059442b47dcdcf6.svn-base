/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2016年11月04日
 * @version 2.0
 */
package com.icinfo.cs.es.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.icinfo.cs.es.model.PanoramaSearch;
import com.icinfo.framework.mybatis.mapper.common.Mapper;

/**
 * 描述:    cs_panorama_search 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2016年11月04日
 */
public interface PanoramaSearchMapper extends Mapper<PanoramaSearch> {
	
	/**
	 * 根据id区间获取结果
	 * 
	 * @author zhuyong
	 * @param map
	 * @return
	 */
	public List<PanoramaSearch> selectDataListByIdRange(Map<String,Object> map);

	/**
	 * 获取最大的id
	 * 
	 * @author zhuyong
	 * @return
	 */
	public Integer selectMaxId();

	/**
	 * 获取创建索引的增量数据
	 * 
	 * @author zhuyong
	 * @return
	 */
	public List<PanoramaSearch> selectIncDataForIdx(Map<String,Object> map);
	/**
	 * 获取创建索引的增量数据
	 * 
	 * @author zhuyong
	 * @return
	 */
	public Integer selectIncDataTotalForIdx(Map<String,Object> map);
	
	/**
	 * 获取单条全景实体
	 * 
	 * @author zhuyong
	 * @return
	 */
	public PanoramaSearch selectOnePanorama(@Param("PriPID") String priPID, @Param("regState") String regState) throws Exception;
}