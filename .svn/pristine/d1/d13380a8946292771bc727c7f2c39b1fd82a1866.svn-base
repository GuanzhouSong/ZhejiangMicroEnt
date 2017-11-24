/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.sccheck.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.icinfo.framework.mybatis.mapper.annotation.Before;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * 描述:    cs_code_special_type 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年09月15日
 */
@Table(name = "cs_code_special_type")
public class CodeSpecialType implements Serializable {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "Uid")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    private String uid;
    
    /**
     * 专项库编码
     */
    @Column(name = "SpecialCode")
    private String specialCode;

    /**
     * 专项库名称
     */
    @Column(name = "SpecialName")
    private String specialName;

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
     * 是否有效
     */
    @Column(name = "IsVlid")
    private String isVlid;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @Column(name = "CreatTime")
    private Date creatTime;

    /**
     * 设置人姓名
     */
    @Column(name = "SetUserName")
    private String setUserName;

    /**
     * 设置人UID
     */
    @Column(name = "SetUserUid")
    private String setUserUid;

    /**
     * 设置部门编码
     */
    @Column(name = "SetDeptCode")
    private String setDeptCode;
    
    /**
     * 描述
     */
    @Column(name = "Remark")
    private String remark;
    
    /**
     * 检查事项编码
     */
    @Column(name = "CheckCode")
    private String checkCode;
    
    /**
     * 检查事项描述
     */
    @Column(name = "CheckName")
    private String checkName;

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
     * 获取专项库编码
     *
     * @return SpecialCode - 专项库编码
     */
    public String getSpecialCode() {
        return specialCode;
    }

    /**
     * 设置专项库编码
     *
     * @param specialCode 专项库编码
     */
    public void setSpecialCode(String specialCode) {
        this.specialCode = specialCode;
    }

    /**
     * 获取专项库名称
     *
     * @return SpecialName - 专项库名称
     */
    public String getSpecialName() {
        return specialName;
    }

    /**
     * 设置专项库名称
     *
     * @param specialName 专项库名称
     */
    public void setSpecialName(String specialName) {
        this.specialName = specialName;
    }

    /**
     * 获取职能部门编码
     *
     * @return DutyDeptCode - 职能部门编码
     */
    public String getDutyDeptCode() {
        return dutyDeptCode;
    }

    /**
     * 设置职能部门编码
     *
     * @param dutyDeptCode 职能部门编码
     */
    public void setDutyDeptCode(String dutyDeptCode) {
        this.dutyDeptCode = dutyDeptCode;
    }

    /**
     * 获取职能部门名称
     *
     * @return DutyDeptName - 职能部门名称
     */
    public String getDutyDeptName() {
        return dutyDeptName;
    }

    /**
     * 设置职能部门名称
     *
     * @param dutyDeptName 职能部门名称
     */
    public void setDutyDeptName(String dutyDeptName) {
        this.dutyDeptName = dutyDeptName;
    }

    /**
     * @return CreatTime
     */
    public Date getCreatTime() {
        return creatTime;
    }

    /**
     * @param creatTime
     */
    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    /**
     * 获取设置人姓名
     *
     * @return SetUserName - 设置人姓名
     */
    public String getSetUserName() {
        return setUserName;
    }

    /**
     * 设置设置人姓名
     *
     * @param setUserName 设置人姓名
     */
    public void setSetUserName(String setUserName) {
        this.setUserName = setUserName;
    }

    /**
     * 获取设置人UID
     *
     * @return SetUserUid - 设置人UID
     */
    public String getSetUserUid() {
        return setUserUid;
    }

    /**
     * 设置设置人UID
     *
     * @param setUserUid 设置人UID
     */
    public void setSetUserUid(String setUserUid) {
        this.setUserUid = setUserUid;
    }

    /**
     * 获取设置部门编码
     *
     * @return SetDeptCode - 设置部门编码
     */
    public String getSetDeptCode() {
        return setDeptCode;
    }

    /**
     * 设置设置部门编码
     *
     * @param setDeptCode 设置部门编码
     */
    public void setSetDeptCode(String setDeptCode) {
        this.setDeptCode = setDeptCode;
    }

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getIsVlid() {
		return isVlid;
	}

	public void setIsVlid(String isVlid) {
		this.isVlid = isVlid;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getCheckCode() {
		return checkCode;
	}

	public void setCheckCode(String checkCode) {
		this.checkCode = checkCode;
	}

	public String getCheckName() {
		return checkName;
	}

	public void setCheckName(String checkName) {
		this.checkName = checkName;
	}
}