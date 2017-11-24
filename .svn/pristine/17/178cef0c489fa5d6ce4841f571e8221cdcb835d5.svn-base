package com.icinfo.cs.quartz.service.impl;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icinfo.cs.base.constant.QuartzJobName;
import com.icinfo.cs.base.service.ICsQuartzJobService;
import com.icinfo.cs.common.constant.LogOperation;
import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.common.utils.SleepUtil;
import com.icinfo.cs.opanomaly.service.IPubPbopanomalyService;
import com.icinfo.cs.quartz.service.IPubPbopanomalyNoReportQuartzJobService;
import com.icinfo.cs.system.mapper.SysLogMapper;
import com.icinfo.cs.system.model.SysLog;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;

/**
 * 
 * 描述:   个体户未按时年报列入异常
 * @author: 赵祥江
 * @date: 2017年6月28日 下午2:49:49
 */
public class PubPbopanomalyNoReportQuartzJobServiceImpl extends MyBatisServiceSupport implements IPubPbopanomalyNoReportQuartzJobService {
	private static final Logger logger = LoggerFactory.getLogger(PubPbopanomalyNoReportQuartzJobServiceImpl.class);

	@Autowired
	private  IPubPbopanomalyService  pubPbopanomalyService;
	@Autowired
	private ICsQuartzJobService csQuartzJobService;
	@Autowired
	private SysLogMapper sysLogMapper;
	
	
	/**
	 * 
	 * 描述   个体户未按时年报列入异常
	 * @author 赵祥江
	 * @date 2017年6月28日 下午2:50:09 
	 * @param 
	 * @return String
	 * @throws
	 */
    public String pbopanomalyNoReportQuartzJob() throws Exception { 
    	Map<String, Object> qryMap = new HashMap<String, Object>();  
    	//当年年度
		int nowYear =0; 
		//上一年
		int previousYear=0;
		logger.info("*********************************定时任务个体户未按时年报批量列入经营异常开始执行*********************************");
		Calendar cal = Calendar.getInstance();
		//当前年度
		nowYear = cal.get(Calendar.YEAR);
		//上一年
		previousYear = nowYear-1;
		qryMap.put("nowYear",nowYear);
		qryMap.put("previousYear", previousYear);
		String msg="完成";
		try {
			//阻塞任务，防止并发访问数据库
			SleepUtil.threadSleep();
	 		if(csQuartzJobService.checkJobIsExecute(QuartzJobName.PBOPANOMALYNOREPORT_JOB.getJobName())){
				return "任务已执行";
			}
	 		csQuartzJobService.insert(QuartzJobName.PBOPANOMALYNOREPORT_JOB.getJobName()); 
			pubPbopanomalyService.doPubPbopanomalyNoReport(qryMap); 
		} catch (Exception e) {
			e.printStackTrace();
			msg="出现异常";
		} 
		SysLog sysLog=new SysLog();
		sysLog.setYear(Integer.parseInt(DateUtil.getYear()) );
		sysLog.setLogMsg(previousYear+"年度个体户未按照规定报送年度列入异常任务"+msg);
		sysLog.setLogOperation(LogOperation.PBOPANOMALYNOREPORTLOG.getCode()); 
		sysLog.setSetTime(DateUtil.getSysDate());
        sysLogMapper.insert(sysLog);
		logger.info("*********************************定时任务个体户未按时年报批量列入经营异常结束执行*********************************");
		return null;
	}
}
