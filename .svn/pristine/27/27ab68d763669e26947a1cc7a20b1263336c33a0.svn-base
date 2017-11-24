/**
 * Copyright© 2003-2014 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 企业查询<br/>
 *
 * @author baifangfang
 * @date 2016-7-20
 * @version 1.0
 */
package com.icinfo.cs.es.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.MatchAllQueryBuilder;
import org.elasticsearch.index.query.MultiMatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.icinfo.cs.base.constant.QuartzJobName;
import com.icinfo.cs.base.service.ICsQuartzJobService;
import com.icinfo.cs.common.utils.AESEUtil;
import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.common.utils.HttpFluent;
import com.icinfo.cs.common.utils.SleepUtil;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.es.dto.LimitwordDto;
import com.icinfo.cs.es.dto.PubEntSearchDto;
import com.icinfo.cs.es.dto.PubEntSearchGSDto;
import com.icinfo.cs.es.service.IEntSearchService;
import com.icinfo.cs.es.service.ILimitwordService;
import com.icinfo.cs.es.util.ESUtil;
import com.icinfo.cs.es.util.EsGsUtil;
import com.icinfo.cs.es.util.JsonDateValueProcessor;
import com.icinfo.cs.es.util.SortUtil;
import com.icinfo.cs.ext.dto.MidBaseInfoDto;
import com.icinfo.cs.ext.mapper.MidBaseInfoMapper;
import com.icinfo.cs.ext.model.MidBaseinfoDel;
import com.icinfo.cs.ext.service.IMidBaseInfoService;
import com.icinfo.cs.ext.service.IMidBaseinfoDelService;
import com.icinfo.cs.simpleesc.model.ErEscAppinfo;
import com.icinfo.cs.simpleesc.service.IErEscAppinfoService;

import cn.gov.zj.gsj.v2.api.GsjClient;
import cn.gov.zj.gsj.v2.obj.entity.IndexDeleteRequest;
import cn.gov.zj.gsj.v2.obj.entity.IndexDeleteResponse;
import cn.gov.zj.gsj.v2.obj.entity.IndexInsertRequest;
import cn.gov.zj.gsj.v2.obj.entity.IndexInsertResponse;
import cn.gov.zj.gsj.v2.obj.entity.IndexQueryRequest;
import cn.gov.zj.gsj.v2.obj.entity.IndexQueryResponse;
import cn.gov.zj.gsj.v2.sys.ApiException;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

/**
 * @author baifangfang
 * @date 2016-7-21
 */
@Service
public class EntSearchHttpServiceImpl implements IEntSearchService {
	private static final Logger logger = LoggerFactory.getLogger(EntSearchHttpServiceImpl.class);

	// 云平台开启标志
	private static final String cloudOpen = "Y";

	@Value("${cloudModel}")
	private String cloudModel;// 云平台模式 Y：开启 N：不开启

	@Autowired
	SortUtil sortUtil;

	@Autowired
	ILimitwordService limitwordService;

	@Autowired
	IMidBaseInfoService midBaseInfoService;

	@Value("${es.ip}")
	private String esHost;// es服务器的ip

	@Value("${es.http.port}")
	private String esHttpPort;// es服务器的端口

	@Value("${es.pubentsearchindex}")
	private String pubEntSearchIndex;// 公示企业综合查询索引名称

	@Value("${es.gsentsearchindex}")
	private String gsEntSearchIndex;// 云平台上公示企业综合查询索引名称

	@Value("${es.pubentsearchtype}")
	private String pubEntSearchType;// 公示企业综合查询type

	@Value("${appsearch.pagesize}")
	private String appSearchPagesize;// 企业查询分页页面大小

	@Autowired
	private MidBaseInfoMapper midBaseInfoMapper;

	@Autowired
	private ICsQuartzJobService csQuartzJobService;

	@Autowired
	GsjClient client;

	@Autowired
	IErEscAppinfoService erEscAppinfoService;

	@Autowired
	IMidBaseinfoDelService midBaseinfoDelService;

	@Override
	public Map<String, Object> doGetAppSearchResult(String searchKeyWord, int currentPage, String isOpanomaly) {
		if (StringUtils.isEmpty(isOpanomaly)) {
			isOpanomaly = "0";
		}
		// 查询行政区划列表
		Map<String, Object> queryMap = new HashMap<String, Object>();
		queryMap.put("limitFlag", 1);// 1.行政区划2.公司性质
		List<LimitwordDto> limitwordList = limitwordService.queryListResult(queryMap);

		String entarea = "";// 行政区划
		for (int i = 0; i < limitwordList.size(); i++) {
			String limitword = limitwordList.get(i).getLimitword();
			entarea = entarea + limitword + ",";
		}

		int appSearchPagesizeInt = Integer.parseInt(appSearchPagesize);

		if (cloudOpen.equalsIgnoreCase(cloudModel)) {// 云平台开启
			return queryPageCloud(searchKeyWord, currentPage, isOpanomaly, entarea, appSearchPagesizeInt);
		} else {
			return queryPageNormal(searchKeyWord, currentPage, isOpanomaly, entarea, appSearchPagesizeInt);
		}

	}

