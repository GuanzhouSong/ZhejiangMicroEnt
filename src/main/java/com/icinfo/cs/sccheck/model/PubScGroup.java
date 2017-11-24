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
 * 描述:    cs_pub_scgroup 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年07月10日
 */
@Table(name = "cs_pub_scgroup")
public class PubScGroup implements Serializable {
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
     * 执法人员姓名
     */
    @Column(name = "AgentNames")
    private String agentNames;

    /**
     * 专家(多个以逗号隔开)
     */
    @Column(name = "ExpertNames")
    private String expertNames;
    
    /**
     * 组长
     */
    @Column(name = "TeamLeader")
    private String teamLeader;
    
    /**
     * 执法人员数量
     */
    @Column(name = "MemberNum")
    private Integer memberNum;

    /**
     * 分组类别（随机抽取过程-1；执法人员调整-2）
     */
    @Column(name = "GroupType")
    private String groupType;

    /**
     * 设置人uid
     */
    @Column(name = "SetUserUid")
    private String setUserUid;

    /**
     * 设置人姓名
     */
    @Column(name = "SetUserName")
    private String setUserName;

    /**
     * 设置部门
     */
    @Column(name = "SetDeptCode")
    private String setDeptCode;

    /**
     * 设置时间
     */
    @Column(name = "SetTime")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date setTime;
    
    /**
     * 是否有效
     */
    @Column(name = "IsVlid")
    private String isVlid;

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
     * 获取执法人员姓名
     *
     * @return AgentNames - 执法人员姓名
     */
    public String getAgentNames() {
        return agentNames;
    }

    /**
     * 设置执法人员姓名
     *
     * @param agentNames 执法人员姓名
     */
    public void setAgentNames(String agentNames) {
        this.agentNames = agentNames;
    }

    /**
     * 获取专家
     *
     * @return ExpertName - 专家
     */
    public String getExpertNames() {
        return expertNames;
    }

    /**
     * 设置专家
     *
     * @param expertName 专家
     */
    public void setExpertNames(String expertNames) {
        this.expertNames = expertNames;
    }

    /**
     * 获取分组类别（随机抽取过程-1；执法人员调整-2）
     *
     * @return GroupType - 分组类别（随机抽取过程-1；执法人员调整-2）
     */
    public String getGroupType() {
        return groupType;
    }

    /**
     * 设置分组类别（随机抽取过程-1；执法人员调整-2）
     *
     * @param groupType 分组类别（随机抽取过程-1；执法人员调整-2）
     */
    public void setGroupType(String groupType) {
        this.groupType = groupType;
    }

    /**
     * 获取设置人uid
     *
     * @return SetUserUid - 设置人uid
     */
    public String getSetUserUid() {
        return setUserUid;
    }

    /**
     * 设置设置人uid
     *
     * @param setUserUid 设置人uid
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
     * 获取设置部门
     *
     * @return SetDeptCode - 设置部门
     */
    public String getSetDeptCode() {
        return setDeptCode;
    }

    /**
     * 设置设置部门
     *
     * @param setDeptCode 设置部门
     */
    public void setSetDeptCode(String setDeptCode) {
        this.setDeptCode = setDeptCode;
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

	public String getTeamLeader() {
		return teamLeader;
	}

	public void setTeamLeader(String teamLeader) {
		this.teamLeader = teamLeader;
	}

	public Integer getMemberNum() {
		return memberNum;
	}

	public void setMemberNum(Integer memberNum) {
		this.memberNum = memberNum;
	}

	public String getIsVlid() {
		return isVlid;
	}

	public void setIsVlid(String isVlid) {
		this.isVlid = isVlid;
	}
}