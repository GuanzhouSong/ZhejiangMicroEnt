/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.webservice.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.icinfo.framework.mybatis.mapper.annotation.Before;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

/**
 * 描述:    cs_mid_inv 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年02月16日
 */
@Table(name = "cs_mid_inv")
public class WsMidInv implements Serializable {
    /**
     * 自增ID
     */
    @Id
    @Column(name = "id")
//    @Before
//    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    private Integer id;

    /**
     * 主体身份代码
     */
    @Column(name = "PriPID")
    private String priPID;

    /**
     * 住所
     */
    @Column(name = "Dom")
    private String dom;

    /**
     * 币种
     */
    @Column(name = "Currency")
    private String currency;

    /**
     * 承担责任方式/责任形式
     */
    @Column(name = "RespForm")
    private String respForm;

    /**
     * 姓名
     */
    @Column(name = "Inv")
    private String inv;

    /**
     * 投资人身份标识
     */
    @Column(name = "InvID")
    private String invID;

    /**
     * 投资人类型/主管部门类型
     */
    @Column(name = "InvType")
    private String invType;

    /**
     * 国别(地区)
     */
    @Column(name = "Country")
    private String country;

    /**
     * 实缴出资额折万美元
     */
    @Column(name = "CurActConAmUSD")
    private BigDecimal curActConAmUSD;

    /**
     * 出资方式（个独）
     */
    @Column(name = "SConForm")
    private String SConForm;

    /**
     * 证照类型
     */
    @Column(name = "BLicType")
    private String BLicType;

    /**
     * 证照编号
     */
    @Column(name = "BLicNO")
    private String BLicNO;

    /**
     * 认缴出资比例
     */
    @Column(name = "SubConProp")
    private BigDecimal subConProp;

    /**
     * 认缴出资额折万美元
     */
    @Column(name = "ForSubConAmUSD")
    private BigDecimal forSubConAmUSD;

    /**
     * 认缴出资额
     */
    @Column(name = "SubConAm")
    private BigDecimal subConAm;

    /**
     * 实缴出资额
     */
    @Column(name = "AcConAm")
    private BigDecimal acConAm;

    /**
     * 邮政编码
     */
    @Column(name = "PostalCode")
    private String postalCode;

    /**
     * 证件类型
     */
    @Column(name = "CerType")
    private String cerType;

    /**
     * 证件号码
     */
    @Column(name = "CerNO")
    private String cerNO;

    /**
     * 性别
     */
    @Column(name = "Sex")
    private String sex;

    /**
     * 联系电话
     */
    @Column(name = "Tel")
    private String tel;

    /**
     * 出生日期
     */
    @Column(name = "NatDate")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date natDate;

    /**
     * 文化程度
     */
    @Column(name = "LiteDeg")
    private String liteDeg;

    /**
     * 政治面貌
     */
    @Column(name = "PolStand")
    private String polStand;

    /**
     * 民族
     */
    @Column(name = "Nation")
    private String nation;

    /**
     * 职业状况
     */
    @Column(name = "OccSt")
    private String occSt;

    /**
     * 执行合伙事务标志1、是2、否
     */
    @Column(name = "ExeAffSign")
    private String exeAffSign;

    /**
     * 时间戳
     */
    @Column(name = "CreateTime")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date createTime;

    /**
     * 认缴出资方式
     */
    @Column(name = "SubConForm")
    private String subConForm;

    /**
     * 认缴出资日期
     */
    @Column(name = "SubConDate")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date subConDate;

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
     * 获取住所
     *
     * @return Dom - 住所
     */
    public String getDom() {
        return dom;
    }

    /**
     * 设置住所
     *
     * @param dom 住所
     */
    public void setDom(String dom) {
        this.dom = dom;
    }

    /**
     * 获取币种
     *
     * @return Currency - 币种
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * 设置币种
     *
     * @param currency 币种
     */
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    /**
     * 获取承担责任方式/责任形式
     *
     * @return RespForm - 承担责任方式/责任形式
     */
    public String getRespForm() {
        return respForm;
    }

