/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.drcheck.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.icinfo.framework.mybatis.mapper.annotation.Before;

/**
 * 描述:  cs_pub_code_sctype 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2016年11月08日
 */
@Table(name = "cs_pub_code_sctype")
public class PubCodeSctype implements Serializable {
    @Id
    @Column(name = "id")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    private Integer id;

    /**
     * 科目类型编码
     */
    @Column(name = "ScType")
    private String scType;
    
    /**
     * 部门编码
     */
    @Column(name = "DeptCode")
    private String deptCode;

    /**
     * 科目类型描述
     */
    @Column(name = "ScName")
    private String scName;

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
     * 获取科目类型编码
     *
     * @return ScType - 科目类型编码
     */
    public String getScType() {
        return scType;
    }

    /**
     * 设置科目类型编码
     *
     * @param scType 科目类型编码
     */
    public void setScType(String scType) {
        this.scType = scType;
    }

    /**
     * 获取科目类型描述
     *
     * @return ScName - 科目类型描述
     */
    public String getScName() {
        return scName;
    }

    /**
     * 设置科目类型描述
     *
     * @param scName 科目类型描述
     */
    public void setScName(String scName) {
        this.scName = scName;
    }

	public String getDeptCode() {
		return deptCode;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}
}