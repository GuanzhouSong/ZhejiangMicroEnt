/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.sccheck.model;

import com.icinfo.framework.mybatis.mapper.annotation.Before;
import java.io.Serializable;
import javax.persistence.*;

/**
 * 描述:    cs_pub_scgroup_member 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年07月10日
 */
@Table(name = "cs_pub_scgroup_member")
public class PubScGroupMember implements Serializable {
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
     * 分组uid
     */
    @Column(name = "GroupUid")
    private String groupUid;

    /**
     * 执法人员uid
     */
    @Column(name = "AgentUid")
    private String agentUid;

    /**
     * 执法人员姓名
     */
    @Column(name = "AgentName")
    private String agentName;

    /**
     * 部门描述
     */
    @Column(name = "AgentDeptName")
    private String agentDeptName;

    /**
     * 专家
     */
    @Column(name = "ExpertFlag")
    private String expertFlag;
    
    /**
     * 组长
     */
    @Column(name = "LeaderFlag")
    private String leaderFlag;
    
    /**
     * 临时数据操作类型 1-删除 2-新增
     */
    @Column(name = "OptDataType")
    private String optDataType;
    
    

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
     * 获取分组uid
     *
     * @return GroupUid - 分组uid
     */
    public String getGroupUid() {
        return groupUid;
    }

    /**
     * 设置分组uid
     *
     * @param groupUid 分组uid
     */
    public void setGroupUid(String groupUid) {
        this.groupUid = groupUid;
    }

    /**
     * 获取执法人员uid
     *
     * @return AgentUid - 执法人员uid
     */
    public String getAgentUid() {
        return agentUid;
    }

    /**
     * 设置执法人员uid
     *
     * @param agentUid 执法人员uid
     */
    public void setAgentUid(String agentUid) {
        this.agentUid = agentUid;
    }

    /**
     * 获取执法人员姓名
     *
     * @return AgentName - 执法人员姓名
     */
    public String getAgentName() {
        return agentName;
    }

    /**
     * 设置执法人员姓名
     *
     * @param agentName 执法人员姓名
     */
    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    /**
     * 获取部门描述
     *
     * @return AgentDeptName - 部门描述
     */
    public String getAgentDeptName() {
        return agentDeptName;
    }

    /**
     * 设置部门描述
     *
     * @param agentDeptName 部门描述
     */
    public void setAgentDeptName(String agentDeptName) {
        this.agentDeptName = agentDeptName;
    }

    /**
     * 获取组长/专家
     *
     * @return ExpertFlag - 组长/专家
     */
    public String getExpertFlag() {
        return expertFlag;
    }

    /**
     * 设置组长/专家
     *
     * @param expertFlag 组长/专家
     */
    public void setExpertFlag(String expertFlag) {
        this.expertFlag = expertFlag;
    }

	public String getLeaderFlag() {
		return leaderFlag;
	}

	public void setLeaderFlag(String leaderFlag) {
		this.leaderFlag = leaderFlag;
	}

	public String getOptDataType() {
		return optDataType;
	}

	public void setOptDataType(String optDataType) {
		this.optDataType = optDataType;
	}
    
    
}