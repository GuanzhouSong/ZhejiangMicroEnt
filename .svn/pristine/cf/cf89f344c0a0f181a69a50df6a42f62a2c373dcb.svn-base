package com.icinfo.cs.es.service;

import com.icinfo.cs.es.dto.SmEntSearchDto;
import com.icinfo.framework.mybatis.pagehelper.Page;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

public interface ISmEntSearchService {

	/**
	 * 描述：小微企业信息查询列表
	 * 
	 * @author baifangfang
	 * @date 2017年5月2日
	 * @param request
	 * @return
	 */
	public Page<SmEntSearchDto> doGetSmEntSearchList(PageRequest request) throws Exception;
	
	/**
	 * 描述：根据id范围向云服务器导入小微企业信息
	 * @author Administrator
	 * @date 2017年5月3日
	 */
	public void doInsertSmEntDataToGsById();

	/**
	 * 描述：更新小微企业信息
	 * @author baifangfang
	 * @date 2017年5月8日
	 * @param priPID
	 */
	public boolean updateSmEnt(String condition);

	/**
	 * 描述：小微企业信息查询索引增量更新
	 * @author Administrator
	 * @date 2017年5月8日
	 */
	public void doInsertIncreToGs();

}
