/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icinfo.cs.yr.mapper.SfcBranchInfoHisMapper;
import com.icinfo.cs.yr.model.SfcBranchInfoHis;
import com.icinfo.cs.yr.service.ISfcBranchInfoHisService;
import com.icinfo.framework.core.exception.BusinessException;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;

/**
 * 描述:    cs_sfc_branchinfo_his 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年10月08日
 */
@Service
public class SfcBranchInfoHisServiceImpl extends MyBatisServiceSupport implements ISfcBranchInfoHisService {
	private static final Logger logger = LoggerFactory.getLogger(SfcBaseInfoServiceImpl.class);
	@Autowired
	private SfcBranchInfoHisMapper sfcBranchInfoHisMapper;
	/**
	 * 
	 * 描述   根据年报ID和年报编号查分支机构信息
	 * @author 赵祥江
	 * @date 2016年10月8日 上午10:45:59 
	 * @param 
	 * @return List<SfcBranchInfoHis>
	 * @throws
	 */
	@Override
	public List<SfcBranchInfoHis> selectSfcBranchInfoHisByAnCheIdAndReportNo(
			String anCheID, String reportNo) throws Exception {
		try {
			SfcBranchInfoHis sfcBranchInfoHis=new SfcBranchInfoHis();
			sfcBranchInfoHis.setAnCheID(anCheID);
			sfcBranchInfoHis.setReportNo(reportNo);
			return sfcBranchInfoHisMapper.select(sfcBranchInfoHis);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("exception {}", "根据年报ID和年报编号查分支机构信息失败!");
            throw new BusinessException("根据年报ID和年报编号查分支机构信息失败!");
		}
	}
	
	/**
	 * 
	 * 描述: 保存分支机构历史记录
	 * @auther gaojinling
	 * @date 2016年10月11日 
	 * @param sfcLicenceInfoHis
	 * @return
	 * @throws Exception
	 */
	@Override
	public int insert(SfcBranchInfoHis sfcBranchInfoHis) throws Exception {
		sfcBranchInfoHis.setCreateTime(new Date());
	   return sfcBranchInfoHisMapper.insert(sfcBranchInfoHis);
	}
}