/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.ext.dto;

import java.util.Date;

import org.apache.commons.lang.StringUtils;

import com.icinfo.cs.common.utils.AESEUtil;
import com.icinfo.cs.ext.model.MidBaseInfo;

/**
 * 描述: cs_mid_baseinfo 对应的DTO类.<br>
 *
 * @author framework generator
 * @date 2016年08月29日
 */
public class MidBaseInfoDto extends MidBaseInfo {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4927436287596055466L;

	private String entTypeCatgName;// 企业类型(大类)
	private String industryCoName;// 行业名称
	private String positionName;// 关系名称
	private String isOpanomaly;// 是否是经营异常名录
	private String entTypeName;// 企业类型名称
	private Date punishDate;// 吊销企业的吊销日期
	private String exeAffSign;// 执行事务合伙人标记
	private String inv;// 执行事务合伙人名称
	private String isSimpleCancle;//简易注销标记
	private String hisEntName;//历史名称
	
	private String limitName;
	private String cerType;

	// 加密证件号码
	private String encerNO;
	// 加密法定代表人
	private String enleRep;
	//年份
	private Integer year;
	private String batchEntType;
	
	private String basx;//多证合一编码
	private String basxCN;//多证合一名称
	
	private String regStateDesc;
	
	private Date updateTime;
	
	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getBasx() {
		return basx;
	}

	public void setBasx(String basx) {
		this.basx = basx;
	}

	public String getCerType() {
		return cerType;
	}

	public void setCerType(String cerType) {
		this.cerType = cerType;
	}

	public String getIndustryCoName() {
		return industryCoName;
	}

	public void setIndustryCoName(String industryCoName) {
		this.industryCoName = industryCoName;
	}

	public String getEntTypeCatgName() {
		return entTypeCatgName;
	}

	public void setEntTypeCatgName(String entTypeCatgName) {
		this.entTypeCatgName = entTypeCatgName;
	}

	public String getPositionName() {
		return positionName;
	}

	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}

	public String getIsOpanomaly() {
		return isOpanomaly;
	}

	public void setIsOpanomaly(String isOpanomaly) {
		this.isOpanomaly = isOpanomaly;
	}

	public String getEntTypeName() {
		return entTypeName;
	}

	public void setEntTypeName(String entTypeName) {
		this.entTypeName = entTypeName;
	}

	public void setEncerNO(String encerNO) {
		this.encerNO = encerNO;
	}

	public String getEncerNO() {
		return encerNO;
	}

	public void setEnleRep(String enleRep) {
		this.enleRep = enleRep;
	}

	public String getEnleRep() {
		return enleRep;
	}

	public Date getPunishDate() {
		return punishDate;
	}

	public void setPunishDate(Date punishDate) {
		this.punishDate = punishDate;
	}

	public String getExeAffSign() {
		return exeAffSign;
	}

	public void setExeAffSign(String exeAffSign) {
		this.exeAffSign = exeAffSign;
	}

	public String getInv() {
		return inv;
	}

	public void setInv(String inv) {
		this.inv = inv;
	}

	public String getPriPIDDesc(){
		if(StringUtils.isNotEmpty(getPriPID())){
			return AESEUtil.encodeCorpid(getPriPID());
		}
		return "";
	}

	public String getIsSimpleCancle() {
		return isSimpleCancle;
	}

	public void setIsSimpleCancle(String isSimpleCancle) {
		this.isSimpleCancle = isSimpleCancle;
	}

	public String getLimitName() {
		return limitName;
	}

	public void setLimitName(String limitName) {
		this.limitName = limitName;
	}
	
	public void setYear(Integer year) {
		this.year = year;
	}
	public Integer getYear() {
		return year;
	}
	
	public void setBatchEntType(String batchEntType) {
		this.batchEntType = batchEntType;
	}
	public String getBatchEntType() {
		return batchEntType;
	}

	public String getBasxCN() {
		return basxCN;
	}

	public void setBasxCN(String basxCN) {
		this.basxCN = basxCN;
	}

	public String getRegStateDesc() {
		return regStateDesc;
	}

	public void setRegStateDesc(String regStateDesc) {
		this.regStateDesc = regStateDesc;
	}

	public String getHisEntName() {
		return hisEntName;
	}

	public void setHisEntName(String hisEntName) {
		this.hisEntName = hisEntName;
	}
}