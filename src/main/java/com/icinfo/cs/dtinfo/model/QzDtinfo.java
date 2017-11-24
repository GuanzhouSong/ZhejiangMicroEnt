/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.dtinfo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.icinfo.framework.mybatis.mapper.annotation.Before;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * 描述:    cs_qz_dtinfo 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年03月29日
 */
@Table(name = "cs_qz_dtinfo")
public class QzDtinfo implements Serializable {
    /**
     * 自增id
     */
    @Id
    @Column(name = "id")
    private Integer id;

    /**
     * 主键
     */
    @Column(name = "UID")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    private String UID;

    /**
     * 主体身份代码
     */
    @Column(name = "PriPID")
    private String priPID;

    /**
     * 统一社会信用代码
     */
    @Column(name = "UniSCID")
    private String uniSCID;

    /**
     * 企业名称
     */
    @Column(name = "EntName")
    private String entName;

    /**
     * 注册号
     */
    @Column(name = "RegNO")
    private String regNO;

    /**
     * 登记机关
     */
    @Column(name = "regOrg")
    private String regOrg;

    /**
     * 管辖单位
     */
    @Column(name = "LocalAdm")
    private String localAdm;

    /**
     * 后置审批事项编码
     */
    @Column(name = "exaCode")
    private String exaCode;

    /**
     * 后置审批事项名称
     */
    @Column(name = "exaName")
    private String exaName;

    /**
     * 实际审批部门编码
     */
    @Column(name = "adCode")
    private String adCode;

    /**
     * 实际审批部门名称
     */
    @Column(name = "orgName")
    private String orgName;

    /**
     * 分流状态 0：未分流； 1自动分流； 2：手动分流，3分流失败
     */
    @Column(name = "CheckPushType")
    private String checkPushType;

    /**
     * 分流日期
     */
    @Column(name = "CheckPushDate")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date checkPushDate;

    /**
     * 时间戳
     */
    @Column(name = "CreateTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;

    /**
     * 备注
     */
    @Column(name = "Remark")
    private String remark;

    private static final long serialVersionUID = 1L;

    /**
     * 获取自增id
     *
     * @return id - 自增id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置自增id
     *
     * @param id 自增id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取主键
     *
     * @return UID - 主键
     */
    public String getUID() {
        return UID;
    }

    /**
     * 设置主键
     *
     * @param UID 主键
     */
    public void setUID(String UID) {
        this.UID = UID;
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
     * 获取统一社会信用代码
     *
     * @return UniSCID - 统一社会信用代码
     */
    public String getUniSCID() {
        return uniSCID;
    }

    /**
     * 设置统一社会信用代码
     *
     * @param uniSCID 统一社会信用代码
     */
    public void setUniSCID(String uniSCID) {
        this.uniSCID = uniSCID;
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
     * 获取登记机关
     *
     * @return regOrg - 登记机关
     */
    public String getRegOrg() {
        return regOrg;
    }

    /**
     * 设置登记机关
     *
     * @param regOrg 登记机关
     */
    public void setRegOrg(String regOrg) {
        this.regOrg = regOrg;
    }

    /**
     * 获取管辖单位
     *
     * @return LocalAdm - 管辖单位
     */
    public String getLocalAdm() {
        return localAdm;
    }

    /**
     * 设置管辖单位
     *
     * @param localAdm 管辖单位
     */
    public void setLocalAdm(String localAdm) {
        this.localAdm = localAdm;
    }

    /**
     * 获取后置审批事项编码
     *
     * @return exaCode - 后置审批事项编码
     */
    public String getExaCode() {
        return exaCode;
    }

    /**
     * 设置后置审批事项编码
     *
     * @param exaCode 后置审批事项编码
     */
    public void setExaCode(String exaCode) {
        this.exaCode = exaCode;
    }

    /**
     * 获取后置审批事项名称
     *
     * @return exaName - 后置审批事项名称
     */
    public String getExaName() {
        return exaName;
    }

    /**
     * 设置后置审批事项名称
     *
     * @param exaName 后置审批事项名称
     */
    public void setExaName(String exaName) {
        this.exaName = exaName;
    }

    /**
     * 获取实际审批部门编码
     *
     * @return adCode - 实际审批部门编码
     */
    public String getAdCode() {
        return adCode;
    }

    /**
     * 设置实际审批部门编码
     *
     * @param adCode 实际审批部门编码
     */
    public void setAdCode(String adCode) {
        this.adCode = adCode;
    }

    /**
     * 获取实际审批部门名称
     *
     * @return orgName - 实际审批部门名称
     */
    public String getOrgName() {
        return orgName;
    }

    /**
     * 设置实际审批部门名称
     *
     * @param orgName 实际审批部门名称
     */
    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    /**
     * 获取分流状态 0：未分流； 1自动分流； 2：手动分流，3分流失败
     *
     * @return CheckPushType - 分流状态 0：未分流； 1自动分流； 2：手动分流，3分流失败
     */
    public String getCheckPushType() {
        return checkPushType;
    }

    /**
     * 设置分流状态 0：未分流； 1自动分流； 2：手动分流，3分流失败
     *
     * @param checkPushType 分流状态 0：未分流； 1自动分流； 2：手动分流，3分流失败
     */
    public void setCheckPushType(String checkPushType) {
        this.checkPushType = checkPushType;
    }

    /**
     * 获取分流日期
     *
     * @return CheckPushDate - 分流日期
     */
    public Date getCheckPushDate() {
        return checkPushDate;
    }

    /**
     * 设置分流日期
     *
     * @param checkPushDate 分流日期
     */
    public void setCheckPushDate(Date checkPushDate) {
        this.checkPushDate = checkPushDate;
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