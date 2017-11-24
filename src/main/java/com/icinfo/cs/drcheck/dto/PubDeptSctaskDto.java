/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.drcheck.dto;

import java.util.Date;
import java.util.List;

import com.icinfo.cs.drcheck.model.PubDeptSctask;
import com.icinfo.cs.drcheck.model.PubScdispose;
import com.icinfo.cs.drcheck.model.PubScitemResult;
import com.icinfo.cs.drcheck.model.PubScresult;
import com.icinfo.cs.drcheck.model.PubScresultOpinionHis;

/**
 * 描述:  cs_pub_dept_sctask 对应的DTO类.<br>
 *
 * @author framework generator
 * @date 2016年10月25日
 */
public class PubDeptSctaskDto extends PubDeptSctask {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8357064679684970306L;
	
	//检查项结果
	private List<PubScitemResult> pubScitemResultList;
	//历次审核意见
	private List<PubScresultOpinionHis> pubScresultOpinionHiList;
	//检查结果信息id
	private Integer resultId;
	//检查结果信息UID
	private String resultUID;
	//检查结果详情
	private String scDetail;
	//检查结果项
	private String scResult;
	//设置人id
	private String setUserId;
	//设置人用户名
	private String setUserName;
	//设置时间
	private Date setTime;
	//其他说明情况
	private String remark;
	//是否已填写
	private String resultFlag;
	
	//后续处置信息id
	private Integer disposeId;
	//后续处置信息UID
	private String disposeUID;
	//后续处置详情
	private String disposeDetail;
	//后续处置结果项
	private String disposeResult;
	//审核人
	private String auditName;
	//审核日期
	private Date auditDate;
	//审核意见
	private String auditOpin;
	//审核状态
	private String auditState;
	//检查科目编码以逗号隔开
	private String scTypes;
	//检查科目以逗号隔开
	private String scNames;
	//检查结果
	private PubScresult pubScresult;
	//后续处置
	private PubScdispose pubScdispose;
	//检察人员
	private String agentNames;
	//检查日期
	private String inspectDateDesc;
	

	public List<PubScitemResult> getPubScitemResultList() {
		return pubScitemResultList;
	}

	public void setPubScitemResultList(List<PubScitemResult> pubScitemResultList) {
		this.pubScitemResultList = pubScitemResultList;
	}

	public Integer getResultId() {
		return resultId;
	}

	public void setResultId(Integer resultId) {
		this.resultId = resultId;
	}

	public String getResultUID() {
		return resultUID;
	}

	public void setResultUID(String resultUID) {
		this.resultUID = resultUID;
	}

	public String getScDetail() {
		return scDetail;
	}

	public void setScDetail(String scDetail) {
		this.scDetail = scDetail;
	}

	public String getScResult() {
		return scResult;
	}

	public void setScResult(String scResult) {
		this.scResult = scResult;
	}

	public Integer getDisposeId() {
		return disposeId;
	}

	public void setDisposeId(Integer disposeId) {
		this.disposeId = disposeId;
	}

	public String getDisposeUID() {
		return disposeUID;
	}

	public void setDisposeUID(String disposeUID) {
		this.disposeUID = disposeUID;
	}

	public String getDisposeDetail() {
		return disposeDetail;
	}

	public void setDisposeDetail(String disposeDetail) {
		this.disposeDetail = disposeDetail;
	}

	public String getDisposeResult() {
		return disposeResult;
	}

	public void setDisposeResult(String disposeResult) {
		this.disposeResult = disposeResult;
	}

	public String getSetUserId() {
		return setUserId;
	}

	public void setSetUserId(String setUserId) {
		this.setUserId = setUserId;
	}

	public String getSetUserName() {
		return setUserName;
	}

	public void setSetUserName(String setUserName) {
		this.setUserName = setUserName;
	}

	public Date getSetTime() {
		return setTime;
	}

	public void setSetTime(Date setTime) {
		this.setTime = setTime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getResultFlag() {
		return resultFlag;
	}

	public void setResultFlag(String resultFlag) {
		this.resultFlag = resultFlag;
	}

	public String getAuditName() {
		return auditName;
	}

	public void setAuditName(String auditName) {
		this.auditName = auditName;
	}

	public Date getAuditDate() {
		return auditDate;
	}

	public void setAuditDate(Date auditDate) {
		this.auditDate = auditDate;
	}

	public String getAuditOpin() {
		return auditOpin;
	}

	public void setAuditOpin(String auditOpin) {
		this.auditOpin = auditOpin;
	}

	public String getAuditState() {
		return auditState;
	}

	public void setAuditState(String auditState) {
		this.auditState = auditState;
	}

	public String getScNames() {
		return scNames;
	}

	public void setScNames(String scNames) {
		this.scNames = scNames;
	}

	public String getScTypes() {
		return scTypes;
	}

	public void setScTypes(String scTypes) {
		this.scTypes = scTypes;
	}

	public PubScresult getPubScresult() {
		return pubScresult;
	}

	public void setPubScresult(PubScresult pubScresult) {
		this.pubScresult = pubScresult;
	}

	public PubScdispose getPubScdispose() {
		return pubScdispose;
	}

	public void setPubScdispose(PubScdispose pubScdispose) {
		this.pubScdispose = pubScdispose;
	}

	public String getAgentNames() {
		return agentNames;
	}

	public void setAgentNames(String agentNames) {
		this.agentNames = agentNames;
	}

	public String getInspectDateDesc() {
		return inspectDateDesc;
	}

	public void setInspectDateDesc(String inspectDateDesc) {
		this.inspectDateDesc = inspectDateDesc;
	}

	public List<PubScresultOpinionHis> getPubScresultOpinionHiList() {
		return pubScresultOpinionHiList;
	}

	public void setPubScresultOpinionHiList(List<PubScresultOpinionHis> pubScresultOpinionHiList) {
		this.pubScresultOpinionHiList = pubScresultOpinionHiList;
	}

	
}