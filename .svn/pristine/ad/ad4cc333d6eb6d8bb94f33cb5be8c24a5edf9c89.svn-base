/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.party.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.icinfo.framework.mybatis.mapper.annotation.Before;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * 描述:    cs_party_ent_info 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年09月01日
 */
@Table(name = "cs_party_ent_info")
public class PartyEntInfo implements Serializable {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "UID")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    private String UID;

    /**
     * 主体代码
     */
    @Column(name = "PriPID")
    private String priPID;

    /**
     * 企业名称
     */
    @Column(name = "EntName")
    private String entName;

    /**
     * 是否自身建有党组织
     */
    @Column(name = "IsBuildPartyOrg")
    private String isBuildPartyOrg;

    /**
     * 党员个数
     */
    @Column(name = "PartyMemberNum")
    private Integer partyMemberNum;

    /**
     * 组建方式
     */
    @Column(name = "BuildOrgWay")
    private String buildOrgWay;

    /**
     * 党组织建制
     */
    @Column(name = "BuildOrgType")
    private String buildOrgType;

    /**
     * 组建时间
     */
    @Column(name = "CreateOrgTime")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date createOrgTime;

    private static final long serialVersionUID = 1L;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return UID
     */
    public String getUID() {
        return UID;
    }

    /**
     * @param UID
     */
    public void setUID(String UID) {
        this.UID = UID;
    }

    /**
     * 获取主体代码
     *
     * @return PriPID - 主体代码
     */
    public String getPriPID() {
        return priPID;
    }

    /**
     * 设置主体代码
     *
     * @param priPID 主体代码
     */
    public void setPriPID(String priPID) {
        this.priPID = priPID;
    }

    /**
     * 获取企业名称
     *
     * @return EntName - 企业名称
     */
    public String getEntName() {
        return entName;
    }

    /**
     * 设置企业名称
     *
     * @param entName 企业名称
     */
    public void setEntName(String entName) {
        this.entName = entName;
    }

    /**
     * 获取是否自身建有党组织
     *
     * @return IsBuildPartyOrg - 是否自身建有党组织
     */
    public String getIsBuildPartyOrg() {
        return isBuildPartyOrg;
    }

    /**
     * 设置是否自身建有党组织
     *
     * @param isBuildPartyOrg 是否自身建有党组织
     */
    public void setIsBuildPartyOrg(String isBuildPartyOrg) {
        this.isBuildPartyOrg = isBuildPartyOrg;
    }

    /**
     * 获取党员个数
     *
     * @return PartyMemberNum - 党员个数
     */
    public Integer getPartyMemberNum() {
        return partyMemberNum;
    }

    /**
     * 设置党员个数
     *
     * @param partyMemberNum 党员个数
     */
    public void setPartyMemberNum(Integer partyMemberNum) {
        this.partyMemberNum = partyMemberNum;
    }

    /**
     * 获取组建方式
     *
     * @return BuildOrgWay - 组建方式
     */
    public String getBuildOrgWay() {
        return buildOrgWay;
    }

    /**
     * 设置组建方式
     *
     * @param buildOrgWay 组建方式
     */
    public void setBuildOrgWay(String buildOrgWay) {
        this.buildOrgWay = buildOrgWay;
    }

    /**
     * 获取党组织建制
     *
     * @return BuildOrgType - 党组织建制
     */
    public String getBuildOrgType() {
        return buildOrgType;
    }

    /**
     * 设置党组织建制
     *
     * @param buildOrgType 党组织建制
     */
    public void setBuildOrgType(String buildOrgType) {
        this.buildOrgType = buildOrgType;
    }

    /**
     * 获取组建时间
     *
     * @return CreateOrgTime - 组建时间
     */
    public Date getCreateOrgTime() {
        return createOrgTime;
    }

    /**
     * 设置组建时间
     *
     * @param createOrgTime 组建时间
     */
    public void setCreateOrgTime(Date createOrgTime) {
        this.createOrgTime = createOrgTime;
    }
}