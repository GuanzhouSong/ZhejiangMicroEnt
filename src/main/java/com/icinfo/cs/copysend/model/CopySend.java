/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.copysend.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.icinfo.framework.mybatis.mapper.annotation.Before;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * 描述:    cs_copy_send 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2016年10月21日
 */
@Table(name = "cs_copy_send")
public class CopySend implements Serializable {
    /**
     * 主键ID
     */
    @Id
    @Column(name = "id")
    private Integer id;

    /**
     * UID
     */
    @Column(name = "UID")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    private String uid;

    /**
     * 抄告单编号
     */
    @Column(name = "CopyFormNo")
    private String copyFormNo;
    
    /**
     * 年度
     */
    @Column(name = "Year")
    private Integer year;
    
    /**
     * 抄告单序号
     */
    @Column(name = "CopyNo")
    private Integer copyNo;

    /**
     * 抄告发起部门编码
     */
    @Column(name = "CopyDepartCode")
    private String copyDepartCode;
    
    /**
     * 抄告发起部门名称
     */
    @Column(name = "CopyDepartName")
    private String copyDepartName;
    
    /**
     * 抄告接收部门编码串
     */
    @Column(name = "AcceptDeptCodes")
    private String acceptDeptCodes;
    
    /**
     * 抄告接收部门列表
     */
    @Column(name = "AcceptDeptNames")
    private String acceptDeptNames;

    /**
     * 抄告类型
     */
    @Column(name = "CopyType")
    private String copyType;

    /**
     * 抄告状态
     */
    @Column(name = "CopyState")
    private String copyState;

    /**
     * 涉嫌违法事项
     */
    @Column(name = "IllegalItem")
    private String illegalItem;

    /**
     * 抄告信息来源
     */
    @Column(name = "CopyInfoFrom")
    private String copyInfoFrom;

    /**
     * 是否需要反馈0:是1:否
     */
    @Column(name = "FeedbackNeed")
    private Integer feedbackNeed;

    /**
     * 具体违法情况
     */
    @Column(name = "IllegalCase")
    private String illegalCase;

    /**
     * 证据资料
     */
    @Column(name = "EvidenceData")
    private String evidenceData;

    /**
     * 抄告发起日期
     */
    @Column(name = "CopyDate")
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date copyDate;

    /**
     * 抄告最新处理日期
     */
    @Column(name = "CopyOptDate")
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date copyOptDate;

    /**
     * 抄告发起部门联系人
     */
    @Column(name = "CopyDepartPerson")
    private String copyDepartPerson;

    /**
     * 抄告发起部门联系电话
     */
    @Column(name = "CopyDepartTel")
    private String copyDepartTel;

    /**
     * 抄告发起部门传真
     */
    @Column(name = "CopyDepartFax")
    private String copyDepartFax;

    /**
     * 抄告发起部门邮箱
     */
    @Column(name = "CopyDepartMail")
    private String copyDepartMail;

    /**
     * 审核人
     */
    @Column(name = "CheckPerson")
    private String checkPerson;

    /**
     * 审核结果
     */
    @Column(name = "CheckResult")
    private String checkResult;

    /**
     * 审核日期
     */
    @Column(name = "CheckDate")
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date checkDate;

    /**
     * 审核意见
     */
    @Column(name = "CheckOpinion")
    private String checkOpinion;

    /**
     * 创建时间
     */
    @Column(name = "CreateTime")
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date createTime;

    private static final long serialVersionUID = 1L;

    /**
     * 获取主键ID
     *
     * @return id - 主键ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置主键ID
     *
     * @param id 主键ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取UID
     *
     * @return UID - UID
     */
    public String getUid() {
		return uid;
	}
    /**
     * 设置UID
     *
     * @param UID UID
     */
	public void setUid(String uid) {
		this.uid = uid;
	}
	
    /**
     * 获取抄告单编号
     *
     * @return CopyFormNo - 抄告单编号
     */
    public String getCopyFormNo() {
        return copyFormNo;
    }


