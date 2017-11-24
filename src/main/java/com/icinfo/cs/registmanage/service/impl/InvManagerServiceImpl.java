/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.registmanage.service.impl;

import com.icinfo.cs.registmanage.dto.InvManagerCount;
import com.icinfo.cs.registmanage.dto.InvManagerDto;
import com.icinfo.cs.registmanage.mapper.InvManagerMapper;
import com.icinfo.cs.registmanage.service.IInvManagerService;
import com.icinfo.cs.yr.model.YrRegCheck;
import com.icinfo.cs.yr.service.IYrRegCheckService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述: cs_inv_manager 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年11月22日
 */
@Service
public class InvManagerServiceImpl extends MyBatisServiceSupport implements IInvManagerService {
	@Autowired
	InvManagerMapper invManagerMapper;
	@Autowired
	IYrRegCheckService yrRegCheckService;

	@Override
	public List<InvManagerDto> selectLicenceInvalidMgrJSON(PageRequest request) {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		return invManagerMapper.selectLicenceInvalidMgrJSON(request.getParams());
	}

	@Override
	public InvManagerCount queryInvManagerCount(PageRequest request) {
		return invManagerMapper.selectInvManagerCount(request.getParams());
	}

	@Override
	public InvManagerCount selectYrinfo(String priPID) throws Exception {
		InvManagerCount invManagerCount = new InvManagerCount();
		List<YrRegCheck> yrRegCheckList = yrRegCheckService.doGetYrRegCheckInit(priPID);
		if (yrRegCheckList != null && yrRegCheckList.size() > 0) {
			invManagerCount.setYear(yrRegCheckList.get(0).getYear());
			invManagerCount.setYcdate(yrRegCheckList.get(0).getFirstReportTime());
		}
		return invManagerCount;
	}
}