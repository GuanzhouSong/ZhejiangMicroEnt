/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.ext.service;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.ext.dto.MidMemberDto;
import com.icinfo.cs.ext.model.MidMember;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_mid_member 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2016年10月20日
 */
public interface IMidMemberService extends BaseService {

	/**
	 * 描述：根据priPID查询主要人员信息JSON数据列表
	 * @author baifangfang
	 * @date 2016年10月20日
	 * @param priPID
	 * @return
	 */
	List<MidMemberDto> queryListResult(String priPID);
	
	/**
	 * 描述：根据priPID查询主要人员信息JSON数据列表
	 * @author zhuyong
	 * @date 2016年10月20日
	 * @param priPID
	 * @return
	 */
	List<MidMemberDto> queryListResult(PageRequest request);
	
	/**
	 * 描述：根据证件号列表查询主要人员信息JSON数据列表
	 * @author ylr
	 * @date 2016年11月6日
	 * @param priPID
	 * @return
	 */
	List<MidMemberDto> selectMidMemberList(PageRequest request);
	/**
	 * 按条件查询
	 * @author zjj
	 */
	List<MidMember> selectMidMemberListForSearch(Map<String,Object> qryMap);
    
	/**
	 * 描述：根据名称和证件好查询高管信息
	 * @author yujingwei
	 * @date 2016年10月20日
	 * @param certNO,clientName
	 * @return List<MidMember>
	 */
	List<MidMember> selectMidMemberInfoByCerNOAndName(String certNO,String clientName) throws Exception;
    
	/**
	 * 获取高管人员信息(人员受限)
	 * @author yujingwei
	 * @param request
	 * @return List<MidMemberDto>
	 * @throws Exception
	 */
	List<MidMemberDto> selectMemberListForLimit(PageRequest request) throws Exception;

	/**
	 * 描述：根据身份证号和姓名查询高管人员数量
	 * @author baifangfang
	 * @date 2017年4月10日
	 * @param certNO
	 * @param clientName
	 * @return
	 */
	int qryMidMemCountByCerNOAndName(String certNO, String clientName);
	
	/**
	 * 
	 * 描述   根据证件号查询
	 * @author 赵祥江
	 * @date 2017年4月20日 下午3:09:01 
	 * @param 
	 * @return List<MidMember>
	 * @throws
	 */
	List<MidMember> selectMemberByCertNO(String certNO) throws Exception;
	
}