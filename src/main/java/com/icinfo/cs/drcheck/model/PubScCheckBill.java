/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.drcheck.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.icinfo.framework.mybatis.mapper.annotation.Before;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * 描述:    cs_pub_sccheck_bill 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年05月02日
 */
@Table(name = "cs_pub_sccheck_bill")
public class PubScCheckBill implements Serializable {
    /**
     * 序号
     */
    @Id
    @Column(name = "id")
    private Integer id;

    /**
     * uuid
     */
    @Column(name = "UID")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    private String UID;

    /**
     * 类别编码
     */
    @Column(name = "CheckCode")
    private String checkCode;

    /**
     * 类别描述
     */
    @Column(name = "CheckDesc")
    private String checkDesc;

    /**
     * 检查事项编码
     */
    @Column(name = "CheckItemCode")
    private String checkItemCode;

    /**
     * 检查事项描述
     */
    @Column(name = "CheckItemDesc")
    private String checkItemDesc;

    /**
     * 抽查检查依据
     */
    @Column(name = "CheckReason")
    private String checkReason;

    /**
     * 抽查检查主体
     */
    @Column(name = "CheckSubject")
    private String checkSubject;
    
    /**
     * 抽查检查对象
     */
    @Column(name = "CheckObject")
    private String checkObject;

    /**
     * 检查比例
     */
    @Column(name = "CheckScale")
    private String checkScale;

    /**
     * 检查频率
     */
    @Column(name = "CheckFrequent")
    private String checkFrequent;

    /**
     * 检查方式
     */
    @Column(name = "CheckWay")
    private String checkWay;

    /**
     * 检查人员要求
     */
    @Column(name = "CheckManFlag")
    private String checkManFlag;

    /**
     * 备注
     */
    @Column(name = "Remark")
    private String remark;

    /**
     * 责任处室
     */
    @Column(name = "ResponsibleOffices")
    private String responsibleOffices;

    /**
     * 失效有效
     */
    @Column(name = "IsScVlid")
    private String isScVlid;

    /**
     * 设置人ID
     */
    @Column(name = "SetUserUid")
    private String setUserUid;

    /**
     * 设置人
     */
    @Column(name = "SetUserName")
    private String setUserName;

    /**
     * 设置日期
     */
    @Column(name = "SetTime")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date setTime;

    /**
     * 设置人部门编码
     */
    @Column(name = "SetDeptcode")
    private String setDeptcode;

    /**
     * 设置人部门中文表述
     */
    @Column(name = "SetDeptName")
    private String setDeptName;

    /**
     * 抽查检查内容
     */
    @Column(name = "CheckContent")
    private String checkContent;
    
    /**
     * 职能部门编码
     */
    @Column(name = "DutyDeptCode")
    private String dutyDeptCode;

    private static final long serialVersionUID = 1L;

    /**
     * 获取序号
     *
     * @return id - 序号
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置序号
     *
     * @param id 序号
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
     * 获取类别编码
     *
     * @return CheckCode - 类别编码
     */
    public String getCheckCode() {
        return checkCode;
    }

    /**
     * 设置类别编码
     *
     * @param checkCode 类别编码
     */
    public void setCheckCode(String checkCode) {
        this.checkCode = checkCode;
    }

    /**
     * 获取类别描述
     *
     * @return CheckDesc - 类别描述
     */
    public String getCheckDesc() {
        return checkDesc;
    }

    /**
     * 设置类别描述
     *
     * @param checkDesc 类别描述
     */
    public void setCheckDesc(String checkDesc) {
        this.checkDesc = checkDesc;
    }

    /**
     * 获取检查事项编码
     *
     * @return CheckItemCode - 检查事项编码
     */
    public String getCheckItemCode() {
        return checkItemCode;
    }

    /**
     * 设置检查事项编码
     *
     * @param checkItemCode 检查事项编码
     */
    public void setCheckItemCode(String checkItemCode) {
        this.checkItemCode = checkItemCode;
    }

    /**
     * 获取检查事项描述
     *
     * @return CheckItemDesc - 检查事项描述
     */
    public String getCheckItemDesc() {
        return checkItemDesc;
    }

    /**
     * 设置检查事项描述
     *
     * @param checkItemDesc 检查事项描述
     */
    public void setCheckItemDesc(String checkItemDesc) {
        this.checkItemDesc = checkItemDesc;
    }

    /**
     * 获取抽查检查依据
     *
     * @return CheckReason - 抽查检查依据
     */
    public String getCheckReason() {
        return checkReason;
    }

