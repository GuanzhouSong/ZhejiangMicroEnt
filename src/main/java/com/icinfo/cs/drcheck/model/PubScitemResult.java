/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.drcheck.model;

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
 * 描述:  cs_pub_scitem_result 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2016年10月26日
 */
@Table(name = "cs_pub_scitem_result")
public class PubScitemResult implements Serializable {
    /**
     * 自增序号
     */
    @Id
    @Column(name = "id")
    private Integer id;
    
    /**
     * 唯一标识
     */
    @Column(name = "UID")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    private String UID;

    /**
     * 序号：任务表UUID
     */
    @Column(name = "TaskNO")
    private String taskNO;
    
    /**
     * 主体身份代码
     */
    @Column(name = "PriPID")
    private String priPID;
    
    /**
     * 检查项类型 1:常规检查，2：重点检查，3：自定义检查
     */
    @Column(name = "ScType")
    private String scType;
    
    /**
     * 检查项类型描述
     */
    @Column(name = "ScName")
    private String scName;

    /**
     * 检查项编码
     */
    @Column(name = "ItemCode")
    private String itemCode;

    /**
     * 检查项名称
     */
    @Column(name = "ItemName")
    private String itemName;

    /**
     * 检查项内容
     */
    @Column(name = "ItemContent")
    private String itemContent;

    /**
     * 检查结果
     */
    @Column(name = "ScResult")
    private String scResult;
    
    /**
     * 是否相同
     */
    @Column(name = "SameFlag")
    private String sameFlag;
    
    /**
     * 是否公示
     */
    @Column(name = "PubFlag")
    private String pubFlag;

    /**
     * 设置人ID
     */
    @Column(name = "SetUserId")
    private String setUserId;

    /**
     * 设置人
     */
    @Column(name = "SetUserName")
    private String setUserName;

    /**
     * 设置日期
     */
    @Column(name = "SetTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date setTime;

    /**
     * 设置部门编码
     */
    @Column(name = "SetDeptCode")
    private String setDeptCode;

    /**
     * 时间戳
     */
    @Column(name = "CreateTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;

    private static final long serialVersionUID = 1L;

    /**
     * 获取自增序号
     *
     * @return id - 自增序号
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置自增序号
     *
     * @param id 自增序号
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取序号：任务表UUID
     *
     * @return TaskNO - 序号：任务表UUID
     */
    public String getTaskNO() {
        return taskNO;
    }

    /**
     * 设置序号：任务表UUID
     *
     * @param taskNO 序号：任务表UUID
     */
    public void setTaskNO(String taskNO) {
        this.taskNO = taskNO;
    }

    /**
     * 获取检查项类型 1:常规检查，2：重点检查，3：自定义检查
     *
     * @return ScType - 检查项类型 1:常规检查，2：重点检查，3：自定义检查
     */
    public String getScType() {
        return scType;
    }

    /**
     * 设置检查项类型 1:常规检查，2：重点检查，3：自定义检查
     *
     * @param scType 检查项类型 1:常规检查，2：重点检查，3：自定义检查
     */
    public void setScType(String scType) {
        this.scType = scType;
    }

    /**
     * 获取检查项编码
     *
     * @return ItemCode - 检查项编码
     */
    public String getItemCode() {
        return itemCode;
    }

    /**
     * 设置检查项编码
     *
     * @param itemCode 检查项编码
     */
    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    /**
     * 获取检查项名称
     *
     * @return ItemName - 检查项名称
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * 设置检查项名称
     *
     * @param itemName 检查项名称
     */
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    /**
     * 获取检查项内容
     *
     * @return ItemContent - 检查项内容
     */
    public String getItemContent() {
        return itemContent;
    }

    /**
     * 设置检查项内容
     *
     * @param itemContent 检查项内容
     */
    public void setItemContent(String itemContent) {
        this.itemContent = itemContent;
    }

    /**
     * 获取检查结果
     *
     * @return ScResult - 检查结果
     */
    public String getScResult() {
        return scResult;
    }

    /**
     * 设置检查结果
     *
     * @param scResult 检查结果
     */
    public void setScResult(String scResult) {
        this.scResult = scResult;
    }

    /**
     * 获取设置人ID
     *
     * @return SetUserId - 设置人ID
     */
    public String getSetUserId() {
        return setUserId;
    }

    /**
     * 设置设置人ID
     *
     * @param setUserId 设置人ID
     */
    public void setSetUserId(String setUserId) {
        this.setUserId = setUserId;
    }

    /**
     * 获取设置人
     *
     * @return SetUserName - 设置人
     */
    public String getSetUserName() {
        return setUserName;
    }

    /**
     * 设置设置人
     *
     * @param setUserName 设置人
     */
    public void setSetUserName(String setUserName) {
        this.setUserName = setUserName;
    }

    /**
     * 获取设置日期
     *
     * @return SetTime - 设置日期
     */
    public Date getSetTime() {
        return setTime;
    }

    /**
     * 设置设置日期
     *
     * @param setTime 设置日期
     */
    public void setSetTime(Date setTime) {
        this.setTime = setTime;
    }

    /**
     * 获取设置部门编码
     *
     * @return SetDeptCode - 设置部门编码
     */
    public String getSetDeptCode() {
        return setDeptCode;
    }

    /**
     * 设置设置部门编码
     *
     * @param setDeptCode 设置部门编码
     */
    public void setSetDeptCode(String setDeptCode) {
        this.setDeptCode = setDeptCode;
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

	public String getPriPID() {
		return priPID;
	}

	public void setPriPID(String priPID) {
		this.priPID = priPID;
	}

	public String getSameFlag() {
		return sameFlag;
	}

	public void setSameFlag(String sameFlag) {
		this.sameFlag = sameFlag;
	}

	public String getPubFlag() {
		return pubFlag;
	}

	public void setPubFlag(String pubFlag) {
		this.pubFlag = pubFlag;
	}

	public String getUID() {
		return UID;
	}

	public void setUID(String uID) {
		UID = uID;
	}

	public String getScName() {
		return scName;
	}

	public void setScName(String scName) {
		this.scName = scName;
	}
    
}