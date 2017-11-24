/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.sment.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.icinfo.framework.mybatis.mapper.annotation.Before;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * 描述:   小微企业培育档案库 sm_bus_entarchives_his 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年05月04日
 */
@Table(name = "sm_bus_entarchives_his")
public class EntarchivesHis implements Serializable {
    @Id
    @Column(name = "id")
    private Integer id;

    /**
     * uuid
     */
    @Column(name = "UID")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    private String UID;

    /**
     * 主体身份代码(CA14)
     */
    @Column(name = "PriPID")
    private String priPID;

    /**
     * 企业负责人
     */
    @Column(name = "EntPrincipal")
    private String entPrincipal;

    /**
     * 企业负责人电话
     */
    @Column(name = "EntPrincipalTel")
    private String entPrincipalTel;

    /**
     * 企业联络人
     */
    @Column(name = "EntContact")
    private String entContact;

    /**
     * 企业联络人电话
     */
    @Column(name = "EntContactTel")
    private String entContactTel;

    /**
     * 培育类型 1 初创型 2 成长型 3 领军型
     */
    @Column(name = "CultivationTypeCode")
    private String cultivationTypeCode;

    /**
     * 培育类型名称
     */
    @Column(name = "CultivationTypeName")
    private String cultivationTypeName;

    /**
     * 产业类型 1 信息 2 环保 3 健康 4 旅游 5 时尚 6 金融 7 高端装备制造 8 文化创意产业
     */
    @Column(name = "IndustryType")
    private String industryType;

    /**
     * 产业类型名称
     */
    @Column(name = "IndustryName")
    private String industryName;

    /**
     * 特色小镇
     */
    @Column(name = "Tsxz")
    private String tsxz;

    /**
     * 众创空间
     */
    @Column(name = "Zckj")
    private String zckj;

    /**
     * 科技孵化园
     */
    @Column(name = "Kjfhy")
    private String kjfhy;

    /**
     * 跨境电商园区
     */
    @Column(name = "Kjdsy")
    private String kjdsy;

    /**
     * 小微企业园区
     */
    @Column(name = "Xwqyy")
    private String            xwqyy;
    
    /**
     * 其他
     */
    @Column(name = "Qt")
    private String qt;

    /**
     * 创业人群 1 大学生 2 高校、科研院所科技人员  3 海外高层次人才 4 其他
     */
    @Column(name = "EntCrowdCode")
    private String entCrowdCode;

    /**
     * 创业人群名称，多个逗号分隔
     */
    @Column(name = "EntCrowdName")
    private String entCrowdName;

    /**
     * 创业人群文本
     */
    @Column(name = "EntCrowdText")
    private String entCrowdText;

    /**
     * 帮扶状态 1：无需求 2：未帮扶 3：部分帮扶 4：已帮扶
     */
    @Column(name = "HelpState")
    private String helpState;

    /**
     * 帮扶需求数量
     */
    @Column(name = "HelpNum")
    private Integer helpNum;

    /**
     * 设置部门code
     */
    @Column(name = "SetDeptCode")
    private String setDeptCode;

    /**
     * 移除类型code 1 企业注销 2 升规 3 不符合培育库要求
     */
    @Column(name = "RemoveTypeCode")
    private String removeTypeCode;

    /**
     * 移除类型名称
     */
    @Column(name = "RemoveTypeName")
    private String removeTypeName;

    /**
     * 移除时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    @Column(name = "RemoveTime")
    private Date removeTime;

    /**
     * 时间戳
     */
    @Column(name = "CreateTime")
    private Date createTime;

    @Column(name = "UpdateTime")
    private Date updateTime;
    
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
     * 获取uuid
     *
     * @return UID - uuid
     */
    public String getUID() {
        return UID;
    }

