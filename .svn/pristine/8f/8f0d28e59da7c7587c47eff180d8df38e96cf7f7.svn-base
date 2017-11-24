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
 * 描述:    cs_sm_baseinfo 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2016年10月31日
 */
@Table(name = "cs_sm_baseinfo")
public class SmBaseInfo implements Serializable {
    /**
     * 自增长id
     */
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
     * 小微企业所属年度
     */
    @Column(name = "DirYear")
    private String dirYear;

    /**
     * 统一社会信用代码
     */
    @Column(name = "UniSCID")
    private String uniSCID;

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
     * 企业类型大类
     */
    @Column(name = "EntTypeCatg")
    private String entTypeCatg;

    /**
     * 企业类型
     */
    @Column(name = "EntType")
    private String entType;

    /**
     * 成立日期
     */
    @Column(name = "EstDate")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date estDate;

    /**
     * 注册资本
     */
    @Column(name = "RegCap")
    private BigDecimal regCap;

    /**
     * 登记机关
     */
    @Column(name = "RegOrg")
    private String regOrg;

    /**
     * 所属门类
     */
    @Column(name = "IndustryPhy")
    private String industryPhy;

    /**
     * 行业代码
     */
    @Column(name = "IndustryCo")
    private String industryCo;

    /**
     * 年报年度
     */
    @Column(name = "Year")
    private String year;

    /**
     * 资产总额/资金数额 - 是否公示1：公示，0：不公示
     */
    @Column(name = "AssgroIsp")
    private String assgroIsp;

    /**
     * 资产总额/资金数额 - 单位：元
     */
    @Column(name = "Assgro")
    private BigDecimal assgro;

    /**
     * 其中主营业务收入/营业收入 - 是否公示1：公示，0：不公示
     */
    @Column(name = "MaiBusincIsp")
    private String maiBusincIsp;

    /**
     * 其中主营业务收入/营业收入/销售(营业)收入 - 单位：元
     */
    @Column(name = "MaiBusinc")
    private BigDecimal maiBusinc;

    /**
     * 从业人数 - 是否公示1：公示，0：不公示
     */
    @Column(name = "EmpNumIsp")
    private String empNumIsp;

    /**
     * 从业人数
     */
    @Column(name = "EmpNum")
    private String empNum;

    /**
     * 列入小微企业理由编码
     */
    @Column(name = "DirCreateReasonCode")
    private String dirCreateReasonCode;

    /**
     * 列入小微企业理由
     */
    @Column(name = "DirCreateReason")
    private String dirCreateReason;

    /**
     * 列入时间
     */
    @Column(name = "DirCreateTime")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date dirCreateTime;

