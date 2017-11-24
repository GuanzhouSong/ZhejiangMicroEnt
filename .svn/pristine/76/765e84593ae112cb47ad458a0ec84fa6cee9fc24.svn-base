/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.dto;

import java.util.Date;
import java.util.List;

import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.yr.model.PubOtherPunishAlter;
import com.icinfo.cs.yr.model.PubOtherpunish;

/**
 * 描述:    cs_pub_otherpunish 对应的DTO类.<br>
 *
 * @author framework generator
 * @date 2016年10月17日
 */
public class PubOtherpunishDto extends PubOtherpunish {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//登记机关描述
	private String regOrgDesc;

	//管辖单位描述
	private String localAdmName;
	
	//企业类型描述
	private String entTypeCatgDesc;
	
	//责任区描述
	private String sliceNOName;
	
	//是否含有变更信息
	private String punIsAlter;
	
	//行政处罚来源
	private String punSource;
	
	//登记状态
	private String regState;
	
	//住所
	private String dom;
	
	//法定代表人
	private String leRep;
	
	//来源：其它部门 查询家数
	private int total;
	
    //来源：其它部门 查询条数
	private int amount;
	
	//来源：企业  查询家数
	private int imTotal;
	
    //来源：企业  查询条数
	private int imAmount;
	
	//来源：工商  查询家数
	private int midTotal;
	
    //来源：工商  查询条数
	private int midAmount;
	
	//变更列表
	private List<PubOtherPunishAlter> pubOtherPunishAlterList;
	
	//行政处罚决定书
	private String punDecDoc;
	
	public String getRegOrgDesc() {
		return regOrgDesc;
	}

	public void setRegOrgDesc(String regOrgDesc) {
		this.regOrgDesc = regOrgDesc;
	}

	public String getEntTypeCatgDesc() {
		return entTypeCatgDesc;
	}

	public void setEntTypeCatgDesc(String entTypeCatgDesc) {
		this.entTypeCatgDesc = entTypeCatgDesc;
	}

	public String getPunIsAlter() {
		return punIsAlter;
	}

	public void setPunIsAlter(String punIsAlter) {
		this.punIsAlter = punIsAlter;
	}

	public String getLocalAdmName() {
		return localAdmName;
	}

	public void setLocalAdmName(String localAdmName) {
		this.localAdmName = localAdmName;
	}

	public String getPunSource() {
		return punSource;
	}

	public void setPunSource(String punSource) {
		this.punSource = punSource;
	}

	public String getRegState() {
		return regState;
	}

	public void setRegState(String regState) {
		this.regState = regState;
	}

	public String getDom() {
		return dom;
	}

	public void setDom(String dom) {
		this.dom = dom;
	}

	public String getLeRep() {
		return leRep;
	}

	public void setLeRep(String leRep) {
		this.leRep = leRep;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getSliceNOName() {
		return sliceNOName;
	}

	public void setSliceNOName(String sliceNOName) {
		this.sliceNOName = sliceNOName;
	}

	public List<PubOtherPunishAlter> getPubOtherPunishAlterList() {
		return pubOtherPunishAlterList;
	}

	public void setPubOtherPunishAlterList(
			List<PubOtherPunishAlter> pubOtherPunishAlterList) {
		this.pubOtherPunishAlterList = pubOtherPunishAlterList;
	}

	public String getPunDecDoc() {
		return punDecDoc;
	}

	public void setPunDecDoc(String punDecDoc) {
		this.punDecDoc = punDecDoc;
	}

	public int getImTotal() {
		return imTotal;
	}

	public void setImTotal(int imTotal) {
		this.imTotal = imTotal;
	}
     
	public int getImAmount() {
		return imAmount;
	}

	public void setImAmount(int imAmount) {
		this.imAmount = imAmount;
	}

	public int getMidTotal() {
		return midTotal;
	}

	public void setMidTotal(int midTotal) {
		this.midTotal = midTotal;
	}

	public int getMidAmount() {
		return midAmount;
	}

	public void setMidAmount(int midAmount) {
		this.midAmount = midAmount;
	}
	
	   /**
     * 获取处罚决定日期
     *
     * @return PenDecIssDate - 处罚决定日期
     */
    public String getPenDecIssDateDesc() {
    	if(super.getPenDecIssDate() == null) return "";
    	try {
			return DateUtil.dateToString(super.getPenDecIssDate(),"yyyy年MM月dd日");
		} catch (Exception e) {
			return "";
		}
    }
    

    /**
     * 获取审核日期
     *
     * @return AuditDate - 审核日期
     */
    public String getAuditDateDesc() {
    	if(super.getAuditDate() == null) return "";
    	try {
			return DateUtil.dateToString(super.getAuditDate(),"yyyy年MM月dd日");
		} catch (Exception e) {
			return "";
		}
    }


}   