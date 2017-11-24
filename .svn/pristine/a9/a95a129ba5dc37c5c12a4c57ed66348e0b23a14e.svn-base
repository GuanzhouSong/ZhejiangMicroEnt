/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.other.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icinfo.cs.other.dto.PubOtherlicenceGovDto;
import com.icinfo.cs.other.mapper.PubOtherlicenceGovMapper;
import com.icinfo.cs.other.service.IPubOtherlicenceGovService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_pub_otherlicence_gov 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年10月31日
 */
@Service
public class PubOtherlicenceGovServiceImpl extends MyBatisServiceSupport implements IPubOtherlicenceGovService {
	
	@Autowired
	private PubOtherlicenceGovMapper pubOtherlicenceGovMapper;

	/** 
	 * 描述: 行政许可归集查询
	 * @auther ZhouYan
	 * @date 2017年10月31日 
	 * @param request
	 * @return
	 * @throws Exception 
	 */
	@Override
	public List<PubOtherlicenceGovDto> selectPubOtherlicenceGovList(
			PageRequest request) throws Exception {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		Map<String, Object> paramsMap = request.getParams();
		return pubOtherlicenceGovMapper.selectPubOtherlicenceGovList(paramsMap);
	}

	/** 
	 * 描述: 在册企业行政许可数
	 * @auther ZhouYan
	 * @date 2017年11月1日 
	 * @param paramsMap
	 * @return
	 * @throws Exception 
	 */
	@Override
	public Integer selectPubOtherlicenceGovRegTotal(
			Map<String, Object> paramsMap) throws Exception {
		return pubOtherlicenceGovMapper.selectPubOtherlicenceGovRegTotal(paramsMap);
	}

	/**
	 * 
	 * 描述 定时任务专用   批量插入  将cs_pub_otherlicence_gov的 SetDeptName = '政务网' 和 PubFlag ='1'的数据插入 cs_pub_otherlicence
	 * @author 赵祥江
	 * @date 2017年11月20日 下午3:49:11 
	 * @param 
	 * @return int
	 * @throws
	 */
	@Override
	public int insertBatchPubOtherLicenceQuartz(Map<String, Object> paramsMap)
			throws Exception { 
		return pubOtherlicenceGovMapper.insertBatchPubOtherLicenceQuartz(paramsMap);
	}

	/**
	 * 
	 * 描述   定时任务专用  更新cs_pub_otherlicence_gov表的注册号 企业名称 、PubFlag标识
	 * @author 赵祥江
	 * @date 2017年11月20日 下午3:49:14 
	 * @param 
	 * @return int
	 * @throws
	 */
	@Override
	public int updatePubotherlicenceGovQuartz(Map<String, Object> paramsMap)
			throws Exception { 
		return pubOtherlicenceGovMapper.updatePubotherlicenceGovQuartz(paramsMap);
	} 

	/** 
	 * 描述: 在册企业行政许可数
	 * @auther ZhouYan
	 * @date 2017年11月1日 
	 * @param paramsMap
	 * @return
	 * @throws Exception 
	 */
	public PubOtherlicenceGovDto selectOtherLicenceGovCount(Map<String, Object> paramsMap) throws Exception{
		PubOtherlicenceGovDto otherlicenceGovDto = new PubOtherlicenceGovDto();
		Integer regTotal = pubOtherlicenceGovMapper.selectPubOtherlicenceGovRegTotal(paramsMap);
		Integer regAnthTotal = pubOtherlicenceGovMapper.selectPubOtherlicenceGovRegAnthTotal(paramsMap);
		Integer anthTotal = pubOtherlicenceGovMapper.selectPubOtherlicenceGovAnthTotal(paramsMap);
		otherlicenceGovDto.setRegTotal(String.valueOf(regTotal));
		otherlicenceGovDto.setRegAnthTotal(String.valueOf(regAnthTotal));
		otherlicenceGovDto.setAnthTotal(String.valueOf(anthTotal));
		return otherlicenceGovDto;
	}
	
	
}