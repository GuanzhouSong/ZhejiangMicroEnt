/*
 *  Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
 */
package com.icinfo.cs.system.dto;

import java.io.Serializable;

import javax.persistence.Column;

/**
 * 描述:  .<br>
 *
 * @author xiajunwei
 * @date 2016年05月09日
 */
public class PermisionTreeNode implements Serializable {
    private static final long serialVersionUID = -4238023960294120354L;

    /**
     * 主键
     */
    private String id;

    /**
     * 父ID
     */
    private String pId;

    /**
     * 名称
     */
    private String name;

    /**
     * 状态
     */
    private boolean open = false;
    
    /**
     * 编码值
     */
    private String code;
    
    /**
     * 部门序号
     */
    private String deptId;

    /**
     * 是否可选
     */
    private String nocheck;

    public String getNocheck() {
        return nocheck;
    }

    public void setNocheck(String nocheck) {
        this.nocheck = nocheck;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
}
