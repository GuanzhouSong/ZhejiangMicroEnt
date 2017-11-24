/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.rpt.rptmodel;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * 描述:    cs_rpt_qcdz_ztqs 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年09月25日
 */
@Table(name = "cs_rpt_qcdz_ztqs")
public class RptQcdzZtQs implements Serializable {

	@Column(name = "monthcode")
    private String monthcode;

    @Column(name = "newcount")
    private Integer newcount;

    @Column(name = "cancount")
    private Integer cancount;

    @Column(name = "update_time")
    private Date updatetime;

    private static final long serialVersionUID = 1L;

    /**
     * @return monthcode
     */
    public String getMonthcode() {
        return monthcode;
    }

    /**
     * @param monthcode
     */
    public void setMonthcode(String monthcode) {
        this.monthcode = monthcode;
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