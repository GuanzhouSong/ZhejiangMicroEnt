/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.system.service;

import java.util.List;

import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.system.dto.SysUserAreaManageDto;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.cs.system.model.SysUser;
import com.icinfo.cs.system.model.SysUserAreaManage;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:   111111 SYS_USER_AREA_ADMIN 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2017年05月04日
 */
public interface ISysUserAreaManageService extends BaseService {
	/**
	 * 
	 * 描述   分页查询区域管理员
	 * @author 赵祥江
	 * @date 2017年5月4日 下午3:32:26 
	 * @param 
	 * @return List<SysUserAreaManageDto>
	 * @throws
	 */
	public List<SysUserAreaManageDto> queryPage(PageRequest request) throws Exception;
	
	/**
	 * 
	 * 描述   根据主键修改
	 * @author 赵祥江
	 * @date 2017年5月4日 下午3:33:29 
	 * @param 
	 * @return int
	 * @throws
	 */
	public int updateSysUserAreaManageByUid(SysUserAreaManage sysUserAreaManage)throws Exception;
	
	/**
	 * 
	 * 描述   保存
	 * @author 赵祥江
	 * @date 2017年5月5日 上午11:37:17 
	 * @param 
	 * @return int
	 * @throws
	 */
	public int insertSysUserAreaManage(SysUserAreaManage sysUserAreaManage)throws Exception;
	
	/**
	 * 
	 * 描述   根据主键查询区域管理员
	 * @author 赵祥江
	 * @date 2017年5月4日 下午3:41:11 
	 * @param 
	 * @return SysUserAreaManage
	 * @throws
	 */
	public SysUserAreaManage selectSysUserAreaManageByUid(String uid)throws Exception;
	
	/**
	 * 
	 * 描述   根据uid删除
	 * @author 赵祥江
	 * @date 2017年5月5日 下午2:41:59 
	 * @param 
	 * @return int
	 * @throws
	 */
	public int deleteSysUserAreaManageByUid(String uid)throws Exception;
	
	/**
	 * 
	 * 描述   根据用户主键查询区域管理员
	 * @author 赵祥江
	 * @date 2017年5月4日 下午3:41:28 
	 * @param 
	 * @return SysUserAreaManage
	 * @throws
	 */
	public SysUserAreaManage selectSysUserAreaManageByUserIdentity(String userIdentity,String userStatus)throws Exception;
	 }