/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.rpt.rptmodel;

import com.icinfo.framework.mybatis.mapper.annotation.Before;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * 描述:    cs_rpt_warning_info 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年10月18日
 */
@Table(name = "cs_rpt_warning_info")
public class RptWarningInfo implements Serializable {
    @Id
    @Column(name = "id")
    private Integer id;

    /**
     * 2.1.1食品许可到期
     */
    @Column(name = "foodexpired")
    private Integer foodexpired;

    @Column(name = "areacode")
    private String areacode;

    @Column(name = "regorg")
    private String regorg;

    @Column(name = "localadm")
    private String localadm;

    /**
     * 2.1.2药品许可到期
     */
    @Column(name = "drugexpired")
    private Integer drugexpired;

    /**
     *  2.1.5任职资格受限
     */
    @Column(name = "qualifilimit")
    private Integer qualifilimit;

    /**
     * 2.2.1年报逾期未报
     */
    @Column(name = "reporteover")
    private Integer reporteover;

    /**
     * 2.2.2年报信息异常
     */
    @Column(name = "reporteabnormal")
    private Integer reporteabnormal;

    /**
     * 2.4.1年报逾期未列入异常
     */
    @Column(name = "notopanomaly")
    private Integer notopanomaly;

    /**
     * 2.4.2补报后未移出异常
     */
    @Column(name = "notremove")
    private Integer notremove;

    /**
     * 2.4.3查无下落后变更
     */
    @Column(name = "notfoundalter")
    private Integer notfoundalter;

    /**
     * 2.4.4查无下落后年报
     */
    @Column(name = "notfoundreported")
    private Integer notfoundreported;

    /**
     * 2.4.5异常异常将满三年
     */
    @Column(name = "illdisdetail")
    private Integer illdisdetail;

    @Column(name = "createtime")
    private Date createtime;

    private static final long serialVersionUID = 1L;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取2.1.1食品许可到期
     *
     * @return foodexpired - 2.1.1食品许可到期
     */
    public Integer getFoodexpired() {
        return foodexpired;
    }

    /**
     * 设置2.1.1食品许可到期
     *
     * @param foodexpired 2.1.1食品许可到期
     */
    public void setFoodexpired(Integer foodexpired) {
        this.foodexpired = foodexpired;
    }

    /**
     * @return areacode
     */
    public String getAreacode() {
        return areacode;
    }

    /**
     * @param areacode
     */
    public void setAreacode(String areacode) {
        this.areacode = areacode;
    }

    /**
     * @return regorg
     */
    public String getRegorg() {
        return regorg;
    }

    /**
     * @param regorg
     */
    public void setRegorg(String regorg) {
        this.regorg = regorg;
    }

    /**
     * @return localadm
     */
    public String getLocaladm() {
        return localadm;
    }

    /**
     * @param localadm
     */
    public void setLocaladm(String localadm) {
        this.localadm = localadm;
    }

    /**
     * 获取2.1.2药品许可到期
     *
     * @return drugexpired - 2.1.2药品许可到期
     */
    public Integer getDrugexpired() {
        return drugexpired;
    }

    /**
     * 设置2.1.2药品许可到期
     *
     * @param drugexpired 2.1.2药品许可到期
     */
    public void setDrugexpired(Integer drugexpired) {
        this.drugexpired = drugexpired;
    }

    /**
     * 获取 2.1.5任职资格受限
     *
     * @return qualifilimit -  2.1.5任职资格受限
     */
    public Integer getQualifilimit() {
        return qualifilimit;
    }

    /**
     * 设置 2.1.5任职资格受限
     *
     * @param qualifilimit  2.1.5任职资格受限
     */
    public void setQualifilimit(Integer qualifilimit) {
        this.qualifilimit = qualifilimit;
    }

    /**
     * 获取2.2.1年报逾期未报
     *
     * @return reporteover - 2.2.1年报逾期未报
     */
    public Integer getReporteover() {
        return reporteover;
    }

    /**
     * 设置2.2.1年报逾期未报
     *
     * @param reporteover 2.2.1年报逾期未报
     */
    public void setReporteover(Integer reporteover) {
        this.reporteover = reporteover;
    }

    /**
     * 获取2.2.2年报信息异常
     *
     * @return reporteabnormal - 2.2.2年报信息异常
     */
    public Integer getReporteabnormal() {
        return reporteabnormal;
    }

    /**
     * 设置2.2.2年报信息异常
     *
     * @param reporteabnormal 2.2.2年报信息异常
     */
    public void setReporteabnormal(Integer reporteabnormal) {
        this.reporteabnormal = reporteabnormal;
    }

    /**
     * 获取2.4.1年报逾期未列入异常
     *
     * @return notopanomaly - 2.4.1年报逾期未列入异常
     */
    public Integer getNotopanomaly() {
        return notopanomaly;
    }

    /**
     * 设置2.4.1年报逾期未列入异常
     *
     * @param notopanomaly 2.4.1年报逾期未列入异常
     */
    public void setNotopanomaly(Integer notopanomaly) {
        this.notopanomaly = notopanomaly;
    }

    /**
     * 获取2.4.2补报后未移出异常
     *
     * @return notremove - 2.4.2补报后未移出异常
     */
    public Integer getNotremove() {
        return notremove;
    }

    /**
     * 设置2.4.2补报后未移出异常
     *
     * @param notremove 2.4.2补报后未移出异常
     */
    public void setNotremove(Integer notremove) {
        this.notremove = notremove;
    }

    /**
     * 获取2.4.3查无下落后变更
     *
     * @return notfoundalter - 2.4.3查无下落后变更
     */
    public Integer getNotfoundalter() {
        return notfoundalter;
    }

    /**
     * 设置2.4.3查无下落后变更
     *
     * @param notfoundalter 2.4.3查无下落后变更
     */
    public void setNotfoundalter(Integer notfoundalter) {
        this.notfoundalter = notfoundalter;
    }

    /**
     * 获取2.4.4查无下落后年报
     *
     * @return notfoundreported - 2.4.4查无下落后年报
     */
    public Integer getNotfoundreported() {
        return notfoundreported;
    }

    /**
     * 设置2.4.4查无下落后年报
     *
     * @param notfoundreported 2.4.4查无下落后年报
     */
    public void setNotfoundreported(Integer notfoundreported) {
        this.notfoundreported = notfoundreported;
    }

    /**
     * 获取2.4.5异常异常将满三年
     *
     * @return illdisdetail - 2.4.5异常异常将满三年
     */
    public Integer getIlldisdetail() {
        return illdisdetail;
    }

    /**
     * 设置2.4.5异常异常将满三年
     *
     * @param illdisdetail 2.4.5异常异常将满三年
     */
    public void setIlldisdetail(Integer illdisdetail) {
        this.illdisdetail = illdisdetail;
    }

    /**
     * @return createtime
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * @param createtime
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}