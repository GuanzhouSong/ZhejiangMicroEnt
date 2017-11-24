/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.other.service.impl;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
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
import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.ext.mapper.MidBaseInfoMapper;
import com.icinfo.cs.ext.model.MidBaseInfo;
import com.icinfo.cs.other.dto.PubSamllSupportDto;
import com.icinfo.cs.other.mapper.PubSamllSupportMapper;
import com.icinfo.cs.other.model.PubSamllSupport;
import com.icinfo.cs.other.service.IPubSamllSupportService;
import com.icinfo.cs.system.model.SysUser;
import com.icinfo.cs.yr.mapper.PubServerHisModMapper;
import com.icinfo.cs.yr.model.PubServerHisMod;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述: cs_pub_small_suporrt 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年11月28日
 */
@Service
public class PubSamllSupportServiceImpl extends MyBatisServiceSupport implements IPubSamllSupportService {
	/**
	 * 日志记录器
	 */
	private static final Logger logger = LoggerFactory.getLogger(PubSamllSupportServiceImpl.class);

	@Autowired
	private PubSamllSupportMapper pubSamllSupportMapper;
	@Autowired
	PubServerHisModMapper pubServerHisModMapper;

	@Autowired
	private MidBaseInfoMapper midBaseInfoMapper;

	@Override
	public List<PubSamllSupportDto> selectByCation(PageRequest request) {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		Map<String, Object> map = request.getParams();
		return pubSamllSupportMapper.selectByCation(map);
	}

	@Override
	public int saveSmalSupport(PubSamllSupport pubSamllSupport) {
		pubSamllSupport.setProvideType("1");
		return pubSamllSupportMapper.insertSelective(pubSamllSupport);
	}

	@Override
	public PubSamllSupport selectByOne(String uid) {
		PubSamllSupport pubSamllSupport = new PubSamllSupport();
		pubSamllSupport.setUID(uid);
		return pubSamllSupportMapper.selectOne(pubSamllSupport);
	}

	@Override
	public int deleteByUids(String uid) {
		String uids[] = uid.split(",");
		Example example = new Example(PubSamllSupport.class);
		example.createCriteria().andIn("UID", Arrays.asList(uids));
		return pubSamllSupportMapper.deleteByExample(example);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public int auditSmallSupport(PubSamllSupport pubSamllSupport) throws Exception {
		int result = 0;
		Example example = new Example(PubSamllSupport.class);
		example.createCriteria().andEqualTo("UID", pubSamllSupport.getUID());
		result = pubSamllSupportMapper.updateByExampleSelective(pubSamllSupport, example);
		if (result > 0) {
			PubServerHisMod pubServerHisMod = new PubServerHisMod();
			pubServerHisMod = doHandleInfo(pubSamllSupport, pubServerHisMod);
			result = pubServerHisModMapper.insert(pubServerHisMod);
		}
		return result;
	}

	public PubServerHisMod doHandleInfo(PubSamllSupport pubSamllSupport, PubServerHisMod pubServerHisMod)
			throws Exception {
		pubServerHisMod.setHisNO(StringUtil.getRandomNumber(pubSamllSupport.getPriPID()));
		pubServerHisMod.setPriPID(pubSamllSupport.getPriPID());
		pubServerHisMod.setAltDate(pubSamllSupport.getSetDate());
		pubServerHisMod.setAltName(pubSamllSupport.getSetName());
		pubServerHisMod.setAuditState(pubSamllSupport.getAuditState());
		pubServerHisMod.setAuditDate(pubSamllSupport.getAuditDate());
		pubServerHisMod.setAuditName(pubSamllSupport.getAuditName());
		pubServerHisMod.setModUID(pubSamllSupport.getUID());
		pubServerHisMod.setAltTable("cs_pub_small_suporrt");
		return pubServerHisMod;
	}

	@Override
	public int updateSmallSupport(PubSamllSupport pubSamllSupport) {

		Example example = new Example(PubSamllSupport.class);
		example.createCriteria().andEqualTo("UID", pubSamllSupport.getUID());
		return pubSamllSupportMapper.updateByExampleSelective(pubSamllSupport, example);
	}

	@Override
	public int importByExcel(List<List<Object>> list, HttpSession session) throws Exception {
		int result = 0;
		SysUser sysUser = (SysUser) session.getAttribute(Constants.SESSION_SYS_USER);
		PubSamllSupport pubSamllSupport = new PubSamllSupport();

		pubSamllSupport.setDeptID(sysUser.getDeptCode());

		pubSamllSupport.setDeptName(sysUser.getDept());
		pubSamllSupport.setSetDate(new Date());
		pubSamllSupport.setProvideType("2");
		for (int i = 0; i < list.size(); i++) {
			List<Object> lo = list.get(i);
			MidBaseInfo bas = new MidBaseInfo();
			 if(StringUtils.isEmpty(String.valueOf(lo.get(0)).trim())){//如果注册号为空则不保存
					continue;
				}
			bas.setRegNO(String.valueOf(lo.get(0)));
			MidBaseInfo baseIfo = midBaseInfoMapper.selectOne(bas);// 查询其主体信息，活动主体id(pirPID)
			if (baseIfo != null) {
				pubSamllSupport.setPriPID(baseIfo.getPriPID());
			}
			pubSamllSupport.setRegNO(String.valueOf(lo.get(0)));
			pubSamllSupport.setEntName(String.valueOf(lo.get(1)));
			pubSamllSupport.setHelpDate(DateUtil.stringToDate(String.valueOf(lo.get(2)), "yyyy-MM-dd"));
			pubSamllSupport.setFeedBackTime(DateUtil.stringToDate(String.valueOf(lo.get(3)), "yyyy-MM-dd"));
			pubSamllSupport.setHelpContent(String.valueOf(lo.get(4)));
			if (StringUtils.isNotEmpty(lo.get(5).toString())) {
				BigDecimal am = new BigDecimal(String.valueOf(String.valueOf(lo.get(5))));
				pubSamllSupport.setSupportAm(am);
				result = pubSamllSupportMapper.insertSelective(pubSamllSupport);
			}
		}

		return result;
	}
}