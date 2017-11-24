/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.other.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.icinfo.framework.mybatis.mapper.annotation.Before;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * 描述:  cs_pub_server_modrecord 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2016年11月04日
 */
@Table(name = "cs_pub_server_modrecord")
public class PubServerModrecord implements Serializable {
    /**
     * 自增id
     */
    @Id
    @Column(name = "id")
   
    private Integer id;

    /**
     * 修改序号
     */
    @Column(name = "ModNO")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    private String modNO;

    /**
     * 主体身份代码
     */
    @Column(name = "PriPID")
    private String priPID;

    /**
     * 修改内容序号
     */
    @Column(name = "ModUID")
   private String modUID;

    /**
     * 修改事项
     */
    @Column(name = "AltItem")
    private String altItem;

    /**
     * 修改记录对应表
     */
    @Column(name = "AltTable")
    private String altTable;

    /**
     * 记录号
     */
    @Column(name = "HisNO")
    private String hisNO;

    /**
     * 修改日期
     */
    @Column(name = "AltDate")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date altDate;

    /**
     * 时间戳
     */
    @Column(name = "CreateTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;

    /**
     * 修改前
     */
    @Column(name = "AltBe")
    private String altBe;

    /**
     * 修改后
     */
    @Column(name = "AltAf")
    private String altAf;

    private static final long serialVersionUID = 1L;

    /**
     * 获取自增id
     *
     * @return id - 自增id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置自增id
     *
     * @param id 自增id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取修改序号
     *
     * @return ModNO - 修改序号
     */
    public String getModNO() {
        return modNO;
    }

    /**
     * 设置修改序号
     *
     * @param modNO 修改序号
     */
    public void setModNO(String modNO) {
        this.modNO = modNO;
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
     * 获取修改内容序号
     *
     * @return ModUID - 修改内容序号
     */
    public String getModUID() {
        return modUID;
    }

    /**
     * 设置修改内容序号
     *
     * @param modUID 修改内容序号
     */
    public void setModUID(String modUID) {
        this.modUID = modUID;
    }

    /**
     * 获取修改事项
     *
     * @return AltItem - 修改事项
     */
    public String getAltItem() {
        return altItem;
    }

    /**
     * 设置修改事项
     *
     * @param altItem 修改事项
     */
    public void setAltItem(String altItem) {
        this.altItem = altItem;
    }

    /**
     * 获取修改记录对应表
     *
     * @return AltTable - 修改记录对应表
     */
    public String getAltTable() {
        return altTable;
    }

    /**
     * 设置修改记录对应表
     *
     * @param altTable 修改记录对应表
     */
    public void setAltTable(String altTable) {
        this.altTable = altTable;
    }

    /**
     * 获取记录号
     *
     * @return HisNO - 记录号
     */
    public String getHisNO() {
        return hisNO;
    }

    /**
     * 设置记录号
     *
     * @param hisNO 记录号
     */
    public void setHisNO(String hisNO) {
        this.hisNO = hisNO;
    }

    /**
     * 获取修改日期
     *
     * @return AltDate - 修改日期
     */
    public Date getAltDate() {
        return altDate;
    }

    /**
     * 设置修改日期
     *
     * @param altDate 修改日期
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
     * 获取修改前
     *
     * @return AltBe - 修改前
     */
    public String getAltBe() {
        return altBe;
    }

    /**
     * 设置修改前
     *
     * @param altBe 修改前
     */
    public void setAltBe(String altBe) {
        this.altBe = altBe;
    }

    /**
     * 获取修改后
     *
     * @return AltAf - 修改后
     */
    public String getAltAf() {
        return altAf;
    }

    /**
     * 设置修改后
     *
     * @param altAf 修改后
     */
    public void setAltAf(String altAf) {
        this.altAf = altAf;
    }
}