    /**
     * 设置抽查检查依据
     *
     * @param checkReason 抽查检查依据
     */
    public void setCheckReason(String checkReason) {
        this.checkReason = checkReason;
    }

    /**
     * 获取抽查检查对象
     *
     * @return CheckObject - 抽查检查对象
     */
    public String getCheckObject() {
        return checkObject;
    }

    /**
     * 设置抽查检查对象
     *
     * @param checkObject 抽查检查对象
     */
    public void setCheckObject(String checkObject) {
        this.checkObject = checkObject;
    }

    /**
     * 获取检查比例
     *
     * @return CheckScale - 检查比例
     */
    public String getCheckScale() {
        return checkScale;
    }

    /**
     * 设置检查比例
     *
     * @param checkScale 检查比例
     */
    public void setCheckScale(String checkScale) {
        this.checkScale = checkScale;
    }

    /**
     * 获取检查频率
     *
     * @return CheckFrequent - 检查频率
     */
    public String getCheckFrequent() {
        return checkFrequent;
    }

    /**
     * 设置检查频率
     *
     * @param checkFrequent 检查频率
     */
    public void setCheckFrequent(String checkFrequent) {
        this.checkFrequent = checkFrequent;
    }

    /**
     * 获取检查方式
     *
     * @return CheckWay - 检查方式
     */
    public String getCheckWay() {
        return checkWay;
    }

    /**
     * 设置检查方式
     *
     * @param checkWay 检查方式
     */
    public void setCheckWay(String checkWay) {
        this.checkWay = checkWay;
    }

    /**
     * 获取检查人员要求
     *
     * @return CheckManFlag - 检查人员要求
     */
    public String getCheckManFlag() {
        return checkManFlag;
    }

    /**
     * 设置检查人员要求
     *
     * @param checkManFlag 检查人员要求
     */
    public void setCheckManFlag(String checkManFlag) {
        this.checkManFlag = checkManFlag;
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
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * 获取责任处室
     *
     * @return ResponsibleOffices - 责任处室
     */
    public String getResponsibleOffices() {
        return responsibleOffices;
    }

    /**
     * 设置责任处室
     *
     * @param responsibleOffices 责任处室
     */
    public void setResponsibleOffices(String responsibleOffices) {
        this.responsibleOffices = responsibleOffices;
    }

    /**
     * 获取失效有效
     *
     * @return IsScVlid - 失效有效
     */
    public String getIsScVlid() {
        return isScVlid;
    }

    /**
     * 设置失效有效
     *
     * @param isScVlid 失效有效
     */
    public void setIsScVlid(String isScVlid) {
        this.isScVlid = isScVlid;
    }

    /**
     * 获取设置人ID
     *
     * @return SetUserUid - 设置人ID
     */
    public String getSetUserUid() {
        return setUserUid;
    }

    /**
     * 设置设置人ID
     *
     * @param setUserUid 设置人ID
     */
    public void setSetUserUid(String setUserUid) {
        this.setUserUid = setUserUid;
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
     * 获取设置人部门编码
     *
     * @return SetDeptcode - 设置人部门编码
     */
    public String getSetDeptcode() {
        return setDeptcode;
    }

    /**
     * 设置设置人部门编码
     *
     * @param setDeptcode 设置人部门编码
     */
    public void setSetDeptcode(String setDeptcode) {
        this.setDeptcode = setDeptcode;
    }

    /**
     * 获取设置人部门中文表述
     *
     * @return SetDeptName - 设置人部门中文表述
     */
    public String getSetDeptName() {
        return setDeptName;
    }

    /**
     * 设置设置人部门中文表述
     *
     * @param setDeptName 设置人部门中文表述
     */
    public void setSetDeptName(String setDeptName) {
        this.setDeptName = setDeptName;
    }

    /**
     * 获取抽查检查内容
     *
     * @return CheckContent - 抽查检查内容
     */
    public String getCheckContent() {
        return checkContent;
    }

    /**
     * 设置抽查检查内容
     *
     * @param checkContent 抽查检查内容
     */
    public void setCheckContent(String checkContent) {
        this.checkContent = checkContent;
    }

	public String getCheckSubject() {
		return checkSubject;
	}

	public void setCheckSubject(String checkSubject) {
		this.checkSubject = checkSubject;
	}

	public String getDutyDeptCode() {
		return dutyDeptCode;
	}

	public void setDutyDeptCode(String dutyDeptCode) {
		this.dutyDeptCode = dutyDeptCode;
	}
}