/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.yr.dto.PbLicenceinfoDto;
import com.icinfo.cs.yr.mapper.PbLicenceinfoMapper;
import com.icinfo.cs.yr.model.PbLicenceinfo;
import com.icinfo.cs.yr.service.IPbLicenceinfoService;
import com.icinfo.framework.core.exception.BusinessException;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_pb_licenceinfo 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年09月12日
 */
@Service
public class PbLicenceinfoServiceImpl extends MyBatisServiceSupport implements IPbLicenceinfoService {
	
	@Autowired
	private PbLicenceinfoMapper pbLicenceinfoMapper ;
	
	/**
	 * 
	 * 描述: 通过年报id查询个体户公示网站信息（相当于查询整个年份）
	 * @auther gaojinling
	 * @date 2016年9月12日 
	 * @param anCheID
	 * @return
	 */
	public List<PbLicenceinfo> selectPbLicenceListByPriPidAndYear(
			String anCheID) {
		Example example = new Example(PbLicenceinfo.class);
		example.createCriteria().andEqualTo("anCheID",anCheID);
		return pbLicenceinfoMapper.selectByExample(example);
	}
	
	
	/**
	 * 
	 * 描述: 通过年报id查询个体户公示网站信息（分页）
	 * @auther gaojinling
	 * @date 2016年9月12日 
	 * @param request
	 * @return
	 */
	public List<PbLicenceinfo> queryPbLicencePage(PageRequest request){
		PageHelper.startPage(request.getPageNum(), request.getLength());
		Example example = new Example(PbLicenceinfo.class);
		example.createCriteria().andEqualTo("anCheID",request.getParams().get("anCheID").toString());		
		return pbLicenceinfoMapper.selectByExample(example);
	}
	
	/***
	 * 
	 * 描述: 添加（null字段保存，且不使用默认值）
	 * @auther gaojinling
	 * @date 2016年8月29日 
	 * @param phoneApply
	 * @return
	 */
	public int savePbLicenceinfo(PbLicenceinfo pbLicenceinfo) {
		pbLicenceinfo.setCreateTime(new Date());
		return pbLicenceinfoMapper.insert(pbLicenceinfo);
	}
	
	/**
	 * 
	 * 描述: 更新（通过年报id更新）
	 * @auther gaojinling
	 * @date 2016年8月31日 
	 * @param phoneApply
	 * @return
	 */
	public int updatePbLicenceinfo(PbLicenceinfo pbLicenceinfo) {
		pbLicenceinfo.setCreateTime(new Date());
		Example example = new Example(PbLicenceinfo.class);
		example.createCriteria().andEqualTo("licID",pbLicenceinfo.getLicID());
		return pbLicenceinfoMapper.updateByExampleSelective(pbLicenceinfo, example);
	}
	
	/**
	 * 
	 * 描述: 删除(根据年报id删除，相当于删除整个年份)
	 * @auther gaojinling
	 * @date 2016年9月12日 
	 * @param pbWebsiteinfo
	 * @return
	 */
	public int deletePbLicenceinfoByAnCheID(PbLicenceinfo pbLicenceinfo){
		Example example = new Example(PbLicenceinfo.class);
		example.createCriteria().andEqualTo("anCheID",pbLicenceinfo.getAnCheID());
		return pbLicenceinfoMapper.deleteByExample(example);
	}
	
	
	/**
	 * 
	 * 描述: 删除(根据主键id删除 单个删除)
	 * @auther gaojinling
	 * @date 2016年9月12日 
	 * @param pbWebsiteinfo
	 * @return
	 */
	public int deletePbLicenceinfoByID(PbLicenceinfo pbLicenceinfo){
		Example example = new Example(PbLicenceinfo.class);
		example.createCriteria().andEqualTo("licID",pbLicenceinfo.getLicID());
		return pbLicenceinfoMapper.deleteByExample(example);
	}

	@Override
	public List<PbLicenceinfoDto> queryPage(PageRequest request) {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		return pbLicenceinfoMapper.queryPageResult(request.getParams());
	}


	/** 
	 * 描述: 根据年报ID 获取个体年报行政许可列表
	 * @auther ZhouYan
	 * @date 2016年10月10日 
	 * @param anCheID
	 * @return
	 * @throws Exception 
	 */
	@Override
	public List<PbLicenceinfo> selectPbLicenceinfoByAnCheID(String anCheID)
			throws Exception {
		try {
			PbLicenceinfo pbLicenceinfo=new PbLicenceinfo();
			pbLicenceinfo.setAnCheID(anCheID);
			return pbLicenceinfoMapper.select(pbLicenceinfo);
		} catch (Exception e) {
			e.printStackTrace();
            throw new BusinessException("根据年报ID 获取个体年报行政许可列表失败!");
		}
	}


	/** 
	 * 描述: 根据年报id删除公示信息
	 * @auther ZhouYan
	 * @date 2016年10月10日 
	 * @param anCheID
	 * @return
	 * @throws Exception 
	 */
	@Override
	public int deleteByAnCheID(String anCheID) throws Exception {
		Example example = new Example(PbLicenceinfo.class);
		example.createCriteria().andEqualTo(Constants.CS_ANCHEID, anCheID);
		return pbLicenceinfoMapper.deleteByExample(example);
	}


	/** 
	 * 描述: 根据年报id保存公示信息
	 * @auther ZhouYan
	 * @date 2016年10月10日 
	 * @param anCheID
	 * @return
	 * @throws Exception 
	 */
	@Override
	public int insertByAnCheID(String anCheID) throws Exception {
		return pbLicenceinfoMapper.insertByAnCheID(anCheID);
	}


	/** 
	 * 描述: 保存公示信息
	 * @auther ZhouYan
	 * @date 2016年11月11日 
	 * @param pbLicenceinfo
	 * @return
	 * @throws Exception 
	 */
	@Override
	public int insert(PbLicenceinfo pbLicenceinfo) throws Exception {
		return pbLicenceinfoMapper.insert(pbLicenceinfo);
	}
	
}