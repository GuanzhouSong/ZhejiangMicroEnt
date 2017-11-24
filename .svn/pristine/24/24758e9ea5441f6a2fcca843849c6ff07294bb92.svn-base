/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.party.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.icinfo.framework.mybatis.mapper.annotation.Before;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * 描述:    cs_party_activity_info 对应的实体类.（党建活动信息表）<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年09月04日
 */
@Table(name = "cs_party_activity_info")
public class PartyActivityInfo implements Serializable {
    @Id
    @Column(name = "id")
    private Integer id;

    /**
     * 唯一标识
     */
    @Column(name = "UID")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    private String UID;

    /**
     * 活动名称
     */
    @Column(name = "ActivityName")
    private String activityName;

    /**
     * 活动类别（1重点常规活动 2党员日常活动）
     */
    @Column(name = "ActivityType")
    private String activityType;

    /**
     * 活动内容
     */
    @Column(name = "ActivityContent")
    private String activityContent;

    /**
     * 活动发布日期
     */
    @Column(name = "PublishDate")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date publishDate;

    /**
     * 要求活动结束时间
     */
    @Column(name = "RequireEndDate")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date requireEndDate;

    /**
     * 活动发布部门名称
     */
    @Column(name = "PublishDeptName")
    private String publishDeptName;

    /**
     * 活动发布部门UID
     */
    @Column(name = "PublishDeptUID")
    private String publishDeptUID;

    /**
     * 活动接收部门名称（所在党组织）
     */
    @Column(name = "ClaimDeptName")
    private String claimDeptName;

    /**
     * 活动接收部门UID
     */
    @Column(name = "ClaimDeptUID")
    private String claimDeptUID;

    /**
     * 接收部门对应管辖单位编码
     */
    @Column(name = "ClaimLocalAdm")
    private String claimLocalAdm;

    /**
     * 接收部门对应管辖单位名称
     */
    @Column(name = "ClaimLocalAdmName")
    private String claimLocalAdmName;

    /**
     * 活动录入员账号
     */
    @Column(name = "InputCode")
    private String inputCode;

    /**
     * 活动录入员姓名
     */
    @Column(name = "InputName")
    private String inputName;

    /**
     * 活动录入时间
     */
    @Column(name = "InputDate")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date inputDate;

    /**
     * 活动附件
     */
    @Column(name = "UpfilePath")
    private String upfilePath;

    /**
     * 创建时间
     */
    @Column(name = "CreateTime")
    private Date createTime;

   
    /**
     * 录入状态：0待录入1已录入
     */
    @Column(name = "InputState")
    private String inputState;
        
    
    /**
     * 活动地点
     */
    @Column(name = "ActivityPlace")
    private String activityPlace;

    /**
     * 活动开始时间
     */
    @Column(name = "ActivitybeginDate")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date activitybeginDate;

    /**
     * 活动结束时间
     */
    @Column(name = "ActivityEndDate")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date activityEndDate;

    /**
     * 活动发起人
     */
    @Column(name = "Originator")
    private String originator;

    /**
     * 活动发起人ID
     */
    @Column(name = "OriginatorID")
    private String originatorID;

    /**
     * 参与人数
     */
    @Column(name = "JoinNum")
    private Integer joinNum;

    /**
     * 参与人
     */
    @Column(name = "Joiner")
    private String joiner;

    /**
     * 参与人ID
     */
    @Column(name = "JoinerId")
    private String joinerId;

    /**
     * 活动情况
     */
    @Column(name = "ActivitySituation")
    private String activitySituation;

    /**
     * 结果附件
     */
    @Column(name = "ResultFilePath")
    private String resultFilePath;

    /**
     * 结果录入人账号
     */
    @Column(name = "ResultInputCode")
    private String resultInputCode;

    /**
     * 结果录入人
     */
    @Column(name = "ResultInputName")
    private String resultInputName;

    /**
     * 结果录入人时间
     */
    @Column(name = "ResultInputDate")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date resultInputDate;

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
     * 获取唯一标识
     *
     * @return UID - 唯一标识
     */
    public String getUID() {
        return UID;
    }

    /**
     * 设置唯一标识
     *
     * @param UID 唯一标识
     */
    public void setUID(String UID) {
        this.UID = UID;
    }

    /**
     * 获取活动名称
     *
     * @return ActivityName - 活动名称
     */
    public String getActivityName() {
        return activityName;
    }

    /**
     * 设置活动名称
     *
     * @param activityName 活动名称
     */
    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    /**
     * 获取活动类别（1重点常规活动 2党员日常活动）
     *
     * @return ActivityType - 活动类别（1重点常规活动 2党员日常活动）
     */
    public String getActivityType() {
        return activityType;
    }

    /**
     * 设置活动类别（1重点常规活动 2党员日常活动）
     *
     * @param activityType 活动类别（1重点常规活动 2党员日常活动）
     */
    public void setActivityType(String activityType) {
        this.activityType = activityType;
    }

