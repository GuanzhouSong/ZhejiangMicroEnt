/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.yr.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 描述:    cs_individ_questionnaire 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2016年09月24日
 */
@Table(name = "cs_individ_questionnaire")
public class IndividQuestionnaire implements Serializable {
    /**
     * 主键ID
     */
    @Id
    @Column(name = "id")
    private Integer id;

    /**
     * 个转企调查ID
     */
    @Column(name = "QueID")
    private String queID;

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
     * 年产值或年营业额(万元)
     */
    @Column(name = "VendInc")
    private BigDecimal vendInc;

    /**
     * 年利润(万元)
     */
    @Column(name = "ProGro")
    private BigDecimal proGro;

    /**
     * 纳税总额(万元)
     */
    @Column(name = "RatGro")
    private BigDecimal ratGro;

    /**
     * 社保总费用
     */
    @Column(name = "SocIns")
    private BigDecimal socIns;

    /**
     * 经营面积
     */
    @Column(name = "OpSpace")
    private BigDecimal opSpace;

    /**
     * 从业人数
     */
    @Column(name = "EmpNum")
    private Integer empNum;

    /**
     * 参加社保人数
     */
    @Column(name = "Insured")
    private Integer insured;

    /**
     * 企业融资情况
     */
    @Column(name = "ComLoan")
    private BigDecimal comLoan;

    /**
     * 注册商标数
     */
    @Column(name = "DomTraRegs")
    private Integer domTraRegs;

    /**
     * 专利数
     */
    @Column(name = "PatAmount")
    private Integer patAmount;

    /**
     * 荣誉数(件)
     */
    @Column(name = "HorAmount")
    private Integer horAmount;

    /**
     * 纳税人类型1：一般纳税人，2：小规模纳税人
     */
    @Column(name = "TaxpayerType")
    private String taxpayerType;

    /**
     * 1：转企前，2：转企后
     */
    @Column(name = "QueFlag")
    private String queFlag;

    /**
     * 填报日期
     */
    @Column(name = "SetDate")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date setDate;

    /**
     * 关联表ID
     */
    @Column(name = "QmID")
    private String qmID;

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
     * 获取个转企调查ID
     *
     * @return QueID - 个转企调查ID
     */
    public String getQueID() {
        return queID;
    }

