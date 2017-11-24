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
import com.icinfo.cs.yr.mapper.BaseInfoHisMapper;
import com.icinfo.cs.yr.model.BaseInfoHis;
import com.icinfo.cs.yr.model.YrForinvestMent;
import com.icinfo.cs.yr.service.IBaseInfoHisService;
import com.icinfo.framework.core.exception.BusinessException;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_baseinfo_his 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年09月09日
 */
@Service
public class BaseInfoHisServiceImpl extends MyBatisServiceSupport implements IBaseInfoHisService {
	private static final Logger logger = LoggerFactory.getLogger(BaseInfoHisServiceImpl.class);

	@Autowired
	private BaseInfoHisMapper baseInfoHisMapper;
	
	/**
	 * 
	 * 描述             : 根据年报ID分页查询 公示 年报基本信息 历史信息
	 * @author: 赵祥江
	 * @date  : 2016年9月9日 下午6:11:06 
	 * @param : anCheID:年报ID
	 * @return: List<BaseInfoHis>
	 * @throws
	 */
	@Override
	public List<BaseInfoHis> queryPage(PageRequest request)
			throws Exception {
		try {
			Map<String, Object> searchMap=  request.getParams();
			PageHelper.startPage(request.getPageNum(), request.getLength());
			Example example=this.getExample(BaseInfoHis.class);
			//年报ID
			if(searchMap.containsKey(Constants.CS_ANCHEID)){
				example.createCriteria()
				.andEqualTo(Constants.CS_ANCHEID, searchMap.get(Constants.CS_ANCHEID).toString());
				List<BaseInfoHis>  baseInfoHisList= baseInfoHisMapper.selectByExample(example);
				if(baseInfoHisList.size()>0){
					return baseInfoHisList;
				} 
			} 
			return new ArrayList<BaseInfoHis>();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("exception {}", "根据年报ID分页查询 公示 年报基本信息 历史信息失败!");
            throw new BusinessException("根据年报ID分页查询 公示 年报基本信息 历史信息失败!");
		}
	}
	
	
	
	private Example getExample(Class<?> classObj){
		Example example=new Example(classObj); 
		return example;
	}



	/** 
	 * 描述: 保存公示基本信息历史记录
	 * @auther ZhouYan
	 * @date 2016年9月19日 
	 * @param baseInfoHis
	 * @return
	 * @throws Exception 
	 */
	@Override
	public int insert(BaseInfoHis baseInfoHis) throws Exception {
		return baseInfoHisMapper.insert(baseInfoHis);
	}
	

	/**
	 * 
	 * 描述             : 根据年报年度和主体代码获取年报基本信息 历史信息
	 * @author: 赵祥江
	 * @date  : 2016年9月19日 上午10:44:07 
	 * @param : 
	 * @throws
	 */
	@Override
	public List<BaseInfoHis> slectBaseInfoHisByYearAndpriPID(int year,
			String priPID) throws Exception {
		try {
			BaseInfoHis baseInfoHis=new BaseInfoHis();
			baseInfoHis.setYear(year);
			baseInfoHis.setPriPID(priPID);
			return baseInfoHisMapper.select(baseInfoHis);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("exception {}", "根据年报年度和主体代码获取年报基本信息 历史信息失败!");
            throw new BusinessException("根据年报年度和主体代码获取年报基本信息 历史信息失败!");
		}
	} 

	/**
	 * 
	 * 描述   根据年报ID和年报编码查询历史信息
	 * @author  赵祥江
	 * @date 2016年9月26日 下午6:00:32 
	 * @param  
	 * @throws
	 */
	@Override
	public BaseInfoHis slectBaseInfoHisByanCheIDAndReportNo(
			String anCheID, String reportNo) throws Exception {
		BaseInfoHis baseInfoHis=new BaseInfoHis();
		baseInfoHis.setAnCheID(anCheID);
		baseInfoHis.setReportNo(reportNo);
		return baseInfoHisMapper.selectOne(baseInfoHis);
	}


	 /** 
	 * 描述   根据年度和主体代码获取年报日期和最后年报日期不相等的历史信息
	 * @author 赵祥江
	 * @date 2016年12月29日 下午4:46:50 
	 * @param 
	 * @return List<BaseInfoHis>
	 * @throws
	 */
	@Override
	public List<BaseInfoHis> selectBaseInfoHisListYear(int year, String priPID)
			throws Exception {
		 Map<String,Object> qMap=new HashMap<String,Object>();
		 qMap.put("year", year);
		 qMap.put("priPID", priPID);
		return baseInfoHisMapper.selectBaseInfoHisListYear(qMap);
	}
}