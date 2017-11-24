/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.service;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.system.model.SysLogTable;
import com.icinfo.cs.yr.dto.FoodstorageBaseDto;
import com.icinfo.cs.yr.dto.FoodstorageCountDto;
import com.icinfo.cs.yr.model.FoodstorageBase;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_foodstorage_base 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2016年09月26日
 */
public interface IFoodstorageBaseService extends BaseService {
	/**
	 * 描述: 获取食品仓储信息查询列表list数据（工商端）
     * @auther chenxin
     * @date 2016年09月23日 
	 * @param request
	 * @return List<FoodstorageBaseDto>
	 */
	public List<FoodstorageBaseDto> queryPage(PageRequest request);
	
	/**
	 * 描述: 获取本年度食品仓储退回列表列表list数据（工商端）
	 * @auther chenxin
	 * @date 2016年09月27日 
	 * @param request
	 * @return List<FoodstorageBaseDto>
	 */
	public List<FoodstorageBaseDto> queryBaseBackPage(PageRequest request);
	
	/**
	 * 
	 * 描述: 查询食品仓储详细信息（工商端）
	 * @auther chenxin
	 * @date 2016年9月26日 
	 * @param map
	 * @return ModApplicationDto
	 */
	public FoodstorageBase selecFoodstorageBaseById(Map<String, Object> map);
	

	/**
	 * 
	 * 描述: 根据序号和年度查询食品仓储信息（公用）
	 * @auther chenxin
	 * @date 2016年9月26日 
	 * @param priPID
	 * @param year
	 * @return FoodstorageBase
	 */
	public FoodstorageBase selecFoodstorageBaseByPriPIDandYear(String priPID,Integer year);
	
	
	/**
	 * 
	 * 描述: 根据序号和年度查询食品仓储退回信息（公用）
	 * @auther chenxin
	 * @date 2016年9月28日 
	 * @param priPID
	 * @param year
	 * @return FoodstorageBase
	 */
	public FoodstorageBaseDto selecFoodstorageBaseDtoById(Map<String, Object> map);
	
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
	public boolean applyFoodStorageBaseAddLog(String priPID,Integer year,List<SysLogTable> logCollector)throws Exception;
	
	/**
	 * 
	 * 描述: 保存食品仓储基本信息（公用）
	 * @auther chenxin
	 * @date 2016年9月29日 
	 * @param foodstorageBase
	 * @param logCollector
	 * @return boolean
	 */
	public boolean saveFoodstorageBaseAddLog(FoodstorageBase foodstorageBase,List<SysLogTable> logCollector)throws Exception;
	
	
	/**
	 * 
	 * 描述: 修改食品仓储基本信息（公用）
	 * @auther chenxin
	 * @date 2016年9月29日 
	 * @param foodstorageBase
	 * @param logCollector
	 * @return boolean
	 */
	public boolean modFoodstorageBaseAddLog(FoodstorageBase foodstorageBase,List<SysLogTable> logCollector)throws Exception;
    
	/**
	 * 
	 * 描述: 通过pripId和year 删除所有食品仓储相关信息
	 * @auther chenxin
	 * @date 2016年9月29日 
	 * @param foodstorageBase
	 * @param logCollector
	 * @return boolean
	 */
	public boolean deleteAllByPripidAndYear(String priPID, int year) throws Exception;
	
	
	/**
	 * 
	 * 描述   食品仓储统计
	 * @author 赵祥江
	 * @date 2017年5月8日 下午7:11:54 
	 * @param 
	 * @return List<FoodstorageCountDto>
	 * @throws
	 */
	public List<FoodstorageCountDto>  queryFoodstorageCountPage(PageRequest request);
    
	/**
	 * 描述: 判断是否属于食品仓储企业
	 * @auther yujingwei
	 * @date 2016年9月29日 
	 * @param priPID
	 * @return boolean
	 */
	public boolean doJudgeIsFoodStorageEnt(String priPID) throws Exception;
}