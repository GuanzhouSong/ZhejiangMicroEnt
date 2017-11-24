/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.yr.model;

import com.icinfo.framework.mybatis.mapper.annotation.Before;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * 描述:    cs_yr_websiteinfo 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年07月21日
 */
@Table(name = "cs_yr_websiteinfo")
public class WebsiteinfoSearch implements Serializable {
    /**
     * 自增ID
     */
    @Id
    @Column(name = "id")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    private Integer id;

    /**
     * 主体身份代码
     */
    @Column(name = "PriPID")
    private String priPID;

    /**
     * 网站（网店）网址
     */
    @Column(name = "WebSite")
    private String webSite;

    /**
     * 年报年度
     */
    @Column(name = "Year")
    private Integer year;

    /**
     * 网站网店类型
     */
    @Column(name = "WebType")
    private String webType;

    /**
     * 时间戳
     */
    @Column(name = "CreateTime")
    private Date createTime;

    /**
     * 年报ID
     */
    @Column(name = "AnCheID")
    private String anCheID;

    /**
     * 网站标识
     */
    @Column(name = "WEBID")
    private String WEBID;

    /**
     * 网站（网店）名称
     */
    @Column(name = "WebSitName")
    private String webSitName;

    /**
     * 网络交易平台运营类型
     */
    @Column(name = "WebPlatFormType")
    private String webPlatFormType;

    /**
     * 网络交易产品类型
     */
    @Column(name = "WebGoodsType")
    private String webGoodsType;

    /**
     * 电商类型
     */
    @Column(name = "ECommerceType")
    private String ecommerceType;

    /**
     * ICP证号/备案号
     */
    @Column(name = "IcpBackNO")
    private String icpBackNO;

    /**
     * 微信公众服务号
     */
    @Column(name = "WeChatPublicNO")
    private String weChatPublicNO;

    /**
     * APP软件名称
     */
    @Column(name = "AppNames")
    private String appNames;

    /**
     * 所属平台名称:如天猫、淘宝、京东、1688、蘑菇街、贝贝网、义乌购、海宁皮城等）
     */
    @Column(name = "BelongPlatFormName")
    private String belongPlatFormName;

    /**
     * 发货地址
     */
    @Column(name = "SendAddress")
    private String sendAddress;

    /**
     * 退货地址
     */
    @Column(name = "BackAddress")
    private String backAddress;

    /**
     * 网站类型：网络交易平台1，企业信息管网2
     */
    @Column(name = "WebSmallType")
    private String webSmallType;

    private static final long serialVersionUID = 1L;

