package com.icinfo.cs.depsyn.service.impl;

import java.util.Date;
import java.util.Map;

import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.icinfo.cs.common.constant.DBAuthorConstants;
import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.common.utils.HttpFluent;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.depsyn.service.IDepSynSearchService;
import com.icinfo.cs.es.dto.PanoramaResultDto;
import com.icinfo.cs.es.mapper.PanoramaSearchMapper;
import com.icinfo.cs.es.service.impl.PanoramaSearchServiceImpl;
import com.icinfo.cs.es.util.ESUtil;
import com.icinfo.cs.es.util.EsGsUtil;
import com.icinfo.framework.mybatis.pagehelper.Page;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

import cn.gov.zj.gsj.v2.api.GsjClient;
import cn.gov.zj.gsj.v2.obj.entity.IndexQueryResponse;

/**
 * 全景查询相关业务方法
 * 
 * @author zhuyong
 */
@Service
public class DepSynSearchServiceImpl implements IDepSynSearchService {

	private static final Logger logger = LoggerFactory.getLogger(PanoramaSearchServiceImpl.class);

	//云平台开启标志
	private static final String cloudOpen = "Y";
	
	@Autowired
	PanoramaSearchMapper panoramaSearchMapper;
	
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
	
	//需要模糊搜索的列
	private static final String[] nameArrWild = new String[]{"entName","dom","opScope","licNameAft"};
	
	//需要切分的列
	private static final String[] nameArrSplit = new String[]{"industryCo","entType","entTypeCatg",
			"localAdm","regOrg","regState","sliceNO"};
	//年报相关的搜索条件
	private static final String[] yrRepMatch = new String[]{"yrRepMode","yrIsRep","yrRepState"};
		
	//年报相关的搜索条件 in & not in 筛选
	private static final String[] yrRepMatchBool = new String[]{"yrRepModify","yrSenCheck"};
		
	
	//不需要模糊搜索的列
	private static final String[] nameArrMatch = new String[]{"leRep","licState","tel"};
		
	//不需要模糊搜索的列 用作 in & not in筛选
	private static final String[] nameArrMatchBool = new String[]{"isCase","isOpan","leRepIsLim","isIndRegObj",
			"isFocusObj","isRiskWarn"};
		
	
	/****************************************************
	 * estDateStart   成立日期开始    estDateEnd     成立日期结束
	 * apprDateStart  核准日期开始    apprDateEnd    核准日期结束
	 * altDateStart   销户日期开始    altDateEnd     销户日期结束
	 ****************************************************/
	private static final String[] dateRange = new String[]{"estDateStart","estDateEnd","apprDateStart",
			"apprDateEnd","altDateStart","altDateEnd"};
	
