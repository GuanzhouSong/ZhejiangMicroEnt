/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.im.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.icinfo.cs.common.anno.Forbidword;
import com.icinfo.framework.mybatis.mapper.annotation.Before;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

/**
 * 描述:    cs_im_invactdetail 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2016年08月29日
 */
@Table(name = "cs_im_invactdetail")
public class ImInvactdetail implements Serializable {
    /**
     * 主键自增id
     */
    @Id
    @Column(name = "id")
    private Integer id;

    /**
     * 实缴ID（UUID）
     */
    @Column(name = "PaidID")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    private String paidID;


    /**
     * 股东/发起人名称
     */
    @Column(name = "Inv")
    @Forbidword
    private String inv;

    /**
     * 出资人ID
     */
    @Column(name = "InvID")
    private String invID;

    /**
     * 实缴出资日期
     */
    @Column(name = "ConDate")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date conDate;

    /**
     * 实缴出资额
     */
    @Column(name = "AcConAm")
    private BigDecimal acConAm;

    /**
     * 创建时间戳
     */
    @Column(name = "CreateTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;


    /**
     * 实缴出资方式（中文名称）
     */
    @Column(name = "AcConFormCn")
    private String acConFormCn;

    /**
     * 公示状态1：公示，2：暂存，0：历史记录
     */
    @Column(name = "PubFlag")
    private String pubFlag;

    /**
     * 公示日期
     */
    @Column(name = "PublicDate")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date publicDate;

    /**
     * 实缴出资方式CA22
     */
    @Column(name = "AcConForm")
    private String acConForm;

    private static final long serialVersionUID = 1L;

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
     * 获取股东/发起人名称
     *
     * @return Inv - 股东/发起人名称
     */
    public String getInv() {
        return inv;
    }

    /**
     * 设置股东/发起人名称
     *
     * @param inv 股东/发起人名称
     */
    public void setInv(String inv) {
        this.inv = inv;
    }

    /**
     * 获取出资人ID
     *
     * @return InvID - 出资人ID
     */
    public String getInvID() {
        return invID;
    }

    /**
     * 设置出资人ID
     *
     * @param invID 出资人ID
     */
    public void setInvID(String invID) {
        this.invID = invID;
    }

    /**
     * 获取实缴出资日期
     *
     * @return ConDate - 实缴出资日期
     */
    public Date getConDate() {
        return conDate;
    }

    /**
     * 设置实缴出资日期
     *
     * @param conDate 实缴出资日期
     */
    public void setConDate(Date conDate) {
        this.conDate = conDate;
    }

    /**
     * 获取实缴出资额
     *
     * @return AcConAm - 实缴出资额
     */
    public BigDecimal getAcConAm() {
        return acConAm;
    }

    /**
     * 设置实缴出资额
     *
     * @param acConAm 实缴出资额
     */
    public void setAcConAm(BigDecimal acConAm) {
        this.acConAm = acConAm;
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

    /**
     * 获取实缴ID（UUID）
     *
     * @return PaidID - 实缴ID（UUID）
     */
    public String getPaidID() {
        return paidID;
    }

    /**
     * 设置实缴ID（UUID）
     *
     * @param paidID 实缴ID（UUID）
     */
    public void setPaidID(String paidID) {
        this.paidID = paidID;
    }

    /**
     * 获取实缴出资方式（中文名称）
     *
     * @return AcConFormCn - 实缴出资方式（中文名称）
     */
    public String getAcConFormCn() {
        return acConFormCn;
    }

    /**
     * 设置实缴出资方式（中文名称）
     *
     * @param acConFormCn 实缴出资方式（中文名称）
     */
    public void setAcConFormCn(String acConFormCn) {
        this.acConFormCn = acConFormCn;
    }

    /**
     * 获取公示状态1：公示，2：暂存，0：历史记录
     *
     * @return PubFlag - 公示状态1：公示，2：暂存，0：历史记录
     */
    public String getPubFlag() {
        return pubFlag;
    }

    /**
     * 设置公示状态1：公示，2：暂存，0：历史记录
     *
     * @param pubFlag 公示状态1：公示，2：暂存，0：历史记录
     */
    public void setPubFlag(String pubFlag) {
        this.pubFlag = pubFlag;
    }

    /**
     * 获取公示日期
     *
     * @return PublicDate - 公示日期
     */
    public Date getPublicDate() {
        return publicDate;
    }

    /**
     * 设置公示日期
     *
     * @param publicDate 公示日期
     */
    public void setPublicDate(Date publicDate) {
        this.publicDate = publicDate;
    }

    /**
     * 获取实缴出资方式CA22
     *
     * @return AcConForm - 实缴出资方式CA22
     */
    public String getAcConForm() {
        return acConForm;
    }

    /**
     * 设置实缴出资方式CA22
     *
     * @param acConForm 实缴出资方式CA22
     */
    public void setAcConForm(String acConForm) {
        this.acConForm = acConForm;
    }
}