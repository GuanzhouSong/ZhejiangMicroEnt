/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.registinfo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.registinfo.mapper.RegistSurverMapper;
import com.icinfo.cs.registinfo.model.RegistSurver;
import com.icinfo.cs.registinfo.service.IRegistSurverService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述: cs_regist_surver 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年08月18日
 */
@Service
public class RegistSurverServiceImpl extends MyBatisServiceSupport implements IRegistSurverService {
	@Autowired
	RegistSurverMapper registSurverMapper;

	@Override
	public int editRecord(RegistSurver registSurver) {
		if (StringUtil.isEmpty(registSurver.getUid())) {// 添加勘察记录
			return registSurverMapper.insert(registSurver);
		} else {// 修改勘察记录
			return registSurverMapper.updateByPrimaryKeySelective(registSurver);
		}
	}

	@Override
	public List<RegistSurver> registSurverPage(PageRequest request) {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		return registSurverMapper.selectRegistSurverPage(request.getParams());
	}

	@Override
	public RegistSurver selectRegistSurverByUidAndPriPID(String uid, String priPID) {
		RegistSurver registSurver = new RegistSurver();
		registSurver.setUid(uid);
		registSurver.setPriPID(priPID);
		return registSurverMapper.selectOne(registSurver);
	}

	@Override
	public List<RegistSurver> findByRegistSurversPriPID(String priPID) {
		RegistSurver registSurver = new RegistSurver();
		registSurver.setPriPID(priPID);
		return registSurverMapper.select(registSurver);
	}
}