	/**
	 * 云平台查询
	 *
	 * @author baifangfang
	 * @date 2016年11月8日
	 * @param searchKeyWord
	 * @param currentPage
	 * @param isOpanomaly
	 * @param entarea
	 * @param appSearchPagesizeInt
	 * @return
	 */
	private Map<String, Object> queryPageCloud(String searchKeyWord, int currentPage, String isOpanomaly,
			String entarea, int appSearchPagesizeInt) {
		try {
			String sql = null;

			if (searchKeyWord.length() < 7) {// 如果输入的关键字个数<7，按照现有名称分词历史名称不分词模糊来查询
				if (!"0".equals(isOpanomaly)) {
					sql = "select * from " + gsEntSearchIndex + " where (entName= matchQuery('" + searchKeyWord
							+ "') or hisEntName like '*" + searchKeyWord + "*' or regNO='" + searchKeyWord
							+ "' or UNICODE='" + searchKeyWord + "') and isOpanomaly='" + isOpanomaly
							+ "' order by _score desc limit " + currentPage * appSearchPagesizeInt + ","
							+ appSearchPagesizeInt;
				} else {
					sql = "select * from " + gsEntSearchIndex + " where entName= matchQuery('" + searchKeyWord
							+ "') or hisEntName like '*" + searchKeyWord + "*' or regNO='" + searchKeyWord
							+ "' or UNICODE='" + searchKeyWord + "' order by _score desc limit "
							+ currentPage * appSearchPagesizeInt + "," + appSearchPagesizeInt;
				}
			} else {// 如果输入关键字个数>=7,按照现有名称历史名称不分词后模糊查询匹配
				// 先精确查询
				if (!"0".equals(isOpanomaly)) {
					sql = "select * from " + gsEntSearchIndex + " where (entNameNo = '" + searchKeyWord
							+ "' or hisEntName = '" + searchKeyWord + "' or regNO='" + searchKeyWord + "' or UNICODE='"
							+ searchKeyWord + "') and isOpanomaly='" + isOpanomaly + "' order by _score desc limit "
							+ currentPage * appSearchPagesizeInt + "," + appSearchPagesizeInt;
				} else {
					sql = "select * from " + gsEntSearchIndex + " where entNameNo = '" + searchKeyWord
							+ "' or hisEntName = '" + searchKeyWord + "' or regNO='" + searchKeyWord + "' or UNICODE='"
							+ searchKeyWord + "' order by _score desc limit " + currentPage * appSearchPagesizeInt + ","
							+ appSearchPagesizeInt;
				}

			}

			logger.info("sql {}", sql);

			IndexQueryRequest query = new IndexQueryRequest();
			query.setSql(sql);
			IndexQueryResponse response = client.excute(query);

			List<PubEntSearchDto> pubEntSearchDtos = new ArrayList<PubEntSearchDto>();
			Map<String, Object> entBaseInfoMap = new HashMap<String, Object>();
			if (response.getErrorCode().isEmpty()) {
				String reqValue = response.getResult(); // 请求返回值

				long start = System.currentTimeMillis();

				com.alibaba.fastjson.JSONObject resultObject = com.alibaba.fastjson.JSONObject.parseObject(reqValue);
				com.alibaba.fastjson.JSONObject jsonObj = resultObject.getJSONObject("hits");

				Object took = resultObject.get("took");
				entBaseInfoMap.put("took", took);

				com.alibaba.fastjson.JSONArray jsonArr = jsonObj.getJSONArray("hits");
				if (jsonArr.size() == 0) {
					if (!"0".equals(isOpanomaly)) {
						sql = "select * from " + gsEntSearchIndex + " where (entNameNo like '" + searchKeyWord
								+ "*' or hisEntName like '" + searchKeyWord + "*' or regNO='" + searchKeyWord
								+ "' or UNICODE='" + searchKeyWord + "') and isOpanomaly='" + isOpanomaly
								+ "' order by _score desc limit " + currentPage * appSearchPagesizeInt + ","
								+ appSearchPagesizeInt;
					} else {
						sql = "select * from " + gsEntSearchIndex + " where entNameNo like '" + searchKeyWord
								+ "*' or hisEntName like '" + searchKeyWord + "*' or regNO='" + searchKeyWord
								+ "' or UNICODE='" + searchKeyWord + "' order by _score desc limit "
								+ currentPage * appSearchPagesizeInt + "," + appSearchPagesizeInt;
					}
					query.setSql(sql);
					response = client.excute(query);
					if (response.getErrorCode().isEmpty()) {
						reqValue = response.getResult(); // 请求返回值

						start = System.currentTimeMillis();

						resultObject = com.alibaba.fastjson.JSONObject.parseObject(reqValue);
						jsonObj = resultObject.getJSONObject("hits");

						took = resultObject.get("took");
						entBaseInfoMap.put("took", took);
						jsonArr = jsonObj.getJSONArray("hits");
					}
				}

				for (int i = 0; i < jsonArr.size(); i++) {
					com.alibaba.fastjson.JSONObject jobj = (com.alibaba.fastjson.JSONObject) jsonArr.get(i);
					com.alibaba.fastjson.JSONObject source = jobj.getJSONObject("_source");

					PubEntSearchDto pubEntSearchDto = (PubEntSearchDto) com.alibaba.fastjson.JSONObject
							.toJavaObject(source, PubEntSearchDto.class);
					String encryPriPID = AESEUtil.encodeCorpid(pubEntSearchDto.getPriPID());
					pubEntSearchDto.setEncryPriPID(encryPriPID);

					// 查询简易注销情况
					ErEscAppinfo erEscAppinfo = erEscAppinfoService
							.getErEscAppinfoByPriPID(pubEntSearchDto.getPriPID());
					if (erEscAppinfo != null) {
						if (erEscAppinfo.getNoticeTo() != null
								&& erEscAppinfo.getNoticeTo().getTime() > new Date().getTime()
								&& !"5".equals(erEscAppinfo.getSimplecanRea())) {
							pubEntSearchDto.setIsSimpleCancle("1");
						} else {
							pubEntSearchDto.setIsSimpleCancle("0");
						}
					} else {
						pubEntSearchDto.setIsSimpleCancle("0");
					}

					String estDate = pubEntSearchDto.getEstDate();
					String opFrom = pubEntSearchDto.getOpFrom();
					String opTo = pubEntSearchDto.getOpTo();
					String apprDate = pubEntSearchDto.getApprDate();

					if (!StringUtils.isEmpty(estDate) && !"null".equals(estDate)) {
						String estDateStr = DateUtil.dateToString(DateUtil.stringToDate(estDate, "yyyyMMddhhmmss"),
								"yyyy年MM月dd日");
						pubEntSearchDto.setEstDateStr(estDateStr);
					}
					if (!StringUtils.isEmpty(opFrom) && !"null".equals(opFrom)) {
						String opFromStr = DateUtil.dateToString(DateUtil.stringToDate(opFrom, "yyyyMMddhhmmss"),
								"yyyy年MM月dd日");
						pubEntSearchDto.setOpFromStr(opFromStr);
					}
					if (!StringUtils.isEmpty(opTo) && !"null".equals(opTo)) {
						String opToStr = DateUtil.dateToString(DateUtil.stringToDate(opTo, "yyyyMMddhhmmss"),
								"yyyy年MM月dd日");
						pubEntSearchDto.setOpToStr(opToStr);
					}
					if (!StringUtils.isEmpty(apprDate) && !"null".equals(apprDate)) {
						String apprDateStr = DateUtil.dateToString(DateUtil.stringToDate(apprDate, "yyyyMMddhhmmss"),
								"yyyy年MM月dd日");
						pubEntSearchDto.setApprDateStr(apprDateStr);
					}

					pubEntSearchDtos.add(pubEntSearchDto);
				}
				long end = System.currentTimeMillis();
				logger.debug("JSON to JAVA转换耗时：" + (end - start) + "毫秒");
				// 排序
				sortUtil.doEntListSort(pubEntSearchDtos, searchKeyWord, entarea);

				// 高亮显示
				lightShow(searchKeyWord, pubEntSearchDtos);

				int totalCount = (Integer) jsonObj.get("total");
				Page<PubEntSearchDto> resultPage = new PageImpl<PubEntSearchDto>(pubEntSearchDtos,
						new PageRequest(currentPage, appSearchPagesizeInt), totalCount);

				entBaseInfoMap.put("resultPage", resultPage);
				entBaseInfoMap.put("size", totalCount);
				return entBaseInfoMap;
			}
		} catch (Exception e) {
			logger.info("exception {}", e, e.getMessage());
			return null;
		}
		return null;
	}

