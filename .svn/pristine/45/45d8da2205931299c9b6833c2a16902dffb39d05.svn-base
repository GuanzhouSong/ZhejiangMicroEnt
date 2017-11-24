/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.system.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.icinfo.cs.system.dto.SysLogDto;
import com.icinfo.cs.system.model.SysLog;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_sys_log 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2016年09月18日
 */
public interface ISysLogService extends BaseService {
	//log type
	String LOG_TYPE_SERVER="1";//警示系统
	String LOG_TYPE_SYN="2";//协同系统
	String LOG_TYPE_CLIENT="0";//
	//log map keys
	String LOG_MAP_KEY_PRIPID="priPID";
	String LOG_MAP_KEY_ENTNAME="entName";
	String LOG_MAP_KEY_REGNO="regNO";
	String LOG_MAP_KEY_YEAR="year";
	String LOG_MAP_KEY_LOGEENTYPE="logEntType";
	String LOG_MAP_KEY_LOGTYPE="logType";	
	String LOG_MAP_KEY_LOGMSG="logMsg";
	String LOG_MAP_KEY_REMARK="remark";//其他详细信息
	String LOG_MAP_KEY_LOGOPERRATION="logOperation";
	/**
     * 描述: 保存操作日志
     * @auther chenxin
     * @date 2016-09-19
     * @param request http请求，logMap log属性map
     * @return
     */
	public void doAddSysLog(final Map<String, String> logMap,final HttpServletRequest request) throws Exception;
	
	/**
	 * 描述: 获取日志列表list数据
     * @auther chenxin
     * @date 2016年09月19日 
	 * @param request
	 * @return
	 */
	public List<SysLogDto> queryPage(PageRequest request);
	
	/**
	 * 
	 * 描述: 查询日志详细信息
	 * @auther chenxin
	 * @date 2016年9月20日 
	 * @param map
	 * @return SysLogDto
	 */
	public SysLogDto selectSysLogDtoById(Map<String, Object> map);

	/**
	 * 根据 priPID 查询最后一次操作的日期
	 * @param priPID
	 * @return
     */
	List<SysLog> selectSysLogByPripid(String priPID);
}