    /**
     * 设置承担责任方式/责任形式
     *
     * @param respForm 承担责任方式/责任形式
     */
    public void setRespForm(String respForm) {
        this.respForm = respForm;
    }

    /**
     * 获取姓名
     *
     * @return Inv - 姓名
     */
    public String getInv() {
        return inv;
    }

    /**
     * 设置姓名
     *
     * @param inv 姓名
     */
    public void setInv(String inv) {
        this.inv = inv;
    }

    /**
     * 获取投资人身份标识
     *
     * @return InvID - 投资人身份标识
     */
    public String getInvID() {
        return invID;
    }

    /**
     * 设置投资人身份标识
     *
     * @param invID 投资人身份标识
     */
    public void setInvID(String invID) {
        this.invID = invID;
    }

    /**
     * 获取投资人类型/主管部门类型
     *
     * @return InvType - 投资人类型/主管部门类型
     */
    public String getInvType() {
        return invType;
    }

    /**
     * 设置投资人类型/主管部门类型
     *
     * @param invType 投资人类型/主管部门类型
     */
    public void setInvType(String invType) {
        this.invType = invType;
    }

    /**
     * 获取国别(地区)
     *
     * @return Country - 国别(地区)
     */
    public String getCountry() {
        return country;
    }

    /**
     * 设置国别(地区)
     *
     * @param country 国别(地区)
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * 获取实缴出资额折万美元
     *
     * @return CurActConAmUSD - 实缴出资额折万美元
     */
    public BigDecimal getCurActConAmUSD() {
        return curActConAmUSD;
    }

    /**
     * 设置实缴出资额折万美元
     *
     * @param curActConAmUSD 实缴出资额折万美元
     */
    public void setCurActConAmUSD(BigDecimal curActConAmUSD) {
        this.curActConAmUSD = curActConAmUSD;
    }

    /**
     * 获取出资方式（个独）
     *
     * @return SConForm - 出资方式（个独）
     */
    public String getSConForm() {
        return SConForm;
    }

    /**
     * 设置出资方式（个独）
     *
     * @param SConForm 出资方式（个独）
     */
    public void setSConForm(String SConForm) {
        this.SConForm = SConForm;
    }

    /**
     * 获取证照类型
     *
     * @return BLicType - 证照类型
     */
    public String getBLicType() {
        return BLicType;
    }

    /**
     * 设置证照类型
     *
     * @param BLicType 证照类型
     */
    public void setBLicType(String BLicType) {
        this.BLicType = BLicType;
    }

    /**
     * 获取证照编号
     *
     * @return BLicNO - 证照编号
     */
    public String getBLicNO() {
        return BLicNO;
    }

    /**
     * 设置证照编号
     *
     * @param BLicNO 证照编号
     */
    public void setBLicNO(String BLicNO) {
        this.BLicNO = BLicNO;
    }

    /**
     * 获取认缴出资比例
     *
     * @return SubConProp - 认缴出资比例
     */
    public BigDecimal getSubConProp() {
        return subConProp;
    }

    /**
     * 设置认缴出资比例
     *
     * @param subConProp 认缴出资比例
     */
    public void setSubConProp(BigDecimal subConProp) {
        this.subConProp = subConProp;
    }

    /**
     * 获取认缴出资额折万美元
     *
     * @return ForSubConAmUSD - 认缴出资额折万美元
     */
    public BigDecimal getForSubConAmUSD() {
        return forSubConAmUSD;
    }

    /**
     * 设置认缴出资额折万美元
     *
     * @param forSubConAmUSD 认缴出资额折万美元
     */
    public void setForSubConAmUSD(BigDecimal forSubConAmUSD) {
        this.forSubConAmUSD = forSubConAmUSD;
    }

    /**
     * 获取认缴出资额
     *
     * @return SubConAm - 认缴出资额
     */
    public BigDecimal getSubConAm() {
        return subConAm;
    }

    /**
     * 设置认缴出资额
     *
     * @param subConAm 认缴出资额
     */
    public void setSubConAm(BigDecimal subConAm) {
        this.subConAm = subConAm;
    }

    /**
     * 获取实缴出资额
     *
     * @return AcConAm - 实缴出资额
     */
    public BigDecimal getAcConAm() {
        return acConAm;
    }

