/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
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

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.icinfo.cs.base.constant.QuartzJobName;
import com.icinfo.cs.base.service.ICsQuartzJobService;
import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.common.utils.SleepUtil;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.es.dto.SmEntSearchDto;
import com.icinfo.cs.es.mapper.SmEntSearchMapper;
import com.icinfo.cs.es.service.ISmEntSearchService;
import com.icinfo.cs.es.util.EsGsUtil;
import com.icinfo.cs.es.util.JsonDateValueProcessor;
import com.icinfo.cs.sment.dto.SmBaseinfoDto;
import com.icinfo.cs.sment.service.ISmBaseinfoService;
import com.icinfo.framework.mybatis.pagehelper.Page;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

import cn.gov.zj.gsj.v2.api.GsjClient;
import cn.gov.zj.gsj.v2.obj.entity.IndexInsertRequest;
import cn.gov.zj.gsj.v2.obj.entity.IndexInsertResponse;
import cn.gov.zj.gsj.v2.obj.entity.IndexQueryResponse;
import cn.gov.zj.gsj.v2.sys.ApiException;
import net.sf.json.JsonConfig;

@Service
public class SmEntSearchServiceImpl implements ISmEntSearchService {
	private static final Logger logger = LoggerFactory.getLogger(SmEntSearchServiceImpl.class);
	private static final String[] nameArrWild = new String[] { "entName", "dom", "opScope" };// 需要模糊搜索的列
	private static final String[] nameArrMatch = new String[] { "leRep" };// 不需要模糊搜索的列
	private static final String[] nameArrMatchBool = new String[] { "maiBusincIsp", "empNumIsp", "assgroIsp" }; // in筛选
	private static final String[] nameArrSplit = new String[] { "industryCo", "entType", "entTypeCatg", "localAdm",
			"regOrg", "regState", "sliceNO", "industryType", "cultivationTypeCode", "demandType", "helpState" };// 需要切分的列
	private static final String[] dateRange = new String[] { "estDateStart", "estDateEnd" };// 日期

	@Value("${cloudModel}")
	private String cloudModel;// 云平台模式 Y：开启 N：不开启

	@Value("${es.smentsearchindex}")
	private String smEntSearchIndex;// 小微企业查询索引名称

	@Autowired
	GsjClient client;

	@Autowired
	SmEntSearchMapper smEntSearchMapper;

	@Autowired
	ISmBaseinfoService smBaseinfoService;

	private String jobName = QuartzJobName.SM_IDX_JOB.getJobName();
	private static final int pageSize = 100;

	@Autowired
	ICsQuartzJobService csQuartzJobService;

	@Override
	public Page<SmEntSearchDto> doGetSmEntSearchList(PageRequest request) throws Exception {
		if ("Y".equalsIgnoreCase(cloudModel)) {
			return queryPageCloud(request);
		}
		return null;
	}

	/**
	 * 描述：获取小微企业信息查询返回结果
	 * 
	 * @author baifangfang
	 * @date 2017年5月2日
	 * @param request
	 * @return
	 */
	private Page<SmEntSearchDto> queryPageCloud(PageRequest request) throws Exception {
		String baseSql = "select * from " + smEntSearchIndex;
		String sql = baseSql + queryPageCloudCond(request.getParams()) + " order by _score desc limit "
				+ request.getStart() + "," + request.getLength();
		logger.debug("查询SQL:" + sql);
		IndexQueryResponse response = EsGsUtil.getQueryRep(sql, client);
		Page<SmEntSearchDto> page = new Page<SmEntSearchDto>(request.getStart(), request.getLength());
		if (response.getErrorCode().isEmpty()) {
			String reqStr = response.getResult(); // 请求返回值
			JSONObject json = EsGsUtil.getJsonObj(reqStr);
			page.setTotal(EsGsUtil.getRstTotal(json));

			JSONArray jsonArr = EsGsUtil.parseEsReqResult(json);
			if (jsonArr != null && !jsonArr.isEmpty()) {
				page.addAll(EsGsUtil.jsonArr2ListSmEnt(jsonArr));
			}
			return page;
		}
		return null;
	}

