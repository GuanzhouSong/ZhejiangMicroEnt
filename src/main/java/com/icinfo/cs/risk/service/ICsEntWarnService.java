/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.risk.service;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.risk.dto.CsEntWarnDto;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_ent_warn 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2016年10月20日
 */
public interface ICsEntWarnService extends BaseService {
	/**
	 * 获取企业申请数据
	 * @author zjj
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<CsEntWarnDto> queryPage(PageRequest request) throws Exception;
	/**
	 * 插入标识
	 * @author zjj
	 * @param csEntWarn
	 * @return
	 * @throws Exception
	 */
	public int insert(CsEntWarnDto csEntWarn) throws Exception;
	/**
	 * 添加申请企业
	 * @author zjj
	 */
	public int insertEnt(CsEntWarnDto csEntWarn) throws Exception;
	/**
	 * 获取企业预警审核数据
	 * @author zjj
	 * 20161025
	 */
	public List<CsEntWarnDto> queryPageForCheck(PageRequest request) throws Exception;
	/**
	 * 获取指定申请信息
	 * @author zjj
	 */
	public List<CsEntWarnDto> selectCsEntWarnApplyInfo(Map<String,Object> qryMap) throws Exception;
	/**
	 * 获取指定审核信息
	 * @return
	 * @throws Exception
	 */
	public List<CsEntWarnDto> selectCsEntWarnInfo(Map<String,Object> qryMap) throws Exception;
	
	/**
	 *按批次号修改审核意见
	 *@author zjj
	 *20161025
	 */
	public int update(CsEntWarnDto csEntWarn) throws Exception; 
	
	/**
	 * 删除指定预警申请企业
	 * @author zjj
	 * 20161026
	 */
	public int delete(String str) throws Exception;
	/**
	 * 按uid修改企业申请
	 * @author zjj
	 * @param csEntWarn
	 * @return
	 * @throws Exception
	 */
	
	public int updateByUID(CsEntWarnDto csEntWarn) throws Exception;
	
	/**
	 * 按标记编号修改企业预警申请
	 * @author zjj
	 */
	public int updateByWarnNo(CsEntWarnDto csEntWarn) throws Exception;
	/**
	 * 获取查看页面数据
	 * @author zjj
	 * 20161031 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<CsEntWarnDto> queryPageForView(PageRequest request) throws Exception;
	/**
	 * 获取有效企业预警标识
	 * @author zjj
	 */
	public List<CsEntWarnDto> selectEffectiveWarnMark(Map<String,Object> qryMap) throws Exception;
	/**
	 * 获取一家企业预警情况
	 * 返回Map作为全景查询索引参数
	 * 
	 * @author zjj
	 */
	public Map<String,Object> doGetEntWarnInfoForIndex(String priPID) throws Exception;
	/**
	 * 描述：查询风险预警提示标签
	 * 
	 * @author baifangfang
	 * @date 2017年7月21日
	 * @return
	 */
	public List<CsEntWarnDto> selectCsEntWarnMarks(Map<String, Object> params);
}