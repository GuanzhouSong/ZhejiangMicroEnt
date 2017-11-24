/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.base.service.impl;

import com.icinfo.cs.base.mapper.CsQuartzJobMapper;
import com.icinfo.cs.base.model.CsQuartzJob;
import com.icinfo.cs.base.service.ICsQuartzJobService;
import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.common.utils.RequestUtil;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:    cs_quartz_job 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年12月20日
 */
@Service
public class CsQuartzJobServiceImpl extends MyBatisServiceSupport implements ICsQuartzJobService {
	
	@Autowired
	CsQuartzJobMapper csQuartzJobMapper;
	
	/**
	 * 插入定时任务对象
	 * 
	 * @author zhuyong
	 * @return
	 * @throws Exception
	 */
	public int insert(String jobName) throws Exception{
		CsQuartzJob job = new CsQuartzJob();
		job.setJobName(jobName);
		job.setJobDay(DateUtil.getCurrentDate());
		//获取执行任务服务器的内网ip
		job.setJobServerIp(RequestUtil.getServerIpAddress());
		return csQuartzJobMapper.insert(job);
	}
	
	/**
	 * 检查定时任务当天是否已经执行
	 * 
	 * @author zhuyong
	 * @date 2016-12-20
	 */
	public boolean checkJobIsExecute(String jobName) throws Exception{
		if(StringUtils.isBlank(jobName))
			return true;
		
		Example example = new Example(CsQuartzJob.class);
		example.createCriteria().andEqualTo("jobName",jobName).andEqualTo("jobDay",DateUtil.getCurrentDate());
		List<CsQuartzJob> dataList = csQuartzJobMapper.selectByExample(example);
		
		if(dataList!=null && dataList.size() > 0) 
			return true;
		
		return false;
	}
}

