	@Override
	public List<PubEntSearchDto> queryEntList(String searchKeyWord) {
		try {
			String sql = null;
			if (searchKeyWord.length() < 7) {// 如果输入的关键字个数<7，按照现有名称分词历史名称不分词模糊来查询
				sql = "select * from " + gsEntSearchIndex + " where entName= matchQuery('" + searchKeyWord
						+ "') or regNO='" + searchKeyWord + "' or UNICODE='" + searchKeyWord
						+ "' order by _score desc limit " + 0 + "," + 10;
			} else {// 如果输入关键字个数>=7,按照现有名称历史名称不分词后模糊查询匹配
				sql = "select * from " + gsEntSearchIndex + " where entNameNo like '" + searchKeyWord + "*' or regNO='"
						+ searchKeyWord + "' or UNICODE='" + searchKeyWord + "' order by _score desc limit " + 0 + ","
						+ 10;
			}
			logger.info("sql {}", sql);

			IndexQueryRequest query = new IndexQueryRequest();
			query.setSql(sql);
			IndexQueryResponse response = client.excute(query);

			List<PubEntSearchDto> pubEntSearchDtos = new ArrayList<PubEntSearchDto>();
			if (response.getErrorCode().isEmpty()) {
				String reqValue = response.getResult(); // 请求返回值

				com.alibaba.fastjson.JSONObject resultObject = com.alibaba.fastjson.JSONObject.parseObject(reqValue);
				com.alibaba.fastjson.JSONObject jsonObj = resultObject.getJSONObject("hits");
				com.alibaba.fastjson.JSONArray jsonArr = jsonObj.getJSONArray("hits");

				for (int i = 0; i < jsonArr.size(); i++) {
					com.alibaba.fastjson.JSONObject jobj = (com.alibaba.fastjson.JSONObject) jsonArr.get(i);
					com.alibaba.fastjson.JSONObject source = jobj.getJSONObject("_source");

					PubEntSearchDto pubEntSearchDto = (PubEntSearchDto) com.alibaba.fastjson.JSONObject
							.toJavaObject(source, PubEntSearchDto.class);
					String encryPriPID = AESEUtil.encodeCorpid(pubEntSearchDto.getPriPID());
					pubEntSearchDto.setEncryPriPID(encryPriPID);

					String estDate = pubEntSearchDto.getEstDate();
					String opFrom = pubEntSearchDto.getOpFrom();
					String opTo = pubEntSearchDto.getOpTo();
					String apprDate = pubEntSearchDto.getApprDate();

					if (!StringUtils.isEmpty(estDate) && !"null".equals(estDate)) {
						String estDateStr = DateUtil.dateToString(DateUtil.stringToDate(estDate, "yyyyMMddhhmmss"),
								"yyyy年MM月dd日");
						pubEntSearchDto.setEstDateStr(estDateStr);
					}
					if (!StringUtils.isEmpty(opFrom) && !"null".equals(opFrom)) {
						String opFromStr = DateUtil.dateToString(DateUtil.stringToDate(opFrom, "yyyyMMddhhmmss"),
								"yyyy年MM月dd日");
						pubEntSearchDto.setOpFromStr(opFromStr);
					}
					if (!StringUtils.isEmpty(opTo) && !"null".equals(opTo)) {
						String opToStr = DateUtil.dateToString(DateUtil.stringToDate(opTo, "yyyyMMddhhmmss"),
								"yyyy年MM月dd日");
						pubEntSearchDto.setOpToStr(opToStr);
					}
					if (!StringUtils.isEmpty(apprDate) && !"null".equals(apprDate)) {
						String apprDateStr = DateUtil.dateToString(DateUtil.stringToDate(apprDate, "yyyyMMddhhmmss"),
								"yyyy年MM月dd日");
						pubEntSearchDto.setApprDateStr(apprDateStr);
					}
					pubEntSearchDtos.add(pubEntSearchDto);
				}

				// 高亮显示
				lightShow(searchKeyWord, pubEntSearchDtos);
				return pubEntSearchDtos;
			}
		} catch (Exception e) {
			logger.info("exception {}", e, e.getMessage());
			return null;
		}
		return null;
	}

	private void lightShow(String searchKeyWord, List<PubEntSearchDto> pubEntSearchDtos) {
		for (int j = 0; j < pubEntSearchDtos.size(); j++) {
			PubEntSearchDto pubEntSearchDto = pubEntSearchDtos.get(j);
			String entName = pubEntSearchDto.getEntName();
			String hisEntName = pubEntSearchDto.getHisEntName();
			for (int m = 0; m < searchKeyWord.length(); m++) {
				for (int n = m + 1; n < searchKeyWord.length() + 1; n++) {
					String key = searchKeyWord.substring(m, n);
					if (entName.contains(key)) {
						entName = entName.replace(key, "[" + key + "]");
					}
					if (!StringUtil.isEmpty(hisEntName)) {
						if (hisEntName.contains(key)) {
							hisEntName = hisEntName.replace(key, "[" + key + "]");
						}
					}
				}
			}
			entName = entName.replace("[", "<span class='light'>");
			entName = entName.replace("]", "</span>");

			if (!StringUtil.isEmpty(hisEntName)) {
				hisEntName = hisEntName.replace("[", "<span class='light'>");
				hisEntName = hisEntName.replace("]", "</span>");
			}

			pubEntSearchDto.setEntName(entName);
			pubEntSearchDto.setHisEntName(hisEntName);
		}
	}