	/**
     * 设置抄告单编号
     *
     * @param copyFormNo 抄告单编号
     */
    public void setCopyFormNo(String copyFormNo) {
        this.copyFormNo = copyFormNo;
    }

    /**
     * 获取抄告发起部门
     *
     * @return CopyDepart - 抄告发起部门
     */
    public String getCopyDepartCode() {
        return copyDepartCode;
    }

    /**
     * 设置抄告发起部门
     *
     * @param copyDepart 抄告发起部门
     */
    public void setCopyDepartCode(String copyDepartCode) {
        this.copyDepartCode = copyDepartCode;
    }

    /**
     * 获取抄告类型
     *
     * @return CopyType - 抄告类型
     */
    public String getCopyType() {
        return copyType;
    }

    /**
     * 设置抄告类型
     *
     * @param copyType 抄告类型
     */
    public void setCopyType(String copyType) {
        this.copyType = copyType;
    }

    /**
     * 获取抄告状态
     *
     * @return CcopyState - 抄告状态
     */
    public String getCopyState() {
        return copyState;
    }

    /**
     * 设置抄告状态
     *
     * @param ccopyState 抄告状态
     */
    public void setCopyState(String copyState) {
        this.copyState = copyState;
    }

    /**
     * 获取涉嫌违法事项
     *
     * @return IllegalItem - 涉嫌违法事项
     */
    public String getIllegalItem() {
        return illegalItem;
    }

    /**
     * 设置涉嫌违法事项
     *
     * @param illegalItem 涉嫌违法事项
     */
    public void setIllegalItem(String illegalItem) {
        this.illegalItem = illegalItem;
    }

    /**
     * 获取抄告信息来源
     *
     * @return CopyInfoFrom - 抄告信息来源
     */
    public String getCopyInfoFrom() {
        return copyInfoFrom;
    }

    /**
     * 设置抄告信息来源
     *
     * @param copyInfoFrom 抄告信息来源
     */
    public void setCopyInfoFrom(String copyInfoFrom) {
        this.copyInfoFrom = copyInfoFrom;
    }

    /**
     * 获取是否需要反馈0:是1:否
     *
     * @return FeedbackNeed - 是否需要反馈0:是1:否
     */
    public Integer getFeedbackNeed() {
        return feedbackNeed;
    }

    /**
     * 设置是否需要反馈0:是1:否
     *
     * @param feedbackNeed 是否需要反馈0:是1:否
     */
    public void setFeedbackNeed(Integer feedbackNeed) {
        this.feedbackNeed = feedbackNeed;
    }

    /**
     * 获取
具体违法情况
     *
     * @return IllegalCase - 
具体违法情况
     */
    public String getIllegalCase() {
        return illegalCase;
    }

    /**
     * 设置
具体违法情况
     *
     * @param illegalCase 
具体违法情况
     */
    public void setIllegalCase(String illegalCase) {
        this.illegalCase = illegalCase;
    }

    /**
     * 获取证据资料
     *
     * @return EvidenceData - 证据资料
     */
    public String getEvidenceData() {
        return evidenceData;
    }

    /**
     * 设置证据资料
     *
     * @param evidenceData 证据资料
     */
    public void setEvidenceData(String evidenceData) {
        this.evidenceData = evidenceData;
    }

    /**
     * 获取抄告发起日期
     *
     * @return CopyDate - 抄告发起日期
     */
    public Date getCopyDate() {
        return copyDate;
    }

    /**
     * 设置抄告发起日期
     *
     * @param copyDate 抄告发起日期
     */
    public void setCopyDate(Date copyDate) {
        this.copyDate = copyDate;
    }

    /**
     * 获取抄告最新处理日期
     *
     * @return CopyOptDate - 抄告最新处理日期
     */
    public Date getCopyOptDate() {
        return copyOptDate;
    }

    /**
     * 设置抄告最新处理日期
     *
     * @param copyOptDate 抄告最新处理日期
     */
    public void setCopyOptDate(Date copyOptDate) {
        this.copyOptDate = copyOptDate;
    }

