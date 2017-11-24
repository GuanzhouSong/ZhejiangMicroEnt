/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.copysend.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.icinfo.framework.mybatis.mapper.annotation.Before;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * 描述:    cs_copy_send_feedback 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2016年10月24日
 */
@Table(name = "cs_copy_send_feedback")
public class CopySendFeedback implements Serializable {
    /**
     * 主键ID
     */
    @Id
    @Column(name = "id")
    private Integer id;

    /**
     * UID
     */
    @Column(name = "UID")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    private String uid;

    /**
     * 抄告单编号
     */
    @Column(name = "CopyFormNo")
    private String copyFormNo;

    /**
     * 抄告接收部门
     */
    @Column(name = "AcceptDepartCode")
    private String acceptDepartCode;

    /**
     * 0:未反馈 1:已反馈
     */
    @Column(name = "State")
    private Integer state;

    /**
     * 反馈意见
     */
    @Column(name = "Feedback")
    private String feedback;

    /**
     * 反馈时间
     */
    @Column(name = "FeedbackTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date feedbackTime;

    /**
     * 反馈人
     */
    @Column(name = "FeedbackPerson")
    private String feedbackPerson;

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
     * 获取UID
     *
     * @return UID - UID
     */
    public String getUid() {
        return uid;
    }

    /**
     * 设置UID
     *
     * @param UID UID
     */
    public void setUid(String uid) {
        this.uid = uid;
    }

    /**
     * 获取抄告单编号
     *
     * @return CopyFormNo - 抄告单编号
     */
    public String getCopyFormNo() {
        return copyFormNo;
    }

    /**
     * 设置抄告单编号
     *
     * @param copyFormNo 抄告单编号
     */
    public void setCopyFormNo(String copyFormNo) {
        this.copyFormNo = copyFormNo;
    }

    /**
     * 获取抄告接收部门
     *
     * @return AcceptDepart - 抄告接收部门
     */
    public String getAcceptDepartCode() {
        return acceptDepartCode;
    }

    /**
     * 设置抄告接收部门
     *
     * @param acceptDepart 抄告接收部门
     */
    public void setAcceptDepartCode(String acceptDepartCode) {
        this.acceptDepartCode = acceptDepartCode;
    }

    /**
     * 获取0:未反馈 1:已反馈
     *
     * @return State - 0:未反馈 1:已反馈
     */
    public Integer getState() {
        return state;
    }

    /**
     * 设置0:未反馈 1:已反馈
     *
     * @param state 0:未反馈 1:已反馈
     */
    public void setState(Integer state) {
        this.state = state;
    }

    /**
     * 获取反馈意见
     *
     * @return Feedback - 反馈意见
     */
    public String getFeedback() {
        return feedback;
    }

    /**
     * 设置反馈意见
     *
     * @param feedback 反馈意见
     */
    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    /**
     * 获取反馈时间
     *
     * @return FeedbackTime - 反馈时间
     */
    public Date getFeedbackTime() {
        return feedbackTime;
    }

    /**
     * 设置反馈时间
     *
     * @param feedbackTime 反馈时间
     */
    public void setFeedbackTime(Date feedbackTime) {
        this.feedbackTime = feedbackTime;
    }

    /**
     * 获取反馈人
     *
     * @return FeedbackPerson - 反馈人
     */
    public String getFeedbackPerson() {
        return feedbackPerson;
    }

    /**
     * 设置反馈人
     *
     * @param feedbackPerson 反馈人
     */
    public void setFeedbackPerson(String feedbackPerson) {
        this.feedbackPerson = feedbackPerson;
    }
}