	/**
	 * 非云平台的查询
	 *
	 * @author baifangfang
	 * @date 2016年11月8日
	 * @param searchKeyWord
	 * @param currentPage
	 * @param isOpanomaly
	 * @param entarea
	 * @param appSearchPagesizeInt
	 * @return
	 */
	private Map<String, Object> queryPageNormal(String searchKeyWord, int currentPage, String isOpanomaly,
			String entarea, int appSearchPagesizeInt) {
		String param;
		if (!StringUtils.isEmpty(searchKeyWord) && !"null".equals(searchKeyWord)) {
			MultiMatchQueryBuilder mmq = new MultiMatchQueryBuilder(searchKeyWord, "entName", "regNO", "UNICODE");
			BoolQueryBuilder qb = QueryBuilders.boolQuery();
			qb.must(mmq);
			if (!"0".equals(isOpanomaly)) {
				qb.must(QueryBuilders.termQuery("isOpanomaly", isOpanomaly));
			}
			param = ESUtil.toBoolQueryStr(qb, currentPage * appSearchPagesizeInt, appSearchPagesizeInt);
		} else {
			MatchAllQueryBuilder maqb = new MatchAllQueryBuilder();
			BoolQueryBuilder qb = QueryBuilders.boolQuery();
			qb.must(maqb);
			if ("1".equals(isOpanomaly)) {
				qb.must(QueryBuilders.termQuery("isOpanomaly", isOpanomaly));
			}
			param = ESUtil.toBoolQueryStr(qb, currentPage * appSearchPagesizeInt, appSearchPagesizeInt);
		}
		logger.info("param {}", param);

		try {
			String result = HttpFluent.postData("http://" + esHost + ":" + esHttpPort + "/" + pubEntSearchIndex + "/"
					+ pubEntSearchType + "/_search", param);

			long start = System.currentTimeMillis();

			com.alibaba.fastjson.JSONObject resultObject = com.alibaba.fastjson.JSONObject.parseObject(result);
			com.alibaba.fastjson.JSONObject jsObject = resultObject.getJSONObject("hits");
			com.alibaba.fastjson.JSONArray obj = jsObject.getJSONArray("hits");

			Object took = resultObject.get("took");
			logger.info("obj {},took {}", obj, took);

			Map<String, Object> entBaseInfoMap = new HashMap<String, Object>();
			entBaseInfoMap.put("took", took);

			List<PubEntSearchDto> pubEntSearchDtos = new ArrayList<PubEntSearchDto>();

			for (int i = 0; i < obj.size(); i++) {
				com.alibaba.fastjson.JSONObject jobj = (com.alibaba.fastjson.JSONObject) obj.get(i);
				com.alibaba.fastjson.JSONObject source = jobj.getJSONObject("_source");
				PubEntSearchDto pubEntSearchDto = (PubEntSearchDto) com.alibaba.fastjson.JSONObject.toJavaObject(source,
						PubEntSearchDto.class);
				String encryPriPID = AESEUtil.encodeCorpid(pubEntSearchDto.getPriPID());
				pubEntSearchDto.setEncryPriPID(encryPriPID);

				String estDate = pubEntSearchDto.getEstDate();
				String opFrom = pubEntSearchDto.getOpFrom();
				String opTo = pubEntSearchDto.getOpTo();
				String apprDate = pubEntSearchDto.getApprDate();

				if (!StringUtils.isEmpty(estDate) && !"null".equals(estDate)) {
					String estDateStr = DateUtil.dateToString(DateUtil.stringToDate(estDate, "yyyy-MM-dd"),
							"yyyy年MM月dd日");
					pubEntSearchDto.setEstDateStr(estDateStr);
				}
				if (!StringUtils.isEmpty(opFrom) && !"null".equals(opFrom)) {
					String opFromStr = DateUtil.dateToString(DateUtil.stringToDate(opFrom, "yyyy-MM-dd"),
							"yyyy年MM月dd日");
					pubEntSearchDto.setOpFromStr(opFromStr);
				}
				if (!StringUtils.isEmpty(opTo) && !"null".equals(opTo)) {
					String opToStr = DateUtil.dateToString(DateUtil.stringToDate(opTo, "yyyy-MM-dd"), "yyyy年MM月dd日");
					pubEntSearchDto.setOpToStr(opToStr);
				}
				if (!StringUtils.isEmpty(apprDate) && !"null".equals(apprDate)) {
					String apprDateStr = DateUtil.dateToString(DateUtil.stringToDate(apprDate, "yyyy-MM-dd"),
							"yyyy年MM月dd日");
					pubEntSearchDto.setApprDateStr(apprDateStr);
				}

				pubEntSearchDtos.add(pubEntSearchDto);
			}
			long end = System.currentTimeMillis();
			logger.debug("JSON to JAVA转换耗时：" + (end - start) + "毫秒");
			// 排序
			sortUtil.doEntListSort(pubEntSearchDtos, searchKeyWord, entarea);

			// 高亮显示
			lightShow(searchKeyWord, pubEntSearchDtos);

			int totalCount = (Integer) jsObject.get("total");
			Page<PubEntSearchDto> resultPage = new PageImpl<PubEntSearchDto>(pubEntSearchDtos,
					new PageRequest(currentPage, appSearchPagesizeInt), totalCount);
			entBaseInfoMap.put("resultPage", resultPage);
			entBaseInfoMap.put("size", totalCount);
			return entBaseInfoMap;
		} catch (Exception e) {
			logger.info("exception {}", e.getMessage(), e);
		}
		return null;
	}

	@Override
	public PubEntSearchDto selectByDocId(String docId) {
		if (cloudOpen.equalsIgnoreCase(cloudModel)) {// 云平台开启
			return findByGs(docId);
		} else {
			return findOneByLocal(docId);
		}
	}

