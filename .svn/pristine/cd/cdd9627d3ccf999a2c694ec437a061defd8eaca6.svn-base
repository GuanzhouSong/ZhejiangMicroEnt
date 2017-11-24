/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.yr.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.icinfo.framework.mybatis.mapper.annotation.Before;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.*;

/**
 * 描述:    cs_yr_sfc_baseinfo 对应的实体类.（农专基本信息表）<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2016年09月27日
 */
@Table(name = "cs_yr_sfc_baseinfo")
public class YrSfcBaseinfo implements Serializable {
    /**
     * 自增ID
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
     *   企业通讯地址
     */
    @Column(name = "Dom")
    private String dom;

    /**
     *  经营住所
     */
    @Column(name = "AddrDom")
    private String addrDom;

    /**
     * 法定代表人
     */
    @Column(name = "LeRep")
    private String leRep;

    /**
     * 农民专业合作社名称
     */
    @Column(name = "FarSpeArtName")
    private String farSpeArtName;

    /**
     * 出资总额
     */
    @Column(name = "MemConGro")
    private BigDecimal memConGro;

    /**
     * 联系电话
     */
    @Column(name = "Tel")
    private String tel;

    /**
     * 电子邮件
     */
    @Column(name = "Email")
    private String email;

    /**
     * 年报年度
     */
    @Column(name = "Year")
    private Integer year;

    /**
     * 成员人数
     */
    @Column(name = "MemNum")
    private Integer memNum;

    /**
     * 本年度新增成员人数
     */
    @Column(name = "AnnNewMemNum")
    private Integer annNewMemNum;

    /**
     * 本年度退出成员人数
     */
    @Column(name = "AnnRedMemNum")
    private Integer annRedMemNum;

    /**
     * 成员人数中农民人数
     */
    @Column(name = "Farnum")
    private Integer farnum;

