/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.other.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.common.constant.DBAuthorConstants;
import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.ext.mapper.MidBaseInfoMapper;
import com.icinfo.cs.ext.model.MidBaseInfo;
import com.icinfo.cs.im.mapper.ImPrmtaltMapper;
import com.icinfo.cs.im.model.ImPrmtalt;
import com.icinfo.cs.login.model.PubEppassword;
import com.icinfo.cs.login.service.IPubEppasswordService;
import com.icinfo.cs.other.dto.LicenceInvalidCount;
import com.icinfo.cs.other.dto.PubOtherlicenceDto;
import com.icinfo.cs.other.mapper.PubOtherlicenceHisMapper;
import com.icinfo.cs.other.mapper.PubOtherlicenceMapper;
import com.icinfo.cs.other.mapper.PubServerModrecordMapper;
import com.icinfo.cs.other.model.PubOtherlicence;
import com.icinfo.cs.other.model.PubOtherlicenceHis;
import com.icinfo.cs.other.model.PubServerModrecord;
import com.icinfo.cs.other.service.IPubOtherlicenceService;
import com.icinfo.cs.simpleesc.model.ErEscAppinfo;
import com.icinfo.cs.simpleesc.service.IErEscAppinfoService;
import com.icinfo.cs.system.model.SysUser;
import com.icinfo.cs.yr.mapper.PubOtherpunishMapper;
import com.icinfo.cs.yr.mapper.PubServerHisModMapper;
import com.icinfo.cs.yr.model.PubOtherpunish;
import com.icinfo.cs.yr.model.PubServerHisMod;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.mapper.entity.Example.Criteria;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述: cs_pub_otherlicence 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年10月18日
 */
@Service
public class PubOtherlicenceServiceImpl extends MyBatisServiceSupport implements IPubOtherlicenceService {
	/**
	 * 日志记录器
	 */
	private static final Logger logger = LoggerFactory.getLogger(PubOtherlicenceServiceImpl.class);

	@Autowired
	private PubOtherlicenceMapper pubOtherlicenceMapper;
	@Autowired
	private PubOtherlicenceHisMapper pubOtherlicenceHisMapper;
	@Autowired
	private PubServerHisModMapper pubServerHisModMapper;
	@Autowired
	private MidBaseInfoMapper midBaseInfoMapper;
	@Autowired
	private ImPrmtaltMapper imPrmtaltMapper;
	@Autowired
	private PubServerModrecordMapper pubServerModrecordMapper;
	@Autowired
	IPubEppasswordService pubEppasswordService;
	@Autowired
	IErEscAppinfoService erEscAppinfoService;
	@Autowired
	PubOtherpunishMapper pubOtherpunishMapper;

	@Override
	public List<PubOtherlicence> selectAll() {

		return pubOtherlicenceMapper.selectAll();
	}

	public List<PubOtherlicence> queryPubOtherlicenceList() {

		return null;
	}

	@Override
	public List<PubOtherlicenceDto> selectPubOtherlicenceByCation(PageRequest request) {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		Map<String, Object> map = request.getParams();
		if (map != null) {

			if (map.get("licState") != null && !map.get("licState").equals("")
					&& !map.get("licState").toString().equals("1")) {

				map.put("licStateType", "d");
				map.put("licState", null);
			}

			if (map.get("regOrg") != null && !map.get("regOrg").equals("")) {

				map.put("items", map.get("regOrg").toString().split(","));

			}
			if (map.get("localAdm") != null && !map.get("localAdm").equals("")) {
				map.put("localAdms", map.get("localAdm").toString().split(","));
			}
			if (map.get("entType") != null && !map.get("entType").equals("")) {
				map.put("entTypes", map.get("entType").toString().split(","));
			}
			if (map.get("sliceNO") != null && !map.get("sliceNO").equals("")) {
				map.put("sliceNOS", map.get("sliceNO").toString().split(","));
			}
		}

		return pubOtherlicenceMapper.selectPubOtherlicenceByCation(map);
	}

