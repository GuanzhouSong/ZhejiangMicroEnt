/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.datamodify.dto;

import com.icinfo.cs.datamodify.model.ApplyDataModify;

import java.util.Date;

/**
 * 描述:  cs_apply_data_modify 对应的DTO类.<br>
 *
 * @author framework generator
 * @date 2017年11月22日
 */
public class ApplyDataModifyDto extends ApplyDataModify {


    private Date applyDateStart;

    private Date applyDateEnd;

    private Date feedbackDateStart;

    private Date feedbackDateEnd;

    public Date getApplyDateStart() {
        return applyDateStart;
    }

    public void setApplyDateStart(Date applyDateStart) {
        this.applyDateStart = applyDateStart;
    }

    public Date getApplyDateEnd() {
        return applyDateEnd;
    }

    public void setApplyDateEnd(Date applyDateEnd) {
        this.applyDateEnd = applyDateEnd;
    }

    public Date getFeedbackDateStart() {
        return feedbackDateStart;
    }

    public void setFeedbackDateStart(Date feedbackDateStart) {
        this.feedbackDateStart = feedbackDateStart;
    }

    public Date getFeedbackDateEnd() {
        return feedbackDateEnd;
    }

    public void setFeedbackDateEnd(Date feedbackDateEnd) {
        this.feedbackDateEnd = feedbackDateEnd;
    }
}