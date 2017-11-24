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
 * 描述:  cs_sfc_cominfo 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2016年10月19日
 */
@Table(name = "cs_sfc_cominfo")
public class SfcCominfo implements Serializable {
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
     * 内部序号
     */
    @Column(name = "PriPID")
    private String priPID;

    /**
     * 年度
     */
    @Column(name = "Year")
    private Integer year;

    /**
     * 合作社类型：1.种植类 2.养殖类 3.服务类 4.营销类
     */
    @Column(name = "FarArtType")
    private String farArtType;

    /**
     * 主要农产品名称
     */
    @Column(name = "FarArtProName")
    private String farArtProName;

    /**
     * 已获得的农产品认证：无公害产品认证；0.无 1.有
     */
    @Column(name = "FarArtPolFreeCe")
    private String farArtPolFreeCe;

    /**
     * 已获得的农产品认证：绿色有机产品认证；0.无 1.有
     */
    @Column(name = "FarArtGreenOrgCe")
    private String farArtGreenOrgCe;

    /**
     * 已获得的农产品认证：有机农产品认证；0.无 1.有
     */
    @Column(name = "FarArtOrgCe")
    private String farArtOrgCe;

    /**
     * 已获得的农产品认证：农产品地理；0.无 1.有
     */
    @Column(name = "FarArtGeoCe")
    private String farArtGeoCe;

    /**
     * 合作社成员数
     */
    @Column(name = "FarArtMemNum")
    private Integer farArtMemNum;

    /**
     * 生产基地面积；单位：亩
     */
    @Column(name = "FarArtArea")
    private BigDecimal farArtArea;

    /**
     * 带动农户；单位：户
     */
    @Column(name = "FarArtDriFarmerNum")
    private Integer farArtDriFarmerNum;

    /**
     * 自有产权房面积；单位：平方米
     */
    @Column(name = "FarArtPriProArea")
    private BigDecimal farArtPriProArea;

    /**
     * 自有生产经营设备价值；单位：万元
     */
    @Column(name = "FarArtOpeEquVal")
    private BigDecimal farArtOpeEquVal;

    /**
     * 合作社投资总规模；单位：万元
     */
    @Column(name = "FarArtCoopTotalInv")
    private BigDecimal farArtCoopTotalInv;

    /**
     * 其中：成员出资；单位：万元
     */
    @Column(name = "FarArtMemInv")
    private BigDecimal farArtMemInv;

    /**
     * 贷款额,单位：万元
     */
    @Column(name = "FarArtLoanAmount")
    private BigDecimal farArtLoanAmount;

    /**
     * 政府补助；单位：万元
     */
    @Column(name = "FarArtGovGrants")
    private BigDecimal farArtGovGrants;

    /**
     * 主要营销市场；1.省内2.省外3.国外
     */
    @Column(name = "FarArtMarketing")
    private String farArtMarketing;

    /**
     * 上年度销售总额；单位：万元
     */
    @Column(name = "FarArtTotalSales")
    private BigDecimal farArtTotalSales;

    /**
     * 销售额年增长率；单位：%
     */
    @Column(name = "FarArtSalesIncRatio")
    private BigDecimal farArtSalesIncRatio;

    /**
     * 利润总额；单位：万元
     */
    @Column(name = "FarArtTotalProfit")
    private BigDecimal farArtTotalProfit;

    /**
     * 全年纳税总额；单位：万元
     */
    @Column(name = "FarArtTaxAmount")
    private BigDecimal farArtTaxAmount;

    /**
     * 其中：所得税总额；单位：%
     */
    @Column(name = "FarArtGroIncTax")
    private BigDecimal farArtGroIncTax;

    /**
     * 享受扶持资金；单位：万元
     */
    @Column(name = "FarArtSupFinancing")
    private BigDecimal farArtSupFinancing;

    /**
     * 税费减免总额；单位：万元
     */
    @Column(name = "FarArtTotalTaxCuts")
    private BigDecimal farArtTotalTaxCuts;

    /**
     * 社员年均纯收入；单位：元
     */
    @Column(name = "FarArtAreNetIncome")
    private BigDecimal farArtAreNetIncome;

    /**
     * 统一采购农业投入品比例；单位：%
     */
    @Column(name = "FarArtInpProRatio")
    private BigDecimal farArtInpProRatio;

    /**
     * 统一销售主产品比例；单位：%
     */
    @Column(name = "FarArtSaleProRatio")
    private BigDecimal farArtSaleProRatio;

    /**
     * 开展初加工后销售；0.否 1.是
     */
    @Column(name = "FarArtPreSales")
    private String farArtPreSales;

    /**
     * 开展深加工后销售；0.否 1.是
     */
    @Column(name = "FarArtDeepSales")
    private String farArtDeepSales;

    /**
     * 实现农超对接；0.否 1.是
     */
    @Column(name = "FarArtLinkFarSupmarket")
    private String farArtLinkFarSupmarket;

    /**
     * 已执行的事项：设立监事会；0.无 1.有
     */
    @Column(name = "FarArtSupBoardItem")
    private String farArtSupBoardItem;

    /**
     * 已执行的事项：定期召开社员大会；0.无 1.有
     */
    @Column(name = "FarArtMemMeetingItem")
    private String farArtMemMeetingItem;

    /**
     * 已执行的事项：建立会计核算；0.无 1.有
     */
    @Column(name = "FarArtAccItem")
    private String farArtAccItem;

    /**
     * 已执行的事项：定期财务公开；0.无 1.有
     */
    @Column(name = "FarArtFinDisItem")
    private String farArtFinDisItem;

    /**
     * 其他事项执行情况
     */
    @Column(name = "FarArtOtherItem")
    private String farArtOtherItem;

    /**
     * 使用的订单合同有：示范合同文本；0.无 1.有
     */
    @Column(name = "FarArtModelCont")
    private String farArtModelCont;

    /**
     * 使用的订单合同有：自制合同文本；0.无 1.有
     */
    @Column(name = "FarArtSelfMadeCont")
    private String farArtSelfMadeCont;

    /**
     * 上年度订单合同份数；单位：份
     */
    @Column(name = "FarArtContNum")
    private Integer farArtContNum;

    /**
     * 合同金额；单位：万元
     */
    @Column(name = "FarArtContAmount")
    private BigDecimal farArtContAmount;

    /**
     * 签约农户；单位：户
     */
    @Column(name = "FarArtSignFarmerNum")
    private Integer farArtSignFarmerNum;

    /**
     * 注册商标；单位：只
     */
    @Column(name = "FarArtRegMark")
    private Integer farArtRegMark;

    /**
     * 其中拥有：国家级驰名商标；0.无 1.有
     */
    @Column(name = "FarArtNatMarkNum")
    private String farArtNatMarkNum;

    /**
     * 其中拥有：省级著名商标 0.无 1.有
     */
    @Column(name = "FarArtProMarkNum")
    private String farArtProMarkNum;

    /**
     * 其中拥有：市级知名商标 ；0.无 1.有
     */
    @Column(name = "FarArtCityMarkNum")
    private String farArtCityMarkNum;

    /**
     * 使用证明商标；0.无 1.有
     */
    @Column(name = "FarArtUseCeMark")
    private String farArtUseCeMark;

    /**
     * 获得专利或其他知识产权；0.无 1.有
     */
    @Column(name = "FarArtPatent")
    private String farArtPatent;

    /**
     * 已获得：省知名商号；0.无 1.有
     */
    @Column(name = "FarArtProTradeName")
    private String farArtProTradeName;

    /**
     * 已获得：市知名商号；0.无 1.有
     */
    @Column(name = "FarArtCityTradeName")
    private String farArtCityTradeName;

    /**
     * 上年度组织开展技术培训；0.无 1.有
     */
    @Column(name = "FarArtTecTrain")
    private String farArtTecTrain;

