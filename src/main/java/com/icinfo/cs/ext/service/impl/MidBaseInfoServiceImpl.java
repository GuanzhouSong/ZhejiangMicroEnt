/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.ext.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.RangeQueryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.icinfo.cs.base.model.CodeRegorg;
import com.icinfo.cs.base.service.ICodeRegorgService;
import com.icinfo.cs.common.constant.RegStateEnum;
import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.common.utils.ExcelUtil;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.ext.dto.MidBaseInfoDto;
import com.icinfo.cs.ext.mapper.MidBaseInfoMapper;
import com.icinfo.cs.ext.model.MidBaseInfo;
import com.icinfo.cs.ext.service.IMidBaseInfoService;
import com.icinfo.cs.system.model.EntBaseInfo;
import com.icinfo.cs.system.model.EntDelegateRecord;
import com.icinfo.cs.system.model.SysUser;
import com.icinfo.cs.system.service.IEntDelegateRecordService;
import com.icinfo.cs.system.service.ISysUserService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.pagehelper.Page;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.security.shiro.UserProfile;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 描述: cs_mid_baseinfo 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年08月29日
 */
@Service
public class MidBaseInfoServiceImpl extends MyBatisServiceSupport implements IMidBaseInfoService {
	private static final Logger logger = LoggerFactory.getLogger(MidBaseInfoServiceImpl.class);

	@Autowired
	private MidBaseInfoMapper midBaseInfoMapper;

	@Autowired
	private ISysUserService sysUserService;

	@Autowired
	private ICodeRegorgService codeRegorgService;

	@Autowired
	private IEntDelegateRecordService delegateRecordService;

	@Value("${es.ip}")
	private String esHost;// es服务器的ip

	/**
	 * 描述: 按内部序号查询企业基本信息
	 * 
	 * @auther ZhouYan
	 * @date 2016年8月29日
	 * @param pripid
	 * @return
	 * @throws Exception
	 */
	@Override
	public MidBaseInfo selectByPripid(String pripid) throws Exception {
		if (StringUtils.isNotEmpty(pripid)) {
			Example example = new Example(MidBaseInfo.class);
			List<String> fieldValues = new ArrayList<String>();
			for (String s : RegStateEnum.CUNXU.getCode().split(",")) {
				fieldValues.add(s);
			}
			example.createCriteria().andEqualTo("priPID", pripid).andIn("regState", fieldValues);// 否
			List<MidBaseInfo> midbaseinfos = midBaseInfoMapper.selectByExample(example);
			if (midbaseinfos != null && midbaseinfos.size() > 0) {
				return midbaseinfos.get(0);
			} else {
				return null;
			}
		} else {
			return null;
		}
	}

	/**
	 * 描述: 数据比对分页
	 *
	 * @param
	 * @return
	 * @throws Exception
	 * @auther ylr
	 * @date 2016年8月29日
	 */
	public List<MidBaseInfoDto> queryComparePage(PageRequest request, List<MidBaseInfoDto> list) throws Exception {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		return list;
	}

	/**
	 * 描述: 登录时按内部序号查询企业基本信息
	 * 
	 * @auther ZhouYan
	 * @date 2016年10月24日
	 * @param pripid
	 * @param systemType
	 * @return
	 * @throws Exception
	 */
	@Override
	public MidBaseInfoDto selectMidBaseInfoByPripid(String pripid, String systemType) throws Exception {
		return midBaseInfoMapper.selectMidBaseInfoByPripidForLogin(pripid, systemType, RegStateEnum.CUNXU.getParam());
	}

	/**
	 * 描述: 按内部序号查询企业基本信息
	 *
	 * @auther liuhq
	 * @date 2016年10月24日
	 * @param pripid
	 * @return
	 * @throws Exception
	 */
	@Override
	public MidBaseInfoDto selectMidBaseInfoByPripid(String pripid) throws Exception {
		return midBaseInfoMapper.selectMidBaseInfoByPripid(pripid);
	}

	/**
	 * 根据 统一信用代码或注册号查询企业名称(存续)
	 * 
	 * @author :chenxin
	 * @param regno
	 * @return
	 * @throws Exception
	 */
	@Override
	public MidBaseInfoDto selectMidBaseInfoByRegNOHold(String regno) throws Exception {
		return midBaseInfoMapper.selectMidBaseInfoByRegNOHold(regno, RegStateEnum.CUNXU.getParam());
	}

	/**
	 * 根据 统一信用代码或注册号查询企业名称
	 * 
	 * @author :wangjin
	 * @param regno
	 * @return
	 * @throws Exception
	 */
	@Override
	public MidBaseInfo selectMidBaseInfoByRegno(String regno) throws Exception {
		MidBaseInfo midBaseInfo = new MidBaseInfo();
		if (StringUtil.isNotBlank(regno)) {
			Example example = new Example(MidBaseInfo.class);
			example.createCriteria().andEqualTo("regNO", regno);
			example.or(example.createCriteria().andEqualTo("uniCode", regno));
			List<MidBaseInfo> midList = midBaseInfoMapper.selectByExample(example);
			if (midList.size() > 0) {
				midBaseInfo = midList.get(0);
				return midBaseInfo;
			}
		}
		return null;
	}

