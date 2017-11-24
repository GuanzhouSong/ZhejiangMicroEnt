/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.rpt.rptservice.impl;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.common.constant.RegStateEnum;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.rpt.rptdto.RptSmEntInfoAllDto;
import com.icinfo.cs.rpt.rptdto.RptSmNormalDto;
import com.icinfo.cs.rpt.rptmapper.RptSmEntInfoAllMapper;
import com.icinfo.cs.rpt.rptmapper.RptSmNormalMapper;
import com.icinfo.cs.rpt.rptservice.IRptSmEntInfoAllService;
import com.icinfo.framework.core.exception.BusinessException;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:    rpt_sm_ent_info_all 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年05月09日
 */
@Service
public class RptSmEntInfoAllServiceImpl extends MyBatisServiceSupport implements IRptSmEntInfoAllService {
	
	private static final Logger logger = LoggerFactory.getLogger(RptSmEntInfoAllServiceImpl.class);

	//登记信息
	@Autowired
	private  RptSmEntInfoAllMapper rptSmEntInfoAllMapper;
	
	private Map<String, Object> countMap;
	
	/**
	 * 
	 * 描述: 小微检测登记信息统计（普通统计）
	 * @auther gaojinling
	 * @date 2017年5月5日 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<RptSmEntInfoAllDto> selectRptSmNormalCount(PageRequest request) throws Exception {
		try {
			Map<String, Object> searchMap=  request.getParams();
			if(searchMap != null && searchMap.containsKey("startCheckPushDate") && searchMap.containsKey("endCheckPushDate")){
				if(searchMap.get("startCheckPushDate") != null && StringUtil.isNotBlank(searchMap.get("startCheckPushDate").toString())){
					searchMap.put("startCheckPushDate", StringUtil.replace(searchMap.get("startCheckPushDate").toString(), "-", ""));
					searchMap.put("endCheckPushDate", StringUtil.replace(searchMap.get("endCheckPushDate").toString(), "-", ""));
				}else{
					searchMap.put("startCheckPushDate", searchMap.get("rptyear").toString()+searchMap.get("rptbeginmouth").toString());
				}
			}
			if(searchMap != null && searchMap.containsKey("industryCo") && searchMap.get("industryCo") !=null){  //行业门类
				searchMap.put("industryCo", StringUtil.doSplitStringToSqlFormat(searchMap.get("industryCo").toString(),","));
			}
			searchMap.put("numStart", request.getStart());
			searchMap.put("pageSize", 50000);
			//清空全局变量
			if(countMap != null){
				countMap.clear();
			}
			
			countMap = searchMap;
//			PageHelper.startPage(request.getPageNum(), 50000);
			return rptSmEntInfoAllMapper.selectRptSmNormalCount(searchMap);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("exception {}", "小微检测登记信息统计（普通统计）失败!");
            throw new BusinessException("小微检测登记信息统计（普通统计）失败!");
		}
	}
	
	/**
	 * 
	 * 描述:小微检测登记信息统计（普通统计条数） 
	 * @auther gaojinling
	 * @date 2017年5月23日 
	 * @return
	 * @throws Exception
	 */
	public Integer selectRptSmNormalTotal()
			throws Exception {
		try {
			return rptSmEntInfoAllMapper.selectRptSmNormalTotal(countMap);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("exception {}", "小微检测登记信息统计（普通统计）条数失败!");
			throw new BusinessException("小微检测登记信息统计（普通统计）条数失败!");
		}
	}
	
	/**
	 * 
	 * 描述: 小微检测登记信息统计（八大重点产业统计）
	 * @auther gaojinling
	 * @date 2017年5月5日 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<RptSmEntInfoAllDto> selectRptImportCount(PageRequest request) throws Exception {
		try {
			Map<String, Object> searchMap=  request.getParams();
			if(searchMap != null && searchMap.containsKey("startCheckPushDate") && searchMap.containsKey("endCheckPushDate")){
				if(searchMap.get("startCheckPushDate") != null && StringUtil.isNotBlank(searchMap.get("startCheckPushDate").toString())){
					searchMap.put("startCheckPushDate", StringUtil.replace(searchMap.get("startCheckPushDate").toString(), "-", ""));
					searchMap.put("endCheckPushDate", StringUtil.replace(searchMap.get("endCheckPushDate").toString(), "-", ""));
				}else{
					searchMap.put("startCheckPushDate", searchMap.get("rptyear").toString()+searchMap.get("rptbeginmouth").toString());
				}
			}
			searchMap.put("numStart", request.getStart());
			searchMap.put("pageSize", 50000);
			//清空全局变量
			if(countMap != null){
				countMap.clear();
			}
			
			countMap = searchMap;
//			PageHelper.startPage(request.getPageNum(), 50000);
			return rptSmEntInfoAllMapper.selectRptImportCount(searchMap);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("exception {}", "小微检测登记信息统计（八大重点产业统计）失败!");
			throw new BusinessException("小微检测登记信息统计（八大重点产业统计）失败!");
		}
	}
	
	/**
	 * 
	 * 描述:小微检测登记信息统计（重点统计条数） 
	 * @auther gaojinling
	 * @date 2017年5月23日 
	 * @return
	 * @throws Exception
	 */
	public Integer selectRptSmImportTotal()
			throws Exception {
		try {
			return rptSmEntInfoAllMapper.selectRptImportTotal(countMap);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("exception {}", "小微检测登记信息统计（重点统计）条数失败!");
			throw new BusinessException("小微检测登记信息统计（重点统计）条数失败!");
		}
	}
	
	
	
