/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.rpt.rptservice.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.rpt.rptdto.RptEntIminfoDto;
import com.icinfo.cs.rpt.rptmapper.RptEntIminfoMapper;
import com.icinfo.cs.rpt.rptservice.IRptEntIminfoService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述: cs_rpt_ent_iminfo 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年08月09日
 */
@Service
public class RptEntIminfoServiceImpl extends MyBatisServiceSupport implements IRptEntIminfoService {
	@Autowired
	RptEntIminfoMapper rptEntIminfoMapper;

	@Override
	public List<RptEntIminfoDto> selectRptEntIminfoCount(PageRequest request) {
		Map<String, Object> searchMap = request.getParams();
		if (searchMap != null && searchMap.containsKey("startCheckPushDate")
				&& searchMap.containsKey("endCheckPushDate")) {
			if (searchMap.get("startCheckPushDate") != null
					&& StringUtil.isNotBlank(searchMap.get("startCheckPushDate").toString())) {
				searchMap.put("startCheckPushDate",
						StringUtil.replace(searchMap.get("startCheckPushDate").toString(), "-", ""));
				searchMap.put("endCheckPushDate",
						StringUtil.replace(searchMap.get("endCheckPushDate").toString(), "-", ""));
			} else {
				searchMap.put("startCheckPushDate",
						searchMap.get("rptyear").toString() + searchMap.get("rptbeginmouth").toString());
			}
		}
		PageHelper.startPage(request.getPageNum(), 10000);
		return rptEntIminfoMapper.selectRptEntIminfoCount(searchMap);
	}
}