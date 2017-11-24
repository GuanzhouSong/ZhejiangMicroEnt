package com.icinfo.cs.nocreditPunish.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

import com.icinfo.framework.mybatis.mapper.annotation.Before;

/**
 * cs_nocredit_punishrule 对应实体类
 * @author caoxu
 * @date 2016年10月18日
 */
@Table(name = "cs_nocredit_punishrule")
public class NoCreditPunishRule implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7937023450745471471L;
	
	/**
     * uuid
     */
	@Id
    @Column(name = "Uid")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "select replace(uuid(), '-', '')")
    private String id;
	
	/**
     * 创建时间
     */
	@Column(name = "CreateTime")
	private Date createTime;
	
	/**
     * 惩戒领域
     */
	@NotBlank
	@Column(name = "PunField")
	private String punField;
	
	/**
     * 限制时间
     */
	@Column(name = "LimitTime")
	private String limitTime;
	
	/**
     * 法律依据
     */
	@Column(name = "LegBasis")
	private String legBasis;
	
	/**
     * 惩戒事由
     */
	@NotBlank
	@Column(name = "PunCause")
	private String punCause;
	
	/**
     * 惩戒规则
     */
	@NotBlank
	@Column(name = "PunRule")
	private String punRule;
	
	/**
     * 惩戒措施
     */
	@NotBlank
	@Column(name = "PunMea")
	private String punMea;
	
	/**
     * 惩戒提请部门
     */
	@Column(name = "PunReqDept")
	private String punReqDept;
	
	/**
     * 惩戒提请部门编码
     */
	@Column(name = "PunReqDeptCode")
	private String punReqDeptCode;
	
	/**
     * 惩戒执行部门
     */
	@Column(name = "PunExeDept")
	private String punExeDept;
	
	/**
     * 惩戒执行部门编码
     */
	@Column(name = "PunExeDeptCode")
	private String punExeDeptCode;

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getPunField() {
		return punField;
	}

	public void setPunField(String punField) {
		this.punField = punField.trim();
	}

	public String getLimitTime() {
		return limitTime;
	}

	public void setLimitTime(String limitTime) {
		this.limitTime = limitTime;
	}

	public String getLegBasis() {
		return legBasis;
	}

	public void setLegBasis(String legBasis) {
		this.legBasis = legBasis;
	}

	public String getPunCause() {
		return punCause;
	}

	public void setPunCause(String punCause) {
		this.punCause = punCause.trim();
	}

	public String getPunRule() {
		return punRule;
	}

	public void setPunRule(String punRule) {
		this.punRule = punRule;
	}

	public String getPunMea() {
		return punMea;
	}

	public void setPunMea(String punMea) {
		this.punMea = punMea;
	}

	public String getPunReqDept() {
		return punReqDept;
	}

	public void setPunReqDept(String punReqDept) {
		this.punReqDept = punReqDept;
	}

	public String getPunExeDept() {
		return punExeDept;
	}

	public void setPunExeDept(String punExeDept) {
		this.punExeDept = punExeDept;
	}

	public String getPunReqDeptCode() {
		return punReqDeptCode;
	}

	public void setPunReqDeptCode(String punReqDeptCode) {
		this.punReqDeptCode = punReqDeptCode;
	}

	public String getPunExeDeptCode() {
		return punExeDeptCode;
	}

	public void setPunExeDeptCode(String punExeDeptCode) {
		this.punExeDeptCode = punExeDeptCode;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
