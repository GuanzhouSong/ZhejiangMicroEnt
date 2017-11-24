/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.sment.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.icinfo.cs.common.utils.AESEUtil;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.framework.mybatis.mapper.annotation.Before;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

/**
 * 描述:    sm_baseinfo 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年05月04日
 */
@Table(name = "sm_baseinfo")
public class SmBaseinfo implements Serializable {
	
	/**
     * UID
     */
    @Column(name = "UID")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    private String UID;
    
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
     * 统一社会信用代码(CA91)
     */
    @Column(name = "UniCode")
    private String uniCode;

    /**
     * 经营(驻在)期限自
     */
    @Column(name = "OpFrom")
    private Date opFrom;

    /**
     * 经营(驻在)期限至
     */
    @Column(name = "OpTo")
    private Date opTo;

    /**
     * 币种(CA04)
     */
    @Column(name = "Currency")
    private String currency;

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
    private Date apprDate;

    /**
     * 变更注销日期
     */
    @Column(name = "AltDate")
    private Date altDate;

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
     * 登记机关名称
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
     * 列入小微原因
     */
    @Column(name = "SmentReason")
    private String smentReason;

    /**
     * 是否是小微 1：是  0：不是
     */
    @Column(name = "IsSment")
    private String isSment;

    /**
     * 移除小微原因
     */
    @Column(name = "SmentRemReason")
    private String smentRemReason;

    /**
     * 核准日期
     */
    @Column(name = "SmentRemTime")
    private Date smentRemTime;
    
    /**
     * 经营方式
     */
    @Column(name = "OpForm")
    private String opForm;

    /**
     * 经营范围
     */
    @Column(name = "OpScope")
    private String opScope;
    
    /**
     * 邮编
     */
    @Column(name = "PostalCode")
    private String postalCode;
    
    /**
     * 身份证号
     */
    @Column(name = "CerNO")
    private String cerNO;
    
    /**
     * 从业人数
     */
    @Column(name = "EmpNum")
    private String empNum;
    
    
    private static final long serialVersionUID = 1L;


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
     * 获取登记机关名称
     *
     * @return RegOrgName - 登记机关名称
     */
    public String getRegOrgName() {
        return regOrgName;
    }

    /**
     * 设置登记机关名称
     *
     * @param regOrgName 登记机关名称
     */
    public void setRegOrgName(String regOrgName) {
        this.regOrgName = regOrgName;
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
     * 获取属地监管工商所名称
     *
     * @return LocalAdmName - 属地监管工商所名称
     */
    public String getLocalAdmName() {
        return localAdmName;
    }

    /**
     * 设置属地监管工商所名称
     *
     * @param localAdmName 属地监管工商所名称
     */
    public void setLocalAdmName(String localAdmName) {
        this.localAdmName = localAdmName;
    }

    /**
     * 获取责任区商圈
     *
     * @return SliceNO - 责任区商圈
     */
    public String getSliceNO() {
        return sliceNO;
    }

    /**
     * 设置责任区商圈
     *
     * @param sliceNO 责任区商圈
     */
    public void setSliceNO(String sliceNO) {
        this.sliceNO = sliceNO;
    }

    /**
     * 获取责任区商圈名称
     *
     * @return SliceNOName - 责任区商圈名称
     */
    public String getSliceNOName() {
        return sliceNOName;
    }

    /**
     * 设置责任区商圈名称
     *
     * @param sliceNOName 责任区商圈名称
     */
    public void setSliceNOName(String sliceNOName) {
        this.sliceNOName = sliceNOName;
    }

    /**
     * 获取列入小微原因
     *
     * @return SmentReason - 列入小微原因
     */
    public String getSmentReason() {
        return smentReason;
    }

    /**
     * 设置列入小微原因
     *
     * @param smentReason 列入小微原因
     */
    public void setSmentReason(String smentReason) {
        this.smentReason = smentReason;
    }

    /**
     * 获取是否是小微 1：是  0：不是
     *
     * @return IsSment - 是否是小微 1：是  0：不是
     */
    public String getIsSment() {
        return isSment;
    }

    /**
     * 设置是否是小微 1：是  0：不是
     *
     * @param isSment 是否是小微 1：是  0：不是
     */
    public void setIsSment(String isSment) {
        this.isSment = isSment;
    }

    /**
     * 获取移除小微原因
     *
     * @return SmentRemReason - 移除小微原因
     */
    public String getSmentRemReason() {
        return smentRemReason;
    }

    /**
     * 设置移除小微原因
     *
     * @param smentRemReason 移除小微原因
     */
    public void setSmentRemReason(String smentRemReason) {
        this.smentRemReason = smentRemReason;
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

    
    public Date getSmentRemTime() {
		return smentRemTime;
	}

	public void setSmentRemTime(Date smentRemTime) {
		this.smentRemTime = smentRemTime;
	}

	public String getCerNO() {
		return cerNO;
	}

	public void setCerNO(String cerNO) {
		this.cerNO = cerNO;
	}

	public String getEmpNum() {
		return empNum;
	}

	public void setEmpNum(String empNum) {
		this.empNum = empNum;
	}

	public String getPostalCode(){
        return postalCode;
    }

    public void setPostalCode(String postalCode){
        this.postalCode = postalCode;
    }
    
    public String getPriPIDDesc() {
        if(StringUtil.isNotBlank (this.priPID)){
            return AESEUtil.encodeCorpid(this.priPID);
        }
        return "";
 }
        
}