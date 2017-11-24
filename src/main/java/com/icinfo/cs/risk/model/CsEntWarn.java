/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.risk.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.icinfo.framework.mybatis.mapper.annotation.Before;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * 描述:    cs_ent_warn 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2016年10月20日
 */
@Table(name = "cs_ent_warn")
public class CsEntWarn implements Serializable {
    /**
     * 主键ID
     */
    @Id
    @Column(name = "id")
    private Integer id;

    /**
     * UID
     */
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    @Column(name = "UID")
    private String UID;

    /**
     * 主体代码
     */
    @Column(name = "PriPID")
    private String priPID;

    /**
     * 审核状态
     */
    @Column(name = "CheckState")
    private String checkState;

    /**
     * 0:无效，1:有效
     */
    @Column(name = "EntWarnState")
    private String entWarnState;

    /**
     * 批次编号
     */
    @Column(name = "BatchNo")
    private String batchNo;

   
    
    /**
     * 录入人
     */
    @Column(name = "ImportPeople")
    private String importPeople;

    /**
     * 录入时间
     */
    @Column(name = "ImportDate")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date importDate;

    /**
     * 审核人
     */
    @Column(name = "CheckPeople")
    private String checkPeople;

    /**
     * 审核时间
     */
    @Column(name = "CheckDate")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date checkDate;

    /**
     * 预警编码
     */
    @Column(name = "MarkNo")
    private String markNo;

    /**
     * 创建时间
     */
    @Column(name = "CreateTime")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date createTime;

    /**
     * 录入人ID
     */
    @Column(name = "ImportSetId")
    private String importSetId;
    
    /**
     * 操作部门编码
     */
    @Column(name = "DeptCode")
    private String deptCode;
    
    /**
     * 审核意见
     */
    @Column(name = "CheckView")
    private String checkView;
    
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
    public String getUID() {
        return UID;
    }

    /**
     * 设置UID
     *
     * @param UID UID
     */
    public void setUID(String UID) {
        this.UID = UID;
    }

    /**
     * 获取主体代码
     *
     * @return PriPID - 主体代码
     */
    public String getPriPID() {
        return priPID;
    }

    /**
     * 设置主体代码
     *
     * @param priPID 主体代码
     */
    public void setPriPID(String priPID) {
        this.priPID = priPID;
    }

    /**
     * 获取审核状态
     *
     * @return CheckState - 审核状态
     */
    public String getCheckState() {
        return checkState;
    }

    /**
     * 设置审核状态
     *
     * @param checkState 审核状态
     */
    public void setCheckState(String checkState) {
        this.checkState = checkState;
    }

    /**
     * 获取0:无效，1:有效
     *
     * @return EntWarnState - 0:无效，1:有效
     */
    public String getEntWarnState() {
        return entWarnState;
    }

    /**
     * 设置0:无效，1:有效
     *
     * @param entWarnState 0:无效，1:有效
     */
    public void setEntWarnState(String entWarnState) {
        this.entWarnState = entWarnState;
    }

    /**
     * 获取批次编号
     *
     * @return BatchNo - 批次编号
     */
    public String getBatchNo() {
        return batchNo;
    }

    /**
     * 设置批次编号
     *
     * @param batchNo 批次编号
     */
    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }

    /**
     * 获取录入人
     *
     * @return ImportPeople - 录入人
     */
    public String getImportPeople() {
        return importPeople;
    }

    /**
     * 设置录入人
     *
     * @param importPeople 录入人
     */
    public void setImportPeople(String importPeople) {
        this.importPeople = importPeople;
    }

    /**
     * 获取录入时间
     *
     * @return ImportDate - 录入时间
     */
    public Date getImportDate() {
        return importDate;
    }

    /**
     * 设置录入时间
     *
     * @param importDate 录入时间
     */
    public void setImportDate(Date importDate) {
        this.importDate = importDate;
    }

    /**
     * 获取审核人
     *
     * @return CheckPeople - 审核人
     */
    public String getCheckPeople() {
        return checkPeople;
    }

    /**
     * 设置审核人
     *
     * @param checkPeople 审核人
     */
    public void setCheckPeople(String checkPeople) {
        this.checkPeople = checkPeople;
    }

    /**
     * 获取审核时间
     *
     * @return CheckDate - 审核时间
     */
    public Date getCheckDate() {
        return checkDate;
    }

    /**
     * 设置审核时间
     *
     * @param checkDate 审核时间
     */
    public void setCheckDate(Date checkDate) {
        this.checkDate = checkDate;
    }

    /**
     * 获取预警编码
     *
     * @return WarnNo - 预警编码
     */
    public String getMarkNo() {
		return markNo;
	}

	public void setMarkNo(String markNo) {
		this.markNo = markNo;
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

	public String getImportSetId() {
		return importSetId;
	}

	public void setImportSetId(String importSetId) {
		this.importSetId = importSetId;
	}


	public String getDeptCode() {
		return deptCode;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}

	public String getCheckView() {
		return checkView;
	}

	public void setCheckView(String checkView) {
		this.checkView = checkView;
	}

	
    
    
}