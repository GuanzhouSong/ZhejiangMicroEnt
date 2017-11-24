package com.icinfo.cs.es.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.icinfo.cs.common.constant.DBAuthorConstants;
import com.icinfo.cs.common.constant.RegStateEnum;
import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.common.utils.HttpFluent;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.drcheck.model.PubScinfoBack;
import com.icinfo.cs.drcheck.service.IPubScinfoBackService;
import com.icinfo.cs.es.dto.PanoramaResultDto;
import com.icinfo.cs.es.mapper.PanoramaSearchMapper;
import com.icinfo.cs.es.model.PanoramaSearch;
import com.icinfo.cs.es.service.IPanoramaSearchService;
import com.icinfo.cs.es.util.ESUtil;
import com.icinfo.cs.es.util.EsGsUtil;
import com.icinfo.cs.es.util.JsonDateValueProcessor;
import com.icinfo.cs.ext.model.MidLeRep;
import com.icinfo.cs.ext.service.IMidBaseInfoService;
import com.icinfo.cs.ext.service.IMidLeRepService;
import com.icinfo.cs.login.model.PubEppassword;
import com.icinfo.cs.login.service.IPubEppasswordService;
import com.icinfo.cs.yr.model.YrOtherInfo;
import com.icinfo.cs.yr.service.IYrOtherInfoService;
import com.icinfo.framework.mybatis.pagehelper.Page;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.tools.utils.StringUtils;

import cn.gov.zj.gsj.v2.api.GsjClient;
import cn.gov.zj.gsj.v2.obj.entity.IndexInsertRequest;
import cn.gov.zj.gsj.v2.obj.entity.IndexInsertResponse;
import cn.gov.zj.gsj.v2.obj.entity.IndexQueryResponse;
import net.sf.json.JsonConfig;

/**
 * 全景查询相关业务方法
 * 
 * @author zhuyong
 */
@Service
public class PanoramaSearchServiceImpl implements IPanoramaSearchService {

	private static final Logger logger = LoggerFactory.getLogger(PanoramaSearchServiceImpl.class);

	// 云平台开启标志
	private static final String cloudOpen = "Y";

	@Autowired
	PanoramaSearchMapper panoramaSearchMapper;

	@Autowired
	private IPubScinfoBackService pubScinfoBackService;

	@Value("${cloudModel}")
	private String cloudModel;// 云平台模式 Y：开启 N：不开启

	@Value("${es.ip}")
	private String esHost;// es服务器的ip

	@Value("${es.http.port}")
	private String esHttpPort;// es服务器的端口

	@Value("${es.panoramasearchindex}")
	private String panoramaSearchIndex;// 全景查询索引名称

	@Value("${es.panoramasearchtype}")
	private String panoramaSearchType;// 全景查询类型

	@Autowired
	GsjClient client;

	@Autowired
	IPubEppasswordService pubEppasswordService;

	@Autowired
	IMidBaseInfoService midBaseInfoService;

	@Autowired
	IYrOtherInfoService yrOtherInfoService;

	@Autowired
	IMidLeRepService midLeRepService;

	// 需要模糊搜索的列
	private static final String[] nameArrWild = new String[] { "entName", "isOpan", "dom", "opScope", "licNameAft",
			"liaName" };

	// 需要切分的列
	private static final String[] nameArrSplit = new String[] { "industryCo", "entType", "entTypeCatg", "localAdm",
			"regOrg", "regState", "sliceNO", "checkDep" };

	// 即时信息相关列
	private static final String[] imCon = new String[] { "imCase", "imInvest", "imPermit", "imIppldg", "imInvsra" };

	// 年报相关的搜索条件
	private static final String[] yrRepMatch = new String[] { "yrRepMode", "yrIsRep", "yrRepState", "acceptDept",
			"acceptName" };

	// 年报相关的搜索条件 in & not in 筛选
	private static final String[] yrRepMatchBool = new String[] { "yrRepModify", "yrSenCheck" };

	// 不需要模糊搜索的列
	private static final String[] nameArrMatch = new String[] { "leRep", "licState", "tel" };

	// 不需要模糊搜索的列 用作 in & not in筛选
	private static final String[] nameArrMatchBool = new String[] { "isCase", "isSim", "leRepIsLim", "isIndRegObj",
			"isFocusObj", "isRiskWarn" };

	/****************************************************
	 * estDateStart 成立日期开始 estDateEnd 成立日期结束 apprDateStart 核准日期开始 apprDateEnd
	 * 核准日期结束 altDateStart 销户日期开始 altDateEnd 销户日期结束
	 ****************************************************/
	private static final String[] dateRange = new String[] { "estDateStart", "estDateEnd", "apprDateStart",
			"apprDateEnd", "altDateStart", "altDateEnd", "imPubDateStart", "imPubDateEnd" };

	/**
	 * 获取查询返回结果
	 * 
	 * @author zhuyong
	 * @param keyword
	 * @return
	 * @throws Exception
	 */
	public String doGetResponseStr(String keyword) {
		try {
			if (cloudOpen.equalsIgnoreCase(cloudModel)) {// 云平台开启
				String sql = "select * from " + panoramaSearchIndex + " where priPID = '" + keyword + "' limit 0,1";
				IndexQueryResponse response = EsGsUtil.getQueryRep(sql, client);
				return response.getResult(); // 请求返回值
			} else {
				// 返回第一页查询结果 返回十条数据
				String param = ESUtil.toBoolQueryStr(
						QueryBuilders.boolQuery().should(QueryBuilders.matchQuery("priPID", keyword)), 0, 1);
				// 请求返回值
				return HttpFluent.postData(doBuildQueryURL(), param);
			}
		} catch (Exception e) {
			return "发生异常";
		}
	}

	/**
	 * 获取综合查询返回结果 无分页功能
	 * 
	 * @author zhuyong
	 * @param keyword
	 * @return
	 * @throws Exception
	 */
	public List<PanoramaResultDto> doGetSearchList(String keyword) throws Exception {
		if (cloudOpen.equalsIgnoreCase(cloudModel))// 云平台开启
			return queryCompCloud(keyword);

		return queryCompNormal(keyword);
	}

	/**
	 * 获取全景查询返回结果 供分页框架使用
	 * 
	 * @author zhuyong
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public Page<PanoramaResultDto> doGetSearchList(PageRequest request) throws Exception {
		if (cloudOpen.equalsIgnoreCase(cloudModel))// 云平台开启
			return queryPageCloud(request);

		return queryPageNormal(request);
	}

	/**
	 * 获取企业综合查询返回结果
	 * 
	 * @author baifangfang
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public Page<PanoramaResultDto> doGetComSearchList(PageRequest request) throws Exception {
		if (cloudOpen.equalsIgnoreCase(cloudModel))// 云平台开启
			return queryPageCloudCom(request);

		return queryPageNormal(request);
	}

	/**
	 * 获取企业综合查询返回结果(导出全部)
	 * 
	 * @author baifangfang
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public Page<PanoramaResultDto> doGetComSearchListAll(PageRequest request) throws Exception {
		request.setLength(20000);
		request.setStart(0);
		if (cloudOpen.equalsIgnoreCase(cloudModel))// 云平台开启
			return queryPageCloudCom(request);

		return queryPageNormal(request);
	}

	/**
	 * 获取企业综合查询返回结果(导出全部)
	 * 
	 * @author baifangfang
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public Integer doGetComSearchListAllCount(PageRequest request) throws Exception {
		if (cloudOpen.equalsIgnoreCase(cloudModel))// 云平台开启
			return queryPageCloudComCount(request);
		else {
			return 0;
		}
	}

	/**
	 * 获取多年度企业综合查询返回结果
	 * 
	 * @author baifangfang
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@Override
	public Page<PanoramaResultDto> doGetYearsComSearchList(PageRequest request) throws Exception {
		if (cloudOpen.equalsIgnoreCase(cloudModel))// 云平台开启
			return queryPageCloudComYears(request);

		return queryPageNormal(request);
	}

	@Override
	public Page<PanoramaResultDto> doGetSmsSearchList(PageRequest request) throws Exception {
		if (cloudOpen.equalsIgnoreCase(cloudModel))// 云平台开启
			return queryPageCloudSms(request);

		return queryPageNormal(request);
	}

	@Override
	public Page<PanoramaResultDto> doGetEmailSearchList(PageRequest request) throws Exception {
		if (cloudOpen.equalsIgnoreCase(cloudModel))// 云平台开启
			return queryPageCloudEmail(request);

		return queryPageNormal(request);
	}

	/**
	 * 获取全景查询返回结果 供分页框架使用
	 * 
	 * @author zhuyong
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public String doSearchForPubScinfoList(String taskNO, Map<String, Object> params) throws Exception {
		if (cloudOpen.equalsIgnoreCase(cloudModel))// 云平台开启
			return queryForPubScinfoListCloud(taskNO, params);

		return queryForPubScinfoListNormal(taskNO, params);
	}

	/**
	 * 更新全景查询索引
	 * 
	 * @author zhuyong
	 * @param jsonMap
	 *            需要更新的内容
	 */
	public String updatePanoramaIdx(Map<String, Object> jsonMap) {
		if (cloudOpen.equalsIgnoreCase(cloudModel))// 云平台开启
			return updatePanoramaIdxCloud(jsonMap);
		return "1";
		// return updatePanoramaIdxNormal(jsonMap);

	}

