/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.common.constant;

import java.util.Map;
import java.util.TreeMap;

import com.icinfo.cs.yr.model.FoodstorageAux;
import com.icinfo.cs.yr.model.FoodstorageBack;
import com.icinfo.cs.yr.model.FoodstorageBase;
import com.icinfo.cs.yr.model.FoodstorageInfo;
import com.icinfo.cs.yr.model.FoodstorageLicense;
import com.icinfo.cs.yr.model.ModApplication;
import com.icinfo.cs.yr.model.YrAlterStockInfo;
import com.icinfo.cs.yr.model.YrForinvestMent;
import com.icinfo.cs.yr.model.YrRegCheck;

/**
 * 描述:日志保存表名<br>
 *
 * @author chenxin
 * @date 2016年05月20日
 */
public enum LogTables {
	//年报修改申请
	CS_MOD_APPLICATION("1","CS_MOD_APPLICATION",ModApplication.class)	
	,CS_YR_REG_CHECK("2","CS_YR_REG_CHECK",YrRegCheck.class)
	
	
	
	/*年报*/
	//对外投资
	,CS_YR_FORINVESTMENT("3","CS_YR_FORINVESTMENT",YrForinvestMent.class)
	//对外担保
	,CS_YR_ALTERSTOCKINFO("4","CS_YR_ALTERSTOCKINFO",YrAlterStockInfo.class) 
	//食品仓储退回表
	,CS_FOODSTORAGE_BACK("5","CS_FOODSTORAGE_BACK",FoodstorageBack.class)
	//食品仓储主表
	,CS_FOODSTORAGE_BASE("6","CS_FOODSTORAGE_BASE",FoodstorageBase.class)
	//食品仓储许可证
	,CS_FOODSTORAGE_LICENSE("7","CS_FOODSTORAGE_LICENSE",FoodstorageLicense.class)
	//食品仓库
	,CS_FOODSTORAGE_INFO("8","CS_FOODSTORAGE_INFO",FoodstorageInfo.class)
	//食品仓库详情表
	,CS_FOODSTORAGE_AUX("9","CS_FOODSTORAGE_AUX",FoodstorageAux.class)
	;
	private String code;//编码
	private String desc;//描述
	private Class clazz;
	private LogTables(String code, String desc,Class clazz){
		this.code= code;
		this.desc=desc;
		this.clazz =clazz;
	}
	public String getCode() {
		return code;
	}
	public String getDesc() {
		return desc;
	}
	
	public Class getClazz() {
		return clazz;
	}
	public static LogTables getValue(String code) {
		for (LogTables logTables : LogTables.values()) {
			if (logTables.code.equalsIgnoreCase(code)) {
				return logTables;
			}
		}
		return null;
	}
    
    public static Map<String,LogTables> getLogTablesMap(){
		Map<String,LogTables> logTablesMap = new TreeMap<String,LogTables>();
		for(LogTables logTables :LogTables.values()){
			logTablesMap.put(logTables.getCode(),logTables);
		}
		return logTablesMap;
	}

}
