/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.yr.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.icinfo.framework.mybatis.mapper.annotation.Before;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * 描述:    cs_mod_application 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2016年09月11日
 */
@Table(name = "cs_mod_application")
public class ModApplication implements Serializable {
    /**
     * 自增ID
     */
    @Id
    @Column(name = "id")
    private Integer id;

    /**
     * 主体身份代码
     */
    @Column(name = "PriPID")
    private String priPID;

    /**
     * 时间戳
     */
    @Column(name = "CreateTime")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date createTime;

    /**
     * 唯一标识
     */
    @Column(name = "UID")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    private String UID;

    /**
     * 统一社会信用代码
     */
    @Column(name = "Unicode")
    private String unicode;

    /**
     * 企业名称
     */
    @Column(name = "EntName")
    private String entName;

    /**
     * 年报年份
     */
    @Column(name = "Year")
    private Integer year;

    /**
     * 提交原因
     */
    @Column(name = "ModReason")
    private String modReason;

    /**
     * 0:待审核，1：同意，2：不同意
     */
    @Column(name = "ModResult")
    private String modResult;

    /**
     * 审核理由
     */
    @Column(name = "ModDescription")
    private String modDescription;

    /**
     * 提交日期
     */
    @Column(name = "ModSubmitDate")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date modSubmitDate;

    /**
     * 审核人员
     */
    @Column(name = "AudName")
    private String audName;

    /**
     * 审核日期
     */
    @Column(name = "AudDate")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date audDate;

    /**
     * 资料已重新提交，记录失效为1，未失效为0
     */
    @Column(name = "ModResubmit")
    private String modResubmit;


    private static final long serialVersionUID = 1L;

    /**
     * 获取自增ID
     *
     * @return id - 自增ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置自增ID
     *
     * @param id 自增ID
     */
    public void setId(Integer id) {
        this.id = id;
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
     * 获取唯一标识
     *
     * @return UID - 唯一标识
     */
    public String getUID() {
        return UID;
    }

    /**
     * 设置唯一标识
     *
     * @param UID 唯一标识
     */
    public void setUID(String UID) {
        this.UID = UID;
    }

    /**
     * 获取统一社会信用代码
     *
     * @return Unicode - 统一社会信用代码
     */
    public String getUnicode() {
        return unicode;
    }

    /**
     * 设置统一社会信用代码
     *
     * @param unicode 统一社会信用代码
     */
    public void setUnicode(String unicode) {
        this.unicode = unicode;
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
     * 获取年报年份
     *
     * @return Year - 年报年份
     */
    public Integer getYear() {
        return year;
    }

    /**
     * 设置年报年份
     *
     * @param year 年报年份
     */
    public void setYear(Integer year) {
        this.year = year;
    }

    /**
     * 获取提交原因
     *
     * @return ModReason - 提交原因
     */
    public String getModReason() {
        return modReason;
    }

    /**
     * 设置提交原因
     *
     * @param modReason 提交原因
     */
    public void setModReason(String modReason) {
        this.modReason = modReason;
    }

    /**
     * 获取0:待审核，1：同意，2：不同意
     *
     * @return ModResult - 0:待审核，1：同意，2：不同意
     */
    public String getModResult() {
        return modResult;
    }

    /**
     * 设置0:待审核，1：同意，2：不同意
     *
     * @param modResult 0:待审核，1：同意，2：不同意
     */
    public void setModResult(String modResult) {
        this.modResult = modResult;
    }

    /**
     * 获取审核理由
     *
     * @return ModDescription - 审核理由
     */
    public String getModDescription() {
        return modDescription;
    }

    /**
     * 设置审核理由
     *
     * @param modDescription 审核理由
     */
    public void setModDescription(String modDescription) {
        this.modDescription = modDescription;
    }

    /**
     * 获取提交日期
     *
     * @return ModSubmitDate - 提交日期
     */
    public Date getModSubmitDate() {
        return modSubmitDate;
    }

    /**
     * 设置提交日期
     *
     * @param modSubmitDate 提交日期
     */
    public void setModSubmitDate(Date modSubmitDate) {
        this.modSubmitDate = modSubmitDate;
    }

    /**
     * 获取审核人员
     *
     * @return AudName - 审核人员
     */
    public String getAudName() {
        return audName;
    }

    /**
     * 设置审核人员
     *
     * @param audName 审核人员
     */
    public void setAudName(String audName) {
        this.audName = audName;
    }

    /**
     * 获取审核日期
     *
     * @return AudDate - 审核日期
     */
    public Date getAudDate() {
        return audDate;
    }

    /**
     * 设置审核日期
     *
     * @param audDate 审核日期
     */
    public void setAudDate(Date audDate) {
        this.audDate = audDate;
    }

    /**
     * 获取资料已重新提交，记录失效为1，未失效为0
     *
     * @return ModResubmit - 资料已重新提交，记录失效为1，未失效为0
     */
    public String getModResubmit() {
        return modResubmit;
    }

    /**
     * 设置资料已重新提交，记录失效为1，未失效为0
     *
     * @param modResubmit 资料已重新提交，记录失效为1，未失效为0
     */
    public void setModResubmit(String modResubmit) {
        this.modResubmit = modResubmit;
    }
    
    @Override
   	public String toString() {
   		return "ModApplication [id=" + id + ", priPID=" + priPID + ", createTime="
   				+ createTime + ", UID=" + UID + ", unicode="
   				+ unicode + ", entName=" + entName + ", year="
   				+ year + ", modReason=" + modReason + ", modResult=" + modResult
   				+ ", modDescription=" + modDescription + ", modSubmitDate=" + modSubmitDate + ", audName=" + audName 
   				+ ", audDate=" + audDate + ", modResubmit=" + modResubmit + "]";
   	}

}