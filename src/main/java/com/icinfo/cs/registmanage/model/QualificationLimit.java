/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.registmanage.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.icinfo.framework.mybatis.mapper.annotation.Before;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * 描述:    cs_qualification_limit 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2016年11月04日
 */
@Table(name = "cs_qualification_limit")
public class QualificationLimit implements Serializable {
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
     * 来源表数据的唯一标识
     */
    @Column(name = "SourceId")
    private String sourceId;

    /**
     * 主体身份代码(CA14)
     */
    @Column(name = "PriPID")
    private String priPID;

    /**
     * 当事人名称
     */
    @Column(name = "ClientName")
    private String clientName;

    /**
     * 当事人证件类型0:经营许可证 其他参考编码表
     */
    @Column(name = "CertType")
    private String certType;

    /**
     * 当事人证件号
     */
    @Column(name = "CertNO")
    private String certNO;

    /**
     * 限制类别0:吊销企业1:失信被执行人2:刑事责任司法判决3:失信惩戒黑名单4:工商严重违法失信
     */
    @Column(name = "LimitType")
    private String limitType;

    /**
     * 限制开始日期
     */
    @Column(name = "LimitDateStart")
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date limitDateStart;

    /**
     * 限制结束日期
     */
    @Column(name = "LimitDateEnd")
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date limitDateEnd;
    
    
    /**
     * 最近修改人
     */
    @Column(name = "ChangePerson")
    private String changePerson;
    
    /**
     * 修改时间
     */
    @Column(name = "ChangeTime")
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date changeTime;

    /**
     * 创建时间
     */
    @Column(name = "CreateTime")
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date createTime;
    
    /**
     * 居住地
     */
    @Column(name = "HouseAdd")
    private String houseAdd;
    
    /**
     * 联系电话
     */
    @Column(name = "MobTel")
    private String mobTel;
    
    /**
     * 国籍
     */
    @Column(name = "Country")
    private String country;
    
    /**
     * 限制原因
     */
    @Column(name = "LimitReason")
    private String limitReason;
    
    /**
     * 限制部门
     */
    @Column(name = "LimitDepartName")
    private String limitDepartName;
    
    /**
     * 执行文号
     */
    @Column(name = "LimitNO")
    private String limitNO;
    
    /**
     * 性别
     */
    @Column(name = "Sex")
    private String sex;
    
    /**
     * 企业名称
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
    @Column(name = "UniCode")
  	private String uniCode;
    
  	/**
  	 * 登记机关
  	 */
  	@Column(name = "RegOrg")
  	private String regOrg;
  	
  	/**
  	 * 管辖单位
  	 */
  	@Column(name = "localAdm")
  	private String LocalAdm;
  	
  	/**
  	 * 登记机关中文
  	 */
  	@Column(name = "RegOrgName")
  	private String regOrgName;
  	
  	/**
  	 * 管辖单位中文
  	 */
  	@Column(name = "LocalAdmName")
  	private String localAdmName;
  	
    /**
     * 限制解除审核状态
     */
    @Column(name = "AuditState")
    private String auditState;    
    /**
     * 限制解除原因中文
     */
    @Column(name = "RemoveReason")
    private String removeReason;
    /**
     * 限制解除原因编码
     */
    @Column(name = "RemoveReasonCN")
    private String removeReasonCN;
    /**
     * 限制解除其他原因（中文）
     */
    @Column(name = "RemoveOtherReason")
    private String removeOtherReason;
    /**
     * 解除申请人
     */
    @Column(name = "RemoveAppLyName")
    private String removeAppLyName;

    /**
     * 解除申请日期
     */
    @Column(name = "RemoveAppLyDate")
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date removeAppLyDate;
    
    /**
     * 解除审核人
     */
    @Column(name = "RemoveAuditName")
    private String removeAuditName;
    
    /**
     *解除审核日期
     */
    @Column(name = "RemoveAuditDate")
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date removeAuditDate;
    
    /**
     * 提前解除审核部门
     */
    @Column(name = "RemoveAuditDept")
    private String removeAuditDept;
    /**
     * 提前解除限制审核意见
     */
    @Column(name = "RemoveAuditOpin")
    private String removeAuditOpin;
    /**
     * 解除机关
     */
    @Column(name = "RemoveDept")
    private String removeDept;
    /**
     * 解除机关中文
     */
    @Column(name = "RemoveDeptName")
    private String removeDeptName;
  	
