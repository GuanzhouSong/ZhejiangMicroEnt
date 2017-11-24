/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.copysend.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.icinfo.framework.mybatis.mapper.annotation.Before;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * 描述:    cs_copy_send_illegal_items 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2016年11月01日
 */
@Table(name = "cs_copy_send_illegal_items")
public class CopySendIllegalItems implements Serializable {
    @Id
    @Column(name = "id")
    private Integer id;

    /**
     * UID
     */
    @Column(name = "UID")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    private String uid;

    /**
     * 单位
     */
    @Column(name = "UnitCode")
    private String unitCode;
    
    /**
     * 单位层级
     */
    @Column(name = "UnitLevel")
    private String unitLevel;
    
    /**
     * 部门编码
     */
    @Column(name = "DeptCode")
    private String deptCode;

    /**
     * 违法事项
     */
    @Column(name = "IllegalItems")
    private String illegalItems;
    
    /**
     * 设置人
     */
    @Column(name = "SetUserName")
    private String setUserName;
    
    /**
     * 设置日期
     */
    @Column(name = "SetTime")
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date setTime;
    

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
     * 获取UID
     *
     * @return UID - UID
     */
    public String getUid() {
        return uid;
    }

    /**
     * 设置UID
     *
     * @param UID UID
     */
    public void setUid(String uid) {
        this.uid = uid;
    }

    /**
     * 获取部门编码
     *
     * @return DeptCode - 部门编码
     */
    public String getDeptCode() {
        return deptCode;
    }

    /**
     * 设置部门编码
     *
     * @param deptCode 部门编码
     */
    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    /**
     * 获取违法事项
     *
     * @return IllegalItems - 违法事项
     */
    public String getIllegalItems() {
        return illegalItems;
    }

    /**
     * 设置违法事项
     *
     * @param illegalItems 违法事项
     */
    public void setIllegalItems(String illegalItems) {
        this.illegalItems = illegalItems;
    }

	public String getUnitCode() {
		return unitCode;
	}

	public void setUnitCode(String unitCode) {
		this.unitCode = unitCode;
	}

	public String getUnitLevel() {
		return unitLevel;
	}

	public void setUnitLevel(String unitLevel) {
		this.unitLevel = unitLevel;
	}

	public String getSetUserName() {
		return setUserName;
	}

	public void setSetUserName(String setUserName) {
		this.setUserName = setUserName;
	}

	public Date getSetTime() {
		return setTime;
	}

	public void setSetTime(Date setTime) {
		this.setTime = setTime;
	}
    
}