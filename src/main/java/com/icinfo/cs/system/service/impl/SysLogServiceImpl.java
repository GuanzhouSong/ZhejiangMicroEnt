/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.system.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.login.model.PubEppassword;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.common.constant.LogTables;
import com.icinfo.cs.common.constant.OperationTypes;
import com.icinfo.cs.common.utils.RequestUtil;
import com.icinfo.cs.ext.dto.MidBaseInfoDto;
import com.icinfo.cs.system.dto.SysLogDto;
import com.icinfo.cs.system.mapper.SysLogMapper;
import com.icinfo.cs.system.model.SysLog;
import com.icinfo.cs.system.model.SysLogJson;
import com.icinfo.cs.system.model.SysLogJsonItem;
import com.icinfo.cs.system.model.SysLogTable;
import com.icinfo.cs.system.model.SysUser;
import com.icinfo.cs.system.service.ISysLogService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_sys_log 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年09月18日
 */
@Service
public class SysLogServiceImpl extends MyBatisServiceSupport implements ISysLogService {
	private final static Logger logger = Logger.getLogger(ISysLogService.class);
	
	@Autowired
	private SysLogMapper sysLogMapper;
	/**
     * 描述: 保存操作日志
     * @auther chenxin
     * @date 2016-09-19
     * @param request http请求，logMap log属性map
     * @return
     */
	public void doAddSysLog(Map<String, String> logMap,HttpServletRequest request) throws Exception{
		 if (logMap != null) {
        	SysLog log = new SysLog();
        	for (String key : logMap.keySet()) {
        		 if (key.equals(ISysLogService.LOG_MAP_KEY_PRIPID)) {
                     log.setPriPID(logMap.get(key));
                 }
                 if (key.equals(ISysLogService.LOG_MAP_KEY_ENTNAME)){
                     log.setEntName(logMap.get(key));
                 }                       
                 if (key.equals(ISysLogService.LOG_MAP_KEY_REGNO)) {
                     log.setRegNO(logMap.get(key));
                 }
                 if (key.equals(ISysLogService.LOG_MAP_KEY_YEAR)) {
                     log.setYear(Integer.parseInt(logMap.get(key)));
                 }
                 if (key.equals(ISysLogService.LOG_MAP_KEY_LOGEENTYPE)) {
                     log.setLogEntType(logMap.get(key));
                 }                        
                 if (key.equals(ISysLogService.LOG_MAP_KEY_LOGTYPE)) {
                 	log.setLogType(logMap.get(key));
                 }   
                 if (key.equals(ISysLogService.LOG_MAP_KEY_LOGMSG)) {
            		 log.setLogMsg(doTranslateJsonForPage(logMap.get(key)));
                 }
				 if (key.equals(ISysLogService.LOG_MAP_KEY_REMARK)) {
					log.setRemark((logMap.get(key)));
				 }
				if (key.equals(ISysLogService.LOG_MAP_KEY_LOGOPERRATION)) {
                	 log.setLogOperation(logMap.get(key));
                 }   
    		}
            if (request != null) {
            	String ip = RequestUtil.getIpAddress(request);
            	if("0:0:0:0:0:0:0:1".equals(RequestUtil.getIpAddress(request))){
            		ip = "127.0.0.1";
            	}
            	log.setCallIp(ip);
            	if (request != null && request.getSession() != null) {
            		SysUser sysUser = (SysUser) request.getSession().getAttribute(Constants.SESSION_SYS_USER);
            		if (sysUser != null) {
            			log.setSetName(sysUser.getRealName());
            			log.setSetId(sysUser.getId());
						if (!logMap.containsKey(ISysLogService.LOG_MAP_KEY_LOGTYPE)){//如果logMap中传了logType参数，以传递的为准
							log.setLogType(ISysLogService.LOG_TYPE_SERVER);
						}
            		} else {
            			try{
            				MidBaseInfoDto midBaseInfoDto = (MidBaseInfoDto) request.getSession().getAttribute(Constants.SESSION_MIDBASEINFODTO);
            				if(midBaseInfoDto != null){
            					log.setEntName(midBaseInfoDto.getEntName());
            					log.setPriPID(midBaseInfoDto.getPriPID());
            					log.setRegNO(midBaseInfoDto.getRegNO());
            					log.setLogEntType(midBaseInfoDto.getEntTypeCatg());
//            					log.setSetName(midBaseInfoDto.getEntName());
            					log.setSetId(midBaseInfoDto.getId().toString());
            					log.setLogType(ISysLogService.LOG_TYPE_CLIENT);
            				}
            			}catch(Exception e){
            				logger.error(e.getMessage(), e);
            			}
            		}
            	}
            }
            log.setSetTime(new Date());
            try {
                log.setLogMsg(log.getLogMsg());
                sysLogMapper.insertSelective(log);  
            } catch (Exception ex) {
                logger.error(ex.getMessage(), ex);
            }
        }
	}
	
