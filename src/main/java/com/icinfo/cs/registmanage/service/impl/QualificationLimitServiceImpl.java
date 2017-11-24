/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.registmanage.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icinfo.cs.base.model.CsMidLerep;
import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.ext.mapper.MidLeRepMapper;
import com.icinfo.cs.ext.model.MidLeRep;
import com.icinfo.cs.registmanage.dto.QualificationLimitDto;
import com.icinfo.cs.registmanage.mapper.QualificationLimitMapper;
import com.icinfo.cs.registmanage.model.QualificationLimit;
import com.icinfo.cs.registmanage.service.IQualificationLimitService;
import com.icinfo.framework.core.exception.BusinessException;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.tools.utils.DateUtils;

/**
 * 描述: cs_qualification_limit 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年11月04日
 */
@Service
public class QualificationLimitServiceImpl extends MyBatisServiceSupport implements IQualificationLimitService {
	private static final Logger logger = LoggerFactory.getLogger(QualificationLimitServiceImpl.class);
	@Autowired
	private QualificationLimitMapper qualificationLimitMapper;
	@Autowired
	private MidLeRepMapper midLeRepMapper;

	/**
	 * 描述:获取任职资格限制管理列表
	 *
	 * @throws Exception
	 * @auther ylr
	 * @date 2016年11月6日
	 */
	public List<QualificationLimitDto> selectQualificationLimitList(PageRequest request) throws Exception {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		return qualificationLimitMapper.selectQualificationLimitList(request.getParams());
	}

	/**
	 * 描述:提前解除限制
	 *
	 * @throws Exception
	 * @auther ylr
	 * @date 2016年11月6日
	 */
	public Integer updateByUid(QualificationLimitDto qualificationLimitDto) throws Exception {
		Example example = new Example(QualificationLimit.class);
		if (StringUtils.isBlank(qualificationLimitDto.getUid()))
			return -1;
		example.createCriteria().andEqualTo("uid", qualificationLimitDto.getUid());
		return qualificationLimitMapper.updateByExampleSelective(qualificationLimitDto, example);
	}

	/**
	 * 描述:判断法人是否受限
	 * 
	 * @throws Exception
	 * @auther yujingwei
	 * @date 2017年3月22日
	 */
	public List<QualificationLimit> selectLimitPersonInfo(String priPID) throws Exception {
		Example example = new Example(CsMidLerep.class);
		example.createCriteria().andEqualTo("priPID", priPID);
		List<MidLeRep> cerNOs = midLeRepMapper.selectByExample(example);
		if (cerNOs != null && cerNOs.size() > 0) {
			Map<String, Object> qrymap = new HashMap<String, Object>();
			qrymap.put("certNO", cerNOs.get(0).getCerNO());
			qrymap.put("noLimitTime", DateUtil.getCurrentDate());
			return qualificationLimitMapper.selectLimitPersonInfo(qrymap);
		}
		return null;
	}

	/**
	 * 描述:通过uid查询受限黑名单信息
	 * 
	 * @throws Exception
	 * @auther yujingwei
	 * @param uid
	 * @date 2017年3月22日
	 */
	public QualificationLimit selectQualificationLimitInfoByUid(String uid) throws Exception {
		if (StringUtils.isEmpty(uid)) {
			return null;
		}
		QualificationLimit limitInfo = new QualificationLimit();
		limitInfo.setUid(uid);
		return qualificationLimitMapper.selectOne(limitInfo);
	}

