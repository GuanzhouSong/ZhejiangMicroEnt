/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.yr.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.icinfo.framework.mybatis.mapper.annotation.Before;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 描述:  cs_sfc_balanctsheet 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2016年10月23日
 */
@Table(name = "cs_sfc_balanctsheet")
public class SfcBalanctsheet implements Serializable {
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
     * 货币资金
     */
    @Column(name = "MoneFunds")
    private BigDecimal moneFunds;

    /**
     * 应收款项
     */
    @Column(name = "AccRec")
    private BigDecimal accRec;

    /**
     * 存货
     */
    @Column(name = "Inventory")
    private BigDecimal inventory;

    /**
     * 流动资产合计
     */
    @Column(name = "TotCurrAssets")
    private BigDecimal totCurrAssets;

    /**
     * 对外投资
     */
    @Column(name = "ForInvestAssets")
    private BigDecimal forInvestAssets;

    /**
     * 牲畜(禽)资产
     */
    @Column(name = "LiveStockAssets")
    private BigDecimal liveStockAssets;

    /**
     * 林木资产
     */
    @Column(name = "TreeAssets")
    private BigDecimal treeAssets;

    /**
     * 农业资产合计
     */
    @Column(name = "ArgAssetsAmount")
    private BigDecimal argAssetsAmount;

    /**
     * 固定资产原值
     */
    @Column(name = "FixAssetsOri")
    private BigDecimal fixAssetsOri;

    /**
     * 减：累计折旧
     */
    @Column(name = "AccDepreciation")
    private BigDecimal accDepreciation;

    /**
     * 固定资产净值
     */
    @Column(name = "FixAssetsWorth")
    private BigDecimal fixAssetsWorth;

    /**
     * 固定资产清理
     */
    @Column(name = "FixAssetsClean")
    private BigDecimal fixAssetsClean;

    /**
     * 在建工程
     */
    @Column(name = "ProConstr")
    private BigDecimal proConstr;

    /**
     * 固定资产合计
     */
    @Column(name = "FixAssetsAmount")
    private BigDecimal fixAssetsAmount;

    /**
     * 无形资产
     */
    @Column(name = "IntAssets")
    private BigDecimal intAssets;

    /**
     * 长期资产合计
     */
    @Column(name = "LongAssetsAmount")
    private BigDecimal longAssetsAmount;

    /**
     * 资产总计
     */
    @Column(name = "AssGro")
    private BigDecimal assGro;

    /**
     * 短期借款
     */
    @Column(name = "ShortBorrowing")
    private BigDecimal shortBorrowing;

    /**
     * 应付款项
     */
    @Column(name = "AccPay")
    private BigDecimal accPay;

    /**
     * 应付工资
     */
    @Column(name = "WagePay")
    private BigDecimal wagePay;

    /**
     * 应付盈余返还
     */
    @Column(name = "ReturnSurplusPay")
    private BigDecimal returnSurplusPay;

    /**
     * 应付剩余盈余
     */
    @Column(name = "RemainSurplusPay")
    private BigDecimal remainSurplusPay;

    /**
     * 流动负债合计
     */
    @Column(name = "TotCurrLiab")
    private BigDecimal totCurrLiab;

    /**
     * 长期借款
     */
    @Column(name = "LongBorrowing")
    private BigDecimal longBorrowing;

    /**
     * 专项应付款
     */
    @Column(name = "SpecificPay")
    private BigDecimal specificPay;

    /**
     * 长期负债合计
     */
    @Column(name = "LTermLiaAm")
    private BigDecimal LTermLiaAm;

    /**
     * 负债合计
     */
    @Column(name = "LiaGro")
    private BigDecimal liaGro;

    /**
     *  股金
     */
    @Column(name = "CapitalAmount")
    private BigDecimal capitalAmount;

    /**
     * 专项基金
     */
    @Column(name = "SpecificFund")
    private BigDecimal specificFund;

