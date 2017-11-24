/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.rpt.rptservice.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.rpt.rptdto.RptPartyCliamInfoDto;
import com.icinfo.cs.rpt.rptmapper.RptPartyCliamInfoMapper;
import com.icinfo.cs.rpt.rptservice.IRptPartyCliamInfoService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_rpt_non_public_party 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年08月31日
 */
@Service
public class RptPartyCliamInfoServiceImpl extends MyBatisServiceSupport implements IRptPartyCliamInfoService {
	
	@Autowired
	RptPartyCliamInfoMapper rptPartyCliamInfoMapper;
	
	private final static String PB_ENT_TYPE = "9500";
	
	private final static String NO_PUBLIC_ENT_TYPE = "1122,1130,1151,1152,1212,1222,2122,2130,2151,2152,2212,2222,4500,4510,4550,4530,4570,4560,4580";
	
	 /**
     * 描述: 查询党员户口认领列表
     * @auther yujingwei
     * @date 2016年9月20日 
     * @param request
     * @return PageResponse
     * @throws Exception
     */
	public List<RptPartyCliamInfoDto> queryRptPartyCliamInfo(PageRequest request) throws Exception{
		Map<String, Object> searchMap = request.getParams();
		int pageSize = request.getLength();
		searchMap.put("numStart", (request.getPageNum() - 1) * pageSize);
		searchMap.put("pageSize", pageSize);
		
		if(searchMap.get("regState") != null && !searchMap.get("regState").equals("")){
			searchMap.put("regStates", searchMap.get("regState").toString().split(","));
		}
		if (searchMap.get("regOrg") != null && !searchMap.get("regOrg").equals("")) {
			searchMap.put ("regOrg",
					StringUtil.doSplitStringToSqlFormat (searchMap.get ("regOrg").toString (), ","));
        }
        if (searchMap.get("localAdm") != null && !searchMap.get("localAdm").equals("")) {
        	searchMap.put ("localAdm",
        			StringUtil.doSplitStringToSqlFormat (searchMap.get ("localAdm").toString (), ","));
        }
        if (searchMap.get("entCatg") != null && !searchMap.get("entCatg").equals("")) {
        	if("1".equals(searchMap.get("entCatg"))){
        		searchMap.put ("entCatg",PB_ENT_TYPE);
        	}else if("2".equals(searchMap.get("entCatg"))){
        		searchMap.put ("entCatg",StringUtil.doSplitStringToSqlFormat (NO_PUBLIC_ENT_TYPE, ","));
        	}else{
        		searchMap.put ("entCatg","");
        	}
        }
		return rptPartyCliamInfoMapper.selectRptPartyCliamInfo(request.getParams());
	}
	
	
	/**
     * 描述: 查询党员户口认领列表 个数
     * @auther yujingwei
     * @date 2016年9月20日 
     * @param request
     * @return PageResponse
     * @throws Exception
     */
	public Integer queryCountRptPartyCliamInfo(PageRequest request) throws Exception{
		return rptPartyCliamInfoMapper.selectRptpartyCliamCount(request.getParams());
	}
	
	/**
     * 描述: 根据uid查询认领信息
     * @auther yujingwei
     * @date 2016年9月20日 
     * @param cliamUid
     * @return List<RptPartyCliamInfoDto>
     * @throws Exception
     */
	public List<RptPartyCliamInfoDto> doGetRptPartyCliamInfoByUid(String cliamUid) throws Exception{
		Map<String, Object> qrMap = new HashMap<String, Object>();
		qrMap.put("cliamUid", cliamUid);
		return rptPartyCliamInfoMapper.selectRptPartyCliamInfo(qrMap);
	}
}