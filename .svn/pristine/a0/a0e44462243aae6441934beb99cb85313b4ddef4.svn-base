/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.common.constant.LogTables;
import com.icinfo.cs.common.constant.OperationTypes;
import com.icinfo.cs.common.utils.ObjectComparator;
import com.icinfo.cs.system.model.SysLogJsonItem;
import com.icinfo.cs.system.model.SysLogTable;
import com.icinfo.cs.yr.dto.FoodstorageInfoDto;
import com.icinfo.cs.yr.mapper.FoodstorageInfoMapper;
import com.icinfo.cs.yr.model.FoodstorageAux;
import com.icinfo.cs.yr.model.FoodstorageInfo;
import com.icinfo.cs.yr.service.IFoodstorageAuxService;
import com.icinfo.cs.yr.service.IFoodstorageInfoService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_foodstorage_info 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年09月26日
 */
@Service
public class FoodstorageInfoServiceImpl extends MyBatisServiceSupport implements IFoodstorageInfoService {
	@Autowired
	private FoodstorageInfoMapper foodstorageInfoMapper;
	
	@Autowired
	private IFoodstorageAuxService foodstorageAuxService;
	
	/**
	 * 描述: 获取许可证列表（工商段）
     * @auther chenxin
     * @date 2016年09月26日 
	 * @param request
	 * @return
	 */
	@Override
	public List<FoodstorageInfo> queryPage(PageRequest request) {
		List<FoodstorageInfo> foodstorageLicenseList = null;
		if(request != null && request.getParams() != null && request.getParams().get("priPID") != null && request.getParams().get("year") != null){
			PageHelper.startPage(request.getPageNum(), request.getLength());
			String priPID = (String)request.getParams().get("priPID");
			String year = (String)request.getParams().get("year");
			if(StringUtils.isNotEmpty(priPID) && StringUtils.isNotEmpty(year)){
				Example example=new Example(FoodstorageInfo.class);
				example.createCriteria()
				.andEqualTo("priPID", priPID)
				.andEqualTo("year", year);
				foodstorageLicenseList = foodstorageInfoMapper.selectByExample(example);
			}
		}
		return foodstorageLicenseList;
	}
	
	/**
	 * 描述: 获取仓库列表（企业端）
     * @auther chenxin
     * @date 2016年09月26日 
	 * @param request
	 * @return
	 */
	public List<FoodstorageInfoDto> queryPageForClient(PageRequest request) throws Exception{
		List<FoodstorageInfoDto> foodstorageLicenseList = null;
		if(request.getParams() != null && request.getParams().get("priPID") != null && request.getParams().get("year") !=null){
			PageHelper.startPage(request.getPageNum(), request.getLength());
		    foodstorageLicenseList = foodstorageInfoMapper.selectFoodstorageInfoDto(request.getParams());
		    if(CollectionUtils.isNotEmpty(foodstorageLicenseList)){
		    	for(FoodstorageInfoDto foodstorageInfoDto : foodstorageLicenseList){
		    	   List<FoodstorageAux> foodstorageAuxList = foodstorageAuxService.searchFoodstorageAuxByFsInfoIdAndPriPID(
		    			   foodstorageInfoDto.getFsinfoID(),foodstorageInfoDto.getPriPID());
		    	   foodstorageInfoDto.setFoodstorageAuxList(foodstorageAuxList);
		    	}
		    }
		}
		return foodstorageLicenseList;
	}
	
	/**
	 * 
	 * 描述: 保存仓库信息并且保存日志
	 * @auther chenxin
	 * @date 2016年9月29日 
	 * @param foodstorageLicense
	 * @param foodstorageAux
	 * @param logCollector
	 * @return boolean
	 */
	@Transactional(rollbackFor=Exception.class)
	@Override
	public boolean saveFoodstorageInfoAndAuxAddLog(FoodstorageInfo foodstorageInfo, List<FoodstorageAux> foodstorageAuxList,
			List<SysLogTable> logCollector) throws Exception {
		if(foodstorageInfo != null && foodstorageAuxList != null && foodstorageAuxList.size() > 0){
			foodstorageInfo.setSetTime(new Date());
			foodstorageInfo.setCreateTime(new Date());
			if(doAddLog4AddFoodStorageInfo(foodstorageInfo, logCollector)){
				if(foodstorageInfoMapper.insert(foodstorageInfo) > 0){
					List<FoodstorageAux> newFoodstogereList = setFoodstorageAuxDefaultValue(foodstorageInfo, foodstorageAuxList);
					return foodstorageAuxService.saveFoodstorageAuxAddLog(newFoodstogereList, logCollector);
				}
			}
		}
		return false;
	}
	
