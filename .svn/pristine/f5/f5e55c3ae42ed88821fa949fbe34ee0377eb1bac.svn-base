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

import com.icinfo.cs.yr.mapper.SfcLicenceInfoHisMapper;
import com.icinfo.cs.yr.model.SfcLicenceInfoHis;
import com.icinfo.cs.yr.service.ISfcLicenceInfoHisService;
import com.icinfo.framework.core.exception.BusinessException;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;

/**
 * 描述:    cs_sfc_licenceinfo_his 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年10月08日
 */
@Service
public class SfcLicenceInfoHisServiceImpl extends MyBatisServiceSupport implements ISfcLicenceInfoHisService {
	private static final Logger logger = LoggerFactory.getLogger(SfcLicenceInfoHisServiceImpl.class);

	@Autowired
	private SfcLicenceInfoHisMapper sfcLicenceInfoHisMapper; 

	/**
	 * 
	 * 描述   根据年报ID和年报编号查询许可证信息 历史 农专
	 * @author 赵祥江
	 * @date 2016年10月8日 上午10:34:44 
	 * @param 
	 * @return List<SfcLicenceInfoHis>
	 * @throws
	 */
	@Override
	public List<SfcLicenceInfoHis> selectSfcLicenceInfoHisByAnCheIdAndReportNo(
			String anCheID, String reportNo) throws Exception {
		try {
			SfcLicenceInfoHis sfcLicenceInfoHis=new SfcLicenceInfoHis();
			sfcLicenceInfoHis.setAnCheID(anCheID);
			sfcLicenceInfoHis.setReportNo(reportNo);
			return sfcLicenceInfoHisMapper.select(sfcLicenceInfoHis);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("exception {}", "据年报ID和年报编号查询许可证信息 历史 农专失败!");
	        throw new BusinessException("据年报ID和年报编号查询许可证信息 历史 农专失败!");
		}
	}
	
	/**
	 * 
	 * 描述: 保存许可证历史记录
	 * @auther gaojinling
	 * @date 2016年10月11日 
	 * @param sfcLicenceInfoHis
	 * @return
	 * @throws Exception
	 */
	@Override
	public int insert(SfcLicenceInfoHis sfcLicenceInfoHis) throws Exception {
		sfcLicenceInfoHis.setCreateTime(new Date());
		return sfcLicenceInfoHisMapper.insert(sfcLicenceInfoHis);
	}
}