package com.icinfo.cs.sment.mapper;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.sment.dto.BaseinfoDataSyncDto;
import com.icinfo.framework.mybatis.mapper.common.Mapper;

public interface BaseinfoDataSyncMapper extends Mapper<BaseinfoDataSyncDto>{
	
	/**
	 * 获取前一天增量的数据总量
	 * 
	 * @author zhuyong
	 * @param qryMap
	 * @return
	 * @throws Exception
	 */
	public Integer selectSyncCountForBaseinfo(Map<String,Object> qryMap) throws Exception;
	
	/**
	 * 分页获取增量的pripid
	 * 
	 * @author zhuyong
	 * @param qryMap
	 * @return
	 * @throws Exception
	 */
	public List<String> selectSmPriPIDInc(Map<String,Object> qryMap) throws Exception;
}