	@Override
	public int update(PubOtherlicence pubOtherlicence) {
		Example example = new Example(PubOtherlicence.class);
		example.createCriteria().andEqualTo("licID", pubOtherlicence.getLicID());
		return pubOtherlicenceMapper.updateByExampleSelective(pubOtherlicence, example);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public int alert(PubOtherlicence pubOtherlicence, String names, String changevalues, String originalValues,
			Date altDate) {
		String nameArray[] = names.split(",");
		String changeArray[] = changevalues.split(",");
		String original[] = originalValues.split(",");
		int result = 0;
		pubOtherlicence.setLicType("1");
		// pubOtherlicence.setLicState("1");
		Example example = new Example(PubOtherlicence.class);
		example.createCriteria().andEqualTo("licID", pubOtherlicence.getLicID());
		if (pubOtherlicenceMapper.updateByExampleSelective(pubOtherlicence, example) > 0) {
			for (int i = 0; i < nameArray.length; i++) {
				ImPrmtalt imPrmtalt = new ImPrmtalt();
				imPrmtalt.setAltItemContent(nameArray[i]);
				imPrmtalt.setAltBeContent(original[i]);
				imPrmtalt.setAltAfContent(changeArray[i]);
				imPrmtalt.setLicID(pubOtherlicence.getLicID());
				imPrmtalt.setCreateTime(new Date());
				imPrmtalt.setAltDate(altDate);
				result = imPrmtaltMapper.insert(imPrmtalt);
				if (result > 0) {// 保存记录
					PubServerModrecord pubServerModrecord = new PubServerModrecord();
					pubServerModrecord.setPriPID(pubOtherlicence.getPriPID());
					pubServerModrecord.setModUID(pubOtherlicence.getLicID());
					pubServerModrecord.setAltItem(nameArray[i]);
					pubServerModrecord.setAltBe(original[i]);
					pubServerModrecord.setAltAf(changeArray[i]);
					pubServerModrecord.setAltTable("cs_pub_otherlicence");
					pubServerModrecord.setHisNO(StringUtil.getRandomNumber(pubOtherlicence.getPriPID()));
					pubServerModrecord.setAltDate(altDate);
					pubServerModrecord.setCreateTime(new Date());
					result = pubServerModrecordMapper.insert(pubServerModrecord);
				}

			}
		}

		return result;
	}

	@Override
	public PubOtherlicence selectByOne(String licID) {
		PubOtherlicence pubOtherlicence = new PubOtherlicence();
		pubOtherlicence.setLicID(licID);
		return pubOtherlicenceMapper.selectOne(pubOtherlicence);
	}

	@Override
	public int insert(PubOtherlicence pubOtherlicence) {
		return pubOtherlicenceMapper.insert(pubOtherlicence);
	}

	@Override
	public int auditOtherlicence(PubOtherlicence pubOtherlicence) {
		int result = 0;
		Example example = new Example(PubOtherlicence.class);
		example.createCriteria().andEqualTo("licID", pubOtherlicence.getLicID());

		if (pubOtherlicence.getAuditState().equals("1")) {

			pubOtherlicence.setPubFlag("1");
		} else if (pubOtherlicence.getAuditState().equals("2")) {
			pubOtherlicence.setPubFlag("0");
		}
		result = pubOtherlicenceMapper.updateByExampleSelective(pubOtherlicence, example);

		if (result > 0) {
			example.createCriteria().andEqualTo("priPID", pubOtherlicence.getPriPID()).andEqualTo("licNO",
					pubOtherlicence.getLicNO());
			List<PubOtherlicence> licList = pubOtherlicenceMapper.selectByExample(example);
			result = doSaveHisLicence(licList);// 保存历史表
		}
		PubServerHisMod pubServerHisMod = new PubServerHisMod();
		if (pubOtherlicence.getPriPID() != null && !pubOtherlicence.getPriPID().equals("")) {
			pubServerHisMod.setHisNO(StringUtil.getRandomNumber(pubOtherlicence.getPriPID()));
		}
		pubServerHisMod.setPriPID(pubOtherlicence.getPriPID());
		pubServerHisMod.setAltDate(pubOtherlicence.getSetDate());
		pubServerHisMod.setAltName(pubOtherlicence.getSetName());
		pubServerHisMod.setAuditState(pubOtherlicence.getAuditState());
		pubServerHisMod.setAuditDate(pubOtherlicence.getAuditDate());
		pubServerHisMod.setAuditName(pubOtherlicence.getAuditName());
		pubServerHisMod.setModUID(pubOtherlicence.getLicNO());
		pubServerHisMod.setAltTable("cs_pub_otherlicence");
		result = pubServerHisModMapper.insert(pubServerHisMod);

		return result;
	}

	/**
	 * 
	 * 描述: 保存历史表方法
	 * 
	 * @auther ljx
	 * @date 2016年10月19日
	 * @param licList
	 * @return
	 */
	public int doSaveHisLicence(List<PubOtherlicence> licList) {
		int result = 0;
		if (licList != null && licList.size() > 0) {
			for (PubOtherlicence lic : licList) {
				PubOtherlicenceHis otherHis = doGetOtherHis(lic);
				result = pubOtherlicenceHisMapper.insert(otherHis);
			}
			return result;
		} else {
			return 1;
		}
	}

	/**
	 * 
	 * 描述: 转换方法
	 * 
	 * @auther ljx
	 * @date 2016年10月19日
	 * @param licence
	 * @return
	 */
	public PubOtherlicenceHis doGetOtherHis(PubOtherlicence licence) {
		PubOtherlicenceHis licenCeHis = new PubOtherlicenceHis();
		licenCeHis.setLicID(licence.getLicID());
		licenCeHis.setPriPID(licence.getPriPID());
		licenCeHis.setRegNO(licence.getRegNO());
		licenCeHis.setEntName(licence.getEntName());
		licenCeHis.setLicNameCN(licence.getLicNameCN());
		licenCeHis.setLicNO(licence.getLicNO());
		licenCeHis.setLicValFrom(licence.getLicValFrom());
		licenCeHis.setLicValTo(licence.getLicValTo());
		licenCeHis.setLicAnth(licence.getLicAnth());
		licenCeHis.setPubFlag(licence.getPubFlag());
		licenCeHis.setLicType(licence.getLicType());
		licenCeHis.setAltDate(licence.getAltDate());
		licenCeHis.setCanDate(licence.getCanDate());
		licenCeHis.setRevDate(licence.getRevDate());
		licenCeHis.setInvAlidDate(licence.getInvAlidDate());
		licenCeHis.setSetName(licence.getSetName());
		licenCeHis.setSetDate(licence.getSetDate());
		licenCeHis.setAuditName(licence.getAuditName());
		licenCeHis.setAuditDate(licence.getAuditDate());
		licenCeHis.setAuditState(licence.getAuditState());
		licenCeHis.setAuditOpin(licence.getAuditOpin());
		licenCeHis.setLicState(licence.getLicState());
		licenCeHis.setSetDeptname(licence.getSetDeptname());
		licenCeHis.setCreateTime(licence.getCreateTime());
		licenCeHis.setLicScope(licence.getLicScope());
		licenCeHis.setLicScope(licence.getLicScope());
		licenCeHis.setCanRea(licence.getCanRea());
		return licenCeHis;
	}

	/**
	 * 
	 * 描述: 双告知许可审批信息（分页查询）
	 * 
	 * @auther gaojinling
	 * @date 2016年10月19日
	 * @param request
	 * @return
	 */
	public List<PubOtherlicence> selectOtherlicenceListByPriPid(PageRequest request) {
		PageHelper.startPage(request.getPageNum(), request.getLength(), "setDate");
		Example example = new Example(PubOtherlicence.class);
		example.createCriteria().andEqualTo("priPID", request.getParams().get("priPID")).andEqualTo("pubFlag", "1");
		return pubOtherlicenceMapper.selectByExample(example);
	}

	@Override
	public List<PubOtherlicenceDto> selectImPrimitByCation(PageRequest request) {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		Map<String, Object> map = request.getParams();
		if (map != null) {
			if (map.get("regOrg") != null && !map.get("regOrg").equals("")) {

				map.put("items", map.get("regOrg").toString().split(","));

			}
			if (map.get("localAdm") != null && !map.get("localAdm").equals("")) {
				map.put("localAdms", map.get("localAdm").toString().split(","));
			}
			if (map.get("entType") != null && !map.get("entType").equals("")) {
				map.put("entTypes", map.get("entType").toString().split(","));
			}
			if (map.get("sliceNO") != null && !map.get("sliceNO").equals("")) {
				map.put("sliceNOS", map.get("sliceNO").toString().split(","));
			}
			if (map.get("setName") != null && !map.get("setName").equals("")) {// 如果是录入人员只查otherlicence
				map.put("pubFlag", "1");
				return pubOtherlicenceMapper.selectPubOtherlicenceByCation(map);
			}
			if (map.get("auditName") != null && !map.get("auditName").equals("")) {
				map.put("pubFlag", "1");

				return pubOtherlicenceMapper.selectPubOtherlicenceByCation(map);
			}

			if (map.get("licState") != null && !map.get("licState").equals("")) {// 如果是状态只查otherlicence
				map.put("pubFlag", "1");
				if (!map.get("licState").equals("1")) {
					map.put("licStateType", "0");
					map.put("licState", null);
				}
				return pubOtherlicenceMapper.selectPubOtherlicenceByCation(map);
			}

			if (map.get("auditDateStart") != null && !map.get("auditDateStart").equals("")) {// 如果是状态只查otherlicence
				map.put("pubFlag", "1");
				return pubOtherlicenceMapper.selectPubOtherlicenceByCation(map);
			}
			if (map.get("auditDateEnd") != null && !map.get("auditDateEnd").equals("")) {// 如果是状态只查otherlicence
				map.put("pubFlag", "1");
				return pubOtherlicenceMapper.selectPubOtherlicenceByCation(map);
			}

			if (map.get("setDateStart") != null && !map.get("setDateStart").equals("")) {// 如果是状态只查otherlicence
				map.put("pubFlag", "1");
				return pubOtherlicenceMapper.selectPubOtherlicenceByCation(map);
			}
			if (map.get("setDateEnd") != null && !map.get("setDateEnd").equals("")) {// 如果是状态只查otherlicence
				map.put("pubFlag", "1");
				return pubOtherlicenceMapper.selectPubOtherlicenceByCation(map);
			}

		}

		return pubOtherlicenceMapper.selectImPrimitByCation(map);
	}

	@Override
	public Map<String, Object> selectCountOtherLicence(PubOtherlicenceDto dto, Map<String, Object> qryMap)
			throws Exception {
		Map<String, Object> mp = new HashMap<String, Object>();
		Map<String, Object> map = dtoToMap(dto);
		// qryMap.get(DBAuthorConstants.PARAM_NAME_CHECK_DEP).toString()
		if (qryMap.containsKey(DBAuthorConstants.PARAM_NAME_CHECK_DEP)) {
			if (qryMap.containsKey(DBAuthorConstants.PARAM_EQ_VAL_NAME_CHECK_DEP)) {
				map.put(DBAuthorConstants.PARAM_EQ_VAL_NAME_CHECK_DEP,
						map.get(DBAuthorConstants.PARAM_EQ_VAL_NAME_CHECK_DEP));
			}
			if (qryMap.containsKey(DBAuthorConstants.PARAM_LIKE_VAL_CHECK_DEP)) {
				map.put(DBAuthorConstants.PARAM_EQ_VAL_NAME_CHECK_DEP,
						map.get(DBAuthorConstants.PARAM_EQ_VAL_NAME_CHECK_DEP));
			}
		}
		map.putAll(qryMap);
		mp.put("perMit", pubOtherlicenceMapper.selectCountPermit(map));
		mp.put("perMItDistinct", pubOtherlicenceMapper.selectCountPermitDistinct(map));
		if (StringUtils.isNotEmpty(dto.getSetName()) || StringUtils.isNotEmpty(dto.getAuditName())
				|| StringUtils.isNotEmpty(dto.getLicState()) || StringUtils.isNotEmpty(dto.getSetDateStart())
				|| StringUtils.isNotEmpty(dto.getSetDateEnd()) || StringUtils.isNotEmpty(dto.getAuditDateStart())
				|| StringUtils.isNotEmpty(dto.getAuditDateEnd())) {
			mp.put("perMit", "");
			mp.put("perMItDistinct", "");
		}

		mp.put("licence", pubOtherlicenceMapper.selectCountOtherLicence(map));
		mp.put("licenceDistinct", pubOtherlicenceMapper.selectCountOtherLicenceDistinct(map));
		return mp;
	}

	public Map<String, Object> dtoToMap(PubOtherlicenceDto dto) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("regNO", dto.getRegNO());
		map.put("licID", dto.getLicID());
		map.put("entName", dto.getEntName());
		map.put("licNameCN", dto.getLicNameCN());
		map.put("licNO", dto.getLicNO());
		map.put("licValFrom", DateUtil.dateToString(dto.getLicValFrom(), "yyyy-MM-dd"));
		map.put("licValTo", DateUtil.dateToString(dto.getLicValTo(), "yyyy-MM-dd"));
		map.put("licAnth", dto.getLicAnth());
		map.put("pubFlag", dto.getPubFlag());
		map.put("licType", dto.getLicType());
		map.put("altDate", DateUtil.dateToString(dto.getAltDate(), "yyyy-MM-dd"));
		map.put("canDate", DateUtil.dateToString(dto.getCanDate(), "yyyy-MM-dd"));
		map.put("revDate", DateUtil.dateToString(dto.getRevDate(), "yyyy-MM-dd"));
		map.put("invAlidDate", DateUtil.dateToString(dto.getInvAlidDate(), "yyyy-MM-dd"));
		map.put("invAliDRea", dto.getInvAliDRea());
		map.put("setName", dto.getSetName());
		map.put("setDate", dto.getSetDate());
		map.put("auditName", dto.getAuditName());
		map.put("auditDate", DateUtil.dateToString(dto.getAuditDate(), "yyyy-MM-dd"));
		map.put("auditOpin", dto.getAuditOpin());
		map.put("licState", dto.getLicState());
		if (StringUtils.isNotEmpty(dto.getLicState()) && !dto.getLicState().equals("1")) {
			map.put("licStateType", "0");
			map.put("licState", null);
		}
		map.put("setDeptname", dto.getSetDeptname());
		map.put("createTime", DateUtil.dateToString(dto.getCreateTime(), "yyyy-MM-dd"));
		map.put("licScope", dto.getLicScope());
		map.put("canRea", dto.getCanRea());
		map.put("revRea", dto.getRevRea());
		map.put("setDateStart", dto.getSetDateStart());
		map.put("setDateEnd", dto.getSetDateEnd());
		map.put("auditDateStart", dto.getAuditDateStart());
		map.put("auditDateEnd", dto.getAuditDateEnd());
		map.put("leRep", dto.getLeRep());
		map.put("licValFromStart", dto.getLicValFromStart());
		map.put("licValFromEnd", dto.getLicValFromEnd());
		map.put("licValToStart", dto.getLicValToStart());
		map.put("licValToEnd", dto.getLicValToEnd());
		map.put("items", StringUtil.isEmpty(dto.getRegOrg()) ? "" : dto.getRegOrg().toString().split(","));
		map.put("localAdms", StringUtil.isEmpty(dto.getLocalAdm()) ? "" : dto.getLocalAdm().toString().split(","));
		map.put("entTypes", StringUtil.isEmpty(dto.getEntType()) ? "" : dto.getEntType().toString().split(","));
		map.put("sliceNOS", StringUtil.isEmpty(dto.getSliceNO()) ? "" : dto.getSliceNO().toString().split(","));
		return map;

	}