	/**
	 * 往工商云平台索引插入数据
	 * 
	 * @author zhuyong
	 * @throws Exception
	 */
	public void doInsertIndexToGs() throws Exception {
		logger.info("全景查询全量生成索引 start......");

		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
		long time1 = System.currentTimeMillis();
		int pageSize = 4000;
		int maxId = doGetMaxId() + 1;

		IndexInsertRequest request = new IndexInsertRequest();
		IndexInsertResponse response = null;
		String beanStr = "";// 存储bean转成的json字符串

		Map<String, Object> map = new HashMap<String, Object>();
		for (int idStart = 0; idStart < maxId;) {// 将数据库数据生成至索引中去
			logger.info("\n全景查询全量生成索引 共{}条数据  当前条数{}-{}", maxId, idStart, idStart + pageSize);
			map.put("idStart", idStart);
			map.put("idEnd", idStart + pageSize);
			List<PanoramaSearch> dataList = doGetList(map);// 分页取出数据库数据
			if (dataList == null || dataList.size() == 0 || StringUtils.isBlank(dataList.get(0).getPriPID()))
				break;
			idStart = idStart + pageSize;
			request.setIndex(panoramaSearchIndex);// 索引名
			request.setType("single");// single是1条1插，batch是累积到1000条才插入

			for (PanoramaSearch data : dataList) {
				beanStr = net.sf.json.JSONArray.fromObject(data, jsonConfig).toString().replace("[", "").replace("]",
						"");
				request.setKey(data.getPriPID());// 主键_ID的值
				request.setJsonData(beanStr);// 要插入的字段名和字段值
				response = client.excute(request);
				if (response.getErrorCode().isEmpty()) {
					// logger.info("全景查询全量生成索引 success priPID={}......
					// ",data.getPriPID());
				} else {
					logger.info("全景查询全量生成索引 fail errorcode={} errmsg={}", response.getErrorCode(),
							response.getMessage());
				}
			}
		}
		long time2 = System.currentTimeMillis();

		logger.info("\n全景查询全量生成索引 耗时:{}ms......", (time2 - time1));
		logger.info("\n全景查询全量生成索引 end......");
	}

	/**
	 * 获取综合查询返回结果 无分页功能 非云平台方法
	 * 
	 * @author zhuyong
	 * @param keyword
	 * @return
	 * @throws Exception
	 */
	private List<PanoramaResultDto> queryCompNormal(String keyword) throws Exception {
		// 返回第一页查询结果 返回十条数据
		String param = ESUtil.toBoolQueryStr(buildCompQuery(keyword), 0, 10);
		// 请求返回值
		String reqStr = HttpFluent.postData(doBuildQueryURL(), param);

		return EsGsUtil.jsonArr2List(EsGsUtil.parseEsReqResult(EsGsUtil.getJsonObj(reqStr)));
	}

	/**
	 * 获取综合查询返回结果 无分页功能 云平台方法
	 * 
	 * @author zhuyong
	 * @param keyword
	 * @return
	 * @throws Exception
	 */
	private List<PanoramaResultDto> queryCompCloud(String keyword) throws Exception {

		String sql = "select * from " + panoramaSearchIndex + " where entNamePPL = matchQuery('" + keyword
				+ "') OR regNO = '" + keyword + "' OR uniscid ='" + keyword + "' order by _score desc limit 0,10";

		IndexQueryResponse response = EsGsUtil.getQueryRep(sql, client);
		if (response.getErrorCode().isEmpty()) {
			String reqStr = response.getResult(); // 请求返回值
			return EsGsUtil.jsonArr2List(EsGsUtil.parseEsReqResult(EsGsUtil.getJsonObj(reqStr)));
		}
		return null;
	}

	/**
	 * 获取全景查询返回结果 供分页框架使用 非云平台使用
	 * 
	 * @author zhuyong
	 * @param request
	 * @return
	 * @throws Exception
	 */
	private Page<PanoramaResultDto> queryPageNormal(PageRequest request) throws Exception {
		BoolQueryBuilder bqb = buildManyQuery(request.getParams());
		String param = ESUtil.toBoolQueryStr(bqb, request.getStart(), request.getLength());
		String reqStr = HttpFluent.postData(doBuildQueryURL(), param); // 请求返回值
		Page<PanoramaResultDto> page = new Page<PanoramaResultDto>(request.getStart(), request.getLength());
		JSONObject json = EsGsUtil.getJsonObj(reqStr);
		page.setTotal(EsGsUtil.getRstTotal(json));
		page.addAll(jsonArr2List(EsGsUtil.parseEsReqResult(json)));
		return page;
	}

	private List<PanoramaResultDto> jsonArr2List(JSONArray jsonArr) throws Exception {
		List<PanoramaResultDto> dataList = new ArrayList<PanoramaResultDto>();
		for (int i = 0; i < jsonArr.size(); i++) {
			JSONObject jsonObj = (JSONObject) jsonArr.get(i);
			JSONObject appObj = jsonObj.getJSONObject("_source");
			PanoramaResultDto panoramaResultDto = (PanoramaResultDto) JSONObject.toJavaObject(appObj,
					PanoramaResultDto.class);
			int year = Integer.parseInt(DateUtil.getCurrentYear()) - 1;
			YrOtherInfo yrOtherInfo = yrOtherInfoService.selectByYearAndPripid(year, panoramaResultDto.getPriPID());
			String email = null;
			if (yrOtherInfo != null) {
				if (!StringUtil.isEmpty(email)) {
					yrOtherInfo = yrOtherInfoService.selectByYearAndPripid(year, panoramaResultDto.getPriPID());
					email = yrOtherInfo.getEmail();
				} else {
					yrOtherInfo = yrOtherInfoService.selectByYearAndPripid(year - 1, panoramaResultDto.getPriPID());
					if (yrOtherInfo != null) {
						email = yrOtherInfo.getEmail();
					}
				}
			}
			panoramaResultDto.setEmail(email);
			dataList.add(panoramaResultDto);
		}
		return dataList;
	}

	/**
	 * 获取全景查询返回结果 供分页框架使用 云平台使用
	 * 
	 * @author zhuyong
	 * @param request
	 * @return
	 * @throws Exception
	 */
	private Page<PanoramaResultDto> queryPageCloud(PageRequest request) throws Exception {
		String baseSql = "select * from " + panoramaSearchIndex;
		String sql = baseSql + queryPageCloudCond(request.getParams()) + " order by _score desc limit "
				+ request.getStart() + "," + request.getLength();
		logger.debug("查询SQL:" + sql);
		IndexQueryResponse response = EsGsUtil.getQueryRep(sql, client);
		Page<PanoramaResultDto> page = new Page<PanoramaResultDto>(request.getStart(), request.getLength());
		if (response.getErrorCode().isEmpty()) {
			String reqStr = response.getResult(); // 请求返回值
			JSONObject json = EsGsUtil.getJsonObj(reqStr);
			page.setTotal(EsGsUtil.getRstTotal(json));
			page.addAll(EsGsUtil.jsonArr2List(EsGsUtil.parseEsReqResult(json)));
			return page;
		}
		return null;
	}

	/**
	 * 获取企业综合查询返回结果 供分页框架使用 云平台使用
	 * 
	 * @author baifangfang
	 * @param request
	 * @return
	 * @throws Exception
	 */
	private Page<PanoramaResultDto> queryPageCloudCom(PageRequest request) throws Exception {
		String baseSql = "select * from " + panoramaSearchIndex;
		String sql = baseSql + queryPageCloudCondCom(request.getParams()) + " order by _score desc limit "
				+ request.getStart() + "," + request.getLength();
		logger.debug("查询SQL:" + sql);
		IndexQueryResponse response = EsGsUtil.getQueryRep(sql, client);
		Page<PanoramaResultDto> page = new Page<PanoramaResultDto>(request.getStart(), request.getLength());
		if (response.getErrorCode().isEmpty()) {
			String reqStr = response.getResult(); // 请求返回值
			JSONObject json = EsGsUtil.getJsonObj(reqStr);
			page.setTotal(EsGsUtil.getRstTotal(json));

			JSONArray jsonArr = EsGsUtil.parseEsReqResult(json);
			if (jsonArr != null && !jsonArr.isEmpty()) {
				page.addAll(jsonArr2ListCom(jsonArr));
			}
			return page;
		}
		return null;
	}

	/**
	 * 获取企业综合查询统计数量
	 * 
	 * @author baifangfang
	 * @param request
	 * @return
	 * @throws Exception
	 */
	private Integer queryPageCloudComCount(PageRequest request) throws Exception {
		String baseSql = "select count(*) from " + panoramaSearchIndex;
		String sql = baseSql + queryPageCloudCondCom(request.getParams());
		logger.debug("查询SQL:" + sql);
		IndexQueryResponse response = EsGsUtil.getQueryRep(sql, client);
		if (response.getErrorCode().isEmpty()) {
			String result = response.getResult();
			JSONObject json = EsGsUtil.getJsonObj(result);
			Integer count = EsGsUtil.getRstTotal(json);
			return count;
		}
		return null;
	}

