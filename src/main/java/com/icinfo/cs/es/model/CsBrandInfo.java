/**
 * Copyright? 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.es.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * 描述:    cs_brand_info 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2016年11月06日
 */
@Table(name = "cs_brand_info")
public class CsBrandInfo implements Serializable {
    /**
     * ID
     */
    @Column(name = "id")
    private Integer id;

    /**
     * UID
     */
    @Column(name = "uid")
    private String uid;

    /**
     * 主体身份代码
     */
    @Column(name = "PriPID")
    private String priPID;

    /**
     * 企业(机构)名称
     */
    @Column(name = "EntName")
    private String entName;

    /**
     * 注册号
     */
    @Column(name = "RegNO")
    private String regNO;

    /**
     * 股权所在企业统一社会信用代码
     */
    @Column(name = "uniscid")
    private String uniscid;

    /**
     * 商标编号
     */
    @Column(name = "TmRegNO")
    private String tmRegNO;

    /**
     * 注册商标名称
     */
    @Column(name = "TmName")
    private String tmName;

    /**
     * 驰名/著名标识
     */
    @Column(name = "ResFamous")
    private String resFamous;

    /**
     * 商标有效期自
     */
    @Column(name = "TmFrom")
    private Date tmFrom;

    /**
     * 商标有效期至
     */
    @Column(name = "TmTo")
    private Date tmTo;

    /**
     * 商标类别
     */
    @Column(name = "TmType")
    private String tmType;

    /**
     * 使用商标名称
     */
    @Column(name = "UseTmName")
    private String useTmName;

    /**
     * 商标信息
     */
    @Column(name = "TmInfo")
    private String tmInfo;

    /**
     * 认定机关
     */
    @Column(name = "CogAuth")
    private String cogAuth;

    /**
     * 认定日期
     */
    @Column(name = "CogDate")
    private Date cogDate;

    /**
     * CreateTime
     */
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
     * 获取UID
     *
     * @return uid - UID
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
     * 获取企业(机构)名称
     *
     * @return EntName - 企业(机构)名称
     */
    public String getEntName() {
        return entName;
    }

    /**
     * 设置企业(机构)名称
     *
     * @param entName 企业(机构)名称
     */
    public void setEntName(String entName) {
        this.entName = entName;
    }

    /**
     * 获取注册号
     *
     * @return RegNO - 注册号
     */
    public String getRegNO() {
        return regNO;
    }

    /**
     * 设置注册号
     *
     * @param regNO 注册号
     */
    public void setRegNO(String regNO) {
        this.regNO = regNO;
    }

    /**
     * 获取股权所在企业统一社会信用代码
     *
     * @return uniscid - 股权所在企业统一社会信用代码
     */
    public String getUniscid() {
        return uniscid;
    }

    /**
     * 设置股权所在企业统一社会信用代码
     *
     * @param uniscid 股权所在企业统一社会信用代码
     */
    public void setUniscid(String uniscid) {
        this.uniscid = uniscid;
    }

    /**
     * 获取商标编号
     *
     * @return TmRegNO - 商标编号
     */
    public String getTmRegNO() {
        return tmRegNO;
    }

    /**
     * 设置商标编号
     *
     * @param tmRegNO 商标编号
     */
    public void setTmRegNO(String tmRegNO) {
        this.tmRegNO = tmRegNO;
    }

    /**
     * 获取注册商标名称
     *
     * @return TmName - 注册商标名称
     */
    public String getTmName() {
        return tmName;
    }

    /**
     * 设置注册商标名称
     *
     * @param tmName 注册商标名称
     */
    public void setTmName(String tmName) {
        this.tmName = tmName;
    }

    /**
     * 获取驰名/著名标识
     *
     * @return ResFamous - 驰名/著名标识
     */
    public String getResFamous() {
        return resFamous;
    }

    /**
     * 设置驰名/著名标识
     *
     * @param resFamous 驰名/著名标识
     */
    public void setResFamous(String resFamous) {
        this.resFamous = resFamous;
    }

    /**
     * 获取商标有效期自
     *
     * @return TmFrom - 商标有效期自
     */
    public Date getTmFrom() {
        return tmFrom;
    }

    /**
     * 设置商标有效期自
     *
     * @param tmFrom 商标有效期自
     */
    public void setTmFrom(Date tmFrom) {
        this.tmFrom = tmFrom;
    }

    /**
     * 获取商标有效期至
     *
     * @return TmTo - 商标有效期至
     */
    public Date getTmTo() {
        return tmTo;
    }

    /**
     * 设置商标有效期至
     *
     * @param tmTo 商标有效期至
     */
    public void setTmTo(Date tmTo) {
        this.tmTo = tmTo;
    }

    /**
     * 获取商标类别
     *
     * @return TmType - 商标类别
     */
    public String getTmType() {
        return tmType;
    }

    /**
     * 设置商标类别
     *
     * @param tmType 商标类别
     */
    public void setTmType(String tmType) {
        this.tmType = tmType;
    }

    /**
     * 获取使用商标名称
     *
     * @return UseTmName - 使用商标名称
     */
    public String getUseTmName() {
        return useTmName;
    }

    /**
     * 设置使用商标名称
     *
     * @param useTmName 使用商标名称
     */
    public void setUseTmName(String useTmName) {
        this.useTmName = useTmName;
    }

    /**
     * 获取商标信息
     *
     * @return TmInfo - 商标信息
     */
    public String getTmInfo() {
        return tmInfo;
    }

    /**
     * 设置商标信息
     *
     * @param tmInfo 商标信息
     */
    public void setTmInfo(String tmInfo) {
        this.tmInfo = tmInfo;
    }

    /**
     * 获取认定机关
     *
     * @return CogAuth - 认定机关
     */
    public String getCogAuth() {
        return cogAuth;
    }

    /**
     * 设置认定机关
     *
     * @param cogAuth 认定机关
     */
    public void setCogAuth(String cogAuth) {
        this.cogAuth = cogAuth;
    }

    /**
     * 获取认定日期
     *
     * @return CogDate - 认定日期
     */
    public Date getCogDate() {
        return cogDate;
    }

    /**
     * 设置认定日期
     *
     * @param cogDate 认定日期
     */
    public void setCogDate(Date cogDate) {
        this.cogDate = cogDate;
    }

    /**
     * 获取CreateTime
     *
     * @return CreateTime - CreateTime
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置CreateTime
     *
     * @param createTime CreateTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}