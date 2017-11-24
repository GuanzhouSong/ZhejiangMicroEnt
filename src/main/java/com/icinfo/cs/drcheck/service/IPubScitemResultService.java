/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.drcheck.service;

import java.util.List;

import com.icinfo.cs.drcheck.dto.PubScitemResultDto;
import com.icinfo.cs.drcheck.model.PubScitemResult;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:  cs_pub_scitem_result 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2016年10月26日
 */
public interface IPubScitemResultService extends BaseService {

	/**
	 * 根据priPID获取抽查检查信息列表
	 *
	 * @author chenyu
	 * @param request
	 * @return
	 * @throws Exception
	 */
	
	public List<PubScitemResultDto> selectPubScitemResultListByPriPID(PageRequest request) throws Exception;

	/**
	 * 描述：根据任务编号和科目大类查询配置项信息(公用)
	 * @author chenxin
	 * @date 2016-10-27
	 * @param deptTaskNO
	 * @param taskNO
	 * @param scType
	 * @param priPID
	 * @param inspectDept
	 * @return List<PubScitemResult>
	 * @throws Exception
	 */
	public List<PubScitemResult> selectByTaskNOAndScType(String deptTaskNO,String taskNO,String priPID,String inspectDept) throws Exception;
	
	/**
	 * 描述：保存基本实施项结果录入信息
	 * @author chenxin
	 * @date 2016-10-27
	 * @param pubDeptSctaskList
	 * @return
	 * @throws Exception
	 */
	public boolean savePubScitemResultList(List<PubScitemResult> pubScitemResultList,SysUserDto sysUser)throws Exception;
}