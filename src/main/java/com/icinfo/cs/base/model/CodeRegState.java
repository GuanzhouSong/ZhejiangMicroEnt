/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.base.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 描述:    cs_code_regstate 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年07月26日
 */
@Table(name = "cs_code_regstate")
public class CodeRegState implements Serializable {
    @Id
    @Column(name = "id")
    private Integer id;

    /**
     * 状态编码
     */
    @Column(name = "RegState")
    private String regState;

    /**
     * 原名称状态
     */
    @Column(name = "RegStateDesc")
    private String regStateDesc;

    /**
     * 大监管状态（1-存续，0-其他）
     */
    @Column(name = "CsState")
    private String csState;

    /**
     * 大监管状态描述
     */
    @Column(name = "CsStateDesc")
    private String csStateDesc;

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
     * 获取状态编码
     *
     * @return RegState - 状态编码
     */
    public String getRegState() {
        return regState;
    }

    /**
     * 设置状态编码
     *
     * @param regState 状态编码
     */
    public void setRegState(String regState) {
        this.regState = regState;
    }

    /**
     * 获取原名称状态
     *
     * @return RegStateDesc - 原名称状态
     */
    public String getRegStateDesc() {
        return regStateDesc;
    }

    /**
     * 设置原名称状态
     *
     * @param regStateDesc 原名称状态
     */
    public void setRegStateDesc(String regStateDesc) {
        this.regStateDesc = regStateDesc;
    }

    /**
     * 获取大监管状态（1-存续，0-其他）
     *
     * @return CsState - 大监管状态（1-存续，0-其他）
     */
    public String getCsState() {
        return csState;
    }

    /**
     * 设置大监管状态（1-存续，0-其他）
     *
     * @param csState 大监管状态（1-存续，0-其他）
     */
    public void setCsState(String csState) {
        this.csState = csState;
    }

    /**
     * 获取大监管状态描述
     *
     * @return CsStateDesc - 大监管状态描述
     */
    public String getCsStateDesc() {
        return csStateDesc;
    }

    /**
     * 设置大监管状态描述
     *
     * @param csStateDesc 大监管状态描述
     */
    public void setCsStateDesc(String csStateDesc) {
        this.csStateDesc = csStateDesc;
    }
}