	/**
	 * 描述:获取任职资格黑名单查询列表
	 * 
	 * @auther chenxin
	 * @date 2017年03月22日
	 * @param request
	 * @return
	 */
	@Override
	public List<QualificationLimitDto> selectRightLimitList(PageRequest request) {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		Map<String, Object> params = request.getParams();
		if (params != null) {
			String limitType = "";
			if (params.get("limitType") != null && StringUtils.isNotEmpty(params.get("limitType").toString())) {
				limitType = params.get("limitType").toString();
				if (limitType.split(",").length >= 1) {
					params.put("limitTypeArr", limitType.split(","));
					params.remove("limitType");
				}
			}
			if (params.get("limitDateEnd") != null && StringUtils.isNotEmpty(params.get("limitDateEnd").toString())) {
				String limitDateEnd = params.get("limitDateEnd").toString();
				params.put("limitDateEnd", limitDateEnd + " " + "23:59:59");
			}
			if (params.get("freeState") != null && StringUtils.isNotEmpty(params.get("freeState").toString())) {
				String freeState = params.get("freeState").toString();
				String date = DateUtil.getCurrentDate();
				if ("2".equals(freeState)) {
					if (StringUtils.isEmpty(limitType)
							|| (StringUtils.isNotEmpty(limitType) && limitType.indexOf("1") != -1)) {// 失信被执行人，未解除状态,特殊处理数据库"0000-00-00"的数据
						params.put("freeState2", "1");
					}
					params.put("auditState", "1");
					// params.put("noLimitTimeStart",date);
				} else if ("1".equals(freeState)) {
					if (StringUtils.isEmpty(limitType)
							|| (StringUtils.isNotEmpty(limitType) && limitType.indexOf("1") != -1)) {// 失信被执行人，未解除状态,特殊处理数据库"0000-00-00"的数据
						params.put("freeState1", "1");
					}
					params.put("noLimitTimeEnd", date + " " + "23:59:59");
				}
			}
		}
		return qualificationLimitMapper.selectRightLimitList(request.getParams());
	}

	@Override
	public List<QualificationLimitDto> selectLimitObjList(PageRequest request) {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		Map<String, Object> params = request.getParams();
		if (params != null) {
			if (params.get("freeState") != null && StringUtils.isNotEmpty(params.get("freeState").toString())) {
				String freeState = params.get("freeState").toString();
				String date = DateUtil.getCurrentDate();
				if ("2".equals(freeState)) {// 已解除
					params.put("auditState", "1");
					params.put("noLimitTimeStart", date + " " + "23:59:59");
				} else if ("1".equals(freeState)) {// 未解除
					params.put("noLimitTimeEnd", date + " " + "23:59:59");
				} else {
					//
				}
			}
		}
		return qualificationLimitMapper.selectLimitObjList(request.getParams());
	}

	@Override
	public List<QualificationLimitDto> selectlimitRelEntList(PageRequest request) {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		Map<String, Object> params = request.getParams();
		if (params != null) {
			if (params.get("freeState") != null && StringUtils.isNotEmpty(params.get("freeState").toString())) {
				String freeState = params.get("freeState").toString();
				String date = DateUtil.getCurrentDate();
				if ("2".equals(freeState)) {// 已解除
					params.put("auditState", "1");
					params.put("noLimitTimeStart", date + " " + "23:59:59");
				} else if ("1".equals(freeState)) {// 未解除
					params.put("noLimitTimeEnd", date + " " + "23:59:59");
				} else {
					//
				}
			}
		}
		String lerep = (String) params.get("lerep");
		String member = (String) params.get("member");
		if ("1".equals(lerep) && StringUtil.isEmpty(member)) {
			params.put("name", "1");
		} else if (StringUtil.isEmpty(lerep) && "1".equals(member)) {
			params.put("name", "2");
		}
		return qualificationLimitMapper.selectlimitRelEntList(params);
	}

	/**
	 * 描述：获取限制原因企业数量
	 * 
	 * @auther chenxin
	 * @date 2017年03月22日
	 * @param map
	 * @return
	 */
	@Override
	public int selectEntTotal(Map<String, Object> map) {
		return qualificationLimitMapper.selectEntTotal(map);
	}

	/**
	 * 描述：获取限制对象人数
	 * 
	 * @auther chenxin
	 * @date 2017年03月22日
	 * @param map
	 * @return
	 */
	@Override
	public int selectPersonTotal(Map<String, Object> map) {
		return qualificationLimitMapper.selectPersonTotal(map);
	}