	/**
	 * 根据 统一信用代码或注册号查询企业内部序号
	 * 
	 * @author chenxin
	 * @date 2017-02-21
	 * @param regNOList
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<String> selectPriPIDByRegno(List<String> regNOList) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		String[] strings = new String[regNOList.size()];
		regNOList.toArray(strings);
		map.put("regNOList", strings);
		return midBaseInfoMapper.selectPriPIDByRegno(map);
	}

	@Override
	public List<String> selectPriPIDByRegno(String regNO) throws Exception {

		return null;
	}

	/**
	 * 描述: 登录时按注册号、企业名称查询企业基本信息
	 * 
	 * @auther ZhouYan
	 * @date 2016年8月29日
	 * @param regno
	 * @param entname
	 * @param systemType
	 *            1(企业); 2:(个体户); 3：(农专)
	 * @return
	 * @throws Exception
	 */
	@Override
	public MidBaseInfoDto selectByRegnoAndEntname(String regno, String entname, String systemType) throws Exception {
		return midBaseInfoMapper.selectByRegnoAndEntname(regno, entname, systemType, RegStateEnum.CUNXU.getParam());
	}

	/**
	 *
	 * 描述: 根据注册号（统一代码）或名称查询
	 * 
	 * @auther gaojinling
	 * @date 2016年8月29日
	 * @param map
	 * @return
	 */
	@Override
	public List<MidBaseInfoDto> selectMidBaseinfoByRegNoAndName(Map<String, Object> map) {
		if (map != null) {
			map.put("regStateParam", RegStateEnum.CUNXU.getParam());
		}
		return midBaseInfoMapper.selectMidBaseinfoByRegNoAndName(map);
	}

	/**
	 * 描述: 查找登记机关与管辖单位所在机关不一致的企业（regOrgCode！= 管辖单位的父代码的前6位）
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 * @auther ZhuDefeng
	 * @date 2016年9月20日
	 */
	@Override
	public List<MidBaseInfoDto> selectMidbaseinfo4delegate(PageRequest request) throws Exception {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		return midBaseInfoMapper.selectMidbaseinfo4delegate(request.getParams());
	}

	/**
	 * 描述: 根据法人姓名和证件号码查询关联企业信息
	 *
	 * @param map
	 * @return
	 * @auther chenxin
	 * @date 2017年3月22日
	 */
	@Override
	public List<MidBaseInfoDto> selectMidBaseinfoBackList(PageRequest request) throws Exception {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		if (request.getParams() != null) {
			Map<String, Object> params = request.getParams();
			if (params.get("notInPidList") != null && StringUtils.isNotEmpty(params.get("notInPidList").toString())) {
				String notInPidList = params.get("notInPidList").toString();
				if (notInPidList.split(",").length >= 1) {
					params.put("notInPidArr", notInPidList.split(","));
					params.remove("notInPidList");
				}
			}
		}
		return midBaseInfoMapper.selectMidBaseinfoBackList(request.getParams());
	}

	/**
	 * 描述：查询企业基本信息
	 * 
	 * @author yujingwei
	 * @date 2016-10-12
	 * @param request
	 * @return List<MidBaseInfo>
	 * @throws Exception
	 */
	public List<MidBaseInfo> queryPage(PageRequest request) throws Exception {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		return midBaseInfoMapper.selectMidInfo(request.getParams());
	}

