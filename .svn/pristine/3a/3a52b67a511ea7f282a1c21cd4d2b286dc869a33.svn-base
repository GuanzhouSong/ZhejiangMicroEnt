/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.login.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.icinfo.framework.mybatis.mapper.annotation.Before;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * 描述:    cs_pub_phoneapply 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2016年08月28日
 */
@Table(name = "cs_pub_phoneapply")
public class PubPhoneapply implements Serializable {
    /**
     * id
     */
    @Id
    @Column(name = "id")
    private Integer id;

    /**
     * 主体身份代码
     */
    @Column(name = "PriPID")
    private String pripid;

    /**
     * 企业名称
     */
    @Column(name = "EntName")
    private String entname;

    /**
     * 统一代码/注册号
     */
    @Column(name = "RegNO")
    private String regno;

    /**
     * 法定代表人
     */
    @Column(name = "LeRep")
    private String lerep;

    /**
     * 企业类型
     */
    @Column(name = "EntType")
    private String enttype;

    /**
     * 统一社会信用代码
     */
    @Column(name = "UniCode")
    private String unicode;

    /**
     * 时间戳
     */
    @Column(name = "CreateTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8") 
    private Date createtime;

    /**
     * 法定代表人手机号
     */
    @Column(name = "LeRepPhone")
    private String lerepphone;

    /**
     * 手机号码
     */
    @Column(name = "Tel")
    private String tel;

    /**
     * 流水号：8位时间戳（yyyyMMdd）+2位地区编码+5位随机码
     */
    @Column(name = "PasID")
    private String pasid;

    /**
     * 状态标志 01:已接受，02:申请，03：不接受
     */
    @Column(name = "PasStatus")
    private String passtatus;

    /**
     * 证件号码
     */
    @Column(name = "LiaIDNum")
    private String liaidnum;

    /**
     * 证件类型（联络人）
     */
    @Column(name = "LiaIDType")
    private String liaidtype;

    /**
     * 备案人姓名（联络人）
     */
    @Column(name = "LiaName")
    private String lianame;
    
    /**
     * 法定代表人证件号码
     */
    @Column(name = "CerNO")
    private String cerNO;

    private static final long serialVersionUID = 1L;

    /**
     * 获取id
     *
     * @return id - id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置id
     *
     * @param id id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取主体身份代码
     *
     * @return PriPID - 主体身份代码
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
     * 获取企业名称
     *
     * @return EntName - 企业名称
     */
    public String getEntname() {
        return entname;
    }

    /**
     * 设置企业名称
     *
     * @param entname 企业名称
     */
    public void setEntname(String entname) {
        this.entname = entname;
    }

    /**
     * 获取统一代码/注册号
     *
     * @return RegNO - 统一代码/注册号
     */
    public String getRegno() {
        return regno;
    }

    /**
     * 设置统一代码/注册号
     *
     * @param regno 统一代码/注册号
     */
    public void setRegno(String regno) {
        this.regno = regno;
    }

    /**
     * 获取法定代表人
     *
     * @return LeRep - 法定代表人
     */
    public String getLerep() {
        return lerep;
    }

    /**
     * 设置法定代表人
     *
     * @param lerep 法定代表人
     */
    public void setLerep(String lerep) {
        this.lerep = lerep;
    }

    /**
     * 获取企业类型
     *
     * @return EntType - 企业类型
     */
    public String getEnttype() {
        return enttype;
    }

    /**
     * 设置企业类型
     *
     * @param enttype 企业类型
     */
    public void setEnttype(String enttype) {
        this.enttype = enttype;
    }

    /**
     * 获取统一社会信用代码
     *
     * @return UniCode - 统一社会信用代码
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
     * 获取时间戳
     *
     * @return CreateTime - 时间戳
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * 设置时间戳
     *
     * @param createtime 时间戳
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * 获取法定代表人手机号
     *
     * @return LeRepPhone - 法定代表人手机号
     */
    public String getLerepphone() {
        return lerepphone;
    }

    /**
     * 设置法定代表人手机号
     *
     * @param lerepphone 法定代表人手机号
     */
    public void setLerepphone(String lerepphone) {
        this.lerepphone = lerepphone;
    }

    /**
     * 获取手机号码
     *
     * @return Tel - 手机号码
     */
    public String getTel() {
        return tel;
    }

    /**
     * 设置手机号码
     *
     * @param tel 手机号码
     */
    public void setTel(String tel) {
        this.tel = tel;
    }

    /**
     * @return PasID
     */
    public String getPasid() {
        return pasid;
    }

    /**
     * @param pasid
     */
    public void setPasid(String pasid) {
        this.pasid = pasid;
    }

    /**
     * 获取状态标志 01:已接受，02:申请，03：不接受
     *
     * @return PasStatus - 状态标志 01:已接受，02:申请，03：不接受
     */
    public String getPasstatus() {
        return passtatus;
    }

    /**
     * 设置状态标志 01:已接受，02:申请，03：不接受
     *
     * @param passtatus 状态标志 01:已接受，02:申请，03：不接受
     */
    public void setPasstatus(String passtatus) {
        this.passtatus = passtatus;
    }

    /**
     * 获取证件号码
     *
     * @return LiaIDNum - 证件号码
     */
    public String getLiaidnum() {
        return liaidnum;
    }

    /**
     * 设置证件号码
     *
     * @param liaidnum 证件号码
     */
    public void setLiaidnum(String liaidnum) {
        this.liaidnum = liaidnum;
    }

    /**
     * 获取证件类型（联络人）
     *
     * @return LiaIDType - 证件类型（联络人）
     */
    public String getLiaidtype() {
        return liaidtype;
    }

    /**
     * 设置证件类型（联络人）
     *
     * @param liaidtype 证件类型（联络人）
     */
    public void setLiaidtype(String liaidtype) {
        this.liaidtype = liaidtype;
    }

    /**
     * 获取备案人姓名（联络人）
     *
     * @return LiaName - 备案人姓名（联络人）
     */
    public String getLianame() {
        return lianame;
    }

    /**
     * 设置备案人姓名（联络人）
     *
     * @param lianame 备案人姓名（联络人）
     */
    public void setLianame(String lianame) {
        this.lianame = lianame;
    }

    public void setCerNO(String cerNO) {
		this.cerNO = cerNO;
	}
    public String getCerNO() {
		return cerNO;
	}
}