/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.ext.service;

import java.util.List;

import com.icinfo.cs.ext.dto.MidLeRepDto;
import com.icinfo.cs.ext.model.MidLeRep;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_mid_lerep 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2016年08月29日
 */
public interface IMidLeRepService extends BaseService {
	
	public List<MidLeRep> selectMidLeRepListByPriPID(String key ,String priPid);
	
	public List<MidLeRepDto> selectMidLeRepList(PageRequest request);
	
	/**
	 * 描述：任职资格黑名单查询列表
	 * @author chenxin
	 * @date 2017-03-21
	 * @param qryMap
	 * @return
	 */
	List<MidLeRepDto> selectMidLeRepBackList(PageRequest request);
	
	/**
	 * 描述：受限对象受限原因
	 * @author chenxin
	 * @date 2017-03-21
	 * @param qryMap
	 * @return
	 */
	List<MidLeRepDto> selectMidLeRepBackReasonList(PageRequest request);
     
	/**
	 * 描述：通过证件号查询法定代表人信息（内部序号唯一）
	 * @author yujingwei
	 * @date 2017-03-21
	 * @param certNO
	 * @return List<MidLeRep>
	 */
	public List<MidLeRep> selectMidLeRepListByCerNO(String certNO) throws Exception;

	/**
	 * 描述：通过证件号和姓名查询法定代表人信息
	 * @author yujingwei
	 * @date 2017-04-10
	 * @param certNO
	 * @param clientName
	 * @return
	 */
	public int qryMidLeRepByCerNOAndName(String certNO, String name);

	/**
	 * 描述：通过pripids取法人列表
	 * @author baifangfang
	 * @date 2017年6月14日
	 * @param priPidList
	 * @return
	 */
	public List<MidLeRep> findMidLerepByPriPIDList(List<String> priPidList);
}