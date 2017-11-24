/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.system.model;

import com.icinfo.framework.mybatis.mapper.annotation.Before;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * 描述:   用户验证记录 SYS_USER_CHECK_RECORD 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2016年12月20日
 */
@Table(name = "SYS_USER_CHECK_RECORD")
public class SysUserCheckRecord implements Serializable {

    @Id
    @Column(name = "UID")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    private String id;

    /**
     * 登录用户名
     */
    @Column(name = "USER_USERNAME")
    private String userUsername;

    /**
     * 登录密码
     */
    @Column(name = "USER_PASSWORD")
    private String userPassword;

    /**
     * 部门Code
     */
    @Column(name = "OrgCode")
    private String orgcode;

    /**
     * 部门行政编码
     */
    @Column(name = "AdCode")
    private String adcode;

    /**
     * 部门全称
     */
    @Column(name = "DEPT_FULL_NAME")
    private String deptFullName;

    /**
     * 部门简称
     */
    @Column(name = "DEPT_SHORT_NAME")
    private String deptShortName;

    /**
     * 部门地址
     */
    @Column(name = "DEPT_ADDRESS")
    private String deptAddress;

    /**
     * 职能部门编码
     */
    @Column(name = "DUTY_CODES")
    private String dutyCodes;

    /**
     * 职能部门编码
     */
    @Column(name = "DUTY_CODE_NAMES")
    private String dutyCodeNames;

    /**
     * 后置审批事项
     */
    @Column(name = "LIC_ITEMS")
    private String licItems;


    /**
     * 后置审批事项
     */
    @Column(name = "LIC_ITEM_NAMES")
    private String licItemNames;



    /**
     * 后置审批事项
     */
    @Column(name = "LIC_ITEM_NAMES_OLD")
    private String licItemNamesOld;


    /**
     * 职能部门编码
     */
    @Column(name = "DUTY_CODE_NAMES_OLD")
    private String dutyCodeNamesOld;

    /**
     * 真实姓名
     */
    @Column(name = "USER_REAL_NAME")
    private String userRealName;

    /**
     * 性别
     */
    @Column(name = "USER_SEX")
    private String userSex;

    /**
     * 部门科室
     */
    @Column(name = "DEPT_NAME")
    private String deptName;

    /**
     * 职务
     */
    @Column(name = "POST")
    private String post;

    /**
     * 电子邮件
     */
    @Column(name = "USER_EMAIL")
    private String userEmail;

    /**
     * 手机
     */
    @Column(name = "TEL_PHONE")
    private String telPhone;

    /**
     * 座机
     */
    @Column(name = "PHONE")
    private String phone;

    /**
     * 系统用户类型（1：监管系统；2：协同系统）
     */
    @Column(name = "USER_TYPE")
    private String userType;

    /**
     * 手机校验码
     */
    @Column(name = "CHECK_CODE")
    private String checkCode;

    /**
     * 是否成功绑定
     */
    @Column(name = "IS_BIND")
    private String isBind;

    /**
     * 创建时间
     */
    @Column(name = "USER_CREATE_TIME")
    private Date userCreateTime;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getDutyCodeNames() {
        return dutyCodeNames;
    }

    public void setDutyCodeNames(String dutyCodeNames) {
        this.dutyCodeNames = dutyCodeNames;
    }

    public String getLicItemNames() {
        return licItemNames;
    }

    public void setLicItemNames(String licItemNames) {
        this.licItemNames = licItemNames;
    }


    public String getLicItemNamesOld() {
        return licItemNamesOld;
    }

    public void setLicItemNamesOld(String licItemNamesOld) {
        this.licItemNamesOld = licItemNamesOld;
    }

    public String getDutyCodeNamesOld() {
        return dutyCodeNamesOld;
    }

    public void setDutyCodeNamesOld(String dutyCodeNamesOld) {
        this.dutyCodeNamesOld = dutyCodeNamesOld;
    }

    /**
     * 获取登录用户名
     *
     * @return USER_USERNAME - 登录用户名
     */
    public String getUserUsername() {
        return userUsername;
    }

    /**
     * 设置登录用户名
     *
     * @param userUsername 登录用户名
     */
    public void setUserUsername(String userUsername) {
        this.userUsername = userUsername;
    }

    /**
     * 获取登录密码
     *
     * @return USER_PASSWORD - 登录密码
     */
    public String getUserPassword() {
        return userPassword;
    }

    /**
     * 设置登录密码
     *
     * @param userPassword 登录密码
     */
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    /**
     * 获取部门Code
     *
     * @return OrgCode - 部门Code
     */
    public String getOrgcode() {
        return orgcode;
    }

    /**
     * 设置部门Code
     *
     * @param orgcode 部门Code
     */
    public void setOrgcode(String orgcode) {
        this.orgcode = orgcode;
    }

    /**
     * 获取部门行政编码
     *
     * @return AdCode - 部门行政编码
     */
    public String getAdcode() {
        return adcode;
    }

