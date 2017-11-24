/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.yr.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 描述:    cs_department 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2016年09月20日
 */
@Table(name = "cs_department")
public class DepartMent implements Serializable {
    /**
     * 序号
     */
    @Id
    @Column(name = "id")
    private Integer id;

    /**
     * 部门树节点值
     */
    @Column(name = "DeptDID")
    private String deptDID;

    /**
     * 对应父节点值
     */
    @Column(name = "DeptPID")
    private String deptPID;

    /**
     * 部门名称
     */
    @Column(name = "DeptName")
    private String deptName;

    /**
     * 简称
     */
    @Column(name = "DeptShortName")
    private String deptShortName;

    /**
     * 树层级
     */
    @Column(name = "NodeLevel")
    private String nodeLevel;

    /**
     * 是否叶子
     */
    @Column(name = "IsLeaf")
    private String isLeaf;

    /**
     * 是否有效
     */
    @Column(name = "IsValid")
    private String isValid;

    /**
     * 排序
     */
    @Column(name = "Sort")
    private Integer sort;

    /**
     * 部门编码值
     */
    @Column(name = "DeptCode")
    private String deptCode;

    /**
     * 部门地址
     */
    @Column(name = "DeptAddress")
    private String deptAddress;

    /**
     * 部门电话
     */
    @Column(name = "DeptTel")
    private String deptTel;

    /**
     * 部门电话是否公开 0 不公开 1 公开
     */
    @Column(name = "IsPub")
    private String isPub;

    /**
     * 邮编
     */
    @Column(name = "PostalCode")
    private String postalCode;

    /**
     * 备注表述
     */
    @Column(name = "Remark")
    private String remark;

    /**
     * 设置人
     */
    @Column(name = "Setter")
    private String setter;

    /**
     * 设置日期
     */
    @Column(name = "SetDate")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8") 
    private Date setDate;

    /**
     * 部门类型1：工商 2：农业 3:金融
     */
    @Column(name = "DeptType")
    private String deptType;

    /**
     * 文号简称
     */
    @Column(name = "DocShortName")
    private String docShortName;

    /**
     * 同级人民政府
     */
    @Column(name = "SameGov")
    private String sameGov;

    /**
     * 同级人民法院
     */
    @Column(name = "SameCourt")
    private String sameCourt;

    /**
     * 设置人-部门名称规范维护
     */
    @Column(name = "SetName")
    private String setName;

    /**
     * 设置时间-部门名称规范维护
     */
    @Column(name = "SetTime")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8") 
    private Date setTime;

    /**
     * 上级机关名称
     */
    @Column(name = "DeptUpName")
    private String deptUpName;

    /**
     * 时间戳
     */
    @Column(name = "CreateTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8") 
    private Date createTime;

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
     * 获取部门树节点值
     *
     * @return DeptDID - 部门树节点值
     */
    public String getDeptDID() {
        return deptDID;
    }

    /**
     * 设置部门树节点值
     *
     * @param deptDID 部门树节点值
     */
    public void setDeptDID(String deptDID) {
        this.deptDID = deptDID;
    }

    /**
     * 获取对应父节点值
     *
     * @return DeptPID - 对应父节点值
     */
    public String getDeptPID() {
        return deptPID;
    }

    /**
     * 设置对应父节点值
     *
     * @param deptPID 对应父节点值
     */
    public void setDeptPID(String deptPID) {
        this.deptPID = deptPID;
    }

    /**
     * 获取部门名称
     *
     * @return DeptName - 部门名称
     */
    public String getDeptName() {
        return deptName;
    }

    /**
     * 设置部门名称
     *
     * @param deptName 部门名称
     */
    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    /**
     * 获取简称
     *
     * @return DeptShortName - 简称
     */
    public String getDeptShortName() {
        return deptShortName;
    }

    /**
     * 设置简称
     *
     * @param deptShortName 简称
     */
    public void setDeptShortName(String deptShortName) {
        this.deptShortName = deptShortName;
    }

    /**
     * 获取树层级
     *
     * @return NodeLevel - 树层级
     */
    public String getNodeLevel() {
        return nodeLevel;
    }

    /**
     * 设置树层级
     *
     * @param nodeLevel 树层级
     */
    public void setNodeLevel(String nodeLevel) {
        this.nodeLevel = nodeLevel;
    }

    /**
     * 获取是否叶子
     *
     * @return IsLeaf - 是否叶子
     */
    public String getIsLeaf() {
        return isLeaf;
    }

    /**
     * 设置是否叶子
     *
     * @param isLeaf 是否叶子
     */
    public void setIsLeaf(String isLeaf) {
        this.isLeaf = isLeaf;
    }

    /**
     * 获取是否有效
     *
     * @return IsValid - 是否有效
     */
    public String getIsValid() {
        return isValid;
    }

    /**
     * 设置是否有效
     *
     * @param isValid 是否有效
     */
    public void setIsValid(String isValid) {
        this.isValid = isValid;
    }

