/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.ext.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.ext.dto.MidMemberDto;
import com.icinfo.cs.ext.mapper.MidMemberMapper;
import com.icinfo.cs.ext.model.MidMember;
import com.icinfo.cs.ext.service.IMidMemberService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.mapper.entity.Example.Criteria;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_mid_member 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年10月20日
 */
@Service
public class MidMemberServiceImpl extends MyBatisServiceSupport implements IMidMemberService {
	
	@Autowired
	MidMemberMapper midMemberMapper;

	@Override
	public List<MidMemberDto> queryListResult(String priPID) {
		Map<String, Object> queryMap = new HashMap<String, Object>();
		queryMap.put("priPID", priPID);
		return midMemberMapper.queryListResultByPripid(queryMap);
	}
	
	/**
	 * 描述：根据priPID查询主要人员信息JSON数据列表
	 * @author zhuyong
	 * @date 2016年10月20日
	 * @param priPID
	 * @return
	 */
	@Override
	public List<MidMemberDto> queryListResult(PageRequest request) {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		return midMemberMapper.queryListResultByPripid(request.getParams());
	}
	
	/**
	 * 描述：根据名称和证件好查询高管信息
	 * @author yujingwei
	 * @date 2016年10月20日
	 * @param certNO,clientName
	 * @return List<MidMember>
	 */
	public List<MidMember> selectMidMemberInfoByCerNOAndName(String certNO,String clientName) throws Exception{
		if(certNO ==null || clientName ==null){
			return null;
		}
		Map<String, Object> qryMap = new HashMap<String, Object>();
		qryMap.put("cerNO", certNO);
		qryMap.put("name", clientName);
		return midMemberMapper.quaryMemberListByCerNOAndName(qryMap);
	}
	
	/**
	 * 获取高管人员信息(人员受限)
	 * @author yujingwei
	 * @param request
	 * @return List<MidMemberDto>
	 * @throws Exception
	 */
	public List<MidMemberDto> selectMemberListForLimit(PageRequest request) throws Exception{
		PageHelper.startPage(request.getPageNum(), request.getLength());
		Map<String, Object> qryMap = request.getParams();
		qryMap.put("limitDateEnd", DateUtil.getCurrentDate());
		return midMemberMapper.selectMemberListForLimit(qryMap);
	}
	
	
	/**
	 * 描述：根据证件号列表查询主要人员信息JSON数据列表
	 * @author ylr
	 * @date 2016年11月6日
	 * @param priPID
	 * @return
	 */
	public List<MidMemberDto> selectMidMemberList(PageRequest request){
		PageHelper.startPage(request.getPageNum(), request.getLength());
		return midMemberMapper.selectMidMemberList(request.getParams());
		
	}

	@Override
	public List<MidMember> selectMidMemberListForSearch(Map<String, Object> qryMap) {
		Example example = new Example(MidMember.class);
		// 构建条件表达式
		Criteria criteria = example.createCriteria();
		if (qryMap != null) {
			for (Map.Entry<String, Object> entry : qryMap.entrySet()) {
				criteria.andEqualTo(entry.getKey(), entry.getValue());
			}
		}
		return midMemberMapper.selectByExample(example);
}

	@Override
	public int qryMidMemCountByCerNOAndName(String certNO, String clientName) {
		Map<String, Object> qryMap = new HashMap<String, Object>();
		qryMap.put("cerNO", certNO);
		qryMap.put("name", clientName);
		return midMemberMapper.selectMidMemCountByCerNOAndName(qryMap);
	}

	/**
	 * 
	 * 描述   根据证件号查询
	 * @author  赵祥江
	 * @date 2017年4月20日 下午3:10:02 
	 * @param  
	 * @throws
	 */
	@Override
	public List<MidMember> selectMemberByCertNO(String certNO) throws Exception {
		MidMember midMember=new MidMember();
		midMember.setCerNO(certNO);
		return midMemberMapper.select(midMember);
	}
}