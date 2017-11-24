package com.icinfo.cs.quartz.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.icinfo.cs.base.constant.QuartzJobName;
import com.icinfo.cs.base.service.ICsQuartzJobService;
import com.icinfo.cs.common.utils.SleepUtil;
import com.icinfo.cs.inspect.service.IReportCheckInfoService;
import com.icinfo.cs.quartz.service.IReportCheckQuartzJobService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;

/** 
 * 描述: 补报核查企业同步Service
 * @author ZhouYan
 * @date 2017年11月7日  
 */
public class ReportCheckQuartzJobServiceImpl extends MyBatisServiceSupport implements IReportCheckQuartzJobService {
	private static final Logger logger = LoggerFactory.getLogger(ReportCheckQuartzJobServiceImpl.class);
	@Autowired
	private IReportCheckInfoService reportCheckInfoService;
	@Autowired
	private ICsQuartzJobService csQuartzJobService;
	
	
	
	/** 
	 * 描述: 补报核查企业同步
	 * @auther ZhouYan
	 * @date 2017年11月7日 
	 * @return
	 * @throws Exception 
	 */
	@Override
	public String reportCheckQuartzJob() throws Exception {
		logger.info("补报核查企业同步开始执行");
		try {
			//阻塞任务，防止并发访问数据库
			SleepUtil.threadSleep();
	 		if(csQuartzJobService.checkJobIsExecute(QuartzJobName.REPORT_CHECK_JOB.getJobName())){
				return "任务已执行";
			}
	 		csQuartzJobService.insert(QuartzJobName.REPORT_CHECK_JOB.getJobName()); 
	 		reportCheckInfoService.doReportCheckQuartz(); 
	 		logger.info("补报核查企业同步结束执行");
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return null;
	}
}
