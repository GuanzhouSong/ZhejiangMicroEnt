/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.es.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import com.icinfo.cs.common.utils.AESEUtil;

/**
 * 描述:    sm_ent_search 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年05月03日
 */
@Table(name = "sm_ent_search")
public class SmEntSearch implements Serializable {
    @Id
    @Column(name = "id")
    private Long id;

    /**
     * 内部序号
     */
    @Column(name = "PriPID")
    private String priPID;

    /**
     * 注册号
     */
    @Column(name = "RegNO")
    private String regNO;

    /**
     * 同一代码
     */
    @Column(name = "UniCode")
    private String uniCode;

    /**
     * 企业名称不分词
     */
    @Column(name = "EntName")
    private String entName;

    /**
     * 法人
     */
    @Column(name = "LeRep")
    private String leRep;

    /**
     * 小类
     */
    @Column(name = "EntType")
    private String entType;

    /**
     * 企业名称(分词)
     */
    @Column(name = "EntNamePPL")
    private String entNamePPL;

    /**
     * 小类名称
     */
    @Column(name = "EntTypeName")
    private String entTypeName;

    /**
     * 登记机关
     */
    @Column(name = "RegOrg")
    private String regOrg;

    /**
     * 登记机关名称
     */
    @Column(name = "RegOrgName")
    private String regOrgName;

    /**
     * 企业大类
     */
    @Column(name = "EntTypeCatg")
    private String entTypeCatg;

    /**
     * 企业大类名称
     */
    @Column(name = "EntTypeCatgName")
    private String entTypeCatgName;

    /**
     * 管辖单位
     */
    @Column(name = "LocalAdm")
    private String localAdm;

    /**
     * 管辖单位名称
     */
    @Column(name = "LocalAdmName")
    private String localAdmName;

    /**
     * 登记状态
     */
    @Column(name = "RegState")
    private String regState;

    /**
     * 成立日期
     */
    @Column(name = "EstDate")
    private Date estDate;

    /**
     * 行业类型
     */
    @Column(name = "IndustryCo")
    private String industryCo;

    /**
     * 行业类型名称
     */
    @Column(name = "IndustryCoName")
    private String industryCoName;

    /**
     * 住所
     */
    @Column(name = "Dom")
    private String dom;

    /**
     * 产业类型
     */
    @Column(name = "IndustryType")
    private String industryType;

    /**
     * 产业类型名称
     */
    @Column(name = "IndustryName")
    private String industryName;

    /**
     * 注册资本
     */
    @Column(name = "RegCap")
    private BigDecimal regCap;

    /**
     * 注册资本美元
     */
    @Column(name = "RegCapUSD")
    private BigDecimal regCapUSD;

    /**
     * 培育类型
     */
    @Column(name = "CultivationTypeCode")
    private String cultivationTypeCode;

    /**
     * 培育类型名称
     */
    @Column(name = "CultivationTypeName")
    private String cultivationTypeName;

    /**
     * 帮扶状态 1：无需求 2：未帮扶 3：部分帮扶 4：已帮扶
     */
    @Column(name = "HelpState")
    private String helpState;

    /**
     * 帮扶类型code
     */
    @Column(name = "HelpTypeCode")
    private String helpTypeCode;

    /**
     * 帮扶类型名称
     */
    @Column(name = "HelpTypeName")
    private String helpTypeName;
    
    /**
     * 企业需求类别
     */
    @Column(name = "DemandType")
    private String demandType;
    
    /**
     * 企业需求类别
     */
    @Column(name = "DemandTypeName")
    private String demandTypeName;

    /**
     * 片区
     */
    @Column(name = "SliceNO")
    private String sliceNO;

    /**
     * 片区名称
     */
    @Column(name = "SliceNOName")
    private String sliceNOName;

    /**
     * 从业人数
     */
    @Column(name = "EmpNum2013")
    private Integer empNum2013;

    @Column(name = "EmpNum2014")
    private Integer empNum2014;

