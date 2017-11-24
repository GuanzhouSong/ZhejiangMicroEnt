/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.yr.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 描述:    cs_sys_license 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2016年08月30日
 */
@Table(name = "cs_sys_license")
public class SysLicense implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 7478474015593835031L;

	@Id
    @Column(name = "id")
    private Integer id;

	// 许可事项名称
    @Column(name = "LicName")
    private String licName;

    // 许可事项编号
    @Column(name = "LicNO")
    private String licNO;

    // 创建时间
    @Column(name = "CreateTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")  
    private Date createTime;

    // 类型(1前置,2后置)
    @Column(name = "LicType")
    private String licType;

    // 级别
    @Column(name = "LicZone")
    private String licZone;

    // 审批部门类型
    @Column(name = "LicDeptType")
    private String licDeptType;

    // 审批部门
    @Column(name = "LicDept")
    private String licDept;

    // 设置时间
    @Column(name = "SetTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")  
    private Date setTime;

    // 设置人姓名
    @Column(name = "SetName")
    private String setName;

    // 设置人id
    @Column(name = "SetId")
    private String setId;

    // 是否有效(1有效,0无效)
    @Column(name = "IsValid")
    private String isValid;

    // 法律依据
    @Column(name = "LicRea")
    private String licRea;
    
    // 排序优先级依据
    @Column(name = "OrderBy")
    private Integer orderBy;

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
     * @return LicName
     */
    public String getLicName() {
        return licName;
    }

    /**
     * @param licName
     */
    public void setLicName(String licName) {
        this.licName = licName;
    }

    /**
     * @return LicNO
     */
    public String getLicNO() {
        return licNO;
    }

    /**
     * @param licNO
     */
    public void setLicNO(String licNO) {
        this.licNO = licNO;
    }

    /**
     * @return CreateTime
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return LicType
     */
    public String getLicType() {
        return licType;
    }

    /**
     * @param licType
     */
    public void setLicType(String licType) {
        this.licType = licType;
    }

    /**
     * @return LicZone
     */
    public String getLicZone() {
        return licZone;
    }

    /**
     * @param licZone
     */
    public void setLicZone(String licZone) {
        this.licZone = licZone;
    }

    /**
     * @return LicDeptType
     */
    public String getLicDeptType() {
        return licDeptType;
    }

    /**
     * @param licDeptType
     */
    public void setLicDeptType(String licDeptType) {
        this.licDeptType = licDeptType;
    }

    /**
     * @return LicDept
     */
    public String getLicDept() {
        return licDept;
    }

    /**
     * @param licDept
     */
    public void setLicDept(String licDept) {
        this.licDept = licDept;
    }

    /**
     * @return SetTime
     */
    public Date getSetTime() {
        return setTime;
    }

    /**
     * @param setTime
     */
    public void setSetTime(Date setTime) {
        this.setTime = setTime;
    }

    /**
     * @return SetName
     */
    public String getSetName() {
        return setName;
    }

    /**
     * @param setName
     */
    public void setSetName(String setName) {
        this.setName = setName;
    }

    /**
     * @return SetId
     */
    public String getSetId() {
        return setId;
    }

    /**
     * @param setId
     */
    public void setSetId(String setId) {
        this.setId = setId;
    }

    /**
     * @return IsValid
     */
    public String getIsValid() {
        return isValid;
    }

    /**
     * @param isValid
     */
    public void setIsValid(String isValid) {
        this.isValid = isValid;
    }

    /**
     * @return LicRea
     */
    public String getLicRea() {
        return licRea;
    }

    /**
     * @param licRea
     */
    public void setLicRea(String licRea) {
        this.licRea = licRea;
    }

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SysLicense [id=");
		builder.append(id);
		builder.append(", licName=");
		builder.append(licName);
		builder.append(", licNO=");
		builder.append(licNO);
		builder.append(", createTime=");
		builder.append(createTime);
		builder.append(", licType=");
		builder.append(licType);
		builder.append(", licZone=");
		builder.append(licZone);
		builder.append(", licDeptType=");
		builder.append(licDeptType);
		builder.append(", licDept=");
		builder.append(licDept);
		builder.append(", setTime=");
		builder.append(setTime);
		builder.append(", setName=");
		builder.append(setName);
		builder.append(", setId=");
		builder.append(setId);
		builder.append(", isValid=");
		builder.append(isValid);
		builder.append(", licRea=");
		builder.append(licRea);
		builder.append("]");
		return builder.toString();
	}
	
	
	public void setOrderBy(Integer orderBy) {
		this.orderBy = orderBy;
	}
	
	public Integer getOrderBy() {
		return orderBy;
	}
    
}