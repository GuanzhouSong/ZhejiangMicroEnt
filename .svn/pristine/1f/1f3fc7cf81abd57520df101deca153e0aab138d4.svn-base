/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.party.model;

import com.icinfo.framework.mybatis.mapper.annotation.Before;
import java.io.Serializable;
import javax.persistence.*;

/**
 * 描述:    cs_party_activity_joinResult 对应的实体类.(党建活动参与人信息表  与活动一对多)<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年09月04日
 */
@Table(name = "cs_party_activity_joinResult")
public class PartyActivityJoinResult implements Serializable {
    @Id
    @Column(name = "id")
    private Integer id;

    /**
     * uid
     */
    @Column(name = "UID")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    private String UID;

    /**
     * 活动id
     */
    @Column(name = "ActivityUID")
    private String activityUID;

    /**
     * 参与人id
     */
    @Column(name = "JoinerId")
    private String joinerId;

    /**
     * 参与人姓名
     */
    @Column(name = "Joiner")
    private String joiner;

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
     * 获取uid
     *
     * @return UID - uid
     */
    public String getUID() {
        return UID;
    }

    /**
     * 设置uid
     *
     * @param UID uid
     */
    public void setUID(String UID) {
        this.UID = UID;
    }

    /**
     * 获取活动id
     *
     * @return ActivityUID - 活动id
     */
    public String getActivityUID() {
        return activityUID;
    }

    /**
     * 设置活动id
     *
     * @param activityUID 活动id
     */
    public void setActivityUID(String activityUID) {
        this.activityUID = activityUID;
    }

    /**
     * 获取参与人id
     *
     * @return JoinerId - 参与人id
     */
    public String getJoinerId() {
        return joinerId;
    }

    /**
     * 设置参与人id
     *
     * @param joinerId 参与人id
     */
    public void setJoinerId(String joinerId) {
        this.joinerId = joinerId;
    }

    /**
     * 获取参与人姓名
     *
     * @return Joiner - 参与人姓名
     */
    public String getJoiner() {
        return joiner;
    }

    /**
     * 设置参与人姓名
     *
     * @param joiner 参与人姓名
     */
    public void setJoiner(String joiner) {
        this.joiner = joiner;
    }
}