	/**
	 * 
	 * 描述: 小微检测登记信息统计省局账户（普通统计）
	 * @auther gaojinling
	 * @date 2017年5月5日 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<RptSmEntInfoAllDto> selectRptSmNormalsjCount(PageRequest request) throws Exception {
		try {
			Map<String, Object> searchMap=  request.getParams();
			if(searchMap != null && searchMap.containsKey("startCheckPushDate") && searchMap.containsKey("endCheckPushDate")){
				if(searchMap.get("startCheckPushDate") != null && StringUtil.isNotBlank(searchMap.get("startCheckPushDate").toString())){
					searchMap.put("startCheckPushDate", StringUtil.replace(searchMap.get("startCheckPushDate").toString(), "-", ""));
					searchMap.put("endCheckPushDate", StringUtil.replace(searchMap.get("endCheckPushDate").toString(), "-", ""));
				}else{
					searchMap.put("startCheckPushDate", searchMap.get("rptyear").toString()+searchMap.get("rptbeginmouth").toString());
				}
			}
            if (searchMap != null && searchMap.containsKey ("industryCo") && searchMap.get ("industryCo") != null) { // 行业门类
                searchMap.put ("industryCo", StringUtil.doSplitStringToSqlFormat (searchMap.get ("industryCo").toString (), ","));
            }
            if (searchMap != null && searchMap.containsKey ("thrIndustry") && searchMap.get ("thrIndustry") != null) { // 三大产业
                searchMap.put ("thrIndustry", StringUtil.doSplitStringToSqlFormat (searchMap.get ("thrIndustry").toString (), ","));
            }
			searchMap.put("numStart", request.getStart());
			searchMap.put("pageSize", 50000);
			searchMap.put("regState", RegStateEnum.CUNXU.getParam());
			//清空全局变量
			if(countMap != null){
				countMap.clear();
			}
			countMap = searchMap;
//			PageHelper.startPage(request.getPageNum(), 50000);
			return rptSmEntInfoAllMapper.selectRptSmNormalsjCount(searchMap);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("exception {}", "小微检测登记信息统计省局帐户（普通统计）失败!");
            throw new BusinessException("小微检测登记信息统计省局账户（普通统计）失败!");
		}
	}
	
	/**
	 * 
	 * 描述:小微检测登记信息统计省局账户（普通统计条数） 
	 * @auther gaojinling
	 * @date 2017年5月23日 
	 * @return
	 * @throws Exception
	 */
	public Integer selectRptSmNormalsjTotal() throws Exception {
		try {
			return rptSmEntInfoAllMapper.selectRptSmNormalsjTotal(countMap);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("exception {}", "小微检测登记信息统计省局账户（普通统计）条数失败!");
			throw new BusinessException("小微检测登记信息统计省局账户（普通统计）条数失败!");
		}
	}
	
	
	/**
	 * 
	 * 描述: 小微检测登记信息统计省局账户（重点统计）
	 * @auther gaojinling
	 * @date 2017年5月5日 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<RptSmEntInfoAllDto> selectRptImportsjCount(PageRequest request) throws Exception {
		try {
			Map<String, Object> searchMap=  request.getParams();
            if (searchMap != null && searchMap.containsKey ("industryCo") && searchMap.get ("industryCo") != null) { // 行业门类
                searchMap.put ("industryCo", StringUtil.doSplitStringToSqlFormat (searchMap.get ("industryCo").toString (), ","));
            }
            if (searchMap != null && searchMap.containsKey ("thrIndustry") && searchMap.get ("thrIndustry") != null) { // 三大产业
                searchMap.put ("thrIndustry", StringUtil.doSplitStringToSqlFormat (searchMap.get ("thrIndustry").toString (), ","));
            }
			searchMap.put("numStart", request.getStart());
			searchMap.put("pageSize", 50000);
			searchMap.put("regState", RegStateEnum.CUNXU.getParam());
			//清空全局变量
			if(countMap != null){
				countMap.clear();
			}			
			countMap = searchMap;
//			PageHelper.startPage(request.getPageNum(), 50000);
			return rptSmEntInfoAllMapper.selectRptImportsjCount(searchMap);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("exception {}", "小微检测登记信息统计省局帐户（重点统计）失败!");
            throw new BusinessException("小微检测登记信息统计省局账户（重点统计）失败!");
		}
	}
	
	/**
	 * 
	 * 描述:小微检测登记信息统计省局账户（重点统计条数） 
	 * @auther gaojinling
	 * @date 2017年5月23日 
	 * @return
	 * @throws Exception
	 */
	public Integer selectRptSmImportsjTotal() throws Exception {
		try {
			return rptSmEntInfoAllMapper.selectRptImportsjTotal(countMap);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("exception {}", "小微检测登记信息统计省局账户（重点统计）条数失败!");
			throw new BusinessException("小微检测登记信息统计省局账户（重点统计）条数失败!");
		}
	}
	
	
	
	
	
}