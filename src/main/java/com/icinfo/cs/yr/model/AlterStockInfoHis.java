/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.yr.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * 描述:    cs_alterstockinfo_his 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2016年09月09日
 */
@Table(name = "cs_alterstockinfo_his")
public class AlterStockInfoHis extends AlterStockInfo implements Serializable {
    
    //年报提交编号
    @Column(name = "ReportNo")
    private String reportNo;

    private static final long serialVersionUID = 1L;

	public String getReportNo() {
		return reportNo;
	}

	public void setReportNo(String reportNo) {
		this.reportNo = reportNo;
	}
    
}