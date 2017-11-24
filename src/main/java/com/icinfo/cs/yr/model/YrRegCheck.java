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
import com.icinfo.cs.common.constant.ReportStatusEnum;

/**
 * 描述:    cs_yr_reg_check 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2016年08月28日
 */
@Table(name = "cs_yr_reg_check")
public class YrRegCheck implements Serializable {
    @Id
    @Column(name = "id")
    private Integer id;

    /**
     * 主体身份代码
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
     * 注册资本
     */
    @Column(name = "RegCap")
    private BigDecimal regCap;

    /**
     * 币种
     */
    @Column(name = "Currency")
    private String currency;

    /**
     * 企业类型
     */
    @Column(name = "EntType")
    private String entType;

    /**
     * 成立日期
     */
    @Column(name = "EstDate")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date estDate;

    /**
     * 行业
     */
    @Column(name = "IndustryCo")
    private String industryCo;

    /**
     * 登记机关
     */
    @Column(name = "RegOrg")
    private String regOrg;

    /**
     * 管辖单位
     */
    @Column(name = "LocalAdm")
    private String localAdm;

    /**
     * 状态
     */
    @Column(name = "RegState")
    private String regState;

    /**
     * 邮政编码
     */
    @Column(name = "PostalCode")
    private String postalCode;

    /**
     * 企业类型大类
     */
    @Column(name = "EntTypeCatg")
    private String entTypeCatg;

    /**
     * 统一社会信用代码
     */
    @Column(name = "UniCode")
    private String uniCode;

    /**
     * 首次报告时间
     */
    @Column(name = "FirstReportTime")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date firstReportTime;

    /**
     * 电话
     */
    @Column(name = "Tel")
    private String tel;

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
     * 年检部门
     */
    @Column(name = "CheckDep")
    private String checkDep;

    /**
     * 综合信息金融审核人账号
     */
    @Column(name = "CheckNameBank")
    private String checkNameBank;

    /**
     * 签字（金融）
     */
    @Column(name = "SignBank")
    private String signBank;

    /**
     * 签字日期（工商）
     */
    @Column(name = "SignDateBur")
    private Date signDateBur;

    /**
     * 综合信息工商审核人账号
     */
    @Column(name = "CheckNameBur")
    private String checkNameBur;

    /**
     * 签字（工商）
     */
    @Column(name = "SignBur")
    private String signBur;

    /**
     * 签字日期（农业）
     */
    @Column(name = "SignDateSfc")
    private Date signDateSfc;

    /**
     * 综合信息农业审核人账号
     */
    @Column(name = "CheckNameSfc")
    private String checkNameSfc;

    /**
     * 审核人签字（农业）
     */
    @Column(name = "SignSfc")
    private String signSfc;

    /**
     * 综合信息填表状态0:未申报 1:申报待核2:已核实 3已退回 4申请修改成功
     */
    @Column(name = "DeclStatus")
    private String declStatus;

    /**
     * 接收日期
     */
    @Column(name = "AcceptDate")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date acceptDate;

    /**
     * 接收人姓名
     */
    @Column(name = "AcceptName")
    private String acceptName;

    /**
     * 接收人帐号
     */
    @Column(name = "AcceptUser")
    private String acceptUser;

    /**
     * 签字日期（金融）
     */
    @Column(name = "SignBankDate")
    private Date signBankDate;

    /**
     * 获取年报公示状态（当前年报状态）：
     * 00未公示[未公示]；
     * 10已公示[已公示]；
     * 11已公示[敏感词通过]；
     * 12已公示（内容待审核）[敏感词待审核]；
     * 13已公示（内容审核不通过）[敏感词不通过]；
     * 20待修改[待修改]
     */
    @Column(name = "ReportState")
    private String reportState;

    /**
     * 提交方IP地址
     */
    @Column(name = "SubIp")
    private String subIp;

    /**
     * 报表类型
     */
    @Column(name = "RepType")
    private String repType;

    /**
     * 年度年报状态：0未年报；1已年报；2已年报（逾期）
     */
    @Column(name = "IsReported")
    private String isReported;

    /**
     * 最近报告时间
     */
    @Column(name = "LastReportTime")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date lastReportTime;

    /**
     * 报送登录方式1：证书 ，2：用户名，3：临时证书，4：大厅终端，5：政务服务网证书登录
     */
    @Column(name = "ReportType")
    private String reportType;

