/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.yr.model;

import com.icinfo.framework.mybatis.mapper.annotation.Before;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

/**
 * 描述:    cs_yr_social_security 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2016年12月21日
 */
@Table(name = "cs_yr_social_security")
public class YrSocialSecurity implements Serializable {
    @Id
    @Column(name = "id")
    private Integer id;

    /**
     * 唯一标识
     */

    @Column(name = "SocialID")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    private String socialID;

    /**
     * 主体身份代码
     */
    @Column(name = "PriPID")
    private String priPID;

    /**
     * 年报ID
     */
    @Column(name = "AnCheID")
    private String anCheID;

    /**
     * 年报年度
     */
    @Column(name = "Year")
    private Integer year;

    /**
     * 统一社会信用代码
     */
    @Column(name = "UniCode")
    private String uniCode;

    /**
     * 注册号
     */
    @Column(name = "RegNO")
    private String regNO;

    /**
     * 名称
     */
    @Column(name = "EntName")
    private String entName;

    /**
     * 城镇职工基本养老保险人数
     */
    @Column(name = "EndowmentNum")
    private Integer endowmentNum;

    /**
     * 失业保险人数
     */
    @Column(name = "UnemploymentNum")
    private Integer unemploymentNum;

    /**
     * 医疗保险人数
     */
    @Column(name = "MedicalNum")
    private Integer medicalNum;

    /**
     * 工伤保险人数
     */
    @Column(name = "EmpInjuryNum")
    private Integer empInjuryNum;

    /**
     * 生育保险人数
     */
    @Column(name = "MaternityNum")
    private Integer maternityNum;

    /**
     * 单位缴费基数
     */
    @Column(name = "PaymentBase")
    private BigDecimal paymentBase;

    /**
     * 单位缴费基数是否公示
     */
    @Column(name = "PaymentBaseIsPub")
    private String paymentBaseIsPub;

    /**
     * 本期实际缴费金额
     */
    @Column(name = "ActualPayment")
    private BigDecimal actualPayment;

    /**
     * 本期实际缴费金额是否公示
     */
    @Column(name = "ActualPaymentIsPub")
    private String actualPaymentIsPub;

    /**
     * 单位累计欠缴金额
     */
    @Column(name = "CumulArrears")
    private BigDecimal cumulArrears;

    /**
     * 单位累计欠缴金额是否公示
     */
    @Column(name = "CumulArrearsIsPub")
    private String cumulArrearsIsPub;

    /**
     * 时间戳
     */
    @Column(name = "CreateTime")
    private Date createTime;


    /**
     * 单位缴费基数-城镇职工基本养老保险
     */
    @Column(name = "PaymentEndowment")
    private BigDecimal paymentEndowment;

    /**
     * 单位缴费基数-失业保险
     */
    @Column(name = "PaymentUnemployment")
    private BigDecimal paymentUnemployment;

    /**
     * 单位缴费基数-医疗保险
     */
    @Column(name = "PaymentMedical")
    private BigDecimal paymentMedical;

    /**
     * 单位缴费基数-工伤保险
     */
    @Column(name = "PaymentEmpInjury")
    private BigDecimal paymentEmpInjury;

    /**
     * 单位缴费基数-生育保险
     */
    @Column(name = "PaymentMaternity")
    private BigDecimal paymentMaternity;

    /**
     * 本期实际缴费金额-城镇职工基本养老保险
     */
    @Column(name = "ActualPayEndowment")
    private BigDecimal actualPayEndowment;

    /**
     * 本期实际缴费金额-失业保险
     */
    @Column(name = "ActualPayUnemployment")
    private BigDecimal actualPayUnemployment;

    /**
     * 本期实际缴费金额-医疗保险
     */
    @Column(name = "ActualPayMedical")
    private BigDecimal actualPayMedical;

    /**
     * 本期实际缴费金额-工伤保险
     */
    @Column(name = "ActualPayEmpInjury")
    private BigDecimal actualPayEmpInjury;

    /**
     * 本期实际缴费金额-生育保险
     */
    @Column(name = "ActualPayMaternity")
    private BigDecimal actualPayMaternity;

    /**
     * 单位累计欠缴金额-城镇职工基本养老保险
     */
    @Column(name = "CumuEndowment")
    private BigDecimal cumuEndowment;

    /**
     * 单位累计欠缴金额-失业保险
     */
    @Column(name = "CumuUnemployment")
    private BigDecimal cumuUnemployment;

    /**
     * 单位累计欠缴金额-医疗保险
     */
    @Column(name = "CumuMedical")
    private BigDecimal cumuMedical;

    /**
     * 单位累计欠缴金额-工伤保险
     */
    @Column(name = "CumuEmpInjury")
    private BigDecimal cumuEmpInjury;

