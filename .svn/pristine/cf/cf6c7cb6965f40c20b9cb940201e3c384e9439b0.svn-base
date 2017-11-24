package com.icinfo.cs.sment.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.icinfo.cs.base.constant.QuartzJobName;
import com.icinfo.cs.base.service.ICsQuartzJobService;
import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.common.utils.SleepUtil;
import com.icinfo.cs.sment.service.IBaseinfoDataSyncService;
import com.icinfo.cs.system.controller.CSBaseController;

/**
 * 定时任务相关控制
 * 
 * @author zhuyong
 */
public class SmentQuartzController extends CSBaseController{
	
	private static final Logger logger = LoggerFactory.getLogger(SmentQuartzController.class);
	
	@Autowired
	private IBaseinfoDataSyncService baseinfoDataSyncService;
	@Autowired
	private ICsQuartzJobService csQuartzJobService;
	
	private static final int incTotal = 200000; //

	
	/**
	 * 小微企业（新设）数据同步
	 * 
	 * @author zhuyong
	 * @date 2017-05-05
	 */
	public void quartzForDataSync() {
		// 构造增量查询条件
		Map<String, Object> qryMap = new HashMap<String, Object>();
		qryMap.put("updateTimeStart", DateUtil.getDayBeforeDayEnd(new Date()));
		qryMap.put("updateTimeEnd", DateUtil.getDayAfterDayStart(new Date()));

		try {
			//阻塞任务，防止并发访问数据库
			SleepUtil.threadSleep();
			if(csQuartzJobService.checkJobIsExecute(QuartzJobName.SCINFO_JOB.getJobName())){
				return ;
			}
			csQuartzJobService.insert(QuartzJobName.SCINFO_JOB.getJobName());
			
			/** 获取增量数据总量 */
			int syncTotal = baseinfoDataSyncService.selectSyncCountForBaseinfo(qryMap);
			/** 增量数据同步 */
			if(syncTotal > incTotal){//两表比对更新
				baseinfoDataSyncService.updateByBatchComp(qryMap);
			}else{ //增量更新
				baseinfoDataSyncService.updateByInc(qryMap, syncTotal);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("小微企业数据同步任务发生异常");
		}
	}
}