    /**
     *限制解除日期
     */
    @Column(name = "RemoveDate")
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date removeDate;
    
  	
    
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
     * 获取UID
     *
     * @return UID - UID
     */
    public String getUid() {
        return uid;
    }

    /**
     * 设置UID
     *
     * @param UID UID
     */
    public void setUid(String uid) {
        this.uid = uid;
    }

    /**
     * 获取来源表数据的唯一标识
     *
     * @return SourceId - 来源表数据的唯一标识
     */
    public String getSourceId() {
        return sourceId;
    }

    /**
     * 设置来源表数据的唯一标识
     *
     * @param sourceId 来源表数据的唯一标识
     */
    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    /**
     * 获取主体身份代码(CA14)
     *
     * @return PriPID - 主体身份代码(CA14)
     */
    public String getPriPID() {
        return priPID;
    }

    /**
     * 设置主体身份代码(CA14)
     *
     * @param priPID 主体身份代码(CA14)
     */
    public void setPriPID(String priPID) {
        this.priPID = priPID;
    }

    /**
     * 获取当事人名称
     *
     * @return ClientName - 当事人名称
     */
    public String getClientName() {
        return clientName;
    }

    /**
     * 设置当事人名称
     *
     * @param clientName 当事人名称
     */
    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    /**
     * 获取当事人证件类型0:经营许可证 其他参考编码表
     *
     * @return CertType - 当事人证件类型0:经营许可证 其他参考编码表
     */
    public String getCertType() {
        return certType;
    }

    /**
     * 设置当事人证件类型0:经营许可证 其他参考编码表
     *
     * @param certType 当事人证件类型0:经营许可证 其他参考编码表
     */
    public void setCertType(String certType) {
        this.certType = certType;
    }

    /**
     * 获取当事人证件号
     *
     * @return CertNO - 当事人证件号
     */
    public String getCertNO() {
        return certNO;
    }

    /**
     * 设置当事人证件号
     *
     * @param certNO 当事人证件号
     */
    public void setCertNO(String certNO) {
        this.certNO = certNO;
    }

    /**
     * 获取限制类别0:吊销企业1:失信被执行人2:刑事责任司法判决3:失信惩戒黑名单4:工商严重违法失信
     *
     * @return LimitType - 限制类别0:吊销企业1:失信被执行人2:刑事责任司法判决3:失信惩戒黑名单4:工商严重违法失信
     */
    public String getLimitType() {
        return limitType;
    }

    /**
     * 设置限制类别0:吊销企业1:失信被执行人2:刑事责任司法判决3:失信惩戒黑名单4:工商严重违法失信
     *
     * @param limitType 限制类别0:吊销企业1:失信被执行人2:刑事责任司法判决3:失信惩戒黑名单4:工商严重违法失信
     */
    public void setLimitType(String limitType) {
        this.limitType = limitType;
    }

    /**
     * 获取限制开始日期
     *
     * @return LimitDateStart - 限制开始日期
     */
    public Date getLimitDateStart() {
        return limitDateStart;
    }

    /**
     * 设置限制开始日期
     *
     * @param limitDateStart 限制开始日期
     */
    public void setLimitDateStart(Date limitDateStart) {
        this.limitDateStart = limitDateStart;
    }

    /**
     * 获取限制结束日期
     *
     * @return LimitDateEnd - 限制结束日期
     */
    public Date getLimitDateEnd() {
        return limitDateEnd;
    }

    /**
     * 设置限制结束日期
     *
     * @param limitDateEnd 限制结束日期
     */
    public void setLimitDateEnd(Date limitDateEnd) {
        this.limitDateEnd = limitDateEnd;
    }

    /**
     * 获取修改时间
     *
     * @return ChangeTime - 修改时间
     */
    public Date getChangeTime() {
        return changeTime;
    }

    /**
     * 设置修改时间
     *
     * @param changeTime 修改时间
     */
    public void setChangeTime(Date changeTime) {
        this.changeTime = changeTime;
    }

