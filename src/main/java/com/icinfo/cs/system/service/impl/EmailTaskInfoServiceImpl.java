/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icinfo.cs.system.dto.EmailTaskInfoDto;
import com.icinfo.cs.system.mapper.EmailTaskInfoMapper;
import com.icinfo.cs.system.service.IEmailTaskInfoService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述: cs_email_task_info 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年11月14日
 */
@Service
public class EmailTaskInfoServiceImpl extends MyBatisServiceSupport implements IEmailTaskInfoService {

	@Autowired
	EmailTaskInfoMapper emailTaskInfoMapper;

	@Override
	public List<EmailTaskInfoDto> queryPageResult(PageRequest request) {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		return emailTaskInfoMapper.queryPageResultByUid(request.getParams());
	}
}