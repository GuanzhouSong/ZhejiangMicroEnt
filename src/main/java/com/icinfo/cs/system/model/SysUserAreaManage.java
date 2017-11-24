/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.system.model;

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
 * 描述:   111111 SYS_USER_AREA_ADMIN 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年05月04日
 */
@Table(name = "SYS_USER_AREA_MANAGE")
public class SysUserAreaManage implements Serializable {
    /**
     * 自增主键ID
     */
    @Id
    @Column(name = "ID")
    private Integer ID;

    /**
     * 主键
     */
    @Column(name = "UID")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    private String uid;

    /**
     * 用户唯一编号
     */
    @Column(name = "USER_IDENTITY")
    private String userIdentity;

    /**
     * 用户状态
     */
    @Column(name = "USER_STATUS")
    private String userStatus;

    /**
     * 用户设置人
     */
    @Column(name = "SetName")
    private String setName;

    /**
     * 设置时间
     */
    @Column(name = "SetDate")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date setDate;

    /**
     * 时间戳
     */
    @Column(name = "CreateTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;

    private static final long serialVersionUID = 1L;

    /**
     * 获取自增主键ID
     *
     * @return ID - 自增主键ID
     */
    public Integer getID() {
        return ID;
    }

    /**
     * 设置自增主键ID
     *
     * @param ID 自增主键ID
     */
    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getUid() {
		return uid;
	}
    
	public void setUid(String uid) {
		this.uid = uid;
	}

	

    /**
     * 获取用户设置人
     *
     * @return SetName - 用户设置人
     */
    public String getSetName() {
        return setName;
    }

    /**
     * 设置用户设置人
     *
     * @param setName 用户设置人
     */
    public void setSetName(String setName) {
        this.setName = setName;
    }
    

    /**
     * 获取设置时间
     *
     * @return SetDate - 设置时间
     */
    public Date getSetDate() {
        return setDate;
    }

    /**
     * 设置设置时间
     *
     * @param setDate 设置时间
     */
    public void setSetDate(Date setDate) {
        this.setDate = setDate;
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

	public String getUserIdentity() {
		return userIdentity;
	}

	public void setUserIdentity(String userIdentity) {
		this.userIdentity = userIdentity;
	}

	public String getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}
}