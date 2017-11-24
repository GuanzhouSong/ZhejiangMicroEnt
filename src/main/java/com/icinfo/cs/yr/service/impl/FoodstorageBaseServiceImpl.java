/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.icinfo.cs.common.constant.LogTables;
import com.icinfo.cs.common.constant.OperationTypes;
import com.icinfo.cs.common.constant.RegStateEnum;
import com.icinfo.cs.common.utils.ObjectComparator;
import com.icinfo.cs.system.model.SysLogJsonItem;
import com.icinfo.cs.system.model.SysLogTable;
import com.icinfo.cs.yr.dto.FoodstorageBaseDto;
import com.icinfo.cs.yr.dto.FoodstorageCountDto;
import com.icinfo.cs.yr.mapper.FoodstorageBaseMapper;
import com.icinfo.cs.yr.model.FoodstorageBase;
import com.icinfo.cs.yr.service.IFoodstorageAuxService;
import com.icinfo.cs.yr.service.IFoodstorageBaseService;
import com.icinfo.cs.yr.service.IFoodstorageInfoService;
import com.icinfo.cs.yr.service.IFoodstorageLicenseService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_foodstorage_base 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年09月26日
 */
@Service
public class FoodstorageBaseServiceImpl extends MyBatisServiceSupport implements IFoodstorageBaseService {
	
	@Autowired
	private FoodstorageBaseMapper foodstorageBaseMapper;
	
	@Autowired
	private IFoodstorageLicenseService foodstorageLicenseService;
	
	@Autowired
	private IFoodstorageAuxService foodstorageAuxService;
	
	@Autowired
	private IFoodstorageInfoService foodstorageInfoService;
	
	/**
	 * 描述: 获取食品仓储信息查询列表list数据（工商端）
     * @auther chenxin
     * @date 2016年09月23日 
	 * @param request
	 * @return List<FoodstorageBaseDto>
	 */
	@Override
	public List<FoodstorageBaseDto> queryPage(PageRequest request) {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		Map<String,Object> map = request.getParams();
		if(map != null && map.get("fsScopeValue") != null){
			String fsScope = (String)map.get("fsScopeValue");
			if(StringUtils.isNotBlank(fsScope) && fsScope.length() > 1){
				String[] fsScopeList = fsScope.split(",");
				map.put("fsScopeList", fsScopeList);
			}else if(StringUtils.isNotBlank(fsScope) && fsScope.length() == 1){
				map.put("fsScopeParam", fsScope);
			}
		}
        return foodstorageBaseMapper.selectFoodstorageBaseDtoList(request.getParams());
	}
	
	/**
	 * 描述: 获取本年度食品仓储退回列表列表list数据（工商端）
	 * @auther chenxin
	 * @date 2016年09月27日 
	 * @param request
	 * @return List<FoodstorageBaseDto>
	 */
	@Override
	public List<FoodstorageBaseDto> queryBaseBackPage(PageRequest request) {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		return foodstorageBaseMapper.selectFoodstorageBaseDtoList(request.getParams());
	}
	
	/**
	 * 
	 * 描述: 查询食品仓储详细信息（工商端）
	 * @auther chenxin
	 * @date 2016年9月26日 
	 * @param map
	 * @return ModApplicationDto
	 */
	@Override
	public FoodstorageBase selecFoodstorageBaseById(Map<String, Object> map) {
		return foodstorageBaseMapper.selectFoodstorageBaseById(map);
	}
	
	/**
	 * 
	 * 描述: 添加食品仓储退回日志(工商端)
	 * @auther chenxin
	 * @date 2016年9月27日 
	 * @param priPID
	 * @param year
	 * @param logCollector
	 * @return boolean
	 */
	@Override
	public boolean applyFoodStorageBaseAddLog(String priPID, Integer year,
			List<SysLogTable> logCollector) throws Exception {
		FoodstorageBase foodstorageBase = selecFoodstorageBaseByPriPIDandYear(priPID, year);
		foodstorageBase.setSubmitState("3");
		if(doAddLog4ModFoodstorageBase(foodstorageBase, logCollector)){
			if(foodstorageBaseMapper.updateByPrimaryKeySelective(foodstorageBase) > 0){
				return true;
			};
		}
		return false;
	}
	
