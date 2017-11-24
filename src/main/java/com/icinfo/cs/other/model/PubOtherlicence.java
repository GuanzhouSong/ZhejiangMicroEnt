/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.other.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.framework.mybatis.mapper.annotation.Before;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

import org.apache.commons.lang3.StringUtils;

/**
 * 描述:  cs_pub_otherlicence 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2016年10月18日
 */
@Table(name = "cs_pub_otherlicence")
public class PubOtherlicence implements Serializable {
    /**
     * 主键自增id
     */
    @Id
    @Column(name = "id")
   
    private Integer id;
    @Transient
    private String isExpire;

    /**
     * UUID
     */
    @Column(name = "LicID")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    private String licID;

    /**
     * 主体身份代码
     */
    @Column(name = "PriPID")
    private String priPID;

    /**
     * 注册号
     */
    @Column(name = "RegNO")
    private String regNO;

    /**
     * 企业名称
     */
    @Column(name = "EntName")
    private String entName;

    /**
     * 许可证名称
     */
    @Column(name = "LicNameCN")
    private String licNameCN;

    /**
     * 许可证编号
     */
    @Column(name = "LicNO")
    private String licNO;

    /**
     * 有效期始
     */
    @Column(name = "LicValFrom")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date licValFrom;

    /**
     * 有效期至
     */
    @Column(name = "LicValTo")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date licValTo;

    /**
     * 许可机关
     */
    @Column(name = "LicAnth")
    private String licAnth;

    /**
     * 是否已公示1:已公示0:未公示
     */
    @Column(name = "PubFlag")
    private String pubFlag;

    /**
     * 类别选择:1:变更,2注销,3被吊销,4撤销失效
     */
    @Column(name = "LicType")
    private String licType;

    /**
     * 变更日期
     */
    @Column(name = "AltDate")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date altDate;

    /**
     * 注销日期
     */
    @Column(name = "CanDate")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date canDate;

    /**
     * 被吊销日期
     */
    @Column(name = "RevDate")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date revDate;

    /**
     * 无效日期
     */
    @Column(name = "InvAlidDate")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date invAlidDate;

    /**
     * 其他无效原因
     */
    @Column(name = "InvAliDRea")
    private String invAliDRea;

    /**
     * 录入人
     */
    @Column(name = "SetName")
    private String setName;

    /**
     * 录入日期
     */
    @Column(name = "SetDate")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date setDate;

    /**
     * 审核人
     */
    @Column(name = "AuditName")
    private String auditName;

    /**
     * 审核日期
     */
    @Column(name = "AuditDate")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date auditDate;

    /**
     * 审核结果:0:待审核,1:已审核,2:审核通不过
     */
    @Column(name = "AuditState")
    private String auditState;

    /**
     * 审核意见
     */
    @Column(name = "AuditOpin")
    private String auditOpin;

    /**
     * 状态:1有效,0:无效
     */
    @Column(name = "LicState")
    private String licState;

    /**
     * 录入部门
     */
    @Column(name = "SetDeptname")
    private String setDeptname;

