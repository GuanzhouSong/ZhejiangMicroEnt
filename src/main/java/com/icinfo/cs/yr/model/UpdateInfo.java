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
 * 描述:    cs_updateinfo 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2016年09月19日
 */
@Table(name = "cs_updateinfo")
public class UpdateInfo implements Serializable {
    /**
     * 自增id
     */
    @Id
    @Column(name = "id")
    private Integer id;

    /**
     * 修改日期
     */
    @Column(name = "AltDate")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8") 
    private Date altDate;

    /**
     * 时间戳
     */
    @Column(name = "CreateTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")   
    private Date createTime;

    /**
     * 年报ID
     */
    @Column(name = "AnCheID")
    private String anCheID;

    /**
     * 修改记录对应表
     */
    @Column(name = "AltTable")
    private String altTable;

    /**
     * 年报修改ID；uuid
     */
    @Column(name = "AncheUID")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    private String ancheUID;

    /**
     * 包括：联系电话、企业通信地址、邮政编码、电子邮箱、经营状态、隶属企业名称、资金数额、从业人数、出资信息、对外投资信息、资产总额、负债总额、营业总收入、主营业务收入、利润总额、净利润、纳税总额、所有者权益合计、网站或网店信息、股东变更信息、对外提供保证担保信息
该规范从2016年年报填写开始使用，用于页面上改动过的内容高亮判断使用。
仅2016年以后的年报信息增加该变更信息高亮功能。
     */
    @Column(name = "AltItem")
    private String altItem;

    /**
     * 年报提交编号
     */
    @Column(name = "ReportNo")
    private String reportNo;

    /**
     * 修改前
     */
    @Column(name = "AltBe")
    private String altBe;

    /**
     * 修改后
     */
    @Column(name = "AltAf")
    private String altAf;

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
     * 获取修改日期
     *
     * @return AltDate - 修改日期
     */
    public Date getAltDate() {
        return altDate;
    }

    /**
     * 设置修改日期
     *
     * @param altDate 修改日期
     */
    public void setAltDate(Date altDate) {
        this.altDate = altDate;
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
     * 获取年报ID
     *
     * @return AnCheID - 年报ID
     */
    public String getAnCheID() {
        return anCheID;
    }

    /**
     * 设置年报ID
     *
     * @param anCheID 年报ID
     */
    public void setAnCheID(String anCheID) {
        this.anCheID = anCheID;
    }

    /**
     * 获取修改记录对应表
     *
     * @return AltTable - 修改记录对应表
     */
    public String getAltTable() {
        return altTable;
    }

    /**
     * 设置修改记录对应表
     *
     * @param altTable 修改记录对应表
     */
    public void setAltTable(String altTable) {
        this.altTable = altTable;
    }

    /**
     * 获取年报修改ID；uuid
     *
     * @return AncheUID - 年报修改ID；uuid
     */
    public String getAncheUID() {
        return ancheUID;
    }

    /**
     * 设置年报修改ID；uuid
     *
     * @param ancheUID 年报修改ID；uuid
     */
    public void setAncheUID(String ancheUID) {
        this.ancheUID = ancheUID;
    }

    /**
     * 获取包括：联系电话、企业通信地址、邮政编码、电子邮箱、经营状态、隶属企业名称、资金数额、从业人数、出资信息、对外投资信息、资产总额、负债总额、营业总收入、主营业务收入、利润总额、净利润、纳税总额、所有者权益合计、网站或网店信息、股东变更信息、对外提供保证担保信息
该规范从2016年年报填写开始使用，用于页面上改动过的内容高亮判断使用。
仅2016年以后的年报信息增加该变更信息高亮功能。
     *
     * @return AltItem - 包括：联系电话、企业通信地址、邮政编码、电子邮箱、经营状态、隶属企业名称、资金数额、从业人数、出资信息、对外投资信息、资产总额、负债总额、营业总收入、主营业务收入、利润总额、净利润、纳税总额、所有者权益合计、网站或网店信息、股东变更信息、对外提供保证担保信息
该规范从2016年年报填写开始使用，用于页面上改动过的内容高亮判断使用。
仅2016年以后的年报信息增加该变更信息高亮功能。
     */
    public String getAltItem() {
        return altItem;
    }

    /**
     * 设置包括：联系电话、企业通信地址、邮政编码、电子邮箱、经营状态、隶属企业名称、资金数额、从业人数、出资信息、对外投资信息、资产总额、负债总额、营业总收入、主营业务收入、利润总额、净利润、纳税总额、所有者权益合计、网站或网店信息、股东变更信息、对外提供保证担保信息
该规范从2016年年报填写开始使用，用于页面上改动过的内容高亮判断使用。
仅2016年以后的年报信息增加该变更信息高亮功能。
     *
     * @param altItem 包括：联系电话、企业通信地址、邮政编码、电子邮箱、经营状态、隶属企业名称、资金数额、从业人数、出资信息、对外投资信息、资产总额、负债总额、营业总收入、主营业务收入、利润总额、净利润、纳税总额、所有者权益合计、网站或网店信息、股东变更信息、对外提供保证担保信息
该规范从2016年年报填写开始使用，用于页面上改动过的内容高亮判断使用。
仅2016年以后的年报信息增加该变更信息高亮功能。
     */
    public void setAltItem(String altItem) {
        this.altItem = altItem;
    }

    /**
     * 获取年报提交编号
     *
     * @return ReportNo - 年报提交编号
     */
    public String getReportNo() {
        return reportNo;
    }

    /**
     * 设置年报提交编号
     *
     * @param reportNo 年报提交编号
     */
    public void setReportNo(String reportNo) {
        this.reportNo = reportNo;
    }

    /**
     * 获取修改前
     *
     * @return AltBe - 修改前
     */
    public String getAltBe() {
        return altBe;
    }

    /**
     * 设置修改前
     *
     * @param altBe 修改前
     */
    public void setAltBe(String altBe) {
        this.altBe = altBe;
    }

    /**
     * 获取修改后
     *
     * @return AltAf - 修改后
     */
    public String getAltAf() {
        return altAf;
    }

    /**
     * 设置修改后
     *
     * @param altAf 修改后
     */
    public void setAltAf(String altAf) {
        this.altAf = altAf;
    }
    
    /**
     * chenyl 2016-10-13新增
     * 修改项唯一标识字段
     */
    @Column(name = "AltID")
    private String altID;

	public String getAltID() {
		return altID;
	}

	public void setAltID(String altID) {
		this.altID = altID;
	}

}