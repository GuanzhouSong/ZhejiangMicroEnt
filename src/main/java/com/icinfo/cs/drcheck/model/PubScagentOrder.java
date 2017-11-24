/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.drcheck.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * 描述:    cs_pub_scagent_order 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2016年11月21日
 */
@Table(name = "cs_pub_scagent_order")
public class PubScagentOrder implements Serializable {
	
    @Id
    @Column(name = "id")
    private Integer id;

    /**
     * 内部编号当前序号(例如:H01)
     */
    @Column(name = "AgentInnerId")
    private String agentInnerId;

    /**
     * 当前内部序号排列序号
     */
    @Column(name = "OrderBy")
    private Integer orderBy;

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
     * 获取内部编号当前序号(例如:H01)
     *
     * @return AgentInnerId - 内部编号当前序号(例如:H01)
     */
    public String getAgentInnerId() {
        return agentInnerId;
    }

    /**
     * 设置内部编号当前序号(例如:H01)
     *
     * @param agentInnerId 内部编号当前序号(例如:H01)
     */
    public void setAgentInnerId(String agentInnerId) {
        this.agentInnerId = agentInnerId;
    }

    /**
     * 获取当前内部序号排列序号
     *
     * @return OrderBy - 当前内部序号排列序号
     */
    public Integer getOrderBy() {
        return orderBy;
    }

    /**
     * 设置当前内部序号排列序号
     *
     * @param orderBy 当前内部序号排列序号
     */
    public void setOrderBy(Integer orderBy) {
        this.orderBy = orderBy;
    }
}