	/**
	 * 描述：组装小微企业查询条件
	 * 
	 * @author baifangfnag
	 * @date 2017年5月2日
	 * @param params
	 * @return
	 */
	private String queryPageCloudCond(Map<String, Object> params) {
		if (params == null)
			return "";
		String rstSql = "";
		StringBuffer condSql = new StringBuffer("");

		/**************************** 统一信用代码/注册号 **************************/
		if (EsGsUtil.KIE(params, "cidRegNO"))
			condSql.append(" AND (unicode like '*" + params.get("cidRegNO").toString() + "' OR regNO like '*"
					+ params.get("cidRegNO").toString() + "')");

		/**************************** 需要模糊搜索的列 ****************************/
		for (String naw : nameArrWild) {
			if (EsGsUtil.KIE(params, naw))
				condSql.append(" AND (" + naw + " like '*" + EsGsUtil.MGV(params, naw) + "*')");
		}

		/************************** 不需要模糊搜索的列 **************************/
		for (String nam : nameArrMatch) {
			if (EsGsUtil.KIE(params, nam))
				condSql.append(" AND (" + nam + "='" + EsGsUtil.MGV(params, nam) + "')");
		}
		for (String nam : nameArrMatchBool) {
			if (!EsGsUtil.KIE(params, nam))
				continue;
			if ("Y".equals(EsGsUtil.MGV(params, nam)))
				condSql.append(" AND (" + nam + "='Y')");
			else
				condSql.append(" AND (" + nam + "<>'Y')");
		}

		/************************** 需要切分的列 **************************/
		for (String nas : nameArrSplit) {
			if (EsGsUtil.KIE(params, nas))
				condSql.append(" AND " + nas + " IN (" + EsGsUtil.MGV(params, nas) + ")");
		}

		/************************** 注册资本 **************************/
		if (EsGsUtil.KIE(params, "regCapStart"))// 注册资本开始
			condSql.append(" AND regCap>=" + EsGsUtil.MGV(params, "regCapStart"));
		if (EsGsUtil.KIE(params, "regCapEnd"))// 注册资本结束
			condSql.append(" AND regCap<=" + EsGsUtil.MGV(params, "regCapEnd"));

		/************************ 日期区间相关搜索 ***********************/
		for (String dr : dateRange) {
			if (!EsGsUtil.KIE(params, dr))
				continue;
			if (dr.contains("Start"))
				condSql.append(" AND " + dr.replace("Start", "") + ">=" + EsGsUtil.FCD(EsGsUtil.MGV(params, dr)));
			else
				condSql.append(
						" AND " + dr.replace("End", "") + "<" + EsGsUtil.FCD(EsGsUtil.AOD(EsGsUtil.MGV(params, dr))));
		}
		rstSql = condSql.toString();
		if (!StringUtil.isEmpty(rstSql)) {
			return " WHERE " + rstSql.substring(4, rstSql.length());
		} else {
			return "";
		}
	}

	@Override
	public void doInsertSmEntDataToGsById() {
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
		long time1 = System.currentTimeMillis();

		int perCount = 20000;// 每次导入数量
		int totalCount = 0;
		int total = getMaxId();
		if (total % perCount == 0) {
			totalCount = total / perCount;
		}
		totalCount = (total / perCount) + 1;// 一共需导入次数

		try {
			IndexInsertRequest request = new IndexInsertRequest();
			IndexInsertResponse response = null;
			String beanStr = "";// 存储bean转成的json字符串

			int start = 0;
			for (int current = 0; current <= totalCount; current++) {// 将数据库数据生成至索引中去
				logger.info("小微企业信息查询全量生成索引 共循环{}次, 当前循环第{}次, 一次导入{}条", totalCount, current, perCount);
				start = current * perCount;
				List<SmEntSearchDto> dataList = doGetListById(start);

				request.setIndex(smEntSearchIndex);// 索引名
				request.setType("single");// single是1条1插，batch是累积到1000条才插入

				for (SmEntSearchDto data : dataList) {
					beanStr = net.sf.json.JSONArray.fromObject(data, jsonConfig).toString().replace("[", "")
							.replace("]", "");
					request.setKey(data.getPriPID());// 主键_ID的值
					request.setJsonData(beanStr);// 要插入的字段名和字段值
					response = client.excute(request);

					if (response.getErrorCode().isEmpty()) {
					} else {
						logger.info("errorcode {},message {}", response.getErrorCode(), response.getMessage());
					}
				}
			}
		} catch (Exception e) {
			logger.info("exception {}", e, e.getMessage());
		}
		long time2 = System.currentTimeMillis();
		logger.info("小微企业信息全量生成索引 耗时:{}ms......", (time2 - time1));
	}

