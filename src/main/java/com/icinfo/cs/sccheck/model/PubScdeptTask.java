/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.sccheck.model;

import com.icinfo.framework.mybatis.mapper.annotation.Before;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * 描述:    pub_scdept_task 对应的实体类.(抽取人员名单状态)<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年05月19日
 */
@Table(name = "pub_scdept_task")
public class PubScdeptTask implements Serializable {
    /**
     * 自增序号
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
     * 主任务Uid
     */
    @Column(name = "TaskUid")
    private String taskUid;

    /**
     * 任务状态
     */
    @Column(name = "DeptState")
    private String deptState;

    /**
     * 检查人员数
     */
    @Column(name = "CheckNum")
    private Integer checkNum;

    /**
     * 专家人员数
     */
    @Column(name = "SpecialNum")
    private Integer specialNum;

    /**
     * 检查对象数量
     */
    @Column(name = "EntNum")
    private Integer entNum;

    /**
     * 计划制定部门编码
     */
    @Column(name = "deptCode")
    private String deptCode;
    
    /**
     * 计划制定部门编码8位
     */
    @Column(name = "UnitDeptCode")
    private String unitDeptCode;

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
     * 导入用户uid
     */
    @Column(name = "RelateUserUid")
    private String relateUserUid;

    /**
     * 设置时间
     */
    @Column(name = "SetTime")
    private Date setTime;
    

    /**
     * 每家企业最小检查人数
     */
    @Column(name = "MinNum")
    private Integer minNum;
    
    /**
     * 执法人员抽取方式（1-按检查小组建库；2-按检查人员建库）
     */
    @Column(name = "RandomType")
    private String randomType;
    

    /**
     * 随机抽取时间
     */
    @Column(name = "RandomDate")
    private Date randomDate;

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
     * 获取主任务Uid
     *
     * @return TaskUid - 主任务Uid
     */
    public String getTaskUid() {
        return taskUid;
    }

    /**
     * 设置主任务Uid
     *
     * @param taskUid 主任务Uid
     */
    public void setTaskUid(String taskUid) {
        this.taskUid = taskUid;
    }

    /**
     * 获取任务状态
     *
     * @return DeptState - 任务状态
     */
    public String getDeptState() {
        return deptState;
    }

    /**
     * 设置任务状态
     *
     * @param deptState 任务状态
     */
    public void setDeptState(String deptState) {
        this.deptState = deptState;
    }

    /**
     * 获取检查人员数
     *
     * @return CheckNum - 检查人员数
     */
    public Integer getCheckNum() {
        return checkNum;
    }

    /**
     * 设置检查人员数
     *
     * @param checkNum 检查人员数
     */
    public void setCheckNum(Integer checkNum) {
        this.checkNum = checkNum;
    }

    /**
     * 获取专家人员数
     *
     * @return SpecialNum - 专家人员数
     */
    public Integer getSpecialNum() {
        return specialNum;
    }

    /**
     * 设置专家人员数
     *
     * @param specialNum 专家人员数
     */
    public void setSpecialNum(Integer specialNum) {
        this.specialNum = specialNum;
    }

    /**
     * 获取检查对象数量
     *
     * @return EntNum - 检查对象数量
     */
    public Integer getEntNum() {
        return entNum;
    }

    /**
     * 设置检查对象数量
     *
     * @param entNum 检查对象数量
     */
    public void setEntNum(Integer entNum) {
        this.entNum = entNum;
    }

    /**
     * 获取计划制定部门编码
     *
     * @return deptCode - 计划制定部门编码
     */
    public String getDeptCode() {
        return deptCode;
    }

    /**
     * 设置计划制定部门编码
     *
     * @param deptCode 计划制定部门编码
     */
    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
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

	public String getRelateUserUid() {
		return relateUserUid;
	}

	public void setRelateUserUid(String relateUserUid) {
		this.relateUserUid = relateUserUid;
	}

	public Integer getMinNum() {
		return minNum;
	}

	public void setMinNum(Integer minNum) {
		this.minNum = minNum;
	}

	public String getUnitDeptCode() {
		return unitDeptCode;
	}

	public void setUnitDeptCode(String unitDeptCode) {
		this.unitDeptCode = unitDeptCode;
	}

	public String getRandomType() {
		return randomType;
	}

	public void setRandomType(String randomType) {
		this.randomType = randomType;
	}

	public Date getRandomDate() {
		return randomDate;
	}

	public void setRandomDate(Date randomDate) {
		this.randomDate = randomDate;
	}
}