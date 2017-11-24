/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.im.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.icinfo.cs.common.anno.Forbidword;
import com.icinfo.framework.mybatis.mapper.annotation.Before;

/**
 * 描述:    cs_im_invprodetail 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2016年08月28日
 */
@Table(name = "cs_im_invprodetail")
public class ImInvprodetail implements Serializable {
    /**
     * 主键自增id
     */
    @Id
    @Column(name = "id")
    private Integer id;

    /**
     * 认缴id(UUID)
     */
    @Column(name = "SubID")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    private String subID;


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
     * 认缴出资方式
     */
    @Column(name = "ConForm")
    private String conForm;

    /**
     * 认缴出资日期
     */
    @Column(name = "ConDate")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date conDate;

    /**
     * 认缴出资额
     */
    @Column(name = "SubConAm")
    private BigDecimal subConAm;

    /**
     * 创建时间戳
     */
    @Column(name = "CreateTime")
    private Date createTime;

    /**
     * 认缴出资方式(中文名称)
     */
    @Column(name = "ConFormCN")
    private String conFormCN;



    /**
     * 公示状态1:公示,2:暂存,0历史记录
     */
    @Column(name = "PubFlag")
    private String pubFlag;

    /**
     * 公示日期
     */
    @Column(name = "PublicDate")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date publicDate;

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
     * 获取认缴出资方式
     *
     * @return ConForm - 认缴出资方式
     */
    public String getConForm() {
        return conForm;
    }

    /**
     * 设置认缴出资方式
     *
     * @param conForm 认缴出资方式
     */
    public void setConForm(String conForm) {
        this.conForm = conForm;
    }

    /**
     * 获取认缴出资日期
     *
     * @return ConDate - 认缴出资日期
     */
    public Date getConDate() {
        return conDate;
    }

    /**
     * 设置认缴出资日期
     *
     * @param conDate 认缴出资日期
     */
    public void setConDate(Date conDate) {
        this.conDate = conDate;
    }

    /**
     * 获取认缴出资额
     *
     * @return SubConAm - 认缴出资额
     */
    public BigDecimal getSubConAm() {
        return subConAm;
    }

    /**
     * 设置认缴出资额
     *
     * @param subConAm 认缴出资额
     */
    public void setSubConAm(BigDecimal subConAm) {
        this.subConAm = subConAm;
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
     * 获取认缴出资方式(中文名称)
     *
     * @return ConFormCN - 认缴出资方式(中文名称)
     */
    public String getConFormCN() {
        return conFormCN;
    }

    /**
     * 设置认缴出资方式(中文名称)
     *
     * @param conFormCN 认缴出资方式(中文名称)
     */
    public void setConFormCN(String conFormCN) {
        this.conFormCN = conFormCN;
    }

    /**
     * 获取认缴id(UUID)
     *
     * @return SubID - 认缴id(UUID)
     */
    public String getSubID() {
        return subID;
    }

    /**
     * 设置认缴id(UUID)
     *
     * @param subID 认缴id(UUID)
     */
    public void setSubID(String subID) {
        this.subID = subID;
    }

    /**
     * 获取公示状态1:公示,2:暂存,0历史记录
     *
     * @return PubFlag - 公示状态1:公示,2:暂存,0历史记录
     */
    public String getPubFlag() {
        return pubFlag;
    }

    /**
     * 设置公示状态1:公示,2:暂存,0历史记录
     *
     * @param pubFlag 公示状态1:公示,2:暂存,0历史记录
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
}