/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icinfo.cs.system.mapper.SysVersionMapper;
import com.icinfo.cs.system.model.SysVersion;
import com.icinfo.cs.system.service.ISysVersionService;
import com.icinfo.cs.yr.model.SysForbidword;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_sys_version 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年09月23日
 */
@Service
public class SysVersionServiceImpl extends MyBatisServiceSupport implements ISysVersionService {
	@Autowired
	private SysVersionMapper sysVersionMapper;
	/**
	 * 描述: 获取版本列表list数据
     * @auther chenxin
     * @date 2016年09月23日 
	 * @param request
	 * @return
	 */
	@Override
	public List<SysVersion> queryPage(PageRequest request) {
		PageHelper.startPage(request.getPageNum(), request.getLength());
        return sysVersionMapper.selectSysVersionList(request.getParams());
	}
	
	/**
	 * 
	 * 描述: 查询系统版本详细信息
	 * @auther chenxin
	 * @date 2016年9月23日 
	 * @param id
	 * @return SysVersion
	 */
	@Override
	public SysVersion selectSysVersionById(int id) {
		SysVersion sysVersion=new  SysVersion();
		sysVersion.setId(id);
		return sysVersionMapper.selectOne(sysVersion);
	}
	
	/**
	 * 描述：删除版本详细信息
	 * @author chenxin
	 * @date 2016年9月24日
	 * @param sysVersion
	 * @return
	 */
	@Override
	public int deleteById(Integer sysVersionId) {
		return sysVersionMapper.deleteByPrimaryKey(sysVersionId);
	}
	
	/**	
	 * 描述：添加版本详细信息
	 * @author chenxin
	 * @date 2016年9月24日
	 * @param sysVersion
	 * @return
	 */
	@Override
	public int insert(SysVersion sysVersion) {
		return sysVersionMapper.insert(sysVersion);
	}
	
	/**
	 * 描述：修改版本详细信息
	 * @author chenxin
	 * @date 2016年9月24日
	 * @param sysVersion
	 * @return
	 */
	@Override
	public int update(SysVersion sysVersion) {
		return sysVersionMapper.updateByPrimaryKeySelective(sysVersion);
	}
}