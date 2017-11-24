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
 * 描述:    cs_yr_otherinfo 对应的实体类.（其他情况表）<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2016年08月31日
 */
@Table(name = "cs_yr_otherinfo")
public class YrOtherInfo implements Serializable {
    @Id
    @Column(name = "id")
    private Integer id;

    /**
     * 主体身份代码
     */
    @Column(name = "PriPID")
    private String priPID;

    /**
     * 法定代表人（负责人）姓名
     */
    @Column(name = "LeRep")
    private String leRep;

    /**
     * 企业通信地址
     */
    @Column(name = "Addr")
    private String addr;

    /**
     * 邮政编码
     */
    @Column(name = "PostalCode")
    private String postalCode;

    /**
     * 企业联系电话
     */
    @Column(name = "Tel")
    private String tel;

    /**
     * 电子邮箱
     */
    @Column(name = "Email")
    private String email;

    /**
     * 年报年度
     */
    @Column(name = "Year")
    private Integer year;

    /**
     * 时间戳
     */
    @Column(name = "CreateTime")
    
    private Date createTime;

    /**
     * 年报其他情况ID
     */
    @Column(name = "OtherID")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    private String otherID;

    /**
     * 年报ID
     */
    @Column(name = "AnCheID")
    private String anCheID;

    /**
     * 其中跨境网络交易进出口经营额
     */
    @Column(name = "partyAccNetAmount")
    private BigDecimal partyAccNetAmount;

    /**
     * 党组织建制（中文名称）
     */
    @Column(name = "ParInsCN")
    private String parInsCN;

    /**
     * 企业拥有专利的数量（个）
     */
    @Column(name = "otherInfoPatAmount")
    private Integer otherInfoPatAmount;

    /**
     * 企业电子邮箱:0无1有
     */
    @Column(name = "otherInfoIsEmail")
    private String otherInfoIsEmail;

    /**
     * 企业联系电话:0无1有
     */
    @Column(name = "otherInfoIsTel")
    private String otherInfoIsTel;

    /**
     * 隶属企业名称
     */
    @Column(name = "SupEntname")
    private String supEntname;

    /**
     * 党组织建制
     */
    @Column(name = "ParIns")
    private String parIns;

    /**
     * 党组织组建方式
     */
    @Column(name = "ParOrgW")
    private String parOrgW;

    /**
     * 党员（预备党员）人数
     */
    @Column(name = "NumParM")
    private Integer numParM;

    /**
     * 法定代表人是否党员
     */
    @Column(name = "ResParMSign")
    private String resParMSign;

    /**
     * 法定代表人是否党组织书记
     */
    @Column(name = "ResParSecSign")
    private String resParSecSign;

    /**
     * 组建时间
     */
    @Column(name = "ParSetTime")
    private Date parSetTime;

    /**
     * 企业税务证登记号
     */
    @Column(name = "TaxRegNo")
    private String taxRegNo;

    /**
     * 企业组织机构代码证号
     */
    @Column(name = "EntOrgCode")
    private String entOrgCode;

    /**
     * 企业联络员手机号码
     */
    @Column(name = "LiaPhone")
    private String liaPhone;

    /**
     * 企业联络员证件号码
     */
    @Column(name = "LiaIDNum")
    private String liaIDNum;

    /**
     * 企业联络员证件类型
     */
    @Column(name = "LiaIDType")
    private String liaIDType;

    /**
     * 企业联络员姓名
     */
    @Column(name = "LiaName")
    private String liaName;

    /**
     * 法定代表人（负责人）手机号码
     */
    @Column(name = "LeRepPhone")
    private String leRepPhone;

    /**
     * 本年度通过网络交易经营额
     */
    @Column(name = "ThNetTraBusTur")
    private BigDecimal thNetTraBusTur;

    /**
     * 广告经营上缴税收
     */
    @Column(name = "AdvTurTaxPaid")
    private BigDecimal advTurTaxPaid;

