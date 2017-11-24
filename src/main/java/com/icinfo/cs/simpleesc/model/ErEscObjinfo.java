/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.simpleesc.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 描述: er_esc_objinfo 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * 
 * @author framework generator
 * @date 2017年02月13日
 */
@Table(name = "er_esc_objinfo")
public class ErEscObjinfo implements Serializable {
	@Id
	@Column(name = "id")
	private Long id;

	/**
	 * 企业内部序号
	 */
	@Column(name = "PriPID")
	private String priPID;

	/**
	 * 序号
	 */
	@Column(name = "Seq")
	private String seq;

	/**
	 * 姓名
	 */
	@Column(name = "Name")
	private String name;

	/**
	 * 证件类型
	 */
	@Column(name = "CerType")
	private String cerType;

	/**
	 * 证件号码
	 */
	@Column(name = "CerNO")
	private String cerNO;

	/**
	 * 证件照片（正面）
	 */
	@Column(name = "CertificatesPic")
	private String certificatesPic;

	/**
	 * 证件照片（反面）
	 */
	@Column(name = "BCertificatesPic")
	private String bcertificatesPic;

	/**
	 * 移动电话
	 */
	@Column(name = "MobTel")
	private String mobTel;

	/**
	 * 名称
	 */
	@Column(name = "EntName")
	private String entName;

	/**
	 * 注册号
	 */
	@Column(name = "RegNO")
	private String regNO;

	/**
	 * 统一社会信用代码
	 */
	@Column(name = "UniSCID")
	private String uniSCID;

	/**
	 * 法定代表人
	 */
	@Column(name = "LeRep")
	private String leRep;

	/**
	 * 登记机关
	 */
	@Column(name = "RegOrg")
	private String regOrg;

	/**
	 * 管辖单位
	 */
	@Column(name = "LocalAdm")
	private String localAdm;

	/**
	 * 单位名称
	 */
	@Column(name = "UnitName")
	private String unitName;

	/**
	 * 异议申请人类型
	 */
	@Column(name = "Type")
	private String type;

	/**
	 * 异议内容
	 */
	@Column(name = "Objection")
	private String objection;

	/**
	 * 异议申请日期
	 */
	@Column(name = "Objapptime")
	@JsonFormat(pattern = "yyyy年MM月dd日", timezone = "GMT+8")
	private Date objapptime;

	/**
	 * 时间戳
	 */
	@Column(name = "CreateTime")
	private Date createTime;

	private static final long serialVersionUID = 1L;

	/**
	 * @return id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return PriPID
	 */
	public String getPriPID() {
		return priPID;
	}

	/**
	 * @param priPID
	 */
	public void setPriPID(String priPID) {
		this.priPID = priPID;
	}

	/**
	 * @return Seq
	 */
	public String getSeq() {
		return seq;
	}

	/**
	 * @param seq
	 */
	public void setSeq(String seq) {
		this.seq = seq;
	}

	/**
	 * @return Name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return CerType
	 */
	public String getCerType() {
		return cerType;
	}

	/**
	 * @param cerType
	 */
	public void setCerType(String cerType) {
		this.cerType = cerType;
	}

	/**
	 * @return CerNO
	 */
	public String getCerNO() {
		return cerNO;
	}

	/**
	 * @param cerNO
	 */
	public void setCerNO(String cerNO) {
		this.cerNO = cerNO;
	}

	/**
	 * @return CertificatesPic
	 */
	public String getCertificatesPic() {
		return certificatesPic;
	}

	/**
	 * @param certificatesPic
	 */
	public void setCertificatesPic(String certificatesPic) {
		this.certificatesPic = certificatesPic;
	}

	/**
	 * @return MobTel
	 */
	public String getMobTel() {
		return mobTel;
	}

	/**
	 * @param mobTel
	 */
	public void setMobTel(String mobTel) {
		this.mobTel = mobTel;
	}

	/**
	 * @return EntName
	 */
	public String getEntName() {
		return entName;
	}

	public String getBcertificatesPic() {
		return bcertificatesPic;
	}

	public void setBcertificatesPic(String bcertificatesPic) {
		this.bcertificatesPic = bcertificatesPic;
	}

	/**
	 * @param entName
	 */
	public void setEntName(String entName) {
		this.entName = entName;
	}

	/**
	 * @return RegNO
	 */
	public String getRegNO() {
		return regNO;
	}

	/**
	 * @param regNO
	 */
	public void setRegNO(String regNO) {
		this.regNO = regNO;
	}

	/**
	 * @return UniSCID
	 */
	public String getUniSCID() {
		return uniSCID;
	}

	/**
	 * @param uniSCID
	 */
	public void setUniSCID(String uniSCID) {
		this.uniSCID = uniSCID;
	}

	/**
	 * @return LeRep
	 */
	public String getLeRep() {
		return leRep;
	}

	/**
	 * @param leRep
	 */
	public void setLeRep(String leRep) {
		this.leRep = leRep;
	}

	/**
	 * @return UnitName
	 */
	public String getUnitName() {
		return unitName;
	}

	/**
	 * @param unitName
	 */
	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	/**
	 * @return Type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return Objapptime
	 */
	public Date getObjapptime() {
		return objapptime;
	}

	/**
	 * @param objapptime
	 */
	public void setObjapptime(Date objapptime) {
		this.objapptime = objapptime;
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
	 * @return Objection
	 */
	public String getObjection() {
		return objection;
	}

	/**
	 * @param objection
	 */
	public void setObjection(String objection) {
		this.objection = objection;
	}

	public String getRegOrg() {
		return regOrg;
	}

	public void setRegOrg(String regOrg) {
		this.regOrg = regOrg;
	}

	public String getLocalAdm() {
		return localAdm;
	}

	public void setLocalAdm(String localAdm) {
		this.localAdm = localAdm;
	}
}