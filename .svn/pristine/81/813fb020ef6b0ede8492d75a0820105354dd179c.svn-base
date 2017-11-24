/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.yr.model.YrWebsiteInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.yr.mapper.YrSfcWebsiteInfoMapper;
import com.icinfo.cs.yr.model.YrSfcWebsiteInfo;
import com.icinfo.cs.yr.service.IYrSfcWebsiteInfoService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.tools.utils.StringUtils;
import com.icinfo.framework.tools.utils.DateUtils;

/**
 * 描述:    cs_yr_sfc_websiteinfo 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年09月27日
 */
@Service
public class YrSfcWebsiteInfoServiceImpl extends MyBatisServiceSupport implements IYrSfcWebsiteInfoService {

	@Autowired
	private YrSfcWebsiteInfoMapper yrSfcWebsiteInfoMapper;

	/**
	 *  新增
	 * @param yrSfcWebsiteInfo
	 * @return
	 */
	@Override
	public int insert(YrSfcWebsiteInfo yrSfcWebsiteInfo) {
		yrSfcWebsiteInfo.setCreateTime(DateUtils.getSysDate());
		return yrSfcWebsiteInfoMapper.insert(yrSfcWebsiteInfo);
	}

	/**
	 * 根据当前年份和主体身份代码查询网站网店列表
	 *@autor：wangjin
	 * @param year
	 * @param priPID
	 * @return
	 */
	@Override
	public List<YrSfcWebsiteInfo> selectByYearAndPriPID(Integer year, String priPID) {
		if(StringUtils.isNotBlank(priPID)&&year!=null){
			Example example=this.getExample(YrSfcWebsiteInfo.class);
			example.createCriteria().andEqualTo(Constants.CS_PRIPID, priPID).andEqualTo(Constants.CS_YEAR, year);
			example.setOrderByClause(" CreateTime desc ");
			return yrSfcWebsiteInfoMapper.selectByExample(example);
		}
		return null;
	}

	private Example getExample(Class<?> classObj){
		Example example=new Example(classObj);
		return example;
	}

	/**
	 * 单条删除
	 * @param webid
	 * @param priPID
     * @return
     */
	@Override
	public int deleteByWebidwebid(String webid, String priPID) {
		if(StringUtils.isNotBlank(webid)&&StringUtils.isNotBlank(priPID)){
			YrSfcWebsiteInfo yrSfcWebsiteInfo = new YrSfcWebsiteInfo();
			yrSfcWebsiteInfo.setWebID(webid);
			yrSfcWebsiteInfo.setPriPID(priPID);
			//采用的是物理删除
			return yrSfcWebsiteInfoMapper.delete(yrSfcWebsiteInfo);
		}
		return 0;
	}

	/**
	 * 描述：根据传入的参数 清空当前对象
	 * @author: wangjin
	 * @param yrSfcWebsiteInfo
	 * @return
	 */
	@Override
	public int deleteAll(YrSfcWebsiteInfo yrSfcWebsiteInfo) {
		Example example= new Example(YrWebsiteInfo.class);
		if(com.icinfo.cs.common.utils.StringUtil.checkYearAndPripid(yrSfcWebsiteInfo.getYear(),yrSfcWebsiteInfo.getPriPID())&& StringUtils.isNotBlank(yrSfcWebsiteInfo.getAnCheID())){
			example.createCriteria().andEqualTo("anCheID", yrSfcWebsiteInfo.getAnCheID()).andEqualTo(Constants.CS_PRIPID, yrSfcWebsiteInfo.getPriPID()).
					andEqualTo(Constants.CS_YEAR, yrSfcWebsiteInfo.getYear());
			return yrSfcWebsiteInfoMapper.deleteByExample(example);
		}
		return 0;
	}


