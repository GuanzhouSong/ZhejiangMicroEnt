/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.other.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.icinfo.framework.mybatis.mapper.annotation.Before;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.*;

/**
 * 描述:    cs_mort_reg_info 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2016年10月26日
 */
@Table(name = "cs_mort_reg_info")
public class MortRegInfo implements Serializable {
    /**
     * 自增ID
     */
    @Id
    @Column(name = "id")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    private Integer id;

    /**
     * 订单号
     */
    @Column(name = "OrderNO")
    private String orderNO;

    /**
     * 抵押人名称
     */
    @Column(name = "MortGagorName")
    private String mortGagorName;

    /**
     * 抵押人证件类型
     */
    @Column(name = "MortGagorCertType")
    private String mortGagorCertType;

    /**
     * 抵押人证件号码
     */
    @Column(name = "MortGagorCertNO")
    private String mortGagorCertNO;

    /**
     * 抵押权人姓名
     */
    @Column(name = "MortGageeName")
    private String mortGageeName;

    /**
     * 抵押权人证件类型
     */
    @Column(name = "MortGageeCertType")
    private String mortGageeCertType;

    /**
     * 抵押权人证件号码
     */
    @Column(name = "MortGageeCertNO")
    private String mortGageeCertNO;

    /**
     * 抵押种类
     */
    @Column(name = "MortGageType")
    private String mortGageType;

    /**
     * 抵押金额
     */
    @Column(name = "MortGageAmount")
    private BigDecimal mortGageAmount;

    /**
     * 担保范围
     */
    @Column(name = "WarCov")
    private String warCov;

    /**
     * 债务起始日期
     */
    @Column(name = "PefPerForm")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8") 
    private Date pefPerForm;

    /**
     * 债务截止日期
     */
    @Column(name = "PefPerTo")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8") 
    private Date pefPerTo;

    /**
     * 备注
     */
    @Column(name = "Remark")
    private String remark;

    /**
     * 动产抵押登记编号;
     */
    @Column(name = "FilingNO")
    private String filingNO;

    /**
     * 确认状态:0:未确认1:已确认
     */
    @Column(name = "CheckStatus")
    private String checkStatus;

    /**
     * 受理工商部门编号
     */
    @Column(name = "DepartMentID")
    private String departMentID;

    /**
     * 受理时间
     */
    @Column(name = "CheckDate")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8") 
    private Date checkDate;

    /**
     * 变更状态0:未变更1:已变更
     */
    @Column(name = "ChangeStatus")
    private String changeStatus;

    /**
     * 是否注销0：未注销1:已注销
     */
    @Column(name = "CancelStatus")
    private String cancelStatus;

    /**
     * 受理工商部门名称
     */
    @Column(name = "DepartMentName")
    private String departMentName;

    @Column(name = "CreateTime")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8") 
    private Date createTime;
    
    /**
     * 抵押权人住所地
     */
    @Column(name = "MortGageeAddr")
    private String mortGageeAddr;

    private static final long serialVersionUID = 1L;

    /**
     * 获取自增ID
     *
     * @return id - 自增ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置自增ID
     *
     * @param id 自增ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取订单号
     *
     * @return OrderNO - 订单号
     */
    public String getOrderNO() {
        return orderNO;
    }

    /**
     * 设置订单号
     *
     * @param orderNO 订单号
     */
    public void setOrderNO(String orderNO) {
        this.orderNO = orderNO;
    }

    /**
     * 获取抵押人名称
     *
     * @return MortGagorName - 抵押人名称
     */
    public String getMortGagorName() {
        return mortGagorName;
    }

    /**
     * 设置抵押人名称
     *
     * @param mortGagorName 抵押人名称
     */
    public void setMortGagorName(String mortGagorName) {
        this.mortGagorName = mortGagorName;
    }

    /**
     * 获取抵押人证件类型
     *
     * @return MortGagorCertType - 抵押人证件类型
     */
    public String getMortGagorCertType() {
        return mortGagorCertType;
    }

    /**
     * 设置抵押人证件类型
     *
     * @param mortGagorCertType 抵押人证件类型
     */
    public void setMortGagorCertType(String mortGagorCertType) {
        this.mortGagorCertType = mortGagorCertType;
    }

    /**
     * 获取抵押人证件号码
     *
     * @return MortGagorCertNO - 抵押人证件号码
     */
    public String getMortGagorCertNO() {
        return mortGagorCertNO;
    }

    /**
     * 设置抵押人证件号码
     *
     * @param mortGagorCertNO 抵押人证件号码
     */
    public void setMortGagorCertNO(String mortGagorCertNO) {
        this.mortGagorCertNO = mortGagorCertNO;
    }

    /**
     * 获取抵押权人姓名
     *
     * @return MortGageeName - 抵押权人姓名
     */
    public String getMortGageeName() {
        return mortGageeName;
    }

    /**
     * 设置抵押权人姓名
     *
     * @param mortGageeName 抵押权人姓名
     */
    public void setMortGageeName(String mortGageeName) {
        this.mortGageeName = mortGageeName;
    }

    /**
     * 获取抵押权人证件类型
     *
     * @return MortGageeCertType - 抵押权人证件类型
     */
    public String getMortGageeCertType() {
        return mortGageeCertType;
    }

    /**
     * 设置抵押权人证件类型
     *
     * @param mortGageeCertType 抵押权人证件类型
     */
    public void setMortGageeCertType(String mortGageeCertType) {
        this.mortGageeCertType = mortGageeCertType;
    }

