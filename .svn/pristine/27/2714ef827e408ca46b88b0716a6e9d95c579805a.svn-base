/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.depsyn.model;

import com.icinfo.framework.mybatis.mapper.annotation.Before;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 描述:    cs_depsyn_small 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2016年12月12日
 */
@Table(name = "cs_depsyn_small")
public class CsDepsynSmall implements Serializable {
    @Id
    @Column(name = "id")
    @Before
    private Integer id;

    /**
     * UUID
     */
    @Column(name = "UID")
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    private String UID;

    /**
     * 主体身份代码
     */
    @Column(name = "PriPID")
    private String priPID;

    /**
     * 企业名称
     */
    @Column(name = "EntName")
    private String entName;

    /**
     * 注册号
     */
    @Column(name = "RegNO")
    private String regNO;

    /**
     * 注册号校验状态(0: 不通过, 1: 通过)
     */
    @Column(name = "RegNOState")
    private String regNOState;

    /**
     * 统一社会信用代码
     */
    @Column(name = "UniScid")
    private String uniScid;

    /**
     * 统一社会信用代码校验状态(0: 不通过, 1: 通过)
     */
    @Column(name = "UniScidState")
    private String uniScidState;

    /**
     * 部门名称
     */
    @Column(name = "DepName")
    private String depName;

    /**
     * 提供方式
     */
    @Column(name = "ProType")
    private String proType;

    /**
     * 扶持日期
     */
    @Column(name = "HelpDate")
    private String helpDate;

    /**
     * 校验状态(0: 不通过, 1: 通过)
     */
    @Column(name = "HelpDateState")
    private String helpDateState;

    /**
     * 错误代码
     */
    @Column(name = "ErrorCode")
    private String errorCode;

    /**
     * 提交时间
     */
    @Column(name = "ResubTime")
    private Date resubTime;

    /**
     * 反馈时间
     */
    @Column(name = "FeedbackTime")
    private Date feedbackTime;

    /**
     * 校验标志(0: 不通过, 1: 通过)
     */
    @Column(name = "CheckState")
    private String checkState;

    /**
     * 录入人员编号
     */
    @Column(name = "InputPerID")
    private String inputPerID;

    /**
     * 录入人部门编码
     */
    @Column(name = "InputDepCode")
    private String inputDepCode;

    /**
     * 录入时间
     */
    @Column(name = "InputDate")
    private Date inputDate;

    /**
     * 年份
     */
    @Column(name = "Year")
    private String year;

    /**
     * 行政编码
     */
    @Column(name = "Adcode")
    private String adcode;

    /**
     * 扶持内容
     */
    @Column(name = "HelpContent")
    private String helpContent;

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
     * 获取UUID
     *
     * @return UID - UUID
     */
    public String getUID() {
        return UID;
    }

    /**
     * 设置UUID
     *
     * @param UID UUID
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
     * 获取注册号
     *
     * @return RegNO - 注册号
     */
    public String getRegNO() {
        return regNO;
    }

    /**
     * 设置注册号
     *
     * @param regNO 注册号
     */
    public void setRegNO(String regNO) {
        this.regNO = regNO;
    }

    /**
     * 获取注册号校验状态(0: 不通过, 1: 通过)
     *
     * @return RegNOState - 注册号校验状态(0: 不通过, 1: 通过)
     */
    public String getRegNOState() {
        return regNOState;
    }

    /**
     * 设置注册号校验状态(0: 不通过, 1: 通过)
     *
     * @param regNOState 注册号校验状态(0: 不通过, 1: 通过)
     */
    public void setRegNOState(String regNOState) {
        this.regNOState = regNOState;
    }

    /**
     * 获取统一社会信用代码
     *
     * @return UniScid - 统一社会信用代码
     */
    public String getUniScid() {
        return uniScid;
    }

    /**
     * 设置统一社会信用代码
     *
     * @param uniScid 统一社会信用代码
     */
    public void setUniScid(String uniScid) {
        this.uniScid = uniScid;
    }

    /**
     * 获取统一社会信用代码校验状态(0: 不通过, 1: 通过)
     *
     * @return UniScidState - 统一社会信用代码校验状态(0: 不通过, 1: 通过)
     */
    public String getUniScidState() {
        return uniScidState;
    }

    /**
     * 设置统一社会信用代码校验状态(0: 不通过, 1: 通过)
     *
     * @param uniScidState 统一社会信用代码校验状态(0: 不通过, 1: 通过)
     */
    public void setUniScidState(String uniScidState) {
        this.uniScidState = uniScidState;
    }

