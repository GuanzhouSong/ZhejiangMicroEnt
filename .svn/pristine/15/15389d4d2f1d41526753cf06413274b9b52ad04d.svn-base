/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.service.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.common.constant.LogTables;
import com.icinfo.cs.common.constant.OperationTypes;
import com.icinfo.cs.system.model.SysLogTable;
import com.icinfo.cs.yr.mapper.FoodstorageAuxMapper;
import com.icinfo.cs.yr.model.FoodstorageAux;
import com.icinfo.cs.yr.service.IFoodstorageAuxService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;

/**
 * 描述:    cs_foodstorage_aux 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年09月26日
 */
@Service
public class FoodstorageAuxServiceImpl extends MyBatisServiceSupport implements IFoodstorageAuxService {
	
	@Autowired
	private FoodstorageAuxMapper foodstorageAuxMapper;
	
	/**
	 * 
	 * 描述: 保存仓库详细信息并且保存日志
	 * @auther chenxin
	 * @date 2016年9月29日 
	 * @param foodstorageAux
	 * @param logCollector
	 * @return boolean
	 */
	@Override
	public boolean saveFoodstorageAuxAddLog(List<FoodstorageAux> foodstorageAuxList,
			List<SysLogTable> logCollector) throws Exception {
		if(foodstorageAuxList != null && foodstorageAuxList.size() > 0){
			for(FoodstorageAux foodstorageAux :foodstorageAuxList){
				if(doAddLog4AddFoodStorageAux(foodstorageAux, logCollector)){
					foodstorageAuxMapper.insert(foodstorageAux);
				}
			}
		}
		return true;
	}
	
	/**
	 * 
	 * 描述: 修改仓库详细信息并且保存日志
	 * @auther chenxin
	 * @date 2016年9月29日 
	 * @param fsInfoId
	 * @param foodstorageAuxList
	 * @param logCollector
	 * @return boolean
	 */
	@Override
	public boolean modFoodstorageAuxAddLog(String fsInfoId,List<FoodstorageAux> foodstorageAuxList,
			List<SysLogTable> logCollector) throws Exception {
		if(foodstorageAuxList != null && foodstorageAuxList.size() > 0){
			if(rmFoodstorageAuxAddLog(fsInfoId, logCollector)){
				for(FoodstorageAux foodstorageAux :foodstorageAuxList){
					if(doAddLog4AddFoodStorageAux(foodstorageAux, logCollector)){
						foodstorageAuxMapper.insert(foodstorageAux);
					}
				}
			}
		}
		return true;
	}
	
	/**
	 * 
	 * 描述: 根据年份和主题身份代码删除仓库详细信息并且保存日志
	 * @auther chenxin
	 * @date 2016年9月29日 
	 * @param priPID
	 * @param Year
	 * @param logCollector
	 * @return boolean
	 */
	@Override
	public boolean rmFoodstorageAuxAddLog(String priPID, Integer year,List<SysLogTable> logCollector) throws Exception {
		if(StringUtils.isNotEmpty(priPID) && year != null && year.intValue() > 0){
			FoodstorageAux foodstorageAux = new FoodstorageAux();
			foodstorageAux.setPriPID(priPID);
			foodstorageAux.setYear(year);
			foodstorageAuxMapper.delete(foodstorageAux);
			return true;
		}
		return false;
	}
	
