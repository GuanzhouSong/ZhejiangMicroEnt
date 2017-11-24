/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.inforece.sercive;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.secnocreditsup.dto.SecNoCreditSearchDto;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

public interface ISecNoCreditService extends BaseService {
	
	/**
	 * 获取严违失信名单数据
	 * @author zjj
	 * @return
	 * @throws Exception
	 */
	public List<SecNoCreditSearchDto> queryPage(PageRequest request) throws Exception;
	/**
	 * 查询已下载数据
	 * @author zjj
	 */
	public List<SecNoCreditSearchDto> getDownList(SecNoCreditSearchDto secNoCreditSearchDto);
	
	/**
	 * 查询已下载数据总数
	 * 
	 * @author zy
	 */
	public int getQueryTotal(Map<String,Object> qryMap) throws Exception;
}