/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.common.constant.LogTables;
import com.icinfo.cs.common.constant.OperationTypes;
import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.common.utils.ObjectComparator;
import com.icinfo.cs.system.model.SysLogJsonItem;
import com.icinfo.cs.system.model.SysLogTable;
import com.icinfo.cs.yr.mapper.FoodstorageLicenseMapper;
import com.icinfo.cs.yr.model.FoodstorageLicense;
import com.icinfo.cs.yr.service.IFoodstorageLicenseService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_foodstorage_license 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年09月26日
 */
@Service
public class FoodstorageLicenseServiceImpl extends MyBatisServiceSupport implements IFoodstorageLicenseService {
	@Autowired
	private FoodstorageLicenseMapper foodstorageLicenseMapper;
	
	/**
	 * 描述: 获取许可证列表（公用）
     * @auther chenxin
     * @date 2016年09月26日 
	 * @param request
	 * @return
	 */
	@Override
	public List<FoodstorageLicense> queryPage(PageRequest request) {
		List<FoodstorageLicense> foodstorageLicenseList = null;
		if(request != null && request.getParams() != null && request.getParams().get("priPID") != null
				&& request.getParams().get("licType") != null && request.getParams().get("year") != null){
			PageHelper.startPage(request.getPageNum(), request.getLength());
			String priPID = (String)request.getParams().get("priPID");
			String licType = (String)request.getParams().get("licType");
			String year = (String)request.getParams().get("year");
			if(StringUtils.isNotEmpty(priPID) && StringUtils.isNotEmpty(licType) && StringUtils.isNotEmpty(year)){
				Example example=new Example(FoodstorageLicense.class);
				example.createCriteria()
				.andEqualTo("priPID", priPID)
				.andEqualTo("licType", licType)
				.andEqualTo("year",year);
				foodstorageLicenseList = foodstorageLicenseMapper.selectByExample(example);
			}
		}
		return foodstorageLicenseList;
	}
	
