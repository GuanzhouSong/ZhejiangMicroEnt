/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.batch.service.impl;

import com.icinfo.cs.batch.mapper.BatchMapper;
import com.icinfo.cs.batch.model.Batch;
import com.icinfo.cs.batch.service.IBatchService;
import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:    cs_batch 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年10月25日
 */
@Service
public class BatchServiceImpl extends MyBatisServiceSupport implements IBatchService {
	@Autowired
	private BatchMapper batchMapper;
	private final String defaultno = "000001";
	/**
     * 描述:获取批次编号
     *
     * @throws Exception
     * @auther ylr
     * @date 2016年10月24日
     */
	public String getBatchNo(String batchType) throws Exception{
		Map<String, String> qryMap = new HashMap<String, String>();
		Batch batch = new Batch();//构建批次实体
		batch.setBatchType(batchType);
		batch.setBatchData(DateUtil.dateToString(new Date(), "yyyyMMdd"));
		batch.setCreateTime(new Date());
		
		StringBuffer sb = new StringBuffer();//构建返回批次编号
		sb.append(batchType);
		sb.append(DateUtil.dateToString(new Date(), "yyyyMMdd"));
		
		qryMap.put("batchType", batchType);
		qryMap.put("batchData",DateUtil.dateToString(new Date(), "yyyyMMdd"));
		String maxBatchNo = batchMapper.selecMaxBatchNo(qryMap);
		if(StringUtils.isBlank(maxBatchNo)){
			sb.append(defaultno);
			batch.setBatchNo(defaultno);
		}else{
			sb.append(String.format("%06d", Integer.parseInt(maxBatchNo)+1));	
			batch.setBatchNo(String.format("%06d", Integer.parseInt(maxBatchNo)+1));
		}
			
		batchMapper.insert(batch);
		
		return sb.toString();
		
	}
}