    @Column(name = "EmpNum2015")
    private Integer empNum2015;

    @Column(name = "EmpNum2016")
    private Integer empNum2016;

    @Column(name = "EmpNum2017")
    private Integer empNum2017;

    @Column(name = "EmpNum2018")
    private Integer empNum2018;

    @Column(name = "EmpNum2019")
    private Integer empNum2019;

    @Column(name = "EmpNum2020")
    private Integer empNum2020;

    @Column(name = "EmpNum2021")
    private Integer empNum2021;

    @Column(name = "EmpNum2022")
    private Integer empNum2022;

    /**
     * 营业总收入
     */
    @Column(name = "VendInc2013")
    private BigDecimal vendInc2013;

    @Column(name = "VendInc2014")
    private BigDecimal vendInc2014;

    @Column(name = "VendInc2015")
    private BigDecimal vendInc2015;

    @Column(name = "VendInc2016")
    private BigDecimal vendInc2016;

    @Column(name = "VendInc2017")
    private BigDecimal vendInc2017;

    @Column(name = "VendInc2018")
    private BigDecimal vendInc2018;

    @Column(name = "VendInc2019")
    private BigDecimal vendInc2019;

    @Column(name = "VendInc2020")
    private BigDecimal vendInc2020;

    @Column(name = "VendInc2021")
    private BigDecimal vendInc2021;

    @Column(name = "VendInc2022")
    private BigDecimal vendInc2022;

    /**
     * 经营范围
     */
    @Column(name = "OpScope")
    private String opScope;

    private static final long serialVersionUID = 1L;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取内部序号
     *
     * @return PriPID - 内部序号
     */
    public String getPriPID() {
        return priPID;
    }

