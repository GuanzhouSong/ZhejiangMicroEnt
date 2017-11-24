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
 * 描述:    cs_yr_pb_baseinfo 对应的实体类.（个体年报基本信息表）<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2016年09月10日
 */
@Table(name = "cs_yr_pb_baseinfo")
public class YrPbBaseInfo implements Serializable {
    @Id
    @Column(name = "id")
    private Integer id;

    /**
     * 主体身份代码
     */
    @Column(name = "PriPID")
    private String priPID;

    /**
     * 注册号
     */
    @Column(name = "RegNO")
    private String regNO;

    /**
     * 经营场所   
     */
    @Column(name = "OpLoc")
    private String opLoc;

    /**
     * 经营场所--市 编码
     */
    @Column(name = "CityAddressCopy")
    private String cityAddressCopy;

    /**
     * 经营场所--县区 编码
     */
    @Column(name = "AreaAddressCopy")
    private String areaAddressCopy;

    /**
     * 经营场所--街道 编码
     */
    @Column(name = "StreeAddressCopy")
    private String streeAddressCopy;

    /**
     * 实际经营场所-市 编码
     */
    @Column(name = "CityAddress")
    private String cityAddress;

    /**
     * 实际经营场所-县区 编码
     */
    @Column(name = "AreaAddress")
    private String areaAddress;

    /**
     * 实际经营场所-街道 编码
     */
    @Column(name = "StreeAddress")
    private String streeAddress;

    /**
     * 实际经营场所-描述信息
     */
    @Column(name = "DesAddress")
    private String desAddress;

    /**
     * 实际经营场所
     */
    @Column(name = "Addr")
    private String addr;


    /**
     * 名称
     */
    @Column(name = "TraName")
    private String traName;

    /**
     * 从业人数
     */
    @Column(name = "EmpNum")
    private Integer empNum;

    /**
     * 资金数额
     */
    @Column(name = "FundAm")
    private BigDecimal fundAm;

    /**
     * 纳税总额
     */
    @Column(name = "RatGro")
    private BigDecimal ratGro;

    /**
     * 营业额或营业收入是否公示
     */
    @Column(name = "VendIncIsPub")
    private String vendIncIsPub;

    /**
     * 统一社会信用代码
     */
    @Column(name = "UniCode")
    private String uniCode;

    /**
     * 经营者姓名
     */
    @Column(name = "Name")
    private String name;

    /**
     * 经营者联系电话
     */
    @Column(name = "Tel")
    private String tel;

    /**
     * 年份
     */
    @Column(name = "Year")
    private Integer year;

    /**
     * 营业额或营业收入
     */
    @Column(name = "VendInc")
    private BigDecimal vendInc;

    /**
     * 时间戳
     */
    @Column(name = "CreateTime")
    private Date createTime;

    /**
     * 高校毕业生1,退役士兵2,残疾人3,失业人员再就业4,都不是5
     */
    @Column(name = "IsLegRep")
    private String isLegRep;

    /**
     * 年报ID
     */
    @Column(name = "AnCheID")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    private String anCheID;

    /**
     * 党组织建制（中文名称）
     */
    @Column(name = "ParInsCN")
    private String parInsCN;

    /**
     * 2015年投入经营资金
     */
    @Column(name = "PbFundAm")
    private BigDecimal pbFundAm;

    /**
     * 是否已建立党组织 1-是，0-否
     */
    @Column(name = "PartOrgIs")
    private String partOrgIs;

    /**
     * 工商联系手机号码
     */
    @Column(name = "ComPhone")
    private String comPhone;

    /**
     * 是否属于免征纳税 1-是，0-否
     */
    @Column(name = "RreeTaxIs")
    private String rreeTaxIs;

    /**
     * 党组织建制
     */
    @Column(name = "ParIns")
    private String parIns;

    /**
     * 党员（预备党员）人数
     */
    @Column(name = "NumParM")
    private Integer numParM;

    /**
     * 经营者是否党员
     */
    @Column(name = "ResParMSign")
    private String resParMSign;

    /**
     * 经营者是否党组织书记
     */
    @Column(name = "ResParSecSign")
    private String resParSecSign;

