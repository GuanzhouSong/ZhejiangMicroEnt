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
 * 描述:    sm_ent_abovescale 对应的实体类.(规上企业数据目录)<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年07月20日
 */
@Table(name = "sm_ent_abovescale")
public class SmEntAbovescale implements Serializable {
    @Id
    @Column(name = "id")
    private Integer id;

    /**
     * UID
     */
    @Column(name = "UID")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    private String UID;

    /**
     * 组织机构代码
     */
    @Column(name = "Organizecode")
    private String organizecode;

    /**
     * 企业名称（源）
     */
    @Column(name = "EntName")
    private String entName;

    /**
     * 统一社会信用代码（源）
     */
    @Column(name = "UniCode")
    private String uniCode;

    /**
     * 报表类别编码
     */
    @Column(name = "FormType")
    private String formType;

    /**
     * 报表类别中文
     */
    @Column(name = "FormTypeCn")
    private String formTypeCn;

    /**
     * 年度
     */
    @Column(name = "year")
    private Integer year;

    /**
     * 导入批次(年份+(-))
     */
    @Column(name = "ImBatchNum")
    private String imBatchNum;

    /**
     * 主体身份代码
     */
    @Column(name = "Pripid")
    private String pripid;

    /**
     * 匹配后企业名称
     */
    @Column(name = "MatchEntName")
    private String matchEntName;

    /**
     * 匹配后统一社会信用代码
     */
    @Column(name = "MatchUniCode")
    private String matchUniCode;

    /**
     * 匹配后注册号
     */
    @Column(name = "MatchRegNO")
    private String matchRegNO;

    /**
     * 1：是 0：否
     */
    @Column(name = "IsMatch")
    private String isMatch;

    /**
     * 导入人姓名
     */
    @Column(name = "ImportName")
    private String importName;

    /**
     * 导入时间
     */
    @Column(name = "ImportTime")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date importTime;

    /**
     * 更新时间
     */
    @Column(name = "CreateTime")
    private Date createTime;
    
    /**
     * 规上、限上标志:1限上：E和S    2 规上工业：B 3规上服务业：F
     */
    @Column(name = "AboveType")
    private String aboveType;

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
    public String getUID() {
        return UID;
    }

    /**
     * 设置UID
     *
     * @param UID UID
     */
    public void setUID(String UID) {
        this.UID = UID;
    }

    /**
     * 获取组织机构代码
     *
     * @return Organizecode - 组织机构代码
     */
    public String getOrganizecode() {
        return organizecode;
    }

    /**
     * 设置组织机构代码
     *
     * @param organizecode 组织机构代码
     */
    public void setOrganizecode(String organizecode) {
        this.organizecode = organizecode;
    }

    /**
     * 获取企业名称（源）
     *
     * @return EntName - 企业名称（源）
     */
    public String getEntName() {
        return entName;
    }

    /**
     * 设置企业名称（源）
     *
     * @param entName 企业名称（源）
     */
    public void setEntName(String entName) {
        this.entName = entName;
    }

    /**
     * 获取统一社会信用代码（源）
     *
     * @return UniCode - 统一社会信用代码（源）
     */
    public String getUniCode() {
        return uniCode;
    }

    /**
     * 设置统一社会信用代码（源）
     *
     * @param uniCode 统一社会信用代码（源）
     */
    public void setUniCode(String uniCode) {
        this.uniCode = uniCode;
    }

    /**
     * 获取报表类别编码
     *
     * @return FormType - 报表类别编码
     */
    public String getFormType() {
        return formType;
    }

    /**
     * 设置报表类别编码
     *
     * @param formType 报表类别编码
     */
    public void setFormType(String formType) {
        this.formType = formType;
    }

    /**
     * 获取报表类别中文
     *
     * @return FormTypeCn - 报表类别中文
     */
    public String getFormTypeCn() {
        return formTypeCn;
    }

    /**
     * 设置报表类别中文
     *
     * @param formTypeCn 报表类别中文
     */
    public void setFormTypeCn(String formTypeCn) {
        this.formTypeCn = formTypeCn;
    }

    /**
     * 获取年度
     *
     * @return year - 年度
     */
    public Integer getYear() {
        return year;
    }

    /**
     * 设置年度
     *
     * @param year 年度
     */
    public void setYear(Integer year) {
        this.year = year;
    }

    /**
     * 获取导入批次
     *
     * @return ImBatchNum - 导入批次
     */
    public String getImBatchNum() {
        return imBatchNum;
    }

    /**
     * 设置导入批次
     *
     * @param imBatchNum 导入批次
     */
    public void setImBatchNum(String imBatchNum) {
        this.imBatchNum = imBatchNum;
    }

    /**
     * 获取主体身份代码
     *
     * @return Pripid - 主体身份代码
     */
    public String getPripid() {
        return pripid;
    }

    /**
     * 设置主体身份代码
     *
     * @param pripid 主体身份代码
     */
    public void setPripid(String pripid) {
        this.pripid = pripid;
    }

    /**
     * 获取匹配后企业名称
     *
     * @return MatchEntName - 匹配后企业名称
     */
    public String getMatchEntName() {
        return matchEntName;
    }

    /**
     * 设置匹配后企业名称
     *
     * @param matchEntName 匹配后企业名称
     */
    public void setMatchEntName(String matchEntName) {
        this.matchEntName = matchEntName;
    }

    /**
     * 获取匹配后统一社会信用代码
     *
     * @return MatchUniCode - 匹配后统一社会信用代码
     */
    public String getMatchUniCode() {
        return matchUniCode;
    }

    /**
     * 设置匹配后统一社会信用代码
     *
     * @param matchUniCode 匹配后统一社会信用代码
     */
    public void setMatchUniCode(String matchUniCode) {
        this.matchUniCode = matchUniCode;
    }

    /**
     * 获取匹配后注册号
     *
     * @return MatchRegNO - 匹配后注册号
     */
    public String getMatchRegNO() {
        return matchRegNO;
    }

    /**
     * 设置匹配后注册号
     *
     * @param matchRegNO 匹配后注册号
     */
    public void setMatchRegNO(String matchRegNO) {
        this.matchRegNO = matchRegNO;
    }

    /**
     * 获取1：是 2：否
     *
     * @return IsMatch - 1：是 2：否
     */
    public String getIsMatch() {
        return isMatch;
    }

    /**
     * 设置1：是 2：否
     *
     * @param isMatch 1：是 2：否
     */
    public void setIsMatch(String isMatch) {
        this.isMatch = isMatch;
    }

    /**
     * 获取导入人姓名
     *
     * @return ImportName - 导入人姓名
     */
    public String getImportName() {
        return importName;
    }

    /**
     * 设置导入人姓名
     *
     * @param importName 导入人姓名
     */
    public void setImportName(String importName) {
        this.importName = importName;
    }

    /**
     * 获取导入时间
     *
     * @return ImportTime - 导入时间
     */
    public Date getImportTime() {
        return importTime;
    }

    /**
     * 设置导入时间
     *
     * @param importTime 导入时间
     */
    public void setImportTime(Date importTime) {
        this.importTime = importTime;
    }

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	public Date getCreateTime() {
		return createTime;
	}
	
	public void setAboveType(String aboveType) {
		this.aboveType = aboveType;
	}
	public String getAboveType() {
		return aboveType;
	}
}