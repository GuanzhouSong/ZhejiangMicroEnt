/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.yr.dto.SfcLicenceInfoDto;
import com.icinfo.cs.yr.mapper.SfcLicenceInfoMapper;
import com.icinfo.cs.yr.model.SfcLicenceInfo;
import com.icinfo.cs.yr.service.ISfcLicenceInfoService;
import com.icinfo.framework.core.exception.BusinessException;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_sfc_licenceinfo 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年10月08日
 */
@Service
public class SfcLicenceInfoServiceImpl extends MyBatisServiceSupport implements ISfcLicenceInfoService {
	private static final Logger logger = LoggerFactory.getLogger(SfcLicenceInfoServiceImpl.class);
	@Autowired
	private SfcLicenceInfoMapper sfcLicenceInfoMapper;
	
	/**
	 * 
	 * 描述  根据年报ID查询许可证信息
	 * @author  赵祥江
	 * @date 2016年10月8日 下午3:38:59 
	 * @param  
	 * @throws
	 */
	@Override
	public List<SfcLicenceInfo> selectSfcLicenceInfoByAnCheID(String anCheID)
			throws Exception {
		try {
			SfcLicenceInfo sfcLicenceInfo=new SfcLicenceInfo();
			sfcLicenceInfo.setAnCheID(anCheID);
 			return sfcLicenceInfoMapper.select(sfcLicenceInfo);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("exception {}", "根据年报ID查询许可证信息失败!");
            throw new BusinessException("根据年报ID查询许可证信息失败!");
		}
	}

	@Override
	public List<SfcLicenceInfoDto> queryPage(PageRequest request) {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		return sfcLicenceInfoMapper.queryPageResult(request.getParams());
	}
	
	/**
	 * 
	 * 描述: 根据年报id删除公示信息
	 * @auther gaojinling
	 * @date 2016年10月11日 
	 * @param anCheID
	 * @return
	 * @throws Exception
	 */
	public int deleteByAnCheID(String anCheID) throws Exception{
		Example example = new Example(SfcLicenceInfo.class);
		example.createCriteria().andEqualTo(Constants.CS_ANCHEID, anCheID);
		return sfcLicenceInfoMapper.deleteByExample(example);
	}
	
	/**
	 * 描述：查询农专年报行政许可信息列表
	 * @author yujingwei
	 * @date 2016年10月10日
	 * @param request
	 * @return List<SfcLicenceInfo>
	 */
	public List<SfcLicenceInfo> queryPageInfo(PageRequest request) throws Exception{
		PageHelper.startPage(request.getPageNum(), request.getLength());
		List<SfcLicenceInfo> sfcLicenceInfoList = new ArrayList<SfcLicenceInfo>();
		if(request !=null && request.getParams() !=null){
			Example example = new Example(SfcLicenceInfo.class);
			example.createCriteria().andEqualTo(Constants.CS_ANCHEID, request.getParams().get("anCheID").toString());
			return sfcLicenceInfoMapper.selectByExample(example);
		}
		return sfcLicenceInfoList;
	}
	
	/**
	 * 
	 * 描述: 根据年报id保存公示信息
	 * @auther gaojinling
	 * @date 2016年10月11日 
	 * @param anCheID
	 * @return
	 * @throws Exception
	 */
	public int insertByAnCheID(String anCheID) throws Exception{
		return sfcLicenceInfoMapper.insertByAnCheID(anCheID);
	}

	/** 
	 * 描述: 保存公示信息
	 * @auther ZhouYan
	 * @date 2016年11月11日 
	 * @param sfcLicenceInfo
	 * @return
	 * @throws Exception 
	 */
	@Override
	public int insert(SfcLicenceInfo sfcLicenceInfo) throws Exception {
		// TODO Auto-generated method stub
		return sfcLicenceInfoMapper.insert(sfcLicenceInfo);
	}
	
}