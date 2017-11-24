/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.other.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.other.mapper.SpPledgeMapper;
import com.icinfo.cs.other.model.SpPledge;
import com.icinfo.cs.other.service.ISpPledgeService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_sp_pledge 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年10月27日
 */
@Service
public class SpPledgeServiceImpl extends MyBatisServiceSupport implements ISpPledgeService {
	
	@Autowired
	SpPledgeMapper spPledgeMapper;

	/** 
	 * 描述: 获取股权出质登记信息列表数据（公示）
	 * @auther ZhouYan
	 * @date 2016年10月27日 
	 * @param request
	 * @return
	 * @throws Exception 
	 */
	@Override
	public List<SpPledge> queryPage(PageRequest request) throws Exception {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		return spPledgeMapper.queryPageResult(request.getParams());
	}

	/** 
	 * 描述: 根据id获取股权出质登记信息详情数据（公示）
	 * @auther ZhouYan
	 * @date 2016年10月27日 
	 * @param id
	 * @return
	 * @throws Exception 
	 */
	@Override
	public SpPledge doGetSpPledgeById(String id) throws Exception {
		return spPledgeMapper.selectByPrimaryKey(Integer.valueOf(id));
	}

	
	
	/** 
	 * 描述: 根据priPID获取股权出质登记信息详情数据（公示）
	 * @auther 陈宇
	 * @date 2016年10月28日 
	 * @param priPID
	 * @return
	 * @throws Exception 
	 */
	@Override
	public List<SpPledge> selectSpPledgeListByPriPID(PageRequest request) throws Exception {
		// TODO Auto-generated method stub
		PageHelper.startPage(request.getPageNum(), request.getLength());
		Example example = new Example(SpPledge.class);
		example.createCriteria().andEqualTo("priPID", request.getParams().get("priPID"));
		return spPledgeMapper.selectByExample(example);
	}

	/** 
	 * 描述: 根据cerNo获取股权出质登记信息详情数据（公示）
	 * @auther 陈宇
	 * @date 2016年10月28日 
	 * @param priPID
	 * @return
	 * @throws Exception 
	 */
	@Override
	public List<SpPledge> selectSpPledgeListByCerNO(PageRequest request) throws Exception {
		// TODO Auto-generated method stub\
		PageHelper.startPage(request.getPageNum(), request.getLength());
		Example example = new Example(SpPledge.class);
		example.createCriteria().andEqualTo("pleBLicNO", request.getParams().get("cerNO"));
		return spPledgeMapper.selectByExample(example);
	}
	
	/** 
	 * 描述: 根据priPID获取股权出质登记信息详情数据
	 * @auther yujingwei
	 * @date 2017年2月17日 
	 * @param priPID
	 * @return List<SpPledge>
	 */
	public List<SpPledge> selectSpPledgeInfoListByPriPID(String priPID) throws Exception{
		Example example = new Example(SpPledge.class);
		example.createCriteria()
		.andEqualTo(Constants.CS_PRIPID, priPID)
		.andEqualTo("equSource", "0");
		return spPledgeMapper.selectByExample(example);
	}
}