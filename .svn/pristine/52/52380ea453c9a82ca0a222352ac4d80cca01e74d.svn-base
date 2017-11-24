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
 * 描述:    cs_delegate_record 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2016年09月22日
 */
@Table(name = "cs_ent_delegate_record")
public class EntDelegateRecord implements Serializable {
    @Id
    @Column(name = "ID")
    private Integer ID;

    @Column(name = "UID")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    private String UID;

    /**
     * 企业名称
     */
    @Column(name = "EntName")
    private String entName;

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
     * 委托机关
     */
    @Column(name = "DelegateOrg")
    private String delegateOrg;



    @Column(name = "UserId")
    private String userId;

    /**
     * 操作人
     */
    @Column(name = "Username")
    private String username;

    /**
     * 操作人所在部门
     */
    @Column(name = "AppReviewOrg")
    private String appReviewOrg;


    /**
     * 委托机关名称
     */
    @Column(name = "DelegateOrgName")
    private String delegateOrgName;

    /**
     * 操作人所在部门名称
     *
     */
    @Column(name = "AppReviewOrgName")
    private String appReviewOrgName;


    public String getRegNO() {
        return regNO;
    }

    public void setRegNO(String regNO) {
        this.regNO = regNO;
    }

    public String getUniCode() {
        return uniCode;
    }

    public void setUniCode(String uniCode) {
        this.uniCode = uniCode;
    }

    public String getAppReviewOrgName() {
        return appReviewOrgName;
    }

    public void setAppReviewOrgName(String appReviewOrgName) {
        this.appReviewOrgName = appReviewOrgName;
    }

    public String getDelegateOrgName() {
        return delegateOrgName;
    }

    public void setDelegateOrgName(String delegateOrgName) {
        this.delegateOrgName = delegateOrgName;
    }

    public String getEntName() {
        return entName;
    }

    public void setEntName(String entName) {
        this.entName = entName;
    }


    /**
     * 操作时间
     */
    @Column(name = "SetTime")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date setTime;

    /**
     * 是否取消委托
     */
    @Column(name = "IsCancle")
    private String isCancle;

    private static final long serialVersionUID = 1L;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

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
     * 获取委托机关
     *
     * @return DelegateOrg - 委托机关
     */
    public String getDelegateOrg() {
        return delegateOrg;
    }

    /**
     * 设置委托机关
     *
     * @param delegateOrg 委托机关
     */
    public void setDelegateOrg(String delegateOrg) {
        this.delegateOrg = delegateOrg;
    }

    /**
     * 获取操作人
     *
     * @return Username - 操作人
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置操作人
     *
     * @param username 操作人
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取操作人所在部门
     *
     * @return AppReviewOrg - 操作人所在部门
     */
    public String getAppReviewOrg() {
        return appReviewOrg;
    }

    /**
     * 设置操作人所在部门
     *
     * @param appReviewOrg 操作人所在部门
     */
    public void setAppReviewOrg(String appReviewOrg) {
        this.appReviewOrg = appReviewOrg;
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
     * 获取是否取消委托
     *
     * @return IsCancle - 是否取消委托
     */
    public String getIsCancle() {
        return isCancle;
    }

    /**
     * 设置是否取消委托
     *
     * @param isCancle 是否取消委托
     */
    public void setIsCancle(String isCancle) {
        this.isCancle = isCancle;
    }
}