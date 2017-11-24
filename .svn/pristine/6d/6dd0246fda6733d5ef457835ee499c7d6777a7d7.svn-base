/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.login.model;

import com.icinfo.framework.mybatis.mapper.annotation.Before;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * 描述:   联络员信息表 cs_pub_pbpassword 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年03月01日
 */
@Table(name = "cs_pub_pbpassword")
public class PubPbpassword implements Serializable {
    /**
     * ID
     */
    @Id
    @Column(name = "id")
    private Integer id;

    /**
     * 验证码
     */
    @Column(name = "Password")
    private String password;

    /**
     * 手机号码（工商联络人）
     */
    @Column(name = "Tel")
    private String tel;

    /**
     * UID
     */
    @Column(name = "UID")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    private String UID;

    /**
     * 操作类型 1：App联络员注册 2:App登录
     */
    @Column(name = "operation")
    private String operation;

    /**
     * 创建时间
     */
    @Column(name = "ApplyTime")
    private Date applyTime;

    /**
     * 时间戳
     */
    @Column(name = "CreateTime")
    private Date createTime;

    private static final long serialVersionUID = 1L;

    /**
     * 获取ID
     *
     * @return id - ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置ID
     *
     * @param id ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取验证码
     *
     * @return Password - 验证码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置验证码
     *
     * @param password 验证码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取手机号码（工商联络人）
     *
     * @return Tel - 手机号码（工商联络人）
     */
    public String getTel() {
        return tel;
    }

    /**
     * 设置手机号码（工商联络人）
     *
     * @param tel 手机号码（工商联络人）
     */
    public void setTel(String tel) {
        this.tel = tel;
    }

    /**
     * 获取UID
     *
     * @return UID - UID
     */
    public String getUID() {
        return UID;
    }

    /**
     * 设置UID
     *
     * @param UID UID
     */
    public void setUID(String UID) {
        this.UID = UID;
    }

    /**
     * 获取操作类型 1：联络员注册 2:登录
     *
     * @return operation - 操作类型 1：联络员注册 2:登录
     */
    public String getOperation() {
        return operation;
    }

    /**
     * 设置操作类型 1：联络员注册 2:登录
     *
     * @param operation 操作类型 1：联络员注册 2:登录
     */
    public void setOperation(String operation) {
        this.operation = operation;
    }

    /**
     * 获取创建时间
     *
     * @return ApplyTime - 创建时间
     */
    public Date getApplyTime() {
        return applyTime;
    }

    /**
     * 设置创建时间
     *
     * @param applyTime 创建时间
     */
    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
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
}