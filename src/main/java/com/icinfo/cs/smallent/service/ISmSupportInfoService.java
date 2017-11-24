/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.smallent.service;

import java.util.List;

import com.icinfo.cs.smallent.model.SmSupportInfo;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_sm_support 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2016年10月31日
 */
public interface ISmSupportInfoService extends BaseService {
     
	/**
     * 获取小微企业扶持列表数据
     * @author yujingwei
     * @date 2016-10-17
     * @param request
     * @return List<SmSupportInfo>
     * @throws Exception
     */
	public List<SmSupportInfo> doGetSupportInfoList(PageRequest request) throws Exception;
    
	/**
     * 通过UID获取小微企业扶持详细信息
     * @author yujingwei
     * @date 2016-10-17
     * @param uID
     * @return SmSupportInfo
     * @throws Exception
     */
	public SmSupportInfo doGetSupportInfo(String uID) throws Exception;

	/**
	 * 通过 pripid 查询
	 * @author: wangjin
	 * @param priPID
	 * @return
     */
	List<SmSupportInfo> selectByPripid(String priPID);
}