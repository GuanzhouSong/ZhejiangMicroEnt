/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.rpt.rptmodel;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

/**
 * 描述:    cs_rpt_qcdz_yearcount 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年09月25日
 */
@Table(name = "cs_rpt_qcdz_yearcount")
public class RptQcdzYearCount implements Serializable {
    @Id
    @Column(name = "year")
    private Integer year;

    /**
     * allcount = newcount + cancount
     */
    @Column(name = "Allcount")
    private Integer allcount;

    @Column(name = "newcount")
    private Integer newcount;

    @Column(name = "cancount")
    private Integer cancount;

    @Column(name = "addcount")
    private Integer addcount;

    @Column(name = "addrate")
    private BigDecimal addrate;

    /**
     * 1:展示，2：不展示
     */
    @Column(name = "isshow")
    private String isshow;

    @Column(name = "update_time")
    private Date updatetime;

    private static final long serialVersionUID = 1L;

    /**
     * @return year
     */
    public Integer getYear() {
        return year;
    }

    /**
     * @param year
     */
    public void setYear(Integer year) {
        this.year = year;
    }

    /**
     * 获取allcount = newcount + cancount
     *
     * @return Allcount - allcount = newcount + cancount
     */
    public Integer getAllcount() {
        return allcount;
    }

    /**
     * 设置allcount = newcount + cancount
     *
     * @param allcount allcount = newcount + cancount
     */
    public void setAllcount(Integer allcount) {
        this.allcount = allcount;
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
     * @return addcount
     */
    public Integer getAddcount() {
        return addcount;
    }

    /**
     * @param addcount
     */
    public void setAddcount(Integer addcount) {
        this.addcount = addcount;
    }

    /**
     * @return addrate
     */
    public BigDecimal getAddrate() {
        return addrate;
    }

    /**
     * @param addrate
     */
    public void setAddrate(BigDecimal addrate) {
        this.addrate = addrate;
    }

    /**
     * 获取1:展示，2：不展示
     *
     * @return isshow - 1:展示，2：不展示
     */
    public String getIsshow() {
        return isshow;
    }

    /**
     * 设置1:展示，2：不展示
     *
     * @param isshow 1:展示，2：不展示
     */
    public void setIsshow(String isshow) {
        this.isshow = isshow;
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