	/**
	 * 描述: 为企业设置委托
	 *
	 * @param priPIDs
	 *            主体身份代码
	 * @param userProfile
	 *            当前登录用户
	 * @throws Exception
	 * @auther ZhuDefeng
	 * @date 2016年9月22日
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public void setDelegate(String[] priPIDs, UserProfile userProfile) throws Exception {
		MidBaseInfo midBaseInfoCoditon = new MidBaseInfo();
		if (priPIDs == null)
			return;
		SysUser sysUser = sysUserService.selectByUserName(userProfile.getUsername());
		for (int i = 0; i < priPIDs.length; i++) {
			EntBaseInfo entBaseInfo = null;
			CodeRegorg codeRegorg = null;
			if (StringUtils.isBlank(StringUtils.trim(priPIDs[i])))
				continue;
			midBaseInfoCoditon.setPriPID(priPIDs[i]);
			midBaseInfoMapper.setDelegate(priPIDs[i]);
			// 取出委托后的新的
			entBaseInfo = selectBaseInfoByPriPIDAndEs(priPIDs[i]);
			EntDelegateRecord entDelegateRecord = new EntDelegateRecord();
			entDelegateRecord.setPriPID(priPIDs[i]);
			entDelegateRecord.setIsCancle("0");
			entDelegateRecord.setSetTime(new Date());
			entDelegateRecord.setUsername(userProfile.getUsername());
			entDelegateRecord.setDelegateOrg(entBaseInfo.getDelegateOrg());
			codeRegorg = codeRegorgService.selectRegOrgByCode(entBaseInfo.getDelegateOrg());
			if (codeRegorg != null)
				entDelegateRecord.setDelegateOrgName(codeRegorg.getContent());
			if (sysUser != null) {
				entDelegateRecord.setUsername(sysUser.getUsername());
				entDelegateRecord.setAppReviewOrg(sysUser.getDeptCode());
				entDelegateRecord.setAppReviewOrgName(sysUser.getDeptName());
			}
			entDelegateRecord.setEntName(entBaseInfo.getEntName());
			delegateRecordService.insertRecord(entDelegateRecord);
		}
	}

	/**
	 * 描述: 为企业取消委托
	 *
	 * @param priPIDs
	 *            主体身份代码
	 * @param userProfile
	 *            当前登录用户
	 * @throws Exception
	 * @auther ZhuDefeng
	 * @date 2016年9月22日
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public void cancleDelegate(String[] priPIDs, UserProfile userProfile) throws Exception {
		MidBaseInfo midBaseInfoCoditon = new MidBaseInfo();
		for (int i = 0; i < priPIDs.length; i++) {
			if (StringUtils.isBlank(StringUtils.trim(priPIDs[i])))
				continue;
			midBaseInfoCoditon.setPriPID(priPIDs[i]);
			// MidBaseInfo midBaseInfo =
			// midBaseInfoMapper.selectOne(midBaseInfoCoditon);
			midBaseInfoMapper.cancleDelegate(priPIDs[i]);

			EntDelegateRecord entDelegateRecord = new EntDelegateRecord();
			entDelegateRecord.setPriPID(priPIDs[i]);
			entDelegateRecord.setIsCancle("1");
			entDelegateRecord.setSetTime(new Date());
			entDelegateRecord.setUsername(userProfile.getUsername());

			delegateRecordService.insertRecord(entDelegateRecord);

		}
	}

	/**
	 * 描述: 查询登记机关与属地机关不一致的企业
	 *
	 * @param request
	 *            请求参数
	 * @throws Exception
	 * @auther ZhuDefeng
	 * @date 2016年9月22日
	 */
	@Override
	public Page<EntBaseInfo> selectbaseinfo4delegateByEs(PageRequest request) throws Exception {
		// Map<String, Object> params = request.getParams();
		// BoolQueryBuilder qb = buildQuery(params);
		// logger.info("bqb {}", qb);
		// String param = ESUtil.toBoolQueryStr(qb, request.getStart(),
		// request.getLength());
		//
		// try {
		// String result = HttpFluent.postData("http://" + esHost + ":" +
		// esHttpPort + "/" + baseinfoDelegate + "/"
		// + baseinfoDelegateType + "/_search", param);
		// JSONObject jsObject =
		// JSONObject.fromObject(result).getJSONObject("hits");
		// Object obj = jsObject.get("hits");
		// Object took = JSONObject.fromObject(result).get("took");
		// logger.info("obj {},took {}", obj, took);
		// List<EntBaseInfo> midBaseInfos = new ArrayList<EntBaseInfo>();
		// JSONArray data = JSONArray.fromObject(obj);
		//
		// for (int i = 0; i < data.size(); i++) {
		// JSONObject jobj = (JSONObject) data.get(i);
		// Object source = jobj.get("_source");
		// JSONObject jsObjectApp = JSONObject.fromObject(source);
		// midBaseInfos.add((EntBaseInfo) JSONObject.toBean(jsObjectApp,
		// EntBaseInfo.class));
		// }
		// int totalCount = (Integer) jsObject.get("total");
		// Page<EntBaseInfo> midBaseInfoPage = new
		// Page<EntBaseInfo>(request.getStart(), request.getLength());
		// midBaseInfoPage.setTotal(totalCount);
		// midBaseInfoPage.addAll(midBaseInfos);
		// return midBaseInfoPage;
		// } catch (IOException e) {
		// logger.info("exception {}", e.getMessage(), e);
		// }
		return null;
	}

	/**
	 * 描述：
	 *
	 * @param priPID
	 * @return
	 * @throws Exception
	 */
	@Override
	public EntBaseInfo selectBaseInfoByPriPIDAndEs(String priPID) throws Exception {
		return null;

		// String url = "http://" + esHost + ":" + esHttpPort + "/" +
		// baseinfoDelegate + "/" + baseinfoDelegateType + "/"
		// + priPID;
		// String result = HttpFluent.getData(url);
		// logger.info("url {},result {}", url, result);
		// JSONObject jsObject =
		// JSONObject.fromObject(result).getJSONObject("_source");
		// EntBaseInfo entBaseInfo = (EntBaseInfo) JSONObject.toBean(jsObject,
		// EntBaseInfo.class);
		// return entBaseInfo;
	}

