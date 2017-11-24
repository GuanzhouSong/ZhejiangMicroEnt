/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.rpt.rptmodel;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

/**
 * 描述:    cs_rpt_qcdz_invcount 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年09月25日
 */
@Table(name = "cs_rpt_qcdz_invcount")
public class RptQcdzInvcount implements Serializable {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "allcount")
    private Integer allcount;

    @Column(name = "entcount")
    private Integer entcount;

    @Column(name = "percount")
    private Integer percount;

    /**
     * 法人类型股东占比
     */
    @Column(name = "entrate")
    private BigDecimal entrate;

    /**
     * 自然人股东占比
     */
    @Column(name = "perrate")
    private BigDecimal perrate;

    /**
     * 1:整体情况 2：各地市情况
     */
    @Column(name = "type")
    private String type;

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
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return allcount
     */
    public Integer getAllcount() {
        return allcount;
    }

    /**
     * @param allcount
     */
    public void setAllcount(Integer allcount) {
        this.allcount = allcount;
    }

    /**
     * @return entcount
     */
    public Integer getEntcount() {
        return entcount;
    }

    /**
     * @param entcount
     */
    public void setEntcount(Integer entcount) {
        this.entcount = entcount;
    }

    /**
     * @return percount
     */
    public Integer getPercount() {
        return percount;
    }

    /**
     * @param percount
     */
    public void setPercount(Integer percount) {
        this.percount = percount;
    }

    /**
     * 获取法人类型股东占比
     *
     * @return entrate - 法人类型股东占比
     */
    public BigDecimal getEntrate() {
        return entrate;
    }

    /**
     * 设置法人类型股东占比
     *
     * @param entrate 法人类型股东占比
     */
    public void setEntrate(BigDecimal entrate) {
        this.entrate = entrate;
    }

    /**
     * 获取自然人股东占比
     *
     * @return perrate - 自然人股东占比
     */
    public BigDecimal getPerrate() {
        return perrate;
    }

    /**
     * 设置自然人股东占比
     *
     * @param perrate 自然人股东占比
     */
    public void setPerrate(BigDecimal perrate) {
        this.perrate = perrate;
    }

    /**
     * 获取1:整体情况 2：各地市情况
     *
     * @return type - 1:整体情况 2：各地市情况
     */
    public String getType() {
        return type;
    }

    /**
     * 设置1:整体情况 2：各地市情况
     *
     * @param type 1:整体情况 2：各地市情况
     */
    public void setType(String type) {
        this.type = type;
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
    public void setUpdate_time(Date updatetime) {
        this.updatetime = updatetime;
    }
}