    /**
     * 时间戳
     */
    @Column(name = "CreateTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;

    /**
     * 年报ID
     */
    @Column(name = "AnCheID")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    private String anCheID;

    /**
     * 填报日期
     */
    @Column(name = "SubDate")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date subDate;

    /**
     * 其它工商服务
     */
    @Column(name = "OthICService")
    private String othICService;

    /**
     * 工商服务；1.商标注册、著名商标、知名商号等品牌建设方面，需要支持帮助
     */
    @Column(name = "ICService")
    private String icService;

    /**
     * 社员信用户；单位：%
     */
    @Column(name = "CreditMem")
    private BigDecimal creditMem;

    /**
     * 企业联络员手机号码
     */
    @Column(name = "LiaPhone")
    private String liaPhone;

    /**
     * 联络员证件号码
     */
    @Column(name = "LiaIDNum")
    private String liaIDNum;

    /**
     * 联络员证件类型
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
     * 经营(业务)范围
     */
    @Column(name = "OpScope")
    private String opScope;
    
    
    /**
     * 纳税金额
     */
    @Column(name = "RatGro")
    private BigDecimal ratGro;

    /**
     * 销售额或营业收入是否公示
     */
    @Column(name = "VendIncIsPub")
    private String vendIncIsPub;

    /**
     * 销售额或营业收入
     */
    @Column(name = "VendInc")
    private BigDecimal vendInc;

    /**
     * 盈余总额
     */
    @Column(name = "PriYeaProfit")
    private BigDecimal priYeaProfit;

    /**
     * 获得政府扶持资金、补助
     */
    @Column(name = "PriYeaSub")
    private BigDecimal priYeaSub;

    /**
     * 金融贷款
     */
    @Column(name = "PriYeaLoan")
    private BigDecimal priYeaLoan;

    /**
     * 盈余总额是否公示
     */
    @Column(name = "MaiBusIncIsPub")
    private String maiBusIncIsPub;

    /**
     * 纳税金额是否公示
     */
    @Column(name = "RatGroIsPub")
    private String ratGroIsPub;

    /**
     * 金融贷款是否公示
     */
    @Column(name = "PriYeaLoanIsPub")
    private String priYeaLoanIsPub;

    /**
     * 获得政府扶持资金、补助是否公示
     */
    @Column(name = "PriYeaSubIsPub")
    private String priYeaSubIsPub;
    
    
    /**
     * 从业人数
     */
    @Column(name = "EmpNum")
    private Integer empNum;

    /**
     * 从业人数是否公示
     */
    @Column(name = "EmpNumDis")
    private String empNumDis;
    
    /**
     * 其中女性从业人数
     */
    @Column(name = "FemaleEmploye")
    private Integer femaleEmploye;

    /**
     * 其中女性从业人数是否公示
     */
    @Column(name = "FemaleEmployeIsPub")
    private String femaleEmployeIsPub;
    /**
     * 主营业务活动
     */
    @Column(name = "EntMainBusActivity")
    private String entMainBusActivity;
    
    /**
     * 有无网站网店信息（有:1;无:0）
     */
    @Column(name = "WebsiteFlag")
    private String websiteFlag;

    /**
     * 企业住所--市 编码
     */
    @Column(name = "CityAddressCopy")
    private String cityAddressCopy;

    /**
     * 企业住所--县区 编码
     */
    @Column(name = "AreaAddressCopy")
    private String areaAddressCopy;

    /**
     * 企业住所--街道 编码
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
     * 获取农民专业合作社名称
     *
     * @return FarSpeArtName - 农民专业合作社名称
     */
    public String getFarSpeArtName() {
        return farSpeArtName;
    }

    /**
     * 设置农民专业合作社名称
     *
     * @param farSpeArtName 农民专业合作社名称
     */
    public void setFarSpeArtName(String farSpeArtName) {
        this.farSpeArtName = farSpeArtName;
    }

    /**
     * 获取出资总额
     *
     * @return MemConGro - 出资总额
     */
    public BigDecimal getMemConGro() {
        return memConGro;
    }

    /**
     * 设置出资总额
     *
     * @param memConGro 出资总额
     */
    public void setMemConGro(BigDecimal memConGro) {
        this.memConGro = memConGro;
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
     * 获取电子邮件
     *
     * @return Email - 电子邮件
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置电子邮件
     *
     * @param email 电子邮件
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
     * 获取成员人数
     *
     * @return MemNum - 成员人数
     */
    public Integer getMemNum() {
        return memNum;
    }

    /**
     * 设置成员人数
     *
     * @param memNum 成员人数
     */
    public void setMemNum(Integer memNum) {
        this.memNum = memNum;
    }

    /**
     * 获取本年度新增成员人数
     *
     * @return AnnNewMemNum - 本年度新增成员人数
     */
    public Integer getAnnNewMemNum() {
        return annNewMemNum;
    }

    /**
     * 设置本年度新增成员人数
     *
     * @param annNewMemNum 本年度新增成员人数
     */
    public void setAnnNewMemNum(Integer annNewMemNum) {
        this.annNewMemNum = annNewMemNum;
    }

    /**
     * 获取本年度退出成员人数
     *
     * @return AnnRedMemNum - 本年度退出成员人数
     */
    public Integer getAnnRedMemNum() {
        return annRedMemNum;
    }

    /**
     * 设置本年度退出成员人数
     *
     * @param annRedMemNum 本年度退出成员人数
     */
    public void setAnnRedMemNum(Integer annRedMemNum) {
        this.annRedMemNum = annRedMemNum;
    }

    /**
     * 获取成员人数中农民人数
     *
     * @return Farnum - 成员人数中农民人数
     */
    public Integer getFarnum() {
        return farnum;
    }

    /**
     * 设置成员人数中农民人数
     *
     * @param farnum 成员人数中农民人数
     */
    public void setFarnum(Integer farnum) {
        this.farnum = farnum;
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
     * 获取填报日期
     *
     * @return SubDate - 填报日期
     */
    public Date getSubDate() {
        return subDate;
    }

    /**
     * 设置填报日期
     *
     * @param subDate 填报日期
     */
    public void setSubDate(Date subDate) {
        this.subDate = subDate;
    }

    /**
     * 获取其它工商服务
     *
     * @return OthICService - 其它工商服务
     */
    public String getOthICService() {
        return othICService;
    }

    /**
     * 设置其它工商服务
     *
     * @param othICService 其它工商服务
     */
    public void setOthICService(String othICService) {
        this.othICService = othICService;
    }

    /**
     * 获取工商服务；1.商标注册、著名商标、知名商号等品牌建设方面，需要支持帮助
     *
     * @return ICService - 工商服务；1.商标注册、著名商标、知名商号等品牌建设方面，需要支持帮助
     */
    public String getIcService() {
        return icService;
    }

    /**
     * 设置工商服务；1.商标注册、著名商标、知名商号等品牌建设方面，需要支持帮助
     *
     * @param ICService 工商服务；1.商标注册、著名商标、知名商号等品牌建设方面，需要支持帮助
     */
    public void setIcService(String icService) {
        this.icService = icService;
    }

    /**
     * 获取社员信用户；单位：%
     *
     * @return CreditMem - 社员信用户；单位：%
     */
    public BigDecimal getCreditMem() {
        return creditMem;
    }

    /**
     * 设置社员信用户；单位：%
     *
     * @param creditMem 社员信用户；单位：%
     */
    public void setCreditMem(BigDecimal creditMem) {
        this.creditMem = creditMem;
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
     * 获取联络员证件号码
     *
     * @return LiaIDNum - 联络员证件号码
     */
    public String getLiaIDNum() {
        return liaIDNum;
    }

    /**
     * 设置联络员证件号码
     *
     * @param liaIDNum 联络员证件号码
     */
    public void setLiaIDNum(String liaIDNum) {
        this.liaIDNum = liaIDNum;
    }

    /**
     * 获取联络员证件类型
     *
     * @return LiaIDType - 联络员证件类型
     */
    public String getLiaIDType() {
        return liaIDType;
    }

    /**
     * 设置联络员证件类型
     *
     * @param liaIDType 联络员证件类型
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
     * 获取经营(业务)范围
     *
     * @return OpScope - 经营(业务)范围
     */
    public String getOpScope() {
        return opScope;
    }

    /**
     * 设置经营(业务)范围
     *
     * @param opScope 经营(业务)范围
     */
    public void setOpScope(String opScope) {
        this.opScope = opScope;
    }

    /**
     * 获取纳税金额
     *
     * @return RatGro - 纳税金额
     */
    public BigDecimal getRatGro() {
        return ratGro;
    }

    /**
     * 设置纳税金额
     *
     * @param ratGro 纳税金额
     */
    public void setRatGro(BigDecimal ratGro) {
        this.ratGro = ratGro;
    }

    /**
     * 获取销售额或营业收入是否公示
     *
     * @return VendIncIsPub - 销售额或营业收入是否公示
     */
    public String getVendIncIsPub() {
        return vendIncIsPub;
    }

    /**
     * 设置销售额或营业收入是否公示
     *
     * @param vendIncIsPub 销售额或营业收入是否公示
     */
    public void setVendIncIsPub(String vendIncIsPub) {
        this.vendIncIsPub = vendIncIsPub;
    }

    /**
     * 获取销售额或营业收入
     *
     * @return VendInc - 销售额或营业收入
     */
    public BigDecimal getVendInc() {
        return vendInc;
    }

    /**
     * 设置销售额或营业收入
     *
     * @param vendInc 销售额或营业收入
     */
    public void setVendInc(BigDecimal vendInc) {
        this.vendInc = vendInc;
    }

    /**
     * 获取盈余总额
     *
     * @return PriYeaProfit - 盈余总额
     */
    public BigDecimal getPriYeaProfit() {
        return priYeaProfit;
    }

    /**
     * 设置盈余总额
     *
     * @param priYeaProfit 盈余总额
     */
    public void setPriYeaProfit(BigDecimal priYeaProfit) {
        this.priYeaProfit = priYeaProfit;
    }

    /**
     * 获取获得政府扶持资金、补助
     *
     * @return PriYeaSub - 获得政府扶持资金、补助
     */
    public BigDecimal getPriYeaSub() {
        return priYeaSub;
    }

    /**
     * 设置获得政府扶持资金、补助
     *
     * @param priYeaSub 获得政府扶持资金、补助
     */
    public void setPriYeaSub(BigDecimal priYeaSub) {
        this.priYeaSub = priYeaSub;
    }

    /**
     * 获取金融贷款
     *
     * @return PriYeaLoan - 金融贷款
     */
    public BigDecimal getPriYeaLoan() {
        return priYeaLoan;
    }

    /**
     * 设置金融贷款
     *
     * @param priYeaLoan 金融贷款
     */
    public void setPriYeaLoan(BigDecimal priYeaLoan) {
        this.priYeaLoan = priYeaLoan;
    }


    /**
     * 获取盈余总额是否公示
     *
     * @return MaiBusIncIsPub - 盈余总额是否公示
     */
    public String getMaiBusIncIsPub() {
        return maiBusIncIsPub;
    }

    /**
     * 设置盈余总额是否公示
     *
     * @param maiBusIncIsPub 盈余总额是否公示
     */
    public void setMaiBusIncIsPub(String maiBusIncIsPub) {
        this.maiBusIncIsPub = maiBusIncIsPub;
    }

    /**
     * 获取纳税金额是否公示
     *
     * @return RatGroIsPub - 纳税金额是否公示
     */
    public String getRatGroIsPub() {
        return ratGroIsPub;
    }

    /**
     * 设置纳税金额是否公示
     *
     * @param ratGroIsPub 纳税金额是否公示
     */
    public void setRatGroIsPub(String ratGroIsPub) {
        this.ratGroIsPub = ratGroIsPub;
    }

    /**
     * 获取金融贷款是否公示
     *
     * @return PriYeaLoanIsPub - 金融贷款是否公示
     */
    public String getPriYeaLoanIsPub() {
        return priYeaLoanIsPub;
    }

    /**
     * 设置金融贷款是否公示
     *
     * @param priYeaLoanIsPub 金融贷款是否公示
     */
    public void setPriYeaLoanIsPub(String priYeaLoanIsPub) {
        this.priYeaLoanIsPub = priYeaLoanIsPub;
    }

    /**
     * 获取获得政府扶持资金、补助是否公示
     *
     * @return PriYeaSubIsPub - 获得政府扶持资金、补助是否公示
     */
    public String getPriYeaSubIsPub() {
        return priYeaSubIsPub;
    }

    /**
     * 设置获得政府扶持资金、补助是否公示
     *
     * @param priYeaSubIsPub 获得政府扶持资金、补助是否公示
     */
    public void setPriYeaSubIsPub(String priYeaSubIsPub) {
        this.priYeaSubIsPub = priYeaSubIsPub;
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

	public Integer getEmpNum() {
		return empNum;
	}

	public void setEmpNum(Integer empNum) {
		this.empNum = empNum;
	}

	public String getEmpNumDis() {
		return empNumDis;
	}

	public void setEmpNumDis(String empNumDis) {
		this.empNumDis = empNumDis;
	}

	public Integer getFemaleEmploye() {
		return femaleEmploye;
	}

	public void setFemaleEmploye(Integer femaleEmploye) {
		this.femaleEmploye = femaleEmploye;
	}

	public String getFemaleEmployeIsPub() {
		return femaleEmployeIsPub;
	}

	public void setFemaleEmployeIsPub(String femaleEmployeIsPub) {
		this.femaleEmployeIsPub = femaleEmployeIsPub;
	}

	public String getEntMainBusActivity() {
		return entMainBusActivity;
	}

	public void setEntMainBusActivity(String entMainBusActivity) {
		this.entMainBusActivity = entMainBusActivity;
	}

	public String getWebsiteFlag() {
		return websiteFlag;
	}

	public void setWebsiteFlag(String websiteFlag) {
		this.websiteFlag = websiteFlag;
	}

    public String getAddrDom() {
        return addrDom;
    }

    public void setAddrDom(String addrDom) {
        this.addrDom = addrDom;
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
}