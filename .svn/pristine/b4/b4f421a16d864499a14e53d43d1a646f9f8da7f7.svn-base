/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.system.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.icinfo.framework.mybatis.mapper.annotation.Before;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * 描述:    cs_ent_assign_log 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2016年10月13日
 */
@Table(name = "cs_ent_assign_log")
public class EntAssignLog implements Serializable {
    @Id
    @Column(name = "ID")
    private Integer ID;

    @Column(name = "UID")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    private String UID;

    /**
     * 注册号(CA15)
     */
    @Column(name = "RegNO")
    private String regNO;

    /**
     * 统一社会信用代码(CA91)
     */
    @Column(name = "UniCode")
    private String uniCode;

    /**
     * 主体身份代码
     */
    @Column(name = "PriPID")
    private String priPID;

    /**
     * 企业(机构)名称
     */
    @Column(name = "EntName")
    private String entName;

    /**
     * 指定人用户ID
     */
    @Column(name = "AssignUserId")
    private String assignUserId;

    /**
     * 指定人用户姓名
     */
    @Column(name = "AssignUserName")
    private String assignUserName;

    /**
     * 指定人所在部门ID
     */
    @Column(name = "AssignDeptId")
    private String assignDeptId;

    /**
     * 操作人所在部门名称
     */
    @Column(name = "AssignDeptName")
    private String assignDeptName;

    /**
     * 是否取消分配
     */
    @Column(name = "IsCancleAssign")
    private String isCancleAssign;

    /**
     * 操作时间
     */
    @Column(name = "SetTime")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date setTime;

    /**
     * 设置人员名称
     */
    @Column(name = "SetName")
    private String setName;

    private static final long serialVersionUID = 1L;

    /**
     * @return ID
     */
    public Integer getID() {
        return ID;
    }

    /**
     * @param ID
     */
    public void setID(Integer ID) {
        this.ID = ID;
    }

    /**
     * @return UID
     */
    public String getUID() {
        return UID;
    }

    /**
     * @param UID
     */
    public void setUID(String UID) {
        this.UID = UID;
    }

    /**
     * 获取注册号(CA15)
     *
     * @return RegNO - 注册号(CA15)
     */
    public String getRegNO() {
        return regNO;
    }

    /**
     * 设置注册号(CA15)
     *
     * @param regNO 注册号(CA15)
     */
    public void setRegNO(String regNO) {
        this.regNO = regNO;
    }

    /**
     * 获取统一社会信用代码(CA91)
     *
     * @return UniCode - 统一社会信用代码(CA91)
     */
    public String getUniCode() {
        return uniCode;
    }

    /**
     * 设置统一社会信用代码(CA91)
     *
     * @param uniCode 统一社会信用代码(CA91)
     */
    public void setUniCode(String uniCode) {
        this.uniCode = uniCode;
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
     * 获取企业(机构)名称
     *
     * @return EntName - 企业(机构)名称
     */
    public String getEntName() {
        return entName;
    }

    /**
     * 设置企业(机构)名称
     *
     * @param entName 企业(机构)名称
     */
    public void setEntName(String entName) {
        this.entName = entName;
    }

    /**
     * 获取指定人用户ID
     *
     * @return AssignUserId - 指定人用户ID
     */
    public String getAssignUserId() {
        return assignUserId;
    }

    /**
     * 设置指定人用户ID
     *
     * @param assignUserId 指定人用户ID
     */
    public void setAssignUserId(String assignUserId) {
        this.assignUserId = assignUserId;
    }

    /**
     * 获取指定人用户姓名
     *
     * @return AssignUserName - 指定人用户姓名
     */
    public String getAssignUserName() {
        return assignUserName;
    }

    /**
     * 设置指定人用户姓名
     *
     * @param assignUserName 指定人用户姓名
     */
    public void setAssignUserName(String assignUserName) {
        this.assignUserName = assignUserName;
    }

    /**
     * 获取指定人所在部门ID
     *
     * @return AssignDeptId - 指定人所在部门ID
     */
    public String getAssignDeptId() {
        return assignDeptId;
    }

    /**
     * 设置指定人所在部门ID
     *
     * @param assignDeptId 指定人所在部门ID
     */
    public void setAssignDeptId(String assignDeptId) {
        this.assignDeptId = assignDeptId;
    }

    /**
     * 获取操作人所在部门名称
     *
     * @return AssignDeptName - 操作人所在部门名称
     */
    public String getAssignDeptName() {
        return assignDeptName;
    }

    /**
     * 设置操作人所在部门名称
     *
     * @param assignDeptName 操作人所在部门名称
     */
    public void setAssignDeptName(String assignDeptName) {
        this.assignDeptName = assignDeptName;
    }

    /**
     * 获取是否取消分配
     *
     * @return IsCancleAssign - 是否取消分配
     */
    public String getIsCancleAssign() {
        return isCancleAssign;
    }

    /**
     * 设置是否取消分配
     *
     * @param isCancleAssign 是否取消分配
     */
    public void setIsCancleAssign(String isCancleAssign) {
        this.isCancleAssign = isCancleAssign;
    }

    /**
     * 获取操作时间
     *
     * @return SetTime - 操作时间
     */
    public Date getSetTime() {
        return setTime;
    }

    /**
     * 设置操作时间
     *
     * @param setTime 操作时间
     */
    public void setSetTime(Date setTime) {
        this.setTime = setTime;
    }

    /**
     * 获取设置人员名称
     *
     * @return SetName - 设置人员名称
     */
    public String getSetName() {
        return setName;
    }

    /**
     * 设置设置人员名称
     *
     * @param setName 设置人员名称
     */
    public void setSetName(String setName) {
        this.setName = setName;
    }
}