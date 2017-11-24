/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.drcheck.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 描述:  cs_pub_scitem 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2016年10月25日
 */
@Table(name = "cs_pub_scitem")
public class PubScitem implements Serializable {
    /**
     * 自增序号
     */
    @Id
    @Column(name = "id")
    private Integer id;

    /**
     * 检查项类型 1:常规检查，2：重点检查，3：自定义检查
     */
    @Column(name = "ScType")
    private String scType;

    /**
     * 检查项编码
     */
    @Column(name = "ItemCode")
    private String itemCode;

    /**
     * 检查项名称
     */
    @Column(name = "ItemName")
    private String itemName;

    /**
     * 检查项内容
     */
    @Column(name = "ItemContent")
    private String itemContent;

    @Column(name = "SetUserId")
    private String setUserId;

    /**
     * 设置人
     */
    @Column(name = "SetUserName")
    private String setUserName;

    /**
     * 设置日期
     */
    @Column(name = "SetTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date setTime;

    /**
     * 设置部门编码
     */
    @Column(name = "SetDeptCode")
    private String setDeptCode;

    /**
     * 时间戳
     */
    @Column(name = "CreateTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;

    private static final long serialVersionUID = 1L;

    /**
     * 获取自增序号
     *
     * @return id - 自增序号
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置自增序号
     *
     * @param id 自增序号
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取检查项类型 1:常规检查，2：重点检查，3：自定义检查
     *
     * @return ScType - 检查项类型 1:常规检查，2：重点检查，3：自定义检查
     */
    public String getScType() {
        return scType;
    }

    /**
     * 设置检查项类型 1:常规检查，2：重点检查，3：自定义检查
     *
     * @param scType 检查项类型 1:常规检查，2：重点检查，3：自定义检查
     */
    public void setScType(String scType) {
        this.scType = scType;
    }

    /**
     * 获取检查项编码
     *
     * @return ItemCode - 检查项编码
     */
    public String getItemCode() {
        return itemCode;
    }

    /**
     * 设置检查项编码
     *
     * @param itemCode 检查项编码
     */
    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    /**
     * 获取检查项名称
     *
     * @return ItemName - 检查项名称
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * 设置检查项名称
     *
     * @param itemName 检查项名称
     */
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    /**
     * 获取检查项内容
     *
     * @return ItemContent - 检查项内容
     */
    public String getItemContent() {
        return itemContent;
    }

    /**
     * 设置检查项内容
     *
     * @param itemContent 检查项内容
     */
    public void setItemContent(String itemContent) {
        this.itemContent = itemContent;
    }

    /**
     * @return SetUserId
     */
    public String getSetUserId() {
        return setUserId;
    }

    /**
     * @param setUserId
     */
    public void setSetUserId(String setUserId) {
        this.setUserId = setUserId;
    }

    /**
     * 获取设置人
     *
     * @return SetUserName - 设置人
     */
    public String getSetUserName() {
        return setUserName;
    }

    /**
     * 设置设置人
     *
     * @param setUserName 设置人
     */
    public void setSetUserName(String setUserName) {
        this.setUserName = setUserName;
    }

    /**
     * 获取设置日期
     *
     * @return SetTime - 设置日期
     */
    public Date getSetTime() {
        return setTime;
    }

    /**
     * 设置设置日期
     *
     * @param setTime 设置日期
     */
    public void setSetTime(Date setTime) {
        this.setTime = setTime;
    }

    /**
     * 获取设置部门编码
     *
     * @return SetDeptCode - 设置部门编码
     */
    public String getSetDeptCode() {
        return setDeptCode;
    }

    /**
     * 设置设置部门编码
     *
     * @param setDeptCode 设置部门编码
     */
    public void setSetDeptCode(String setDeptCode) {
        this.setDeptCode = setDeptCode;
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