/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.dtinfo.model;

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
 * 描述:    cs_lic_dept 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2016年10月19日
 */
@Table(name = "cs_lic_dept")
public class LicDept implements Serializable {
    /**
     * 主键ID
     */
    @Id
    @Column(name = "id")
    private Integer id;

    /**
     * 审批事项编码
     */
    @Column(name = "ExaCode")
    private String exaCode;

    /**
     * 审批部门编码
     */
    @Column(name = "DeptCode")
    private String deptCode;
    
    /**
     * 实际审批部门名称
     */
    @Column(name = "DeptName")
    private String deptName;

    /**
     * 是否有效
     */
    @Column(name = "IsValid")
    private String isValid;

    /**
     * 设置人
     */
    @Column(name = "SetName")
    private String setName;

    /**
     * 设置日期
     */
    @Column(name = "SetTime")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")  
    private Date setTime;

    /**
     * 登记/属地 1:登记； 2：属地
     */
    @Column(name = "LicDeptType")
    private String licDeptType;
    
    /**
     * 职能部门编码
     */
    @Column(name = "DutyDeptCode")
    private String dutyDeptCode;
    
    
    /**
     * 职能部门名称
     */
    @Column(name = "DutyDeptName")
    private String dutyDeptName;

    /**
     * 时间戳
     */
    @Column(name = "CreateTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8") 
    private Date createTime;

    private static final long serialVersionUID = 1L;
    
    /**
     * 主键
     */
    @Column(name = "UID")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    private String uid;
    
    /**
     * 实际审批部门编码
     */
    @Column(name = "AdCode")
    private String adCode;
    
    /**
     * 实际审批部门名称
     */
    @Column(name = "OrgName")
    private String orgName; 
    
   
   /**
    * 企业所在行政区划
    */
   @Column(name = "Yiedistrict")
   private String yiedistrict;
   
   /**
    * 企业所在行政区划
    */
   @Column(name = "IsSameGov")
   private String isSameGov;

   /**
    * 行政区划名称
    */
   @Column(name = "AreaName")
   private String areaName;
   
   
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
     * 获取审批事项编码
     *
     * @return ExaCode - 审批事项编码
     */
    public String getExaCode() {
        return exaCode;
    }

    /**
     * 设置审批事项编码
     *
     * @param exaCode 审批事项编码
     */
    public void setExaCode(String exaCode) {
        this.exaCode = exaCode;
    }

    /**
     * 获取审批部门编码
     *
     * @return DeptCode - 审批部门编码
     */
    public String getDeptCode() {
        return deptCode;
    }

    /**
     * 设置审批部门编码
     *
     * @param deptCode 审批部门编码
     */
    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    /**
     * 获取是否有效
     *
     * @return IsValid - 是否有效
     */
    public String getIsValid() {
        return isValid;
    }

    /**
     * 设置是否有效
     *
     * @param isValid 是否有效
     */
    public void setIsValid(String isValid) {
        this.isValid = isValid;
    }

    /**
     * 获取设置人
     *
     * @return SetName - 设置人
     */
    public String getSetName() {
        return setName;
    }

    /**
     * 设置设置人
     *
     * @param setName 设置人
     */
    public void setSetName(String setName) {
        this.setName = setName;
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
     * 获取登记/属地 1:登记； 2：属地
     *
     * @return LicDeptType - 登记/属地 1:登记； 2：属地
     */
    public String getLicDeptType() {
        return licDeptType;
    }

    /**
     * 设置登记/属地 1:登记； 2：属地
     *
     * @param licDeptType 登记/属地 1:登记； 2：属地
     */
    public void setLicDeptType(String licDeptType) {
        this.licDeptType = licDeptType;
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

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getDutyDeptCode() {
		return dutyDeptCode;
	}

	public void setDutyDeptCode(String dutyDeptCode) {
		this.dutyDeptCode = dutyDeptCode;
	}

	public String getDutyDeptName() {
		return dutyDeptName;
	}

	public void setDutyDeptName(String dutyDeptName) {
		this.dutyDeptName = dutyDeptName;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getAdCode() {
		return adCode;
	}

	public void setAdCode(String adCode) {
		this.adCode = adCode;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	} 

	public String getYiedistrict() {
		return yiedistrict;
	}

	public void setYiedistrict(String yiedistrict) {
		this.yiedistrict = yiedistrict;
	}

	public String getIsSameGov() {
		return isSameGov;
	}

	public void setIsSameGov(String isSameGov) {
		this.isSameGov = isSameGov;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	} 
}