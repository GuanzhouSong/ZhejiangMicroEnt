package com.icinfo.cs.depsyn.mapper;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.depsyn.dto.DepSynSearchHisDto;
import com.icinfo.cs.depsyn.model.DepSynSearchHis;
import com.icinfo.framework.mybatis.mapper.common.Mapper;

/**
 * 描述:    cs_depsyn_search_his 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2016年12月10日
 */
public interface DepSynSearchHisMapper extends Mapper<DepSynSearchHis> {
	
	List<DepSynSearchHisDto> selectHistory(Map<String, Object> queryMap);
	
	DepSynSearchHisDto historyExist(Map<String, Object> queryMap);

}
