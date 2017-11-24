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
import com.icinfo.cs.yr.mapper.PbBaseinfoHisMapper;
import com.icinfo.cs.yr.model.PbBaseinfoHis;
import com.icinfo.cs.yr.service.IPbBaseinfoHisService;
import com.icinfo.framework.core.exception.BusinessException;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_pb_baseinfo_his 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年09月28日
 */
@Service
public class PbBaseinfoHisServiceImpl extends MyBatisServiceSupport implements IPbBaseinfoHisService {
	private static final Logger logger = LoggerFactory.getLogger(PbBaseinfoHisServiceImpl.class);

	@Autowired
	private PbBaseinfoHisMapper pbBaseinfoHisMapper;
	
	/**
	 * 
	 * 描述   根据年报ID分页查询 公示  历史信息 个体户
	 * @author 赵祥江
	 * @date 2016年9月28日 下午8:46:49 
	 * @param 
	 * @return List<PbBaseinfoHis>
	 * @throws
	 */
	@Override
	public List<PbBaseinfoHis> queryPage(PageRequest request) throws Exception {
		try {
			Map<String, Object> searchMap=  request.getParams();
			PageHelper.startPage(request.getPageNum(), request.getLength());
			Example example=new Example(PbBaseinfoHis.class);
			//年报ID
			if(searchMap.containsKey(Constants.CS_ANCHEID)){
				example.createCriteria()
				.andEqualTo(Constants.CS_ANCHEID, searchMap.get(Constants.CS_ANCHEID).toString());
				example.setOrderByClause("CreateTime desc");
				List<PbBaseinfoHis> pbBaseinfoHisList= pbBaseinfoHisMapper.selectByExample(example);
				if(pbBaseinfoHisList.size()>0){
					return pbBaseinfoHisList;
				} 
			} 
			return new ArrayList<PbBaseinfoHis>();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("exception {}", "根据年报ID分页查询 公示 年报基本信息 历史信息失败!");
            throw new BusinessException("根据年报ID分页查询 公示 年报基本信息 历史信息失败!");
		}
 	}

	/**
	 * 
	 * 描述   根据年报ID和年报提交编号查询历史信息 个体户
	 * @author 赵祥江
	 * @date 2016年9月28日 下午8:48:42 
	 * @param 
	 * @return PbBaseinfoHis
	 * @throws
	 */
	@Override
	public PbBaseinfoHis selectPbBaseinfoHisAnCheIdAndReportNo(String anCheID, String reportNo)
			throws Exception {
		try {
			PbBaseinfoHis pbBaseinfoHis=new PbBaseinfoHis();
			pbBaseinfoHis.setAnCheID(anCheID);
			pbBaseinfoHis.setReportNo(reportNo);
			return pbBaseinfoHisMapper.selectOne(pbBaseinfoHis);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("exception {}", "根据年报ID和年报提交编号查询历史信息 个体户失败!");
            throw new BusinessException("根据年报ID和年报提交编号查询历史信息 个体户失败!");
		}
	}
	
	
	/**
	 * 
	 * 描述   根据年报ID不分页查询 公示 年报基本信息 历史信息
	 * @author 赵祥江
	 * @date 2016年9月29日 下午5:43:30 
	 * @param 
	 * @return List<PbBaseinfoHis>
	 * @throws
	 */
	@Override
	public List<PbBaseinfoHis> selectPbBaseinfoHisByAnCheID(String anCheID) throws Exception {
		try {
			PbBaseinfoHis pbBaseinfoHis=new PbBaseinfoHis();
			pbBaseinfoHis.setAnCheID(anCheID); 
			return pbBaseinfoHisMapper.select(pbBaseinfoHis);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("exception {}", "根据年报ID不分页查询 公示 年报基本信息 历史信息失败!");
            throw new BusinessException("根据年报ID不分页查询 公示 年报基本信息 历史信息失败!");
		}
 	}

	/** 
	 * 描述: 保存公示基本信息历史记录
	 * @auther ZhouYan
	 * @date 2016年10月10日 
	 * @param pbBaseinfoHis
	 * @return
	 * @throws Exception 
	 */
	@Override
	public int insert(PbBaseinfoHis pbBaseinfoHis) throws Exception {
		return pbBaseinfoHisMapper.insert(pbBaseinfoHis);
	}

	/**
	 * 
	 * 描述   根据年度和主体代码获取年报日期和最后年报日期不相等的历史信息
	 * @author 赵祥江
	 * @date 2016年12月29日 下午5:38:51 
	 * @param 
	 * @return List<SfcBaseInfoHis>
	 * @throws
	 */
	@Override
	public List<PbBaseinfoHis> selectPbBaseinfoHisListYear(int year, String priPID)
			throws Exception {
		 Map<String,Object> qMap=new HashMap<String,Object>();
		 qMap.put("year", year);
		 qMap.put("priPID", priPID); 
		return pbBaseinfoHisMapper.selectPbBaseinfoHisListYear(qMap);
	}
	
}