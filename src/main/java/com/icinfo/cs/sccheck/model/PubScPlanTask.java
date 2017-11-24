/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.sccheck.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 描述:    cs_pub_scplan_task 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年05月17日
 */
@Table(name = "cs_pub_scplan_task")
public class PubScPlanTask implements Serializable {
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
    private String uid;

    /**
     * 任务编号
     */
    @Column(name = "TaskCode")
    private String taskCode;

    /**
     * 任务名称
     */
    @Column(name = "TaskName")
    private String taskName;

    /**
     * 任务状态：待执行01,执行中02,已完成10
     */
    @Column(name = "TaskState")
    private String taskState;

    /**
     * 任务组织部门
     */
    @Column(name = "TaskLeadDeptCode")
    private String taskLeadDeptCode;

    /**
     * 任务组织部门描述
     */
    @Column(name = "TaskLeadDeptName")
    private String taskLeadDeptName;

    /**
     * 任务来源：临时任务-1，年度抽查工作计划-2
     */
    @Column(name = "TaskResource")
    private String taskResource;

    /**
     * 年度抽查工作计划UID
     */
    @Column(name = "ResourcePlanUid")
    private String resourcePlanUid;

    /**
     * 年度抽查工作计划名称
     */
    @Column(name = "ResourcePlanName")
    private String resourcePlanName;
    
    /**
     * 任务实施部门名称
     */
    @Column(name = "TaskInspectDeptName")
    private String taskInspectDeptName;
    
    /**
     * 任务实施部门编码
     */
    @Column(name = "TaskInspectDeptCode")
    private String taskInspectDeptCode;

    /**
     * 任务期限起始
     */
    @Column(name = "TaskStartTime")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date taskStartTime;

    /**
     * 任务期限结束
     */
    @Column(name = "TaskEndTime")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date taskEndTime;

    /**
     * 抽查方式：定向-1，不定向-2
     */
    @Column(name = "TaskType")
    private String taskType;

    /**
     * 检查对象：企业-1，农专社-2，个体户-3，外企代表机构-4，多个以逗号隔开【来源，随机抽取企业之后生成】
     */
    @Column(name = "TaskObject")
    private String taskObject;

    /**
     * 入库对象筛选条件说明（200字内）
     */
    @Column(name = "TaskCondition")
    private String taskCondition;

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
     * 序号年度
     */
    @Column(name = "SeqYear")
    private Integer seqYear;
    

    /**
     * 设置人姓名
     */
    @Column(name = "SetUserName")
    private String setUserName;

