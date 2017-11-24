/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.depsyn.model;

import com.icinfo.framework.mybatis.mapper.annotation.Before;
import java.io.Serializable;
import javax.persistence.*;

/**
 * 描述:    cs_depsyn_manage_num 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2016年12月13日
 */
@Table(name = "cs_depsyn_manage_num")
public class CsDepsynManageNum implements Serializable {
    @Id
    @Column(name = "id")
    @Before
    private Integer id;

    /**
     * UUID
     */
    @Column(name = "UID")
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    private String uid;

    /**
     * 信息类型
     */
    @Column(name = "MsgType")
    private String msgType;

    /**
     * 实际处理条数
     */
    @Column(name = "ManageNum")
    private Integer manageNum;

    /**
     * 部门
     */
    @Column(name = "Dept")
    private String dept;

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


    public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	/**
     * 获取信息类型
     *
     * @return MsgType - 信息类型
     */
    public String getMsgType() {
        return msgType;
    }

    /**
     * 设置信息类型
     *
     * @param msgType 信息类型
     */
    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }


    public Integer getManageNum() {
		return manageNum;
	}

	public void setManageNum(Integer manageNum) {
		this.manageNum = manageNum;
	}

	/**
     * 获取部门
     *
     * @return Dept - 部门
     */
    public String getDept() {
        return dept;
    }

    /**
     * 设置部门
     *
     * @param dept 部门
     */
    public void setDept(String dept) {
        this.dept = dept;
    }
}