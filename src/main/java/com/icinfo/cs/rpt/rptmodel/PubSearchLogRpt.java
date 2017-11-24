/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.rpt.rptmodel;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.icinfo.framework.mybatis.mapper.annotation.Before;

/**
 * 描述:    cs_pub_search_log 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年10月09日
 */
@Table(name = "cs_pub_search_log")
public class PubSearchLogRpt implements Serializable {
    @Id
    @Column(name = "id")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    private Integer id;

    /**
     * 搜索关键字
     */
    @Column(name = "PubSearchKey")
    private String pubSearchKey;

    /**
     * 搜索时间
     */
    @Column(name = "PubTime")
    private Date pubTime;

    /**
     * 来访ip
     */
    @Column(name = "PubIp")
    private String pubIp;

    /**
     * 访问类型(1是搜索，2：详情页面打开)
     */
    @Column(name = "PubType")
    private String pubType;

    /**
     * 内部序号
     */
    @Column(name = "PriPID")
    private String priPID;

    /**
     * 备注
     */
    @Column(name = "PubRemark")
    private String pubRemark;

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
     * 获取搜索关键字
     *
     * @return PubSearchKey - 搜索关键字
     */
    public String getPubSearchKey() {
        return pubSearchKey;
    }

    /**
     * 设置搜索关键字
     *
     * @param pubSearchKey 搜索关键字
     */
    public void setPubSearchKey(String pubSearchKey) {
        this.pubSearchKey = pubSearchKey;
    }

    /**
     * 获取搜索时间
     *
     * @return PubTime - 搜索时间
     */
    public Date getPubTime() {
        return pubTime;
    }

    /**
     * 设置搜索时间
     *
     * @param pubTime 搜索时间
     */
    public void setPubTime(Date pubTime) {
        this.pubTime = pubTime;
    }

    /**
     * 获取来访ip
     *
     * @return PubIp - 来访ip
     */
    public String getPubIp() {
        return pubIp;
    }

    /**
     * 设置来访ip
     *
     * @param pubIp 来访ip
     */
    public void setPubIp(String pubIp) {
        this.pubIp = pubIp;
    }

    /**
     * 获取访问类型(1是搜索，2：详情页面打开)
     *
     * @return PubType - 访问类型(1是搜索，2：详情页面打开)
     */
    public String getPubType() {
        return pubType;
    }

    /**
     * 设置访问类型(1是搜索，2：详情页面打开)
     *
     * @param pubType 访问类型(1是搜索，2：详情页面打开)
     */
    public void setPubType(String pubType) {
        this.pubType = pubType;
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
     * 获取备注
     *
     * @return PubRemark - 备注
     */
    public String getPubRemark() {
        return pubRemark;
    }

    /**
     * 设置备注
     *
     * @param pubRemark 备注
     */
    public void setPubRemark(String pubRemark) {
        this.pubRemark = pubRemark;
    }
}