    /**
     * 本年度广告经营额
     */
    @Column(name = "ThAdvTurnover")
    private BigDecimal thAdvTurnover;

    /**
     * 是否经营广告业务:1:专营,2:兼营,0:否
     */
    @Column(name = "AdvBusFlag")
    private String advBusFlag;

    /**
     * 其中：在互联网投入广告费
     */
    @Column(name = "ThIntAnnAdvFee")
    private BigDecimal thIntAnnAdvFee;

    /**
     * 本年度投入广告费
     */
    @Column(name = "ThAnnAdvFee")
    private BigDecimal thAnnAdvFee;

    /**
     * 本年新申请商标数量
     */
    @Column(name = "NewAppTraRegs")
    private Integer newAppTraRegs;

    /**
     * 许可他人使用商标数量
     */
    @Column(name = "LicOthTraRegs")
    private Integer licOthTraRegs;

    /**
     * 其中：实际在使用商标数量
     */
    @Column(name = "UsingTraRegs")
    private Integer usingTraRegs;

    /**
     * 境外商标注册数量
     */
    @Column(name = "AbrTraRegs")
    private Integer abrTraRegs;

    /**
     * 国内商标注册数量
     */
    @Column(name = "DomTraRegs")
    private Integer domTraRegs;

    /**
     *隶属企业统一代码注册号
     */
    @Column(name = "SupRegNO")
    private String supRegNO;

    /**
     * 有无网站网店信息（有:1;无:0）
     */
    @Column(name = "WebsiteFlag")
    private String websiteFlag;


    /**
     * 住所-市 编码
     */
    @Column(name = "CityAddressCopy")
    private String cityAddressCopy;

    /**
     * 住所-县区 编码
     */
    @Column(name = "AreaAddressCopy")
    private String areaAddressCopy;

    /**
     * 住所-街道 编码
     */
    @Column(name = "StreeAddressCopy")
    private String streeAddressCopy;

    /**
     * 通讯地址-市 编码
     */
    @Column(name = "CityAddress")
    private String cityAddress;

    /**
     * 通讯地址-县区 编码
     */
    @Column(name = "AreaAddress")
    private String areaAddress;

    /**
     * 通讯地址-街道 编码
     */
    @Column(name = "StreeAddress")
    private String streeAddress;

    /**
     * 通讯地址-描述信息
     */
    @Column(name = "DesAddress")
    private String desAddress;

    /**
     * 经营住所
     */
    @Column(name = "Dom")
    private String dom;

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
     * 获取法定代表人（负责人）姓名
     *
     * @return LeRep - 法定代表人（负责人）姓名
     */
    public String getLeRep() {
        return leRep;
    }

    /**
     * 设置法定代表人（负责人）姓名
     *
     * @param leRep 法定代表人（负责人）姓名
     */
    public void setLeRep(String leRep) {
        this.leRep = leRep;
    }

    /**
     * 获取企业通信地址
     *
     * @return Addr - 企业通信地址
     */
    public String getAddr() {
        return addr;
    }

