/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.service;

import java.util.List;

import com.icinfo.cs.yr.dto.PubExcludeEntDto;
import com.icinfo.cs.yr.model.PubExcludeEnt;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述: cs_pub_excludeent 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2016年08月30日
 */
public interface IPubExcludeEntService extends BaseService {

	/**
	 * 描述：限制公示名单列表
	 * 
	 * @author baifangfang
	 * @date 2016年8月30日
	 * @param request
	 * @return
	 */
	List<PubExcludeEntDto> queryPageExcludeResult(PageRequest request) throws Exception;

	/**
	 * 描述：根据pubExcludeEntId查询限制公示名单(进入添加或修改页面)
	 * 
	 * @author baifangfang
	 * @date 2016年8月30日
	 * @param pubExcludeEntId
	 * @return
	 */
	PubExcludeEnt doGetPubExcludeEntById(Integer pubExcludeEntId);

	/**
	 * 描述：更新限制公示名单
	 * 
	 * @author baifangfang
	 * @date 2016年9月8日
	 * @param pubExcludeEnt
	 * @return
	 */
	int update(PubExcludeEnt pubExcludeEnt);

	/**
	 * 描述：添加限制公示名单
	 * 
	 * @author baifangfang
	 * @date 2016年9月8日
	 * @param pubExcludeEnt
	 * @return
	 */
	int insert(PubExcludeEnt pubExcludeEnt);

	/**
	 * 描述：删除限制公示名单
	 * 
	 * @author baifangfang
	 * @date 2016年9月8日
	 * @param pubExcludeEntId
	 * @return
	 */
	int deleteById(Integer pubExcludeEntId);

	/**
	 * 描述：获取未进入限制公示的企业名单列表
	 * 
	 * @author baifangfang
	 * @date 2016年9月10日
	 * @param request
	 * @return
	 */
	List<PubExcludeEntDto> queryPageNotExcludeResult(PageRequest request);

	/**
	 * 描述：根据主体身份代码查询限制公示名单企业
	 * 
	 * @author baifangfang
	 * @date 2016年9月11日
	 * @param priPID
	 * @return
	 */
	PubExcludeEnt doGetPubExcludeEntByPriPID(String priPID);
}