	/**
	 * 获取发送短信企业
	 * 
	 * @author baifangfang
	 * @param request
	 * @return
	 * @throws Exception
	 */
	private Page<PanoramaResultDto> queryPageCloudSms(PageRequest request) throws Exception {
		String baseSql = "select * from " + panoramaSearchIndex;
		String sql = baseSql + queryPageCloudCondSms(request.getParams()) + " order by _score desc limit "
				+ request.getStart() + "," + request.getLength();
		logger.debug("查询SQL:" + sql);
		IndexQueryResponse response = EsGsUtil.getQueryRep(sql, client);
		Page<PanoramaResultDto> page = new Page<PanoramaResultDto>(request.getStart(), request.getLength());
		if (response.getErrorCode().isEmpty()) {
			String reqStr = response.getResult(); // 请求返回值
			JSONObject json = EsGsUtil.getJsonObj(reqStr);
			page.setTotal(EsGsUtil.getRstTotal(json));

			JSONArray jsonArr = EsGsUtil.parseEsReqResult(json);
			if (jsonArr != null && !jsonArr.isEmpty()) {
				page.addAll(jsonArr2ListCom(jsonArr));
			}
			return page;
		}
		return null;
	}

	/**
	 * 获取发送短信企业
	 * 
	 * @author baifangfang
	 * @param request
	 * @return
	 * @throws Exception
	 */
	private Page<PanoramaResultDto> queryPageCloudEmail(PageRequest request) throws Exception {
		String baseSql = "select * from " + panoramaSearchIndex;
		String sql = baseSql + queryPageCloudCondSms(request.getParams()) + " order by _score desc limit "
				+ request.getStart() + "," + request.getLength();
		logger.debug("查询SQL:" + sql);
		IndexQueryResponse response = EsGsUtil.getQueryRep(sql, client);
		Page<PanoramaResultDto> page = new Page<PanoramaResultDto>(request.getStart(), request.getLength());
		if (response.getErrorCode().isEmpty()) {
			String reqStr = response.getResult(); // 请求返回值
			JSONObject json = EsGsUtil.getJsonObj(reqStr);
			page.setTotal(EsGsUtil.getRstTotal(json));

			JSONArray jsonArr = EsGsUtil.parseEsReqResult(json);
			if (jsonArr != null && !jsonArr.isEmpty()) {
				page.addAll(jsonArr2ListEmail(jsonArr));
			}
			return page;
		}
		return null;
	}

	/**
	 * 获取企业综合查询返回结果 供分页框架使用 云平台使用
	 * 
	 * @author baifangfang
	 * @param request
	 * @return
	 * @throws Exception
	 */
	private Page<PanoramaResultDto> queryPageCloudComYears(PageRequest request) throws Exception {
		String baseSql = "select * from " + panoramaSearchIndex;
		String sql = baseSql + queryPageCloudCondComYears(request.getParams()) + " order by _score desc limit "
				+ request.getStart() + "," + request.getLength();
		logger.debug("查询SQL:" + sql);
		IndexQueryResponse response = EsGsUtil.getQueryRep(sql, client);
		Page<PanoramaResultDto> page = new Page<PanoramaResultDto>(request.getStart(), request.getLength());
		if (response.getErrorCode().isEmpty()) {
			String reqStr = response.getResult(); // 请求返回值
			JSONObject json = EsGsUtil.getJsonObj(reqStr);
			page.setTotal(EsGsUtil.getRstTotal(json));

			JSONArray jsonArr = EsGsUtil.parseEsReqResult(json);
			if (jsonArr != null && !jsonArr.isEmpty()) {
				page.addAll(jsonArr2ListCom(jsonArr));
			}
			return page;
		}
		return null;
	}

	/**
	 * 描述： 将jsonarray类型的数据转成企业综合查询结果集
	 * 
	 * @author baifangfang
	 * @return
	 * @throws Exception
	 */
	private List<PanoramaResultDto> jsonArr2ListCom(JSONArray jsonArr) throws Exception {
		List<PanoramaResultDto> dataList = new ArrayList<PanoramaResultDto>();
		List<String> priPidList = new ArrayList<String>();
		Map<String, PanoramaResultDto> dtoMap = new HashMap<String, PanoramaResultDto>();
		Map<String, Date> lerepMap = new HashMap<String, Date>();
		JSONObject jsonObj = null;
		JSONObject appObj = null;
		PanoramaResultDto panoramaResultDto = null;
		int year = Integer.parseInt(DateUtil.getCurrentYear()) - 1;
		for (int i = 0; i < jsonArr.size(); i++) {
			jsonObj = (JSONObject) jsonArr.get(i);
			appObj = jsonObj.getJSONObject("_source");
			panoramaResultDto = (PanoramaResultDto) JSONObject.toJavaObject(appObj, PanoramaResultDto.class);
			priPidList.add(panoramaResultDto.getPriPID());
			dtoMap.put(panoramaResultDto.getPriPID(), panoramaResultDto);
		}

		PanoramaResultDto dto = null;
		// 1 法人表中取法人名称
		List<MidLeRep> midLerepList = midLeRepService.findMidLerepByPriPIDList(priPidList);
		if (midLerepList != null && midLerepList.size() > 0) {
			for (MidLeRep midLeRep : midLerepList) {
				dto = dtoMap.get(midLeRep.getPriPID());
				dto.setLeRep(midLeRep.getName());
				if (!StringUtil.isEmpty(midLeRep.getMobTel())) {
					dto.setTel(midLeRep.getMobTel());
				} else if (!StringUtil.isEmpty(midLeRep.getTel())) {
					dto.setTel(midLeRep.getTel());
				}
				dtoMap.put(midLeRep.getPriPID(), dto);
				lerepMap.put(midLeRep.getPriPID(), midLeRep.getUpdateTime());
			}
		}
		// 2 联络员表中取数据
		List<PubEppassword> pubEppasswordList = pubEppasswordService.selectLiaInfo(priPidList, year);
		if (pubEppasswordList != null && pubEppasswordList.size() > 0) {
			for (PubEppassword pubEppassword : pubEppasswordList) {
				// 比较两个更新时间用于取法人电话
				Date lerepUpdateTime = lerepMap.get(pubEppassword.getPripid());
				Date liaUpdateTime = pubEppassword.getUpdateTime();
				dto = dtoMap.get(pubEppassword.getPripid());
				if (lerepUpdateTime != null) {
					if (liaUpdateTime.getTime() > lerepUpdateTime.getTime()) {
						dto.setTel(pubEppassword.getLerepphone());
					}
				}
				dto.setLiaName(pubEppassword.getLianame());
				dto.setLiaTel(pubEppassword.getTel());
				dtoMap.put(pubEppassword.getPripid(), dto);
			}
		}

		Iterator<String> keys = dtoMap.keySet().iterator();
		while (keys.hasNext()) {
			String key = (String) keys.next();
			dataList.add(dtoMap.get(key));
		}
		return dataList;
	}

	/**
	 * 描述： 将jsonarray类型的数据转成企业综合查询结果集
	 * 
	 * @author baifangfang
	 * @return
	 * @throws Exception
	 */
	private List<PanoramaResultDto> jsonArr2ListEmail(JSONArray jsonArr) throws Exception {
		List<PanoramaResultDto> dataList = new ArrayList<PanoramaResultDto>();
		JSONObject jsonObj = null;
		JSONObject appObj = null;
		PanoramaResultDto panoramaResultDto = null;
		// 循环查询企业邮箱
		for (int i = 0; i < jsonArr.size(); i++) {
			jsonObj = (JSONObject) jsonArr.get(i);
			appObj = jsonObj.getJSONObject("_source");
			panoramaResultDto = (PanoramaResultDto) JSONObject.toJavaObject(appObj, PanoramaResultDto.class);
			int year = Integer.parseInt(DateUtil.getCurrentYear()) - 1;
			YrOtherInfo yrOtherInfo = yrOtherInfoService.selectByYearAndPripid(year, panoramaResultDto.getPriPID());
			String email = null;
			if (yrOtherInfo != null) {
				if (!StringUtil.isEmpty(email)) {
					yrOtherInfo = yrOtherInfoService.selectByYearAndPripid(year, panoramaResultDto.getPriPID());
					email = yrOtherInfo.getEmail();
				} else {
					yrOtherInfo = yrOtherInfoService.selectByYearAndPripid(year - 1, panoramaResultDto.getPriPID());
					if (yrOtherInfo != null) {
						email = yrOtherInfo.getEmail();
					}
				}
			}
			panoramaResultDto.setEmail(email);
			dataList.add(panoramaResultDto);
		}

		return dataList;
	}

