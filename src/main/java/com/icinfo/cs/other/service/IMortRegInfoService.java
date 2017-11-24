/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.other.service;

import java.util.List;

import com.icinfo.cs.other.model.MortRegInfo;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_mort_reg_info 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2016年10月26日
 */
public interface IMortRegInfoService extends BaseService {
	/** 
	 * 描述: 获取动产抵押信息列表数据（公示）
	 * @auther ZhouYan
	 * @date 2016年10月26日 
	 * @param request
	 * @return
	 * @throws Exception 
	 */
	public List<MortRegInfo> queryPage(PageRequest request) throws Exception;
	
	/** 
	 * 描述: 获取动产抵押信息详情（公示）
	 * @auther ZhouYan
	 * @date 2016年10月27日 
	 * @param id
	 * @return
	 * @throws Exception 
	 */
	public MortRegInfo doGetMortRegInfoById(String id) throws Exception;
	
	/** 
	 * 描述: 根据priPID获取动产抵押信息详情
	 * @auther chenyu
	 * @date 2016年10月27日 
	 * @param id
	 * @return
	 * @throws Exception 
	 */
	public List<MortRegInfo> selectMortRegInfoListByPriPID(PageRequest request) throws Exception;
	
	/** 
	 * 描述: 根据cerNO获取动产抵押信息详情
	 * @auther chenyu
	 * @date 2016年10月27日 
	 * @param id
	 * @return
	 * @throws Exception 
	 */
	public List<MortRegInfo> selectMortRegInfoListByCerNO(PageRequest request) throws Exception;
}