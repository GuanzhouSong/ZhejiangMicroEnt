/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.system.model;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;

import com.icinfo.cs.common.constant.OperationTypes;

/**
 * 描述:    日志前后记录<br>
 * 
 * @author 陈鑫
 * @date 2016年09月19日
 */
public class SysLogTable {
	private String tableName;
	// 操作类型 ：INSERT,UPDATE,DELETE
	private String operationType;
	private List<SysLogJsonItem> tableData;
	private Object object;

	public static SysLogTable generateLogTable(String tableName,
			List<SysLogJsonItem> tableData, Object object, String operationType) {
		if (tableName != null && operationType != null) {
			OperationTypes OperationType = OperationTypes
					.getOperationTypesMap().get(operationType);
			if (OperationType != null) {
				if (OperationTypes.DELETE.getCode().equalsIgnoreCase(
						operationType)
						|| OperationTypes.INSERT.getCode().equalsIgnoreCase(
								operationType) && object != null) {
					SysLogTable logTable = new SysLogTable();
					logTable.setTableName(tableName);
					logTable.setOperationType(operationType);
					logTable.setObject(object);
					return logTable;
				}
				if (OperationTypes.UPDATE.getCode().equalsIgnoreCase(
						operationType)
						&& tableData != null) {
					if (CollectionUtils.isNotEmpty(tableData)) {
						SysLogTable logTable = new SysLogTable();
						logTable.setTableName(tableName);
						logTable.setOperationType(operationType);
						logTable.setTableData(tableData);
						return logTable;
					}
				}
			}

		}
		return null;

	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getOperationType() {
		return operationType;
	}

	public void setOperationType(String operationType) {
		this.operationType = operationType;
	}

	public List<SysLogJsonItem> getTableData() {
		return tableData;
	}

	public void setTableData(List<SysLogJsonItem> tableData) {
		this.tableData = tableData;
	}

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}
}
