/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.rpt.rptmodel;

import com.icinfo.framework.mybatis.mapper.annotation.Before;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * 描述:    sm_rpt_addcount 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年08月18日
 */
@Table(name = "sm_rpt_addcount")
public class SmRptAddcount implements Serializable {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "RegOrg")
    private String regOrg;

    @Column(name = "LocalAdm")
    private String localAdm;

    /**
     * 1.登记主表2 年报主表 3列入异常 4移出异常
     */
    @Column(name = "TableType")
    private String tableType;

    /**
     * 更新时间（当天数据过来日期）
     */
    @Column(name = "RptDate")
    private Date rptDate;

    /**
     * 表数据量
     */
    @Column(name = "addCount")
    private Long addCount;

    private static final long serialVersionUID = 1L;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return RegOrg
     */
    public String getRegOrg() {
        return regOrg;
    }

    /**
     * @param regOrg
     */
    public void setRegOrg(String regOrg) {
        this.regOrg = regOrg;
    }

    /**
     * @return LocalAdm
     */
    public String getLocalAdm() {
        return localAdm;
    }

    /**
     * @param localAdm
     */
    public void setLocalAdm(String localAdm) {
        this.localAdm = localAdm;
    }

    /**
     * 获取1.登记主表2 年报主表 3列入异常 4移出异常
     *
     * @return TableType - 1.登记主表2 年报主表 3列入异常 4移出异常
     */
    public String getTableType() {
        return tableType;
    }

    /**
     * 设置1.登记主表2 年报主表 3列入异常 4移出异常
     *
     * @param tableType 1.登记主表2 年报主表 3列入异常 4移出异常
     */
    public void setTableType(String tableType) {
        this.tableType = tableType;
    }

    /**
     * 获取更新时间（当天数据过来日期）
     *
     * @return RptDate - 更新时间（当天数据过来日期）
     */
    public Date getRptDate() {
        return rptDate;
    }

    /**
     * 设置更新时间（当天数据过来日期）
     *
     * @param rptDate 更新时间（当天数据过来日期）
     */
    public void setRptDate(Date rptDate) {
        this.rptDate = rptDate;
    }

    /**
     * 获取表数据量
     *
     * @return addCount - 表数据量
     */
    public Long getAddCount() {
        return addCount;
    }

    /**
     * 设置表数据量
     *
     * @param addCount 表数据量
     */
    public void setAddCount(Long addCount) {
        this.addCount = addCount;
    }
}