	/**
	 * 获取全景查询返回结果
	 * 供分页框架使用
	 * 
	 * @author zhuyong
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public Page<PanoramaResultDto> doGetSearchList(PageRequest request) throws Exception {
		if(cloudOpen.equalsIgnoreCase(cloudModel))//云平台开启
			return queryPageCloud(request);
		
		return queryPageNormal(request);
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
		page.addAll(EsGsUtil.jsonArr2List(EsGsUtil.parseEsReqResult(json)));
		return page;
	}
	
	/**
	 * 获取全景查询返回结果
	 * 供分页框架使用
	 * 云平台使用
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
		/**************************** 统一信用代码/注册号/企业名称/法人 **************************/
		if (EsGsUtil.KIE(params, "keyword"))
			if (params.get("type").equals("0")) {
				condSql.append(" AND (uniscid like '*" + params.get("keyword").toString() + "*' OR regNO like '*"
						+ params.get("keyword").toString() + "*' OR entName like '*" + params.get("keyword").toString()
						+ "*' OR leRep like '*" + params.get("keyword").toString() + "*')");
			} else if (params.get("type").equals("1")) {
				condSql.append(" AND (entName like '*" + params.get("keyword").toString() + "*')");
			} else if (params.get("type").equals("2")) {
				condSql.append(" AND (uniscid like '*" + params.get("keyword").toString() + "*' OR regNO like '*"
						+ params.get("keyword").toString() + "*')");
			} else if (params.get("type").equals("3")) {
				condSql.append(" AND (leRep like '*" + params.get("keyword").toString() + "*')");
			} else if (params.get("type").equals("4")) {
				condSql.append(" AND (opScope like '*" + params.get("keyword").toString() + "*')");
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
				condSql.append(" AND " + dr.replace("End", "") + "<=" + EsGsUtil.FCD(EsGsUtil.MGV(params, dr)));
		}
		/************************** 年报相关搜索 **************************/
		if (EsGsUtil.KIE(params, "yrYear")) {
			String yrYear = params.get("yrYear") + "";
			condSql.append(" AND estDate <" + EsGsUtil.FCD(EsGsUtil.GNY(yrYear)));

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

			/****************************************************
			 * yrRepMode 年报方式 yrIsRep 是否年报 yrSenCheck 是否涉及敏感词审核
			 ****************************************************/
			for (String nam : yrRepMatch) {
				if (EsGsUtil.KIE(params, nam))
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
		appendDBAuthWhereSql(condSql, params);
		rstSql = condSql.toString();
		if (rstSql.equals("") || rstSql.length() < 5)
			return "";
		return " WHERE " + rstSql.substring(4, rstSql.length());
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
			if (params == null) return qb;	
			/****************************统一信用代码/注册号/企业名称**************************/
			if(EsGsUtil.KIE(params,"keyword")){
				bqb = QueryBuilders.boolQuery();
				if (params.get("type").equals("0")) {
					bqb.should(QueryBuilders.wildcardQuery("uniscid", "*"+params.get("keyword")+"*"));
					bqb.should(QueryBuilders.wildcardQuery("regNO", "*"+params.get("keyword")+"*"));
					bqb.should(QueryBuilders.wildcardQuery("entName", "*"+params.get("keyword")+"*"));
					bqb.should(QueryBuilders.wildcardQuery("leRep", "*"+params.get("keyword")+"*"));
				} else if (params.get("type").equals("1")) {
					bqb.should(QueryBuilders.wildcardQuery("entName", "*"+params.get("keyword")+"*"));
				} else if (params.get("type").equals("2")) {
					bqb.should(QueryBuilders.wildcardQuery("uniscid", "*"+params.get("keyword")+"*"));
					bqb.should(QueryBuilders.wildcardQuery("regNO", "*"+params.get("keyword")+"*"));
				} else if (params.get("type").equals("3")) {
					bqb.should(QueryBuilders.wildcardQuery("leRep", "*"+params.get("keyword")+"*"));
				} else if (params.get("type").equals("4")) {
					bqb.should(QueryBuilders.wildcardQuery("opScope", "*"+params.get("keyword")+"*"));
				}
				qb.must(bqb);
			}
			/*****************************是否联络员确认*******************************/
			if(EsGsUtil.KIE(params, "yrLiaConfirm")){
				if("Y".equals(EsGsUtil.MGV(params, "yrLiaConfirm")))
					qb.mustNot(QueryBuilders.matchQuery("liaName", ""));
				else
					qb.must(QueryBuilders.matchQuery("liaName", ""));
			}
			/****************************最近一年是否抽检******************************/
			if(EsGsUtil.KIE(params, "spotDate")){
				if("Y".equals(EsGsUtil.MGV(params, "spotDate")))
					qb.must(QueryBuilders.rangeQuery("spotDate").gte(DateUtil.getNyearlaterDate(new Date(), -1)));
				else
					qb.mustNot(QueryBuilders.rangeQuery("spotDate").gte(DateUtil.getNyearlaterDate(new Date(), -1)));
			}
			/****************************需要模糊搜索的列****************************/
			for (String naw : nameArrWild) {
				if(EsGsUtil.KIE(params,naw)) qb.must(QueryBuilders.wildcardQuery(naw,"*"+params.get(naw)+"*"));
			}
			/****************************不需要模糊搜索的列****************************/
			for (String nam : nameArrMatch) {
				if(EsGsUtil.KIE(params,nam)) qb.must(QueryBuilders.matchQuery(nam,params.get(nam)));
			}
			for (String nam : nameArrMatchBool) {
				if(!EsGsUtil.KIE(params,nam)) continue;
				if("Y".equals(EsGsUtil.MGV(params, nam)))
					qb.must(QueryBuilders.matchQuery(nam,"Y"));
				else
					qb.mustNot(QueryBuilders.matchQuery(nam,"Y"));
			}
			/**************************需要切分的列**************************/
			for(String nas : nameArrSplit){
				if(!EsGsUtil.KIE(params, nas)) continue;
				String[] codeArr = params.get(nas).toString().split(",");
				bqb = QueryBuilders.boolQuery();
				for (String code : codeArr) {
					bqb.should(QueryBuilders.matchQuery(nas, code));
				}
				qb.must(bqb);
			}
			/**************************注册资本**************************/
			if(EsGsUtil.KIE(params, "regCapStart"))//注册资本开始
				qb.must(QueryBuilders.rangeQuery("regCap").gte(params.get("regCapStart")));
			if(EsGsUtil.KIE(params, "regCapEnd"))//注册资本结束
				qb.must(QueryBuilders.rangeQuery("regCap").lte(params.get("regCapEnd")));
			
			/************************日期区间相关搜索***********************/
			for (String dr : dateRange) {
				if(!EsGsUtil.KIE(params, dr)) continue;
				if(dr.contains("Start"))
					qb.must(QueryBuilders.rangeQuery(dr.replace("Start","")).gte(EsGsUtil.BOD(EsGsUtil.MGV(params,dr))));
				else
					qb.must(QueryBuilders.rangeQuery(dr.replace("End","")).lte(params.get(dr)));
			}
			/**************************年报相关搜索**************************/
			if(EsGsUtil.KIE(params, "yrYear")){
				String yrYear = params.get("yrYear") + "";		
				qb.must(QueryBuilders.rangeQuery("estDate").lt(EsGsUtil.GNY(yrYear)));		
				/**************************最近报送时间**************************/
				if(EsGsUtil.KIE(params, "yrRecRepTimeStart"))//最近报送时间
					qb.must(QueryBuilders.rangeQuery("yrRecRepTime"+yrYear).gte(EsGsUtil.BOD(EsGsUtil.MGV(params, "yrRecRepTimeStart"))));
				if(EsGsUtil.KIE(params, "yrRecRepTimeEnd"))//最近报送时间
					qb.must(QueryBuilders.rangeQuery("yrRecRepTime"+yrYear).lte(params.get("yrRecRepTimeEnd")));		
				/**************************首次报送时间**************************/
				if(EsGsUtil.KIE(params, "yrFirRepTimeStart"))//首次报送时间
					qb.must(QueryBuilders.rangeQuery("yrFirRepTime"+yrYear).gte(EsGsUtil.BOD(EsGsUtil.MGV(params, "yrFirRepTimeStart"))));
				if(EsGsUtil.KIE(params, "yrFirRepTimeEnd"))//首次报送时间
					qb.must(QueryBuilders.rangeQuery("yrFirRepTime"+yrYear).lte(params.get("yrFirRepTimeEnd")));
				/****************************************************
				 * yrRepMode   年报方式
				 * yrIsRep     是否年报
				 * yrSenCheck  是否涉及敏感词审核
				 ****************************************************/
				for (String nam : yrRepMatch) {
					if(EsGsUtil.KIE(params,nam)) 
						qb.must(QueryBuilders.matchQuery(nam+yrYear, params.get(nam)));
				}
				for (String nam : yrRepMatchBool) {
					if(!EsGsUtil.KIE(params,nam)) continue; 
					if("Y".equals(EsGsUtil.MGV(params, "yrIsRep")))
						qb.must(QueryBuilders.matchQuery(nam+yrYear,"Y"));
					else
						qb.mustNot(QueryBuilders.matchQuery(nam+yrYear,"Y"));
				}
			}
			/**************************经营期限到期提示**************************/
			if(EsGsUtil.KIE(params, "opTip")){
				if("0".equals(EsGsUtil.MGV(params, "opTip"))){
					qb.must(QueryBuilders.rangeQuery("opTo").lte(DateUtil.getNmonthlater(new Date(), 1, "yyyy-MM-dd")));
				}else if ("2".equals(EsGsUtil.MGV(params, "opTip"))) {
					qb.must(QueryBuilders.rangeQuery("opTo").gte(DateUtil.getNmonthlater(new Date(),0, "yyyy-MM-dd"))
					.lte(DateUtil.getNmonthlater(new Date(), 1, "yyyy-MM-dd")));
				}else if("1".equals(EsGsUtil.MGV(params, "opTip"))){
					qb.must(QueryBuilders.rangeQuery("opTo").lt(DateUtil.dateToString(new Date(),"yyyy-MM-dd")));
				}
			}
			
			/**************************经营期限**************************/
			if(EsGsUtil.KIE(params, "opFrom"))//经营期限开始
				qb.must(QueryBuilders.rangeQuery("opFrom").gte(EsGsUtil.BOD(EsGsUtil.MGV(params, "opFrom"))));
			if(EsGsUtil.KIE(params, "opTo"))//经营期限结束
				qb.must(QueryBuilders.rangeQuery("opTo").lte(params.get("opTo")));

			builderDBAuthQuery(qb,params);
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
			qb.should(QueryBuilders.wildcardQuery("checkDep", likeValue));
		}
		if (EsGsUtil.KIE(params, DBAuthorConstants.PARAM_NAME_CHECK_DEP)
				&& EsGsUtil.KIE(params, DBAuthorConstants.PARAM_EQ_VAL_NAME_CHECK_DEP)) {
			qb.should(QueryBuilders.matchQuery("checkDep",
					params.get(DBAuthorConstants.PARAM_EQ_VAL_NAME_CHECK_DEP).toString()));
		}
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
		if (EsGsUtil.KIE(params, DBAuthorConstants.PARAM_NAME_CHECK_DEP)
				&& EsGsUtil.KIE(params, DBAuthorConstants.PARAM_LIKE_VAL_CHECK_DEP)) {
			condSql.append(" AND " + params.get(DBAuthorConstants.PARAM_NAME_CHECK_DEP) + " like "
					+ params.get(DBAuthorConstants.PARAM_LIKE_VAL_CHECK_DEP));
		}
		if (EsGsUtil.KIE(params, DBAuthorConstants.PARAM_NAME_CHECK_DEP)
				&& EsGsUtil.KIE(params, DBAuthorConstants.PARAM_EQ_VAL_NAME_CHECK_DEP)) {
			condSql.append(" AND " + params.get(DBAuthorConstants.PARAM_NAME_CHECK_DEP) + " = "
					+ params.get(DBAuthorConstants.PARAM_EQ_VAL_NAME_CHECK_DEP));
		}
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

}
