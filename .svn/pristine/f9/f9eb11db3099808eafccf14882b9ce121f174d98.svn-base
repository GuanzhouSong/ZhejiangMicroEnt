/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.drcheck.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 描述:    cs_pub_scresult_opinion_his 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2016年11月17日
 */
@Table(name = "cs_pub_scresult_opinion_his")
public class PubScresultOpinionHis implements Serializable {
	
    @Id
    @Column(name = "id")
    private Integer id;

    /**
     * 组织部门UUID
     */
    @Column(name = "TaskNO")
    private String taskNO;

    /**
     * 实施部门UUID
     */
    @Column(name = "DeptTaskNO")
    private String deptTaskNO;

    @Column(name = "PriPID")
    private String priPID;

    /**
     * 审核(通过，不通过，退回)
     */
    @Column(name = "AuditFlag")
    private String auditFlag;

    /**
     * 审核意见
     */
    @Column(name = "AuditOpin")
    private String auditOpin;

    /**
     * 审核用户UID
     */
    @Column(name = "AuditUserUid")
    private String auditUserUid;

    /**
     * 审核用户名
     */
    @Column(name = "AuditUserName")
    private String auditUserName;

    /**
     * 审核日期
     */
    @Column(name = "AuditDate")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date auditDate;

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
     * 获取组织部门UUID
     *
     * @return TaskNO - 组织部门UUID
     */
    public String getTaskNO() {
        return taskNO;
    }

    /**
     * 设置组织部门UUID
     *
     * @param taskNO 组织部门UUID
     */
    public void setTaskNO(String taskNO) {
        this.taskNO = taskNO;
    }

    /**
     * 获取实施部门UUID
     *
     * @return DeptTaskNO - 实施部门UUID
     */
    public String getDeptTaskNO() {
        return deptTaskNO;
    }

    /**
     * 设置实施部门UUID
     *
     * @param deptTaskNO 实施部门UUID
     */
    public void setDeptTaskNO(String deptTaskNO) {
        this.deptTaskNO = deptTaskNO;
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
     * 获取审核(通过，不通过，退回)
     *
     * @return AuditFlag - 审核(通过，不通过，退回)
     */
    public String getAuditFlag() {
        return auditFlag;
    }

    /**
     * 设置审核(通过，不通过，退回)
     *
     * @param auditFlag 审核(通过，不通过，退回)
     */
    public void setAuditFlag(String auditFlag) {
        this.auditFlag = auditFlag;
    }

    /**
     * 获取审核意见
     *
     * @return AuditOpin - 审核意见
     */
    public String getAuditOpin() {
        return auditOpin;
    }

    /**
     * 设置审核意见
     *
     * @param auditOpin 审核意见
     */
    public void setAuditOpin(String auditOpin) {
        this.auditOpin = auditOpin;
    }

    /**
     * 获取审核用户UID
     *
     * @return AuditUserUid - 审核用户UID
     */
    public String getAuditUserUid() {
        return auditUserUid;
    }

    /**
     * 设置审核用户UID
     *
     * @param auditUserUid 审核用户UID
     */
    public void setAuditUserUid(String auditUserUid) {
        this.auditUserUid = auditUserUid;
    }

    /**
     * 获取审核用户名
     *
     * @return AuditUserName - 审核用户名
     */
    public String getAuditUserName() {
        return auditUserName;
    }

    /**
     * 设置审核用户名
     *
     * @param auditUserName 审核用户名
     */
    public void setAuditUserName(String auditUserName) {
        this.auditUserName = auditUserName;
    }

    /**
     * 获取审核日期
     *
     * @return AuditDate - 审核日期
     */
    public Date getAuditDate() {
        return auditDate;
    }

    /**
     * 设置审核日期
     *
     * @param auditDate 审核日期
     */
    public void setAuditDate(Date auditDate) {
        this.auditDate = auditDate;
    }
}