    /**
     * 设置内部序号
     *
     * @param priPID 内部序号
     */
    public void setPriPID(String priPID) {
        this.priPID = priPID;
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
     * 获取同一代码
     *
     * @return UniCode - 同一代码
     */
    public String getUniCode() {
        return uniCode;
    }

    /**
     * 设置同一代码
     *
     * @param uniCode 同一代码
     */
    public void setUniCode(String uniCode) {
        this.uniCode = uniCode;
    }

    /**
     * 获取企业名称不分词
     *
     * @return EntName - 企业名称不分词
     */
    public String getEntName() {
        return entName;
    }

    /**
     * 设置企业名称不分词
     *
     * @param entName 企业名称不分词
     */
    public void setEntName(String entName) {
        this.entName = entName;
    }

    /**
     * 获取法人
     *
     * @return LeRep - 法人
     */
    public String getLeRep() {
        return leRep;
    }

    /**
     * 设置法人
     *
     * @param leRep 法人
     */
    public void setLeRep(String leRep) {
        this.leRep = leRep;
    }

    /**
     * 获取小类
     *
     * @return EntType - 小类
     */
    public String getEntType() {
        return entType;
    }

    /**
     * 设置小类
     *
     * @param entType 小类
     */
    public void setEntType(String entType) {
        this.entType = entType;
    }

    /**
     * 获取小类名称
     *
     * @return EntTypeName - 小类名称
     */
    public String getEntTypeName() {
        return entTypeName;
    }

    /**
     * 设置小类名称
     *
     * @param entTypeName 小类名称
     */
    public void setEntTypeName(String entTypeName) {
        this.entTypeName = entTypeName;
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
     * 获取企业大类
     *
     * @return EntTypeCatg - 企业大类
     */
    public String getEntTypeCatg() {
        return entTypeCatg;
    }

    /**
     * 设置企业大类
     *
     * @param entTypeCatg 企业大类
     */
    public void setEntTypeCatg(String entTypeCatg) {
        this.entTypeCatg = entTypeCatg;
    }

    /**
     * 获取企业大类名称
     *
     * @return EntTypeCatgName - 企业大类名称
     */
    public String getEntTypeCatgName() {
        return entTypeCatgName;
    }

    /**
     * 设置企业大类名称
     *
     * @param entTypeCatgName 企业大类名称
     */
    public void setEntTypeCatgName(String entTypeCatgName) {
        this.entTypeCatgName = entTypeCatgName;
    }

    /**
     * 获取管辖单位
     *
     * @return LocalAdm - 管辖单位
     */
    public String getLocalAdm() {
        return localAdm;
    }

    /**
     * 设置管辖单位
     *
     * @param localAdm 管辖单位
     */
    public void setLocalAdm(String localAdm) {
        this.localAdm = localAdm;
    }

    /**
     * 获取管辖单位名称
     *
     * @return LocalAdmName - 管辖单位名称
     */
    public String getLocalAdmName() {
        return localAdmName;
    }

    /**
     * 设置管辖单位名称
     *
     * @param localAdmName 管辖单位名称
     */
    public void setLocalAdmName(String localAdmName) {
        this.localAdmName = localAdmName;
    }

    /**
     * 获取登记状态
     *
     * @return RegState - 登记状态
     */
    public String getRegState() {
        return regState;
    }

    /**
     * 设置登记状态
     *
     * @param regState 登记状态
     */
    public void setRegState(String regState) {
        this.regState = regState;
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
     * 获取行业类型
     *
     * @return IndustryCo - 行业类型
     */
    public String getIndustryCo() {
        return industryCo;
    }

    /**
     * 设置行业类型
     *
     * @param industryCo 行业类型
     */
    public void setIndustryCo(String industryCo) {
        this.industryCo = industryCo;
    }

    /**
     * 获取行业类型名称
     *
     * @return IndustryCoName - 行业类型名称
     */
    public String getIndustryCoName() {
        return industryCoName;
    }

    /**
     * 设置行业类型名称
     *
     * @param industryCoName 行业类型名称
     */
    public void setIndustryCoName(String industryCoName) {
        this.industryCoName = industryCoName;
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
     * 获取产业类型
     *
     * @return IndustryType - 产业类型
     */
    public String getIndustryType() {
        return industryType;
    }

    /**
     * 设置产业类型
     *
     * @param industryType 产业类型
     */
    public void setIndustryType(String industryType) {
        this.industryType = industryType;
    }

    /**
     * 获取产业类型名称
     *
     * @return IndustryName - 产业类型名称
     */
    public String getIndustryName() {
        return industryName;
    }

    /**
     * 设置产业类型名称
     *
     * @param industryName 产业类型名称
     */
    public void setIndustryName(String industryName) {
        this.industryName = industryName;
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
     * 获取注册资本美元
     *
     * @return RegCapUSD - 注册资本美元
     */
    public BigDecimal getRegCapUSD() {
        return regCapUSD;
    }

    /**
     * 设置注册资本美元
     *
     * @param regCapUSD 注册资本美元
     */
    public void setRegCapUSD(BigDecimal regCapUSD) {
        this.regCapUSD = regCapUSD;
    }

    /**
     * 获取培育类型
     *
     * @return CultivationTypeCode - 培育类型
     */
    public String getCultivationTypeCode() {
        return cultivationTypeCode;
    }

    /**
     * 设置培育类型
     *
     * @param cultivationTypeCode 培育类型
     */
    public void setCultivationTypeCode(String cultivationTypeCode) {
        this.cultivationTypeCode = cultivationTypeCode;
    }

    /**
     * 获取培育类型名称
     *
     * @return CultivationTypeName - 培育类型名称
     */
    public String getCultivationTypeName() {
        return cultivationTypeName;
    }

    /**
     * 设置培育类型名称
     *
     * @param cultivationTypeName 培育类型名称
     */
    public void setCultivationTypeName(String cultivationTypeName) {
        this.cultivationTypeName = cultivationTypeName;
    }

    /**
     * 获取帮扶状态 1：无需求 2：未帮扶 3：部分帮扶 4：已帮扶
     *
     * @return HelpState - 帮扶状态 1：无需求 2：未帮扶 3：部分帮扶 4：已帮扶
     */
    public String getHelpState() {
        return helpState;
    }

    /**
     * 设置帮扶状态 1：无需求 2：未帮扶 3：部分帮扶 4：已帮扶
     *
     * @param helpState 帮扶状态 1：无需求 2：未帮扶 3：部分帮扶 4：已帮扶
     */
    public void setHelpState(String helpState) {
        this.helpState = helpState;
    }

    /**
     * 获取企业需求类别
     *
     * @return DemandType - 企业需求类别
     */
    public String getDemandType() {
        return demandType;
    }

    /**
     * 设置企业需求类别
     *
     * @param demandType 企业需求类别
     */
    public void setDemandType(String demandType) {
        this.demandType = demandType;
    }

    /**
     * 获取片区
     *
     * @return SliceNO - 片区
     */
    public String getSliceNO() {
        return sliceNO;
    }

    /**
     * 设置片区
     *
     * @param sliceNO 片区
     */
    public void setSliceNO(String sliceNO) {
        this.sliceNO = sliceNO;
    }

    /**
     * 获取片区名称
     *
     * @return SliceNOName - 片区名称
     */
    public String getSliceNOName() {
        return sliceNOName;
    }

    /**
     * 设置片区名称
     *
     * @param sliceNOName 片区名称
     */
    public void setSliceNOName(String sliceNOName) {
        this.sliceNOName = sliceNOName;
    }

    /**
     * 获取从业人数
     *
     * @return EmpNum2013 - 从业人数
     */
    public Integer getEmpNum2013() {
        return empNum2013;
    }

    /**
     * 设置从业人数
     *
     * @param empNum2013 从业人数
     */
    public void setEmpNum2013(Integer empNum2013) {
        this.empNum2013 = empNum2013;
    }

    /**
     * @return EmpNum2014
     */
    public Integer getEmpNum2014() {
        return empNum2014;
    }

    /**
     * @param empNum2014
     */
    public void setEmpNum2014(Integer empNum2014) {
        this.empNum2014 = empNum2014;
    }

    /**
     * @return EmpNum2015
     */
    public Integer getEmpNum2015() {
        return empNum2015;
    }

    /**
     * @param empNum2015
     */
    public void setEmpNum2015(Integer empNum2015) {
        this.empNum2015 = empNum2015;
    }

    /**
     * @return EmpNum2016
     */
    public Integer getEmpNum2016() {
        return empNum2016;
    }

    /**
     * @param empNum2016
     */
    public void setEmpNum2016(Integer empNum2016) {
        this.empNum2016 = empNum2016;
    }

    /**
     * @return EmpNum2017
     */
    public Integer getEmpNum2017() {
        return empNum2017;
    }

    /**
     * @param empNum2017
     */
    public void setEmpNum2017(Integer empNum2017) {
        this.empNum2017 = empNum2017;
    }

    /**
     * @return EmpNum2018
     */
    public Integer getEmpNum2018() {
        return empNum2018;
    }

    /**
     * @param empNum2018
     */
    public void setEmpNum2018(Integer empNum2018) {
        this.empNum2018 = empNum2018;
    }

    /**
     * @return EmpNum2019
     */
    public Integer getEmpNum2019() {
        return empNum2019;
    }

    /**
     * @param empNum2019
     */
    public void setEmpNum2019(Integer empNum2019) {
        this.empNum2019 = empNum2019;
    }

    /**
     * @return EmpNum2020
     */
    public Integer getEmpNum2020() {
        return empNum2020;
    }

    /**
     * @param empNum2020
     */
    public void setEmpNum2020(Integer empNum2020) {
        this.empNum2020 = empNum2020;
    }

    /**
     * @return EmpNum2021
     */
    public Integer getEmpNum2021() {
        return empNum2021;
    }

    /**
     * @param empNum2021
     */
    public void setEmpNum2021(Integer empNum2021) {
        this.empNum2021 = empNum2021;
    }

    /**
     * @return EmpNum2022
     */
    public Integer getEmpNum2022() {
        return empNum2022;
    }

    /**
     * @param empNum2022
     */
    public void setEmpNum2022(Integer empNum2022) {
        this.empNum2022 = empNum2022;
    }

    /**
     * 获取营业总收入
     *
     * @return VendInc2013 - 营业总收入
     */
    public BigDecimal getVendInc2013() {
        return vendInc2013;
    }

    /**
     * 设置营业总收入
     *
     * @param vendInc2013 营业总收入
     */
    public void setVendInc2013(BigDecimal vendInc2013) {
        this.vendInc2013 = vendInc2013;
    }

    /**
     * @return VendInc2014
     */
    public BigDecimal getVendInc2014() {
        return vendInc2014;
    }

    /**
     * @param vendInc2014
     */
    public void setVendInc2014(BigDecimal vendInc2014) {
        this.vendInc2014 = vendInc2014;
    }

    /**
     * @return VendInc2015
     */
    public BigDecimal getVendInc2015() {
        return vendInc2015;
    }

    /**
     * @param vendInc2015
     */
    public void setVendInc2015(BigDecimal vendInc2015) {
        this.vendInc2015 = vendInc2015;
    }

    /**
     * @return VendInc2016
     */
    public BigDecimal getVendInc2016() {
        return vendInc2016;
    }

    /**
     * @param vendInc2016
     */
    public void setVendInc2016(BigDecimal vendInc2016) {
        this.vendInc2016 = vendInc2016;
    }

    /**
     * @return VendInc2017
     */
    public BigDecimal getVendInc2017() {
        return vendInc2017;
    }

    /**
     * @param vendInc2017
     */
    public void setVendInc2017(BigDecimal vendInc2017) {
        this.vendInc2017 = vendInc2017;
    }

    /**
     * @return VendInc2018
     */
    public BigDecimal getVendInc2018() {
        return vendInc2018;
    }

    /**
     * @param vendInc2018
     */
    public void setVendInc2018(BigDecimal vendInc2018) {
        this.vendInc2018 = vendInc2018;
    }

    /**
     * @return VendInc2019
     */
    public BigDecimal getVendInc2019() {
        return vendInc2019;
    }

    /**
     * @param vendInc2019
     */
    public void setVendInc2019(BigDecimal vendInc2019) {
        this.vendInc2019 = vendInc2019;
    }

    /**
     * @return VendInc2020
     */
    public BigDecimal getVendInc2020() {
        return vendInc2020;
    }

    /**
     * @param vendInc2020
     */
    public void setVendInc2020(BigDecimal vendInc2020) {
        this.vendInc2020 = vendInc2020;
    }

    /**
     * @return VendInc2021
     */
    public BigDecimal getVendInc2021() {
        return vendInc2021;
    }

    /**
     * @param vendInc2021
     */
    public void setVendInc2021(BigDecimal vendInc2021) {
        this.vendInc2021 = vendInc2021;
    }

    /**
     * @return VendInc2022
     */
    public BigDecimal getVendInc2022() {
        return vendInc2022;
    }

    /**
     * @param vendInc2022
     */
    public void setVendInc2022(BigDecimal vendInc2022) {
        this.vendInc2022 = vendInc2022;
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

	public String getEntNamePPL() {
		return entNamePPL;
	}

	public void setEntNamePPL(String entNamePPL) {
		this.entNamePPL = entNamePPL;
	}

	public String getHelpTypeCode() {
		return helpTypeCode;
	}

	public void setHelpTypeCode(String helpTypeCode) {
		this.helpTypeCode = helpTypeCode;
	}

	public String getHelpTypeName() {
		return helpTypeName;
	}

	public void setHelpTypeName(String helpTypeName) {
		this.helpTypeName = helpTypeName;
	}

	public String getDemandTypeName() {
		return demandTypeName;
	}

	public void setDemandTypeName(String demandTypeName) {
		this.demandTypeName = demandTypeName;
	}
	
	public String getPriPIDDesc() {
		return AESEUtil.encodeCorpid(this.priPID);
	}
    
}