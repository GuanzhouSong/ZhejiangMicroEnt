/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.smallent.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.icinfo.framework.mybatis.mapper.annotation.Before;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.*;

/**
 * 描述:    cs_sm_support 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2016年10月31日
 */
@Table(name = "cs_sm_support")
public class SmSupportInfo implements Serializable {
    @Id
    @Column(name = "id")
    private Integer id;

    /**
     * UUID
     */
    @Column(name = "UID")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    private String UID;

    /**
     * 主体身份代码
     */
    @Column(name = "PriPID")
    private String priPID;

    /**
     * 享受扶持年度
     */
    @Column(name = "EnjoyYear")
    private String enjoyYear;

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
     * 享受扶持政策依据
     */
    @Column(name = "EnjSpBasis")
    private String enjSpBasis;

    /**
     * 享受扶持政策内容
     */
    @Column(name = "EnjSpContent")
    private String enjSpContent;

    /**
     * 享受扶持政策的数额 - 单位：元
     */
    @Column(name = "EnjSpAmount")
    private BigDecimal enjSpAmount;

    /**
     * 实施扶持政策的部门
     */
    @Column(name = "ImpSpDepart")
    private String impSpDepart;

    /**
     * 实施扶持政策日期
     */
    @Column(name = "ImpSpDate")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date impSpDate;

    /**
     * 创建时间
     */
    @Column(name = "EnjoyCreateTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date enjoyCreateTime;

    /**
     * 时间戳
     */
    @Column(name = "CreateTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;

    /**
     * 区域编码
     */
    @Column(name = "RegOrg")
    private String regOrg;

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
     * 获取享受扶持年度
     *
     * @return EnjoyYear - 享受扶持年度
     */
    public String getEnjoyYear() {
        return enjoyYear;
    }

    /**
     * 设置享受扶持年度
     *
     * @param enjoyYear 享受扶持年度
     */
    public void setEnjoyYear(String enjoyYear) {
        this.enjoyYear = enjoyYear;
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
     * 获取享受扶持政策依据
     *
     * @return EnjSpBasis - 享受扶持政策依据
     */
    public String getEnjSpBasis() {
        return enjSpBasis;
    }

    /**
     * 设置享受扶持政策依据
     *
     * @param enjSpBasis 享受扶持政策依据
     */
    public void setEnjSpBasis(String enjSpBasis) {
        this.enjSpBasis = enjSpBasis;
    }

    /**
     * 获取享受扶持政策内容
     *
     * @return EnjSpContent - 享受扶持政策内容
     */
    public String getEnjSpContent() {
        return enjSpContent;
    }

    /**
     * 设置享受扶持政策内容
     *
     * @param enjSpContent 享受扶持政策内容
     */
    public void setEnjSpContent(String enjSpContent) {
        this.enjSpContent = enjSpContent;
    }

    /**
     * 获取享受扶持政策的数额 - 单位：元
     *
     * @return EnjSpAmount - 享受扶持政策的数额 - 单位：元
     */
    public BigDecimal getEnjSpAmount() {
        return enjSpAmount;
    }

    /**
     * 设置享受扶持政策的数额 - 单位：元
     *
     * @param enjSpAmount 享受扶持政策的数额 - 单位：元
     */
    public void setEnjSpAmount(BigDecimal enjSpAmount) {
        this.enjSpAmount = enjSpAmount;
    }

    /**
     * 获取实施扶持政策的部门
     *
     * @return ImpSpDepart - 实施扶持政策的部门
     */
    public String getImpSpDepart() {
        return impSpDepart;
    }

    /**
     * 设置实施扶持政策的部门
     *
     * @param impSpDepart 实施扶持政策的部门
     */
    public void setImpSpDepart(String impSpDepart) {
        this.impSpDepart = impSpDepart;
    }

    /**
     * 获取实施扶持政策日期
     *
     * @return ImpSpDate - 实施扶持政策日期
     */
    public Date getImpSpDate() {
        return impSpDate;
    }

    /**
     * 设置实施扶持政策日期
     *
     * @param impSpDate 实施扶持政策日期
     */
    public void setImpSpDate(Date impSpDate) {
        this.impSpDate = impSpDate;
    }

    /**
     * 获取创建时间
     *
     * @return EnjoyCreateTime - 创建时间
     */
    public Date getEnjoyCreateTime() {
        return enjoyCreateTime;
    }

    /**
     * 设置创建时间
     *
     * @param enjoyCreateTime 创建时间
     */
    public void setEnjoyCreateTime(Date enjoyCreateTime) {
        this.enjoyCreateTime = enjoyCreateTime;
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

    public String getRegOrg() {
        return regOrg;
    }

    public void setRegOrg(String regOrg) {
        this.regOrg = regOrg;
    }
}