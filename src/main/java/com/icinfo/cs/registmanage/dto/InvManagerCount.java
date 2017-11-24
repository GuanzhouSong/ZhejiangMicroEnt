/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.registmanage.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class InvManagerCount {
	private int entNum;// 企业数
	private int zeroInvNum;// 零出资数
	private int partInvNum;// 部分出资数
	private int allInvNum;// 全额出资数
	private int partInvExpireNum;// 未全额出资企业中将到期数
	private int alreadyExpireNum;// 已到期数
	
	private Integer year;
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date ycdate;

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Date getYcdate() {
		return ycdate;
	}

	public void setYcdate(Date ycdate) {
		this.ycdate = ycdate;
	}

	public int getEntNum() {
		return entNum;
	}

	public void setEntNum(int entNum) {
		this.entNum = entNum;
	}

	public int getZeroInvNum() {
		return zeroInvNum;
	}

	public void setZeroInvNum(int zeroInvNum) {
		this.zeroInvNum = zeroInvNum;
	}

	public int getPartInvNum() {
		return partInvNum;
	}

	public void setPartInvNum(int partInvNum) {
		this.partInvNum = partInvNum;
	}

	public int getAllInvNum() {
		return allInvNum;
	}

	public void setAllInvNum(int allInvNum) {
		this.allInvNum = allInvNum;
	}

	public int getPartInvExpireNum() {
		return partInvExpireNum;
	}

	public void setPartInvExpireNum(int partInvExpireNum) {
		this.partInvExpireNum = partInvExpireNum;
	}

	public int getAlreadyExpireNum() {
		return alreadyExpireNum;
	}

	public void setAlreadyExpireNum(int alreadyExpireNum) {
		this.alreadyExpireNum = alreadyExpireNum;
	}

}