/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icinfo.cs.yr.mapper.PbLicenceinfoHisMapper;
import com.icinfo.cs.yr.model.PbLicenceinfoHis;
import com.icinfo.cs.yr.service.IPbLicenceinfoHisService;
import com.icinfo.framework.core.exception.BusinessException;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;

/**
 * 描述:    cs_pb_licenceinfo_his 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年09月28日
 */
@Service
public class PbLicenceinfoHisServiceImpl extends MyBatisServiceSupport implements IPbLicenceinfoHisService {
	private static final Logger logger = LoggerFactory.getLogger(PbLicenceinfoHisServiceImpl.class);
	@Autowired
	private PbLicenceinfoHisMapper pbLicenceinfoHisMapper;
	
	/**
	 * 
	 * 描述   根据年报ID和年报提交编号查询许可证历史信息 个体户
	 * @author 赵祥江
	 * @date 2016年9月28日 下午8:48:42 
	 * @param 
	 * @return List<PbLicenceinfoHis>
	 * @throws
	 */
	@Override
	public List<PbLicenceinfoHis> selectPbLicenceinfoHisByAnCheIdAndReportNo(
			String anCheID, String reportNo) throws Exception {
		try {
			PbLicenceinfoHis pbLicenceinfoHis=new PbLicenceinfoHis();
			pbLicenceinfoHis.setAnCheID(anCheID);
			pbLicenceinfoHis.setReportNo(reportNo);
			return pbLicenceinfoHisMapper.select(pbLicenceinfoHis);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("exception {}", "根据年报ID和年报提交编号查询许可证历史信息 个体户失败!");
            throw new BusinessException("根据年报ID和年报提交编号查询许可证历史信息 个体户失败!");
		}
	}

	/** 
	 * 描述: 保存许可证历史记录
	 * @auther ZhouYan
	 * @date 2016年10月10日 
	 * @param pbLicenceinfoHis
	 * @return
	 * @throws Exception 
	 */
	@Override
	public int insert(PbLicenceinfoHis pbLicenceinfoHis) throws Exception {
		return pbLicenceinfoHisMapper.insert(pbLicenceinfoHis);
	}
	
	
}