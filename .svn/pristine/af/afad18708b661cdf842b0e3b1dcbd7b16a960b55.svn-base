/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.yr.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 描述:    cs_baseinfo 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2016年09月09日
 */
@Table(name = "cs_baseinfo")
public class BaseInfo implements Serializable {
    /**
     * 主键ID
     */
    @Id
    @Column(name = "id")
    private Integer id;

    /**
     * 主体代码
     */
    @Column(name = "PriPID")
    private String priPID;

    /**
     * 企业名称
     */
    @Column(name = "EntName")
    private String entName;

    /**
     * 注册号
     */
    @Column(name = "RegNO")
    private String regNO;

    /**
     * 法定代表人
     */
    @Column(name = "LeRep")
    private String leRep;

    /**
     * 企业类型
     */
    @Column(name = "EntType")
    private String entType;

    /**
     * 统一社会信用代码
     */
    @Column(name = "UniCode")
    private String uniCode;

    /**
     * 时间戳
     */
    @Column(name = "CreateTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8") 
    private Date createTime;

    /**
     * 法定代表人手机号
     */
    @Column(name = "LeRepPhone")
    private String leRepPhone;

    /**
     * 从业人数
     */
    @Column(name = "EmpNum")
    private Integer empNum;

    /**
     * 企业通信地址
     */
    @Column(name = "Addr")
    private String addr;

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
     * 邮政编码
     */
    @Column(name = "PostalCode")
    private String postalCode;

    /**
     * 营业总收入是否公示
     */
    @Column(name = "VendIncIsPub")
    private String vendIncIsPub;

    /**
     * 从业人员中属于残疾人
     */
    @Column(name = "DisableMgr")
    private Integer disableMgr;

    /**
     * 企业联系电话
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
     * 资产总额/资金数额 - 单位：元
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
     * 盈余总额
     */
    @Column(name = "MaiBusInc")
    private BigDecimal maiBusInc;

    /**
     * 所有者权益合计
     */
    @Column(name = "TotEqu")
    private BigDecimal totEqu;

    /**
     * 残疾人员数
     */
    @Column(name = "EntSetDis")
    private Integer entSetDis;

    /**
     * 企业应安置残疾人员数
     */
    @Column(name = "EntOugthSetDis")
    private Integer entOugthSetDis;

    /**
     * 是否依法交纳残保金1：是，0：否
     */
    @Column(name = "IsLegPay")
    private String isLegPay;

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
     * 企业年报类别
     */
    @Column(name = "AnType")
    private String anType;

    /**
     * 年报ID
     */
    @Column(name = "AnCheID")
    private String anCheID;

    /**
     * 党组织建制（中文名称）
     */
    @Column(name = "ParInsCN")
    private String parInsCN;

    /**
     * 隶属企业名称
     */
    @Column(name = "SupEntname")
    private String supEntname;

    /**
     * 最后一次修改时间
     */
    @Column(name = "LastReportTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8") 
    private Date lastReportTime;

    /**
     * 年报时间
     */
    @Column(name = "AncheDate")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8") 
    private Date ancheDate;

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
     * 法定代表人是否党员
     */
    @Column(name = "ResParMSign")
    private String resParMSign;

    /**
     * 经营者是否党组织书记
     */
    @Column(name = "ResParSecSign")
    private String resParSecSign;

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
     * 敏感词审核结果 0-不通过 1-通过
     */
    @Column(name = "AuditState")
    private String auditState;
    
    /**
     * 审核意见
     */
    @Column(name = "AuditOpinion")
    private String auditOpinion;
    
    /**
     * 审核人姓名
     */
    @Column(name = "AuditUser")
    private String auditUser;
    
    /**
     * 审核时间
     */
    @Column(name = "AuditDate")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date auditDate;
    
    
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
    
    /**
     *隶属企业统一代码注册号
     */
    @Column(name = "SupRegNO")
    private String supRegNO;
    
