/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.sment.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.icinfo.framework.mybatis.mapper.annotation.Before;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * 描述:   小微企业培育档案库-帮扶信息 sm_bus_entarchives_help 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年04月27日
 */
@Table(name = "sm_bus_entarchives_help")
public class EntarchivesHelp implements Serializable {
    @Id
    @Column(name = "id")
    @Before
    private Integer id;

    @Column(name = "PriPID")
    private String priPID;

    @Column(name = "Year")
    private Integer year;

    /**
     * 帮扶类型code
     */
    @Column(name = "HelpTypeCode")
    private String helpTypeCode;

    /**
     * 帮扶类型名称
     */
    @Column(name = "HelpTypeName")
    private String helpTypeName;

    /**
     * 帮扶文本
     */
    @Column(name = "HelpText")
    private String helpText;

    /**
     * 帮扶时间
     */
    @Column(name = "HelpTime")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date helpTime;

    /**
     * 帮扶内容
     */
    @Column(name = "HelpContent")
    private String helpContent;

    /**
     * 时间戳
     */
    @Column(name = "CreateTime")
    private Date createTime;

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
     * @return PriPID
     */
    public String getPriPID() {
        return priPID;
    }

    /**
     * @param priPID
     */
    public void setPriPID(String priPID) {
        this.priPID = priPID;
    }

    /**
     * @return Year
     */
    public Integer getYear() {
        return year;
    }

    /**
     * @param year
     */
    public void setYear(Integer year) {
        this.year = year;
    }

    /**
     * 获取帮扶类型code
     *
     * @return HelpTypeCode - 帮扶类型code
     */
    public String getHelpTypeCode() {
        return helpTypeCode;
    }

    /**
     * 设置帮扶类型code
     *
     * @param helpTypeCode 帮扶类型code
     */
    public void setHelpTypeCode(String helpTypeCode) {
        this.helpTypeCode = helpTypeCode;
    }

    /**
     * 获取帮扶类型名称
     *
     * @return HelpTypeName - 帮扶类型名称
     */
    public String getHelpTypeName() {
        return helpTypeName;
    }

    /**
     * 设置帮扶类型名称
     *
     * @param helpTypeName 帮扶类型名称
     */
    public void setHelpTypeName(String helpTypeName) {
        this.helpTypeName = helpTypeName;
    }

    /**
     * 获取帮扶文本
     *
     * @return HelpText - 帮扶文本
     */
    public String getHelpText() {
        return helpText;
    }

    /**
     * 设置帮扶文本
     *
     * @param helpText 帮扶文本
     */
    public void setHelpText(String helpText) {
        this.helpText = helpText;
    }

    /**
     * 获取帮扶时间
     *
     * @return HelpTime - 帮扶时间
     */
    public Date getHelpTime() {
        return helpTime;
    }

    /**
     * 设置帮扶时间
     *
     * @param helpTime 帮扶时间
     */
    public void setHelpTime(Date helpTime) {
        this.helpTime = helpTime;
    }

    /**
     * 获取帮扶内容
     *
     * @return HelpContent - 帮扶内容
     */
    public String getHelpContent() {
        return helpContent;
    }

    /**
     * 设置帮扶内容
     *
     * @param helpContent 帮扶内容
     */
    public void setHelpContent(String helpContent) {
        this.helpContent = helpContent;
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