package com.icinfo.cs.es.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.icinfo.cs.base.constant.QuartzJobName;
import com.icinfo.cs.base.service.ICsQuartzJobService;
import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.common.utils.SleepUtil;
import com.icinfo.cs.concern.dto.CsConcernObjDto;
import com.icinfo.cs.concern.service.ICsConcernObjService;
import com.icinfo.cs.es.model.PanoramaSearch;
import com.icinfo.cs.es.service.IEsManageService;
import com.icinfo.cs.es.service.IPanoramaSearchService;
import com.icinfo.cs.es.util.JsonDateValueProcessor;
import com.icinfo.cs.ext.model.MidBaseinfoDel;
import com.icinfo.cs.ext.service.IMidBaseinfoDelService;
import com.icinfo.cs.other.service.IPubOtherlicenceService;
import com.icinfo.cs.risk.dto.CsEntWarnDto;
import com.icinfo.cs.risk.model.CsWarnMark;
import com.icinfo.cs.risk.service.ICsEntWarnService;
import com.icinfo.cs.risk.service.ICsWarnMarkService;
import com.icinfo.cs.supervise.dto.CsSuperviseObjDto;
import com.icinfo.cs.supervise.service.ICsSuperviseObjService;
import com.icinfo.cs.yr.service.IPubOtherpunishService;

import cn.gov.zj.gsj.v2.api.GsjClient;
import cn.gov.zj.gsj.v2.obj.entity.IndexDeleteRequest;
import cn.gov.zj.gsj.v2.obj.entity.IndexInsertRequest;
import cn.gov.zj.gsj.v2.obj.entity.IndexInsertResponse;
import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

/**
 * es索引维护
 * 
 * @author zhuyong
 *
 */
@Service
public class EsManageServiceImpl implements IEsManageService {

	private static final Logger logger = LoggerFactory.getLogger(EsManageServiceImpl.class);

	@Autowired
	ICsWarnMarkService csWarnMarkService;

	@Autowired
	ICsEntWarnService csEntWarnService;

	@Autowired
	ICsSuperviseObjService iCsSuperviseObjService;

	@Autowired
	ICsConcernObjService csConcernObjService;

	@Autowired
	IPanoramaSearchService panoramaSearchService;

	@Autowired
	IPubOtherlicenceService pubOtherlicenceService;

	@Autowired
	IPubOtherpunishService pubOtherpunishService;

	@Autowired
	ICsQuartzJobService csQuartzJobService;

	@Autowired
	IMidBaseinfoDelService midBaseinfoDelService;

	@Autowired
	GsjClient client;

	private static final int pageSize = 100;

	@Value("${es.panoramasearchindex}")
	private String panoramaSearchIndex;// 全景查询索引名称

	@Value("${cloudModel}")
	private String cloudModel;// 云平台模式 Y：开启 N：不开启

	private String jobName = QuartzJobName.PANORAMA_JOB.getJobName();

	/**
	 * 索引维护定时任务
	 * 
	 * @author zhuyong
	 */
	public void esQuartzJob() {
		try {
			// 阻塞任务，防止并发访问数据库
			SleepUtil.threadSleep();
			if (csQuartzJobService.checkJobIsExecute(jobName)) {
				return;
			}
			csQuartzJobService.insert(jobName);

			logger.info("/n {} start...", jobName);

			Map<String, Object> qryMap = new HashMap<String, Object>();
			qryMap.put("updateTime", DateUtil.dateToString(DateUtil.getNdaylaterDate(new Date(), -1), "yyyy-MM-dd"));

			// 基本信息增量
			panoramaIncJob(qryMap);
			// 许可信息增量
			licenseIncJob(qryMap);
			// 处罚信息增量
			punishIncJob(qryMap);
			// 标识信息增量
			markIncJob();

			// 从 cs_mid_baseinfo_del 删除索引
			List<MidBaseinfoDel> midBaseinfoDelList = midBaseinfoDelService.selectMidBaseinfoDelList();
			for (int i = 0; i < midBaseinfoDelList.size(); i++) {
				deleteOnePanoramaIdx(midBaseinfoDelList.get(i).getPriPID());// 根据内部序号删除索引
			}

		} catch (Exception e) {
			logger.info("{} 任务异常：{}", jobName, e + "");
		}
	}

