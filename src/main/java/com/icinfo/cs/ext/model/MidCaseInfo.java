/**
 * Copyright? 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.ext.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.icinfo.framework.mybatis.mapper.annotation.Before;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

/**
 * 描述:    cs_mid_caseinfo 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2016年10月27日
 */
@Table(name = "cs_mid_caseinfo")
public class MidCaseInfo implements Serializable {
    @Id
    @Column(name = "id")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    private Integer id;

    @Column(name = "CaseNO")
    private String caseNO;

    @Column(name = "PriPID")
    private String priPID;

    @Column(name = "SetTime")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date setTime;

    @Column(name = "SetDeptname")
    private String setDeptname;

    @Column(name = "CaseType")
    private String caseType;

    @Column(name = "AuditName")
    private String auditName;

    @Column(name = "AuditDate")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date auditDate;

    @Column(name = "AuditState")
    private String auditState;

    @Column(name = "AudSug")
    private String audSug;

    @Column(name = "PenDecNo")
    private String penDecNo;

    @Column(name = "PenType")
    private String penType;

    @Column(name = "PenAm")
    private BigDecimal penAm;

    @Column(name = "ForfAm")
    private BigDecimal forfAm;

    @Column(name = "PenAuth")
    private String penAuth;

    @Column(name = "PenDecIssDate")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date penDecIssDate;

    @Column(name = "UnitName")
    private String unitName;

    @Column(name = "RegNO")
    private String regNO;

    @Column(name = "LeRep")
    private String leRep;

    @Column(name = "CreateTime")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date createTime;

    @Column(name = "update_time")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date update_time;

    @Column(name = "delflag")
    private Boolean delflag;

    /**
     * 设置人员
     */
    @Column(name = "SetName")
    private String setName;

    @Column(name = "IllegActType")
    private String illegActType;

    @Column(name = "PenContent")
    private String penContent;

    @Column(name = "PunDecDoc")
    private String punDecDoc;

    @Column(name = "AudSugDesc")
    private String audSugDesc;

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
     * @return CaseNO
     */
    public String getCaseNO() {
        return caseNO;
    }

    /**
     * @param caseNO
     */
    public void setCaseNO(String caseNO) {
        this.caseNO = caseNO;
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
     * @return CaseType
     */
    public String getCaseType() {
        return caseType;
    }

    /**
     * @param caseType
     */
    public void setCaseType(String caseType) {
        this.caseType = caseType;
    }

    /**
     * @return AuditName
     */
    public String getAuditName() {
        return auditName;
    }

    /**
     * @param auditName
     */
    public void setAuditName(String auditName) {
        this.auditName = auditName;
    }

    /**
     * @return AuditDate
     */
    public Date getAuditDate() {
        return auditDate;
    }

    /**
     * @param auditDate
     */
    public void setAuditDate(Date auditDate) {
        this.auditDate = auditDate;
    }

    /**
     * @return AuditState
     */
    public String getAuditState() {
        return auditState;
    }

    /**
     * @param auditState
     */
    public void setAuditState(String auditState) {
        this.auditState = auditState;
    }

    /**
     * @return AudSug
     */
    public String getAudSug() {
        return audSug;
    }

    /**
     * @param audSug
     */
    public void setAudSug(String audSug) {
        this.audSug = audSug;
    }

    /**
     * @return PenDecNo
     */
    public String getPenDecNo() {
        return penDecNo;
    }

    /**
     * @param penDecNo
     */
    public void setPenDecNo(String penDecNo) {
        this.penDecNo = penDecNo;
    }

    /**
     * @return PenType
     */
    public String getPenType() {
        return penType;
    }

    /**
     * @param penType
     */
    public void setPenType(String penType) {
        this.penType = penType;
    }

    /**
     * @return PenAm
     */
    public BigDecimal getPenAm() {
        return penAm;
    }

    /**
     * @param penAm
     */
    public void setPenAm(BigDecimal penAm) {
        this.penAm = penAm;
    }

    /**
     * @return ForfAm
     */
    public BigDecimal getForfAm() {
        return forfAm;
    }

    /**
     * @param forfAm
     */
    public void setForfAm(BigDecimal forfAm) {
        this.forfAm = forfAm;
    }

    /**
     * @return PenAuth
     */
    public String getPenAuth() {
        return penAuth;
    }

    /**
     * @param penAuth
     */
    public void setPenAuth(String penAuth) {
        this.penAuth = penAuth;
    }

    /**
     * @return PenDecIssDate
     */
    public Date getPenDecIssDate() {
        return penDecIssDate;
    }

    /**
     * @param penDecIssDate
     */
    public void setPenDecIssDate(Date penDecIssDate) {
        this.penDecIssDate = penDecIssDate;
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
     * @return update_time
     */
    public Date getUpdate_time() {
        return update_time;
    }

    /**
     * @param update_time
     */
    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    /**
     * @return delflag
     */
    public Boolean getDelflag() {
        return delflag;
    }

    /**
     * @param delflag
     */
    public void setDelflag(Boolean delflag) {
        this.delflag = delflag;
    }

    /**
     * 获取设置人员
     *
     * @return SetName - 设置人员
     */
    public String getSetName() {
        return setName;
    }

    /**
     * 设置设置人员
     *
     * @param setName 设置人员
     */
    public void setSetName(String setName) {
        this.setName = setName;
    }

    /**
     * @return IllegActType
     */
    public String getIllegActType() {
        return illegActType;
    }

    /**
     * @param illegActType
     */
    public void setIllegActType(String illegActType) {
        this.illegActType = illegActType;
    }

    /**
     * @return PenContent
     */
    public String getPenContent() {
        return penContent;
    }

    /**
     * @param penContent
     */
    public void setPenContent(String penContent) {
        this.penContent = penContent;
    }
 
    /**
     * @return PunDecDoc
     */
    public String getPunDecDoc() {
        return punDecDoc;
    }

    /**
     * @param punDecDoc
     */
    public void setPunDecDoc(String punDecDoc) {
        this.punDecDoc = punDecDoc;
    }

    /**
     * @return AudSugDesc
     */
    public String getAudSugDesc() {
        return audSugDesc;
    }

    /**
     * @param audSugDesc
     */
    public void setAudSugDesc(String audSugDesc) {
        this.audSugDesc = audSugDesc;
    }
    
   
}