/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.ext.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.icinfo.cs.common.utils.AESEUtil;
import com.icinfo.cs.common.utils.StringUtil;

/**
 * 描述:    cs_mid_baseinfo 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2016年08月29日
 */
@Table(name = "cs_mid_baseinfo")
public class MidBaseInfo implements Serializable {
    @Id
    @Column(name = "id")
    private Integer id;

    /**
     * 主体身份代码(CA14)
     */
    @Column(name = "PriPID")
    private String priPID;

    /**
     * 企业(机构)名称
     */
    @Column(name = "EntName")
    private String entName;

    /**
     * 注册号(CA15)
     */
    @Column(name = "RegNO")
    private String regNO;

    /**
     * 住所
     */
    @Column(name = "Dom")
    private String dom;

    /**
     * 住所所在行政区划(CA01)
     */
    @Column(name = "DomDistrict")
    private String domDistrict;

    /**
     * 法定代表人
     */
    @Column(name = "LeRep")
    private String leRep;

    /**
     * 注册资本(金)
     */
    @Column(name = "RegCap")
    private BigDecimal regCap;

    /**
     * 市场主体类型(CA16)
     */
    @Column(name = "EntType")
    private String entType;
    
    /**
     * 成立日期
     */
    @Column(name = "EstDate")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date estDate;

    /**
     * 行业代码(CA06)
     */
    @Column(name = "IndustryCo")
    private String industryCo;

    /**
     * 登记机关(CA11)
     */
    @Column(name = "RegOrg")
    private String regOrg;
    /**
     * 登记机关名称(CA11)
     */
    @Column(name = "RegOrgName")
    private String regOrgName;
    /**
     * 属地监管工商所
     */
    @Column(name = "LocalAdm")
    private String localAdm;
    /**
     * 属地监管工商所名称
     */
    @Column(name = "LocalAdmName")
    private String localAdmName;
    /**
     * 行业门类(CA05)
     */
    @Column(name = "IndustryPhy")
    private String industryPhy;

    /**
     * 登记状态(CA19)
     */
    @Column(name = "RegState")
    private String regState;

    /**
     * 注册资本(金)折万美元
     */
    @Column(name = "RegCapUSD")
    private BigDecimal regCapUSD;

    /**
     * 实收资本折万美元
     */
    @Column(name = "RecCapUSD")
    private BigDecimal recCapUSD;

    /**
     * 实收资本
     */
    @Column(name = "RecCapRMB")
    private BigDecimal recCapRMB;

    /**
     * 统一社会信用代码(CA91)
     */
    @Column(name = "UniCode")
    private String uniCode;

    /**
     * 邮政编码
     */
    @Column(name = "PostalCode")
    private String postalCode;

    /**
     * 经营(驻在)期限自
     */
    @Column(name = "OpFrom")
    private Date opFrom;

    /**
     * 经营(驻在)期限至
     */
    @Column(name = "OpTo")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date opTo;

    /**
     * 从业人员/农专成员总数
     */
    @Column(name = "EmpNum")
    private Integer empNum;

    /**
     * 国别(地区)(CA02)
     */
    @Column(name = "Country")
    private String country;

    /**
     * 币种(CA04)
     */
    @Column(name = "Currency")
    private String currency;

    /**
     * 是否城镇
     */
    @Column(name = "Town")
    private Boolean town;

    /**
     * 乡镇街道
     */
    @Column(name = "Street")
    private String street;

    /**
     * 身份证件号码
     */
    @Column(name = "CerNO")
    private String cerNO;

    /**
     * 联系电话
     */
    @Column(name = "Tel")
    private String tel;

    /**
     * 电子邮箱
     */
    @Column(name = "Email")
    private String email;

    /**
     * 核准日期
     */
    @Column(name = "ApprDate")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date apprDate;

    /**
     * 变更注销日期
     */
    @Column(name = "AltDate")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date altDate;

