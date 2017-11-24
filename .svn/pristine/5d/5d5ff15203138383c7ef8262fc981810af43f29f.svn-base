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
 * 描述:    cs_yr_asset 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author wangjin
 * @date 2016年08月28日
 */
@Table(name = "cs_yr_asset")
public class YrAsset implements Serializable {
    @Id
    @Column(name = "id")
    private Integer id;

    /**
     * 从业人数
     */
    @Column(name = "EmpNum")
    private Integer empNum;

    /**
     * 利润总额
     */
    @Column(name = "ProGro")
    private BigDecimal proGro;

    /**
     * 纳税总额
     */
    @Column(name = "RatGro")
    private BigDecimal ratGro;

    /**
     * 营业总收入是否公示
     */
    @Column(name = "VendIncIsPub")
    private String vendIncIsPub;

    /**
     * 年报年度
     */
    @Column(name = "Year")
    private Integer year;

    /**
     * 资产总额
     */
    @Column(name = "AssGro")
    private BigDecimal assGro;

    /**
     * 负债总额
     */
    @Column(name = "LiaGro")
    private BigDecimal liaGro;

    /**
     * 营业总收入
     */
    @Column(name = "VendInc")
    private BigDecimal vendInc;

    /**
     * 净利润
     */
    @Column(name = "NetInc")
    private BigDecimal netInc;

    /**
     * 营运状况
     */
    @Column(name = "BusSt")
    private String busSt;

    /**
     * 其中主营业务收入
     */
    @Column(name = "MaiBusInc")
    private BigDecimal maiBusInc;

    /**
     * 所有者权益合计
     */
    @Column(name = "TotEqu")
    private BigDecimal totEqu;

    @Column(name = "CreateTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8") 
    private Date createTime;

    /**
     * 你企业属于：1独立核算，2非独立核算（经营情况表-分支机构使用字段）
     */
    @Column(name = "EntBelong")
    private String entBelong;

    /**
     * 当年五险一金支出总额
     */
    @Column(name = "SocFee")
    private BigDecimal socFee;

    /**
     * 当年房租支出总额
     */
    @Column(name = "RentFee")
    private BigDecimal rentFee;

    /**
     * 当年工资支出总额
     */
    @Column(name = "SalaryFee")
    private BigDecimal salaryFee;

    /**
     * 当年水电费支出总额
     */
    @Column(name = "WaterFee")
    private BigDecimal waterFee;

    /**
     * 企业已安置残疾人员数
     */
    @Column(name = "EntSetDis")
    private Integer entSetDis;

    /**
     * 企业应安置残疾人员数
     */
    @Column(name = "EntOugthSetDis")
    private Integer entOugthSetDis;

    /**
     * 企业法定代表人是否属于：1高校毕业生，2退役士兵，3残疾人，4失业人员再就业，5都不是
     */
    @Column(name = "IsLegRep")
    private String isLegRep;

    /**
     * 当年是否依法交纳残保金1：是，0：否
     */
    @Column(name = "IsLegPay")
    private String isLegPay;

    /**
     * 当年是否享受减免残保金政策1：是，0：否
     */
    @Column(name = "IsMinDis")
    private String isMinDis;

    /**
     * 当年减免地税
     */
    @Column(name = "MinLandTax")
    private BigDecimal minLandTax;

    /**
     * 当年减免国税
     */
    @Column(name = "MinNationTax")
    private BigDecimal minNationTax;

    /**
     * 其他
     */
    @Column(name = "otherTax")
    private BigDecimal otherTax;

    /**
     * 水利基金
     */
    @Column(name = "WaterTax")
    private BigDecimal waterTax;

    /**
     * 城镇土地使用税
     */
    @Column(name = "LanUseTax")
    private BigDecimal lanUseTax;

    /**
     * 房产税
     */
    @Column(name = "HouseTax")
    private BigDecimal houseTax;

    /**
     * 教育费附加
     */
    @Column(name = "TechTax")
    private BigDecimal techTax;

    /**
     * 个人所得税
     */
    @Column(name = "PersonTax")
    private BigDecimal personTax;

    /**
     * 关税
     */
    @Column(name = "DutyTax")
    private BigDecimal dutyTax;

    /**
     * 企业所得税
     */
    @Column(name = "EntTax")
    private BigDecimal entTax;

    /**
     * 土地增值税
     */
    @Column(name = "LandTax")
    private BigDecimal landTax;

    /**
     * 消费税
     */
    @Column(name = "ExpenseTax")
    private BigDecimal expenseTax;

    /**
     * 印花税
     */
    @Column(name = "FloTax")
    private BigDecimal floTax;

    /**
     * 营业税
     */
    @Column(name = "MngTax")
    private BigDecimal mngTax;

    /**
     * 城市维护建设税
     */
    @Column(name = "CityTax")
    private BigDecimal cityTax;