	/**
	 *
	 * 描述: 根据年报id查农专网站信息（无分页）
	 * @auther gaojinling
	 * @date 2016年9月27日
	 * @param anCheID
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<YrSfcWebsiteInfo> selectSfcWebsiteListByanCheID(String anCheID)
			throws Exception {
		Example example = new Example(YrSfcWebsiteInfo.class);
		example.createCriteria().andEqualTo("anCheID",anCheID);
		return yrSfcWebsiteInfoMapper.selectByExample(example);
	}


	// TODO   --------------------------------------分割线-------------------------------

	/**
	 * 
	 * 描述: 根据年份和主体代码分页查询农专社网站信息（年报id）
	 * @auther gaojinling
	 * @date 2016年9月27日 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<YrSfcWebsiteInfo> queryPageByAnCheID(PageRequest request)
			throws Exception {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		Example example = new Example(YrSfcWebsiteInfo.class);
		example.createCriteria().andEqualTo("anCheID",request.getParams().get("anCheID"));
		return yrSfcWebsiteInfoMapper.selectByExample(example);
	}



	/**
	 * 
	 * 描述:  单个网站信息（主键查询）
	 * @auther gaojinling
	 * @date 2016年9月27日 
	 * @param webID
	 * @return
	 */
	@Override
	public YrSfcWebsiteInfo selectOneByWebId(String webID) {
		if(StringUtils.isNotBlank(webID)){
			YrSfcWebsiteInfo yrSfcWebsiteInfo = new YrSfcWebsiteInfo();
			yrSfcWebsiteInfo.setWebID(webID);
			return yrSfcWebsiteInfoMapper.selectOne(yrSfcWebsiteInfo);
		}else{
			return null;
		}
	}



	/**
	 * 
	 * 描述:  添加（单个）
	 * @auther gaojinling
	 * @date 2016年9月27日 
	 * @param yrSfcWebsiteInfo
	 * @return
	 * @throws Exception
	 */
	@Override
	public int saveYrSfcWebsiteInfo(YrSfcWebsiteInfo yrSfcWebsiteInfo)
			throws Exception {
		if(yrSfcWebsiteInfo != null){
			yrSfcWebsiteInfo.setCreateTime(new Date());
			return yrSfcWebsiteInfoMapper.insert(yrSfcWebsiteInfo);	
		}else{
			return 0 ;
		}
	}

	/**
	 * 
	 * 描述: 更新（单个）
	 * @auther gaojinling
	 * @date 2016年9月27日 
	 * @param yrSfcWebsiteInfo
	 * @return
	 * @throws Exception
	 */
	@Override
	public int updateYrSfcWebsiteInfo(YrSfcWebsiteInfo yrSfcWebsiteInfo)
			throws Exception {
		if(StringUtil.isNotBlank(yrSfcWebsiteInfo.getWebID())){
			yrSfcWebsiteInfo.setCreateTime(new Date());
			Example example= new Example(YrSfcWebsiteInfo.class);
			example.createCriteria().andEqualTo("webID", yrSfcWebsiteInfo.getWebID());
			return yrSfcWebsiteInfoMapper.updateByExample(yrSfcWebsiteInfo, example);
		}else{
			return 0 ;
		}
	}

	/**
	 * 
	 * 描述:  批量删除（通过主键）
	 * @auther gaojinling
	 * @date 2016年9月27日 
	 * @param webIds
	 * @return
	 * @throws Exception
	 */
	@Override
	public int deleteYrSfcWebsiteInfoRtn(String webIds) throws Exception {
		Example example= new Example(YrSfcWebsiteInfo.class);
		List<String> idsList=new ArrayList<String>();
		//数组转换成LIST
		Collections.addAll(idsList, webIds.split(","));
		if(idsList.size()>0){
			example.createCriteria().andIn("webID", idsList);
			return yrSfcWebsiteInfoMapper.deleteByExample(example);
		}
		return 0;
	}
	
	/**
	 * 
	 * 描述: 删除
	 * @auther gaojinling
	 * @date 2017年02月15日 
	 * @param webId
	 * @throws Exception
	 */
	@Override
	public int deleteByWebID(String webId) throws Exception {
		Example example= new Example(YrSfcWebsiteInfo.class);
		example.createCriteria().andEqualTo("webID", webId);
		return yrSfcWebsiteInfoMapper.deleteByExample(example);
	}
	

}