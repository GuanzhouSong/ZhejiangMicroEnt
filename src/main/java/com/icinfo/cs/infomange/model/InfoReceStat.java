/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.infomange.model;

import com.icinfo.framework.mybatis.mapper.annotation.Before;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * 描述:    info_rece_stat 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2016年11月28日
 */
@Table(name = "cs_info_rece_stat")
public class InfoReceStat implements Serializable {
    /**
     * 自增主键ID
     */
    @Id
    @Column(name = "id")
    private Integer id;

    /**
     * 唯一标识
     */
    @Column(name = "UID")
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    @Before
    private String uid;

    /**
     * 主体身份代码
     */
    @Column(name = "PriPID")
    private String priPID;

    /**
     * 年份
     */
    @Column(name = "Year")
    private String year;

    /**
     * 数据类型，'1':双告知，'2':严重违法,'3':经营异常,'4':联合惩戒
     */
    @Column(name = "Type")
    private String type;

    /**
     * 部门行政编码
     */
    @Column(name = "Adcode")
    private String adcode;
    
    /**
     * 关联id
     */
    @Column(name = "RelateId")
    private String relateId;
    
    /**
     * 创建时间
     */
    @Column(name = "CreateTime")
    private Date createTime;

    private static final long serialVersionUID = 1L;

    /**
     * 获取自增主键ID
     *
     * @return id - 自增主键ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置自增主键ID
     *
     * @param id 自增主键ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取唯一标识
     *
     * @return UID - 唯一标识
     */
    public String getUid() {
        return uid;
    }

    /**
     * 设置唯一标识
     *
     * @param UID 唯一标识
     */
    public void setUid(String uid) {
        this.uid = uid;
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
     * 获取年份
     *
     * @return Year - 年份
     */
    public String getYear() {
        return year;
    }

    /**
     * 设置年份
     *
     * @param year 年份
     */
    public void setYear(String year) {
        this.year = year;
    }

    /**
     * 获取数据类型，'1':双告知，'2':严重违法,'3':经营异常,'4':联合惩戒
     *
     * @return Type - 数据类型，'1':双告知，'2':严重违法,'3':经营异常,'4':联合惩戒
     */
    public String getType() {
        return type;
    }

    /**
     * 设置数据类型，'1':双告知，'2':严重违法,'3':经营异常,'4':联合惩戒
     *
     * @param type 数据类型，'1':双告知，'2':严重违法,'3':经营异常,'4':联合惩戒
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 获取部门行政编码
     *
     * @return Adcode - 部门行政编码
     */
    public String getAdcode() {
        return adcode;
    }

    /**
     * 设置部门行政编码
     *
     * @param adcode 部门行政编码
     */
    public void setAdcode(String adcode) {
        this.adcode = adcode;
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

	public String getRelateId() {
		return relateId;
	}

	public void setRelateId(String relateId) {
		this.relateId = relateId;
	}
    
    
}