    /**
     * 城镇职工基本养老保险人数
     */
    @Column(name = "EndowmentNum")
    private Integer endowmentNum;

    /**
     * 失业保险人数
     */
    @Column(name = "UnemploymentNum")
    private Integer unemploymentNum;

    /**
     * 医疗保险人数
     */
    @Column(name = "MedicalNum")
    private Integer medicalNum;

    /**
     * 工伤保险人数
     */
    @Column(name = "EmpInjuryNum")
    private Integer empInjuryNum;

    /**
     * 生育保险人数
     */
    @Column(name = "MaternityNum")
    private Integer maternityNum;

    /**
     * 单位缴费基数
     */
    @Column(name = "PaymentBase")
    private BigDecimal paymentBase;

    /**
     * 单位缴费基数是否公示
     */
    @Column(name = "PaymentBaseIsPub")
    private String paymentBaseIsPub;

    /**
     * 本期实际缴费金额
     */
    @Column(name = "ActualPayment")
    private BigDecimal actualPayment;

    /**
     * 本期实际缴费金额是否公示
     */
    @Column(name = "ActualPaymentIsPub")
    private String actualPaymentIsPub;

    /**
     * 单位累计欠缴金额
     */
    @Column(name = "CumulArrears")
    private BigDecimal cumulArrears;

    /**
     * 单位累计欠缴金额是否公示
     */
    @Column(name = "CumulArrearsIsPub")
    private String cumulArrearsIsPub;

    /**
     * 单位缴费基数-城镇职工基本养老保险
     */
    @Column(name = "PaymentEndowment")
    private BigDecimal paymentEndowment;

    /**
     * 单位缴费基数-失业保险
     */
    @Column(name = "PaymentUnemployment")
    private BigDecimal paymentUnemployment;

    /**
     * 单位缴费基数-医疗保险
     */
    @Column(name = "PaymentMedical")
    private BigDecimal paymentMedical;

    /**
     * 单位缴费基数-工伤保险
     */
    @Column(name = "PaymentEmpInjury")
    private BigDecimal paymentEmpInjury;

    /**
     * 单位缴费基数-生育保险
     */
    @Column(name = "PaymentMaternity")
    private BigDecimal paymentMaternity;

    /**
     * 本期实际缴费金额-城镇职工基本养老保险
     */
    @Column(name = "ActualPayEndowment")
    private BigDecimal actualPayEndowment;

    /**
     * 本期实际缴费金额-失业保险
     */
    @Column(name = "ActualPayUnemployment")
    private BigDecimal actualPayUnemployment;

    /**
     * 本期实际缴费金额-医疗保险
     */
    @Column(name = "ActualPayMedical")
    private BigDecimal actualPayMedical;

    /**
     * 本期实际缴费金额-工伤保险
     */
    @Column(name = "ActualPayEmpInjury")
    private BigDecimal actualPayEmpInjury;

    /**
     * 本期实际缴费金额-生育保险
     */
    @Column(name = "ActualPayMaternity")
    private BigDecimal actualPayMaternity;

    /**
     * 单位累计欠缴金额-城镇职工基本养老保险
     */
    @Column(name = "CumuEndowment")
    private BigDecimal cumuEndowment;

    /**
     * 单位累计欠缴金额-失业保险
     */
    @Column(name = "CumuUnemployment")
    private BigDecimal cumuUnemployment;

    /**
     * 单位累计欠缴金额-医疗保险
     */
    @Column(name = "CumuMedical")
    private BigDecimal cumuMedical;

    /**
     * 单位累计欠缴金额-工伤保险
     */
    @Column(name = "CumuEmpInjury")
    private BigDecimal cumuEmpInjury;

    /**
     * 单位累计欠缴金额-生育保险
     */
    @Column(name = "CumuMaternity")
    private BigDecimal cumuMaternity;

    private static final long serialVersionUID = 1L;

