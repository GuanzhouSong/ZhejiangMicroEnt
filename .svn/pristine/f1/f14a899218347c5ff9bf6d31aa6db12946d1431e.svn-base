/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.other.service;

import java.util.List;

import com.icinfo.cs.other.model.SpPledge;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_sp_pledge 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2016年10月27日
 */
public interface ISpPledgeService extends BaseService {
	
	/** 
	 * 描述: 获取股权出质登记信息列表数据（公示）
	 * @auther ZhouYan
	 * @date 2016年10月26日 
	 * @param request
	 * @return
	 * @throws Exception 
	 */
	public List<SpPledge> queryPage(PageRequest request) throws Exception;
	
	/** 
	 * 描述: 根据id获取股权出质登记信息详情数据（公示）
	 * @auther ZhouYan
	 * @date 2016年10月27日 
	 * @param id
	 * @return
	 * @throws Exception 
	 */
	public SpPledge doGetSpPledgeById(String id) throws Exception;
	
	/** 
	 * 描述: 根据priPID获取股权出质登记信息详情数据（公示）
	 * @auther 陈宇
	 * @date 2016年10月28日 
	 * @param priPID
	 * @return
	 * @throws Exception 
	 */
	public List<SpPledge> selectSpPledgeListByPriPID(PageRequest request) throws Exception;
	
	/** 
	 * 描述: 根据cerNo获取股权出质登记信息详情数据（公示）
	 * @auther 陈宇
	 * @date 2016年10月28日 
	 * @param priPID
	 * @return
	 * @throws Exception 
	 */
	public List<SpPledge> selectSpPledgeListByCerNO(PageRequest request) throws Exception;

	/** 
	 * 描述: 根据priPID获取股权出质登记信息详情数据
	 * @auther yujingwei
	 * @date 2017年2月17日 
	 * @param priPID
	 * @return List<SpPledge>
	 */
	public List<SpPledge> selectSpPledgeInfoListByPriPID(String priPID) throws Exception;
}