	/**
	 * 组装工商云搜索引擎查询条件
	 * 
	 * @author zhuyong
	 * @param params
	 * @return
	 * @throws Exception
	 */
	private String queryPageCloudCond(Map<String, Object> params) throws Exception {
		if (params == null)
			return "";
		String rstSql = "";
		StringBuffer condSql = new StringBuffer("");

		/**************************** 统一信用代码/注册号 **************************/
		if (EsGsUtil.KIE(params, "cidRegNO"))
			condSql.append(" AND (uniscid like '*" + params.get("cidRegNO").toString() + "' OR regNO like '*"
					+ params.get("cidRegNO").toString() + "')");

		/**************************** 统一信用代码/注册号/企业名称 **************************/
		if (EsGsUtil.KIE(params, "cidRegNOEntName"))
			condSql.append(" AND (uniscid like '*" + params.get("cidRegNOEntName").toString() + "' OR regNO like '*"
					+ params.get("cidRegNOEntName").toString() + "' OR entName like '*"
					+ params.get("cidRegNOEntName").toString() + "*')");

		/**************************** 是否建档 **************************/
		if (EsGsUtil.KIE(params, "isClaimRegist")) {
			condSql.append(" AND (localAdm is not null) AND (localAdm <> '' ) AND (isClaimRegist='Y') ");
		}

		/***************************** 是否联络员确认 *******************************/
		if (EsGsUtil.KIE(params, "yrLiaConfirm")) {
			if ("Y".equals(EsGsUtil.MGV(params, "yrLiaConfirm")))
				condSql.append(" AND (liaName <> '') ");
			else
				condSql.append(" AND (liaName = '') ");
		}

		/**************************** 最近一年是否抽检 ******************************/
		if (EsGsUtil.KIE(params, "spotDate")) {
			if ("Y".equals(EsGsUtil.MGV(params, "spotDate")))
				condSql.append(" AND( spotDate>=" + EsGsUtil.FCD(DateUtil.getNyearlaterDate(new Date(), -1)) + ")");
			else
				condSql.append(" AND( spotDate<" + EsGsUtil.FCD(DateUtil.getNyearlaterDate(new Date(), -1))
						+ " OR spotDate is null )");
		}

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

		/************************** 不良信息 **************************/
		condSql = badInfo(params, condSql);

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

		/************************** 年报相关搜索 **************************/
		if (EsGsUtil.KIE(params, "yrYear")) {
			String yrYear = params.get("yrYear") + "";
			condSql.append(" AND estDate <" + EsGsUtil.FCD(EsGsUtil.GNY(yrYear)));

			/************************** 去除年报方式 **************************/
			if (EsGsUtil.KIE(params, "repTypeNotIn")) {
				condSql.append("AND (yrRepMode" + yrYear + " not in (2,4,5)) ");
			}
			if (EsGsUtil.KIE(params, "yrRepModeGT")) {
				if ("6".equals(EsGsUtil.MGV(params, "yrRepModeGT"))) {
					condSql.append("AND (yrRepMode" + yrYear + "= '6') ");
				} else {
					condSql.append("AND (yrRepMode" + yrYear + " not in (6)) ");
				}
			}

			/************************** 最近报送时间 **************************/
			if (EsGsUtil.KIE(params, "yrRecRepTimeStart"))// 最近报送时间
				condSql.append(
						" AND yrRecRepTime" + yrYear + ">=" + EsGsUtil.FCD(EsGsUtil.MGV(params, "yrRecRepTimeStart")));
			if (EsGsUtil.KIE(params, "yrRecRepTimeEnd"))// 最近报送时间
				condSql.append(
						" AND yrRecRepTime" + yrYear + "<=" + EsGsUtil.FCD(EsGsUtil.MGV(params, "yrRecRepTimeEnd")));
			/************************** 首次报送时间 **************************/
			if (EsGsUtil.KIE(params, "yrFirRepTimeStart"))// 首次报送时间
				condSql.append(
						" AND yrFirRepTime" + yrYear + ">=" + EsGsUtil.FCD(EsGsUtil.MGV(params, "yrFirRepTimeStart")));
			if (EsGsUtil.KIE(params, "yrFirRepTimeEnd"))// 首次报送时间
				condSql.append(
						" AND yrFirRepTime" + yrYear + "<=" + EsGsUtil.FCD(EsGsUtil.MGV(params, "yrFirRepTimeEnd")));

			/************************** 纸质接收时间 **************************/
			if (EsGsUtil.KIE(params, "acceptDateStart"))// 纸质接收时间
				condSql.append(
						" AND acceptDate" + yrYear + ">=" + EsGsUtil.FCD(EsGsUtil.MGV(params, "acceptDateStart")));
			if (EsGsUtil.KIE(params, "acceptDateEnd"))// 纸质接收时间
				condSql.append(" AND acceptDate" + yrYear + "<"
						+ EsGsUtil.FCD(EsGsUtil.AOD(EsGsUtil.MGV(params, "acceptDateEnd"))));

			/****************************************************
			 * yrRepMode 年报方式 yrIsRep 是否年报 yrSenCheck 是否涉及敏感词审核
			 ****************************************************/
			for (String nam : yrRepMatch) {
				if (!EsGsUtil.KIE(params, nam))
					continue;
				condSql.append(" AND (" + nam + yrYear + "='" + params.get(nam) + "')");
			}

			for (String nam : yrRepMatchBool) {
				if (!EsGsUtil.KIE(params, nam))
					continue;
				if ("Y".equals(EsGsUtil.MGV(params, nam)))
					condSql.append(" AND (" + nam + yrYear + "='Y')");
				else
					condSql.append(" AND (" + nam + yrYear + "<>'Y')");
			}

		}

		/************************** 经营期限到期提示 **************************/
		if (EsGsUtil.KIE(params, "opTip")) {
			if ("0".equals(EsGsUtil.MGV(params, "opTip"))) {
				condSql.append(" AND opTo<=" + EsGsUtil.FCD(DateUtil.getNmonthlater(new Date(), 1, "yyyy-MM-dd")));
			} else if ("2".equals(EsGsUtil.MGV(params, "opTip"))) {
				condSql.append(" AND opTo>=" + EsGsUtil.FCD(DateUtil.getNmonthlater(new Date(), 0, "yyyy-MM-dd")));
				condSql.append(" AND opTo<=" + EsGsUtil.FCD(DateUtil.getNmonthlater(new Date(), 1, "yyyy-MM-dd")));
			} else if ("1".equals(EsGsUtil.MGV(params, "opTip"))) {
				condSql.append(" AND opTo < " + EsGsUtil.FCD(DateUtil.dateToString(new Date(), "yyyy-MM-dd")));
			}
		}

		/************************** 经营期限 **************************/
		if (EsGsUtil.KIE(params, "opFrom"))// 经营期限开始
			condSql.append(" AND opFrom >= " + EsGsUtil.FCD(EsGsUtil.MGV(params, "opFrom")));
		if (EsGsUtil.KIE(params, "opTo"))// 经营期限结束
			condSql.append(" AND opTo <= " + EsGsUtil.FCD(EsGsUtil.MGV(params, "opTo")));
		joinYrStatus(params, condSql);
		appendDBAuthWhereSql(condSql, params);
		rstSql = condSql.toString();
		if (rstSql.equals("") || rstSql.length() < 5)
			return "";

		return " WHERE " + rstSql.substring(4, rstSql.length());
	}

	/**
	 * 不良信息拼接语句
	 * 
	 * @param params
	 * @param condSql
	 * @return
	 */
	private StringBuffer badInfo(Map<String, Object> params, StringBuffer condSql) {
		if (EsGsUtil.KIE(params, "badInfo")) {
			boolean isOpan = params.get("badInfo").toString().contains("1");// 列入经营异常
			boolean isSerVio = params.get("badInfo").toString().contains("2");// 列入严重违法
			boolean isCase = params.get("badInfo").toString().contains("3");// 行政处罚
			boolean isJudicial = params.get("badInfo").toString().contains("4");// 司法协助
			boolean leRepisLim = params.get("badInfo").toString().contains("5");// 法人受限

			condSql.append(" AND (");
			List<String> list = new ArrayList<String>();
			if (isOpan) {
				list.add("(isOpan='1') OR (isOpan='2') OR (isOpan='3') OR (isOpan='4')");
			}
			if (isSerVio) {
				list.add("isSerVio='Y'");
			}
			if (isCase) {
				list.add("isCase='Y'");
			}
			if (isJudicial) {
				list.add("isJudicial='Y'");
			}
			if (leRepisLim) {
				list.add("leRepisLim='Y'");
			}
			String temp = "";
			for (int i = 0; i < list.size(); i++) {
				if (i == list.size() - 1) {
					temp = temp + list.get(i);
				} else {
					temp = temp + list.get(i) + " OR ";
				}
			}
			condSql.append(temp + ")");
		}
		return condSql;
	}

	/**
	 * 拼接年度年报与状态方法
	 * 
	 * @author baifangfang
	 * @param params
	 * @param condSql
	 */
	private void joinYrStatus(Map<String, Object> params, StringBuffer condSql) {
		if (EsGsUtil.KIE(params, "yearMode")) {
			String yearModeValue = (String) params.get("yearMode");
			String[] yearModeValueArr = yearModeValue.split(",");
			List<String> yearModeValueList = Arrays.asList(yearModeValueArr);

			// 年度列表
			List<String> yearList = DateUtil.getYearToNow();
			yearList.remove(0);

			// // 获取查询的最大年度，用于判断成立日期
			// String maxYear = null;
			// for (int i = 0; i < yearList.size(); i++) {
			// String year = yearList.get(i);
			// if (yearModeValue.contains(year)) {
			// maxYear = year;
			// break;
			// }
			// }
			// condSql.append(" AND estDate <" +
			// EsGsUtil.FCD(EsGsUtil.GNY(maxYear)));

			condSql.append(" and (");

			// 组装年度年报条件
			List<String> yearInputList = new ArrayList<String>();
			for (int i = 0; i < yearList.size(); i++) {
				String year = yearList.get(i);
				if (yearModeValue.contains(year)) {
					yearInputList.add(year);
				}
			}
			logger.info("yearModeValueList {}", yearModeValueList);
			for (int i = 0; i < yearInputList.size(); i++) {
				String year = yearInputList.get(i);
				String yrstatus = "";
				for (int j = 0; j < yearModeValueList.size(); j++) {
					if (yearModeValueList.get(j).length() > 4 && yearModeValueList.get(j).contains(year)) {
						yrstatus = yrstatus + yearModeValueList.get(j).substring(5, yearModeValueList.get(j).length())
								+ ",";
					}
				}
				condSql.append("( yrIsRep" + year + " in (" + yrstatus.substring(0, yrstatus.length() - 1) + ")");
				condSql.append(" AND estDate <" + EsGsUtil.FCD(EsGsUtil.GNY(year)));
				condSql.append(")");
				if (i < yearInputList.size() - 1) {
					condSql.append(" and ");
				}
			}
			condSql.append(")");
		}
	}

