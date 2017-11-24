package com.icinfo.cs.sment.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.icinfo.cs.sment.model.SmentBulletins;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.cs.yr.model.Bulletins;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:   小微企业公告通知 sm_bulletins 对应的Service接口.<br>
 *
 * @author 
 * @date 2017年05月02日
 */
public abstract interface ISmentBulletinsService {
	/** 
	 * 描述: 获取公告通知
	 * @author Czj
	 * @date 2017年05月03日 
	 * @param request
	 * @param sysUses
	 * @return
	 * @throws SQLException 
	 */
	public List<SmentBulletins> selectBulletinsList(PageRequest request,SysUserDto sysUses);
	/** 
	 * 描述: 新增公告
	 * @author Czj
	 * @date 2017年05月03日 
	 * @param bulletins
	 * @return
	 * @throws SQLException 
	 */
	public int insertBulletins(SmentBulletins smentBulletins) throws SQLException;
	/** 
	 * 描述: 更新公告
	 * @author Czj
	 * @date 2017年05月03日 
	 * @param bulletins
	 * @return
	 * @throws SQLException 
	 */
	public int updateBulletins(SmentBulletins smentBulletins) throws SQLException;
	
	/** 
	 * 描述: 根据UID查找公告
	 * @author Czj
	 * @date 2017年05月03日 
	 * @param uid
	 * @return
	 * @throws SQLException 
	 */
	public SmentBulletins selectByUID(String uid);
	
	/** 
	 * 描述: 根据UID删除公告
	 * @author Czj
	 * @date 2017年05月03日 
	 * @param uid
	 * @return
	 * @throws SQLException 
	 */
	public int deleteBulletinsByUid(String uid);
	
}
