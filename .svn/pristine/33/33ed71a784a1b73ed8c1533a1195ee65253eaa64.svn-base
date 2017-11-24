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
import com.icinfo.cs.yr.dto.WebsiteInfoDto;
import com.icinfo.cs.yr.mapper.WebsiteInfoMapper;
import com.icinfo.cs.yr.model.WebsiteInfo;
import com.icinfo.cs.yr.service.IWebsiteInfoService;
import com.icinfo.framework.core.exception.BusinessException;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述: cs_websiteinfo 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年09月09日
 */
@Service
public class WebsiteInfoServiceImpl extends MyBatisServiceSupport implements IWebsiteInfoService {

	private static final Logger logger = LoggerFactory.getLogger(WebsiteInfoServiceImpl.class);

	@Autowired
	private WebsiteInfoMapper websiteInfoMapper;

	/**
	 * 
	 * 描述 : 根据年报ID分页查询 公示 网站网店信息 @author: 赵祥江 @date : 2016年9月9日 下午3:55:12 @param
	 * : anCheID:年报ID @return: List<WebsiteInfo> @throws
	 */
	@Override
	public List<WebsiteInfo> queryPage(PageRequest request) throws Exception {
		try {
			Map<String, Object> searchMap = request.getParams();
			PageHelper.startPage(request.getPageNum(), request.getLength());
			Example example = this.getExample(WebsiteInfo.class);
			// 年报ID
			if (searchMap != null && searchMap.containsKey(Constants.CS_ANCHEID)) {
				example.createCriteria().andEqualTo(Constants.CS_ANCHEID,
						searchMap.get(Constants.CS_ANCHEID).toString());
				return websiteInfoMapper.selectByExample(example);
			}
			return new ArrayList<WebsiteInfo>();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("exception {}", "根据年报ID查询公示  年报网站网店信息失败!");
			throw new BusinessException("根据年报ID查询公示  年报网站网店信息失败!");
		}
	}

	/**
	 * 
	 * 描述 : 根据年报ID 获取网店网站 @author: 赵祥江 @date : 2016年9月19日 下午2:02:00 @param
	 * : @return: List<WebsiteInfo> @throws
	 */
	@Override
	public List<WebsiteInfo> selectWebsiteInfoByAnCheID(String anCheID) throws Exception {
		try {
			WebsiteInfo websiteInfo = new WebsiteInfo();
			websiteInfo.setAnCheID(anCheID);
			return websiteInfoMapper.select(websiteInfo);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("exception {}", "根据年报ID 获取网店网站失败!");
			throw new BusinessException("根据年报ID 获取网店网站失败!");
		}
	}

	private Example getExample(Class<?> classObj) {
		Example example = new Example(classObj);
		return example;
	}

	/**
	 * 描述: 根据年报id删除公示信息
	 * 
	 * @auther ZhouYan
	 * @date 2016年9月19日
	 * @param anCheID
	 * @return
	 * @throws Exception
	 */
	@Override
	public int deleteByAnCheID(String anCheID) throws Exception {
		Example example = this.getExample(WebsiteInfo.class);
		example.createCriteria().andEqualTo(Constants.CS_ANCHEID, anCheID);
		return websiteInfoMapper.deleteByExample(example);
	}

	/**
	 * 描述: 根据年报id保存公示信息
	 * 
	 * @auther ZhouYan
	 * @date 2016年9月19日
	 * @param anCheID
	 * @return
	 * @throws Exception
	 */
	@Override
	public int insertByAnCheID(String anCheID) throws Exception {
		return websiteInfoMapper.insertByAnCheID(anCheID);
	}

	/**
	 * 描述: 公示侧企业网站信息查询
	 * 
	 * @auther chenyl
	 * @date 2016年10月8日
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<WebsiteInfoDto> queryPageForPub(PageRequest request) throws Exception {

		Map<String, Object> searchMap = request.getParams();
		PageHelper.startPage(request.getPageNum(), request.getLength());
		// 年报ID
		if (searchMap != null && searchMap.containsKey(Constants.CS_ANCHEID)) {

			List<WebsiteInfoDto> websiteInfoList = websiteInfoMapper.selectWebInfoForPub(searchMap);
			if (websiteInfoList.size() > 0) {
				return websiteInfoList;
			}
		}
		return new ArrayList<WebsiteInfoDto>();

	}

	@Override
	public List<WebsiteInfoDto> queryListResult(String anCheID) {
		Map<String, Object> queryMap = new HashMap<String, Object>();
		queryMap.put("anCheID", anCheID);
		List<WebsiteInfoDto> websiteInfoList = websiteInfoMapper.selectWebInfoForPub(queryMap);
		return websiteInfoList;
	}

	/** 
	 * 描述: 保存公示信息
	 * @auther ZhouYan
	 * @date 2016年11月11日 
	 * @param websiteInfo
	 * @return
	 * @throws Exception 
	 */
	@Override
	public int insert(WebsiteInfo websiteInfo) throws Exception {
		return websiteInfoMapper.insert(websiteInfo);
	}
	
}