	/**
	 * 组装工商云搜索引擎查询条件(企业综合查询)
	 * 
	 * @author zhuyong
	 * @param params
	 * @return
	 * @throws Exception
	 */
	private String queryPageCloudCondComYears(Map<String, Object> params) throws Exception {

		String rstSql = "";
		StringBuffer condSql = new StringBuffer("");

		/**************************** 统一信用代码/注册号 **************************/
		if (EsGsUtil.KIE(params, "cidRegNO"))
			condSql.append(" AND (uniscid like '*" + params.get("cidRegNO").toString() + "' OR regNO like '*"
					+ params.get("cidRegNO").toString() + "')");

		/**************************** 需要模糊搜索的列 ****************************/
		for (String naw : nameArrWild) {
			if (EsGsUtil.KIE(params, naw))
				condSql.append(" AND (" + naw + " like '*" + EsGsUtil.MGV(params, naw) + "*')");
		}

		/************************** 不需要模糊搜索的列 **************************/
		for (String nam : nameArrMatch) {
			if (EsGsUtil.KIE(params, nam)) {
				if ("tel".equals(nam)) {// 企业电话和联络员电话查询
					condSql.append(" AND (" + nam + "='" + EsGsUtil.MGV(params, nam) + "' or liaTel = '"
							+ EsGsUtil.MGV(params, nam) + "')");

				} else {
					condSql.append(" AND (" + nam + "='" + EsGsUtil.MGV(params, nam) + "')");
				}
			}
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
			if ("regState".equals(nas)) {
				String regStateValue = (String) params.get("regState");
				if (!StringUtils.isBlank(regStateValue)) {
					regStateValue = split(regStateValue);
					condSql.append(" AND " + nas + " IN (" + regStateValue + ")");
				}
				continue;
			}
			if (EsGsUtil.KIE(params, nas)) {
				if ("industryCo".equals(nas)) {
					String industryCoName = EsGsUtil.MGV(params, nas);
					industryCoName = StringUtil.doSplitStringToSqlFormat(industryCoName.toString(), ",");
					condSql.append(" AND " + nas + " IN (" + industryCoName + ")");
				} else {
					condSql.append(" AND " + nas + " IN (" + EsGsUtil.MGV(params, nas) + ")");
				}
			}
		}

		/************************** 注册资本 **************************/
		if (EsGsUtil.KIE(params, "regCapStart"))// 注册资本开始
			condSql.append(" AND regCap>=" + EsGsUtil.MGV(params, "regCapStart"));
		if (EsGsUtil.KIE(params, "regCapEnd"))// 注册资本结束
			condSql.append(" AND regCap<=" + EsGsUtil.MGV(params, "regCapEnd"));

		/************************** 个转企 **************************/
		if (EsGsUtil.KIE(params, "isIndivid")) {// 个转企
			if ("1".equals(EsGsUtil.MGV(params, "isIndivid"))) {
				condSql.append(" AND (isIndivid='1') ");
			} else {
				condSql.append(" AND (isIndivid<>'1') ");
			}
		}

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

		/************************** 年报相关搜索 **************************/

		// 2016,2016-0,2016-1,2016-2,2015,2015-0,2015-1,2015-2
		// 2016,2016-2,2015,2015-1,2014,2014-0,2013,2013-0,2013-1,2013-2
		joinYrStatus(params, condSql);

		appendDBAuthWhereSql(condSql, params);
		rstSql = condSql.toString();
		if (rstSql.equals("") || rstSql.length() < 5)
			return "";

		return " WHERE " + rstSql.substring(4, rstSql.length());
	}

	/**
	 * 组装工商云搜索引擎查询条件(企业综合查询)
	 * 
	 * @author zhuyong
	 * @param params
	 * @return
	 * @throws Exception
	 */
	private String queryPageCloudCondSms(Map<String, Object> params) throws Exception {

		String rstSql = "";
		StringBuffer condSql = new StringBuffer("");

		/**************************** 统一信用代码/注册号 **************************/
		if (EsGsUtil.KIE(params, "cidRegNO"))
			condSql.append(" AND (uniscid like '*" + params.get("cidRegNO").toString() + "' OR regNO like '*"
					+ params.get("cidRegNO").toString() + "')");

		/**************************** 需要模糊搜索的列 ****************************/
		for (String naw : nameArrWild) {
			if (EsGsUtil.KIE(params, naw))
				condSql.append(" AND (" + naw + " like '*" + EsGsUtil.MGV(params, naw) + "*')");
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
			if ("sliceNO".equals(nas)) {
				String nasValue = (String) params.get(nas);
				if (!StringUtils.isBlank(nasValue)) {
					nasValue = split(nasValue);
					condSql.append(" AND " + nas + " IN (" + nasValue + ")");
				}
				continue;
			}
			if (EsGsUtil.KIE(params, nas))
				condSql.append(" AND " + nas + " IN (" + EsGsUtil.MGV(params, nas) + ")");
		}

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

		/************************** 年报日期，多年度只选择上一年度的日期 **************************/
		String currentYear = DateUtil.getCurrentYear();
		String yrYear = Integer.parseInt(currentYear) - 2 + "";
		if (EsGsUtil.KIE(params, "yrFirRepTimeStart"))// 首次报送时间
			condSql.append(
					" AND yrFirRepTime" + yrYear + ">=" + EsGsUtil.FCD(EsGsUtil.MGV(params, "yrFirRepTimeStart")));
		if (EsGsUtil.KIE(params, "yrFirRepTimeEnd"))// 首次报送时间
			condSql.append(" AND yrFirRepTime" + yrYear + "<=" + EsGsUtil.FCD(EsGsUtil.MGV(params, "yrFirRepTimeEnd")));

		// 年报年度与状态
		joinYrStatus(params, condSql);

		appendDBAuthWhereSql(condSql, params);
		rstSql = condSql.toString();
		if (rstSql.equals("") || rstSql.length() < 5)
			return "";

		return " WHERE " + rstSql.substring(4, rstSql.length());
	}

