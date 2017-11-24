/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.base.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * 描述:    cs_common_dic 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2016年11月08日
 */
@Table(name = "cs_common_dic")
public class CommonDic implements Serializable {
    /**
     * 主键id
     */
    @Id
    @Column(name = "id")
    private Integer id;

    /**
     * 字典项
     */
    @Column(name = "DicColumn")
    private String dicColumn;

    /**
     * 字典值
     */
    @Column(name = "DicValue")
    private String dicValue;

    /**
     * 字典说明
     */
    @Column(name = "DicExlain")
    private String dicExlain;

    /**
     * 数据库表名
     */
    @Column(name = "DicTable")
    private String dicTable;

    /**
     * 序号
     */
    @Column(name = "DicOrder")
    private Integer dicOrder;

    /**
     * 备注
     */
    @Column(name = "DicRemark")
    private String dicRemark;

    /**
     * 是否显示1-显示 0-不显示
     */
    @Column(name = "DicFlag")
    private String dicFlag;

    /**
     * 上级id
     */
    @Column(name = "DicPid")
    private Integer dicPid;

    /**
     * 设置人
     */
    @Column(name = "DicSetter")
    private String dicSetter;

    /**
     * 设置时间
     */
    @Column(name = "DicSetDate")
    private Date dicSetDate;

    private static final long serialVersionUID = 1L;

    /**
     * 获取主键id
     *
     * @return id - 主键id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置主键id
     *
     * @param id 主键id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取字典项
     *
     * @return DicColumn - 字典项
     */
    public String getDicColumn() {
        return dicColumn;
    }

    /**
     * 设置字典项
     *
     * @param dicColumn 字典项
     */
    public void setDicColumn(String dicColumn) {
        this.dicColumn = dicColumn;
    }

    /**
     * 获取字典值
     *
     * @return DicValue - 字典值
     */
    public String getDicValue() {
        return dicValue;
    }

    /**
     * 设置字典值
     *
     * @param dicValue 字典值
     */
    public void setDicValue(String dicValue) {
        this.dicValue = dicValue;
    }

    /**
     * 获取字典说明
     *
     * @return DicExlain - 字典说明
     */
    public String getDicExlain() {
        return dicExlain;
    }

    /**
     * 设置字典说明
     *
     * @param dicExlain 字典说明
     */
    public void setDicExlain(String dicExlain) {
        this.dicExlain = dicExlain;
    }

    /**
     * 获取数据库表名
     *
     * @return DicTable - 数据库表名
     */
    public String getDicTable() {
        return dicTable;
    }

    /**
     * 设置数据库表名
     *
     * @param dicTable 数据库表名
     */
    public void setDicTable(String dicTable) {
        this.dicTable = dicTable;
    }

    /**
     * 获取序号
     *
     * @return DicOrder - 序号
     */
    public Integer getDicOrder() {
        return dicOrder;
    }

    /**
     * 设置序号
     *
     * @param dicOrder 序号
     */
    public void setDicOrder(Integer dicOrder) {
        this.dicOrder = dicOrder;
    }

    /**
     * 获取备注
     *
     * @return DicRemark - 备注
     */
    public String getDicRemark() {
        return dicRemark;
    }

    /**
     * 设置备注
     *
     * @param dicRemark 备注
     */
    public void setDicRemark(String dicRemark) {
        this.dicRemark = dicRemark;
    }

    /**
     * 获取是否显示1-显示 0-不显示
     *
     * @return DicFlag - 是否显示1-显示 0-不显示
     */
    public String getDicFlag() {
        return dicFlag;
    }

    /**
     * 设置是否显示1-显示 0-不显示
     *
     * @param dicFlag 是否显示1-显示 0-不显示
     */
    public void setDicFlag(String dicFlag) {
        this.dicFlag = dicFlag;
    }

    /**
     * 获取上级id
     *
     * @return DicPid - 上级id
     */
    public Integer getDicPid() {
        return dicPid;
    }

    /**
     * 设置上级id
     *
     * @param dicPid 上级id
     */
    public void setDicPid(Integer dicPid) {
        this.dicPid = dicPid;
    }

    /**
     * 获取设置人
     *
     * @return DicSetter - 设置人
     */
    public String getDicSetter() {
        return dicSetter;
    }

    /**
     * 设置设置人
     *
     * @param dicSetter 设置人
     */
    public void setDicSetter(String dicSetter) {
        this.dicSetter = dicSetter;
    }

    /**
     * 获取设置时间
     *
     * @return DicSetDate - 设置时间
     */
    public Date getDicSetDate() {
        return dicSetDate;
    }

    /**
     * 设置设置时间
     *
     * @param dicSetDate 设置时间
     */
    public void setDicSetDate(Date dicSetDate) {
        this.dicSetDate = dicSetDate;
    }
}