	/**
	 * 描述：云平台上的查询
	 *
	 * @author baifangfang
	 * @date 2016年11月11日
	 * @param docId
	 * @return
	 */
	private PubEntSearchDto findByGs(String docId) {
		String sql = "select * from " + gsEntSearchIndex + " where priPID = '" + docId + "' limit 0,1";
		IndexQueryRequest request = new IndexQueryRequest();
		request.setSql(sql);
		try {
			IndexQueryResponse response = client.excute(request);
			if (response.getErrorCode().isEmpty()) {
				String reqValue = response.getResult(); // 请求返回值

				com.alibaba.fastjson.JSONObject jsonObj = com.alibaba.fastjson.JSONObject.parseObject(reqValue)
						.getJSONObject("hits");
				Object obj = jsonObj.get("hits");
				JSONArray jsonArr = JSONArray.fromObject(obj);
				JSONObject jsonObj2 = (JSONObject) jsonArr.get(0);
				Object source = jsonObj2.get("_source");
				JSONObject appObj = JSONObject.fromObject(source);

				PubEntSearchDto pubEntSearchDto = (PubEntSearchDto) JSONObject.toBean(appObj, PubEntSearchDto.class);

				String estDate = pubEntSearchDto.getEstDate();
				String opFrom = pubEntSearchDto.getOpFrom();
				String opTo = pubEntSearchDto.getOpTo();
				String apprDate = pubEntSearchDto.getApprDate();

				if (!StringUtils.isEmpty(estDate) && !"null".equals(estDate)) {
					String estDateStr = DateUtil.dateToString(DateUtil.stringToDate(estDate, "yyyyMMddhhmmss"),
							"yyyy年MM月dd日");
					pubEntSearchDto.setEstDateStr(estDateStr);
				}
				if (!StringUtils.isEmpty(opFrom) && !"null".equals(opFrom)) {
					String opFromStr = DateUtil.dateToString(DateUtil.stringToDate(opFrom, "yyyyMMddhhmmss"),
							"yyyy年MM月dd日");
					pubEntSearchDto.setOpFromStr(opFromStr);
				}
				if (!StringUtils.isEmpty(opTo) && !"null".equals(opTo)) {
					String opToStr = DateUtil.dateToString(DateUtil.stringToDate(opTo, "yyyyMMddhhmmss"),
							"yyyy年MM月dd日");
					pubEntSearchDto.setOpToStr(opToStr);
				}
				if (!StringUtils.isEmpty(apprDate) && !"null".equals(apprDate)) {
					String apprDateStr = DateUtil.dateToString(DateUtil.stringToDate(apprDate, "yyyyMMddhhmmss"),
							"yyyy年MM月dd日");
					pubEntSearchDto.setApprDateStr(apprDateStr);
				}

				return pubEntSearchDto;
			} else {
				logger.info("errorcode {},message {}", response.getErrorCode(), response.getMessage());
			}
		} catch (Exception e) {
			logger.info("exception {}", e, e.getMessage());
			return null;
		}
		return null;
	}

	/**
	 * 描述：非云平台上的查询
	 *
	 * @author baifangfang
	 * @date 2016年11月11日
	 * @param docId
	 * @return
	 */
	private PubEntSearchDto findOneByLocal(String docId) {
		String url = "http://" + esHost + ":" + esHttpPort + "/" + pubEntSearchIndex + "/" + pubEntSearchType + "/"
				+ docId;
		String result = HttpFluent.getData(url);
		logger.info("url {},result {}", url, result);

		JSONObject jsObject = JSONObject.fromObject(result).getJSONObject("_source");
		PubEntSearchDto pubEntSearchDto = (PubEntSearchDto) JSONObject.toBean(jsObject, PubEntSearchDto.class);
		String estDate = pubEntSearchDto.getEstDate();
		String opFrom = pubEntSearchDto.getOpFrom();
		String opTo = pubEntSearchDto.getOpTo();
		String apprDate = pubEntSearchDto.getApprDate();

		if (!StringUtils.isEmpty(estDate) && !"null".equals(estDate)) {
			String estDateStr = DateUtil.dateToString(DateUtil.stringToDate(estDate, "yyyy-MM-dd"), "yyyy年MM月dd日");
			pubEntSearchDto.setEstDateStr(estDateStr);
		}
		if (!StringUtils.isEmpty(opFrom) && !"null".equals(opFrom)) {
			String opFromStr = DateUtil.dateToString(DateUtil.stringToDate(opFrom, "yyyy-MM-dd"), "yyyy年MM月dd日");
			pubEntSearchDto.setOpFromStr(opFromStr);
		}
		if (!StringUtils.isEmpty(opTo) && !"null".equals(opTo)) {
			String opToStr = DateUtil.dateToString(DateUtil.stringToDate(opTo, "yyyy-MM-dd"), "yyyy年MM月dd日");
			pubEntSearchDto.setOpToStr(opToStr);
		}
		if (!StringUtils.isEmpty(apprDate) && !"null".equals(apprDate)) {
			String apprDateStr = DateUtil.dateToString(DateUtil.stringToDate(apprDate, "yyyy-MM-dd"), "yyyy年MM月dd日");
			pubEntSearchDto.setApprDateStr(apprDateStr);
		}

		return pubEntSearchDto;
	}

	@Override
	public MidBaseInfoDto selectByPripid(String priPID) {
		return midBaseInfoMapper.selectByPripid(priPID);
	}

