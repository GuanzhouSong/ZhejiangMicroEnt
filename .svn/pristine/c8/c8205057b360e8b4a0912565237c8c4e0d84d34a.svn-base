/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.webservice.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.icinfo.framework.mybatis.mapper.annotation.Before;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * 描述:    cs_mid_altitem 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年02月17日
 */
@Table(name = "cs_mid_altitem")
public class WsMidAltitem implements Serializable {
    @Id
    @Column(name = "id")
//    @Before
//    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    private Integer id;

    /**
     * 内部序号
     */
    @Column(name = "PriPID")
    private String priPID;

    /**
     * 变更事项
     */
    @Column(name = "AltItem")
    private String altItem;

    /**
     * 变更次数
     */
    @Column(name = "AltTime")
    private Integer altTime;

    /**
     * 变更时间
     */
    @Column(name = "AltDate")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date altDate;

    /**
     * 序号
     */
    @Column(name = "UID")
    private String UID;

    /**
     * 时间戳
     */
    @Column(name = "CreateTime")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date createTime;

    /**
     * 变更前内容
     */
    @Column(name = "AltBeContent")
    private String altBeContent;

    /**
     * 变更后内容
     */
    @Column(name = "AltAfContent")
    private String altAfContent;

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
     * 获取内部序号
     *
     * @return PriPID - 内部序号
     */
    public String getPriPID() {
        return priPID;
    }

    /**
     * 设置内部序号
     *
     * @param priPID 内部序号
     */
    public void setPriPID(String priPID) {
        this.priPID = priPID;
    }

    /**
     * 获取变更事项
     *
     * @return AltItem - 变更事项
     */
    public String getAltItem() {
        return altItem;
    }

    /**
     * 设置变更事项
     *
     * @param altItem 变更事项
     */
    public void setAltItem(String altItem) {
        this.altItem = altItem;
    }

    /**
     * 获取变更次数
     *
     * @return AltTime - 变更次数
     */
    public Integer getAltTime() {
        return altTime;
    }

    /**
     * 设置变更次数
     *
     * @param altTime 变更次数
     */
    public void setAltTime(Integer altTime) {
        this.altTime = altTime;
    }

    /**
     * 获取变更时间
     *
     * @return AltDate - 变更时间
     */
    public Date getAltDate() {
        return altDate;
    }

    /**
     * 设置变更时间
     *
     * @param altDate 变更时间
     */
    public void setAltDate(Date altDate) {
        this.altDate = altDate;
    }

    /**
     * 获取序号
     *
     * @return UID - 序号
     */
    public String getUID() {
        return UID;
    }

    /**
     * 设置序号
     *
     * @param UID 序号
     */
    public void setUID(String UID) {
        this.UID = UID;
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

    /**
     * 获取变更前内容
     *
     * @return AltBeContent - 变更前内容
     */
    public String getAltBeContent() {
        return altBeContent;
    }

    /**
     * 设置变更前内容
     *
     * @param altBeContent 变更前内容
     */
    public void setAltBeContent(String altBeContent) {
        this.altBeContent = altBeContent;
    }

    /**
     * 获取变更后内容
     *
     * @return AltAfContent - 变更后内容
     */
    public String getAltAfContent() {
        return altAfContent;
    }

    /**
     * 设置变更后内容
     *
     * @param altAfContent 变更后内容
     */
    public void setAltAfContent(String altAfContent) {
        this.altAfContent = altAfContent;
    }
}