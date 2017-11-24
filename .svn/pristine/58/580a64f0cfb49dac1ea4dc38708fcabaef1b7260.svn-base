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

import com.icinfo.cs.yr.mapper.SfcWebsiteInfoHisMapper;
import com.icinfo.cs.yr.model.SfcWebsiteInfoHis;
import com.icinfo.cs.yr.service.ISfcWebsiteInfoHisService;
import com.icinfo.framework.core.exception.BusinessException;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;

/**
 * 描述:    cs_sfc_websiteinfo_his 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年10月08日
 */
@Service
public class SfcWebsiteInfoHisServiceImpl extends MyBatisServiceSupport implements ISfcWebsiteInfoHisService {
	private static final Logger logger = LoggerFactory.getLogger(SfcWebsiteInfoHisServiceImpl.class);

	@Autowired
	private SfcWebsiteInfoHisMapper sfcWebsiteInfoHisMapper; 

	/**
	 * 
	 * 描述   根据年报ID和年报编号查询网站网店信息 历史 农专
	 * @author 赵祥江
	 * @date 2016年10月8日 上午10:34:44 
	 * @param 
	 * @return List<SfcWebsiteInfoHis>
	 * @throws
	 */
	@Override
	public List<SfcWebsiteInfoHis> selectSfcWebsiteInfoHisByAnCheIdAndReportNo(
			String anCheID, String reportNo) throws Exception {
		try {
			SfcWebsiteInfoHis sfcWebsiteInfoHis=new SfcWebsiteInfoHis();
			sfcWebsiteInfoHis.setAnCheID(anCheID);
			sfcWebsiteInfoHis.setReportNo(reportNo);
			return sfcWebsiteInfoHisMapper.select(sfcWebsiteInfoHis);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("exception {}", "根据年报ID和年报编号查询网站网店信息 历史 农专失败!");
	        throw new BusinessException("根据年报ID和年报编号查询网站网店信息 历史 农专失败!");
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
	public int insert(SfcWebsiteInfoHis sfcWebsiteInfoHis) throws Exception {
	   sfcWebsiteInfoHis.setCreateTime(new Date());
	   return sfcWebsiteInfoHisMapper.insert(sfcWebsiteInfoHis);
	}
}