	/**
	 * 组装工商云搜索引擎查询条件(企业综合查询)
	 * 
	 * @author zhuyong
	 * @param params
	 * @return
	 * @throws Exception
	 */
	private String queryPageCloudCondCom(Map<String, Object> params) throws Exception {

		String rstSql = "";
		StringBuffer condSql = new StringBuffer("");

		/**************************** 统一信用代码/注册号 **************************/
		if (EsGsUtil.KIE(params, "cidRegNO"))
			condSql.append(" AND (uniscid like '*" + params.get("cidRegNO").toString() + "' OR regNO like '*"
					+ params.get("cidRegNO").toString() + "')");

		/**************************** 即时信息相关搜索 **************************/
		StringBuffer imStr = new StringBuffer("");
		for (String nam : imCon) {
			if (!EsGsUtil.KIE(params, nam))
				continue;
			if ("Y".equals(EsGsUtil.MGV(params, nam)))
				imStr.append(" OR (" + nam + "='Y')");
		}
		String imRst = imStr.toString();
		if (!"".equals(imRst)) {
			imRst = imRst.substring(4, imRst.length());
			condSql.append("AND (" + imRst + ")");
		}

		// 即时信息选择 否
		if (EsGsUtil.KIE(params, "imConNo")) {
			if ("Y".equals(EsGsUtil.MGV(params, "imConNo")))
				condSql.append(" AND ( imCase<> 'Y')  AND ( imInvest<> 'Y') "
						+ "AND ( imPermit<> 'Y') AND ( imIppldg<> 'Y') AND ( imInvsra<> 'Y') ");
		}

		/**************************** 即时信息-年报记录 **************************/
		if (EsGsUtil.KIE(params, "imYear")) {
			if ("none".equals(EsGsUtil.MGV(params, "imYear"))) {
				condSql.append(" AND ( yrIsRep2013 not in(1,2)) AND ( yrIsRep2014 not in(1,2)) "
						+ "AND ( yrIsRep2015 not in(1,2)) AND ( yrIsRep2016 not in(1,2)) ");
			} else {
				condSql.append(" AND ( yrIsRep" + EsGsUtil.MGV(params, "imYear") + "  in(1,2)) ");
			}
		}

		/**************************** 需要模糊搜索的列 ****************************/
		for (String naw : nameArrWild) {
			if (EsGsUtil.KIE(params, naw))
				condSql.append(" AND (" + naw + " like '*" + EsGsUtil.MGV(params, naw) + "*')");
		}

		/************************** 不需要模糊搜索的列 **************************/
		for (String nam : nameArrMatch) {
			if (EsGsUtil.KIE(params, nam)) {
				if ("tel".equals(nam)) {// 企业电话和联络员电话查询
					condSql.append(" AND (" + nam + "='" + EsGsUtil.MGV(params, nam) + "' or liaTel = '"
							+ EsGsUtil.MGV(params, nam) + "')");

				} else {
					condSql.append(" AND (" + nam + "='" + EsGsUtil.MGV(params, nam) + "')");
				}
			}
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
			if ("regState".equals(nas) || "sliceNO".equals(nas)) {
				String nasValue = (String) params.get(nas);
				if (!StringUtils.isBlank(nasValue)) {
					nasValue = split(nasValue);
					condSql.append(" AND " + nas + " IN (" + nasValue + ")");
				}
				continue;
			}
			if (EsGsUtil.KIE(params, nas)) {
				if ("industryCo".equals(nas)) {
					String industryCoName = EsGsUtil.MGV(params, nas);
					industryCoName = StringUtil.doSplitStringToSqlFormat(industryCoName.toString(), ",");
					condSql.append(" AND " + nas + " IN (" + industryCoName + ")");
				} else {
					condSql.append(" AND " + nas + " IN (" + EsGsUtil.MGV(params, nas) + ")");
				}
			}
		}

		/************************** 注册资本 **************************/
		if (EsGsUtil.KIE(params, "regCapStart"))// 注册资本开始
			condSql.append(" AND regCap>=" + EsGsUtil.MGV(params, "regCapStart"));
		if (EsGsUtil.KIE(params, "regCapEnd"))// 注册资本结束
			condSql.append(" AND regCap<=" + EsGsUtil.MGV(params, "regCapEnd"));

		/************************** 个转企 **************************/
		if (EsGsUtil.KIE(params, "isIndivid")) {// 个转企
			if ("1".equals(EsGsUtil.MGV(params, "isIndivid"))) {
				condSql.append(" AND (isIndivid='1') ");
			} else {
				condSql.append(" AND (isIndivid<>'1') ");
			}
		}

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

		/************************** 不良信息 **************************/
		condSql = badInfo(params, condSql);

		/************************** 年报相关搜索 **************************/
		if (EsGsUtil.KIE(params, "yrYear")) {

			String yrYear = params.get("yrYear") + "";
			condSql.append(" AND estDate <" + EsGsUtil.FCD(EsGsUtil.GNY(yrYear)));

			/************************** 最近报送时间 **************************/
			if (EsGsUtil.KIE(params, "yrRecRepTimeStart"))// 最近报送时间
				condSql.append(
						" AND yrRecRepTime" + yrYear + ">=" + EsGsUtil.FCD(EsGsUtil.MGV(params, "yrRecRepTimeStart")));
			if (EsGsUtil.KIE(params, "yrRecRepTimeEnd")) {// 最近报送时间
				condSql.append(" AND yrRecRepTime" + yrYear + "<"
						+ EsGsUtil.FCD(EsGsUtil.AOD(EsGsUtil.MGV(params, "yrRecRepTimeEnd"))));
			}
			/************************** 首次报送时间 **************************/
			if (EsGsUtil.KIE(params, "yrFirRepTimeStart"))// 首次报送时间
				condSql.append(
						" AND yrFirRepTime" + yrYear + ">=" + EsGsUtil.FCD(EsGsUtil.MGV(params, "yrFirRepTimeStart")));
			if (EsGsUtil.KIE(params, "yrFirRepTimeEnd")) {// 首次报送时间
				condSql.append(" AND yrFirRepTime" + yrYear + "<"
						+ EsGsUtil.FCD(EsGsUtil.AOD(EsGsUtil.MGV(params, "yrFirRepTimeEnd"))));
			}
			/****************************************************
			 * yrRepMode 年报方式 yrIsRep 是否年报 yrSenCheck 是否涉及敏感词审核
			 ****************************************************/
			for (String nam : yrRepMatch) {
				if ("yrRepState".equals(nam)) {
					String yrRepStateValue = (String) params.get("yrRepState");
					if (!StringUtils.isBlank(yrRepStateValue)) {
						yrRepStateValue = split(yrRepStateValue);
						condSql.append(" AND (yrRepState" + yrYear + " in (" + yrRepStateValue + "))");
					}
					continue;
				}
				if (!EsGsUtil.KIE(params, nam)) {
					if ("yrIsRep".equals(nam)) {
						condSql.append(" and (" + nam + yrYear + " in ('0','1','2'))");
					} else {
						continue;
					}
				} else {
					condSql.append(" AND (" + nam + yrYear + " in (" + params.get(nam) + "))");
				}
			}

			for (String nam : yrRepMatchBool) {
				if (!EsGsUtil.KIE(params, nam))
					continue;
				if ("Y".equals(EsGsUtil.MGV(params, nam)))
					condSql.append(" AND (" + nam + yrYear + "='Y')");
				else
					condSql.append(" AND (" + nam + yrYear + "<>'Y')");
			}

		}
		appendDBAuthWhereSql(condSql, params);
		rstSql = condSql.toString();
		if (rstSql.equals("") || rstSql.length() < 5)
			return "";

		return " WHERE " + rstSql.substring(4, rstSql.length());
	}

	private String split(String str) {
		StringBuffer sb = new StringBuffer();
		String[] temp = str.split(",");
		for (int i = 0; i < temp.length; i++) {
			if (!"".equals(temp[i]) && temp[i] != null)
				sb.append("'" + temp[i] + "',");
		}
		String result = sb.toString();
		String tp = result.substring(result.length() - 1, result.length());
		if (",".equals(tp))
			return result.substring(0, result.length() - 1);
		else
			return result;
	}

	/**
	 * 添加默认的数据权限
	 * 
	 * @author ZhuDefeng
	 * @date 2016-12-06
	 * @param condSql
	 * @param params
	 */
	private void appendDBAuthWhereSql(StringBuffer condSql, Map<String, Object> params) {
		String s1 = (params.get(DBAuthorConstants.PARAM_LIKE_VAL_CHECK_DEP) + "").replace("%", "*");
		String s2 = (params.get(DBAuthorConstants.PARAM_EQ_VAL_NAME_CHECK_DEP) + "").replace("%", "*");
		String localAdmLikeVal = (params.get(DBAuthorConstants.PARAM_LIKE_VAL_LOCAL_ADM) + "").replace("%", "*");
		if (EsGsUtil.KIE(params, DBAuthorConstants.PARAM_NAME_CHECK_DEP)
				&& EsGsUtil.KIE(params, DBAuthorConstants.PARAM_LIKE_VAL_CHECK_DEP)) {
			condSql.append(" AND (" + params.get(DBAuthorConstants.PARAM_NAME_CHECK_DEP) + " like '" + s1 + "')");
		}

		if (EsGsUtil.KIE(params, DBAuthorConstants.PARAM_NAME_CHECK_DEP)
				&& EsGsUtil.KIE(params, DBAuthorConstants.PARAM_EQ_VAL_NAME_CHECK_DEP)) {
			condSql.append(" AND (" + params.get(DBAuthorConstants.PARAM_NAME_CHECK_DEP) + " = '" + s2 + "'");
			if (EsGsUtil.KIE(params, DBAuthorConstants.PARAM_NAME_LOCAL_ADM_ALIAS)
					&& EsGsUtil.KIE(params, DBAuthorConstants.PARAM_LIKE_VAL_LOCAL_ADM)) {
				// 登记机关为市局，checkDep为市局，但是管辖单位却为市局下的分局或者所，分局或所也想要看到checkDep为市局的企业
				condSql.append(" OR " + params.get(DBAuthorConstants.PARAM_NAME_LOCAL_ADM_ALIAS) + " LIKE '"
						+ localAdmLikeVal + "'");
			}
			condSql.append(")");
		}
		if (EsGsUtil.KIE(params, DBAuthorConstants.ES_PARAM_NAME_REG_STATE)) {
			condSql.append(" AND " + DBAuthorConstants.PARAM_NAME_REG_STATE + " in ("
					+ params.get(DBAuthorConstants.ES_PARAM_NAME_REG_STATE).toString() + ")");
		}
	}

	/**
	 * 描述：构建综合查询query 页面只有一个综合查询的搜索框
	 * 
	 * @author zhuyong
	 * @date 2016-10-21
	 * @return
	 */
	private BoolQueryBuilder buildCompQuery(String keyword) throws Exception {
		return QueryBuilders.boolQuery().should(QueryBuilders.matchQuery("entNamePPL", keyword))// 企业名称
				.should(QueryBuilders.matchQuery("regNO", keyword))// 注册号
				.should(QueryBuilders.matchQuery("uniscid", keyword));
	}

