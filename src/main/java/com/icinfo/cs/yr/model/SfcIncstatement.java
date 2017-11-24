/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.yr.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.icinfo.framework.mybatis.mapper.annotation.Before;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

/**
 * 描述:  cs_sfc_incstatement 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2016年10月23日
 */
@Table(name = "cs_sfc_incstatement")
public class SfcIncstatement implements Serializable {
    /**
     * 自增ID
     */
    @Id
    @Column(name = "id")
    private Integer id;

    /**
     * 序号
     */
    @Column(name = "UID")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    private String uid;

    /**
     * 主体身份代码
     */
    @Column(name = "PriPID")
    private String priPID;

    /**
     * 年度
     */
    @Column(name = "Year")
    private Integer year;

    /**
     * 1年末数，0年初数
     */
    @Column(name = "BalanceType")
    private String balanceType;

    /**
     * 经营收入
     */
    @Column(name = "BusInc")
    private BigDecimal busInc;

    /**
     * 加：投资收益
     */
    @Column(name = "AnnDisInc")
    private BigDecimal annDisInc;

    /**
     * 减：经营支出
     */
    @Column(name = "BusSpend")
    private BigDecimal busSpend;

    /**
     * 管理费用
     */
    @Column(name = "ManageFees")
    private BigDecimal manageFees;

    /**
     * 经营收益
     */
    @Column(name = "BusEarn")
    private BigDecimal busEarn;

    /**
     * 加：其他收入
     */
    @Column(name = "OtherInc")
    private BigDecimal otherInc;

    /**
     * 减：其他支出
     */
    @Column(name = "OtherSpend")
    private BigDecimal otherSpend;

    /**
     * 三、本年盈余
     */
    @Column(name = "ThisSurplus")
    private BigDecimal thisSurplus;

    /**
     * 四、本年盈余
     */
    @Column(name = "ThatSurplus")
    private BigDecimal thatSurplus;

    /**
     * 加：年初未分配盈余
     */
    @Column(name = "UndistSurplusBegin")
    private BigDecimal undistSurplusBegin;

    /**
     * 其他转入
     */
    @Column(name = "OtherTrans")
    private BigDecimal otherTrans;

    /**
     * 五、可分配盈余
     */
    @Column(name = "DistSurplus")
    private BigDecimal distSurplus;

    /**
     * 减：提取盈余公积
     */
    @Column(name = "ExtSurAccuFund")
    private BigDecimal extSurAccuFund;

    /**
     * 盈余返还
     */
    @Column(name = "ReturnSurplusPay")
    private BigDecimal returnSurplusPay;

    /**
     * 剩余盈余分配
     */
    @Column(name = "RemainSurplusPay")
    private BigDecimal remainSurplusPay;

    /**
     * 六、年末未分配盈余
     */
    @Column(name = "UndistSurplusEnd")
    private BigDecimal undistSurplusEnd;

