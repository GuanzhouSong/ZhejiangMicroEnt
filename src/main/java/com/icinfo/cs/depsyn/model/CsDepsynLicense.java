/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.depsyn.model;

import com.icinfo.framework.mybatis.mapper.annotation.Before;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 描述:    cs_depsyn_license 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2016年12月12日
 */
@Table(name = "cs_depsyn_license")
public class CsDepsynLicense implements Serializable {
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
     * 许可文件编号
     */
    @Column(name = "LicNO")
    private String licNO;

    /**
     * 许可文件名称
     */
    @Column(name = "LicName")
    private String licName;

    /**
     * 有效期开始
     */
    @Column(name = "ValFrom")
    private String valFrom;

    /**
     * 有效期开始标志
     */
    @Column(name = "ValFromState")
    private String valFromState;

    /**
     * 有效期截止
     */
    @Column(name = "ValTo")
    private String valTo;

    /**
     * 有效期截止标志
     */
    @Column(name = "ValToState")
    private String valToState;

    /**
     * 许可机关
     */
    @Column(name = "LicAnth")
    private String licAnth;

    /**
     * 登记状态
     */
    @Column(name = "RegState")
    private String regState;

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
     * 校验标志(0: 不通过, 1: 通过)
     */
    @Column(name = "UniScidState")
    private String uniScidState;

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

    /**
     * 校验标志(0: 不通过, 1: 通过)
     */
    @Column(name = "CheckState")
    private String checkState;

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
     * 获取许可文件编号
     *
     * @return LicNO - 许可文件编号
     */
    public String getLicNO() {
        return licNO;
    }

    /**
     * 设置许可文件编号
     *
     * @param licNO 许可文件编号
     */
    public void setLicNO(String licNO) {
        this.licNO = licNO;
    }

    /**
     * 获取许可文件名称
     *
     * @return LicName - 许可文件名称
     */
    public String getLicName() {
        return licName;
    }

    /**
     * 设置许可文件名称
     *
     * @param licName 许可文件名称
     */
    public void setLicName(String licName) {
        this.licName = licName;
    }

    /**
     * 获取有效期开始
     *
     * @return ValFrom - 有效期开始
     */
    public String getValFrom() {
        return valFrom;
    }

    /**
     * 设置有效期开始
     *
     * @param valFrom 有效期开始
     */
    public void setValFrom(String valFrom) {
        this.valFrom = valFrom;
    }

    /**
     * 获取有效期开始标志
     *
     * @return ValFromState - 有效期开始标志
     */
    public String getValFromState() {
        return valFromState;
    }

    /**
     * 设置有效期开始标志
     *
     * @param valFromState 有效期开始标志
     */
    public void setValFromState(String valFromState) {
        this.valFromState = valFromState;
    }

    /**
     * 获取有效期截止
     *
     * @return ValTo - 有效期截止
     */
    public String getValTo() {
        return valTo;
    }

    /**
     * 设置有效期截止
     *
     * @param valTo 有效期截止
     */
    public void setValTo(String valTo) {
        this.valTo = valTo;
    }

    /**
     * 获取有效期截止标志
     *
     * @return ValToState - 有效期截止标志
     */
    public String getValToState() {
        return valToState;
    }

    /**
     * 设置有效期截止标志
     *
     * @param valToState 有效期截止标志
     */
    public void setValToState(String valToState) {
        this.valToState = valToState;
    }

    /**
     * 获取许可机关
     *
     * @return LicAnth - 许可机关
     */
    public String getLicAnth() {
        return licAnth;
    }

    /**
     * 设置许可机关
     *
     * @param licAnth 许可机关
     */
    public void setLicAnth(String licAnth) {
        this.licAnth = licAnth;
    }

    /**
     * 获取登记状态
     *
     * @return RegState - 登记状态
     */
    public String getRegState() {
        return regState;
    }

    /**
     * 设置登记状态
     *
     * @param regState 登记状态
     */
    public void setRegState(String regState) {
        this.regState = regState;
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
     * 获取校验标志(0: 不通过, 1: 通过)
     *
     * @return UniScidState - 校验标志(0: 不通过, 1: 通过)
     */
    public String getUniScidState() {
        return uniScidState;
    }

    /**
     * 设置校验标志(0: 不通过, 1: 通过)
     *
     * @param uniScidState 校验标志(0: 不通过, 1: 通过)
     */
    public void setUniScidState(String uniScidState) {
        this.uniScidState = uniScidState;
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
     *
     * @param adcode 行政编码
     */
    public void setAdcode(String adcode) {
        this.adcode = adcode;
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