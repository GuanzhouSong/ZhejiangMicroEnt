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
 * 描述:  cs_dzhz 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年06月08日
 */
@Table(name = "cs_dzhz")
public class Dzhz implements Serializable {
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
     * 主体身份代码(CA14)
     */
    @Column(name = "PriPID")
    private String priPID;

    /**
     * 企业名称
     */
    @Column(name = "EntName")
    private String entName;

    /**
     * 回执人
     */
    @Column(name = "ReceivePeople")
    private String receivePeople;

    /**
     * 联系电话
     */
    @Column(name = "Tel")
    private String tel;

    /**
     * 回执日期
     */
    @Column(name = "ReceiveTime")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date receiveTime;

    /**
     * 创建时间
     */
    @Column(name = "CreateTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;

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
     * 获取主体身份代码(CA14)
     *
     * @return PriPID - 主体身份代码(CA14)
     */
    public String getPriPID() {
        return priPID;
    }

    /**
     * 设置主体身份代码(CA14)
     *
     * @param priPID 主体身份代码(CA14)
     */
    public void setPriPID(String priPID) {
        this.priPID = priPID;
    }

    /**
     * 获取企业名称
     *
     * @return EntName - 企业名称
     */
    public String getEntName() {
        return entName;
    }

    /**
     * 设置企业名称
     *
     * @param entName 企业名称
     */
    public void setEntName(String entName) {
        this.entName = entName;
    }

    /**
     * 获取回执人
     *
     * @return ReceivePeople - 回执人
     */
    public String getReceivePeople() {
        return receivePeople;
    }

    /**
     * 设置回执人
     *
     * @param receivePeople 回执人
     */
    public void setReceivePeople(String receivePeople) {
        this.receivePeople = receivePeople;
    }

    /**
     * 获取联系电话
     *
     * @return Tel - 联系电话
     */
    public String getTel() {
        return tel;
    }

    /**
     * 设置联系电话
     *
     * @param tel 联系电话
     */
    public void setTel(String tel) {
        this.tel = tel;
    }

    /**
     * 获取回执日期
     *
     * @return ReceiveTime - 回执日期
     */
    public Date getReceiveTime() {
        return receiveTime;
    }

    /**
     * 设置回执日期
     *
     * @param receiveTime 回执日期
     */
    public void setReceiveTime(Date receiveTime) {
        this.receiveTime = receiveTime;
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