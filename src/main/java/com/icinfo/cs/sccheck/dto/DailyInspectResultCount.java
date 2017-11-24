/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.sccheck.dto;

public class DailyInspectResultCount {
	private int notInputNum;// 未录入
	private int alreadyInputNum;// 已录入
	private int notOverNum;// 未完结
	private int alreadyOverNum;// 已完结

	public int getNotInputNum() {
		return notInputNum;
	}

	public void setNotInputNum(int notInputNum) {
		this.notInputNum = notInputNum;
	}

	public int getAlreadyInputNum() {
		return alreadyInputNum;
	}

	public void setAlreadyInputNum(int alreadyInputNum) {
		this.alreadyInputNum = alreadyInputNum;
	}

	public int getNotOverNum() {
		return notOverNum;
	}

	public void setNotOverNum(int notOverNum) {
		this.notOverNum = notOverNum;
	}

	public int getAlreadyOverNum() {
		return alreadyOverNum;
	}

	public void setAlreadyOverNum(int alreadyOverNum) {
		this.alreadyOverNum = alreadyOverNum;
	}

}