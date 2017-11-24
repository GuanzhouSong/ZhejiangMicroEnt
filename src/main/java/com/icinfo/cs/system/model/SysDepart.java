/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.system.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * 描述:    cs_sys_depart 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2016年10月19日
 */
@Table(name = "cs_sys_depart")
public class SysDepart implements Serializable {

    @Id
    @Column(name = "id")
    private Integer id;

    /**
     * 编码
     */
    @Column(name = "OrgCoding")
    private String orgCoding;

    /**
     * 机构名称
     */
    @Column(name = "OrgName")
    private String orgName;

    /**
     *
     */
    @Column(name = "DevCoding")
    private String devCoding;

    /**
     * 部门全称
     */
    @Column(name = "OrganizeAllName")
    private String organizeAllName;

    /**
     *
     */
    @Column(name = "DisponClient")
    private String disponClient;

    /**
     *
     */
    @Column(name = "OrderBy")
    private Integer orderBy;

    @Column(name = "QuanLimag")
    private String quanLimag;

    /**
     *
     */
    @Column(name = "Adcode")
    private String adcode;

    /**
     * 上级机构编码
     */
    @Column(name = "PorgCoding")
    private String porgCoding;


    @Column(name = "CreateTime")
    private Date createTime;

    //登记机关联络员
    @Column(name = "LiaName")
    private String liaName;

    //联络员电话号码
    @Column(name = "LiaPhone")
    private  String liaPhone;
    
    //父节点标识
    @Column(name = "ParentFlag")
    private  String parentFlag;
    
    //文号简称
    @Column(name = "DocShortName")
    private  String docShortName;


    @Transient
    private String isParent;

    @Transient
    private String nocheck;

    /**
     * 职能编码（关联CS_CODE_DUTYDEPT）
     */
    @Transient
    private String dutyCodes;

    /**
     * 职能部门名称（复数）
     */
    @Transient
    private String dutyNames;

    public String getLiaName() {
        return liaName;
    }

    public void setLiaName(String liaName) {
        this.liaName = liaName;
    }

    public String getLiaPhone() {
        return liaPhone;
    }

    public void setLiaPhone(String liaPhone) {
        this.liaPhone = liaPhone;
    }

    public String getDutyNames() {
        return dutyNames;
    }

    public void setDutyNames(String dutyNames) {
        this.dutyNames = dutyNames;
    }

    public String getDutyCodes() {
        return dutyCodes;
    }

    public void setDutyCodes(String dutyCodes) {
        this.dutyCodes = dutyCodes;
    }

    public String getNocheck() {
        return nocheck;
    }

    public void setNocheck(String nocheck) {
        this.nocheck = nocheck;
    }

    public String getIsParent() {
        return isParent;
    }

    public void setIsParent(String isParent) {
        this.isParent = isParent;
    }

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
     * 获取编码
     *
     * @return OrgCoding - 编码
     */
    public String getOrgCoding() {
        return orgCoding;
    }

    /**
     * 设置编码
     *
     * @param orgCoding 编码
     */
    public void setOrgCoding(String orgCoding) {
        this.orgCoding = orgCoding;
    }

    /**
     * 获取机构名称
     *
     * @return OrgName - 机构名称
     */
    public String getOrgName() {
        return orgName;
    }

    /**
     * 设置机构名称
     *
     * @param orgName 机构名称
     */
    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    /**
     * @return DevCoding
     */
    public String getDevCoding() {
        return devCoding;
    }

    /**
     * @param devCoding
     */
    public void setDevCoding(String devCoding) {
        this.devCoding = devCoding;
    }

    /**
     * @return OrganizeAllName
     */
    public String getOrganizeAllName() {
        return organizeAllName;
    }

    /**
     * @param organizeAllName
     */
    public void setOrganizeAllName(String organizeAllName) {
        this.organizeAllName = organizeAllName;
    }

    /**
     * @return DisponClient
     */
    public String getDisponClient() {
        return disponClient;
    }

    /**
     * @param disponClient
     */
    public void setDisponClient(String disponClient) {
        this.disponClient = disponClient;
    }

    /**
     * @return OrderBy
     */
    public Integer getOrderBy() {
        return orderBy;
    }

    /**
     * @param orderBy
     */
    public void setOrderBy(Integer orderBy) {
        this.orderBy = orderBy;
    }

    /**
     * @return QuanLimag
     */
    public String getQuanLimag() {
        return quanLimag;
    }

    /**
     * @param quanLimag
     */
    public void setQuanLimag(String quanLimag) {
        this.quanLimag = quanLimag;
    }

    /**
     * @return Adcode
     */
    public String getAdcode() {
        return adcode;
    }

    /**
     * @param adcode
     */
    public void setAdcode(String adcode) {
        this.adcode = adcode;
    }

    /**
     * 获取上级机构编码
     *
     * @return PorgCoding - 上级机构编码
     */
    public String getPorgCoding() {
        return porgCoding;
    }

    /**
     * 设置上级机构编码
     *
     * @param porgCoding 上级机构编码
     */
    public void setPorgCoding(String porgCoding) {
        this.porgCoding = porgCoding;
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

	public String getParentFlag() {
		return parentFlag;
	}

	public void setParentFlag(String parentFlag) {
		this.parentFlag = parentFlag;
	}

	public String getDocShortName() {
		return docShortName;
	}

	public void setDocShortName(String docShortName) {
		this.docShortName = docShortName;
	}
}