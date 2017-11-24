/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.inspect.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.icinfo.framework.mybatis.mapper.annotation.Before;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * 描述:  cs_report_check_info 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年01月17日
 */
@Table(name = "cs_report_check_info")
public class ReportCheckInfo implements Serializable {
    @Id
    @Column(name = "ID")
    private Integer ID;

    /**
     * 序号：UUID
     */
    @Column(name = "UID")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    private String UID;

    /**
     * 统一代码
     */
    @Column(name = "UniCode")
    private String uniCode;

    /**
     * 注册号
     */
    @Column(name = "RegNO")
    private String regNO;

    /**
     * 主体代码
     */
    @Column(name = "PriPID")
    private String priPID;

    @Column(name = "Year")
    private String year;

    /**
     * 企业名称
     */
    @Column(name = "EntName")
    private String entName;

    /**
     * 检查内容1:即时信息，2：出资信息，3：年报信息
     */
    @Column(name = "InfoCheckCon")
    private String infoCheckCon;

    /**
     * 检查日期
     */
    @Column(name = "InfoCheckDate")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date infoCheckDate;

    /**
     * 审核结果0：待审核，1：审核通过，2：审核不通过
     */
    @Column(name = "InfoAuditResult")
    private String infoAuditResult;

    /**
     * 检查机关--默认企业登记机关
     */
    @Column(name = "InfoCheckOrg")
    private String infoCheckOrg;

    /**
     * 检查机关名称
     */
    @Column(name = "InfoCheckOrgName")
    private String infoCheckOrgName;

    /**
     * 检查部门--默认登录人所属部门
     */
    @Column(name = "Depart")
    private String depart;

    /**
     * 检查部门名称
     */
    @Column(name = "DepartName")
    private String departName;

    /**
     * 检查人员
     */
    @Column(name = "InfoCheckMan")
    private String infoCheckMan;

    /**
     * 录入人员
     */
    @Column(name = "InfoFillMan")
    private String infoFillMan;

    /**
     * 录入日期
     */
    @Column(name = "InfoFillDate")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date infoFillDate;

    /**
     * 审核人员
     */
    @Column(name = "InfoAuditMan")
    private String infoAuditMan;

    /**
     * 审核日期
     */
    @Column(name = "InfoAuditDate")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date infoAuditDate;

    /**
     * 审核意见
     */
    @Column(name = "InfoAuditOpin")
    private String infoAuditOpin;
    /**
     *
     */
    @Column(name = "LeRep")
    private String leRep;
    /**
     * 企业管辖单位
     */
    @Column(name = "LocalAdm")
    private String localAdm;
    @Column(name = "CheckDep")
    private String checkDep;
    /**
     * 成立日期
     */
    @Column(name = "EstDate")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date estDate;
    /**
     * 补报日期
     */
    @Column(name = "FirstReportTime")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date firstReportTime;
    /**
     * 后续处置
     */
    @Column(name = "ResDispose")
    private String resDispose;
    /**
     * 后续处置内容
     */
    @Column(name = "ResContent")
    private String resContent;
    /**
     * 检查方式
     */
    @Column(name = "ItemWay")
    private String itemWay;

    /**
     * 公示日期
     */
    @Column(name = "PubDate")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date pubDate;
    /**
     * 企业类型大类
     */
    @Column(name = "EntTypeCatg")
    private String entTypeCatg;

    /**
     * 企业状态
     */
    @Column(name = "RegState")
    private String regState;

    /**
	 * 后续处置状态：未完结-1，已完结-2
	 */
	@Column(name = "DisposeState")
	private String disposeState;

	/**
	 * 后续处置完结信息
	 */
	@Column(name = "DisposeFinishMss")
	private String disposeFinishMss;
	
	/**
	 * 后续处置完结日期
	 */
	@Column(name = "DisposeFinishDate")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date disposeFinishDate;
	
	
	/**
     * 修改日期
     */
    @Column(name = "ModTime")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date modTime;
	
    /**
	 * 修改内容
	 */
	@Column(name = "ModContent")
	private String modContent;
	
	/**
	 * 修改人员
	 */
	@Column(name = "ModName")
	private String modName;

    private static final long serialVersionUID = 1L;

    /**
     * @return ID
     */
    public Integer getID() {
        return ID;
    }

    /**
     * @param ID
     */
    public void setID(Integer ID) {
        this.ID = ID;
    }

