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
 * 描述:    cs_code_mark_type 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年09月15日
 */
@Table(name = "cs_code_mark_type")
public class CodeMarkType implements Serializable {
    /**
     * 序号
     */
    @Id
    @Column(name = "id")
    private Integer id;

    /**
     * uid
     */
    @Column(name = "Uid")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    private String uid;

    /**
     * 标签编码
     */
    @Column(name = "MarkCode")
    private String markCode;

    /**
     * 标签名称
     */
    @Column(name = "MarkName")
    private String markName;

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

    @Column(name = "Remark")
    private String remark;

    /**
     * 是否需要专业监管标识
     */
    @Column(name = "CheckFlag")
    private String checkFlag;

    /**
     * 专业资格资质编码（多个以逗号隔开）
     */
    @Column(name = "RightCodes")
    private String rightCodes;
    
    /**
     * 专业资格资质编码（多个以逗号隔开）描述
     */
    @Column(name = "RightNames")
    private String rightNames;

    /**
     * 配备专家（组长）
     */
    @Column(name = "LeaderCodes")
    private String leaderCodes;
    
    /**
     * 配备专家（组长）描述
     */
    @Column(name = "LeaderNames")
    private String leaderNames;

    /**
     * 状态
     */
    @Column(name = "IsVlid")
    private String isVlid;

    /**
     * 创建日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @Column(name = "CreatTime")
    private Date creatTime;

    @Column(name = "SetUserUid")
    private String setUserUid;

    /**
     * 设置人姓名
     */
    @Column(name = "SetUserName")
    private String setUserName;

    /**
     * 设置部门编码
     */
    @Column(name = "SetDeptCode")
    private String setDeptCode;

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
     * 获取uid
     *
     * @return Uid - uid
     */
    public String getUid() {
        return uid;
    }

    /**
     * 设置uid
     *
     * @param uid uid
     */
    public void setUid(String uid) {
        this.uid = uid;
    }

    /**
     * 获取标签编码
     *
     * @return MarkCode - 标签编码
     */
    public String getMarkCode() {
        return markCode;
    }

    /**
     * 设置标签编码
     *
     * @param markCode 标签编码
     */
    public void setMarkCode(String markCode) {
        this.markCode = markCode;
    }

    /**
     * 获取标签名称
     *
     * @return MarkName - 标签名称
     */
    public String getMarkName() {
        return markName;
    }

    /**
     * 设置标签名称
     *
     * @param markName 标签名称
     */
    public void setMarkName(String markName) {
        this.markName = markName;
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
     * @return Remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     * @param remark
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * 获取是否需要专业监管标识
     *
     * @return CheckFlag - 是否需要专业监管标识
     */
    public String getCheckFlag() {
        return checkFlag;
    }

    /**
     * 设置是否需要专业监管标识
     *
     * @param checkFlag 是否需要专业监管标识
     */
    public void setCheckFlag(String checkFlag) {
        this.checkFlag = checkFlag;
    }

    /**
     * 获取专业资格资质编码（多个以逗号隔开）
     *
     * @return RightCodes - 专业资格资质编码（多个以逗号隔开）
     */
    public String getRightCodes() {
        return rightCodes;
    }

    /**
     * 设置专业资格资质编码（多个以逗号隔开）
     *
     * @param rightCodes 专业资格资质编码（多个以逗号隔开）
     */
    public void setRightCodes(String rightCodes) {
        this.rightCodes = rightCodes;
    }

    /**
     * 获取配备专家（组长）
     *
     * @return LeaderCodes - 配备专家（组长）
     */
    public String getLeaderCodes() {
        return leaderCodes;
    }

    /**
     * 设置配备专家（组长）
     *
     * @param leaderCodes 配备专家（组长）
     */
    public void setLeaderCodes(String leaderCodes) {
        this.leaderCodes = leaderCodes;
    }

    /**
     * 获取状态
     *
     * @return IsVlid - 状态
     */
    public String getIsVlid() {
        return isVlid;
    }

    /**
     * 设置状态
     *
     * @param isVlid 状态
     */
    public void setIsVlid(String isVlid) {
        this.isVlid = isVlid;
    }

    /**
     * 获取创建日期
     *
     * @return CreatTime - 创建日期
     */
    public Date getCreatTime() {
        return creatTime;
    }

    /**
     * 设置创建日期
     *
     * @param creatTime 创建日期
     */
    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    /**
     * @return SetUserUid
     */
    public String getSetUserUid() {
        return setUserUid;
    }

    /**
     * @param setUserUid
     */
    public void setSetUserUid(String setUserUid) {
        this.setUserUid = setUserUid;
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

	public String getRightNames() {
		return rightNames;
	}

	public void setRightNames(String rightNames) {
		this.rightNames = rightNames;
	}

	public String getLeaderNames() {
		return leaderNames;
	}

	public void setLeaderNames(String leaderNames) {
		this.leaderNames = leaderNames;
	}
}