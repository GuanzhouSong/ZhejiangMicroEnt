/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.service;

import java.util.List;

import com.icinfo.cs.system.model.SysLogTable;
import com.icinfo.cs.yr.model.FoodstorageAux;
import com.icinfo.framework.core.service.BaseService;

/**
 * 描述:    cs_foodstorage_aux 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2016年09月26日
 */
public interface IFoodstorageAuxService extends BaseService {
	
	/**
	 * 
	 * 描述: 根据ID查询FoodstorageInfo
	 * @auther chenxin
	 * @date 2016年9月29日 
	 * @param fsInfoId
	 * @param priPID
	 * @return List<FoodstorageAux>
	 */
	public List<FoodstorageAux> searchFoodstorageAuxByFsInfoIdAndPriPID(String fsInfoId,String priPID)throws Exception;
	
	/**
	 * 
	 * 描述: 保存仓库详细信息并且保存日志
	 * @auther chenxin
	 * @date 2016年9月29日 
	 * @param foodstorageAuxList
	 * @param logCollector
	 * @return boolean
	 */
	public boolean saveFoodstorageAuxAddLog(List<FoodstorageAux> foodstorageAuxList,List<SysLogTable> logCollector)throws Exception;
	
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
	public boolean modFoodstorageAuxAddLog(String fsInfoId,List<FoodstorageAux> foodstorageAuxList,List<SysLogTable> logCollector)throws Exception;
	
	
	/**
	 * 
	 * 描述: 删除仓库详细信息并且保存日志
	 * @auther chenxin
	 * @date 2016年9月29日 
	 * @param fsInfoId
	 * @param logCollector
	 * @return boolean
	 */
	public boolean rmFoodstorageAuxAddLog(String fsInfoId,List<SysLogTable> logCollector)throws Exception;
	
	
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
	public boolean rmFoodstorageAuxAddLog(String priPID,Integer year,List<SysLogTable> logCollector)throws Exception;
	
	/**
	 * 
	 * 描述: 批量删除仓库详细信息并且保存日志
	 * @auther chenxin
	 * @date 2016年9月29日 
	 * @param fsInfoIdList
	 * @param logCollector
	 * @return boolean
	 */
	public boolean rmBatchFoodstorageAuxAddLog(List<String> fsInfoIdList,List<SysLogTable> logCollector)throws Exception;
    
	/**
	 * 
	 * 描述: 根据年份和主题身份代码删除仓库详细信息
	 * @auther yujingwei
	 * @date 2016年9月29日 
	 * @param priPID
	 * @param Year
	 * @return boolean
	 */
	public boolean deleteStorageAuxInfo(String priPID, int year) throws Exception;
}