	/**
	 * 描述:获取任职资格黑名单查询pripid List
	 * 
	 * @auther chenxin
	 * @date 2017年03月22日
	 * @param qryMap
	 * @return
	 */
	@Override
	public List<String> selectRightPriPIDList(Map<String, Object> qryMap) {
		return qualificationLimitMapper.selectRightPriPIDList(qryMap);
	}

	/**
	 * 
	 * 描述: 获取提前限制资格列表
	 * 
	 * @auther gaojinling
	 * @date 2017年4月6日
	 * @param qryMap
	 * @return
	 */
	public List<QualificationLimitDto> selectRemoveLimitList(PageRequest request) {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		Map<String, Object> params = request.getParams();
		if (params != null) {
			if (params.get("limitType") != null && StringUtils.isNotEmpty(params.get("limitType").toString())) {
				String limitType = params.get("limitType").toString();
				if (limitType.indexOf(",") > -1) {// 查询的为全部
					params.remove("limitType");
				} else {// 查询的为单个
					params.remove("removelimitflag");
				}
			}
		}
		return qualificationLimitMapper.selectRemoveLimitList(request.getParams());
	}

	@Override
	public int qryLimitObjCount(Map<String, Object> params) {
		if (params != null) {
			if (params.get("freeState") != null && StringUtils.isNotEmpty(params.get("freeState").toString())) {
				String freeState = params.get("freeState").toString();
				String date = DateUtil.getCurrentDate();
				if ("2".equals(freeState)) {// 已解除
					params.put("auditState", "1");
					params.put("noLimitTimeStart", date + " " + "23:59:59");
				} else if ("1".equals(freeState)) {// 未解除
					params.put("noLimitTimeEnd", date + " " + "23:59:59");
				} else {
					//
				}
			}
		}
		return qualificationLimitMapper.selectLimitObjCount(params);
	}

	@Override
	public int qryRelEntCount(Map<String, Object> params) {
		if (params != null) {
			if (params.get("freeState") != null && StringUtils.isNotEmpty(params.get("freeState").toString())) {
				String freeState = params.get("freeState").toString();
				String date = DateUtil.getCurrentDate();
				if ("2".equals(freeState)) {// 已解除
					params.put("auditState", "1");
					params.put("noLimitTimeStart", date + " " + "23:59:59");
				} else if ("1".equals(freeState)) {// 未解除
					params.put("noLimitTimeEnd", date + " " + "23:59:59");
				} else {
					//
				}
			}
		}
		return qualificationLimitMapper.selectRelEntCount(params);
	}

	@Override
	public int qryLimitObjCountByEnt(Map<String, Object> params) {
		if (params != null) {
			if (params.get("freeState") != null && StringUtils.isNotEmpty(params.get("freeState").toString())) {
				String freeState = params.get("freeState").toString();
				String date = DateUtil.getCurrentDate();
				if ("2".equals(freeState)) {// 已解除
					params.put("auditState", "1");
					params.put("noLimitTimeStart", date + " " + "23:59:59");
				} else if ("1".equals(freeState)) {// 未解除
					params.put("noLimitTimeEnd", date + " " + "23:59:59");
				} else {
					//
				}
			}
		}
		String lerep = (String) params.get("lerep");
		String member = (String) params.get("member");
		if ("1".equals(lerep) && StringUtil.isEmpty(member)) {
			params.put("name", "1");
		} else if (StringUtil.isEmpty(lerep) && "1".equals(member)) {
			params.put("name", "2");
		}
		return qualificationLimitMapper.selectLimitObjCountByEnt(params);
	}

