/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.registinfo.service;

import java.util.List;

import com.icinfo.cs.registinfo.model.RegistSurver;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述: cs_regist_surver 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2017年08月18日
 */
public interface IRegistSurverService extends BaseService {
	/**
	 * 描述：添加或修改勘察记录
	 * 
	 * @author baifangfang
	 * @date 2017年8月18日
	 * @param registSurver
	 * @return
	 */
	int editRecord(RegistSurver registSurver);

	/**
	 * 描述：获取勘察记录列表
	 * 
	 * @author baifangfang
	 * @date 2017年8月18日
	 * @param request
	 * @return
	 */
	List<RegistSurver> registSurverPage(PageRequest request);

	/**
	 * 描述：根据uid查询勘察记录
	 * 
	 * @author baifangfang
	 * @date 2017年8月21日
	 * @param uid，priPID
	 * @return
	 */
	RegistSurver selectRegistSurverByUidAndPriPID(String uid, String priPID);

	/**
	 * 描述：根据内部序号查询企业有没有勘察记录
	 * @author baifangfang
	 * @date 2017年8月21日
	 * @param priPID
	 * @return
	 */
	List<RegistSurver> findByRegistSurversPriPID(String priPID);
}