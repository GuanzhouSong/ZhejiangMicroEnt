/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.yr.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.icinfo.framework.mybatis.mapper.annotation.Before;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * 描述:    cs_bulletins 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2016年09月19日
 */
@Table(name = "cs_bulletins")
public class Bulletins implements Serializable {
	
    @Id
    @Column(name = "id")
    private Integer id;

    //标题
    @Column(name = "Title")
    private String title;

    @Column(name = "CreateTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8") 
    private Date createTime;

    @Column(name = "UID")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    private String UID;

    //来源
    @Column(name = "Source")
    private String source;

    //发布范围(1- 全市  2-本局)
    @Column(name = "BulScope")
    private String bulScope;
    //发布人所在局
    @Column(name = "SetDeptname")
    private String setDeptname;

    //公告类型 (3- 面向工商   1-面向企业   5-面向工商和企业)
    @Column(name = "BulType")
    private String bulType;

    //发布时间
    @Column(name = "SetTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8") 
    private Date setTime;

    //发布人
    @Column(name = "SetName")
    private String setName;

    //发布人id
    @Column(name = "SetId")
    private String setId;
    //是否有效
    @Column(name = "IsValid")
    private String isValid;
    //公告内容
    @Column(name = "contents")
    private String contents;
   
    //系统类别：1 警示  2 协同
    @Column(name = "SystemType")
    private String systemType;
    
    //发布人所在部门编码(协同显示AdCode)
    @Column(name = "SetDeptCode")
    private String setDeptCode;
    
    //阅读量
    @Column(name = "ReadCount")
    private Integer readCount;
    
    //修改时间
    @Column(name = "ModTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8") 
    private Date modTime;
    //附件
    @Column(name = "BulData")
    private String bulData;

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
     * @return Title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return CreateTime
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return UID
     */
    public String getUID() {
        return UID;
    }

    /**
     * @param UID
     */
    public void setUID(String UID) {
        this.UID = UID;
    }

    /**
     * @return Source
     */
    public String getSource() {
        return source;
    }

    /**
     * @param source
     */
    public void setSource(String source) {
        this.source = source;
    }

    /**
     * @return BulScope
     */
    public String getBulScope() {
        return bulScope;
    }

    /**
     * @param bulScope
     */
    public void setBulScope(String bulScope) {
        this.bulScope = bulScope;
    }

    /**
     * @return SetDeptname
     */
    public String getSetDeptname() {
        return setDeptname;
    }

    /**
     * @param setDeptname
     */
    public void setSetDeptname(String setDeptname) {
        this.setDeptname = setDeptname;
    }

    /**
     * @return BulType
     */
    public String getBulType() {
        return bulType;
    }

    /**
     * @param bulType
     */
    public void setBulType(String bulType) {
        this.bulType = bulType;
    }

    /**
     * @return SetTime
     */
    public Date getSetTime() {
        return setTime;
    }

    /**
     * @param setTime
     */
    public void setSetTime(Date setTime) {
        this.setTime = setTime;
    }

    /**
     * @return SetName
     */
    public String getSetName() {
        return setName;
    }

    /**
     * @param setName
     */
    public void setSetName(String setName) {
        this.setName = setName;
    }

    /**
     * @return SetId
     */
    public String getSetId() {
        return setId;
    }

    /**
     * @param setId
     */
    public void setSetId(String setId) {
        this.setId = setId;
    }

    /**
     * @return IsValid
     */
    public String getIsValid() {
        return isValid;
    }

    /**
     * @param isValid
     */
    public void setIsValid(String isValid) {
        this.isValid = isValid;
    }

    /**
     * @return contents
     */
    public String getContents() {
        return contents;
    }

    /**
     * @param contents
     */
    public void setContents(String contents) {
        this.contents = contents;
    }
    
    public void setSystemType(String systemType) {
		this.systemType = systemType;
	}
    
    public String getSystemType() {
		return systemType;
	}
    
    public void setSetDeptCode(String setDeptCode) {
		this.setDeptCode = setDeptCode;
	}
    
    public String getSetDeptCode() {
		return setDeptCode;
	}
    
    
    public void setReadCount(Integer readCount) {
		this.readCount = readCount;
	}
    
    public Integer getReadCount() {
		return readCount;
	}

	public Date getModTime() {
		return modTime;
	}

	public void setModTime(Date modTime) {
		this.modTime = modTime;
	}

	public String getBulData() {
		return bulData;
	}

	public void setBulData(String bulData) {
		this.bulData = bulData;
	}
    
    
    
}