    /**
     * 设置时间
     */
    @Column(name = "SetTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date setTime;

    /**
     * 任务内容
     */
    @Column(name = "TaskContent")
    private String taskContent;
    
    /**
     * 随机抽取模式
     */
    @Column(name = "RandomType")
    private String randomType;
    
    /**
     * 随机抽取日期
     */
    @Column(name = "RandomDate")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date randomDate;
    
    /**
     * 检查对象抽取库总户数（去重）
     */
    @Column(name = "EntTotal")
    private Integer entTotal;
    
    /**
     * 抽取目标总户数（去重）
     */
    @Column(name = "RandomTotal")
    private Integer randomTotal;
    
    /**
     * 总抽取比例
     */
    @Column(name = "RandomPercent")
    private String randomPercent;
    
    /**
     * 国家局公示内部序号-抽查检查
     */
    @Column(name = "InnerCode")
    private String innerCode;
    
    /**
     * 职能部门编码
     */
    @Column(name = "DutyDeptCode")
    private String dutyDeptCode;
    
    /**
     * 职能部门描述
     */
    @Column(name = "DutyDeptName")
    private String dutyDeptName;
    
    /**
     * 是否跨部门，1-本部门，2-跨部门
     */
    @Column(name = "CrossDepartFlag")
    private String crossDepartFlag;
    
    /**
     * 检查事项数量
     */
    @Column(name = "ItemNum")
    private Integer itemNum;
    
    /**
     * 抽取对象名单是否公示1-公示2不公示
     */
    @Column(name = "PublicFlag")
    private String publicFlag;

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

    public Integer getSeqYear() {
		return seqYear;
	}

	public void setSeqYear(Integer seqYear) {
		this.seqYear = seqYear;
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
     * 获取任务编号
     *
     * @return TaskCode - 任务编号
     */
    public String getTaskCode() {
        return taskCode;
    }

    /**
     * 设置任务编号
     *
     * @param taskCode 任务编号
     */
    public void setTaskCode(String taskCode) {
        this.taskCode = taskCode;
    }

    /**
     * 获取任务名称
     *
     * @return TaskName - 任务名称
     */
    public String getTaskName() {
        return taskName;
    }

    /**
     * 设置任务名称
     *
     * @param taskName 任务名称
     */
    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    /**
     * 获取任务状态：待执行01,执行中02,已完成10
     *
     * @return TaskState - 任务状态：待执行01,执行中02,已完成10
     */
    public String getTaskState() {
        return taskState;
    }

    /**
     * 设置任务状态：待执行01,执行中02,已完成10
     *
     * @param taskState 任务状态：待执行01,执行中02,已完成10
     */
    public void setTaskState(String taskState) {
        this.taskState = taskState;
    }

    /**
     * 获取任务组织部门
     *
     * @return TaskLeadDeptCode - 任务组织部门
     */
    public String getTaskLeadDeptCode() {
        return taskLeadDeptCode;
    }

    /**
     * 设置任务组织部门
     *
     * @param taskLeadDeptCode 任务组织部门
     */
    public void setTaskLeadDeptCode(String taskLeadDeptCode) {
        this.taskLeadDeptCode = taskLeadDeptCode;
    }

    /**
     * 获取任务组织部门描述
     *
     * @return TaskLeadDeptName - 任务组织部门描述
     */
    public String getTaskLeadDeptName() {
        return taskLeadDeptName;
    }

    /**
     * 设置任务组织部门描述
     *
     * @param taskLeadDeptName 任务组织部门描述
     */
    public void setTaskLeadDeptName(String taskLeadDeptName) {
        this.taskLeadDeptName = taskLeadDeptName;
    }

    /**
     * 获取任务来源：临时任务-1，年度抽查工作计划-2
     *
     * @return TaskResource - 任务来源：临时任务-1，年度抽查工作计划-2
     */
    public String getTaskResource() {
        return taskResource;
    }

    /**
     * 设置任务来源：临时任务-1，年度抽查工作计划-2
     *
     * @param taskResource 任务来源：临时任务-1，年度抽查工作计划-2
     */
    public void setTaskResource(String taskResource) {
        this.taskResource = taskResource;
    }

    /**
     * 获取年度抽查工作计划UID
     *
     * @return ResourcePlanUid - 年度抽查工作计划UID
     */
    public String getResourcePlanUid() {
        return resourcePlanUid;
    }

    /**
     * 设置年度抽查工作计划UID
     *
     * @param resourcePlanUid 年度抽查工作计划UID
     */
    public void setResourcePlanUid(String resourcePlanUid) {
        this.resourcePlanUid = resourcePlanUid;
    }

    /**
     * 获取年度抽查工作计划名称
     *
     * @return ResourcePlanName - 年度抽查工作计划名称
     */
    public String getResourcePlanName() {
        return resourcePlanName;
    }

    /**
     * 设置年度抽查工作计划名称
     *
     * @param resourcePlanName 年度抽查工作计划名称
     */
    public void setResourcePlanName(String resourcePlanName) {
        this.resourcePlanName = resourcePlanName;
    }

    /**
     * 获取任务期限起始
     *
     * @return TaskStartTime - 任务期限起始
     */
    public Date getTaskStartTime() {
        return taskStartTime;
    }

    /**
     * 设置任务期限起始
     *
     * @param taskStartTime 任务期限起始
     */
    public void setTaskStartTime(Date taskStartTime) {
        this.taskStartTime = taskStartTime;
    }

    /**
     * 获取任务期限结束
     *
     * @return TaskEndTime - 任务期限结束
     */
    public Date getTaskEndTime() {
        return taskEndTime;
    }

    /**
     * 设置任务期限结束
     *
     * @param taskEndTime 任务期限结束
     */
    public void setTaskEndTime(Date taskEndTime) {
        this.taskEndTime = taskEndTime;
    }

    /**
     * 获取抽查方式：定向-1，不定向-2
     *
     * @return TaskType - 抽查方式：定向-1，不定向-2
     */
    public String getTaskType() {
        return taskType;
    }

    /**
     * 设置抽查方式：定向-1，不定向-2
     *
     * @param taskType 抽查方式：定向-1，不定向-2
     */
    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }

    /**
     * 获取检查对象：企业-1，农专社-2，个体户-3，外企代表机构-4，多个以逗号隔开【来源，随机抽取企业之后生成】
     *
     * @return TaskObject - 检查对象：企业-1，农专社-2，个体户-3，外企代表机构-4，多个以逗号隔开【来源，随机抽取企业之后生成】
     */
    public String getTaskObject() {
        return taskObject;
    }

    /**
     * 设置检查对象：企业-1，农专社-2，个体户-3，外企代表机构-4，多个以逗号隔开【来源，随机抽取企业之后生成】
     *
     * @param taskObject 检查对象：企业-1，农专社-2，个体户-3，外企代表机构-4，多个以逗号隔开【来源，随机抽取企业之后生成】
     */
    public void setTaskObject(String taskObject) {
        this.taskObject = taskObject;
    }

    /**
     * 获取入库对象筛选条件说明（200字内）
     *
     * @return TaskCondition - 入库对象筛选条件说明（200字内）
     */
    public String getTaskCondition() {
        return taskCondition;
    }

    /**
     * 设置入库对象筛选条件说明（200字内）
     *
     * @param taskCondition 入库对象筛选条件说明（200字内）
     */
    public void setTaskCondition(String taskCondition) {
        this.taskCondition = taskCondition;
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

    /**
     * 获取任务内容
     *
     * @return TaskContent - 任务内容
     */
    public String getTaskContent() {
        return taskContent;
    }

    /**
     * 设置任务内容
     *
     * @param taskContent 任务内容
     */
    public void setTaskContent(String taskContent) {
        this.taskContent = taskContent;
    }

	public String getTaskInspectDeptName() {
		return taskInspectDeptName;
	}

	public void setTaskInspectDeptName(String taskInspectDeptName) {
		this.taskInspectDeptName = taskInspectDeptName;
	}

	public String getTaskInspectDeptCode() {
		return taskInspectDeptCode;
	}

	public void setTaskInspectDeptCode(String taskInspectDeptCode) {
		this.taskInspectDeptCode = taskInspectDeptCode;
	}

	public String getRandomType() {
		return randomType;
	}

	public void setRandomType(String randomType) {
		this.randomType = randomType;
	}

	public Integer getEntTotal() {
		return entTotal;
	}

	public void setEntTotal(Integer entTotal) {
		this.entTotal = entTotal;
	}

	public Integer getRandomTotal() {
		return randomTotal;
	}

	public void setRandomTotal(Integer randomTotal) {
		this.randomTotal = randomTotal;
	}

	public String getRandomPercent() {
		return randomPercent;
	}

	public void setRandomPercent(String randomPercent) {
		this.randomPercent = randomPercent;
	}

	public Date getRandomDate() {
		return randomDate;
	}

	public void setRandomDate(Date randomDate) {
		this.randomDate = randomDate;
	}

	public String getInnerCode() {
		return innerCode;
	}

	public void setInnerCode(String innerCode) {
		this.innerCode = innerCode;
	}

	public String getDutyDeptCode() {
		return dutyDeptCode;
	}

	public void setDutyDeptCode(String dutyDeptCode) {
		this.dutyDeptCode = dutyDeptCode;
	}

	public String getDutyDeptName() {
		return dutyDeptName;
	}

	public void setDutyDeptName(String dutyDeptName) {
		this.dutyDeptName = dutyDeptName;
	}

	public String getCrossDepartFlag() {
		return crossDepartFlag;
	}

	public void setCrossDepartFlag(String crossDepartFlag) {
		this.crossDepartFlag = crossDepartFlag;
	}

	public Integer getItemNum() {
		return itemNum;
	}

	public void setItemNum(Integer itemNum) {
		this.itemNum = itemNum;
	}

	public String getPublicFlag() {
		return publicFlag;
	}

	public void setPublicFlag(String publicFlag) {
		this.publicFlag = publicFlag;
	}

	
}