    /**
     * 获取部门名称
     *
     * @return DepName - 部门名称
     */
    public String getDepName() {
        return depName;
    }

    /**
     * 设置部门名称
     *
     * @param depName 部门名称
     */
    public void setDepName(String depName) {
        this.depName = depName;
    }

    /**
     * 获取提供方式
     *
     * @return ProType - 提供方式
     */
    public String getProType() {
        return proType;
    }

    /**
     * 设置提供方式
     *
     * @param proType 提供方式
     */
    public void setProType(String proType) {
        this.proType = proType;
    }

    /**
     * 获取扶持日期
     *
     * @return HelpDate - 扶持日期
     */
    public String getHelpDate() {
        return helpDate;
    }

    /**
     * 设置扶持日期
     *
     * @param helpDate 扶持日期
     */
    public void setHelpDate(String helpDate) {
        this.helpDate = helpDate;
    }

    /**
     * 获取校验状态(0: 不通过, 1: 通过)
     *
     * @return HelpDateState - 校验状态(0: 不通过, 1: 通过)
     */
    public String getHelpDateState() {
        return helpDateState;
    }

    /**
     * 设置校验状态(0: 不通过, 1: 通过)
     *
     * @param helpDateState 校验状态(0: 不通过, 1: 通过)
     */
    public void setHelpDateState(String helpDateState) {
        this.helpDateState = helpDateState;
    }

    /**
     * 获取错误代码
     *
     * @return ErrorCode - 错误代码
     */
    public String getErrorCode() {
        return errorCode;
    }

    /**
     * 设置错误代码
     *
     * @param errorCode 错误代码
     */
    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    /**
     * 获取提交时间
     *
     * @return ResubTime - 提交时间
     */
    public Date getResubTime() {
        return resubTime;
    }

    /**
     * 设置提交时间
     *
     * @param resubTime 提交时间
     */
    public void setResubTime(Date resubTime) {
        this.resubTime = resubTime;
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
     * 获取校验标志(0: 不通过, 1: 通过)
     *
     * @return CheckState - 校验标志(0: 不通过, 1: 通过)
     */
    public String getCheckState() {
        return checkState;
    }

    /**
     * 设置校验标志(0: 不通过, 1: 通过)
     *
     * @param checkState 校验标志(0: 不通过, 1: 通过)
     */
    public void setCheckState(String checkState) {
        this.checkState = checkState;
    }

    /**
     * 获取录入人员编号
     *
     * @return InputPerID - 录入人员编号
     */
    public String getInputPerID() {
        return inputPerID;
    }

    /**
     * 设置录入人员编号
     *
     * @param inputPerID 录入人员编号
     */
    public void setInputPerID(String inputPerID) {
        this.inputPerID = inputPerID;
    }

    /**
     * 获取录入人部门编码
     *
     * @return InputDepCode - 录入人部门编码
     */
    public String getInputDepCode() {
        return inputDepCode;
    }

    /**
     * 设置录入人部门编码
     *
     * @param inputDepCode 录入人部门编码
     */
    public void setInputDepCode(String inputDepCode) {
        this.inputDepCode = inputDepCode;
    }

    /**
     * 获取录入时间
     *
     * @return InputDate - 录入时间
     */
    public Date getInputDate() {
        return inputDate;
    }

    /**
     * 设置录入时间
     *
     * @param inputDate 录入时间
     */
    public void setInputDate(Date inputDate) {
        this.inputDate = inputDate;
    }

    /**
     * 获取年份
     *
     * @return Year - 年份
     */
    public String getYear() {
        return year;
    }

    /**
     * 设置年份
     *
     * @param year 年份
     */
    public void setYear(String year) {
        this.year = year;
    }

    /**
     * 获取行政编码
     *
     * @return Adcode - 行政编码
     */
    public String getAdcode() {
        return adcode;
    }

    /**
     * 设置行政编码
     *
     * @param adcode 行政编码
     */
    public void setAdcode(String adcode) {
        this.adcode = adcode;
    }

    /**
     * 获取扶持内容
     *
     * @return HelpContent - 扶持内容
     */
    public String getHelpContent() {
        return helpContent;
    }

    /**
     * 设置扶持内容
     *
     * @param helpContent 扶持内容
     */
    public void setHelpContent(String helpContent) {
        this.helpContent = helpContent;
    }
}