    /**
     * 单位累计欠缴金额-生育保险
     */
    @Column(name = "CumuMaternity")
    private BigDecimal cumuMaternity;

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
     * 获取年报ID
     *
     * @return AnCheID - 年报ID
     */
    public String getAnCheID() {
        return anCheID;
    }

    /**
     * 设置年报ID
     *
     * @param anCheID 年报ID
     */
    public void setAnCheID(String anCheID) {
        this.anCheID = anCheID;
    }

    /**
     * 获取年报年度
     *
     * @return Year - 年报年度
     */
    public Integer getYear() {
        return year;
    }

    /**
     * 设置年报年度
     *
     * @param year 年报年度
     */
    public void setYear(Integer year) {
        this.year = year;
    }

    /**
     * 获取统一社会信用代码
     *
     * @return UniCode - 统一社会信用代码
     */
    public String getUniCode() {
        return uniCode;
    }

    /**
     * 设置统一社会信用代码
     *
     * @param uniCode 统一社会信用代码
     */
    public void setUniCode(String uniCode) {
        this.uniCode = uniCode;
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
     * 获取名称
     *
     * @return EntName - 名称
     */
    public String getEntName() {
        return entName;
    }

    /**
     * 设置名称
     *
     * @param entName 名称
     */
    public void setEntName(String entName) {
        this.entName = entName;
    }

    /**
     * 获取城镇职工基本养老保险人数
     *
     * @return EndowmentNum - 城镇职工基本养老保险人数
     */
    public Integer getEndowmentNum() {
        return endowmentNum;
    }

    /**
     * 设置城镇职工基本养老保险人数
     *
     * @param endowmentNum 城镇职工基本养老保险人数
     */
    public void setEndowmentNum(Integer endowmentNum) {
        this.endowmentNum = endowmentNum;
    }

    /**
     * 获取失业保险人数
     *
     * @return UnemploymentNum - 失业保险人数
     */
    public Integer getUnemploymentNum() {
        return unemploymentNum;
    }

    /**
     * 设置失业保险人数
     *
     * @param unemploymentNum 失业保险人数
     */
    public void setUnemploymentNum(Integer unemploymentNum) {
        this.unemploymentNum = unemploymentNum;
    }

    /**
     * 获取医疗保险人数
     *
     * @return MedicalNum - 医疗保险人数
     */
    public Integer getMedicalNum() {
        return medicalNum;
    }

    /**
     * 设置医疗保险人数
     *
     * @param medicalNum 医疗保险人数
     */
    public void setMedicalNum(Integer medicalNum) {
        this.medicalNum = medicalNum;
    }

    /**
     * 获取工伤保险人数
     *
     * @return EmpInjuryNum - 工伤保险人数
     */
    public Integer getEmpInjuryNum() {
        return empInjuryNum;
    }

    /**
     * 设置工伤保险人数
     *
     * @param empInjuryNum 工伤保险人数
     */
    public void setEmpInjuryNum(Integer empInjuryNum) {
        this.empInjuryNum = empInjuryNum;
    }

    /**
     * 获取生育保险人数
     *
     * @return MaternityNum - 生育保险人数
     */
    public Integer getMaternityNum() {
        return maternityNum;
    }

    /**
     * 设置生育保险人数
     *
     * @param maternityNum 生育保险人数
     */
    public void setMaternityNum(Integer maternityNum) {
        this.maternityNum = maternityNum;
    }

    /**
     * 获取单位缴费基数
     *
     * @return PaymentBase - 单位缴费基数
     */
    public BigDecimal getPaymentBase() {
        return paymentBase;
    }

    /**
     * 设置单位缴费基数
     *
     * @param paymentBase 单位缴费基数
     */
    public void setPaymentBase(BigDecimal paymentBase) {
        this.paymentBase = paymentBase;
    }

    /**
     * 获取单位缴费基数是否公示
     *
     * @return PaymentBaseIsPub - 单位缴费基数是否公示
     */
    public String getPaymentBaseIsPub() {
        return paymentBaseIsPub;
    }

    /**
     * 设置单位缴费基数是否公示
     *
     * @param paymentBaseIsPub 单位缴费基数是否公示
     */
    public void setPaymentBaseIsPub(String paymentBaseIsPub) {
        this.paymentBaseIsPub = paymentBaseIsPub;
    }

    /**
     * 获取本期实际缴费金额
     *
     * @return ActualPayment - 本期实际缴费金额
     */
    public BigDecimal getActualPayment() {
        return actualPayment;
    }

    /**
     * 设置本期实际缴费金额
     *
     * @param actualPayment 本期实际缴费金额
     */
    public void setActualPayment(BigDecimal actualPayment) {
        this.actualPayment = actualPayment;
    }

    /**
     * 获取本期实际缴费金额是否公示
     *
     * @return ActualPaymentIsPub - 本期实际缴费金额是否公示
     */
    public String getActualPaymentIsPub() {
        return actualPaymentIsPub;
    }

    /**
     * 设置本期实际缴费金额是否公示
     *
     * @param actualPaymentIsPub 本期实际缴费金额是否公示
     */
    public void setActualPaymentIsPub(String actualPaymentIsPub) {
        this.actualPaymentIsPub = actualPaymentIsPub;
    }

    /**
     * 获取单位累计欠缴金额
     *
     * @return CumulArrears - 单位累计欠缴金额
     */
    public BigDecimal getCumulArrears() {
        return cumulArrears;
    }

    /**
     * 设置单位累计欠缴金额
     *
     * @param cumulArrears 单位累计欠缴金额
     */
    public void setCumulArrears(BigDecimal cumulArrears) {
        this.cumulArrears = cumulArrears;
    }

    /**
     * 获取单位累计欠缴金额是否公示
     *
     * @return CumulArrearsIsPub - 单位累计欠缴金额是否公示
     */
    public String getCumulArrearsIsPub() {
        return cumulArrearsIsPub;
    }

    /**
     * 设置单位累计欠缴金额是否公示
     *
     * @param cumulArrearsIsPub 单位累计欠缴金额是否公示
     */
    public void setCumulArrearsIsPub(String cumulArrearsIsPub) {
        this.cumulArrearsIsPub = cumulArrearsIsPub;
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

    /**
     * 获取唯一标识
     *
     * @return SocialID - 唯一标识
     */
    public String getSocialID() {
        return socialID;
    }

    /**
     * 设置唯一标识
     *
     * @param socialID 唯一标识
     */
    public void setSocialID(String socialID) {
        this.socialID = socialID;
    }

    /**
     * 获取单位缴费基数-城镇职工基本养老保险
     *
     * @return PaymentEndowment - 单位缴费基数-城镇职工基本养老保险
     */
    public BigDecimal getPaymentEndowment() {
        return paymentEndowment;
    }

    /**
     * 设置单位缴费基数-城镇职工基本养老保险
     *
     * @param paymentEndowment 单位缴费基数-城镇职工基本养老保险
     */
    public void setPaymentEndowment(BigDecimal paymentEndowment) {
        this.paymentEndowment = paymentEndowment;
    }

    /**
     * 获取单位缴费基数-失业保险
     *
     * @return PaymentUnemployment - 单位缴费基数-失业保险
     */
    public BigDecimal getPaymentUnemployment() {
        return paymentUnemployment;
    }

    /**
     * 设置单位缴费基数-失业保险
     *
     * @param paymentUnemployment 单位缴费基数-失业保险
     */
    public void setPaymentUnemployment(BigDecimal paymentUnemployment) {
        this.paymentUnemployment = paymentUnemployment;
    }

    /**
     * 获取单位缴费基数-医疗保险
     *
     * @return PaymentMedical - 单位缴费基数-医疗保险
     */
    public BigDecimal getPaymentMedical() {
        return paymentMedical;
    }

    /**
     * 设置单位缴费基数-医疗保险
     *
     * @param paymentMedical 单位缴费基数-医疗保险
     */
    public void setPaymentMedical(BigDecimal paymentMedical) {
        this.paymentMedical = paymentMedical;
    }

    /**
     * 获取单位缴费基数-工伤保险
     *
     * @return PaymentEmpInjury - 单位缴费基数-工伤保险
     */
    public BigDecimal getPaymentEmpInjury() {
        return paymentEmpInjury;
    }

    /**
     * 设置单位缴费基数-工伤保险
     *
     * @param paymentEmpInjury 单位缴费基数-工伤保险
     */
    public void setPaymentEmpInjury(BigDecimal paymentEmpInjury) {
        this.paymentEmpInjury = paymentEmpInjury;
    }

    /**
     * 获取单位缴费基数-生育保险
     *
     * @return PaymentMaternity - 单位缴费基数-生育保险
     */
    public BigDecimal getPaymentMaternity() {
        return paymentMaternity;
    }

    /**
     * 设置单位缴费基数-生育保险
     *
     * @param paymentMaternity 单位缴费基数-生育保险
     */
    public void setPaymentMaternity(BigDecimal paymentMaternity) {
        this.paymentMaternity = paymentMaternity;
    }

    /**
     * 获取本期实际缴费金额-城镇职工基本养老保险
     *
     * @return ActualPayEndowment - 本期实际缴费金额-城镇职工基本养老保险
     */
    public BigDecimal getActualPayEndowment() {
        return actualPayEndowment;
    }

    /**
     * 设置本期实际缴费金额-城镇职工基本养老保险
     *
     * @param actualPayEndowment 本期实际缴费金额-城镇职工基本养老保险
     */
    public void setActualPayEndowment(BigDecimal actualPayEndowment) {
        this.actualPayEndowment = actualPayEndowment;
    }

    /**
     * 获取本期实际缴费金额-失业保险
     *
     * @return ActualPayUnemployment - 本期实际缴费金额-失业保险
     */
    public BigDecimal getActualPayUnemployment() {
        return actualPayUnemployment;
    }

    /**
     * 设置本期实际缴费金额-失业保险
     *
     * @param actualPayUnemployment 本期实际缴费金额-失业保险
     */
    public void setActualPayUnemployment(BigDecimal actualPayUnemployment) {
        this.actualPayUnemployment = actualPayUnemployment;
    }

    /**
     * 获取本期实际缴费金额-医疗保险
     *
     * @return ActualPayMedical - 本期实际缴费金额-医疗保险
     */
    public BigDecimal getActualPayMedical() {
        return actualPayMedical;
    }

    /**
     * 设置本期实际缴费金额-医疗保险
     *
     * @param actualPayMedical 本期实际缴费金额-医疗保险
     */
    public void setActualPayMedical(BigDecimal actualPayMedical) {
        this.actualPayMedical = actualPayMedical;
    }

    /**
     * 获取本期实际缴费金额-工伤保险
     *
     * @return ActualPayEmpInjury - 本期实际缴费金额-工伤保险
     */
    public BigDecimal getActualPayEmpInjury() {
        return actualPayEmpInjury;
    }

    /**
     * 设置本期实际缴费金额-工伤保险
     *
     * @param actualPayEmpInjury 本期实际缴费金额-工伤保险
     */
    public void setActualPayEmpInjury(BigDecimal actualPayEmpInjury) {
        this.actualPayEmpInjury = actualPayEmpInjury;
    }

    /**
     * 获取本期实际缴费金额-生育保险
     *
     * @return ActualPayMaternity - 本期实际缴费金额-生育保险
     */
    public BigDecimal getActualPayMaternity() {
        return actualPayMaternity;
    }

    /**
     * 设置本期实际缴费金额-生育保险
     *
     * @param actualPayMaternity 本期实际缴费金额-生育保险
     */
    public void setActualPayMaternity(BigDecimal actualPayMaternity) {
        this.actualPayMaternity = actualPayMaternity;
    }

    /**
     * 获取单位累计欠缴金额-城镇职工基本养老保险
     *
     * @return CumuEndowment - 单位累计欠缴金额-城镇职工基本养老保险
     */
    public BigDecimal getCumuEndowment() {
        return cumuEndowment;
    }

    /**
     * 设置单位累计欠缴金额-城镇职工基本养老保险
     *
     * @param cumuEndowment 单位累计欠缴金额-城镇职工基本养老保险
     */
    public void setCumuEndowment(BigDecimal cumuEndowment) {
        this.cumuEndowment = cumuEndowment;
    }

    /**
     * 获取单位累计欠缴金额-失业保险
     *
     * @return CumuUnemployment - 单位累计欠缴金额-失业保险
     */
    public BigDecimal getCumuUnemployment() {
        return cumuUnemployment;
    }

    /**
     * 设置单位累计欠缴金额-失业保险
     *
     * @param cumuUnemployment 单位累计欠缴金额-失业保险
     */
    public void setCumuUnemployment(BigDecimal cumuUnemployment) {
        this.cumuUnemployment = cumuUnemployment;
    }

    /**
     * 获取单位累计欠缴金额-医疗保险
     *
     * @return CumuMedical - 单位累计欠缴金额-医疗保险
     */
    public BigDecimal getCumuMedical() {
        return cumuMedical;
    }

    /**
     * 设置单位累计欠缴金额-医疗保险
     *
     * @param cumuMedical 单位累计欠缴金额-医疗保险
     */
    public void setCumuMedical(BigDecimal cumuMedical) {
        this.cumuMedical = cumuMedical;
    }

    /**
     * 获取单位累计欠缴金额-工伤保险
     *
     * @return CumuEmpInjury - 单位累计欠缴金额-工伤保险
     */
    public BigDecimal getCumuEmpInjury() {
        return cumuEmpInjury;
    }

    /**
     * 设置单位累计欠缴金额-工伤保险
     *
     * @param cumuEmpInjury 单位累计欠缴金额-工伤保险
     */
    public void setCumuEmpInjury(BigDecimal cumuEmpInjury) {
        this.cumuEmpInjury = cumuEmpInjury;
    }

    /**
     * 获取单位累计欠缴金额-生育保险
     *
     * @return CumuMaternity - 单位累计欠缴金额-生育保险
     */
    public BigDecimal getCumuMaternity() {
        return cumuMaternity;
    }

    /**
     * 设置单位累计欠缴金额-生育保险
     *
     * @param cumuMaternity 单位累计欠缴金额-生育保险
     */
    public void setCumuMaternity(BigDecimal cumuMaternity) {
        this.cumuMaternity = cumuMaternity;
    }
}