	/**
	 * 描述： 构建多条件查询query 组装全景查询对应的多条件查询页面
	 * 
	 * 注意事项： 如需要增加查询条件，无需修改controller层代码，只需修改buildManyQuery代码 注意命名
	 * 
	 * @author zhuyong
	 * @date 2016-10-21
	 * @return
	 */
	private BoolQueryBuilder buildManyQuery(Map<String, Object> params) throws Exception {
		BoolQueryBuilder qb = QueryBuilders.boolQuery();
		BoolQueryBuilder bqb = null;
		if (params == null)
			return qb;

		/**************************** 统一信用代码/注册号 **************************/
		if (EsGsUtil.KIE(params, "cidRegNO")) {
			bqb = QueryBuilders.boolQuery();
			bqb.should(QueryBuilders.wildcardQuery("uniscid", "*" + params.get("cidRegNO") + "*"));
			bqb.should(QueryBuilders.wildcardQuery("regNO", "*" + params.get("cidRegNO") + "*"));
			qb.must(bqb);
		}

		/**************************** 是否建档 **************************/
		if (EsGsUtil.KIE(params, "isClaimRegist")) {
			qb.mustNot(QueryBuilders.matchQuery("localAdm", ""));
			qb.must(QueryBuilders.matchQuery("isClaimRegist", "Y"));
		}

		/***************************** 是否联络员确认 *******************************/
		if (EsGsUtil.KIE(params, "yrLiaConfirm")) {
			if ("Y".equals(EsGsUtil.MGV(params, "yrLiaConfirm")))
				qb.mustNot(QueryBuilders.matchQuery("liaName", ""));
			else
				qb.must(QueryBuilders.matchQuery("liaName", ""));
		}

		/**************************** 最近一年是否抽检 ******************************/
		if (EsGsUtil.KIE(params, "spotDate")) {
			if ("Y".equals(EsGsUtil.MGV(params, "spotDate")))
				qb.must(QueryBuilders.rangeQuery("spotDate").gte(DateUtil.getNyearlaterDate(new Date(), -1)));
			else
				qb.mustNot(QueryBuilders.rangeQuery("spotDate").gte(DateUtil.getNyearlaterDate(new Date(), -1)));
		}

		/**************************** 需要模糊搜索的列 ****************************/
		for (String naw : nameArrWild) {
			if (EsGsUtil.KIE(params, naw))
				qb.must(QueryBuilders.wildcardQuery(naw, "*" + params.get(naw) + "*"));
		}

		/**************************** 不需要模糊搜索的列 ****************************/
		for (String nam : nameArrMatch) {
			if (EsGsUtil.KIE(params, nam))
				qb.must(QueryBuilders.matchQuery(nam, params.get(nam)));
		}
		for (String nam : nameArrMatchBool) {
			if (!EsGsUtil.KIE(params, nam))
				continue;
			if ("Y".equals(EsGsUtil.MGV(params, nam)))
				qb.must(QueryBuilders.matchQuery(nam, "Y"));
			else
				qb.mustNot(QueryBuilders.matchQuery(nam, "Y"));
		}

		/************************** 需要切分的列 **************************/
		for (String nas : nameArrSplit) {
			if (!EsGsUtil.KIE(params, nas))
				continue;
			String[] codeArr = params.get(nas).toString().split(",");
			bqb = QueryBuilders.boolQuery();
			for (String code : codeArr) {
				bqb.should(QueryBuilders.matchQuery(nas, code));
			}
			qb.must(bqb);
		}

		/************************** 注册资本 **************************/
		if (EsGsUtil.KIE(params, "regCapStart"))// 注册资本开始
			qb.must(QueryBuilders.rangeQuery("regCap").gte(params.get("regCapStart")));
		if (EsGsUtil.KIE(params, "regCapEnd"))// 注册资本结束
			qb.must(QueryBuilders.rangeQuery("regCap").lte(params.get("regCapEnd")));

		/************************ 日期区间相关搜索 ***********************/
		for (String dr : dateRange) {
			if (!EsGsUtil.KIE(params, dr))
				continue;
			if (dr.contains("Start"))
				qb.must(QueryBuilders.rangeQuery(dr.replace("Start", "")).gte(EsGsUtil.BOD(EsGsUtil.MGV(params, dr))));
			else
				qb.must(QueryBuilders.rangeQuery(dr.replace("End", "")).lte(params.get(dr)));
		}

		/************************** 年报相关搜索 **************************/
		if (EsGsUtil.KIE(params, "yrYear")) {
			String yrYear = params.get("yrYear") + "";

			qb.must(QueryBuilders.rangeQuery("estDate").lt(EsGsUtil.GNY(yrYear)));

			/************************** 最近报送时间 **************************/
			if (EsGsUtil.KIE(params, "yrRecRepTimeStart"))// 最近报送时间
				qb.must(QueryBuilders.rangeQuery("yrRecRepTime" + yrYear)
						.gte(EsGsUtil.BOD(EsGsUtil.MGV(params, "yrRecRepTimeStart"))));
			if (EsGsUtil.KIE(params, "yrRecRepTimeEnd"))// 最近报送时间
				qb.must(QueryBuilders.rangeQuery("yrRecRepTime" + yrYear).lte(params.get("yrRecRepTimeEnd")));

			/************************** 首次报送时间 **************************/
			if (EsGsUtil.KIE(params, "yrFirRepTimeStart"))// 首次报送时间
				qb.must(QueryBuilders.rangeQuery("yrFirRepTime" + yrYear)
						.gte(EsGsUtil.BOD(EsGsUtil.MGV(params, "yrFirRepTimeStart"))));
			if (EsGsUtil.KIE(params, "yrFirRepTimeEnd"))// 首次报送时间
				qb.must(QueryBuilders.rangeQuery("yrFirRepTime" + yrYear).lte(params.get("yrFirRepTimeEnd")));

			/****************************************************
			 * yrRepMode 年报方式 yrIsRep 是否年报 yrSenCheck 是否涉及敏感词审核
			 ****************************************************/
			for (String nam : yrRepMatch) {
				if (!EsGsUtil.KIE(params, nam))
					continue;
				qb.must(QueryBuilders.matchQuery(nam + yrYear, params.get(nam)));
			}

			for (String nam : yrRepMatchBool) {
				if (!EsGsUtil.KIE(params, nam))
					continue;
				if ("Y".equals(EsGsUtil.MGV(params, "yrIsRep")))
					qb.must(QueryBuilders.matchQuery(nam + yrYear, "Y"));
				else
					qb.mustNot(QueryBuilders.matchQuery(nam + yrYear, "Y"));
			}

		}

		/************************** 经营期限到期提示 **************************/
		if (EsGsUtil.KIE(params, "opTip")) {
			if ("0".equals(EsGsUtil.MGV(params, "opTip"))) {
				qb.must(QueryBuilders.rangeQuery("opTo").lte(DateUtil.getNmonthlater(new Date(), 1, "yyyy-MM-dd")));
			} else if ("2".equals(EsGsUtil.MGV(params, "opTip"))) {
				qb.must(QueryBuilders.rangeQuery("opTo").gte(DateUtil.getNmonthlater(new Date(), 0, "yyyy-MM-dd"))
						.lte(DateUtil.getNmonthlater(new Date(), 1, "yyyy-MM-dd")));
			} else if ("1".equals(EsGsUtil.MGV(params, "opTip"))) {
				qb.must(QueryBuilders.rangeQuery("opTo").lt(DateUtil.dateToString(new Date(), "yyyy-MM-dd")));
			}
		}

		/************************** 经营期限 **************************/
		if (EsGsUtil.KIE(params, "opFrom"))// 经营期限开始
			qb.must(QueryBuilders.rangeQuery("opFrom").gte(EsGsUtil.BOD(EsGsUtil.MGV(params, "opFrom"))));
		if (EsGsUtil.KIE(params, "opTo"))// 经营期限结束
			qb.must(QueryBuilders.rangeQuery("opTo").lte(params.get("opTo")));

		builderDBAuthQuery(qb, params);
		return qb;
	}

	/**
	 * 添加默认的数据权限
	 * 
	 * @author ZhuDefeng
	 * @date 2016-12-06
	 * @param qb
	 * @param params
	 */
	private void builderDBAuthQuery(BoolQueryBuilder qb, Map<String, Object> params) {
		if (EsGsUtil.KIE(params, DBAuthorConstants.PARAM_NAME_CHECK_DEP)
				&& EsGsUtil.KIE(params, DBAuthorConstants.PARAM_LIKE_VAL_CHECK_DEP)) {
			String likeValue = params.get(DBAuthorConstants.PARAM_LIKE_VAL_CHECK_DEP).toString();
			likeValue = StringUtil.substring(likeValue, 0, likeValue.length() - 1) + "*";
			qb.must(QueryBuilders.wildcardQuery("checkDep", likeValue));
		}
		if (EsGsUtil.KIE(params, DBAuthorConstants.PARAM_NAME_CHECK_DEP)
				&& EsGsUtil.KIE(params, DBAuthorConstants.PARAM_EQ_VAL_NAME_CHECK_DEP)) {
			qb.must(QueryBuilders.matchQuery("checkDep",
					params.get(DBAuthorConstants.PARAM_EQ_VAL_NAME_CHECK_DEP).toString()));
		}
		if (EsGsUtil.KIE(params, DBAuthorConstants.ES_PARAM_NAME_REG_STATE)) {
			String regStates = params.get(DBAuthorConstants.ES_PARAM_NAME_REG_STATE).toString();
			String[] regStateArr = StringUtil.isBlank(regStates) ? null : regStates.split(",");
			if (regStateArr == null)
				return;
			for (String regState : regStateArr) {
				qb.should(QueryBuilders.matchQuery(DBAuthorConstants.PARAM_NAME_REG_STATE, regState));
			}
		}
	}

