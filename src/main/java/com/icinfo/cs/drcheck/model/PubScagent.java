/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.drcheck.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.icinfo.framework.mybatis.mapper.annotation.Before;

/**
 * 描述:  cs_pub_scagent 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2016年10月26日
 */
/**
 * @author Administrator
 *
 */
@Table(name = "cs_pub_scagent")
public class PubScagent implements Serializable {
	 /**
     * 自增序号
     */
    @Id
    @Column(name = "id")
  
    private Integer id;
    
    /**
     * 唯一标识
     */
    @Column(name = "UID")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    private String UID;
    
	/**
     * 单位工号
     */
    @Column(name = "EmployeeNO")
    private String employeeNO;
    
    /**
     * 工作单位
     */
    @Column(name = "UnitCode")
    private String unitCode;

    /**
     * 工作单描述（新增）
     */
    @Column(name = "UnitName")
    private String unitName;
    
    /**
     * 内部编号
     */
    @Column(name = "AgentInnerNO")
    private String agentInnerNO;
    
    /**
     * 单位所属地区
     */
    @Column(name = "AgentArea")
    private String agentArea;

    /**
     * 姓名
     */
    @Column(name = "AgentName")
    private String agentName;
    
    /**
     * 性别
     */
    @Column(name = "AgentSex")
    private String agentSex;
    

    /**
     * 单位层级
     */
    @Column(name = "UnitLevel")
    private String unitLevel;
    
    /**
     * 身份证号码
     */
    @Column(name = "AgentNO")
    private String agentNO;
    
    /**
     * 所在业务部门（机构）
     */
    @Column(name = "DeptCode")
    private String deptCode;
    
    /**
     * 职能部门编码
     */
    @Column(name = "DutyDeptCode")
    private String dutyDeptCode;
    
    /**
     * 所在业务部门（机构）描述(新增)
     */
    @Column(name = "DeptName")
    private String deptName;
    
    /**
     * 出生年月(新增)
     */
    @Column(name = "BirthDay")
    private String birthDay;

    /**
     * 担任职务(新增)
     */
    @Column(name = "AgentPosition")
    private String agentPosition;

    /**
     * 年龄(新增)
     */
    @Column(name = "AgentAge")
    private Integer agentAge;
    
    /**
     * 从事岗位（大类）
     */
    @Column(name = "DeptCatg")
    private String deptCatg;
    
    /**
     * 手机号码（新增）
     */
    @Column(name = "Mobile")
    private String mobile;

    /**
     * 岗位管辖片区
     */
    @Column(name = "SlicenNO")
    private String slicenNO;
    
    /**
     * 工作单位名称
     */
    @Column(name = "SlicenNOName")
    private String slicenNOName;
    
    /**
     * 最高学历
     */
    @Column(name = "StudyLevel")
    private String studyLevel;
    
    /**
     * 从事本岗位起始时间
     */
    @Column(name = "WorkTime")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date workTime;
    
    /**
     * 学历专业
     */
    @Column(name = "Professionals")
    private String professionals;
    
    /**
     * 发证部门
     */
    @Column(name = "CertificateDept")
    private String certificateDept;
    
    /**
     * 具体职务
     */
    @Column(name = "ConcreteDuties")
    private String concreteDuties;
    
    /**
     * 所在市
     */
    @Column(name = "LocCity")
    private String locCity;
    
    /**
     * 所在区县
     */
    @Column(name = "LocCounty")
    private String locCounty;
    
    /**
     * 所在街道
     */
    @Column(name = "LocAddress")
    private String locAddress;
    
    /**
     * 行政区划全名
     */
    @Column(name = "LocAreaName")
    private String locAreaName;
    
    /**
     * 工商执法证编号
     */
    @Column(name = "LawNO")
    private String lawNO;
    
    /**
     * 工商执法证有效期至(新增)
     */
    @Column(name = "LawEndDate")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date lawEndDate;
    
    /**
     * 个人专业技术职称(新增)
     */
    @Column(name = "TechnicalTitle")
    private String technicalTitle;
    
    /**
     * 省政府执法证编号(新增)
     */
    @Column(name = "GovLawNO")
    private String govLawNO;
    
    /**
     * 省政府执法证有效期至(新增)
     */
    @Column(name = "GovLawEndDate")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date govLawEndDate;
    
   /**
    * 获得岗位资格资质
    */
   @Column(name = "StationTerm")
   private String stationTerm;
   
