package com.icinfo.cs.quartz.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.icinfo.cs.base.constant.QuartzJobName;
import com.icinfo.cs.base.service.ICsQuartzJobService;
import com.icinfo.cs.common.utils.SleepUtil;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.ext.model.MidBaseInfo;
import com.icinfo.cs.ext.service.IMidBaseInfoService;
import com.icinfo.cs.other.model.PubOtherpunishGov;
import com.icinfo.cs.other.service.IPubOtherlicenceGovService;
import com.icinfo.cs.other.service.IPubOtherlicenceService;
import com.icinfo.cs.other.service.IPubOtherpunishGovService;
import com.icinfo.cs.quartz.service.IPubOtherlicenceGovQuartzJobService;
import com.icinfo.framework.common.exception.GenericException;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;

/** 
 * 描述: 补报核查企业同步Service
 * @author ZhouYan
 * @date 2017年11月7日  
 */
@Service
public class PubOtherlicenceGovQuartzJobServiceImpl extends MyBatisServiceSupport implements IPubOtherlicenceGovQuartzJobService {
	private static final Logger logger = LoggerFactory.getLogger(PubOtherlicenceGovQuartzJobServiceImpl.class);
	@Autowired
	private IPubOtherlicenceGovService pubOtherlicenceGovService;
	
	@Autowired
	private IPubOtherlicenceService pubOtherlicenceService;
	
	@Autowired
	private ICsQuartzJobService csQuartzJobService;
	@Autowired
	private IPubOtherpunishGovService pubOtherpunishGovService; 
	@Autowired
	private IMidBaseInfoService midBaseInfoService;
	
	/**
	 * 
	 * 描述   公示许可证定时任务
	 * @author  赵祥江
	 * @date 2017年11月20日 下午3:19:39 
	 * @param  
	 * @throws
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public String pubOtherlicenceGovQuartzJob() throws Exception {
		logger.info("公示许可证定时任务开始");
		try {
			//阻塞任务，防止并发访问数据库
			SleepUtil.threadSleep();
	 		if(csQuartzJobService.checkJobIsExecute(QuartzJobName.PUBOTHERLICENCEGOV_JOB.getJobName())){
				return "任务已执行";
			}
	 		csQuartzJobService.insert(QuartzJobName.PUBOTHERLICENCEGOV_JOB.getJobName()); 
	 		Map<String,Object> paramsMap=new HashMap<String,Object>();
	 		Map<String,Object> qMap=new HashMap<String,Object>();
	 		try {
	 			//stateType 1 行政许可归集 2行政处罚归集-政务网  3 行政处罚归集-总局下发
		 		paramsMap.put("stateType", "1");
		 		pubOtherlicenceGovNotional(paramsMap); 
			} catch (Exception e) {
				logger.error("定时任务：行政许可归集异常", e);
				throw new GenericException("定时任务：行政许可归集异常", e);
			}
	 		
	 		try { 
	 			paramsMap.put("stateType", "2");
		 		pubOtherlicenceGovNotional(paramsMap); 
			} catch (Exception e) {
				logger.error("定时任务：行政处罚-政务网归集异常", e);
				throw new GenericException("定时任务：行政处罚-政务网归集异常", e);
			}
	 		
	 		try {  
	 			List<PubOtherpunishGov> pubOtherpunishGovList =pubOtherpunishGovService.selectPubOtherpunishGovByDeptnameList("总局下发");
			    if(pubOtherpunishGovList.size()>0){
			    	for(PubOtherpunishGov pubOtherpunishGov:pubOtherpunishGovList){
			    	  MidBaseInfo  midBaseInfo =null;
			    	  String uniscid=pubOtherpunishGov.getUniSCID();
			    	  String regNO=pubOtherpunishGov.getRegNO();
			    	  String entName=pubOtherpunishGov.getEntName();
			    	  if(StringUtil.isNotBlank(uniscid)){
			    		  midBaseInfo=midBaseInfoService.selectMidBaseInfoByRegno(uniscid);
			    	  }
			    	  if(midBaseInfo==null&&StringUtil.isNotBlank(regNO)){
			    		  midBaseInfo=midBaseInfoService.selectMidBaseInfoByRegno(regNO);
			    	  }
			    	  if(midBaseInfo==null&&StringUtil.isNotBlank(entName)&&!"无".equals(entName)&&!entName.contains("*")){
			    		  qMap.put("keyword", entName);
			    		  List<MidBaseInfo> midBaseInfoList= midBaseInfoService.selectMidInfoByKeyword(qMap);
			    		  if(midBaseInfoList.size()>0){
			    			  midBaseInfo=midBaseInfoList.get(0);
			    		  }
			    	  }
			    	  if(midBaseInfo!=null){
			    		  pubOtherpunishGov.setPriPID(midBaseInfo.getPriPID());
			    		  pubOtherpunishGov.setRegNO(midBaseInfo.getRegNO());
			    		  pubOtherpunishGov.setUniSCID(midBaseInfo.getUniCode());
			    		  pubOtherpunishGov.setLeRep(midBaseInfo.getLeRep());
			    		  pubOtherpunishGov.setPubFlag("1");
			    		  pubOtherpunishGov.setId(pubOtherpunishGov.getId());
			    		  pubOtherpunishGov.setUpdate_time(null);
			    		  pubOtherpunishGovService.updatePubOtherpunishGov(pubOtherpunishGov);
			    	  }
			    	}
			    	paramsMap.put("stateType", "3");
			 		pubOtherlicenceGovNotional(paramsMap);
			    }
	 		} catch (Exception e) {
				logger.error("定时任务：行政处罚-总局下发归集异常", e);
				throw new GenericException("定时任务：行政处罚-总局下发归集异常", e);
			}
	 		
	 		logger.info("公示许可证定时任务结束");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(),e);
			throw new GenericException(e.getMessage(), e); 
		} 
		return "";
	}
	
	/**
	 * 
	 * 描述   行政许可归集--政务网
	 * @author 赵祥江
	 * @date 2017年11月21日 上午10:29:29 
	 * @param 
	 * @return void
	 * @throws
	 */ 
	private void pubOtherlicenceGovNotional(Map<String,Object> paramsMap)throws Exception{
		//第一步 关联cs_mid_baseinfo 更新cs_pub_otherlicence_gov表的注册号 企业名称 、PubFlag标识 
		String stateType= paramsMap.get("stateType").toString();
		if(!"3".equals(stateType)){
			pubOtherlicenceGovService.updatePubotherlicenceGovQuartz(paramsMap);
		} 
 		//第二步：将 cs_pub_otherlicence 表中 SetDeptName 字段值为'政务网'的数据全部删除
 		pubOtherlicenceService.deletePubOtherlicenceBySetDeptName(paramsMap);
 		//第三步：将 cs_pub_otherlicence_gov 表中 SetDeptName 字段值为'政务网'并且 PubFlag 字段值为'1' 的数据全部插入 cs_pub_otherlicence 表中
 		pubOtherlicenceGovService.insertBatchPubOtherLicenceQuartz(paramsMap); 
	}
}
