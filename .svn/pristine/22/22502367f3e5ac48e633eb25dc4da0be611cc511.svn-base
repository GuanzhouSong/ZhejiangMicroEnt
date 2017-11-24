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
 * 描述:    cs_pub_eppassword 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2016年08月28日
 */
@Table(name = "cs_pub_eppassword")
public class PubEppassword implements Serializable {
    /**
     * ID
     */
    @Id
    @Column(name = "id")
    private Integer id;

    /**
     * 受理单位
     */
    @Column(name = "AppReviewOrg")
    private String apprevieworg;

    /**
     * 密码
     */
    @Column(name = "Password")
    private String password;

    /**
     * 手机号码（联络人）
     */
    @Column(name = "Tel")
    private String tel;

    /**
     * 操作人登录名
     */
    @Column(name = "Username")
    private String username;


    /**
     * UID
     */
    @Column(name = "UID")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    private String uid;

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
     * 创建时间
     */
    @Column(name = "ApplyTime")
    private Date applytime;

    /**
     * 企业身份证号
     */
    @Column(name = "LiaIDNum")
    private String liaidnum;

    /**
     * 证件类型(联络人)
     */
    @Column(name = "LiaIDType")
    private String liaidtype;

    /**
     * 备案人姓名(联络人)
     */
    @Column(name = "LiaName")
    private String lianame;

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
     * 企业登录码（注册号）
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
     * updateTime
     */
    @Column(name = "update_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8") 
    private Date updateTime;

    public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	private static final long serialVersionUID = 1L;

    /**
     * 获取ID
     *
     * @return id - ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置ID
     *
     * @param id ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取受理单位
     *
     * @return AppReviewOrg - 受理单位
     */
    public String getApprevieworg() {
        return apprevieworg;
    }

    /**
     * 设置受理单位
     *
     * @param apprevieworg 受理单位
     */
    public void setApprevieworg(String apprevieworg) {
        this.apprevieworg = apprevieworg;
    }

    /**
     * 获取密码
     *
     * @return Password - 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取手机号码（联络人）
     *
     * @return Tel - 手机号码（联络人）
     */
    public String getTel() {
        return tel;
    }

    /**
     * 设置手机号码（联络人）
     *
     * @param tel 手机号码（联络人）
     */
    public void setTel(String tel) {
        this.tel = tel;
    }

    /**
     * 获取操作人登录名
     *
     * @return Username - 操作人登录名
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置操作人登录名
     *
     * @param username 操作人登录名
     */
    public void setUsername(String username) {
        this.username = username;
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
     * @param uid UID
     */
    public void setUid(String uid) {
        this.uid = uid;
    }

    /**
     * 获取流水号：8位时间戳（yyyyMMdd）+2位地区编码+5位随机码
     *
     * @return PasID - 流水号：8位时间戳（yyyyMMdd）+2位地区编码+5位随机码
     */
    public String getPasid() {
        return pasid;
    }

    /**
     * 设置流水号：8位时间戳（yyyyMMdd）+2位地区编码+5位随机码
     *
     * @param pasid 流水号：8位时间戳（yyyyMMdd）+2位地区编码+5位随机码
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
     * 获取创建时间
     *
     * @return ApplyTime - 创建时间
     */
    public Date getApplytime() {
        return applytime;
    }

    /**
     * 设置创建时间
     *
     * @param applytime 创建时间
     */
    public void setApplytime(Date applytime) {
        this.applytime = applytime;
    }

    /**
     * 获取企业身份证号
     *
     * @return LiaIDNum - 企业身份证号
     */
    public String getLiaidnum() {
        return liaidnum;
    }

    /**
     * 设置企业身份证号
     *
     * @param liaidnum 企业身份证号
     */
    public void setLiaidnum(String liaidnum) {
        this.liaidnum = liaidnum;
    }

    /**
     * 获取证件类型(联络人)
     *
     * @return LiaIDType - 证件类型(联络人)
     */
    public String getLiaidtype() {
        return liaidtype;
    }

    /**
     * 设置证件类型(联络人)
     *
     * @param liaidtype 证件类型(联络人)
     */
    public void setLiaidtype(String liaidtype) {
        this.liaidtype = liaidtype;
    }

    /**
     * 获取备案人姓名(联络人)
     *
     * @return LiaName - 备案人姓名(联络人)
     */
    public String getLianame() {
        return lianame;
    }

    /**
     * 设置备案人姓名(联络人)
     *
     * @param lianame 备案人姓名(联络人)
     */
    public void setLianame(String lianame) {
        this.lianame = lianame;
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
     * 获取企业登录码（注册号）
     *
     * @return RegNO - 企业登录码（注册号）
     */
    public String getRegno() {
        return regno;
    }

    /**
     * 设置企业登录码（注册号）
     *
     * @param regno 企业登录码（注册号）
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

    // WARNING：不是表中字段的属性必须加@Transient注解
    @Transient
    public String dom;
    
    @Transient
    public String regUnit;
    
    @Transient
    public String regOrg;
    
    @Transient
    public String checkDep;

	public String getDom() {
		return dom;
	}

	public void setDom(String dom) {
		this.dom = dom;
	}

	public String getRegUnit() {
		return regUnit;
	}

	public void setRegUnit(String regUnit) {
		this.regUnit = regUnit;
	}

	public String getRegOrg() {
		return regOrg;
	}

	public void setRegOrg(String regOrg) {
		this.regOrg = regOrg;
	}

	public String getCheckDep() {
		return checkDep;
	}

	public void setCheckDep(String checkDep) {
		this.checkDep = checkDep;
	}
}