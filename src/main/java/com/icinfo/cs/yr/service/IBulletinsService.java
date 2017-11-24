/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.cs.system.model.SysUser;
import com.icinfo.cs.yr.model.Bulletins;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;


/**
 * 描述:    cs_bulletins 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2016年09月19日
 */
public interface IBulletinsService extends BaseService {
	/** 
	 * 描述: 获取列表数据
	 * @author ZhouJun
	 * @date 2016年9月28日 
	 * @param request
	 * @return
	 * @throws SQLException 
	 */
	public List<Bulletins> selectBulletins( PageRequest request,SysUserDto sysUser) throws SQLException;
	
	/** 
	 * 描述: 新增公告
	 * @author ZhouJun
	 * @date 2016年9月28日 
	 * @param bulletins
	 * @return
	 * @throws SQLException 
	 */
	public int insertBulletins(Bulletins bulletins) throws SQLException;

	/** 
	 * 描述: 更新公告
	 * @author ZhouJun
	 * @date 2016年9月28日 
	 * @param bulletins
	 * @return
	 * @throws SQLException 
	 */
	public int updateBulletins(Bulletins bulletins) throws SQLException;

	/** 
	 * 描述: 根据uid删除公告
	 * @author ZhouJun
	 * @date 2016年9月28日 
	 * @param uid
	 * @return
	 * @throws SQLException 
	 */
	public int deleteBulletinsByUid(String uid) throws SQLException;
	
	/** 
	 * 描述: 根据Uid搜索公告
	 * @author ZhouJun
	 * @date 2016年9月28日 
	 * @param UID
	 * @return
	 * @throws SQLException 
	 */
	public Bulletins selectByUID(String UID)  throws SQLException;
	
	/**
	 * 
	 * 描述: 企业端公告查询
	 * @auther gaojinling
	 * @date 2016年12月5日 
	 * @param request
	 * @return
	 * @throws SQLException
	 */
	public List<Bulletins> selectBulletinsClientList(PageRequest request) throws SQLException ;

	
	
	

}