	/**
	 * 更新单条索引信息
	 * 
	 * @author zhuyong
	 * @param priPID
	 * @throws Exception
	 */
	public String updateOnePanoramaIdx(String priPID) {
		if ("N".equalsIgnoreCase(cloudModel)) {
			return "";
		}
		try {
			if (StringUtils.isBlank(priPID))
				return "输入参数不合法";

			JsonConfig jsonConfig = new JsonConfig();
			jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
			IndexInsertRequest request = new IndexInsertRequest();
			IndexInsertResponse response = null;
			String beanStr = "";// 存储bean转成的json字符串

			request.setIndex(panoramaSearchIndex);// 索引名
			request.setType("single");
			PanoramaSearch obj = panoramaSearchService.selectOnePanorama(priPID);
			if (obj == null || StringUtils.isBlank(obj.getPriPID()))
				return "数据库没有改企业信息";

			beanStr = JSONArray.fromObject(obj, jsonConfig).toString().replace("[", "").replace("]", "");
			request.setKey(priPID);
			request.setJsonData(beanStr);
			response = client.excute(request);
			if (response.getErrorCode().isEmpty()) {
				logger.info("全景查询增量生成索引 success priPID={}...... ", priPID);
			} else {
				logger.info("全景查询增量生成索引 fail errorcode={} errmsg={}", response.getErrorCode(), response.getMessage());
			}
			return "索引更新成功";
		} catch (Exception e) {
			return "索引更新失败";
		}

	}

	/**
	 * 删除单条索引信息
	 * 
	 * @author zhuyong
	 * @param priPID
	 * @throws Exception
	 */
	public String deleteOnePanoramaIdx(String priPID) {
		if (StringUtils.isBlank(priPID)) {
			return "内部序号为空，不能删除";
		}
		try {
			IndexDeleteRequest indexDeleteRequest = new IndexDeleteRequest();
			indexDeleteRequest.setSql("delete from " + panoramaSearchIndex + " where priPID = '" + priPID + "'");
			client.excute(indexDeleteRequest);
			return "删除成功";
		} catch (Exception e) {
			return "删除失败";
		}
	}

