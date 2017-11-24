package com.icinfo.cs.quartz.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.icinfo.cs.base.constant.QuartzJobName;
import com.icinfo.cs.base.service.ICsQuartzJobService;
import com.icinfo.cs.common.utils.SleepUtil;
import com.icinfo.cs.quartz.service.IQualificationLimitQuartzJobService;
import com.icinfo.cs.registmanage.service.IQualificationLimitService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;

/** 
 * 描述: 任职资格限制信息同步<br>
 * @author ZhouYan
 * @date 2017年10月23日  
 */
public class QualificationLimitQuartzJobServiceImpl extends MyBatisServiceSupport implements IQualificationLimitQuartzJobService {
	private static final Logger logger = LoggerFactory.getLogger(QualificationLimitQuartzJobServiceImpl.class);
	@Autowired
	private IQualificationLimitService qualificationLimitService;
	@Autowired
	private ICsQuartzJobService csQuartzJobService;
	
	
	/** 
	 * 描述: 任职资格限制信息同步
	 * @auther ZhouYan
	 * @date 2017年10月23日 
	 * @return
	 * @throws Exception 
	 */
	@Override
	public String qualificationLimitQuartzJob() throws Exception {
		logger.info("任职资格限制信息同步开始执行");
		try {
			//阻塞任务，防止并发访问数据库
			SleepUtil.threadSleep();
	 		if(csQuartzJobService.checkJobIsExecute(QuartzJobName.QUALIFICATION_LIMIT_JOB.getJobName())){
				return "任务已执行";
			}
	 		csQuartzJobService.insert(QuartzJobName.QUALIFICATION_LIMIT_JOB.getJobName()); 
	 		qualificationLimitService.doQualificationLimitQuartz(); 
	 		logger.info("任职资格限制信息同步结束执行");
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return null;
	}
}
