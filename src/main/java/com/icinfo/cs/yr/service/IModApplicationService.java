/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.service;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.system.model.SysLogTable;
import com.icinfo.cs.yr.dto.ModApplicationDto;
import com.icinfo.cs.yr.model.ModApplication;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_mod_application 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2016年09月11日
 */
public interface IModApplicationService extends BaseService {
	
	/**
	 * 描述: 获取年报修改列表list数据
     * @auther chenxin
     * @date 2016年09月11日 
	 * @param request
	 * @return
	 */
	public List<ModApplicationDto> queryPage(PageRequest request);
	
	
	/**
	 * 描述: 获取年报修改审核历史记录列表list数据
	 * @auther chenxin
	 * @date 2016年09月11日 
	 * @param request
	 * @return
	 */
	public List<ModApplication> queryHisPage(PageRequest request);
	
	/**
     * 
     * 描述: 查询年报修改信息
     * @auther chenxin
     * @date 2016年9月11日 
     * @param priPID
     * @return ModApplication
     */
	public ModApplication selectModApplication(String priPID);
	
	
	/**
	 * 
	 * 描述 : 企业端：根据年报年度和主体代码查询当前年报修改记录
	 * @author: 赵祥江
	 * @date  : 2016年9月18日 下午3:22:05 
	 * @param :
	 * @return: List<ModApplication>
	 * @throws
	 */
	public List<ModApplication> selectModApplicationPriPIDAndYear(int year ,String priPID);
    
	/**
	 * 
	 * 描述: 查询年报修改信息
	 * @auther chenxin
	 * @date 2016年9月11日 
	 * @param map
	 * @return ModApplicationDto
	 */
	public ModApplicationDto selectModApplicationApplyById(Map<String, Object> map);
	
	/**
	 * 
	 * 描述: 记录修改年报修改日志
	 * @auther chenxin
	 * @date 2016年9月18日 
	 * @param modApplication
	 * @param logCollector
	 * @return boolean
	 */
	public boolean applyModApplicationAddLog(ModApplication modApplication,List<SysLogTable> logCollector)throws Exception;
	
	/**
	 * 
	 * 描述             : 保存
	 * @author: 赵祥江
	 * @date  : 2016年9月18日 下午3:34:31 
	 * @param :
	 * @return: int
	 * @throws
	 */
    public int insertModApplication(ModApplication modApplication) throws Exception;
    
    /** 
     * 描述: 提交年报时，设置修改申请失效
     * @auther ZhouYan
     * @date 2016年9月20日 
     * @param pripid
     * @param year
     * @return
     * @throws Exception 
     */
    public int updateModApplicationInvalid(String pripid, Integer year) throws Exception;
    
    /** 
     * 描述: 企业端：查询历史修改记录
     * @auther ZhouYan
     * @date 2016年9月22日 
     * @param request
     * @return 
     * @throws Exception 
     */
    List<ModApplication> select_queryPage(PageRequest request) throws Exception;
    
	/**
	 * 
	 * 描述: 年报修改申请审核条数（警示端首页）
	 * @auther gaojinling
	 * @date 2017年3月17日 
	 * @param map
	 * @return
	 */
	public Integer selectModCount(Map<String, Object> map) throws Exception ;
}