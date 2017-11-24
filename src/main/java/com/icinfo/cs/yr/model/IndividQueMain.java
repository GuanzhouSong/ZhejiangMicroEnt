/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.yr.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.icinfo.framework.mybatis.mapper.annotation.Before;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * 描述:    cs_individ_quemain 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2016年09月24日
 */
@Table(name = "cs_individ_quemain")
public class IndividQueMain implements Serializable {
    /**
     * 主键ID
     */
    @Id
    @Column(name = "id")
    private Integer id;

    /**
     * 个转企序号ID
     */
    @Column(name = "QmID")
    private String qmID;

    /**
     * 主体代码
     */
    @Column(name = "PriPID")
    private String priPID;

    /**
     * 年度
     */
    @Column(name = "Year")
    private Integer year;

    /**
     * 优惠政策兑现情况-财政一次性奖励
     */
    @Column(name = "QuePolicyAll")
    private String quePolicyAll;

    /**
     * 优惠政策兑现情况-部分补贴
     */
    @Column(name = "QuePolicyPart")
    private String quePolicyPart;

    /**
     * 优惠政策兑现情况 -社保补贴
     */
    @Column(name = "QuePolicySoc")
    private String quePolicySoc;

    /**
     * 填报人
     */
    @Column(name = "SetName")
    private String setName;

    /**
     * 电话
     */
    @Column(name = "Tel")
    private String tel;

    /**
     * 手机号码
     */
    @Column(name = "MobTel")
    private String mobTel;

    /**
     * 填报时间
     */
    @Column(name = "SetTime")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date setTime;

    /**
     * 审核状态
     */
    @Column(name = "AuditState")
    private String auditState;

    /**
     * 审核人
     */
    @Column(name = "AuditName")
    private String auditName;

    /**
     * 审核日期
     */
    @Column(name = "AuditDate")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8") 
    private Date auditDate;

    /**
     * 做大做强信心1有信心，2无信心，3不确定
     */
    @Column(name = "QueFaith")
    private String queFaith;

    /**
     * 时间戳
     */
    @Column(name = "CreateTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8") 
    private Date createTime;

    private static final long serialVersionUID = 1L;

    /**
     * 获取主键ID
     *
     * @return id - 主键ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置主键ID
     *
     * @param id 主键ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取个转企序号ID
     *
     * @return QmID - 个转企序号ID
     */
    public String getQmID() {
        return qmID;
    }

    /**
     * 设置个转企序号ID
     *
     * @param qmID 个转企序号ID
     */
    public void setQmID(String qmID) {
        this.qmID = qmID;
    }

    /**
     * 获取主体代码
     *
     * @return PriPID - 主体代码
     */
    public String getPriPID() {
        return priPID;
    }

    /**
     * 设置主体代码
     *
     * @param priPID 主体代码
     */
    public void setPriPID(String priPID) {
        this.priPID = priPID;
    }

    /**
     * 获取年度
     *
     * @return Year - 年度
     */
    public Integer getYear() {
        return year;
    }

    /**
     * 设置年度
     *
     * @param year 年度
     */
    public void setYear(Integer year) {
        this.year = year;
    }

    /**
     * 获取优惠政策兑现情况-财政一次性奖励
     *
     * @return QuePolicyAll - 优惠政策兑现情况-财政一次性奖励
     */
    public String getQuePolicyAll() {
        return quePolicyAll;
    }

    /**
     * 设置优惠政策兑现情况-财政一次性奖励
     *
     * @param quePolicyAll 优惠政策兑现情况-财政一次性奖励
     */
    public void setQuePolicyAll(String quePolicyAll) {
        this.quePolicyAll = quePolicyAll;
    }

    /**
     * 获取优惠政策兑现情况-部分补贴
     *
     * @return QuePolicyPart - 优惠政策兑现情况-部分补贴
     */
    public String getQuePolicyPart() {
        return quePolicyPart;
    }

    /**
     * 设置优惠政策兑现情况-部分补贴
     *
     * @param quePolicyPart 优惠政策兑现情况-部分补贴
     */
    public void setQuePolicyPart(String quePolicyPart) {
        this.quePolicyPart = quePolicyPart;
    }

    /**
     * 获取优惠政策兑现情况 -社保补贴
     *
     * @return QuePolicySoc - 优惠政策兑现情况 -社保补贴
     */
    public String getQuePolicySoc() {
        return quePolicySoc;
    }

    /**
     * 设置优惠政策兑现情况 -社保补贴
     *
     * @param quePolicySoc 优惠政策兑现情况 -社保补贴
     */
    public void setQuePolicySoc(String quePolicySoc) {
        this.quePolicySoc = quePolicySoc;
    }

    /**
     * 获取填报人
     *
     * @return SetName - 填报人
     */
    public String getSetName() {
        return setName;
    }

    /**
     * 设置填报人
     *
     * @param setName 填报人
     */
    public void setSetName(String setName) {
        this.setName = setName;
    }

    /**
     * 获取电话
     *
     * @return Tel - 电话
     */
    public String getTel() {
        return tel;
    }

    /**
     * 设置电话
     *
     * @param tel 电话
     */
    public void setTel(String tel) {
        this.tel = tel;
    }

    /**
     * 获取手机号码
     *
     * @return MobTel - 手机号码
     */
    public String getMobTel() {
        return mobTel;
    }

    /**
     * 设置手机号码
     *
     * @param mobTel 手机号码
     */
    public void setMobTel(String mobTel) {
        this.mobTel = mobTel;
    }

    /**
     * 获取填报时间
     *
     * @return SetTime - 填报时间
     */
    public Date getSetTime() {
        return setTime;
    }

    /**
     * 设置填报时间
     *
     * @param setTime 填报时间
     */
    public void setSetTime(Date setTime) {
        this.setTime = setTime;
    }

    /**
     * 获取审核状态
     *
     * @return AuditState - 审核状态
     */
    public String getAuditState() {
        return auditState;
    }

    /**
     * 设置审核状态
     *
     * @param auditState 审核状态
     */
    public void setAuditState(String auditState) {
        this.auditState = auditState;
    }

    /**
     * 获取审核人
     *
     * @return AuditName - 审核人
     */
    public String getAuditName() {
        return auditName;
    }

    /**
     * 设置审核人
     *
     * @param auditName 审核人
     */
    public void setAuditName(String auditName) {
        this.auditName = auditName;
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

    /**
     * 获取做大做强信心1有信心，2无信心，3不确定
     *
     * @return QueFaith - 做大做强信心1有信心，2无信心，3不确定
     */
    public String getQueFaith() {
        return queFaith;
    }

    /**
     * 设置做大做强信心1有信心，2无信心，3不确定
     *
     * @param queFaith 做大做强信心1有信心，2无信心，3不确定
     */
    public void setQueFaith(String queFaith) {
        this.queFaith = queFaith;
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