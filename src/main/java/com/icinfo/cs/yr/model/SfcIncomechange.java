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
 * 描述:  cs_sfc_incomechange 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2016年10月27日
 */
@Table(name = "cs_sfc_incomechange")
public class SfcIncomechange implements Serializable {
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
     * 变动类型
     */
    @Column(name = "ChangeType")
    private String changeType;

    /**
     * 股金-年初余额（万元）
     */
    @Column(name = "ChgStockStartBal")
    private BigDecimal chgStockStartBal;

    /**
     * 股金-本年增加数
     */
    @Column(name = "ChgStockAdd")
    private BigDecimal chgStockAdd;

    /**
     * 股金-本年增加数--资本公积转赠
     */
    @Column(name = "ChgStockAddCap")
    private BigDecimal chgStockAddCap;

    /**
     * 股金-本年增加数--盈余公积转赠
     */
    @Column(name = "ChgStockAddSur")
    private BigDecimal chgStockAddSur;

    /**
     * 股金-本年增加数--成员增加出资
     */
    @Column(name = "ChgStockAddMem")
    private BigDecimal chgStockAddMem;

    /**
     * 股金-本年减少数
     */
    @Column(name = "ChgStockLess")
    private BigDecimal chgStockLess;

    /**
     * 股金-年末余额
     */
    @Column(name = "ChgStockEndBal")
    private BigDecimal chgStockEndBal;

    /**
     * 专项基金-年初余额
     */
    @Column(name = "ChgFundStartBal")
    private BigDecimal chgFundStartBal;

    /**
     * 专项基金-本年增加数
     */
    @Column(name = "ChgFundAdd")
    private BigDecimal chgFundAdd;

    /**
     * 专项基金-本年增加数-国家财政直接补助
     */
    @Column(name = "ChgFundAddSsd")
    private BigDecimal chgFundAddSsd;

    /**
     * 专项基金-本年增加数-接受捐赠转入
     */
    @Column(name = "ChgFundAddDona")
    private BigDecimal chgFundAddDona;

    /**
     * 专项基金-本年减少数
     */
    @Column(name = "ChgFundLess")
    private BigDecimal chgFundLess;

    /**
     * 专项基金-年末余额
     */
    @Column(name = "ChgFundEndBal")
    private BigDecimal chgFundEndBal;

    /**
     * 资本公积--年初余额
     */
    @Column(name = "ChgCapitalStartBal")
    private BigDecimal chgCapitalStartBal;

    /**
     * 资本公积--本年增加数
     */
    @Column(name = "ChgCapitalAdd")
    private BigDecimal chgCapitalAdd;

    /**
     * 资本公积--本年增加数--股金溢价
     */
    @Column(name = "ChgCapitalAddPre")
    private BigDecimal chgCapitalAddPre;

    /**
     * 资本公积-本年增加数--资产评估增值
     */
    @Column(name = "ChgCapitalAddAppr")
    private BigDecimal chgCapitalAddAppr;

    /**
     * 资本公积-本年减少数
     */
    @Column(name = "ChgCapitalLess")
    private BigDecimal chgCapitalLess;

    /**
     * 资本公积-年末余额
     */
    @Column(name = "ChgCapitalEndBal")
    private BigDecimal chgCapitalEndBal;

    /**
     * 盈余公积-年初余额
     */
    @Column(name = "ChgProfitStartBal")
    private BigDecimal chgProfitStartBal;

    /**
     * 盈余公积-本年增加数
     */
    @Column(name = "ChgProfitAdd")
    private BigDecimal chgProfitAdd;

    /**
     * 盈余公积-本年增加数-从盈余中提取
     */
    @Column(name = "ChgProfitAddSur")
    private BigDecimal chgProfitAddSur;

    /**
     * 盈余公积-本年减少数
     */
    @Column(name = "ChgProfitLess")
    private BigDecimal chgProfitLess;

    /**
     * 盈余公积-年末余额
     */
    @Column(name = "ChgProfitEndBal")
    private BigDecimal chgProfitEndBal;

    /**
     * 未分配盈余-年初余额
     */
    @Column(name = "ChgNogetStartBal")
    private BigDecimal chgNogetStartBal;

    /**
     * 未分配盈余-本年增加数
     */
    @Column(name = "ChgNogetAdd")
    private BigDecimal chgNogetAdd;

    /**
     * 未分配盈余-本年减少数
     */
    @Column(name = "ChgNogetLess")
    private BigDecimal chgNogetLess;

    /**
     * 未分配盈余-按交易量（额）分配的盈余
     */
    @Column(name = "ChgNogetLessVol")
    private BigDecimal chgNogetLessVol;

