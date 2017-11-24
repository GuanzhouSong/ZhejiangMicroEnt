/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.datamodify.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.icinfo.framework.mybatis.mapper.annotation.Before;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * 描述:  cs_apply_data_modify 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年11月22日
 */
@Table(name = "cs_apply_data_modify")
public class ApplyDataModify implements Serializable {
    @Id
    @Column(name = "id")
    private Integer id;


    @Column(name = "Uid")
    private String uid;

    /**
     * 数据修正类型
     */
    @Column(name = "ModifyType")
    private String modifyType;

    /**
     * 主体身份代码
     */
    @Column(name = "PriPID")
    private String priPID;

    /**
     * 统一代码(或注册号)
     */
    @Column(name = "UniCode")
    private String uniCode;

    /**
     * 企业名称
     */
    @Column(name = "EntName")
    private String entName;

    /**
     * 申请人
     */
    @Column(name = "ApplyPerson")
    private String applyPerson;

    /**
     * 申请日期
     */
    @Column(name = "ApplyDate")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date applyDate;

    /**
     * 联系电话
     */
    @Column(name = "Phone")
    private String phone;

    /**
     * 申请内容
     */
    @Column(name = "ApplyContent")
    private String applyContent;

    /**
     * 反馈日期
     */
    @Column(name = "FeedbackDate")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date feedbackDate;

    /**
     * 备注
     */
    @Column(name = "Remark")
    private String remark;

    /**
     * 创建时间
     */
    @Column(name = "CreateTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
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
     * @return Uid
     */
    public String getUid() {
        return uid;
    }

    /**
     * @param uid
     */
    public void setUid(String uid) {
        this.uid = uid;
    }

    /**
     * 获取数据修正类型
     *
     * @return ModifyType - 数据修正类型
     */
    public String getModifyType() {
        return modifyType;
    }

    /**
     * 设置数据修正类型
     *
     * @param modifyType 数据修正类型
     */
    public void setModifyType(String modifyType) {
        this.modifyType = modifyType;
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
     * 获取统一代码(或注册号)
     *
     * @return UniCode - 统一代码(或注册号)
     */
    public String getUniCode() {
        return uniCode;
    }

    /**
     * 设置统一代码(或注册号)
     *
     * @param uniCode 统一代码(或注册号)
     */
    public void setUniCode(String uniCode) {
        this.uniCode = uniCode;
    }

    /**
     * 获取企业名称
     *
     * @return EntName - 企业名称
     */
    public String getEntName() {
        return entName;
    }

    /**
     * 设置企业名称
     *
     * @param entName 企业名称
     */
    public void setEntName(String entName) {
        this.entName = entName;
    }

    /**
     * 获取申请人
     *
     * @return ApplyPerson - 申请人
     */
    public String getApplyPerson() {
        return applyPerson;
    }

    /**
     * 设置申请人
     *
     * @param applyPerson 申请人
     */
    public void setApplyPerson(String applyPerson) {
        this.applyPerson = applyPerson;
    }

    /**
     * 获取申请日期
     *
     * @return ApplyDate - 申请日期
     */
    public Date getApplyDate() {
        return applyDate;
    }

    /**
     * 设置申请日期
     *
     * @param applyDate 申请日期
     */
    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }

    /**
     * 获取联系电话
     *
     * @return Phone - 联系电话
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置联系电话
     *
     * @param phone 联系电话
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获取申请内容
     *
     * @return ApplyContent - 申请内容
     */
    public String getApplyContent() {
        return applyContent;
    }

    /**
     * 设置申请内容
     *
     * @param applyContent 申请内容
     */
    public void setApplyContent(String applyContent) {
        this.applyContent = applyContent;
    }

    /**
     * 获取反馈日期
     *
     * @return FeedbackDate - 反馈日期
     */
    public Date getFeedbackDate() {
        return feedbackDate;
    }

    /**
     * 设置反馈日期
     *
     * @param feedbackDate 反馈日期
     */
    public void setFeedbackDate(Date feedbackDate) {
        this.feedbackDate = feedbackDate;
    }

    /**
     * 获取备注
     *
     * @return Remark - 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注
     *
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
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
}