    /**
     * 填表日期
     */
    @Column(name = "CreateTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;

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
     * 获取序号
     *
     * @return uid - 序号
     */
    public String getUid() {
        return uid;
    }

    /**
     * 设置序号
     *
     * @param uid 序号
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
     * 获取年度
     *
     * @return Year - 年度
     */
    public Integer getYear() {
        return year;
    }

    /**
     * 设置年度
     *
     * @param year 年度
     */
    public void setYear(Integer year) {
        this.year = year;
    }

    /**
     * 获取1年末数，0年初数
     *
     * @return BalanceType - 1年末数，0年初数
     */
    public String getBalanceType() {
        return balanceType;
    }

    /**
     * 设置1年末数，0年初数
     *
     * @param balanceType 1年末数，0年初数
     */
    public void setBalanceType(String balanceType) {
        this.balanceType = balanceType;
    }

    /**
     * 获取经营收入
     *
     * @return BusInc - 经营收入
     */
    public BigDecimal getBusInc() {
        return busInc;
    }

    /**
     * 设置经营收入
     *
     * @param busInc 经营收入
     */
    public void setBusInc(BigDecimal busInc) {
        this.busInc = busInc;
    }

    /**
     * 获取加：投资收益
     *
     * @return AnnDisInc - 加：投资收益
     */
    public BigDecimal getAnnDisInc() {
        return annDisInc;
    }

    /**
     * 设置加：投资收益
     *
     * @param annDisInc 加：投资收益
     */
    public void setAnnDisInc(BigDecimal annDisInc) {
        this.annDisInc = annDisInc;
    }

    /**
     * 获取减：经营支出
     *
     * @return BusSpend - 减：经营支出
     */
    public BigDecimal getBusSpend() {
        return busSpend;
    }

    /**
     * 设置减：经营支出
     *
     * @param busSpend 减：经营支出
     */
    public void setBusSpend(BigDecimal busSpend) {
        this.busSpend = busSpend;
    }

    /**
     * 获取管理费用
     *
     * @return ManageFees - 管理费用
     */
    public BigDecimal getManageFees() {
        return manageFees;
    }

    /**
     * 设置管理费用
     *
     * @param manageFees 管理费用
     */
    public void setManageFees(BigDecimal manageFees) {
        this.manageFees = manageFees;
    }

    /**
     * 获取经营收益
     *
     * @return BusEarn - 经营收益
     */
    public BigDecimal getBusEarn() {
        return busEarn;
    }

    /**
     * 设置经营收益
     *
     * @param busEarn 经营收益
     */
    public void setBusEarn(BigDecimal busEarn) {
        this.busEarn = busEarn;
    }

    /**
     * 获取加：其他收入
     *
     * @return OtherInc - 加：其他收入
     */
    public BigDecimal getOtherInc() {
        return otherInc;
    }

    /**
     * 设置加：其他收入
     *
     * @param otherInc 加：其他收入
     */
    public void setOtherInc(BigDecimal otherInc) {
        this.otherInc = otherInc;
    }

    /**
     * 获取减：其他支出
     *
     * @return OtherSpend - 减：其他支出
     */
    public BigDecimal getOtherSpend() {
        return otherSpend;
    }

    /**
     * 设置减：其他支出
     *
     * @param otherSpend 减：其他支出
     */
    public void setOtherSpend(BigDecimal otherSpend) {
        this.otherSpend = otherSpend;
    }

    /**
     * 获取三、本年盈余
     *
     * @return ThisSurplus - 三、本年盈余
     */
    public BigDecimal getThisSurplus() {
        return thisSurplus;
    }

    /**
     * 设置三、本年盈余
     *
     * @param thisSurplus 三、本年盈余
     */
    public void setThisSurplus(BigDecimal thisSurplus) {
        this.thisSurplus = thisSurplus;
    }

    /**
     * 获取四、本年盈余
     *
     * @return ThatSurplus - 四、本年盈余
     */
    public BigDecimal getThatSurplus() {
        return thatSurplus;
    }

    /**
     * 设置四、本年盈余
     *
     * @param thatSurplus 四、本年盈余
     */
    public void setThatSurplus(BigDecimal thatSurplus) {
        this.thatSurplus = thatSurplus;
    }

    /**
     * 获取加：年初未分配盈余
     *
     * @return UndistSurplusBegin - 加：年初未分配盈余
     */
    public BigDecimal getUndistSurplusBegin() {
        return undistSurplusBegin;
    }

    /**
     * 设置加：年初未分配盈余
     *
     * @param undistSurplusBegin 加：年初未分配盈余
     */
    public void setUndistSurplusBegin(BigDecimal undistSurplusBegin) {
        this.undistSurplusBegin = undistSurplusBegin;
    }

    /**
     * 获取其他转入
     *
     * @return OtherTrans - 其他转入
     */
    public BigDecimal getOtherTrans() {
        return otherTrans;
    }

    /**
     * 设置其他转入
     *
     * @param otherTrans 其他转入
     */
    public void setOtherTrans(BigDecimal otherTrans) {
        this.otherTrans = otherTrans;
    }

    /**
     * 获取五、可分配盈余
     *
     * @return DistSurplus - 五、可分配盈余
     */
    public BigDecimal getDistSurplus() {
        return distSurplus;
    }

    /**
     * 设置五、可分配盈余
     *
     * @param distSurplus 五、可分配盈余
     */
    public void setDistSurplus(BigDecimal distSurplus) {
        this.distSurplus = distSurplus;
    }

    /**
     * 获取减：提取盈余公积
     *
     * @return ExtSurAccuFund - 减：提取盈余公积
     */
    public BigDecimal getExtSurAccuFund() {
        return extSurAccuFund;
    }

    /**
     * 设置减：提取盈余公积
     *
     * @param extSurAccuFund 减：提取盈余公积
     */
    public void setExtSurAccuFund(BigDecimal extSurAccuFund) {
        this.extSurAccuFund = extSurAccuFund;
    }

    /**
     * 获取盈余返还
     *
     * @return ReturnSurplusPay - 盈余返还
     */
    public BigDecimal getReturnSurplusPay() {
        return returnSurplusPay;
    }

    /**
     * 设置盈余返还
     *
     * @param returnSurplusPay 盈余返还
     */
    public void setReturnSurplusPay(BigDecimal returnSurplusPay) {
        this.returnSurplusPay = returnSurplusPay;
    }

    /**
     * 获取剩余盈余分配
     *
     * @return RemainSurplusPay - 剩余盈余分配
     */
    public BigDecimal getRemainSurplusPay() {
        return remainSurplusPay;
    }

    /**
     * 设置剩余盈余分配
     *
     * @param remainSurplusPay 剩余盈余分配
     */
    public void setRemainSurplusPay(BigDecimal remainSurplusPay) {
        this.remainSurplusPay = remainSurplusPay;
    }

    /**
     * 获取六、年末未分配盈余
     *
     * @return UndistSurplusEnd - 六、年末未分配盈余
     */
    public BigDecimal getUndistSurplusEnd() {
        return undistSurplusEnd;
    }

    /**
     * 设置六、年末未分配盈余
     *
     * @param undistSurplusEnd 六、年末未分配盈余
     */
    public void setUndistSurplusEnd(BigDecimal undistSurplusEnd) {
        this.undistSurplusEnd = undistSurplusEnd;
    }

    /**
     * 获取填表日期
     *
     * @return CreateTime - 填表日期
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置填表日期
     *
     * @param createTime 填表日期
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}