    /**
     * 设置企业通信地址
     *
     * @param addr 企业通信地址
     */
    public void setAddr(String addr) {
        this.addr = addr;
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
     * 获取企业联系电话
     *
     * @return Tel - 企业联系电话
     */
    public String getTel() {
        return tel;
    }

    /**
     * 设置企业联系电话
     *
     * @param tel 企业联系电话
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
     * 获取年报其他情况ID
     *
     * @return OtherID - 年报其他情况ID
     */
    public String getOtherID() {
        return otherID;
    }

    /**
     * 设置年报其他情况ID
     *
     * @param otherID 年报其他情况ID
     */
    public void setOtherID(String otherID) {
        this.otherID = otherID;
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
     * 获取其中跨境网络交易进出口经营额
     *
     * @return partyAccNetAmount - 其中跨境网络交易进出口经营额
     */
    public BigDecimal getPartyAccNetAmount() {
        return partyAccNetAmount;
    }

    /**
     * 设置其中跨境网络交易进出口经营额
     *
     * @param partyAccNetAmount 其中跨境网络交易进出口经营额
     */
    public void setPartyAccNetAmount(BigDecimal partyAccNetAmount) {
        this.partyAccNetAmount = partyAccNetAmount;
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
     * 获取企业拥有专利的数量（个）
     *
     * @return otherInfoPatAmount - 企业拥有专利的数量（个）
     */
    public Integer getOtherInfoPatAmount() {
        return otherInfoPatAmount;
    }

    /**
     * 设置企业拥有专利的数量（个）
     *
     * @param otherInfoPatAmount 企业拥有专利的数量（个）
     */
    public void setOtherInfoPatAmount(Integer otherInfoPatAmount) {
        this.otherInfoPatAmount = otherInfoPatAmount;
    }

    /**
     * 获取企业电子邮箱:0无1有
     *
     * @return otherInfoIsEmail - 企业电子邮箱:0无1有
     */
    public String getOtherInfoIsEmail() {
        return otherInfoIsEmail;
    }

    /**
     * 设置企业电子邮箱:0无1有
     *
     * @param otherInfoIsEmail 企业电子邮箱:0无1有
     */
    public void setOtherInfoIsEmail(String otherInfoIsEmail) {
        this.otherInfoIsEmail = otherInfoIsEmail;
    }

    /**
     * 获取企业联系电话:0无1有
     *
     * @return otherInfoIsTel - 企业联系电话:0无1有
     */
    public String getOtherInfoIsTel() {
        return otherInfoIsTel;
    }

    /**
     * 设置企业联系电话:0无1有
     *
     * @param otherInfoIsTel 企业联系电话:0无1有
     */
    public void setOtherInfoIsTel(String otherInfoIsTel) {
        this.otherInfoIsTel = otherInfoIsTel;
    }

    /**
     * 获取隶属企业名称
     *
     * @return SupEntname - 隶属企业名称
     */
    public String getSupEntname() {
        return supEntname;
    }

    /**
     * 设置隶属企业名称
     *
     * @param supEntname 隶属企业名称
     */
    public void setSupEntname(String supEntname) {
        this.supEntname = supEntname;
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
     * 获取党组织组建方式
     *
     * @return ParOrgW - 党组织组建方式
     */
    public String getParOrgW() {
        return parOrgW;
    }

    /**
     * 设置党组织组建方式
     *
     * @param parOrgW 党组织组建方式
     */
    public void setParOrgW(String parOrgW) {
        this.parOrgW = parOrgW;
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
     * 获取法定代表人是否党员
     *
     * @return ResParMSign - 法定代表人是否党员
     */
    public String getResParMSign() {
        return resParMSign;
    }

    /**
     * 设置法定代表人是否党员
     *
     * @param resParMSign 法定代表人是否党员
     */
    public void setResParMSign(String resParMSign) {
        this.resParMSign = resParMSign;
    }

    /**
     * 获取法定代表人是否党组织书记
     *
     * @return ResParSecSign - 法定代表人是否党组织书记
     */
    public String getResParSecSign() {
        return resParSecSign;
    }

    /**
     * 设置法定代表人是否党组织书记
     *
     * @param resParSecSign 法定代表人是否党组织书记
     */
    public void setResParSecSign(String resParSecSign) {
        this.resParSecSign = resParSecSign;
    }

    /**
     * 获取组建时间
     *
     * @return ParSetTime - 组建时间
     */
    public Date getParSetTime() {
        return parSetTime;
    }

    /**
     * 设置组建时间
     *
     * @param parSetTime 组建时间
     */
    public void setParSetTime(Date parSetTime) {
        this.parSetTime = parSetTime;
    }

    /**
     * 获取企业税务证登记号
     *
     * @return TaxRegNo - 企业税务证登记号
     */
    public String getTaxRegNo() {
        return taxRegNo;
    }

    /**
     * 设置企业税务证登记号
     *
     * @param taxRegNo 企业税务证登记号
     */
    public void setTaxRegNo(String taxRegNo) {
        this.taxRegNo = taxRegNo;
    }

    /**
     * 获取企业组织机构代码证号
     *
     * @return EntOrgCode - 企业组织机构代码证号
     */
    public String getEntOrgCode() {
        return entOrgCode;
    }

    /**
     * 设置企业组织机构代码证号
     *
     * @param entOrgCode 企业组织机构代码证号
     */
    public void setEntOrgCode(String entOrgCode) {
        this.entOrgCode = entOrgCode;
    }

    /**
     * 获取企业联络员手机号码
     *
     * @return LiaPhone - 企业联络员手机号码
     */
    public String getLiaPhone() {
        return liaPhone;
    }

    /**
     * 设置企业联络员手机号码
     *
     * @param liaPhone 企业联络员手机号码
     */
    public void setLiaPhone(String liaPhone) {
        this.liaPhone = liaPhone;
    }

    /**
     * 获取企业联络员证件号码
     *
     * @return LiaIDNum - 企业联络员证件号码
     */
    public String getLiaIDNum() {
        return liaIDNum;
    }

    /**
     * 设置企业联络员证件号码
     *
     * @param liaIDNum 企业联络员证件号码
     */
    public void setLiaIDNum(String liaIDNum) {
        this.liaIDNum = liaIDNum;
    }

    /**
     * 获取企业联络员证件类型
     *
     * @return LiaIDType - 企业联络员证件类型
     */
    public String getLiaIDType() {
        return liaIDType;
    }

    /**
     * 设置企业联络员证件类型
     *
     * @param liaIDType 企业联络员证件类型
     */
    public void setLiaIDType(String liaIDType) {
        this.liaIDType = liaIDType;
    }

    /**
     * 获取企业联络员姓名
     *
     * @return LiaName - 企业联络员姓名
     */
    public String getLiaName() {
        return liaName;
    }

    /**
     * 设置企业联络员姓名
     *
     * @param liaName 企业联络员姓名
     */
    public void setLiaName(String liaName) {
        this.liaName = liaName;
    }

    /**
     * 获取法定代表人（负责人）手机号码
     *
     * @return LeRepPhone - 法定代表人（负责人）手机号码
     */
    public String getLeRepPhone() {
        return leRepPhone;
    }

    /**
     * 设置法定代表人（负责人）手机号码
     *
     * @param leRepPhone 法定代表人（负责人）手机号码
     */
    public void setLeRepPhone(String leRepPhone) {
        this.leRepPhone = leRepPhone;
    }

    /**
     * 获取本年度通过网络交易经营额
     *
     * @return ThNetTraBusTur - 本年度通过网络交易经营额
     */
    public BigDecimal getThNetTraBusTur() {
        return thNetTraBusTur;
    }

    /**
     * 设置本年度通过网络交易经营额
     *
     * @param thNetTraBusTur 本年度通过网络交易经营额
     */
    public void setThNetTraBusTur(BigDecimal thNetTraBusTur) {
        this.thNetTraBusTur = thNetTraBusTur;
    }

    /**
     * 获取广告经营上缴税收
     *
     * @return AdvTurTaxPaid - 广告经营上缴税收
     */
    public BigDecimal getAdvTurTaxPaid() {
        return advTurTaxPaid;
    }

    /**
     * 设置广告经营上缴税收
     *
     * @param advTurTaxPaid 广告经营上缴税收
     */
    public void setAdvTurTaxPaid(BigDecimal advTurTaxPaid) {
        this.advTurTaxPaid = advTurTaxPaid;
    }

    /**
     * 获取本年度广告经营额
     *
     * @return ThAdvTurnover - 本年度广告经营额
     */
    public BigDecimal getThAdvTurnover() {
        return thAdvTurnover;
    }

    /**
     * 设置本年度广告经营额
     *
     * @param thAdvTurnover 本年度广告经营额
     */
    public void setThAdvTurnover(BigDecimal thAdvTurnover) {
        this.thAdvTurnover = thAdvTurnover;
    }

    /**
     * 获取是否经营广告业务:1:专营,2:兼营,0:否
     *
     * @return AdvBusFlag - 是否经营广告业务:1:专营,2:兼营,0:否
     */
    public String getAdvBusFlag() {
        return advBusFlag;
    }

    /**
     * 设置是否经营广告业务:1:专营,2:兼营,0:否
     *
     * @param advBusFlag 是否经营广告业务:1:专营,2:兼营,0:否
     */
    public void setAdvBusFlag(String advBusFlag) {
        this.advBusFlag = advBusFlag;
    }

    /**
     * 获取其中：在互联网投入广告费
     *
     * @return ThIntAnnAdvFee - 其中：在互联网投入广告费
     */
    public BigDecimal getThIntAnnAdvFee() {
        return thIntAnnAdvFee;
    }

    /**
     * 设置其中：在互联网投入广告费
     *
     * @param thIntAnnAdvFee 其中：在互联网投入广告费
     */
    public void setThIntAnnAdvFee(BigDecimal thIntAnnAdvFee) {
        this.thIntAnnAdvFee = thIntAnnAdvFee;
    }

    /**
     * 获取本年度投入广告费
     *
     * @return ThAnnAdvFee - 本年度投入广告费
     */
    public BigDecimal getThAnnAdvFee() {
        return thAnnAdvFee;
    }

    /**
     * 设置本年度投入广告费
     *
     * @param thAnnAdvFee 本年度投入广告费
     */
    public void setThAnnAdvFee(BigDecimal thAnnAdvFee) {
        this.thAnnAdvFee = thAnnAdvFee;
    }

    /**
     * 获取本年新申请商标数量
     *
     * @return NewAppTraRegs - 本年新申请商标数量
     */
    public Integer getNewAppTraRegs() {
        return newAppTraRegs;
    }

    /**
     * 设置本年新申请商标数量
     *
     * @param newAppTraRegs 本年新申请商标数量
     */
    public void setNewAppTraRegs(Integer newAppTraRegs) {
        this.newAppTraRegs = newAppTraRegs;
    }

    /**
     * 获取许可他人使用商标数量
     *
     * @return LicOthTraRegs - 许可他人使用商标数量
     */
    public Integer getLicOthTraRegs() {
        return licOthTraRegs;
    }

    /**
     * 设置许可他人使用商标数量
     *
     * @param licOthTraRegs 许可他人使用商标数量
     */
    public void setLicOthTraRegs(Integer licOthTraRegs) {
        this.licOthTraRegs = licOthTraRegs;
    }

    /**
     * 获取其中：实际在使用商标数量
     *
     * @return UsingTraRegs - 其中：实际在使用商标数量
     */
    public Integer getUsingTraRegs() {
        return usingTraRegs;
    }

    /**
     * 设置其中：实际在使用商标数量
     *
     * @param usingTraRegs 其中：实际在使用商标数量
     */
    public void setUsingTraRegs(Integer usingTraRegs) {
        this.usingTraRegs = usingTraRegs;
    }

    /**
     * 获取境外商标注册数量
     *
     * @return AbrTraRegs - 境外商标注册数量
     */
    public Integer getAbrTraRegs() {
        return abrTraRegs;
    }

    /**
     * 设置境外商标注册数量
     *
     * @param abrTraRegs 境外商标注册数量
     */
    public void setAbrTraRegs(Integer abrTraRegs) {
        this.abrTraRegs = abrTraRegs;
    }

    /**
     * 获取国内商标注册数量
     *
     * @return DomTraRegs - 国内商标注册数量
     */
    public Integer getDomTraRegs() {
        return domTraRegs;
    }

    /**
     * 设置国内商标注册数量
     *
     * @param domTraRegs 国内商标注册数量
     */
    public void setDomTraRegs(Integer domTraRegs) {
        this.domTraRegs = domTraRegs;
    }

    /**
     * 获取 隶属企业统一代码注册号
     * @return
     */
    public String getSupRegNO() {
        return supRegNO;
    }
    /**
     * 设置隶属企业统一代码注册号
     *
     * @param supRegNO 隶属企业统一代码注册号
     */
    public void setSupRegNO(String supRegNO) {
        this.supRegNO = supRegNO;
    }
    /**
     * 获取住所-市 编码
     *
     * @return CityAddressCopy - 住所-市 编码
     */
    public String getCityAddressCopy() {
        return cityAddressCopy;
    }

    /**
     * 设置住所-市 编码
     *
     * @param cityAddressCopy 住所-市 编码
     */
    public void setCityAddressCopy(String cityAddressCopy) {
        this.cityAddressCopy = cityAddressCopy;
    }

    /**
     * 获取住所-县区 编码
     *
     * @return AreaAddressCopy - 住所-县区 编码
     */
    public String getAreaAddressCopy() {
        return areaAddressCopy;
    }

    /**
     * 设置住所-县区 编码
     *
     * @param areaAddressCopy 住所-县区 编码
     */
    public void setAreaAddressCopy(String areaAddressCopy) {
        this.areaAddressCopy = areaAddressCopy;
    }

    /**
     * 获取住所-街道 编码
     *
     * @return StreeAddressCopy - 住所-街道 编码
     */
    public String getStreeAddressCopy() {
        return streeAddressCopy;
    }

    /**
     * 设置住所-街道 编码
     *
     * @param streeAddressCopy 住所-街道 编码
     */
    public void setStreeAddressCopy(String streeAddressCopy) {
        this.streeAddressCopy = streeAddressCopy;
    }

    /**
     * 获取通讯地址-市 编码
     *
     * @return CityAddress - 通讯地址-市 编码
     */
    public String getCityAddress() {
        return cityAddress;
    }

    /**
     * 设置通讯地址-市 编码
     *
     * @param cityAddress 通讯地址-市 编码
     */
    public void setCityAddress(String cityAddress) {
        this.cityAddress = cityAddress;
    }

    /**
     * 获取通讯地址-县区 编码
     *
     * @return AreaAddress - 通讯地址-县区 编码
     */
    public String getAreaAddress() {
        return areaAddress;
    }

    /**
     * 设置通讯地址-县区 编码
     *
     * @param areaAddress 通讯地址-县区 编码
     */
    public void setAreaAddress(String areaAddress) {
        this.areaAddress = areaAddress;
    }

    /**
     * 获取通讯地址-街道 编码
     *
     * @return StreeAddress - 通讯地址-街道 编码
     */
    public String getStreeAddress() {
        return streeAddress;
    }

    /**
     * 设置通讯地址-街道 编码
     *
     * @param streeAddress 通讯地址-街道 编码
     */
    public void setStreeAddress(String streeAddress) {
        this.streeAddress = streeAddress;
    }

    /**
     * 获取通讯地址-描述信息
     *
     * @return DesAddress - 通讯地址-描述信息
     */
    public String getDesAddress() {
        return desAddress;
    }

    /**
     * 设置通讯地址-描述信息
     *
     * @param desAddress 通讯地址-描述信息
     */
    public void setDesAddress(String desAddress) {
        this.desAddress = desAddress;
    }

    /**
     * 获取经营住所
     *
     * @return Dom - 经营住所
     */
    public String getDom() {
        return dom;
    }

    /**
     * 设置经营住所
     *
     * @param dom 经营住所
     */
    public void setDom(String dom) {
        this.dom = dom;
    }

    public String getWebsiteFlag() {
        return websiteFlag;
    }

    public void setWebsiteFlag(String websiteFlag) {
        this.websiteFlag = websiteFlag;
    }


}