    /**
     * 设置部门行政编码
     *
     * @param adcode 部门行政编码
     */
    public void setAdcode(String adcode) {
        this.adcode = adcode;
    }

    /**
     * 获取部门全称
     *
     * @return DEPT_FULL_NAME - 部门全称
     */
    public String getDeptFullName() {
        return deptFullName;
    }

    /**
     * 设置部门全称
     *
     * @param deptFullName 部门全称
     */
    public void setDeptFullName(String deptFullName) {
        this.deptFullName = deptFullName;
    }

    /**
     * 获取部门简称
     *
     * @return DEPT_SHORT_NAME - 部门简称
     */
    public String getDeptShortName() {
        return deptShortName;
    }

    /**
     * 设置部门简称
     *
     * @param deptShortName 部门简称
     */
    public void setDeptShortName(String deptShortName) {
        this.deptShortName = deptShortName;
    }

    /**
     * 获取部门地址
     *
     * @return DEPT_ADDRESS - 部门地址
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
     * 获取职能部门编码
     *
     * @return DUTY_CODES - 职能部门编码
     */
    public String getDutyCodes() {
        return dutyCodes;
    }

    /**
     * 设置职能部门编码
     *
     * @param dutyCodes 职能部门编码
     */
    public void setDutyCodes(String dutyCodes) {
        this.dutyCodes = dutyCodes;
    }

    /**
     * 获取后置审批事项
     *
     * @return LIC_ITEMS - 后置审批事项
     */
    public String getLicItems() {
        return licItems;
    }

    /**
     * 设置后置审批事项
     *
     * @param licItems 后置审批事项
     */
    public void setLicItems(String licItems) {
        this.licItems = licItems;
    }

    /**
     * 获取真实姓名
     *
     * @return USER_REAL_NAME - 真实姓名
     */
    public String getUserRealName() {
        return userRealName;
    }

    /**
     * 设置真实姓名
     *
     * @param userRealName 真实姓名
     */
    public void setUserRealName(String userRealName) {
        this.userRealName = userRealName;
    }

    /**
     * 获取性别
     *
     * @return USER_SEX - 性别
     */
    public String getUserSex() {
        return userSex;
    }

    /**
     * 设置性别
     *
     * @param userSex 性别
     */
    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    /**
     * 获取部门科室
     *
     * @return DEPT_NAME - 部门科室
     */
    public String getDeptName() {
        return deptName;
    }

    /**
     * 设置部门科室
     *
     * @param deptName 部门科室
     */
    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    /**
     * 获取职务
     *
     * @return POST - 职务
     */
    public String getPost() {
        return post;
    }

    /**
     * 设置职务
     *
     * @param post 职务
     */
    public void setPost(String post) {
        this.post = post;
    }

    /**
     * 获取电子邮件
     *
     * @return USER_EMAIL - 电子邮件
     */
    public String getUserEmail() {
        return userEmail;
    }

    /**
     * 设置电子邮件
     *
     * @param userEmail 电子邮件
     */
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    /**
     * 获取手机
     *
     * @return TEL_PHONE - 手机
     */
    public String getTelPhone() {
        return telPhone;
    }

    /**
     * 设置手机
     *
     * @param telPhone 手机
     */
    public void setTelPhone(String telPhone) {
        this.telPhone = telPhone;
    }

    /**
     * 获取座机
     *
     * @return PHONE - 座机
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置座机
     *
     * @param phone 座机
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获取系统用户类型（1：监管系统；2：协同系统）
     *
     * @return USER_TYPE - 系统用户类型（1：监管系统；2：协同系统）
     */
    public String getUserType() {
        return userType;
    }

    /**
     * 设置系统用户类型（1：监管系统；2：协同系统）
     *
     * @param userType 系统用户类型（1：监管系统；2：协同系统）
     */
    public void setUserType(String userType) {
        this.userType = userType;
    }

    /**
     * 获取手机校验码
     *
     * @return CHECK_CODE - 手机校验码
     */
    public String getCheckCode() {
        return checkCode;
    }

    /**
     * 设置手机校验码
     *
     * @param checkCode 手机校验码
     */
    public void setCheckCode(String checkCode) {
        this.checkCode = checkCode;
    }

    /**
     * 获取是否成功绑定
     *
     * @return IS_BIND - 是否成功绑定
     */
    public String getIsBind() {
        return isBind;
    }

    /**
     * 设置是否成功绑定
     *
     * @param isBind 是否成功绑定
     */
    public void setIsBind(String isBind) {
        this.isBind = isBind;
    }

    /**
     * 获取创建时间
     *
     * @return USER_CREATE_TIME - 创建时间
     */
    public Date getUserCreateTime() {
        return userCreateTime;
    }

    /**
     * 设置创建时间
     *
     * @param userCreateTime 创建时间
     */
    public void setUserCreateTime(Date userCreateTime) {
        this.userCreateTime = userCreateTime;
    }
}