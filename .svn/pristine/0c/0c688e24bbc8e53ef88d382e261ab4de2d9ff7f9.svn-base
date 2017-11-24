/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.im.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.icinfo.cs.common.anno.Forbidword;
import com.icinfo.framework.mybatis.mapper.annotation.Before;

/**
 * 描述:    cs_im_case 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2016年08月28日
 */
@Table(name = "cs_im_case")
public class ImCase implements Serializable {
    /**
     * 主键自增id
     */
    @Id
    @Column(name = "id")
    private Integer id;

    /**
     * 主体身份代码
     */
    @Column(name = "PriPID")
    private String priPID;

    /**
     * 企业(机构)名称
     */
    @Column(name = "EntName")
    @NotNull
 
    private String entName;

    /**
     * 注册号
     */
    @Column(name = "RegNO")
    private String regNO;

    /**
     * 统一社会信用代码
     */
    @Column(name = "UniCode")
    private String uniCode;

    /**
     * 行政处罚ID(UUID)
     */
    @Column(name = "CaseNO")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    private String caseNO;

    /**
     * 违法行为类型
     */
    @Column(name = "IllegActType")
    @Forbidword
  
    private String illegActType;

    /**
     * 处罚种类
     */
    @Column(name = "PenType")
    @Forbidword
    private String penType;

    /**
     * 罚款金额
     */
    @Column(name = "PenAm")
    private BigDecimal penAm;

    /**
     * 没收金额
     */
    @Column(name = "ForfAm")
    private BigDecimal forfAm;

    /**
     * 处罚决定书文号
     */
    @Column(name = "PenDecNo")
    @Forbidword 
    private String penDecNo;

    /**
     * 作出处罚决定书日期
     */
    @Column(name = "PenDecIssDate")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date penDecIssDate;

    /**
     * 创建时间戳
     */
    @Column(name = "CreateTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;

    /**
     * 处罚种类（中文名称）
     */
    @Column(name = "PenTypeCN")
   
    private String penTypeCN;

    /**
     * 类别选择：1变更，2诉讼，3复议
     */
    @Column(name = "PubType")
    private String pubType;

    /**
     * 公示标识1：公示，2：暂存，0：历史
     */
    @Column(name = "PubFlag")
    private String pubFlag;

    /**
     * 作出行政处罚决定机关名称
     */
    @Column(name = "JudAuth")
    @Forbidword
    private String judAuth;

    /**
     * 公示日期
     */
    @Column(name = "PublicDate")
    private Date publicDate;

    /**
     * 处罚内容
     */
    @Column(name = "PenContent")
    @Forbidword
    private String penContent;

    private static final long serialVersionUID = 1L;

    /**
     * 获取主键自增id
     *
     * @return id - 主键自增id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置主键自增id
     *
     * @param id 主键自增id
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
     * 获取企业(机构)名称
     *
     * @return EntName - 企业(机构)名称
     */
    public String getEntName() {
        return entName;
    }

    /**
     * 设置企业(机构)名称
     *
     * @param entName 企业(机构)名称
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
     * 获取行政处罚ID(UUID)
     *
     * @return CaseNO - 行政处罚ID(UUID)
     */
    public String getCaseNO() {
        return caseNO;
    }

    /**
     * 设置行政处罚ID(UUID)
     *
     * @param caseNO 行政处罚ID(UUID)
     */
    public void setCaseNO(String caseNO) {
        this.caseNO = caseNO;
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
     * 获取罚款金额
     *
     * @return PenAm - 罚款金额
     */
    public BigDecimal getPenAm() {
        return penAm;
    }

    /**
     * 设置罚款金额
     *
     * @param penAm 罚款金额
     */
    public void setPenAm(BigDecimal penAm) {
        this.penAm = penAm;
    }

    /**
     * 获取没收金额
     *
     * @return ForfAm - 没收金额
     */
    public BigDecimal getForfAm() {
        return forfAm;
    }

    /**
     * 设置没收金额
     *
     * @param forfAm 没收金额
     */
    public void setForfAm(BigDecimal forfAm) {
        this.forfAm = forfAm;
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
     * 获取作出处罚决定书日期
     *
     * @return PenDecIssDate - 作出处罚决定书日期
     */
    public Date getPenDecIssDate() {
        return penDecIssDate;
    }

    /**
     * 设置作出处罚决定书日期
     *
     * @param penDecIssDate 作出处罚决定书日期
     */
    public void setPenDecIssDate(Date penDecIssDate) {
        this.penDecIssDate = penDecIssDate;
    }

    /**
     * 获取创建时间戳
     *
     * @return CreateTime - 创建时间戳
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间戳
     *
     * @param createTime 创建时间戳
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取处罚种类（中文名称）
     *
     * @return PenTypeCN - 处罚种类（中文名称）
     */
    public String getPenTypeCN() {
        return penTypeCN;
    }

    /**
     * 设置处罚种类（中文名称）
     *
     * @param penTypeCN 处罚种类（中文名称）
     */
    public void setPenTypeCN(String penTypeCN) {
        this.penTypeCN = penTypeCN;
    }

    /**
     * 获取类别选择：1变更，2诉讼，3复议
     *
     * @return PubType - 类别选择：1变更，2诉讼，3复议
     */
    public String getPubType() {
        return pubType;
    }

    /**
     * 设置类别选择：1变更，2诉讼，3复议
     *
     * @param pubType 类别选择：1变更，2诉讼，3复议
     */
    public void setPubType(String pubType) {
        this.pubType = pubType;
    }

    /**
     * 获取公示标识1：公示，2：暂存，0：历史
     *
     * @return PubFlag - 公示标识1：公示，2：暂存，0：历史
     */
    public String getPubFlag() {
        return pubFlag;
    }

    /**
     * 设置公示标识1：公示，2：暂存，0：历史
     *
     * @param pubFlag 公示标识1：公示，2：暂存，0：历史
     */
    public void setPubFlag(String pubFlag) {
        this.pubFlag = pubFlag;
    }

    /**
     * 获取作出行政处罚决定机关名称
     *
     * @return JudAuth - 作出行政处罚决定机关名称
     */
    public String getJudAuth() {
        return judAuth;
    }

    /**
     * 设置作出行政处罚决定机关名称
     *
     * @param judAuth 作出行政处罚决定机关名称
     */
    public void setJudAuth(String judAuth) {
        this.judAuth = judAuth;
    }

    /**
     * 获取公示日期
     *
     * @return PublicDate - 公示日期
     */
    public Date getPublicDate() {
        return publicDate;
    }

    /**
     * 设置公示日期
     *
     * @param publicDate 公示日期
     */
    public void setPublicDate(Date publicDate) {
        this.publicDate = publicDate;
    }

    /**
     * 获取处罚内容
     *
     * @return PenContent - 处罚内容
     */
    public String getPenContent() {
        return penContent;
    }

    /**
     * 设置处罚内容
     *
     * @param penContent 处罚内容
     */
    public void setPenContent(String penContent) {
        this.penContent = penContent;
    }
}