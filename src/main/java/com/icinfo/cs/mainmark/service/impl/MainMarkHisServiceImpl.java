/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.mainmark.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.icinfo.cs.mainmark.dto.MainMarkHisDto;
import com.icinfo.cs.mainmark.mapper.MainMarkHisMapper;
import com.icinfo.cs.mainmark.model.MainMarkHis;
import com.icinfo.cs.mainmark.service.IMainMarkHisService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.mapper.entity.Example.Criteria;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_main_mark_his 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年03月29日
 */
@Service
public class MainMarkHisServiceImpl extends MyBatisServiceSupport implements IMainMarkHisService {
	
	@Autowired
	private MainMarkHisMapper mainMarkHisMapper;
	/** 
	 * 描述: 批量新增
	 * @author 张文男
	 * @date 2017年3月30日 
	 * @param list 
	 */
	
	@Transactional(rollbackFor = Exception.class)
	public void insertBatch(List<MainMarkHis> list){
		for (MainMarkHis mainMarkHis : list) {
			mainMarkHisMapper.insertOne(mainMarkHis);
		}
	}
	
	
	
	/** 
	 * 描述: 分页列表
	 * @author 张文男
	 * @date 2017年3月30日 
	 * @param map
	 * @return 
	 */
	
	public List<MainMarkHisDto> queryPageList(PageRequest request){
		PageHelper.startPage(request.getPageNum(), request.getLength());
		Map<String, Object> queryMap = request.getParams();
		List<MainMarkHisDto> list = mainMarkHisMapper.queryPageList(queryMap);
		return list;
	}
	
	/** 
	 * 描述: 根据企业ID更新最新一条数据
	 * @author 张文男
	 * @date 2017年4月5日 
	 * @param bean 
	 */
	
	public void updateLastByPriPID(MainMarkHis bean){
		String markUuid = mainMarkHisMapper.queryLastMarkUuidByPriPID(bean.getPriPID());
		bean.setMarkUuid(markUuid);
		mainMarkHisMapper.updateByMarkUuid(bean);
	}



	@Override
	public void insertOne(MainMarkHis bean) {
		mainMarkHisMapper.insertOne(bean);
	}
}