/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.service;

import java.util.List;

import com.icinfo.cs.system.model.SysLogTable;
import com.icinfo.cs.yr.dto.FoodstorageBackDto;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_foodstorage_back 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2016年09月26日
 */
public interface IFoodstorageBackService extends BaseService {
	
	/**
	 * 描述: 获取食品仓储信息退回列表（工商端）
     * @auther chenxin
     * @date 2016年09月27日 
	 * @param request
	 * @return
	 */
	public List<FoodstorageBackDto> queryPage(PageRequest request);
	
	/**
	 * 
	 * 描述: 添加食品仓储退回日志(工商端)
	 * @auther chenxin
	 * @date 2016年9月18日 
	 * @param foodstorageBack
	 * @param logCollector
	 * @return boolean
	 */
	public boolean applyFoodStorageBackAddLog(FoodstorageBackDto foodStorageBackDto,List<SysLogTable> logCollector)throws Exception;
}