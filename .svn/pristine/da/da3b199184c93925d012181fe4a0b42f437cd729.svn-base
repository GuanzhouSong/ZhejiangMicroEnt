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
 * 描述:    cs_mort_altitem_info 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2016年10月26日
 */
@Table(name = "cs_mort_altitem_info")
public class MortAltitemInfo implements Serializable {
    /**
     * 自增ID
     */
    @Id
    @Column(name = "id")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    private Integer id;

    /**
     * 原始抵押登记编号
     */
    @Column(name = "OriFilingNO")
    private String oriFilingNO;

    /**
     * 改动内容
     */
    @Column(name = "Remark")
    private String remark;

    /**
     * 确认状态:0:未确认1:已确认
     */
    @Column(name = "CheckStatus")
    private String checkStatus;

    /**
     * 受理时间
     */
    @Column(name = "CheckDate")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8") 
    private Date checkDate;

    @Column(name = "CreateTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8") 
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
     * 获取原始抵押登记编号
     *
     * @return OriFilingNO - 原始抵押登记编号
     */
    public String getOriFilingNO() {
        return oriFilingNO;
    }

    /**
     * 设置原始抵押登记编号
     *
     * @param oriFilingNO 原始抵押登记编号
     */
    public void setOriFilingNO(String oriFilingNO) {
        this.oriFilingNO = oriFilingNO;
    }

    /**
     * 获取改动内容
     *
     * @return Remark - 改动内容
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置改动内容
     *
     * @param remark 改动内容
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * 获取确认状态:0:未确认1:已确认
     *
     * @return CheckStatus - 确认状态:0:未确认1:已确认
     */
    public String getCheckStatus() {
        return checkStatus;
    }

    /**
     * 设置确认状态:0:未确认1:已确认
     *
     * @param checkStatus 确认状态:0:未确认1:已确认
     */
    public void setCheckStatus(String checkStatus) {
        this.checkStatus = checkStatus;
    }

    /**
     * 获取受理时间
     *
     * @return CheckDate - 受理时间
     */
    public Date getCheckDate() {
        return checkDate;
    }

    /**
     * 设置受理时间
     *
     * @param checkDate 受理时间
     */
    public void setCheckDate(Date checkDate) {
        this.checkDate = checkDate;
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