    /**
     * 获取活动内容
     *
     * @return ActivityContent - 活动内容
     */
    public String getActivityContent() {
        return activityContent;
    }

    /**
     * 设置活动内容
     *
     * @param activityContent 活动内容
     */
    public void setActivityContent(String activityContent) {
        this.activityContent = activityContent;
    }

    /**
     * 获取活动发布日期
     *
     * @return PublishDate - 活动发布日期
     */
    public Date getPublishDate() {
        return publishDate;
    }

    /**
     * 设置活动发布日期
     *
     * @param publishDate 活动发布日期
     */
    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    /**
     * 获取要求活动结束时间
     *
     * @return RequireEndDate - 要求活动结束时间
     */
    public Date getRequireEndDate() {
        return requireEndDate;
    }

    /**
     * 设置要求活动结束时间
     *
     * @param requireEndDate 要求活动结束时间
     */
    public void setRequireEndDate(Date requireEndDate) {
        this.requireEndDate = requireEndDate;
    }

    /**
     * 获取活动发布部门名称
     *
     * @return PublishDeptName - 活动发布部门名称
     */
    public String getPublishDeptName() {
        return publishDeptName;
    }

    /**
     * 设置活动发布部门名称
     *
     * @param publishDeptName 活动发布部门名称
     */
    public void setPublishDeptName(String publishDeptName) {
        this.publishDeptName = publishDeptName;
    }

    /**
     * 获取活动发布部门UID
     *
     * @return PublishDeptUID - 活动发布部门UID
     */
    public String getPublishDeptUID() {
        return publishDeptUID;
    }

    /**
     * 设置活动发布部门UID
     *
     * @param publishDeptUID 活动发布部门UID
     */
    public void setPublishDeptUID(String publishDeptUID) {
        this.publishDeptUID = publishDeptUID;
    }

    /**
     * 获取活动接收部门名称（所在党组织）
     *
     * @return ClaimDeptName - 活动接收部门名称（所在党组织）
     */
    public String getClaimDeptName() {
        return claimDeptName;
    }

    /**
     * 设置活动接收部门名称（所在党组织）
     *
     * @param claimDeptName 活动接收部门名称（所在党组织）
     */
    public void setClaimDeptName(String claimDeptName) {
        this.claimDeptName = claimDeptName;
    }

    /**
     * 获取活动接收部门UID
     *
     * @return ClaimDeptUID - 活动接收部门UID
     */
    public String getClaimDeptUID() {
        return claimDeptUID;
    }

    /**
     * 设置活动接收部门UID
     *
     * @param claimDeptUID 活动接收部门UID
     */
    public void setClaimDeptUID(String claimDeptUID) {
        this.claimDeptUID = claimDeptUID;
    }

    /**
     * 获取接收部门对应管辖单位编码
     *
     * @return ClaimLocalAdm - 接收部门对应管辖单位编码
     */
    public String getClaimLocalAdm() {
        return claimLocalAdm;
    }

    /**
     * 设置接收部门对应管辖单位编码
     *
     * @param claimLocalAdm 接收部门对应管辖单位编码
     */
    public void setClaimLocalAdm(String claimLocalAdm) {
        this.claimLocalAdm = claimLocalAdm;
    }

    /**
     * 获取接收部门对应管辖单位名称
     *
     * @return ClaimLocalAdmName - 接收部门对应管辖单位名称
     */
    public String getClaimLocalAdmName() {
        return claimLocalAdmName;
    }

    /**
     * 设置接收部门对应管辖单位名称
     *
     * @param claimLocalAdmName 接收部门对应管辖单位名称
     */
    public void setClaimLocalAdmName(String claimLocalAdmName) {
        this.claimLocalAdmName = claimLocalAdmName;
    }

    /**
     * 获取活动录入员账号
     *
     * @return InputCode - 活动录入员账号
     */
    public String getInputCode() {
        return inputCode;
    }

    /**
     * 设置活动录入员账号
     *
     * @param inputCode 活动录入员账号
     */
    public void setInputCode(String inputCode) {
        this.inputCode = inputCode;
    }

    /**
     * 获取活动录入员姓名
     *
     * @return InputName - 活动录入员姓名
     */
    public String getInputName() {
        return inputName;
    }

    /**
     * 设置活动录入员姓名
     *
     * @param inputName 活动录入员姓名
     */
    public void setInputName(String inputName) {
        this.inputName = inputName;
    }

    /**
     * 获取活动录入时间
     *
     * @return InputDate - 活动录入时间
     */
    public Date getInputDate() {
        return inputDate;
    }

    /**
     * 设置活动录入时间
     *
     * @param inputDate 活动录入时间
     */
    public void setInputDate(Date inputDate) {
        this.inputDate = inputDate;
    }

    /**
     * 获取活动附件
     *
     * @return UpfilePath - 活动附件
     */
    public String getUpfilePath() {
        return upfilePath;
    }

