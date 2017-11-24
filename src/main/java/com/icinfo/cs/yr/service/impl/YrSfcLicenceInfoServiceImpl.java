/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.yr.mapper.YrSfcLicenceInfoMapper;
import com.icinfo.cs.yr.model.YrSfcLicenceInfo;
import com.icinfo.cs.yr.service.IYrSfcLicenceInfoService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.tools.utils.StringUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:    cs_yr_sfc_licenceinfo 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年09月27日
 */
@Service
public class YrSfcLicenceInfoServiceImpl extends MyBatisServiceSupport implements IYrSfcLicenceInfoService {

	@Autowired
	private YrSfcLicenceInfoMapper yrSfcLicenceInfoMapper;
	
	/**
	 * 
	 * 描述: 根据主体代码和年份查询农专许可信息（无分页）（由于现有的表中无年份和主体代码，换为年报id查询）
	 * @auther gaojinling
	 * @date 2016年9月12日 
	 * @param anCheID
	 * @return
	 */
	@Override
	public List<YrSfcLicenceInfo> selectSfcLicenceListByAnCheID(String anCheID) {
		Example example = new Example(YrSfcLicenceInfo.class);
		example.createCriteria().andEqualTo("anCheID",anCheID);
		return yrSfcLicenceInfoMapper.selectByExample(example);
	}

	/**
	 * 
	 * 描述: 根据年报id查询许可信息(分页查询)
	 * @auther gaojinling
	 * @date 2016年9月11日 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<YrSfcLicenceInfo> queryPageByAnCheID(PageRequest request)
			throws Exception {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		Example example = new Example(YrSfcLicenceInfo.class);
		example.createCriteria().andEqualTo("anCheID",request.getParams().get("anCheID"));
		return yrSfcLicenceInfoMapper.selectByExample(example);
	}

	/**
	 * 
	 * 描述: 单个许可信息（主键查询）
	 * @auther gaojinling
	 * @date 2016年9月24日 
	 * @param LicId
	 * @return
	 */
	@Override
	public YrSfcLicenceInfo selectOneByLicId(String licID) {
		if(StringUtils.isNotBlank(licID)){
			YrSfcLicenceInfo yrsfcLicenceInfo = new YrSfcLicenceInfo();
			yrsfcLicenceInfo.setLicID(licID);
			return yrSfcLicenceInfoMapper.selectOne(yrsfcLicenceInfo);
		}else{
			return null;
		}
	}

	/**
	 * 
	 * 描述: 添加（单个）
	 * @auther gaojinling
	 * @date 2016年9月11日 
	 * @param YrSfcLicenceInfo
	 * @return
	 * @throws Exception
	 */
	@Override
	public int saveYrSfcLicenceInfo(YrSfcLicenceInfo yrSfcLicenceInfo)
			throws Exception {
		if(yrSfcLicenceInfo != null){
			yrSfcLicenceInfo.setCreateTime(new Date());
			return yrSfcLicenceInfoMapper.insert(yrSfcLicenceInfo);	
		}else{
			return 0 ;
		}
	}

	/**
	 * 
	 * 描述: 更新（单个）
	 * @auther gaojinling
	 * @date 2016年9月24日 
	 * @param YrSfcLicenceInfo
	 * @return
	 * @throws Exception
	 */
	@Override
	public int updateYrSfcLicenceInfo(YrSfcLicenceInfo yrSfcLicenceInfo)
			throws Exception {
		if(StringUtil.isNotBlank(yrSfcLicenceInfo.getLicID())){
			yrSfcLicenceInfo.setCreateTime(new Date());
			Example example= new Example(YrSfcLicenceInfo.class);
			example.createCriteria().andEqualTo("licID", yrSfcLicenceInfo.getLicID());
			return yrSfcLicenceInfoMapper.updateByExample(yrSfcLicenceInfo, example);
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
	@Override
	public int deleteYrSfcLicenceInfoRtn(String licenceIds) throws Exception {
		Example example= new Example(YrSfcLicenceInfo.class);
		List<String> idsList=new ArrayList<String>();
		//数组转换成LIST
		Collections.addAll(idsList, licenceIds.split(","));
		if(idsList.size()>0){
			example.createCriteria().andIn("licID", idsList);
			return yrSfcLicenceInfoMapper.deleteByExample(example);
		}
		return 0;
	}
}