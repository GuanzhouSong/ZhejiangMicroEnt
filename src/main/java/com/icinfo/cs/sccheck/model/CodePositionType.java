/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.sccheck.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.icinfo.framework.mybatis.mapper.annotation.Before;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * 描述:    cs_code_position_type 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年09月25日
 */
@Table(name = "cs_code_position_type")
public class CodePositionType implements Serializable {
    /**
     * 序号
     */
    @Id
    @Column(name = "id")
    private Integer id;

    /**
     * uid
     */
    @Column(name = "Uid")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    private String uid;

    /**
     * 人员岗位大类编码
     */
    @Column(name = "PositionCode")
    private String positionCode;

    /**
     * 人员岗位大类描述
     */
    @Column(name = "PositionName")
    private String positionName;

    /**
     * 状态
     */
    @Column(name = "IsVlid")
    private String isVlid;

    /**
     * 创建日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @Column(name = "CreatTime")
    private Date creatTime;

    @Column(name = "SetUserUid")
    private String setUserUid;

    /**
     * 设置人姓名
     */
    @Column(name = "SetUserName")
    private String setUserName;

    /**
     * 设置部门编码
     */
    @Column(name = "SetDeptCode")
    private String setDeptCode;

    /**
     * 职能部门编码
     */
    @Column(name = "DutyDeptCode")
    private String dutyDeptCode;

    /**
     * 职能部门描述
     */
    @Column(name = "DutyDeptName")
    private String dutyDeptName;

    /**
     * 说明
     */
    @Column(name = "Remark")
    private String remark;

    private static final long serialVersionUID = 1L;

    /**
     * 获取序号
     *
     * @return id - 序号
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置序号
     *
     * @param id 序号
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取uid
     *
     * @return Uid - uid
     */
    public String getUid() {
        return uid;
    }

    /**
     * 设置uid
     *
     * @param uid uid
     */
    public void setUid(String uid) {
        this.uid = uid;
    }

    /**
     * 获取人员岗位大类编码
     *
     * @return PositionCode - 人员岗位大类编码
     */
    public String getPositionCode() {
        return positionCode;
    }

    /**
     * 设置人员岗位大类编码
     *
     * @param positionCode 人员岗位大类编码
     */
    public void setPositionCode(String positionCode) {
        this.positionCode = positionCode;
    }

    /**
     * 获取人员岗位大类描述
     *
     * @return PositionName - 人员岗位大类描述
     */
    public String getPositionName() {
        return positionName;
    }

    /**
     * 设置人员岗位大类描述
     *
     * @param positionName 人员岗位大类描述
     */
    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    /**
     * 获取状态
     *
     * @return IsVlid - 状态
     */
    public String getIsVlid() {
        return isVlid;
    }

    /**
     * 设置状态
     *
     * @param isVlid 状态
     */
    public void setIsVlid(String isVlid) {
        this.isVlid = isVlid;
    }

    /**
     * 获取创建日期
     *
     * @return CreatTime - 创建日期
     */
    public Date getCreatTime() {
        return creatTime;
    }

    /**
     * 设置创建日期
     *
     * @param creatTime 创建日期
     */
    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    /**
     * @return SetUserUid
     */
    public String getSetUserUid() {
        return setUserUid;
    }

    /**
     * @param setUserUid
     */
    public void setSetUserUid(String setUserUid) {
        this.setUserUid = setUserUid;
    }

    /**
     * 获取设置人姓名
     *
     * @return SetUserName - 设置人姓名
     */
    public String getSetUserName() {
        return setUserName;
    }

    /**
     * 设置设置人姓名
     *
     * @param setUserName 设置人姓名
     */
    public void setSetUserName(String setUserName) {
        this.setUserName = setUserName;
    }

    /**
     * 获取设置部门编码
     *
     * @return SetDeptCode - 设置部门编码
     */
    public String getSetDeptCode() {
        return setDeptCode;
    }

    /**
     * 设置设置部门编码
     *
     * @param setDeptCode 设置部门编码
     */
    public void setSetDeptCode(String setDeptCode) {
        this.setDeptCode = setDeptCode;
    }

    /**
     * 获取职能部门编码
     *
     * @return DutyDeptCode - 职能部门编码
     */
    public String getDutyDeptCode() {
        return dutyDeptCode;
    }

    /**
     * 设置职能部门编码
     *
     * @param dutyDeptCode 职能部门编码
     */
    public void setDutyDeptCode(String dutyDeptCode) {
        this.dutyDeptCode = dutyDeptCode;
    }

    /**
     * 获取职能部门描述
     *
     * @return DutyDeptName - 职能部门描述
     */
    public String getDutyDeptName() {
        return dutyDeptName;
    }

    /**
     * 设置职能部门描述
     *
     * @param dutyDeptName 职能部门描述
     */
    public void setDutyDeptName(String dutyDeptName) {
        this.dutyDeptName = dutyDeptName;
    }

    /**
     * 获取说明
     *
     * @return Remark - 说明
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置说明
     *
     * @param remark 说明
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }
}