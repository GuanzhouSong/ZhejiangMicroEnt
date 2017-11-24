/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.rpt.rptdto;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.icinfo.cs.rpt.rptmodel.RptSmBaseinfo;

/**
 * 描述: cs_sm_baseinfo 对应的DTO类.<br>
 *
 * @author framework generator
 * @date 2017年05月02日
 */
public class RptSmBaseinfoDto extends RptSmBaseinfo {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6789770466234302778L;

	/** 营业总收入 */
	private BigDecimal vendInc;

	/** 行业 */
	private String industryCoName;

	/** 企业类型 */
	private String entTypeName;

	/** 来源类型 */
	private String sourceType;

	private String industryName;// 产业名称
	private String cultivationTypeName;// 培育库名称
	private int helpNum;// 培育需求类别数量
	private int helpTypeNum;// 帮扶数量
	private String helpState;// 帮扶状态
	
	@JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
	private Date ancheDate;// 公示日期
	private String year;// 年度
	
    
	/** 企业大类类型（小微企业大类） */
	private String entTypeCatgName;
	/** 三大产业 */
	private String industryCodeName;
	/**
     * 应年报数
     */
    private BigDecimal rptCount;

    /**
     * 已年报数
     */
    private BigDecimal isRptCount;
    /**
     *开业数
     */
    private BigDecimal busstatus;
    
    //资产总额
    private BigDecimal assGro;
    //固定资产总额
    private BigDecimal fixAssets;
    //负债总额
    private BigDecimal liaGro;
    //利润总额
    private BigDecimal proGro;
    //净利润
    private BigDecimal netInc;
    //盈利企业个数
    private BigDecimal  addProCount;
    //亏损企业数
    private BigDecimal  minuProCount;
    //纳税总额
    private BigDecimal ratGro;
    
    //年报率:已年报数/应年报数
    private BigDecimal yreportRay;

    //开业率：开业数/已年报数
    private BigDecimal busstatusRay;
    
    //资产负债率：负债总额/资产总额
    private BigDecimal assliaRay;


    /**
     * 移除类型code 1 企业注销 2 升规 3 不符合培育库要求
     */
    private String removeTypeCode;

    /**
     * 移除类型名称
     */
    private String removeTypeName;

    /**
     * 移除时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date removeTime;
    
    
    
    /**
     * 小微企业所属年度
     */
    private String dirYear;
    //资产总额/资金数额 - 是否公示1：公示，0：不公示
    private String assgroIsp;
    //其中主营业务收入/营业收入 - 是否公示1：公示，0：不公示
    private String maiBusincIsp;
    //其中主营业务收入/营业收入/销售(营业)收入 -单位：元
    private BigDecimal maiBusinc;
    //从业人数 - 是否公示1：公示，0：不公示
    private String empNumIsp;
    //列入小微企业理由编码
    private String dirCreateReasonCode;
    //列入小微企业理由
    private String dirCreateReason;
    //列入时间
    private Date dirCreateTime;
    //时间戳
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;
	//企业大类描述
	private String entTypeCatgDesc;
	//行业门类描述
	private String industryMlDesc;
	//登记机关描述
	private String regOrgDesc;
	
	
	
	  /**
     * 享受扶持年度
     */
    private String enjoyYear;

    /**
     * 享受扶持政策依据
     */
    private String enjSpBasis;

    /**
     * 享受扶持政策内容
     */
    private String enjSpContent;

    /**
     * 享受扶持政策的数额 - 单位：元
     */
    private BigDecimal enjSpAmount;

    /**
     * 实施扶持政策的部门
     */
    private String impSpDepart;