    /**
     * 培训师资来源：外聘；0.无 1.有
     */
    @Column(name = "FarArtTeaExt")
    private String farArtTeaExt;

    /**
     * 培训师资来源：自有；0.无 1.有
     */
    @Column(name = "FarArtTeaInt")
    private String farArtTeaInt;

    /**
     * 上年度组织或参加培训总次数；单位：次
     */
    @Column(name = "FarArtTrainNum")
    private Integer farArtTrainNum;

    /**
     * 参加培训人员；单位：人/次
     */
    @Column(name = "FarArtMemAttNum")
    private Integer farArtMemAttNum;

    /**
     * 已开展的质量工作有：执行农产品质量标准；0.无 1.有
     */
    @Column(name = "FarArtQuaSta")
    private String farArtQuaSta;

    /**
     * 已开展的质量工作有：建立农产品质量追溯制度；0.无 1.有
     */
    @Column(name = "FarArtQuaTraSys")
    private String farArtQuaTraSys;

    /**
     * 已开展的质量工作有：获得产品质量体系认证；0.无 1.有
     */
    @Column(name = "FarArtQuaSys")
    private String farArtQuaSys;

    /**
     * 已开展的质量工作有：建立风险储备金制度；0.无 1.有
     */
    @Column(name = "FarArtQuaRiskSys")
    private String farArtQuaRiskSys;

    /**
     * 设立独立网站或网页；0.无 1.有
     */
    @Column(name = "FarArtWebsite")
    private String farArtWebsite;

    /**
     * 网站名称
     */
    @Column(name = "FarArtWebName")
    private String farArtWebName;

    /**
     * 网址
     */
    @Column(name = "FarArtWebUrl")
    private String farArtWebUrl;

    /**
     * 运用互联网络发布信息；0.无 1.有
     */
    @Column(name = "FarArtNetRelInfo")
    private String farArtNetRelInfo;

    /**
     * 其中累计用于网络广告费用
     */
    @Column(name = "FarArtNetAdCost")
    private BigDecimal farArtNetAdCost;

    /**
     * 通过网络销售产品或服务；0.无 1.有
     */
    @Column(name = "FarArtNetSales")
    private String farArtNetSales;

    /**
     * 其中上年度网上销售额
     */
    @Column(name = "FarArtNetSalesAmount")
    private BigDecimal farArtNetSalesAmount;

    /**
     * 示范合作社验收情况，已获得：1.国家级 2.省级3.市级4.县级5.目前正在申报
     */
    @Column(name = "FarArtDemoCoopGrade")
    private String farArtDemoCoopGrade;

    /**
     * 开户银行（基本户）
     */
    @Column(name = "FarArtBank")
    private String farArtBank;

    /**
     * 账号
     */
    @Column(name = "FarArtBankAccount")
    private String farArtBankAccount;

    /**
     * 信用等级；01：AAA 02：AA 03：A 04：B 05：C 06：D
     */
    @Column(name = "FarArtCreditLevel")
    private String farArtCreditLevel;

    /**
     * 组织机构代码证号
     */
    @Column(name = "EntOrgCode")
    private String entOrgCode;

    /**
     * 税务登记证号
     */
    @Column(name = "TaxRegNo")
    private String taxRegNo;

    /**
     * 合作社负责人或社会中担任：人大代表；0：无1：县级2：市级3：省级4：国家级
     */
    @Column(name = "FarArtIsNpcMem")
    private String farArtIsNpcMem;

    /**
     * 合作社负责人或社会中担任：政协委员；0：无1：县级2：市级3：省级4：国家级
     */
    @Column(name = "FarArtIsCppccMem")
    private String farArtIsCppccMem;

    /**
     * 合作社负责人或社会中担任：党代表；0：无1：县级2：市级3：省级4：国家级
     */
    @Column(name = "FarArtIsPartyRep")
    private String farArtIsPartyRep;

    /**
     * 合作社负责人或社员中获得：优秀党员；0：无1：县级2：市级3：省级4：国家级
     */
    @Column(name = "FarArtIsOutPartyMum")
    private String farArtIsOutPartyMum;

    /**
     * 合作社负责人或社员中获得：劳动模范；0：无1：县级2：市级3：省级4：国家级
     */
    @Column(name = "FarArtIsModelWorker")
    private String farArtIsModelWorker;

    /**
     * 合作社负责人或社员中获得：三八红旗手；0：无1：县级2：市级3：省级4：国家级
     */
    @Column(name = "FarArtIsWomSetter")
    private String farArtIsWomSetter;

    /**
     * 合作社负责人是否兼任：村书记；0.否1.是
     */
    @Column(name = "FarArtIsVilSec")
    private String farArtIsVilSec;

    /**
     * 合作社负责人是否兼任：村主任；0.否1.是
     */
    @Column(name = "FarArtIsVilDir")
    private String farArtIsVilDir;

    /**
     * 法定代表人
     */
    @Column(name = "LeRep")
    private String leRep;

    /**
     * 固定电话号码
     */
    @Column(name = "LeRepTel")
    private String leRepTel;

    /**
     * 移动电话
     */
    @Column(name = "LeRepPhone")
    private String leRepPhone;

    /**
     * 财务负责人
     */
    @Column(name = "Finance")
    private String finance;

    /**
     * 固定电话号码
     */
    @Column(name = "FinanceTel")
    private String financeTel;

    /**
     * 移动电话
     */
    @Column(name = "FinancePhone")
    private String financePhone;

    /**
     * 工商联络员
     */
    @Column(name = "LiaName")
    private String liaName;

    /**
     * 固定电话号码
     */
    @Column(name = "LiaTel")
    private String liaTel;

    /**
     * 移动电话
     */
    @Column(name = "LiaPhone")
    private String liaPhone;

    /**
     * 单位电子邮箱
     */
    @Column(name = "UnitEmail")
    private String unitEmail;

    /**
     * 联络员电子邮箱
     */
    @Column(name = "LiaEMail")
    private String liaEMail;

