/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.mainmark.service;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.mainmark.dto.MainMarkHisDto;
import com.icinfo.cs.mainmark.model.MainMarkHis;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_main_mark_his 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2017年03月29日
 */
public interface IMainMarkHisService extends BaseService {
	
	/** 
	 * 描述: 批量新增
	 * @author 张文男
	 * @date 2017年3月30日 
	 * @param list 
	 */
	
	public void insertBatch(List<MainMarkHis> list);
	
	/** 
	 * 描述: 分页列表
	 * @author 张文男
	 * @date 2017年3月30日 
	 * @param map
	 * @return 
	 */
	
	public List<MainMarkHisDto> queryPageList(PageRequest request);
	
	/** 
	 * 描述: 根据企业ID更新最新一条数据
	 * @author 张文男
	 * @date 2017年4月5日 
	 * @param bean 
	 */
	
	public void updateLastByPriPID(MainMarkHis bean);
	
	/** 
	 * 描述: 新增
	 * @author 张文男
	 * @date 2017年4月6日 
	 * @param bean 
	 */
	
	public void insertOne(MainMarkHis bean);
	
}