	/**
	 * 描述：构建ES查询条件
	 * 
	 * @author ZhuDefeng、
	 * @date 2016-10-11
	 * @param params
	 * @return
	 */
	private BoolQueryBuilder buildQuery(Map<String, Object> params) {
		BoolQueryBuilder qb = QueryBuilders.boolQuery();
		if (params != null) {

			// 注册号
			if (!org.springframework.util.StringUtils.isEmpty(params.get("regNO"))) {
				qb.must(QueryBuilders.termQuery("regNO", params.get("regNO")));
			}

			// 企业名称
			if (!org.springframework.util.StringUtils.isEmpty(params.get("entName"))) {
				qb.must(QueryBuilders.matchQuery("entName", params.get("entName")));
			}

			// 法定代表人
			if (!org.springframework.util.StringUtils.isEmpty(params.get("leRep"))) {
				qb.must(QueryBuilders.matchQuery("leRep", params.get("leRep")));
			}

			// 年检机关
			if (!org.springframework.util.StringUtils.isEmpty(params.get("checkOrg"))) {
				qb.must(QueryBuilders.termQuery("checkOrg", params.get("checkOrg")));
			}

			// // 登记机关
			// if
			// (!org.springframework.util.StringUtils.isEmpty(params.get("regOrg")))
			// {
			// List<String> regOrgList =
			// strToList(params.get("regOrg").toString());
			// qb.must(QueryBuilders.termsQuery("regOrg", regOrgList));
			// }
			// 成立日期
			if (!org.springframework.util.StringUtils.isEmpty(params.get("startEstDate"))
					|| !org.springframework.util.StringUtils.isEmpty(params.get("endEstDate"))) {
				RangeQueryBuilder rqb = QueryBuilders.rangeQuery("estDate");
				if (!org.springframework.util.StringUtils.isEmpty(params.get("startEstDate"))) {
					rqb.gte(DateUtil.stringToDate(params.get("startEstDate").toString(), "yyyy-MM-dd").getTime());
				}
				if (!org.springframework.util.StringUtils.isEmpty(params.get("endEstDate"))) {
					rqb.lte(DateUtil.stringToDate(params.get("endEstDate").toString(), "yyyy-MM-dd").getTime());
				}
				qb.must(rqb);
			}

			// 登记状态
			if (!org.springframework.util.StringUtils.isEmpty(params.get("regState"))) {
				qb.must(QueryBuilders.matchQuery("regState", params.get("regState")));
			}

			// // 企业类型
			// if
			// (!org.springframework.util.StringUtils.isEmpty(params.get("entType")))
			// {
			// List<String> entTypeList =
			// strToList(params.get("entType").toString());
			// qb.must(QueryBuilders.termsQuery("entType", entTypeList));
			// }

			// 联系电话
			if (!org.springframework.util.StringUtils.isEmpty(params.get("tel"))) {
				qb.must(QueryBuilders.termQuery("tel", params.get("tel")));
			}

			// 注册资本
			if (!org.springframework.util.StringUtils.isEmpty(params.get("startRegCap"))
					|| !org.springframework.util.StringUtils.isEmpty(params.get("endRegCap"))) {
				RangeQueryBuilder rqb = QueryBuilders.rangeQuery("regCap");
				if (!org.springframework.util.StringUtils.isEmpty(params.get("startRegCap"))) {
					rqb.gt(params.get("startRegCap"));
				}
				if (!org.springframework.util.StringUtils.isEmpty(params.get("endRegCap"))) {
					rqb.lt(params.get("endRegCap"));
				}
				qb.must(rqb);
			}

			// 片区
			if (!org.springframework.util.StringUtils.isEmpty(params.get("sliceNo"))) {
				List<String> sliceNoList = Arrays.asList(params.get("sliceNo").toString());
				qb.must(QueryBuilders.termsQuery("sliceNo", sliceNoList));
			}

			// 管辖单位
			if (!org.springframework.util.StringUtils.isEmpty(params.get("localAdm"))) {
				List<String> localAdmList = Arrays.asList(params.get("localAdm").toString());
				qb.must(QueryBuilders.termsQuery("localAdm", localAdmList));
			}

			// 年度
			if (!org.springframework.util.StringUtils.isEmpty(params.get("YEAR"))) {
				qb.must(QueryBuilders.matchQuery("YEAR", params.get("YEAR")));
			}
		}
		return qb;
	}

	/**
	 * 描述：根据企业名称查询企业基本信息
	 * 
	 * @author ylr
	 * @date 2016-10-23
	 * @throws Exception
	 */
	public MidBaseInfo selectEntByEntName(String entName) throws Exception {
		return midBaseInfoMapper.selectEntByEntName(entName);
	}

