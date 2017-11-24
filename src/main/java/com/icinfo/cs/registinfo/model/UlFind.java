/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.registinfo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.icinfo.framework.mybatis.mapper.annotation.Before;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * 描述:    cs_ul_find 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2016年09月09日
 */
@Table(name = "cs_ul_find")
public class UlFind implements Serializable {
    @Id
    @Column(name = "id")
    private Integer id;

    /**
     * 主体身份代码
     */
    @Column(name = "PriPID")
    private String priPID;

    /**
     * 时间戳
     */
    @Column(name = "CreateTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;

    /**
     * 无照的UUID
     */
    @Column(name = "UID")
    private String UID;

    /**
     * 发现途径（1日常巡查、2上级督办、3投诉举报、4部门移交、5其他来源）
     */
    @Column(name = "FindWay")
    private String findWay;

    /**
     * 发现日期
     */
    @Column(name = "FindDate")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date findDate;

    /**
     * 发现人
     */
    @Column(name = "FindName")
    private String findName;

    /**
     * 情况说明
     */
    @Column(name = "Remark")
    private String remark;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

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
     * 获取无照的UUID
     *
     * @return UID - 无照的UUID
     */
    public String getUID() {
        return UID;
    }

    /**
     * 设置无照的UUID
     *
     * @param UID 无照的UUID
     */
    public void setUID(String UID) {
        this.UID = UID;
    }

    /**
     * 获取发现途径（1日常巡查、2上级督办、3投诉举报、4部门移交、5其他来源）
     *
     * @return FindWay - 发现途径（1日常巡查、2上级督办、3投诉举报、4部门移交、5其他来源）
     */
    public String getFindWay() {
        return findWay;
    }

    /**
     * 设置发现途径（1日常巡查、2上级督办、3投诉举报、4部门移交、5其他来源）
     *
     * @param findWay 发现途径（1日常巡查、2上级督办、3投诉举报、4部门移交、5其他来源）
     */
    public void setFindWay(String findWay) {
        this.findWay = findWay;
    }

    /**
     * 获取发现日期
     *
     * @return FindDate - 发现日期
     */
    public Date getFindDate() {
        return findDate;
    }

    /**
     * 设置发现日期
     *
     * @param findDate 发现日期
     */
    public void setFindDate(Date findDate) {
        this.findDate = findDate;
    }

    /**
     * 获取发现人
     *
     * @return FindName - 发现人
     */
    public String getFindName() {
        return findName;
    }

    /**
     * 设置发现人
     *
     * @param findName 发现人
     */
    public void setFindName(String findName) {
        this.findName = findName;
    }

    /**
     * 获取情况说明
     *
     * @return Remark - 情况说明
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置情况说明
     *
     * @param remark 情况说明
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }
}