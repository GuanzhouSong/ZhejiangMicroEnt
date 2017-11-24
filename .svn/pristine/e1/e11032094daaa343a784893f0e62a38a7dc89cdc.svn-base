package com.icinfo.cs.quartz.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icinfo.cs.base.constant.QuartzJobName;
import com.icinfo.cs.base.model.CodeRegorg;
import com.icinfo.cs.base.service.ICodeRegorgService;
import com.icinfo.cs.base.service.ICsQuartzJobService;
import com.icinfo.cs.common.utils.SleepUtil;
import com.icinfo.cs.es.service.IEntSearchService;
import com.icinfo.cs.es.service.IEsManageService;
import com.icinfo.cs.es.service.IPanoramaSearchService;
import com.icinfo.cs.ext.dto.MidBaseInfoDto;
import com.icinfo.cs.ext.service.IMidBaseInfoService;
import com.icinfo.cs.opanomaly.dto.PubPbOpadetailDto;
import com.icinfo.cs.opanomaly.dto.PubPbopanomalyDto;
import com.icinfo.cs.opanomaly.mapper.PubPbOpadetailMapper;
import com.icinfo.cs.opanomaly.model.PubPbOpadetail;
import com.icinfo.cs.opanomaly.service.IPubPbOpadetailService;
import com.icinfo.cs.opanomaly.service.IPubPbopanomalyService;
import com.icinfo.cs.quartz.service.IPubPbopanomalyQuartzJobService;
import com.icinfo.cs.yr.model.YrRegCheck;
import com.icinfo.cs.yr.service.IYrRegCheckService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;

/**
 * Copyright 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 个体户经营异常定时
 * 
 * @author: 赵祥江
 * @date: 2016年12月20日 下午3:30:33
 * @version: V1.0
 */
