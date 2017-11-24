/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.im.model;


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.icinfo.cs.common.anno.Forbidword;
import com.icinfo.framework.mybatis.mapper.annotation.Before;

/**
 * 描述:    cs_im_invactdetail 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2016年08月28日
 */
@Table(name = "cs_im_investment")
public class ImInvestment implements Serializable {
    /**
     * 主键自增id
     */
    @Id
    @Column(name = "id")
    private Integer id;


    /**
     * 出资人id
     *  企业：统一社会信用代码
     *  个体工商：工商注册号
     *  个人：身份证号码
     *
     */
    @Column(name = "InvID")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    private String invID;

    /**
     * 主题身份代码CA14
     */
    @Column(name = "PriPID")
    private String priPID;

    /**
     * 企业(机构)名称
     */
    @Column(name = "EntName")
    
    private String entName;

    /**
     * 注册号CA15
     */
    @Column(name = "RegNO")
    private String regNO;

    /**
     * 股东/发起人名称DA111
     */
    @Forbidword
    @Column(name = "Inv")
    private String inv;
    @Transient
    private String invname;

    /**
     * 统一社会信用代码
     */
    @Column(name = "UniCode")
    private String uniCode;

    /**
     * 创建时间戳
     */
    @Column(name = "CreateTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;

    /**
     * 累计实缴额
     */
    @Column(name = "LiAcConAm")
    private BigDecimal liAcConAm;

    /**
     * 累计认缴额
     */
    @Column(name = "LiSubConAm")
    private BigDecimal liSubConAm;


    /**
     * 认缴明细列表
     */
    @Transient
    private List<ImInvprodetail> imInvprodetailList;

    /**
     * 实缴明细列表
     */
    @Transient
    private List<ImInvactdetail> imInvactdetailList;

    public List<ImInvprodetail> getImInvprodetailList() {
        return imInvprodetailList;
    }

    public void setImInvprodetailList(List<ImInvprodetail> imInvprodetailList) {
        this.imInvprodetailList = imInvprodetailList;
    }

    public List<ImInvactdetail> getImInvactdetailList() {
        return imInvactdetailList;
    }

    public void setImInvactdetailList(List<ImInvactdetail> imInvactdetailList) {
        this.imInvactdetailList = imInvactdetailList;
    }


    private static final long serialVersionUID = 1L;


    public BigDecimal getLiAcConAm() {
        return liAcConAm;
    }

    public void setLiAcConAm(BigDecimal liAcConAm) {
        this.liAcConAm = liAcConAm;
    }

    public BigDecimal getLiSubConAm() {
        return liSubConAm;
    }

    public void setLiSubConAm(BigDecimal liSubConAm) {
        this.liSubConAm = liSubConAm;
    }

    /**
     * 获取主键自增id
     *
     * @return id - 主键自增id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置主键自增id
     *
     * @param id 主键自增id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取主题身份代码CA14
     *
     * @return PriPID - 主题身份代码CA14
     */
    public String getPriPID() {
        return priPID;
    }

    /**
     * 设置主题身份代码CA14
     *
     * @param priPID 主题身份代码CA14
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
     * 获取注册号CA15
     *
     * @return RegNO - 注册号CA15
     */
    public String getRegNO() {
        return regNO;
    }

    /**
     * 设置注册号CA15
     *
     * @param regNO 注册号CA15
     */
    public void setRegNO(String regNO) {
        this.regNO = regNO;
    }

    public String getInvname() {
        return invname;
    }

    public void setInvname(String invname) {
        this.invname = invname;
    }

    /**
     * 获取出资人id
     *
     * @return InvID - 出资人id
     */
    public String getInvID() {
        return invID;
    }

    /**
     * 设置出资人id
     *
     * @param invID 出资人id
     */
    public void setInvID(String invID) {
        this.invID = invID;
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
     * 获取创建时间戳
     *
     * @return CreateTime - 创建时间戳
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间戳
     *
     * @param createTime 创建时间戳
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getInv() {
        return inv;
    }

    public void setInv(String inv) {
        this.inv = inv;
    }
}