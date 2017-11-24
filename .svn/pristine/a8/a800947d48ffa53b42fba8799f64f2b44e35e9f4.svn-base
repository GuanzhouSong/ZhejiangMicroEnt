/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.im.model;


import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 描述:    股东出资修改信息记录 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2016年08月28日
 */
@Table(name = "cs_im_invupdate")
public class ImInvupdate implements Serializable {
    /**
     * 主键自增id
     */
    @Id
    @Column(name = "id")
    private Integer id;

    /**
     * 主体身份代码CA14
     */
    @Column(name = "PriPID")
    private String priPID;

    /**
     * 企业(机构)名称
     */
    @Column(name = "EntName")
    private String entName;

    /**
     * 注册号CA15
     */
    @Column(name = "RegNO")
    private String regNO;

    /**
     * 统一社会信用代码CA91
     */
    @Column(name = "UniCode")
    private String uniCode;

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
     * 出资信息修改ID
     */
    @Column(name = "InvID")
    private String invID;

    /**
     * 变更后
     */
    @Column(name = "AltAfContent")
    private String altAfContent;

    /**
     * 变更前
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
     * 获取主体身份代码CA14
     *
     * @return PriPID - 主体身份代码CA14
     */
    public String getPriPID() {
        return priPID;
    }

    /**
     * 设置主体身份代码CA14
     *
     * @param priPID 主体身份代码CA14
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
     * 获取注册号CA15
     *
     * @return RegNO - 注册号CA15
     */
    public String getRegNO() {
        return regNO;
    }

    /**
     * 设置注册号CA15
     *
     * @param regNO 注册号CA15
     */
    public void setRegNO(String regNO) {
        this.regNO = regNO;
    }

    /**
     * 获取统一社会信用代码CA91
     *
     * @return UniCode - 统一社会信用代码CA91
     */
    public String getUniCode() {
        return uniCode;
    }

    /**
     * 设置统一社会信用代码CA91
     *
     * @param uniCode 统一社会信用代码CA91
     */
    public void setUniCode(String uniCode) {
        this.uniCode = uniCode;
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
     * 获取出资信息修改ID
     *
     * @return InvID - 出资信息修改ID
     */
    public String getInvID() {
        return invID;
    }

    /**
     * 设置出资信息修改ID
     *
     * @param invID 出资信息修改ID
     */
    public void setInvID(String invID) {
        this.invID = invID;
    }

    /**
     * 获取变更后
     *
     * @return AltAfContent - 变更后
     */
    public String getAltAfContent() {
        return altAfContent;
    }

    /**
     * 设置变更后
     *
     * @param altAfContent 变更后
     */
    public void setAltAfContent(String altAfContent) {
        this.altAfContent = altAfContent;
    }

    /**
     * 获取变更前
     *
     * @return AltBeContent - 变更前
     */
    public String getAltBeContent() {
        return altBeContent;
    }

    /**
     * 设置变更前
     *
     * @param altBeContent 变更前
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