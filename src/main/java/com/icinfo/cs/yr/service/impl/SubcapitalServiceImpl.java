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
import com.icinfo.cs.yr.dto.SubcapitalDto;
import com.icinfo.cs.yr.mapper.SubcapitalMapper;
import com.icinfo.cs.yr.model.Subcapital;
import com.icinfo.cs.yr.service.ISubcapitalService;
import com.icinfo.framework.core.exception.BusinessException;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_subcapital 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年09月09日
 */
@Service
public class SubcapitalServiceImpl extends MyBatisServiceSupport implements ISubcapitalService {

	private static final Logger logger = LoggerFactory.getLogger(SubcapitalServiceImpl.class);

	@Autowired
	private SubcapitalMapper subcapitalMapper;
	
	/**
	 * 
	 * 描述             : 根据年报ID分页查询 公示 股东及出资信息
	 * @author: 赵祥江
	 * @date  : 2016年9月9日 下午3:55:12 
	 * @param : anCheID:年报ID
	 * @return: List<Subcapital>
	 * @throws
	 */
	@Override
	public List<Subcapital> queryPage(PageRequest request) throws Exception {
		try {
			Map<String, Object> searchMap=  request.getParams();
			PageHelper.startPage(request.getPageNum(), request.getLength());
			Example example=this.getExample(Subcapital.class);
			
			//年报ID
			if(searchMap != null && searchMap.containsKey(Constants.CS_ANCHEID)){
				example.createCriteria()
				.andEqualTo(Constants.CS_ANCHEID, searchMap.get(Constants.CS_ANCHEID).toString());
				List<Subcapital>  subcapitalList= subcapitalMapper.selectByExample(example);
				if(subcapitalList.size()>0){
					return subcapitalList;
				} 
			} 
			return new ArrayList<Subcapital>();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("exception {}", "根据年报ID分页查询 公示 股东及出资信息失败!");
            throw new BusinessException("根据年报ID分页查询 公示 股东及出资信息失败!");
		}
	}
	
	/**
	 * 
	 * 描述             : 根据年报ID获取出资（不分页）  公示
	 * @author: 赵祥江
	 * @date  : 2016年9月19日 下午2:11:06 
	 * @param :
	 * @return: List<Subcapital>
	 * @throws
	 */
	public List<Subcapital> selectSubcapitalByAnCheID(String anCheID) throws Exception{
		try {
			Subcapital subcapital=new Subcapital();
			subcapital.setAnCheID(anCheID);
			return subcapitalMapper.select(subcapital);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("exception {}", "根据年报ID获取出资（不分页）  公示失败!");
            throw new BusinessException("根据年报ID获取出资（不分页）  公示失败!");
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
		Example example=this.getExample(Subcapital.class);
		example.createCriteria().andEqualTo(Constants.CS_ANCHEID, anCheID);
		return subcapitalMapper.deleteByExample(example);
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
		return subcapitalMapper.insertByAnCheID(anCheID);
	}

	/**
	 * 描述: 公示侧企业股东及出资信息查询
	 * @auther chenyl
	 * @date 2016年10月8日 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<SubcapitalDto> queryPageForPub(PageRequest request) {
		Map<String, Object> searchMap=  request.getParams();
		PageHelper.startPage(request.getPageNum(), request.getLength());
		 
		//年报ID
		if(searchMap != null && searchMap.containsKey(Constants.CS_ANCHEID)){
			
			List<SubcapitalDto>  subcapitalList= subcapitalMapper.selectSubcapitalInfoForPub(searchMap);
			if(subcapitalList.size()>0){
				return subcapitalList;
			} 
		} 
		return new ArrayList<SubcapitalDto>();
	}

	/** 
	 * 描述: 保存公示信息
	 * @auther ZhouYan
	 * @date 2016年11月11日 
	 * @param subcapital
	 * @return
	 * @throws Exception 
	 */
	@Override
	public int insert(Subcapital subcapital) throws Exception {
		return subcapitalMapper.insert(subcapital);
	}
	
}