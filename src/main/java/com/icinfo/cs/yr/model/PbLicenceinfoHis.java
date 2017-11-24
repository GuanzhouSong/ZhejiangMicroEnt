/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.yr.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * 描述:    cs_pb_licenceinfo_his 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2016年09月28日
 */
@Table(name = "cs_pb_licenceinfo_his")
public class PbLicenceinfoHis implements Serializable {
    @Id
    @Column(name = "id")
    private Integer id;

    /**
     * 许可文件名称
     */
    @Column(name = "LicName")
    private String licName;

    /**
     * 许可有效日期至
     */
    @Column(name = "ValTo")
    private Date valTo;

    /**
     * 时间戳
     */
    @Column(name = "CreateTime")
    private Date createTime;

    /**
     * 许可文件中文名称
     */
    @Column(name = "LicNameCN")
    private String licNameCN;

    /**
     * 许可文件id(IND_LIC_NO)
     */
    @Column(name = "LicID")
    private String licID;

    /**
     * 年报id（LIC_REPORT_NO）
     */
    @Column(name = "AnCheID")
    private String anCheID;

    /**
     * 年报提交编号
     */
    @Column(name = "ReportNo")
    private String reportNo;

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
     * 获取许可文件名称
     *
     * @return LicName - 许可文件名称
     */
    public String getLicName() {
        return licName;
    }

    /**
     * 设置许可文件名称
     *
     * @param licName 许可文件名称
     */
    public void setLicName(String licName) {
        this.licName = licName;
    }

    /**
     * 获取许可有效日期至
     *
     * @return ValTo - 许可有效日期至
     */
    public Date getValTo() {
        return valTo;
    }

    /**
     * 设置许可有效日期至
     *
     * @param valTo 许可有效日期至
     */
    public void setValTo(Date valTo) {
        this.valTo = valTo;
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
     * 获取许可文件中文名称
     *
     * @return LicNameCN - 许可文件中文名称
     */
    public String getLicNameCN() {
        return licNameCN;
    }

    /**
     * 设置许可文件中文名称
     *
     * @param licNameCN 许可文件中文名称
     */
    public void setLicNameCN(String licNameCN) {
        this.licNameCN = licNameCN;
    }

    /**
     * 获取许可文件id(IND_LIC_NO)
     *
     * @return LicID - 许可文件id(IND_LIC_NO)
     */
    public String getLicID() {
        return licID;
    }

    /**
     * 设置许可文件id(IND_LIC_NO)
     *
     * @param licID 许可文件id(IND_LIC_NO)
     */
    public void setLicID(String licID) {
        this.licID = licID;
    }

    /**
     * 获取年报id（LIC_REPORT_NO）
     *
     * @return AnCheID - 年报id（LIC_REPORT_NO）
     */
    public String getAnCheID() {
        return anCheID;
    }

    /**
     * 设置年报id（LIC_REPORT_NO）
     *
     * @param anCheID 年报id（LIC_REPORT_NO）
     */
    public void setAnCheID(String anCheID) {
        this.anCheID = anCheID;
    }

    /**
     * 获取年报提交编号
     *
     * @return ReportNo - 年报提交编号
     */
    public String getReportNo() {
        return reportNo;
    }

    /**
     * 设置年报提交编号
     *
     * @param reportNo 年报提交编号
     */
    public void setReportNo(String reportNo) {
        this.reportNo = reportNo;
    }
}