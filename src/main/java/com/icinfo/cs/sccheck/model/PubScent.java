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
 * 描述:    cs_pub_scent 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年05月17日
 */
@Table(name = "cs_pub_scent")
public class PubScent implements Serializable {
    /**
     * 自增长序号
     */
    @Id
    @Column(name = "id")
    private Integer id;

    /**
     * 序号：UUID
     */
    @Column(name = "Uid")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    private String uid;

    /**
     * 任务表序号
     */
    @Column(name = "TaskUid")
    private String taskUid;
    
    /**
     * 部门任务表序号
     */
    @Column(name = "DeptTaskUid")
    private String deptTaskUid;

    /**
     * 主体身份代码
     */
    @Column(name = "PriPID")
    private String priPID;

    /**
     * 时间戳
     */
    @Column(name = "SetTime")
    private Date setTime;
    
    
    /**
     * 企业(机构)名称
     */
    @Column(name = "EntName")
    private String entName;

    /**
     * 注册号(CA15)
     */
    @Column(name = "RegNO")
    private String regNO;

    /**
     * 市场主体类型(CA16)
     */
    @Column(name = "EntTypeCatg")
    private String entTypeCatg;
    
    /**
     * 成立日期
     */
    @Column(name = "EstDate")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date estDate;

    /**
     * 登记机关(CA11)
     */
    @Column(name = "RegOrg")
    private String regOrg;

    /**
     * 属地监管工商所
     */
    @Column(name = "LocalAdm")
    private String localAdm;

    /**
     * 登记状态(CA19)
     */
    @Column(name = "RegState")
    private String regState;

    /**
     * 统一社会信用代码(CA91)
     */
    @Column(name = "UniCode")
    private String uniCode;

    /**
     * 登记机关名称
     */
    @Column(name = "RegOrgName")
    private String regOrgName;

    /**
     * 属地监管工商所名称
     */
    @Column(name = "LocalAdmName")
    private String localAdmName;


    /**
     * 专项库编码
     */
    @Column(name = "SpecialCode")
    private String specialCode;

    /**
     * 专修描述
     */
    @Column(name = "SpecialName")
    private String specialName;
    
    /**
     * 关联专项库uid
     */
    @Column(name = "RelateUserUid")
    private String relateUserUid;

    /**
     * 上次检查日期
     */
    @Column(name = "LastCheckTime")
    private Date lastCheckTime;
    
    /**
     * 调整用户uid
     */
    @Column(name = "AdjustUserUid")
    private String adjustUserUid;
    
    /**
     * 调整用户名
     */
    @Column(name = "AdjustUserName")
    private String adjustUserName;

    /**
     * 调整日期
     */
    @Column(name = "AdjustTime")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date adjustTime;
    
    /**
     * 跨部门专项库UID
     */
    @Column(name = "DrSpeaialUid")
    private String drSpeaialUid;
    
    /**
     * 检查机关编码
     */
    @Column(name = "CheckDeptCode")
    private String checkDeptCode;

    /**
     * 检查部门描述
     */
    @Column(name = "CheckDeptName")
    private String checkDeptName;

    private static final long serialVersionUID = 1L;

    /**
     * 获取自增长序号
     *
     * @return id - 自增长序号
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置自增长序号
     *
     * @param id 自增长序号
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取序号：UUID
     *
     * @return Uid - 序号：UUID
     */
    public String getUid() {
        return uid;
    }

    /**
     * 设置序号：UUID
     *
     * @param uid 序号：UUID
     */
    public void setUid(String uid) {
        this.uid = uid;
    }

    /**
     * 获取任务表序号
     *
     * @return TaskUid - 任务表序号
     */
    public String getTaskUid() {
        return taskUid;
    }

    /**
     * 设置任务表序号
     *
     * @param taskUid 任务表序号
     */
    public void setTaskUid(String taskUid) {
        this.taskUid = taskUid;
    }

    /**
     * 获取主体身份代码
     *
     * @return PriPID - 主体身份代码
     */
    public String getPriPID() {
        return priPID;
    }

