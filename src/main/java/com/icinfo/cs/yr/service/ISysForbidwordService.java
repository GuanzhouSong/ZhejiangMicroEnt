/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.service;

import java.util.List;

import com.icinfo.cs.yr.model.SysForbidword;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述: cs_sys_forbidword 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2016年08月30日
 */
public interface ISysForbidwordService extends BaseService {

	/**
	 * 描述：敏感词列表
	 * 
	 * @author baifangfang
	 * @date 2016年8月30日
	 * @param request
	 * @return
	 */
	List<SysForbidword> queryPageResult(PageRequest request);

	/**
	 * 描述：根据sysForbidwordId查询一条敏感词记录
	 * 
	 * @author baifangfang
	 * @date 2016年8月31日
	 * @param sysForbidwordId
	 * @return
	 */
	SysForbidword doGetSysForbidWordById(Integer sysForbidwordId);

	/**
	 * 描述：修改敏感词
	 * @author baifangfang
	 * @date 2016年9月8日
	 * @param sysForbidword
	 * @return
	 */
	int update(SysForbidword sysForbidword);

	/**
	 * 描述：添加敏感词
	 * @author baifangfang
	 * @date 2016年9月8日
	 * @param sysForbidword
	 * @return
	 */
	int insert(SysForbidword sysForbidword);

	/**
	 * 描述：删除敏感词
	 * @author baifangfang
	 * @date 2016年9月8日
	 * @param sysForbidwordId
	 * @return
	 */
	int deleteById(Integer sysForbidwordId);
	
	/** 
	 * 描述: 获取缓存列表：敏感词校验用
	 * @auther ZhouYan
	 * @date 2016年9月14日 
	 * @return 
	 */
	List<SysForbidword> doGetListForCache();

	/**
	 * 描述：查询是否是敏感词
	 * @author baifangfang
	 * @date 2016年11月2日
	 * @param searchKeyWord
	 * @return
	 */
	List<SysForbidword> findSysForbidBySearchKeyWord(String searchKeyWord);

	/**
	 * 判断是否存在敏感词
	 * @author ZhuDefeng
	 * @date 2016-11-18
	 * @param content
	 * @return
	 */
	boolean isContainForbidWord(String content);
}