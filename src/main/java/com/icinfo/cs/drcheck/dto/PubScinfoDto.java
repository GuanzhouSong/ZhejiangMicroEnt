/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.drcheck.dto;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.icinfo.cs.common.constant.AreaCodes;
import com.icinfo.cs.drcheck.model.PubDeptSctask;
import com.icinfo.cs.drcheck.model.PubScdispose;
import com.icinfo.cs.drcheck.model.PubScinfo;
import com.icinfo.cs.drcheck.model.PubScitemResult;
import com.icinfo.cs.drcheck.model.PubScresult;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.cs.system.model.SysUser;

/**
 * 描述:  cs_pub_scinfo 对应的DTO类.<br>
 *
 * @author framework generator
 * @date 2016年10月25日
 */
/**
 * @author Administrator
 *
 */
public class PubScinfoDto extends PubScinfo {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8368922194573837132L;
	
	//联络人姓名
	private String liaName;
	//联络人电话
	private String leRepPhone;
	//企业大类
	private String entTypeCatgDesc;
	//行业类型
	private String industryDesc;

	/**任务编号*/
	private String taskCode;
	
	/**任务名称*/
	private String taskName; 
	
	/** 审核结果 0：填报中，1：待审核，2：同意,3：不同意 */
    private String auditState;
    
    /**  审核意见 */
    private String auditOpin;
    
    /**  审核人 */
    private String auditName;
    
    /** 审核日期 */
    private Date auditDate;
    
    /** 部门 */
    private String auditDept;
    
    /** 住所 */
    private String dom;
    

    /**
     * 企业名称
     */
    private String entName;

    /**
     * 统一社会信用代码
     */
    private String uniCode;

    /**
     * 注册号
     */
    private String regNO;

    /**
     * 法定代表人
     */
    private String leRep;

    /**
     * 经营场所
     */
    private String opLoc;

    /**
     * 登记机关
     */
    private String regOrg;

    /**
     * 登记机关描述
     */
    private String regOrgDesc;

    /**
     * 成立日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date estDate;

    /**
     * 企业类型
     */
    private String entTypeCatg;
    
    /**
     * 属地监管工商所
     */
    private String localAdm;

    /**
     * 管理片区
     */
    private String slicenNO;

    /**
     * 联络人
     */
    private String linkMan;

    /**
     * 联络人电话
     */
    private String tel;

    /**
     * 备注
     */
    private String remark;
    
    /**
     * 任务截止日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date endDate;
    
    /**
     * 执法人员姓名
     */
    private String agentName;
    
    /**
     * 登记机关前四位
     */
    private String regOrgShort;
    
    /**
     * 地区描述
     */
    private String regOrgShortDesc;
    
    /**
     * 各地区企业数量
     */
    private Integer totalEnt;
    
    /**
     * 各地区企业待抽检库数量
     */
    private Integer backTotalEnt;
    /**
     * 实施部门UID
     */
    private String deptTaskNO;
	
	//==================以下是参数==================
	//实施部门列表
	private List<PubDeptSctask> pubDeptSctaskList;
	//实施部门对应的检查项结果
	private List<PubScitemResult> pubScitemResultList;
	//实施部门结果录入
	private PubScresult pubScresult;
	//实施部门后续处置信息录入
	private PubScdispose pubScdispose;
	//session用户
	private SysUser sysUser;
	//session用户
	private SysUserDto sysUserDto;
	//实施部门
	private PubDeptSctask pubDeptSctask;
	
	
	public String getTaskCode() {
		return taskCode;
	}

