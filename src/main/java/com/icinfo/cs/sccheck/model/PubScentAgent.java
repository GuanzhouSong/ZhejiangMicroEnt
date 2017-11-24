/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.sccheck.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.icinfo.framework.mybatis.mapper.annotation.Before;

/**
 * 描述:    cs_pub_scent_agent 对应的实体类.执法人员待抽检库表<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年05月19日
 */
@Table(name = "cs_pub_scent_agent")
public class PubScentAgent implements Serializable {
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
     * 任务表序号
     */
    @Column(name = "PriPID")
    private String priPID;

    /**
     * 执法人员表UID
     */
    @Column(name = "AgentUid")
    private String agentUid;
    
    /**
     * 调整人uid
     */
    @Column(name = "AdjustUserUid")
    private String adjustUserUid;
    
    /**
     * 调整人姓名
     */
    @Column(name = "AdjustUserName")
    private String adjustUserName;
    
    /**
     * 调整时间
     */
    @Column(name = "AdjustDate")
    private Date adjustDate;
    
    /**
     * 是否组长标识（1-是，0-不是）
     */
    @Column(name = "LeaderFlag")
    private String leaderFlag;
    
    /**
     * 是否专家标识（1-是；0-不是）
     */
    @Column(name = "ExpertFlag")
    private String expertFlag;
    
    /**
     * 已抽取企业UID
     */
    @Column(name = "ScentUid")
    private String scentUid;
    
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

	public String getPriPID() {
		return priPID;
	}

	public void setPriPID(String priPID) {
		this.priPID = priPID;
	}

	public String getAdjustUserUid() {
		return adjustUserUid;
	}

	public void setAdjustUserUid(String adjustUserUid) {
		this.adjustUserUid = adjustUserUid;
	}

	public String getAdjustUserName() {
		return adjustUserName;
	}

	public void setAdjustUserName(String adjustUserName) {
		this.adjustUserName = adjustUserName;
	}

	public Date getAdjustDate() {
		return adjustDate;
	}

	public void setAdjustDate(Date adjustDate) {
		this.adjustDate = adjustDate;
	}

	public String getLeaderFlag() {
		return leaderFlag;
	}

	public void setLeaderFlag(String leaderFlag) {
		this.leaderFlag = leaderFlag;
	}

	public String getExpertFlag() {
		return expertFlag;
	}

	public void setExpertFlag(String expertFlag) {
		this.expertFlag = expertFlag;
	}

	public String getScentUid() {
		return scentUid;
	}

	public void setScentUid(String scentUid) {
		this.scentUid = scentUid;
	}
}