/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.specialrec.service;

import java.io.InputStream;
import java.util.List;

import net.sf.json.JSONObject;

import com.icinfo.cs.specialrec.dto.SpecialRecEntDto;
import com.icinfo.cs.specialrec.model.SpecialRecEnt;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_special_rec_ent 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2017年11月01日
 */
public interface ISpecialRecEntService extends BaseService {
    
	/**
	 * 描述：查询检查名单列表
	 *
	 * @author yujingwei
	 * @date 2017年10月27日
	 * @param request
	 * @return pageResponse
	 * @throws Exception
	 */
	public List<SpecialRecEntDto> querySpecialrecEntList(PageRequest request) throws Exception;
    
	/**
	 * 描述：批量插入检查对象
	 *
	 * @author yujingwei
	 * @date 2017年10月27日
	 * @param taskUid
	 * @param priPIDs
	 * @return String
	 * @throws Exception
	 */
	public String addSpecialreceEntBatch(String taskUid, String priPIDs) throws Exception;
    
	/**
	 * 描述：删除检查对象信息
	 * 
	 * @author yujingwei
	 * @date 2017年11月01日
	 * @param delUidList
	 * @return AjaxResult
	 * @throws Exception
	 */
	public int doDelSpecialRecEntInfo(String delUidList) throws Exception;
    
	/**
	 * 描述：清空检查对象
	 * 
	 * @author yujingwei
	 * @date 2017年11月01日
	 * @param taskUid
	 * @return AjaxResult
	 * @throws Exception
	 */
	public int doCleanSpecialRecEntInfo(String taskUid) throws Exception;
    
	/**
	 * 描述：通过任务编号查询检查名单
	 * 
	 * @author yujingwei
	 * @date 2017年11月01日
	 * @param uid
	 * @return List
	 * @throws Exception
	 */
	public List<SpecialRecEnt> selectSpecialRecEntInfoList(String uid) throws Exception;
    
	/**
	 * 描述：保存检查结果信息
	 * 
	 * @author yujingwei
	 * @date 2017年11月01日
	 * @param recEnt
	 * @throws Exception
	 */
	public void saveSpecialRecEnt(SpecialRecEnt recEnt) throws Exception;
    
	/**
	 * 描述：专项整治名单导入
	 * 
	 * @author yujingwei
	 * @date 2017年11月01日
	 * @param taskUid
	 * @throws Exception
	 */
	public JSONObject doAddExcelBatch(InputStream in, String taskUid,SysUserDto sysUser) throws Exception;
}