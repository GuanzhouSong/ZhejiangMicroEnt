/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.depsyn.service;

import java.util.Map;

import com.icinfo.cs.depsyn.model.CsDepsynManageNum;
import com.icinfo.framework.core.service.BaseService;

/**
 * 描述:    cs_depsyn_manage_num 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2016年12月13日
 */
public interface ICsDepsynManageNumService extends BaseService {
	/**
	 * 指定删除
	 * @author zjj
	 */
	void deleteByMap(Map<String,Object> qryMap) throws Exception;
	/**
	 * 插入数据
	 * @author zjj
	 * @return
	 */
	int insert(CsDepsynManageNum csDepsynManageNum) throws Exception;
}