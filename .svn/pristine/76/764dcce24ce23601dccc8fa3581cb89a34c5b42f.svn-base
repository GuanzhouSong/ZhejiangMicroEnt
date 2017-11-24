/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.rpt.rptservice.impl;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.rpt.rptdto.DeptPubInfoRptDto;
import com.icinfo.cs.rpt.rptmapper.DeptPubInfoRptMapper;
import com.icinfo.cs.rpt.rptservice.IDeptPubInfoRptService;
import com.icinfo.framework.core.exception.BusinessException;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_rpt_public_info 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年08月10日
 */
@Service
public class DeptPubInfoRptServiceImpl extends MyBatisServiceSupport implements IDeptPubInfoRptService {
	private static final Logger logger = LoggerFactory.getLogger(DeptPubInfoRptServiceImpl.class);

	@Autowired
	private  DeptPubInfoRptMapper deptPubInfoRptMapper;
	/** 
	 * 描述: 查询部门公示信息统计
	 * @auther ZhouYan
	 * @date 2017年8月10日 
	 * @param request
	 * @return
	 * @throws Exception 
	 */
	@Override
	public List<DeptPubInfoRptDto> selectDeptPubInfoRpt(PageRequest request)
			throws Exception {
		try {
			Map<String, Object> searchMap=  request.getParams();
			if(searchMap != null  && searchMap.containsKey("endCheckPushDate")){
				if(searchMap.get("endCheckPushDate") != null && StringUtil.isNotBlank(searchMap.get("endCheckPushDate").toString())){
					searchMap.put("endCheckPushDate", StringUtil.replace(searchMap.get("endCheckPushDate").toString(), "-", ""));
				}else{
					searchMap.put("endCheckPushDate", searchMap.get("rptyear").toString()+searchMap.get("rptmonth").toString());
				}
			}
			PageHelper.startPage(request.getPageNum(), 10000);
			return deptPubInfoRptMapper.selectDeptPubInfoRpt(searchMap);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("exception {}", "部门公示信息统计失败!");
            throw new BusinessException("部门公示信息统计失败!");
		}
	}
	
	/**
	 * 
	 * 描述   可视化企业信用信息公示统计
	 * @author 赵祥江
	 * @date 2017年8月17日 上午9:11:05 
	 * @param 
	 * @return List<DeptPubInfoRptDto>
	 * @throws
	 */
	@Override
	public List<DeptPubInfoRptDto> selectDeptPubInfoSituationRpt(
			Map<String, Object> parmMap) throws Exception {
		try {
			return deptPubInfoRptMapper.selectDeptPubInfoSituationRpt(parmMap);
		} catch (Exception e) {
			logger.error("可视化企业信用信息公示统计失败",e);
			throw new BusinessException("可视化企业信用信息公示统计失败");
		}
	} 
	
	
	/**
	 * 
	 * 描述:大屏可视化 图6监管动态 
	 * @auther gaojinling
	 * @date 2017年9月27日 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<DeptPubInfoRptDto> selectRptPublicInfoList(Map<String,Object> map) throws Exception{
		return deptPubInfoRptMapper.selectRptPublicInfoList(map);
	}
}