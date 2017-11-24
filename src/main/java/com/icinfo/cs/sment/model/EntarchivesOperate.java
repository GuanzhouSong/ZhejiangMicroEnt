/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.sment.model;

import com.icinfo.framework.mybatis.mapper.annotation.Before;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

/**
 * 描述:   小微企业培育档案库-经营状况 sm_bus_entarchives_operate 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年04月27日
 */
@Table(name = "sm_bus_entarchives_operate")
public class EntarchivesOperate implements Serializable {
    @Id
    @Column(name = "id")
    @Before
    private Integer id;

    @Column(name = "PriPID")
    private String priPID;

    /**
     * 年份
     */
    @Column(name = "Year")
    private Integer year;

    /**
     * 总收入
     */
    @Column(name = "OpeStateIncome")
    private BigDecimal opeStateIncome;

    /**
     * 利润总额
     */
    @Column(name = "OpeStateProfi")
    private BigDecimal opeStateProfi;

    /**
     * 纳税总额
     */
    @Column(name = "OpeStateTax")
    private BigDecimal opeStateTax;

    /**
     * 备注
     */
    @Column(name = "Remark")
    private String remark;

    /**
     * 时间戳
     */
    @Column(name = "CreateTime")
    private Date createTime;

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
     * @return PriPID
     */
    public String getPriPID() {
        return priPID;
    }

    /**
     * @param priPID
     */
    public void setPriPID(String priPID) {
        this.priPID = priPID;
    }

    /**
     * 获取年份
     *
     * @return Year - 年份
     */
    public Integer getYear() {
        return year;
    }

    /**
     * 设置年份
     *
     * @param year 年份
     */
    public void setYear(Integer year) {
        this.year = year;
    }

    /**
     * 获取总收入
     *
     * @return OpeStateIncome - 总收入
     */
    public BigDecimal getOpeStateIncome() {
        return opeStateIncome;
    }

    /**
     * 设置总收入
     *
     * @param opeStateIncome 总收入
     */
    public void setOpeStateIncome(BigDecimal opeStateIncome) {
        this.opeStateIncome = opeStateIncome;
    }

    /**
     * 获取利润总额
     *
     * @return OpeStateProfi - 利润总额
     */
    public BigDecimal getOpeStateProfi() {
        return opeStateProfi;
    }

    /**
     * 设置利润总额
     *
     * @param opeStateProfi 利润总额
     */
    public void setOpeStateProfi(BigDecimal opeStateProfi) {
        this.opeStateProfi = opeStateProfi;
    }

    /**
     * 获取纳税总额
     *
     * @return OpeStateTax - 纳税总额
     */
    public BigDecimal getOpeStateTax() {
        return opeStateTax;
    }

    /**
     * 设置纳税总额
     *
     * @param opeStateTax 纳税总额
     */
    public void setOpeStateTax(BigDecimal opeStateTax) {
        this.opeStateTax = opeStateTax;
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
     * 获取时间戳
     *
     * @return CreateTime - 时间戳
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置时间戳
     *
     * @param createTime 时间戳
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}