/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.infomange.service;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.infomange.dto.InfoReceStatDto;
import com.icinfo.framework.core.service.BaseService;

/**
 * 描述:    info_rece_stat 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2016年11月28日
 */
public interface IInfoReceStatService extends BaseService {
	/**
	 * 保存下载数据
	 * @author zjj
	 * 20161129
	 * @throws Exception
	 */
	public int insert(InfoReceStatDto infoReceStat) throws Exception;
	/**
	 * 获取统计下载数据
	 * @author zjj
	 * 20161129
	 */
	public List<InfoReceStatDto> selectDownDateCount(Map<String,Object> qryMap);
	/**
	 * 获取统计提供数据
	 * @author zjj
	 */
	public List<InfoReceStatDto> selectSendDateCount(Map<String,Object> qryMap);
}