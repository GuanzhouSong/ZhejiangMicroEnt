/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.opanomaly.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.opanomaly.model.PubOpanoMaly;

/**
 * 描述:    cs_pub_opanomaly 对应的DTO类.<br>
 *
 * @author framework generator
 * @date 2016年10月11日
 */
@SuppressWarnings("serial")
public class PubOpanoMalyDto extends PubOpanoMaly {
	//登记机关名称
	private String regOrgName;
	//管辖单位名称
	private String localAdmName;
	//登记状态
	private String regState;
	
	//住所地
	private String dom;
	//审核日期
	private String auditDateDesc; 
	//审核日期
	private String penDecNoDetail; 
	// 移出、撤销标识    1移出 2撤销
	private String isMove;
	//移出决定书文号
	private String  canOutPenDecNo;
	//移出、撤销原因中文名称
    private String remExcpresCN;
    //移出、撤销日期
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date remDate;
    // 移出、撤销决定机关中文名称
    private String reDecOrgCN; 
    //责任区名称
    private String sliceNOName; 
    //抽检机关名称
    private String checkDepName; 
    //移出/撤销事实和事由
    private String removeRea;
    
    //列入列出标志
    private String pubState;
	//下载标志
	private String downState;
	// 简易注销标志
	private String isErEscApp;
	// 主体类型标志(1-企业 2-个体)
	private String entCatgFlag;
	
	private String deptName;
	
    //全景个数统计
	private String countAll;
	private String disCountAllTotal;
	private String totalType;
	
	//批量列入初始数量
	private Long initBatchNum;
	//批量列入时后期更正撤销数量
	private Long batchRemoveNum;
	//批量列入现有实际有效列入数量
	private Long batchNum;
	
	//批列入
	private String isIndivid;
	private Date estDateStart;
	private Date estDateEnd;
	private String operate;
    
	public String getSliceNOName() {
		return sliceNOName;
	}
	public void setSliceNOName(String sliceNOName) {
		this.sliceNOName = sliceNOName;
	}
	public String getIsMove() {
		return isMove;
	}
	public void setIsMove(String isMove) {
		this.isMove = isMove;
	}
	public String getCanOutPenDecNo() {
		return canOutPenDecNo;
	}
	public void setCanOutPenDecNo(String canOutPenDecNo) {
		this.canOutPenDecNo = canOutPenDecNo;
	}
	public String getRemExcpresCN() {
		return remExcpresCN;
	}
	public void setRemExcpresCN(String remExcpresCN) {
		this.remExcpresCN = remExcpresCN;
	}
	public Date getRemDate() {
		return remDate;
	}
	public void setRemDate(Date remDate) {
		this.remDate = remDate;
	}
	public String getReDecOrgCN() {
		return reDecOrgCN;
	}
	public void setReDecOrgCN(String reDecOrgCN) {
		this.reDecOrgCN = reDecOrgCN;
	}
	public void setAuditDateDesc(String auditDateDesc) {
		this.auditDateDesc = auditDateDesc;
	}
	public String getRegOrgName() {
		return regOrgName;
	}
	public void setRegOrgName(String regOrgName) {
		this.regOrgName = regOrgName;
	}
	public String getLocalAdmName() {
		return localAdmName;
	}
	public void setLocalAdmName(String localAdmName) {
		this.localAdmName = localAdmName;
	} 
	public String getDom() {
		return dom;
	}
	public void setDom(String dom) {
		this.dom = dom;
	}
	public String getAuditDateDesc() {
		return auditDateDesc;
	}
	public void setAuditDateDesc(Date auditDateDesc) {
		this.auditDateDesc = DateUtil.formatDate(auditDateDesc);
	}
	public String getPenDecNoDetail() {
		return penDecNoDetail;
	}
	public void setPenDecNoDetail(String penDecNoDetail) {
		this.penDecNoDetail = penDecNoDetail;
	}
	 
	public String getCheckDepName() {
		return checkDepName;
	}
	public void setCheckDepName(String checkDepName) {
		this.checkDepName = checkDepName;
	}
	public String getRemoveRea() {
		return removeRea;
	}
	public void setRemoveRea(String removeRea) {
		this.removeRea = removeRea;
	}
	public String getPubState() {
		return pubState;
	}
	public void setPubState(String pubState) {
		this.pubState = pubState;
	}

	public String getDownState() {
		return downState;
	}

	public void setDownState(String downState) {
		this.downState = downState;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getRemDateFom(){
    	try {
			return DateUtil.dateToString(this.remDate, "yyyy年MM月dd日");
		} catch (Exception e) {
			return "";
		}
    }
	public String getRegState() {
		return regState;
	}
	public void setRegState(String regState) {
		this.regState = regState;
	}
	public String getIsErEscApp() {
		return isErEscApp;
	}
	public void setIsErEscApp(String isErEscApp) {
		this.isErEscApp = isErEscApp;
	}
	public String getEntCatgFlag() {
		return entCatgFlag;
	}
	public void setEntCatgFlag(String entCatgFlag) {
		this.entCatgFlag = entCatgFlag;
	}
	public String getCountAll() {
		return countAll;
	}
	public void setCountAll(String countAll) {
		this.countAll = countAll;
	}
	public String getDisCountAllTotal() {
		return disCountAllTotal;
	}
	public void setDisCountAllTotal(String disCountAllTotal) {
		this.disCountAllTotal = disCountAllTotal;
	}
	public String getTotalType() {
		return totalType;
	}
	public void setTotalType(String totalType) {
		this.totalType = totalType;
	}
	
	public Long getInitBatchNum() {
		return initBatchNum;
	}
	public void setInitBatchNum(Long initBatchNum) {
		this.initBatchNum = initBatchNum;
	}
	public Long getBatchRemoveNum() {
		return batchRemoveNum;
	}
	public void setBatchRemoveNum(Long batchRemoveNum) {
		this.batchRemoveNum = batchRemoveNum;
	}
	public Long getBatchNum() {
		return batchNum;
	}
	public void setBatchNum(Long batchNum) {
		this.batchNum = batchNum;
	}
	public String getIsIndivid() {
		return isIndivid;
	}
	public void setIsIndivid(String isIndivid) {
		this.isIndivid = isIndivid;
	}
	public Date getEstDateStart() {
		return estDateStart;
	}
	public void setEstDateStart(Date estDateStart) {
		this.estDateStart = estDateStart;
	}
	public Date getEstDateEnd() {
		return estDateEnd;
	}
	public void setEstDateEnd(Date estDateEnd) {
		this.estDateEnd = estDateEnd;
	}

}