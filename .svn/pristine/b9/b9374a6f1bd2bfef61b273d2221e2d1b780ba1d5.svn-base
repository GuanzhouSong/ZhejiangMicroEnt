/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.yr.mapper.SfcBaseInfoHisMapper;
import com.icinfo.cs.yr.model.PbBaseinfoHis;
import com.icinfo.cs.yr.model.SfcBaseInfoHis;
import com.icinfo.cs.yr.service.ISfcBaseInfoHisService;
import com.icinfo.framework.core.exception.BusinessException;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_sfc_baseinfo_his 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年10月08日
 */
@Service
public class SfcBaseInfoHisServiceImpl extends MyBatisServiceSupport implements ISfcBaseInfoHisService {
	private static final Logger logger = LoggerFactory.getLogger(SfcBaseInfoHisServiceImpl.class);

	@Autowired
	private SfcBaseInfoHisMapper sfcBaseInfoHisMapper;
	/**
	 * 
	 * 描述   根据年报ID分页查询 公示  历史信息 农专
	 * @author 赵祥江
	 * @date 2016年10月8日 上午10:16:29 
	 * @param 
	 * @return List<SfcBaseInfoHis>
	 * @throws
	 */
	@Override
	public List<SfcBaseInfoHis> queryPage(PageRequest request) throws Exception {
		try {
			Map<String, Object> searchMap=  request.getParams();
			PageHelper.startPage(request.getPageNum(), request.getLength());
			Example example=new Example(PbBaseinfoHis.class);
			//年报ID
			if(searchMap.containsKey(Constants.CS_ANCHEID)){
				example.createCriteria()
				.andEqualTo(Constants.CS_ANCHEID, searchMap.get(Constants.CS_ANCHEID).toString());
				example.setOrderByClause("CreateTime desc");
				List<SfcBaseInfoHis> sfcBaseInfoHisList= sfcBaseInfoHisMapper.selectByExample(example);
				if(sfcBaseInfoHisList.size()>0){
					return sfcBaseInfoHisList;
				} 
			} 
			return new ArrayList<SfcBaseInfoHis>();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("exception {}", "根据年报ID分页查询 公示  历史信息 农专失败!");
            throw new BusinessException("根据年报ID分页查询 公示  历史信息 农专失败!");
		}
	}

	/**
	 * 
	 * 描述    根据年报ID和年报提交编号查询历史信息 农专
	 * @author 赵祥江
	 * @date 2016年10月8日 上午10:17:05 
	 * @param 
	 * @return SfcBaseInfoHis
	 * @throws
	 */
	@Override
	public SfcBaseInfoHis selectSfcBaseInfoHisAnCheIdAndReportNo(
			String anCheID, String reportNo) throws Exception {
		try {
			SfcBaseInfoHis sfcBaseInfoHis=new SfcBaseInfoHis();
			sfcBaseInfoHis.setAnCheID(anCheID);
			sfcBaseInfoHis.setReportNo(reportNo);
			return sfcBaseInfoHisMapper.selectOne(sfcBaseInfoHis);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("exception {}", "根据年报ID和年报提交编号查询历史信息 农专失败!");
            throw new BusinessException("根据年报ID和年报提交编号查询历史信息 农专失败!");
		}
	}


	/**
	 * 
	 * 描述   根据年报ID不分页查询 公示 年报基本信息 历史信息 农专
	 * @author 赵祥江
	 * @date 2016年10月8日 上午10:17:32 
	 * @param 
	 * @return List<SfcBaseInfoHis>
	 * @throws
	 */
	@Override
	public List<SfcBaseInfoHis> selectSfcBaseInfoHisByAnCheID(String anCheID)
			throws Exception {
		try {
			SfcBaseInfoHis sfcBaseInfoHis=new SfcBaseInfoHis();
			sfcBaseInfoHis.setAnCheID(anCheID); 
			return sfcBaseInfoHisMapper.select(sfcBaseInfoHis);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("exception {}", "根据年报ID不分页查询 公示 年报基本信息 历史信息 农专失败!");
            throw new BusinessException("根据年报ID不分页查询 公示 年报基本信息 历史信息 农专失败!");
		}
	}
	
	
	/**
	 * 
	 * 描述: 保存公示基本信息历史记录
	 * @auther gaojinling
	 * @date 2016年10月11日 
	 * @param pbBaseinfoHis
	 * @return
	 * @throws Exceptions
	 */
	@Override
	public int insert(SfcBaseInfoHis sfcBaseInfoHis) throws Exception {
		sfcBaseInfoHis.setCreateTime(new Date());
		return sfcBaseInfoHisMapper.insert(sfcBaseInfoHis);
	}

	/**
	 * 
	 * 描述   根据年度和主体代码获取年报日期和最后年报日期不相等的历史信息
	 * @author  赵祥江
	 * @date 2016年12月29日 下午5:43:18 
	 * @param  
	 * @throws
	 */
	@Override
	public List<SfcBaseInfoHis> selectSfcBaseinfoHisListYear(int year,
			String priPID) throws Exception {
		 Map<String,Object> qMap=new HashMap<String,Object>();
		 qMap.put("year", year);
		 qMap.put("priPID", priPID);
		return sfcBaseInfoHisMapper.selectSfcBaseinfoHisListYear(qMap);
	}
	
}