	@Override
	public int qryRelEntCountByEnt(Map<String, Object> params) {
		if (params != null) {
			if (params.get("freeState") != null && StringUtils.isNotEmpty(params.get("freeState").toString())) {
				String freeState = params.get("freeState").toString();
				String date = DateUtil.getCurrentDate();
				if ("2".equals(freeState)) {// 已解除
					params.put("auditState", "1");
					params.put("noLimitTimeStart", date + " " + "23:59:59");
				} else if ("1".equals(freeState)) {// 未解除
					params.put("noLimitTimeEnd", date + " " + "23:59:59");
				} else {
					//
				}
			}
		}
		String lerep = (String) params.get("lerep");
		String member = (String) params.get("member");
		if ("1".equals(lerep) && StringUtil.isEmpty(member)) {
			params.put("name", "1");
		} else if (StringUtil.isEmpty(lerep) && "1".equals(member)) {
			params.put("name", "2");
		}
		return qualificationLimitMapper.selectRelEntCountByEnt(params);
	}

	/**
	 * 
	 * 描述: 删除（通过uid）
	 * 
	 * @auther gaojinling
	 * @date 2017年4月10日
	 * @param uid
	 * @return
	 * @throws Exception
	 */
	public int delete(String uid) throws Exception {
		try {
			if (StringUtils.isNotEmpty(uid)) {
				QualificationLimit qualificationLimit = new QualificationLimit();
				qualificationLimit.setUid(uid);
				return qualificationLimitMapper.delete(qualificationLimit);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException("根据主键uid删除限制申请信息失败!");
		}
		return 0;
	}

	/**
	 * 
	 * 描述: 获取单个限制资格对象（未分页）
	 * 
	 * @auther gaojinling
	 * @date 2017年4月10日
	 * @param map
	 * @return
	 */
	public QualificationLimitDto selectQualificationLimitDtoByUid(Map<String, Object> map) {
		List<QualificationLimitDto> qualificationLimitDtos = qualificationLimitMapper.selectRemoveLimitList(map);
		if (qualificationLimitDtos != null && qualificationLimitDtos.size() > 0) {
			return qualificationLimitDtos.get(0);
		} else {
			return null;
		}

	}

	/**
	 * 
	 * 描述: 修改
	 * 
	 * @auther gaojinling
	 * @date 2017年4月10日
	 * @param qualificationLimit
	 * @return
	 * @throws Exception
	 */
	public int update(QualificationLimit qualificationLimit) throws Exception {
		try {
			if (qualificationLimit != null && StringUtils.isNotEmpty(qualificationLimit.getUid())) {
				// 时间戳
				qualificationLimit.setCreateTime(DateUtils.getSysDate());
				Example example = new Example(QualificationLimit.class);
				example.createCriteria().andEqualTo("uid", qualificationLimit.getUid()).andEqualTo("priPID",
						qualificationLimit.getPriPID());
				return qualificationLimitMapper.updateByExampleSelective(qualificationLimit, example);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException("根据uid修改限制申请信息失败!");
		}
		return 0;
	}

	/**
	 * 
	 * 描述: 获取提前解除限制查询 限制对象人数
	 * 
	 * @auther gaojinling
	 * @date 2017年4月13日
	 * @param map
	 * @return
	 */
	public int selectRemovePripidTotal(Map<String, Object> map) {
		return qualificationLimitMapper.selectRemovePripidTotal(map);
	}

	/**
	 * 
	 * 描述: 修改(更新包括属性值为NUll的数据)
	 * 
	 * @auther gaojinling
	 * @date 2017年4月10日
	 * @param qualificationLimit
	 * @return
	 * @throws Exception
	 */
	public int updateByNull(QualificationLimit qualificationLimit) throws Exception {
		try {
			if (qualificationLimit != null && StringUtils.isNotEmpty(qualificationLimit.getUid())) {
				// 时间戳
				qualificationLimit.setCreateTime(DateUtils.getSysDate());
				Example example = new Example(QualificationLimit.class);
				example.createCriteria().andEqualTo("uid", qualificationLimit.getUid()).andEqualTo("priPID",
						qualificationLimit.getPriPID());
				return qualificationLimitMapper.updateByExample(qualificationLimit, example);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException("根据uid修改限制申请信息失败!");
		}
		return 0;
	}

	/**
	 * 
	 * 描述: 获取提前解除限制查询 限制对象人数
	 * 
	 * @auther gaojinling
	 * @date 2017年4月13日
	 * @param map
	 * @return
	 */
	public int selectRemoveClientNameTotal(Map<String, Object> map) {
		return qualificationLimitMapper.selectRemoveClientNameTotal(map);
	}

	@Override
	public List<QualificationLimitDto> selectLimitObjDetailList(PageRequest request) {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		Map<String, Object> params = request.getParams();
		if (params != null) {
			if (params.get("freeState") != null && StringUtils.isNotEmpty(params.get("freeState").toString())) {
				String freeState = params.get("freeState").toString();
				String date = DateUtil.getCurrentDate();
				if ("2".equals(freeState)) {// 已解除
					params.put("auditState", "1");
					params.put("noLimitTimeStart", date + " " + "23:59:59");
				} else if ("1".equals(freeState)) {// 未解除
					params.put("noLimitTimeEnd", date + " " + "23:59:59");
				} else {
					//
				}
			}
		}
		return qualificationLimitMapper.selectLimitObjDetailList(request.getParams());
	}

	@Override
	public List<QualificationLimit> selectlimiterRelEntList(PageRequest request) {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		Map<String, Object> params = request.getParams();
		String lerep = (String) params.get("lerep");
		String member = (String) params.get("member");
		if ("1".equals(lerep) && StringUtil.isEmpty(member)) {
			params.put("name", "1");
		} else if (StringUtil.isEmpty(lerep) && "1".equals(member)) {
			params.put("name", "2");
		} else {
			params.put("name", "3");
		}
		List<QualificationLimitDto> qualificationLimitDtos = qualificationLimitMapper.selectlimiterRelEntList(params);
		List<QualificationLimit> qLimits = new ArrayList<QualificationLimit>();

		// 去除重复的身份证号
		List<String> cerNOList = new ArrayList<String>();
		for (QualificationLimitDto qualificationLimitDto : qualificationLimitDtos) {
			if ("无".equals(qualificationLimitDto.getCertNO())) {
				continue;
			}
			cerNOList.add(qualificationLimitDto.getCertNO());
		}
		HashSet<String> cerNOListHash = new HashSet<String>(cerNOList);
		cerNOList.clear();
		cerNOList.addAll(cerNOListHash);

		// 用身份证号查询限制对象名单
		for (String cerNO : cerNOList) {
			QualificationLimit qualificationLimit = new QualificationLimit();
			qualificationLimit.setCertNO(cerNO);
			List<QualificationLimit> qualificationLimitList = qualificationLimitMapper.select(qualificationLimit);
			qLimits.addAll(qualificationLimitList);
		}

		return qLimits;
	}

	@Override
	public int limitObjNum(Map<String, Object> qryMap) {
		return qualificationLimitMapper.limitObjNum(qryMap);
	}
	
	/** 
	 * 描述: 任职资格限制信息同步
	 * @auther ZhouYan
	 * @date 2017年10月23日 
	 * @throws Exception 
	 */
	@Override
	public void doQualificationLimitQuartz() throws Exception {
		//吊销表删除
		qualificationLimitMapper.deleteRevocationInfo();
		logger.info("吊销表删除");
		List<QualificationLimit> newRevocationInfoList = qualificationLimitMapper.selectNewRevocationInfo();
		if(!newRevocationInfoList.isEmpty()) {
			//吊销表增量
			qualificationLimitMapper.insertRevocationInfo();
			logger.info("吊销表增量");
		}
		//黑名单删除
		qualificationLimitMapper.deleteDishonestexe();
		logger.info("黑名单删除");
		List<QualificationLimit> newDishonestexeList = qualificationLimitMapper.selectNewDishonestexe();
		if(!newDishonestexeList.isEmpty()) {
			//黑名单增量
			qualificationLimitMapper.insertDishonestexe();
			logger.info("黑名单增量");
		}
	}
	
}