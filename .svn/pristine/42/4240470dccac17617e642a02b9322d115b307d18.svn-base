/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.creditprove.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.icinfo.framework.mybatis.mapper.annotation.Before;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * 描述:    cs_credit_prove_print_his 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年04月05日
 */
@Table(name = "cs_credit_prove_print")
public class CreditProvePrintHis implements Serializable {
    /**
     * 自增主键
     */
    @Id
    @Column(name = "id")
    private Integer id;

    /**
     * 主键UID
     */
    @Column(name = "UID")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    private String uid;

    /**
     * 出证单编号
     */
    @Column(name = "PrintNo")
    private String printNo;
    
    /**
     * 出证单编号
     */
    @Column(name = "ProveNo")
    private String proveNo;

    /**
     * 打印时间
     */
    @Column(name = "PrintTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date printTime;

    /**
     * 打印人姓名
     */
    @Column(name = "PrintName")
    private String printName;

    /**
     * 打印人部门名称
     */
    @Column(name = "PrintDeptName")
    private String printDeptName;

    /**
     * 时间戳
     */
    @Column(name = "CreateTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;

    private static final long serialVersionUID = 1L;

    /**
     * 获取自增主键
     *
     * @return id - 自增主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置自增主键
     *
     * @param id 自增主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取主键UID
     *
     * @return UID - 主键UID
     */
    public String getUID() {
        return uid;
    }

    /**
     * 设置主键UID
     *
     * @param UID 主键UID
     */
    public void setUID(String uid) {
        this.uid = uid;
    }
    

    public String getPrintNo() {
		return printNo;
	}

	public void setPrintNo(String printNo) {
		this.printNo = printNo;
	}

	/**
     * 获取出证单编号
     *
     * @return ProveNo - 出证单编号
     */
    public String getProveNo() {
        return proveNo;
    }

    /**
     * 设置出证单编号
     *
     * @param proveNo 出证单编号
     */
    public void setProveNo(String proveNo) {
        this.proveNo = proveNo;
    }

    /**
     * 获取打印时间
     *
     * @return PrintTime - 打印时间
     */
    public Date getPrintTime() {
        return printTime;
    }

    /**
     * 设置打印时间
     *
     * @param printTime 打印时间
     */
    public void setPrintTime(Date printTime) {
        this.printTime = printTime;
    }

    /**
     * 获取打印人姓名
     *
     * @return PrintName - 打印人姓名
     */
    public String getPrintName() {
        return printName;
    }

    /**
     * 设置打印人姓名
     *
     * @param printName 打印人姓名
     */
    public void setPrintName(String printName) {
        this.printName = printName;
    }

    /**
     * 获取打印人部门名称
     *
     * @return PrintDeptName - 打印人部门名称
     */
    public String getPrintDeptName() {
        return printDeptName;
    }

    /**
     * 设置打印人部门名称
     *
     * @param printDeptName 打印人部门名称
     */
    public void setPrintDeptName(String printDeptName) {
        this.printDeptName = printDeptName;
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