	/**
	 * 
	 * 描述: 记录修改食品仓储信息日志
	 * @auther chenxin
	 * @date 2016年9月18日 
	 * @param modApplication
	 * @param logCollector
	 * @return boolean
	 */
	private boolean doAddLog4ModFoodstorageBase(FoodstorageBase foodstorageBase,
			List<SysLogTable> logCollector) throws Exception {
		if(foodstorageBase != null && foodstorageBase.getId() != null){
			FoodstorageBase foodstorageBaseparam = new FoodstorageBase();
			foodstorageBaseparam.setId(foodstorageBase.getId());
			FoodstorageBase dbFoodstorageBase = foodstorageBaseMapper.selectOne(foodstorageBaseparam);
			List<SysLogJsonItem> logJsonItemList = ObjectComparator.compareObject(dbFoodstorageBase, foodstorageBase);
			SysLogTable logTable = SysLogTable.generateLogTable(LogTables.CS_FOODSTORAGE_BASE.getCode(), logJsonItemList, null, OperationTypes.UPDATE.getCode());	
			if(logTable!=null){
				logCollector.add(logTable);
    		} 
			return true;
		}
    	return false;
	}

	
	/**
	 * 
	 * 描述: 根据序号和年度查询食品仓储信息（公用）
	 * @auther chenxin
	 * @date 2016年9月26日 
	 * @param priPID
	 * @param year
	 * @return FoodstorageBase
	 */
	@Override
	public FoodstorageBase selecFoodstorageBaseByPriPIDandYear(String priPID,
			Integer year) {
		FoodstorageBase foodstorageBase = new FoodstorageBase();
		foodstorageBase.setPriPID(priPID);
		foodstorageBase.setYear(year);
		return foodstorageBaseMapper.selectOne(foodstorageBase);
	}
	
	/**
	 * 
	 * 描述: 根据序号和年度查询食品仓储退回信息（公用）
	 * @auther chenxin
	 * @date 2016年9月28日 
	 * @param priPID
	 * @param year
	 * @return FoodstorageBase
	 */
	@Override
	public FoodstorageBaseDto selecFoodstorageBaseDtoById(Map<String, Object> map) {
		return foodstorageBaseMapper.selecFoodstorageBaseDtoById(map);
	}
	
	/**
	 * 
	 * 描述: 保存食品仓储基本信息（公用）
	 * @auther chenxin
	 * @date 2016年9月29日 
	 * @param foodstorageBase
	 * @param logCollector
	 * @return boolean
	 */
	@Override
	public boolean saveFoodstorageBaseAddLog(FoodstorageBase foodstorageBase,List<SysLogTable> logCollector) throws Exception {
		if(doAddLog4AddFoodstorageBase(foodstorageBase, logCollector)){
			if(foodstorageBaseMapper.insertSelective(foodstorageBase) > 0){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 
	 * 描述: 修改食品仓储基本信息（公用）
	 * @auther chenxin
	 * @date 2016年9月29日 
	 * @param foodstorageBase
	 * @param logCollector
	 * @return boolean
	 */
	@Override
	public boolean modFoodstorageBaseAddLog(FoodstorageBase foodstorageBase,
			List<SysLogTable> logCollector) throws Exception {
		if(doAddLog4ModFoodstorageBase(foodstorageBase, logCollector)){
			if(foodstorageBaseMapper.updateByPrimaryKeySelective(foodstorageBase) > 0){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 
	 * 描述: 记录新增食品仓储信息日志
	 * @auther chenxin
	 * @date 2016年9月29日 
	 * @param foodstorageBase
	 * @param logCollector
	 * @return boolean
	 */
	private boolean doAddLog4AddFoodstorageBase(FoodstorageBase foodstorageBase,List<SysLogTable> logCollector) throws Exception {
		SysLogTable logTable = SysLogTable.generateLogTable(LogTables.CS_FOODSTORAGE_BASE.getCode(), null, foodstorageBase, OperationTypes.INSERT.getCode());	
		if(logTable!=null){
			logCollector.add(logTable);
		} 
		return true;
	}
	
	/**
	 * 
	 * 描述: 通过pripId和year 删除所有食品仓储相关信息
	 * @auther chenxin
	 * @date 2016年9月29日 
	 * @param foodstorageBase
	 * @param logCollector
	 * @return boolean
	 */
	@Transactional(rollbackFor=Exception.class)
	public boolean deleteAllByPripidAndYear(String priPID, int year) throws Exception{
		if(foodstorageLicenseService.deleteLicenseInfo(null, priPID, year)
				&& foodstorageInfoService.deleteStorageInfo(priPID, year)
				   && foodstorageAuxService.deleteStorageAuxInfo(priPID, year)){
			return true;
		}
		return false;
	}

	/**
	 * 
	 * 描述   食品仓储统计
	 * @author  赵祥江
	 * @date 2017年5月8日 下午7:12:38 
	 * @param  
	 * @throws
	 */
	@Override
	public List<FoodstorageCountDto> queryFoodstorageCountPage(
			PageRequest request) { 
		PageHelper.startPage(request.getPageNum(), request.getLength());
		Map<String, Object> paramsMap = request.getParams();
		paramsMap.put("regState", RegStateEnum.CUNXU.getParam());
		return foodstorageBaseMapper.foodstorageCount(paramsMap);
	}
	
	/**
	 * 描述: 判断是否属于食品仓储企业
	 * @auther yujingwei
	 * @date 2016年9月29日 
	 * @param priPID
	 * @return boolean
	 */
	public boolean doJudgeIsFoodStorageEnt(String priPID) throws Exception{
		List<FoodstorageBaseDto> baseDtos = foodstorageBaseMapper.doJudgeIsFoodStorageEnt(priPID);
		if(baseDtos !=null && baseDtos.size() > 0){
			return true;
		}
		return false;
	}
}