    /**
     * 获取序号：UUID
     *
     * @return UID - 序号：UUID
     */
    public String getUID() {
        return UID;
    }

    /**
     * 设置序号：UUID
     *
     * @param UID 序号：UUID
     */
    public void setUID(String UID) {
        this.UID = UID;
    }

    /**
     * 获取统一代码
     *
     * @return UniCode - 统一代码
     */
    public String getUniCode() {
        return uniCode;
    }

    /**
     * 设置统一代码
     *
     * @param uniCode 统一代码
     */
    public void setUniCode(String uniCode) {
        this.uniCode = uniCode;
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
     * @return Year
     */
    public String getYear() {
        return year;
    }

    /**
     * @param year
     */
    public void setYear(String year) {
        this.year = year;
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
     * 获取检查内容1:即时信息，2：出资信息，3：年报信息
     *
     * @return InfoCheckCon - 检查内容1:即时信息，2：出资信息，3：年报信息
     */
    public String getInfoCheckCon() {
        return infoCheckCon;
    }

    /**
     * 设置检查内容1:即时信息，2：出资信息，3：年报信息
     *
     * @param infoCheckCon 检查内容1:即时信息，2：出资信息，3：年报信息
     */
    public void setInfoCheckCon(String infoCheckCon) {
        this.infoCheckCon = infoCheckCon;
    }

    /**
     * 获取检查日期
     *
     * @return InfoCheckDate - 检查日期
     */
    public Date getInfoCheckDate() {
        return infoCheckDate;
    }

    /**
     * 设置检查日期
     *
     * @param infoCheckDate 检查日期
     */
    public void setInfoCheckDate(Date infoCheckDate) {
        this.infoCheckDate = infoCheckDate;
    }

    /**
     * 获取审核结果0：待审核，1：审核通过，2：审核不通过
     *
     * @return InfoAuditResult - 审核结果0：待审核，1：审核通过，2：审核不通过
     */
    public String getInfoAuditResult() {
        return infoAuditResult;
    }

    /**
     * 设置审核结果0：待审核，1：审核通过，2：审核不通过
     *
     * @param infoAuditResult 审核结果0：待审核，1：审核通过，2：审核不通过
     */
    public void setInfoAuditResult(String infoAuditResult) {
        this.infoAuditResult = infoAuditResult;
    }

    /**
     * 获取检查机关--默认企业登记机关
     *
     * @return InfoCheckOrg - 检查机关--默认企业登记机关
     */
    public String getInfoCheckOrg() {
        return infoCheckOrg;
    }

    /**
     * 设置检查机关--默认企业登记机关
     *
     * @param infoCheckOrg 检查机关--默认企业登记机关
     */
    public void setInfoCheckOrg(String infoCheckOrg) {
        this.infoCheckOrg = infoCheckOrg;
    }

    /**
     * 获取检查机关名称
     *
     * @return InfoCheckOrgName - 检查机关名称
     */
    public String getInfoCheckOrgName() {
        return infoCheckOrgName;
    }

    /**
     * 设置检查机关名称
     *
     * @param infoCheckOrgName 检查机关名称
     */
    public void setInfoCheckOrgName(String infoCheckOrgName) {
        this.infoCheckOrgName = infoCheckOrgName;
    }

    /**
     * 获取检查部门--默认登录人所属部门
     *
     * @return Depart - 检查部门--默认登录人所属部门
     */
    public String getDepart() {
        return depart;
    }

    /**
     * 设置检查部门--默认登录人所属部门
     *
     * @param depart 检查部门--默认登录人所属部门
     */
    public void setDepart(String depart) {
        this.depart = depart;
    }

    /**
     * 获取检查部门名称
     *
     * @return DepartName - 检查部门名称
     */
    public String getDepartName() {
        return departName;
    }

    /**
     * 设置检查部门名称
     *
     * @param departName 检查部门名称
     */
    public void setDepartName(String departName) {
        this.departName = departName;
    }

    /**
     * 获取检查人员
     *
     * @return InfoCheckMan - 检查人员
     */
    public String getInfoCheckMan() {
        return infoCheckMan;
    }

    /**
     * 设置检查人员
     *
     * @param infoCheckMan 检查人员
     */
    public void setInfoCheckMan(String infoCheckMan) {
        this.infoCheckMan = infoCheckMan;
    }

    /**
     * 获取录入人员
     *
     * @return InfoFillMan - 录入人员
     */
    public String getInfoFillMan() {
        return infoFillMan;
    }

    /**
     * 设置录入人员
     *
     * @param infoFillMan 录入人员
     */
    public void setInfoFillMan(String infoFillMan) {
        this.infoFillMan = infoFillMan;
    }

    /**
     * 获取录入日期
     *
     * @return InfoFillDate - 录入日期
     */
    public Date getInfoFillDate() {
        return infoFillDate;
    }

    /**
     * 设置录入日期
     *
     * @param infoFillDate 录入日期
     */
    public void setInfoFillDate(Date infoFillDate) {
        this.infoFillDate = infoFillDate;
    }

    /**
     * 获取审核人员
     *
     * @return InfoAuditMan - 审核人员
     */
    public String getInfoAuditMan() {
        return infoAuditMan;
    }

    /**
     * 设置审核人员
     *
     * @param infoAuditMan 审核人员
     */
    public void setInfoAuditMan(String infoAuditMan) {
        this.infoAuditMan = infoAuditMan;
    }

    /**
     * 获取审核日期
     *
     * @return InfoAuditDate - 审核日期
     */
    public Date getInfoAuditDate() {
        return infoAuditDate;
    }

    /**
     * 设置审核日期
     *
     * @param infoAuditDate 审核日期
     */
    public void setInfoAuditDate(Date infoAuditDate) {
        this.infoAuditDate = infoAuditDate;
    }

    /**
     * 获取审核意见
     *
     * @return InfoAuditOpin - 审核意见
     */
    public String getInfoAuditOpin() {
        return infoAuditOpin;
    }

    /**
     * 设置审核意见
     *
     * @param infoAuditOpin 审核意见
     */
    public void setInfoAuditOpin(String infoAuditOpin) {
        this.infoAuditOpin = infoAuditOpin;
    }

    /**
     * 获取企业管辖单位
     *
     * @return LocalAdm - 企业管辖单位
     */
    public String getLocalAdm() {
        return localAdm;
    }

    /**
     * 设置企业管辖单位
     *
     * @param localAdm 企业管辖单位
     */
    public void setLocalAdm(String localAdm) {
        this.localAdm = localAdm;
    }

    public Date getEstDate() {
        return estDate;
    }

    public void setEstDate(Date estDate) {
        this.estDate = estDate;
    }

    public Date getFirstReportTime() {
        return firstReportTime;
    }

    public void setFirstReportTime(Date firstReportTime) {
        this.firstReportTime = firstReportTime;
    }

    public String getLeRep() {
        return leRep;
    }

    public void setLeRep(String leRep) {
        this.leRep = leRep;
    }

    public String getResDispose() {
        return resDispose;
    }

    public void setResDispose(String resDispose) {
        this.resDispose = resDispose;
    }

    public String getResContent() {
        return resContent;
    }

    public void setResContent(String resContent) {
        this.resContent = resContent;
    }

    public String getItemWay() {
        return itemWay;
    }

    public void setItemWay(String itemWay) {
        this.itemWay = itemWay;
    }

    public Date getPubDate() {
        return pubDate;
    }

    public void setPubDate(Date pubDate) {
        this.pubDate = pubDate;
    }

    public String getEntTypeCatg() {
        return entTypeCatg;
    }

    public void setEntTypeCatg(String entTypeCatg) {
        this.entTypeCatg = entTypeCatg;
    }

    public String getRegState() {
        return regState;
    }

    public void setRegState(String regState) {
        this.regState = regState;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getCheckDep() {
        return checkDep;
    }

    public void setCheckDep(String checkDep) {
        this.checkDep = checkDep;
    }

	public String getDisposeState() {
		return disposeState;
	}

	public void setDisposeState(String disposeState) {
		this.disposeState = disposeState;
	}

	public String getDisposeFinishMss() {
		return disposeFinishMss;
	}

	public void setDisposeFinishMss(String disposeFinishMss) {
		this.disposeFinishMss = disposeFinishMss;
	}

	public Date getDisposeFinishDate() {
		return disposeFinishDate;
	}

	public void setDisposeFinishDate(Date disposeFinishDate) {
		this.disposeFinishDate = disposeFinishDate;
	}

	public Date getModTime() {
		return modTime;
	}

	public void setModTime(Date modTime) {
		this.modTime = modTime;
	}

	public String getModContent() {
		return modContent;
	}

	public void setModContent(String modContent) {
		this.modContent = modContent;
	}

	public String getModName() {
		return modName;
	}

	public void setModName(String modName) {
		this.modName = modName;
	}
	
    
}