    /**
     * 纳税总额是否公示
     */
    @Column(name = "RatGroIsPub")
    private String ratGroIsPub;

    /**
     * 其中残疾人人数(雇工)
     */
    @Column(name = "DisEmps")
    private Integer disEmps;

    /**
     * 其中退役士兵人数(雇工)
     */
    @Column(name = "ExSoldEmps")
    private Integer exSoldEmps;

    /**
     * 其中高校毕业生人数(雇工)
     */
    @Column(name = "UniGradEmps")
    private Integer uniGradEmps;

    /**
     * 其中失业人员再就业人数(雇工)
     */
    @Column(name = "UnemEmps")
    private Integer unemEmps;

    /**
     * 从业人数是否公示
     */
    @Column(name = "MemberNumsIsPub")
    private String memberNumsIsPub;
    
    /**
     * 有无网站网店信息（有:1;无:0）
     */
    @Column(name = "WebsiteFlag")
    private String websiteFlag;
    /**
     * 有无许可证信息（有:1;无:0）
     */
    @Column(name = "LicenseFlag")
    private String licenseFlag;

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
     * 获取经营场所
     *
     * @return OpLoc - 经营场所
     */
    public String getOpLoc() {
        return opLoc;
    }

    /**
     * 设置经营场所
     *
     * @param opLoc 经营场所
     */
    public void setOpLoc(String opLoc) {
        this.opLoc = opLoc;
    }

    /**
     * 获取名称
     *
     * @return TraName - 名称
     */
    public String getTraName() {
        return traName;
    }

