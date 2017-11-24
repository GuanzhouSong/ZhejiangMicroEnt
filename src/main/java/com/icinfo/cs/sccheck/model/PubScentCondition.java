/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.sccheck.model;

import com.icinfo.framework.mybatis.mapper.annotation.Before;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * 描述:    cs_pub_scent_condition 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年05月17日
 */
@Table(name = "cs_pub_scent_condition")
public class PubScentCondition implements Serializable {
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
     * 检查事项编码
     */
    @Column(name = "CheckCode")
    private String checkCode;

    /**
     * 检查事项名称
     */
    @Column(name = "CheckName")
    private String checkName;

    /**
     * 专项库编码
     */
    @Column(name = "SpecialCode")
    private String specialCode;

    /**
     * 专项库描述
     */
    @Column(name = "SpecialName")
    private String specialName;

    /**
     * 当前检查对象对应的检查户数
     */
    @Column(name = "SpecialNum")
    private Integer specialNum;

    /**
     * 抽取目标户数
     */
    @Column(name = "RandomNum")
    private Integer randomNum;

    /**
     * 计划制定部门编码
     */
    @Column(name = "SetDeptCode")
    private String setDeptCode;

    /**
     * 计划制定部门描述
     */
    @Column(name = "SetDeptName")
    private String setDeptName;

    /**
     * 设置用户Uid
     */
    @Column(name = "SetUserUid")
    private String setUserUid;

    /**
     * 设置人姓名
     */
    @Column(name = "SetUserName")
    private String setUserName;

    /**
     * 设置时间
     */
    @Column(name = "SetTime")
    private Date setTime;
    
    /**
     * 抽取模式
     */
    @Column(name = "CheckType")
    private String checkType;

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
     * 获取检查事项编码
     *
     * @return CheckCode - 检查事项编码
     */
    public String getCheckCode() {
        return checkCode;
    }

    /**
     * 设置检查事项编码
     *
     * @param checkCode 检查事项编码
     */
    public void setCheckCode(String checkCode) {
        this.checkCode = checkCode;
    }

    /**
     * 获取检查事项名称
     *
     * @return CheckName - 检查事项名称
     */
    public String getCheckName() {
        return checkName;
    }

    /**
     * 设置检查事项名称
     *
     * @param checkName 检查事项名称
     */
    public void setCheckName(String checkName) {
        this.checkName = checkName;
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
     * 获取专修描述
     *
     * @return SpecialName - 专修描述
     */
    public String getSpecialName() {
        return specialName;
    }

    /**
     * 设置专修描述
     *
     * @param specialName 专修描述
     */
    public void setSpecialName(String specialName) {
        this.specialName = specialName;
    }

    /**
     * 获取当前检查对象对应的检查户数
     *
     * @return SpecialNum - 当前检查对象对应的检查户数
     */
    public Integer getSpecialNum() {
        return specialNum;
    }

    /**
     * 设置当前检查对象对应的检查户数
     *
     * @param specialNum 当前检查对象对应的检查户数
     */
    public void setSpecialNum(Integer specialNum) {
        this.specialNum = specialNum;
    }

    /**
     * 获取抽取目标户数
     *
     * @return RandomNum - 抽取目标户数
     */
    public Integer getRandomNum() {
        return randomNum;
    }

    /**
     * 设置抽取目标户数
     *
     * @param randomNum 抽取目标户数
     */
    public void setRandomNum(Integer randomNum) {
        this.randomNum = randomNum;
    }

    /**
     * 获取计划制定部门编码
     *
     * @return SetDeptCode - 计划制定部门编码
     */
    public String getSetDeptCode() {
        return setDeptCode;
    }

    /**
     * 设置计划制定部门编码
     *
     * @param setDeptCode 计划制定部门编码
     */
    public void setSetDeptCode(String setDeptCode) {
        this.setDeptCode = setDeptCode;
    }

    /**
     * 获取计划制定部门描述
     *
     * @return SetDeptName - 计划制定部门描述
     */
    public String getSetDeptName() {
        return setDeptName;
    }

    /**
     * 设置计划制定部门描述
     *
     * @param setDeptName 计划制定部门描述
     */
    public void setSetDeptName(String setDeptName) {
        this.setDeptName = setDeptName;
    }

    /**
     * 获取设置用户Uid
     *
     * @return SetUserUid - 设置用户Uid
     */
    public String getSetUserUid() {
        return setUserUid;
    }

    /**
     * 设置设置用户Uid
     *
     * @param setUserUid 设置用户Uid
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
     * 获取设置时间
     *
     * @return SetTime - 设置时间
     */
    public Date getSetTime() {
        return setTime;
    }

    /**
     * 设置设置时间
     *
     * @param setTime 设置时间
     */
    public void setSetTime(Date setTime) {
        this.setTime = setTime;
    }

	public String getCheckType() {
		return checkType;
	}

	public void setCheckType(String checkType) {
		this.checkType = checkType;
	}
}