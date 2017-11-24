/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.simpleesc.service;

import java.util.List;

import com.icinfo.cs.simpleesc.dto.ErEscAppinfoDto;
import com.icinfo.cs.simpleesc.model.ErEscAppinfo;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    er_esc_appinfo 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2017年02月13日
 */
public interface IErEscAppinfoService extends BaseService {

	/**
	 * 描述：根据内部序号查询简易注销公告
	 * @author baifangfang
	 * @date 2017-02-13
	 * @param priPID
	 * @return
	 */
	ErEscAppinfoDto getErEscAppinfoByPriPID(String priPID);
   
	/**
	 * 描述：保存简易注销申请信息
	 * @author yujingwei
	 * @date 2017-02-13
	 * @param erEscAppinfo
	 * @param saveType 
	 * @return boolean
	 */
	public boolean doSaveErEscAppinfo(ErEscAppinfo erEscAppinfo, String saveType) throws Exception;
    
	/**
	 * 描述：根据内部序号查询简易注销公告(查询所有字段)
	 * @author yujingwei
	 * @date 2017-02-14
	 * @param priPID
	 * @return ErEscAppinfo
	 */
	public ErEscAppinfo doGetErEscAppinfoByPriPID(String priPID) throws Exception;
    
	/**
	 * 描述：撤销简易注销信息
	 * @author yujingwei
	 * @date 2017-02-15
	 * @param priPID
	 * @return boolean
	 */
	public boolean doCancelErEscAppinfo(String priPID) throws Exception;
	
	/**
	 * 
	 * 描述   分页查询简易注销公告
	 * @author 赵祥江
	 * @date 2017年2月21日 下午5:04:45 
	 * @param 
	 * @return List<ErEscScrinfoDto>
	 * @throws
	 */
	List<ErEscAppinfoDto> queryErEscAppinfoPageResult(PageRequest request);
    
	/**
	 * 描述   手动数据交换
	 * @author yujingwei
	 * @date 2017年4月18日 
	 * @param priPID
	 * @return boolean
	 * @throws
	 */
	public boolean doSendErEscAppinfo(String priPID) throws Exception;
    
	/**
	 * 描述  简易注销维护
	 * @author yujingwei
	 * @date 2017年4月18日 
	 * @param erEscAppinfo，saveType
	 * @return boolean
	 * @throws
	 */
	public boolean doMaintainSimpleesc(ErEscAppinfo erEscAppinfo, String saveType) throws Exception;
    
	/**
	 * 描述：通过企业名称查找简易注销信息
	 * @author yujingwei
	 * @date 2017年4月18日 
	 * @param entName
	 * @return ErEscAppinfo
	 * @throws Exception
	 */
	public ErEscAppinfo doGetErEscAppinfoByEntName(String entName) throws Exception;

}