    /**
     * 获取自增ID
     *
     * @return id - 自增ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置自增ID
     *
     * @param id 自增ID
     */
    public void setId(Integer id) {
        this.id = id;
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
     * 获取网站（网店）网址
     *
     * @return WebSite - 网站（网店）网址
     */
    public String getWebSite() {
        return webSite;
    }

    /**
     * 设置网站（网店）网址
     *
     * @param webSite 网站（网店）网址
     */
    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    /**
     * 获取年报年度
     *
     * @return Year - 年报年度
     */
    public Integer getYear() {
        return year;
    }

    /**
     * 设置年报年度
     *
     * @param year 年报年度
     */
    public void setYear(Integer year) {
        this.year = year;
    }

    /**
     * 获取网站网店类型
     *
     * @return WebType - 网站网店类型
     */
    public String getWebType() {
        return webType;
    }

    /**
     * 设置网站网店类型
     *
     * @param webType 网站网店类型
     */
    public void setWebType(String webType) {
        this.webType = webType;
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
     * 获取网站标识
     *
     * @return WEBID - 网站标识
     */
    public String getWEBID() {
        return WEBID;
    }

    /**
     * 设置网站标识
     *
     * @param WEBID 网站标识
     */
    public void setWEBID(String WEBID) {
        this.WEBID = WEBID;
    }

    /**
     * 获取网站（网店）名称
     *
     * @return WebSitName - 网站（网店）名称
     */
    public String getWebSitName() {
        return webSitName;
    }

    /**
     * 设置网站（网店）名称
     *
     * @param webSitName 网站（网店）名称
     */
    public void setWebSitName(String webSitName) {
        this.webSitName = webSitName;
    }

    /**
     * 获取网络交易平台运营类型
     *
     * @return WebPlatFormType - 网络交易平台运营类型
     */
    public String getWebPlatFormType() {
        return webPlatFormType;
    }

    /**
     * 设置网络交易平台运营类型
     *
     * @param webPlatFormType 网络交易平台运营类型
     */
    public void setWebPlatFormType(String webPlatFormType) {
        this.webPlatFormType = webPlatFormType;
    }

    /**
     * 获取网络交易产品类型
     *
     * @return WebGoodsType - 网络交易产品类型
     */
    public String getWebGoodsType() {
        return webGoodsType;
    }

    /**
     * 设置网络交易产品类型
     *
     * @param webGoodsType 网络交易产品类型
     */
    public void setWebGoodsType(String webGoodsType) {
        this.webGoodsType = webGoodsType;
    }

    /**
     * 获取电商类型
     *
     * @return ECommerceType - 电商类型
     */
    public String getEcommerceType() {
		return ecommerceType;
	}



	/**
     * 设置电商类型
     *
     * @param ECommerceType 电商类型
     */
	public void setEcommerceType(String ecommerceType) {
		this.ecommerceType = ecommerceType;
	}

    /**
     * 获取ICP证号/备案号
     *
     * @return IcpBackNO - ICP证号/备案号
     */
    public String getIcpBackNO() {
        return icpBackNO;
    }

    /**
     * 设置ICP证号/备案号
     *
     * @param icpBackNO ICP证号/备案号
     */
    public void setIcpBackNO(String icpBackNO) {
        this.icpBackNO = icpBackNO;
    }

    /**
     * 获取微信公众服务号
     *
     * @return WeChatPublicNO - 微信公众服务号
     */
    public String getWeChatPublicNO() {
        return weChatPublicNO;
    }

    /**
     * 设置微信公众服务号
     *
     * @param weChatPublicNO 微信公众服务号
     */
    public void setWeChatPublicNO(String weChatPublicNO) {
        this.weChatPublicNO = weChatPublicNO;
    }

    /**
     * 获取APP软件名称
     *
     * @return AppNames - APP软件名称
     */
    public String getAppNames() {
        return appNames;
    }

    /**
     * 设置APP软件名称
     *
     * @param appNames APP软件名称
     */
    public void setAppNames(String appNames) {
        this.appNames = appNames;
    }

    /**
     * 获取所属平台名称:如天猫、淘宝、京东、1688、蘑菇街、贝贝网、义乌购、海宁皮城等）
     *
     * @return BelongPlatFormName - 所属平台名称:如天猫、淘宝、京东、1688、蘑菇街、贝贝网、义乌购、海宁皮城等）
     */
    public String getBelongPlatFormName() {
        return belongPlatFormName;
    }

    /**
     * 设置所属平台名称:如天猫、淘宝、京东、1688、蘑菇街、贝贝网、义乌购、海宁皮城等）
     *
     * @param belongPlatFormName 所属平台名称:如天猫、淘宝、京东、1688、蘑菇街、贝贝网、义乌购、海宁皮城等）
     */
    public void setBelongPlatFormName(String belongPlatFormName) {
        this.belongPlatFormName = belongPlatFormName;
    }

    /**
     * 获取发货地址
     *
     * @return SendAddress - 发货地址
     */
    public String getSendAddress() {
        return sendAddress;
    }

    /**
     * 设置发货地址
     *
     * @param sendAddress 发货地址
     */
    public void setSendAddress(String sendAddress) {
        this.sendAddress = sendAddress;
    }

    /**
     * 获取退货地址
     *
     * @return BackAddress - 退货地址
     */
    public String getBackAddress() {
        return backAddress;
    }

    /**
     * 设置退货地址
     *
     * @param backAddress 退货地址
     */
    public void setBackAddress(String backAddress) {
        this.backAddress = backAddress;
    }

    /**
     * 获取网站类型：网络交易平台1，企业信息管网2
     *
     * @return WebSmallType - 网站类型：网络交易平台1，企业信息管网2
     */
    public String getWebSmallType() {
        return webSmallType;
    }

    /**
     * 设置网站类型：网络交易平台1，企业信息管网2
     *
     * @param webSmallType 网站类型：网络交易平台1，企业信息管网2
     */
    public void setWebSmallType(String webSmallType) {
        this.webSmallType = webSmallType;
    }
}