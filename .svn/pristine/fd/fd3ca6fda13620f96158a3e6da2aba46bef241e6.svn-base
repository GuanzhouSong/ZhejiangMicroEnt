/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.rpt.rptmodel;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * 描述:    cs_rpt_qcdz_today 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年09月25日
 */
@Table(name = "cs_rpt_qcdz_today")
public class RptQcdzToday implements Serializable {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "daycode")
    private Date daycode;

    @Column(name = "newcount")
    private Integer newcount;

    @Column(name = "cancount")
    private Integer cancount;

    /**
     * 1:企业农专个体 2:各地市
     */
    @Column(name = "type")
    private String type;

    /**
     * 名称（企业类型名称\各地市名称）
     */
    @Column(name = "name")
    private String name;

    /**
     * 排序规则
     */
    @Column(name = "orderid")
    private Integer orderid;

    @Column(name = "update_time")
    private Date updatetime;

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
     * @return daycode
     */
    public Date getDaycode() {
        return daycode;
    }

    /**
     * @param daycode
     */
    public void setDaycode(Date daycode) {
        this.daycode = daycode;
    }

    /**
     * @return newcount
     */
    public Integer getNewcount() {
        return newcount;
    }

    /**
     * @param newcount
     */
    public void setNewcount(Integer newcount) {
        this.newcount = newcount;
    }

    /**
     * @return cancount
     */
    public Integer getCancount() {
        return cancount;
    }

    /**
     * @param cancount
     */
    public void setCancount(Integer cancount) {
        this.cancount = cancount;
    }

    /**
     * 获取1:企业农专个体 2:各地市
     *
     * @return type - 1:企业农专个体 2:各地市
     */
    public String getType() {
        return type;
    }

    /**
     * 设置1:企业农专个体 2:各地市
     *
     * @param type 1:企业农专个体 2:各地市
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 获取名称（企业类型名称\各地市名称）
     *
     * @return name - 名称（企业类型名称\各地市名称）
     */
    public String getName() {
        return name;
    }

    /**
     * 设置名称（企业类型名称\各地市名称）
     *
     * @param name 名称（企业类型名称\各地市名称）
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取排序规则
     *
     * @return orderid - 排序规则
     */
    public Integer getOrderid() {
        return orderid;
    }

    /**
     * 设置排序规则
     *
     * @param orderid 排序规则
     */
    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    /**
     * @return update_time
     */
    public Date getUpdatetime() {
        return updatetime;
    }

    /**
     * @param update_time
     */
    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }
}