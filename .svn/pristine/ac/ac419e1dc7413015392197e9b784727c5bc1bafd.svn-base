/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.rpt.rptmodel;

import com.icinfo.framework.mybatis.mapper.annotation.Before;
import java.io.Serializable;
import javax.persistence.*;

/**
 * 描述:    sm_count_month_route 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年06月15日
 */
@Table(name = "sm_count_month_route")
public class SmCountMonthRoute implements Serializable {
    @Id
    @Column(name = "id")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    private Integer id;

    @Column(name = "SmCount")
    private Integer smcount;

    @Column(name = "SmMonth")
    private String smmonth;

    @Column(name = "SmFlag")
    private String smflag;

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
     * @return SmCount
     */
    public Integer getSmcount() {
        return smcount;
    }

    /**
     * @param smcount
     */
    public void setSmcount(Integer smcount) {
        this.smcount = smcount;
    }

    /**
     * @return SmMonth
     */
    public String getSmmonth() {
        return smmonth;
    }

    /**
     * @param smmonth
     */
    public void setSmmonth(String smmonth) {
        this.smmonth = smmonth;
    }

    /**
     * @return SmFlag
     */
    public String getSmflag() {
        return smflag;
    }

    /**
     * @param smflag
     */
    public void setSmflag(String smflag) {
        this.smflag = smflag;
    }
}