	/**
	 * 描述：设置默认仓库详情表信息
	 * @auther chenxin
	 * @date 2016年9月29日 
	 * @param foodstorageInfo
	 * @param foodstorageAuxList
	 * @return
	 */
	private List<FoodstorageAux> setFoodstorageAuxDefaultValue(FoodstorageInfo foodstorageInfo,List<FoodstorageAux> foodstorageAuxList){
		List<FoodstorageAux> foodstorageAuxListNew = new ArrayList<FoodstorageAux>();
		for(FoodstorageAux foodstorageAux : foodstorageAuxList){
			foodstorageAux.setPriPID(foodstorageInfo.getPriPID());
			foodstorageAux.setYear(foodstorageInfo.getYear());
			foodstorageAux.setCreateTime(new Date());
			foodstorageAux.setFsinfoID(foodstorageInfo.getFsinfoID());
			foodstorageAuxListNew.add(foodstorageAux);
		}
		return foodstorageAuxListNew;
	}
	
	/**
	 * 
	 * 描述: 修改仓库信息并且保存日志
	 * @auther chenxin
	 * @date 2016年9月29日 
	 * @param foodstorageLicense
	 * @param logCollector
	 * @return boolean
	 */
	@Transactional(rollbackFor=Exception.class)
	@Override
	public boolean modFoodstorageInfoAndAuxAddLog(FoodstorageInfo foodstorageInfo,List<FoodstorageAux> foodstorageAuxList, List<SysLogTable> logCollector)throws Exception {
		if(foodstorageInfo != null && foodstorageAuxList != null && foodstorageAuxList.size() > 0){
			foodstorageInfo.setCreateTime(new Date());
			if(doAddLog4ModFoodStorageInfo(foodstorageInfo, logCollector)){
				if(foodstorageInfoMapper.updateByPrimaryKeySelective(foodstorageInfo) > 0){
					List<FoodstorageAux> newFoodstogereList = setFoodstorageAuxDefaultValue(foodstorageInfo, foodstorageAuxList);
					return foodstorageAuxService.modFoodstorageAuxAddLog(foodstorageInfo.getFsinfoID(),newFoodstogereList, logCollector);
				}
			}
		}
		return false;
	}
	
	/**
	 * 
	 * 描述: 删除仓库信息并且保存日志
	 * @auther chenxin
	 * @date 2016年9月29日 
	 * @param foodstorageLicenseId
	 * @param logCollector
	 * @return boolean
	 */
	@Override
	public boolean rmFoodstorageInfoAndAuxAddLog(String fsinfoID,
			List<SysLogTable> logCollector) throws Exception {
		if(StringUtils.isNotEmpty(fsinfoID) && doAddLog4DelFoodStorageLicense(fsinfoID, logCollector)){
			FoodstorageInfo foodstorageInfo = new FoodstorageInfo();
			foodstorageInfo.setFsinfoID(fsinfoID);
			if(foodstorageInfoMapper.delete(foodstorageInfo)>0){
				return foodstorageAuxService.rmFoodstorageAuxAddLog(fsinfoID, logCollector);
			}
		}
		return false;
	}
	
	/**
	 * 
	 * 描述: 批量仓库信息并且保存日志
	 * @auther chenxin
	 * @date 2016年9月29日 
	 * @param fsinfoIDList
	 * @param logCollector
	 * @return boolean
	 */
	@Transactional(rollbackFor=Exception.class)
	@Override
	public boolean rmBatchFoodstorageInfoAndAuxAddLog(List<String> fsinfoIDList,
			List<SysLogTable> logCollector) throws Exception {
		if(fsinfoIDList != null && fsinfoIDList.size() > 0){
			for(String fsinfoID :fsinfoIDList){
				rmFoodstorageInfoAndAuxAddLog(fsinfoID, logCollector);
			}
			return true;
		}
		return false;
	}
	
