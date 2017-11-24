/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.registinfo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.icinfo.framework.mybatis.mapper.annotation.Before;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * 描述:    cs_regist_unlicensed 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2016年09月09日
 */
@Table(name = "cs_regist_unlicensed")
public class RegistUnlicensed implements Serializable {

    @Id
    @Column(name = "id")
    private Integer id;


    /**
     * 主体身份代码
     */
    @Column(name = "PriPID")
    private String priPID;

    /**
     * 创建时间
     */
    @Column(name = "CreateTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;

    /**
     * 主体户口、无照的UUID
     */
    @Column(name = "UID")
    private String UID;

    /**
     * 监管项目名称
     */
    @Column(name = "SuperName")
    private String superName;

    /**
     * 监管项目编号
     */
    @Column(name = "SuperNo")
    private String superNo;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取主体身份代码
     *
     * @return PriPID - 主体身份代码
     */
    public String getPriPID() {
        return priPID;
    }

    /**
     * 设置主体身份代码
     *
     * @param priPID 主体身份代码
     */
    public void setPriPID(String priPID) {
        this.priPID = priPID;
    }

    /**
     * 获取创建时间
     *
     * @return CreateTime - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取主体户口、无照的UUID
     *
     * @return UID - 主体户口、无照的UUID
     */
    public String getUID() {
        return UID;
    }

    /**
     * 设置主体户口、无照的UUID
     *
     * @param UID 主体户口、无照的UUID
     */
    public void setUID(String UID) {
        this.UID = UID;
    }

    /**
     * 获取监管项目名称
     *
     * @return SuperName - 监管项目名称
     */
    public String getSuperName() {
        return superName;
    }

    /**
     * 设置监管项目名称
     *
     * @param superName 监管项目名称
     */
    public void setSuperName(String superName) {
        this.superName = superName;
    }

    /**
     * 获取监管项目编号
     *
     * @return SuperNo - 监管项目编号
     */
    public String getSuperNo() {
        return superNo;
    }

    /**
     * 设置监管项目编号
     *
     * @param superNo 监管项目编号
     */
    public void setSuperNo(String superNo) {
        this.superNo = superNo;
    }
}