    /**
     * 锁定状态：1已锁定；0未锁定；
     */
    @Column(name = "LockState")
    private String lockState;

    /**
     * 解锁设置人
     */
    @Column(name = "Setter")
    private String setter;

    /**
     * 解锁日期
     */
    @Column(name = "SetDate")
    private Date setDate;

    /**
     * 管理片号
     */
    @Column(name = "SliceNo")
    private String sliceNo;



    /**
     * 意见（金融）
     */
    @Column(name = "CheckOpinBank")
    private String checkOpinBank;

    /**
     * 审查意见（工商）
     */
    @Column(name = "CheckOpinBur")
    private String checkOpinBur;

    /**
     * 审查意见（农业）
     */
    @Column(name = "CheckOpinSfc")
    private String checkOpinSfc;

    /**
     * 接收部门
     */
    @Column(name = "AcceptDept")
    private String acceptDept;

    /**
     * 解锁原因
     */
    @Column(name = "UnlockReason")
    private String unlockReason;
    
    
    /**
     * 是否涉及过敏感词:0否1是
     */
    @Column(name = "IsForbidWord")
    private String isForbidWord;
    
    //修改次数
    @Column(name = "ModifyCount")
    private Integer modifyCount;
    
    
    //纸质年报补录状态
    @Column(name = "AddRecState")
    private String addRecState;
    
    /**
     * 补录日期
     */
    @Column(name = "AddRecDate")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date addRecDate;

    /**
     * 补录部门
     */
    @Column(name = "AddRecDept")
    private String addRecDept;

    /**
     * 补录人
     */
    @Column(name = "AddRecUser")
    private String addRecUser;

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
     * 获取行业
     *
     * @return IndustryCo - 行业
     */
    public String getIndustryCo() {
        return industryCo;
    }