    /**
     * 增值税
     */
    @Column(name = "AddTax")
    private BigDecimal addTax;

    /**
     * 当年贷款利息支出总额
     */
    @Column(name = "PayLoan")
    private BigDecimal payLoan;

    /**
     * 截止当年末，从金融机构获得的贷款余额
     */
    @Column(name = "EndLoan")
    private BigDecimal endLoan;

    /**
     * 当年从小额贷款公司等其他渠道融资总额
     */
    @Column(name = "ComLoan")
    private BigDecimal comLoan;

    /**
     * 当年从金融机构获得贷款总额
     */
    @Column(name = "FinOrgLoan")
    private BigDecimal finOrgLoan;

    /**
     * 当年研究开发、技术改造、科技创新等方面的支出
     */
    @Column(name = "IntelGro")
    private BigDecimal intelGro;

    /**
     * 当年出口创汇总额
     */
    @Column(name = "ExpGro")
    private BigDecimal expGro;

    /**
     * 无经营活动收入或歇业的原因
     */
    @Column(name = "NoBusRea")
    private String noBusRea;

    /**
     * 经营状态（中文名称）
     */
    @Column(name = "BusStatusCN")
    private String busStatusCN;

    /**
     * 从业人数是否公示
     */
    @Column(name = "EmpNumDis")
    private String empNumDis;

    /**
     * 资产状况ID
     */
    @Column(name = "AssetID")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    private String assetID;

    /**
     * 年报ID
     */
    @Column(name = "AnCheID")
    private String anCheID;

    /**
     * 资产总额是否公示
     */
    @Column(name = "AssGroIsPub")
    private String assGroIsPub;

    /**
     * 负债总额是否公示
     */
    @Column(name = "LiaGroIsPub")
    private String liaGroIsPub;

    /**
     * 其中主营业务收入是否公示
     */
    @Column(name = "MaiBusIncIsPub")
    private String maiBusIncIsPub;

    /**
     * 纳税总额是否公示
     */
    @Column(name = "RatGroIsPub")
    private String ratGroIsPub;

    /**
     * 净利润是否公示
     */
    @Column(name = "NetIncIsPub")
    private String netIncIsPub;

    /**
     * 利润总额是否公示
     */
    @Column(name = "ProGroIsPub")
    private String proGroIsPub;

    /**
     * 所有者权益合计是否公示
     */
    @Column(name = "TotEquIsPub")
    private String totEquIsPub;


    /**
     * 实收资本
     */
    @Column(name = "RecCap")
    private BigDecimal recCap;

    /**
     * 其中残疾人人数(雇工)
     */
    @Column(name = "DisEmps")
    private Integer disEmps;

    /**
     * 其中残疾人人数(经营者)
     */
    @Column(name = "DisOpers")
    private Integer disOpers;

    /**
     * 其中退役士兵人数(雇工)
     */
    @Column(name = "ExSoldEmps")
    private Integer exSoldEmps;

    /**
     * 其中退役士兵人数(经营者)
     */
    @Column(name = "ExSoldOpers")
    private Integer exSoldOpers;

    /**
     * 其中高校毕业生人数(雇工)
     */
    @Column(name = "UniGradEmps")
    private Integer uniGradEmps;

    /**
     * 其中高校毕业生人数(经营者)
     */
    @Column(name = "UniGradOpers")
    private Integer uniGradOpers;

    /**
     * 其中失业人员再就业人数(雇工)
     */
    @Column(name = "UnemEmps")
    private Integer unemEmps;

    /**
     * 其中失业人员再就业人数(经营者)
     */
    @Column(name = "UnemOpers")
    private Integer unemOpers;

    /**
     * 流动负债合计
     */
    @Column(name = "TotCurrLiab")
    private BigDecimal totCurrLiab;

    /**
     * 其他应付款
     */
    @Column(name = "OthPay")
    private BigDecimal othPay;

    /**
     * 流动资产合计
     */
    @Column(name = "TotCurrAssets")
    private BigDecimal totCurrAssets;

    /**
     * 应付账款
     */
    @Column(name = "AccPay")
    private BigDecimal accPay;

    /**
     * 存货
     */
    @Column(name = "Inventory")
    private BigDecimal inventory;

    /**
     * 无形资产
     */
    @Column(name = "IntAssets")
    private BigDecimal intAssets;

    /**
     * 其他应收款
     */
    @Column(name = "OthAccRec")
    private BigDecimal othAccRec;

    /**
     * 固定资产
     */
    @Column(name = "FixAssets")
    private BigDecimal fixAssets;

    /**
     * 应收账款
     */
    @Column(name = "AccRec")
    private BigDecimal accRec;

    /**
     * 长期投资
     */
    @Column(name = "LongInvest")
    private BigDecimal longInvest;

    /**
     * 货币资金
     */
    @Column(name = "MoneFunds")
    private BigDecimal moneFunds;

