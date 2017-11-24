
package com.icinfo.cs.common.constant;


/** 
 * 描述: 年报状态枚举类
 * @author ZhouYan
 * @date 2016年9月11日  
 */
public enum ReportStatusEnum {
	
	/*
	 * 年度年报状态：
	 * a.未年报：首次成功提交年报前
	 * b.已年报：首次提交年报在6月30日前且当前年报未涉及敏感词审核不通过情况
	 * c.已年报（逾期）：首次提交年报在6月30日后
	 */
	IsReportedNo("0","未年报","未年报"),
	IsReportedYes("1","已年报","已年报"), 
	IsReportedOverdue("2","已年报（逾期）","已年报（逾期）"),
	
	/*
	 * 年报公示状态（当前年报状态）：
	 * a.未公示：年报未提交前
	 * b.已公示：年报提交后，不涉及敏感词审核
	 * c.敏感词通过：年报提交后，涉及敏感词审核
	 * d.敏感词待审核：年报提交后，敏感词审核不通过
	 * e.敏感词不通过：年报提交后，敏感词审核通过
	 * f.待修改：6月30日前企业点击修改后、6月30日后修改申请审核通过后变为待修改状态；
	 */
	ReportStateNo("00", "未公示", "未公示"), //原91未提交
	ReportStateYes("10", "已公示", "已公示"), //原1已公示
	ReportStateForbidYes("11", "已公示", "敏感词通过"), //原1已公示
	ReportStateForbidAuditing("12", "已公示（内容待审核）", "敏感词待审核"), //原81待审核
	ReportStateForbidFail("13", "已公示（内容审核不通过）", "敏感词不通过"), //原80敏感词审核不通过
	ReportStateModify("20", "待修改", "待修改"); //原83待修改

	//状态编码
	private String statusCode;
	//企业端名称
	private String statusClientDesc;
	//工商端名称
	private String statusServerDesc;
	
	private ReportStatusEnum(String statusCode, String statusClientDesc, String statusServerDesc)	{
		this.statusCode = statusCode;
		this.statusClientDesc = statusClientDesc;
		this.statusServerDesc = statusServerDesc;
	}
	
	public static ReportStatusEnum getValue(String statusCode) {
		for (ReportStatusEnum reportStatusEnum : ReportStatusEnum.values()) {
			if (statusCode.equals(reportStatusEnum.statusCode)) {
				return reportStatusEnum;
			}
		}
		return null;
	}

	public String getStatusCode() {
		return statusCode;
	}
	
	public String getStatusClientDesc() {
		return statusClientDesc;
	}
	
	public String getStatusServerDesc() {
		return statusServerDesc;
	}
	
}
