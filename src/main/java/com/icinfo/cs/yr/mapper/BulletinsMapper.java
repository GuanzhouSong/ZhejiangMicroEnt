/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2016年09月19日
 * @version 2.0
 */
package com.icinfo.cs.yr.mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.cs.yr.model.Bulletins;
import com.icinfo.framework.mybatis.mapper.common.Mapper;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_bulletins 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2016年09月19日
 */
public interface BulletinsMapper extends Mapper<Bulletins> {
	
	/**
	 * 
	 * 描述: 公告栏维护分页查询列表
	 * @auther gaojinling
	 * @date 2016年10月31日 
	 * @param params
	 * @return
	 */
	public List<Bulletins> selectBulletinsList(Map<String, Object> params);

	/**
	 * 获取（警示、协同）对内系统通知公告
	 * @param sysType
	 * @param deptCode
	 * @return
	 */
	public List<Bulletins> selectBulletinsListBySysuser(String sysType,String deptCode);
	
	/**
	 * 
	 * 描述: 企业端公告列表
	 * @auther gaojinling
	 * @date 2016年12月5日 
	 * @param params
	 * @return
	 */
	public List<Bulletins> selectBulletinsClientList(Map<String, Object> params);
	
}