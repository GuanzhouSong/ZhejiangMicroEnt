/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.drcheck.model;

import com.icinfo.framework.mybatis.mapper.annotation.Before;
import java.io.Serializable;
import javax.persistence.*;

/**
 * 描述:    cs_pub_scinfo_agent 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2016年11月17日
 */
@Table(name = "cs_pub_scinfo_agent")
public class PubScinfoAgent implements Serializable {
    /**
     * 自增长
     */
    @Id
    @Column(name = "id")
    private Integer id;
    
    @Column(name = "UID")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    private String UID;

    /**
     * 组织部门UID
     */
    @Column(name = "TaskNO")
    private String taskNO;

    /**
     * 实施部门UID
     */
    @Column(name = "DeptTaskNO")
    private String deptTaskNO;

    @Column(name = "PriPID")
    private String priPID;

    /**
     * 执法人员表UID
     */
    @Column(name = "AgentUid")
    private String agentUid;

    private static final long serialVersionUID = 1L;

    /**
     * 获取自增长
     *
     * @return id - 自增长
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置自增长
     *
     * @param id 自增长
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取组织部门UID
     *
     * @return TaskNO - 组织部门UID
     */
    public String getTaskNO() {
        return taskNO;
    }

    /**
     * 设置组织部门UID
     *
     * @param taskNO 组织部门UID
     */
    public void setTaskNO(String taskNO) {
        this.taskNO = taskNO;
    }

    /**
     * 获取实施部门UID
     *
     * @return DeptTaskNO - 实施部门UID
     */
    public String getDeptTaskNO() {
        return deptTaskNO;
    }

    /**
     * 设置实施部门UID
     *
     * @param deptTaskNO 实施部门UID
     */
    public void setDeptTaskNO(String deptTaskNO) {
        this.deptTaskNO = deptTaskNO;
    }

    /**
     * @return PriPID
     */
    public String getPriPID() {
        return priPID;
    }

    /**
     * @param priPID
     */
    public void setPriPID(String priPID) {
        this.priPID = priPID;
    }

    /**
     * 获取执法人员表UID
     *
     * @return AgentUid - 执法人员表UID
     */
    public String getAgentUid() {
        return agentUid;
    }

    /**
     * 设置执法人员表UID
     *
     * @param agentUid 执法人员表UID
     */
    public void setAgentUid(String agentUid) {
        this.agentUid = agentUid;
    }

	public String getUID() {
		return UID;
	}

	public void setUID(String uID) {
		this.UID = uID;
	}

}