package com.icinfo.cs.nocreditPunish.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * cs_nocredit_punishback 对应实体类
 * @author caoxu
 * @date 2016年10月18日
 */
@Table(name = "cs_nocredit_punishback")
public class NoCreditPunishBack implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6860959614279625771L;
	
	@Id
	@Column(name = "id")
	private Integer id;
	
	/**
     * 批次号
     */
	@Column(name = "BatchNo")
	private String batchNo;
	
	/**
	 * 反馈日期
	 */
	@Column(name = "CreateTime")
	private Date createTime;
	
	/**
     * 反馈部门编号
     */
	@Column(name = "BackDeptCode")
	private String backDeptCode;
	
	/**
     * 反馈部门
     */
	@Column(name = "BackDept")
	private String backDept;
	
	/**
     * 反馈人姓名
     */
	@Column(name = "OpName")
	private String opName;
	
	/**
     * 反馈人内容
     */
	@Column(name = "BackContent")
	private String backContent;
	
	/**
	 * 部门反馈状态（0，未反馈；1，已反馈）
	 */
	@Column(name = "State")
	private Integer state;
	
	/**
	 * 是否需要反馈
	 */
	@Column(name = "FeedBack")
	private String feedBack;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBatchNo() {
		return batchNo;
	}

	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getBackDeptCode() {
		return backDeptCode;
	}

	public void setBackDeptCode(String backDeptCode) {
		this.backDeptCode = backDeptCode;
	}

	public String getBackDept() {
		return backDept;
	}

	public void setBackDept(String backDept) {
		this.backDept = backDept;
	}

	public String getOpName() {
		return opName;
	}

	public void setOpName(String opName) {
		this.opName = opName;
	}

	public String getBackContent() {
		return backContent;
	}

	public void setBackContent(String backContent) {
		this.backContent = backContent;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getFeedBack() {
		return feedBack;
	}

	public void setFeedBack(String feedBack) {
		this.feedBack = feedBack;
	}

}
