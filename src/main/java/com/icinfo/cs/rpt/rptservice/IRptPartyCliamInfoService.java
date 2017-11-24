/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.rpt.rptservice;

import java.util.List;

import com.icinfo.cs.rpt.rptdto.RptPartyCliamInfoDto;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_rpt_non_public_party 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2017年08月31日
 */
public interface IRptPartyCliamInfoService extends BaseService {
    
	 /**
     * 描述: 查询党员户口认领列表
     * @auther yujingwei
     * @date 2016年9月20日 
     * @param request
     * @return PageResponse
     * @throws Exception
     */
	public List<RptPartyCliamInfoDto> queryRptPartyCliamInfo(PageRequest request) throws Exception;
    
	/**
     * 描述: 根据uid查询认领信息
     * @auther yujingwei
     * @date 2016年9月20日 
     * @param cliamUid
     * @return List<RptPartyCliamInfoDto>
     * @throws Exception
     */
	public List<RptPartyCliamInfoDto> doGetRptPartyCliamInfoByUid(String cliamUid) throws Exception;
    
	/**
     * 描述: 查询党员户口认领列表 个数
     * @auther yujingwei
     * @date 2016年9月20日 
     * @param request
     * @return PageResponse
     * @throws Exception
     */
	public Integer queryCountRptPartyCliamInfo(PageRequest request) throws Exception;
}