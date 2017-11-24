/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.consult.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 描述:    cs_consult_info 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年10月12日
 */
@Table(name = "cs_consult_info")
public class ConsultInfo implements Serializable {
    /**
     * 自增id
     */
    @Id
    @Column(name = "id")
    private Integer id;

    /**
     * 唯一标识uid
     */
    @Column(name = "UID")
    private String uid;

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
     * 咨询标题
     */
    @Column(name = "consultTitle")
    private String consultTitle;

    /**
     * 咨询日期
     */
    @Column(name = "consultTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date consultTime;

    /**
     * 咨询人姓名
     */
    @Column(name = "consultName")
    private String consultName;

    /**
     * 咨询人联系电话
     */
    @Column(name = "consultTel")
    private String consultTel;

    /**
     * 反馈部门编码
     */
    @Column(name = "BackDeptCode")
    private String backDeptCode;

    /**
     * 反馈部门名称
     */
    @Column(name = "BackDept")
    private String backDept;

    /**
     * 反馈人姓名
     */
    @Column(name = "BackName")
    private String backName;

    /**
     * 反馈时间
     */
    @Column(name = "BackTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date backTime;

    /**
     * 0,未反馈 1 已反馈
     */
    @Column(name = "State")
    private String state;

    /**
     * 时间戳
     */
    @Column(name = "CreateTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;

    /**
     * 咨询内容
     */
    @Column(name = "consultContent")
    private String consultContent;

    /**
     * 反馈内容
     */
    @Column(name = "BackContent")
    private String backContent;

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

     

    public String getUid() {
		return uid;
	}

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
     * 获取咨询标题
     *
     * @return consultTitle - 咨询标题
     */
    public String getConsultTitle() {
        return consultTitle;
    }

    /**
     * 设置咨询标题
     *
     * @param consultTitle 咨询标题
     */
    public void setConsultTitle(String consultTitle) {
        this.consultTitle = consultTitle;
    }

    /**
     * 获取咨询日期
     *
     * @return consultTime - 咨询日期
     */
    public Date getConsultTime() {
        return consultTime;
    }

    /**
     * 设置咨询日期
     *
     * @param consultTime 咨询日期
     */
    public void setConsultTime(Date consultTime) {
        this.consultTime = consultTime;
    }

    /**
     * 获取咨询人姓名
     *
     * @return consultName - 咨询人姓名
     */
    public String getConsultName() {
        return consultName;
    }

    /**
     * 设置咨询人姓名
     *
     * @param consultName 咨询人姓名
     */
    public void setConsultName(String consultName) {
        this.consultName = consultName;
    }

    /**
     * 获取咨询人联系电话
     *
     * @return consultTel - 咨询人联系电话
     */
    public String getConsultTel() {
        return consultTel;
    }

    /**
     * 设置咨询人联系电话
     *
     * @param consultTel 咨询人联系电话
     */
    public void setConsultTel(String consultTel) {
        this.consultTel = consultTel;
    }

    /**
     * 获取反馈部门编码
     *
     * @return BackDeptCode - 反馈部门编码
     */
    public String getBackDeptCode() {
        return backDeptCode;
    }

    /**
     * 设置反馈部门编码
     *
     * @param backDeptCode 反馈部门编码
     */
    public void setBackDeptCode(String backDeptCode) {
        this.backDeptCode = backDeptCode;
    }

    /**
     * 获取反馈部门名称
     *
     * @return BackDept - 反馈部门名称
     */
    public String getBackDept() {
        return backDept;
    }

    /**
     * 设置反馈部门名称
     *
     * @param backDept 反馈部门名称
     */
    public void setBackDept(String backDept) {
        this.backDept = backDept;
    }

    /**
     * 获取反馈人姓名
     *
     * @return BackName - 反馈人姓名
     */
    public String getBackName() {
        return backName;
    }

    /**
     * 设置反馈人姓名
     *
     * @param backName 反馈人姓名
     */
    public void setBackName(String backName) {
        this.backName = backName;
    }

    /**
     * 获取反馈时间
     *
     * @return BackTime - 反馈时间
     */
    public Date getBackTime() {
        return backTime;
    }

    /**
     * 设置反馈时间
     *
     * @param backTime 反馈时间
     */
    public void setBackTime(Date backTime) {
        this.backTime = backTime;
    }

    /**
     * 获取0,未反馈 1 已反馈
     *
     * @return State - 0,未反馈 1 已反馈
     */
    public String getState() {
        return state;
    }

    /**
     * 设置0,未反馈 1 已反馈
     *
     * @param state 0,未反馈 1 已反馈
     */
    public void setState(String state) {
        this.state = state;
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
     * 获取咨询内容
     *
     * @return consultContent - 咨询内容
     */
    public String getConsultContent() {
        return consultContent;
    }

    /**
     * 设置咨询内容
     *
     * @param consultContent 咨询内容
     */
    public void setConsultContent(String consultContent) {
        this.consultContent = consultContent;
    }

    /**
     * 获取反馈内容
     *
     * @return BackContent - 反馈内容
     */
    public String getBackContent() {
        return backContent;
    }

    /**
     * 设置反馈内容
     *
     * @param backContent 反馈内容
     */
    public void setBackContent(String backContent) {
        this.backContent = backContent;
    }
}