@Service
public class PubPbopanomalyQuartzJobServiceImpl extends MyBatisServiceSupport
		implements IPubPbopanomalyQuartzJobService {
	private static final Logger logger = LoggerFactory.getLogger(PubPbopanomalyQuartzJobServiceImpl.class);
	@Autowired
	private IPubPbopanomalyService pubPbopanomalyService;
	@Autowired
	private ICsQuartzJobService csQuartzJobService;
	@Autowired
	private IPanoramaSearchService panoramaSearchService;
	@Autowired
	private IEntSearchService entSearchService;
	@Autowired
	private ICodeRegorgService codeRegorgService;
	@Autowired
	private IMidBaseInfoService midBaseInfoService;
	@Autowired
	PubPbOpadetailMapper pubPbOpadetailMapper;
	@Autowired
	IPubPbOpadetailService pubPbOpadetailService;
	@Autowired
	IYrRegCheckService yrRegCheckService;
	@Autowired
	IEsManageService esManageService;

	/**
	 * 
	 * 描述 个体户 已年报后 定时移出经营异常 @author 赵祥江 @date 2016年12月20日
	 * 下午3:34:08 @param @return void @throws
	 */
	@Override
	public String pubPbopanomalyOutQuartzJob() throws Exception {
		logger.info("个体户 已年报 定时移出经营异常任务 开始");
		// 阻塞任务，防止并发访问数据库
		SleepUtil.threadSleep();
		if (csQuartzJobService.checkJobIsExecute(QuartzJobName.PBOPANOMALY_JOB.getJobName())) {
			return "任务已执行";
		}
		csQuartzJobService.insert(QuartzJobName.PBOPANOMALY_JOB.getJobName());
		Map<String, Object> searchMap = new HashMap<String, Object>();

		// 获取已补报且还在经营异常（未按时年报）的个体户
		List<PubPbopanomalyDto> pubPbopanomalyDtoList = pubPbopanomalyService.selectPubPbopanomalyIsReported(searchMap);
		if (pubPbopanomalyDtoList != null && pubPbopanomalyDtoList.size() > 0) {
			for (PubPbopanomalyDto pubPbopanomalyDto : pubPbopanomalyDtoList) {
				try {
					PubPbOpadetail pubPbOpadetail = new PubPbOpadetail();
					pubPbOpadetail.setBusExcList(pubPbopanomalyDto.getBusExcList());
					pubPbOpadetail.setPriPID(pubPbopanomalyDto.getPriPID());
					pubPbOpadetail.setYear(pubPbopanomalyDto.getYear());
					pubPbOpadetail.setNorRea("3");
					pubPbOpadetail.setNorReaCN("已报送最新年度年报,系统自动恢复正常");
					MidBaseInfoDto midBaseInfoDto = midBaseInfoService
							.selectMidBaseInfoByPripid(pubPbopanomalyDto.getPriPID());
					String decOrg = midBaseInfoDto == null ? "000" : midBaseInfoDto.getRegOrg();
					CodeRegorg codeRegorg = codeRegorgService.selectRegOrgByCode(decOrg);
					pubPbOpadetail.setNorDecOrgCN(codeRegorg == null ? "" : codeRegorg.getContentShort());
					pubPbOpadetail.setNorDecOrg(codeRegorg == null ? "" : decOrg);

					// 查询最新年报日期作为恢复日期
					List<YrRegCheck> yrRegCheckList = yrRegCheckService
							.doGetYrRegCheckInit(pubPbopanomalyDto.getPriPID());
					YrRegCheck yrRegCheck = yrRegCheckList.get(0);
					Date reportTime = yrRegCheck.getFirstReportTime();
					pubPbOpadetail.setNorDate(reportTime);
					pubPbOpadetail.setRecoverRea("已补报");
					pubPbOpadetail.setRecoveryType("1");
					pubPbOpadetail.setResetName("系统自动");
					pubPbOpadetail.setIsRecovery("0");
					pubPbOpadetail.setCreateTime(new Date());
					pubPbopanomalyDto.setPBState("1");
					pubPbOpadetail.setFirstName("系统自动");
					pubPbOpadetail.setFirstDate(new Date());
					pubPbOpadetail.setFirstOpin("已补报");
					pubPbOpadetail.setFirstDept(codeRegorg == null ? "" : decOrg);
					pubPbOpadetail.setAuditName("系统自动");
					pubPbOpadetail.setAuditDate(new Date());
					pubPbOpadetail.setAuditOpin("已补报");
					pubPbOpadetail.setAuditDept(codeRegorg == null ? "" : decOrg);
					pubPbOpadetail.setAuditState("1");
					// 更新标记记录，增加恢复记录
					pubPbopanomalyService.updatePubPbopanomalyByBusExcList(pubPbopanomalyDto);
					PubPbOpadetailDto pubPbOpadetailDto = pubPbOpadetailService
							.selectPubPbOpadetailDtoByBusExcList(pubPbopanomalyDto.getBusExcList());
					if (pubPbOpadetailDto == null) {
						pubPbOpadetailMapper.insert(pubPbOpadetail);
					}

					// 检索个体户还有没有在列异常 如果没有更新索引打上移出标识
					Map<String, Object> searchmaps = new HashMap<>();
					searchmaps.put("regNO", midBaseInfoDto.getRegNO());
					List<PubPbopanomalyDto> pubPbopanomalyDtos = pubPbopanomalyService
							.selectPubPbopanomalys(searchmaps);
					if (pubPbopanomalyDtos == null || pubPbopanomalyDtos.size() == 0) {
						// 搜索列表索引
						esManageService.updateOnePanoramaIdx(pubPbopanomalyDto.getPriPID());
						//panoramaSearchService.updatePanoramaIdx(searchMap);
						searchMap.put("priPID", pubPbopanomalyDto.getPriPID());
						// 更新公示索引
						searchMap.put("isOpanomaly", "0");
						entSearchService.updatePubIndex(searchMap);
					}
				} catch (Exception e) {
					continue;
				}
			}
		}
		logger.info("个体户 已年报 定时移出经营异常任务 结束");
		return "";
	}
}
