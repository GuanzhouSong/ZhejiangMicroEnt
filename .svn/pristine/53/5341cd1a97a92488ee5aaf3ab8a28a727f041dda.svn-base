/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.yr.mapper.YrPbLicenceInfoMapper;
import com.icinfo.cs.yr.model.YrPbLicenceInfo;
import com.icinfo.cs.yr.service.IYrPbLicenceInfoService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.tools.utils.StringUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:    cs_yr_pb_licenceinfo 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年09月10日
 */
@Service
public class YrPbLicenceInfoServiceImpl extends MyBatisServiceSupport implements IYrPbLicenceInfoService {
	@Autowired
	private YrPbLicenceInfoMapper yrPbLicenceInfoMapper;
	 
	
	/**
	 * 
	 * 描述: 根据主体代码和年份查询个体户许可信息（无分页）（由于现有的表中无年份和主体代码，换为年报id查询）
	 * @auther gaojinling
	 * @date 2016年9月12日 
	 * @param anCheID
	 * @return
	 */
	public List<YrPbLicenceInfo> selectPbLicenceListByAnCheID(String anCheID) {
	Example example = new Example(YrPbLicenceInfo.class);
	example.createCriteria().andEqualTo("anCheID",anCheID);
	return yrPbLicenceInfoMapper.selectByExample(example);
    }	
	
	/**
	 * 
	 * 描述: 根据年报id查询个体户许可信息(分页查询)
	 * @auther gaojinling
	 * @date 2016年9月11日 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<YrPbLicenceInfo> queryPageByAnCheID(PageRequest request)
			throws Exception {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		Example example = new Example(YrPbLicenceInfo.class);
		example.createCriteria().andEqualTo("anCheID",request.getParams().get("anCheID"));
		return yrPbLicenceInfoMapper.selectByExample(example);
	} 
	
	
	/**
	 * 
	 * 描述: 添加（单个）
	 * @auther gaojinling
	 * @date 2016年9月11日 
	 * @param yrPbBaseInfo
	 * @return
	 */
	@Override
	public int saveYrPbLicenceInfo(YrPbLicenceInfo yrPbLicenceInfo) throws Exception {
		if(yrPbLicenceInfo != null){
			yrPbLicenceInfo.setCreateTime(new Date());
			return yrPbLicenceInfoMapper.insert(yrPbLicenceInfo);	
		}else{
			return 0 ;
		}
		
	}
	
	/**
	 * 
	 * 描述: 更新（通过主键）
	 * @auther gaojinling
	 * @date 2016年9月11日 
	 * @param YrPbLicenceList
	 * @throws Exception
	 */
	public int updateYrPbLicenceInfo(YrPbLicenceInfo yrPbLicenceInfo) throws Exception {
		if(StringUtil.isNotBlank(yrPbLicenceInfo.getLicID())){
			yrPbLicenceInfo.setCreateTime(new Date());
			Example example= new Example(YrPbLicenceInfo.class);
			example.createCriteria().andEqualTo("licID", yrPbLicenceInfo.getLicID());
			return yrPbLicenceInfoMapper.updateByExample(yrPbLicenceInfo, example);
		}else{
			return 0 ;
		}
	}
	
	/**
	 * 
	 * 描述: 批量删除（通过主键）
	 * @auther gaojinling
	 * @date 2016年9月11日 
	 * @param YrPbLicenceList
	 * @throws Exception
	 */
	public int deleteYrPbLicenceInfoRtn(String licenceIds) throws Exception {
		Example example= new Example(YrPbLicenceInfo.class);
		List<String> idsList=new ArrayList<String>();
		//数组转换成LIST
		Collections.addAll(idsList, licenceIds.split(","));
		if(idsList.size()>0){
			example.createCriteria().andIn("licID", idsList);
			return yrPbLicenceInfoMapper.deleteByExample(example);
		}
		return 0;
	}


	/**
	 * 
	 * 描述:查询单个许可信息
	 * @auther gaojinling
	 * @date 2016年9月24日 
	 * @param LicId
	 * @return
	 */
	public YrPbLicenceInfo selectOneByLicId(String licID) {
		if(StringUtils.isNotBlank(licID)){
			YrPbLicenceInfo yrPbLicenceInfo = new YrPbLicenceInfo();
			yrPbLicenceInfo.setLicID(licID);
			return yrPbLicenceInfoMapper.selectOne(yrPbLicenceInfo);
		}else{
			return null;
		}
	}
	
	
//	/**
//	 * 
//	 * 描述: 根据主体代码和年份查询个体户许可信息（无分页）（由于现有的表中无年份和主体代码，换为年报id查询）
//	 * @auther gaojinling
//	 * @date 2016年9月11日 
//	 * @param PriPID
//	 * @param year
//	 * @return
//	 */
//	public List<YrPbLicenceInfo> selectPbLicenceListByPriPidAndYear(String priPID, int year) {
//		Example example = new Example(YrPbLicenceInfo.class);
//		example.createCriteria().andEqualTo("priPID",priPID);
//		example.createCriteria().andEqualTo("year",year);
//		return yrPbLicenceInfoMapper.selectByExample(example);
//	}
	
//	/**
//	 * 
//	 * 描述: 根据主体代码和年份查询个体户许可信息(分页查询)
//	 * @auther gaojinling
//	 * @date 2016年9月11日 
//	 * @param request
//	 * @return
//	 * @throws Exception
//	 */
//	public List<YrPbLicenceInfo> queryPage(PageRequest request)
//			throws Exception {
//		PageHelper.startPage(request.getPageNum(), request.getLength());
//		Example example = new Example(YrPbLicenceInfo.class);
//		example.createCriteria().andEqualTo("priPID",request.getParams().get("priPID"));
//		example.createCriteria().andEqualTo("year",request.getParams().get("year"));
//		return yrPbLicenceInfoMapper.selectByExample(example);
//	}
}