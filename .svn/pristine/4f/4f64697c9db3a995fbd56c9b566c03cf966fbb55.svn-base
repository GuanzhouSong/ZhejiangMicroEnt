/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.depsyn.model;

import com.icinfo.framework.mybatis.mapper.annotation.Before;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 描述:    cs_depsyn_punish 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2016年12月10日
 */
@Table(name = "cs_depsyn_punish")
public class CsDepsynPunish implements Serializable {
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
     * 处罚决定书文号
     */
    @Column(name = "PenDecNo")
    private String penDecNo;

    /**
     * 处罚决定书签发日期
     */
    @Column(name = "CerIssDate")
    private String cerIssDate;

    /**
     * 处罚决定书签发日期
校验标识
     */
    @Column(name = "CerIssDateState")
    private String cerIssDateState;

    /**
     * 违法行为类型
     */
    @Column(name = "IllegActType")
    private String illegActType;

    /**
     * 处罚种类
     */
    @Column(name = "PenType")
    private String penType;

    /**
     * 处罚机关
     */
    @Column(name = "PenAuth")
    private String penAuth;

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
     * 注册号校验状态
     */
    @Column(name = "RegNOState")
    private String regNOState;

    /**
     * 统一社会信用代码
     */
    @Column(name = "UniScid")
    private String uniScid;

    /**
     * 统一社会信用代码校验状态
     */
    @Column(name = "UniScidState")
    private String uniScidState;

    /**
     * 校验标志
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
     * 录入年份
     */
    @Column(name = "Year")
    private String year;

    /**
     * 行政编码
     */
    @Column(name = "Adcode")
    private String adcode;

    @Column(name = "ProType")
    private String proType;

    @Column(name = "ErrorCode")
    private String errorCode;

    @Column(name = "ResubTime")
    private Date resubTime;

    @Column(name = "FeedbackTime")
    private Date feedbackTime;

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
     * 获取处罚决定书文号
     *
     * @return PenDecNo - 处罚决定书文号
     */
    public String getPenDecNo() {
        return penDecNo;
    }

    /**
     * 设置处罚决定书文号
     *
     * @param penDecNo 处罚决定书文号
     */
    public void setPenDecNo(String penDecNo) {
        this.penDecNo = penDecNo;
    }

    /**
     * 获取处罚决定书签发日期
     *
     * @return CerIssDate - 处罚决定书签发日期
     */
    public String getCerIssDate() {
        return cerIssDate;
    }

    /**
     * 设置处罚决定书签发日期
     *
     * @param cerIssDate 处罚决定书签发日期
     */
    public void setCerIssDate(String cerIssDate) {
        this.cerIssDate = cerIssDate;
    }

    /**
     * 获取处罚决定书签发日期
校验标识
     *
     * @return CerIssDateState - 处罚决定书签发日期
校验标识
     */
    public String getCerIssDateState() {
        return cerIssDateState;
    }

    /**
     * 设置处罚决定书签发日期
校验标识
     *
     * @param cerIssDateState 处罚决定书签发日期
校验标识
     */
    public void setCerIssDateState(String cerIssDateState) {
        this.cerIssDateState = cerIssDateState;
    }

    /**
     * 获取违法行为类型
     *
     * @return IllegActType - 违法行为类型
     */
    public String getIllegActType() {
        return illegActType;
    }

    /**
     * 设置违法行为类型
     *
     * @param illegActType 违法行为类型
     */
    public void setIllegActType(String illegActType) {
        this.illegActType = illegActType;
    }

    /**
     * 获取处罚种类
     *
     * @return PenType - 处罚种类
     */
    public String getPenType() {
        return penType;
    }

    /**
     * 设置处罚种类
     *
     * @param penType 处罚种类
     */
    public void setPenType(String penType) {
        this.penType = penType;
    }

    /**
     * 获取处罚机关
     *
     * @return PenAuth - 处罚机关
     */
    public String getPenAuth() {
        return penAuth;
    }

    /**
     * 设置处罚机关
     *
     * @param penAuth 处罚机关
     */
    public void setPenAuth(String penAuth) {
        this.penAuth = penAuth;
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
     * 获取注册号校验状态
     *
     * @return RegNOState - 注册号校验状态
     */
    public String getRegNOState() {
        return regNOState;
    }

    /**
     * 设置注册号校验状态
     *
     * @param regNOState 注册号校验状态
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
     * 获取统一社会信用代码校验状态
     *
     * @return UniScidState - 统一社会信用代码校验状态
     */
    public String getUniScidState() {
        return uniScidState;
    }

    /**
     * 设置统一社会信用代码校验状态
     *
     * @param uniScidState 统一社会信用代码校验状态
     */
    public void setUniScidState(String uniScidState) {
        this.uniScidState = uniScidState;
    }

    /**
     * 获取校验标志
     *
     * @return CheckState - 校验标志
     */
    public String getCheckState() {
        return checkState;
    }

    /**
     * 设置校验标志
     *
     * @param checkState 校验标志
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
     * 获取录入年份
     *
     * @return Year - 录入年份
     */
    public String getYear() {
        return year;
    }

    /**
     * 设置录入年份
     *
     * @param year 录入年份
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
     * @param adcode 行政编码
     */
    public void setAdcode(String adcode) {
        this.adcode = adcode;
    }

    public String getProType() {
        return proType;
    }

    public void setProType(String proType) {
        this.proType = proType;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public Date getResubTime() {
        return resubTime;
    }

    public void setResubTime(Date resubTime) {
        this.resubTime = resubTime;
    }

    public Date getFeedbackTime() {
        return feedbackTime;
    }

    public void setFeedbackTime(Date feedbackTime) {
        this.feedbackTime = feedbackTime;
    }
}