    /**
     * 设置实缴出资额
     *
     * @param acConAm 实缴出资额
     */
    public void setAcConAm(BigDecimal acConAm) {
        this.acConAm = acConAm;
    }

    /**
     * 获取邮政编码
     *
     * @return PostalCode - 邮政编码
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * 设置邮政编码
     *
     * @param postalCode 邮政编码
     */
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    /**
     * 获取证件类型
     *
     * @return CerType - 证件类型
     */
    public String getCerType() {
        return cerType;
    }

    /**
     * 设置证件类型
     *
     * @param cerType 证件类型
     */
    public void setCerType(String cerType) {
        this.cerType = cerType;
    }

    /**
     * 获取证件号码
     *
     * @return CerNO - 证件号码
     */
    public String getCerNO() {
        return cerNO;
    }

    /**
     * 设置证件号码
     *
     * @param cerNO 证件号码
     */
    public void setCerNO(String cerNO) {
        this.cerNO = cerNO;
    }

    /**
     * 获取性别
     *
     * @return Sex - 性别
     */
    public String getSex() {
        return sex;
    }

    /**
     * 设置性别
     *
     * @param sex 性别
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * 获取联系电话
     *
     * @return Tel - 联系电话
     */
    public String getTel() {
        return tel;
    }

    /**
     * 设置联系电话
     *
     * @param tel 联系电话
     */
    public void setTel(String tel) {
        this.tel = tel;
    }

    /**
     * 获取出生日期
     *
     * @return NatDate - 出生日期
     */
    public Date getNatDate() {
        return natDate;
    }

    /**
     * 设置出生日期
     *
     * @param natDate 出生日期
     */
    public void setNatDate(Date natDate) {
        this.natDate = natDate;
    }

    /**
     * 获取文化程度
     *
     * @return LiteDeg - 文化程度
     */
    public String getLiteDeg() {
        return liteDeg;
    }

    /**
     * 设置文化程度
     *
     * @param liteDeg 文化程度
     */
    public void setLiteDeg(String liteDeg) {
        this.liteDeg = liteDeg;
    }

    /**
     * 获取政治面貌
     *
     * @return PolStand - 政治面貌
     */
    public String getPolStand() {
        return polStand;
    }

    /**
     * 设置政治面貌
     *
     * @param polStand 政治面貌
     */
    public void setPolStand(String polStand) {
        this.polStand = polStand;
    }

    /**
     * 获取民族
     *
     * @return Nation - 民族
     */
    public String getNation() {
        return nation;
    }

    /**
     * 设置民族
     *
     * @param nation 民族
     */
    public void setNation(String nation) {
        this.nation = nation;
    }

    /**
     * 获取职业状况
     *
     * @return OccSt - 职业状况
     */
    public String getOccSt() {
        return occSt;
    }

    /**
     * 设置职业状况
     *
     * @param occSt 职业状况
     */
    public void setOccSt(String occSt) {
        this.occSt = occSt;
    }

    /**
     * 获取执行合伙事务标志1、是2、否
     *
     * @return ExeAffSign - 执行合伙事务标志1、是2、否
     */
    public String getExeAffSign() {
        return exeAffSign;
    }

    /**
     * 设置执行合伙事务标志1、是2、否
     *
     * @param exeAffSign 执行合伙事务标志1、是2、否
     */
    public void setExeAffSign(String exeAffSign) {
        this.exeAffSign = exeAffSign;
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
     * 获取认缴出资方式
     *
     * @return SubConForm - 认缴出资方式
     */
    public String getSubConForm() {
        return subConForm;
    }

    /**
     * 设置认缴出资方式
     *
     * @param subConForm 认缴出资方式
     */
    public void setSubConForm(String subConForm) {
        this.subConForm = subConForm;
    }

    /**
     * 获取认缴出资日期
     *
     * @return SubConDate - 认缴出资日期
     */
    public Date getSubConDate() {
        return subConDate;
    }

    /**
     * 设置认缴出资日期
     *
     * @param subConDate 认缴出资日期
     */
    public void setSubConDate(Date subConDate) {
        this.subConDate = subConDate;
    }
}