	/**
	 * 
	 * 描述 根据核准日期范围获取有审批事项的在册核准数据 @author 赵祥江 @date 2016年10月24日
	 * 上午10:49:37 @param @return List<MidBaseInfo> @throws
	 */
	@Override
	public List<MidBaseInfo> selectMidInfoByApprDate(Map<String, Object> params) {
		if (params != null) {
			params.put("regState", RegStateEnum.CUNXU.getParam());
		}
		return midBaseInfoMapper.selectMidInfoByApprDate(params);
	}

	/**
	 * 
	 * 描述 根据核准日期范围获取有审批事项的在册核准数据 @author 赵祥江 @date 2016年10月24日
	 * 上午10:49:37 @param @return List<MidBaseInfo> @throws
	 */
	@Override
	public List<MidBaseInfo> selectMidInfoDzByApprDate(Map<String, Object> params) {
		if (params != null) {
			params.put("regState", RegStateEnum.CUNXU.getParam());
		}
		return midBaseInfoMapper.selectMidInfoDzByApprDate(params);
	}

	/**
	 * 
	 * 描述 根据cerNo获取企业信息 @author 陈宇 @date 2016年10月24日 上午10:49:37 @param @return
	 * List<MidBaseInfo> @throws
	 * 
	 * @throws Exception
	 */
	@Override
	public List<MidBaseInfoDto> selectMidBaseInfoDtoListByCerNO(PageRequest request) throws Exception {
		// TODO Auto-generated method stub
		PageHelper.startPage(request.getPageNum(), request.getLength());
		Map<String, Object> paramsMap = request.getParams();
		return midBaseInfoMapper.selectMidBaseInfoDtoListByCerNO(handleParamsMap(paramsMap));
	}

