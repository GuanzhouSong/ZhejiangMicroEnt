/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.base.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.icinfo.framework.mybatis.mapper.annotation.Before;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * 描述:  cs_super_item 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2016年10月31日
 */
@Table(name = "cs_super_item")
public class SuperItem implements Serializable {
    /**
     * 自增ID
     */
    @Id
    @Column(name = "id")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    private Integer id;

    /**
     * 监管项目编号
     */
    @Column(name = "SuperNO")
    private String superNO;

    /**
     * 监管项目名称
     */
    @Column(name = "SuperName")
    private String superName;

    /**
     * 监管项目类型
     */
    @Column(name = "SuperType")
    private String superType;

    /**
     * 设置人
     */
    @Column(name = "SetName")
    private String setName;

    /**
     * 时间戳
     */
    @Column(name = "CreateTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;

    private static final long serialVersionUID = 1L;

    /**
     * 获取自增ID
     *
     * @return id - 自增ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置自增ID
     *
     * @param id 自增ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取监管项目编号
     *
     * @return SuperNO - 监管项目编号
     */
    public String getSuperNO() {
        return superNO;
    }

    /**
     * 设置监管项目编号
     *
     * @param superNO 监管项目编号
     */
    public void setSuperNO(String superNO) {
        this.superNO = superNO;
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
     * 获取监管项目类型
     *
     * @return SuperType - 监管项目类型
     */
    public String getSuperType() {
        return superType;
    }

    /**
     * 设置监管项目类型
     *
     * @param superType 监管项目类型
     */
    public void setSuperType(String superType) {
        this.superType = superType;
    }

    /**
     * 获取设置人
     *
     * @return SetName - 设置人
     */
    public String getSetName() {
        return setName;
    }

    /**
     * 设置设置人
     *
     * @param setName 设置人
     */
    public void setSetName(String setName) {
        this.setName = setName;
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