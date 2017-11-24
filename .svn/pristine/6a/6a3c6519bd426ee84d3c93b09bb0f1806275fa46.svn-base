/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.service;

import java.util.List;

import com.icinfo.cs.yr.model.PubServerHisMod;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_pub_server_hismod 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2016年10月17日
 */
public interface IPubServerHisModService extends BaseService {
    
	/**
     * 描述：获取修改记录列表数据
     * @author yujingwei
     * @data 2016-10-17
     * @param request
     * @return PageResponse<PubServerHisMod>(data)
     * @throws Exception
     */
	public List<PubServerHisMod> queryPage(PageRequest request) throws Exception;
	
	/**
     * 描述：获取修改记录List(通过priPID，ModUID)
     * @author yujingwei
     * @data 2016-10-17
     * @param pripid,uID
     * @return List<PubServerHisMod>
     * @throws Exception
     */
	public List<PubServerHisMod> doGetPubServerHisModList(String pripid,
			String uID) throws Exception;
}