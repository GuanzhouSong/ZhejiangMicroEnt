/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.sccheck.model;

import com.icinfo.framework.mybatis.mapper.annotation.Before;
import java.io.Serializable;
import javax.persistence.*;

/**
 * 描述:    cs_pub_scent_agent_back 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年05月20日
 */
@Table(name = "cs_pub_scent_agent_back")
public class PubScentAgentBack implements Serializable {
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
    @Column(name = "DeptTaskUid")
    private String deptTaskUid;

    /**
     * 执法人员表UID
     */
    @Column(name = "AgentUid")
    private String agentUid;

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
     * @return DeptTaskUid - 任务表序号
     */
    public String getDeptTaskUid() {
        return deptTaskUid;
    }

    /**
     * 设置任务表序号
     *
     * @param deptTaskUid 任务表序号
     */
    public void setDeptTaskUid(String deptTaskUid) {
        this.deptTaskUid = deptTaskUid;
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
}