	/**
	 * 
	 * 描述: 双告知许可审批信息2（分页查询）
	 * 
	 * @auther chenyu
	 * @date 2016年10月19日
	 * @param request
	 * @return
	 */
	public List<PubOtherlicence> selectOtherlicenceListByPriPid2(PageRequest request) {
		PageHelper.startPage(request.getPageNum(), request.getLength(), "setDate");
		Example example = new Example(PubOtherlicence.class);
		example.createCriteria().andEqualTo("priPID", request.getParams().get("priPID"));
		example.createCriteria().andEqualTo("licState", "1");
		return pubOtherlicenceMapper.selectByExample(example);
	}

	@Override
	public int saveOhterLicence(PubOtherlicence pubOtherlicence) {
		pubOtherlicence.setCreateTime(new Date());

		return pubOtherlicenceMapper.insert(pubOtherlicence);
	}

	@Override
	public int deleteByLicID(String licID) {
		PubOtherlicence pubOtherlicence = new PubOtherlicence();
		pubOtherlicence.setLicID(licID);
		return pubOtherlicenceMapper.delete(pubOtherlicence);
	}

	/**
	 * 查询数据列表
	 *
	 * @author：wangjin
	 * @param request
	 * @return
	 */
	@Override
	public List<PubOtherlicenceDto> select_queryPage(PageRequest request) {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		return pubOtherlicenceMapper.selectPubOtherlicenceForPub(request.getParams());

	}