    /**
     * 获取抵押权人证件号码
     *
     * @return MortGageeCertNO - 抵押权人证件号码
     */
    public String getMortGageeCertNO() {
        return mortGageeCertNO;
    }

    /**
     * 设置抵押权人证件号码
     *
     * @param mortGageeCertNO 抵押权人证件号码
     */
    public void setMortGageeCertNO(String mortGageeCertNO) {
        this.mortGageeCertNO = mortGageeCertNO;
    }

    /**
     * 获取抵押种类
     *
     * @return MortGageType - 抵押种类
     */
    public String getMortGageType() {
        return mortGageType;
    }

    /**
     * 设置抵押种类
     *
     * @param mortGageType 抵押种类
     */
    public void setMortGageType(String mortGageType) {
        this.mortGageType = mortGageType;
    }

    /**
     * 获取抵押金额
     *
     * @return MortGageAmount - 抵押金额
     */
    public BigDecimal getMortGageAmount() {
        return mortGageAmount;
    }

    /**
     * 设置抵押金额
     *
     * @param mortGageAmount 抵押金额
     */
    public void setMortGageAmount(BigDecimal mortGageAmount) {
        this.mortGageAmount = mortGageAmount;
    }

    /**
     * 获取担保范围
     *
     * @return WarCov - 担保范围
     */
    public String getWarCov() {
        return warCov;
    }

    /**
     * 设置担保范围
     *
     * @param warCov 担保范围
     */
    public void setWarCov(String warCov) {
        this.warCov = warCov;
    }

    /**
     * 获取债务起始日期
     *
     * @return PefPerForm - 债务起始日期
     */
    public Date getPefPerForm() {
        return pefPerForm;
    }

    /**
     * 设置债务起始日期
     *
     * @param pefPerForm 债务起始日期
     */
    public void setPefPerForm(Date pefPerForm) {
        this.pefPerForm = pefPerForm;
    }

    /**
     * 获取债务截止日期
     *
     * @return PefPerTo - 债务截止日期
     */
    public Date getPefPerTo() {
        return pefPerTo;
    }

    /**
     * 设置债务截止日期
     *
     * @param pefPerTo 债务截止日期
     */
    public void setPefPerTo(Date pefPerTo) {
        this.pefPerTo = pefPerTo;
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
     * 获取动产抵押登记编号;
     *
     * @return FilingNO - 动产抵押登记编号;
     */
    public String getFilingNO() {
        return filingNO;
    }

    /**
     * 设置动产抵押登记编号;
     *
     * @param filingNO 动产抵押登记编号;
     */
    public void setFilingNO(String filingNO) {
        this.filingNO = filingNO;
    }

    /**
     * 获取确认状态:0:未确认1:已确认
     *
     * @return CheckStatus - 确认状态:0:未确认1:已确认
     */
    public String getCheckStatus() {
        return checkStatus;
    }

    /**
     * 设置确认状态:0:未确认1:已确认
     *
     * @param checkStatus 确认状态:0:未确认1:已确认
     */
    public void setCheckStatus(String checkStatus) {
        this.checkStatus = checkStatus;
    }

    /**
     * 获取受理工商部门编号
     *
     * @return DepartMentID - 受理工商部门编号
     */
    public String getDepartMentID() {
        return departMentID;
    }

    /**
     * 设置受理工商部门编号
     *
     * @param departMentID 受理工商部门编号
     */
    public void setDepartMentID(String departMentID) {
        this.departMentID = departMentID;
    }

    /**
     * 获取受理时间
     *
     * @return CheckDate - 受理时间
     */
    public Date getCheckDate() {
        return checkDate;
    }

    /**
     * 设置受理时间
     *
     * @param checkDate 受理时间
     */
    public void setCheckDate(Date checkDate) {
        this.checkDate = checkDate;
    }

    /**
     * 获取变更状态0:未变更1:已变更
     *
     * @return ChangeStatus - 变更状态0:未变更1:已变更
     */
    public String getChangeStatus() {
        return changeStatus;
    }

    /**
     * 设置变更状态0:未变更1:已变更
     *
     * @param changeStatus 变更状态0:未变更1:已变更
     */
    public void setChangeStatus(String changeStatus) {
        this.changeStatus = changeStatus;
    }

    /**
     * 获取是否注销0：未注销1:已注销
     *
     * @return CancelStatus - 是否注销0：未注销1:已注销
     */
    public String getCancelStatus() {
        return cancelStatus;
    }

    /**
     * 设置是否注销0：未注销1:已注销
     *
     * @param cancelStatus 是否注销0：未注销1:已注销
     */
    public void setCancelStatus(String cancelStatus) {
        this.cancelStatus = cancelStatus;
    }

    /**
     * 获取受理工商部门名称
     *
     * @return DepartMentName - 受理工商部门名称
     */
    public String getDepartMentName() {
        return departMentName;
    }

    /**
     * 设置受理工商部门名称
     *
     * @param departMentName 受理工商部门名称
     */
    public void setDepartMentName(String departMentName) {
        this.departMentName = departMentName;
    }

    /**
     * @return CreateTime
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

	public String getMortGageeAddr() {
		return mortGageeAddr;
	}

	public void setMortGageeAddr(String mortGageeAddr) {
		this.mortGageeAddr = mortGageeAddr;
	}
    
}