	/**
	 * 基本信息增量更新
	 * 
	 * @author zhuyong
	 */
	public void panoramaIncJob(Map<String, Object> qryMap) {
		try {
			JsonConfig jsonConfig = new JsonConfig();
			jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());

			int incInt = panoramaSearchService.queryIncDataTotalForIdx(qryMap);
			IndexInsertRequest request = new IndexInsertRequest();
			IndexInsertResponse response = null;
			String beanStr = "";// 存储bean转成的json字符串

			for (int numStart = 0; numStart < incInt;) {// 将数据库数据生成至索引中去
				qryMap.put("numStart", numStart);
				qryMap.put("pageSize", pageSize);
				List<PanoramaSearch> dataList = panoramaSearchService.queryIncDataForIdx(qryMap);// 分页取出数据库数据
				request.setIndex(panoramaSearchIndex);// 索引名
				request.setType("single");
				PanoramaSearch obj = null;
				for (PanoramaSearch data : dataList) {
					if (StringUtils.isBlank(data.getPriPID()))
						continue;
					obj = panoramaSearchService.selectOnePanorama(data.getPriPID());
					beanStr = JSONArray.fromObject(obj, jsonConfig).toString().replace("[", "").replace("]", "");
					request.setKey(data.getPriPID());// 主键_ID的值
					request.setJsonData(beanStr);// 要插入的字段名和字段值
					response = client.excute(request);
					if (response.getErrorCode().isEmpty()) {
						logger.info("全景查询增量生成索引 success priPID={}...... ", data.getPriPID());
					} else {
						logger.info("全景查询增量生成索引 fail errorcode={} errmsg={}", response.getErrorCode(),
								response.getMessage());
					}
				}
				numStart = numStart + pageSize;
			}
		} catch (Exception e) {
			logger.info("索引维护定时任务异常[method=panoramaIncJob]：{}", e + "");
		}
	}

	/**
	 * 许可信息增量更新
	 * 
	 * @author zhuyong
	 */
	public void licenseIncJob(Map<String, Object> qryMap) {
		try {
			List<Map<String, Object>> dataList = pubOtherlicenceService.selectOtherlicencesMaps(qryMap);
			for (Map<String, Object> map : dataList) {
				panoramaSearchService.updatePanoramaIdx(map);
			}

		} catch (Exception e) {
			logger.info("索引维护定时任务异常[method=licenseIncJob]：{}", e + "");
		}
	}

	/**
	 * 处罚信息增量更新
	 * 
	 * @author zhuyong
	 */
	public void punishIncJob(Map<String, Object> qryMap) {
		try {
			List<Map<String, Object>> dataList = pubOtherpunishService.selectOtherpunishListForIdx(qryMap);
			for (Map<String, Object> map : dataList) {
				panoramaSearchService.updatePanoramaIdx(map);
			}

		} catch (Exception e) {
			logger.info("索引维护定时任务异常[method=punishIncJob]：{}", e + "");
		}
	}

	/**
	 * 风险预警 & 重点企业监管 & 关注服务 标识有效性相关的更新
	 * 
	 * @author zjj
	 */
	public void markIncJob() {
		try {
			// 查询因时间变化的标识
			Map<String, Object> qryMap = new HashMap<String, Object>();
			qryMap.put("dateForInvalidStart", DateUtil.getNdaylater2(new Date(), 0));
			qryMap.put("dateForInvalidEnd", DateUtil.getNdaylater2(new Date(), -1));
			List<CsWarnMark> list = csWarnMarkService.selectCsWarnMarkList(qryMap);
			for (CsWarnMark csWarnMark : list) {
				// 预警信息
				if ("yj".equals(csWarnMark.getMarkFunc())) {
					qryMap.put("MarkNo", csWarnMark.getMarkNo());
					List<CsEntWarnDto> csEntWarnList = csEntWarnService.selectCsEntWarnApplyInfo(qryMap);
					if (csEntWarnList.size() > 0) {
						for (CsEntWarnDto csEntWarnDto : csEntWarnList) {
							panoramaSearchService.updatePanoramaIdx(
									csEntWarnService.doGetEntWarnInfoForIndex(csEntWarnDto.getPriPID()));
						}
					}
					continue;
				}
				// 重点监管
				if ("jg".equals(csWarnMark.getMarkFunc())) {
					qryMap.put("MarkNo", csWarnMark.getMarkNo());
					List<CsSuperviseObjDto> csSuperviseObjList = iCsSuperviseObjService.queryListNoPage(qryMap);
					if (csSuperviseObjList.size() > 0) {
						for (CsSuperviseObjDto csSuperviseObjDto : csSuperviseObjList) {
							panoramaSearchService.updatePanoramaIdx(
									iCsSuperviseObjService.doGetSuperviewInfoForIndex(csSuperviseObjDto.getPriPID()));
						}
					}
					continue;
				}
				// 关注服务
				if ("gz".equals(csWarnMark.getMarkFunc())) {
					qryMap.put("MarkNo", csWarnMark.getMarkNo());
					List<CsConcernObjDto> csConcernObjList = csConcernObjService.selectCsConObjInfo(qryMap);
					if (csConcernObjList.size() > 0) {
						for (CsConcernObjDto csConcernObjDto : csConcernObjList) {
							panoramaSearchService.updatePanoramaIdx(
									csConcernObjService.doGetConcernInfoForIndex(csConcernObjDto.getPriPID()));
						}
					}
					continue;
				}
			}
		} catch (Exception e) {
			logger.info("索引维护定时任务异常[method=markIncJob]：{}", e + "");
		}
	}

}