    /**
     * 实施扶持政策日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date impSpDate;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date enjoyCreateTime;




	public Date getAncheDate() {
		return ancheDate;
	}

	public void setAncheDate(Date ancheDate) {
		this.ancheDate = ancheDate;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getIndustryName() {
		return industryName;
	}

	public void setIndustryName(String industryName) {
		this.industryName = industryName;
	}

	public String getCultivationTypeName() {
		return cultivationTypeName;
	}

	public void setCultivationTypeName(String cultivationTypeName) {
		this.cultivationTypeName = cultivationTypeName;
	}

	public int getHelpNum() {
		return helpNum;
	}

	public void setHelpNum(int helpNum) {
		this.helpNum = helpNum;
	}

	public int getHelpTypeNum() {
		return helpTypeNum;
	}

	public void setHelpTypeNum(int helpTypeNum) {
		this.helpTypeNum = helpTypeNum;
	}

	public BigDecimal getVendInc() {
		return vendInc;
	}

	public void setVendInc(BigDecimal vendInc) {
		this.vendInc = vendInc;
	}

	public String getIndustryCoName() {
		return industryCoName;
	}

	public void setIndustryCoName(String industryCoName) {
		this.industryCoName = industryCoName;
	}

	public String getEntTypeName() {
		return entTypeName;
	}

	public void setEntTypeName(String entTypeName) {
		this.entTypeName = entTypeName;
	}

	public String getSourceType() {
		return sourceType;
	}

	public void setSourceType(String sourceType) {
		this.sourceType = sourceType;
	}

	public String getHelpState() {
		return helpState;
	}

	public void setHelpState(String helpState) {
		this.helpState = helpState;
	}

	public void setRptCount(BigDecimal rptCount) {
		this.rptCount = rptCount;
	}
	public BigDecimal getRptCount() {
		return rptCount;
	}

	public BigDecimal getIsRptCount() {
		return isRptCount;
	}

	public void setIsRptCount(BigDecimal isRptCount) {
		this.isRptCount = isRptCount;
	}

	public BigDecimal getBusstatus() {
		return busstatus;
	}

	public void setBusstatus(BigDecimal busstatus) {
		this.busstatus = busstatus;
	}

	public BigDecimal getAssGro() {
		return assGro;
	}

	public void setAssGro(BigDecimal assGro) {
		this.assGro = assGro;
	}

	public BigDecimal getFixAssets() {
		return fixAssets;
	}

	public void setFixAssets(BigDecimal fixAssets) {
		this.fixAssets = fixAssets;
	}

	public BigDecimal getLiaGro() {
		return liaGro;
	}

	public void setLiaGro(BigDecimal liaGro) {
		this.liaGro = liaGro;
	}

	public BigDecimal getProGro() {
		return proGro;
	}

	public void setProGro(BigDecimal proGro) {
		this.proGro = proGro;
	}

	public BigDecimal getNetInc() {
		return netInc;
	}

	public void setNetInc(BigDecimal netInc) {
		this.netInc = netInc;
	}

	public BigDecimal getAddProCount() {
		return addProCount;
	}

	public void setAddProCount(BigDecimal addProCount) {
		this.addProCount = addProCount;
	}

	public BigDecimal getMinuProCount() {
		return minuProCount;
	}

	public void setMinuProCount(BigDecimal minuProCount) {
		this.minuProCount = minuProCount;
	}

	public BigDecimal getRatGro() {
		return ratGro;
	}

	public void setRatGro(BigDecimal ratGro) {
		this.ratGro = ratGro;
	}
	
	public void setBusstatusRay(BigDecimal busstatusRay) {
		this.busstatusRay = busstatusRay;
	}
	public BigDecimal getBusstatusRay() {
		return busstatusRay;
	}
	public void setAssliaRay(BigDecimal assliaRay) {
		this.assliaRay = assliaRay;
	}
	public BigDecimal getAssliaRay() {
		return assliaRay;
	}
	public void setYreportRay(BigDecimal yreportRay) {
		this.yreportRay = yreportRay;
	}
	public BigDecimal getYreportRay() {
		return yreportRay;
	}
	
	public void setEntTypeCatgName(String entTypeCatgName) {
		this.entTypeCatgName = entTypeCatgName;
	}
	public String getEntTypeCatgName() {
		return entTypeCatgName;
	}
	public void setIndustryCodeName(String industryCodeName) {
		this.industryCodeName = industryCodeName;
	} 
	public String getIndustryCodeName() {
		return industryCodeName;
	}
	
    
    /**
     * 获取移除类型code 1 企业注销 2 升规 3 不符合培育库要求
     *
     * @return RemoveTypeCode - 移除类型code 1 企业注销 2 升规 3 不符合培育库要求
     */
    public String getRemoveTypeCode() {
        return removeTypeCode;
    }

    /**
     * 设置移除类型code 1 企业注销 2 升规 3 不符合培育库要求
     *
     * @param removeTypeCode 移除类型code 1 企业注销 2 升规 3 不符合培育库要求
     */
    public void setRemoveTypeCode(String removeTypeCode) {
        this.removeTypeCode = removeTypeCode;
    }

