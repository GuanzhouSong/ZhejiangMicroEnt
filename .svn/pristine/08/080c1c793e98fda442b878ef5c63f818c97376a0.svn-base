/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.sment.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 描述:    sm_baseinfo_temp 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年06月14日
 */
@Table(name = "sm_baseinfo_temp")
public class SmBaseinfoTemp implements Serializable {
    @Id
    @Column(name = "id")
    private Integer id;

    /**
     * 主体身份代码(CA14)
     */
    @Column(name = "PriPID")
    private String priPID;

    /**
     * 企业(机构)名称
     */
    @Column(name = "EntName")
    private String entName;

    /**
     * 注册号(CA15)
     */
    @Column(name = "RegNO")
    private String regNO;
    
    /**
     * 用户id
     */
    @Column(name = "userId")
    private String userId;

    @Column(name = "CreateTime")
    private Date createTime;

    /**
     * 操作时间
     */
    @Column(name = "update_time")
    private Date update_time;

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
     * 获取主体身份代码(CA14)
     *
     * @return PriPID - 主体身份代码(CA14)
     */
    public String getPriPID() {
        return priPID;
    }

    /**
     * 设置主体身份代码(CA14)
     *
     * @param priPID 主体身份代码(CA14)
     */
    public void setPriPID(String priPID) {
        this.priPID = priPID;
    }

    /**
     * 获取企业(机构)名称
     *
     * @return EntName - 企业(机构)名称
     */
    public String getEntName() {
        return entName;
    }

    /**
     * 设置企业(机构)名称
     *
     * @param entName 企业(机构)名称
     */
    public void setEntName(String entName) {
        this.entName = entName;
    }

    /**
     * 获取注册号(CA15)
     *
     * @return RegNO - 注册号(CA15)
     */
    public String getRegNO() {
        return regNO;
    }

    /**
     * 设置注册号(CA15)
     *
     * @param regNO 注册号(CA15)
     */
    public void setRegNO(String regNO) {
        this.regNO = regNO;
    }

    /**
     * @return CreateTime
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取操作时间
     *
     * @return update_time - 操作时间
     */
    public Date getUpdate_time() {
        return update_time;
    }

    /**
     * 设置操作时间
     *
     * @param update_time 操作时间
     */
    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    
    public String getUserId(){
        return userId;
    }

    
    public void setUserId(String userId){
        this.userId = userId;
    }
}