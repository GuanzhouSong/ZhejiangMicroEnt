/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.quartz.service.impl;

import com.icinfo.cs.base.constant.QuartzJobName;
import com.icinfo.cs.base.model.CodeLicense;
import com.icinfo.cs.base.service.ICodeLicenseService;
import com.icinfo.cs.base.service.ICsQuartzJobService;
import com.icinfo.cs.common.utils.SleepUtil;
import com.icinfo.cs.dtinfo.dto.LicDeptDto;
import com.icinfo.cs.dtinfo.model.LicDept;
import com.icinfo.cs.dtinfo.model.PubDtInfo;
import com.icinfo.cs.dtinfo.service.ILicDeptService;
import com.icinfo.cs.dtinfo.service.IPubDtInfoService;
import com.icinfo.cs.ext.model.MidBaseInfo;
import com.icinfo.cs.ext.service.IMidBaseInfoService;
import com.icinfo.cs.quartz.service.IPubDtInfoQuartzJobService;
import com.icinfo.cs.quartz.service.IRegistInfoQuartzJobService;
import com.icinfo.cs.registinfo.service.IRegistInfoService;
import com.icinfo.cs.registinfo.service.impl.RegistInfoServiceImpl;
import com.icinfo.cs.system.model.SysDepart;
import com.icinfo.cs.system.service.ISysDepartService;
import com.icinfo.framework.core.exception.BusinessException;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.util.StringUtil;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.tools.utils.DateUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * 描述:    主体户口 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年11月11日
 */
@Service
public class RegistInfoQuartzJobServiceImpl extends MyBatisServiceSupport implements IRegistInfoQuartzJobService {
	private static final Logger logger = LoggerFactory.getLogger(RegistInfoQuartzJobServiceImpl.class);

	@Autowired
	private IRegistInfoService registInfoService;

	@Autowired
	ICsQuartzJobService csQuartzJobService; 
 	/**
	 * 
	 * 描述   主体户口定时同步
	 * @author  liuhq
	 * @date 2016年10月24日 上午10:22:56 
	 * @param  
	 * @throws
	 */
	@Override
	public String registInfoSyn() throws Exception{
		try {
			logger.info("主体户口定时同步任务开始");
			SleepUtil.threadSleep();
	 		if(csQuartzJobService.checkJobIsExecute(QuartzJobName.REGISTINFO_JOB.getJobName())){
				return "任务已执行";
			}
			csQuartzJobService.insert(QuartzJobName.REGISTINFO_JOB.getJobName());
		    registInfoService.registInfoSyn();
			logger.info("主体户口定时同步任务结束");
			return "主体户口定时同步任务结束";
		} catch (Exception e) {
			 e.printStackTrace();
			 throw new BusinessException(e.getCause().getMessage(),e);
		}
	}
	
	

 
}