	private int getMaxId() {
		return smEntSearchMapper.selectMaxId();
	}

	private List<SmEntSearchDto> doGetListById(int start) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("start", start);
		paramMap.put("end", start + 20000);
		return smEntSearchMapper.selectIndexListById(paramMap);
	}

	@Override
	public boolean updateSmEnt(String condition) {
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
		List<SmBaseinfoDto> dataList = smBaseinfoService.selectListByCondition(condition);
		IndexInsertRequest request = new IndexInsertRequest();
		IndexInsertResponse response = null;

		if (dataList != null && dataList.size() > 0) {
			SmBaseinfoDto smBaseinfoDto = dataList.get(0);

			String beanStr = net.sf.json.JSONArray.fromObject(smBaseinfoDto, jsonConfig).toString().replace("[", "")
					.replace("]", "");
			request.setIndex(smEntSearchIndex);
			request.setType("single");
			request.setKey(smBaseinfoDto.getPriPID());// 主键_ID的值
			request.setJsonData(beanStr);// 要插入的字段名和字段值
			try {
				response = client.excute(request);
			} catch (ApiException e) {
				logger.info("exception {}", e, e.getMessage());
				return false;
			}

			if (response.getErrorCode().isEmpty()) {
				logger.info("result {}", response.getResult());
			} else {
				logger.info("errorcode {},message {}", response.getErrorCode(), response.getMessage());
				return false;
			}
		} else {
			return false;
		}
		return true;
	}

	@Override
	public void doInsertIncreToGs() {
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

			smEntInCreJob(qryMap);
		} catch (Exception e) {
			logger.info("{} 任务异常：{}", jobName, e + "");
		}

	}

	/**
	 * 描述：小微企业信息查询索引增量更新
	 * 
	 * @author baifangfang
	 * @date 2017年5月8日
	 * @param qryMap
	 */
	private void smEntInCreJob(Map<String, Object> qryMap) {
		try {
			JsonConfig jsonConfig = new JsonConfig();
			jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());

			int increCount = smBaseinfoService.queryIncreCount(qryMap);
			IndexInsertRequest request = new IndexInsertRequest();
			IndexInsertResponse response = null;
			String beanStr = "";// 存储bean转成的json字符串

			for (int numStart = 0; numStart < increCount;) {
				qryMap.put("numStart", numStart);
				qryMap.put("pageSize", pageSize);
				List<SmBaseinfoDto> dataList = smBaseinfoService.queryIncreData(qryMap);// 分页取出数据库priPID
				request.setIndex(smEntSearchIndex);// 索引名
				request.setType("single");
				SmBaseinfoDto obj = null;
				for (SmBaseinfoDto data : dataList) {
					if (StringUtils.isBlank(data.getPriPID()))
						continue;
					obj = smBaseinfoService.selectListByCondition(data.getPriPID()).get(0);
					beanStr = net.sf.json.JSONArray.fromObject(obj, jsonConfig).toString().replace("[", "").replace("]", "");
					request.setKey(data.getPriPID());// 主键_ID的值
					request.setJsonData(beanStr);// 要插入的字段名和字段值
					response = client.excute(request);
					if (response.getErrorCode().isEmpty()) {
						logger.info("小微企业查询增量生成索引 success priPID={}...... ", data.getPriPID());
					} else {
						logger.info("小微企业查询增量生成索引 fail errorcode={} errmsg={}", response.getErrorCode(),
								response.getMessage());
					}
				}
				numStart = numStart + pageSize;
			}
		} catch (Exception e) {
			logger.info("索引维护定时任务异常[method=panoramaIncJob]：{}", e + "");
		}

	}
}