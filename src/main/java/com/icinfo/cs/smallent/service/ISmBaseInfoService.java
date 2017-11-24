/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.smallent.service;

import java.util.List;

import com.icinfo.cs.smallent.dto.SmBaseInfoDto;
import com.icinfo.cs.smallent.model.SmBaseInfo;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_sm_baseinfo 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2016年10月31日
 */
public interface ISmBaseInfoService extends BaseService {
    
	/**
	 * 描述: 获取小微企业库详细信息
	 * @auther yujingwei
	 * @date 2016年10月17日
	 * @param uID
	 * @return SmBaseInfo
	 * @throws Exception
	 */
	public SmBaseInfoDto doGetSmBaseInfo(String uID) throws Exception;
    
	/**
	 * 描述: 获取小微企业库列表数据
	 * @auther yujingwei
	 * @date 2016年10月17日
	 * @param request
	 * @return List<SmBaseInfo>
	 * @throws Exception
	 */
	public List<SmBaseInfo> doGetSmallDirInfoList(PageRequest request) throws Exception;
}