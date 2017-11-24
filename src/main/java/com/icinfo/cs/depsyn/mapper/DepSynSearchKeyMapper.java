package com.icinfo.cs.depsyn.mapper;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.depsyn.model.DepSynSearchKey;
import com.icinfo.framework.mybatis.mapper.common.Mapper;

/**
 * 描述:    cs_depsyn_search_key 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2016年12月10日
 */
public interface DepSynSearchKeyMapper extends Mapper<DepSynSearchKey> {

	List<DepSynSearchKey> selectParams(Map<String, Object> queryMap);

	DepSynSearchKey paramsExist(Map<String, Object> queryMap);

}