   /**
    * 是否属于专家（新增）
    */
   @Column(name = "ExpertFlag")
   private String expertFlag;

   /**
    * 执法事项清单范围
    */
   @Column(name = "AgentRange")
   private String agentRange;
   
   /**
    * 执法事项清单范围描述
    */
   @Column(name = "AgentRangeName")
   private String agentRangeName;
   
   /**
    * 执法人员状态(新增)
    */
   @Column(name = "AgentState")
   private String agentState;

    /**
     * 单位类别
     */
    @Column(name = "UnitType")
    private String unitType;
    
    /**
     * 关联用户UId(暂时不用)
     */
    @Column(name = "RelateUserUid")
    private String relateUserUid;
    
    /**
     * 关联用户名称(暂时不用)
     */
    @Transient
    private String relateUserName;

    /**
     * 设置人ID
     */
    @Column(name = "SetUserId")
    private String setUserId;

    /**
     * 设置人
     */
    @Column(name = "SetUserName")
    private String setUserName;

    /**
     * 设置人部门编码(新增)
     */
    @Column(name = "SetDeptcode")
    private String setDeptcode;

    /**
     * 设置人部门中文表述(新增)
     */
    @Column(name = "SetDeptName")
    private String setDeptName;
    
    /**
     * 设置日期
     */
    @Column(name = "SetTime")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date setTime;

    /**
     * 时间戳
     */
    @Column(name = "CreateTime")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date createTime;
    
    /**
     * 科室(暂时不用)
     */
    @Column(name = "AgentDeptName")
    private String agentDeptName;
    
    private static final long serialVersionUID = 1L;

    /**
     * 获取自增序号
     *
     * @return id - 自增序号
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置自增序号
     *
     * @param id 自增序号
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取uuid
     *
     * @return UID - uuid
     */
    public String getUID() {
        return UID;
    }

    /**
     * 设置uuid
     *
     * @param UID uuid
     */
    public void setUID(String UID) {
        this.UID = UID;
    }

    /**
     * 获取单位
     *
     * @return UnitCode - 单位
     */
    public String getUnitCode() {
        return unitCode;
    }

    /**
     * 设置单位
     *
     * @param unitCode 单位
     */
    public void setUnitCode(String unitCode) {
        this.unitCode = unitCode;
    }

    /**
     * 获取单位层级
     *
     * @return UnitLevel - 单位层级
     */
    public String getUnitLevel() {
        return unitLevel;
    }

    /**
     * 设置单位层级
     *
     * @param unitLevel 单位层级
     */
    public void setUnitLevel(String unitLevel) {
        this.unitLevel = unitLevel;
    }

    /**
     * 获取部门机构
     *
     * @return DeptCode - 部门机构
     */
    public String getDeptCode() {
        return deptCode;
    }

    /**
     * 设置部门机构
     *
     * @param deptCode 部门机构
     */
    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    /**
     * 获取岗位大类
     *
     * @return DeptCatg - 岗位大类
     */
    public String getDeptCatg() {
        return deptCatg;
    }

    /**
     * 设置岗位大类
     *
     * @param deptCatg 岗位大类
     */
    public void setDeptCatg(String deptCatg) {
        this.deptCatg = deptCatg;
    }

    /**
     * 获取姓名
     *
     * @return AgentName - 姓名
     */
    public String getAgentName() {
        return agentName;
    }

    /**
     * 设置姓名
     *
     * @param agentName 姓名
     */
    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    /**
     * 获取身份证号码
     *
     * @return AgentNO - 身份证号码
     */
    public String getAgentNO() {
        return agentNO;
    }

    /**
     * 设置身份证号码
     *
     * @param agentNO 身份证号码
     */
    public void setAgentNO(String agentNO) {
        this.agentNO = agentNO;
    }

    /**
     * 获取所属地区
     *
     * @return AgentArea - 所属地区
     */
    public String getAgentArea() {
        return agentArea;
    }

    /**
     * 设置所属地区
     *
     * @param agentArea 所属地区
     */
    public void setAgentArea(String agentArea) {
        this.agentArea = agentArea;
    }

    /**
     * 获取岗位管辖片区
     *
     * @return SlicenNO - 岗位管辖片区
     */
    public String getSlicenNO() {
        return slicenNO;
    }