    /**
     * 设置行业
     *
     * @param industryCo 行业
     */
    public void setIndustryCo(String industryCo) {
        this.industryCo = industryCo;
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
     * 获取状态
     *
     * @return RegState - 状态
     */
    public String getRegState() {
        return regState;
    }

    /**
     * 设置状态
     *
     * @param regState 状态
     */
    public void setRegState(String regState) {
        this.regState = regState;
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
     * 获取企业类型大类
     *
     * @return EntTypeCatg - 企业类型大类
     */
    public String getEntTypeCatg() {
        return entTypeCatg;
    }

    /**
     * 设置企业类型大类
     *
     * @param entTypeCatg 企业类型大类
     */
    public void setEntTypeCatg(String entTypeCatg) {
        this.entTypeCatg = entTypeCatg;
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
     * 获取首次报告时间
     *
     * @return FirstReportTime - 首次报告时间
     */
    public Date getFirstReportTime() {
        return firstReportTime;
    }

    /**
     * 设置首次报告时间
     *
     * @param firstReportTime 首次报告时间
     */
    public void setFirstReportTime(Date firstReportTime) {
        this.firstReportTime = firstReportTime;
    }

    /**
     * 获取电话
     *
     * @return Tel - 电话
     */
    public String getTel() {
        return tel;
    }

    /**
     * 设置电话
     *
     * @param tel 电话
     */
    public void setTel(String tel) {
        this.tel = tel;
    }

   

    public Integer getYear() {
		return year;
	}

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
     * 获取年检部门
     *
     * @return CheckDep - 年检部门
     */
    public String getCheckDep() {
        return checkDep;
    }

    /**
     * 设置年检部门
     *
     * @param checkDep 年检部门
     */
    public void setCheckDep(String checkDep) {
        this.checkDep = checkDep;
    }

    /**
     * 获取综合信息金融审核人账号
     *
     * @return CheckNameBank - 综合信息金融审核人账号
     */
    public String getCheckNameBank() {
        return checkNameBank;
    }

    /**
     * 设置综合信息金融审核人账号
     *
     * @param checkNameBank 综合信息金融审核人账号
     */
    public void setCheckNameBank(String checkNameBank) {
        this.checkNameBank = checkNameBank;
    }

    /**
     * 获取签字（金融）
     *
     * @return SignBank - 签字（金融）
     */
    public String getSignBank() {
        return signBank;
    }

    /**
     * 设置签字（金融）
     *
     * @param signBank 签字（金融）
     */
    public void setSignBank(String signBank) {
        this.signBank = signBank;
    }

    /**
     * 获取签字日期（工商）
     *
     * @return SignDateBur - 签字日期（工商）
     */
    public Date getSignDateBur() {
        return signDateBur;
    }

    /**
     * 设置签字日期（工商）
     *
     * @param signDateBur 签字日期（工商）
     */
    public void setSignDateBur(Date signDateBur) {
        this.signDateBur = signDateBur;
    }

    /**
     * 获取综合信息工商审核人账号
     *
     * @return CheckNameBur - 综合信息工商审核人账号
     */
    public String getCheckNameBur() {
        return checkNameBur;
    }

    /**
     * 设置综合信息工商审核人账号
     *
     * @param checkNameBur 综合信息工商审核人账号
     */
    public void setCheckNameBur(String checkNameBur) {
        this.checkNameBur = checkNameBur;
    }

    /**
     * 获取签字（工商）
     *
     * @return SignBur - 签字（工商）
     */
    public String getSignBur() {
        return signBur;
    }

    /**
     * 设置签字（工商）
     *
     * @param signBur 签字（工商）
     */
    public void setSignBur(String signBur) {
        this.signBur = signBur;
    }

    /**
     * 获取签字日期（农业）
     *
     * @return SignDateSfc - 签字日期（农业）
     */
    public Date getSignDateSfc() {
        return signDateSfc;
    }

    /**
     * 设置签字日期（农业）
     *
     * @param signDateSfc 签字日期（农业）
     */
    public void setSignDateSfc(Date signDateSfc) {
        this.signDateSfc = signDateSfc;
    }

    /**
     * 获取综合信息农业审核人账号
     *
     * @return CheckNameSfc - 综合信息农业审核人账号
     */
    public String getCheckNameSfc() {
        return checkNameSfc;
    }

    /**
     * 设置综合信息农业审核人账号
     *
     * @param checkNameSfc 综合信息农业审核人账号
     */
    public void setCheckNameSfc(String checkNameSfc) {
        this.checkNameSfc = checkNameSfc;
    }

    /**
     * 获取审核人签字（农业）
     *
     * @return SignSfc - 审核人签字（农业）
     */
    public String getSignSfc() {
        return signSfc;
    }

    /**
     * 设置审核人签字（农业）
     *
     * @param signSfc 审核人签字（农业）
     */
    public void setSignSfc(String signSfc) {
        this.signSfc = signSfc;
    }

    /**
     * 获取综合信息填表状态0:未申报 1:申报待核2:已核实 3已退回 4申请修改成功
     *
     * @return DeclStatus - 综合信息填表状态0:未申报 1:申报待核2:已核实 3已退回 4申请修改成功
     */
    public String getDeclStatus() {
        return declStatus;
    }

    /**
     * 设置综合信息填表状态0:未申报 1:申报待核2:已核实 3已退回 4申请修改成功
     *
     * @param declStatus 综合信息填表状态0:未申报 1:申报待核2:已核实 3已退回 4申请修改成功
     */
    public void setDeclStatus(String declStatus) {
        this.declStatus = declStatus;
    }

    /**
     * 获取接收日期
     *
     * @return AcceptDate - 接收日期
     */
    public Date getAcceptDate() {
        return acceptDate;
    }

    /**
     * 设置接收日期
     *
     * @param acceptDate 接收日期
     */
    public void setAcceptDate(Date acceptDate) {
        this.acceptDate = acceptDate;
    }

    /**
     * 获取接收人姓名
     *
     * @return AcceptName - 接收人姓名
     */
    public String getAcceptName() {
        return acceptName;
    }

    /**
     * 设置接收人姓名
     *
     * @param acceptName 接收人姓名
     */
    public void setAcceptName(String acceptName) {
        this.acceptName = acceptName;
    }

    /**
     * 获取接收人帐号
     *
     * @return AcceptUser - 接收人帐号
     */
    public String getAcceptUser() {
        return acceptUser;
    }

    /**
     * 设置接收人帐号
     *
     * @param acceptUser 接收人帐号
     */
    public void setAcceptUser(String acceptUser) {
        this.acceptUser = acceptUser;
    }

    /**
     * 获取签字日期（金融）
     *
     * @return SignBankDate - 签字日期（金融）
     */
    public Date getSignBankDate() {
        return signBankDate;
    }

    /**
     * 设置签字日期（金融）
     *
     * @param signBankDate 签字日期（金融）
     */
    public void setSignBankDate(Date signBankDate) {
        this.signBankDate = signBankDate;
    }

    /**
     * 获取年报公示状态（当前年报状态）：
     * @return ReportState - 年报公示状态（当前年报状态）
     */
    public String getReportState() {
        return reportState;
    }

    /**
     * 设置年报公示状态（当前年报状态）
     *
     * @param reportState 年报公示状态（当前年报状态）
     */
    public void setReportState(String reportState) {
        this.reportState = reportState;
    }

    /**
     * 获取提交方IP地址
     *
     * @return SubIp - 提交方IP地址
     */
    public String getSubIp() {
        return subIp;
    }

    /**
     * 设置提交方IP地址
     *
     * @param subIp 提交方IP地址
     */
    public void setSubIp(String subIp) {
        this.subIp = subIp;
    }

    /**
     * 获取报表类型
     *
     * @return RepType - 报表类型
     */
    public String getRepType() {
        return repType;
    }

    /**
     * 设置报表类型
     *
     * @param repType 报表类型
     */
    public void setRepType(String repType) {
        this.repType = repType;
    }

    /**
     * 获取年度年报状态：0未年报；1已年报；2已年报（逾期）
     *
     * @return IsReported - 年度年报状态：0未年报；1已年报；2已年报（逾期）
     */
    public String getIsReported() {
        return isReported;
    }

    /**
     * 设置年度年报状态：0未年报；1已年报；2已年报（逾期）
     *
     * @param isReported 年度年报状态：0未年报；1已年报；2已年报（逾期）
     */
    public void setIsReported(String isReported) {
        this.isReported = isReported;
    }

    /**
     * 获取最近报告时间
     *
     * @return LastReportTime - 最近报告时间
     */
    public Date getLastReportTime() {
        return lastReportTime;
    }

    /**
     * 设置最近报告时间
     *
     * @param lastReportTime 最近报告时间
     */
    public void setLastReportTime(Date lastReportTime) {
        this.lastReportTime = lastReportTime;
    }

    /**
     * 获取报送登录方式1：证书 ，2：用户名，3：临时证书，4：大厅终端，5：政务服务网证书登录
     *
     * @return ReportType - 报送登录方式1：证书 ，2：用户名，3：临时证书，4：大厅终端，5：政务服务网证书登录
     */
    public String getReportType() {
        return reportType;
    }

    /**
     * 设置报送登录方式1：证书 ，2：用户名，3：临时证书，4：大厅终端，5：政务服务网证书登录
     *
     * @param reportType 报送登录方式1：证书 ，2：用户名，3：临时证书，4：大厅终端，5：政务服务网证书登录
     */
    public void setReportType(String reportType) {
        this.reportType = reportType;
    }

    /**
     * 获取锁定状态：1已锁定；0未锁定；
     *
     * @return LockState - 锁定状态：1已锁定；0未锁定；
     */
    public String getLockState() {
        return lockState;
    }

    /**
     * 设置锁定状态：1已锁定；0未锁定；
     *
     * @param lockState 锁定状态：1已锁定；0未锁定；
     */
    public void setLockState(String lockState) {
        this.lockState = lockState;
    }

    /**
     * 获取解锁设置人
     *
     * @return Setter - 解锁设置人
     */
    public String getSetter() {
        return setter;
    }

    /**
     * 设置解锁设置人
     *
     * @param setter 解锁设置人
     */
    public void setSetter(String setter) {
        this.setter = setter;
    }

    /**
     * 获取解锁日期
     *
     * @return SetDate - 解锁日期
     */
    public Date getSetDate() {
        return setDate;
    }

    /**
     * 设置解锁日期
     *
     * @param setDate 解锁日期
     */
    public void setSetDate(Date setDate) {
        this.setDate = setDate;
    }

    /**
     * 获取管理片号
     *
     * @return SliceNo - 管理片号
     */
    public String getSliceNo() {
        return sliceNo;
    }

    /**
     * 设置管理片号
     *
     * @param sliceNo 管理片号
     */
    public void setSliceNo(String sliceNo) {
        this.sliceNo = sliceNo;
    }


    /**
     * 获取意见（金融）
     *
     * @return CheckOpinBank - 意见（金融）
     */
    public String getCheckOpinBank() {
        return checkOpinBank;
    }

    /**
     * 设置意见（金融）
     *
     * @param checkOpinBank 意见（金融）
     */
    public void setCheckOpinBank(String checkOpinBank) {
        this.checkOpinBank = checkOpinBank;
    }

    /**
     * 获取审查意见（工商）
     *
     * @return CheckOpinBur - 审查意见（工商）
     */
    public String getCheckOpinBur() {
        return checkOpinBur;
    }

    /**
     * 设置审查意见（工商）
     *
     * @param checkOpinBur 审查意见（工商）
     */
    public void setCheckOpinBur(String checkOpinBur) {
        this.checkOpinBur = checkOpinBur;
    }

    /**
     * 获取审查意见（农业）
     *
     * @return CheckOpinSfc - 审查意见（农业）
     */
    public String getCheckOpinSfc() {
        return checkOpinSfc;
    }

    /**
     * 设置审查意见（农业）
     *
     * @param checkOpinSfc 审查意见（农业）
     */
    public void setCheckOpinSfc(String checkOpinSfc) {
        this.checkOpinSfc = checkOpinSfc;
    }

    /**
     * 获取接收部门
     *
     * @return AcceptDept - 接收部门
     */
    public String getAcceptDept() {
        return acceptDept;
    }

    /**
     * 设置接收部门
     *
     * @param acceptDept 接收部门
     */
    public void setAcceptDept(String acceptDept) {
        this.acceptDept = acceptDept;
    }

    /**
     * 获取解锁原因
     *
     * @return UnlockReason - 解锁原因
     */
    public String getUnlockReason() {
        return unlockReason;
    }

    /**
     * 设置解锁原因
     *
     * @param unlockReason 解锁原因
     */
    public void setUnlockReason(String unlockReason) {
        this.unlockReason = unlockReason;
    }

	public String getIsForbidWord() {
		return isForbidWord;
	}

	public void setIsForbidWord(String isForbidWord) {
		this.isForbidWord = isForbidWord;
	}
	
	public Integer getModifyCount() {
		return modifyCount;
	}

	public void setModifyCount(Integer modifyCount) {
		this.modifyCount = modifyCount;
	}

	/** 
	 * 描述: 年度年报状态说明（企业端）
	 * @auther ZhouYan
	 * @date 2016年9月13日 
	 * @return 
	 */
	public String getIsReportedClientDesc() {
		try {
			return this.isReported == null ? "" : ReportStatusEnum.getValue(this.isReported).getStatusClientDesc();
		} catch (Exception e) {
			return this.isReported;
		}
	}

	/** 
	 * 描述: 年度年报状态说明（工商端）
	 * @auther ZhouYan
	 * @date 2016年9月13日 
	 * @return 
	 */
	public String getIsReportedServerDesc() {
		try {
			return this.isReported == null ? "" : ReportStatusEnum.getValue(this.isReported).getStatusServerDesc();
		} catch (Exception e) {
			return this.isReported;
		}
	}

	/** 
	 * 描述: 年报公示状态（当前年报状态）说明（企业端）
	 * @auther ZhouYan
	 * @date 2016年9月13日 
	 * @return 
	 */
	public String getReportStateClientDesc() {
		try {
			return this.reportState == null ? "" : ReportStatusEnum.getValue(this.reportState).getStatusClientDesc();
		} catch (Exception e) {
			return this.reportState;
		}
	}

	/** 
	 * 描述: 年报公示状态（当前年报状态）说明（工商端）
	 * @auther ZhouYan
	 * @date 2016年9月13日 
	 * @return 
	 */
	public String getReportStateServerDesc() {
		try {
			return this.reportState == null ? "" : ReportStatusEnum.getValue(this.reportState).getStatusServerDesc();
		} catch (Exception e) {
			return this.reportState;
		}
	}
	
	public void setAddRecState(String addRecState) {
		this.addRecState = addRecState;
	}
	public String getAddRecState() {
		return addRecState;
	}

	public Date getAddRecDate() {
		return addRecDate;
	}

	public void setAddRecDate(Date addRecDate) {
		this.addRecDate = addRecDate;
	}

	public String getAddRecDept() {
		return addRecDept;
	}

	public void setAddRecDept(String addRecDept) {
		this.addRecDept = addRecDept;
	}

	public String getAddRecUser() {
		return addRecUser;
	}

	public void setAddRecUser(String addRecUser) {
		this.addRecUser = addRecUser;
	}
	
	

}