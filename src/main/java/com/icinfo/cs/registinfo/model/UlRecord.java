/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.registinfo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.icinfo.framework.mybatis.mapper.annotation.Before;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * 描述:    cs_ul_record 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2016年09月09日
 */
@Table(name = "cs_ul_record")
public class UlRecord implements Serializable {

    @Id
    @Column(name = "id")
    private Integer id;
    /**
     * 主体身份代码
     */
    @Column(name = "PriPID")
    private String priPID;

    /**
     * 许可证名称
     */
    @Column(name = "LicName")
    private String licName;

    /**
     * 许可证编号
     */
    @Column(name = "LicNO")
    private String licNO;

    /**
     * 创建时间
     */
    @Column(name = "CreateTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;

    /**
     * 无照的UUID
     */
    @Column(name = "UID")
    private String UID;

    /**
     * 许可证状况说明
     */
    @Column(name = "Remark")
    private String remark;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
     * 获取许可证名称
     *
     * @return LicName - 许可证名称
     */
    public String getLicName() {
        return licName;
    }

    /**
     * 设置许可证名称
     *
     * @param licName 许可证名称
     */
    public void setLicName(String licName) {
        this.licName = licName;
    }

    /**
     * 获取许可证编号
     *
     * @return LicNO - 许可证编号
     */
    public String getLicNO() {
        return licNO;
    }

    /**
     * 设置许可证编号
     *
     * @param licNO 许可证编号
     */
    public void setLicNO(String licNO) {
        this.licNO = licNO;
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
     * 获取无照的UUID
     *
     * @return UID - 无照的UUID
     */
    public String getUID() {
        return UID;
    }

    /**
     * 设置无照的UUID
     *
     * @param UID 无照的UUID
     */
    public void setUID(String UID) {
        this.UID = UID;
    }

    /**
     * 获取许可证状况说明
     *
     * @return Remark - 许可证状况说明
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置许可证状况说明
     *
     * @param remark 许可证状况说明
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }
}