/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.rpt.rptmodel;

import com.icinfo.framework.mybatis.mapper.annotation.Before;
import java.io.Serializable;
import javax.persistence.*;

/**
 * 描述:    sm_count_area_dist 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年06月15日
 */
@Table(name = "sm_count_area_dist")
public class SmCountAreaDist implements Serializable {
    @Id
    @Column(name = "id")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    private Integer id;

    @Column(name = "smArea")
    private String smarea;

    @Column(name = "smCount")
    private Integer smcount;

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
     * @return smArea
     */
    public String getSmarea() {
        return smarea;
    }

    /**
     * @param smarea
     */
    public void setSmarea(String smarea) {
        this.smarea = smarea;
    }

    /**
     * @return smCount
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
}