    /**
     * 未分配盈余-剩余盈余分配
     */
    @Column(name = "ChgNogetLessSur")
    private BigDecimal chgNogetLessSur;

    /**
     * 未分配盈余-年末余额
     */
    @Column(name = "ChgNogetEndBal")
    private BigDecimal chgNogetEndBal;

    /**
     * 合计-年初余额
     */
    @Column(name = "ChgTotalStartBal")
    private BigDecimal chgTotalStartBal;

    /**
     * 合计-本年增加数
     */
    @Column(name = "ChgTotalAdd")
    private BigDecimal chgTotalAdd;

    /**
     * 合计-本年减少数
     */
    @Column(name = "ChgTotalLess")
    private BigDecimal chgTotalLess;

    /**
     * 合计-年末余额
     */
    @Column(name = "ChgTotalEndbal")
    private BigDecimal chgTotalEndbal;

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
     * 获取变动类型
     *
     * @return ChangeType - 变动类型
     */
    public String getChangeType() {
        return changeType;
    }

    /**
     * 设置变动类型
     *
     * @param changeType 变动类型
     */
    public void setChangeType(String changeType) {
        this.changeType = changeType;
    }

    /**
     * 获取股金-年初余额（万元）
     *
     * @return ChgStockStartBal - 股金-年初余额（万元）
     */
    public BigDecimal getChgStockStartBal() {
        return chgStockStartBal;
    }

    /**
     * 设置股金-年初余额（万元）
     *
     * @param chgStockStartBal 股金-年初余额（万元）
     */
    public void setChgStockStartBal(BigDecimal chgStockStartBal) {
        this.chgStockStartBal = chgStockStartBal;
    }

    /**
     * 获取股金-本年增加数
     *
     * @return ChgStockAdd - 股金-本年增加数
     */
    public BigDecimal getChgStockAdd() {
        return chgStockAdd;
    }

    /**
     * 设置股金-本年增加数
     *
     * @param chgStockAdd 股金-本年增加数
     */
    public void setChgStockAdd(BigDecimal chgStockAdd) {
        this.chgStockAdd = chgStockAdd;
    }

    /**
     * 获取股金-本年增加数--资本公积转赠
     *
     * @return ChgStockAddCap - 股金-本年增加数--资本公积转赠
     */
    public BigDecimal getChgStockAddCap() {
        return chgStockAddCap;
    }

    /**
     * 设置股金-本年增加数--资本公积转赠
     *
     * @param chgStockAddCap 股金-本年增加数--资本公积转赠
     */
    public void setChgStockAddCap(BigDecimal chgStockAddCap) {
        this.chgStockAddCap = chgStockAddCap;
    }

    /**
     * 获取股金-本年增加数--盈余公积转赠
     *
     * @return ChgStockAddSur - 股金-本年增加数--盈余公积转赠
     */
    public BigDecimal getChgStockAddSur() {
        return chgStockAddSur;
    }

    /**
     * 设置股金-本年增加数--盈余公积转赠
     *
     * @param chgStockAddSur 股金-本年增加数--盈余公积转赠
     */
    public void setChgStockAddSur(BigDecimal chgStockAddSur) {
        this.chgStockAddSur = chgStockAddSur;
    }

    /**
     * 获取股金-本年增加数--成员增加出资
     *
     * @return ChgStockAddMem - 股金-本年增加数--成员增加出资
     */
    public BigDecimal getChgStockAddMem() {
        return chgStockAddMem;
    }

    /**
     * 设置股金-本年增加数--成员增加出资
     *
     * @param chgStockAddMem 股金-本年增加数--成员增加出资
     */
    public void setChgStockAddMem(BigDecimal chgStockAddMem) {
        this.chgStockAddMem = chgStockAddMem;
    }

    /**
     * 获取股金-本年减少数
     *
     * @return ChgStockLess - 股金-本年减少数
     */
    public BigDecimal getChgStockLess() {
        return chgStockLess;
    }

    /**
     * 设置股金-本年减少数
     *
     * @param chgStockLess 股金-本年减少数
     */
    public void setChgStockLess(BigDecimal chgStockLess) {
        this.chgStockLess = chgStockLess;
    }

    /**
     * 获取股金-年末余额
     *
     * @return ChgStockEndBal - 股金-年末余额
     */
    public BigDecimal getChgStockEndBal() {
        return chgStockEndBal;
    }

    /**
     * 设置股金-年末余额
     *
     * @param chgStockEndBal 股金-年末余额
     */
    public void setChgStockEndBal(BigDecimal chgStockEndBal) {
        this.chgStockEndBal = chgStockEndBal;
    }

