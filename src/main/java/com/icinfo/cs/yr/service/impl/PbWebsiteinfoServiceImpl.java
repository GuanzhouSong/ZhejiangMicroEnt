/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.yr.dto.PbWebsiteinfoDto;
import com.icinfo.cs.yr.mapper.PbWebsiteinfoMapper;
import com.icinfo.cs.yr.model.PbWebsiteinfo;
import com.icinfo.cs.yr.service.IPbWebsiteinfoService;
import com.icinfo.framework.core.exception.BusinessException;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述: cs_pb_websiteinfo 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年09月12日
 */
@Service
public class PbWebsiteinfoServiceImpl extends MyBatisServiceSupport implements IPbWebsiteinfoService {

	@Autowired
	private PbWebsiteinfoMapper pbWebsiteinfoMapper;

	/**
	 * 
	 * 描述: 通过年报id查询个体户公示网站信息（相当于查询整个年份）
	 * 
	 * @auther gaojinling
	 * @date 2016年9月12日
	 * @param anCheID
	 * @return
	 */
	public List<PbWebsiteinfo> selectPbWebsiteListByPriPidAndYear(String anCheID) {
		Example example = new Example(PbWebsiteinfo.class);
		example.createCriteria().andEqualTo("anCheID", anCheID);
		return pbWebsiteinfoMapper.selectByExample(example);
	}

	/**
	 * 
	 * 描述: 通过年报id查询个体户公示网站信息（分页）
	 * 
	 * @auther gaojinling
	 * @date 2016年9月12日
	 * @param request
	 * @return
	 */
	public List<PbWebsiteinfo> queryPbWebsitePage(PageRequest request) {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		Example example = new Example(PbWebsiteinfo.class);
		example.createCriteria().andEqualTo("anCheID", request.getParams().get("anCheID").toString());
		return pbWebsiteinfoMapper.selectByExample(example);
	}

	/***
	 * 
	 * 描述: 添加（null字段保存，且不使用默认值）
	 * 
	 * @auther gaojinling
	 * @date 2016年8月29日
	 * @param pbWebsiteinfo
	 * @return
	 */
	public int savePbWebsiteinfo(PbWebsiteinfo pbWebsiteinfo) {
		pbWebsiteinfo.setCreateTime(new Date());
		return pbWebsiteinfoMapper.insert(pbWebsiteinfo);
	}

	/**
	 * 
	 * 描述: 更新（通过年报id更新）
	 * 
	 * @auther gaojinling
	 * @date 2016年8月31日
	 * @param pbWebsiteinfo
	 * @return
	 */
	public int updatePbWebsiteinfo(PbWebsiteinfo pbWebsiteinfo) {
		pbWebsiteinfo.setCreateTime(new Date());
		Example example = new Example(PbWebsiteinfo.class);
		example.createCriteria().andEqualTo("WEBID", pbWebsiteinfo.getWebid());
		return pbWebsiteinfoMapper.updateByExampleSelective(pbWebsiteinfo, example);
	}

	/**
	 * 
	 * 描述: 删除(根据年报id删除，相当于删除整个年份)
	 * 
	 * @auther gaojinling
	 * @date 2016年9月12日
	 * @param pbWebsiteinfo
	 * @return
	 */
	public int deletePbWebsiteinfoByAnCheID(PbWebsiteinfo pbWebsiteinfo) {
		Example example = new Example(PbWebsiteinfo.class);
		example.createCriteria().andEqualTo("anCheID", pbWebsiteinfo.getAnCheID());
		return pbWebsiteinfoMapper.deleteByExample(example);
	}

	/**
	 * 
	 * 描述: 删除(根据主键id删除 单个删除)
	 * 
	 * @auther gaojinling
	 * @date 2016年9月12日
	 * @param pbWebsiteinfo
	 * @return
	 */
	public int deletePbWebsiteinfoBy(PbWebsiteinfo pbWebsiteinfo) {
		Example example = new Example(PbWebsiteinfo.class);
		example.createCriteria().andEqualTo("WEBID", pbWebsiteinfo.getWebid());
		return pbWebsiteinfoMapper.deleteByExample(example);
	}

	@Override
	public List<PbWebsiteinfoDto> queryPage(PageRequest request) {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		return pbWebsiteinfoMapper.queryPageResult(request.getParams());
	}

	/**
	 * 描述: 根据年报ID 获取网店网站
	 * 
	 * @auther ZhouYan
	 * @date 2016年10月10日
	 * @param anCheID
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<PbWebsiteinfo> selectPbWebsiteInfoByAnCheID(String anCheID) throws Exception {
		try {
			PbWebsiteinfo pbWebsiteInfo = new PbWebsiteinfo();
			pbWebsiteInfo.setAnCheID(anCheID);
			return pbWebsiteinfoMapper.select(pbWebsiteInfo);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException("根据年报ID 获取网店网站失败!");
		}
	}

	/**
	 * 描述: 根据年报id删除公示信息
	 * 
	 * @auther ZhouYan
	 * @date 2016年10月10日
	 * @param anCheID
	 * @return
	 * @throws Exception
	 */
	@Override
	public int deleteByAnCheID(String anCheID) throws Exception {
		Example example = new Example(PbWebsiteinfo.class);
		example.createCriteria().andEqualTo(Constants.CS_ANCHEID, anCheID);
		return pbWebsiteinfoMapper.deleteByExample(example);
	}

	/**
	 * 描述: 根据年报id保存公示信息
	 * 
	 * @auther ZhouYan
	 * @date 2016年10月10日
	 * @param anCheID
	 * @return
	 * @throws Exception
	 */
	@Override
	public int insertByAnCheID(String anCheID) throws Exception {
		return pbWebsiteinfoMapper.insertByAnCheID(anCheID);
	}

	@Override
	public List<PbWebsiteinfoDto> queryListResult(String anCheID) {
		Map<String, Object> queryMap = new HashMap<String, Object>();
		queryMap.put("anCheID", anCheID);
		List<PbWebsiteinfoDto> pbWebsiteinfoDtoList = pbWebsiteinfoMapper.queryPageResult(queryMap);
		return pbWebsiteinfoDtoList;
	}

	/** 
	 * 描述: 保存公示信息
	 * @auther ZhouYan
	 * @date 2016年11月11日 
	 * @param pbWebsiteinfo
	 * @return
	 * @throws Exception 
	 */
	@Override
	public int insert(PbWebsiteinfo pbWebsiteinfo) throws Exception {
		return pbWebsiteinfoMapper.insert(pbWebsiteinfo);
	}
	
}