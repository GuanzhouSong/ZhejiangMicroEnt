/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.rpt.rptmodel;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.icinfo.framework.mybatis.mapper.annotation.Before;
import java.io.Serializable;
import javax.persistence.*;

/**
 * 描述:  cs_relation_net_all 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年07月12日
 */
@Table(name = "cs_relation_net_all")
public class RelationNetAll implements Serializable {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "from_id")
    private String from_id;

    @Column(name = "from_name")
    private String from_name;

    @Column(name = "to_id")
    private String to_id;

    @Column(name = "to_name")
    private String to_name;

    @Column(name = "relation_name")
    private String relation_name;

    /**
     * 1:法人，2：自然人
     */
    @Column(name = "to_type")
    private String to_type;

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
     * @return from_id
     */
    public String getFrom_id() {
        return from_id;
    }

    /**
     * @param from_id
     */
    public void setFrom_id(String from_id) {
        this.from_id = from_id;
    }

    /**
     * @return from_name
     */
    public String getFrom_name() {
        return from_name;
    }

    /**
     * @param from_name
     */
    public void setFrom_name(String from_name) {
        this.from_name = from_name;
    }

    /**
     * @return to_id
     */
    public String getTo_id() {
        return to_id;
    }

    /**
     * @param to_id
     */
    public void setTo_id(String to_id) {
        this.to_id = to_id;
    }

    /**
     * @return to_name
     */
    public String getTo_name() {
        return to_name;
    }

    /**
     * @param to_name
     */
    public void setTo_name(String to_name) {
        this.to_name = to_name;
    }

    /**
     * @return relation_name
     */
    public String getRelation_name() {
        return relation_name;
    }

    /**
     * @param relation_name
     */
    public void setRelation_name(String relation_name) {
        this.relation_name = relation_name;
    }

    /**
     * 获取1:法人，2：自然人
     *
     * @return to_type - 1:法人，2：自然人
     */
    public String getTo_type() {
        return to_type;
    }

    /**
     * 设置1:法人，2：自然人
     *
     * @param to_type 1:法人，2：自然人
     */
    public void setTo_type(String to_type) {
        this.to_type = to_type;
    }
}