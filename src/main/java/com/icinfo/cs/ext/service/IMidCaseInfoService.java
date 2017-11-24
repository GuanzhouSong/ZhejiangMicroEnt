/*
 * Copyright? 2003-2016 �㽭���ſƼ����޹�˾, All Rights Reserved. 
 */
package com.icinfo.cs.ext.service;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.ext.model.MidCaseInfo;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * ����: cs_mid_caseinfo ��Ӧ��Service�ӿ�.<br>
 *
 * @author framework generator
 * @date 2016��10��27��
 */
public interface IMidCaseInfoService extends BaseService {
	/**
	 * 
	 * 描述: 企业行政处罚信息（分页查询）
	 * 
	 * @auther chenyu
	 * @date 2016年10月19日
	 * @param licID
	 * @return
	 */
	public List<MidCaseInfo> selectMidCaseInfoListByPriId(PageRequest request);

	public int insertMidCaseInfo(MidCaseInfo midCaseInfo);

	/**
	 * 描述:根据自然人身份证号获取列表
	 * 
	 * @author 张文男
	 * @date 2017年3月17日
	 * @param request
	 * @return
	 */

	public List<MidCaseInfo> selectListByCerNO(PageRequest request);

	/**
	 * 描述：严违失信信息详情
	 * 
	 * @author baifangfang
	 * @date 2017年10月23日
	 * @param id
	 * @return
	 */
	public MidCaseInfo selectMidCaseInfoById(String id);
}