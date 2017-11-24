/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.yr.dto.SfcWebsiteInfoDto;
import com.icinfo.cs.yr.mapper.SfcWebsiteInfoMapper;
import com.icinfo.cs.yr.model.SfcWebsiteInfo;
import com.icinfo.cs.yr.service.ISfcWebsiteInfoService;
import com.icinfo.framework.core.exception.BusinessException;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_sfc_websiteinfo 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年10月08日
 */
@Service
public class SfcWebsiteInfoServiceImpl extends MyBatisServiceSupport implements ISfcWebsiteInfoService {
	private static final Logger logger = LoggerFactory.getLogger(SfcWebsiteInfoServiceImpl.class);
	@Autowired
	private SfcWebsiteInfoMapper sfcWebsiteInfoMapper;
	
	/**
	 * 
	 * 描述   根据年报ID查询网站网店信息
	 * @author  赵祥江
	 * @date 2016年10月8日 下午3:41:16 
	 * @param  
	 * @throws
	 */
	@Override
	public List<SfcWebsiteInfo> selectSfcWebsiteInfoByAnCheID(String anCheID)
			throws Exception {
		try {
			SfcWebsiteInfo sfcWebsiteInfo=new SfcWebsiteInfo();
			sfcWebsiteInfo.setAnCheID(anCheID);
 			return sfcWebsiteInfoMapper.select(sfcWebsiteInfo);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("exception {}", "根据年报ID查询网站网店信息失败!");
            throw new BusinessException("根据年报ID查询网站网店信息失败!");
		}
	}

	@Override
	public List<SfcWebsiteInfoDto> queryPage(PageRequest request) {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		return sfcWebsiteInfoMapper.queryPageResult(request.getParams());
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
		Example example = new Example(SfcWebsiteInfo.class);
		example.createCriteria().andEqualTo(Constants.CS_ANCHEID, anCheID);
		return sfcWebsiteInfoMapper.deleteByExample(example);
	}
     
	/**
	 * 描述：查询农专年报网站或网店列表(用于敏感词审核)
	 * @author yujingwei
	 * @date 2016年10月10日
	 * @param request
	 * @return List<SfcWebsiteInfo>
	 */
	public List<SfcWebsiteInfo> querySfcWebsitePage(PageRequest request) throws Exception{
		List<SfcWebsiteInfo> sfcWebsiteInfoList = new ArrayList<SfcWebsiteInfo>();
		PageHelper.startPage(request.getPageNum(), request.getLength());
		if(request !=null && request.getParams() !=null){
			Example example = new Example(SfcWebsiteInfo.class);
			example.createCriteria().andEqualTo(Constants.CS_ANCHEID, request.getParams().get("anCheID"));
			sfcWebsiteInfoList = sfcWebsiteInfoMapper.selectByExample(example);
		}
		 return sfcWebsiteInfoList;
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
		return sfcWebsiteInfoMapper.insertByAnCheID(anCheID);
	}

	@Override
	public List<SfcWebsiteInfoDto> queryListResult(String anCheID) {
		Map<String, Object> queryMap = new HashMap<String, Object>();
		queryMap.put("anCheID", anCheID);
		List<SfcWebsiteInfoDto> sfcWebsiteInfoDtoList = sfcWebsiteInfoMapper.queryPageResult(queryMap);
		return sfcWebsiteInfoDtoList;
	}

	/** 
	 * 描述: 保存公示信息
	 * @auther ZhouYan
	 * @date 2016年11月11日 
	 * @param sfcWebsiteInfo
	 * @return
	 * @throws Exception 
	 */
	@Override
	public int insert(SfcWebsiteInfo sfcWebsiteInfo) throws Exception {
		return sfcWebsiteInfoMapper.insert(sfcWebsiteInfo);
	}
	
}