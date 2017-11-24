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
 * 描述:    cs_code_right_type 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年09月25日
 */
@Table(name = "cs_code_right_type")
public class CodeRightType implements Serializable {
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
     * 专业资格资质编码
     */
    @Column(name = "RightCode")
    private String rightCode;

    /**
     * 专业资格资质描述
     */
    @Column(name = "RightName")
    private String rightName;

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

    /**
     * 设置人UId
     */
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
     * 说明
     */
    @Column(name = "Remark")
    private String remark;

    /**
     * 职能部门名称
     */
    @Column(name = "DutyDeptName")
    private String dutyDeptName;

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
     * 获取专业资格资质编码
     *
     * @return RightCode - 专业资格资质编码
     */
    public String getRightCode() {
        return rightCode;
    }

    /**
     * 设置专业资格资质编码
     *
     * @param rightCode 专业资格资质编码
     */
    public void setRightCode(String rightCode) {
        this.rightCode = rightCode;
    }

    /**
     * 获取专业资格资质描述
     *
     * @return RightName - 专业资格资质描述
     */
    public String getRightName() {
        return rightName;
    }

    /**
     * 设置专业资格资质描述
     *
     * @param rightName 专业资格资质描述
     */
    public void setRightName(String rightName) {
        this.rightName = rightName;
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
     * 获取设置人UId
     *
     * @return SetUserUid - 设置人UId
     */
    public String getSetUserUid() {
        return setUserUid;
    }

    /**
     * 设置设置人UId
     *
     * @param setUserUid 设置人UId
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

    /**
     * 获取职能部门名称
     *
     * @return DutyDeptName - 职能部门名称
     */
    public String getDutyDeptName() {
        return dutyDeptName;
    }

    /**
     * 设置职能部门名称
     *
     * @param dutyDeptName 职能部门名称
     */
    public void setDutyDeptName(String dutyDeptName) {
        this.dutyDeptName = dutyDeptName;
    }
}