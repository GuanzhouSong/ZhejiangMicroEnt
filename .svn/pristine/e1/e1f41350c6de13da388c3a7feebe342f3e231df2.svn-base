/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.sment.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.icinfo.framework.mybatis.mapper.annotation.Before;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * 描述:   小微企业培育档案库-调整信息 sm_bus_entarchives_adjust 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年04月27日
 */
@Table(name = "sm_bus_entarchives_adjust")
public class EntarchivesAdjust implements Serializable {
    @Id
    @Column(name = "id")
    @Before
    private Integer id;

    @Column(name = "PriPID")
    private String priPID;

    /**
     * 调整类型
     */
    @Column(name = "AdjustTypeCode")
    private String adjustTypeCode;

    /**
     * 调整类型名称
     */
    @Column(name = "AdjustTypeName")
    private String adjustTypeName;

    /**
     * 调整原因
     */
    @Column(name = "AdjustReason")
    private String adjustReason;

    /**
     * 调整人id
     */
    @Column(name = "AdjustUserId")
    private String adjustUserId;

    /**
     * 调整人姓名
     */
    @Column(name = "AdjustUserName")
    private String adjustUserName;

    /**
     * 调整部门id
     */
    @Column(name = "AdjustDeptId")
    private String adjustDeptId;

    /**
     * 调整部门名称
     */
    @Column(name = "AdjustDeptName")
    private String adjustDeptName;

    /**
     * 调整时间
     */
    @Column(name = "AdjustTime")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date adjustTime;

    /**
     * 调整状态 0 移除 1 调整
     */
    @Column(name = "AdjustState")
    private String adjustState;

    /**
     * 时间戳
     */
    @Column(name = "CreateTime")
    private Date createTime;

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
     * @return PriPID
     */
    public String getPriPID() {
        return priPID;
    }

    /**
     * @param priPID
     */
    public void setPriPID(String priPID) {
        this.priPID = priPID;
    }

    /**
     * 获取调整类型
     *
     * @return AdjustTypeCode - 调整类型
     */
    public String getAdjustTypeCode() {
        return adjustTypeCode;
    }

    /**
     * 设置调整类型
     *
     * @param adjustTypeCode 调整类型
     */
    public void setAdjustTypeCode(String adjustTypeCode) {
        this.adjustTypeCode = adjustTypeCode;
    }

    /**
     * 获取调整类型名称
     *
     * @return AdjustTypeName - 调整类型名称
     */
    public String getAdjustTypeName() {
        return adjustTypeName;
    }

    /**
     * 设置调整类型名称
     *
     * @param adjustTypeName 调整类型名称
     */
    public void setAdjustTypeName(String adjustTypeName) {
        this.adjustTypeName = adjustTypeName;
    }

    /**
     * 获取调整原因
     *
     * @return AdjustReason - 调整原因
     */
    public String getAdjustReason() {
        return adjustReason;
    }

    /**
     * 设置调整原因
     *
     * @param adjustReason 调整原因
     */
    public void setAdjustReason(String adjustReason) {
        this.adjustReason = adjustReason;
    }

    /**
     * 获取调整人id
     *
     * @return AdjustUserId - 调整人id
     */
    public String getAdjustUserId() {
        return adjustUserId;
    }

    /**
     * 设置调整人id
     *
     * @param adjustUserId 调整人id
     */
    public void setAdjustUserId(String adjustUserId) {
        this.adjustUserId = adjustUserId;
    }

    /**
     * 获取调整人姓名
     *
     * @return AdjustUserName - 调整人姓名
     */
    public String getAdjustUserName() {
        return adjustUserName;
    }

    /**
     * 设置调整人姓名
     *
     * @param adjustUserName 调整人姓名
     */
    public void setAdjustUserName(String adjustUserName) {
        this.adjustUserName = adjustUserName;
    }

    /**
     * 获取调整部门id
     *
     * @return AdjustDeptId - 调整部门id
     */
    public String getAdjustDeptId() {
        return adjustDeptId;
    }

    /**
     * 设置调整部门id
     *
     * @param adjustDeptId 调整部门id
     */
    public void setAdjustDeptId(String adjustDeptId) {
        this.adjustDeptId = adjustDeptId;
    }

    /**
     * 获取调整部门名称
     *
     * @return AdjustDeptName - 调整部门名称
     */
    public String getAdjustDeptName() {
        return adjustDeptName;
    }

    /**
     * 设置调整部门名称
     *
     * @param adjustDeptName 调整部门名称
     */
    public void setAdjustDeptName(String adjustDeptName) {
        this.adjustDeptName = adjustDeptName;
    }

    /**
     * 获取调整时间
     *
     * @return AdjustTime - 调整时间
     */
    public Date getAdjustTime() {
        return adjustTime;
    }

    /**
     * 设置调整时间
     *
     * @param adjustTime 调整时间
     */
    public void setAdjustTime(Date adjustTime) {
        this.adjustTime = adjustTime;
    }

    /**
     * 获取调整状态 0 移除 1 调整
     *
     * @return AdjustState - 调整状态 0 移除 1 调整
     */
    public String getAdjustState() {
        return adjustState;
    }

    /**
     * 设置调整状态 0 移除 1 调整
     *
     * @param adjustState 调整状态 0 移除 1 调整
     */
    public void setAdjustState(String adjustState) {
        this.adjustState = adjustState;
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
}