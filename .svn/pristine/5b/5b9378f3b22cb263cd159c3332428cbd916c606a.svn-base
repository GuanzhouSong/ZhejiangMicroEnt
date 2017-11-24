/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.webservice.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.icinfo.framework.mybatis.mapper.annotation.Before;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * 描述: 联络员信息表 cs_pub_eppassword 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年10月31日
 */
@Table(name = "cs_pub_eppassword")
public class WsPubEppassword implements Serializable {
    /**
     * ID
     */
    @Id
    @Column(name = "id")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
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
    private String UID;

    /**
     * 流水号：8位时间戳（yyyyMMdd）+2位地区编码+5位随机码
     */
    @Column(name = "PasID")
    private String pasID;

    /**
     * 状态标志 01:已接受，02:申请，03：不接受
     */
    @Column(name = "PasStatus")
    private String pasStatus;

    /**
     * 创建时间
     */
    @Column(name = "ApplyTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date applyTime;

    /**
     * 企业身份证号
     */
    @Column(name = "LiaIDNum")
    private String liaIDNum;

    /**
     * 证件类型(联络人)
     */
    @Column(name = "LiaIDType")
    private String liaIDType;

    /**
     * 备案人姓名(联络人)
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

    @Column(name = "LeRep")
    private String leRep;

    /**
     * 企业类型
     */
    @Column(name = "EntType")
    private String entType;

    /**
     * 统一社会信用代码
     */
    @Column(name = "UniCode")
    private String uniCode;

    /**
     * 时间戳
     */
    @Column(name = "CreateTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;

    /**
     * 法定代表人手机号
     */
    @Column(name = "LeRepPhone")
    private String leRepPhone;

    @Column(name = "update_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date update_time;

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
     * 获取流水号：8位时间戳（yyyyMMdd）+2位地区编码+5位随机码
     *
     * @return PasID - 流水号：8位时间戳（yyyyMMdd）+2位地区编码+5位随机码
     */
    public String getPasID() {
        return pasID;
    }

    /**
     * 设置流水号：8位时间戳（yyyyMMdd）+2位地区编码+5位随机码
     *
     * @param pasID 流水号：8位时间戳（yyyyMMdd）+2位地区编码+5位随机码
     */
    public void setPasID(String pasID) {
        this.pasID = pasID;
    }

    /**
     * 获取状态标志 01:已接受，02:申请，03：不接受
     *
     * @return PasStatus - 状态标志 01:已接受，02:申请，03：不接受
     */
    public String getPasStatus() {
        return pasStatus;
    }

    /**
     * 设置状态标志 01:已接受，02:申请，03：不接受
     *
     * @param pasStatus 状态标志 01:已接受，02:申请，03：不接受
     */
    public void setPasStatus(String pasStatus) {
        this.pasStatus = pasStatus;
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
     * 获取证件类型(联络人)
     *
     * @return LiaIDType - 证件类型(联络人)
     */
    public String getLiaIDType() {
        return liaIDType;
    }

    /**
     * 设置证件类型(联络人)
     *
     * @param liaIDType 证件类型(联络人)
     */
    public void setLiaIDType(String liaIDType) {
        this.liaIDType = liaIDType;
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
     * 获取企业类型
     *
     * @return EntType - 企业类型
     */
    public String getEntType() {
        return entType;
    }

    /**
     * 设置企业类型
     *
     * @param entType 企业类型
     */
    public void setEntType(String entType) {
        this.entType = entType;
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

    /**
     * 获取法定代表人手机号
     *
     * @return LeRepPhone - 法定代表人手机号
     */
    public String getLeRepPhone() {
        return leRepPhone;
    }

    /**
     * 设置法定代表人手机号
     *
     * @param leRepPhone 法定代表人手机号
     */
    public void setLeRepPhone(String leRepPhone) {
        this.leRepPhone = leRepPhone;
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
}