    /**
     * 获取专项基金-年初余额
     *
     * @return ChgFundStartBal - 专项基金-年初余额
     */
    public BigDecimal getChgFundStartBal() {
        return chgFundStartBal;
    }

    /**
     * 设置专项基金-年初余额
     *
     * @param chgFundStartBal 专项基金-年初余额
     */
    public void setChgFundStartBal(BigDecimal chgFundStartBal) {
        this.chgFundStartBal = chgFundStartBal;
    }

    /**
     * 获取专项基金-本年增加数
     *
     * @return ChgFundAdd - 专项基金-本年增加数
     */
    public BigDecimal getChgFundAdd() {
        return chgFundAdd;
    }

    /**
     * 设置专项基金-本年增加数
     *
     * @param chgFundAdd 专项基金-本年增加数
     */
    public void setChgFundAdd(BigDecimal chgFundAdd) {
        this.chgFundAdd = chgFundAdd;
    }

    /**
     * 获取专项基金-本年增加数-国家财政直接补助
     *
     * @return ChgFundAddSsd - 专项基金-本年增加数-国家财政直接补助
     */
    public BigDecimal getChgFundAddSsd() {
        return chgFundAddSsd;
    }

    /**
     * 设置专项基金-本年增加数-国家财政直接补助
     *
     * @param chgFundAddSsd 专项基金-本年增加数-国家财政直接补助
     */
    public void setChgFundAddSsd(BigDecimal chgFundAddSsd) {
        this.chgFundAddSsd = chgFundAddSsd;
    }

    /**
     * 获取专项基金-本年增加数-接受捐赠转入
     *
     * @return ChgFundAddDona - 专项基金-本年增加数-接受捐赠转入
     */
    public BigDecimal getChgFundAddDona() {
        return chgFundAddDona;
    }

    /**
     * 设置专项基金-本年增加数-接受捐赠转入
     *
     * @param chgFundAddDona 专项基金-本年增加数-接受捐赠转入
     */
    public void setChgFundAddDona(BigDecimal chgFundAddDona) {
        this.chgFundAddDona = chgFundAddDona;
    }

    /**
     * 获取专项基金-本年减少数
     *
     * @return ChgFundLess - 专项基金-本年减少数
     */
    public BigDecimal getChgFundLess() {
        return chgFundLess;
    }

    /**
     * 设置专项基金-本年减少数
     *
     * @param chgFundLess 专项基金-本年减少数
     */
    public void setChgFundLess(BigDecimal chgFundLess) {
        this.chgFundLess = chgFundLess;
    }

    /**
     * 获取专项基金-年末余额
     *
     * @return ChgFundEndBal - 专项基金-年末余额
     */
    public BigDecimal getChgFundEndBal() {
        return chgFundEndBal;
    }

    /**
     * 设置专项基金-年末余额
     *
     * @param chgFundEndBal 专项基金-年末余额
     */
    public void setChgFundEndBal(BigDecimal chgFundEndBal) {
        this.chgFundEndBal = chgFundEndBal;
    }

    /**
     * 获取资本公积--年初余额
     *
     * @return ChgCapitalStartBal - 资本公积--年初余额
     */
    public BigDecimal getChgCapitalStartBal() {
        return chgCapitalStartBal;
    }

    /**
     * 设置资本公积--年初余额
     *
     * @param chgCapitalStartBal 资本公积--年初余额
     */
    public void setChgCapitalStartBal(BigDecimal chgCapitalStartBal) {
        this.chgCapitalStartBal = chgCapitalStartBal;
    }

    /**
     * 获取资本公积--本年增加数
     *
     * @return ChgCapitalAdd - 资本公积--本年增加数
     */
    public BigDecimal getChgCapitalAdd() {
        return chgCapitalAdd;
    }

    /**
     * 设置资本公积--本年增加数
     *
     * @param chgCapitalAdd 资本公积--本年增加数
     */
    public void setChgCapitalAdd(BigDecimal chgCapitalAdd) {
        this.chgCapitalAdd = chgCapitalAdd;
    }

    /**
     * 获取资本公积--本年增加数--股金溢价
     *
     * @return ChgCapitalAddPre - 资本公积--本年增加数--股金溢价
     */
    public BigDecimal getChgCapitalAddPre() {
        return chgCapitalAddPre;
    }

    /**
     * 设置资本公积--本年增加数--股金溢价
     *
     * @param chgCapitalAddPre 资本公积--本年增加数--股金溢价
     */
    public void setChgCapitalAddPre(BigDecimal chgCapitalAddPre) {
        this.chgCapitalAddPre = chgCapitalAddPre;
    }

