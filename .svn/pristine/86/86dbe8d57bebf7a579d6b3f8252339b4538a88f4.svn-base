/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.rpt.rptmodel;

import com.icinfo.framework.mybatis.mapper.annotation.Before;

import java.io.Serializable;

import javax.persistence.*;

/**
 * 描述:    cs_rpt_reporteover_list 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年11月15日
 */
@Table(name = "cs_rpt_reporteover_list")
public class RptReporteoverList implements Serializable {
    @Column(name = "PriPID")
    private String priPID;

    @Column(name = "year")
    private Integer year;

    @Column(name = "EntTypeCatg")
    private String entTypeCatg;

    @Column(name = "EntType")
    private String entType;

    @Column(name = "UniCode")
    private String uniCode;

    @Column(name = "RegNO")
    private String regNO;

    @Column(name = "EntName")
    private String entName;

    @Column(name = "LeRep")
    private String leRep;

    @Column(name = "Tel")
    private String tel;

    @Column(name = "LiaName")
    private String liaName;

    @Column(name = "LiaTel")
    private String liaTel;

    @Column(name = "Dom")
    private String dom;

    @Column(name = "RegOrg")
    private String regOrg;

    @Column(name = "RegOrgName")
    private String regOrgName;

    @Column(name = "LocalAdm")
    private String localAdm;

    @Column(name = "LocalAdmName")
    private String localAdmName;
    
    /**
     * 获取年报公示状态（当前年报状态）：
     * 00未公示[未公示]；
     * 10已公示[已公示]；
     * 11已公示[敏感词通过]；
     * 12已公示（内容待审核）[敏感词待审核]；
     * 13已公示（内容审核不通过）[敏感词不通过]；
     * 20待修改[待修改]
     */
    @Column(name = "ReportState")
    private String reportState;

    private static final long serialVersionUID = 1L;

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
     * @return year
     */
    public Integer getYear() {
        return year;
    }

    /**
     * @param year
     */
    public void setYear(Integer year) {
        this.year = year;
    }

    /**
     * @return EntTypeCatg
     */
    public String getEntTypeCatg() {
        return entTypeCatg;
    }

    /**
     * @param entTypeCatg
     */
    public void setEntTypeCatg(String entTypeCatg) {
        this.entTypeCatg = entTypeCatg;
    }

    /**
     * @return EntType
     */
    public String getEntType() {
        return entType;
    }

    /**
     * @param entType
     */
    public void setEntType(String entType) {
        this.entType = entType;
    }

    /**
     * @return UniCode
     */
    public String getUniCode() {
        return uniCode;
    }

    /**
     * @param uniCode
     */
    public void setUniCode(String uniCode) {
        this.uniCode = uniCode;
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
     * @return EntName
     */
    public String getEntName() {
        return entName;
    }

    /**
     * @param entName
     */
    public void setEntName(String entName) {
        this.entName = entName;
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
     * @return Tel
     */
    public String getTel() {
        return tel;
    }

    /**
     * @param tel
     */
    public void setTel(String tel) {
        this.tel = tel;
    }

    /**
     * @return LiaName
     */
    public String getLiaName() {
        return liaName;
    }

    /**
     * @param liaName
     */
    public void setLiaName(String liaName) {
        this.liaName = liaName;
    }

    /**
     * @return LiaTel
     */
    public String getLiaTel() {
        return liaTel;
    }

    /**
     * @param liaTel
     */
    public void setLiaTel(String liaTel) {
        this.liaTel = liaTel;
    }

    /**
     * @return Dom
     */
    public String getDom() {
        return dom;
    }

    /**
     * @param dom
     */
    public void setDom(String dom) {
        this.dom = dom;
    }

    /**
     * @return RegOrg
     */
    public String getRegOrg() {
        return regOrg;
    }

    /**
     * @param regOrg
     */
    public void setRegOrg(String regOrg) {
        this.regOrg = regOrg;
    }

    /**
     * @return RegOrgName
     */
    public String getRegOrgName() {
        return regOrgName;
    }

    /**
     * @param regOrgName
     */
    public void setRegOrgName(String regOrgName) {
        this.regOrgName = regOrgName;
    }

    /**
     * @return LocalAdm
     */
    public String getLocalAdm() {
        return localAdm;
    }

    /**
     * @param localAdm
     */
    public void setLocalAdm(String localAdm) {
        this.localAdm = localAdm;
    }

    /**
     * @return LocalAdmName
     */
    public String getLocalAdmName() {
        return localAdmName;
    }

    /**
     * @param localAdmName
     */
    public void setLocalAdmName(String localAdmName) {
        this.localAdmName = localAdmName;
    }
    
    public void setReportState(String reportState) {
		this.reportState = reportState;
	}
    
    public String getReportState() {
		return reportState;
	}
}