	/**
	 * 从数据获取查询结果集 为索引提供基础数据
	 * 
	 * @author zhuyong
	 * @param map
	 * @return
	 * @throws Exception
	 */
	private List<PanoramaSearch> doGetList(Map<String, Object> map) throws Exception {
		return panoramaSearchMapper.selectDataListByIdRange(map);
	}

	/**
	 * 取出最大id 为索引提供基础数据
	 * 
	 * @author zhuyong
	 * @return
	 * @throws Exception
	 */
	private Integer doGetMaxId() throws Exception {
		return panoramaSearchMapper.selectMaxId();
	}

	/**
	 * 组装查询url
	 * 
	 * @author zhuyong
	 * @return
	 */
	private String doBuildQueryURL() {
		return "http://" + esHost + ":" + esHttpPort + "/" + panoramaSearchIndex + "/" + panoramaSearchType
				+ "/_search";
	}

	/**
	 * 组装更新url
	 * 
	 * @author zhuyong
	 * @return
	 */
	private String doBuildUpdateURL(String docID) {
		return "http://" + esHost + ":" + esHttpPort + "/" + panoramaSearchIndex + "/" + panoramaSearchType + "/"
				+ docID;
	}

	/**
	 * 更新全景查询索引 非云平台
	 * 
	 * @author zhuyong
	 * @param jsonMap
	 */
	public String updatePanoramaIdxNormal(Map<String, Object> jsonMap) {
		if (EsGsUtil.checkPriPIDIsBlank(jsonMap))
			return "1";
		try {
			String priPID = jsonMap.get("priPID") + "";
			String reqValue = HttpFluent.getData(doBuildUpdateURL(priPID)); // 请求返回值
			net.sf.json.JSONObject jsonObj = null;
			if ("".equals(reqValue)) {// 新增
				jsonObj = net.sf.json.JSONObject.fromObject(jsonMap);
			} else {// 更新
				jsonObj = net.sf.json.JSONObject.fromObject(reqValue).getJSONObject("_source");
			}
			jsonObj = EsGsUtil.updateJsonObj(jsonObj, jsonMap, cloudOpen, cloudModel);// 更新元数据
			HttpFluent.putData(doBuildUpdateURL(priPID), jsonObj.toString());// 更新索引文档
		} catch (Exception e) {
			logger.info("索引更新发生错误[原生]：{}", e);
			return "0";
		}
		return "1";
	}

	/**
	 * 更新全景查询索引 云平台 如果存在就更新，不存在就插入
	 * 
	 * @author zhuyong
	 * @param jsonMap
	 *            需要更新的内容
	 */
	public String updatePanoramaIdxCloud(Map<String, Object> jsonMap) {
		if (EsGsUtil.checkPriPIDIsBlank(jsonMap))
			return "1";
		try {
			String priPID = jsonMap.get("priPID") + "";

			String baseSql = "select * from " + panoramaSearchIndex + " where priPID = '" + priPID + "' limit 0,1";

			IndexQueryResponse response = EsGsUtil.getQueryRep(baseSql, client);
			net.sf.json.JSONObject strJson = net.sf.json.JSONObject.fromObject(response.getResult())
					.getJSONObject("hits");
			Object obj = strJson.get("hits");
			net.sf.json.JSONArray jsonArr = net.sf.json.JSONArray.fromObject(obj);
			net.sf.json.JSONObject appObj = null;
			if (jsonArr == null || jsonArr.size() == 0) {// 新增
				appObj = net.sf.json.JSONObject.fromObject(jsonMap);
			} else {
				net.sf.json.JSONObject jsonObj = (net.sf.json.JSONObject) jsonArr.get(0);
				appObj = jsonObj.getJSONObject("_source");
			}
			appObj = EsGsUtil.updateJsonObj(appObj, jsonMap, cloudOpen, cloudModel);// 更新元数据
			String appObjStr = appObj.toString();
			EsGsUtil.updateIndexBySingle(client, panoramaSearchIndex, priPID, appObjStr);// 更新索引文档
			return "1";
		} catch (Exception e) {
			logger.info("索引更新发生错误[工商云]：{}", e);
			return "0";
		}

	}

	/**
	 * 获取创建索引的增量数据
	 * 
	 * @author zhuyong
	 * @return
	 */
	public List<PanoramaSearch> queryIncDataForIdx(Map<String, Object> map) throws Exception {
		return panoramaSearchMapper.selectIncDataForIdx(map);
	}

	/**
	 * 获取创建索引的增量数据
	 * 
	 * @author zhuyong
	 * @return
	 */
	public Integer queryIncDataTotalForIdx(Map<String, Object> map) throws Exception {
		return panoramaSearchMapper.selectIncDataTotalForIdx(map);
	}

	/**
	 * 获取全景查询返回结果 供分页框架使用 非云平台使用
	 * 
	 * @author zhuyong
	 * @param taskNO
	 * @param params
	 * @return
	 * @throws Exception
	 */
	private String queryForPubScinfoListNormal(String taskNO, Map<String, Object> params) throws Exception {
		BoolQueryBuilder bqb = buildManyQuery(params);
		String param = ESUtil.toBoolQueryStr(bqb, 0, 1);
		String reqStr = HttpFluent.postData(doBuildQueryURL(), param); // 请求返回值
		JSONObject json = EsGsUtil.getJsonObj(reqStr);
		List<String> list = pubScinfoBackService.selectPriPIDListByTaskNO(taskNO);
		int total = EsGsUtil.getRstTotal(json);
		boolean flag = true;
		int count = 0;
		JSONObject sourceObj = null;
		String priPID = "";
		JSONObject source = null;
		JSONArray arr = null;
		while (flag) {
			if (count >= total) {
				flag = false;
				param = ESUtil.toBoolQueryStr(bqb, count, total);
			} else {
				param = ESUtil.toBoolQueryStr(bqb, count, count + 200);
			}
			reqStr = HttpFluent.postData(doBuildQueryURL(), param); // 请求返回值
			json = EsGsUtil.getJsonObj(reqStr);
			arr = EsGsUtil.parseEsReqResult(json);
			for (int i = 0; i < arr.size(); i++) {
				PubScinfoBack pubScinfoBack = new PubScinfoBack();
				sourceObj = (JSONObject) arr.get(i);
				source = sourceObj.getJSONObject("_source");
				priPID = source.get("priPID") + "";
				if (list.contains(priPID)) {
					continue;
				}
				pubScinfoBack = new PubScinfoBack();
				pubScinfoBack.setPriPID(priPID);
				pubScinfoBack.setTaskNO(taskNO);
				pubScinfoBack.setCreateTime(new Date());
				pubScinfoBackService.savePubScinfoBack(pubScinfoBack);
				list.add(priPID);
			}
			count += 200;
		}
		return "";
	}

	/**
	 * 获取全景查询返回结果 供分页框架使用 云平台使用
	 * 
	 * @author zhuyong
	 * @param taskNO
	 * @param params
	 * @return
	 * @throws Exception
	 */
	private String queryForPubScinfoListCloud(String taskNO, Map<String, Object> params) throws Exception {
		String baseSql = "select * from " + panoramaSearchIndex;
		String sql = baseSql + queryPageCloudCond(params) + " limit 0,1";
		IndexQueryResponse response = EsGsUtil.getQueryRep(sql, client);
		if (response.getErrorCode().isEmpty()) {
			List<String> list = pubScinfoBackService.selectPriPIDListByTaskNO(taskNO);
			int total = EsGsUtil.getRstTotal(EsGsUtil.getJsonObj(response.getResult()));
			boolean flag = true;
			int count = 0;
			while (flag) {
				if (count >= total) {
					flag = false;
					int leftNum = total - (count - 200);
					sql = baseSql + queryPageCloudCond(params) + " limit " + count + "," + leftNum;
				} else {
					sql = baseSql + queryPageCloudCond(params) + " limit " + count + ",200";
				}
				IndexQueryResponse responsePage = EsGsUtil.getQueryRep(sql, client);
				JSONArray arr = EsGsUtil.parseEsReqResult(EsGsUtil.getJsonObj(responsePage.getResult()));// 请求返回值
				JSONObject sourceObj = null;
				String priPID = "";
				JSONObject source = null;
				PubScinfoBack pubScinfoBack = null;
				for (int i = 0; i < arr.size(); i++) {
					sourceObj = (JSONObject) arr.get(i);
					source = sourceObj.getJSONObject("_source");
					priPID = source.get("priPID") + "";
					if (list.contains(priPID)) {
						continue;
					}
					pubScinfoBack = new PubScinfoBack();
					pubScinfoBack.setPriPID(priPID);
					pubScinfoBack.setTaskNO(taskNO);
					pubScinfoBack.setCreateTime(new Date());
					pubScinfoBackService.savePubScinfoBack(pubScinfoBack);
					list.add(priPID);
				}
				count += 200;
			}
		}
		return "";
	}

	/**
	 * 获取单条全景实体
	 * 
	 * @author zhuyong
	 * @return
	 */
	public PanoramaSearch selectOnePanorama(String priPID) throws Exception {
		return panoramaSearchMapper.selectOnePanorama(priPID, RegStateEnum.ZHUXIAO.getParam());

	}

}