	@Override
	public List<PubOtherlicence> selectOtherlicencesByPriPid(String priPID) {
		if (StringUtil.isEmpty(priPID))
			return null;
		PubOtherlicence pubOtherlicence = new PubOtherlicence();
		pubOtherlicence.setPriPID(priPID);
		pubOtherlicence.setAuditState("1");
		// pubOtherlicence.setLicState("1");
		return pubOtherlicenceMapper.select(pubOtherlicence);
	}

	@Override
	public List<MidBaseInfo> queryMidBasePageForOtherAdd(PageRequest request) throws Exception {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		Map<String, Object> map = request.getParams();
		if (map != null) {
			if (map.get("regOrg") != null && !map.get("regOrg").toString().equals("")) {
				map.put("regOrgs", map.get("regOrg").toString().split(","));
			}
			if (map.get("entTypeCode") != null && !map.get("entTypeCode").toString().equals("")) {
				map.put("entTypes", map.get("entTypeCode").toString().split(","));
			}
			if (map.get("localAdm") != null && !map.get("localAdm").toString().equals("")) {
				map.put("localAdms", map.get("localAdm").toString().split(","));
			}
			if (map.get("sliceNO") != null && !map.get("sliceNO").toString().equals("")) {
				map.put("sliceNOs", map.get("sliceNO").toString().split(","));
			}

			if (map.get("industryCo") != null && !map.get("industryCo").toString().equals("")) {
				map.put("industryCos", map.get("industryCo").toString().split(","));
			}

		}

		return midBaseInfoMapper.selectMidInfoForOtherAdd(map);

	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public Map<String, String> importByExcel(List<List<Object>> list, HttpSession session) throws Exception {
		int result = 0;
		Map<String, String> resultMap = new HashMap<String, String>();

		SysUser sysUser = (SysUser) session.getAttribute(Constants.SESSION_SYS_USER);
		PubOtherlicence otherlicence = new PubOtherlicence();
		otherlicence.setSetDate(new Date());// 录入时间
		otherlicence.setSetName(sysUser.getRealName());// 录入人

		otherlicence.setSetDeptname(sysUser.getDeptCode());// 录入部门id

		otherlicence.setAuditState("0");// 设置待审核
		otherlicence.setAuditOpin(null);// 审核意见
		otherlicence.setAuditName(null);// 审核人姓名
		otherlicence.setAuditDate(null);// 审核时间
		otherlicence.setPubFlag("0");// 设置未公示
		otherlicence.setLicState("1");// 默认有效
		otherlicence.setCreateTime(new Date());
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < list.size(); i++) {

			List<Object> lo = list.get(i);
			MidBaseInfo bas = new MidBaseInfo();
			if (StringUtils.isEmpty(String.valueOf(lo.get(0)).trim())) {// 如果注册号为空则不保存
				continue;
			}
			PubOtherlicence record = new PubOtherlicence();
			record.setRegNO(String.valueOf(lo.get(0)).trim());
			record.setEntName(String.valueOf(lo.get(1)).trim());
			record.setLicNO(String.valueOf(lo.get(2)));
			record.setLicNameCN(String.valueOf(lo.get(3)).trim());
			List<PubOtherlicence> listLicence = pubOtherlicenceMapper.select(record);
			if (listLicence != null && listLicence.size() > 0) {
				continue;
			}

			bas.setRegNO(String.valueOf(lo.get(0)));
			MidBaseInfo baseIfo = getBaseInfoByUniIDOrRegNO(lo.get(0).toString());// 查询其主体信息，活动主体id(pirPID)
			if (baseIfo == null || baseIfo.getPriPID().equals("")) {
				buffer.append(lo.get(0).toString()).append(",");
				continue;
			} else {
				otherlicence.setPriPID(baseIfo.getPriPID());
			}
			if (lo.size() > 0) {
				otherlicence.setRegNO(String.valueOf(lo.get(0)));
			}
			if (lo.size() > 1) {
				otherlicence.setEntName(String.valueOf(lo.get(1)));
			}
			if (lo.size() > 2) {
				otherlicence.setLicNO(String.valueOf(lo.get(2)));
			}
			if (lo.size() > 3) {
				otherlicence.setLicNameCN(String.valueOf(lo.get(3)));
			}
			if (lo.size() > 4) {
				otherlicence.setLicValFrom(DateUtil.stringToDate(String.valueOf(lo.get(4)), "yyyy-MM-dd"));
			}
			if (lo.size() > 5) {
				otherlicence.setLicValTo(DateUtil.stringToDate(String.valueOf(lo.get(5)), "yyyy-MM-dd"));
			}
			if (lo.size() > 6) {
				otherlicence.setLicAnth(String.valueOf(lo.get(6)));
			}
			if (lo.size() > 7) {
				otherlicence.setLicScope(String.valueOf(lo.get(7)));
			}
			result = pubOtherlicenceMapper.insertSelective(otherlicence);
		}
		resultMap.put("result", String.valueOf(result));
		resultMap.put("regNO", buffer.toString());
		return resultMap;
	}

