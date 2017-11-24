/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.yr.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.icinfo.framework.mybatis.mapper.annotation.Before;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * 描述:  cs_sfc_form 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2016年12月05日
 */
@Table(name = "cs_sfc_form")
public class SfcForm implements Serializable {
    @Id
    @Column(name = "id")
    private Integer id;

    /**
     * 主体身份代码
     */
    @Column(name = "PriPID")
    private String priPID;

    /**
     * 年报年度
     */
    @Column(name = "Year")
    private Integer year;

    /**
     * 时间戳
     */
    @Column(name = "CreateTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;

    /**
     * 综合信息:0未填写 1已保存
     */
    @Column(name = "Cominfo")
    private String cominfo;

    /**
     * 资产负债:0未填写 1已保存
     */
    @Column(name = "Balanctsheet")
    private String balanctsheet;

    /**
     * 盈余及分配:0未填写 1已保存
     */
    @Column(name = "Incstatement")
    private String incstatement;

    /**
     * 成员权益变动:0未填写 1已保存
     */
    @Column(name = "Incomechange")
    private String incomechange;

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
     * 获取主体身份代码
     *
     * @return PriPID - 主体身份代码
     */
    public String getPriPID() {
        return priPID;
    }

    /**
     * 设置主体身份代码
     *
     * @param priPID 主体身份代码
     */
    public void setPriPID(String priPID) {
        this.priPID = priPID;
    }

    /**
     * 获取年报年度
     *
     * @return Year - 年报年度
     */
    public Integer getYear() {
        return year;
    }

    /**
     * 设置年报年度
     *
     * @param year 年报年度
     */
    public void setYear(Integer year) {
        this.year = year;
    }

    /**
     * 获取时间戳
     *
     * @return CreateTime - 时间戳
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置时间戳
     *
     * @param createTime 时间戳
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取综合信息:0未填写 1已保存
     *
     * @return Cominfo - 综合信息:0未填写 1已保存
     */
    public String getCominfo() {
        return cominfo;
    }

    /**
     * 设置综合信息:0未填写 1已保存
     *
     * @param cominfo 综合信息:0未填写 1已保存
     */
    public void setCominfo(String cominfo) {
        this.cominfo = cominfo;
    }

    /**
     * 获取资产负债:0未填写 1已保存
     *
     * @return Balanctsheet - 资产负债:0未填写 1已保存
     */
    public String getBalanctsheet() {
        return balanctsheet;
    }

    /**
     * 设置资产负债:0未填写 1已保存
     *
     * @param balanctsheet 资产负债:0未填写 1已保存
     */
    public void setBalanctsheet(String balanctsheet) {
        this.balanctsheet = balanctsheet;
    }

    /**
     * 获取盈余及分配:0未填写 1已保存
     *
     * @return Incstatement - 盈余及分配:0未填写 1已保存
     */
    public String getIncstatement() {
        return incstatement;
    }

    /**
     * 设置盈余及分配:0未填写 1已保存
     *
     * @param incstatement 盈余及分配:0未填写 1已保存
     */
    public void setIncstatement(String incstatement) {
        this.incstatement = incstatement;
    }

    /**
     * 获取成员权益变动:0未填写 1已保存
     *
     * @return Incomechange - 成员权益变动:0未填写 1已保存
     */
    public String getIncomechange() {
        return incomechange;
    }

    /**
     * 设置成员权益变动:0未填写 1已保存
     *
     * @param incomechange 成员权益变动:0未填写 1已保存
     */
    public void setIncomechange(String incomechange) {
        this.incomechange = incomechange;
    }
}