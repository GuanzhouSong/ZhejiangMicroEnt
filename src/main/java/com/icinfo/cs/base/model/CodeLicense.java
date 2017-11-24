/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.base.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 描述:    cs_code_license 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2016年10月18日
 */
@Table(name = "cs_code_license")
public class CodeLicense implements Serializable {
    @Id
    @Column(name = "id")
    private Integer id;

    /**
     * 审批事项编码
     */
    @Column(name = "ExaCode")
    private String exaCode;

    /**
     * 审批事项名称
     */
    @Column(name = "ExaName")
    private String exaName;

    /**
     * 法律依据
     */
    @Column(name = "LicRea")
    private String licRea;

    /**
     * 审批机关
     */
    @Column(name = "LicDept")
    private String licDept;

    /**
     * 登记/属地 1:登记； 2：属地
     */
    @Column(name = "LicDeptType")
    private String licDeptType;

    /**
     * 级别
     */
    @Column(name = "LicZone")
    private String licZone;

    /**
     * 类型
     */
    @Column(name = "LicType")
    private String licType;

    /**
     * 时间戳
     */
    @Column(name = "CreateTime")
    private Date createTime;

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
     * 获取审批事项编码
     *
     * @return ExaCode - 审批事项编码
     */
    public String getExaCode() {
        return exaCode;
    }

    /**
     * 设置审批事项编码
     *
     * @param exaCode 审批事项编码
     */
    public void setExaCode(String exaCode) {
        this.exaCode = exaCode;
    }

    /**
     * 获取审批事项名称
     *
     * @return ExaName - 审批事项名称
     */
    public String getExaName() {
        return exaName;
    }

    /**
     * 设置审批事项名称
     *
     * @param exaName 审批事项名称
     */
    public void setExaName(String exaName) {
        this.exaName = exaName;
    }

    /**
     * 获取法律依据
     *
     * @return LicRea - 法律依据
     */
    public String getLicRea() {
        return licRea;
    }

    /**
     * 设置法律依据
     *
     * @param licRea 法律依据
     */
    public void setLicRea(String licRea) {
        this.licRea = licRea;
    }

    /**
     * 获取审批机关
     *
     * @return LicDept - 审批机关
     */
    public String getLicDept() {
        return licDept;
    }

    /**
     * 设置审批机关
     *
     * @param licDept 审批机关
     */
    public void setLicDept(String licDept) {
        this.licDept = licDept;
    }

    /**
     * 获取登记/属地 1:登记； 2：属地
     *
     * @return LicDeptType - 登记/属地 1:登记； 2：属地
     */
    public String getLicDeptType() {
        return licDeptType;
    }

    /**
     * 设置登记/属地 1:登记； 2：属地
     *
     * @param licDeptType 登记/属地 1:登记； 2：属地
     */
    public void setLicDeptType(String licDeptType) {
        this.licDeptType = licDeptType;
    }

    /**
     * 获取级别
     *
     * @return LicZone - 级别
     */
    public String getLicZone() {
        return licZone;
    }

    /**
     * 设置级别
     *
     * @param licZone 级别
     */
    public void setLicZone(String licZone) {
        this.licZone = licZone;
    }

    /**
     * 获取类型
     *
     * @return LicType - 类型
     */
    public String getLicType() {
        return licType;
    }

    /**
     * 设置类型
     *
     * @param licType 类型
     */
    public void setLicType(String licType) {
        this.licType = licType;
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
}