/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.rpt.rptservice.impl;

import java.util.HashMap;
import java.util.Map;

import com.icinfo.cs.rpt.rptdto.RptWarningInfoDto;
import com.icinfo.cs.rpt.rptmapper.RptWarningInfoMapper;
import com.icinfo.cs.rpt.rptservice.IRptWarningInfoService;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:    cs_rpt_warning_info 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年10月18日
 */
@Service
public class RptWarningInfoServiceImpl extends MyBatisServiceSupport implements IRptWarningInfoService {
	
	@Autowired
	private RptWarningInfoMapper rptWarningInfoMapper;
	
	/**
	 * 
	 * 描述: 首页提示统计项
	 * @auther gaojinling
	 * @date 2017年10月18日 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public RptWarningInfoDto selectWarnCount(Map<String, Object> map) throws Exception{
		return rptWarningInfoMapper.selectWarnCount(map);
	}
	
	/**
	 * 
	 * 描述: 首页提示统计项(2.3日常监督管理)
	 * @auther gaojinling
	 * @date 2017年10月18日 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public RptWarningInfoDto selectRptScentCheck(SysUserDto sysUserDto) throws Exception{
		Map<String, Object> qryMap = new HashMap<String, Object>();
		String deptCode = "2".equals(sysUserDto.getUserType()) ? sysUserDto.getSysDepart().getAdcode()
				: sysUserDto.getDepartMent().getDeptCode();
		String userid = sysUserDto.getId();
		deptCode = deptCode.substring(0, 6);
		qryMap.put("userId", userid);
		qryMap.put("deptCode", deptCode);
		return rptWarningInfoMapper.selectRptScentCheck(qryMap);
	}
}