/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.es.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.icinfo.framework.mybatis.mapper.annotation.Before;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

/**
 * 描述:    cs_mort_estate_info 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2016年11月08日
 */
@Table(name = "cs_mort_estate_info")
public class CsMortEstateInfo implements Serializable {
    /**
     * 自增ID
     */
    @Id
    @Column(name = "id")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    private Integer id;

    /**
     * 抵押证编号
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
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date pefPerForm;

    /**
     * 债务截止日期
     */
    @Column(name = "PefPerTo")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date pefPerTo;

    /**
     * 抵押原因
     */
    @Column(name = "MortReason")
    private String mortReason;

    /**
     * 受理时间
     */
    @Column(name = "CheckDate")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date checkDate;

    @Column(name = "CreateTime")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date createTime;

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
     * 获取抵押证编号
     *
     * @return OrderNO - 抵押证编号
     */
    public String getOrderNO() {
        return orderNO;
    }

    /**
     * 设置抵押证编号
     *
     * @param orderNO 抵押证编号
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
     * 获取抵押原因
     *
     * @return MortReason - 抵押原因
     */
    public String getMortReason() {
        return mortReason;
    }

    /**
     * 设置抵押原因
     *
     * @param mortReason 抵押原因
     */
    public void setMortReason(String mortReason) {
        this.mortReason = mortReason;
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
}