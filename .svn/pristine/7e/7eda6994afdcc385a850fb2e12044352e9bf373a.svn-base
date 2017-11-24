/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.specialrec.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.icinfo.framework.mybatis.mapper.annotation.Before;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * 描述:    cs_special_rec_result 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年11月02日
 */
@Table(name = "cs_special_rec_result")
public class SpecialRecResult implements Serializable {
	
    @Id
    @Column(name = "id")
    private Integer id;

    /**
     * 唯一标识
     */
    @Column(name = "Uid")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    private String uid;

    /**
     * 任务UID
     */
    @Column(name = "TaskUid")
    private String taskUid;

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
     * 注册号
     */
    @Column(name = "RegNO")
    private String regNO;

    /**
     * 统一社会信用代码
     */
    @Column(name = "UniCode")
    private String uniCode;

    /**
     * 检查状态 0-待录入 1-已录入
     */
    @Column(name = "CheckState")
    private String checkState;

    /**
     * 检查执行部门编码
     */
    @Column(name = "CheckDeptCode")
    private String checkDeptCode;

    /**
     * 检查执行部门名称
     */
    @Column(name = "CheckDeptName")
    private String checkDeptName;

    /**
     * 检查人
     */
    @Column(name = "CheckDeptPerson")
    private String checkDeptPerson;

    /**
     * 检查结果
     */
    @Column(name = "CheckResult")
    private String checkResult;

    /**
     * 检查时间
     */
    @Column(name = "CheckDate")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date checkDate;

    /**
     * 检查方式
     */
    @Column(name = "CheckType")
    private String checkType;

    /**
     * 后续处置措施
     */
    @Column(name = "DisposeMss")
    private String disposeMss;

    /**
     * 后续处置状态1-未完结 2-已完结
     */
    @Column(name = "DisposeState")
    private String disposeState;

    /**
     * 后续处置完结信息
     */
    @Column(name = "DisposeFinishMss")
    private String disposeFinishMss;

    /**
     * 后续处置完结时间
     */
    @Column(name = "DisposeFinishDate")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date disposeFinishDate;

    /**
     * 录入人
     */
    @Column(name = "EnterUserName")
    private String enterUserName;

    /**
     * 录入时间
     */
    @Column(name = "EnterDate")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date enterDate;
    
    /**
     * 修改内容
     */
    @Column(name = "ModifyContent")
    private String modifyContent;
    
    /**
     * 修改人
     */
    @Column(name = "ModifyName")
    private String modifyName;
    
    /**
     * 修改时间
     */
    @Column(name = "ModifyDate")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date modifyDate;
    
    /**
     * 检查机关编码
     */
    @Column(name = "SetDeptCode")
    private String setDeptCode;
    
    /**
     * 检查机关名称
     */
    @Column(name = "SetDeptName")
    private String setDeptName;
    
    /**
     * 指派人姓名
     */
    @Column(name = "AssignName")
    private String assignName;
    
    /**
     * 指派时间
     */
    @Column(name = "AssignDate")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date assignDate;

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
     * @return Uid - 唯一标识
     */
    public String getUid() {
        return uid;
    }

    /**
     * 设置唯一标识
     *
     * @param uid 唯一标识
     */
    public void setUid(String uid) {
        this.uid = uid;
    }

    /**
     * 获取任务UID
     *
     * @return TaskUid - 任务UID
     */
    public String getTaskUid() {
        return taskUid;
    }

