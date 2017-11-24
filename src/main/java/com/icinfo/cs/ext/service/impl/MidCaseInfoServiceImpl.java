/*
 * Copyright? 2003-2016 �㽭���ſƼ����޹�˾, All Rights Reserved. 
 */
package com.icinfo.cs.ext.service.impl;

import com.icinfo.cs.ext.mapper.MidCaseInfoMapper;
import com.icinfo.cs.ext.model.MidCaseInfo;
import com.icinfo.cs.ext.service.IMidCaseInfoService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ����:    cs_mid_caseinfo ��Ӧ��Service�ӿ�ʵ����.<br>
 *
 * @author framework generator
 * @date 2016��10��27��
 */
@Service("midCaseInfoService")
public class MidCaseInfoServiceImpl extends MyBatisServiceSupport implements IMidCaseInfoService {

	@Autowired
	private MidCaseInfoMapper midCaseInfoMapper;
	
	 /**
	  * 
	  * 描述: 企业行政处罚信息（分页查询）
	  * @auther chenyu
	  * @date 2016年10月19日 
	  * @param licID
	  * @return
	  */
	@Override
	public List<MidCaseInfo> selectMidCaseInfoListByPriId(PageRequest request) {
		// TODO Auto-generated method stub
		PageHelper.startPage(request.getPageNum(), request.getLength());
		return midCaseInfoMapper.selectMidCaseInfoListByPriPID(request.getParams());
	}

	@Override
	public int insertMidCaseInfo(MidCaseInfo midCaseInfo) {
		// TODO Auto-generated method stub
		return midCaseInfoMapper.insertMidCaseInfo(midCaseInfo);
	}

	@Override
	public List<MidCaseInfo> selectListByCerNO(PageRequest request) {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		return midCaseInfoMapper.selectListByCerNO(request.getParams());
	}

	@Override
	public MidCaseInfo selectMidCaseInfoById(String id) {
		return midCaseInfoMapper.selectByPrimaryKey(id);
	}

}