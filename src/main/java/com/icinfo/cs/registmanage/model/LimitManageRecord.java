/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.registmanage.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.icinfo.framework.mybatis.mapper.annotation.Before;

/**
 * 描述:    cs_limit_managerecord 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年04月10日
 */
@Table(name = "cs_limit_managerecord")
public class LimitManageRecord implements Serializable {
    @Id
    @Column(name = "id")
    private Integer id;

    /**
     * 管理事项
     */
    @Column(name = "Item")
    private String item;

    /**
     * 文号
     */
    @Column(name = "LimitNO")
    private String limitNO;

    /**
     * 对象
     */
    @Column(name = "ClientName")
    private String clientName;

    /**
     * 创建时间
     */
    @Column(name = "CreateTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")  
    private Date createTime;

    /**
     * 经办人
     */
    @Column(name = "Operator")
    private String operator;

    /**
     * 部门
     */
    @Column(name = "Department")
    private String department;

    @Column(name = "UID")
    private String uid;
    /**
     * 本局联系人
     */
    @Column(name = "RemoveLiaName")
    private String removeLiaName;
    /**
     *本局联系电话
     */
    @Column(name = "RemoveLiaTel")
    private String removeLiaTel;
    
    @Column(name = "RemoveUid")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "select replace(uuid(), '-', '')")
    private String removeUid;

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
     * 获取管理事项
     *
     * @return Item - 管理事项
     */
    public String getItem() {
        return item;
    }

    /**
     * 设置管理事项
     *
     * @param item 管理事项
     */
    public void setItem(String item) {
        this.item = item;
    }

    /**
     * 获取文号
     *
     * @return LimitNO - 文号
     */
    public String getLimitNO() {
        return limitNO;
    }

    /**
     * 设置文号
     *
     * @param limitNO 文号
     */
    public void setLimitNO(String limitNO) {
        this.limitNO = limitNO;
    }

    /**
     * 获取对象
     *
     * @return ClientName - 对象
     */
    public String getClientName() {
        return clientName;
    }

    /**
     * 设置对象
     *
     * @param clientName 对象
     */
    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    /**
     * 获取创建时间
     *
     * @return CreateTime - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取经办人
     *
     * @return Operator - 经办人
     */
    public String getOperator() {
        return operator;
    }

    /**
     * 设置经办人
     *
     * @param operator 经办人
     */
    public void setOperator(String operator) {
        this.operator = operator;
    }

    /**
     * 获取部门
     *
     * @return Department - 部门
     */
    public String getDepartment() {
        return department;
    }

    /**
     * 设置部门
     *
     * @param department 部门
     */
    public void setDepartment(String department) {
        this.department = department;
    }

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getRemoveLiaName() {
		return removeLiaName;
	}

	public void setRemoveLiaName(String removeLiaName) {
		this.removeLiaName = removeLiaName;
	}

	public String getRemoveLiaTel() {
		return removeLiaTel;
	}

	public void setRemoveLiaTel(String removeLiaTel) {
		this.removeLiaTel = removeLiaTel;
	}

	public String getRemoveUid() {
		return removeUid;
	}

	public void setRemoveUid(String removeUid) {
		this.removeUid = removeUid;
	}
	
	

}