    /**
     * 获取创建时间
     *
     * @return CreateTime - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

	public String getChangePerson() {
		return changePerson;
	}

	public void setChangePerson(String changePerson) {
		this.changePerson = changePerson;
	}

	public String getHouseAdd() {
		return houseAdd;
	}

	public void setHouseAdd(String houseAdd) {
		this.houseAdd = houseAdd;
	}

	public String getMobTel() {
		return mobTel;
	}

	public void setMobTel(String mobTel) {
		this.mobTel = mobTel;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getLimitReason() {
		return limitReason;
	}

	public void setLimitReason(String limitReason) {
		this.limitReason = limitReason;
	}

	public String getLimitDepartName() {
		return limitDepartName;
	}

	public void setLimitDepartName(String limitDepartName) {
		this.limitDepartName = limitDepartName;
	}

	public String getLimitNO() {
		return limitNO;
	}

	public void setLimitNO(String limitNO) {
		this.limitNO = limitNO;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getEntName() {
		return entName;
	}

	public void setEntName(String entName) {
		this.entName = entName;
	}

	public String getRegNO() {
		return regNO;
	}

	public void setRegNO(String regNO) {
		this.regNO = regNO;
	}

	public String getUniCode() {
		return uniCode;
	}

	public void setUniCode(String uniCode) {
		this.uniCode = uniCode;
	}

	public String getRegOrg() {
		return regOrg;
	}

	public void setRegOrg(String regOrg) {
		this.regOrg = regOrg;
	}

	public String getLocalAdm() {
		return LocalAdm;
	}

	public void setLocalAdm(String localAdm) {
		LocalAdm = localAdm;
	}

	public String getRegOrgName() {
		return regOrgName;
	}

	public void setRegOrgName(String regOrgName) {
		this.regOrgName = regOrgName;
	}

	public String getLocalAdmName() {
		return localAdmName;
	}

	public void setLocalAdmName(String localAdmName) {
		this.localAdmName = localAdmName;
	}

	public String getAuditState() {
		return auditState;
	}

	public void setAuditState(String auditState) {
		this.auditState = auditState;
	}

	public String getRemoveReason() {
		return removeReason;
	}

	public void setRemoveReason(String removeReason) {
		this.removeReason = removeReason;
	}

	public String getRemoveAppLyName() {
		return removeAppLyName;
	}

	public void setRemoveAppLyName(String removeAppLyName) {
		this.removeAppLyName = removeAppLyName;
	}

	public Date getRemoveAppLyDate() {
		return removeAppLyDate;
	}

	public void setRemoveAppLyDate(Date removeAppLyDate) {
		this.removeAppLyDate = removeAppLyDate;
	}

	public String getRemoveAuditName() {
		return removeAuditName;
	}

	public void setRemoveAuditName(String removeAuditName) {
		this.removeAuditName = removeAuditName;
	}

	public Date getRemoveAuditDate() {
		return removeAuditDate;
	}

	public void setRemoveAuditDate(Date removeAuditDate) {
		this.removeAuditDate = removeAuditDate;
	}

	public String getRemoveAuditDept() {
		return removeAuditDept;
	}

	public void setRemoveAuditDept(String removeAuditDept) {
		this.removeAuditDept = removeAuditDept;
	}

	public String getRemoveAuditOpin() {
		return removeAuditOpin;
	}

	public void setRemoveAuditOpin(String removeAuditOpin) {
		this.removeAuditOpin = removeAuditOpin;
	}

	public String getRemoveDept() {
		return removeDept;
	}

	public void setRemoveDept(String removeDept) {
		this.removeDept = removeDept;
	}

	public String getRemoveReasonCN() {
		return removeReasonCN;
	}

	public void setRemoveReasonCN(String removeReasonCN) {
		this.removeReasonCN = removeReasonCN;
	}

	public String getRemoveOtherReason() {
		return removeOtherReason;
	}

	public void setRemoveOtherReason(String removeOtherReason) {
		this.removeOtherReason = removeOtherReason;
	}

	public String getRemoveDeptName() {
		return removeDeptName;
	}

	public void setRemoveDeptName(String removeDeptName) {
		this.removeDeptName = removeDeptName;
	}
	
	public Date getRemoveDate() {
		return removeDate;
	}
	public void setRemoveDate(Date removeDate) {
		this.removeDate = removeDate;
	}
	
	
 
}