/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.service;

import java.util.List;

import com.icinfo.cs.system.model.SysLogTable;
import com.icinfo.cs.yr.model.FoodstorageLicense;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_foodstorage_license 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2016年09月26日
 */
public interface IFoodstorageLicenseService extends BaseService {
	

	/**
	 * 描述: 获取许可证列表（公用）
     * @auther chenxin
     * @date 2016年09月26日 
	 * @param request
	 * @return
	 */
	public List<FoodstorageLicense> queryPage(PageRequest request);
	
	/**
	 * 
	 * 描述: 保存许可证和日志
	 * @auther chenxin
	 * @date 2016年9月29日 
	 * @param foodstorageLicense
	 * @param logCollector
	 * @return boolean
	 */
	public boolean saveFoodstorageLicenseAddLog(FoodstorageLicense foodstorageLicense,List<SysLogTable> logCollector)throws Exception;
	
	/**
	 * 
	 * 描述: 根据ID查询FoodstorageLicense
	 * @auther chenxin
	 * @date 2016年9月29日 
	 * @param id
	 * @return FoodstorageLicense
	 */
	public FoodstorageLicense searchFoodstorageLicenseByFsInfoIdAndPriPID(Integer id,String priPID)throws Exception;
	
	
	/**
	 * 
	 * 描述: 修改许可证和日志
	 * @auther chenxin
	 * @date 2016年9月29日 
	 * @param foodstorageLicense
	 * @param logCollector
	 * @return boolean
	 */
	public boolean modFoodstorageLicenseAddLog(FoodstorageLicense foodstorageLicense,List<SysLogTable> logCollector)throws Exception;
	
	/**
	 * 
	 * 描述: 删除许可证和日志
	 * @auther chenxin
	 * @date 2016年9月29日 
	 * @param foodstorageLicenseId
	 * @param logCollector
	 * @return boolean
	 */
	public boolean rmFoodstorageLicenseAddLog(Integer foodstorageLicenseId,List<SysLogTable> logCollector)throws Exception;
	
	/**
	 * 
	 * 描述: 批量许可证和日志
	 * @auther chenxin
	 * @date 2016年9月29日 
	 * @param foodstorageLicenseIdList
	 * @param logCollector
	 * @return boolean
	 */
	public boolean rmBatchFoodstorageLicenseAddLog(List<Integer> foodstorageLicenseIdList,List<SysLogTable> logCollector)throws Exception;
    
	/**
	 * 
	 * 描述: 删除所有许可证信息
	 * @auther yujingwei
	 * @date 2016年10月14日 
	 * @param licType
	 * @param priPID
	 * @param year
	 * @return boolean
	 */
	public boolean deleteLicenseInfo(String licType, String priPID, int year) throws Exception;
}