/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.ext.service;

import java.util.List;

import com.icinfo.cs.ext.dto.TmDetailInfoDto;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_tm_detail_info 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2016年12月08日
 */
public interface ITmDetailInfoService extends BaseService {
	
	/**
	 * 
	 * 描述: 根据主体代码查询商标注册信息（公示）
	 * @auther gaojinling
	 * @date 2016年12月8日 
	 * @param request
	 * @return
	 */
	public List<TmDetailInfoDto> queryPageResult(String priPID,String regnum);
     
	/**
	 * 描述: 商标信息查询（全景-企业综合查询）
	 * @auther yujingwei
	 * @date 2017年3月20日 
	 * @param request
	 * @return
	 */
	public List<TmDetailInfoDto> doGetBrandInfoList(PageRequest request);
}