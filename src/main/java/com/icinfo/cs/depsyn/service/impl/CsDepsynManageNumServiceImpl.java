/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.depsyn.service.impl;

import com.icinfo.cs.depsyn.mapper.CsDepsynManageNumMapper;
import com.icinfo.cs.depsyn.model.CsDepsynManageNum;
import com.icinfo.cs.depsyn.service.ICsDepsynManageNumService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:    cs_depsyn_manage_num 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年12月13日
 */
@Service
public class CsDepsynManageNumServiceImpl extends MyBatisServiceSupport implements ICsDepsynManageNumService {
	@Autowired
	CsDepsynManageNumMapper csDepsynManageNumMapper;
	/**
	 * 指定删除
	 * @author zjj
	 */
	@Override
	public void deleteByMap(Map<String, Object> qryMap) throws Exception {
		csDepsynManageNumMapper.deleteByMap(qryMap);
	}
	/**
	 * 插入数据
	 * @author zjj
	 * @return
	 */
	@Override
	public int insert(CsDepsynManageNum csDepsynManageNum) throws Exception {
		return csDepsynManageNumMapper.insert(csDepsynManageNum);
	}
}