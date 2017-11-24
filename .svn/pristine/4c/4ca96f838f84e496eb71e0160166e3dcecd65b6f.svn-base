/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.sment.service.impl;

import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.sment.mapper.SmLogMapper;
import com.icinfo.cs.sment.model.SmLog;
import com.icinfo.cs.sment.service.ISmLogService;
import com.icinfo.cs.sment.util.RequestUtil;
import com.icinfo.cs.system.model.SysUser;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.tools.utils.WebUtils;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:    sm_log 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年05月02日
 */
@Service
public class SmLogServiceImpl extends MyBatisServiceSupport implements ISmLogService {

	@Autowired
	SmLogMapper smLogMapper;
	
	@Override
	public int save(String LogType, String LogRemark) throws Exception {
		String userName = ((SysUser)RequestUtil.getSession().getAttribute(Constants.SESSION_SYS_USER)).getUsername();
		String ip = WebUtils.getIpAddress(RequestUtil.getRequest());
		return smLogMapper.insert(new SmLog(userName,LogType,LogRemark,ip));
	}
	
	@Override
	public List<SmLog> queryPage(PageRequest request) throws Exception {
		PageHelper.startPage(request.getPageNum(), request.getLength());
	    Map<String, Object> maps = request.getParams();
		return smLogMapper.selectLogList(maps);
	}
}