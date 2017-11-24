package com.icinfo.cs.depsyn.service;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.depsyn.dto.DepSynSearchHisDto;
import com.icinfo.cs.depsyn.model.DepSynSearchHis;
import com.icinfo.cs.depsyn.model.DepSynSearchKey;
import com.icinfo.cs.ext.model.MidBaseInfo;
import com.icinfo.framework.core.service.BaseService;

public interface IDepSynSearchHisService extends BaseService {

	/**
	 * 新增查询记录
	 */
	public int insert(DepSynSearchHis depSynSearchHis, MidBaseInfo baseInfo);

	/**
	 * 获取最近记录
	 * @param queryMap
	 * @return
	 */
	public List<DepSynSearchHisDto> selectHistory(Map<String, Object> queryMap);

	/**
	 * 更新查询记录
	 * @param depSynSearchHis
	 * @return
	 */
	public int update(DepSynSearchHis depSynSearchHis);

	/**
	 * 判断记录是否存在
	 * @param queryMap
	 * @return
	 */
	public boolean historyExist(Map<String, Object> queryMap);

	/**
	 * 查询条件组合记录
	 * @param queryMap
	 * @return
	 */
	public List<DepSynSearchKey> selectParams(Map<String, Object> queryMap);

	/**
	 * 判断条件组合是否存在
	 * @param queryMap
	 * @return
	 */
	public boolean paramsExist(Map<String, Object> queryMap);

	/**
	 * 新增查询条件组合
	 * @param depSynSearchKey
	 * @return
	 */
	public int insert(DepSynSearchKey depSynSearchKey);

	/**
	 * 更新查询条件组合
	 * @param depSynSearchKey
	 * @return
	 */
	public int update(DepSynSearchKey depSynSearchKey);

}
