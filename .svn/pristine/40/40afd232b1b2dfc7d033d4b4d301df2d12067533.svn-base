/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.party.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.icinfo.framework.mybatis.mapper.annotation.Before;

/**
 * 描述: cs_party_member_info 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * 
 * @author framework generator
 * @date 2017年08月18日
 */
@Table(name = "cs_party_member_info")
public class PartyMemberInfo implements Serializable {

	@Id
	@Column(name = "id")
	private Integer id;

	/**
	 * 唯一标识
	 */
	@Column(name = "UID")
	@Before
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "select replace(uuid(), '-', '')")
	private String UID;

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
     * 企业类型 1-企业  2-个体
     */
	@Column(name = "EntType")
	private String entType;

	/**
	 * 注册号
	 */
	@Column(name = "RegNO")
	private String regNO;

	/**
	 * 统一代码
	 */
	@Column(name = "UniCode")
	private String uniCode;

	/**
	 * 法人（业主）
	 */
	@Column(name = "LeRep")
	private String leRep;

	/**
	 * 成员类型 1-业主 2-从业人员
	 */
	@Column(name = "MemberType")
	private String memberType;

	/**
	 * 个体户或企业是否建有党组织 0-否 1-是
	 */
	@Column(name = "IsBuildPartyOrg")
	private String isBuildPartyOrg;

	/**
	 * 姓名
	 */
	@Column(name = "MemberName")
	private String memberName;
    
    /**
     * 民族 1-汉族 2-其它
     */
    @Column(name = "Nationality")
    private String nationality;

	/**
	 * 性别 1-男 2-女
	 */
	@Column(name = "Sex")
	private String sex;
	
	 /**
     * 年龄
     */
	@Column(name = "MemberAge")
	private Integer memberAge;

	/**
	 * 身份信息
	 */
	@Column(name = "IdentityInfo")
	private String identityInfo;
    
    /**
     * 手机号码
     */
    @Column(name = "PhoneNum")
    private String phoneNum;

	/**
	 * 电话号码
	 */
	@Column(name = "TelNum")
	private String telNum;

	/**
	 * 是否为书记 0-否 1-是
	 */
	@Column(name = "IsSecretary")
	private String isSecretary;
	
	/**
	 * 党务工作者 0-否 1-是
	 */
	@Column(name = "PartyWorker")
	private String partyWorker;

	/**
	 * 学历
	 */
	@Column(name = "Qualifications")
	private String qualifications;
    
    /**
     * 所属市场
     */
    @Column(name = "BelongMarket")
    private String belongMarket;

	/**
	 * 原籍所在地
	 */
	@Column(name = "OriginLoc")
	private String originLoc;
	
	/**
	 * 原籍：省
	 */
	@Column(name = "LocProvince")
	private String locProvince;
	
	/**
	 * 原籍：市
	 */
	@Column(name = "LocCity")
	private String locCity;
	
	/**
	 * 原籍：区县
	 */
	@Column(name = "LocCounty")
	private String locCounty;
	
	/**
	 * 现组织关系所在地 1-在本辖区街道、社区、村党组织 2-在本辖个私协会党组织 3-在本辖区市场党组织 4-在原籍党组织的流动党员
	 */
	@Column(name = "OrgRelationLoc")
	private String orgRelationLoc;

	/**
	 * 组织生活所在辖区党组织
	 */
	@Column(name = "PartyOrgName")
	private String partyOrgName;

	/**
	 * 所属党组织ID
	 */
	@Column(name = "PartyOrgID")
	private String partyOrgID;

	/**
	 * 是否为个协会员 0-否 1-是
	 */
	@Column(name = "IsAssoVip")
	private String isAssoVip;

	/**
	 * 党员类别 1-正式 2-预备 3-积极分子 4-培养考察对象
	 */
	@Column(name = "PmType")
	private String pmType;

	/**
	 * 党员分布 0-市场 1-个体
	 */
	@Column(name = "PmDistributed")
	private String pmDistributed;
    
    /**
     * 组织关系登记日期
     */
    @Column(name = "OrgRegisterTime")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date orgRegisterTime;

    /**
     * 党内职务  1-普通党员  2-干部
     */
    @Column(name = "PartyPosition")
    private String partyPosition;

	/**
	 * 入党时间
	 */
	@Column(name = "JoinPartyTime")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date joinPartyTime;

    /**
     * 认领状态  0-待认领  1-已认领
     */
    @Column(name = "AuditState")
    private String auditState;

	/**
	 * 备注
	 */
	@Column(name = "Remark")
	private String remark;


	/**
	 * 认领时间
	 */
	@Column(name = "AuditTime")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date auditTime;

	/**
	 * 审核人
	 */
	@Column(name = "AuditName")
	private String auditName;

    /**
     * 建档时间
     */
    @Column(name = "CreateTime")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date createTime;
    
	/**
	 * 审核部门
	 */
	@Column(name = "AuditDept")
	private String auditDept;
    
    /**
     * 修改时间
     */
    @Column(name = "ModifyTime")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date modifyTime;
    
    /**
     * 入库类型
     */
    @Column(name = "InputType")
    private String inputType;
    

	public String getEntType() {
		return entType;
	}

	public void setEntType(String entType) {
		this.entType = entType;
	}

	public Integer getMemberAge() {
		return memberAge;
	}

	public void setMemberAge(Integer memberAge) {
		this.memberAge = memberAge;
	}

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
	 * 获取唯一标识
	 *
	 * @return UID - 唯一标识
	 */
	public String getUID() {
		return UID;
	}

	/**
	 * 设置唯一标识
	 *
	 * @param UID
	 *            唯一标识
	 */
	public void setUID(String UID) {
		this.UID = UID;
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
	 * @param priPID
	 *            主体代码
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
	 * @param entName
	 *            企业名称
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
	 * @param regNO
	 *            注册号
	 */
	public void setRegNO(String regNO) {
		this.regNO = regNO;
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
	 * @param uniCode
	 *            统一代码
	 */
	public void setUniCode(String uniCode) {
		this.uniCode = uniCode;
	}

	/**
	 * 获取法人（业主）
	 *
	 * @return LeRep - 法人（业主）
	 */
	public String getLeRep() {
		return leRep;
	}

	/**
	 * 设置法人（业主）
	 *
	 * @param leRep
	 *            法人（业主）
	 */
	public void setLeRep(String leRep) {
		this.leRep = leRep;
	}

	/**
	 * 获取成员类型 1-业主 2-从业人员
	 *
	 * @return MemberType - 成员类型 1-业主 2-从业人员
	 */
	public String getMemberType() {
		return memberType;
	}

	/**
	 * 设置成员类型 1-业主 2-从业人员
	 *
	 * @param memberType
	 *            成员类型 1-业主 2-从业人员
	 */
	public void setMemberType(String memberType) {
		this.memberType = memberType;
	}

	/**
	 * 获取个体户或企业是否建有党组织 0-否 1-是
	 *
	 * @return IsBuildPartyOrg - 个体户或企业是否建有党组织 0-否 1-是
	 */
	public String getIsBuildPartyOrg() {
		return isBuildPartyOrg;
	}

	/**
	 * 设置个体户或企业是否建有党组织 0-否 1-是
	 *
	 * @param isBuildPartyOrg
	 *            个体户或企业是否建有党组织 0-否 1-是
	 */
	public void setIsBuildPartyOrg(String isBuildPartyOrg) {
		this.isBuildPartyOrg = isBuildPartyOrg;
	}

	/**
	 * 获取姓名
	 *
	 * @return MemberName - 姓名
	 */
	public String getMemberName() {
		return memberName;
	}

	/**
	 * 设置姓名
	 *
	 * @param memberName
	 *            姓名
	 */
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	/**
	 * 获取性别
	 *
	 * @return Sex - 性别
	 */
	public String getSex() {
		return sex;
	}

	/**
	 * 设置性别
	 *
	 * @param sex
	 *            性别
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}

	/**
	 * 获取身份信息
	 *
	 * @return IdentityInfo - 身份信息
	 */
	public String getIdentityInfo() {
		return identityInfo;
	}

	/**
	 * 设置身份信息
	 *
	 * @param identityInfo
	 *            身份信息
	 */
	public void setIdentityInfo(String identityInfo) {
		this.identityInfo = identityInfo;
	}

	/**
	 * 获取电话号码
	 *
	 * @return TelNum - 电话号码
	 */
	public String getTelNum() {
		return telNum;
	}

	/**
	 * 设置电话号码
	 *
	 * @param telNum
	 *            电话号码
	 */
	public void setTelNum(String telNum) {
		this.telNum = telNum;
	}

	/**
	 * 获取是否为书记
	 *
	 * @return IsSecretary - 是否为书记
	 */
	public String getIsSecretary() {
		return isSecretary;
	}

	/**
	 * 设置是否为书记
	 *
	 * @param isSecretary
	 *            是否为书记
	 */
	public void setIsSecretary(String isSecretary) {
		this.isSecretary = isSecretary;
	}

	/**
	 * 获取学历
	 *
	 * @return Qualifications - 学历
	 */
	public String getQualifications() {
		return qualifications;
	}

	/**
	 * 设置学历
	 *
	 * @param qualifications
	 *            学历
	 */
	public void setQualifications(String qualifications) {
		this.qualifications = qualifications;
	}

	/**
	 * 获取原籍所在地
	 *
	 * @return OriginLoc - 原籍所在地
	 */
	public String getOriginLoc() {
		return originLoc;
	}

	/**
	 * 设置原籍所在地
	 *
	 * @param originLoc
	 *            原籍所在地
	 */
	public void setOriginLoc(String originLoc) {
		this.originLoc = originLoc;
	}

	/**
	 * 获取现组织关系所在地
	 *
	 * @return OrgRelationLoc - 现组织关系所在地
	 */
	public String getOrgRelationLoc() {
		return orgRelationLoc;
	}

	/**
	 * 设置现组织关系所在地
	 *
	 * @param orgRelationLoc
	 *            现组织关系所在地
	 */
	public void setOrgRelationLoc(String orgRelationLoc) {
		this.orgRelationLoc = orgRelationLoc;
	}

	/**
	 * 获取组织生活所在辖区党组织
	 *
	 * @return PartyOrgName - 组织生活所在辖区党组织
	 */
	public String getPartyOrgName() {
		return partyOrgName;
	}

	/**
	 * 设置组织生活所在辖区党组织
	 *
	 * @param partyOrgName
	 *            组织生活所在辖区党组织
	 */
	public void setPartyOrgName(String partyOrgName) {
		this.partyOrgName = partyOrgName;
	}

	/**
	 * 获取所属党组织ID
	 *
	 * @return PartyOrgID - 所属党组织ID
	 */
	public String getPartyOrgID() {
		return partyOrgID;
	}

	/**
	 * 设置所属党组织ID
	 *
	 * @param partyOrgID
	 *            所属党组织ID
	 */
	public void setPartyOrgID(String partyOrgID) {
		this.partyOrgID = partyOrgID;
	}

	/**
	 * 获取是否为个协会员
	 *
	 * @return IsAssoVip - 是否为个协会员
	 */
	public String getIsAssoVip() {
		return isAssoVip;
	}

	/**
	 * 设置是否为个协会员
	 *
	 * @param isAssoVip
	 *            是否为个协会员
	 */
	public void setIsAssoVip(String isAssoVip) {
		this.isAssoVip = isAssoVip;
	}

	/**
	 * 获取党员类别 1-正式 2-预备
	 *
	 * @return PmType - 党员类别 1-正式 2-预备
	 */
	public String getPmType() {
		return pmType;
	}

	/**
	 * 设置党员类别 1-正式 2-预备
	 *
	 * @param pmType
	 *            党员类别 1-正式 2-预备
	 */
	public void setPmType(String pmType) {
		this.pmType = pmType;
	}

	/**
	 * 获取党员分布 0-市场 1-个体
	 *
	 * @return PmDistributed - 党员分布 0-市场 1-个体
	 */
	public String getPmDistributed() {
		return pmDistributed;
	}

	/**
	 * 设置党员分布 0-市场 1-个体
	 *
	 * @param pmDistributed
	 *            党员分布 0-市场 1-个体
	 */
	public void setPmDistributed(String pmDistributed) {
		this.pmDistributed = pmDistributed;
	}

	/**
	 * 获取入党时间
	 *
	 * @return JoinPartyTime - 入党时间
	 */
	public Date getJoinPartyTime() {
		return joinPartyTime;
	}

	/**
	 * 设置入党时间
	 *
	 * @param joinPartyTime
	 *            入党时间
	 */
	public void setJoinPartyTime(Date joinPartyTime) {
		this.joinPartyTime = joinPartyTime;
	}

	/**
	 * 获取党内职务
	 *
	 * @return PartyPosition - 党内职务
	 */
	public String getPartyPosition() {
		return partyPosition;
	}

	/**
	 * 设置党内职务
	 *
	 * @param partyPosition
	 *            党内职务
	 */
	public void setPartyPosition(String partyPosition) {
		this.partyPosition = partyPosition;
	}

	/**
	 * 获取备注
	 *
	 * @return Remark - 备注
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * 设置备注
	 *
	 * @param remark
	 *            备注
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * 获取认领状态
	 *
	 * @return AuditState - 认领状态
	 */
	public String getAuditState() {
		return auditState;
	}

	/**
	 * 设置认领状态
	 *
	 * @param auditState
	 *            认领状态
	 */
	public void setAuditState(String auditState) {
		this.auditState = auditState;
	}

	/**
	 * 获取认领时间
	 *
	 * @return AuditTime - 认领时间
	 */
	public Date getAuditTime() {
		return auditTime;
	}

	/**
	 * 设置认领时间
	 *
	 * @param auditTime
	 *            认领时间
	 */
	public void setAuditTime(Date auditTime) {
		this.auditTime = auditTime;
	}

	/**
	 * 获取审核人
	 *
	 * @return AuditName - 审核人
	 */
	public String getAuditName() {
		return auditName;
	}

	/**
	 * 设置审核人
	 *
	 * @param auditName
	 *            审核人
	 */
	public void setAuditName(String auditName) {
		this.auditName = auditName;
	}

	/**
	 * 获取审核部门
	 *
	 * @return AuditDept - 审核部门
	 */
	public String getAuditDept() {
		return auditDept;
	}

	/**
	 * 设置审核部门
	 *
	 * @param auditDept
	 *            审核部门
	 */
	public void setAuditDept(String auditDept) {
		this.auditDept = auditDept;
	}

	/**
	 * 获取创建时间
	 *
	 * @return CreateTime - 创建时间
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * 设置创建时间
	 *
	 * @param createTime
	 *            创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getBelongMarket() {
		return belongMarket;
	}

	public void setBelongMarket(String belongMarket) {
		this.belongMarket = belongMarket;
	}

	public Date getOrgRegisterTime() {
		return orgRegisterTime;
	}

	public void setOrgRegisterTime(Date orgRegisterTime) {
		this.orgRegisterTime = orgRegisterTime;
	}

	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	public String getInputType() {
		return inputType;
	}

	public void setInputType(String inputType) {
		this.inputType = inputType;
	}

	public String getPartyWorker() {
		return partyWorker;
	}

	public void setPartyWorker(String partyWorker) {
		this.partyWorker = partyWorker;
	}

	public String getLocProvince() {
		return locProvince;
	}

	public void setLocProvince(String locProvince) {
		this.locProvince = locProvince;
	}

	public String getLocCity() {
		return locCity;
	}

	public void setLocCity(String locCity) {
		this.locCity = locCity;
	}

	public String getLocCounty() {
		return locCounty;
	}

	public void setLocCounty(String locCounty) {
		this.locCounty = locCounty;
	}
	
    
}