/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.qcdz.qcdzdto;

import java.math.BigDecimal;

import com.icinfo.cs.qcdz.qcdzmodel.HzQyhznr;

/**
 * 描述:    hz_qyhznr 对应的DTO类.<br>
 *
 * @author framework generator
 * @date 2017年09月22日
 */
public class HzQyhznrDto extends HzQyhznr {
	
	private static final long serialVersionUID = 1L;
	//部门编码
	private String areacode;
	//
	private BigDecimal dayXsnum;
	
	//图一上
	//主体总数
	private BigDecimal ztTotal;
	//前一年企业总数
	private BigDecimal preZtTotal;
	//同比增长率
	private BigDecimal yearAddRoate;
	//分类
	private String type;
	//隔分类占比
	private BigDecimal typeCount;
	//图一下
	//月份
	private String mouthcode;
	//新设
	private BigDecimal xsCount;
	//消亡
	private BigDecimal xwCount;
	
	private String invType;
	private Integer invTypeCount;
	
	//股东行业占比
	//行业编码
	private String hydm;
	//行业名称
	private String hymc;
	//股东行业数量
	private Integer indNum;
	
	//地图数据
	//新设
	private Long xsNum;
	//注销
	private Long zxNum;
	
	
	
	
	public String getAreacode() {
		return areacode;
	}
	public void setAreacode(String areacode) {
		this.areacode = areacode;
	}
	public BigDecimal getDayXsnum() {
		return dayXsnum;
	}
	public void setDayXsnum(BigDecimal dayXsnum) {
		this.dayXsnum = dayXsnum;
	}
	public BigDecimal getZtTotal() {
		return ztTotal;
	}
	public void setZtTotal(BigDecimal ztTotal) {
		this.ztTotal = ztTotal;
	}
	public BigDecimal getPreZtTotal() {
		return preZtTotal;
	}
	public void setPreZtTotal(BigDecimal preZtTotal) {
		this.preZtTotal = preZtTotal;
	}
	public void setYearAddRoate(BigDecimal yearAddRoate) {
		this.yearAddRoate = yearAddRoate;
	}
	public BigDecimal getYearAddRoate() {
		return yearAddRoate;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public BigDecimal getTypeCount() {
		return typeCount;
	}
	public void setTypeCount(BigDecimal typeCount) {
		this.typeCount = typeCount;
	}
	public String getMouthcode() {
		return mouthcode;
	}
	public void setMouthcode(String mouthcode) {
		this.mouthcode = mouthcode;
	}
	public BigDecimal getXsCount() {
		return xsCount;
	}
	public void setXsCount(BigDecimal xsCount) {
		this.xsCount = xsCount;
	}
	public BigDecimal getXwCount() {
		return xwCount;
	}
	public void setXwCount(BigDecimal xwCount) {
		this.xwCount = xwCount;
	}
	
	public void setInvType(String invType) {
		this.invType = invType;
	}
	public String getInvType() {
		return invType;
	}
	public void setInvTypeCount(Integer invTypeCount) {
		this.invTypeCount = invTypeCount;
	}
	public Integer getInvTypeCount() {
		return invTypeCount;
	}
	public String getHydm() {
		return hydm;
	}
	public void setHydm(String hydm) {
		this.hydm = hydm;
	}
	public String getHymc() {
		return hymc;
	}
	public void setHymc(String hymc) {
		this.hymc = hymc;
	}
	public Integer getIndNum() {
		return indNum;
	}
	public void setIndNum(Integer indNum) {
		this.indNum = indNum;
	}
	
	public void setXsNum(Long xsNum) {
		this.xsNum = xsNum;
	}
	public Long getXsNum() {
		return xsNum;
	}
	public void setZxNum(Long zxNum) {
		this.zxNum = zxNum;
	}
	public Long getZxNum() {
		return zxNum;
	}
	
	
	
	
	
}