    /**
     * 设置个转企调查ID
     *
     * @param queID 个转企调查ID
     */
    public void setQueID(String queID) {
        this.queID = queID;
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
     * 获取年产值或年营业额(万元)
     *
     * @return VendInc - 年产值或年营业额(万元)
     */
    public BigDecimal getVendInc() {
        return vendInc;
    }

    /**
     * 设置年产值或年营业额(万元)
     *
     * @param vendInc 年产值或年营业额(万元)
     */
    public void setVendInc(BigDecimal vendInc) {
        this.vendInc = vendInc;
    }

    /**
     * 获取年利润(万元)
     *
     * @return ProGro - 年利润(万元)
     */
    public BigDecimal getProGro() {
        return proGro;
    }

    /**
     * 设置年利润(万元)
     *
     * @param proGro 年利润(万元)
     */
    public void setProGro(BigDecimal proGro) {
        this.proGro = proGro;
    }

    /**
     * 获取纳税总额(万元)
     *
     * @return RatGro - 纳税总额(万元)
     */
    public BigDecimal getRatGro() {
        return ratGro;
    }

    /**
     * 设置纳税总额(万元)
     *
     * @param ratGro 纳税总额(万元)
     */
    public void setRatGro(BigDecimal ratGro) {
        this.ratGro = ratGro;
    }

    /**
     * 获取社保总费用
     *
     * @return SocIns - 社保总费用
     */
    public BigDecimal getSocIns() {
        return socIns;
    }

    /**
     * 设置社保总费用
     *
     * @param socIns 社保总费用
     */
    public void setSocIns(BigDecimal socIns) {
        this.socIns = socIns;
    }

    /**
     * 获取经营面积
     *
     * @return OpSpace - 经营面积
     */
    public BigDecimal getOpSpace() {
        return opSpace;
    }

    /**
     * 设置经营面积
     *
     * @param opSpace 经营面积
     */
    public void setOpSpace(BigDecimal opSpace) {
        this.opSpace = opSpace;
    }

    /**
     * 获取从业人数
     *
     * @return EmpNum - 从业人数
     */
    public Integer getEmpNum() {
        return empNum;
    }

    /**
     * 设置从业人数
     *
     * @param empNum 从业人数
     */
    public void setEmpNum(Integer empNum) {
        this.empNum = empNum;
    }

    /**
     * 获取参加社保人数
     *
     * @return Insured - 参加社保人数
     */
    public Integer getInsured() {
        return insured;
    }

    /**
     * 设置参加社保人数
     *
     * @param insured 参加社保人数
     */
    public void setInsured(Integer insured) {
        this.insured = insured;
    }

    /**
     * 获取企业融资情况
     *
     * @return ComLoan - 企业融资情况
     */
    public BigDecimal getComLoan() {
        return comLoan;
    }

    /**
     * 设置企业融资情况
     *
     * @param comLoan 企业融资情况
     */
    public void setComLoan(BigDecimal comLoan) {
        this.comLoan = comLoan;
    }

    /**
     * 获取注册商标数
     *
     * @return DomTraRegs - 注册商标数
     */
    public Integer getDomTraRegs() {
        return domTraRegs;
    }

    /**
     * 设置注册商标数
     *
     * @param domTraRegs 注册商标数
     */
    public void setDomTraRegs(Integer domTraRegs) {
        this.domTraRegs = domTraRegs;
    }

    /**
     * 获取专利数
     *
     * @return PatAmount - 专利数
     */
    public Integer getPatAmount() {
        return patAmount;
    }

    /**
     * 设置专利数
     *
     * @param patAmount 专利数
     */
    public void setPatAmount(Integer patAmount) {
        this.patAmount = patAmount;
    }

    /**
     * 获取荣誉数(件)
     *
     * @return HorAmount - 荣誉数(件)
     */
    public Integer getHorAmount() {
        return horAmount;
    }

    /**
     * 设置荣誉数(件)
     *
     * @param horAmount 荣誉数(件)
     */
    public void setHorAmount(Integer horAmount) {
        this.horAmount = horAmount;
    }

    /**
     * 获取纳税人类型1：一般纳税人，2：小规模纳税人
     *
     * @return TaxpayerType - 纳税人类型1：一般纳税人，2：小规模纳税人
     */
    public String getTaxpayerType() {
        return taxpayerType;
    }

    /**
     * 设置纳税人类型1：一般纳税人，2：小规模纳税人
     *
     * @param taxpayerType 纳税人类型1：一般纳税人，2：小规模纳税人
     */
    public void setTaxpayerType(String taxpayerType) {
        this.taxpayerType = taxpayerType;
    }

    /**
     * 获取1：转企前，2：转企后
     *
     * @return QueFlag - 1：转企前，2：转企后
     */
    public String getQueFlag() {
        return queFlag;
    }

    /**
     * 设置1：转企前，2：转企后
     *
     * @param queFlag 1：转企前，2：转企后
     */
    public void setQueFlag(String queFlag) {
        this.queFlag = queFlag;
    }

    /**
     * 获取填报日期
     *
     * @return SetDate - 填报日期
     */
    public Date getSetDate() {
        return setDate;
    }

    /**
     * 设置填报日期
     *
     * @param setDate 填报日期
     */
    public void setSetDate(Date setDate) {
        this.setDate = setDate;
    }

    /**
     * 获取关联表ID
     *
     * @return QmID - 关联表ID
     */
    public String getQmID() {
        return qmID;
    }

    /**
     * 设置关联表ID
     *
     * @param qmID 关联表ID
     */
    public void setQmID(String qmID) {
        this.qmID = qmID;
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