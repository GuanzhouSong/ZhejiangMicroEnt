/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.party.model;

import com.icinfo.framework.mybatis.mapper.annotation.Before;
import java.io.Serializable;
import javax.persistence.*;

/**
 * 描述:    cs_party_act_relation 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年08月18日
 */
@Table(name = "cs_party_act_relation")
public class PartyActRelation implements Serializable {
	
    @Id
    @Column(name = "id")
    private Integer id;

    /**
     * 唯一标识
     */
    @Column(name = "UID")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    private String UID;

    /**
     * 党成员ID
     */
    @Column(name = "MemberID")
    private String memberID;

    /**
     * 活动ID
     */
    @Column(name = "ActivityID")
    private String activityID;

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
     * 获取唯一标识
     *
     * @return UID - 唯一标识
     */
    public String getUID() {
        return UID;
    }

    /**
     * 设置唯一标识
     *
     * @param UID 唯一标识
     */
    public void setUID(String UID) {
        this.UID = UID;
    }

    /**
     * 获取党成员ID
     *
     * @return MemberID - 党成员ID
     */
    public String getMemberID() {
        return memberID;
    }

    /**
     * 设置党成员ID
     *
     * @param memberID 党成员ID
     */
    public void setMemberID(String memberID) {
        this.memberID = memberID;
    }

    /**
     * 获取活动ID
     *
     * @return ActivityID - 活动ID
     */
    public String getActivityID() {
        return activityID;
    }

    /**
     * 设置活动ID
     *
     * @param activityID 活动ID
     */
    public void setActivityID(String activityID) {
        this.activityID = activityID;
    }
}