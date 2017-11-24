/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.rpt.rptmodel;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

/**
 * 描述:    cs_rpt_yr 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年01月18日
 */
@Table(name = "cs_rpt_yr")
public class YrRpt implements Serializable {
    /**
     * 地区
     */
    @Column(name = "areaCode")
    private String areaCode;

    /**
     * 登记机关(CA11)
     */
    @Column(name = "regOrgCode")
    private String regOrgCode;

    /**
     * 管辖单位
     */
    @Column(name = "localAdmCode")
    private String localAdmCode;

    /**
     * 市场主体类型大类
     */
    @Column(name = "entCatgCode")
    private String entCatgCode;

    /**
     * 年报年度
     */
    @Column(name = "YEAR")
    private Integer YEAR;

    /**
     * 已年报数
     */
    @Column(name = "isreported")
    private BigDecimal isreported;

    /**
     * 因查无下落列入异常且未年报数
     */
    @Column(name = "notFound")
    private Double notFound;

    /**
     * 逾期年报数
     */
    @Column(name = "delay")
    private Double delay;

    /**
     * 数字证书年报数
     */
    @Column(name = "keyLogin")
    private BigDecimal keyLogin;

    /**
     * 联络员年报数
     */
    @Column(name = "passwordLogin")
    private BigDecimal passwordLogin;

    /**
     * 纸质报告年报数
     */
    @Column(name = "paper")
    private BigDecimal paper;

    /**
     * 手机APP年报数
     */
    @Column(name = "app")
    private BigDecimal app;

    @Column(name = "updateTime")
    private Date updateTime;

    private static final long serialVersionUID = 1L;

    /**
     * 获取地区
     *
     * @return areaCode - 地区
     */
    public String getAreaCode() {
        return areaCode;
    }

    /**
     * 设置地区
     *
     * @param areaCode 地区
     */
    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    /**
     * 获取登记机关(CA11)
     *
     * @return regOrgCode - 登记机关(CA11)
     */
    public String getRegOrgCode() {
        return regOrgCode;
    }

    /**
     * 设置登记机关(CA11)
     *
     * @param regOrgCode 登记机关(CA11)
     */
    public void setRegOrgCode(String regOrgCode) {
        this.regOrgCode = regOrgCode;
    }

    /**
     * 获取管辖单位
     *
     * @return localAdmCode - 管辖单位
     */
    public String getLocalAdmCode() {
        return localAdmCode;
    }

    /**
     * 设置管辖单位
     *
     * @param localAdmCode 管辖单位
     */
    public void setLocalAdmCode(String localAdmCode) {
        this.localAdmCode = localAdmCode;
    }

    /**
     * 获取市场主体类型大类
     *
     * @return entCatgCode - 市场主体类型大类
     */
    public String getEntCatgCode() {
        return entCatgCode;
    }

    /**
     * 设置市场主体类型大类
     *
     * @param entCatgCode 市场主体类型大类
     */
    public void setEntCatgCode(String entCatgCode) {
        this.entCatgCode = entCatgCode;
    }

    /**
     * 获取年报年度
     *
     * @return YEAR - 年报年度
     */
    public Integer getYEAR() {
        return YEAR;
    }

    /**
     * 设置年报年度
     *
     * @param YEAR 年报年度
     */
    public void setYEAR(Integer YEAR) {
        this.YEAR = YEAR;
    }

    /**
     * 获取已年报数
     *
     * @return isreported - 已年报数
     */
    public BigDecimal getIsreported() {
        return isreported;
    }

    /**
     * 设置已年报数
     *
     * @param isreported 已年报数
     */
    public void setIsreported(BigDecimal isreported) {
        this.isreported = isreported;
    }

    /**
     * 获取因查无下落列入异常且未年报数
     *
     * @return notFound - 因查无下落列入异常且未年报数
     */
    public Double getNotFound() {
        return notFound;
    }

    /**
     * 设置因查无下落列入异常且未年报数
     *
     * @param notFound 因查无下落列入异常且未年报数
     */
    public void setNotFound(Double notFound) {
        this.notFound = notFound;
    }

    /**
     * 获取逾期年报数
     *
     * @return delay - 逾期年报数
     */
    public Double getDelay() {
        return delay;
    }

    /**
     * 设置逾期年报数
     *
     * @param delay 逾期年报数
     */
    public void setDelay(Double delay) {
        this.delay = delay;
    }

    /**
     * 获取数字证书年报数
     *
     * @return keyLogin - 数字证书年报数
     */
    public BigDecimal getKeyLogin() {
        return keyLogin;
    }

    /**
     * 设置数字证书年报数
     *
     * @param keyLogin 数字证书年报数
     */
    public void setKeyLogin(BigDecimal keyLogin) {
        this.keyLogin = keyLogin;
    }

    /**
     * 获取联络员年报数
     *
     * @return passwordLogin - 联络员年报数
     */
    public BigDecimal getPasswordLogin() {
        return passwordLogin;
    }

    /**
     * 设置联络员年报数
     *
     * @param passwordLogin 联络员年报数
     */
    public void setPasswordLogin(BigDecimal passwordLogin) {
        this.passwordLogin = passwordLogin;
    }

    /**
     * 获取纸质报告年报数
     *
     * @return paper - 纸质报告年报数
     */
    public BigDecimal getPaper() {
        return paper;
    }

    /**
     * 设置纸质报告年报数
     *
     * @param paper 纸质报告年报数
     */
    public void setPaper(BigDecimal paper) {
        this.paper = paper;
    }

    /**
     * 获取手机APP年报数
     *
     * @return app - 手机APP年报数
     */
    public BigDecimal getApp() {
        return app;
    }

    /**
     * 设置手机APP年报数
     *
     * @param app 手机APP年报数
     */
    public void setApp(BigDecimal app) {
        this.app = app;
    }

    /**
     * @return updateTime
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}