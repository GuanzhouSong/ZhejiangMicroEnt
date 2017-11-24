/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icinfo.cs.yr.mapper.PbWebsiteinfoHisMapper;
import com.icinfo.cs.yr.model.PbWebsiteinfoHis;
import com.icinfo.cs.yr.service.IPbWebsiteinfoHisService;
import com.icinfo.framework.core.exception.BusinessException;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;

/**
 * 描述:    cs_pb_websiteinfo_his 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年09月28日
 */
@Service
public class PbWebsiteinfoHisServiceImpl extends MyBatisServiceSupport implements IPbWebsiteinfoHisService {
	private static final Logger logger = LoggerFactory.getLogger(PbWebsiteinfoHisServiceImpl.class);

	@Autowired
	private PbWebsiteinfoHisMapper pbWebsiteinfoHisMapper;
	 

	/**
	 * 
	 * 描述   根据年报ID和年报提交编号查询网站网店历史信息 个体户
	 * @author  赵祥江
	 * @date 2016年9月29日 下午12:26:06 
	 * @param  
	 * @throws
	 */
	@Override
	public List<PbWebsiteinfoHis> selectPbWebsiteinfoHisByAnCheIdAndReportNo(
			String anCheID, String reportNo) throws Exception {
		try {
			PbWebsiteinfoHis pbWebsiteinfoHis=new PbWebsiteinfoHis();
			pbWebsiteinfoHis.setAnCheID(anCheID);
			pbWebsiteinfoHis.setReportNo(reportNo);
			return pbWebsiteinfoHisMapper.select(pbWebsiteinfoHis);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("exception {}", "根据年报ID和年报提交编号查询网站网店历史信息 个体户失败!");
            throw new BusinessException("根据年报ID和年报提交编号查询网站网店历史信息 个体户失败!");
		}
	}


	/** 
	 * 描述: 保存公示网站历史记录
	 * @auther ZhouYan
	 * @date 2016年10月10日 
	 * @param pbWebsiteinfoHis
	 * @return
	 * @throws Exception 
	 */
	@Override
	public int insert(PbWebsiteinfoHis pbWebsiteinfoHis) throws Exception {
		return pbWebsiteinfoHisMapper.insert(pbWebsiteinfoHis);
	}  
	
}