    /**
     * 设置活动附件
     *
     * @param upfilePath 活动附件
     */
    public void setUpfilePath(String upfilePath) {
        this.upfilePath = upfilePath;
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
     * 获取活动地点
     *
     * @return ActivityPlace - 活动地点
     */
    public String getActivityPlace() {
        return activityPlace;
    }

    /**
     * 设置活动地点
     *
     * @param activityPlace 活动地点
     */
    public void setActivityPlace(String activityPlace) {
        this.activityPlace = activityPlace;
    }

    /**
     * 获取活动开始时间
     *
     * @return ActivitybeginDate - 活动开始时间
     */
    public Date getActivitybeginDate() {
        return activitybeginDate;
    }

    /**
     * 设置活动开始时间
     *
     * @param activitybeginDate 活动开始时间
     */
    public void setActivitybeginDate(Date activitybeginDate) {
        this.activitybeginDate = activitybeginDate;
    }

    /**
     * 获取活动结束时间
     *
     * @return ActivityEndDate - 活动结束时间
     */
    public Date getActivityEndDate() {
        return activityEndDate;
    }

    /**
     * 设置活动结束时间
     *
     * @param activityEndDate 活动结束时间
     */
    public void setActivityEndDate(Date activityEndDate) {
        this.activityEndDate = activityEndDate;
    }

    /**
     * 获取活动发起人
     *
     * @return Originator - 活动发起人
     */
    public String getOriginator() {
        return originator;
    }

    /**
     * 设置活动发起人
     *
     * @param originator 活动发起人
     */
    public void setOriginator(String originator) {
        this.originator = originator;
    }

    /**
     * 获取活动发起人ID
     *
     * @return OriginatorID - 活动发起人ID
     */
    public String getOriginatorID() {
        return originatorID;
    }

    /**
     * 设置活动发起人ID
     *
     * @param originatorID 活动发起人ID
     */
    public void setOriginatorID(String originatorID) {
        this.originatorID = originatorID;
    }

    /**
     * 获取参与人数
     *
     * @return JoinNum - 参与人数
     */
    public Integer getJoinNum() {
        return joinNum;
    }

    /**
     * 设置参与人数
     *
     * @param joinNum 参与人数
     */
    public void setJoinNum(Integer joinNum) {
        this.joinNum = joinNum;
    }

    /**
     * 获取参与人
     *
     * @return Joiner - 参与人
     */
    public String getJoiner() {
        return joiner;
    }

    /**
     * 设置参与人
     *
     * @param joiner 参与人
     */
    public void setJoiner(String joiner) {
        this.joiner = joiner;
    }

    /**
     * 获取参与人ID
     *
     * @return JoinerId - 参与人ID
     */
    public String getJoinerId() {
        return joinerId;
    }

    /**
     * 设置参与人ID
     *
     * @param joinerId 参与人ID
     */
    public void setJoinerId(String joinerId) {
        this.joinerId = joinerId;
    }

    /**
     * 获取活动情况
     *
     * @return ActivitySituation - 活动情况
     */
    public String getActivitySituation() {
        return activitySituation;
    }

    /**
     * 设置活动情况
     *
     * @param activitySituation 活动情况
     */
    public void setActivitySituation(String activitySituation) {
        this.activitySituation = activitySituation;
    }

    /**
     * 获取结果附件
     *
     * @return ResultFilePath - 结果附件
     */
    public String getResultFilePath() {
        return resultFilePath;
    }

    /**
     * 设置结果附件
     *
     * @param resultFilePath 结果附件
     */
    public void setResultFilePath(String resultFilePath) {
        this.resultFilePath = resultFilePath;
    }

    /**
     * 获取结果录入人账号
     *
     * @return ResultInputCode - 结果录入人账号
     */
    public String getResultInputCode() {
        return resultInputCode;
    }

    /**
     * 设置结果录入人账号
     *
     * @param resultInputCode 结果录入人账号
     */
    public void setResultInputCode(String resultInputCode) {
        this.resultInputCode = resultInputCode;
    }

    /**
     * 获取结果录入人
     *
     * @return ResultInputName - 结果录入人
     */
    public String getResultInputName() {
        return resultInputName;
    }

    /**
     * 设置结果录入人
     *
     * @param resultInputName 结果录入人
     */
    public void setResultInputName(String resultInputName) {
        this.resultInputName = resultInputName;
    }

    /**
     * 获取结果录入人时间
     *
     * @return ResultInputDate - 结果录入人时间
     */
    public Date getResultInputDate() {
        return resultInputDate;
    }

    /**
     * 设置结果录入人时间
     *
     * @param resultInputDate 结果录入人时间
     */
    public void setResultInputDate(Date resultInputDate) {
        this.resultInputDate = resultInputDate;
    }
    
    public void setInputState(String inputState) {
		this.inputState = inputState;
	}
    
    public String getInputState() {
		return inputState;
	}
}