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
 * 描述:  cs_pub_dept_sctask 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2016年10月25日
 */
@Table(name = "cs_pub_dept_sctask")
public class PubDeptSctask implements Serializable {
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
     * 序号：任务表UUID
     */
    @Column(name = "TaskNO")
    private String taskNO;

    /**
     * 实施部门编码
     */
    @Column(name = "InspectDept")
    private String inspectDept;

    /**
     * 实施部门描述
     */
    @Column(name = "InspectDesc")
    private String inspectDesc;

    /**
     * 实施状态
     */
    @Column(name = "InspectState")
    private String inspectState;

    @Column(name = "InspectType")
    private String inspectType;
    
    @Column(name="InspectTypeDesc")
    private String inspectTypeDesc;
    /**
     * 检查人员(多个以逗号分开)
     */
    @Column(name = "InspectUserNames")
    private String inspectUserNames;

    /**
     * 检查机关(多个以逗号分开)
     */
    @Column(name = "InspectDepts")
    private String inspectDepts;

    /**
     * 检查日期
     */
    @Column(name = "InspectDate")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date inspectDate;

    /**
     * 创建时间
     */
    @Column(name = "CreateTime")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date createTime;

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
     * 获取序号：任务表UUID
     *
     * @return TaskNO - 序号：任务表UUID
     */
    public String getTaskNO() {
        return taskNO;
    }
  
    public String getInspectTypeDesc() {
		return inspectTypeDesc;
	}

	public void setInspectTypeDesc(String inspectTypeDesc) {
		this.inspectTypeDesc = inspectTypeDesc;
	}

	/**
     * 设置序号：任务表UUID
     *
     * @param taskNO 序号：任务表UUID
     */
    public void setTaskNO(String taskNO) {
        this.taskNO = taskNO;
    }

    /**
     * 获取实施部门编码
     *
     * @return InspectDept - 实施部门编码
     */
    public String getInspectDept() {
        return inspectDept;
    }

    /**
     * 设置实施部门编码
     *
     * @param inspectDept 实施部门编码
     */
    public void setInspectDept(String inspectDept) {
        this.inspectDept = inspectDept;
    }

    /**
     * 获取实施部门描述
     *
     * @return InspectDesc - 实施部门描述
     */
    public String getInspectDesc() {
        return inspectDesc;
    }

    /**
     * 设置实施部门描述
     *
     * @param inspectDesc 实施部门描述
     */
    public void setInspectDesc(String inspectDesc) {
        this.inspectDesc = inspectDesc;
    }

    /**
     * 获取实施状态
     *
     * @return InspectState - 实施状态
     */
    public String getInspectState() {
        return inspectState;
    }

    /**
     * 设置实施状态
     *
     * @param inspectState 实施状态
     */
    public void setInspectState(String inspectState) {
        this.inspectState = inspectState;
    }

    /**
     * @return InspectType
     */
    public String getInspectType() {
        return inspectType;
    }

    /**
     * @param inspectType
     */
    public void setInspectType(String inspectType) {
        this.inspectType = inspectType;
    }

    /**
     * 获取检查人员(多个以逗号分开)
     *
     * @return InspectUserNames - 检查人员(多个以逗号分开)
     */
    public String getInspectUserNames() {
        return inspectUserNames;
    }

    /**
     * 设置检查人员(多个以逗号分开)
     *
     * @param inspectUserNames 检查人员(多个以逗号分开)
     */
    public void setInspectUserNames(String inspectUserNames) {
        this.inspectUserNames = inspectUserNames;
    }

    /**
     * 获取检查机关(多个以逗号分开)
     *
     * @return InspectDepts - 检查机关(多个以逗号分开)
     */
    public String getInspectDepts() {
        return inspectDepts;
    }

    /**
     * 设置检查机关(多个以逗号分开)
     *
     * @param inspectDepts 检查机关(多个以逗号分开)
     */
    public void setInspectDepts(String inspectDepts) {
        this.inspectDepts = inspectDepts;
    }

    /**
     * 获取检查日期
     *
     * @return InspectDate - 检查日期
     */
    public Date getInspectDate() {
        return inspectDate;
    }

    /**
     * 设置检查日期
     *
     * @param inspectDate 检查日期
     */
    public void setInspectDate(Date inspectDate) {
        this.inspectDate = inspectDate;
    }

    /**
     * 获取创建时间
     *
     * @return CreateTime - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
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
    
    
}