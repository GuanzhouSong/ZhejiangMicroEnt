package com.icinfo.cs.sment.model;

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
 * 描述:   小微企业通知公告sm_bullentins 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年05月03日
 */
@Table(name = "sm_bulletins")
public class SmentBulletins implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @Column(name = "id")
    private Integer id;

    /**
     * uuid
     */
	@Column(name = "UID")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    private String UID;
    
    /**
     * 标题
     */
    @Column(name = "Title")
    private String title;
    
    /**
     * 创建时间
     */
    @Column(name = "CreateTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date  createTime ;
    /**
     * 来源
     */
    @Column(name = "Source")
    private  String source;
    
    /**
     * 发布范围
     */
    @Column(name = "BulScope")
    private String bulScope ;
    
    /**
     * 发布人所在局
     */
    @Column(name = "SetDeptname")
    private String setDeptname ;
    
    /**
     * 公告类型3-面向工商1-面向企业5-面向工商与企业 
     */
    @Column(name = "BulType")
    private String bulType;
    
    /**
     * 公告内容
     */
    @Column(name = "Contents")
    private String contents;
    
    /**
     * 发布时间
     */
    @Column(name = "SetTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date setTime;
    
    /**
     * 发布人
     */
    @Column(name = "SetName")
    private String setName;
    
    /**
     * 发布人ID
     */
    @Column(name = "SetId")
    private String setId;
    
    /**
     * 是否有效
     */
    @Column(name = "IsValid")
    private String isValid;
    
    /**
     * 发布人所在部门编码
     */
    @Column(name = "SetDeptCode")
    private String setDeptCode;
    
    /**
     * 发布人所在部门编码
     */
    @Column(name = "ReadCount")
    private Integer readCount;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUID() {
		return UID;
	}

	public void setUID(String uID) {
		UID = uID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getBulScope() {
		return bulScope;
	}

	public void setBulScope(String bulScope) {
		this.bulScope = bulScope;
	}

	public String getSetDeptname() {
		return setDeptname;
	}

	public void setSetDeptname(String setDeptname) {
		this.setDeptname = setDeptname;
	}

	public String getBulType() {
		return bulType;
	}

	public void setBulType(String bulType) {
		this.bulType = bulType;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public Date getSetTime() {
		return setTime;
	}

	public void setSetTime(Date setTime) {
		this.setTime = setTime;
	}

	public String getSetName() {
		return setName;
	}

	public void setSetName(String setName) {
		this.setName = setName;
	}

	public String getSetId() {
		return setId;
	}

	public void setSetId(String setId) {
		this.setId = setId;
	}

	public String getIsValid() {
		return isValid;
	}

	public void setIsValid(String isValid) {
		this.isValid = isValid;
	}

	public String getSetDeptCode() {
		return setDeptCode;
	}

	public void setSetDeptCode(String setDeptCode) {
		this.setDeptCode = setDeptCode;
	}

	public Integer getReadCount() {
		return readCount;
	}

	public void setReadCount(Integer readCount) {
		this.readCount = readCount;
	}
    
}
