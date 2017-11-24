/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.yr.mapper.YrPbWebsiteInfoMapper;
import com.icinfo.cs.yr.model.YrPbWebsiteInfo;
import com.icinfo.cs.yr.service.IYrPbWebsiteInfoService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.tools.utils.DateUtils;
import com.icinfo.framework.tools.utils.StringUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:    cs_yr_pb_websiteinfo 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年09月10日
 */
@Service
public class YrPbWebsiteInfoServiceImpl extends MyBatisServiceSupport implements IYrPbWebsiteInfoService {

	@Autowired
	private YrPbWebsiteInfoMapper yrPbWebsiteInfoMapper;
	
	
	/**
	 * 
	 * 描述: 根据年报id查询个体户网站信息（年报id 无分页） 
	 * @auther gaojinling
	 * @date 2016年9月11日 
	 * @param
	 * @param
	 * @return
	 */
	public List<YrPbWebsiteInfo> selectPbWebsiteListByanCheID(
			String anCheID) {
		Example example = new Example(YrPbWebsiteInfo.class);
		example.createCriteria().andEqualTo("anCheID",anCheID);
		example.setOrderByClause(" CreateTime desc ");
		return yrPbWebsiteInfoMapper.selectByExample(example);
	}
	
	
	/**
	 * 
	 * 描述: 根据年报id分页查询个体户网站信息（年报id）
	 * @auther gaojinling
	 * @date 2016年9月11日 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<YrPbWebsiteInfo> queryPageByAnCheID(PageRequest request) throws Exception {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		Example example = new Example(YrPbWebsiteInfo.class);
		example.createCriteria().andEqualTo("anCheID",request.getParams().get("anCheID"));
		return yrPbWebsiteInfoMapper.selectByExample(example);
	}
	
	/**
	 * 
	 * 描述: 单个网站信息（主键查询）
	 * @auther gaojinling
	 * @date 2016年9月24日 
	 * @param webID
	 * @return
	 */
	public YrPbWebsiteInfo selectOneByWebId(String webID) {
		if(StringUtils.isNotBlank(webID)){
			YrPbWebsiteInfo yrPbWebsiteInfo = new YrPbWebsiteInfo();
			yrPbWebsiteInfo.setWebID(webID);
			return yrPbWebsiteInfoMapper.selectOne(yrPbWebsiteInfo);
		}else{
			return null;
		}
	}


	/**
	 * 
	 * 描述: 添加（单个）
	 * @auther gaojinling
	 * @date 2016年9月11日 
	 * @param yrPbWebsiteInfo
	 * @return
	 * @throws Exception
	 */
	public int saveYrPbWebsiteInfo(YrPbWebsiteInfo yrPbWebsiteInfo)
			throws Exception {
		if(yrPbWebsiteInfo != null){
			yrPbWebsiteInfo.setCreateTime(new Date());
			return yrPbWebsiteInfoMapper.insert(yrPbWebsiteInfo);	
		}else{
			return 0 ;
		}
	}


	/**
	 * 
	 * 描述: 更新（单个）
	 * @auther gaojinling
	 * @date 2016年9月24日 
	 * @param yrPbWebsiteInfo
	 * @return
	 * @throws Exception
	 */
	public int updateYrPbWebsiteInfo(YrPbWebsiteInfo yrPbWebsiteInfo)
			throws Exception {
		if(StringUtil.isNotBlank(yrPbWebsiteInfo.getWebID())){
			yrPbWebsiteInfo.setCreateTime(new Date());
			Example example= new Example(YrPbWebsiteInfo.class);
			example.createCriteria().andEqualTo("webID", yrPbWebsiteInfo.getWebID());
			return yrPbWebsiteInfoMapper.updateByExample(yrPbWebsiteInfo, example);
		}else{
			return 0 ;
		}
	}
	

	/**
	 * 
	 * 描述: 批量删除（通过主键）
	 * @auther gaojinling
	 * @date 2016年9月11日 
	 * @param webIds
	 * @throws Exception
	 */
	public int deleteYrPbWebsiteInfoRtn(String webIds) throws Exception {
		Example example= new Example(YrPbWebsiteInfo.class);
		List<String> idsList=new ArrayList<String>();
		//数组转换成LIST
		Collections.addAll(idsList, webIds.split(","));
		if(idsList.size()>0){
			example.createCriteria().andIn("webID", idsList);
			return yrPbWebsiteInfoMapper.deleteByExample(example);
		}
		return 0;
	}
	
	/**
	 * 
	 * 描述: 单条删除
	 * @auther chenxin
	 * @date 2017年02月14日 
	 * @param
	 * @throws Exception
	 */
	public int deleteByWebID(String webId) throws Exception {
		Example example= new Example(YrPbWebsiteInfo.class);
		if(StringUtils.isNotBlank(webId)){
			example.createCriteria().andEqualTo("webID", webId);
			return yrPbWebsiteInfoMapper.deleteByExample(example);
		}
		return 0;
	}
	
	/**
	 * 
	 * 描述: 删除所有
	 * @auther chenxin
	 * @date 2017年02月27日 
	 * @param anCheID
	 * @throws Exception
	 */
	@Override
	public int deleteByAnCheID(String anCheID) throws Exception {
		Example example= new Example(YrPbWebsiteInfo.class);
		example.createCriteria().andEqualTo("anCheID", anCheID);
		return yrPbWebsiteInfoMapper.deleteByExample(example);
	}


	/**
	 * 描述：插入一条网站网店信息
	 * @param yrPbWebsiteInfo
	 * @return
	 */
	@Override
	public int insert(YrPbWebsiteInfo yrPbWebsiteInfo) {
		yrPbWebsiteInfo.setCreateTime(DateUtils.getSysDate());
		return yrPbWebsiteInfoMapper.insert(yrPbWebsiteInfo);
	}
	/**
	 * 描述：获取网站网店类列表
	 * @param anCheID
	 * @return
	 */
	@Override
	public List<YrPbWebsiteInfo> selectByAnCheID(String anCheID) {
		if(StringUtils.isNotBlank(anCheID)){
			Example example=this.getExample(YrPbWebsiteInfo.class);
			example.createCriteria().andEqualTo(Constants.CS_ANCHEID, anCheID);
			example.setOrderByClause(" CreateTime desc ");
			return yrPbWebsiteInfoMapper.selectByExample(example);
		}
		return null;
	}

	/**
	 * 描述：清空当前网站网店的所有数据
	 * @param yrPbWebsiteInfo
	 * @return
	 */
	@Override
	public int deleteAll(YrPbWebsiteInfo yrPbWebsiteInfo) {
		Example example= new Example(YrPbWebsiteInfo.class);
		if(StringUtils.isNotBlank(yrPbWebsiteInfo.getAnCheID())){
			example.createCriteria().andEqualTo("anCheID",yrPbWebsiteInfo.getAnCheID());
			return yrPbWebsiteInfoMapper.deleteByExample(example);
		}
		return 0;

	}
	private Example getExample(Class<?> classObj){
		Example example=new Example(classObj);
		return example;
	}

}