	/**
	 * 
	 * 描述: 保存许可证和日志
	 * @auther chenxin
	 * @date 2016年9月29日 
	 * @param foodstorageLicense
	 * @param logCollector
	 * @return boolean
	 */
	@Transactional(rollbackFor=Exception.class)
	@Override
	public boolean saveFoodstorageLicenseAddLog(FoodstorageLicense foodstorageLicense,List<SysLogTable> logCollector) throws Exception {
		if(doAddLog4AddFoodStorageLicense(foodstorageLicense, logCollector)){
			if(foodstorageLicenseMapper.insertSelective(foodstorageLicense)>0){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 
	 * 描述: 修改许可证和日志
	 * @auther chenxin
	 * @date 2016年9月29日 
	 * @param foodstorageLicense
	 * @param logCollector
	 * @return boolean
	 */
	@Transactional(rollbackFor=Exception.class)
	@Override
	public boolean modFoodstorageLicenseAddLog(FoodstorageLicense foodstorageLicense,List<SysLogTable> logCollector) throws Exception {
		if(doAddLog4ModFoodStorageLicense(foodstorageLicense, logCollector)){
			if(foodstorageLicenseMapper.updateByPrimaryKeySelective(foodstorageLicense) > 0){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 
	 * 描述: 记录新增许可证日志
	 * @auther chenxin
	 * @date 2016年9月29日 
	 * @param foodStorageLicense
	 * @param logCollector
	 * @return boolean
	 */
	private boolean doAddLog4AddFoodStorageLicense(FoodstorageLicense foodStorageLicense,
		List<SysLogTable> logCollector) throws Exception {
		SysLogTable logTable = SysLogTable.generateLogTable(LogTables.CS_FOODSTORAGE_LICENSE.getCode(),null , foodStorageLicense, OperationTypes.INSERT.getCode());	
		if(logTable!=null){
			logCollector.add(logTable);
		} 
		return true;
	}
	
	/**
	 * 
	 * 描述: 记录修改许可证日志
	 * @auther chenxin
	 * @date 2016年9月29日 
	 * @param foodStorageLicense
	 * @param logCollector
	 * @return boolean
	 */
	private boolean doAddLog4ModFoodStorageLicense(FoodstorageLicense foodStorageLicense,List<SysLogTable> logCollector) throws Exception {
		if(foodStorageLicense != null && foodStorageLicense.getId() != null){
			FoodstorageLicense foodstorageLicenseParam = new FoodstorageLicense();
			foodstorageLicenseParam.setId(foodStorageLicense.getId());
			FoodstorageLicense dbFoodstorageLicense = foodstorageLicenseMapper.selectOne(foodstorageLicenseParam);
			List<SysLogJsonItem> logJsonItemList = ObjectComparator.compareObject(dbFoodstorageLicense, foodStorageLicense);
			SysLogTable logTable = SysLogTable.generateLogTable(LogTables.CS_FOODSTORAGE_LICENSE.getCode(), logJsonItemList, null, OperationTypes.UPDATE.getCode());	
			if(logTable!=null){
				logCollector.add(logTable);
    		} 
			return true;
		}
    	return false;
	}
	
	/**
	 * 
	 * 描述: 删除许可证和日志
	 * @auther chenxin
	 * @date 2016年9月29日 
	 * @param foodstorageLicenseId
	 * @param logCollector
	 * @return boolean
	 */
	@Transactional(rollbackFor=Exception.class)
	@Override
	public boolean rmFoodstorageLicenseAddLog(Integer foodstorageLicenseId,List<SysLogTable> logCollector) throws Exception {
		if(doAddLog4DelFoodStorageLicense(foodstorageLicenseId, logCollector)){
			if(foodstorageLicenseMapper.deleteByPrimaryKey(foodstorageLicenseId) > 0){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 
	 * 描述: 保存许可证和日志
	 * @auther chenxin
	 * @date 2016年9月29日 
	 * @param foodstorageLicenseIdList
	 * @param logCollector
	 * @return boolean
	 */
	@Transactional(rollbackFor=Exception.class)
	@Override
	public boolean rmBatchFoodstorageLicenseAddLog(List<Integer> foodstorageLicenseIdList,List<SysLogTable> logCollector) throws Exception {
		for (Integer foodstorageLicenseId : foodstorageLicenseIdList) {
			if(!rmFoodstorageLicenseAddLog(foodstorageLicenseId, logCollector)){
				return false;
			}
		}
		return true;
	}
	
	/**
	 * 
	 * 描述: 删除许可证日志
	 * @auther chenxin
	 * @date 2016年9月29日 
	 * @param foodStorageLicense
	 * @param logCollector
	 * @return boolean
	 */
	private boolean doAddLog4DelFoodStorageLicense(Integer foodstorageLicenseId,List<SysLogTable> logCollector) throws Exception {
		FoodstorageLicense foodStorageLicense = foodstorageLicenseMapper.selectByPrimaryKey(foodstorageLicenseId);
		SysLogTable logTable = SysLogTable.generateLogTable(LogTables.CS_FOODSTORAGE_LICENSE.getCode(),null , foodStorageLicense, OperationTypes.DELETE.getCode());	
		if(logTable!=null){
			logCollector.add(logTable);
		} 
		return true;
	}
	
	/**
	 * 
	 * 描述: 根据ID查询FoodstorageLicense
	 * @auther chenxin
	 * @date 2016年9月29日 
	 * @param id
	 * @return FoodstorageLicense
	 */
	@Override
	public FoodstorageLicense searchFoodstorageLicenseByFsInfoIdAndPriPID(Integer id,String priPID)throws Exception {
		FoodstorageLicense foodstorageLicense = new FoodstorageLicense();
		foodstorageLicense.setId(id);
		foodstorageLicense.setPriPID(priPID);
		return foodstorageLicenseMapper.selectOne(foodstorageLicense);
	}
	
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
	public boolean deleteLicenseInfo(String licType, String priPID, int year) throws Exception{
		Example example = new Example(FoodstorageLicense.class);
		example.createCriteria().andEqualTo(Constants.CS_PRIPID, priPID)
		   .andEqualTo(Constants.CS_YEAR, year).andEqualTo("licType", licType);
		if(foodstorageLicenseMapper.deleteByExample(example) < 0){
			return false;
		}
		return true;
	}
}