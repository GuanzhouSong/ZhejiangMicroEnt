/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.ext.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.icinfo.framework.mybatis.mapper.annotation.Before;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * 描述:    cs_mid_altitem 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2016年10月20日
 */
@Table(name = "cs_mid_altitem")
public class MidAltitem implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 311531567166953215L;

	@Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "PriPID")
    private String priPID;

    @Column(name = "AltItem")
    private String altItem;//变更事项

    @Column(name = "AltTime")
    private Integer altTime;//变更次数

    @Column(name = "AltDate")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8") 
    private Date altDate;//变更日期

    @Column(name = "UID")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    private String UID;

    @Column(name = "CreateTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8") 
    private Date createTime;//时间戳

    @Column(name = "AltBeContent")
    private String altBeContent;//变更前内容

    @Column(name = "AltAfContent")
    private String altAfContent;//变更后内容

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
     * @return AltItem
     */
    public String getAltItem() {
        return altItem;
    }

    /**
     * @param altItem
     */
    public void setAltItem(String altItem) {
        this.altItem = altItem;
    }

    /**
     * @return AltTime
     */
    public Integer getAltTime() {
        return altTime;
    }

    /**
     * @param altTime
     */
    public void setAltTime(Integer altTime) {
        this.altTime = altTime;
    }

    /**
     * @return AltDate
     */
    public Date getAltDate() {
        return altDate;
    }

    /**
     * @param altDate
     */
    public void setAltDate(Date altDate) {
        this.altDate = altDate;
    }

    /**
     * @return UID
     */
    public String getUID() {
        return UID;
    }

    /**
     * @param UID
     */
    public void setUID(String UID) {
        this.UID = UID;
    }

    /**
     * @return CreateTime
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return AltBeContent
     */
    public String getAltBeContent() {
        return altBeContent;
    }

    /**
     * @param altBeContent
     */
    public void setAltBeContent(String altBeContent) {
        this.altBeContent = altBeContent;
    }

    /**
     * @return AltAfContent
     */
    public String getAltAfContent() {
        return altAfContent;
    }

    /**
     * @param altAfContent
     */
    public void setAltAfContent(String altAfContent) {
        this.altAfContent = altAfContent;
    }
}