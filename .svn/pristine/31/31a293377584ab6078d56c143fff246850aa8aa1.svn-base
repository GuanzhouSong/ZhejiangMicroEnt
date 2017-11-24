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
 * 描述:    cs_sfc_baseinfo 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2016年10月08日
 */
@Table(name = "cs_sfc_baseinfo")
public class SfcBaseInfo implements Serializable {
    /**
     * 自增主键ID
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
     * 合作社名称
     */
    @Column(name = "FarSpeArtName")
    private String farSpeArtName;
    
    /**
     * 住所
     */
    @Column(name = "Dom")
    private String dom;

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
    private Date createTime;

    /**
     * 年报ID
     */
    @Column(name = "AnCheID")
    private String anCheID;


    /**
     * 注册号
     */
    @Column(name = "RegNO")
    private String regNO;

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
     * 统一社会信用代码
     */
    @Column(name = "UniCode")
    private String uniCode;

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
     * 最新年报时间
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

	/**
     * 获取自增主键ID
     *
     * @return id - 自增主键ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置自增主键ID
     *
     * @param id 自增主键ID
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
     * 获取合作社名称
     *
     * @return FarSpeArtName - 合作社名称
     */
    public String getFarSpeArtName() {
        return farSpeArtName;
    }

    /**
     * 设置合作社名称
     *
     * @param farSpeArtName 合作社名称
     */
    public void setFarSpeArtName(String farSpeArtName) {
        this.farSpeArtName = farSpeArtName;
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
     * 获取最新年报时间
     *
     * @return LastReportTime - 最新年报时间
     */
    public Date getLastReportTime() {
        return lastReportTime;
    }

    /**
     * 设置最新年报时间
     *
     * @param lastReportTime 最新年报时间
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

	/** 
	 * 描述: 公示敏感词校验字符串
	 * @auther ZhouYan
	 * @date 2016年9月14日 
	 * @return 
	 */
	public String getPubForbidInfo() {
		return "企业基本信息 [合作社名称（基本信息表）=" + farSpeArtName + ", 电子邮箱（基本信息表）=" + email + "]";
	}
}