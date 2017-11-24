package com.icinfo.cs.es.dto;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.icinfo.cs.common.utils.AESEUtil;
import com.icinfo.cs.es.model.PanoramaSearch;

/**
 * 全景查询参数组装DTO
 * 
 * @author zhuyong
 */
public class PanoramaSearchDto extends PanoramaSearch {
	
	private static final long serialVersionUID = 2577357480341234286L;
	
	private String _id;
	
	/**	 * 核准日期开始	 */
	private String apprDateStart;
	/**	 * 核准日期结束	 */
	private String apprDateEnd;
	
	/**	 * 成立日期开始	 */
	private String estDateStart;
	/**	 * 成立日期结束	 */
	private String estDateEnd;
	
	/** 注册资本开始*/
	private double regCapStart;
	/** 注册资本结束*/
	private double regCapEnd;
	/** 年报年度 */
	private String yrYear;
	
	/**最近报送时间*/
	private String yrRecRepTimeStart;
	/**最近报送时间*/
	private String yrRecRepTimeEnd;
	
	/**首次报送时间*/
	private String yrFirRepTimeStart;
	/**首次报送时间*/
	private String yrFirRepTimeEnd;
	
	
	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getPriPIDDesc() {
		return AESEUtil.encodeCorpid(super.getPriPID());
	}
	
	public String getApprDateStart() {
		return apprDateStart;
	}

	public void setApprDateStart(String apprDateStart) {
		this.apprDateStart = apprDateStart;
	}

	public String getApprDateEnd() {
		return apprDateEnd;
	}

	public void setApprDateEnd(String apprDateEnd) {
		this.apprDateEnd = apprDateEnd;
	}

	public String getEstDateStart() {
		return estDateStart;
	}

	public void setEstDateStart(String estDateStart) {
		this.estDateStart = estDateStart;
	}

	public String getEstDateEnd() {
		return estDateEnd;
	}

	public void setEstDateEnd(String estDateEnd) {
		this.estDateEnd = estDateEnd;
	}
	

	public double getRegCapStart() {
		return regCapStart;
	}

	public void setRegCapStart(double regCapStart) {
		this.regCapStart = regCapStart;
	}

	public double getRegCapEnd() {
		return regCapEnd;
	}

	public void setRegCapEnd(double regCapEnd) {
		this.regCapEnd = regCapEnd;
	}

	public String getYrYear() {
		return yrYear;
	}

	public void setYrYear(String yrYear) {
		this.yrYear = yrYear;
	}
	

	public String getYrRecRepTimeStart() {
		return yrRecRepTimeStart;
	}

	public void setYrRecRepTimeStart(String yrRecRepTimeStart) {
		this.yrRecRepTimeStart = yrRecRepTimeStart;
	}

	public String getYrRecRepTimeEnd() {
		return yrRecRepTimeEnd;
	}

	public void setYrRecRepTimeEnd(String yrRecRepTimeEnd) {
		this.yrRecRepTimeEnd = yrRecRepTimeEnd;
	}
	

	public String getYrFirRepTimeStart() {
		return yrFirRepTimeStart;
	}

	public void setYrFirRepTimeStart(String yrFirRepTimeStart) {
		this.yrFirRepTimeStart = yrFirRepTimeStart;
	}

	public String getYrFirRepTimeEnd() {
		return yrFirRepTimeEnd;
	}

	public void setYrFirRepTimeEnd(String yrFirRepTimeEnd) {
		this.yrFirRepTimeEnd = yrFirRepTimeEnd;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	
	
	
}
