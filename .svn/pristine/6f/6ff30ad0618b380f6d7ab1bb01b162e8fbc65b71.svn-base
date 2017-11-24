/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.icinfo.cs.common.constant.LogTables;
import com.icinfo.cs.common.constant.OperationTypes;
import com.icinfo.cs.system.model.SysLogTable;
import com.icinfo.cs.yr.dto.FoodstorageBackDto;
import com.icinfo.cs.yr.mapper.FoodstorageBackMapper;
import com.icinfo.cs.yr.model.FoodstorageBack;
import com.icinfo.cs.yr.service.IFoodstorageBackService;
import com.icinfo.cs.yr.service.IFoodstorageBaseService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述: cs_foodstorage_back 对应的Service接口实现类.<br>
 * 
 * @author framework generator
 * @date 2016年09月26日
 */
@Service
public class FoodstorageBackServiceImpl extends MyBatisServiceSupport implements
		IFoodstorageBackService {
	@Autowired
	private FoodstorageBackMapper foodstorageBackMapper;
	
	@Autowired
	private IFoodstorageBaseService foodstorageBaseService;

	/**
	 * 描述: 获取食品仓储信息退回列表（工商端）
	 * 
	 * @auther chenxin
	 * @date 2016年09月27日
	 * @param request
	 * @return
	 */
	@Override
	public List<FoodstorageBackDto> queryPage(PageRequest request) {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		return foodstorageBackMapper.selectFoodstorageBackDtoList(request
				.getParams());
	}

	/**
	 * 
	 * 描述: 添加食品仓储退回日志(工商端)
	 * 
	 * @auther chenxin
	 * @date 2016年9月18日
	 * @param foodstorageBack
	 * @param logCollector
	 * @return boolean
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public boolean applyFoodStorageBackAddLog(FoodstorageBackDto foodstorageBackDto,List<SysLogTable> logCollector) throws Exception {
		if(foodstorageBackDto != null){
			FoodstorageBack foodstorageBack = copyFoodstorageBackDto(foodstorageBackDto);
			if (doAddLog4AddFoodstorageBack(foodstorageBack, logCollector)) {
				if (foodstorageBackMapper.insertSelective(foodstorageBack) > 0) {
					if(foodstorageBaseService.applyFoodStorageBaseAddLog(foodstorageBackDto.getPriPID(), foodstorageBackDto.getYear(), logCollector)){
						return true;
					}
				}
			}
		}
		return false;
	}
	
	/**
	 * 描述：拷贝
	 * @author chenxin
	 * @date 2016-09-27
	 * @param foodstorageBackDto
	 * @return FoodstorageBack
	 */
	private FoodstorageBack copyFoodstorageBackDto(FoodstorageBackDto foodstorageBackDto){
		FoodstorageBack foodstorageBack = new FoodstorageBack();
		foodstorageBack.setPriPID(foodstorageBackDto.getPriPID());
		foodstorageBack.setYear(foodstorageBackDto.getYear());
		foodstorageBack.setBackReason(foodstorageBackDto.getBackReason());
		foodstorageBack.setBackTime(new Date());
		foodstorageBack.setBackName(foodstorageBackDto.getBackName());
		foodstorageBack.setCreateTime(new Date());
		return foodstorageBack;
	}

	/**
	 * 
	 * 描述: 记录修改年报修改日志
	 * 
	 * @auther chenxin
	 * @date 2016年9月18日
	 * @param modApplication
	 * @param logCollector
	 * @return boolean
	 */
	private boolean doAddLog4AddFoodstorageBack(
			FoodstorageBack foodstorageBack, List<SysLogTable> logCollector)
			throws Exception {
		SysLogTable logTable = SysLogTable.generateLogTable(
				LogTables.CS_FOODSTORAGE_BACK.getCode(), null, foodstorageBack,
				OperationTypes.INSERT.getCode());
		if (logTable != null) {
			logCollector.add(logTable);
		}
		return true;
	}
}