    /**
     * 时间戳
     */
    @Column(name = "CreateTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;

    /**
     * 许可内容
     */
    @Column(name = "LicScope")
    private String licScope;

    /**
     * 注销原因
     */
    @Column(name = "CanRea")
    private String canRea;

    /**
     * 被吊销原因
     */
    @Column(name = "RevRea")
    private String revRea;
    
    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private String updateTime;

    public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	private static final long serialVersionUID = 1L;

    /**
     * 获取主键自增id
     *
     * @return id - 主键自增id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置主键自增id
     *
     * @param id 主键自增id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取UUID
     *
     * @return LicID - UUID
     */
    public String getLicID() {
        return licID;
    }

    /**
     * 设置UUID
     *
     * @param licID UUID
     */
    public void setLicID(String licID) {
        this.licID = licID;
    }

    /**
     * 获取主体身份代码
     *
     * @return PriPID - 主体身份代码
     */
    public String getPriPID() {
        return priPID;
    }

    /**
     * 设置主体身份代码
     *
     * @param priPID 主体身份代码
     */
    public void setPriPID(String priPID) {
        this.priPID = priPID;
    }

    /**
     * 获取注册号
     *
     * @return RegNO - 注册号
     */
    public String getRegNO() {
        return regNO;
    }

    /**
     * 设置注册号
     *
     * @param regNO 注册号
     */
    public void setRegNO(String regNO) {
        this.regNO = regNO;
    }

    /**
     * 获取企业名称
     *
     * @return EntName - 企业名称
     */
    public String getEntName() {
        return entName;
    }

    /**
     * 设置企业名称
     *
     * @param entName 企业名称
     */
    public void setEntName(String entName) {
        this.entName = entName;
    }

    /**
     * 获取许可证名称
     *
     * @return LicNameCN - 许可证名称
     */
    public String getLicNameCN() {
        return licNameCN;
    }

    /**
     * 设置许可证名称
     *
     * @param licNameCN 许可证名称
     */
    public void setLicNameCN(String licNameCN) {
        this.licNameCN = licNameCN;
    }

    /**
     * 获取许可证编号
     *
     * @return LicNO - 许可证编号
     */
    public String getLicNO() {
        return licNO;
    }

    /**
     * 设置许可证编号
     *
     * @param licNO 许可证编号
     */
    public void setLicNO(String licNO) {
        this.licNO = licNO;
    }

    /**
     * 获取有效期始
     *
     * @return LicValFrom - 有效期始
     */
    public Date getLicValFrom() {
        return licValFrom;
    }

    /**
     * 获取有效期至
     *
     * @return LicValTo - 有效期至
     */
    public String getLicValFromDesc() {
    	if(this.licValFrom==null) return "";
    	try {
			return DateUtil.dateToString(this.licValFrom,"yyyy年MM月dd日");
		} catch (Exception e) {
			 return "";
		}
    }
    
    /**
     * 设置有效期始
     *
     * @param licValFrom 有效期始
     */
    public void setLicValFrom(Date licValFrom) {
        this.licValFrom = licValFrom;
    }

    /**
     * 获取有效期至
     *
     * @return LicValTo - 有效期至
     */
    public Date getLicValTo() {
        return licValTo;
    }
    
    /**
     * 获取有效期至
     *
     * @return LicValTo - 有效期至
     */
    public String getLicValToDesc() {
    	if(this.licValTo==null) return "";
    	try {
			return DateUtil.dateToString(this.licValTo,"yyyy年MM月dd日");
		} catch (Exception e) {
			 return "";
		}
    }

    /**
     * 设置有效期至
     *
     * @param licValTo 有效期至
     */
    public void setLicValTo(Date licValTo) {
        this.licValTo = licValTo;
    }

    /**
     * 获取许可机关
     *
     * @return LicAnth - 许可机关
     */
    public String getLicAnth() {
        return licAnth;
    }

    /**
     * 设置许可机关
     *
     * @param licAnth 许可机关
     */
    public void setLicAnth(String licAnth) {
        this.licAnth = licAnth;
    }

    /**
     * 获取是否已公示1:已公示0:未公示
     *
     * @return PubFlag - 是否已公示1:已公示0:未公示
     */
    public String getPubFlag() {
        return pubFlag;
    }

    /**
     * 设置是否已公示1:已公示0:未公示
     *
     * @param pubFlag 是否已公示1:已公示0:未公示
     */
    public void setPubFlag(String pubFlag) {
        this.pubFlag = pubFlag;
    }

    /**
     * 获取类别选择:1:变更,2注销,3被吊销,4撤销失效
     *
     * @return LicType - 类别选择:1:变更,2注销,3被吊销,4撤销失效
     */
    public String getLicType() {
        return licType;
    }

    /**
     * 设置类别选择:1:变更,2注销,3被吊销,4撤销失效
     *
     * @param licType 类别选择:1:变更,2注销,3被吊销,4撤销失效
     */
    public void setLicType(String licType) {
        this.licType = licType;
    }

    /**
     * 获取变更日期
     *
     * @return AltDate - 变更日期
     */
    public Date getAltDate() {
        return altDate;
    }

    /**
     * 设置变更日期
     *
     * @param altDate 变更日期
     */
    public void setAltDate(Date altDate) {
        this.altDate = altDate;
    }

    /**
     * 获取注销日期
     *
     * @return CanDate - 注销日期
     */
    public Date getCanDate() {
        return canDate;
    }

    /**
     * 设置注销日期
     *
     * @param canDate 注销日期
     */
    public void setCanDate(Date canDate) {
        this.canDate = canDate;
    }

    /**
     * 获取被吊销日期
     *
     * @return RevDate - 被吊销日期
     */
    public Date getRevDate() {
        return revDate;
    }

    /**
     * 设置被吊销日期
     *
     * @param revDate 被吊销日期
     */
    public void setRevDate(Date revDate) {
        this.revDate = revDate;
    }

    /**
     * 获取无效日期
     *
     * @return InvAlidDate - 无效日期
     */
    public Date getInvAlidDate() {
        return invAlidDate;
    }

    /**
     * 设置无效日期
     *
     * @param invAlidDate 无效日期
     */
    public void setInvAlidDate(Date invAlidDate) {
        this.invAlidDate = invAlidDate;
    }

    /**
     * 获取其他无效原因
     *
     * @return InvAliDRea - 其他无效原因
     */
    public String getInvAliDRea() {
        return invAliDRea;
    }

    /**
     * 设置其他无效原因
     *
     * @param invAliDRea 其他无效原因
     */
    public void setInvAliDRea(String invAliDRea) {
        this.invAliDRea = invAliDRea;
    }

    /**
     * 获取设置人
     *
     * @return SetName - 设置人
     */
    public String getSetName() {
        return setName;
    }

    /**
     * 设置设置人
     *
     * @param setName 设置人
     */
    public void setSetName(String setName) {
        this.setName = setName;
    }

    /**
     * 获取设置日期
     *
     * @return SetDate - 设置日期
     */
    public Date getSetDate() {
        return setDate;
    }

    /**
     * 设置设置日期
     *
     * @param setDate 设置日期
     */
    public void setSetDate(Date setDate) {
        this.setDate = setDate;
    }

    /**
     * 获取审核人
     *
     * @return AuditName - 审核人
     */
    public String getAuditName() {
        return auditName;
    }

    /**
     * 设置审核人
     *
     * @param auditName 审核人
     */
    public void setAuditName(String auditName) {
        this.auditName = auditName;
    }

    /**
     * 获取审核日期
     *
     * @return AuditDate - 审核日期
     */
    public Date getAuditDate() {
        return auditDate;
    }

    /**
     * 设置审核日期
     *
     * @param auditDate 审核日期
     */
    public void setAuditDate(Date auditDate) {
        this.auditDate = auditDate;
    }

    /**
     * 获取审核结果:0:待审核,1:已审核,2:审核通不过
     *
     * @return AuditState - 审核结果:0:待审核,1:已审核,2:审核通不过
     */
    public String getAuditState() {
        return auditState;
    }

    /**
     * 设置审核结果:0:待审核,1:已审核,2:审核通不过
     *
     * @param auditState 审核结果:0:待审核,1:已审核,2:审核通不过
     */
    public void setAuditState(String auditState) {
        this.auditState = auditState;
    }

    /**
     * 获取审核意见
     *
     * @return AuditOpin - 审核意见
     */
    public String getAuditOpin() {
        return auditOpin;
    }

    /**
     * 设置审核意见
     *
     * @param auditOpin 审核意见
     */
    public void setAuditOpin(String auditOpin) {
        this.auditOpin = auditOpin;
    }

    /**
     * 获取状态:1有效,0:无效
     *
     * @return LicState - 状态:1有效,0:无效
     */
    public String getLicState() {
        return licState;
    }

    /**
     * 设置状态:1有效,0:无效
     *
     * @param licState 状态:1有效,0:无效
     */
    public void setLicState(String licState) {
        this.licState = licState;
    }

    /**
     * 获取录入部门
     *
     * @return SetDeptname - 录入部门
     */
    public String getSetDeptname() {
        return setDeptname;
    }

    /**
     * 设置录入部门
     *
     * @param setDeptname 录入部门
     */
    public void setSetDeptname(String setDeptname) {
        this.setDeptname = setDeptname;
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

    /**
     * 获取许可内容
     *
     * @return LicScope - 许可内容
     */
    public String getLicScope() {
        return licScope;
    }

    /**
     * 设置许可内容
     *
     * @param licScope 许可内容
     */
    public void setLicScope(String licScope) {
        this.licScope = licScope;
    }

    /**
     * 获取注销原因
     *
     * @return CanRea - 注销原因
     */
    public String getCanRea() {
        return canRea;
    }

    /**
     * 设置注销原因
     *
     * @param canRea 注销原因
     */
    public void setCanRea(String canRea) {
        this.canRea = canRea;
    }

    /**
     * 获取被吊销原因
     *
     * @return RevRea - 被吊销原因
     */
    public String getRevRea() {
        return revRea;
    }

    /**
     * 设置被吊销原因
     *
     * @param revRea 被吊销原因
     */
    public void setRevRea(String revRea) {
        this.revRea = revRea;
    }

	public String getIsExpire() {
		return isExpire;
	}

	public void setIsExpire(String isExpire) {
		this.isExpire = isExpire;
	}
    
//    /**
//     * 是否到期
//     *@author chenyu
//     * @param revRea 被吊销原因
//     */
//    public String getIsExpire() {
//		if(this.getLicValTo().compareTo(new Date())<0)
//			return "是";
//		return "否";
//	}

//	public void setIsExpire(String isExpire) {
//		this.isExpire = isExpire;
//	}

}