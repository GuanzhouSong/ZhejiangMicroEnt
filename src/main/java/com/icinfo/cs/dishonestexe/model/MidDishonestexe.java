/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.dishonestexe.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.icinfo.framework.mybatis.mapper.annotation.Before;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/** 
 * 描述: 失信被执行人信息-model
 * @author 张文男
 * @date 2017年3月17日  
 */
@Table(name = "cs_mid_dishonestexe")
public class MidDishonestexe implements Serializable {
    @Id
    @Column(name = "id")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    private Integer id;

    @Column(name = "InfoActionType")
    private String infoActionType;

    @Column(name = "LaoLaiID")
    private String laoLaiID;

    @Column(name = "CaseCode")
    private String caseCode;

    @Column(name = "IName")
    private String IName;

    @Column(name = "SexName")
    private String sexName;

    @Column(name = "Age")
    private Integer age;

    @Column(name = "CardNum")
    private String cardNum;

    @Column(name = "BuesinessEntity")
    private String buesinessEntity;

    @Column(name = "CourtName")
    private String courtName;

    @Column(name = "AreaID")
    private String areaID;

    @Column(name = "AreaName")
    private String areaName;

    @Column(name = "PartyTypeName")
    private String partyTypeName;

    @Column(name = "GistCID")
    private String gistCID;

    @Column(name = "GistUnit")
    private String gistUnit;

    @Column(name = "PublishDate")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date publishDate;

    @Column(name = "CreateTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;

    @Column(name = "UID")
    private String UID;

    @Column(name = "IsValid")
    private String isValid;

    @Column(name = "update_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date update_time;

    @Column(name = "delflag")
    private Boolean delflag;

    @Column(name = "Duty")
    private String duty;

    @Column(name = "Performance")
    private String performance;

    @Column(name = "DisReputTypeName")
    private String disReputTypeName;

    @Column(name = "PerformedPart")
    private String performedPart;

    @Column(name = "UnperformPart")
    private String unperformPart;

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
     * @return InfoActionType
     */
    public String getInfoActionType() {
        return infoActionType;
    }

    /**
     * @param infoActionType
     */
    public void setInfoActionType(String infoActionType) {
        this.infoActionType = infoActionType;
    }

    /**
     * @return LaoLaiID
     */
    public String getLaoLaiID() {
        return laoLaiID;
    }

    /**
     * @param laoLaiID
     */
    public void setLaoLaiID(String laoLaiID) {
        this.laoLaiID = laoLaiID;
    }

    /**
     * @return CaseCode
     */
    public String getCaseCode() {
        return caseCode;
    }

    /**
     * @param caseCode
     */
    public void setCaseCode(String caseCode) {
        this.caseCode = caseCode;
    }

    /**
     * @return IName
     */
    public String getIName() {
        return IName;
    }

    /**
     * @param IName
     */
    public void setIName(String IName) {
        this.IName = IName;
    }

    /**
     * @return SexName
     */
    public String getSexName() {
        return sexName;
    }

    /**
     * @param sexName
     */
    public void setSexName(String sexName) {
        this.sexName = sexName;
    }

    /**
     * @return Age
     */
    public Integer getAge() {
        return age;
    }

    /**
     * @param age
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * @return CardNum
     */
    public String getCardNum() {
        return cardNum;
    }

    /**
     * @param cardNum
     */
    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    /**
     * @return BuesinessEntity
     */
    public String getBuesinessEntity() {
        return buesinessEntity;
    }

    /**
     * @param buesinessEntity
     */
    public void setBuesinessEntity(String buesinessEntity) {
        this.buesinessEntity = buesinessEntity;
    }

    /**
     * @return CourtName
     */
    public String getCourtName() {
        return courtName;
    }

    /**
     * @param courtName
     */
    public void setCourtName(String courtName) {
        this.courtName = courtName;
    }

    /**
     * @return AreaID
     */
    public String getAreaID() {
        return areaID;
    }

    /**
     * @param areaID
     */
    public void setAreaID(String areaID) {
        this.areaID = areaID;
    }

    /**
     * @return AreaName
     */
    public String getAreaName() {
        return areaName;
    }

    /**
     * @param areaName
     */
    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    /**
     * @return PartyTypeName
     */
    public String getPartyTypeName() {
        return partyTypeName;
    }

    /**
     * @param partyTypeName
     */
    public void setPartyTypeName(String partyTypeName) {
        this.partyTypeName = partyTypeName;
    }

    /**
     * @return GistCID
     */
    public String getGistCID() {
        return gistCID;
    }

    /**
     * @param gistCID
     */
    public void setGistCID(String gistCID) {
        this.gistCID = gistCID;
    }

    /**
     * @return GistUnit
     */
    public String getGistUnit() {
        return gistUnit;
    }

    /**
     * @param gistUnit
     */
    public void setGistUnit(String gistUnit) {
        this.gistUnit = gistUnit;
    }

    /**
     * @return PublishDate
     */
    public Date getPublishDate() {
        return publishDate;
    }

    /**
     * @param publishDate
     */
    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
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
     * @return Duty
     */
    public String getDuty() {
        return duty;
    }

    /**
     * @param duty
     */
    public void setDuty(String duty) {
        this.duty = duty;
    }

    /**
     * @return Performance
     */
    public String getPerformance() {
        return performance;
    }

    /**
     * @param performance
     */
    public void setPerformance(String performance) {
        this.performance = performance;
    }

    /**
     * @return DisReputTypeName
     */
    public String getDisReputTypeName() {
        return disReputTypeName;
    }

    /**
     * @param disReputTypeName
     */
    public void setDisReputTypeName(String disReputTypeName) {
        this.disReputTypeName = disReputTypeName;
    }

    /**
     * @return PerformedPart
     */
    public String getPerformedPart() {
        return performedPart;
    }

    /**
     * @param performedPart
     */
    public void setPerformedPart(String performedPart) {
        this.performedPart = performedPart;
    }

    /**
     * @return UnperformPart
     */
    public String getUnperformPart() {
        return unperformPart;
    }

    /**
     * @param unperformPart
     */
    public void setUnperformPart(String unperformPart) {
        this.unperformPart = unperformPart;
    }
}