    /**
     * 主体身份代码
     */
    @Column(name = "PriPID")
    private String priPID;

    /**
     * 企业主营业务活动
     * @return
     */
    @Column(name = "EntMainBusActivity")
    private String entMainBusActivity;

    /**
    * 企业控股情况
    * @return
    */
    @Column(name = "EntControl")
    private String entControl;

    /**
    * 企业控股情况是否公示
    */
    @Column(name = "EntControlIsPub")
    private String entControlIsPub;

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
     * 获取利润总额
     *
     * @return ProGro - 利润总额
     */
    public BigDecimal getProGro() {
        return proGro;
    }

    /**
     * 设置利润总额
     *
     * @param proGro 利润总额
     */
    public void setProGro(BigDecimal proGro) {
        this.proGro = proGro;
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
     * 获取营业总收入是否公示
     *
     * @return VendIncIsPub - 营业总收入是否公示
     */
    public String getVendIncIsPub() {
        return vendIncIsPub;
    }

    /**
     * 设置营业总收入是否公示
     *
     * @param vendIncIsPub 营业总收入是否公示
     */
    public void setVendIncIsPub(String vendIncIsPub) {
        this.vendIncIsPub = vendIncIsPub;
    }

     

    public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	/**
     * 获取资产总额
     *
     * @return AssGro - 资产总额
     */
    public BigDecimal getAssGro() {
        return assGro;
    }

    /**
     * 设置资产总额
     *
     * @param assGro 资产总额
     */
    public void setAssGro(BigDecimal assGro) {
        this.assGro = assGro;
    }

    /**
     * 获取负债总额
     *
     * @return LiaGro - 负债总额
     */
    public BigDecimal getLiaGro() {
        return liaGro;
    }

    /**
     * 设置负债总额
     *
     * @param liaGro 负债总额
     */
    public void setLiaGro(BigDecimal liaGro) {
        this.liaGro = liaGro;
    }

    /**
     * 获取营业总收入
     *
     * @return VendInc - 营业总收入
     */
    public BigDecimal getVendInc() {
        return vendInc;
    }

    /**
     * 设置营业总收入
     *
     * @param vendInc 营业总收入
     */
    public void setVendInc(BigDecimal vendInc) {
        this.vendInc = vendInc;
    }

    /**
     * 获取净利润
     *
     * @return NetInc - 净利润
     */
    public BigDecimal getNetInc() {
        return netInc;
    }

    /**
     * 设置净利润
     *
     * @param netInc 净利润
     */
    public void setNetInc(BigDecimal netInc) {
        this.netInc = netInc;
    }

    /**
     * 获取营运状况
     *
     * @return BusSt - 营运状况
     */
    public String getBusSt() {
        return busSt;
    }

    /**
     * 设置营运状况
     *
     * @param busSt 营运状况
     */
    public void setBusSt(String busSt) {
        this.busSt = busSt;
    }

    /**
     * 获取其中主营业务收入
     *
     * @return MaiBusInc - 其中主营业务收入
     */
    public BigDecimal getMaiBusInc() {
        return maiBusInc;
    }

    /**
     * 设置其中主营业务收入
     *
     * @param maiBusInc 其中主营业务收入
     */
    public void setMaiBusInc(BigDecimal maiBusInc) {
        this.maiBusInc = maiBusInc;
    }

    /**
     * 获取所有者权益合计
     *
     * @return TotEqu - 所有者权益合计
     */
    public BigDecimal getTotEqu() {
        return totEqu;
    }

    /**
     * 设置所有者权益合计
     *
     * @param totEqu 所有者权益合计
     */
    public void setTotEqu(BigDecimal totEqu) {
        this.totEqu = totEqu;
    }

    /**
     * @return CreateTime
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取你企业属于：1独立核算，2非独立核算（经营情况表-分支机构使用字段）
     *
     * @return EntBelong - 你企业属于：1独立核算，2非独立核算（经营情况表-分支机构使用字段）
     */
    public String getEntBelong() {
        return entBelong;
    }

    /**
     * 设置你企业属于：1独立核算，2非独立核算（经营情况表-分支机构使用字段）
     *
     * @param entBelong 你企业属于：1独立核算，2非独立核算（经营情况表-分支机构使用字段）
     */
    public void setEntBelong(String entBelong) {
        this.entBelong = entBelong;
    }

    /**
     * 获取当年五险一金支出总额
     *
     * @return SocFee - 当年五险一金支出总额
     */
    public BigDecimal getSocFee() {
        return socFee;
    }

    /**
     * 设置当年五险一金支出总额
     *
     * @param socFee 当年五险一金支出总额
     */
    public void setSocFee(BigDecimal socFee) {
        this.socFee = socFee;
    }

    /**
     * 获取当年房租支出总额
     *
     * @return RentFee - 当年房租支出总额
     */
    public BigDecimal getRentFee() {
        return rentFee;
    }

    /**
     * 设置当年房租支出总额
     *
     * @param rentFee 当年房租支出总额
     */
    public void setRentFee(BigDecimal rentFee) {
        this.rentFee = rentFee;
    }

    /**
     * 获取当年工资支出总额
     *
     * @return SalaryFee - 当年工资支出总额
     */
    public BigDecimal getSalaryFee() {
        return salaryFee;
    }

    /**
     * 设置当年工资支出总额
     *
     * @param salaryFee 当年工资支出总额
     */
    public void setSalaryFee(BigDecimal salaryFee) {
        this.salaryFee = salaryFee;
    }

    /**
     * 获取当年水电费支出总额
     *
     * @return WaterFee - 当年水电费支出总额
     */
    public BigDecimal getWaterFee() {
        return waterFee;
    }

    /**
     * 设置当年水电费支出总额
     *
     * @param waterFee 当年水电费支出总额
     */
    public void setWaterFee(BigDecimal waterFee) {
        this.waterFee = waterFee;
    }

    /**
     * 获取企业已安置残疾人员数
     *
     * @return EntSetDis - 企业已安置残疾人员数
     */
    public Integer getEntSetDis() {
        return entSetDis;
    }

    /**
     * 设置企业已安置残疾人员数
     *
     * @param entSetDis 企业已安置残疾人员数
     */
    public void setEntSetDis(Integer entSetDis) {
        this.entSetDis = entSetDis;
    }

    /**
     * 获取企业应安置残疾人员数
     *
     * @return EntOugthSetDis - 企业应安置残疾人员数
     */
    public Integer getEntOugthSetDis() {
        return entOugthSetDis;
    }

    /**
     * 设置企业应安置残疾人员数
     *
     * @param entOugthSetDis 企业应安置残疾人员数
     */
    public void setEntOugthSetDis(Integer entOugthSetDis) {
        this.entOugthSetDis = entOugthSetDis;
    }

    /**
     * 获取企业法定代表人是否属于：1高校毕业生，2退役士兵，3残疾人，4失业人员再就业，5都不是
     *
     * @return IsLegRep - 企业法定代表人是否属于：1高校毕业生，2退役士兵，3残疾人，4失业人员再就业，5都不是
     */
    public String getIsLegRep() {
        return isLegRep;
    }

    /**
     * 设置企业法定代表人是否属于：1高校毕业生，2退役士兵，3残疾人，4失业人员再就业，5都不是
     *
     * @param isLegRep 企业法定代表人是否属于：1高校毕业生，2退役士兵，3残疾人，4失业人员再就业，5都不是
     */
    public void setIsLegRep(String isLegRep) {
        this.isLegRep = isLegRep;
    }

    /**
     * 获取当年是否依法交纳残保金1：是，0：否
     *
     * @return IsLegPay - 当年是否依法交纳残保金1：是，0：否
     */
    public String getIsLegPay() {
        return isLegPay;
    }

    /**
     * 设置当年是否依法交纳残保金1：是，0：否
     *
     * @param isLegPay 当年是否依法交纳残保金1：是，0：否
     */
    public void setIsLegPay(String isLegPay) {
        this.isLegPay = isLegPay;
    }

    /**
     * 获取当年是否享受减免残保金政策1：是，0：否
     *
     * @return IsMinDis - 当年是否享受减免残保金政策1：是，0：否
     */
    public String getIsMinDis() {
        return isMinDis;
    }

    /**
     * 设置当年是否享受减免残保金政策1：是，0：否
     *
     * @param isMinDis 当年是否享受减免残保金政策1：是，0：否
     */
    public void setIsMinDis(String isMinDis) {
        this.isMinDis = isMinDis;
    }

    /**
     * 获取当年减免地税
     *
     * @return MinLandTax - 当年减免地税
     */
    public BigDecimal getMinLandTax() {
        return minLandTax;
    }

    /**
     * 设置当年减免地税
     *
     * @param minLandTax 当年减免地税
     */
    public void setMinLandTax(BigDecimal minLandTax) {
        this.minLandTax = minLandTax;
    }

    /**
     * 获取当年减免国税
     *
     * @return MinNationTax - 当年减免国税
     */
    public BigDecimal getMinNationTax() {
        return minNationTax;
    }

    /**
     * 设置当年减免国税
     *
     * @param minNationTax 当年减免国税
     */
    public void setMinNationTax(BigDecimal minNationTax) {
        this.minNationTax = minNationTax;
    }

    /**
     * 获取其他
     *
     * @return otherTax - 其他
     */
    public BigDecimal getOtherTax() {
        return otherTax;
    }

    /**
     * 设置其他
     *
     * @param otherTax 其他
     */
    public void setOtherTax(BigDecimal otherTax) {
        this.otherTax = otherTax;
    }

    /**
     * 获取水利基金
     *
     * @return WaterTax - 水利基金
     */
    public BigDecimal getWaterTax() {
        return waterTax;
    }

    /**
     * 设置水利基金
     *
     * @param waterTax 水利基金
     */
    public void setWaterTax(BigDecimal waterTax) {
        this.waterTax = waterTax;
    }

    /**
     * 获取城镇土地使用税
     *
     * @return LanUseTax - 城镇土地使用税
     */
    public BigDecimal getLanUseTax() {
        return lanUseTax;
    }

    /**
     * 设置城镇土地使用税
     *
     * @param lanUseTax 城镇土地使用税
     */
    public void setLanUseTax(BigDecimal lanUseTax) {
        this.lanUseTax = lanUseTax;
    }

    /**
     * 获取房产税
     *
     * @return HouseTax - 房产税
     */
    public BigDecimal getHouseTax() {
        return houseTax;
    }

    /**
     * 设置房产税
     *
     * @param houseTax 房产税
     */
    public void setHouseTax(BigDecimal houseTax) {
        this.houseTax = houseTax;
    }

    /**
     * 获取教育费附加
     *
     * @return TechTax - 教育费附加
     */
    public BigDecimal getTechTax() {
        return techTax;
    }

    /**
     * 设置教育费附加
     *
     * @param techTax 教育费附加
     */
    public void setTechTax(BigDecimal techTax) {
        this.techTax = techTax;
    }

    /**
     * 获取个人所得税
     *
     * @return PersonTax - 个人所得税
     */
    public BigDecimal getPersonTax() {
        return personTax;
    }

    /**
     * 设置个人所得税
     *
     * @param personTax 个人所得税
     */
    public void setPersonTax(BigDecimal personTax) {
        this.personTax = personTax;
    }

    /**
     * 获取关税
     *
     * @return DutyTax - 关税
     */
    public BigDecimal getDutyTax() {
        return dutyTax;
    }

    /**
     * 设置关税
     *
     * @param dutyTax 关税
     */
    public void setDutyTax(BigDecimal dutyTax) {
        this.dutyTax = dutyTax;
    }

    /**
     * 获取企业所得税
     *
     * @return EntTax - 企业所得税
     */
    public BigDecimal getEntTax() {
        return entTax;
    }

    /**
     * 设置企业所得税
     *
     * @param entTax 企业所得税
     */
    public void setEntTax(BigDecimal entTax) {
        this.entTax = entTax;
    }

    /**
     * 获取土地增值税
     *
     * @return LandTax - 土地增值税
     */
    public BigDecimal getLandTax() {
        return landTax;
    }

    /**
     * 设置土地增值税
     *
     * @param landTax 土地增值税
     */
    public void setLandTax(BigDecimal landTax) {
        this.landTax = landTax;
    }

    /**
     * 获取消费税
     *
     * @return ExpenseTax - 消费税
     */
    public BigDecimal getExpenseTax() {
        return expenseTax;
    }

    /**
     * 设置消费税
     *
     * @param expenseTax 消费税
     */
    public void setExpenseTax(BigDecimal expenseTax) {
        this.expenseTax = expenseTax;
    }

    /**
     * 获取印花税
     *
     * @return FloTax - 印花税
     */
    public BigDecimal getFloTax() {
        return floTax;
    }

    /**
     * 设置印花税
     *
     * @param floTax 印花税
     */
    public void setFloTax(BigDecimal floTax) {
        this.floTax = floTax;
    }

    /**
     * 获取营业税
     *
     * @return MngTax - 营业税
     */
    public BigDecimal getMngTax() {
        return mngTax;
    }

    /**
     * 设置营业税
     *
     * @param mngTax 营业税
     */
    public void setMngTax(BigDecimal mngTax) {
        this.mngTax = mngTax;
    }

    /**
     * 获取城市维护建设税
     *
     * @return CityTax - 城市维护建设税
     */
    public BigDecimal getCityTax() {
        return cityTax;
    }

    /**
     * 设置城市维护建设税
     *
     * @param cityTax 城市维护建设税
     */
    public void setCityTax(BigDecimal cityTax) {
        this.cityTax = cityTax;
    }

    /**
     * 获取增值税
     *
     * @return AddTax - 增值税
     */
    public BigDecimal getAddTax() {
        return addTax;
    }

    /**
     * 设置增值税
     *
     * @param addTax 增值税
     */
    public void setAddTax(BigDecimal addTax) {
        this.addTax = addTax;
    }

    /**
     * 获取当年贷款利息支出总额
     *
     * @return PayLoan - 当年贷款利息支出总额
     */
    public BigDecimal getPayLoan() {
        return payLoan;
    }

    /**
     * 设置当年贷款利息支出总额
     *
     * @param payLoan 当年贷款利息支出总额
     */
    public void setPayLoan(BigDecimal payLoan) {
        this.payLoan = payLoan;
    }

    /**
     * 获取截止当年末，从金融机构获得的贷款余额
     *
     * @return EndLoan - 截止当年末，从金融机构获得的贷款余额
     */
    public BigDecimal getEndLoan() {
        return endLoan;
    }

    /**
     * 设置截止当年末，从金融机构获得的贷款余额
     *
     * @param endLoan 截止当年末，从金融机构获得的贷款余额
     */
    public void setEndLoan(BigDecimal endLoan) {
        this.endLoan = endLoan;
    }

    /**
     * 获取当年从小额贷款公司等其他渠道融资总额
     *
     * @return ComLoan - 当年从小额贷款公司等其他渠道融资总额
     */
    public BigDecimal getComLoan() {
        return comLoan;
    }

    /**
     * 设置当年从小额贷款公司等其他渠道融资总额
     *
     * @param comLoan 当年从小额贷款公司等其他渠道融资总额
     */
    public void setComLoan(BigDecimal comLoan) {
        this.comLoan = comLoan;
    }

    /**
     * 获取当年从金融机构获得贷款总额
     *
     * @return FinOrgLoan - 当年从金融机构获得贷款总额
     */
    public BigDecimal getFinOrgLoan() {
        return finOrgLoan;
    }

    /**
     * 设置当年从金融机构获得贷款总额
     *
     * @param finOrgLoan 当年从金融机构获得贷款总额
     */
    public void setFinOrgLoan(BigDecimal finOrgLoan) {
        this.finOrgLoan = finOrgLoan;
    }

    /**
     * 获取当年研究开发、技术改造、科技创新等方面的支出
     *
     * @return IntelGro - 当年研究开发、技术改造、科技创新等方面的支出
     */
    public BigDecimal getIntelGro() {
        return intelGro;
    }

    /**
     * 设置当年研究开发、技术改造、科技创新等方面的支出
     *
     * @param intelGro 当年研究开发、技术改造、科技创新等方面的支出
     */
    public void setIntelGro(BigDecimal intelGro) {
        this.intelGro = intelGro;
    }

    /**
     * 获取当年出口创汇总额
     *
     * @return ExpGro - 当年出口创汇总额
     */
    public BigDecimal getExpGro() {
        return expGro;
    }

    /**
     * 设置当年出口创汇总额
     *
     * @param expGro 当年出口创汇总额
     */
    public void setExpGro(BigDecimal expGro) {
        this.expGro = expGro;
    }

    /**
     * 获取无经营活动收入或歇业的原因
     *
     * @return NoBusRea - 无经营活动收入或歇业的原因
     */
    public String getNoBusRea() {
        return noBusRea;
    }

    /**
     * 设置无经营活动收入或歇业的原因
     *
     * @param noBusRea 无经营活动收入或歇业的原因
     */
    public void setNoBusRea(String noBusRea) {
        this.noBusRea = noBusRea;
    }

    /**
     * 获取经营状态（中文名称）
     *
     * @return BusStatusCN - 经营状态（中文名称）
     */
    public String getBusStatusCN() {
        return busStatusCN;
    }

    /**
     * 设置经营状态（中文名称）
     *
     * @param busStatusCN 经营状态（中文名称）
     */
    public void setBusStatusCN(String busStatusCN) {
        this.busStatusCN = busStatusCN;
    }

    /**
     * 获取从业人数是否公示
     *
     * @return EmpNumDis - 从业人数是否公示
     */
    public String getEmpNumDis() {
        return empNumDis;
    }

    /**
     * 设置从业人数是否公示
     *
     * @param empNumDis 从业人数是否公示
     */
    public void setEmpNumDis(String empNumDis) {
        this.empNumDis = empNumDis;
    }

    /**
     * 获取资产状况ID
     *
     * @return AssetID - 资产状况ID
     */
    public String getAssetID() {
        return assetID;
    }

    /**
     * 设置资产状况ID
     *
     * @param assetID 资产状况ID
     */
    public void setAssetID(String assetID) {
        this.assetID = assetID;
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
     * 获取资产总额是否公示
     *
     * @return AssGroIsPub - 资产总额是否公示
     */
    public String getAssGroIsPub() {
        return assGroIsPub;
    }

    /**
     * 设置资产总额是否公示
     *
     * @param assGroIsPub 资产总额是否公示
     */
    public void setAssGroIsPub(String assGroIsPub) {
        this.assGroIsPub = assGroIsPub;
    }

    /**
     * 获取负债总额是否公示
     *
     * @return LiaGroIsPub - 负债总额是否公示
     */
    public String getLiaGroIsPub() {
        return liaGroIsPub;
    }

    /**
     * 设置负债总额是否公示
     *
     * @param liaGroIsPub 负债总额是否公示
     */
    public void setLiaGroIsPub(String liaGroIsPub) {
        this.liaGroIsPub = liaGroIsPub;
    }

    /**
     * 获取其中主营业务收入是否公示
     *
     * @return MaiBusIncIsPub - 其中主营业务收入是否公示
     */
    public String getMaiBusIncIsPub() {
        return maiBusIncIsPub;
    }

    /**
     * 设置其中主营业务收入是否公示
     *
     * @param maiBusIncIsPub 其中主营业务收入是否公示
     */
    public void setMaiBusIncIsPub(String maiBusIncIsPub) {
        this.maiBusIncIsPub = maiBusIncIsPub;
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
     * 获取净利润是否公示
     *
     * @return NetIncIsPub - 净利润是否公示
     */
    public String getNetIncIsPub() {
        return netIncIsPub;
    }

    /**
     * 设置净利润是否公示
     *
     * @param netIncIsPub 净利润是否公示
     */
    public void setNetIncIsPub(String netIncIsPub) {
        this.netIncIsPub = netIncIsPub;
    }

    /**
     * 获取利润总额是否公示
     *
     * @return ProGroIsPub - 利润总额是否公示
     */
    public String getProGroIsPub() {
        return proGroIsPub;
    }

    /**
     * 设置利润总额是否公示
     *
     * @param proGroIsPub 利润总额是否公示
     */
    public void setProGroIsPub(String proGroIsPub) {
        this.proGroIsPub = proGroIsPub;
    }

    /**
     * 获取所有者权益合计是否公示
     *
     * @return TotEquIsPub - 所有者权益合计是否公示
     */
    public String getTotEquIsPub() {
        return totEquIsPub;
    }

    /**
     * 设置所有者权益合计是否公示
     *
     * @param totEquIsPub 所有者权益合计是否公示
     */
    public void setTotEquIsPub(String totEquIsPub) {
        this.totEquIsPub = totEquIsPub;
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
     * 获取其中残疾人人数(经营者)
     *
     * @return DisOpers - 其中残疾人人数(经营者)
     */
    public Integer getDisOpers() {
        return disOpers;
    }

    /**
     * 设置其中残疾人人数(经营者)
     *
     * @param disOpers 其中残疾人人数(经营者)
     */
    public void setDisOpers(Integer disOpers) {
        this.disOpers = disOpers;
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
     * 获取其中退役士兵人数(经营者)
     *
     * @return ExSoldOpers - 其中退役士兵人数(经营者)
     */
    public Integer getExSoldOpers() {
        return exSoldOpers;
    }

    /**
     * 设置其中退役士兵人数(经营者)
     *
     * @param exSoldOpers 其中退役士兵人数(经营者)
     */
    public void setExSoldOpers(Integer exSoldOpers) {
        this.exSoldOpers = exSoldOpers;
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
     * 获取其中高校毕业生人数(经营者)
     *
     * @return UniGradOpers - 其中高校毕业生人数(经营者)
     */
    public Integer getUniGradOpers() {
        return uniGradOpers;
    }

    /**
     * 设置其中高校毕业生人数(经营者)
     *
     * @param uniGradOpers 其中高校毕业生人数(经营者)
     */
    public void setUniGradOpers(Integer uniGradOpers) {
        this.uniGradOpers = uniGradOpers;
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
     * 获取其中失业人员再就业人数(经营者)
     *
     * @return UnemOpers - 其中失业人员再就业人数(经营者)
     */
    public Integer getUnemOpers() {
        return unemOpers;
    }

    /**
     * 设置其中失业人员再就业人数(经营者)
     *
     * @param unemOpers 其中失业人员再就业人数(经营者)
     */
    public void setUnemOpers(Integer unemOpers) {
        this.unemOpers = unemOpers;
    }

    /**
     * 获取流动负债合计
     *
     * @return TotCurrLiab - 流动负债合计
     */
    public BigDecimal getTotCurrLiab() {
        return totCurrLiab;
    }

    /**
     * 设置流动负债合计
     *
     * @param totCurrLiab 流动负债合计
     */
    public void setTotCurrLiab(BigDecimal totCurrLiab) {
        this.totCurrLiab = totCurrLiab;
    }

    /**
     * 获取其他应付款
     *
     * @return OthPay - 其他应付款
     */
    public BigDecimal getOthPay() {
        return othPay;
    }

    /**
     * 设置其他应付款
     *
     * @param othPay 其他应付款
     */
    public void setOthPay(BigDecimal othPay) {
        this.othPay = othPay;
    }

    /**
     * 获取流动资产合计
     *
     * @return TotCurrAssets - 流动资产合计
     */
    public BigDecimal getTotCurrAssets() {
        return totCurrAssets;
    }

    /**
     * 设置流动资产合计
     *
     * @param totCurrAssets 流动资产合计
     */
    public void setTotCurrAssets(BigDecimal totCurrAssets) {
        this.totCurrAssets = totCurrAssets;
    }

    /**
     * 获取应付账款
     *
     * @return AccPay - 应付账款
     */
    public BigDecimal getAccPay() {
        return accPay;
    }

    /**
     * 设置应付账款
     *
     * @param accPay 应付账款
     */
    public void setAccPay(BigDecimal accPay) {
        this.accPay = accPay;
    }

    /**
     * 获取存货
     *
     * @return Inventory - 存货
     */
    public BigDecimal getInventory() {
        return inventory;
    }

    /**
     * 设置存货
     *
     * @param inventory 存货
     */
    public void setInventory(BigDecimal inventory) {
        this.inventory = inventory;
    }

    /**
     * 获取无形资产
     *
     * @return IntAssets - 无形资产
     */
    public BigDecimal getIntAssets() {
        return intAssets;
    }

    /**
     * 设置无形资产
     *
     * @param intAssets 无形资产
     */
    public void setIntAssets(BigDecimal intAssets) {
        this.intAssets = intAssets;
    }

    /**
     * 获取其他应收款
     *
     * @return OthAccRec - 其他应收款
     */
    public BigDecimal getOthAccRec() {
        return othAccRec;
    }

    /**
     * 设置其他应收款
     *
     * @param othAccRec 其他应收款
     */
    public void setOthAccRec(BigDecimal othAccRec) {
        this.othAccRec = othAccRec;
    }

    /**
     * 获取固定资产
     *
     * @return FixAssets - 固定资产
     */
    public BigDecimal getFixAssets() {
        return fixAssets;
    }

    /**
     * 设置固定资产
     *
     * @param fixAssets 固定资产
     */
    public void setFixAssets(BigDecimal fixAssets) {
        this.fixAssets = fixAssets;
    }

    /**
     * 获取应收账款
     *
     * @return AccRec - 应收账款
     */
    public BigDecimal getAccRec() {
        return accRec;
    }

    /**
     * 设置应收账款
     *
     * @param accRec 应收账款
     */
    public void setAccRec(BigDecimal accRec) {
        this.accRec = accRec;
    }

    /**
     * 获取长期投资
     *
     * @return LongInvest - 长期投资
     */
    public BigDecimal getLongInvest() {
        return longInvest;
    }

    /**
     * 设置长期投资
     *
     * @param longInvest 长期投资
     */
    public void setLongInvest(BigDecimal longInvest) {
        this.longInvest = longInvest;
    }

    /**
     * 获取货币资金
     *
     * @return MoneFunds - 货币资金
     */
    public BigDecimal getMoneFunds() {
        return moneFunds;
    }

    /**
     * 设置货币资金
     *
     * @param moneFunds 货币资金
     */
    public void setMoneFunds(BigDecimal moneFunds) {
        this.moneFunds = moneFunds;
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
     * 获取实收资本
     *
     * @return MoneFunds - 实收资本
     */
    public BigDecimal getRecCap() {
        return recCap;
    }
    /**
     * 设置实收资本
     *
     * @param recCap 实收资本
     */
    public void setRecCap(BigDecimal recCap) {
        this.recCap = recCap;
    }


    /**
     * 获取 企业主营业务活动
     * @return
     */
    public String getEntMainBusActivity() {
        return entMainBusActivity;
    }

    /**
     * 设置 企业主营业务活动
     * @param entMainBusActivity
     */
    public void setEntMainBusActivity(String entMainBusActivity) {
        this.entMainBusActivity = entMainBusActivity;
    }

    /**
     * 获取 企业控股情况
     * @return
     */
    public String getEntControl() {
        return entControl;
    }

    /**
     * 设置 企业控股情况
     * @param entControl
     */
    public void setEntControl(String entControl) {
        this.entControl = entControl;
    }

    /**
     * 获取 企业控股情况是否公示
     * @return
     */
    public String getEntControlIsPub() {
        return entControlIsPub;
    }

    /**
     * 设置 企业控股情况是否公示
     * @param entControlIsPub
     */
    public void setEntControlIsPub(String entControlIsPub) {
        this.entControlIsPub = entControlIsPub;
    }
    /**
     * 获取 其中女性从业人数
     * @return
     */
    public Integer getFemaleEmploye() {
        return femaleEmploye;
    }

    /**
     * 设置 其中女性从业人数
     * @param femaleEmploye
     */
    public void setFemaleEmploye(Integer femaleEmploye) {
        this.femaleEmploye = femaleEmploye;
    }

    /**
     * 获取 其中女性从业人数是否公示
     * @return
     */
    public String getFemaleEmployeIsPub() {
        return femaleEmployeIsPub;
    }

    /**
     * 设置 其中女性从业人数是否公示
     * @param femaleEmployeIsPub
     */
    public void setFemaleEmployeIsPub(String femaleEmployeIsPub) {
        this.femaleEmployeIsPub = femaleEmployeIsPub;
    }
}