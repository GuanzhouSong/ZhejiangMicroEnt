/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.drcheck.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.icinfo.framework.mybatis.mapper.annotation.Before;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * 描述:  cs_pub_dept_scitem 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2016年11月01日
 */
@Table(name = "cs_pub_dept_scitem")
public class PubDeptScitem implements Serializable {
    /**
     * 自增长序号
     */
    @Id
    @Column(name = "id")
   private Integer id;

    /**
     * UID
     */
    @Column(name = "UID")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
      private String UID;
    
    /**
     * 部门编码
     */
    @Column(name = "TaskNO")
    private String taskNO;

    /**
     * 部门编码
     */
    @Column(name = "deptCode")
    private String deptCode;

    /**
     * 检查科目类型
     */
    @Column(name = "scType")
    private String scType;

    /**
     * 检查科目名称
     */
    @Column(name = "scName")
    private String scName;

    /**
     * 时间戳
     */
    @Column(name = "CreateTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;

    private static final long serialVersionUID = 1L;

    /**
     * 获取自增长序号
     *
     * @return id - 自增长序号
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置自增长序号
     *
     * @param id 自增长序号
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取UID
     *
     * @return UID - UID
     */
    public String getUID() {
        return UID;
    }

    /**
     * 设置UID
     *
     * @param UID UID
     */
    public void setUID(String UID) {
        this.UID = UID;
    }

    /**
     * 获取部门编码
     *
     * @return deptCode - 部门编码
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
     * 获取检查科目类型
     *
     * @return scType - 检查科目类型
     */
    public String getScType() {
        return scType;
    }

    /**
     * 设置检查科目类型
     *
     * @param scType 检查科目类型
     */
    public void setScType(String scType) {
        this.scType = scType;
    }

    /**
     * 获取检查科目名称
     *
     * @return scName - 检查科目名称
     */
    public String getScName() {
        return scName;
    }

    /**
     * 设置检查科目名称
     *
     * @param scName 检查科目名称
     */
    public void setScName(String scName) {
        this.scName = scName;
    }

    /**
     * 获取时间戳
     *
     * @return creatTime - 时间戳
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置时间戳
     *
     * @param creatTime 时间戳
     */
    public void setCreateTime(Date creatTime) {
        this.createTime = creatTime;
    }

	public String getTaskNO() {
		return taskNO;
	}

	public void setTaskNO(String taskNO) {
		this.taskNO = taskNO;
	}
}