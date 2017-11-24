/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.drcheck.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 描述:  cs_pub_dept_number 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2016年11月13日
 */
@Table(name = "cs_pub_dept_number")
public class PubDeptNumber implements Serializable {
    /**
     * 主键自增id
     */
    @Id
    @Column(name = "id") 
    private Integer id;

    /**
     * 部门id
     */
    @Column(name = "deptCode")
    private String deptCode;

    /**
     * 部门任务序号(默认值为1)
     */
    @Column(name = "deptNumber")
    private Integer deptNumber;

    /**部门任务年度
     * 
     */
    @Column(name ="year")
    private Integer year;
    
    
    private static final long serialVersionUID = 1L;

    /**
     * 获取主键自增id
     *
     * @return id - 主键自增id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置主键自增id
     *
     * @param id 主键自增id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取部门id
     *
     * @return deptCode - 部门id
     */
    public String getDeptCode() {
        return deptCode;
    }

    /**
     * 设置部门id
     *
     * @param deptCode 部门id
     */
    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    /**
     * 获取部门任务序号(默认值为1)
     *
     * @return deptNumber - 部门任务序号(默认值为1)
     */
    public Integer getDeptNumber() {
        return deptNumber;
    }

    /**
     * 设置部门任务序号(默认值为1)
     *
     * @param deptNumber 部门任务序号(默认值为1)
     */
    public void setDeptNumber(Integer deptNumber) {
        this.deptNumber = deptNumber;
    }

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

 
    
}