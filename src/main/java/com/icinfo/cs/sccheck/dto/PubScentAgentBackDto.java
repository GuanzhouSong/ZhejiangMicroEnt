/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.sccheck.dto;

import java.util.Date;
import java.util.List;

import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.icinfo.cs.sccheck.model.PubScentAgentBack;

/**
 * 描述:    cs_pub_scent_agent_back 对应的DTO类.<br>
 *
 * @author framework generator
 * @date 2017年05月20日
 */
public class PubScentAgentBackDto extends PubScentAgentBack {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8436275711939293697L;

	//
	private List<String> uidList;
	

	/**
     * 单位工号
     */
    private String employeeNO;
    
    /**
     * 工作单位
     */
    private String unitCode;

    /**
     * 工作单描述（新增）
     */
    private String unitName;
    
    /**
     * 内部编号
     */
    private String agentInnerNO;
    
    /**
     * 单位所属地区
     */
    private String agentArea;

    /**
     * 姓名
     */
    private String agentName;
    
    /**
     * 性别
     */
    private String agentSex;
    

    /**
     * 单位层级
     */
    private String unitLevel;
    
    /**
     * 身份证号码
     */
    private String agentNO;
    
    /**
     * 所在业务部门（机构）
     */
    private String deptCode;
    
    /**
     * 所在业务部门（机构）描述(新增)
     */
    private String deptName;
    
    /**
     * 出生年月(新增)
     */
    private String birthDay;

    /**
     * 担任职务(新增)
     */
    private String agentPosition;

    /**
     * 年龄(新增)
     */
    private Integer agentAge;
    
    /**
     * 从事岗位（大类）
     */
    private String deptCatg;
    
    /**
     * 手机号码（新增）
     */
    private String mobile;

    /**
     * 岗位管辖片区
     */
    private String slicenNO;
    
    /**
     * 最高学历
     */
    private String studyLevel;
    
    /**
     * 从事本岗位起始时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date workTime;
    
    /**
     * 学历专业
     */
    private String professionals;
    
    /**
     * 工商执法证编号
     */
    private String lawNO;
    
    /**
     * 工商执法证有效期至(新增)
     */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date lawEndDate;
    
    /**
     * 个人专业技术职称(新增)
     */
    private String technicalTitle;
    
    /**
     * 省政府执法证编号(新增)
     */
    private String govLawNO;
    
    /**
     * 省政府执法证有效期至(新增)
     */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date govLawEndDate;
    
   /**
    * 获得岗位资格资质
    */
   private String stationTerm;
   
   /**
    * 是否属于专家（新增）
    */
   private String expertFlag;

   /**
    * 执法事项清单范围
    */
   private String agentRange;
   
   /**
    * 执法事项清单范围描述
    */
   private String agentRangeName;
   
   /**
    * 执法人员状态(新增)
    */
   private String agentState;

    /**
     * 单位类别
     */
    private String unitType;
    
    /**
     * 关联用户UId(暂时不用)
     */
    private String relateUserUid;
    
    /**
     * 关联用户名称(暂时不用)
     */
    @Transient
    private String relateUserName;

    /**
     * 设置人ID
     */
    private String setUserId;

    /**
     * 设置人
     */
    private String setUserName;

    /**
     * 设置人部门编码(新增)
     */
    private String setDeptcode;

    /**
     * 设置人部门中文表述(新增)
     */
    private String setDeptName;
    
    /**
     * 设置日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date setTime;

    /**
     * 时间戳
     */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date createTime;
    
    /**
     * 科室(暂时不用)
     */
    private String agentDeptName;
    
