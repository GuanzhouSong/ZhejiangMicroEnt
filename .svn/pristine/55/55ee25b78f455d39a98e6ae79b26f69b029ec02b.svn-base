/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.service;

import java.util.List;

import com.icinfo.cs.system.model.SysLogTable;
import com.icinfo.cs.yr.dto.FoodstorageInfoDto;
import com.icinfo.cs.yr.model.FoodstorageAux;
import com.icinfo.cs.yr.model.FoodstorageInfo;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_foodstorage_info 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2016年09月26日
 */
public interface IFoodstorageInfoService extends BaseService {
	/**
	 * 描述: 获取仓库列表（工商段）
     * @auther chenxin
     * @date 2016年09月26日 
	 * @param request
	 * @return
	 */
	public List<FoodstorageInfo> queryPage(PageRequest request);
	
	/**
	 * 
	 * 描述: 根据ID查询FoodstorageInfoDto（企业端）
	 * @auther chenxin
	 * @date 2016年9月29日 
	 * @param fsInfoId
	 * @param priPID
	 * @return FoodstorageInfoDto
	 */
	public FoodstorageInfoDto searchFoodstorageInfoByFsInfoIdAndPriPID(String fsInfoId,String priPID)throws Exception;
	
	/**
	 * 
	 * 描述: 根据ID查询FoodstorageInfo（工商段）
	 * @auther chenxin
	 * @date 2016年9月29日 
	 * @param fsInfoId
	 * @return FoodstorageInfo
	 */
	public FoodstorageInfo searchFoodstorageInfoByFsInfoId(String fsInfoId)throws Exception;
	
	/**
	 * 
	 * 描述: 保存仓库信息并且保存日志
	 * @auther chenxin
	 * @date 2016年9月29日 
	 * @param foodstorageInfo
	 * @param foodstorageAux
	 * @param logCollector
	 * @return boolean
	 */
	public boolean saveFoodstorageInfoAndAuxAddLog(FoodstorageInfo foodstorageInfo,List<FoodstorageAux> foodstorageAuxList,List<SysLogTable> logCollector)throws Exception;
	
	
	/**
	 * 
	 * 描述: 修改仓库信息并且保存日志
	 * @auther chenxin
	 * @date 2016年9月29日 
	 * @param foodstorageInfo
	 * @param logCollector
	 * @return boolean
	 */
	public boolean modFoodstorageInfoAndAuxAddLog(FoodstorageInfo foodstorageInfo,List<FoodstorageAux> foodstorageAuxList,List<SysLogTable> logCollector)throws Exception;
	
	/**
	 * 
	 * 描述: 删除仓库信息并且保存日志
	 * @auther chenxin
	 * @date 2016年9月29日 
	 * @param fsInfoId
	 * @param logCollector
	 * @return boolean
	 */
	public boolean rmFoodstorageInfoAndAuxAddLog(String fsInfoId,List<SysLogTable> logCollector)throws Exception;
	
	/**
	 * 
	 * 描述: 批量删除仓库信息并且保存日志
	 * @auther chenxin
	 * @date 2016年9月29日 
	 * @param fsInfoIdList
	 * @param logCollector
	 * @return boolean
	 */
	public boolean rmBatchFoodstorageInfoAndAuxAddLog(List<String> fsInfoIdList,List<SysLogTable> logCollector)throws Exception;
	/**
	 * 描述: 获取仓库列表（企业端）
     * @auther chenxin
     * @date 2016年09月26日 
	 * @param request
	 * @return
	 */
	public List<FoodstorageInfoDto> queryPageForClient(PageRequest request) throws Exception;
    
	/**
	 * 描述: 删除仓库信息（通过priPid 和 year）
     * @auther yujingwei
     * @date 2016年09月26日 
	 * @param priPID
	 * @param year
	 * @return boolean
	 */
	public boolean deleteStorageInfo(String priPID, int year) throws Exception;
}