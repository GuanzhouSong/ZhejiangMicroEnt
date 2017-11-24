/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.yr.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 描述:    cs_pub_server_hismod 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2016年10月17日
 */
@Table(name = "cs_pub_server_hismod")
public class PubServerHisMod implements Serializable {
    /**
     * 自增id
     */
    @Column(name = "id")
    private Integer id;

    /**
     * 记录号
     */
    @Column(name = "HisNO")
    private String hisNO;

    /**
     * 主体身份代码
     */
    @Column(name = "PriPID")
    private String priPID;

    /**
     * 1:审核通过，2：审核不通
     */
    @Column(name = "AuditState")
    private String auditState;

    /**
     * 审核日期
     */
    @Column(name = "AuditDate")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date auditDate;

    /**
     * 审核人
     */
    @Column(name = "AuditName")
    private String auditName;

    /**
     * 修改记录对应表
     */
    @Column(name = "AltTable")
    private String altTable;

    /**
     * 修改内容序号
     */
    @Column(name = "ModUID")
    private String modUID;

    /**
     * 修改人
     */
    @Column(name = "AltName")
    private String altName;

    /**
     * 修改日期
     */
    @Column(name = "AltDate")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date altDate;

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
     * 获取1:审核通过，2：审核不通
     *
     * @return AuditState - 1:审核通过，2：审核不通
     */
    public String getAuditState() {
        return auditState;
    }

    /**
     * 设置1:审核通过，2：审核不通
     *
     * @param auditState 1:审核通过，2：审核不通
     */
    public void setAuditState(String auditState) {
        this.auditState = auditState;
    }

    /**
     * 获取审核日期
     *
     * @return AuditDate - 审核日期
     */
    public Date getAuditDate() {
        return auditDate;
    }

    /**
     * 设置审核日期
     *
     * @param auditDate 审核日期
     */
    public void setAuditDate(Date auditDate) {
        this.auditDate = auditDate;
    }

    /**
     * 获取审核人
     *
     * @return AuditName - 审核人
     */
    public String getAuditName() {
        return auditName;
    }

    /**
     * 设置审核人
     *
     * @param auditName 审核人
     */
    public void setAuditName(String auditName) {
        this.auditName = auditName;
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
     * 获取修改人
     *
     * @return AltName - 修改人
     */
    public String getAltName() {
        return altName;
    }

    /**
     * 设置修改人
     *
     * @param altName 修改人
     */
    public void setAltName(String altName) {
        this.altName = altName;
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
}