/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.es.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.icinfo.framework.mybatis.mapper.annotation.Before;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * 描述:    cs_attachment_estate 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2016年11月09日
 */
@Table(name = "cs_attachment_estate")
public class CsAttachmentEstate implements Serializable {
    /**
     * 自增ID
     */
    @Id
    @Column(name = "id")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    private Integer id;

    /**
     * 内部序号
     */
    @Column(name = "PriPID")
    private String priPID;

    /**
     * 证件号码
     */
    @Column(name = "CerNO")
    private String cerNO;

    /**
     * 查封文号
     */
    @Column(name = "AttachmentNO")
    private String attachmentNO;

    /**
     * 查封类型
     */
    @Column(name = "AttachmenType")
    private String attachmenType;

    /**
     * 查封不动产地址
     */
    @Column(name = "EstateAddr")
    private String estateAddr;

    /**
     * 申请查封单位
     */
    @Column(name = "AttachmentDep")
    private String attachmentDep;

    /**
     * 查封申请日期
     */
    @Column(name = "AttachmentDate")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date attachmentDate;

    /**
     * 撤销查封日期
     */
    @Column(name = "AttachmentCanDate")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date attachmentCanDate;

    /**
     * 查封状态
     */
    @Column(name = "AttachmenStatus")
    private String attachmenStatus;

    @Column(name = "CreateTime")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
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
     * 获取内部序号
     *
     * @return priPID - 内部序号
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
     * 获取证件号码
     *
     * @return CerNO - 证件号码
     */
    public String getCerNO() {
        return cerNO;
    }

    /**
     * 设置证件号码
     *
     * @param cerNO 证件号码
     */
    public void setCerNO(String cerNO) {
        this.cerNO = cerNO;
    }

    /**
     * 获取查封文号
     *
     * @return AttachmentNO - 查封文号
     */
    public String getAttachmentNO() {
        return attachmentNO;
    }

    /**
     * 设置查封文号
     *
     * @param attachmentNO 查封文号
     */
    public void setAttachmentNO(String attachmentNO) {
        this.attachmentNO = attachmentNO;
    }

    /**
     * 获取查封类型
     *
     * @return AttachmenType - 查封类型
     */
    public String getAttachmenType() {
        return attachmenType;
    }

    /**
     * 设置查封类型
     *
     * @param attachmenType 查封类型
     */
    public void setAttachmenType(String attachmenType) {
        this.attachmenType = attachmenType;
    }

    /**
     * 获取查封不动产地址
     *
     * @return EstateAddr - 查封不动产地址
     */
    public String getEstateAddr() {
        return estateAddr;
    }

    /**
     * 设置查封不动产地址
     *
     * @param estateAddr 查封不动产地址
     */
    public void setEstateAddr(String estateAddr) {
        this.estateAddr = estateAddr;
    }

    /**
     * 获取申请查封单位
     *
     * @return AttachmentDep - 申请查封单位
     */
    public String getAttachmentDep() {
        return attachmentDep;
    }

    /**
     * 设置申请查封单位
     *
     * @param attachmentDep 申请查封单位
     */
    public void setAttachmentDep(String attachmentDep) {
        this.attachmentDep = attachmentDep;
    }

    /**
     * 获取查封申请日期
     *
     * @return AttachmentDate - 查封申请日期
     */
    public Date getAttachmentDate() {
        return attachmentDate;
    }

    /**
     * 设置查封申请日期
     *
     * @param attachmentDate 查封申请日期
     */
    public void setAttachmentDate(Date attachmentDate) {
        this.attachmentDate = attachmentDate;
    }

    /**
     * 获取撤销查封日期
     *
     * @return AttachmentCanDate - 撤销查封日期
     */
    public Date getAttachmentCanDate() {
        return attachmentCanDate;
    }

    /**
     * 设置撤销查封日期
     *
     * @param attachmentCanDate 撤销查封日期
     */
    public void setAttachmentCanDate(Date attachmentCanDate) {
        this.attachmentCanDate = attachmentCanDate;
    }

    /**
     * 获取查封状态
     *
     * @return AttachmenStatus - 查封状态
     */
    public String getAttachmenStatus() {
        return attachmenStatus;
    }

    /**
     * 设置查封状态
     *
     * @param attachmenStatus 查封状态
     */
    public void setAttachmenStatus(String attachmenStatus) {
        this.attachmenStatus = attachmenStatus;
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
}