	/**
     * 描述: 翻译成页面展示内容
     * @auther chenxin
     * @date 2016-09-19
     * @param logContentJson
     * @return String
     * @throws Exception
     */	
	private String doTranslateJsonForPage(String logContentJson) throws Exception {
		if(StringUtils.isNotBlank(logContentJson)){		
			SysLogJson logJson = null;
			try{
				JSONObject jsonobject = JSONObject.fromObject(logContentJson);
				logJson  = getLogJson(jsonobject);
			}catch(Exception e){
				 return logContentJson;
			}
			if(logJson != null){
				List<SysLogTable> dataList = logJson.getDataList();
				if(CollectionUtils.isNotEmpty(dataList)){
					StringBuffer logContentForPage = new StringBuffer("变更详情如下：\n");
					for(SysLogTable logTable :dataList){
						String tableName = LogTables.getLogTablesMap().get(logTable.getTableName()).getDesc();
						logContentForPage.append("涉及的表名<").append(tableName).append(">\n");					
						String operationType =logTable.getOperationType();
						logContentForPage.append("操作类型:<").append(OperationTypes.getOperationTypesMap().get(operationType).getDesc()).append(">\n");
						boolean isInsert = OperationTypes.INSERT.getCode().equalsIgnoreCase(operationType);
						boolean isDelete = OperationTypes.DELETE.getCode().equalsIgnoreCase(operationType);
						boolean isUpdate = OperationTypes.UPDATE.getCode().equalsIgnoreCase(operationType);
						if(isInsert||isDelete){//增删操作时候
							Object object = logTable.getObject();
							if(isDelete){
								logContentForPage.append("删除的对象具体内容如下").append(object.toString()).append("\n").append("\n");
							}
							if(isInsert){
								logContentForPage.append("新增的对象具体内容如下").append(object.toString()).append("\n").append("\n");
							}
						}
                        if(isUpdate){//改操作时候		
							List<SysLogJsonItem> tableData = logTable.getTableData();
							if(CollectionUtils.isNotEmpty(tableData)){
								for(SysLogJsonItem LogJsonItem :tableData){
									String beforeValue = StringUtils.isEmpty(LogJsonItem.getBeforeValue())?"空值":LogJsonItem.getBeforeValue();
									String afterValue = StringUtils.isEmpty(LogJsonItem.getAfterValue())?"空值":LogJsonItem.getAfterValue();
									logContentForPage.append("字段[").append(LogJsonItem.getItemKey()).append("] 由原先值\"").append(beforeValue).append("\"，变成\"").append(afterValue).append("\";");
								}
							}
							logContentForPage.deleteCharAt(logContentForPage.length() - 1).append("。\n").append("\n");							
						}							
					}
					return logContentForPage.toString();
				}							
			}
		}	
		return "";
	}

	/**
	 * 描述：json转化
	 * @author chenxin
	 * @date 2016-09-19
	 * @param jsonobject
	 * @return SysLogJson
	 */
	private SysLogJson getLogJson(JSONObject jsonobject) {
		SysLogJson logJson = null;		
		if(jsonobject != null){
			//转换LogJson 实体类
			logJson = (SysLogJson)JSONObject.toBean(jsonobject, SysLogJson.class);			
			//获取一个json数组
			List<SysLogTable> dataList = new ArrayList<SysLogTable>();
			JSONArray array = jsonobject.getJSONArray("dataList");
			for (int i = 0; i < array.size(); i++) {
				SysLogTable logTable = null;					
	            JSONObject object = (JSONObject)array.get(i); 
	            //转换LogTable实体类
	    		logTable = (SysLogTable)JSONObject.toBean(object, SysLogTable.class);  
	    		String operationType = logTable.getOperationType();
	    		boolean isInsert = OperationTypes.INSERT.getCode().equalsIgnoreCase(operationType);
				boolean isDelete = OperationTypes.DELETE.getCode().equalsIgnoreCase(operationType);
				boolean isUpdate = OperationTypes.UPDATE.getCode().equalsIgnoreCase(operationType);
				if(isInsert||isDelete){//增删操作时候
	            	String tableName = logTable.getTableName();
	            	Class clazz = LogTables.getLogTablesMap().get(tableName).getClazz();
	            	JSONObject tableObject = object.getJSONObject("object"); 
	            	logTable.setObject(JSONObject.toBean(tableObject,clazz));
				}
				if(isUpdate){//改操作时候	
		            //获取一个json数组
		    		JSONArray tableDataArray = object.getJSONArray("tableData"); 
		    		List<SysLogJsonItem> tableData = new ArrayList<SysLogJsonItem>();
		    		for (int j = 0; j < tableDataArray.size(); j++) {  
		    			JSONObject logJsonItemObject = (JSONObject)tableDataArray.get(j);
		    			SysLogJsonItem logJsonItem = (SysLogJsonItem) JSONObject.toBean(logJsonItemObject,SysLogJsonItem.class);			    			
		    			tableData.add(logJsonItem);
		    		} 
		    		logTable.setTableData(tableData);
				}		    		
	    		dataList.add(logTable);
		    }		
			logJson.setDataList(dataList);
		}
		return logJson;
	}
	
	/**
	 * 描述: 获取日志列表list数据
     * @auther chenxin
     * @date 2016年09月19日 
	 * @param request
	 * @return
	 */
	@Override
	public List<SysLogDto> queryPage(PageRequest request) {
		PageHelper.startPage(request.getPageNum(), request.getLength());
        return sysLogMapper.selectSysLogList(request.getParams());
	}
	
	/**
	 * 
	 * 描述: 查询日志详细信息
	 * @auther chenxin
	 * @date 2016年9月20日 
	 * @param map
	 * @return SysLogDto
	 */
	@Override
	public SysLogDto selectSysLogDtoById(Map<String, Object> map) {
		return sysLogMapper.selectSysLogDtoById(map);
	}


	/**
	 * 根据 priPID 查询最后一次操作的日期
	 * @param priPID
	 * @return
	 */
	@Override
	public List<SysLog> selectSysLogByPripid(String priPID) {
		if(StringUtil.isNotBlank(priPID)){
			Example example = new Example(SysLog.class);
			example.createCriteria().andEqualTo(Constants.CS_PRIPID, priPID);
			example.setOrderByClause(" setTime desc ");
			return sysLogMapper.selectByExample(example);
		}
		return null;
	}
}