    /**
     * 获取移除类型名称
     *
     * @return RemoveTypeName - 移除类型名称
     */
    public String getRemoveTypeName() {
        return removeTypeName;
    }

    /**
     * 设置移除类型名称
     *
     * @param removeTypeName 移除类型名称
     */
    public void setRemoveTypeName(String removeTypeName) {
        this.removeTypeName = removeTypeName;
    }

    /**
     * 获取移除时间
     *
     * @return RemoveTime - 移除时间
     */
    public Date getRemoveTime() {
        return removeTime;
    }

    /**
     * 设置移除时间
     *
     * @param removeTime 移除时间
     */
    public void setRemoveTime(Date removeTime) {
        this.removeTime = removeTime;
    }

	public String getDirYear() {
		return dirYear;
	}

	public void setDirYear(String dirYear) {
		this.dirYear = dirYear;
	}

	public String getAssgroIsp() {
		return assgroIsp;
	}

	public void setAssgroIsp(String assgroIsp) {
		this.assgroIsp = assgroIsp;
	}

	public String getMaiBusincIsp() {
		return maiBusincIsp;
	}

	public void setMaiBusincIsp(String maiBusincIsp) {
		this.maiBusincIsp = maiBusincIsp;
	}

	public BigDecimal getMaiBusinc() {
		return maiBusinc;
	}

	public void setMaiBusinc(BigDecimal maiBusinc) {
		this.maiBusinc = maiBusinc;
	}

	public String getEmpNumIsp() {
		return empNumIsp;
	}

	public void setEmpNumIsp(String empNumIsp) {
		this.empNumIsp = empNumIsp;
	}

	public String getDirCreateReasonCode() {
		return dirCreateReasonCode;
	}

	public void setDirCreateReasonCode(String dirCreateReasonCode) {
		this.dirCreateReasonCode = dirCreateReasonCode;
	}

	public String getDirCreateReason() {
		return dirCreateReason;
	}

	public void setDirCreateReason(String dirCreateReason) {
		this.dirCreateReason = dirCreateReason;
	}

	public Date getDirCreateTime() {
		return dirCreateTime;
	}

	public void setDirCreateTime(Date dirCreateTime) {
		this.dirCreateTime = dirCreateTime;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getEntTypeCatgDesc() {
		return entTypeCatgDesc;
	}

	public void setEntTypeCatgDesc(String entTypeCatgDesc) {
		this.entTypeCatgDesc = entTypeCatgDesc;
	}

	public String getIndustryMlDesc() {
		return industryMlDesc;
	}

	public void setIndustryMlDesc(String industryMlDesc) {
		this.industryMlDesc = industryMlDesc;
	}

	public String getRegOrgDesc() {
		return regOrgDesc;
	}

	public void setRegOrgDesc(String regOrgDesc) {
		this.regOrgDesc = regOrgDesc;
	}

	public String getEnjoyYear() {
		return enjoyYear;
	}

	public void setEnjoyYear(String enjoyYear) {
		this.enjoyYear = enjoyYear;
	}

	public String getEnjSpBasis() {
		return enjSpBasis;
	}

	public void setEnjSpBasis(String enjSpBasis) {
		this.enjSpBasis = enjSpBasis;
	}

	public String getEnjSpContent() {
		return enjSpContent;
	}

	public void setEnjSpContent(String enjSpContent) {
		this.enjSpContent = enjSpContent;
	}

	public BigDecimal getEnjSpAmount() {
		return enjSpAmount;
	}

	public void setEnjSpAmount(BigDecimal enjSpAmount) {
		this.enjSpAmount = enjSpAmount;
	}

	public String getImpSpDepart() {
		return impSpDepart;
	}

	public void setImpSpDepart(String impSpDepart) {
		this.impSpDepart = impSpDepart;
	}

	public Date getImpSpDate() {
		return impSpDate;
	}

	public void setImpSpDate(Date impSpDate) {
		this.impSpDate = impSpDate;
	}

	public Date getEnjoyCreateTime() {
		return enjoyCreateTime;
	}

	public void setEnjoyCreateTime(Date enjoyCreateTime) {
		this.enjoyCreateTime = enjoyCreateTime;
	}
	
	
	
	
	
}