	/**
	 * 获取索引所需要的许可数据
	 */
	@Override
	public List<Map<String, Object>> selectOtherlicencesMaps(Map<String, Object> qryMap) throws Exception {
		List<PubOtherlicence> list = pubOtherlicenceMapper.selectOtherlicencesList(qryMap);
		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < list.size(); i++) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("priPID", list.get(i).getPriPID());
			map.put("licNameAft", list.get(i).getLicNameCN());
			mapList.add(map);
		}
		return mapList;
	}

	/**
	 * 
	 * @param code
	 * @return
	 * @author ljx
	 */
	@Override
	public MidBaseInfo getBaseInfoByUniIDOrRegNO(String code) {
		Example example = new Example(MidBaseInfo.class);
		Criteria criteria = example.createCriteria();
		criteria.andEqualTo("regNO", code);
		Criteria criteria2 = example.createCriteria();
		criteria2.andEqualTo("uniCode", code);
		example.or(criteria2);
		List<MidBaseInfo> list = midBaseInfoMapper.selectByExample(example);
		if (list != null && list.size() > 0) {
			return list.get(0);
		} else {
			return null;
		}

	}

	@Override
	public List<PubOtherlicenceDto> selectOtherlicenceListByPriPID(String priPID) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("priPID", priPID);
		return pubOtherlicenceMapper.selectOtherlicenceListByPriPID(map);
	}

	@Override
	public int foodExpireNum(Map<String, Object> qryMap) {
		return pubOtherlicenceMapper.foodExpireNum(qryMap);
	}

	@Override
	public int drugsExpireNum(Map<String, Object> qryMap) {
		return pubOtherlicenceMapper.drugsExpireNum(qryMap);
	}

	@Override
	public List<PubOtherlicenceDto> selectLicenceInvalidMgrJSON(PageRequest request) {
		Map<String, Object> params = request.getParams();
		String regState = params.get("regState").toString();
		regState = StringUtil.doSplitStringToSqlFormat(regState, ",");
		params.put("regState", regState);
		PageHelper.startPage(request.getPageNum(), request.getLength());
		List<PubOtherlicenceDto> pubOtherlicenceDtoList = pubOtherlicenceMapper.selectLicenceInvalidMgrJSON(params);
		for (PubOtherlicenceDto pubOtherlicenceDto : pubOtherlicenceDtoList) {
			PubEppassword pubEppassword = pubEppasswordService
					.selectPubEppasswordByPriPid(pubOtherlicenceDto.getPriPID());
			if (pubEppassword != null) {
				pubOtherlicenceDto.setLiaName(pubEppassword.getLianame());
				pubOtherlicenceDto.setLiaTel(pubEppassword.getTel());
			}

			// 查询简易注销情况
			ErEscAppinfo erEscAppinfo = erEscAppinfoService.getErEscAppinfoByPriPID(pubOtherlicenceDto.getPriPID());
			if (erEscAppinfo != null) {
				if (erEscAppinfo.getNoticeTo() != null && erEscAppinfo.getNoticeTo().getTime() > new Date().getTime()
						&& !"5".equals(erEscAppinfo.getSimplecanRea())) {
					pubOtherlicenceDto.setIsSimpleCancle("1");
				} else {
					pubOtherlicenceDto.setIsSimpleCancle("0");
				}
			} else {
				pubOtherlicenceDto.setIsSimpleCancle("0");
			}
		}
		return pubOtherlicenceDtoList;
	}

	@Override
	public LicenceInvalidCount queryLicenceInvalidCount(PageRequest request) {
		Map<String, Object> params = request.getParams();
		String regState = params.get("regState").toString();
		regState = StringUtil.doSplitStringToSqlFormat(regState, ",");
		params.put("regState", regState);
		return pubOtherlicenceMapper.selectLicenceInvalidCount(params);
	}

	/**
	 * 
	 * 描述   根据设置部门名称删除 
	 * @author 赵祥江
	 * @date 2017年11月20日 下午4:02:04 
	 * @param 
	 * @return int
	 * @throws
	 */
	@Override
	public int deletePubOtherlicenceBySetDeptName(Map<String,Object> qMap)
			throws Exception {
		if(qMap!=null&&StringUtil.isNotBlank(qMap.get("stateType")+"")){
			String stateType=qMap.get("stateType").toString();
			if("1".equals(stateType)){//行政许可 政务网
				PubOtherlicence pubOtherlicence = new PubOtherlicence();
				pubOtherlicence.setSetDeptname("政务网");
				return pubOtherlicenceMapper.delete(pubOtherlicence);
			}
			if("2".equals(stateType)){//行政处罚  政务网
				PubOtherpunish pubOtherpunish=new PubOtherpunish();
				pubOtherpunish.setSetDeptname("政务网");
				return pubOtherpunishMapper.delete(pubOtherpunish);
			}
			if("3".equals(stateType)){//行政处罚 总局下发
				PubOtherpunish pubOtherpunish=new PubOtherpunish();
				pubOtherpunish.setSetDeptname("总局下发");
				return pubOtherpunishMapper.delete(pubOtherpunish);
			}
		}
		return 0; 
	}
}