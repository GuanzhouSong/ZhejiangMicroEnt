/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.im.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.icinfo.framework.mybatis.mapper.annotation.Before;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 描述:    cs_im_ippldgalt 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2016年08月28日
 */
@Table(name = "cs_im_ippldgalt")
public class ImIppldgalt implements Serializable {
    /**
     * 主键自增id
     */
    @Id
    @Column(name = "id")
    private Integer id;

    /**
     * 变更日期
     */
    @Column(name = "AltDate")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date altDate;

    /**
     * 时间戳
     */
    @Column(name = "CreateTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;

    /**
     * 知识产权出质变更ID(UUID)
     */
    @Column(name = "PleAltID")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    private String pleAltID;

    /**
     * 知识产权出质ID
     */
    @Column(name = "PleID")
    private String pleID;


    /**
     * 变更后内容
     */
    @Column(name = "AltAfContent")
    private String altAfContent;

    /**
     * 变更前内容
     */
    @Column(name = "AltBeContent")
    private String altBeContent;

    /**
     * 变更事项
     */
    @Column(name = "AltItemContent")
    private String altItemContent;

    private static final long serialVersionUID = 1L;

    /**
     * 获取主键自增id
     *
     * @return id - 主键自增id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置主键自增id
     *
     * @param id 主键自增id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取变更日期
     *
     * @return AltDate - 变更日期
     */
    public Date getAltDate() {
        return altDate;
    }

    /**
     * 设置变更日期
     *
     * @param altDate 变更日期
     */
    public void setAltDate(Date altDate) {
        this.altDate = altDate;
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
     * 获取知识产权出质变更ID(UUID)
     *
     * @return PleAltID - 知识产权出质变更ID(UUID)
     */
    public String getPleAltID() {
        return pleAltID;
    }

    /**
     * 设置知识产权出质变更ID(UUID)
     *
     * @param pleAltID 知识产权出质变更ID(UUID)
     */
    public void setPleAltID(String pleAltID) {
        this.pleAltID = pleAltID;
    }

    /**
     * 获取知识产权出质ID
     *
     * @return PleID - 知识产权出质ID
     */
    public String getPleID() {
        return pleID;
    }

    /**
     * 设置知识产权出质ID
     *
     * @param pleID 知识产权出质ID
     */
    public void setPleID(String pleID) {
        this.pleID = pleID;
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
     * 获取变更事项
     *
     * @return AltItemContent - 变更事项
     */
    public String getAltItemContent() {
        return altItemContent;
    }

    /**
     * 设置变更事项
     *
     * @param altItemContent 变更事项
     */
    public void setAltItemContent(String altItemContent) {
        this.altItemContent = altItemContent;
    }
}