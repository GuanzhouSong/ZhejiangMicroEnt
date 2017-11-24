/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.sccheck.service;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.sccheck.dto.PubScGroupDto;
import com.icinfo.cs.sccheck.model.PubScGroup;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_pub_scgroup 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2017年07月10日
 */
public interface IPubScGroupService extends BaseService {

	/**
     * 
     * 描述: 执法人员随机抽取页面-分组列表
     * @auther chenxin
     * @date 2017年7月11日 
     * @param request
     * @return
     * @throws Exception
     */
	public List<PubScGroupDto> queryGroupPage(PageRequest request)throws Exception;

	/**
   	 * 
   	 * 描述: 批量删除待选库的检查小组
   	 * @auther chenxin
   	 * @date 2017年7月11日 
   	 * @param userUid
   	 * @param groupUids
   	 * @return
   	 * @throws Exception
   	 */
	public boolean deleteByUserUidAndGroupUids(String userUid, String groupUids)throws Exception;

	/**
	 * 
	 * 描述: 清空当前部门待选库的检查小组
	 * @auther chenxin
	 * @date 2017年7月11日 
	 * @param userUid
	 * @return
	 * @throws Exception
	 */
	public boolean deleteByUserUid(String userUid)throws Exception;
	
	/**
	 * 
	 * 描述: 添加检查小组
	 * @auther chenxin
	 * @date 2017年7月11日 
	 * @param pubScGroup
	 * @return
	 * @throws Exception
	 */
	public boolean savePubScGroup(PubScGroup pubScGroup)throws Exception;

	/**
	 * 
	 * 描述: 查询信息并且清除成员信息
	 * @auther chenxin
	 * @date 2017年7月11日 
	 * @param userUid
	 * @return
	 * @throws Exception
	 */
	public PubScGroup selectUnVlidAndCleanMember(String userUid)throws Exception;

	/**
	 * 描述: 更新小组成员
	 * @auther chenxin
	 * @date 2017年7月11日 
	 * @param pubScGroup
	 * @throws Exception
	 */
	public boolean updateByUid(PubScGroup pubScGroup)throws Exception;

	/**
	 * 描述: 查询数量
	 * @auther chenxin
	 * @date 2017年7月12日 
	 * @param params
	 * @throws Exception
	 */
	public int selectGroupCount(Map<String, Object> params) throws Exception;

	/**
	 * 描述: 查询检查小组
	 * @auther chenxin
	 * @date 2017年7月12日 
	 * @param params
	 * @throws Exception
	 */
	public List<PubScGroupDto> selectListBySysUser(SysUserDto sysUser)throws Exception;
}