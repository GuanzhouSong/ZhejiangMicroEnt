package com.icinfo.cs.quartz.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.icinfo.cs.base.constant.QuartzJobName;
import com.icinfo.cs.base.model.CodeRegorg;
import com.icinfo.cs.base.service.ICodeRegorgService;
import com.icinfo.cs.base.service.ICsQuartzJobService;
import com.icinfo.cs.common.utils.SleepUtil;
import com.icinfo.cs.es.service.IEntSearchService;
import com.icinfo.cs.es.service.IEsManageService;
import com.icinfo.cs.ext.dto.MidBaseInfoDto;
import com.icinfo.cs.ext.service.IMidBaseInfoService;
import com.icinfo.cs.opanomaly.dto.PubPbOpadetailDto;
import com.icinfo.cs.opanomaly.dto.PubPbopanomalyDto;
import com.icinfo.cs.opanomaly.mapper.PubPbOpadetailMapper;
import com.icinfo.cs.opanomaly.model.PubPbOpadetail;
import com.icinfo.cs.opanomaly.service.IPubPbOpadetailService;
import com.icinfo.cs.opanomaly.service.IPubPbopanomalyService;
import com.icinfo.cs.quartz.service.IPubPbopanomalyIsIndividQuartzJobService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;

/**
 * 
 * 描述: 个体户转为企业之前涉及有经营异常信息的，在转为企业后，原有的经营异常信息不再归集于该企业名下进行展示与警示。
 * 所有个体户的经营异常状态在转企后由系统自动处理为“个转企，自动移出”
 * 
 * @auther gaojinling
 * @date 2017年1月16日
 * @return
 * @throws Exception
 */
public class PubPbopanomalyIsIndividQuartzJobService extends MyBatisServiceSupport
		implements IPubPbopanomalyIsIndividQuartzJobService {
	private static final Logger logger = LoggerFactory.getLogger(PubPbopanomalyIsIndividQuartzJobService.class);
	@Autowired
	private IPubPbopanomalyService pubPbopanomalyService;
	@Autowired
	private ICsQuartzJobService csQuartzJobService;
	@Autowired
	private IEntSearchService entSearchService;
	@Autowired
	private ICodeRegorgService codeRegorgService;
	@Autowired
	private IMidBaseInfoService midBaseInfoService;

	@Autowired
	IPubPbOpadetailService pubPbOpadetailService;

	@Autowired
	PubPbOpadetailMapper pubPbOpadetailMapper;

	@Autowired
	IEsManageService esManageService;

	@Override
	public String pbopanomalyIsIndividQuartzJob() throws Exception {
		logger.info("个体户 个转企自动移出 定时移出经营异常任务 开始");
		// 阻塞任务，防止并发访问数据库
		SleepUtil.threadSleep();
		if (csQuartzJobService.checkJobIsExecute(QuartzJobName.PBOPANOMALYISINDIVID_JOB.getJobName())) {
			return "任务已执行";
		}
		csQuartzJobService.insert(QuartzJobName.PBOPANOMALYISINDIVID_JOB.getJobName());
		Map<String, Object> searchMap = new HashMap<String, Object>();
		// 获取个转企且还在经营异常的个体户
		List<PubPbopanomalyDto> pubPbopanomalyDtoList = pubPbopanomalyService
				.selectPubPbopanomalyIsIndividualed(searchMap);
		if (pubPbopanomalyDtoList != null && pubPbopanomalyDtoList.size() > 0) {
			for (PubPbopanomalyDto pubPbopanomalyDto : pubPbopanomalyDtoList) {
				try {
					PubPbOpadetail pubPbOpadetail = new PubPbOpadetail();
					pubPbOpadetail.setBusExcList(pubPbopanomalyDto.getBusExcList());
					pubPbOpadetail.setPriPID(pubPbopanomalyDto.getPriPID());
					pubPbOpadetail.setYear(pubPbopanomalyDto.getYear());
					pubPbOpadetail.setNorRea("5");
					pubPbOpadetail.setNorReaCN("个转企自动移除异常");
					MidBaseInfoDto midBaseInfoDto = midBaseInfoService
							.selectMidBaseInfoByPripid(pubPbopanomalyDto.getPriPID());
					String decOrg = midBaseInfoDto == null ? "000" : midBaseInfoDto.getRegOrg();
					CodeRegorg codeRegorg = codeRegorgService.selectRegOrgByCode(decOrg);
					pubPbOpadetail.setNorDecOrgCN(codeRegorg == null ? "" : codeRegorg.getContentShort());
					pubPbOpadetail.setNorDecOrg(codeRegorg == null ? "" : decOrg);

					pubPbOpadetail.setNorDate(midBaseInfoDto.getIndividDate());
					pubPbOpadetail.setRecoverRea("个转企自动移除异常");
					pubPbOpadetail.setRecoveryType("1");
					pubPbOpadetail.setResetName("系统自动");
					pubPbOpadetail.setIsRecovery("0");
					pubPbOpadetail.setCreateTime(new Date());
					pubPbopanomalyDto.setPBState("1");
					pubPbOpadetail.setFirstName("系统自动");
					pubPbOpadetail.setFirstDate(new Date());
					pubPbOpadetail.setFirstOpin("个转企自动移除异常");
					pubPbOpadetail.setFirstDept(codeRegorg == null ? "" : decOrg);
					pubPbOpadetail.setAuditName("系统自动");
					pubPbOpadetail.setAuditDate(new Date());
					pubPbOpadetail.setAuditOpin("个转企自动移除异常");
					pubPbOpadetail.setAuditDept(codeRegorg == null ? "" : decOrg);
					pubPbOpadetail.setAuditState("1");

					// 更新标记记录，增加恢复记录
					pubPbopanomalyService.updatePubPbopanomalyByBusExcList(pubPbopanomalyDto);
					PubPbOpadetailDto pubPbOpadetailDto = pubPbOpadetailService
							.selectPubPbOpadetailDtoByBusExcList(pubPbopanomalyDto.getBusExcList());
					if (pubPbOpadetailDto == null) {
						pubPbOpadetailMapper.insert(pubPbOpadetail);
					}

					// 搜索列表索引
					esManageService.updateOnePanoramaIdx(pubPbopanomalyDto.getPriPID());
					searchMap.put("priPID", pubPbopanomalyDto.getPriPID());
					// 更新公示索引
					searchMap.put("isOpanomaly", "0");
					entSearchService.updatePubIndex(searchMap);
				} catch (Exception e) {
					e.printStackTrace();
					continue;
				}
			}
		}
		logger.info("个体户  个转企自动移出 定时移出经营异常任务 结束");
		return "";
	}
}