    /**
     *  资本公积
     */
    @Column(name = "CapAccuFund")
    private BigDecimal capAccuFund;

    /**
     * 盈余公积
     */
    @Column(name = "SurAccuFund")
    private BigDecimal surAccuFund;

    /**
     * 未分配盈余
     */
    @Column(name = "UndistSurplus")
    private BigDecimal undistSurplus;

    /**
     * 所有者权益合计
     */
    @Column(name = "TotEqu")
    private BigDecimal totEqu;

    /**
     * 负债和所有者权益总计
     */
    @Column(name = "TotLiaEqu")
    private BigDecimal totLiaEqu;

    /**
     * 无法收回、尚未批准核销的应收款项
     */
    @Column(name = "ApprAccRec")
    private BigDecimal apprAccRec;

    /**
     * 盘亏、毁损和报废、尚未批准核销的存货
     */
    @Column(name = "ApprInventory")
    private BigDecimal apprInventory;

    /**
     * 无法收回、尚未批准核销的对外投资
     */
    @Column(name = "ApprForInvestAssets")
    private BigDecimal apprForInvestAssets;

    /**
     * 死亡毁损、尚未批准核销的农业资产
     */
    @Column(name = "ApprArgAssets")
    private BigDecimal apprArgAssets;

    /**
     * 盘亏、毁损和报废、尚未批准核销的固定资产
     */
    @Column(name = "ApprFixAssets")
    private BigDecimal apprFixAssets;

    /**
     * 毁损和报废、尚未批准核销的在建工程
     */
    @Column(name = "ApprProConstr")
    private BigDecimal apprProConstr;

    /**
     * 注销和无效、尚未批准核销的无形资产
     */
    @Column(name = "ApprIntAssets")
    private BigDecimal apprIntAssets;

