/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.infomange.service.impl;

import com.icinfo.cs.infomange.dto.InfoReceStatDto;
import com.icinfo.cs.infomange.mapper.InfoReceStatMapper;
import com.icinfo.cs.infomange.service.IInfoReceStatService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:    info_rece_stat 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年11月28日
 */
@Service
public class InfoReceStatServiceImpl extends MyBatisServiceSupport implements IInfoReceStatService {
	@Autowired
	InfoReceStatMapper infoReceStatMapper;
	
	/**
	 * 保存下载数据
	 * @author zjj
	 * 20161129
	 * @throws Exception
	 */
	@Override
	public int insert(InfoReceStatDto infoReceStat) throws Exception {
		return infoReceStatMapper.insert(infoReceStat);
	}

	/**
	 * 获取统计下载数据
	 * @author zjj
	 * 20161129
	 */
	@Override
	public List<InfoReceStatDto> selectDownDateCount(Map<String, Object> qryMap) {
		return infoReceStatMapper.selectDownDateCount(qryMap);
	}
	/**
	 * 获取统计接收数据
	 * @author zjj
	 * 20161129
	 */
	@Override
	public List<InfoReceStatDto> selectSendDateCount(Map<String, Object> qryMap) {
		return infoReceStatMapper.selectSendDateCount(qryMap);
	}
}