    /**
     * 获取资本公积-本年增加数--资产评估增值
     *
     * @return ChgCapitalAddAppr - 资本公积-本年增加数--资产评估增值
     */
    public BigDecimal getChgCapitalAddAppr() {
        return chgCapitalAddAppr;
    }

    /**
     * 设置资本公积-本年增加数--资产评估增值
     *
     * @param chgCapitalAddAppr 资本公积-本年增加数--资产评估增值
     */
    public void setChgCapitalAddAppr(BigDecimal chgCapitalAddAppr) {
        this.chgCapitalAddAppr = chgCapitalAddAppr;
    }

    /**
     * 获取资本公积-本年减少数
     *
     * @return ChgCapitalLess - 资本公积-本年减少数
     */
    public BigDecimal getChgCapitalLess() {
        return chgCapitalLess;
    }

    /**
     * 设置资本公积-本年减少数
     *
     * @param chgCapitalLess 资本公积-本年减少数
     */
    public void setChgCapitalLess(BigDecimal chgCapitalLess) {
        this.chgCapitalLess = chgCapitalLess;
    }

    /**
     * 获取资本公积-年末余额
     *
     * @return ChgCapitalEndBal - 资本公积-年末余额
     */
    public BigDecimal getChgCapitalEndBal() {
        return chgCapitalEndBal;
    }

    /**
     * 设置资本公积-年末余额
     *
     * @param chgCapitalEndBal 资本公积-年末余额
     */
    public void setChgCapitalEndBal(BigDecimal chgCapitalEndBal) {
        this.chgCapitalEndBal = chgCapitalEndBal;
    }

    /**
     * 获取盈余公积-年初余额
     *
     * @return ChgProfitStartBal - 盈余公积-年初余额
     */
    public BigDecimal getChgProfitStartBal() {
        return chgProfitStartBal;
    }

    /**
     * 设置盈余公积-年初余额
     *
     * @param chgProfitStartBal 盈余公积-年初余额
     */
    public void setChgProfitStartBal(BigDecimal chgProfitStartBal) {
        this.chgProfitStartBal = chgProfitStartBal;
    }

    /**
     * 获取盈余公积-本年增加数
     *
     * @return ChgProfitAdd - 盈余公积-本年增加数
     */
    public BigDecimal getChgProfitAdd() {
        return chgProfitAdd;
    }

    /**
     * 设置盈余公积-本年增加数
     *
     * @param chgProfitAdd 盈余公积-本年增加数
     */
    public void setChgProfitAdd(BigDecimal chgProfitAdd) {
        this.chgProfitAdd = chgProfitAdd;
    }

    /**
     * 获取盈余公积-本年增加数-从盈余中提取
     *
     * @return ChgProfitAddSur - 盈余公积-本年增加数-从盈余中提取
     */
    public BigDecimal getChgProfitAddSur() {
        return chgProfitAddSur;
    }

    /**
     * 设置盈余公积-本年增加数-从盈余中提取
     *
     * @param chgProfitAddSur 盈余公积-本年增加数-从盈余中提取
     */
    public void setChgProfitAddSur(BigDecimal chgProfitAddSur) {
        this.chgProfitAddSur = chgProfitAddSur;
    }

    /**
     * 获取盈余公积-本年减少数
     *
     * @return ChgProfitLess - 盈余公积-本年减少数
     */
    public BigDecimal getChgProfitLess() {
        return chgProfitLess;
    }

    /**
     * 设置盈余公积-本年减少数
     *
     * @param chgProfitLess 盈余公积-本年减少数
     */
    public void setChgProfitLess(BigDecimal chgProfitLess) {
        this.chgProfitLess = chgProfitLess;
    }

    /**
     * 获取盈余公积-年末余额
     *
     * @return ChgProfitEndBal - 盈余公积-年末余额
     */
    public BigDecimal getChgProfitEndBal() {
        return chgProfitEndBal;
    }

    /**
     * 设置盈余公积-年末余额
     *
     * @param chgProfitEndBal 盈余公积-年末余额
     */
    public void setChgProfitEndBal(BigDecimal chgProfitEndBal) {
        this.chgProfitEndBal = chgProfitEndBal;
    }

    /**
     * 获取未分配盈余-年初余额
     *
     * @return ChgNogetStartBal - 未分配盈余-年初余额
     */
    public BigDecimal getChgNogetStartBal() {
        return chgNogetStartBal;
    }

    /**
     * 设置未分配盈余-年初余额
     *
     * @param chgNogetStartBal 未分配盈余-年初余额
     */
    public void setChgNogetStartBal(BigDecimal chgNogetStartBal) {
        this.chgNogetStartBal = chgNogetStartBal;
    }