    /**
     * 设置任务UID
     *
     * @param taskUid 任务UID
     */
    public void setTaskUid(String taskUid) {
        this.taskUid = taskUid;
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
     * @param priPID 主体代码
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
     * @param entName 企业名称
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
     * @param regNO 注册号
     */
    public void setRegNO(String regNO) {
        this.regNO = regNO;
    }

    /**
     * 获取统一社会信用代码
     *
     * @return UniCode - 统一社会信用代码
     */
    public String getUniCode() {
        return uniCode;
    }

    /**
     * 设置统一社会信用代码
     *
     * @param uniCode 统一社会信用代码
     */
    public void setUniCode(String uniCode) {
        this.uniCode = uniCode;
    }

    /**
     * 获取检查状态
     *
     * @return CheckState - 检查状态
     */
    public String getCheckState() {
        return checkState;
    }

    /**
     * 设置检查状态
     *
     * @param checkState 检查状态
     */
    public void setCheckState(String checkState) {
        this.checkState = checkState;
    }

    /**
     * 获取检查执行部门编码
     *
     * @return CheckDeptCode - 检查执行部门编码
     */
    public String getCheckDeptCode() {
        return checkDeptCode;
    }

    /**
     * 设置检查执行部门编码
     *
     * @param checkDeptCode 检查执行部门编码
     */
    public void setCheckDeptCode(String checkDeptCode) {
        this.checkDeptCode = checkDeptCode;
    }

    /**
     * 获取检查执行部门名称
     *
     * @return CheckDeptName - 检查执行部门名称
     */
    public String getCheckDeptName() {
        return checkDeptName;
    }

    /**
     * 设置检查执行部门名称
     *
     * @param checkDeptName 检查执行部门名称
     */
    public void setCheckDeptName(String checkDeptName) {
        this.checkDeptName = checkDeptName;
    }

    /**
     * 获取检查人
     *
     * @return CheckDeptPerson - 检查人
     */
    public String getCheckDeptPerson() {
        return checkDeptPerson;
    }

    /**
     * 设置检查人
     *
     * @param checkDeptPerson 检查人
     */
    public void setCheckDeptPerson(String checkDeptPerson) {
        this.checkDeptPerson = checkDeptPerson;
    }

    /**
     * 获取检查结果
     *
     * @return CheckResult - 检查结果
     */
    public String getCheckResult() {
        return checkResult;
    }

    /**
     * 设置检查结果
     *
     * @param checkResult 检查结果
     */
    public void setCheckResult(String checkResult) {
        this.checkResult = checkResult;
    }

    /**
     * 获取检查时间
     *
     * @return CheckDate - 检查时间
     */
    public Date getCheckDate() {
        return checkDate;
    }

    /**
     * 设置检查时间
     *
     * @param checkDate 检查时间
     */
    public void setCheckDate(Date checkDate) {
        this.checkDate = checkDate;
    }

    /**
     * 获取检查方式
     *
     * @return CheckType - 检查方式
     */
    public String getCheckType() {
        return checkType;
    }

    /**
     * 设置检查方式
     *
     * @param checkType 检查方式
     */
    public void setCheckType(String checkType) {
        this.checkType = checkType;
    }

    /**
     * 获取后续处置措施
     *
     * @return DisposeMss - 后续处置措施
     */
    public String getDisposeMss() {
        return disposeMss;
    }

    /**
     * 设置后续处置措施
     *
     * @param disposeMss 后续处置措施
     */
    public void setDisposeMss(String disposeMss) {
        this.disposeMss = disposeMss;
    }

    /**
     * 获取后续处置状态1-未完结 2-已完结
     *
     * @return DisposeState - 后续处置状态1-未完结 2-已完结
     */
    public String getDisposeState() {
        return disposeState;
    }

    /**
     * 设置后续处置状态1-未完结 2-已完结
     *
     * @param disposeState 后续处置状态1-未完结 2-已完结
     */
    public void setDisposeState(String disposeState) {
        this.disposeState = disposeState;
    }

    /**
     * 获取后续处置完结信息
     *
     * @return DisposeFinishMss - 后续处置完结信息
     */
    public String getDisposeFinishMss() {
        return disposeFinishMss;
    }

    /**
     * 设置后续处置完结信息
     *
     * @param disposeFinishMss 后续处置完结信息
     */
    public void setDisposeFinishMss(String disposeFinishMss) {
        this.disposeFinishMss = disposeFinishMss;
    }

    /**
     * 获取后续处置完结时间
     *
     * @return DisposeFinishDate - 后续处置完结时间
     */
    public Date getDisposeFinishDate() {
        return disposeFinishDate;
    }

    /**
     * 设置后续处置完结时间
     *
     * @param disposeFinishDate 后续处置完结时间
     */
    public void setDisposeFinishDate(Date disposeFinishDate) {
        this.disposeFinishDate = disposeFinishDate;
    }

    /**
     * 获取录入人
     *
     * @return EnterUserName - 录入人
     */
    public String getEnterUserName() {
        return enterUserName;
    }

    /**
     * 设置录入人
     *
     * @param enterUserName 录入人
     */
    public void setEnterUserName(String enterUserName) {
        this.enterUserName = enterUserName;
    }

    /**
     * 获取录入时间
     *
     * @return EnterDate - 录入时间
     */
    public Date getEnterDate() {
        return enterDate;
    }

    /**
     * 设置录入时间
     *
     * @param enterDate 录入时间
     */
    public void setEnterDate(Date enterDate) {
        this.enterDate = enterDate;
    }

	public String getSetDeptCode() {
		return setDeptCode;
	}

	public void setSetDeptCode(String setDeptCode) {
		this.setDeptCode = setDeptCode;
	}

	public String getSetDeptName() {
		return setDeptName;
	}

	public void setSetDeptName(String setDeptName) {
		this.setDeptName = setDeptName;
	}

	public String getModifyName() {
		return modifyName;
	}

	public void setModifyName(String modifyName) {
		this.modifyName = modifyName;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public String getModifyContent() {
		return modifyContent;
	}

	public void setModifyContent(String modifyContent) {
		this.modifyContent = modifyContent;
	}

	public String getAssignName() {
		return assignName;
	}

	public void setAssignName(String assignName) {
		this.assignName = assignName;
	}

	public Date getAssignDate() {
		return assignDate;
	}

	public void setAssignDate(Date assignDate) {
		this.assignDate = assignDate;
	}
    
}