    /**
     * 填报日期
     */
    @Column(name = "CreateTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;

    /**
     * 已获得：守合同重信用企业；0.无 1.有
     */
    @Column(name = "FarArtCreditworth")
    private String farArtCreditworth;

    /**
     * 已获得：消费者信得过单位、名牌产品；0.无 1.有
     */
    @Column(name = "FarArtTruConPro")
    private String farArtTruConPro;

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
     * 获取内部序号
     *
     * @return PriPID - 内部序号
     */
    public String getPriPID() {
        return priPID;
    }

    /**
     * 设置内部序号
     *
     * @param priPID 内部序号
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
     * 获取合作社类型：1.种植类 2.养殖类 3.服务类 4.营销类
     *
     * @return FarArtType - 合作社类型：1.种植类 2.养殖类 3.服务类 4.营销类
     */
    public String getFarArtType() {
        return farArtType;
    }

    /**
     * 设置合作社类型：1.种植类 2.养殖类 3.服务类 4.营销类
     *
     * @param farArtType 合作社类型：1.种植类 2.养殖类 3.服务类 4.营销类
     */
    public void setFarArtType(String farArtType) {
        this.farArtType = farArtType;
    }

    /**
     * 获取主要农产品名称
     *
     * @return FarArtProName - 主要农产品名称
     */
    public String getFarArtProName() {
        return farArtProName;
    }

    /**
     * 设置主要农产品名称
     *
     * @param farArtProName 主要农产品名称
     */
    public void setFarArtProName(String farArtProName) {
        this.farArtProName = farArtProName;
    }

    /**
     * 获取已获得的农产品认证：无公害产品认证；0.无 1.有
     *
     * @return FarArtPolFreeCe - 已获得的农产品认证：无公害产品认证；0.无 1.有
     */
    public String getFarArtPolFreeCe() {
        return farArtPolFreeCe;
    }

    /**
     * 设置已获得的农产品认证：无公害产品认证；0.无 1.有
     *
     * @param farArtPolFreeCe 已获得的农产品认证：无公害产品认证；0.无 1.有
     */
    public void setFarArtPolFreeCe(String farArtPolFreeCe) {
        this.farArtPolFreeCe = farArtPolFreeCe;
    }

    /**
     * 获取已获得的农产品认证：绿色有机产品认证；0.无 1.有
     *
     * @return FarArtGreenOrgCe - 已获得的农产品认证：绿色有机产品认证；0.无 1.有
     */
    public String getFarArtGreenOrgCe() {
        return farArtGreenOrgCe;
    }

    /**
     * 设置已获得的农产品认证：绿色有机产品认证；0.无 1.有
     *
     * @param farArtGreenOrgCe 已获得的农产品认证：绿色有机产品认证；0.无 1.有
     */
    public void setFarArtGreenOrgCe(String farArtGreenOrgCe) {
        this.farArtGreenOrgCe = farArtGreenOrgCe;
    }

    /**
     * 获取已获得的农产品认证：有机农产品认证；0.无 1.有
     *
     * @return FarArtOrgCe - 已获得的农产品认证：有机农产品认证；0.无 1.有
     */
    public String getFarArtOrgCe() {
        return farArtOrgCe;
    }

    /**
     * 设置已获得的农产品认证：有机农产品认证；0.无 1.有
     *
     * @param farArtOrgCe 已获得的农产品认证：有机农产品认证；0.无 1.有
     */
    public void setFarArtOrgCe(String farArtOrgCe) {
        this.farArtOrgCe = farArtOrgCe;
    }

    /**
     * 获取已获得的农产品认证：农产品地理；0.无 1.有
     *
     * @return FarArtGeoCe - 已获得的农产品认证：农产品地理；0.无 1.有
     */
    public String getFarArtGeoCe() {
        return farArtGeoCe;
    }

    /**
     * 设置已获得的农产品认证：农产品地理；0.无 1.有
     *
     * @param farArtGeoCe 已获得的农产品认证：农产品地理；0.无 1.有
     */
    public void setFarArtGeoCe(String farArtGeoCe) {
        this.farArtGeoCe = farArtGeoCe;
    }

    /**
     * 获取合作社成员数
     *
     * @return FarArtMemNum - 合作社成员数
     */
    public Integer getFarArtMemNum() {
        return farArtMemNum;
    }

    /**
     * 设置合作社成员数
     *
     * @param farArtMemNum 合作社成员数
     */
    public void setFarArtMemNum(Integer farArtMemNum) {
        this.farArtMemNum = farArtMemNum;
    }

    /**
     * 获取生产基地面积；单位：亩
     *
     * @return FarArtArea - 生产基地面积；单位：亩
     */
    public BigDecimal getFarArtArea() {
        return farArtArea;
    }

    /**
     * 设置生产基地面积；单位：亩
     *
     * @param farArtArea 生产基地面积；单位：亩
     */
    public void setFarArtArea(BigDecimal farArtArea) {
        this.farArtArea = farArtArea;
    }

    /**
     * 获取带动农户；单位：户
     *
     * @return FarArtDriFarmerNum - 带动农户；单位：户
     */
    public Integer getFarArtDriFarmerNum() {
        return farArtDriFarmerNum;
    }

    /**
     * 设置带动农户；单位：户
     *
     * @param farArtDriFarmerNum 带动农户；单位：户
     */
    public void setFarArtDriFarmerNum(Integer farArtDriFarmerNum) {
        this.farArtDriFarmerNum = farArtDriFarmerNum;
    }

    /**
     * 获取自有产权房面积；单位：平方米
     *
     * @return FarArtPriProArea - 自有产权房面积；单位：平方米
     */
    public BigDecimal getFarArtPriProArea() {
        return farArtPriProArea;
    }

    /**
     * 设置自有产权房面积；单位：平方米
     *
     * @param farArtPriProArea 自有产权房面积；单位：平方米
     */
    public void setFarArtPriProArea(BigDecimal farArtPriProArea) {
        this.farArtPriProArea = farArtPriProArea;
    }

    /**
     * 获取自有生产经营设备价值；单位：万元
     *
     * @return FarArtOpeEquVal - 自有生产经营设备价值；单位：万元
     */
    public BigDecimal getFarArtOpeEquVal() {
        return farArtOpeEquVal;
    }

    /**
     * 设置自有生产经营设备价值；单位：万元
     *
     * @param farArtOpeEquVal 自有生产经营设备价值；单位：万元
     */
    public void setFarArtOpeEquVal(BigDecimal farArtOpeEquVal) {
        this.farArtOpeEquVal = farArtOpeEquVal;
    }

    /**
     * 获取合作社投资总规模；单位：万元
     *
     * @return FarArtCoopTotalInv - 合作社投资总规模；单位：万元
     */
    public BigDecimal getFarArtCoopTotalInv() {
        return farArtCoopTotalInv;
    }

    /**
     * 设置合作社投资总规模；单位：万元
     *
     * @param farArtCoopTotalInv 合作社投资总规模；单位：万元
     */
    public void setFarArtCoopTotalInv(BigDecimal farArtCoopTotalInv) {
        this.farArtCoopTotalInv = farArtCoopTotalInv;
    }

    /**
     * 获取其中：成员出资；单位：万元
     *
     * @return FarArtMemInv - 其中：成员出资；单位：万元
     */
    public BigDecimal getFarArtMemInv() {
        return farArtMemInv;
    }

    /**
     * 设置其中：成员出资；单位：万元
     *
     * @param farArtMemInv 其中：成员出资；单位：万元
     */
    public void setFarArtMemInv(BigDecimal farArtMemInv) {
        this.farArtMemInv = farArtMemInv;
    }

    /**
     * 获取贷款额,单位：万元
     *
     * @return FarArtLoanAmount - 贷款额,单位：万元
     */
    public BigDecimal getFarArtLoanAmount() {
        return farArtLoanAmount;
    }

    /**
     * 设置贷款额,单位：万元
     *
     * @param farArtLoanAmount 贷款额,单位：万元
     */
    public void setFarArtLoanAmount(BigDecimal farArtLoanAmount) {
        this.farArtLoanAmount = farArtLoanAmount;
    }

    /**
     * 获取政府补助；单位：万元
     *
     * @return FarArtGovGrants - 政府补助；单位：万元
     */
    public BigDecimal getFarArtGovGrants() {
        return farArtGovGrants;
    }

    /**
     * 设置政府补助；单位：万元
     *
     * @param farArtGovGrants 政府补助；单位：万元
     */
    public void setFarArtGovGrants(BigDecimal farArtGovGrants) {
        this.farArtGovGrants = farArtGovGrants;
    }

    /**
     * 获取主要营销市场；1.省内2.省外3.国外
     *
     * @return FarArtMarketing - 主要营销市场；1.省内2.省外3.国外
     */
    public String getFarArtMarketing() {
        return farArtMarketing;
    }

    /**
     * 设置主要营销市场；1.省内2.省外3.国外
     *
     * @param farArtMarketing 主要营销市场；1.省内2.省外3.国外
     */
    public void setFarArtMarketing(String farArtMarketing) {
        this.farArtMarketing = farArtMarketing;
    }

    /**
     * 获取上年度销售总额；单位：万元
     *
     * @return FarArtTotalSales - 上年度销售总额；单位：万元
     */
    public BigDecimal getFarArtTotalSales() {
        return farArtTotalSales;
    }

    /**
     * 设置上年度销售总额；单位：万元
     *
     * @param farArtTotalSales 上年度销售总额；单位：万元
     */
    public void setFarArtTotalSales(BigDecimal farArtTotalSales) {
        this.farArtTotalSales = farArtTotalSales;
    }

    /**
     * 获取销售额年增长率；单位：%
     *
     * @return FarArtSalesIncRatio - 销售额年增长率；单位：%
     */
    public BigDecimal getFarArtSalesIncRatio() {
        return farArtSalesIncRatio;
    }

    /**
     * 设置销售额年增长率；单位：%
     *
     * @param farArtSalesIncRatio 销售额年增长率；单位：%
     */
    public void setFarArtSalesIncRatio(BigDecimal farArtSalesIncRatio) {
        this.farArtSalesIncRatio = farArtSalesIncRatio;
    }

    /**
     * 获取利润总额；单位：万元
     *
     * @return FarArtTotalProfit - 利润总额；单位：万元
     */
    public BigDecimal getFarArtTotalProfit() {
        return farArtTotalProfit;
    }

    /**
     * 设置利润总额；单位：万元
     *
     * @param farArtTotalProfit 利润总额；单位：万元
     */
    public void setFarArtTotalProfit(BigDecimal farArtTotalProfit) {
        this.farArtTotalProfit = farArtTotalProfit;
    }

    /**
     * 获取全年纳税总额；单位：万元
     *
     * @return FarArtTaxAmount - 全年纳税总额；单位：万元
     */
    public BigDecimal getFarArtTaxAmount() {
        return farArtTaxAmount;
    }

    /**
     * 设置全年纳税总额；单位：万元
     *
     * @param farArtTaxAmount 全年纳税总额；单位：万元
     */
    public void setFarArtTaxAmount(BigDecimal farArtTaxAmount) {
        this.farArtTaxAmount = farArtTaxAmount;
    }

    /**
     * 获取其中：所得税总额；单位：%
     *
     * @return FarArtGroIncTax - 其中：所得税总额；单位：%
     */
    public BigDecimal getFarArtGroIncTax() {
        return farArtGroIncTax;
    }

    /**
     * 设置其中：所得税总额；单位：%
     *
     * @param farArtGroIncTax 其中：所得税总额；单位：%
     */
    public void setFarArtGroIncTax(BigDecimal farArtGroIncTax) {
        this.farArtGroIncTax = farArtGroIncTax;
    }

    /**
     * 获取享受扶持资金；单位：万元
     *
     * @return FarArtSupFinancing - 享受扶持资金；单位：万元
     */
    public BigDecimal getFarArtSupFinancing() {
        return farArtSupFinancing;
    }

    /**
     * 设置享受扶持资金；单位：万元
     *
     * @param farArtSupFinancing 享受扶持资金；单位：万元
     */
    public void setFarArtSupFinancing(BigDecimal farArtSupFinancing) {
        this.farArtSupFinancing = farArtSupFinancing;
    }

    /**
     * 获取税费减免总额；单位：万元
     *
     * @return FarArtTotalTaxCuts - 税费减免总额；单位：万元
     */
    public BigDecimal getFarArtTotalTaxCuts() {
        return farArtTotalTaxCuts;
    }

    /**
     * 设置税费减免总额；单位：万元
     *
     * @param farArtTotalTaxCuts 税费减免总额；单位：万元
     */
    public void setFarArtTotalTaxCuts(BigDecimal farArtTotalTaxCuts) {
        this.farArtTotalTaxCuts = farArtTotalTaxCuts;
    }

    /**
     * 获取社员年均纯收入；单位：元
     *
     * @return FarArtAreNetIncome - 社员年均纯收入；单位：元
     */
    public BigDecimal getFarArtAreNetIncome() {
        return farArtAreNetIncome;
    }

    /**
     * 设置社员年均纯收入；单位：元
     *
     * @param farArtAreNetIncome 社员年均纯收入；单位：元
     */
    public void setFarArtAreNetIncome(BigDecimal farArtAreNetIncome) {
        this.farArtAreNetIncome = farArtAreNetIncome;
    }

    /**
     * 获取统一采购农业投入品比例；单位：%
     *
     * @return FarArtInpProRatio - 统一采购农业投入品比例；单位：%
     */
    public BigDecimal getFarArtInpProRatio() {
        return farArtInpProRatio;
    }

    /**
     * 设置统一采购农业投入品比例；单位：%
     *
     * @param farArtInpProRatio 统一采购农业投入品比例；单位：%
     */
    public void setFarArtInpProRatio(BigDecimal farArtInpProRatio) {
        this.farArtInpProRatio = farArtInpProRatio;
    }

    /**
     * 获取统一销售主产品比例；单位：%
     *
     * @return FarArtSaleProRatio - 统一销售主产品比例；单位：%
     */
    public BigDecimal getFarArtSaleProRatio() {
        return farArtSaleProRatio;
    }

    /**
     * 设置统一销售主产品比例；单位：%
     *
     * @param farArtSaleProRatio 统一销售主产品比例；单位：%
     */
    public void setFarArtSaleProRatio(BigDecimal farArtSaleProRatio) {
        this.farArtSaleProRatio = farArtSaleProRatio;
    }

    /**
     * 获取开展初加工后销售；0.否 1.是
     *
     * @return FarArtPreSales - 开展初加工后销售；0.否 1.是
     */
    public String getFarArtPreSales() {
        return farArtPreSales;
    }

    /**
     * 设置开展初加工后销售；0.否 1.是
     *
     * @param farArtPreSales 开展初加工后销售；0.否 1.是
     */
    public void setFarArtPreSales(String farArtPreSales) {
        this.farArtPreSales = farArtPreSales;
    }

    /**
     * 获取开展深加工后销售；0.否 1.是
     *
     * @return FarArtDeepSales - 开展深加工后销售；0.否 1.是
     */
    public String getFarArtDeepSales() {
        return farArtDeepSales;
    }

    /**
     * 设置开展深加工后销售；0.否 1.是
     *
     * @param farArtDeepSales 开展深加工后销售；0.否 1.是
     */
    public void setFarArtDeepSales(String farArtDeepSales) {
        this.farArtDeepSales = farArtDeepSales;
    }

    /**
     * 获取实现农超对接；0.否 1.是
     *
     * @return FarArtLinkFarSupmarket - 实现农超对接；0.否 1.是
     */
    public String getFarArtLinkFarSupmarket() {
        return farArtLinkFarSupmarket;
    }

    /**
     * 设置实现农超对接；0.否 1.是
     *
     * @param farArtLinkFarSupmarket 实现农超对接；0.否 1.是
     */
    public void setFarArtLinkFarSupmarket(String farArtLinkFarSupmarket) {
        this.farArtLinkFarSupmarket = farArtLinkFarSupmarket;
    }

    /**
     * 获取已执行的事项：设立监事会；0.无 1.有
     *
     * @return FarArtSupBoardItem - 已执行的事项：设立监事会；0.无 1.有
     */
    public String getFarArtSupBoardItem() {
        return farArtSupBoardItem;
    }

    /**
     * 设置已执行的事项：设立监事会；0.无 1.有
     *
     * @param farArtSupBoardItem 已执行的事项：设立监事会；0.无 1.有
     */
    public void setFarArtSupBoardItem(String farArtSupBoardItem) {
        this.farArtSupBoardItem = farArtSupBoardItem;
    }

    /**
     * 获取已执行的事项：定期召开社员大会；0.无 1.有
     *
     * @return FarArtMemMeetingItem - 已执行的事项：定期召开社员大会；0.无 1.有
     */
    public String getFarArtMemMeetingItem() {
        return farArtMemMeetingItem;
    }

    /**
     * 设置已执行的事项：定期召开社员大会；0.无 1.有
     *
     * @param farArtMemMeetingItem 已执行的事项：定期召开社员大会；0.无 1.有
     */
    public void setFarArtMemMeetingItem(String farArtMemMeetingItem) {
        this.farArtMemMeetingItem = farArtMemMeetingItem;
    }

    /**
     * 获取已执行的事项：建立会计核算；0.无 1.有
     *
     * @return FarArtAccItem - 已执行的事项：建立会计核算；0.无 1.有
     */
    public String getFarArtAccItem() {
        return farArtAccItem;
    }

    /**
     * 设置已执行的事项：建立会计核算；0.无 1.有
     *
     * @param farArtAccItem 已执行的事项：建立会计核算；0.无 1.有
     */
    public void setFarArtAccItem(String farArtAccItem) {
        this.farArtAccItem = farArtAccItem;
    }

    /**
     * 获取已执行的事项：定期财务公开；0.无 1.有
     *
     * @return FarArtFinDisItem - 已执行的事项：定期财务公开；0.无 1.有
     */
    public String getFarArtFinDisItem() {
        return farArtFinDisItem;
    }

    /**
     * 设置已执行的事项：定期财务公开；0.无 1.有
     *
     * @param farArtFinDisItem 已执行的事项：定期财务公开；0.无 1.有
     */
    public void setFarArtFinDisItem(String farArtFinDisItem) {
        this.farArtFinDisItem = farArtFinDisItem;
    }

    /**
     * 获取其他事项执行情况
     *
     * @return FarArtOtherItem - 其他事项执行情况
     */
    public String getFarArtOtherItem() {
        return farArtOtherItem;
    }

    /**
     * 设置其他事项执行情况
     *
     * @param farArtOtherItem 其他事项执行情况
     */
    public void setFarArtOtherItem(String farArtOtherItem) {
        this.farArtOtherItem = farArtOtherItem;
    }

    /**
     * 获取使用的订单合同有：示范合同文本；0.无 1.有
     *
     * @return FarArtModelCont - 使用的订单合同有：示范合同文本；0.无 1.有
     */
    public String getFarArtModelCont() {
        return farArtModelCont;
    }

    /**
     * 设置使用的订单合同有：示范合同文本；0.无 1.有
     *
     * @param farArtModelCont 使用的订单合同有：示范合同文本；0.无 1.有
     */
    public void setFarArtModelCont(String farArtModelCont) {
        this.farArtModelCont = farArtModelCont;
    }

    /**
     * 获取使用的订单合同有：自制合同文本；0.无 1.有
     *
     * @return FarArtSelfMadeCont - 使用的订单合同有：自制合同文本；0.无 1.有
     */
    public String getFarArtSelfMadeCont() {
        return farArtSelfMadeCont;
    }

    /**
     * 设置使用的订单合同有：自制合同文本；0.无 1.有
     *
     * @param farArtSelfMadeCont 使用的订单合同有：自制合同文本；0.无 1.有
     */
    public void setFarArtSelfMadeCont(String farArtSelfMadeCont) {
        this.farArtSelfMadeCont = farArtSelfMadeCont;
    }

    /**
     * 获取上年度订单合同份数；单位：份
     *
     * @return FarArtContNum - 上年度订单合同份数；单位：份
     */
    public Integer getFarArtContNum() {
        return farArtContNum;
    }

    /**
     * 设置上年度订单合同份数；单位：份
     *
     * @param farArtContNum 上年度订单合同份数；单位：份
     */
    public void setFarArtContNum(Integer farArtContNum) {
        this.farArtContNum = farArtContNum;
    }

    /**
     * 获取合同金额；单位：万元
     *
     * @return FarArtContAmount - 合同金额；单位：万元
     */
    public BigDecimal getFarArtContAmount() {
        return farArtContAmount;
    }

    /**
     * 设置合同金额；单位：万元
     *
     * @param farArtContAmount 合同金额；单位：万元
     */
    public void setFarArtContAmount(BigDecimal farArtContAmount) {
        this.farArtContAmount = farArtContAmount;
    }

    /**
     * 获取签约农户；单位：户
     *
     * @return FarArtSignFarmerNum - 签约农户；单位：户
     */
    public Integer getFarArtSignFarmerNum() {
        return farArtSignFarmerNum;
    }

    /**
     * 设置签约农户；单位：户
     *
     * @param farArtSignFarmerNum 签约农户；单位：户
     */
    public void setFarArtSignFarmerNum(Integer farArtSignFarmerNum) {
        this.farArtSignFarmerNum = farArtSignFarmerNum;
    }

    /**
     * 获取注册商标；单位：只
     *
     * @return FarArtRegMark - 注册商标；单位：只
     */
    public Integer getFarArtRegMark() {
        return farArtRegMark;
    }

    /**
     * 设置注册商标；单位：只
     *
     * @param farArtRegMark 注册商标；单位：只
     */
    public void setFarArtRegMark(Integer farArtRegMark) {
        this.farArtRegMark = farArtRegMark;
    }

    /**
     * 获取其中拥有：国家级驰名商标；0.无 1.有
     *
     * @return FarArtNatMarkNum - 其中拥有：国家级驰名商标；0.无 1.有
     */
    public String getFarArtNatMarkNum() {
        return farArtNatMarkNum;
    }

    /**
     * 设置其中拥有：国家级驰名商标；0.无 1.有
     *
     * @param farArtNatMarkNum 其中拥有：国家级驰名商标；0.无 1.有
     */
    public void setFarArtNatMarkNum(String farArtNatMarkNum) {
        this.farArtNatMarkNum = farArtNatMarkNum;
    }

    /**
     * 获取其中拥有：省级著名商标 0.无 1.有
     *
     * @return FarArtProMarkNum - 其中拥有：省级著名商标 0.无 1.有
     */
    public String getFarArtProMarkNum() {
        return farArtProMarkNum;
    }

    /**
     * 设置其中拥有：省级著名商标 0.无 1.有
     *
     * @param farArtProMarkNum 其中拥有：省级著名商标 0.无 1.有
     */
    public void setFarArtProMarkNum(String farArtProMarkNum) {
        this.farArtProMarkNum = farArtProMarkNum;
    }

    /**
     * 获取其中拥有：市级知名商标 ；0.无 1.有
     *
     * @return FarArtCityMarkNum - 其中拥有：市级知名商标 ；0.无 1.有
     */
    public String getFarArtCityMarkNum() {
        return farArtCityMarkNum;
    }

    /**
     * 设置其中拥有：市级知名商标 ；0.无 1.有
     *
     * @param farArtCityMarkNum 其中拥有：市级知名商标 ；0.无 1.有
     */
    public void setFarArtCityMarkNum(String farArtCityMarkNum) {
        this.farArtCityMarkNum = farArtCityMarkNum;
    }

    /**
     * 获取使用证明商标；0.无 1.有
     *
     * @return FarArtUseCeMark - 使用证明商标；0.无 1.有
     */
    public String getFarArtUseCeMark() {
        return farArtUseCeMark;
    }

    /**
     * 设置使用证明商标；0.无 1.有
     *
     * @param farArtUseCeMark 使用证明商标；0.无 1.有
     */
    public void setFarArtUseCeMark(String farArtUseCeMark) {
        this.farArtUseCeMark = farArtUseCeMark;
    }

    /**
     * 获取获得专利或其他知识产权；0.无 1.有
     *
     * @return FarArtPatent - 获得专利或其他知识产权；0.无 1.有
     */
    public String getFarArtPatent() {
        return farArtPatent;
    }

    /**
     * 设置获得专利或其他知识产权；0.无 1.有
     *
     * @param farArtPatent 获得专利或其他知识产权；0.无 1.有
     */
    public void setFarArtPatent(String farArtPatent) {
        this.farArtPatent = farArtPatent;
    }

    /**
     * 获取已获得：省知名商号；0.无 1.有
     *
     * @return FarArtProTradeName - 已获得：省知名商号；0.无 1.有
     */
    public String getFarArtProTradeName() {
        return farArtProTradeName;
    }

    /**
     * 设置已获得：省知名商号；0.无 1.有
     *
     * @param farArtProTradeName 已获得：省知名商号；0.无 1.有
     */
    public void setFarArtProTradeName(String farArtProTradeName) {
        this.farArtProTradeName = farArtProTradeName;
    }

    /**
     * 获取已获得：市知名商号；0.无 1.有
     *
     * @return FarArtCityTradeName - 已获得：市知名商号；0.无 1.有
     */
    public String getFarArtCityTradeName() {
        return farArtCityTradeName;
    }

    /**
     * 设置已获得：市知名商号；0.无 1.有
     *
     * @param farArtCityTradeName 已获得：市知名商号；0.无 1.有
     */
    public void setFarArtCityTradeName(String farArtCityTradeName) {
        this.farArtCityTradeName = farArtCityTradeName;
    }

    /**
     * 获取上年度组织开展技术培训；0.无 1.有
     *
     * @return FarArtTecTrain - 上年度组织开展技术培训；0.无 1.有
     */
    public String getFarArtTecTrain() {
        return farArtTecTrain;
    }

    /**
     * 设置上年度组织开展技术培训；0.无 1.有
     *
     * @param farArtTecTrain 上年度组织开展技术培训；0.无 1.有
     */
    public void setFarArtTecTrain(String farArtTecTrain) {
        this.farArtTecTrain = farArtTecTrain;
    }

    /**
     * 获取培训师资来源：外聘；0.无 1.有
     *
     * @return FarArtTeaExt - 培训师资来源：外聘；0.无 1.有
     */
    public String getFarArtTeaExt() {
        return farArtTeaExt;
    }

    /**
     * 设置培训师资来源：外聘；0.无 1.有
     *
     * @param farArtTeaExt 培训师资来源：外聘；0.无 1.有
     */
    public void setFarArtTeaExt(String farArtTeaExt) {
        this.farArtTeaExt = farArtTeaExt;
    }

    /**
     * 获取培训师资来源：自有；0.无 1.有
     *
     * @return FarArtTeaInt - 培训师资来源：自有；0.无 1.有
     */
    public String getFarArtTeaInt() {
        return farArtTeaInt;
    }

    /**
     * 设置培训师资来源：自有；0.无 1.有
     *
     * @param farArtTeaInt 培训师资来源：自有；0.无 1.有
     */
    public void setFarArtTeaInt(String farArtTeaInt) {
        this.farArtTeaInt = farArtTeaInt;
    }

    /**
     * 获取上年度组织或参加培训总次数；单位：次
     *
     * @return FarArtTrainNum - 上年度组织或参加培训总次数；单位：次
     */
    public Integer getFarArtTrainNum() {
        return farArtTrainNum;
    }

    /**
     * 设置上年度组织或参加培训总次数；单位：次
     *
     * @param farArtTrainNum 上年度组织或参加培训总次数；单位：次
     */
    public void setFarArtTrainNum(Integer farArtTrainNum) {
        this.farArtTrainNum = farArtTrainNum;
    }

    /**
     * 获取参加培训人员；单位：人/次
     *
     * @return FarArtMemAttNum - 参加培训人员；单位：人/次
     */
    public Integer getFarArtMemAttNum() {
        return farArtMemAttNum;
    }

    /**
     * 设置参加培训人员；单位：人/次
     *
     * @param farArtMemAttNum 参加培训人员；单位：人/次
     */
    public void setFarArtMemAttNum(Integer farArtMemAttNum) {
        this.farArtMemAttNum = farArtMemAttNum;
    }

    /**
     * 获取已开展的质量工作有：执行农产品质量标准；0.无 1.有
     *
     * @return FarArtQuaSta - 已开展的质量工作有：执行农产品质量标准；0.无 1.有
     */
    public String getFarArtQuaSta() {
        return farArtQuaSta;
    }

    /**
     * 设置已开展的质量工作有：执行农产品质量标准；0.无 1.有
     *
     * @param farArtQuaSta 已开展的质量工作有：执行农产品质量标准；0.无 1.有
     */
    public void setFarArtQuaSta(String farArtQuaSta) {
        this.farArtQuaSta = farArtQuaSta;
    }

    /**
     * 获取已开展的质量工作有：建立农产品质量追溯制度；0.无 1.有
     *
     * @return FarArtQuaTraSys - 已开展的质量工作有：建立农产品质量追溯制度；0.无 1.有
     */
    public String getFarArtQuaTraSys() {
        return farArtQuaTraSys;
    }

    /**
     * 设置已开展的质量工作有：建立农产品质量追溯制度；0.无 1.有
     *
     * @param farArtQuaTraSys 已开展的质量工作有：建立农产品质量追溯制度；0.无 1.有
     */
    public void setFarArtQuaTraSys(String farArtQuaTraSys) {
        this.farArtQuaTraSys = farArtQuaTraSys;
    }

    /**
     * 获取已开展的质量工作有：获得产品质量体系认证；0.无 1.有
     *
     * @return FarArtQuaSys - 已开展的质量工作有：获得产品质量体系认证；0.无 1.有
     */
    public String getFarArtQuaSys() {
        return farArtQuaSys;
    }

    /**
     * 设置已开展的质量工作有：获得产品质量体系认证；0.无 1.有
     *
     * @param farArtQuaSys 已开展的质量工作有：获得产品质量体系认证；0.无 1.有
     */
    public void setFarArtQuaSys(String farArtQuaSys) {
        this.farArtQuaSys = farArtQuaSys;
    }

    /**
     * 获取已开展的质量工作有：建立风险储备金制度；0.无 1.有
     *
     * @return FarArtQuaRiskSys - 已开展的质量工作有：建立风险储备金制度；0.无 1.有
     */
    public String getFarArtQuaRiskSys() {
        return farArtQuaRiskSys;
    }

    /**
     * 设置已开展的质量工作有：建立风险储备金制度；0.无 1.有
     *
     * @param farArtQuaRiskSys 已开展的质量工作有：建立风险储备金制度；0.无 1.有
     */
    public void setFarArtQuaRiskSys(String farArtQuaRiskSys) {
        this.farArtQuaRiskSys = farArtQuaRiskSys;
    }

    /**
     * 获取设立独立网站或网页；0.无 1.有
     *
     * @return FarArtWebsite - 设立独立网站或网页；0.无 1.有
     */
    public String getFarArtWebsite() {
        return farArtWebsite;
    }

    /**
     * 设置设立独立网站或网页；0.无 1.有
     *
     * @param farArtWebsite 设立独立网站或网页；0.无 1.有
     */
    public void setFarArtWebsite(String farArtWebsite) {
        this.farArtWebsite = farArtWebsite;
    }

    /**
     * 获取网站名称
     *
     * @return FarArtWebName - 网站名称
     */
    public String getFarArtWebName() {
        return farArtWebName;
    }

    /**
     * 设置网站名称
     *
     * @param farArtWebName 网站名称
     */
    public void setFarArtWebName(String farArtWebName) {
        this.farArtWebName = farArtWebName;
    }

    /**
     * 获取网址
     *
     * @return FarArtWebUrl - 网址
     */
    public String getFarArtWebUrl() {
        return farArtWebUrl;
    }

    /**
     * 设置网址
     *
     * @param farArtWebUrl 网址
     */
    public void setFarArtWebUrl(String farArtWebUrl) {
        this.farArtWebUrl = farArtWebUrl;
    }

    /**
     * 获取运用互联网络发布信息；0.无 1.有
     *
     * @return FarArtNetRelInfo - 运用互联网络发布信息；0.无 1.有
     */
    public String getFarArtNetRelInfo() {
        return farArtNetRelInfo;
    }

    /**
     * 设置运用互联网络发布信息；0.无 1.有
     *
     * @param farArtNetRelInfo 运用互联网络发布信息；0.无 1.有
     */
    public void setFarArtNetRelInfo(String farArtNetRelInfo) {
        this.farArtNetRelInfo = farArtNetRelInfo;
    }

    /**
     * 获取其中累计用于网络广告费用
     *
     * @return FarArtNetAdCost - 其中累计用于网络广告费用
     */
    public BigDecimal getFarArtNetAdCost() {
        return farArtNetAdCost;
    }

    /**
     * 设置其中累计用于网络广告费用
     *
     * @param farArtNetAdCost 其中累计用于网络广告费用
     */
    public void setFarArtNetAdCost(BigDecimal farArtNetAdCost) {
        this.farArtNetAdCost = farArtNetAdCost;
    }

    /**
     * 获取通过网络销售产品或服务；0.无 1.有
     *
     * @return FarArtNetSales - 通过网络销售产品或服务；0.无 1.有
     */
    public String getFarArtNetSales() {
        return farArtNetSales;
    }

    /**
     * 设置通过网络销售产品或服务；0.无 1.有
     *
     * @param farArtNetSales 通过网络销售产品或服务；0.无 1.有
     */
    public void setFarArtNetSales(String farArtNetSales) {
        this.farArtNetSales = farArtNetSales;
    }

    /**
     * 获取其中上年度网上销售额
     *
     * @return FarArtNetSalesAmount - 其中上年度网上销售额
     */
    public BigDecimal getFarArtNetSalesAmount() {
        return farArtNetSalesAmount;
    }

    /**
     * 设置其中上年度网上销售额
     *
     * @param farArtNetSalesAmount 其中上年度网上销售额
     */
    public void setFarArtNetSalesAmount(BigDecimal farArtNetSalesAmount) {
        this.farArtNetSalesAmount = farArtNetSalesAmount;
    }

    /**
     * 获取示范合作社验收情况，已获得：1.国家级 2.省级3.市级4.县级5.目前正在申报
     *
     * @return FarArtDemoCoopGrade - 示范合作社验收情况，已获得：1.国家级 2.省级3.市级4.县级5.目前正在申报
     */
    public String getFarArtDemoCoopGrade() {
        return farArtDemoCoopGrade;
    }

    /**
     * 设置示范合作社验收情况，已获得：1.国家级 2.省级3.市级4.县级5.目前正在申报
     *
     * @param farArtDemoCoopGrade 示范合作社验收情况，已获得：1.国家级 2.省级3.市级4.县级5.目前正在申报
     */
    public void setFarArtDemoCoopGrade(String farArtDemoCoopGrade) {
        this.farArtDemoCoopGrade = farArtDemoCoopGrade;
    }

    /**
     * 获取开户银行（基本户）
     *
     * @return FarArtBank - 开户银行（基本户）
     */
    public String getFarArtBank() {
        return farArtBank;
    }

    /**
     * 设置开户银行（基本户）
     *
     * @param farArtBank 开户银行（基本户）
     */
    public void setFarArtBank(String farArtBank) {
        this.farArtBank = farArtBank;
    }

    /**
     * 获取账号
     *
     * @return FarArtBankAccount - 账号
     */
    public String getFarArtBankAccount() {
        return farArtBankAccount;
    }

    /**
     * 设置账号
     *
     * @param farArtBankAccount 账号
     */
    public void setFarArtBankAccount(String farArtBankAccount) {
        this.farArtBankAccount = farArtBankAccount;
    }

    /**
     * 获取信用等级；01：AAA 02：AA 03：A 04：B 05：C 06：D
     *
     * @return FarArtCreditLevel - 信用等级；01：AAA 02：AA 03：A 04：B 05：C 06：D
     */
    public String getFarArtCreditLevel() {
        return farArtCreditLevel;
    }

    /**
     * 设置信用等级；01：AAA 02：AA 03：A 04：B 05：C 06：D
     *
     * @param farArtCreditLevel 信用等级；01：AAA 02：AA 03：A 04：B 05：C 06：D
     */
    public void setFarArtCreditLevel(String farArtCreditLevel) {
        this.farArtCreditLevel = farArtCreditLevel;
    }

    /**
     * 获取组织机构代码证号
     *
     * @return EntOrgCode - 组织机构代码证号
     */
    public String getEntOrgCode() {
        return entOrgCode;
    }

    /**
     * 设置组织机构代码证号
     *
     * @param entOrgCode 组织机构代码证号
     */
    public void setEntOrgCode(String entOrgCode) {
        this.entOrgCode = entOrgCode;
    }

    /**
     * 获取税务登记证号
     *
     * @return TaxRegNo - 税务登记证号
     */
    public String getTaxRegNo() {
        return taxRegNo;
    }

    /**
     * 设置税务登记证号
     *
     * @param taxRegNo 税务登记证号
     */
    public void setTaxRegNo(String taxRegNo) {
        this.taxRegNo = taxRegNo;
    }

    /**
     * 获取合作社负责人或社会中担任：人大代表；0：无1：县级2：市级3：省级4：国家级
     *
     * @return FarArtIsNpcMem - 合作社负责人或社会中担任：人大代表；0：无1：县级2：市级3：省级4：国家级
     */
    public String getFarArtIsNpcMem() {
        return farArtIsNpcMem;
    }

    /**
     * 设置合作社负责人或社会中担任：人大代表；0：无1：县级2：市级3：省级4：国家级
     *
     * @param farArtIsNpcMem 合作社负责人或社会中担任：人大代表；0：无1：县级2：市级3：省级4：国家级
     */
    public void setFarArtIsNpcMem(String farArtIsNpcMem) {
        this.farArtIsNpcMem = farArtIsNpcMem;
    }

    /**
     * 获取合作社负责人或社会中担任：政协委员；0：无1：县级2：市级3：省级4：国家级
     *
     * @return FarArtIsCppccMem - 合作社负责人或社会中担任：政协委员；0：无1：县级2：市级3：省级4：国家级
     */
    public String getFarArtIsCppccMem() {
        return farArtIsCppccMem;
    }

    /**
     * 设置合作社负责人或社会中担任：政协委员；0：无1：县级2：市级3：省级4：国家级
     *
     * @param farArtIsCppccMem 合作社负责人或社会中担任：政协委员；0：无1：县级2：市级3：省级4：国家级
     */
    public void setFarArtIsCppccMem(String farArtIsCppccMem) {
        this.farArtIsCppccMem = farArtIsCppccMem;
    }

    /**
     * 获取合作社负责人或社会中担任：党代表；0：无1：县级2：市级3：省级4：国家级
     *
     * @return FarArtIsPartyRep - 合作社负责人或社会中担任：党代表；0：无1：县级2：市级3：省级4：国家级
     */
    public String getFarArtIsPartyRep() {
        return farArtIsPartyRep;
    }

    /**
     * 设置合作社负责人或社会中担任：党代表；0：无1：县级2：市级3：省级4：国家级
     *
     * @param farArtIsPartyRep 合作社负责人或社会中担任：党代表；0：无1：县级2：市级3：省级4：国家级
     */
    public void setFarArtIsPartyRep(String farArtIsPartyRep) {
        this.farArtIsPartyRep = farArtIsPartyRep;
    }

    /**
     * 获取合作社负责人或社员中获得：优秀党员；0：无1：县级2：市级3：省级4：国家级
     *
     * @return FarArtIsOutPartyMum - 合作社负责人或社员中获得：优秀党员；0：无1：县级2：市级3：省级4：国家级
     */
    public String getFarArtIsOutPartyMum() {
        return farArtIsOutPartyMum;
    }

    /**
     * 设置合作社负责人或社员中获得：优秀党员；0：无1：县级2：市级3：省级4：国家级
     *
     * @param farArtIsOutPartyMum 合作社负责人或社员中获得：优秀党员；0：无1：县级2：市级3：省级4：国家级
     */
    public void setFarArtIsOutPartyMum(String farArtIsOutPartyMum) {
        this.farArtIsOutPartyMum = farArtIsOutPartyMum;
    }

    /**
     * 获取合作社负责人或社员中获得：劳动模范；0：无1：县级2：市级3：省级4：国家级
     *
     * @return FarArtIsModelWorker - 合作社负责人或社员中获得：劳动模范；0：无1：县级2：市级3：省级4：国家级
     */
    public String getFarArtIsModelWorker() {
        return farArtIsModelWorker;
    }

    /**
     * 设置合作社负责人或社员中获得：劳动模范；0：无1：县级2：市级3：省级4：国家级
     *
     * @param farArtIsModelWorker 合作社负责人或社员中获得：劳动模范；0：无1：县级2：市级3：省级4：国家级
     */
    public void setFarArtIsModelWorker(String farArtIsModelWorker) {
        this.farArtIsModelWorker = farArtIsModelWorker;
    }

    /**
     * 获取合作社负责人或社员中获得：三八红旗手；0：无1：县级2：市级3：省级4：国家级
     *
     * @return FarArtIsWomSetter - 合作社负责人或社员中获得：三八红旗手；0：无1：县级2：市级3：省级4：国家级
     */
    public String getFarArtIsWomSetter() {
        return farArtIsWomSetter;
    }

    /**
     * 设置合作社负责人或社员中获得：三八红旗手；0：无1：县级2：市级3：省级4：国家级
     *
     * @param farArtIsWomSetter 合作社负责人或社员中获得：三八红旗手；0：无1：县级2：市级3：省级4：国家级
     */
    public void setFarArtIsWomSetter(String farArtIsWomSetter) {
        this.farArtIsWomSetter = farArtIsWomSetter;
    }

    /**
     * 获取合作社负责人是否兼任：村书记；0.否1.是
     *
     * @return FarArtIsVilSec - 合作社负责人是否兼任：村书记；0.否1.是
     */
    public String getFarArtIsVilSec() {
        return farArtIsVilSec;
    }

    /**
     * 设置合作社负责人是否兼任：村书记；0.否1.是
     *
     * @param farArtIsVilSec 合作社负责人是否兼任：村书记；0.否1.是
     */
    public void setFarArtIsVilSec(String farArtIsVilSec) {
        this.farArtIsVilSec = farArtIsVilSec;
    }

    /**
     * 获取合作社负责人是否兼任：村主任；0.否1.是
     *
     * @return FarArtIsVilDir - 合作社负责人是否兼任：村主任；0.否1.是
     */
    public String getFarArtIsVilDir() {
        return farArtIsVilDir;
    }

    /**
     * 设置合作社负责人是否兼任：村主任；0.否1.是
     *
     * @param farArtIsVilDir 合作社负责人是否兼任：村主任；0.否1.是
     */
    public void setFarArtIsVilDir(String farArtIsVilDir) {
        this.farArtIsVilDir = farArtIsVilDir;
    }

    /**
     * 获取法定代表人
     *
     * @return LeRep - 法定代表人
     */
    public String getLeRep() {
        return leRep;
    }

    /**
     * 设置法定代表人
     *
     * @param leRep 法定代表人
     */
    public void setLeRep(String leRep) {
        this.leRep = leRep;
    }

    /**
     * 获取固定电话号码
     *
     * @return LeRepTel - 固定电话号码
     */
    public String getLeRepTel() {
        return leRepTel;
    }

    /**
     * 设置固定电话号码
     *
     * @param leRepTel 固定电话号码
     */
    public void setLeRepTel(String leRepTel) {
        this.leRepTel = leRepTel;
    }

    /**
     * 获取移动电话
     *
     * @return LeRepPhone - 移动电话
     */
    public String getLeRepPhone() {
        return leRepPhone;
    }

    /**
     * 设置移动电话
     *
     * @param leRepPhone 移动电话
     */
    public void setLeRepPhone(String leRepPhone) {
        this.leRepPhone = leRepPhone;
    }

    /**
     * 获取财务负责人
     *
     * @return Finance - 财务负责人
     */
    public String getFinance() {
        return finance;
    }

    /**
     * 设置财务负责人
     *
     * @param finance 财务负责人
     */
    public void setFinance(String finance) {
        this.finance = finance;
    }

    /**
     * 获取固定电话号码
     *
     * @return FinanceTel - 固定电话号码
     */
    public String getFinanceTel() {
        return financeTel;
    }

    /**
     * 设置固定电话号码
     *
     * @param financeTel 固定电话号码
     */
    public void setFinanceTel(String financeTel) {
        this.financeTel = financeTel;
    }

    /**
     * 获取移动电话
     *
     * @return FinancePhone - 移动电话
     */
    public String getFinancePhone() {
        return financePhone;
    }

    /**
     * 设置移动电话
     *
     * @param financePhone 移动电话
     */
    public void setFinancePhone(String financePhone) {
        this.financePhone = financePhone;
    }

    /**
     * 获取工商联络员
     *
     * @return LiaName - 工商联络员
     */
    public String getLiaName() {
        return liaName;
    }

    /**
     * 设置工商联络员
     *
     * @param liaName 工商联络员
     */
    public void setLiaName(String liaName) {
        this.liaName = liaName;
    }

    /**
     * 获取固定电话号码
     *
     * @return LiaTel - 固定电话号码
     */
    public String getLiaTel() {
        return liaTel;
    }

    /**
     * 设置固定电话号码
     *
     * @param liaTel 固定电话号码
     */
    public void setLiaTel(String liaTel) {
        this.liaTel = liaTel;
    }

    /**
     * 获取移动电话
     *
     * @return LiaPhone - 移动电话
     */
    public String getLiaPhone() {
        return liaPhone;
    }

    /**
     * 设置移动电话
     *
     * @param liaPhone 移动电话
     */
    public void setLiaPhone(String liaPhone) {
        this.liaPhone = liaPhone;
    }

    /**
     * 获取单位电子邮箱
     *
     * @return UnitEmail - 单位电子邮箱
     */
    public String getUnitEmail() {
        return unitEmail;
    }

    /**
     * 设置单位电子邮箱
     *
     * @param unitEmail 单位电子邮箱
     */
    public void setUnitEmail(String unitEmail) {
        this.unitEmail = unitEmail;
    }

    /**
     * 获取联络员电子邮箱
     *
     * @return LiaEMail - 联络员电子邮箱
     */
    public String getLiaEMail() {
        return liaEMail;
    }

    /**
     * 设置联络员电子邮箱
     *
     * @param liaEMail 联络员电子邮箱
     */
    public void setLiaEMail(String liaEMail) {
        this.liaEMail = liaEMail;
    }

    /**
     * 获取填报日期
     *
     * @return CreateTime - 填报日期
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置填报日期
     *
     * @param createTime 填报日期
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取已获得：守合同重信用企业；0.无 1.有
     *
     * @return FarArtCreditworth - 已获得：守合同重信用企业；0.无 1.有
     */
    public String getFarArtCreditworth() {
        return farArtCreditworth;
    }

    /**
     * 设置已获得：守合同重信用企业；0.无 1.有
     *
     * @param farArtCreditworth 已获得：守合同重信用企业；0.无 1.有
     */
    public void setFarArtCreditworth(String farArtCreditworth) {
        this.farArtCreditworth = farArtCreditworth;
    }

    /**
     * 获取已获得：消费者信得过单位、名牌产品；0.无 1.有
     *
     * @return FarArtTruConPro - 已获得：消费者信得过单位、名牌产品；0.无 1.有
     */
    public String getFarArtTruConPro() {
        return farArtTruConPro;
    }

    /**
     * 设置已获得：消费者信得过单位、名牌产品；0.无 1.有
     *
     * @param farArtTruConPro 已获得：消费者信得过单位、名牌产品；0.无 1.有
     */
    public void setFarArtTruConPro(String farArtTruConPro) {
        this.farArtTruConPro = farArtTruConPro;
    }
}