	@Override
	public List<MidBaseInfoDto> doGetIncreList(int pageNum, int pageSize) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("pageNum", pageNum * pageSize);
		paramMap.put("pageSize", pageSize);
		paramMap.put("regState", RegStateEnum.ZHUXIAO.getParam());
		return midBaseInfoMapper.selectIndexIncreList(paramMap);
	}

	@Override
	public List<MidBaseInfoDto> doGetListById(int start) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("start", start);
		paramMap.put("end", start + 20000);
		paramMap.put("regState", RegStateEnum.ZHUXIAO.getParam());
		return midBaseInfoMapper.selectIndexListById(paramMap);
	}

	@Override
	public int getMaxId() {
		return midBaseInfoMapper.selectMaxId();
	}

	@Override
	public List<MidBaseInfoDto> doGetListByCondition(String condition) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("condition", condition);
		paramMap.put("regState", RegStateEnum.ZHUXIAO.getParam());
		return midBaseInfoMapper.selectListByCondition(paramMap);
	}

	/**
	 * 描述：根据多内部序号企业详情信息
	 * 
	 * @date 2016年12月22日
	 * @author ylr
	 * @param
	 * @return
	 */
	public List<MidBaseInfoDto> selectMidBaseInfoListByPriPIDS(Map<String, Object> qryMap) {
		return midBaseInfoMapper.selectMidBaseInfoListByPriPIDS(qryMap);
	}

	/**
	 * 描述：根据上传数据进行批量比对
	 * 
	 * @date 2016年12月10日
	 * @author ylr
	 * @param
	 * @return
	 */
	public Map<String, Object> doDepSynImportCompare(Sheet sheet, String fileName, HttpSession session) {
		List<MidBaseInfo> midBaseInfoList = new ArrayList<MidBaseInfo>();

		Row rowTitle = sheet.getRow(0);// 标题行
		if (!ExcelUtil.isValidCompare(rowTitle)) {
			return ExcelUtil.errMsgInfo(0, "批量比对表头错误", "");
		}
		int i = 1;
		Row row = sheet.getRow(i);// 创建ROW
		int rowNum = sheet.getLastRowNum();
		if (row == null) {
			return ExcelUtil.sucMsgInfo(fileName, 0, true);
		}
		try {
			while (row != null && i <= rowNum) {
				MidBaseInfoDto midBaseInfo = new MidBaseInfoDto();
				if (ExcelUtil.isBlankCell(row.getCell(0)) && ExcelUtil.isBlankCell(row.getCell(1))
						&& ExcelUtil.isBlankCell(row.getCell(2)))
					return ExcelUtil.errMsgInfo(i + 1, "【企业名称】、【注册号】、【统一社会信用代码】不能同时为空。", "");
				midBaseInfo.setEntName(ExcelUtil.parseCellValueToString(row.getCell(0)));// 企业名称
				midBaseInfo.setRegNO(ExcelUtil.parseCellValueToString(row.getCell(1)));// 注册号
				midBaseInfo.setUniCode(ExcelUtil.parseCellValueToString(row.getCell(2)));// 统一社会信用代码
				i++;
				row = sheet.getRow(i);
				midBaseInfoList.add(midBaseInfo);

			}
			session.setAttribute("compareList", midBaseInfoList);

		} catch (Exception e) {
			return ExcelUtil.errMsgInfo(i + 1, "数据格式错误", "");

		}

		return ExcelUtil.sucMsgInfo(fileName, midBaseInfoList.size(), true);

	}

	@Override
	public int doCountByApprDate(String apprDate) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("apprDate", apprDate);
		return midBaseInfoMapper.doCountByApprDate(paramMap);
	}

	@Override
	public List<MidBaseInfoDto> doGetListByApprDate(int pageNum, int pageSize, String apprDate) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("pageNum", pageNum * pageSize);
		paramMap.put("pageSize", pageSize);
		paramMap.put("apprDate", apprDate);
		paramMap.put("regState", RegStateEnum.ZHUXIAO.getParam());
		return midBaseInfoMapper.selectIndexListByApprDate(paramMap);
	}

	@Override
	public List<MidBaseInfoDto> doGetListByPriPID(String priPID) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("priPID", priPID);
		return midBaseInfoMapper.selectListByPriPID(paramMap);
	}

	/**
	 * 根据关键字精确查找实体信息
	 * 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<MidBaseInfo> selectMidInfoByKeyword(Map<String, Object> map) throws Exception {
		return midBaseInfoMapper.selectMidInfoByKeyword(map);
	}

	/**
	 * 描述：根据内容序号查询吊销日期
	 * 
	 * @date 2017年3月23日
	 * @author yujingwei
	 * @param condition
	 * @return Date
	 */
	public List<MidBaseInfoDto> selectPunishDate(String priPID) throws Exception {
		if (StringUtil.isEmpty(priPID)) {
			return null;
		}
		return midBaseInfoMapper.selectPunishDate(priPID);
	}

	@Override
	public List<MidBaseInfoDto> qryLimitObjRelEntList(PageRequest request) {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		if (request.getParams() != null) {
			Map<String, Object> params = request.getParams();
			if (params.get("notInPidList") != null && StringUtils.isNotEmpty(params.get("notInPidList").toString())) {
				String notInPidList = params.get("notInPidList").toString();
				if (notInPidList.split(",").length >= 1) {
					params.put("notInPidArr", notInPidList.split(","));
					params.remove("notInPidList");
				}
			}
		}
		return midBaseInfoMapper.selectLimitObjRelEntList(request.getParams());
	}

	@Override
	public List<MidBaseInfoDto> qryLimitRelEntObjList(PageRequest request) {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		if (request.getParams() != null) {
			Map<String, Object> params = request.getParams();
			if (params.get("notInPidList") != null && StringUtils.isNotEmpty(params.get("notInPidList").toString())) {
				String notInPidList = params.get("notInPidList").toString();
				if (notInPidList.split(",").length >= 1) {
					params.put("notInPidArr", notInPidList.split(","));
					params.remove("notInPidList");
				}
			}
		}
		return midBaseInfoMapper.selectLimitRelEntObjList(request.getParams());
	}

	/**
	 * 描述: 按内部序号查询企业基本信息
	 * 
	 * @throws Exception
	 * @auther yujingwei
	 * @date 2016年8月29日
	 * @param pripid
	 * @return MidBaseInfo
	 */
	public MidBaseInfo selectInfoByPriPID(String priPID) throws Exception {
		if (StringUtils.isNotEmpty(priPID)) {
			Example example = new Example(MidBaseInfo.class);
			example.createCriteria().andEqualTo("priPID", priPID);// 否
			List<MidBaseInfo> midbaseinfos = midBaseInfoMapper.selectByExample(example);
			if (midbaseinfos != null && midbaseinfos.size() > 0) {
				return midbaseinfos.get(0);
			} else {
				return null;
			}
		} else {
			return null;
		}
	}

	/**
	 * 
	 * 描述: 新增批量列入经营异常记录列表（企业、农专）
	 * 
	 * @auther gaojinling
	 * @date 2017年6月13日
	 * @param map
	 * @return
	 */
	public List<MidBaseInfoDto> selectBatchPubOpanomalyInAddList(PageRequest request) throws Exception {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		Map<String, Object> paramsMap = new HashMap<String, Object>();
		if (request.getParams() != null) {
			paramsMap = request.getParams();
		}
		paramsMap.put("regState", RegStateEnum.CUNXU.getParam());
		return midBaseInfoMapper.selectBatchPubOpanomalyInAddList(paramsMap);
	}

	/**
	 * 
	 * 描述: 新增批量列入经营异常记录列表（企业、农专不分页）
	 * 
	 * @auther gaojinling
	 * @date 2017年6月13日
	 * @param map
	 * @return
	 */
	public List<MidBaseInfoDto> selectBatchPubOpanomalyInAddListAll(Map<String, Object> map) throws Exception {
		return midBaseInfoMapper.selectBatchPubOpanomalyInAddList(map);
	}

	/**
	 * 描述: 处理参数
	 * 
	 * @auther ZhouYan
	 * @date 2017年7月26日
	 * @param paramsMap
	 * @return
	 * @throws Exception
	 */
	private Map<String, Object> handleParamsMap(Map<String, Object> paramsMap) throws Exception {
		if (paramsMap != null) {
			if (paramsMap.containsKey("regState")) {
				String regState = (String) paramsMap.get("regState");
				if (StringUtil.isNotEmpty(regState)) {
					String[] regStateList = regState.split(",");
					paramsMap.put("regState", regStateList);
				}
			}
		}
		return paramsMap;
	}

	/**
	 * 描述：根据企业名称/统一社会信用代码查询企业信息
	 * 
	 * @author 陈鑫
	 * @date 2017-09-14
	 * @param parmMap
	 * @return
	 */
	@Override
	public MidBaseInfoDto selectForDrandomByKeyword(Map<String, Object> parmMap) {
		List<MidBaseInfoDto> midBaseInfoDtoList = midBaseInfoMapper.selectForDrandomByKeyword(parmMap);
		if (CollectionUtils.isNotEmpty(midBaseInfoDtoList)) {
			return midBaseInfoDtoList.get(0);
		}
		return null;
	}

	/**
	 * 
	 * 描述 企信连联 专项查询 经营期限 -根据企业名称和信用代码获取企业信息 @author 赵祥江 @date 2017年10月10日
	 * 上午10:55:11 @param @return JSONObject @throws
	 */
	@Override
	public JSONObject getOperatingList(String keyword, String secretkey, int pageNo, int pageSize) throws Exception {
		JSONObject jsonObject = new JSONObject();
		String key = "asdfghjkl";
		try {
			// 校验口令
			if (StringUtil.isBlank(secretkey) || !secretkey.equals(key)) {
				jsonObject.put("responseCode", "0");
				jsonObject.put("responseMessage", "访问接口口令验证不通过");
				logger.error(jsonObject.getString("responseMessage"));
				return jsonObject;
			}
			List<Object> jsonObjList = new ArrayList<Object>();
			Map<String, Object> searchMap = new HashMap<String, Object>();
			// pageNo = StringUtil.isBlank(String.valueOf(pageNo)) ? 1:pageNo;
			// // 默认为0
			// pageSize = StringUtil.isBlank(String.valueOf(pageSize)) ?
			// 10:pageSize; // 默认为 10条每页
			searchMap.put("numStart", 0);
			searchMap.put("pageSize", 11);
			searchMap.put("keyword", keyword);
			searchMap.put("regState", RegStateEnum.CUNXU.getParam());
			List<MidBaseInfoDto> midBaseInfoDtoList = midBaseInfoMapper.selectOperatingList(searchMap);
			if (midBaseInfoDtoList != null && midBaseInfoDtoList.size() > 0) {
				for (MidBaseInfoDto midBaseInfoDto : midBaseInfoDtoList) {
					Map<String, Object> objMap = new HashMap<String, Object>();
					// 企业名称
					objMap.put("entName", midBaseInfoDto.getEntName() == null ? "" : midBaseInfoDto.getEntName());
					// 统一社会信用代码
					objMap.put("uniCode", midBaseInfoDto.getUniCode());
					objMap.put("priPID", midBaseInfoDto.getPriPID());
					// 企业状态
					objMap.put("regStateCn", midBaseInfoDto.getRegState() == null ? "0" : midBaseInfoDto.getRegState());
					// 经营期限
					objMap.put("opToDate", midBaseInfoDto.getOpTo() == null ? ""
							: DateUtil.formatDate(midBaseInfoDto.getOpTo(), "yyyy-MM-dd"));
					if (jsonObjList.size() == 10) {
						break;
					}
					jsonObjList.add(objMap);
				}
			}
			jsonObject.put("totalCount", midBaseInfoDtoList == null ? "0" : midBaseInfoDtoList.size());
			jsonObject.put("resultList", JSONArray.fromObject(jsonObjList));
			jsonObject.put("responseCode", "1");
			jsonObject.put("responseMessage", "查询成功");
		} catch (Exception e) {
			e.printStackTrace();
			jsonObject.put("responseCode", "0");
			jsonObject.put("responseMessage", "系统异常");
			logger.error(jsonObject.getString("responseMessage"), e);
		}
		return jsonObject;
	}

	/**
	 * 
	 * 描述 企信连联 专项查询 经营期限 -查询联络员旗下企业信息 @author 赵祥江 @date 2017年10月10日
	 * 上午10:54:43 @param @return JSONObject @throws
	 */
	@Override
	public JSONObject getOperatingListByTel(String tel, String keyword, String secretkey, String searchFlag)
			throws Exception {
		JSONObject jsonObject = new JSONObject();
		String key = "asdfghjkl";
		try {
			// 校验口令
			if (StringUtil.isBlank(secretkey) || !secretkey.equals(key)) {
				jsonObject.put("responseCode", "0");
				jsonObject.put("responseMessage", "访问接口口令验证不通过");
				logger.error(jsonObject.getString("responseMessage"));
				return jsonObject;
			}
			if (StringUtil.isBlank(tel)) {
				jsonObject.put("responseCode", "0");
				jsonObject.put("responseMessage", "联络员电话号码不能为空");
				logger.error(jsonObject.getString("responseMessage"));
				return jsonObject;
			}
			// 已到期
			List<Object> expiresList = new ArrayList<Object>();
			// 即将到期
			List<Object> imExpiresList = new ArrayList<Object>();
			// 有效期内
			List<Object> noExpiresList = new ArrayList<Object>();
			Map<String, Object> searchMap = new HashMap<String, Object>();
			// pageNo = StringUtil.isBlank(String.valueOf(pageNo)) ? 1:pageNo;
			// // 默认为0
			// pageSize = StringUtil.isBlank(String.valueOf(pageSize)) ?
			// 10:pageSize; // 默认为 10条每页
			searchMap.put("numStart", 0);
			searchMap.put("tel", tel);
			searchMap.put("pageSize", 99999);
			// 经营期限
			if (!"1".equals(searchFlag)) {
				searchMap.put("regState", RegStateEnum.CUNXU.getParam());
			}
			searchMap.put("keyword", keyword);
			List<MidBaseInfoDto> midBaseInfoDtoList = midBaseInfoMapper.selectOperatingListByTel(searchMap);
			if (midBaseInfoDtoList != null && midBaseInfoDtoList.size() > 0) {
				for (MidBaseInfoDto midBaseInfoDto : midBaseInfoDtoList) {
					// 到期日
					String opToDate = midBaseInfoDto.getOpTo() == null ? ""
							: DateUtil.formatDate(midBaseInfoDto.getOpTo(), "yyyy-MM-dd");
					String nowDate = DateUtil.getSysDate() == null ? ""
							: DateUtil.formatDate(DateUtil.getSysDate(), "yyyy-MM-dd");
					int days = DateUtil.getBetweenDays(nowDate, opToDate);
					Map<String, Object> expiresListMap = new HashMap<String, Object>();
					// 企业名称
					expiresListMap.put("entName",
							midBaseInfoDto.getEntName() == null ? "" : midBaseInfoDto.getEntName());
					// 统一社会信用代码
					expiresListMap.put("uniCode", midBaseInfoDto.getUniCode());
					// 企业状态
					expiresListMap.put("regStateCn",
							midBaseInfoDto.getRegState() == null ? "0" : midBaseInfoDto.getRegState());
					// 主体身份代码
					expiresListMap.put("priPID", midBaseInfoDto.getPriPID());
					// 我的企业
					if ("1".equals(searchFlag)) {
						expiresList.add(expiresListMap);
					} else {
						// 经营期限
						expiresListMap.put("opToDate", midBaseInfoDto.getOpTo() == null ? ""
								: DateUtil.formatDate(midBaseInfoDto.getOpTo(), "yyyy-MM-dd"));
						// 长期有效和有效期内
						if ("9999-09-09".equals(opToDate) || days >= 0) {
							noExpiresList.add(expiresListMap);
						}
						if (days >= 0 && days < 30) {// 即将到期
							imExpiresList.add(expiresListMap);
						}
						if (days < 0) {// 已到期
							expiresList.add(expiresListMap);
						}
					}
				}
			}

			// 我的企业
			if ("1".equals(searchFlag)) {
				jsonObject.put("resultList", JSONArray.fromObject(expiresList));
				jsonObject.put("totalCount", expiresList.size());
			} else {// 经营期限
				jsonObject.put("expiresList", JSONArray.fromObject(expiresList));
				jsonObject.put("imExpiresList", JSONArray.fromObject(imExpiresList));
				jsonObject.put("noExpiresList", JSONArray.fromObject(noExpiresList));
			}
			jsonObject.put("responseCode", "1");
			jsonObject.put("responseMessage", "查询成功");
		} catch (Exception e) {
			e.printStackTrace();
			jsonObject.put("responseCode", "0");
			jsonObject.put("responseMessage", "系统异常");
			logger.error(jsonObject.getString("responseMessage"), e);
		}
		return jsonObject;
	}

	@Override
	public int opDateSoonExpireNum(Map<String, Object> qryMap) {
		return midBaseInfoMapper.opDateSoonExpireNum(qryMap);
	}

	@Override
	public int opDateAlreadyExpireNum(Map<String, Object> qryMap) {
		return midBaseInfoMapper.opDateAlreadyExpireNum(qryMap);
	}

	@Override
	public List<MidBaseInfoDto> doGetHisEntNameList(int pageNum, int pageSize) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("pageNum", pageNum * pageSize);
		paramMap.put("pageSize", pageSize);
		return midBaseInfoMapper.selectHisEntNameList(paramMap);
	}
}