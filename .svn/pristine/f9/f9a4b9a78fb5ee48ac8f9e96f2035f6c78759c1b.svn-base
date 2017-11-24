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
 * 描述:    cs_im_prmtalt 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2016年08月28日
 */
@Table(name = "cs_im_prmtalt")
public class ImPrmtalt implements Serializable {
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
     * 创建时间戳
     */
    @Column(name = "CreateTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;

    /**
     * 许可变更ID
     */
    @Column(name = "LicAltID")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    private String licAltID;

    /**
     * 许可ID
     */
    @Column(name = "LicID")
    private String licID;

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
     * 获取创建时间戳
     *
     * @return CreateTime - 创建时间戳
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间戳
     *
     * @param createTime 创建时间戳
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取许可变更ID
     *
     * @return LicAltID - 许可变更ID
     */
    public String getLicAltID() {
        return licAltID;
    }

    /**
     * 设置许可变更ID
     *
     * @param licAltID 许可变更ID
     */
    public void setLicAltID(String licAltID) {
        this.licAltID = licAltID;
    }

    /**
     * 获取许可ID
     *
     * @return LicID - 许可ID
     */
    public String getLicID() {
        return licID;
    }

    /**
     * 设置许可ID
     *
     * @param licID 许可ID
     */
    public void setLicID(String licID) {
        this.licID = licID;
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