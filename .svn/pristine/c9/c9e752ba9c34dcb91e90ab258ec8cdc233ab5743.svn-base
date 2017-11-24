/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.rpt.rptservice.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.rpt.rptdto.OpanoMalyRptDto;
import com.icinfo.cs.rpt.rptmapper.OpanoMalyRptMapper;
import com.icinfo.cs.rpt.rptservice.IOpanoMalyRptService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_rpt_opanomaly 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年02月13日
 */
@Service
public class OpanoMalyRptServiceImpl extends MyBatisServiceSupport implements IOpanoMalyRptService {

	@Autowired
	private OpanoMalyRptMapper rptOpanoMalyMapper;
	/**
	 * 
	 * 描述   异常名录统计
	 * @author  赵祥江
	 * @date 2017年2月13日 下午3:02:27 
	 * @param  
	 * @throws
	 */
	@Override
	public List<OpanoMalyRptDto> selectOpanoMalyrpt(PageRequest request)
			throws Exception {
		Map<String, Object> searchMap= request.getParams();
		if(searchMap != null && searchMap.containsKey("startCheckPushDate") && searchMap.containsKey("endCheckPushDate")){
			if(searchMap.get("startCheckPushDate") != null && StringUtil.isNotBlank(searchMap.get("startCheckPushDate").toString())){
				searchMap.put("startCheckPushDate", StringUtil.replace(searchMap.get("startCheckPushDate").toString(), "-", ""));
				searchMap.put("endCheckPushDate", StringUtil.replace(searchMap.get("endCheckPushDate").toString(), "-", ""));
			}else{
				searchMap.put("startCheckPushDate", searchMap.get("rptyear").toString()+searchMap.get("rptmouth").toString());
			}
		} 
		PageHelper.startPage(request.getPageNum(), 100000);
		return rptOpanoMalyMapper.selectOpanoMalyrpt(searchMap);
	}
}