	@Override
	public void doInsertPubDataToGsById() {
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
		long time1 = System.currentTimeMillis();

		int perCount = 20000;// 每次导入数量
		int totalCount = 0;
		int total = midBaseInfoService.getMaxId();
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
				logger.info("公示查询全量生成索引根据id来查询数据库 共循环{}次, 当前循环第{}次, 一次导入{}条", totalCount, current, perCount);

				start = current * perCount;
				List<MidBaseInfoDto> dataList = midBaseInfoService.doGetListById(start);

				request.setIndex(gsEntSearchIndex);// 索引名
				request.setType("batch");// single是1条1插，batch是累积到1000条才插入

				for (MidBaseInfoDto data : dataList) {
					PubEntSearchGSDto pubEntSearchGSDto = new PubEntSearchGSDto();
					BeanUtils.copyProperties(data, pubEntSearchGSDto);
					pubEntSearchGSDto.setUNICODE(data.getUniCode());
					pubEntSearchGSDto.setEntNameNo(data.getEntName());
					pubEntSearchGSDto.setHisEntNamePPL(data.getHisEntName());
					if (("33".equals(data.getEntTypeCatg()) || "27".equals(data.getEntTypeCatg()))
							&& "1".equals(data.getExeAffSign())) {// 合伙企业法人从投资表取值
						pubEntSearchGSDto.setLeRep(data.getInv());
					}

					beanStr = JSONArray.fromObject(pubEntSearchGSDto, jsonConfig).toString().replace("[", "")
							.replace("]", "");
					request.setKey(data.getPriPID());// 主键_ID的值
					request.setJsonData(beanStr);// 要插入的字段名和字段值
					response = client.excute(request);

					if (response.getErrorCode().isEmpty()) {
						// System.out.println(response.getResult());
					} else {
						logger.info("errorcode {},message {}", response.getErrorCode(), response.getMessage());
					}
				}
			}
		} catch (Exception e) {
			logger.info("exception {}", e, e.getMessage());
		}
		long time2 = System.currentTimeMillis();
		logger.info("公示查询全量生成索引 耗时:{}ms......", (time2 - time1));
	}

	@Override
	public void doInsertIncreToGs() {
		long time1 = System.currentTimeMillis();
		try {
			// 阻塞任务，防止并发访问数据库
			SleepUtil.threadSleep();
			if (csQuartzJobService.checkJobIsExecute(QuartzJobName.PUB_IDX_JOB.getJobName())) {
				return;
			}
			csQuartzJobService.insert(QuartzJobName.PUB_IDX_JOB.getJobName());
			JsonConfig jsonConfig = new JsonConfig();
			jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());

			int pageSize = 20000;
			int totalPage = 0;
			int totalIncreCount = midBaseInfoMapper.doIncreCount();// 查询增量更新的总数量
			logger.info("totalIncreCount {}", totalIncreCount);

			if (totalIncreCount % pageSize == 0) {
				totalPage = totalIncreCount / pageSize;
			}
			totalPage = (totalIncreCount / pageSize) + 1;

			IndexInsertRequest request = new IndexInsertRequest();
			IndexInsertResponse response = null;
			String beanStr = "";// 存储bean转成的json字符串

			for (int currPage = 0; currPage < totalPage; currPage++) {// 将数据库数据生成至索引中去
				logger.info("公示查询增量生成索引 共{}页  当前页码{} size:{}", totalPage, currPage, pageSize);
				List<MidBaseInfoDto> dataList = midBaseInfoService.doGetIncreList(currPage, pageSize);

				request.setIndex(gsEntSearchIndex);// 索引名
				request.setType("single");// single是1条1插，batch是累积到1000条才插入

				for (MidBaseInfoDto data : dataList) {
					PubEntSearchGSDto pubEntSearchGSDto = new PubEntSearchGSDto();
					BeanUtils.copyProperties(data, pubEntSearchGSDto);
					pubEntSearchGSDto.setUNICODE(data.getUniCode());
					pubEntSearchGSDto.setEntNameNo(data.getEntName());
					if (("33".equals(data.getEntTypeCatg()) || "27".equals(data.getEntTypeCatg()))
							&& "1".equals(data.getExeAffSign())) {// 合伙企业法人从投资表取值
						pubEntSearchGSDto.setLeRep(data.getInv());
					}

					beanStr = JSONArray.fromObject(pubEntSearchGSDto, jsonConfig).toString().replace("[", "")
							.replace("]", "");
					request.setKey(data.getPriPID());// 主键_ID的值
					request.setJsonData(beanStr);// 要插入的字段名和字段值
					response = client.excute(request);

					if (response.getErrorCode().isEmpty()) {
						// System.out.println(response.getResult());
					} else {
						logger.info("errorcode {},message {}", response.getErrorCode(), response.getMessage());
					}
				}
			}

			// 更新历史名称
			List<MidBaseInfoDto> midBaseInfoDtoList = midBaseInfoMapper.selectIncreHisEntNameList();
			for (MidBaseInfoDto midBaseInfoDto : midBaseInfoDtoList) {
				Map<String, Object> param = new HashMap<String, Object>();
				param.put("priPID", midBaseInfoDto.getPriPID());
				List<MidBaseInfoDto> mbid = midBaseInfoMapper.selectListByPriPID(param);
				if (mbid.size() > 0) {
					PubEntSearchGSDto pubEntSearchGSDto = new PubEntSearchGSDto();
					BeanUtils.copyProperties(mbid.get(0), pubEntSearchGSDto);
					pubEntSearchGSDto.setUNICODE(mbid.get(0).getUniCode());
					pubEntSearchGSDto.setHisEntNamePPL(mbid.get(0).getHisEntName());
					if (("33".equals(mbid.get(0).getEntTypeCatg()) || "27".equals(mbid.get(0).getEntTypeCatg()))
							&& "1".equals(mbid.get(0).getExeAffSign())) {// 合伙企业法人从投资表取值
						pubEntSearchGSDto.setLeRep(mbid.get(0).getInv());
					}

					beanStr = JSONArray.fromObject(pubEntSearchGSDto, jsonConfig).toString().replace("[", "")
							.replace("]", "");
					request.setKey(mbid.get(0).getPriPID());// 主键_ID的值
					request.setJsonData(beanStr);// 要插入的字段名和字段值
					response = client.excute(request);

					if (response.getErrorCode().isEmpty()) {
					} else {
						logger.info("errorcode {},message {}", response.getErrorCode(), response.getMessage());
					}
				}
			}

			// 从 cs_mid_baseinfo_del 删除索引
			List<MidBaseinfoDel> midBaseinfoDelList = midBaseinfoDelService.selectMidBaseinfoDelList();
			for (int i = 0; i < midBaseinfoDelList.size(); i++) {
				deleteEntByPriPID(midBaseinfoDelList.get(i).getPriPID());// 根据内部序号删除索引
			}

		} catch (Exception e) {
			logger.info("exception {}", e, e.getMessage());
		}
		long time2 = System.currentTimeMillis();
		logger.info("公示查询增量生成索引 耗时:{}ms......", (time2 - time1));
	}

	@Override
	public String updatePubIndex(Map<String, Object> jsonMap) {
		if (cloudOpen.equalsIgnoreCase(cloudModel))// 云平台开启
			return updatePubIndexCloud(jsonMap);
		return updatePubIndexNormal(jsonMap);
	}

	/**
	 * 描述：公示索引更新数据 非云平台
	 * 
	 * @author baifangfang
	 * @date 2016年12月5日
	 * @param jsonMap
	 * @return
	 */
	private String updatePubIndexNormal(Map<String, Object> jsonMap) {
		if (EsGsUtil.checkPriPIDIsBlank(jsonMap))
			return "1";
		try {
			String priPID = jsonMap.get("priPID") + "";
			String esUrl = "http://" + esHost + ":" + esHttpPort + "/" + pubEntSearchIndex + "/" + pubEntSearchType
					+ "/" + priPID;
			String reqValue = HttpFluent.getData(esUrl); // 请求返回值
			net.sf.json.JSONObject jsonObj = net.sf.json.JSONObject.fromObject(reqValue).getJSONObject("_source");
			jsonObj = EsGsUtil.updateJsonObj(jsonObj, jsonMap, cloudOpen, cloudModel);// 更新元数据
			HttpFluent.putData(esUrl, jsonObj.toString());// 更新索引文档
		} catch (Exception e) {
			logger.info("索引更新发生错误[原生]：{}", e);
			return "0";
		}
		return "1";
	}

	/**
	 * 描述：公示索引更新数据 云平台
	 * 
	 * @author baifangfang
	 * @date 2016年12月5日
	 * @param jsonMap
	 * @return
	 */
	private String updatePubIndexCloud(Map<String, Object> jsonMap) {
		if (EsGsUtil.checkPriPIDIsBlank(jsonMap))
			return "1";
		try {
			String priPID = jsonMap.get("priPID") + "";

			String baseSql = "select * from " + gsEntSearchIndex + " where priPID = '" + priPID + "' limit 0,1";

			IndexQueryResponse response = EsGsUtil.getQueryRep(baseSql, client);
			net.sf.json.JSONObject strJson = net.sf.json.JSONObject.fromObject(response.getResult())
					.getJSONObject("hits");
			Object obj = strJson.get("hits");
			net.sf.json.JSONArray jsonArr = net.sf.json.JSONArray.fromObject(obj);
			if (jsonArr == null || jsonArr.size() == 0)
				return "1";
			net.sf.json.JSONObject jsonObj = (net.sf.json.JSONObject) jsonArr.get(0);
			net.sf.json.JSONObject appObj = jsonObj.getJSONObject("_source");
			appObj = EsGsUtil.updateJsonObj(appObj, jsonMap, cloudOpen, cloudModel);// 更新元数据
			EsGsUtil.updateIndexBySingle(client, gsEntSearchIndex, priPID, appObj.toString());// 更新索引文档
			return "1";
		} catch (Exception e) {
			logger.info("索引更新发生错误[工商云]：{}", e);
			return "0";
		}
	}

	@Override
	public Boolean doInsertPubSingleDataToGs(String condition) {
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());

		List<MidBaseInfoDto> dataList = midBaseInfoService.doGetListByCondition(condition);
		IndexInsertRequest request = new IndexInsertRequest();
		IndexInsertResponse response = null;

		if (dataList != null && dataList.size() > 0) {
			MidBaseInfoDto midBaseInfoDto = dataList.get(0);
			PubEntSearchGSDto pubEntSearchGSDto = new PubEntSearchGSDto();
			BeanUtils.copyProperties(midBaseInfoDto, pubEntSearchGSDto);
			if (("33".equals(midBaseInfoDto.getEntTypeCatg()) || "27".equals(midBaseInfoDto.getEntTypeCatg()))
					&& "1".equals(midBaseInfoDto.getExeAffSign())) {// 合伙企业法人从投资表取值
				pubEntSearchGSDto.setLeRep(midBaseInfoDto.getInv());
			}
			pubEntSearchGSDto.setUNICODE(midBaseInfoDto.getUniCode());
			pubEntSearchGSDto.setHisEntNamePPL(midBaseInfoDto.getHisEntName());
			pubEntSearchGSDto.setEntNameNo(midBaseInfoDto.getEntName());
			String beanStr = JSONArray.fromObject(pubEntSearchGSDto, jsonConfig).toString().replace("[", "")
					.replace("]", "");
			request.setIndex(gsEntSearchIndex);
			request.setType("single");
			request.setKey(midBaseInfoDto.getPriPID());// 主键_ID的值
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
	public Boolean doInsertPubDataToGsByApprDate(String apprDate) {
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
		long time1 = System.currentTimeMillis();

		int pageSize = 20000;
		int totalPage = 0;
		// 查询需要导入的总数量
		int totalCount = midBaseInfoService.doCountByApprDate(apprDate);
		logger.info("totalCount {}", totalCount);

		if (totalCount % pageSize == 0) {
			totalPage = totalCount / pageSize;
		}
		totalPage = (totalCount / pageSize) + 1;

		try {
			IndexInsertRequest request = new IndexInsertRequest();
			IndexInsertResponse response = null;
			String beanStr = "";// 存储bean转成的json字符串

			for (int currPage = 0; currPage < totalPage; currPage++) {// 将数据库数据生成至索引中去
				logger.info("公示查询根据核准日期生成索引 共{}页  当前页码{} size:{}", totalPage, currPage, pageSize);
				List<MidBaseInfoDto> dataList = midBaseInfoService.doGetListByApprDate(currPage, pageSize, apprDate);

				request.setIndex(gsEntSearchIndex);// 索引名
				request.setType("single");// single是1条1插，batch是累积到1000条才插入

				for (MidBaseInfoDto data : dataList) {
					PubEntSearchGSDto pubEntSearchGSDto = new PubEntSearchGSDto();
					BeanUtils.copyProperties(data, pubEntSearchGSDto);
					pubEntSearchGSDto.setUNICODE(data.getUniCode());
					pubEntSearchGSDto.setHisEntNamePPL(data.getHisEntName());

					beanStr = JSONArray.fromObject(pubEntSearchGSDto, jsonConfig).toString().replace("[", "")
							.replace("]", "");
					request.setKey(data.getPriPID());// 主键_ID的值
					request.setJsonData(beanStr);// 要插入的字段名和字段值
					response = client.excute(request);

					if (response.getErrorCode().isEmpty()) {
						// System.out.println(response.getResult());
					} else {
						logger.info("errorcode {},message {}", response.getErrorCode(), response.getMessage());
					}
				}
			}
		} catch (Exception e) {
			logger.info("exception {}", e, e.getMessage());
			return false;
		}
		long time2 = System.currentTimeMillis();
		logger.info("公示查询根据核准日期生成索引 耗时:{}ms......", (time2 - time1));
		return true;
	}

	@Override
	public PubEntSearchDto selectByPriPID(String priPID) {
		List<MidBaseInfoDto> dataList = midBaseInfoService.doGetListByPriPID(priPID);
		PubEntSearchDto pubEntSearchDto = new PubEntSearchDto();
		if (dataList != null && dataList.size() > 0) {
			MidBaseInfoDto midBaseInfoDto = dataList.get(0);
			Date estDate = midBaseInfoDto.getEstDate();
			Date apprDate = midBaseInfoDto.getApprDate();
			Date opFrom = midBaseInfoDto.getOpFrom();
			Date opTo = midBaseInfoDto.getOpTo();
			Date altDate = midBaseInfoDto.getAltDate();
			Date punishDate = midBaseInfoDto.getPunishDate();
			BeanUtils.copyProperties(midBaseInfoDto, pubEntSearchDto);
			pubEntSearchDto.setUNICODE(midBaseInfoDto.getUniCode());

			if (!StringUtils.isEmpty(estDate)) {
				pubEntSearchDto.setEstDateStr(DateUtil.dateToString(estDate, "yyyy年MM月dd日"));
				pubEntSearchDto.setEstDate(DateUtil.dateToString(estDate, "yyyy年MM月dd日"));
				pubEntSearchDto.setEstDateLong(estDate.getTime());
			}
			if (!StringUtils.isEmpty(apprDate)) {
				pubEntSearchDto.setApprDateStr(DateUtil.dateToString(apprDate, "yyyy年MM月dd日"));
				pubEntSearchDto.setApprDate(DateUtil.dateToString(apprDate, "yyyy年MM月dd日"));
			}
			if (!StringUtils.isEmpty(opFrom)) {
				pubEntSearchDto.setOpFromStr(DateUtil.dateToString(opFrom, "yyyy年MM月dd日"));
				pubEntSearchDto.setOpFrom(DateUtil.dateToString(opFrom, "yyyy年MM月dd日"));
			}
			if (!StringUtils.isEmpty(opTo)) {
				pubEntSearchDto.setOpToStr(DateUtil.dateToString(opTo, "yyyy年MM月dd日"));
				pubEntSearchDto.setOpTo(DateUtil.dateToString(opTo, "yyyy年MM月dd日"));
			}
			if (!StringUtils.isEmpty(altDate)) {
				pubEntSearchDto.setAltDateStr(DateUtil.dateToString(altDate, "yyyy年MM月dd日"));
				pubEntSearchDto.setAltDate(DateUtil.dateToString(altDate, "yyyy年MM月dd日"));
			}
			if (!StringUtils.isEmpty(punishDate)) {
				pubEntSearchDto.setPunishDateStr(DateUtil.dateToString(punishDate, "yyyy年MM月dd日"));
			}

		}
		return pubEntSearchDto;
	}

	@Override
	public void doInsertPubDataToGsByIdUseThreadPool() {

		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
		long time1 = System.currentTimeMillis();

		int perCount = 20000;// 每次导入数量
		int totalCount = 0;
		int total = midBaseInfoService.getMaxId();
		if (total % perCount == 0) {
			totalCount = total / perCount;
		}
		totalCount = (total / perCount) + 1;// 一共需导入次数

		try {
			ExecutorService threadPool = Executors.newFixedThreadPool(10);
			// IndexInsertRequest request = new IndexInsertRequest();
			// int start = 0;
			for (int current = 0; current <= totalCount; current++) {// 将数据库数据生成至索引中去
				logger.info("公示查询全量生成索引根据id来查询数据库 共循环{}次, 当前循环第{}次, 一次导入{}条", totalCount, current, perCount);

				// start = current * perCount;
				// List<MidBaseInfoDto> dataList =
				// midBaseInfoService.doGetListById(start);

				// request.setIndex(gsEntSearchIndex);// 索引名
				// request.setType("single");// single是1条1插，batch是累积到1000条才插入

				threadPool.execute(new Runnable() {
					public void run() {
						System.out.println(Thread.currentThread().getName() + "run---");
						// for (MidBaseInfoDto data : dataList) {
						// PubEntSearchGSDto pubEntSearchGSDto = new
						// PubEntSearchGSDto();
						// BeanUtils.copyProperties(data, pubEntSearchGSDto);
						// pubEntSearchGSDto.setUNICODE(data.getUniCode());
						//
						// String beanStr =
						// JSONArray.fromObject(pubEntSearchGSDto,
						// jsonConfig).toString()
						// .replace("[", "").replace("]", "");
						// request.setKey(data.getPriPID());// 主键_ID的值
						// request.setJsonData(beanStr);// 要插入的字段名和字段值
						// IndexInsertResponse response = null;
						// try {
						// response = client.excute(request);
						// } catch (ApiException e) {
						// logger.info("gs client response exception {}", e,
						// e.getMessage());
						// }
						//
						// if (response.getErrorCode().isEmpty()) {
						// // System.out.println(response.getResult());
						// } else {
						// logger.info("errorcode {},message {}",
						// response.getErrorCode(), response.getMessage());
						// }
						// }
					}
				});
			}
			threadPool.shutdown();
		} catch (Exception e) {
			logger.info("exception {}", e, e.getMessage());
		}
		long time2 = System.currentTimeMillis();
		logger.info("公示查询全量生成索引 耗时:{}ms......", (time2 - time1));

	}

	@Override
	public Boolean deleteEntByPriPID(String priPID) throws ApiException {
		IndexDeleteRequest indexDeleteRequest = new IndexDeleteRequest();
		indexDeleteRequest.setSql("delete from " + gsEntSearchIndex + " where priPID='" + priPID + "'");
		IndexDeleteResponse response = client.excute(indexDeleteRequest);

		if (response.getErrorCode().isEmpty()) {
			logger.info("success result {}", response.getResult());
			return true;
		} else {
			logger.info("failed code: {},message {}", response.getErrorCode(), response.getMessage());
			return false;
		}
	}

	@Override
	public void updateHisEntName() {
		long time1 = System.currentTimeMillis();
		try {
			int pageSize = 20000;
			int totalPage = 0;
			int totalCount = 1000000;
			logger.info("totalCount {}", totalCount);

			if (totalCount % pageSize == 0) {
				totalPage = totalCount / pageSize;
			}
			totalPage = (totalCount / pageSize) + 1;

			for (int currPage = 0; currPage < totalPage; currPage++) {// 将数据库数据生成至索引中去
				logger.info("公示历史名称共{}页  当前页码{} size:{}", totalPage, currPage, pageSize);
				List<MidBaseInfoDto> dataList = midBaseInfoService.doGetHisEntNameList(currPage, pageSize);

				for (int i = 0; i < dataList.size(); i++) {
					Map<String, Object> jsonMap = new HashMap<String, Object>();
					jsonMap.put("priPID", dataList.get(i).getPriPID());
					jsonMap.put("hisEntName", dataList.get(i).getHisEntName());
					jsonMap.put("hisEntNamePPL", dataList.get(i).getHisEntName());
					updatePubIndex(jsonMap);
				}
			}
		} catch (Exception e) {
			logger.info("exception {}", e, e.getMessage());
		}
		long time2 = System.currentTimeMillis();
		logger.info("公示查询增量生成索引 耗时:{}ms......", (time2 - time1));
	}

}