    /**
     * 设置主体身份代码
     *
     * @param priPID 主体身份代码
     */
    public void setPriPID(String priPID) {
        this.priPID = priPID;
    }

    /**
     * 获取时间戳
     *
     * @return SetTime - 时间戳
     */
    public Date getSetTime() {
        return setTime;
    }

    /**
     * 设置时间戳
     *
     * @param setTime 时间戳
     */
    public void setSetTime(Date setTime) {
        this.setTime = setTime;
    }

	public String getEntName() {
		return entName;
	}

	public void setEntName(String entName) {
		this.entName = entName;
	}

	public String getRegNO() {
		return regNO;
	}

	public void setRegNO(String regNO) {
		this.regNO = regNO;
	}

	public String getEntTypeCatg() {
		return entTypeCatg;
	}

	public void setEntTypeCatg(String entTypeCatg) {
		this.entTypeCatg = entTypeCatg;
	}

	public String getRegOrg() {
		return regOrg;
	}

	public void setRegOrg(String regOrg) {
		this.regOrg = regOrg;
	}

	public String getLocalAdm() {
		return localAdm;
	}

	public void setLocalAdm(String localAdm) {
		this.localAdm = localAdm;
	}

	public String getRegState() {
		return regState;
	}

	public void setRegState(String regState) {
		this.regState = regState;
	}

	public String getUniCode() {
		return uniCode;
	}

	public void setUniCode(String uniCode) {
		this.uniCode = uniCode;
	}

	public String getRegOrgName() {
		return regOrgName;
	}

	public void setRegOrgName(String regOrgName) {
		this.regOrgName = regOrgName;
	}

	public String getLocalAdmName() {
		return localAdmName;
	}

	public void setLocalAdmName(String localAdmName) {
		this.localAdmName = localAdmName;
	}

	public String getSpecialCode() {
		return specialCode;
	}

	public void setSpecialCode(String specialCode) {
		this.specialCode = specialCode;
	}

	public String getSpecialName() {
		return specialName;
	}

	public void setSpecialName(String specialName) {
		this.specialName = specialName;
	}

	public Date getLastCheckTime() {
		return lastCheckTime;
	}

	public void setLastCheckTime(Date lastCheckTime) {
		this.lastCheckTime = lastCheckTime;
	}
	
	public void setEstDate(Date estDate) {
		this.estDate = estDate;
	}
	public Date getEstDate() {
		return estDate;
	}

	public String getDeptTaskUid() {
		return deptTaskUid;
	}

	public void setDeptTaskUid(String deptTaskUid) {
		this.deptTaskUid = deptTaskUid;
	}

	public String getRelateUserUid() {
		return relateUserUid;
	}

	public void setRelateUserUid(String relateUserUid) {
		this.relateUserUid = relateUserUid;
	}

	public String getAdjustUserUid() {
		return adjustUserUid;
	}

	public void setAdjustUserUid(String adjustUserUid) {
		this.adjustUserUid = adjustUserUid;
	}

	public String getAdjustUserName() {
		return adjustUserName;
	}

	public void setAdjustUserName(String adjustUserName) {
		this.adjustUserName = adjustUserName;
	}

	public Date getAdjustTime() {
		return adjustTime;
	}

	public void setAdjustTime(Date adjustTime) {
		this.adjustTime = adjustTime;
	}

	public String getDrSpeaialUid() {
		return drSpeaialUid;
	}

	public void setDrSpeaialUid(String drSpeaialUid) {
		this.drSpeaialUid = drSpeaialUid;
	}

	public String getCheckDeptCode() {
		return checkDeptCode;
	}

	public void setCheckDeptCode(String checkDeptCode) {
		this.checkDeptCode = checkDeptCode;
	}

	public String getCheckDeptName() {
		return checkDeptName;
	}

	public void setCheckDeptName(String checkDeptName) {
		this.checkDeptName = checkDeptName;
	}
}