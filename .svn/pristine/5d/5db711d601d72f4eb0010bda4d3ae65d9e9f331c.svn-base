/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.yr.dto.ForGuaranteeInfoDto;
import com.icinfo.cs.yr.mapper.ForGuaranteeInfoMapper;
import com.icinfo.cs.yr.model.ForGuaranteeInfo;
import com.icinfo.cs.yr.service.IForGuaranteeInfoService;
import com.icinfo.framework.core.exception.BusinessException;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_forguaranteeinfo 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年09月09日
 */
@Service
public class ForGuaranteeInfoServiceImpl extends MyBatisServiceSupport implements IForGuaranteeInfoService {


	private static final Logger logger = LoggerFactory.getLogger(ForGuaranteeInfoServiceImpl.class);

	@Autowired
	private ForGuaranteeInfoMapper  forGuaranteeInfoMapper;
	
	/**
	 * 
	 * 描述             : 根据年报ID分页查询 公示 对外担保信息
	 * @author: 赵祥江
	 * @date  : 2016年9月9日 下午3:55:12 
	 * @param : anCheID:年报ID
	 * @return: List<ForGuaranteeInfo>
	 * @throws
	 */
	@Override
	public List<ForGuaranteeInfo> queryPage(PageRequest request) throws Exception {
		try {
			Map<String, Object> searchMap=  request.getParams();
			PageHelper.startPage(request.getPageNum(), request.getLength());
			Example example=this.getExample(ForGuaranteeInfo.class);
			//年报ID
			if(searchMap != null && searchMap.containsKey(Constants.CS_ANCHEID)){
				example.createCriteria()
				.andEqualTo(Constants.CS_ANCHEID, searchMap.get(Constants.CS_ANCHEID).toString());
				return forGuaranteeInfoMapper.selectByExample(example);
			} 
			return new ArrayList<ForGuaranteeInfo>();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("exception {}", "根据年报ID查询公示  年报对外担保信息失败!");
            throw new BusinessException("根据年报ID查询公示  年报对外担保信息失败!");
		}
	}
	
	
	/**
	 * 
	 * 描述             : 根据年报ID 公示 对外担保信息  不分页
	 * @author: 赵祥江
	 * @date  : 2016年9月19日 下午3:34:47 
	 * @param :
	 * @return: List<ForGuaranteeInfo>
	 * @throws
	 */
	@Override
	public List<ForGuaranteeInfo> selectForGuaranteeInfoByAnCheID(String anCheID)
			throws Exception {
		try {
			ForGuaranteeInfo forGuaranteeInfo=new ForGuaranteeInfo();
			forGuaranteeInfo.setAnCheID(anCheID); 
			return forGuaranteeInfoMapper.select(forGuaranteeInfo);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("exception {}", "根据年报ID查询公示  年报对外担保信息失败!");
            throw new BusinessException("根据年报ID查询公示  年报对外担保信息失败!");
		}
	}
	
	private Example getExample(Class<?> classObj){
		Example example=new Example(classObj); 
		return example;
	}


	/** 
	 * 描述: 根据年报id删除公示信息
	 * @auther ZhouYan
	 * @date 2016年9月19日 
	 * @param anCheID
	 * @return
	 * @throws Exception 
	 */
	@Override
	public int deleteByAnCheID(String anCheID) throws Exception {
		Example example=this.getExample(ForGuaranteeInfo.class);
		example.createCriteria().andEqualTo(Constants.CS_ANCHEID, anCheID);
		return forGuaranteeInfoMapper.deleteByExample(example);
	}


	/** 
	 * 描述: 根据年报id保存公示信息
	 * @auther ZhouYan
	 * @date 2016年9月19日 
	 * @param anCheID
	 * @return
	 * @throws Exception 
	 */
	@Override
	public int insertByAnCheID(String anCheID) throws Exception {
		return forGuaranteeInfoMapper.insertByAnCheID(anCheID);
	}


	/**
	 * 
	 * 描述: 公示侧获取对外担保信息（过滤敏感词）
	 * @auther chenyl
	 * @date 2016年10月10日 
	 * @param request
	 * @return
	 */
	@Override
	public List<ForGuaranteeInfoDto> queryPageForPub(PageRequest request) {
		Map<String, Object> searchMap=  request.getParams();
		PageHelper.startPage(request.getPageNum(), request.getLength());
		//年报ID
		if(searchMap != null && searchMap.containsKey(Constants.CS_ANCHEID)){
			List<ForGuaranteeInfoDto>  forGuaranteeInfoList= forGuaranteeInfoMapper.selectForGuaranteeInfoForPub(searchMap);
			if(forGuaranteeInfoList.size()>0){
				return forGuaranteeInfoList;
			} 
		} 
		return new ArrayList<ForGuaranteeInfoDto>();
	}


	/** 
	 * 描述: 保存公示信息
	 * @auther ZhouYan
	 * @date 2016年11月11日 
	 * @param forGuaranteeInfo
	 * @return
	 * @throws Exception 
	 */
	@Override
	public int insert(ForGuaranteeInfo forGuaranteeInfo) throws Exception {
		return forGuaranteeInfoMapper.insert(forGuaranteeInfo);
	}



	 
	/**
	 * 
	 * 描述   根据年报ID分页查询
	 * @author  赵祥江
	 * @date 2017年3月20日 下午5:40:28 
	 * @param  
	 * @throws
	 */
	@Override
	public List<ForGuaranteeInfo> selectForGuaranteeInfoByAnCheIDPage(
			PageRequest request) throws Exception {
		try {
			String anCheID=request.getParams().get("anCheID").toString();
			ForGuaranteeInfo forGuaranteeInfo=new ForGuaranteeInfo();
			forGuaranteeInfo.setAnCheID(anCheID); 
			PageHelper.startPage(request.getPageNum(), request.getLength());
			return forGuaranteeInfoMapper.select(forGuaranteeInfo);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("exception {}", "根据年报ID查询公示  年报对外担保信息失败!");
            throw new BusinessException("根据年报ID查询公示  年报对外担保信息失败!");
		}
	}
	
}