    /**
     * 管辖单位描述
     */
    private String slicenNOName;

	
	public void setUidList(List<String> uidList) {
		this.uidList = uidList;
	}
	public List<String> getUidList() {
		return uidList;
	}
	public String getEmployeeNO() {
		return employeeNO;
	}
	public void setEmployeeNO(String employeeNO) {
		this.employeeNO = employeeNO;
	}
	public String getUnitCode() {
		return unitCode;
	}
	public void setUnitCode(String unitCode) {
		this.unitCode = unitCode;
	}
	public String getUnitName() {
		return unitName;
	}
	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}
	public String getAgentInnerNO() {
		return agentInnerNO;
	}
	public void setAgentInnerNO(String agentInnerNO) {
		this.agentInnerNO = agentInnerNO;
	}
	public String getAgentArea() {
		return agentArea;
	}
	public void setAgentArea(String agentArea) {
		this.agentArea = agentArea;
	}
	public String getAgentName() {
		return agentName;
	}
	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}
	public String getAgentSex() {
		return agentSex;
	}
	public void setAgentSex(String agentSex) {
		this.agentSex = agentSex;
	}
	public String getUnitLevel() {
		return unitLevel;
	}
	public void setUnitLevel(String unitLevel) {
		this.unitLevel = unitLevel;
	}
	public String getAgentNO() {
		return agentNO;
	}
	public void setAgentNO(String agentNO) {
		this.agentNO = agentNO;
	}
	public String getDeptCode() {
		return deptCode;
	}
	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}
	public String getAgentPosition() {
		return agentPosition;
	}
	public void setAgentPosition(String agentPosition) {
		this.agentPosition = agentPosition;
	}
	public Integer getAgentAge() {
		return agentAge;
	}
	public void setAgentAge(Integer agentAge) {
		this.agentAge = agentAge;
	}
	public String getDeptCatg() {
		return deptCatg;
	}
	public void setDeptCatg(String deptCatg) {
		this.deptCatg = deptCatg;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getSlicenNO() {
		return slicenNO;
	}
	public void setSlicenNO(String slicenNO) {
		this.slicenNO = slicenNO;
	}
	public String getStudyLevel() {
		return studyLevel;
	}
	public void setStudyLevel(String studyLevel) {
		this.studyLevel = studyLevel;
	}
	public Date getWorkTime() {
		return workTime;
	}
	public void setWorkTime(Date workTime) {
		this.workTime = workTime;
	}
	public String getProfessionals() {
		return professionals;
	}
	public void setProfessionals(String professionals) {
		this.professionals = professionals;
	}
	public String getLawNO() {
		return lawNO;
	}
	public void setLawNO(String lawNO) {
		this.lawNO = lawNO;
	}
	public Date getLawEndDate() {
		return lawEndDate;
	}
	public void setLawEndDate(Date lawEndDate) {
		this.lawEndDate = lawEndDate;
	}
	public String getTechnicalTitle() {
		return technicalTitle;
	}
	public void setTechnicalTitle(String technicalTitle) {
		this.technicalTitle = technicalTitle;
	}
	public String getGovLawNO() {
		return govLawNO;
	}
	public void setGovLawNO(String govLawNO) {
		this.govLawNO = govLawNO;
	}
	public Date getGovLawEndDate() {
		return govLawEndDate;
	}
	public void setGovLawEndDate(Date govLawEndDate) {
		this.govLawEndDate = govLawEndDate;
	}
	public String getStationTerm() {
		return stationTerm;
	}
	public void setStationTerm(String stationTerm) {
		this.stationTerm = stationTerm;
	}
	public String getExpertFlag() {
		return expertFlag;
	}
	public void setExpertFlag(String expertFlag) {
		this.expertFlag = expertFlag;
	}
	public String getAgentRange() {
		return agentRange;
	}
	public void setAgentRange(String agentRange) {
		this.agentRange = agentRange;
	}
	public String getAgentRangeName() {
		return agentRangeName;
	}
	public void setAgentRangeName(String agentRangeName) {
		this.agentRangeName = agentRangeName;
	}
	public String getAgentState() {
		return agentState;
	}
	public void setAgentState(String agentState) {
		this.agentState = agentState;
	}
	public String getUnitType() {
		return unitType;
	}
	public void setUnitType(String unitType) {
		this.unitType = unitType;
	}
	public String getRelateUserUid() {
		return relateUserUid;
	}
	public void setRelateUserUid(String relateUserUid) {
		this.relateUserUid = relateUserUid;
	}
	public String getRelateUserName() {
		return relateUserName;
	}
	public void setRelateUserName(String relateUserName) {
		this.relateUserName = relateUserName;
	}
	public String getSetUserId() {
		return setUserId;
	}
	public void setSetUserId(String setUserId) {
		this.setUserId = setUserId;
	}
	public String getSetUserName() {
		return setUserName;
	}
	public void setSetUserName(String setUserName) {
		this.setUserName = setUserName;
	}
	public String getSetDeptcode() {
		return setDeptcode;
	}
	public void setSetDeptcode(String setDeptcode) {
		this.setDeptcode = setDeptcode;
	}
	public String getSetDeptName() {
		return setDeptName;
	}
	public void setSetDeptName(String setDeptName) {
		this.setDeptName = setDeptName;
	}
	public Date getSetTime() {
		return setTime;
	}
	public void setSetTime(Date setTime) {
		this.setTime = setTime;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getAgentDeptName() {
		return agentDeptName;
	}
	public void setAgentDeptName(String agentDeptName) {
		this.agentDeptName = agentDeptName;
	}
	public String getSlicenNOName() {
		return slicenNOName;
	}
	public void setSlicenNOName(String slicenNOName) {
		this.slicenNOName = slicenNOName;
	}
	
}