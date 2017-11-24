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
 * 描述:    cs_foodstorage_license 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2016年09月26日
 */
@Table(name = "cs_foodstorage_license")
public class FoodstorageLicense implements Serializable {
    /**
     * 主键ID
     */
    @Id
    @Column(name = "id")
    private Integer id;

    /**
     * 主体身份代码
     */
    @Column(name = "PriPID")
    private String priPID;

    /**
     * 年度
     */
    @Column(name = "Year")
    private Integer year;

    /**
     * 序号
     */
    @Column(name = "UID")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    private String UID;

    /**
     * 许可证编号
     */
    @Column(name = "LicNO")
    private String licNO;

    /**
     * 许可证名称
     */
    @Column(name = "LicNameCN")
    private String licNameCN;

    /**
     * 许可机关
     */
    @Column(name = "LicAnth")
    private String licAnth;

    /**
     * 有效期开始
     */
    @Column(name = "LicValFrom")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date licValFrom;

    /**
     * 有效期截至
     */
    @Column(name = "LicValTo")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date licValTo;

    /**
     * 类型：1 食品生成许可证 ；2 食品流通许可证
     */
    @Column(name = "LicType")
    private String licType;

    /**
     * 时间
     */
    @Column(name = "CreateTime")
    private Date createTime;

    /**
     * 许可内容
     */
    @Column(name = "LicScope")
    private String licScope;

    /**
     * 备注
     */
    @Column(name = "Remark")
    private String remark;

    private static final long serialVersionUID = 1L;

    /**
     * 获取主键ID
     *
     * @return id - 主键ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置主键ID
     *
     * @param id 主键ID
     */
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
     * 获取序号
     *
     * @return UID - 序号
     */
    public String getUID() {
        return UID;
    }

    /**
     * 设置序号
     *
     * @param UID 序号
     */
    public void setUID(String UID) {
        this.UID = UID;
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
     * 获取许可证名称
     *
     * @return LicNameCN - 许可证名称
     */
    public String getLicNameCN() {
        return licNameCN;
    }

    /**
     * 设置许可证名称
     *
     * @param licNameCN 许可证名称
     */
    public void setLicNameCN(String licNameCN) {
        this.licNameCN = licNameCN;
    }

    /**
     * 获取许可机关
     *
     * @return LicAnth - 许可机关
     */
    public String getLicAnth() {
        return licAnth;
    }

    /**
     * 设置许可机关
     *
     * @param licAnth 许可机关
     */
    public void setLicAnth(String licAnth) {
        this.licAnth = licAnth;
    }

    /**
     * 获取有效期开始
     *
     * @return LicValFrom - 有效期开始
     */
    public Date getLicValFrom() {
        return licValFrom;
    }

    /**
     * 设置有效期开始
     *
     * @param licValFrom 有效期开始
     */
    public void setLicValFrom(Date licValFrom) {
        this.licValFrom = licValFrom;
    }

    /**
     * 获取有效期截至
     *
     * @return LicValTo - 有效期截至
     */
    public Date getLicValTo() {
        return licValTo;
    }

    /**
     * 设置有效期截至
     *
     * @param licValTo 有效期截至
     */
    public void setLicValTo(Date licValTo) {
        this.licValTo = licValTo;
    }

    /**
     * 获取类型：1 食品生成许可证 ；2 食品流通许可证
     *
     * @return LicType - 类型：1 食品生成许可证 ；2 食品流通许可证
     */
    public String getLicType() {
        return licType;
    }

    /**
     * 设置类型：1 食品生成许可证 ；2 食品流通许可证
     *
     * @param licType 类型：1 食品生成许可证 ；2 食品流通许可证
     */
    public void setLicType(String licType) {
        this.licType = licType;
    }

    /**
     * 获取时间
     *
     * @return CreateTime - 时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置时间
     *
     * @param createTime 时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取许可内容
     *
     * @return LicScope - 许可内容
     */
    public String getLicScope() {
        return licScope;
    }

    /**
     * 设置许可内容
     *
     * @param licScope 许可内容
     */
    public void setLicScope(String licScope) {
        this.licScope = licScope;
    }

    /**
     * 获取备注
     *
     * @return Remark - 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注
     *
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }
    
    @Override
   	public String toString() {
   		return "FoodstorageLicense [id=" + id + ", priPID=" + priPID + ", UID="
   				+ UID + ", year=" + year + ", licNO="
   				+ licNO + ", licNameCN=" + licNameCN + ", licValFrom="
   				+ licValFrom + ", licValTo=" + licValTo + ", licType=" + licType
   				+ ", createTime=" + createTime + ", licScope=" + licScope + ", remark=" + remark + "]";
   	}
}