    /**
     * 获取未分配盈余-本年增加数
     *
     * @return ChgNogetAdd - 未分配盈余-本年增加数
     */
    public BigDecimal getChgNogetAdd() {
        return chgNogetAdd;
    }

    /**
     * 设置未分配盈余-本年增加数
     *
     * @param chgNogetAdd 未分配盈余-本年增加数
     */
    public void setChgNogetAdd(BigDecimal chgNogetAdd) {
        this.chgNogetAdd = chgNogetAdd;
    }

    /**
     * 获取未分配盈余-本年减少数
     *
     * @return ChgNogetLess - 未分配盈余-本年减少数
     */
    public BigDecimal getChgNogetLess() {
        return chgNogetLess;
    }

    /**
     * 设置未分配盈余-本年减少数
     *
     * @param chgNogetLess 未分配盈余-本年减少数
     */
    public void setChgNogetLess(BigDecimal chgNogetLess) {
        this.chgNogetLess = chgNogetLess;
    }

    /**
     * 获取未分配盈余-按交易量（额）分配的盈余
     *
     * @return ChgNogetLessVol - 未分配盈余-按交易量（额）分配的盈余
     */
    public BigDecimal getChgNogetLessVol() {
        return chgNogetLessVol;
    }

    /**
     * 设置未分配盈余-按交易量（额）分配的盈余
     *
     * @param chgNogetLessVol 未分配盈余-按交易量（额）分配的盈余
     */
    public void setChgNogetLessVol(BigDecimal chgNogetLessVol) {
        this.chgNogetLessVol = chgNogetLessVol;
    }

    /**
     * 获取未分配盈余-剩余盈余分配
     *
     * @return ChgNogetLessSur - 未分配盈余-剩余盈余分配
     */
    public BigDecimal getChgNogetLessSur() {
        return chgNogetLessSur;
    }

    /**
     * 设置未分配盈余-剩余盈余分配
     *
     * @param chgNogetLessSur 未分配盈余-剩余盈余分配
     */
    public void setChgNogetLessSur(BigDecimal chgNogetLessSur) {
        this.chgNogetLessSur = chgNogetLessSur;
    }

    /**
     * 获取未分配盈余-年末余额
     *
     * @return ChgNogetEndBal - 未分配盈余-年末余额
     */
    public BigDecimal getChgNogetEndBal() {
        return chgNogetEndBal;
    }

    /**
     * 设置未分配盈余-年末余额
     *
     * @param chgNogetEndBal 未分配盈余-年末余额
     */
    public void setChgNogetEndBal(BigDecimal chgNogetEndBal) {
        this.chgNogetEndBal = chgNogetEndBal;
    }

    /**
     * 获取合计-年初余额
     *
     * @return ChgTotalStartBal - 合计-年初余额
     */
    public BigDecimal getChgTotalStartBal() {
        return chgTotalStartBal;
    }

    /**
     * 设置合计-年初余额
     *
     * @param chgTotalStartBal 合计-年初余额
     */
    public void setChgTotalStartBal(BigDecimal chgTotalStartBal) {
        this.chgTotalStartBal = chgTotalStartBal;
    }

    /**
     * 获取合计-本年增加数
     *
     * @return ChgTotalAdd - 合计-本年增加数
     */
    public BigDecimal getChgTotalAdd() {
        return chgTotalAdd;
    }

    /**
     * 设置合计-本年增加数
     *
     * @param chgTotalAdd 合计-本年增加数
     */
    public void setChgTotalAdd(BigDecimal chgTotalAdd) {
        this.chgTotalAdd = chgTotalAdd;
    }

    /**
     * 获取合计-本年减少数
     *
     * @return ChgTotalLess - 合计-本年减少数
     */
    public BigDecimal getChgTotalLess() {
        return chgTotalLess;
    }

    /**
     * 设置合计-本年减少数
     *
     * @param chgTotalLess 合计-本年减少数
     */
    public void setChgTotalLess(BigDecimal chgTotalLess) {
        this.chgTotalLess = chgTotalLess;
    }

    /**
     * 获取合计-年末余额
     *
     * @return ChgTotalEndbal - 合计-年末余额
     */
    public BigDecimal getChgTotalEndbal() {
        return chgTotalEndbal;
    }

    /**
     * 设置合计-年末余额
     *
     * @param chgTotalEndbal 合计-年末余额
     */
    public void setChgTotalEndbal(BigDecimal chgTotalEndbal) {
        this.chgTotalEndbal = chgTotalEndbal;
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