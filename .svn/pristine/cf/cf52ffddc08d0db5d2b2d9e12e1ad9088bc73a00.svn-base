/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.yr.mapper.YrSfcBranchInfoMapper;
import com.icinfo.cs.yr.model.YrSfcBranchInfo;
import com.icinfo.cs.yr.service.IYrSfcBranchInfoService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.tools.utils.StringUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:    cs_yr_sfc_branchinfo 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年09月27日
 */
@Service
public class YrSfcBranchInfoServiceImpl extends MyBatisServiceSupport implements IYrSfcBranchInfoService {

	@Autowired
	private YrSfcBranchInfoMapper yrSfcBranchInfoMapper;
	/**
	 * 
	 * 描述: 根据主体代码和年份（无分页）
	 * @auther gaojinling
	 * @date 2016年9月12日 
	 * @param anCheID
	 * @return
	 */
	public List<YrSfcBranchInfo> selectSfcBranchListByAnCheID(String anCheID) {
		Example example = new Example(YrSfcBranchInfo.class);
		example.createCriteria().andEqualTo("anCheID",anCheID);
		return yrSfcBranchInfoMapper.selectByExample(example);
	}

	/**
	 * 
	 * 描述: 根据年报id查询(分页查询)
	 * @auther gaojinling
	 * @date 2016年9月11日 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<YrSfcBranchInfo> queryPageByAnCheID(PageRequest request)
			throws Exception {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		Example example = new Example(YrSfcBranchInfo.class);
		example.createCriteria().andEqualTo("anCheID",request.getParams().get("anCheID"));
		return yrSfcBranchInfoMapper.selectByExample(example);
	}

	/**
	 * 
	 * 描述: 单个（主键查询）
	 * @auther gaojinling
	 * @date 2016年9月24日 
	 * @param LicId
	 * @return
	 */
	public YrSfcBranchInfo selectOneByBrID(String brID) {
		if(StringUtils.isNotBlank(brID)){
			YrSfcBranchInfo yrSfcBranchInfo = new YrSfcBranchInfo();
			yrSfcBranchInfo.setBrID(brID);
			return yrSfcBranchInfoMapper.selectOne(yrSfcBranchInfo);
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
	public int saveYrSfcBranchInfo(YrSfcBranchInfo yrSfcBranchInfo)
			throws Exception {
		if(yrSfcBranchInfo != null){
			yrSfcBranchInfo.setCreateTime(new Date());
			return yrSfcBranchInfoMapper.insert(yrSfcBranchInfo);	
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
	public int updateYrSfcBranchInfo(YrSfcBranchInfo yrSfcBranchInfo)
			throws Exception {
		if(StringUtil.isNotBlank(yrSfcBranchInfo.getBrID())){
			yrSfcBranchInfo.setCreateTime(new Date());
			Example example= new Example(YrSfcBranchInfo.class);
			example.createCriteria().andEqualTo("brID", yrSfcBranchInfo.getBrID());
			return yrSfcBranchInfoMapper.updateByExample(yrSfcBranchInfo, example);
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
	public int deleteYrSfcBranchInfoRtn(String brIDs) throws Exception {
		Example example= new Example(YrSfcBranchInfo.class);
		List<String> idsList=new ArrayList<String>();
		//数组转换成LIST
		Collections.addAll(idsList, brIDs.split(","));
		if(idsList.size()>0){
			example.createCriteria().andIn("brID", idsList);
			return yrSfcBranchInfoMapper.deleteByExample(example);
		}
		return 0;
	}
	
	
}