	public void setTaskCode(String taskCode) {
		this.taskCode = taskCode;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public List<PubScitemResult> getPubScitemResultList() {
		return pubScitemResultList;
	}

	public void setPubScitemResultList(List<PubScitemResult> pubScitemResultList) {
		this.pubScitemResultList = pubScitemResultList;
	}

	public List<PubDeptSctask> getPubDeptSctaskList() {
		return pubDeptSctaskList;
	}

	public void setPubDeptSctaskList(List<PubDeptSctask> pubDeptSctaskList) {
		this.pubDeptSctaskList = pubDeptSctaskList;
	}

	public SysUser getSysUser() {
		return sysUser;
	}

	public void setSysUser(SysUser sysUser) {
		this.sysUser = sysUser;
	}

	public String getAuditState() {
		return auditState;
	}

	public void setAuditState(String auditState) {
		this.auditState = auditState;
	}

	public String getAuditOpin() {
		return auditOpin;
	}

	public void setAuditOpin(String auditOpin) {
		this.auditOpin = auditOpin;
	}

	public String getAuditName() {
		return auditName;
	}

	public void setAuditName(String auditName) {
		this.auditName = auditName;
	}

	public Date getAuditDate() {
		return auditDate;
	}

	public void setAuditDate(Date auditDate) {
		this.auditDate = auditDate;
	}

	public String getAuditDept() {
		return auditDept;
	}

	public void setAuditDept(String auditDept) {
		this.auditDept = auditDept;
	}

	public String getLiaName() {
		return liaName;
	}

	public void setLiaName(String liaName) {
		this.liaName = liaName;
	}

	public String getLeRepPhone() {
		return leRepPhone;
	}

	public void setLeRepPhone(String leRepPhone) {
		this.leRepPhone = leRepPhone;
	}

	public String getEntTypeCatgDesc() {
		return entTypeCatgDesc;
	}

	public void setEntTypeCatgDesc(String entTypeCatgDesc) {
		this.entTypeCatgDesc = entTypeCatgDesc;
	}

	public String getIndustryDesc() {
		return industryDesc;
	}

	public void setIndustryDesc(String industryDesc) {
		this.industryDesc = industryDesc;
	}

	public SysUserDto getSysUserDto() {
		return sysUserDto;
	}

	public void setSysUserDto(SysUserDto sysUserDto) {
		this.sysUserDto = sysUserDto;
	}

	public PubScresult getPubScresult() {
		return pubScresult;
	}

	public void setPubScresult(PubScresult pubScresult) {
		this.pubScresult = pubScresult;
	}

	public PubScdispose getPubScdispose() {
		return pubScdispose;
	}

	public void setPubScdispose(PubScdispose pubScdispose) {
		this.pubScdispose = pubScdispose;
	}

	public String getDom() {
		return dom;
	}

	public void setDom(String dom) {
		this.dom = dom;
	}

	public PubDeptSctask getPubDeptSctask() {
		return pubDeptSctask;
	}

	public void setPubDeptSctask(PubDeptSctask pubDeptSctask) {
		this.pubDeptSctask = pubDeptSctask;
	}

	public String getEntName() {
		return entName;
	}

	public void setEntName(String entName) {
		this.entName = entName;
	}

	public String getUniCode() {
		return uniCode;
	}

	public void setUniCode(String uniCode) {
		this.uniCode = uniCode;
	}

	public String getRegNO() {
		return regNO;
	}

	public void setRegNO(String regNO) {
		this.regNO = regNO;
	}

	public String getLeRep() {
		return leRep;
	}

	public void setLeRep(String leRep) {
		this.leRep = leRep;
	}

	public String getOpLoc() {
		return opLoc;
	}

	public void setOpLoc(String opLoc) {
		this.opLoc = opLoc;
	}

	public String getRegOrg() {
		return regOrg;
	}

	public void setRegOrg(String regOrg) {
		this.regOrg = regOrg;
	}

	public String getRegOrgDesc() {
		return regOrgDesc;
	}

	public void setRegOrgDesc(String regOrgDesc) {
		this.regOrgDesc = regOrgDesc;
	}

	public Date getEstDate() {
		return estDate;
	}

	public void setEstDate(Date estDate) {
		this.estDate = estDate;
	}

	public String getEntTypeCatg() {
		return entTypeCatg;
	}

	public void setEntTypeCatg(String entTypeCatg) {
		this.entTypeCatg = entTypeCatg;
	}

	public String getLocalAdm() {
		return localAdm;
	}

	public void setLocalAdm(String localAdm) {
		this.localAdm = localAdm;
	}

	public String getSlicenNO() {
		return slicenNO;
	}

	public void setSlicenNO(String slicenNO) {
		this.slicenNO = slicenNO;
	}

	public String getLinkMan() {
		return linkMan;
	}

	public void setLinkMan(String linkMan) {
		this.linkMan = linkMan;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getAgentName() {
		return agentName;
	}

	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}

	public String getRegOrgShort() {
		return regOrgShort;
	}

	public void setRegOrgShort(String regOrgShort) {
		setRegOrgShortDesc(AreaCodes.getValue(regOrgShort).getDesc());
		this.regOrgShort = regOrgShort;
	}

	public Integer getTotalEnt() {
		return totalEnt;
	}

	public void setTotalEnt(Integer totalEnt) {
		this.totalEnt = totalEnt;
	}

	public String getRegOrgShortDesc() {
		return regOrgShortDesc;
	}

	public void setRegOrgShortDesc(String regOrgShortDesc) {
		this.regOrgShortDesc = regOrgShortDesc;
	}

	public Integer getBackTotalEnt() {
		return backTotalEnt;
	}

	public void setBackTotalEnt(Integer backTotalEnt) {
		this.backTotalEnt = backTotalEnt;
	}

	public String getDeptTaskNO() {
		return deptTaskNO;
	}

	public void setDeptTaskNO(String deptTaskNO) {
		this.deptTaskNO = deptTaskNO;
	}
}