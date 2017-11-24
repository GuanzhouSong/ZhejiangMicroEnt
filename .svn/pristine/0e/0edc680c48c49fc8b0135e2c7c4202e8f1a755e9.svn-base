/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.writ.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.icinfo.framework.mybatis.mapper.annotation.Before;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * 描述:  cs_dzqz 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年06月08日
 */
@Table(name = "cs_dzqz")
public class Dzqz implements Serializable {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "Uuid")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    private String uuid;

    /**
     * 年份
     */
    @Column(name = "Year")
    private Integer year;

    /**
     * 主体身份代码
     */
    @Column(name = "PriPID")
    private String priPID;

    /**
     * 签章时间
     */
    @Column(name = "QzTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date qzTime;

    /**
     * 创建时间
     */
    @Column(name = "CreateTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;

    /**
     * 签章状态：1：成功 2：失败
     */
    @Column(name = "QzStatus")
    private String qzStatus;

    /**
     * 签章图片编码
     */
    @Column(name = "ImageCode")
    private String imageCode;

    /**
     * 与文书关联外键
     */
    @Column(name = "WritUuid")
    private String writUuid;

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
     * @return Uuid
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * @param uuid
     */
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    /**
     * 获取年份
     *
     * @return Year - 年份
     */
    public Integer getYear() {
        return year;
    }

    /**
     * 设置年份
     *
     * @param year 年份
     */
    public void setYear(Integer year) {
        this.year = year;
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
     * 获取签章时间
     *
     * @return QzTime - 签章时间
     */
    public Date getQzTime() {
        return qzTime;
    }

    /**
     * 设置签章时间
     *
     * @param qzTime 签章时间
     */
    public void setQzTime(Date qzTime) {
        this.qzTime = qzTime;
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
     * 获取签章状态：1：成功 2：失败
     *
     * @return QzStatus - 签章状态：1：成功 2：失败
     */
    public String getQzStatus() {
        return qzStatus;
    }

    /**
     * 设置签章状态：1：成功 2：失败
     *
     * @param qzStatus 签章状态：1：成功 2：失败
     */
    public void setQzStatus(String qzStatus) {
        this.qzStatus = qzStatus;
    }

    /**
     * 获取签章图片编码
     *
     * @return ImageCode - 签章图片编码
     */
    public String getImageCode() {
        return imageCode;
    }

    /**
     * 设置签章图片编码
     *
     * @param imageCode 签章图片编码
     */
    public void setImageCode(String imageCode) {
        this.imageCode = imageCode;
    }

    /**
     * 获取与文书关联外键
     *
     * @return WritUuid - 与文书关联外键
     */
    public String getWritUuid() {
        return writUuid;
    }

    /**
     * 设置与文书关联外键
     *
     * @param writUuid 与文书关联外键
     */
    public void setWritUuid(String writUuid) {
        this.writUuid = writUuid;
    }

}