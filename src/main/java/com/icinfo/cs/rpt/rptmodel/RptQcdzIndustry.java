/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.rpt.rptmodel;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

/**
 * 描述:    cs_rpt_qcdz_industry 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年09月27日
 */
@Table(name = "cs_rpt_qcdz_industry")
public class RptQcdzIndustry implements Serializable {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "hydm")
    private String hydm;

    @Column(name = "hymc")
    private String hymc;

    @Column(name = "hyrate")
    private BigDecimal hyrate;

    /**
     * 1:法人 2：自然人
     */
    @Column(name = "invtype")
    private String invtype;

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
     * @return hydm
     */
    public String getHydm() {
        return hydm;
    }

    /**
     * @param hydm
     */
    public void setHydm(String hydm) {
        this.hydm = hydm;
    }

    /**
     * @return hymc
     */
    public String getHymc() {
        return hymc;
    }

    /**
     * @param hymc
     */
    public void setHymc(String hymc) {
        this.hymc = hymc;
    }

    /**
     * @return hyrate
     */
    public BigDecimal getHyrate() {
        return hyrate;
    }

    /**
     * @param hyrate
     */
    public void setHyrate(BigDecimal hyrate) {
        this.hyrate = hyrate;
    }

    /**
     * 获取1:法人 2：自然人
     *
     * @return invtype - 1:法人 2：自然人
     */
    public String getInvtype() {
        return invtype;
    }

    /**
     * 设置1:法人 2：自然人
     *
     * @param invtype 1:法人 2：自然人
     */
    public void setInvtype(String invtype) {
        this.invtype = invtype;
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