/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.service;

import java.util.List;

import com.icinfo.cs.system.model.SysUser;
import com.icinfo.cs.yr.model.BaseInfo;
import com.icinfo.cs.yr.model.PubForbidResult;
import com.icinfo.cs.yr.model.YrRegCheck;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_pub_forbidresult 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2016年09月11日
 */
public interface IPubForbidResultService extends BaseService {
	
	/**
	 * 描述：敏感词审核
	 * @date 2016年9月12日 
	 * @author yujingwei
	 * @param auditOpinion 
	 * @param yrRegCheck,pubReportInfo,userProfile
	 * @return boolean
	 * @throws Exception
	 */
	public boolean doCommitForbidCheck(YrRegCheck yrRegCheck,SysUser sysUser,String checkFlag, String auditOpinion) throws Exception;
    
	/**
	 * 描述：获取敏感词信息
	 * @date 2016年9月12日 
	 * @author yujingwei
	 * @param request
	 * @throws Exception
	 */
	public List<PubForbidResult> queryPage(PageRequest request) throws Exception;
	
	/** 
	 * 描述: 保存敏感词结果
	 * @auther ZhouYan
	 * @date 2016年9月14日 
	 * @param priPID
	 * @param year
	 * @param tableName
	 * @param forbidRlt
	 * @return
	 * @throws Exception 
	 */
	int insert(String priPID, Integer year, String tableName, String forbidRlt) throws Exception;
	
	/** 
	 * 描述: 更新历史信息年报编号
	 * @auther ZhouYan
	 * @date 2016年9月30日 
	 * @param reportNo
	 * @return
	 * @throws Exception 
	 */
	int updateHis(String pripid, Integer year, String reportNo) throws Exception;
}