    /**
     * 设置uuid
     *
     * @param UID uuid
     */
    public void setUID(String UID) {
        this.UID = UID;
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
     * 获取企业负责人
     *
     * @return EntPrincipal - 企业负责人
     */
    public String getEntPrincipal() {
        return entPrincipal;
    }

    /**
     * 设置企业负责人
     *
     * @param entPrincipal 企业负责人
     */
    public void setEntPrincipal(String entPrincipal) {
        this.entPrincipal = entPrincipal;
    }

    /**
     * 获取企业负责人电话
     *
     * @return EntPrincipalTel - 企业负责人电话
     */
    public String getEntPrincipalTel() {
        return entPrincipalTel;
    }

    /**
     * 设置企业负责人电话
     *
     * @param entPrincipalTel 企业负责人电话
     */
    public void setEntPrincipalTel(String entPrincipalTel) {
        this.entPrincipalTel = entPrincipalTel;
    }

    /**
     * 获取企业联络人
     *
     * @return EntContact - 企业联络人
     */
    public String getEntContact() {
        return entContact;
    }

    /**
     * 设置企业联络人
     *
     * @param entContact 企业联络人
     */
    public void setEntContact(String entContact) {
        this.entContact = entContact;
    }

    /**
     * 获取企业联络人电话
     *
     * @return EntContactTel - 企业联络人电话
     */
    public String getEntContactTel() {
        return entContactTel;
    }

    /**
     * 设置企业联络人电话
     *
     * @param entContactTel 企业联络人电话
     */
    public void setEntContactTel(String entContactTel) {
        this.entContactTel = entContactTel;
    }

    /**
     * 获取培育类型 1 初创型 2 成长型 3 领军型
     *
     * @return CultivationTypeCode - 培育类型 1 初创型 2 成长型 3 领军型
     */
    public String getCultivationTypeCode() {
        return cultivationTypeCode;
    }

    /**
     * 设置培育类型 1 初创型 2 成长型 3 领军型
     *
     * @param cultivationTypeCode 培育类型 1 初创型 2 成长型 3 领军型
     */
    public void setCultivationTypeCode(String cultivationTypeCode) {
        this.cultivationTypeCode = cultivationTypeCode;
    }

    /**
     * 获取培育类型名称
     *
     * @return CultivationTypeName - 培育类型名称
     */
    public String getCultivationTypeName() {
        return cultivationTypeName;
    }

    /**
     * 设置培育类型名称
     *
     * @param cultivationTypeName 培育类型名称
     */
    public void setCultivationTypeName(String cultivationTypeName) {
        this.cultivationTypeName = cultivationTypeName;
    }

    /**
     * 获取产业类型 1 信息 2 环保 3 健康 4 旅游 5 时尚 6 金融 7 高端装备制造 8 文化创意产业
     *
     * @return IndustryType - 产业类型 1 信息 2 环保 3 健康 4 旅游 5 时尚 6 金融 7 高端装备制造 8 文化创意产业
     */
    public String getIndustryType() {
        return industryType;
    }

    /**
     * 设置产业类型 1 信息 2 环保 3 健康 4 旅游 5 时尚 6 金融 7 高端装备制造 8 文化创意产业
     *
     * @param industryType 产业类型 1 信息 2 环保 3 健康 4 旅游 5 时尚 6 金融 7 高端装备制造 8 文化创意产业
     */
    public void setIndustryType(String industryType) {
        this.industryType = industryType;
    }

    /**
     * 获取产业类型名称
     *
     * @return IndustryName - 产业类型名称
     */
    public String getIndustryName() {
        return industryName;
    }

    /**
     * 设置产业类型名称
     *
     * @param industryName 产业类型名称
     */
    public void setIndustryName(String industryName) {
        this.industryName = industryName;
    }

    /**
     * 获取特色小镇
     *
     * @return Tsxz - 特色小镇
     */
    public String getTsxz() {
        return tsxz;
    }

    /**
     * 设置特色小镇
     *
     * @param tsxz 特色小镇
     */
    public void setTsxz(String tsxz) {
        this.tsxz = tsxz;
    }

    /**
     * 获取众创空间
     *
     * @return Zckj - 众创空间
     */
    public String getZckj() {
        return zckj;
    }

    /**
     * 设置众创空间
     *
     * @param zckj 众创空间
     */
    public void setZckj(String zckj) {
        this.zckj = zckj;
    }

    /**
     * 获取科技孵化园
     *
     * @return Kjfhy - 科技孵化园
     */
    public String getKjfhy() {
        return kjfhy;
    }

    /**
     * 设置科技孵化园
     *
     * @param kjfhy 科技孵化园
     */
    public void setKjfhy(String kjfhy) {
        this.kjfhy = kjfhy;
    }

    /**
     * 获取跨境电商园区
     *
     * @return Kjdsy - 跨境电商园区
     */
    public String getKjdsy() {
        return kjdsy;
    }

    /**
     * 设置跨境电商园区
     *
     * @param kjdsy 跨境电商园区
     */
    public void setKjdsy(String kjdsy) {
        this.kjdsy = kjdsy;
    }

    /**
     * 获取其他
     *
     * @return Qt - 其他
     */
    public String getQt() {
        return qt;
    }

    /**
     * 设置其他
     *
     * @param qt 其他
     */
    public void setQt(String qt) {
        this.qt = qt;
    }

    /**
     * 获取创业人群 1 大学生 2 高校、科研院所科技人员  3 海外高层次人才 4 其他
     *
     * @return EntCrowdCode - 创业人群 1 大学生 2 高校、科研院所科技人员  3 海外高层次人才 4 其他
     */
    public String getEntCrowdCode() {
        return entCrowdCode;
    }

    /**
     * 设置创业人群 1 大学生 2 高校、科研院所科技人员  3 海外高层次人才 4 其他
     *
     * @param entCrowdCode 创业人群 1 大学生 2 高校、科研院所科技人员  3 海外高层次人才 4 其他
     */
    public void setEntCrowdCode(String entCrowdCode) {
        this.entCrowdCode = entCrowdCode;
    }

    /**
     * 获取创业人群名称，多个逗号分隔
     *
     * @return EntCrowdName - 创业人群名称，多个逗号分隔
     */
    public String getEntCrowdName() {
        return entCrowdName;
    }

    /**
     * 设置创业人群名称，多个逗号分隔
     *
     * @param entCrowdName 创业人群名称，多个逗号分隔
     */
    public void setEntCrowdName(String entCrowdName) {
        this.entCrowdName = entCrowdName;
    }

    /**
     * 获取创业人群文本
     *
     * @return EntCrowdText - 创业人群文本
     */
    public String getEntCrowdText() {
        return entCrowdText;
    }

    /**
     * 设置创业人群文本
     *
     * @param entCrowdText 创业人群文本
     */
    public void setEntCrowdText(String entCrowdText) {
        this.entCrowdText = entCrowdText;
    }

    /**
     * 获取帮扶状态 1：无需求 2：未帮扶 3：部分帮扶 4：已帮扶
     *
     * @return HelpState - 帮扶状态 1：无需求 2：未帮扶 3：部分帮扶 4：已帮扶
     */
    public String getHelpState() {
        return helpState;
    }

    /**
     * 设置帮扶状态 1：无需求 2：未帮扶 3：部分帮扶 4：已帮扶
     *
     * @param helpState 帮扶状态 1：无需求 2：未帮扶 3：部分帮扶 4：已帮扶
     */
    public void setHelpState(String helpState) {
        this.helpState = helpState;
    }

    /**
     * 获取帮扶需求数量
     *
     * @return HelpNum - 帮扶需求数量
     */
    public Integer getHelpNum() {
        return helpNum;
    }

    /**
     * 设置帮扶需求数量
     *
     * @param helpNum 帮扶需求数量
     */
    public void setHelpNum(Integer helpNum) {
        this.helpNum = helpNum;
    }

    /**
     * 获取设置部门code
     *
     * @return SetDeptCode - 设置部门code
     */
    public String getSetDeptCode() {
        return setDeptCode;
    }

    /**
     * 设置设置部门code
     *
     * @param setDeptCode 设置部门code
     */
    public void setSetDeptCode(String setDeptCode) {
        this.setDeptCode = setDeptCode;
    }

    /**
     * 获取移除类型code 1 企业注销 2 升规 3 不符合培育库要求
     *
     * @return RemoveTypeCode - 移除类型code 1 企业注销 2 升规 3 不符合培育库要求
     */
    public String getRemoveTypeCode() {
        return removeTypeCode;
    }

    /**
     * 设置移除类型code 1 企业注销 2 升规 3 不符合培育库要求
     *
     * @param removeTypeCode 移除类型code 1 企业注销 2 升规 3 不符合培育库要求
     */
    public void setRemoveTypeCode(String removeTypeCode) {
        this.removeTypeCode = removeTypeCode;
    }

    /**
     * 获取移除类型名称
     *
     * @return RemoveTypeName - 移除类型名称
     */
    public String getRemoveTypeName() {
        return removeTypeName;
    }

    /**
     * 设置移除类型名称
     *
     * @param removeTypeName 移除类型名称
     */
    public void setRemoveTypeName(String removeTypeName) {
        this.removeTypeName = removeTypeName;
    }

    /**
     * 获取移除时间
     *
     * @return RemoveTime - 移除时间
     */
    public Date getRemoveTime() {
        return removeTime;
    }

    /**
     * 设置移除时间
     *
     * @param removeTime 移除时间
     */
    public void setRemoveTime(Date removeTime) {
        this.removeTime = removeTime;
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
     * @return UpdateTime
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
    
    public void setXwqyy(String xwqyy) {
		this.xwqyy = xwqyy;
	}
    public String getXwqyy() {
		return xwqyy;
	}

    
}