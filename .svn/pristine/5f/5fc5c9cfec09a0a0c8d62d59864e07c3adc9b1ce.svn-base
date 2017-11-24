/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.yr.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.icinfo.framework.mybatis.mapper.annotation.Before;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * 描述:  cs_signature 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年05月18日
 */
@Table(name = "cs_signature")
public class Signature implements Serializable {
    @Id
    @Column(name = "id")
    private Integer id;

    /**
     * 年份
     */
    @Column(name = "Year")
    private Integer year;

    /**
     * 内部序号
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
     * 签章状态：0：签章失败  1：签章成功
     */
    @Column(name = "QzStatus")
    private String qzStatus;

    /**
     * 图片编码路径
     */
    @Column(name = "TextCode")
    private String textCode;

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
     * 获取签章状态：0：签章失败  1：签章成功
     *
     * @return QzStatus - 签章状态：0：签章失败  1：签章成功
     */
    public String getQzStatus() {
        return qzStatus;
    }

    /**
     * 设置签章状态：0：签章失败  1：签章成功
     *
     * @param qzStatus 签章状态：0：签章失败  1：签章成功
     */
    public void setQzStatus(String qzStatus) {
        this.qzStatus = qzStatus;
    }

    /**
     * 获取图片编码路径
     *
     * @return TextCode - 图片编码路径
     */
    public String getTextCode() {
        return textCode;
    }

    /**
     * 设置图片编码路径
     *
     * @param textCode 图片编码路径
     */
    public void setTextCode(String textCode) {
        this.textCode = textCode;
    }
}