    /**
     * 时间戳
     */
    @Column(name = "CreateTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;
    
    /**
     * 时间戳
     */
    @Column(name = "update_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date updateTime;

    /**
     * UID
     */
    @Column(name = "UID")
    private String UID;

    /**
     * 是否个转企
     */
    @Column(name = "IsIndivid")
    private String isIndivid;
    /**
     * 个转企日期
     */
    @Column(name = "IndividDate")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date individDate;

    /**
     * 导入时间
     */
    @Column(name = "ImpDate")
    private Date impDate;

    /**
     * 抽检部门
     */
    @Column(name = "CheckDep")
    private String checkDep;

    /**
     * 生产经营地所在行政区划
     */
    @Column(name = "Yiedistrict")
    private String yiedistrict;

    /**
     * 币种（中文名称）
     */
    @Column(name = "CurrencyCn")
    private String currencyCn;

    /**
     * 市场主体类型大类
     */
    @Column(name = "EntTypeCatg")
    private String entTypeCatg;

    /**
     * 生产经营地
     */
    @Column(name = "ProLoc")
    private String proLoc;

    /**
     * 经营方式
     */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @Column(name = "OpForm")
    private String opForm;

    /**
     * 经营范围
     */
    @Column(name = "OpScope")
    private String opScope;




    /**
     * 委托机关
     */
    @Column(name = "DelegateOrg")
    private String delegateOrg;
    
    /**
     * 委托机关名称
     */
    @Column(name = "DelegateOrgName")
    private String delegateOrgName;


    /**
     * 地区
     */
    @Column(name = "Area")
    private String area;
    
    /**
     * 责任区商圈
     */
    @Column(name = "SliceNO")
    private String sliceNO;
    
    /**
     * 责任区商圈名称
     */
    @Column(name = "SliceNOName")
    private String sliceNOName;
    
    /**
     * 抽检部门名称
     */
    @Column(name = "CheckDepName")
    private String checkDepName;
    
    /**
     * 个体户组成形式名称
     */
    @Column(name = "CompFormName")
    private String compFormName; 

	/**
     * 个体户组成形式
     */
    @Column(name = "CompForm")
    private String compForm;

    private static final long serialVersionUID = 1L;

    /**
     * 后置审批事项编码
     */
    @Column(name = "HzApprCode")
    private String hzApprCode;
    
    /**
     * 后置审批事项名称名称
     */
    @Column(name = "HzApprName")
    private String hzApprName; 
    
     
    
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
     * 获取主体身份代码(CA14)
     *
     * @return PriPID - 主体身份代码(CA14)
     */
    public String getPriPID() {
        return priPID;
    }

    /**
     * 设置主体身份代码(CA14)
     *
     * @param priPID 主体身份代码(CA14)
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
     * 获取注册号(CA15)
     *
     * @return RegNO - 注册号(CA15)
     */
    public String getRegNO() {
        return regNO;
    }

    /**
     * 设置注册号(CA15)
     *
     * @param regNO 注册号(CA15)
     */
    public void setRegNO(String regNO) {
        this.regNO = regNO;
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
     * 获取住所所在行政区划(CA01)
     *
     * @return DomDistrict - 住所所在行政区划(CA01)
     */
    public String getDomDistrict() {
        return domDistrict;
    }

    /**
     * 设置住所所在行政区划(CA01)
     *
     * @param domDistrict 住所所在行政区划(CA01)
     */
    public void setDomDistrict(String domDistrict) {
        this.domDistrict = domDistrict;
    }

    /**
     * 获取法定代表人
     *
     * @return LeRep - 法定代表人
     */
    public String getLeRep() {
        return leRep;
    }

    /**
     * 设置法定代表人
     *
     * @param leRep 法定代表人
     */
    public void setLeRep(String leRep) {
        this.leRep = leRep;
    }

    /**
     * 获取注册资本(金)
     *
     * @return RegCap - 注册资本(金)
     */
    public BigDecimal getRegCap() {
        return regCap;
    }

    /**
     * 设置注册资本(金)
     *
     * @param regCap 注册资本(金)
     */
    public void setRegCap(BigDecimal regCap) {
        this.regCap = regCap;
    }

    /**
     * 获取市场主体类型(CA16)
     *
     * @return EntType - 市场主体类型(CA16)
     */
    public String getEntType() {
        return entType;
    }

    /**
     * 设置市场主体类型(CA16)
     *
     * @param entType 市场主体类型(CA16)
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
     * 获取行业代码(CA06)
     *
     * @return IndustryCo - 行业代码(CA06)
     */
    public String getIndustryCo() {
        return industryCo;
    }

    /**
     * 设置行业代码(CA06)
     *
     * @param industryCo 行业代码(CA06)
     */
    public void setIndustryCo(String industryCo) {
        this.industryCo = industryCo;
    }

    /**
     * 获取登记机关(CA11)
     *
     * @return RegOrg - 登记机关(CA11)
     */
    public String getRegOrg() {
        return regOrg;
    }

    /**
     * 设置登记机关(CA11)
     *
     * @param regOrg 登记机关(CA11)
     */
    public void setRegOrg(String regOrg) {
        this.regOrg = regOrg;
    }

    /**
     * 获取属地监管工商所
     *
     * @return LocalAdm - 属地监管工商所
     */
    public String getLocalAdm() {
        return localAdm;
    }

    /**
     * 设置属地监管工商所
     *
     * @param localAdm 属地监管工商所
     */
    public void setLocalAdm(String localAdm) {
        this.localAdm = localAdm;
    }

    /**
     * 获取行业门类(CA05)
     *
     * @return IndustryPhy - 行业门类(CA05)
     */
    public String getIndustryPhy() {
        return industryPhy;
    }

    /**
     * 设置行业门类(CA05)
     *
     * @param industryPhy 行业门类(CA05)
     */
    public void setIndustryPhy(String industryPhy) {
        this.industryPhy = industryPhy;
    }

    /**
     * 获取登记状态(CA19)
     *
     * @return RegState - 登记状态(CA19)
     */
    public String getRegState() {
        return regState;
    }

    /**
     * 设置登记状态(CA19)
     *
     * @param regState 登记状态(CA19)
     */
    public void setRegState(String regState) {
        this.regState = regState;
    }

    /**
     * 获取注册资本(金)折万美元
     *
     * @return RegCapUSD - 注册资本(金)折万美元
     */
    public BigDecimal getRegCapUSD() {
        return regCapUSD;
    }

    /**
     * 设置注册资本(金)折万美元
     *
     * @param regCapUSD 注册资本(金)折万美元
     */
    public void setRegCapUSD(BigDecimal regCapUSD) {
        this.regCapUSD = regCapUSD;
    }

    /**
     * 获取实收资本折万美元
     *
     * @return RecCapUSD - 实收资本折万美元
     */
    public BigDecimal getRecCapUSD() {
        return recCapUSD;
    }

    /**
     * 设置实收资本折万美元
     *
     * @param recCapUSD 实收资本折万美元
     */
    public void setRecCapUSD(BigDecimal recCapUSD) {
        this.recCapUSD = recCapUSD;
    }

    /**
     * 获取实收资本
     *
     * @return RecCapRMB - 实收资本
     */
    public BigDecimal getRecCapRMB() {
        return recCapRMB;
    }

    /**
     * 设置实收资本
     *
     * @param recCapRMB 实收资本
     */
    public void setRecCapRMB(BigDecimal recCapRMB) {
        this.recCapRMB = recCapRMB;
    }

    /**
     * 获取统一社会信用代码(CA91)
     *
     * @return UniCode - 统一社会信用代码(CA91)
     */
    public String getUniCode() {
        return uniCode;
    }

    /**
     * 设置统一社会信用代码(CA91)
     *
     * @param uniCode 统一社会信用代码(CA91)
     */
    public void setUniCode(String uniCode) {
        this.uniCode = uniCode;
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
     * 获取经营(驻在)期限自
     *
     * @return OpFrom - 经营(驻在)期限自
     */
    public Date getOpFrom() {
        return opFrom;
    }

    /**
     * 设置经营(驻在)期限自
     *
     * @param opFrom 经营(驻在)期限自
     */
    public void setOpFrom(Date opFrom) {
        this.opFrom = opFrom;
    }

    /**
     * 获取经营(驻在)期限至
     *
     * @return OpTo - 经营(驻在)期限至
     */
    public Date getOpTo() {
        return opTo;
    }

    /**
     * 设置经营(驻在)期限至
     *
     * @param opTo 经营(驻在)期限至
     */
    public void setOpTo(Date opTo) {
        this.opTo = opTo;
    }

    /**
     * 获取从业人员/农专成员总数
     *
     * @return EmpNum - 从业人员/农专成员总数
     */
    public Integer getEmpNum() {
        return empNum;
    }

    /**
     * 设置从业人员/农专成员总数
     *
     * @param empNum 从业人员/农专成员总数
     */
    public void setEmpNum(Integer empNum) {
        this.empNum = empNum;
    }

    public String getRegOrgName() {
        return regOrgName;
    }

    public void setRegOrgName(String regOrgName) {
        this.regOrgName = regOrgName;
    }

    public String getLocalAdmName() {

        return localAdmName;
    }

    public void setLocalAdmName(String localAdmName) {
        this.localAdmName = localAdmName;
    }

    /**
     * 获取国别(地区)(CA02)
     *
     * @return Country - 国别(地区)(CA02)
     */
    public String getCountry() {
        return country;
    }

    /**
     * 设置国别(地区)(CA02)
     *
     * @param country 国别(地区)(CA02)
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * 获取币种(CA04)
     *
     * @return Currency - 币种(CA04)
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * 设置币种(CA04)
     *
     * @param currency 币种(CA04)
     */
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    /**
     * 获取是否城镇
     *
     * @return Town - 是否城镇
     */
    public Boolean getTown() {
        return town;
    }

    /**
     * 设置是否城镇
     *
     * @param town 是否城镇
     */
    public void setTown(Boolean town) {
        this.town = town;
    }

    /**
     * 获取乡镇街道
     *
     * @return Street - 乡镇街道
     */
    public String getStreet() {
        return street;
    }

    /**
     * 设置乡镇街道
     *
     * @param street 乡镇街道
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * 获取身份证件号码
     *
     * @return CerNO - 身份证件号码
     */
    public String getCerNO() {
        return cerNO;
    }

    /**
     * 设置身份证件号码
     *
     * @param cerNO 身份证件号码
     */
    public void setCerNO(String cerNO) {
        this.cerNO = cerNO;
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
     * 获取电子邮箱
     *
     * @return Email - 电子邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置电子邮箱
     *
     * @param email 电子邮箱
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取核准日期
     *
     * @return ApprDate - 核准日期
     */
    public Date getApprDate() {
        return apprDate;
    }

    /**
     * 设置核准日期
     *
     * @param apprDate 核准日期
     */
    public void setApprDate(Date apprDate) {
        this.apprDate = apprDate;
    }

    /**
     * 获取变更注销日期
     *
     * @return AltDate - 变更注销日期
     */
    public Date getAltDate() {
        return altDate;
    }

    /**
     * 设置变更注销日期
     *
     * @param altDate 变更注销日期
     */
    public void setAltDate(Date altDate) {
        this.altDate = altDate;
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
     * 获取UID
     *
     * @return UID - UID
     */
    public String getUID() {
        return UID;
    }

    /**
     * 设置UID
     *
     * @param UID UID
     */
    public void setUID(String UID) {
        this.UID = UID;
    }

    /**
     * 获取是否个转企
     *
     * @return IsIndivid - 是否个转企
     */
    public String getIsIndivid() {
        return isIndivid;
    }

    /**
     * 设置是否个转企
     *
     * @param isIndivid 是否个转企
     */
    public void setIsIndivid(String isIndivid) {
        this.isIndivid = isIndivid;
    }

    /**
     * 获取导入时间
     *
     * @return ImpDate - 导入时间
     */
    public Date getImpDate() {
        return impDate;
    }

    /**
     * 设置导入时间
     *
     * @param impDate 导入时间
     */
    public void setImpDate(Date impDate) {
        this.impDate = impDate;
    }

    /**
     * 获取抽检部门
     *
     * @return CheckDep - 抽检部门
     */
    public String getCheckDep() {
        return checkDep;
    }

    /**
     * 设置抽检部门
     *
     * @param checkDep 抽检部门
     */
    public void setCheckDep(String checkDep) {
        this.checkDep = checkDep;
    }

    /**
     * 获取生产经营地所在行政区划
     *
     * @return Yiedistrict - 生产经营地所在行政区划
     */
    public String getYiedistrict() {
        return yiedistrict;
    }

    /**
     * 设置生产经营地所在行政区划
     *
     * @param yiedistrict 生产经营地所在行政区划
     */
    public void setYiedistrict(String yiedistrict) {
        this.yiedistrict = yiedistrict;
    }

    /**
     * 获取币种（中文名称）
     *
     * @return CurrencyCn - 币种（中文名称）
     */
    public String getCurrencyCn() {
        return currencyCn;
    }
    

    /**
     * 设置币种（中文名称）
     *
     * @param currencyCn 币种（中文名称）
     */
    public void setCurrencyCn(String currencyCn) {
        this.currencyCn = currencyCn;
    }

    /**
     * 获取市场主体类型大类
     *
     * @return EntTypeCatg - 市场主体类型大类
     */
    public String getEntTypeCatg() {
        return entTypeCatg;
    }

    /**
     * 设置市场主体类型大类
     *
     * @param entTypeCatg 市场主体类型大类
     */
    public void setEntTypeCatg(String entTypeCatg) {
        this.entTypeCatg = entTypeCatg;
    }


    /**
     * 获取生产经营地
     *
     * @return ProLoc - 生产经营地
     */
    public String getProLoc() {
        return proLoc;
    }

    /**
     * 设置生产经营地
     *
     * @param proLoc 生产经营地
     */
    public void setProLoc(String proLoc) {
        this.proLoc = proLoc;
    }

    /**
     * 获取经营方式
     *
     * @return OpForm - 经营方式
     */
    public String getOpForm() {
        return opForm;
    }

    /**
     * 设置经营方式
     *
     * @param opForm 经营方式
     */
    public void setOpForm(String opForm) {
        this.opForm = opForm;
    }

    /**
     * 获取经营范围
     *
     * @return OpScope - 经营范围
     */
    public String getOpScope() {
        return opScope;
    }

    /**
     * 设置经营范围
     *
     * @param opScope 经营范围
     */
    public void setOpScope(String opScope) {
        this.opScope = opScope;
    }
    /**
     * 获取个转企日期
     *
     * @return individDate - 个转企日期
     */
    public Date getIndividDate() {
        return individDate;
    }

    /**
     * 设置个转企日期
     *
     * @param individDate 个转企日期
     */
    public void setIndividDate(Date individDate) {
        this.individDate = individDate;
    }


    public String getDelegateOrg() {
        return delegateOrg;
    }

    public void setDelegateOrg(String delegateOrg) {
        this.delegateOrg = delegateOrg;
    }

	public String getDelegateOrgName() {
		return delegateOrgName;
	}

	public void setDelegateOrgName(String delegateOrgName) {
		this.delegateOrgName = delegateOrgName;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getSliceNO() {
		return sliceNO;
	}

	public void setSliceNO(String sliceNO) {
		this.sliceNO = sliceNO;
	}

	public String getSliceNOName() {
		return sliceNOName;
	}

	public void setSliceNOName(String sliceNOName) {
		this.sliceNOName = sliceNOName;
	}

	public String getCheckDepName() {
		return checkDepName;
	}

	public void setCheckDepName(String checkDepName) {
		this.checkDepName = checkDepName;
	}

	public String getCompFormName() {
		return compFormName;
	}

	public void setCompFormName(String compFormName) {
		this.compFormName = compFormName;
	}

	public String getCompForm() {
		return compForm;
	}

	public void setCompForm(String compForm) {
		this.compForm = compForm;
	}
	
	public String getHzApprCode() {
		return hzApprCode;
	}

	public void setHzApprCode(String hzApprCode) {
		this.hzApprCode = hzApprCode;
	}

	public String getHzApprName() {
		return hzApprName;
	}

	public void setHzApprName(String hzApprName) {
		this.hzApprName = hzApprName;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
	public String getPriPIDDesc() {
		if(StringUtil.isNotBlank(this.priPID)){
			return AESEUtil.encodeCorpid(this.priPID);
		}
		return "";
	}
}