    /**
     * 获取主键ID
     *
     * @return id - 主键ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置主键ID
     *
     * @param id 主键ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取主体代码
     *
     * @return PriPID - 主体代码
     */
    public String getPriPID() {
        return priPID;
    }

    /**
     * 设置主体代码
     *
     * @param priPID 主体代码
     */
    public void setPriPID(String priPID) {
        this.priPID = priPID;
    }

    /**
     * 获取企业名称
     *
     * @return EntName - 企业名称
     */
    public String getEntName() {
        return entName;
    }

    /**
     * 设置企业名称
     *
     * @param entName 企业名称
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
     * 获取法定代表人手机号
     *
     * @return LeRepPhone - 法定代表人手机号
     */
    public String getLeRepPhone() {
        return leRepPhone;
    }

    /**
     * 设置法定代表人手机号
     *
     * @param leRepPhone 法定代表人手机号
     */
    public void setLeRepPhone(String leRepPhone) {
        this.leRepPhone = leRepPhone;
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

    /**
     * 获取从业人员中属于残疾人
     *
     * @return DisableMgr - 从业人员中属于残疾人
     */
    public Integer getDisableMgr() {
        return disableMgr;
    }

    /**
     * 设置从业人员中属于残疾人
     *
     * @param disableMgr 从业人员中属于残疾人
     */
    public void setDisableMgr(Integer disableMgr) {
        this.disableMgr = disableMgr;
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
     * 获取资产总额/资金数额 - 单位：元
     *
     * @return AssGro - 资产总额/资金数额 - 单位：元
     */
    public BigDecimal getAssGro() {
        return assGro;
    }

    /**
     * 设置资产总额/资金数额 - 单位：元
     *
     * @param assGro 资产总额/资金数额 - 单位：元
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
     * 获取盈余总额
     *
     * @return MaiBusInc - 盈余总额
     */
    public BigDecimal getMaiBusInc() {
        return maiBusInc;
    }

    /**
     * 设置盈余总额
     *
     * @param maiBusInc 盈余总额
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
     * 获取残疾人员数
     *
     * @return EntSetDis - 残疾人员数
     */
    public Integer getEntSetDis() {
        return entSetDis;
    }

    /**
     * 设置残疾人员数
     *
     * @param entSetDis 残疾人员数
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
     * 获取是否依法交纳残保金1：是，0：否
     *
     * @return IsLegPay - 是否依法交纳残保金1：是，0：否
     */
    public String getIsLegPay() {
        return isLegPay;
    }

    /**
     * 设置是否依法交纳残保金1：是，0：否
     *
     * @param isLegPay 是否依法交纳残保金1：是，0：否
     */
    public void setIsLegPay(String isLegPay) {
        this.isLegPay = isLegPay;
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
     * 获取企业年报类别
     *
     * @return AnType - 企业年报类别
     */
    public String getAnType() {
        return anType;
    }

    /**
     * 设置企业年报类别
     *
     * @param anType 企业年报类别
     */
    public void setAnType(String anType) {
        this.anType = anType;
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
     * 获取最后一次修改时间
     *
     * @return LastReportTime - 最后一次修改时间
     */
    public Date getLastReportTime() {
        return lastReportTime;
    }

    /**
     * 设置最后一次修改时间
     *
     * @param lastReportTime 最后一次修改时间
     */
    public void setLastReportTime(Date lastReportTime) {
        this.lastReportTime = lastReportTime;
    }

    /**
     * 获取年报时间
     *
     * @return AncheDate - 年报时间
     */
    public Date getAncheDate() {
        return ancheDate;
    }

    /**
     * 设置年报时间
     *
     * @param ancheDate 年报时间
     */
    public void setAncheDate(Date ancheDate) {
        this.ancheDate = ancheDate;
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
    
    
    
	public String getAuditState() {
		return auditState;
	}

	public void setAuditState(String auditState) {
		this.auditState = auditState;
	}

	public String getAuditOpinion() {
		return auditOpinion;
	}

	public void setAuditOpinion(String auditOpinion) {
		this.auditOpinion = auditOpinion;
	}

	public String getAuditUser() {
		return auditUser;
	}

	public void setAuditUser(String auditUser) {
		this.auditUser = auditUser;
	}

	public Date getAuditDate() {
		return auditDate;
	}

	public void setAuditDate(Date auditDate) {
		this.auditDate = auditDate;
	}
	
	public Integer getEndowmentNum() {
		return endowmentNum;
	}

	public void setEndowmentNum(Integer endowmentNum) {
		this.endowmentNum = endowmentNum;
	}

	public Integer getUnemploymentNum() {
		return unemploymentNum;
	}

	public void setUnemploymentNum(Integer unemploymentNum) {
		this.unemploymentNum = unemploymentNum;
	}

	public Integer getMedicalNum() {
		return medicalNum;
	}

	public void setMedicalNum(Integer medicalNum) {
		this.medicalNum = medicalNum;
	}

	public Integer getEmpInjuryNum() {
		return empInjuryNum;
	}

	public void setEmpInjuryNum(Integer empInjuryNum) {
		this.empInjuryNum = empInjuryNum;
	}

	public Integer getMaternityNum() {
		return maternityNum;
	}

	public void setMaternityNum(Integer maternityNum) {
		this.maternityNum = maternityNum;
	}

	public BigDecimal getPaymentBase() {
		return paymentBase;
	}

	public void setPaymentBase(BigDecimal paymentBase) {
		this.paymentBase = paymentBase;
	}

	public String getPaymentBaseIsPub() {
		return paymentBaseIsPub;
	}

	public void setPaymentBaseIsPub(String paymentBaseIsPub) {
		this.paymentBaseIsPub = paymentBaseIsPub;
	}

	public BigDecimal getActualPayment() {
		return actualPayment;
	}

	public void setActualPayment(BigDecimal actualPayment) {
		this.actualPayment = actualPayment;
	}

	public String getActualPaymentIsPub() {
		return actualPaymentIsPub;
	}

	public void setActualPaymentIsPub(String actualPaymentIsPub) {
		this.actualPaymentIsPub = actualPaymentIsPub;
	}

	public BigDecimal getCumulArrears() {
		return cumulArrears;
	}

	public void setCumulArrears(BigDecimal cumulArrears) {
		this.cumulArrears = cumulArrears;
	}

	public String getCumulArrearsIsPub() {
		return cumulArrearsIsPub;
	}

	public void setCumulArrearsIsPub(String cumulArrearsIsPub) {
		this.cumulArrearsIsPub = cumulArrearsIsPub;
	}
	
	public String getEntMainBusActivity() {
		return entMainBusActivity;
	}

	public void setEntMainBusActivity(String entMainBusActivity) {
		this.entMainBusActivity = entMainBusActivity;
	}

	public String getEntControl() {
		return entControl;
	}

	public void setEntControl(String entControl) {
		this.entControl = entControl;
	}

	public String getEntControlIsPub() {
		return entControlIsPub;
	}

	public void setEntControlIsPub(String entControlIsPub) {
		this.entControlIsPub = entControlIsPub;
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

	public String getSupRegNO() {
		return supRegNO;
	}

	public void setSupRegNO(String supRegNO) {
		this.supRegNO = supRegNO;
	}

	/** 
	 * 描述: 公示敏感词校验字符串
	 * @auther ZhouYan
	 * @date 2016年9月14日 
	 * @return 
	 */
	public String getPubForbidInfo() {
		return "企业基本信息 [企业通信地址（其他情况报表）=" + addr + ", 企业电子邮箱（其他情况报表）=" + email + ", 企业主营业务活动（资产状况报表）=" + entMainBusActivity + "]";
	}
	
	/** 
	 * 描述: 公示敏感词校验字符串（分支机构）
	 * @auther ZhouYan
	 * @date 2016年9月14日 
	 * @return 
	 */
	public String getPubForbidInfoBranch() {
		return "企业基本信息 [企业通信地址（其他情况报表）=" + addr + ", 企业电子邮箱（其他情况报表）=" + email + "隶属关系(其他情况表) =" + supEntname + ", 企业主营业务活动（经营情况报表）=" + entMainBusActivity + "]";
	}

	public BigDecimal getPaymentEndowment() {
		return paymentEndowment;
	}

	public void setPaymentEndowment(BigDecimal paymentEndowment) {
		this.paymentEndowment = paymentEndowment;
	}

	public BigDecimal getPaymentUnemployment() {
		return paymentUnemployment;
	}

	public void setPaymentUnemployment(BigDecimal paymentUnemployment) {
		this.paymentUnemployment = paymentUnemployment;
	}

	public BigDecimal getPaymentMedical() {
		return paymentMedical;
	}

	public void setPaymentMedical(BigDecimal paymentMedical) {
		this.paymentMedical = paymentMedical;
	}

	public BigDecimal getPaymentEmpInjury() {
		return paymentEmpInjury;
	}

	public void setPaymentEmpInjury(BigDecimal paymentEmpInjury) {
		this.paymentEmpInjury = paymentEmpInjury;
	}

	public BigDecimal getPaymentMaternity() {
		return paymentMaternity;
	}

	public void setPaymentMaternity(BigDecimal paymentMaternity) {
		this.paymentMaternity = paymentMaternity;
	}

	public BigDecimal getActualPayEndowment() {
		return actualPayEndowment;
	}

	public void setActualPayEndowment(BigDecimal actualPayEndowment) {
		this.actualPayEndowment = actualPayEndowment;
	}

	public BigDecimal getActualPayUnemployment() {
		return actualPayUnemployment;
	}

	public void setActualPayUnemployment(BigDecimal actualPayUnemployment) {
		this.actualPayUnemployment = actualPayUnemployment;
	}

	public BigDecimal getActualPayMedical() {
		return actualPayMedical;
	}

	public void setActualPayMedical(BigDecimal actualPayMedical) {
		this.actualPayMedical = actualPayMedical;
	}

	public BigDecimal getActualPayEmpInjury() {
		return actualPayEmpInjury;
	}

	public void setActualPayEmpInjury(BigDecimal actualPayEmpInjury) {
		this.actualPayEmpInjury = actualPayEmpInjury;
	}

	public BigDecimal getActualPayMaternity() {
		return actualPayMaternity;
	}

	public void setActualPayMaternity(BigDecimal actualPayMaternity) {
		this.actualPayMaternity = actualPayMaternity;
	}

	public BigDecimal getCumuEndowment() {
		return cumuEndowment;
	}

	public void setCumuEndowment(BigDecimal cumuEndowment) {
		this.cumuEndowment = cumuEndowment;
	}

	public BigDecimal getCumuUnemployment() {
		return cumuUnemployment;
	}

	public void setCumuUnemployment(BigDecimal cumuUnemployment) {
		this.cumuUnemployment = cumuUnemployment;
	}

	public BigDecimal getCumuMedical() {
		return cumuMedical;
	}

	public void setCumuMedical(BigDecimal cumuMedical) {
		this.cumuMedical = cumuMedical;
	}

	public BigDecimal getCumuEmpInjury() {
		return cumuEmpInjury;
	}

	public void setCumuEmpInjury(BigDecimal cumuEmpInjury) {
		this.cumuEmpInjury = cumuEmpInjury;
	}

	public BigDecimal getCumuMaternity() {
		return cumuMaternity;
	}

	public void setCumuMaternity(BigDecimal cumuMaternity) {
		this.cumuMaternity = cumuMaternity;
	}
}