    /**
     * 获取抄告发起部门联系人
     *
     * @return CopyDepartPerson - 抄告发起部门联系人
     */
    public String getCopyDepartPerson() {
        return copyDepartPerson;
    }

    /**
     * 设置抄告发起部门联系人
     *
     * @param copyDepartPerson 抄告发起部门联系人
     */
    public void setCopyDepartPerson(String copyDepartPerson) {
        this.copyDepartPerson = copyDepartPerson;
    }

    /**
     * 获取抄告发起部门联系电话
     *
     * @return CopyDepartTel - 抄告发起部门联系电话
     */
    public String getCopyDepartTel() {
        return copyDepartTel;
    }

    /**
     * 设置抄告发起部门联系电话
     *
     * @param copyDepartTel 抄告发起部门联系电话
     */
    public void setCopyDepartTel(String copyDepartTel) {
        this.copyDepartTel = copyDepartTel;
    }

    /**
     * 获取抄告发起部门传真
     *
     * @return CopyDepartFax - 抄告发起部门传真
     */
    public String getCopyDepartFax() {
        return copyDepartFax;
    }

    /**
     * 设置抄告发起部门传真
     *
     * @param copyDepartFax 抄告发起部门传真
     */
    public void setCopyDepartFax(String copyDepartFax) {
        this.copyDepartFax = copyDepartFax;
    }

    /**
     * 获取抄告发起部门邮箱
     *
     * @return CopyDepartMail - 抄告发起部门邮箱
     */
    public String getCopyDepartMail() {
        return copyDepartMail;
    }

    /**
     * 设置抄告发起部门邮箱
     *
     * @param copyDepartMail 抄告发起部门邮箱
     */
    public void setCopyDepartMail(String copyDepartMail) {
        this.copyDepartMail = copyDepartMail;
    }

    /**
     * 获取审核人
     *
     * @return CheckPerson - 审核人
     */
    public String getCheckPerson() {
        return checkPerson;
    }

    /**
     * 设置审核人
     *
     * @param checkPerson 审核人
     */
    public void setCheckPerson(String checkPerson) {
        this.checkPerson = checkPerson;
    }

    /**
     * 获取审核结果
     *
     * @return CheckResult - 审核结果
     */
    public String getCheckResult() {
        return checkResult;
    }

    /**
     * 设置审核结果
     *
     * @param checkResult 审核结果
     */
    public void setCheckResult(String checkResult) {
        this.checkResult = checkResult;
    }

    /**
     * 获取审核日期
     *
     * @return CheckDate - 审核日期
     */
    public Date getCheckDate() {
        return checkDate;
    }

    /**
     * 设置审核日期
     *
     * @param checkDate 审核日期
     */
    public void setCheckDate(Date checkDate) {
        this.checkDate = checkDate;
    }

    /**
     * 获取审核意见
     *
     * @return CheckOpinion - 审核意见
     */
    public String getCheckOpinion() {
        return checkOpinion;
    }

    /**
     * 设置审核意见
     *
     * @param checkOpinion 审核意见
     */
    public void setCheckOpinion(String checkOpinion) {
        this.checkOpinion = checkOpinion;
    }

    /**
     * 获取创建时间
     *
     * @return CreateTime - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

	public String getAcceptDeptCodes() {
		return acceptDeptCodes;
	}

	public void setAcceptDeptCodes(String acceptDeptCodes) {
		this.acceptDeptCodes = acceptDeptCodes;
	}

	public String getCopyDepartName() {
		return copyDepartName;
	}

	public void setCopyDepartName(String copyDepartName) {
		this.copyDepartName = copyDepartName;
	}

	public String getAcceptDeptNames() {
		return acceptDeptNames;
	}

	public void setAcceptDeptNames(String acceptDeptNames) {
		this.acceptDeptNames = acceptDeptNames;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Integer getCopyNo() {
		return copyNo;
	}

	public void setCopyNo(Integer copyNo) {
		this.copyNo = copyNo;
	}


    
}