/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.yr.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 描述:    cs_foodstorage_aux 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2016年09月26日
 */
@Table(name = "cs_foodstorage_aux")
public class FoodstorageAux implements Serializable {
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
     * info表的FS_NO
     */
    @Column(name = "FsinfoID")
    private String fsinfoID;

    /**
     * 年度
     */
    @Column(name = "Year")
    private Integer year;

    /**
     * 编码 
     */
    @Column(name = "Code")
    private String code;

    /**
     * 内容
     */
    @Column(name = "Content")
    private String content;

    /**
     * 上级编码 1:建筑类型；2:仓库类型；3:食品种类；4:运输车辆；
     */
    @Column(name = "SupCode")
    private String supCode;

    /**
     * 类型 1:自有
     */
    @Column(name = "OwnType")
    private String ownType;

    /**
     * 类型 3:其它
     */
    @Column(name = "OtherType")
    private String otherType;

    /**
     * 时间戳
     */
    @Column(name = "CreateTime")
    private Date createTime;

    /**
     * 类型 2:租赁
     */
    @Column(name = "HireType")
    private String hireType;

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
     * 获取info表的FS_NO
     *
     * @return FsinfoID - info表的FS_NO
     */
    public String getFsinfoID() {
        return fsinfoID;
    }

    /**
     * 设置info表的FS_NO
     *
     * @param fsinfoID info表的FS_NO
     */
    public void setFsinfoID(String fsinfoID) {
        this.fsinfoID = fsinfoID;
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
     * 获取编码 
     *
     * @return Code - 编码 
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置编码 
     *
     * @param code 编码 
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 获取内容
     *
     * @return Content - 内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置内容
     *
     * @param content 内容
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 获取上级编码 1:建筑类型；2:仓库类型；3:食品种类；4:运输车辆；
     *
     * @return SupCode - 上级编码 1:建筑类型；2:仓库类型；3:食品种类；4:运输车辆；
     */
    public String getSupCode() {
        return supCode;
    }

    /**
     * 设置上级编码 1:建筑类型；2:仓库类型；3:食品种类；4:运输车辆；
     *
     * @param supCode 上级编码 1:建筑类型；2:仓库类型；3:食品种类；4:运输车辆；
     */
    public void setSupCode(String supCode) {
        this.supCode = supCode;
    }

    /**
     * 获取类型 1:自有
     *
     * @return OwnType - 类型 1:自有
     */
    public String getOwnType() {
        return ownType;
    }

    /**
     * 设置类型 1:自有
     *
     * @param ownType 类型 1:自有
     */
    public void setOwnType(String ownType) {
        this.ownType = ownType;
    }

    /**
     * 获取类型 3:其它
     *
     * @return OtherType - 类型 3:其它
     */
    public String getOtherType() {
        return otherType;
    }

    /**
     * 设置类型 3:其它
     *
     * @param otherType 类型 3:其它
     */
    public void setOtherType(String otherType) {
        this.otherType = otherType;
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
     * 获取类型 2:租赁
     *
     * @return HireType - 类型 2:租赁
     */
    public String getHireType() {
        return hireType;
    }

    /**
     * 设置类型 2:租赁
     *
     * @param hireType 类型 2:租赁
     */
    public void setHireType(String hireType) {
        this.hireType = hireType;
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
   		return "FoodstorageLicense [id=" + id + ", priPID=" + priPID + ", fsinfoID="
   				+ fsinfoID + ", year=" + year + ", code="
   				+ code + ", content=" + content + ", supCode="
   				+ supCode + ", ownType=" + ownType + ", otherType=" + otherType
   				+ ", createTime=" + createTime + ", hireType=" + hireType + ", remark=" + remark + "]";
   	}
}