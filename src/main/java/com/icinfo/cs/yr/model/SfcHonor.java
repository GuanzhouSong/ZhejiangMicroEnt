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
 * 描述:  cs_sfc_honor 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2016年10月19日
 */
@Table(name = "cs_sfc_honor")
public class SfcHonor implements Serializable {
    /**
     * 自增ID
     */
    @Id
    @Column(name = "id")
    private Integer id;

    /**
     * 序号
     */
    @Column(name = "UID")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    private String uid;

    /**
     * 内部序号
     */
    @Column(name = "PriPID")
    private String priPID;

    /**
     * 年度
     */
    @Column(name = "Year")
    private Integer year;

    /**
     * 合作社及负责人获得的其它社会荣誉名称
     */
    @Column(name = "FarArtHonorName")
    private String farArtHonorName;

    /**
     * 授予机关
     */
    @Column(name = "FarArtHonorIssAut")
    private String farArtHonorIssAut;

    /**
     * 有效期始
     */
    @Column(name = "ValFrom")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date valFrom;


    /**
     * 截止日期
     */
    @Column(name = "ValTo")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date valTo;

    /**
     * 时间戳
     */
    @Column(name = "CreateTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;


    private static final long serialVersionUID = 1L;

    /**
     * 获取自增ID
     *
     * @return id - 自增ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置自增ID
     *
     * @param id 自增ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取序号
     *
     * @return uid - 序号
     */
    public String getUid() {
        return uid;
    }


    /**
     * 设置序号
     *
     * @param uid 序号
     */
    public void setUid(String uid) {
        this.uid = uid;
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
     * 获取年度
     *
     * @return Year - 年度
     */
    public Integer getYear() {
        return year;
    }

    /**
     * 设置年度
     *
     * @param year 年度
     */
    public void setYear(Integer year) {
        this.year = year;
    }

    /**
     * 获取合作社及负责人获得的其它社会荣誉名称
     *
     * @return FarArtHonorName - 合作社及负责人获得的其它社会荣誉名称
     */
    public String getFarArtHonorName() {
        return farArtHonorName;
    }

    /**
     * 设置合作社及负责人获得的其它社会荣誉名称
     *
     * @param farArtHonorName 合作社及负责人获得的其它社会荣誉名称
     */
    public void setFarArtHonorName(String farArtHonorName) {
        this.farArtHonorName = farArtHonorName;
    }

    /**
     * 获取授予机关
     *
     * @return FarArtHonorIssAut - 授予机关
     */
    public String getFarArtHonorIssAut() {
        return farArtHonorIssAut;
    }

    /**
     * 设置授予机关
     *
     * @param farArtHonorIssAut 授予机关
     */
    public void setFarArtHonorIssAut(String farArtHonorIssAut) {
        this.farArtHonorIssAut = farArtHonorIssAut;
    }

    /**
     * 获取有效期始
     *
     * @return ValFrom - 有效期始
     */
    public Date getValFrom() {
        return valFrom;
    }

    /**
     * 设置有效期始
     *
     * @param valFrom 有效期始
     */
    public void setValFrom(Date valFrom) {
        this.valFrom = valFrom;
    }

    /**
     * 获取截止日期
     *
     * @return ValFrom - 有效期始
     */
    public Date getValTo() {
        return valTo;
    }
    /**
     * 设置截止日期
     *
     * @param valTo 截止日期
     */
    public void setValTo(Date valTo) {
        this.valTo = valTo;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}