    /**
     * 填表日期
     */
    @Column(name = "CreateTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;

    /**
     * 调整备注
     */
    @Column(name = "Remark")
    private String remark;

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
     * 获取货币资金
     *
     * @return MoneFunds - 货币资金
     */
    public BigDecimal getMoneFunds() {
        return moneFunds;
    }

    /**
     * 设置货币资金
     *
     * @param moneFunds 货币资金
     */
    public void setMoneFunds(BigDecimal moneFunds) {
        this.moneFunds = moneFunds;
    }

    /**
     * 获取应收款项
     *
     * @return AccRec - 应收款项
     */
    public BigDecimal getAccRec() {
        return accRec;
    }

    /**
     * 设置应收款项
     *
     * @param accRec 应收款项
     */
    public void setAccRec(BigDecimal accRec) {
        this.accRec = accRec;
    }

    /**
     * 获取存货
     *
     * @return Inventory - 存货
     */
    public BigDecimal getInventory() {
        return inventory;
    }

    /**
     * 设置存货
     *
     * @param inventory 存货
     */
    public void setInventory(BigDecimal inventory) {
        this.inventory = inventory;
    }

    /**
     * 获取流动资产合计
     *
     * @return TotCurrAssets - 流动资产合计
     */
    public BigDecimal getTotCurrAssets() {
        return totCurrAssets;
    }

    /**
     * 设置流动资产合计
     *
     * @param totCurrAssets 流动资产合计
     */
    public void setTotCurrAssets(BigDecimal totCurrAssets) {
        this.totCurrAssets = totCurrAssets;
    }

    /**
     * 获取对外投资
     *
     * @return ForInvestAssets - 对外投资
     */
    public BigDecimal getForInvestAssets() {
        return forInvestAssets;
    }

    /**
     * 设置对外投资
     *
     * @param forInvestAssets 对外投资
     */
    public void setForInvestAssets(BigDecimal forInvestAssets) {
        this.forInvestAssets = forInvestAssets;
    }

    /**
     * 获取牲畜(禽)资产
     *
     * @return LiveStockAssets - 牲畜(禽)资产
     */
    public BigDecimal getLiveStockAssets() {
        return liveStockAssets;
    }

    /**
     * 设置牲畜(禽)资产
     *
     * @param liveStockAssets 牲畜(禽)资产
     */
    public void setLiveStockAssets(BigDecimal liveStockAssets) {
        this.liveStockAssets = liveStockAssets;
    }

    /**
     * 获取林木资产
     *
     * @return TreeAssets - 林木资产
     */
    public BigDecimal getTreeAssets() {
        return treeAssets;
    }

    /**
     * 设置林木资产
     *
     * @param treeAssets 林木资产
     */
    public void setTreeAssets(BigDecimal treeAssets) {
        this.treeAssets = treeAssets;
    }

    /**
     * 获取农业资产合计
     *
     * @return ArgAssetsAmount - 农业资产合计
     */
    public BigDecimal getArgAssetsAmount() {
        return argAssetsAmount;
    }

    /**
     * 设置农业资产合计
     *
     * @param argAssetsAmount 农业资产合计
     */
    public void setArgAssetsAmount(BigDecimal argAssetsAmount) {
        this.argAssetsAmount = argAssetsAmount;
    }

    /**
     * 获取固定资产原值
     *
     * @return FixAssetsOri - 固定资产原值
     */
    public BigDecimal getFixAssetsOri() {
        return fixAssetsOri;
    }

    /**
     * 设置固定资产原值
     *
     * @param fixAssetsOri 固定资产原值
     */
    public void setFixAssetsOri(BigDecimal fixAssetsOri) {
        this.fixAssetsOri = fixAssetsOri;
    }

    /**
     * 获取减：累计折旧
     *
     * @return AccDepreciation - 减：累计折旧
     */
    public BigDecimal getAccDepreciation() {
        return accDepreciation;
    }

    /**
     * 设置减：累计折旧
     *
     * @param accDepreciation 减：累计折旧
     */
    public void setAccDepreciation(BigDecimal accDepreciation) {
        this.accDepreciation = accDepreciation;
    }

    /**
     * 获取固定资产净值
     *
     * @return FixAssetsWorth - 固定资产净值
     */
    public BigDecimal getFixAssetsWorth() {
        return fixAssetsWorth;
    }

    /**
     * 设置固定资产净值
     *
     * @param fixAssetsWorth 固定资产净值
     */
    public void setFixAssetsWorth(BigDecimal fixAssetsWorth) {
        this.fixAssetsWorth = fixAssetsWorth;
    }

    /**
     * 获取固定资产清理
     *
     * @return FixAssetsClean - 固定资产清理
     */
    public BigDecimal getFixAssetsClean() {
        return fixAssetsClean;
    }

    /**
     * 设置固定资产清理
     *
     * @param fixAssetsClean 固定资产清理
     */
    public void setFixAssetsClean(BigDecimal fixAssetsClean) {
        this.fixAssetsClean = fixAssetsClean;
    }

    /**
     * 获取在建工程
     *
     * @return ProConstr - 在建工程
     */
    public BigDecimal getProConstr() {
        return proConstr;
    }

    /**
     * 设置在建工程
     *
     * @param proConstr 在建工程
     */
    public void setProConstr(BigDecimal proConstr) {
        this.proConstr = proConstr;
    }

    /**
     * 获取固定资产合计
     *
     * @return FixAssetsAmount - 固定资产合计
     */
    public BigDecimal getFixAssetsAmount() {
        return fixAssetsAmount;
    }

    /**
     * 设置固定资产合计
     *
     * @param fixAssetsAmount 固定资产合计
     */
    public void setFixAssetsAmount(BigDecimal fixAssetsAmount) {
        this.fixAssetsAmount = fixAssetsAmount;
    }

    /**
     * 获取无形资产
     *
     * @return IntAssets - 无形资产
     */
    public BigDecimal getIntAssets() {
        return intAssets;
    }

    /**
     * 设置无形资产
     *
     * @param intAssets 无形资产
     */
    public void setIntAssets(BigDecimal intAssets) {
        this.intAssets = intAssets;
    }

    /**
     * 获取长期资产合计
     *
     * @return LongAssetsAmount - 长期资产合计
     */
    public BigDecimal getLongAssetsAmount() {
        return longAssetsAmount;
    }

    /**
     * 设置长期资产合计
     *
     * @param longAssetsAmount 长期资产合计
     */
    public void setLongAssetsAmount(BigDecimal longAssetsAmount) {
        this.longAssetsAmount = longAssetsAmount;
    }

    /**
     * 获取资产总计
     *
     * @return AssGro - 资产总计
     */
    public BigDecimal getAssGro() {
        return assGro;
    }

    /**
     * 设置资产总计
     *
     * @param assGro 资产总计
     */
    public void setAssGro(BigDecimal assGro) {
        this.assGro = assGro;
    }

    /**
     * 获取短期借款
     *
     * @return ShortBorrowing - 短期借款
     */
    public BigDecimal getShortBorrowing() {
        return shortBorrowing;
    }

    /**
     * 设置短期借款
     *
     * @param shortBorrowing 短期借款
     */
    public void setShortBorrowing(BigDecimal shortBorrowing) {
        this.shortBorrowing = shortBorrowing;
    }

    /**
     * 获取应付款项
     *
     * @return AccPay - 应付款项
     */
    public BigDecimal getAccPay() {
        return accPay;
    }

    /**
     * 设置应付款项
     *
     * @param accPay 应付款项
     */
    public void setAccPay(BigDecimal accPay) {
        this.accPay = accPay;
    }

    /**
     * 获取应付工资
     *
     * @return WagePay - 应付工资
     */
    public BigDecimal getWagePay() {
        return wagePay;
    }

    /**
     * 设置应付工资
     *
     * @param wagePay 应付工资
     */
    public void setWagePay(BigDecimal wagePay) {
        this.wagePay = wagePay;
    }

    /**
     * 获取应付盈余返还
     *
     * @return ReturnSurplusPay - 应付盈余返还
     */
    public BigDecimal getReturnSurplusPay() {
        return returnSurplusPay;
    }

    /**
     * 设置应付盈余返还
     *
     * @param returnSurplusPay 应付盈余返还
     */
    public void setReturnSurplusPay(BigDecimal returnSurplusPay) {
        this.returnSurplusPay = returnSurplusPay;
    }

    /**
     * 获取应付剩余盈余
     *
     * @return RemainSurplusPay - 应付剩余盈余
     */
    public BigDecimal getRemainSurplusPay() {
        return remainSurplusPay;
    }

    /**
     * 设置应付剩余盈余
     *
     * @param remainSurplusPay 应付剩余盈余
     */
    public void setRemainSurplusPay(BigDecimal remainSurplusPay) {
        this.remainSurplusPay = remainSurplusPay;
    }

    /**
     * 获取流动负债合计
     *
     * @return TotCurrLiab - 流动负债合计
     */
    public BigDecimal getTotCurrLiab() {
        return totCurrLiab;
    }

    /**
     * 设置流动负债合计
     *
     * @param totCurrLiab 流动负债合计
     */
    public void setTotCurrLiab(BigDecimal totCurrLiab) {
        this.totCurrLiab = totCurrLiab;
    }

    /**
     * 获取长期借款
     *
     * @return LongBorrowing - 长期借款
     */
    public BigDecimal getLongBorrowing() {
        return longBorrowing;
    }

    /**
     * 设置长期借款
     *
     * @param longBorrowing 长期借款
     */
    public void setLongBorrowing(BigDecimal longBorrowing) {
        this.longBorrowing = longBorrowing;
    }

    /**
     * 获取专项应付款
     *
     * @return SpecificPay - 专项应付款
     */
    public BigDecimal getSpecificPay() {
        return specificPay;
    }

    /**
     * 设置专项应付款
     *
     * @param specificPay 专项应付款
     */
    public void setSpecificPay(BigDecimal specificPay) {
        this.specificPay = specificPay;
    }

    /**
     * 获取长期负债合计
     *
     * @return LTermLiaAm - 长期负债合计
     */
    public BigDecimal getLTermLiaAm() {
        return LTermLiaAm;
    }

    /**
     * 设置长期负债合计
     *
     * @param LTermLiaAm 长期负债合计
     */
    public void setLTermLiaAm(BigDecimal LTermLiaAm) {
        this.LTermLiaAm = LTermLiaAm;
    }

    /**
     * 获取负债合计
     *
     * @return LiaGro - 负债合计
     */
    public BigDecimal getLiaGro() {
        return liaGro;
    }

    /**
     * 设置负债合计
     *
     * @param liaGro 负债合计
     */
    public void setLiaGro(BigDecimal liaGro) {
        this.liaGro = liaGro;
    }

    /**
     * 获取 股金
     *
     * @return CapitalAmount -  股金
     */
    public BigDecimal getCapitalAmount() {
        return capitalAmount;
    }

    /**
     * 设置 股金
     *
     * @param capitalAmount  股金
     */
    public void setCapitalAmount(BigDecimal capitalAmount) {
        this.capitalAmount = capitalAmount;
    }

    /**
     * 获取专项基金
     *
     * @return SpecificFund - 专项基金
     */
    public BigDecimal getSpecificFund() {
        return specificFund;
    }

    /**
     * 设置专项基金
     *
     * @param specificFund 专项基金
     */
    public void setSpecificFund(BigDecimal specificFund) {
        this.specificFund = specificFund;
    }

    /**
     * 获取 资本公积
     *
     * @return CapAccuFund -  资本公积
     */
    public BigDecimal getCapAccuFund() {
        return capAccuFund;
    }

    /**
     * 设置 资本公积
     *
     * @param capAccuFund  资本公积
     */
    public void setCapAccuFund(BigDecimal capAccuFund) {
        this.capAccuFund = capAccuFund;
    }

    /**
     * 获取盈余公积
     *
     * @return SurAccuFund - 盈余公积
     */
    public BigDecimal getSurAccuFund() {
        return surAccuFund;
    }

    /**
     * 设置盈余公积
     *
     * @param surAccuFund 盈余公积
     */
    public void setSurAccuFund(BigDecimal surAccuFund) {
        this.surAccuFund = surAccuFund;
    }

    /**
     * 获取未分配盈余
     *
     * @return UndistSurplus - 未分配盈余
     */
    public BigDecimal getUndistSurplus() {
        return undistSurplus;
    }

    /**
     * 设置未分配盈余
     *
     * @param undistSurplus 未分配盈余
     */
    public void setUndistSurplus(BigDecimal undistSurplus) {
        this.undistSurplus = undistSurplus;
    }

    /**
     * 获取所有者权益合计
     *
     * @return TotEqu - 所有者权益合计
     */
    public BigDecimal getTotEqu() {
        return totEqu;
    }

    /**
     * 设置所有者权益合计
     *
     * @param totEqu 所有者权益合计
     */
    public void setTotEqu(BigDecimal totEqu) {
        this.totEqu = totEqu;
    }

    /**
     * 获取负债和所有者权益总计
     *
     * @return TotLiaEqu - 负债和所有者权益总计
     */
    public BigDecimal getTotLiaEqu() {
        return totLiaEqu;
    }

    /**
     * 设置负债和所有者权益总计
     *
     * @param totLiaEqu 负债和所有者权益总计
     */
    public void setTotLiaEqu(BigDecimal totLiaEqu) {
        this.totLiaEqu = totLiaEqu;
    }

    /**
     * 获取无法收回、尚未批准核销的应收款项
     *
     * @return ApprAccRec - 无法收回、尚未批准核销的应收款项
     */
    public BigDecimal getApprAccRec() {
        return apprAccRec;
    }

    /**
     * 设置无法收回、尚未批准核销的应收款项
     *
     * @param apprAccRec 无法收回、尚未批准核销的应收款项
     */
    public void setApprAccRec(BigDecimal apprAccRec) {
        this.apprAccRec = apprAccRec;
    }

    /**
     * 获取盘亏、毁损和报废、尚未批准核销的存货
     *
     * @return ApprInventory - 盘亏、毁损和报废、尚未批准核销的存货
     */
    public BigDecimal getApprInventory() {
        return apprInventory;
    }

    /**
     * 设置盘亏、毁损和报废、尚未批准核销的存货
     *
     * @param apprInventory 盘亏、毁损和报废、尚未批准核销的存货
     */
    public void setApprInventory(BigDecimal apprInventory) {
        this.apprInventory = apprInventory;
    }

    /**
     * 获取无法收回、尚未批准核销的对外投资
     *
     * @return ApprForInvestAssets - 无法收回、尚未批准核销的对外投资
     */
    public BigDecimal getApprForInvestAssets() {
        return apprForInvestAssets;
    }

    /**
     * 设置无法收回、尚未批准核销的对外投资
     *
     * @param apprForInvestAssets 无法收回、尚未批准核销的对外投资
     */
    public void setApprForInvestAssets(BigDecimal apprForInvestAssets) {
        this.apprForInvestAssets = apprForInvestAssets;
    }

    /**
     * 获取死亡毁损、尚未批准核销的农业资产
     *
     * @return ApprArgAssets - 死亡毁损、尚未批准核销的农业资产
     */
    public BigDecimal getApprArgAssets() {
        return apprArgAssets;
    }

    /**
     * 设置死亡毁损、尚未批准核销的农业资产
     *
     * @param apprArgAssets 死亡毁损、尚未批准核销的农业资产
     */
    public void setApprArgAssets(BigDecimal apprArgAssets) {
        this.apprArgAssets = apprArgAssets;
    }

    /**
     * 获取盘亏、毁损和报废、尚未批准核销的固定资产
     *
     * @return ApprFixAssets - 盘亏、毁损和报废、尚未批准核销的固定资产
     */
    public BigDecimal getApprFixAssets() {
        return apprFixAssets;
    }

    /**
     * 设置盘亏、毁损和报废、尚未批准核销的固定资产
     *
     * @param apprFixAssets 盘亏、毁损和报废、尚未批准核销的固定资产
     */
    public void setApprFixAssets(BigDecimal apprFixAssets) {
        this.apprFixAssets = apprFixAssets;
    }

    /**
     * 获取毁损和报废、尚未批准核销的在建工程
     *
     * @return ApprProConstr - 毁损和报废、尚未批准核销的在建工程
     */
    public BigDecimal getApprProConstr() {
        return apprProConstr;
    }

    /**
     * 设置毁损和报废、尚未批准核销的在建工程
     *
     * @param apprProConstr 毁损和报废、尚未批准核销的在建工程
     */
    public void setApprProConstr(BigDecimal apprProConstr) {
        this.apprProConstr = apprProConstr;
    }

    /**
     * 获取注销和无效、尚未批准核销的无形资产
     *
     * @return ApprIntAssets - 注销和无效、尚未批准核销的无形资产
     */
    public BigDecimal getApprIntAssets() {
        return apprIntAssets;
    }

    /**
     * 设置注销和无效、尚未批准核销的无形资产
     *
     * @param apprIntAssets 注销和无效、尚未批准核销的无形资产
     */
    public void setApprIntAssets(BigDecimal apprIntAssets) {
        this.apprIntAssets = apprIntAssets;
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

    /**
     * 获取调整备注
     *
     * @return Remark - 调整备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置调整备注
     *
     * @param remark 调整备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }
}