    /**
     * 设置名称
     *
     * @param traName 名称
     */
    public void setTraName(String traName) {
        this.traName = traName;
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
     * 获取资金数额
     *
     * @return FundAm - 资金数额
     */
    public BigDecimal getFundAm() {
        return fundAm;
    }

    /**
     * 设置资金数额
     *
     * @param fundAm 资金数额
     */
    public void setFundAm(BigDecimal fundAm) {
        this.fundAm = fundAm;
    }

    /**
     * 获取纳税总额
     *
     * @return RatGro - 纳税总额
     */
    public BigDecimal getRatGro() {
        return ratGro;
    }

    /**
     * 设置纳税总额
     *
     * @param ratGro 纳税总额
     */
    public void setRatGro(BigDecimal ratGro) {
        this.ratGro = ratGro;
    }

    /**
     * 获取营业额或营业收入是否公示
     *
     * @return VendIncIsPub - 营业额或营业收入是否公示
     */
    public String getVendIncIsPub() {
        return vendIncIsPub;
    }

    /**
     * 设置营业额或营业收入是否公示
     *
     * @param vendIncIsPub 营业额或营业收入是否公示
     */
    public void setVendIncIsPub(String vendIncIsPub) {
        this.vendIncIsPub = vendIncIsPub;
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
     * 获取经营者姓名
     *
     * @return Name - 经营者姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置经营者姓名
     *
     * @param name 经营者姓名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取经营者联系电话
     *
     * @return Tel - 经营者联系电话
     */
    public String getTel() {
        return tel;
    }

    /**
     * 设置经营者联系电话
     *
     * @param tel 经营者联系电话
     */
    public void setTel(String tel) {
        this.tel = tel;
    }

    /**
     * 获取年份
     *
     * @return Year - 年份
     */
    public Integer getYear() {
        return year;
    }

    /**
     * 设置年份
     *
     * @param year 年份
     */
    public void setYear(Integer year) {
        this.year = year;
    }

    /**
     * 获取营业额或营业收入
     *
     * @return VendInc - 营业额或营业收入
     */
    public BigDecimal getVendInc() {
        return vendInc;
    }

    /**
     * 设置营业额或营业收入
     *
     * @param vendInc 营业额或营业收入
     */
    public void setVendInc(BigDecimal vendInc) {
        this.vendInc = vendInc;
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
     * 获取高校毕业生1,退役士兵2,残疾人3,失业人员再就业4,都不是5
     *
     * @return IsLegRep - 高校毕业生1,退役士兵2,残疾人3,失业人员再就业4,都不是5
     */
    public String getIsLegRep() {
        return isLegRep;
    }

    /**
     * 设置高校毕业生1,退役士兵2,残疾人3,失业人员再就业4,都不是5
     *
     * @param isLegRep 高校毕业生1,退役士兵2,残疾人3,失业人员再就业4,都不是5
     */
    public void setIsLegRep(String isLegRep) {
        this.isLegRep = isLegRep;
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
     * 获取党组织建制（中文名称）
     *
     * @return ParInsCN - 党组织建制（中文名称）
     */
    public String getParInsCN() {
        return parInsCN;
    }

    /**
     * 设置党组织建制（中文名称）
     *
     * @param parInsCN 党组织建制（中文名称）
     */
    public void setParInsCN(String parInsCN) {
        this.parInsCN = parInsCN;
    }

    /**
     * 获取2015年投入经营资金
     *
     * @return PbFundAm - 2015年投入经营资金
     */
    public BigDecimal getPbFundAm() {
        return pbFundAm;
    }

    /**
     * 设置2015年投入经营资金
     *
     * @param pbFundAm 2015年投入经营资金
     */
    public void setPbFundAm(BigDecimal pbFundAm) {
        this.pbFundAm = pbFundAm;
    }

    /**
     * 获取是否已建立党组织 1-是，0-否
     *
     * @return PartOrgIs - 是否已建立党组织 1-是，0-否
     */
    public String getPartOrgIs() {
        return partOrgIs;
    }

    /**
     * 设置是否已建立党组织 1-是，0-否
     *
     * @param partOrgIs 是否已建立党组织 1-是，0-否
     */
    public void setPartOrgIs(String partOrgIs) {
        this.partOrgIs = partOrgIs;
    }

    /**
     * 获取工商联系手机号码
     *
     * @return ComPhone - 工商联系手机号码
     */
    public String getComPhone() {
        return comPhone;
    }

    /**
     * 设置工商联系手机号码
     *
     * @param comPhone 工商联系手机号码
     */
    public void setComPhone(String comPhone) {
        this.comPhone = comPhone;
    }

    /**
     * 获取是否属于免征纳税 1-是，0-否
     *
     * @return RreeTaxIs - 是否属于免征纳税 1-是，0-否
     */
    public String getRreeTaxIs() {
        return rreeTaxIs;
    }

    /**
     * 设置是否属于免征纳税 1-是，0-否
     *
     * @param rreeTaxIs 是否属于免征纳税 1-是，0-否
     */
    public void setRreeTaxIs(String rreeTaxIs) {
        this.rreeTaxIs = rreeTaxIs;
    }

    /**
     * 获取党组织建制
     *
     * @return ParIns - 党组织建制
     */
    public String getParIns() {
        return parIns;
    }

    /**
     * 设置党组织建制
     *
     * @param parIns 党组织建制
     */
    public void setParIns(String parIns) {
        this.parIns = parIns;
    }

    /**
     * 获取党员（预备党员）人数
     *
     * @return NumParM - 党员（预备党员）人数
     */
    public Integer getNumParM() {
        return numParM;
    }

    /**
     * 设置党员（预备党员）人数
     *
     * @param numParM 党员（预备党员）人数
     */
    public void setNumParM(Integer numParM) {
        this.numParM = numParM;
    }

    /**
     * 获取经营者是否党员
     *
     * @return ResParMSign - 经营者是否党员
     */
    public String getResParMSign() {
        return resParMSign;
    }

    /**
     * 设置经营者是否党员
     *
     * @param resParMSign 经营者是否党员
     */
    public void setResParMSign(String resParMSign) {
        this.resParMSign = resParMSign;
    }

    /**
     * 获取经营者是否党组织书记
     *
     * @return ResParSecSign - 经营者是否党组织书记
     */
    public String getResParSecSign() {
        return resParSecSign;
    }

    /**
     * 设置经营者是否党组织书记
     *
     * @param resParSecSign 经营者是否党组织书记
     */
    public void setResParSecSign(String resParSecSign) {
        this.resParSecSign = resParSecSign;
    }

    /**
     * 获取纳税总额是否公示
     *
     * @return RatGroIsPub - 纳税总额是否公示
     */
    public String getRatGroIsPub() {
        return ratGroIsPub;
    }

    /**
     * 设置纳税总额是否公示
     *
     * @param ratGroIsPub 纳税总额是否公示
     */
    public void setRatGroIsPub(String ratGroIsPub) {
        this.ratGroIsPub = ratGroIsPub;
    }

    /**
     * 获取其中残疾人人数(雇工)
     *
     * @return DisEmps - 其中残疾人人数(雇工)
     */
    public Integer getDisEmps() {
        return disEmps;
    }

    /**
     * 设置其中残疾人人数(雇工)
     *
     * @param disEmps 其中残疾人人数(雇工)
     */
    public void setDisEmps(Integer disEmps) {
        this.disEmps = disEmps;
    }

    /**
     * 获取其中退役士兵人数(雇工)
     *
     * @return ExSoldEmps - 其中退役士兵人数(雇工)
     */
    public Integer getExSoldEmps() {
        return exSoldEmps;
    }

    /**
     * 设置其中退役士兵人数(雇工)
     *
     * @param exSoldEmps 其中退役士兵人数(雇工)
     */
    public void setExSoldEmps(Integer exSoldEmps) {
        this.exSoldEmps = exSoldEmps;
    }

    /**
     * 获取其中高校毕业生人数(雇工)
     *
     * @return UniGradEmps - 其中高校毕业生人数(雇工)
     */
    public Integer getUniGradEmps() {
        return uniGradEmps;
    }

    /**
     * 设置其中高校毕业生人数(雇工)
     *
     * @param uniGradEmps 其中高校毕业生人数(雇工)
     */
    public void setUniGradEmps(Integer uniGradEmps) {
        this.uniGradEmps = uniGradEmps;
    }

    /**
     * 获取其中失业人员再就业人数(雇工)
     *
     * @return UnemEmps - 其中失业人员再就业人数(雇工)
     */
    public Integer getUnemEmps() {
        return unemEmps;
    }

    /**
     * 设置其中失业人员再就业人数(雇工)
     *
     * @param unemEmps 其中失业人员再就业人数(雇工)
     */
    public void setUnemEmps(Integer unemEmps) {
        this.unemEmps = unemEmps;
    }

    /**
     * 获取从业人数是否公示
     *
     * @return MemberNumsIsPub - 从业人数是否公示
     */
    public String getMemberNumsIsPub() {
        return memberNumsIsPub;
    }

    /**
     * 设置从业人数是否公示
     *
     * @param memberNumsIsPub 从业人数是否公示
     */
    public void setMemberNumsIsPub(String memberNumsIsPub) {
        this.memberNumsIsPub = memberNumsIsPub;
    }

	public String getWebsiteFlag() {
		return websiteFlag;
	}

	public void setWebsiteFlag(String websiteFlag) {
		this.websiteFlag = websiteFlag;
	}

    public String getCityAddressCopy() {
        return cityAddressCopy;
    }

    public void setCityAddressCopy(String cityAddressCopy) {
        this.cityAddressCopy = cityAddressCopy;
    }

    public String getAreaAddressCopy() {
        return areaAddressCopy;
    }

    public void setAreaAddressCopy(String areaAddressCopy) {
        this.areaAddressCopy = areaAddressCopy;
    }

    public String getStreeAddressCopy() {
        return streeAddressCopy;
    }

    public void setStreeAddressCopy(String streeAddressCopy) {
        this.streeAddressCopy = streeAddressCopy;
    }

    public String getCityAddress() {
        return cityAddress;
    }

    public void setCityAddress(String cityAddress) {
        this.cityAddress = cityAddress;
    }

    public String getAreaAddress() {
        return areaAddress;
    }

    public void setAreaAddress(String areaAddress) {
        this.areaAddress = areaAddress;
    }

    public String getStreeAddress() {
        return streeAddress;
    }

    public void setStreeAddress(String streeAddress) {
        this.streeAddress = streeAddress;
    }

    public String getDesAddress() {
        return desAddress;
    }

    public void setDesAddress(String desAddress) {
        this.desAddress = desAddress;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }
    
    public void setLicenseFlag(String licenseFlag) {
		this.licenseFlag = licenseFlag;
	}
    
    public String getLicenseFlag() {
		return licenseFlag;
	}
}