    /**
     * 获取排序
     *
     * @return Sort - 排序
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 设置排序
     *
     * @param sort 排序
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     * 获取部门编码值
     *
     * @return DeptCode - 部门编码值
     */
    public String getDeptCode() {
        return deptCode;
    }

    /**
     * 设置部门编码值
     *
     * @param deptCode 部门编码值
     */
    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    /**
     * 获取部门地址
     *
     * @return DeptAddress - 部门地址
     */
    public String getDeptAddress() {
        return deptAddress;
    }

    /**
     * 设置部门地址
     *
     * @param deptAddress 部门地址
     */
    public void setDeptAddress(String deptAddress) {
        this.deptAddress = deptAddress;
    }

    /**
     * 获取部门电话
     *
     * @return DeptTel - 部门电话
     */
    public String getDeptTel() {
        return deptTel;
    }

    /**
     * 设置部门电话
     *
     * @param deptTel 部门电话
     */
    public void setDeptTel(String deptTel) {
        this.deptTel = deptTel;
    }

    /**
     * 获取部门电话是否公开 0 不公开 1 公开
     *
     * @return IsPub - 部门电话是否公开 0 不公开 1 公开
     */
    public String getIsPub() {
        return isPub;
    }

    /**
     * 设置部门电话是否公开 0 不公开 1 公开
     *
     * @param isPub 部门电话是否公开 0 不公开 1 公开
     */
    public void setIsPub(String isPub) {
        this.isPub = isPub;
    }

    /**
     * 获取邮编
     *
     * @return PostalCode - 邮编
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * 设置邮编
     *
     * @param postalCode 邮编
     */
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    /**
     * 获取备注表述
     *
     * @return Remark - 备注表述
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注表述
     *
     * @param remark 备注表述
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * 获取设置人
     *
     * @return Setter - 设置人
     */
    public String getSetter() {
        return setter;
    }

    /**
     * 设置设置人
     *
     * @param setter 设置人
     */
    public void setSetter(String setter) {
        this.setter = setter;
    }

    /**
     * 获取设置日期
     *
     * @return SetDate - 设置日期
     */
    public Date getSetDate() {
        return setDate;
    }

    /**
     * 设置设置日期
     *
     * @param setDate 设置日期
     */
    public void setSetDate(Date setDate) {
        this.setDate = setDate;
    }

    /**
     * 获取部门类型1：工商 2：农业 3:金融
     *
     * @return DeptType - 部门类型1：工商 2：农业 3:金融
     */
    public String getDeptType() {
        return deptType;
    }

    /**
     * 设置部门类型1：工商 2：农业 3:金融
     *
     * @param deptType 部门类型1：工商 2：农业 3:金融
     */
    public void setDeptType(String deptType) {
        this.deptType = deptType;
    }

    /**
     * 获取文号简称
     *
     * @return DocShortName - 文号简称
     */
    public String getDocShortName() {
        return docShortName;
    }

    /**
     * 设置文号简称
     *
     * @param docShortName 文号简称
     */
    public void setDocShortName(String docShortName) {
        this.docShortName = docShortName;
    }

    /**
     * 获取同级人民政府
     *
     * @return SameGov - 同级人民政府
     */
    public String getSameGov() {
        return sameGov;
    }

    /**
     * 设置同级人民政府
     *
     * @param sameGov 同级人民政府
     */
    public void setSameGov(String sameGov) {
        this.sameGov = sameGov;
    }

    /**
     * 获取同级人民法院
     *
     * @return SameCourt - 同级人民法院
     */
    public String getSameCourt() {
        return sameCourt;
    }

    /**
     * 设置同级人民法院
     *
     * @param sameCourt 同级人民法院
     */
    public void setSameCourt(String sameCourt) {
        this.sameCourt = sameCourt;
    }

    /**
     * 获取设置人-部门名称规范维护
     *
     * @return SetName - 设置人-部门名称规范维护
     */
    public String getSetName() {
        return setName;
    }

    /**
     * 设置设置人-部门名称规范维护
     *
     * @param setName 设置人-部门名称规范维护
     */
    public void setSetName(String setName) {
        this.setName = setName;
    }

    /**
     * 获取设置时间-部门名称规范维护
     *
     * @return SetTime - 设置时间-部门名称规范维护
     */
    public Date getSetTime() {
        return setTime;
    }

    /**
     * 设置设置时间-部门名称规范维护
     *
     * @param setTime 设置时间-部门名称规范维护
     */
    public void setSetTime(Date setTime) {
        this.setTime = setTime;
    }

    /**
     * 获取上级机关名称
     *
     * @return DeptUpName - 上级机关名称
     */
    public String getDeptUpName() {
        return deptUpName;
    }

    /**
     * 设置上级机关名称
     *
     * @param deptUpName 上级机关名称
     */
    public void setDeptUpName(String deptUpName) {
        this.deptUpName = deptUpName;
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