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
 * 描述:    cs_pub_pbeppassword 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2016年09月18日
 */
@Table(name = "cs_pub_pbeppassword")
public class PubPbePassword implements Serializable {
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
    private String appReviewOrg;

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
    private String UID;

    /**
     * 创建时间
     */
    @Column(name = "ApplyTime")
    private Date applyTime;

    /**
     * 身份证号码
     */
    @Column(name = "LiaIDNum")
    private String liaIDNum;

    /**
     * 经营者姓名
     */
    @Column(name = "LiaName")
    private String liaName;

    /**
     * 主体身份代码
     */
    @Column(name = "PriPID")
    private String priPID;

    /**
     * 企业名称
     */
    @Column(name = "EntName")
    private String entName;

    /**
     * 企业登录码（注册号）
     */
    @Column(name = "RegNO")
    private String regNO;

    /**
     * 统一社会信用代码
     */
    @Column(name = "UniCode")
    private String uniCode;

    /**
     * 时间戳
     */
    
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")  
    @Column(name = "CreateTime")
    private Date createTime;

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
    public String getAppReviewOrg() {
        return appReviewOrg;
    }

    /**
     * 设置受理单位
     *
     * @param appReviewOrg 受理单位
     */
    public void setAppReviewOrg(String appReviewOrg) {
        this.appReviewOrg = appReviewOrg;
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

    public void setUID(String UID) {
		this.UID = UID;
	}
    
    public String getUID() {
		return UID;
	}
    /**
     * 获取创建时间
     *
     * @return ApplyTime - 创建时间
     */
    public Date getApplyTime() {
        return applyTime;
    }

    /**
     * 设置创建时间
     *
     * @param applyTime 创建时间
     */
    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    /**
     * 获取企业身份证号
     *
     * @return LiaIDNum - 企业身份证号
     */
    public String getLiaIDNum() {
        return liaIDNum;
    }

    /**
     * 设置企业身份证号
     *
     * @param liaIDNum 企业身份证号
     */
    public void setLiaIDNum(String liaIDNum) {
        this.liaIDNum = liaIDNum;
    }

    /**
     * 获取备案人姓名(联络人)
     *
     * @return LiaName - 备案人姓名(联络人)
     */
    public String getLiaName() {
        return liaName;
    }

    /**
     * 设置备案人姓名(联络人)
     *
     * @param liaName 备案人姓名(联络人)
     */
    public void setLiaName(String liaName) {
        this.liaName = liaName;
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
     * 获取企业登录码（注册号）
     *
     * @return RegNO - 企业登录码（注册号）
     */
    public String getRegNO() {
        return regNO;
    }

    /**
     * 设置企业登录码（注册号）
     *
     * @param regNO 企业登录码（注册号）
     */
    public void setRegNO(String regNO) {
        this.regNO = regNO;
    }

    /**
     * 获取统一社会信用代码
     *
     * @return UniCode - 统一社会信用代码
     */
    public String getUniCode() {
        return uniCode;
    }

    /**
     * 设置统一社会信用代码
     *
     * @param uniCode 统一社会信用代码
     */
    public void setUniCode(String uniCode) {
        this.uniCode = uniCode;
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
}