/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.yr.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 描述:    cs_pub_otherpunish_alter 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2016年10月18日
 */
@Table(name = "cs_pub_otherpunish_alter")
public class PubOtherPunishAlter implements Serializable {
    @Column(name = "id")
    private Integer id;

    @Column(name = "CaseNO")
    private String caseNO;

    /**
     * 主体身份代码
     */
    @Column(name = "PriPID")
    private String priPID;

    /**
     * 年度
     */
    @Column(name = "Year")
    private Integer year;

    /**
     * 处罚变更日期
     */
    @Column(name = "AltDate")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date altDate;

    /**
     * 处罚变更机关
     */
    @Column(name = "JudAuth")
    private String judAuth;

    /**
     * 修改纪录号
     */
    @Column(name = "HisNO")
    private String hisNO;

    /**
     * 时间戳
     */
    @Column(name = "CreateTime")
    private Date createTime;

    /**
     * 变更内容
     */
    @Column(name = "contents")
    private String contents;

    /**
     * 备注
     */
    @Column(name = "Remark")
    private String remark;

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
     * 获取年度
     *
     * @return Year - 年度
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
     * 获取处罚变更日期
     *
     * @return AltDate - 处罚变更日期
     */
    public Date getAltDate() {
        return altDate;
    }

    /**
     * 设置处罚变更日期
     *
     * @param altDate 处罚变更日期
     */
    public void setAltDate(Date altDate) {
        this.altDate = altDate;
    }

    /**
     * 获取处罚变更机关
     *
     * @return JudAuth - 处罚变更机关
     */
    public String getJudAuth() {
        return judAuth;
    }

    /**
     * 设置处罚变更机关
     *
     * @param judAuth 处罚变更机关
     */
    public void setJudAuth(String judAuth) {
        this.judAuth = judAuth;
    }

    /**
     * 获取修改纪录号
     *
     * @return HisNO - 修改纪录号
     */
    public String getHisNO() {
        return hisNO;
    }

    /**
     * 设置修改纪录号
     *
     * @param hisNO 修改纪录号
     */
    public void setHisNO(String hisNO) {
        this.hisNO = hisNO;
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
     * 获取变更内容
     *
     * @return contents - 变更内容
     */
    public String getContents() {
        return contents;
    }

    /**
     * 设置变更内容
     *
     * @param contents 变更内容
     */
    public void setContents(String contents) {
        this.contents = contents;
    }

    /**
     * 获取备注
     *
     * @return Remark - 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注
     *
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }
}