/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.drcheck.service;

import java.util.List;

import com.icinfo.cs.drcheck.dto.PubScresultDto;
import com.icinfo.cs.drcheck.model.PubScresult;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:  cs_pub_scresult 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2016年10月25日
 */
public interface IPubScresultService extends BaseService {
	/**
	 * 描述：根据任务编号和主体身份代码查询抽查检查结果信息(公用)
	 * @author chenxin
	 * @date 2016-10-26
	 * @param taskNO
	 * @param priPID
	 * @return
	 * @throws Exception
	 */
	public PubScresult selectPubScresultByTaskNO(String taskNO,String priPID);
	
	/**
	 * 描述:保存抽检录入结果信息
	 * @author chenxin
	 * @date 2016-10-27
	 * @param pubScresult
	 * @param sysUser
	 * @return
	 * @throws Exception
	 */
	public boolean savePubScresult(PubScresult pubScresult,SysUserDto sysUser)throws Exception;

	/**
	 * 描述:审核抽检录入结果信息
	 * @author chenxin
	 * @date 2016-10-27
	 * @param pubScresult
	 * @param sysUser
	 * @return
	 * @throws Exception
	 */
	public boolean auditPubScresult(PubScresult pubScresult,SysUserDto sysUser)throws Exception;
	
	/**
	 * 描述：根据priPID查询抽查检查JSON数据列表
	 *
	 * @author baifangfang
	 * @date 2016年9月30日
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<PubScresultDto> queryPageResult(PageRequest request);
	
	/**
	 * 描述：根据priPID查询历史抽检记录
	 *
	 * @author baifangfang
	 * @date 2016年11月15日
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<PubScresultDto> queryPagePubScresultDto(PageRequest request);
    
	/**
	 * 描述:获取公告详细信息列表数据（用于公告）
	 * @author yujingwei
	 * @date 2016-10-27
	 * @param pubScresultList
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<PubScresultDto> selectScresultInfoForBulletin(PageRequest request) throws Exception;
	
	/**
	 * 描述:获取检查公告详情数据
	 * @author yujingwei
	 * @date 2016-10-27
	 * @param pubScresultList
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<PubScresultDto> selectCheckScresultInfoForBulletin(PageRequest request) throws Exception;
}