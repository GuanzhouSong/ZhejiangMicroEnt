/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.mainmark.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.icinfo.framework.mybatis.mapper.annotation.Before;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * 描述:    cs_main_mark 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年03月29日
 */
@Table(name = "cs_main_mark")
public class MainMark implements Serializable {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "MarkUuid")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    private String markUuid;

    /**
     * 主体身份代码
     */
    @Column(name = "PriPID")
    private String priPID;

    /**
     * 设置部门编号
     */
    @Column(name = "SetDeptCode")
    private String setDeptCode;

    /**
     * 创建时间
     */
    @Column(name = "CreateTime")
    private Date createTime;

    /**
     * 设置时间
     */
    @Column(name = "SetTime")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date setTime;

    /**
     * 设置人名称
     */
    @Column(name = "SetName")
    private String setName;

    /**
     * 设置人ID
     */
    @Column(name = "SetId")
    private String setId;

    /**
     * 设置部门名称
     */
    @Column(name = "SetDeptname")
    private String setDeptname;

    /**
     * 审核人id
     */
    @Column(name = "AuditorId")
    private String auditorId;

    /**
     * 审核人姓名
     */
    @Column(name = "AuditorName")
    private String auditorName;

    /**
     * 审核意见
     */
    @Column(name = "AuditorDesc")
    private String auditorDesc;

    /**
     * 审核状态Code(1 待审核 2 审核通过 3 审核不通过)
     */
    @Column(name = "AuditState")
    private String auditState;

    /**
     * 审核时间
     */
    @Column(name = "AuditTime")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date auditTime;

    /**
     * 审核部门Code
     */
    @Column(name = "AuditDeptId")
    private String auditDeptId;

    /**
     * 审核部门Name
     */
    @Column(name = "AuditDeptName")
    private String auditDeptName;

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
     * @return MarkUuid
     */
    public String getMarkUuid() {
        return markUuid;
    }

    /**
     * @param markUuid
     */
    public void setMarkUuid(String markUuid) {
        this.markUuid = markUuid;
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
     * 获取设置部门编号
     *
     * @return SetDeptCode - 设置部门编号
     */
    public String getSetDeptCode() {
        return setDeptCode;
    }

    /**
     * 设置设置部门编号
     *
     * @param setDeptCode 设置部门编号
     */
    public void setSetDeptCode(String setDeptCode) {
        this.setDeptCode = setDeptCode;
    }

    /**
     * 获取创建时间
     *
     * @return CreateTime - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取设置时间
     *
     * @return SetTime - 设置时间
     */
    public Date getSetTime() {
        return setTime;
    }

    /**
     * 设置设置时间
     *
     * @param setTime 设置时间
     */
    public void setSetTime(Date setTime) {
        this.setTime = setTime;
    }

    /**
     * 获取设置人名称
     *
     * @return SetName - 设置人名称
     */
    public String getSetName() {
        return setName;
    }

    /**
     * 设置设置人名称
     *
     * @param setName 设置人名称
     */
    public void setSetName(String setName) {
        this.setName = setName;
    }

    /**
     * 获取设置人ID
     *
     * @return SetId - 设置人ID
     */
    public String getSetId() {
        return setId;
    }

    /**
     * 设置设置人ID
     *
     * @param setId 设置人ID
     */
    public void setSetId(String setId) {
        this.setId = setId;
    }

    /**
     * 获取设置部门名称
     *
     * @return SetDeptname - 设置部门名称
     */
    public String getSetDeptname() {
        return setDeptname;
    }

    /**
     * 设置设置部门名称
     *
     * @param setDeptname 设置部门名称
     */
    public void setSetDeptname(String setDeptname) {
        this.setDeptname = setDeptname;
    }

    /**
     * 获取审核人id
     *
     * @return AuditorId - 审核人id
     */
    public String getAuditorId() {
        return auditorId;
    }

    /**
     * 设置审核人id
     *
     * @param auditorId 审核人id
     */
    public void setAuditorId(String auditorId) {
        this.auditorId = auditorId;
    }

    /**
     * 获取审核人姓名
     *
     * @return AuditorName - 审核人姓名
     */
    public String getAuditorName() {
        return auditorName;
    }

    /**
     * 设置审核人姓名
     *
     * @param auditorName 审核人姓名
     */
    public void setAuditorName(String auditorName) {
        this.auditorName = auditorName;
    }

    /**
     * 获取审核意见
     *
     * @return AuditorDesc - 审核意见
     */
    public String getAuditorDesc() {
        return auditorDesc;
    }

    /**
     * 设置审核意见
     *
     * @param auditorDesc 审核意见
     */
    public void setAuditorDesc(String auditorDesc) {
        this.auditorDesc = auditorDesc;
    }

    /**
     * 获取审核状态Code(1 待审核 2 审核通过 3 审核不通过)
     *
     * @return AuditState - 审核状态Code(1 待审核 2 审核通过 3 审核不通过)
     */
    public String getAuditState() {
        return auditState;
    }

    /**
     * 设置审核状态Code(1 待审核 2 审核通过 3 审核不通过)
     *
     * @param auditState 审核状态Code(1 待审核 2 审核通过 3 审核不通过)
     */
    public void setAuditState(String auditState) {
        this.auditState = auditState;
    }

    /**
     * 获取审核时间
     *
     * @return AuditTime - 审核时间
     */
    public Date getAuditTime() {
        return auditTime;
    }

    /**
     * 设置审核时间
     *
     * @param auditTime 审核时间
     */
    public void setAuditTime(Date auditTime) {
        this.auditTime = auditTime;
    }

    /**
     * 获取审核部门Code
     *
     * @return AuditDeptId - 审核部门Code
     */
    public String getAuditDeptId() {
        return auditDeptId;
    }

    /**
     * 设置审核部门Code
     *
     * @param auditDeptId 审核部门Code
     */
    public void setAuditDeptId(String auditDeptId) {
        this.auditDeptId = auditDeptId;
    }

    /**
     * 获取审核部门Name
     *
     * @return AuditDeptName - 审核部门Name
     */
    public String getAuditDeptName() {
        return auditDeptName;
    }

    /**
     * 设置审核部门Name
     *
     * @param auditDeptName 审核部门Name
     */
    public void setAuditDeptName(String auditDeptName) {
        this.auditDeptName = auditDeptName;
    }
}