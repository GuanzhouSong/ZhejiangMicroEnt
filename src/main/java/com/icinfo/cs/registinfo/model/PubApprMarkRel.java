/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.registinfo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 描述:    cs_pub_appr_mark_rel 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年04月26日
 */
@Table(name = "cs_pub_appr_mark_rel")
public class PubApprMarkRel implements Serializable {
    /**
     * 主键ID
     */
    @Id
    @Column(name = "ID")
    private Integer ID;

    /**
     * 主体身份代码(CA14)
     */
    @Column(name = "PriPID")
    private String priPID;

    /**
     * 标签code
     */
    @Column(name = "MarkCode")
    private String markCode;

    /**
     * 标签名称
     */
    @Column(name = "MarkName")
    private String markName;

    private static final long serialVersionUID = 1L;

    /**
     * 获取主键ID
     *
     * @return ID - 主键ID
     */
    public Integer getID() {
        return ID;
    }

    /**
     * 设置主键ID
     *
     * @param ID 主键ID
     */
    public void setID(Integer ID) {
        this.ID = ID;
    }

    /**
     * 获取主体身份代码(CA14)
     *
     * @return PriPID - 主体身份代码(CA14)
     */
    public String getPriPID() {
        return priPID;
    }

    /**
     * 设置主体身份代码(CA14)
     *
     * @param priPID 主体身份代码(CA14)
     */
    public void setPriPID(String priPID) {
        this.priPID = priPID;
    }

    /**
     * 获取标签code
     *
     * @return MarkCode - 标签code
     */
    public String getMarkCode() {
        return markCode;
    }

    /**
     * 设置标签code
     *
     * @param markCode 标签code
     */
    public void setMarkCode(String markCode) {
        this.markCode = markCode;
    }

    /**
     * 获取标签名称
     *
     * @return MarkName - 标签名称
     */
    public String getMarkName() {
        return markName;
    }

    /**
     * 设置标签名称
     *
     * @param markName 标签名称
     */
    public void setMarkName(String markName) {
        this.markName = markName;
    }
}