	/**
	 * 
	 * 描述: 记录新增仓库信息日志
	 * @auther chenxin
	 * @date 2016年9月29日 
	 * @param foodStorageInfo
	 * @param logCollector
	 * @return boolean
	 */
	private boolean doAddLog4AddFoodStorageInfo(FoodstorageInfo foodStorageInfo,
		List<SysLogTable> logCollector) throws Exception {
		SysLogTable logTable = SysLogTable.generateLogTable(LogTables.CS_FOODSTORAGE_INFO.getCode(),null , foodStorageInfo, OperationTypes.INSERT.getCode());	
		if(logTable!=null){
			logCollector.add(logTable);
		} 
		return true;
	}
	
	/**
	 * 
	 * 描述: 记录修改仓库信息日志
	 * @auther chenxin
	 * @date 2016年9月29日 
	 * @param foodStorageInfo
	 * @param logCollector
	 * @return boolean
	 */
	private boolean doAddLog4ModFoodStorageInfo(FoodstorageInfo foodStorageInfo,List<SysLogTable> logCollector) throws Exception {
		if(foodStorageInfo != null && foodStorageInfo.getId() != null){
			FoodstorageInfo foodStorageInfoParam = new FoodstorageInfo();
			foodStorageInfoParam.setId(foodStorageInfo.getId());
			FoodstorageInfo dbFoodstorageInfo = foodstorageInfoMapper.selectOne(foodStorageInfoParam);
			List<SysLogJsonItem> logJsonItemList = ObjectComparator.compareObject(dbFoodstorageInfo, foodStorageInfo);
			SysLogTable logTable = SysLogTable.generateLogTable(LogTables.CS_FOODSTORAGE_INFO.getCode(), logJsonItemList, null, OperationTypes.UPDATE.getCode());	
			if(logTable!=null){
				logCollector.add(logTable);
    		} 
			return true;
		}
    	return false;
	}
	
	/**
	 * 
	 * 描述: 删除仓库信息日志
	 * @auther chenxin
	 * @date 2016年9月29日 
	 * @param fsinfoID
	 * @param logCollector
	 * @return boolean
	 */
	private boolean doAddLog4DelFoodStorageLicense(String fsinfoID,List<SysLogTable> logCollector) throws Exception {
		FoodstorageInfo foodStorageInfoParam = new FoodstorageInfo();
		foodStorageInfoParam.setFsinfoID(fsinfoID);
		FoodstorageInfo foodStorageInfo = foodstorageInfoMapper.selectOne(foodStorageInfoParam);
		SysLogTable logTable = SysLogTable.generateLogTable(LogTables.CS_FOODSTORAGE_INFO.getCode(),null , foodStorageInfo, OperationTypes.DELETE.getCode());	
		if(logTable!=null){
			logCollector.add(logTable);
		} 
		return true;
	}
	
	/**
	 * 
	 * 描述: 根据ID查询FoodstorageInfoDto（企业端）
	 * @auther chenxin
	 * @date 2016年9月29日 
	 * @param fsInfoId
	 * @param priPID
	 * @return FoodstorageInfo
	 */
	@Override
	public FoodstorageInfoDto searchFoodstorageInfoByFsInfoIdAndPriPID(String fsInfoId, String priPID)
			throws Exception {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("fsinfoID", fsInfoId);
		map.put("priPID", priPID);
		return foodstorageInfoMapper.selectFoodstorageInfoDtoById(map);
	}
	

	/**
	 * 
	 * 描述: 根据ID查询FoodstorageInfo（工商段）
	 * @auther chenxin
	 * @date 2016年9月29日 
	 * @param fsInfoId
	 * @return FoodstorageInfo
	 */
	@Override
	public FoodstorageInfo searchFoodstorageInfoByFsInfoId(String fsInfoId)
			throws Exception {
		FoodstorageInfo foodstorageInfo = new FoodstorageInfo();
		foodstorageInfo.setFsinfoID(fsInfoId);
		return foodstorageInfoMapper.selectOne(foodstorageInfo);
	}
	
	/**
	 * 描述: 删除仓库信息（通过priPid 和 year）
     * @auther yujingwei
     * @date 2016年09月26日 
	 * @param priPID
	 * @param year
	 * @return boolean
	 */
	public boolean deleteStorageInfo(String priPID, int year) throws Exception{
		Example example = new Example(FoodstorageInfo.class);
		example.createCriteria().andEqualTo(Constants.CS_PRIPID, priPID).andEqualTo(Constants.CS_YEAR, year);
		if(foodstorageInfoMapper.deleteByExample(example) < 0){
			return false;
		}
		return true;
	}
}