    /**
     * 时间戳
     */
    @Column(name = "CreateTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;

    private static final long serialVersionUID = 1L;

    /**
     * 获取自增长id
     *
     * @return id - 自增长id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置自增长id
     *
     * @param id 自增长id
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
     * 获取小微企业所属年度
     *
     * @return DirYear - 小微企业所属年度
     */
    public String getDirYear() {
        return dirYear;
    }

    /**
     * 设置小微企业所属年度
     *
     * @param dirYear 小微企业所属年度
     */
    public void setDirYear(String dirYear) {
        this.dirYear = dirYear;
    }

    /**
     * 获取统一社会信用代码
     *
     * @return UniSCID - 统一社会信用代码
     */
    public String getUniSCID() {
        return uniSCID;
    }

    /**
     * 设置统一社会信用代码
     *
     * @param uniSCID 统一社会信用代码
     */
    public void setUniSCID(String uniSCID) {
        this.uniSCID = uniSCID;
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
     * 获取企业类型大类
     *
     * @return EntTypeCatg - 企业类型大类
     */
    public String getEntTypeCatg() {
        return entTypeCatg;
    }

    /**
     * 设置企业类型大类
     *
     * @param entTypeCatg 企业类型大类
     */
    public void setEntTypeCatg(String entTypeCatg) {
        this.entTypeCatg = entTypeCatg;
    }

    /**
     * 获取企业类型
     *
     * @return EntType - 企业类型
     */
    public String getEntType() {
        return entType;
    }

    /**
     * 设置企业类型
     *
     * @param entType 企业类型
     */
    public void setEntType(String entType) {
        this.entType = entType;
    }

    /**
     * 获取成立日期
     *
     * @return EstDate - 成立日期
     */
    public Date getEstDate() {
        return estDate;
    }

    /**
     * 设置成立日期
     *
     * @param estDate 成立日期
     */
    public void setEstDate(Date estDate) {
        this.estDate = estDate;
    }

    /**
     * 获取注册资本
     *
     * @return RegCap - 注册资本
     */
    public BigDecimal getRegCap() {
        return regCap;
    }

    /**
     * 设置注册资本
     *
     * @param regCap 注册资本
     */
    public void setRegCap(BigDecimal regCap) {
        this.regCap = regCap;
    }

    /**
     * 获取登记机关
     *
     * @return RegOrg - 登记机关
     */
    public String getRegOrg() {
        return regOrg;
    }

    /**
     * 设置登记机关
     *
     * @param regOrg 登记机关
     */
    public void setRegOrg(String regOrg) {
        this.regOrg = regOrg;
    }

    /**
     * 获取所属门类
     *
     * @return IndustryPhy - 所属门类
     */
    public String getIndustryPhy() {
        return industryPhy;
    }

    /**
     * 设置所属门类
     *
     * @param industryPhy 所属门类
     */
    public void setIndustryPhy(String industryPhy) {
        this.industryPhy = industryPhy;
    }

    /**
     * 获取行业代码
     *
     * @return IndustryCo - 行业代码
     */
    public String getIndustryCo() {
        return industryCo;
    }

    /**
     * 设置行业代码
     *
     * @param industryCo 行业代码
     */
    public void setIndustryCo(String industryCo) {
        this.industryCo = industryCo;
    }

    /**
     * 获取年报年度
     *
     * @return Year - 年报年度
     */
    public String getYear() {
        return year;
    }

    /**
     * 设置年报年度
     *
     * @param year 年报年度
     */
    public void setYear(String year) {
        this.year = year;
    }

    /**
     * 获取资产总额/资金数额 - 是否公示1：公示，0：不公示
     *
     * @return AssgroIsp - 资产总额/资金数额 - 是否公示1：公示，0：不公示
     */
    public String getAssgroIsp() {
        return assgroIsp;
    }

    /**
     * 设置资产总额/资金数额 - 是否公示1：公示，0：不公示
     *
     * @param assgroIsp 资产总额/资金数额 - 是否公示1：公示，0：不公示
     */
    public void setAssgroIsp(String assgroIsp) {
        this.assgroIsp = assgroIsp;
    }

    /**
     * 获取资产总额/资金数额 - 单位：元
     *
     * @return Assgro - 资产总额/资金数额 - 单位：元
     */
    public BigDecimal getAssgro() {
        return assgro;
    }

    /**
     * 设置资产总额/资金数额 - 单位：元
     *
     * @param assgro 资产总额/资金数额 - 单位：元
     */
    public void setAssgro(BigDecimal assgro) {
        this.assgro = assgro;
    }

    /**
     * 获取其中主营业务收入/营业收入 - 是否公示1：公示，0：不公示
     *
     * @return MaiBusincIsp - 其中主营业务收入/营业收入 - 是否公示1：公示，0：不公示
     */
    public String getMaiBusincIsp() {
        return maiBusincIsp;
    }

    /**
     * 设置其中主营业务收入/营业收入 - 是否公示1：公示，0：不公示
     *
     * @param maiBusincIsp 其中主营业务收入/营业收入 - 是否公示1：公示，0：不公示
     */
    public void setMaiBusincIsp(String maiBusincIsp) {
        this.maiBusincIsp = maiBusincIsp;
    }

    /**
     * 获取其中主营业务收入/营业收入/销售(营业)收入 - 单位：元
     *
     * @return MaiBusinc - 其中主营业务收入/营业收入/销售(营业)收入 - 单位：元
     */
    public BigDecimal getMaiBusinc() {
        return maiBusinc;
    }

    /**
     * 设置其中主营业务收入/营业收入/销售(营业)收入 - 单位：元
     *
     * @param maiBusinc 其中主营业务收入/营业收入/销售(营业)收入 - 单位：元
     */
    public void setMaiBusinc(BigDecimal maiBusinc) {
        this.maiBusinc = maiBusinc;
    }

    /**
     * 获取从业人数 - 是否公示1：公示，0：不公示
     *
     * @return EmpNumIsp - 从业人数 - 是否公示1：公示，0：不公示
     */
    public String getEmpNumIsp() {
        return empNumIsp;
    }

    /**
     * 设置从业人数 - 是否公示1：公示，0：不公示
     *
     * @param empNumIsp 从业人数 - 是否公示1：公示，0：不公示
     */
    public void setEmpNumIsp(String empNumIsp) {
        this.empNumIsp = empNumIsp;
    }

    /**
     * 获取从业人数
     *
     * @return EmpNum - 从业人数
     */
    public String getEmpNum() {
        return empNum;
    }

    /**
     * 设置从业人数
     *
     * @param empNum 从业人数
     */
    public void setEmpNum(String empNum) {
        this.empNum = empNum;
    }

    /**
     * 获取列入小微企业理由编码
     *
     * @return DirCreateReasonCode - 列入小微企业理由编码
     */
    public String getDirCreateReasonCode() {
        return dirCreateReasonCode;
    }

    /**
     * 设置列入小微企业理由编码
     *
     * @param dirCreateReasonCode 列入小微企业理由编码
     */
    public void setDirCreateReasonCode(String dirCreateReasonCode) {
        this.dirCreateReasonCode = dirCreateReasonCode;
    }

    /**
     * 获取列入小微企业理由
     *
     * @return DirCreateReason - 列入小微企业理由
     */
    public String getDirCreateReason() {
        return dirCreateReason;
    }

    /**
     * 设置列入小微企业理由
     *
     * @param dirCreateReason 列入小微企业理由
     */
    public void setDirCreateReason(String dirCreateReason) {
        this.dirCreateReason = dirCreateReason;
    }

    /**
     * 获取列入时间
     *
     * @return DirCreateTime - 列入时间
     */
    public Date getDirCreateTime() {
        return dirCreateTime;
    }

    /**
     * 设置列入时间
     *
     * @param dirCreateTime 列入时间
     */
    public void setDirCreateTime(Date dirCreateTime) {
        this.dirCreateTime = dirCreateTime;
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