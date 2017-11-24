/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.risk.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.icinfo.framework.mybatis.mapper.annotation.Before;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * 描述:    cs_mark 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2016年10月18日
 */
@Table(name = "cs_mark")
public class CsWarnMark implements Serializable {
    /**
     * 主键ID
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
    private String uid;

    /**
     * 编码
     */
    @Column(name = "MarkNo")
    private String markNo;

    /**
     * 标识设置年度
     */
    @Column(name = "MarkSetYear")
    private String markSetYear;

    /**
     * 标识类型
     */
    @Column(name = "MarkType")
    private String markType;

    /**
     * 标识级别
     */
    @Column(name = "MarkClass")
    private String markClass;

    /**
     * 标识名称
     */
    @Column(name = "MarkName")
    private String markName;

    /**
     * 标识内容
     */
    @Column(name = "MarkContent")
    private String markContent;

    /**
     * 标识开始日期
     */
    @Column(name = "MarkStartDate")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date markStartDate;

    /**
     * 标识结束日期
     */
    @Column(name = "MarkEndDate")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date markEndDate;

    /**
     * 标识状态0:无效，1:有效
     */
    @Column(name = "MarkState")
    private String markState;
    
    
    /**
     * 适用地区
     */
    @Column(name = "MarkUseArea")
    private String markUseArea;

    /**
     * 标识指定提示方式
     */
    @Column(name = "MarkAppointWay")
    private String markAppointWay;
    
    /**
     * 标识指定提示部门编码
     */
    @Column(name = "MarkAppointDeptCode")
    private String markAppointDeptCode;
    
    /**
     * 标识指定提示部门
     */
    @Column(name = "MarkAppointDept")
    private String markAppointDept;
    
    /**
     * 标识设置部门联系人
     */
    @Column(name = "SetDeptContact")
    private String setDeptContact;

    /**
     * 标识设置部门
     */
    @Column(name = "MarkSetDept")
    private String markSetDept;
    
    /**
     * 标识设置部门编码
     */
    @Column(name = "MarkSetDeptCode")
    private String markSetDeptCode;
    
    /**
     * 标识设置时间
     */
    @Column(name = "MarkSetDate")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date markSetDate;

    /**
     * 联系电话
     */
    @Column(name = "Tel")
    private String tel;

    /**
     * 传真
     */
    @Column(name = "Fax")
    private String fax;

    /**
     * 邮箱
     */
    @Column(name = "Email")
    private String email;

    /**
     * 操作人ID
     */
    @Column(name = "SetId")
    private String setId;

    /**
     * 创建时间
     */
    @Column(name = "CreateTime")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date createTime;
    
    /**
     * 标识类型
     */
    @Column(name = "MarkFunc")
    private String markFunc;
    
    private static final long serialVersionUID = 1L;

    /**
     * 获取主键ID
     *
     * @return id - 主键ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置主键ID
     *
     * @param id 主键ID
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

	public String getMarkNo() {
		return markNo;
	}

	public void setMarkNo(String markNo) {
		this.markNo = markNo;
	}

	public String getMarkSetYear() {
		return markSetYear;
	}

	public void setMarkSetYear(String markSetYear) {
		this.markSetYear = markSetYear;
	}

	public String getMarkType() {
		return markType;
	}

	public void setMarkType(String markType) {
		this.markType = markType;
	}

	public String getMarkClass() {
		return markClass;
	}

	public void setMarkClass(String markClass) {
		this.markClass = markClass;
	}

	public String getMarkName() {
		return markName;
	}

	public void setMarkName(String markName) {
		this.markName = markName;
	}

	public String getMarkContent() {
		return markContent;
	}

	public void setMarkContent(String markContent) {
		this.markContent = markContent;
	}

	public Date getMarkStartDate() {
		return markStartDate;
	}

	public void setMarkStartDate(Date markStartDate) {
		this.markStartDate = markStartDate;
	}

	public Date getMarkEndDate() {
		return markEndDate;
	}

	public void setMarkEndDate(Date markEndDate) {
		this.markEndDate = markEndDate;
	}

	public String getMarkState() {
		return markState;
	}

	public void setMarkState(String markState) {
		this.markState = markState;
	}

	public String getMarkAppointWay() {
		return markAppointWay;
	}

	public void setMarkAppointWay(String markAppointWay) {
		this.markAppointWay = markAppointWay;
	}

	public String getMarkAppointDeptCode() {
		return markAppointDeptCode;
	}

	public void setMarkAppointDeptCode(String markAppointDeptCode) {
		this.markAppointDeptCode = markAppointDeptCode;
	}

	public String getMarkAppointDept() {
		return markAppointDept;
	}

	public void setMarkAppointDept(String markAppointDept) {
		this.markAppointDept = markAppointDept;
	}

	public String getSetDeptContact() {
		return setDeptContact;
	}

	public void setSetDeptContact(String setDeptContact) {
		this.setDeptContact = setDeptContact;
	}

	public String getMarkSetDept() {
		return markSetDept;
	}

	public void setMarkSetDept(String markSetDept) {
		this.markSetDept = markSetDept;
	}

	public String getMarkSetDeptCode() {
		return markSetDeptCode;
	}

	public void setMarkSetDeptCode(String markSetDeptCode) {
		this.markSetDeptCode = markSetDeptCode;
	}

	public Date getMarkSetDate() {
		return markSetDate;
	}

	public void setMarkSetDate(Date markSetDate) {
		this.markSetDate = markSetDate;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSetId() {
		return setId;
	}

	public void setSetId(String setId) {
		this.setId = setId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getMarkFunc() {
		return markFunc;
	}

	public void setMarkFunc(String markFunc) {
		this.markFunc = markFunc;
	}

	public String getMarkUseArea() {
		return markUseArea;
	}

	public void setMarkUseArea(String markUseArea) {
		this.markUseArea = markUseArea;
	}

     
     
}