    /**
     * 设置岗位管辖片区
     *
     * @param slicenNO 岗位管辖片区
     */
    public void setSlicenNO(String slicenNO) {
        this.slicenNO = slicenNO;
    }

    /**
     * 获取执法清单范围
     *
     * @return AgentRange - 执法清单范围
     */
    public String getAgentRange() {
        return agentRange;
    }

    /**
     * 设置执法清单范围
     *
     * @param agentRange 执法清单范围
     */
    public void setAgentRange(String agentRange) {
        this.agentRange = agentRange;
    }

    /**
     * 获取设置人ID
     *
     * @return SetUserId - 设置人ID
     */
    public String getSetUserId() {
        return setUserId;
    }

    /**
     * 设置设置人ID
     *
     * @param setUserId 设置人ID
     */
    public void setSetUserId(String setUserId) {
        this.setUserId = setUserId;
    }

    /**
     * 获取设置人
     *
     * @return SetUserName - 设置人
     */
    public String getSetUserName() {
        return setUserName;
    }

    /**
     * 设置设置人
     *
     * @param setUserName 设置人
     */
    public void setSetUserName(String setUserName) {
        this.setUserName = setUserName;
    }

    /**
     * 获取设置日期
     *
     * @return SetTime - 设置日期
     */
    public Date getSetTime() {
        return setTime;
    }

    /**
     * 设置设置日期
     *
     * @param setTime 设置日期
     */
    public void setSetTime(Date setTime) {
        this.setTime = setTime;
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

	public String getEmployeeNO() {
		return employeeNO;
	}

	public void setEmployeeNO(String employeeNO) {
		this.employeeNO = employeeNO;
	}

	public String getStudyLevel() {
		return studyLevel;
	}

	public void setStudyLevel(String studyLevel) {
		this.studyLevel = studyLevel;
	}

	public String getProfessionals() {
		return professionals;
	}

	public void setProfessionals(String professionals) {
		this.professionals = professionals;
	}

	public String getStationTerm() {
		return stationTerm;
	}

	public void setStationTerm(String stationTerm) {
		this.stationTerm = stationTerm;
	}

	public Date getWorkTime() {
		return workTime;
	}

	public void setWorkTime(Date workTime) {
		this.workTime = workTime;
	}

	public String getLawNO() {
		return lawNO;
	}

	public void setLawNO(String lawNO) {
		this.lawNO = lawNO;
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
	
    public String getAgentInnerNO() {
		return agentInnerNO;
	}

	public void setAgentInnerNO(String agentInnerNO) {
		this.agentInnerNO = agentInnerNO;
	}

	public String getAgentDeptName() {
		return agentDeptName;
	}

	public void setAgentDeptName(String agentDeptName) {
		this.agentDeptName = agentDeptName;
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

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
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

	public String getExpertFlag() {
		return expertFlag;
	}

	public void setExpertFlag(String expertFlag) {
		this.expertFlag = expertFlag;
	}

	public String getAgentState() {
		return agentState;
	}

	public void setAgentState(String agentState) {
		this.agentState = agentState;
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

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public String getAgentRangeName() {
		return agentRangeName;
	}

	public void setAgentRangeName(String agentRangeName) {
		this.agentRangeName = agentRangeName;
	}

	public String getAgentSex() {
		return agentSex;
	}

	public void setAgentSex(String agentSex) {
		this.agentSex = agentSex;
	}

	public String getSlicenNOName() {
		return slicenNOName;
	}

	public void setSlicenNOName(String slicenNOName) {
		this.slicenNOName = slicenNOName;
	}

	public String getCertificateDept() {
		return certificateDept;
	}

	public void setCertificateDept(String certificateDept) {
		this.certificateDept = certificateDept;
	}

	public String getConcreteDuties() {
		return concreteDuties;
	}

	public void setConcreteDuties(String concreteDuties) {
		this.concreteDuties = concreteDuties;
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

	public String getLocAddress() {
		return locAddress;
	}

	public void setLocAddress(String locAddress) {
		this.locAddress = locAddress;
	}

	public String getLocAreaName() {
		return locAreaName;
	}

	public void setLocAreaName(String locAreaName) {
		this.locAreaName = locAreaName;
	}

	public String getDutyDeptCode() {
		return dutyDeptCode;
	}

	public void setDutyDeptCode(String dutyDeptCode) {
		this.dutyDeptCode = dutyDeptCode;
	}
    
	
}