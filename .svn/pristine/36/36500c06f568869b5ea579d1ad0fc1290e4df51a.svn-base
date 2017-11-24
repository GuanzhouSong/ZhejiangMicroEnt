/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.other.model;

import com.icinfo.framework.mybatis.mapper.annotation.Before;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * 描述:    cs_mort_guarantee_info 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2016年10月26日
 */
@Table(name = "cs_mort_guarantee_info")
public class MortGuaranteeInfo implements Serializable {
    /**
     * 自增ID
     */
    @Id
    @Column(name = "id")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    private Integer id;

    /**
     * 订单号
     */
    @Column(name = "OrderNO")
    private String orderNO;

    /**
     * 抵押物名称
     */
    @Column(name = "GuaName")
    private String guaName;

    /**
     * 所有权归属
     */
    @Column(name = "Own")
    private String own;

    /**
     * 备注
     */
    @Column(name = "Remark")
    private String remark;

    /**
     * 抵押物概况：数量，所在地，质量状况等
     */
    @Column(name = "GuaDes")
    private String guaDes;

    @Column(name = "CreateTime")
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
     * 获取订单号
     *
     * @return OrderNO - 订单号
     */
    public String getOrderNO() {
        return orderNO;
    }

    /**
     * 设置订单号
     *
     * @param orderNO 订单号
     */
    public void setOrderNO(String orderNO) {
        this.orderNO = orderNO;
    }

    /**
     * 获取抵押物名称
     *
     * @return GuaName - 抵押物名称
     */
    public String getGuaName() {
        return guaName;
    }

    /**
     * 设置抵押物名称
     *
     * @param guaName 抵押物名称
     */
    public void setGuaName(String guaName) {
        this.guaName = guaName;
    }

    /**
     * 获取所有权归属
     *
     * @return Own - 所有权归属
     */
    public String getOwn() {
        return own;
    }

    /**
     * 设置所有权归属
     *
     * @param own 所有权归属
     */
    public void setOwn(String own) {
        this.own = own;
    }

    /**
     * 获取备注
     *
     * @return Remark - 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注
     *
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * 获取抵押物概况：数量，所在地，质量状况等
     *
     * @return GuaDes - 抵押物概况：数量，所在地，质量状况等
     */
    public String getGuaDes() {
        return guaDes;
    }

    /**
     * 设置抵押物概况：数量，所在地，质量状况等
     *
     * @param guaDes 抵押物概况：数量，所在地，质量状况等
     */
    public void setGuaDes(String guaDes) {
        this.guaDes = guaDes;
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