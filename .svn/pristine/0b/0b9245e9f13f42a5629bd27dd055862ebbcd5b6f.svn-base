/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.yr.model;

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
 * 描述:    cs_pub_excludeent 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2016年08月30日
 */
@Table(name = "cs_pub_excludeent")
public class PubExcludeEnt implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -6580687664129565824L;

	@Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "PriPID")
    private String priPID;

    @Column(name = "UID")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "select replace(uuid(), '-', '')")
    private String UID;

    // 限制来函部门
    @Column(name = "ExcDept")
    private String excDept;

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

    // 限制公示理由
    @Column(name = "ExcRea")
    private String excRea;

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
     * @return PriPID
     */
    public String getPriPID() {
        return priPID;
    }

    /**
     * @param priPID
     */
    public void setPriPID(String priPID) {
        this.priPID = priPID;
    }

    /**
     * @return UID
     */
    public String getUID() {
        return UID;
    }

    /**
     * @param UID
     */
    public void setUUID(String UID) {
        this.UID = UID;
    }

    /**
     * @return ExcDept
     */
    public String getExcDept() {
        return excDept;
    }

    /**
     * @param excDept
     */
    public void setExcDept(String excDept) {
        this.excDept = excDept;
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
     * @return ExcRea
     */
    public String getExcRea() {
        return excRea;
    }

    /**
     * @param excRea
     */
    public void setExcRea(String excRea) {
        this.excRea = excRea;
    }

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PubExcludeEnt [id=");
		builder.append(id);
		builder.append(", priPID=");
		builder.append(priPID);
		builder.append(", UID=");
		builder.append(UID);
		builder.append(", excDept=");
		builder.append(excDept);
		builder.append(", setTime=");
		builder.append(setTime);
		builder.append(", setName=");
		builder.append(setName);
		builder.append(", setId=");
		builder.append(setId);
		builder.append(", isValid=");
		builder.append(isValid);
		builder.append(", excRea=");
		builder.append(excRea);
		builder.append("]");
		return builder.toString();
	}
    
}