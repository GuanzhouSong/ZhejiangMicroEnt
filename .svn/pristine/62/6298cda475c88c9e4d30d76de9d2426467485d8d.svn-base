package com.icinfo.cs.concern.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Digits;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.icinfo.framework.mybatis.mapper.annotation.Before;

/**
 * cs_concern_activity 对应实体类
 * @author caoxu
 * @date 2016年11月06日
 */
@Table(name = "cs_concern_activity")
public class CsConcernActivity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1435996157940675963L;
	
	/**
     * uuid
     */
	@Id
    @Column(name = "Uid")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "select replace(uuid(), '-', '')")
    private String id;
	
	@Column(name = "CreateTime")
	private Date createTime;
	
	//活动主题
	@Length(max = 200)
	@NotBlank
	@Column(name = "Theme")
	private String theme;
	
	//标识对象
	@NotBlank
	@Column(name = "MarkName")
	private String markName;
	
	//标识编码
	@NotBlank
	@Column(name = "MarkNo")
	private String markNo;
	
	//开展服务日期起
	@JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
	@Column(name = "DateBegin")
	private Date dateBegin;
	
	//开展服务日期止
	@JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
	@Column(name = "DateEnd")
	private Date dateEnd;
	
	//是否长期
	@Column(name = "IsLong")
	private String isLong;
	
	//关注服务形式
	@NotBlank
	@Column(name = "ActFormat")
	private String actFormat;
	
	//金额
	@Digits(integer = 13, fraction = 3)
	@Column(name = "Amount")
	private BigDecimal amount;
	
	//发起部门名称
	@Column(name = "LauDeptName")
	private String lauDeptName;
	
	//发起部门编码
	@Column(name = "LauDeptCode")
	private String lauDeptCode;
	
	//录入部门名称
	@Column(name = "OperDeptName")
	private String operDeptName;
	
	//录入部门编码
	@Column(name = "OperDeptCode")
	private String operDeptCode;
	
	//录入人
	@Column(name = "OperName")
	private String operName;
	
	//录入人UID
	@Column(name = "OperUid")
	private String operUid;
	
	//服务内容
	@Length(max = 1500)
	@Column(name = "Content")
	private String content;
	
	//服务内容
	@Length(max = 200)
	@Column(name = "OtherAct")
	private String otherAct;
	
	//状态
	@Column(name = "State")
	private Integer state;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public String getMarkName() {
		return markName;
	}

	public void setMarkName(String markName) {
		this.markName = markName;
	}

	public String getMarkNo() {
		return markNo;
	}

	public void setMarkNo(String markNo) {
		this.markNo = markNo;
	}

	public Date getDateBegin() {
		return dateBegin;
	}

	public void setDateBegin(Date dateBegin) {
		this.dateBegin = dateBegin;
	}

	public Date getDateEnd() {
		return dateEnd;
	}

	public void setDateEnd(Date dateEnd) {
		this.dateEnd = dateEnd;
	}

	public String getIsLong() {
		return isLong;
	}

	public void setIsLong(String isLong) {
		this.isLong = isLong;
	}

	public String getActFormat() {
		return actFormat;
	}

	public void setActFormat(String actFormat) {
		this.actFormat = actFormat;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getLauDeptName() {
		return lauDeptName;
	}

	public void setLauDeptName(String lauDeptName) {
		this.lauDeptName = lauDeptName;
	}

	public String getLauDeptCode() {
		return lauDeptCode;
	}

	public void setLauDeptCode(String lauDeptCode) {
		this.lauDeptCode = lauDeptCode;
	}

	public String getOperDeptName() {
		return operDeptName;
	}

	public void setOperDeptName(String operDeptName) {
		this.operDeptName = operDeptName;
	}

	public String getOperDeptCode() {
		return operDeptCode;
	}

	public void setOperDeptCode(String operDeptCode) {
		this.operDeptCode = operDeptCode;
	}

	public String getOperName() {
		return operName;
	}

	public void setOperName(String operName) {
		this.operName = operName;
	}

	public String getOperUid() {
		return operUid;
	}

	public void setOperUid(String operUid) {
		this.operUid = operUid;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getOtherAct() {
		return otherAct;
	}

	public void setOtherAct(String otherAct) {
		this.otherAct = otherAct;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

}
