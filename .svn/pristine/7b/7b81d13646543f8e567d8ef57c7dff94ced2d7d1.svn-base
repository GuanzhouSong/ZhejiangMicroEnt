/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.drcheck.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 描述:  cs_pub_sctask_agent_back 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2016年10月26日
 */
@Table(name = "cs_pub_sctask_agent_back")
public class PubSctaskAgentBack implements Serializable {
    /**
     * 自增序号
     */
    @Id
    @Column(name = "id")
    private Integer id;

    /**
     * 序号任务表：UUID
     */
    @Column(name = "TaskNO")
    private String taskNO;

    /**
     * 执法人员ID
     */
    @Column(name = "AgentId")
    private String agentId;

    /**
     * 时间戳
     */
    @Column(name = "CreateTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
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
     * 获取序号任务表：UUID
     *
     * @return TaskNO - 序号任务表：UUID
     */
    public String getTaskNO() {
        return taskNO;
    }

    /**
     * 设置序号任务表：UUID
     *
     * @param taskNO 序号任务表：UUID
     */
    public void setTaskNO(String taskNO) {
        this.taskNO = taskNO;
    }

    /**
     * 获取操作人ID
     *
     * @return AgentId - 执法人员ID
     */
    public String getAgentId() {
        return agentId;
    }

    /**
     * 设置操作人ID
     *
     * @param agentId 执法人员ID
     */
    public void setAgentId(String agentId) {
        this.agentId = agentId;
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
}