	/**
	 * 
	 * 描述: 删除仓库详细信息并且保存日志
	 * @auther chenxin
	 * @date 2016年9月29日 
	 * @param fsInfoId
	 * @param logCollector
	 * @return boolean
	 */
	@Override
	public boolean rmFoodstorageAuxAddLog(String fsInfoId,
			List<SysLogTable> logCollector) throws Exception {
		if(StringUtils.isNotEmpty(fsInfoId) && doAddLog4DelFoodStorageAux(fsInfoId, logCollector)){
			FoodstorageAux foodstorageAux = new FoodstorageAux();
			foodstorageAux.setFsinfoID(fsInfoId);
			if(foodstorageAuxMapper.delete(foodstorageAux) > 0){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 
	 * 描述: 批量删除仓库详细信息并且保存日志
	 * @auther chenxin
	 * @date 2016年9月29日 
	 * @param fsInfoIdList
	 * @param logCollector
	 * @return boolean
	 */
	@Override
	public boolean rmBatchFoodstorageAuxAddLog(List<String> fsInfoIdList,
			List<SysLogTable> logCollector) throws Exception {
		if(fsInfoIdList != null && fsInfoIdList.size() > 0){
			for(String fsInfoId : fsInfoIdList){
				rmFoodstorageAuxAddLog(fsInfoId, logCollector);
			}
			return true;
		}
		return false;
	}
	
	/**
	 * 
	 * 描述: 记录新增仓库详情信息日志
	 * @auther chenxin
	 * @date 2016年9月29日 
	 * @param foodStorageInfo
	 * @param logCollector
	 * @return boolean
	 */
	private boolean doAddLog4AddFoodStorageAux(FoodstorageAux foodstorageAux,
		List<SysLogTable> logCollector) throws Exception {
		SysLogTable logTable = SysLogTable.generateLogTable(LogTables.CS_FOODSTORAGE_AUX.getCode(),null , foodstorageAux, OperationTypes.INSERT.getCode());	
		if(logTable!=null){
			logCollector.add(logTable);
		} 
		return true;
	}
	
	/**
	 * 
	 * 描述: 删除仓库详情信息日志
	 * @auther chenxin
	 * @date 2016年9月29日 
	 * @param foodstorageInfoId
	 * @param logCollector
	 * @return boolean
	 */
	private boolean doAddLog4DelFoodStorageAux(String fsinfoID,List<SysLogTable> logCollector) throws Exception {
		FoodstorageAux foodstorageAuxParam = new FoodstorageAux();
		foodstorageAuxParam.setFsinfoID(fsinfoID);
		List<FoodstorageAux> foodstorageAuxList = foodstorageAuxMapper.select(foodstorageAuxParam);
		for(FoodstorageAux foodstorageAux : foodstorageAuxList){
			SysLogTable logTable = SysLogTable.generateLogTable(LogTables.CS_FOODSTORAGE_AUX.getCode(),null , foodstorageAux, OperationTypes.DELETE.getCode());	
			if(logTable!=null){
				logCollector.add(logTable);
			} 
		}
		return true;
	}
	
	/**
	 * 
	 * 描述: 根据ID查询FoodstorageInfo
	 * @auther chenxin
	 * @date 2016年9月29日 
	 * @param fsInfoId
	 * @param priPID
	 * @return List<FoodstorageAux>
	 */
	@Override
	public List<FoodstorageAux> searchFoodstorageAuxByFsInfoIdAndPriPID(
			String fsInfoId, String priPID) throws Exception {
		FoodstorageAux foodstorageAux = new FoodstorageAux();
		foodstorageAux.setFsinfoID(fsInfoId);
		if(StringUtils.isNotEmpty(priPID)){
			foodstorageAux.setPriPID(priPID);
		}
		return foodstorageAuxMapper.select(foodstorageAux);
	}
	
	/**
	 * 
	 * 描述: 根据年份和主题身份代码删除仓库详细信息
	 * @auther yujingwei
	 * @date 2016年9月29日 
	 * @param priPID
	 * @param Year
	 * @return boolean
	 */
	public boolean deleteStorageAuxInfo(String priPID, int year) throws Exception{
		Example example = new Example(FoodstorageAux.class);
		example.createCriteria().andEqualTo(Constants.CS_PRIPID, priPID).andEqualTo(Constants.CS_YEAR, year);
		if(foodstorageAuxMapper.deleteByExample(example) < 0){
			return false;
		}
		return true;
	}
}