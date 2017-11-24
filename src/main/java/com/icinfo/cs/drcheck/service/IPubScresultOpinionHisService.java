/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.drcheck.service;

import java.util.List;

import com.icinfo.cs.drcheck.model.PubScresult;
import com.icinfo.cs.drcheck.model.PubScresultOpinionHis;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.framework.core.service.BaseService;

/**
 * 描述:    cs_pub_scresult_opinion_his 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2016年11月17日
 */
public interface IPubScresultOpinionHisService extends BaseService {
     
	/**
	 * 描述:保存审核历史记录
	 * @author yujingwei
	 * @param sysUserDto 
	 * @date 2016-10-27
	 * @param pubScresult，taskNO
	 * @return boolean
	 * @throws Exception
	 */
	public boolean savePubScresultOpinion(PubScresult pubScresult, String taskNO, SysUserDto sysUserDto) throws Exception;
	
	/**
	 * 描述:获取历次审核意见
	 * @author yujingwei
	 * @param priPID 
	 * @date 2016-10-27
	 * @param deptTaskNO，taskNO
	 * @return boolean
	 * @throws Exception
	 */
	public List<PubScresultOpinionHis> doGetScOpinionHisList(String taskNO,String deptTaskNO, String priPID) throws Exception;
}