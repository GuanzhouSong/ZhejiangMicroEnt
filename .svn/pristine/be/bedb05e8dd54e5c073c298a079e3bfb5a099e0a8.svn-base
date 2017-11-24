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

import com.fasterxml.jackson.annotation.JsonFormat;
import com.icinfo.framework.mybatis.mapper.annotation.Before;

/**
 * 描述:  cs_pub_scresult 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2016年10月25日
 */
/**
 * @author Administrator
 *
 */
@Table(name = "cs_pub_scresult")
public class PubScresult implements Serializable {
    /**
     * 自增序号
     */
    @Id
    @Column(name = "id")
    private Integer id;
    
    /**
     * 序号：任务表UUID
     */
    @Column(name = "UID")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    private String UID;
    
    /**
     * 实施部门任务表序号
     */
    @Column(name = "TaskNO")
    private String taskNO;

    /**
     * 主体身份代码
     */
    @Column(name = "PriPID")
    private String priPID;

    /**
     * 检查结果
     */
    @Column(name = "ScResult")
    private String scResult;

    /**
     * 具体情况记录
     */
    @Column(name = "ScDetail")
    private String scDetail;

    /**
     * 时间戳
     */
    @Column(name = "CreateTime")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date createTime;
    
    /**
     * 实施部门编码
     */
    @Column(name = "InspectDept")
    private String inspectDept;
    
    /**
     * 设置人id
     */
    @Column(name = "SetUserId")
    private String setUserId;
    
    /**
     * 设置人用户名
     */
    @Column(name = "SetUserName")
    private String setUserName;
    
    /**
     * 设置时间
     */
    @Column(name = "SetTime")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date setTime;
    
    /**
     * 审核结果0：待审核，1：同意，2：不同意
     */
    @Column(name = "AuditState")
    private String auditState;
    
    /**
     * 审核意见
     */
    @Column(name = "AuditOpin")
    private String auditOpin;
    
    /**
     * 审核人
     */
    @Column(name = "AuditName")
    private String auditName;
    
    /**
     * 审核日期
     */
    @Column(name = "AuditDate")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date auditDate;
    
    /**
     * 部门
     */
    @Column(name = "AuditDept")
    private String auditDept;
    
    /**
     * 其他说明情况
     */
    @Column(name = "Remark")
    private String remark;
    
    /**
     * 是否已填写
     */
    @Column(name = "ResultFlag")
    private String resultFlag;
    
    /**
     * 检查机关名称
     */
    @Column(name = "ScDeptName")
    private String scDeptName;
    
    /**
     * 检查时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @Column(name = "InspectDeptTime")
    private Date inspectDeptTime;

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
     * 获取实施部门任务表序号
     *
     * @return TaskNO - 任务表序号
     */
    public String getTaskNO() {
        return taskNO;
    }

    /**
     * 设置实施部门任务表序号
     *
     * @param taskNO 任务表序号
     */
    public void setTaskNO(String taskNO) {
        this.taskNO = taskNO;
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
     * 获取检查结果
     *
     * @return ScResult - 检查结果
     */
    public String getScResult() {
        return scResult;
    }

    /**
     * 设置检查结果
     *
     * @param scResult 检查结果
     */
    public void setScResult(String scResult) {
        this.scResult = scResult;
    }

    /**
     * 获取具体情况记录
     *
     * @return ScDetail - 具体情况记录
     */
    public String getScDetail() {
        return scDetail;
    }

    /**
     * 设置具体情况记录
     *
     * @param scDetail 具体情况记录
     */
    public void setScDetail(String scDetail) {
        this.scDetail = scDetail;
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

	public String getUID() {
		return UID;
	}

	public void setUID(String uID) {
		UID = uID;
	}

	public String getInspectDept() {
		return inspectDept;
	}

	public void setInspectDept(String inspectDept) {
		this.inspectDept = inspectDept;
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

	public Date getSetTime() {
		return setTime;
	}

	public void setSetTime(Date setTime) {
		this.setTime = setTime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getResultFlag() {
		return resultFlag;
	}

	public void setResultFlag(String resultFlag) {
		this.resultFlag = resultFlag;
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

	public String getScDeptName() {
		return scDeptName;
	}

	public void setScDeptName(String scDeptName) {
		this.scDeptName = scDeptName;
	}

	public Date getInspectDeptTime() {
		return inspectDeptTime;
	}

	public void setInspectDeptTime(Date inspectDeptTime) {
		this.inspectDeptTime = inspectDeptTime;
	}
}