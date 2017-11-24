package com.icinfo.cs.es.dto;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.icinfo.cs.common.utils.AESEUtil;
import com.icinfo.cs.common.utils.DateUtil;

/**
 * 全景查询返回结果DTO 为了处理来自不同搜索引擎的返回结果
 * 
 * @author zhuyong
 */
public class PanoramaResultDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Date lerepUpdatime;// 法人表中更新时间
	private Date liaUpdatime;// 联络员表中更新时间
	private String email;// 短信群发管理中发送邮箱

	public Date getLerepUpdatime() {
		return lerepUpdatime;
	}

	public void setLerepUpdatime(Date lerepUpdatime) {
		this.lerepUpdatime = lerepUpdatime;
	}

	public Date getLiaUpdatime() {
		return liaUpdatime;
	}

	public void setLiaUpdatime(Date liaUpdatime) {
		this.liaUpdatime = liaUpdatime;
	}

	/**
	 * 内部序号
	 */
	private String priPID;

	/**
	 * 企业名称（不分词）
	 */
	private String entName;

	/**
	 * 企业名称（分词）
	 */
	private String entNamePPL;

	/**
	 * 注册号
	 */
	private String regNO;

	/**
	 * 统一信用代码
	 */
	private String uniscid;

	/**
	 * 法定代表人身份证号
	 */
	private String cerNO;

	/**
	 * 法定代表人
	 */
	private String leRep;

	/**
	 * 电话号
	 */
	private String tel;

	/**
	 * 行业代码
	 */
	private String industryCo;

	/**
	 * 行业名称
	 */
	private String industryCoName;

	/**
	 * 企业类型
	 */
	private String entType;

	/**
	 * 企业类型名称
	 */
	private String entTypeName;

	/**
	 * 市场主体类型大类
	 */
	private String entTypeCatg;

	private String yrYear;

	/**
	 * 市场主体类型大类名称
	 */
	private String entTypeCatgName;

	/**
	 * 住所
	 */
	private String dom;

	/**
	 * 管辖单位
	 */
	private String localAdm;

	/**
	 * 管辖单位名称
	 */
	private String localAdmName;

	/**
	 * 登记机关
	 */
	private String regOrg;

	/**
	 * 登记机关名称
	 */
	private String regOrgName;

	/**
	 * 抽检部门
	 */
	private String checkDep;

	/**
	 * 抽检部门名称
	 */
	private String checkDepName;

	/**
	 * 委托机关
	 */
	private String delegateOrg;

	/**
	 * 委托机关名称
	 */
	private String delegateOrgName;

	/**
	 * 责任区商圈
	 */
	private String sliceNO;

	/**
	 * 责任区商圈名称
	 */
	private String sliceNOName;

	/**
	 * 属地机关
	 */
	private String localRegOrgCode;

	/**
	 * 属地机关名称
	 */
	private String localRegOrgCodeName;

	/**
	 * 是否需要委托备份
	 */
	private String isNeedDelegate;

	/**
	 * 核准日期
	 */
	private String apprDate;

	/**
	 * 成立日期
	 */
	private String estDate;

	/**
	 * 经营期限自
	 */
	private String opFrom;

	/**
	 * 经营期限至
	 */
	private String opTo;

	/**
	 * 变更注销日期
	 */
	private String altDate;

	/**
	 * 注册资本
	 */
	private String regCap;

	/**
	 * 运营状态
	 */
	private String regState;

	/**
	 * 个转企
	 */
	private String isIndivid;

	/**
	 * 法人是否受限
	 */
	private String leRepIsLim;

	/**
	 * 信用等级
	 */
	private String creLevel;

	/**
	 * 联络员证件号
	 */
	private String liaIDNum;

	/**
	 * 联络员证件类型
	 */
	private String liaIDType;

	/**
	 * 联络员姓名
	 */
	private String liaName;

	/**
	 * 联络员电话
	 */
	private String liaTel;

	/**
	 * 是否有行政处罚
	 */
	private String isCase;

	/**
	 * 是否进入异常名录
	 */
	private String isOpan;

	/**
	 * 是否重点行业监管对象
	 */
	private String isIndRegObj;

	/**
	 * 是否重点关注服务对象
	 */
	private String isFocusObj;

	/**
	 * 是否有风险预警
	 */
	private String isRiskWarn;

	/**
	 * 前置许可证名称
	 */
	private String licNameBef;

	/**
	 * 后置许可证名称
	 */
	private String licNameAft;

	/**
	 * 是否抽查检查名单
	 */
	private String isSpot;

	/**
	 * 实缴认缴企业
	 */
	private String paidOrSub;

	/**
	 * 抽查检查编号
	 */
	private String spotNO;

	/**
	 * 抽查检查年度
	 */
	private String spotYear;

	/**
	 * 抽检时间
	 */
	private String spotDate;

	/**
	 * 抽查检查结果
	 */
	private String spotResult;

	/**
	 * 经营范围
	 */
	private String opScope;

	/**
	 * 是否重点行业监管对象名称
	 */
	private String isIndRegObjName;

	/**
	 * 是否重点关注服务对象名称
	 */
	private String isFocusObjName;

	/**
	 * 是否建档
	 */
	private String isClaimRegist;

	/**
	 * 2013年是否年报
	 */
	private String yrIsRep2013;

	/**
	 * 2013年年报状态
	 */
	private String yrRepState2013;

	/**
	 * 2013年首次报送时间
	 */
	private String yrFirRepTime2013;

	/**
	 * 2013年最近报送时间
	 */
	private String yrRecRepTime2013;

	/**
	 * 2013年报送方式
	 */
	private String yrRepMode2013;

	/**
	 * 2013年联络员确认
	 */
	private String yrLiaTel2013;

	/**
	 * 2013年是否修改过年报
	 */
	private String yrRepModify2013;

	/**
	 * 2013年是否涉及过敏感词审核
	 */
	private String yrSenCheck2013;

	/**
	 * 2014年是否年报
	 */
	private String yrIsRep2014;

	/**
	 * 2014年年报状态
	 */
	private String yrRepState2014;

	/**
	 * 2014年首次报送时间
	 */
	private String yrFirRepTime2014;

	/**
	 * 2014年最近报送时间
	 */
	private String yrRecRepTime2014;

	/**
	 * 2014年报送方式
	 */
	private String yrRepMode2014;

	/**
	 * 2014年联络员确认
	 */
	private String yrLiaTel2014;

	/**
	 * 2014年是否修改过年报
	 */
	private String yrRepModify2014;

	/**
	 * 2014年是否涉及过敏感词审核
	 */
	private String yrSenCheck2014;

	/**
	 * 2015年是否年报
	 */
	private String yrIsRep2015;

	/**
	 * 2015年年报状态
	 */
	private String yrRepState2015;

	/**
	 * 2015年首次报送时间
	 */
	private String yrFirRepTime2015;

	/**
	 * 2015年最近报送时间
	 */
	private String yrRecRepTime2015;

	/**
	 * 2015年报送方式
	 */
	private String yrRepMode2015;

	/**
	 * 2015年联络员确认
	 */
	private String yrLiaTel2015;

	/**
	 * 2015年是否修改过年报
	 */
	private String yrRepModify2015;

	/**
	 * 2015年是否涉及过敏感词审核
	 */
	private String yrSenCheck2015;

	/**
	 * 2016年是否年报
	 */
	private String yrIsRep2016;

	/**
	 * 2016年年报状态
	 */
	private String yrRepState2016;

	/**
	 * 2016年首次报送时间
	 */
	private String yrFirRepTime2016;

	/**
	 * 2016年最近报送时间
	 */
	private String yrRecRepTime2016;

	/**
	 * 2016年报送方式
	 */
	private String yrRepMode2016;

	/**
	 * 2016年联络员确认
	 */
	private String yrLiaTel2016;

	/**
	 * 2016年是否修改过年报
	 */
	private String yrRepModify2016;

	/**
	 * 2016年是否涉及过敏感词审核
	 */
	private String yrSenCheck2016;

	/**
	 * 2017年是否年报
	 */
	private String yrIsRep2017;

	/**
	 * 2017年年报状态
	 */
	private String yrRepState2017;

	/**
	 * 2017年首次报送时间
	 */
	private String yrFirRepTime2017;

	/**
	 * 2017年最近报送时间
	 */
	private String yrRecRepTime2017;

	/**
	 * 2017年报送方式
	 */
	private String yrRepMode2017;

	/**
	 * 2017年联络员确认
	 */
	private String yrLiaTel2017;

	/**
	 * 2017年是否修改过年报
	 */
	private String yrRepModify2017;

	/**
	 * 2017年是否涉及过敏感词审核
	 */
	private String yrSenCheck2017;

	/**
	 * 2018年是否年报
	 */
	private String yrIsRep2018;

	/**
	 * 2018年年报状态
	 */
	private String yrRepState2018;

	/**
	 * 2018年首次报送时间
	 */
	private String yrFirRepTime2018;

	/**
	 * 2018年最近报送时间
	 */
	private String yrRecRepTime2018;

	/**
	 * 2018年报送方式
	 */
	private String yrRepMode2018;

	/**
	 * 2018年联络员确认
	 */
	private String yrLiaTel2018;

	/**
	 * 2018年是否修改过年报
	 */
	private String yrRepModify2018;

	/**
	 * 2018年是否涉及过敏感词审核
	 */
	private String yrSenCheck2018;

	/**
	 * 2019年是否年报
	 */
	private String yrIsRep2019;

	/**
	 * 2019年年报状态
	 */
	private String yrRepState2019;

	/**
	 * 2019年首次报送时间
	 */
	private String yrFirRepTime2019;

	/**
	 * 2019年最近报送时间
	 */
	private String yrRecRepTime2019;

	/**
	 * 2019年报送方式
	 */
	private String yrRepMode2019;

	/**
	 * 2019年联络员确认
	 */
	private String yrLiaTel2019;

	/**
	 * 2019年是否修改过年报
	 */
	private String yrRepModify2019;

	/**
	 * 2019年是否涉及过敏感词审核
	 */
	private String yrSenCheck2019;

	/**
	 * 2020年是否年报
	 */
	private String yrIsRep2020;

	/**
	 * 2020年年报状态
	 */
	private String yrRepState2020;

	/**
	 * 2020年首次报送时间
	 */
	private String yrFirRepTime2020;

	/**
	 * 2020年最近报送时间
	 */
	private String yrRecRepTime2020;

	/**
	 * 2020年报送方式
	 */
	private String yrRepMode2020;

	/**
	 * 2020年联络员确认
	 */
	private String yrLiaTel2020;

	/**
	 * 2020年是否修改过年报
	 */
	private String yrRepModify2020;

	/**
	 * 2020年是否涉及过敏感词审核
	 */
	private String yrSenCheck2020;

	/**
	 * 2021年是否年报
	 */
	private String yrIsRep2021;

	/**
	 * 2021年年报状态
	 */
	private String yrRepState2021;

	/**
	 * 2021年首次报送时间
	 */
	private String yrFirRepTime2021;

	/**
	 * 2021年最近报送时间
	 */
	private String yrRecRepTime2021;

	/**
	 * 2021年报送方式
	 */
	private String yrRepMode2021;

	/**
	 * 2021年联络员确认
	 */
	private String yrLiaTel2021;

	/**
	 * 2021年是否修改过年报
	 */
	private String yrRepModify2021;

	/**
	 * 2021年是否涉及过敏感词审核
	 */
	private String yrSenCheck2021;

	/**
	 * 2022年是否年报
	 */
	private String yrIsRep2022;

	/**
	 * 2022年年报状态
	 */
	private String yrRepState2022;

	/**
	 * 2022年首次报送时间
	 */
	private String yrFirRepTime2022;

	/**
	 * 2022年最近报送时间
	 */
	private String yrRecRepTime2022;

	/**
	 * 2022年报送方式
	 */
	private String yrRepMode2022;

	/**
	 * 2022年联络员确认
	 */
	private String yrLiaTel2022;

	/**
	 * 2022年是否修改过年报
	 */
	private String yrRepModify2022;

	/**
	 * 2022年是否涉及过敏感词审核
	 */
	private String yrSenCheck2022;

	/** 行政处罚 */
	private String imCase;
	/** 股东出资 */
	private String imInvest;
	/** 行政许可 */
	private String imPermit;
	/** 知识产权出质 */
	private String imIppldg;
	/** 股权变更 */
	private String imInvsra;
	/** 严重违法 */
	private String isSerVio;

	/** 接收部门 */
	private String acceptDept2013;
	/** 接收部门 */
	private String acceptDept2014;
	/** 接收部门 */
	private String acceptDept2015;
	/** 接收部门 */
	private String acceptDept2016;

	/** 接受日期 */
	private String acceptDate2013;
	/** 接受日期 */
	private String acceptDate2014;
	/** 接受日期 */
	private String acceptDate2015;
	/** 接受日期 */
	private String acceptDate2016;

	/** 接收姓名 */
	private String acceptName2013;
	/** 接收姓名 */
	private String acceptName2014;
	/** 接收姓名 */
	private String acceptName2015;
	/** 接收姓名 */
	private String acceptName2016;

	private String imPubDate;

	// 司法协助
	private String isJudicial;
	// 简易注销
	private String isSim;

	// ------------------------------------------------------个体户接收新加字段-------------------------------------------------
	// 接收人
	private String acceptName;

	// 接收日期
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date acceptDate;
	// 接收部门
	private String acceptDept;
	// 年度年报状态：0未年报；1已年报；2已年报（逾期）
	private String isReported;
	// 年报方式
	private String reportType;
	// 首次报送时间
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date firstReportTime;
	// 纸质年报补录状态：0 未补录 1 录入中 2 已补录
	private String addRecState;

	public String getPriPID() {
		return priPID;
	}

	public void setPriPID(String priPID) {
		this.priPID = priPID;
	}

	public String getEntName() {
		return entName;
	}

	public void setEntName(String entName) {
		this.entName = entName;
	}

	public String getEntNamePPL() {
		return entNamePPL;
	}

	public void setEntNamePPL(String entNamePPL) {
		this.entNamePPL = entNamePPL;
	}

	public String getRegNO() {
		return regNO;
	}

	public void setRegNO(String regNO) {
		this.regNO = regNO;
	}

	public String getUniscid() {
		return uniscid;
	}

	public void setUniscid(String uniscid) {
		this.uniscid = uniscid;
	}

	public String getCerNO() {
		return cerNO;
	}

	public void setCerNO(String cerNO) {
		this.cerNO = cerNO;
	}

	public String getLeRep() {
		return leRep;
	}

	public void setLeRep(String leRep) {
		this.leRep = leRep;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getIndustryCo() {
		return industryCo;
	}

	public void setIndustryCo(String industryCo) {
		this.industryCo = industryCo;
	}

	public String getIndustryCoName() {
		return industryCoName;
	}

	public void setIndustryCoName(String industryCoName) {
		this.industryCoName = industryCoName;
	}

	public String getEntType() {
		return entType;
	}

	public void setEntType(String entType) {
		this.entType = entType;
	}

	public String getEntTypeName() {
		return entTypeName;
	}

	public void setEntTypeName(String entTypeName) {
		this.entTypeName = entTypeName;
	}

	public String getEntTypeCatg() {
		return entTypeCatg;
	}

	public void setEntTypeCatg(String entTypeCatg) {
		this.entTypeCatg = entTypeCatg;
	}

	public String getEntTypeCatgName() {
		return entTypeCatgName;
	}

	public void setEntTypeCatgName(String entTypeCatgName) {
		this.entTypeCatgName = entTypeCatgName;
	}

	public String getDom() {
		return dom;
	}

	public void setDom(String dom) {
		this.dom = dom;
	}

	public String getLocalAdm() {
		return localAdm;
	}

	public void setLocalAdm(String localAdm) {
		this.localAdm = localAdm;
	}

	public String getLocalAdmName() {
		return localAdmName;
	}

	public void setLocalAdmName(String localAdmName) {
		this.localAdmName = localAdmName;
	}

	public String getRegOrg() {
		return regOrg;
	}

	public void setRegOrg(String regOrg) {
		this.regOrg = regOrg;
	}

	public String getRegOrgName() {
		return regOrgName;
	}

	public void setRegOrgName(String regOrgName) {
		this.regOrgName = regOrgName;
	}

	public String getCheckDep() {
		return checkDep;
	}

	public void setCheckDep(String checkDep) {
		this.checkDep = checkDep;
	}

	public String getCheckDepName() {
		return checkDepName;
	}

	public void setCheckDepName(String checkDepName) {
		this.checkDepName = checkDepName;
	}

	public String getDelegateOrg() {
		return delegateOrg;
	}

	public void setDelegateOrg(String delegateOrg) {
		this.delegateOrg = delegateOrg;
	}

	public String getDelegateOrgName() {
		return delegateOrgName;
	}

	public void setDelegateOrgName(String delegateOrgName) {
		this.delegateOrgName = delegateOrgName;
	}

	public String getSliceNO() {
		return sliceNO;
	}

	public void setSliceNO(String sliceNO) {
		this.sliceNO = sliceNO;
	}

	public String getSliceNOName() {
		return sliceNOName;
	}

	public void setSliceNOName(String sliceNOName) {
		this.sliceNOName = sliceNOName;
	}

	public String getLocalRegOrgCode() {
		return localRegOrgCode;
	}

	public void setLocalRegOrgCode(String localRegOrgCode) {
		this.localRegOrgCode = localRegOrgCode;
	}

	public String getLocalRegOrgCodeName() {
		return localRegOrgCodeName;
	}

	public void setLocalRegOrgCodeName(String localRegOrgCodeName) {
		this.localRegOrgCodeName = localRegOrgCodeName;
	}

	public String getApprDate() {
		return formatDate(apprDate);
	}

	public void setApprDate(String apprDate) {
		this.apprDate = apprDate;
	}

	public String getEstDate() {
		return formatDate(estDate);
	}

	public void setEstDate(String estDate) {
		this.estDate = estDate;
	}

	public String getOpFrom() {
		return formatDate(opFrom);
	}

	public void setOpFrom(String opFrom) {
		this.opFrom = opFrom;
	}

	public String getOpTo() {
		return formatDate(opTo);
	}

	public void setOpTo(String opTo) {
		this.opTo = opTo;
	}

	public String getRegCap() {
		return regCap;
	}

	public void setRegCap(String regCap) {
		this.regCap = regCap;
	}

	public String getRegState() {
		return regState;
	}

	public void setRegState(String regState) {
		this.regState = regState;
	}

	public String getIsIndivid() {
		return isIndivid;
	}

	public void setIsIndivid(String isIndivid) {
		this.isIndivid = isIndivid;
	}

	public String getLeRepIsLim() {
		return leRepIsLim;
	}

	public void setLeRepIsLim(String leRepIsLim) {
		this.leRepIsLim = leRepIsLim;
	}

	public String getCreLevel() {
		return creLevel;
	}

	public void setCreLevel(String creLevel) {
		this.creLevel = creLevel;
	}

	public String getLiaIDNum() {
		return liaIDNum;
	}

	public void setLiaIDNum(String liaIDNum) {
		this.liaIDNum = liaIDNum;
	}

	public String getLiaIDType() {
		return liaIDType;
	}

	public void setLiaIDType(String liaIDType) {
		this.liaIDType = liaIDType;
	}

	public String getLiaName() {
		return liaName;
	}

	public void setLiaName(String liaName) {
		this.liaName = liaName;
	}

	public String getLiaTel() {
		return liaTel;
	}

	public void setLiaTel(String liaTel) {
		this.liaTel = liaTel;
	}

	public String getIsCase() {
		return isCase;
	}

	public void setIsCase(String isCase) {
		this.isCase = isCase;
	}

	public String getIsOpan() {
		return isOpan;
	}

	public void setIsOpan(String isOpan) {
		this.isOpan = isOpan;
	}

	public String getIsIndRegObj() {
		return isIndRegObj;
	}

	public void setIsIndRegObj(String isIndRegObj) {
		this.isIndRegObj = isIndRegObj;
	}

	public String getIsFocusObj() {
		return isFocusObj;
	}

	public void setIsFocusObj(String isFocusObj) {
		this.isFocusObj = isFocusObj;
	}

	public String getIsRiskWarn() {
		return isRiskWarn;
	}

	public void setIsRiskWarn(String isRiskWarn) {
		this.isRiskWarn = isRiskWarn;
	}

	public String getLicNameBef() {
		return licNameBef;
	}

	public void setLicNameBef(String licNameBef) {
		this.licNameBef = licNameBef;
	}

	public String getLicNameAft() {
		return licNameAft;
	}

	public void setLicNameAft(String licNameAft) {
		this.licNameAft = licNameAft;
	}

	public String getIsSpot() {
		return isSpot;
	}

	public void setIsSpot(String isSpot) {
		this.isSpot = isSpot;
	}

	public String getPaidOrSub() {
		return paidOrSub;
	}

	public void setPaidOrSub(String paidOrSub) {
		this.paidOrSub = paidOrSub;
	}

	public String getSpotNO() {
		return spotNO;
	}

	public void setSpotNO(String spotNO) {
		this.spotNO = spotNO;
	}

	public String getSpotYear() {
		return spotYear;
	}

	public void setSpotYear(String spotYear) {
		this.spotYear = spotYear;
	}

	public String getSpotResult() {
		return spotResult;
	}

	public void setSpotResult(String spotResult) {
		this.spotResult = spotResult;
	}

	public String getOpScope() {
		return opScope;
	}

	public void setOpScope(String opScope) {
		this.opScope = opScope;
	}

	public String getIsIndRegObjName() {
		return isIndRegObjName;
	}

	public void setIsIndRegObjName(String isIndRegObjName) {
		this.isIndRegObjName = isIndRegObjName;
	}

	public String getIsFocusObjName() {
		return isFocusObjName;
	}

	public void setIsFocusObjName(String isFocusObjName) {
		this.isFocusObjName = isFocusObjName;
	}

	public String getIsClaimRegist() {
		return isClaimRegist;
	}

	public void setIsClaimRegist(String isClaimRegist) {
		this.isClaimRegist = isClaimRegist;
	}

	public String getYrIsRep2013() {
		return yrIsRep2013;
	}

	public void setYrIsRep2013(String yrIsRep2013) {
		this.yrIsRep2013 = yrIsRep2013;
	}

	public String getYrRepState2013() {
		return yrRepState2013;
	}

	public void setYrRepState2013(String yrRepState2013) {
		this.yrRepState2013 = yrRepState2013;
	}

	public String getYrFirRepTime2013() {
		return formatDate(yrFirRepTime2013);
	}

	public void setYrFirRepTime2013(String yrFirRepTime2013) {
		this.yrFirRepTime2013 = yrFirRepTime2013;
	}

	public String getYrRecRepTime2013() {
		return formatDate(yrRecRepTime2013);
	}

	public void setYrRecRepTime2013(String yrRecRepTime2013) {
		this.yrRecRepTime2013 = yrRecRepTime2013;
	}

	public String getYrRepMode2013() {
		return yrRepMode2013;
	}

	public void setYrRepMode2013(String yrRepMode2013) {
		this.yrRepMode2013 = yrRepMode2013;
	}

	public String getYrLiaTel2013() {
		return yrLiaTel2013;
	}

	public void setYrLiaTel2013(String yrLiaTel2013) {
		this.yrLiaTel2013 = yrLiaTel2013;
	}

	public String getYrRepModify2013() {
		return yrRepModify2013;
	}

	public void setYrRepModify2013(String yrRepModify2013) {
		this.yrRepModify2013 = yrRepModify2013;
	}

	public String getYrSenCheck2013() {
		return yrSenCheck2013;
	}

	public void setYrSenCheck2013(String yrSenCheck2013) {
		this.yrSenCheck2013 = yrSenCheck2013;
	}

	public String getYrIsRep2014() {
		return yrIsRep2014;
	}

	public void setYrIsRep2014(String yrIsRep2014) {
		this.yrIsRep2014 = yrIsRep2014;
	}

	public String getYrRepState2014() {
		return yrRepState2014;
	}

	public void setYrRepState2014(String yrRepState2014) {
		this.yrRepState2014 = yrRepState2014;
	}

	public String getYrFirRepTime2014() {
		return formatDate(yrFirRepTime2014);
	}

	public void setYrFirRepTime2014(String yrFirRepTime2014) {
		this.yrFirRepTime2014 = yrFirRepTime2014;
	}

	public String getYrRecRepTime2014() {
		return formatDate(yrRecRepTime2014);
	}

	public void setYrRecRepTime2014(String yrRecRepTime2014) {
		this.yrRecRepTime2014 = yrRecRepTime2014;
	}

	public String getYrRepMode2014() {
		return yrRepMode2014;
	}

	public void setYrRepMode2014(String yrRepMode2014) {
		this.yrRepMode2014 = yrRepMode2014;
	}

	public String getYrLiaTel2014() {
		return yrLiaTel2014;
	}

	public void setYrLiaTel2014(String yrLiaTel2014) {
		this.yrLiaTel2014 = yrLiaTel2014;
	}

	public String getYrRepModify2014() {
		return yrRepModify2014;
	}

	public void setYrRepModify2014(String yrRepModify2014) {
		this.yrRepModify2014 = yrRepModify2014;
	}

	public String getYrSenCheck2014() {
		return yrSenCheck2014;
	}

	public void setYrSenCheck2014(String yrSenCheck2014) {
		this.yrSenCheck2014 = yrSenCheck2014;
	}

	public String getYrIsRep2015() {
		return yrIsRep2015;
	}

	public void setYrIsRep2015(String yrIsRep2015) {
		this.yrIsRep2015 = yrIsRep2015;
	}

	public String getYrRepState2015() {
		return yrRepState2015;
	}

	public void setYrRepState2015(String yrRepState2015) {
		this.yrRepState2015 = yrRepState2015;
	}

	public String getYrFirRepTime2015() {
		return formatDate(yrFirRepTime2015);
	}

	public void setYrFirRepTime2015(String yrFirRepTime2015) {
		this.yrFirRepTime2015 = yrFirRepTime2015;
	}

	public String getYrRecRepTime2015() {
		return formatDate(yrRecRepTime2015);
	}

	public void setYrRecRepTime2015(String yrRecRepTime2015) {
		this.yrRecRepTime2015 = yrRecRepTime2015;
	}

	public String getYrRepMode2015() {
		return yrRepMode2015;
	}

	public void setYrRepMode2015(String yrRepMode2015) {
		this.yrRepMode2015 = yrRepMode2015;
	}

	public String getYrLiaTel2015() {
		return yrLiaTel2015;
	}

	public void setYrLiaTel2015(String yrLiaTel2015) {
		this.yrLiaTel2015 = yrLiaTel2015;
	}

	public String getYrRepModify2015() {
		return yrRepModify2015;
	}

	public void setYrRepModify2015(String yrRepModify2015) {
		this.yrRepModify2015 = yrRepModify2015;
	}

	public String getYrSenCheck2015() {
		return yrSenCheck2015;
	}

	public void setYrSenCheck2015(String yrSenCheck2015) {
		this.yrSenCheck2015 = yrSenCheck2015;
	}

	public String getYrIsRep2016() {
		return yrIsRep2016;
	}

	public void setYrIsRep2016(String yrIsRep2016) {
		this.yrIsRep2016 = yrIsRep2016;
	}

	public String getYrRepState2016() {
		return yrRepState2016;
	}

	public void setYrRepState2016(String yrRepState2016) {
		this.yrRepState2016 = yrRepState2016;
	}

	public String getYrFirRepTime2016() {
		return formatDate(yrFirRepTime2016);
	}

	public void setYrFirRepTime2016(String yrFirRepTime2016) {
		this.yrFirRepTime2016 = yrFirRepTime2016;
	}

	public String getYrRecRepTime2016() {
		return formatDate(yrRecRepTime2016);
	}

	public void setYrRecRepTime2016(String yrRecRepTime2016) {
		this.yrRecRepTime2016 = yrRecRepTime2016;
	}

	public String getYrRepMode2016() {
		return yrRepMode2016;
	}

	public void setYrRepMode2016(String yrRepMode2016) {
		this.yrRepMode2016 = yrRepMode2016;
	}

	public String getYrLiaTel2016() {
		return yrLiaTel2016;
	}

	public void setYrLiaTel2016(String yrLiaTel2016) {
		this.yrLiaTel2016 = yrLiaTel2016;
	}

	public String getYrRepModify2016() {
		return yrRepModify2016;
	}

	public void setYrRepModify2016(String yrRepModify2016) {
		this.yrRepModify2016 = yrRepModify2016;
	}

	public String getYrSenCheck2016() {
		return yrSenCheck2016;
	}

	public void setYrSenCheck2016(String yrSenCheck2016) {
		this.yrSenCheck2016 = yrSenCheck2016;
	}

	public String getYrIsRep2017() {
		return yrIsRep2017;
	}

	public void setYrIsRep2017(String yrIsRep2017) {
		this.yrIsRep2017 = yrIsRep2017;
	}

	public String getYrRepState2017() {
		return yrRepState2017;
	}

	public void setYrRepState2017(String yrRepState2017) {
		this.yrRepState2017 = yrRepState2017;
	}

	public String getYrFirRepTime2017() {
		return formatDate(yrFirRepTime2017);
	}

	public void setYrFirRepTime2017(String yrFirRepTime2017) {
		this.yrFirRepTime2017 = yrFirRepTime2017;
	}

	public String getYrRecRepTime2017() {
		return formatDate(yrRecRepTime2017);
	}

	public void setYrRecRepTime2017(String yrRecRepTime2017) {
		this.yrRecRepTime2017 = yrRecRepTime2017;
	}

	public String getYrRepMode2017() {
		return yrRepMode2017;
	}

	public void setYrRepMode2017(String yrRepMode2017) {
		this.yrRepMode2017 = yrRepMode2017;
	}

	public String getYrLiaTel2017() {
		return yrLiaTel2017;
	}

	public void setYrLiaTel2017(String yrLiaTel2017) {
		this.yrLiaTel2017 = yrLiaTel2017;
	}

	public String getYrRepModify2017() {
		return yrRepModify2017;
	}

	public void setYrRepModify2017(String yrRepModify2017) {
		this.yrRepModify2017 = yrRepModify2017;
	}

	public String getYrSenCheck2017() {
		return yrSenCheck2017;
	}

	public void setYrSenCheck2017(String yrSenCheck2017) {
		this.yrSenCheck2017 = yrSenCheck2017;
	}

	public String getYrIsRep2018() {
		return yrIsRep2018;
	}

	public void setYrIsRep2018(String yrIsRep2018) {
		this.yrIsRep2018 = yrIsRep2018;
	}

	public String getYrRepState2018() {
		return yrRepState2018;
	}

	public void setYrRepState2018(String yrRepState2018) {
		this.yrRepState2018 = yrRepState2018;
	}

	public String getYrFirRepTime2018() {
		return formatDate(yrFirRepTime2018);
	}

	public void setYrFirRepTime2018(String yrFirRepTime2018) {
		this.yrFirRepTime2018 = yrFirRepTime2018;
	}

	public String getYrRecRepTime2018() {
		return formatDate(yrRecRepTime2018);
	}

	public void setYrRecRepTime2018(String yrRecRepTime2018) {
		this.yrRecRepTime2018 = yrRecRepTime2018;
	}

	public String getYrRepMode2018() {
		return yrRepMode2018;
	}

	public void setYrRepMode2018(String yrRepMode2018) {
		this.yrRepMode2018 = yrRepMode2018;
	}

	public String getYrLiaTel2018() {
		return yrLiaTel2018;
	}

	public void setYrLiaTel2018(String yrLiaTel2018) {
		this.yrLiaTel2018 = yrLiaTel2018;
	}

	public String getYrRepModify2018() {
		return yrRepModify2018;
	}

	public void setYrRepModify2018(String yrRepModify2018) {
		this.yrRepModify2018 = yrRepModify2018;
	}

	public String getYrSenCheck2018() {
		return yrSenCheck2018;
	}

	public void setYrSenCheck2018(String yrSenCheck2018) {
		this.yrSenCheck2018 = yrSenCheck2018;
	}

	public String getYrIsRep2019() {
		return yrIsRep2019;
	}

	public void setYrIsRep2019(String yrIsRep2019) {
		this.yrIsRep2019 = yrIsRep2019;
	}

	public String getYrRepState2019() {
		return yrRepState2019;
	}

	public void setYrRepState2019(String yrRepState2019) {
		this.yrRepState2019 = yrRepState2019;
	}

	public String getYrFirRepTime2019() {
		return formatDate(yrFirRepTime2019);
	}

	public void setYrFirRepTime2019(String yrFirRepTime2019) {
		this.yrFirRepTime2019 = yrFirRepTime2019;
	}

	public String getYrRecRepTime2019() {
		return formatDate(yrRecRepTime2019);
	}

	public void setYrRecRepTime2019(String yrRecRepTime2019) {
		this.yrRecRepTime2019 = yrRecRepTime2019;
	}

	public String getYrRepMode2019() {
		return yrRepMode2019;
	}

	public void setYrRepMode2019(String yrRepMode2019) {
		this.yrRepMode2019 = yrRepMode2019;
	}

	public String getYrLiaTel2019() {
		return yrLiaTel2019;
	}

	public void setYrLiaTel2019(String yrLiaTel2019) {
		this.yrLiaTel2019 = yrLiaTel2019;
	}

	public String getYrRepModify2019() {
		return yrRepModify2019;
	}

	public void setYrRepModify2019(String yrRepModify2019) {
		this.yrRepModify2019 = yrRepModify2019;
	}

	public String getYrSenCheck2019() {
		return yrSenCheck2019;
	}

	public void setYrSenCheck2019(String yrSenCheck2019) {
		this.yrSenCheck2019 = yrSenCheck2019;
	}

	public String getYrIsRep2020() {
		return yrIsRep2020;
	}

	public void setYrIsRep2020(String yrIsRep2020) {
		this.yrIsRep2020 = yrIsRep2020;
	}

	public String getYrRepState2020() {
		return yrRepState2020;
	}

	public void setYrRepState2020(String yrRepState2020) {
		this.yrRepState2020 = yrRepState2020;
	}

	public String getYrFirRepTime2020() {
		return formatDate(yrFirRepTime2020);
	}

	public void setYrFirRepTime2020(String yrFirRepTime2020) {
		this.yrFirRepTime2020 = yrFirRepTime2020;
	}

	public String getYrRecRepTime2020() {
		return formatDate(yrRecRepTime2020);
	}

	public void setYrRecRepTime2020(String yrRecRepTime2020) {
		this.yrRecRepTime2020 = yrRecRepTime2020;
	}

	public String getYrRepMode2020() {
		return yrRepMode2020;
	}

	public void setYrRepMode2020(String yrRepMode2020) {
		this.yrRepMode2020 = yrRepMode2020;
	}

	public String getYrLiaTel2020() {
		return yrLiaTel2020;
	}

	public void setYrLiaTel2020(String yrLiaTel2020) {
		this.yrLiaTel2020 = yrLiaTel2020;
	}

	public String getYrRepModify2020() {
		return yrRepModify2020;
	}

	public void setYrRepModify2020(String yrRepModify2020) {
		this.yrRepModify2020 = yrRepModify2020;
	}

	public String getYrSenCheck2020() {
		return yrSenCheck2020;
	}

	public void setYrSenCheck2020(String yrSenCheck2020) {
		this.yrSenCheck2020 = yrSenCheck2020;
	}

	public String getPriPIDDesc() {
		return AESEUtil.encodeCorpid(this.priPID);
	}

	public String getIsNeedDelegate() {
		return isNeedDelegate;
	}

	public void setIsNeedDelegate(String isNeedDelegate) {
		this.isNeedDelegate = isNeedDelegate;
	}

	public String getAltDate() {
		return formatDate(altDate);
	}

	public void setAltDate(String altDate) {
		this.altDate = altDate;
	}

	public String getSpotDate() {
		return formatDate(spotDate);
	}

	public void setSpotDate(String spotDate) {
		this.spotDate = spotDate;
	}

	public String getYrIsRep2021() {
		return yrIsRep2021;
	}

	public void setYrIsRep2021(String yrIsRep2021) {
		this.yrIsRep2021 = yrIsRep2021;
	}

	public String getYrRepState2021() {
		return yrRepState2021;
	}

	public void setYrRepState2021(String yrRepState2021) {
		this.yrRepState2021 = yrRepState2021;
	}

	public String getYrFirRepTime2021() {
		return formatDate(yrFirRepTime2021);
	}

	public void setYrFirRepTime2021(String yrFirRepTime2021) {
		this.yrFirRepTime2021 = yrFirRepTime2021;
	}

	public String getYrRecRepTime2021() {
		return formatDate(yrRecRepTime2021);
	}

	public void setYrRecRepTime2021(String yrRecRepTime2021) {
		this.yrRecRepTime2021 = yrRecRepTime2021;
	}

	public String getYrRepMode2021() {
		return yrRepMode2021;
	}

	public void setYrRepMode2021(String yrRepMode2021) {
		this.yrRepMode2021 = yrRepMode2021;
	}

	public String getYrLiaTel2021() {
		return yrLiaTel2021;
	}

	public void setYrLiaTel2021(String yrLiaTel2021) {
		this.yrLiaTel2021 = yrLiaTel2021;
	}

	public String getYrRepModify2021() {
		return yrRepModify2021;
	}

	public void setYrRepModify2021(String yrRepModify2021) {
		this.yrRepModify2021 = yrRepModify2021;
	}

	public String getYrSenCheck2021() {
		return yrSenCheck2021;
	}

	public void setYrSenCheck2021(String yrSenCheck2021) {
		this.yrSenCheck2021 = yrSenCheck2021;
	}

	public String getYrIsRep2022() {
		return yrIsRep2022;
	}

	public void setYrIsRep2022(String yrIsRep2022) {
		this.yrIsRep2022 = yrIsRep2022;
	}

	public String getYrRepState2022() {
		return yrRepState2022;
	}

	public void setYrRepState2022(String yrRepState2022) {
		this.yrRepState2022 = yrRepState2022;
	}

	public String getYrFirRepTime2022() {
		return formatDate(yrFirRepTime2022);
	}

	public void setYrFirRepTime2022(String yrFirRepTime2022) {
		this.yrFirRepTime2022 = yrFirRepTime2022;
	}

	public String getYrRecRepTime2022() {
		return formatDate(yrRecRepTime2022);
	}

	public void setYrRecRepTime2022(String yrRecRepTime2022) {
		this.yrRecRepTime2022 = yrRecRepTime2022;
	}

	public String getYrRepMode2022() {
		return yrRepMode2022;
	}

	public void setYrRepMode2022(String yrRepMode2022) {
		this.yrRepMode2022 = yrRepMode2022;
	}

	public String getYrLiaTel2022() {
		return yrLiaTel2022;
	}

	public void setYrLiaTel2022(String yrLiaTel2022) {
		this.yrLiaTel2022 = yrLiaTel2022;
	}

	public String getYrRepModify2022() {
		return yrRepModify2022;
	}

	public void setYrRepModify2022(String yrRepModify2022) {
		this.yrRepModify2022 = yrRepModify2022;
	}

	public String getYrSenCheck2022() {
		return yrSenCheck2022;
	}

	public void setYrSenCheck2022(String yrSenCheck2022) {
		this.yrSenCheck2022 = yrSenCheck2022;
	}

	/**
	 * 处理日期字符串 来自云平台和原生搜索引擎返回的日期格式不相同 云平台 yyyyMMddHHmmss 原生
	 * yyyy-MM-dd'T'HH:mm:ss.SSSXXX
	 * 
	 * @param date
	 * @return
	 */
	private String formatDate(String date) {

		if (StringUtils.isBlank(date) || date.length() < 14)
			return "-";
		try {
			if (date.length() == 14) {
				date = date.substring(0, 8);
				return DateUtil.dateToString(DateUtil.stringToDate(date, "yyyyMMdd"), "yyyy-MM-dd");
			}
			return date.substring(0, 10);
		} catch (Exception e) {
			return "-";
		}
	}

	public String getAcceptName() {
		return acceptName;
	}

	public void setAcceptName(String acceptName) {
		this.acceptName = acceptName;
	}

	public void setAcceptDate(Date acceptDate) {
		this.acceptDate = acceptDate;
	}

	public Date getAcceptDate() {
		return acceptDate;
	}

	public void setAcceptDept(String acceptDept) {
		this.acceptDept = acceptDept;
	}

	public String getAcceptDept() {
		return acceptDept;
	}

	public String getIsReported() {
		return isReported;
	}

	public void setIsReported(String isReported) {
		this.isReported = isReported;
	}

	public void setReportType(String reportType) {
		this.reportType = reportType;
	}

	public String getReportType() {
		return reportType;
	}

	public void setFirstReportTime(Date firstReportTime) {
		this.firstReportTime = firstReportTime;
	}

	public Date getFirstReportTime() {
		return firstReportTime;
	}

	public String getYrYear() {
		return yrYear;
	}

	public String getImCase() {
		return imCase;
	}

	public void setImCase(String imCase) {
		this.imCase = imCase;
	}

	public String getImInvest() {
		return imInvest;
	}

	public void setImInvest(String imInvest) {
		this.imInvest = imInvest;
	}

	public String getImPermit() {
		return imPermit;
	}

	public void setImPermit(String imPermit) {
		this.imPermit = imPermit;
	}

	public String getImIppldg() {
		return imIppldg;
	}

	public void setImIppldg(String imIppldg) {
		this.imIppldg = imIppldg;
	}

	public String getImInvsra() {
		return imInvsra;
	}

	public void setImInvsra(String imInvsra) {
		this.imInvsra = imInvsra;
	}

	public String getIsSerVio() {
		return isSerVio;
	}

	public void setIsSerVio(String isSerVio) {
		this.isSerVio = isSerVio;
	}

	public void setYrYear(String yrYear) {
		this.yrYear = yrYear;
	}

	public String getAcceptDept2013() {
		return acceptDept2013;
	}

	public void setAcceptDept2013(String acceptDept2013) {
		this.acceptDept2013 = acceptDept2013;
	}

	public String getAcceptDept2014() {
		return acceptDept2014;
	}

	public void setAcceptDept2014(String acceptDept2014) {
		this.acceptDept2014 = acceptDept2014;
	}

	public String getAcceptDept2015() {
		return acceptDept2015;
	}

	public void setAcceptDept2015(String acceptDept2015) {
		this.acceptDept2015 = acceptDept2015;
	}

	public String getAcceptDept2016() {
		return acceptDept2016;
	}

	public void setAcceptDept2016(String acceptDept2016) {
		this.acceptDept2016 = acceptDept2016;
	}

	public String getAcceptName2013() {
		return acceptName2013;
	}

	public void setAcceptName2013(String acceptName2013) {
		this.acceptName2013 = acceptName2013;
	}

	public String getAcceptName2014() {
		return acceptName2014;
	}

	public void setAcceptName2014(String acceptName2014) {
		this.acceptName2014 = acceptName2014;
	}

	public String getAcceptName2015() {
		return acceptName2015;
	}

	public void setAcceptName2015(String acceptName2015) {
		this.acceptName2015 = acceptName2015;
	}

	public String getAcceptName2016() {
		return acceptName2016;
	}

	public void setAcceptName2016(String acceptName2016) {
		this.acceptName2016 = acceptName2016;
	}

	public String getAcceptDate2013() {
		return formatDate(acceptDate2013);
	}

	public void setAcceptDate2013(String acceptDate2013) {
		this.acceptDate2013 = acceptDate2013;
	}

	public String getAcceptDate2014() {
		return formatDate(acceptDate2014);
	}

	public void setAcceptDate2014(String acceptDate2014) {
		this.acceptDate2014 = acceptDate2014;
	}

	public String getAcceptDate2015() {
		return formatDate(acceptDate2015);
	}

	public void setAcceptDate2015(String acceptDate2015) {
		this.acceptDate2015 = acceptDate2015;
	}

	public String getAcceptDate2016() {
		return formatDate(acceptDate2016);
	}

	public void setAcceptDate2016(String acceptDate2016) {
		this.acceptDate2016 = acceptDate2016;
	}

	public String getImPubDate() {
		return formatDate(imPubDate);
	}

	public void setImPubDate(String imPubDate) {
		this.imPubDate = imPubDate;
	}

	public String getAddRecState() {
		return addRecState;
	}

	public void setAddRecState(String addRecState) {
		this.addRecState = addRecState;
	}

	public String getIsJudicial() {
		return isJudicial;
	}

	public void setIsJudicial(String isJudicial) {
		this.isJudicial = isJudicial;
	}

	public String getIsSim() {
		return isSim;
	}

	public void setIsSim(String isSim) {
		this.isSim = isSim;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
