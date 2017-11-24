/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.sccheck.service;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import com.icinfo.cs.sccheck.dto.DrandomSpecialEntDto;
import com.icinfo.cs.sccheck.model.DrandomSpecialEnt;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_drandom_special_ent 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2017年09月13日
 */
public interface IDrandomSpecialEntService extends BaseService {
	/**
	 * 
	 * 描述: 保存跨部门专项库
	 * @auther chenxin
	 * @date 2017年9月13日 
	 * @param DrandomSpecialEnt
	 * @param sysUserDto
	 * @return
	 */
	public AjaxResult saveOrUpdateDrandomSpecialEnt(DrandomSpecialEnt drandomSpecialEnt,SysUserDto sysUserDto)  throws Exception;
	
	/**
	 * 描述：跨部门专项库列表
	 *
	 * @author chenxin
	 * @date 2017年9月13日
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<DrandomSpecialEntDto> queryPage(PageRequest request,SysUserDto sysUserDto)throws Exception;
	
	/**
	 * 描述：统计查询
	 *
	 * @author chenxin
	 * @date 2017年9月13日
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<DrandomSpecialEntDto> selectSpecialCount(Map<String,Object> params,SysUserDto sysUserDto)throws Exception;

	/**
	 * 描述：根据uid查询详情
	 *
	 * @author chenxin
	 * @date 2017年9月13日
	 * @param uid
	 * @return
	 * @throws Exception
	 */
	public DrandomSpecialEnt selectByUid(String uid)throws Exception;

	/**
	 * 描述：excel批量导入跨部门专项库(只用作协同除工商部门以外)
     * @author chenxin
     * @date 2017-9-13
	 * @param in
	 * @param sysUser
	 * @param dutyDeptCode
	 * @param dutyDeptName
	 * @param subjectType
	 * @return
	 * @throws Exception
	 */
	public JSONObject saveExcelBatch(InputStream in, SysUserDto sysUser,String subjectType)throws Exception;

	/**
	 * 描述：导入待抽检库
	 * 
	 * @author chenxin
	 * @date 2017-10-31
	 * @param parmMap
	 * @param sysUserDto
	 * @return
	 * @throws Exception
	 */
	public AjaxResult addSpecialAll(Map<String, Object> parmMap,SysUserDto sysUserDto) throws Exception;

	/**
	 * 描述：查询企业对应的检查事项
	 * 
	 * @author chenxin
	 * @date 2017-10-31
	 * @param priPID
	 * @return
	 * @throws Exception
	 */
	public List<String> selectCheckCodeList(String priPID) throws Exception;

}