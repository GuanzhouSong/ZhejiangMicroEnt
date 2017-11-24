/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.concern.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.icinfo.framework.mybatis.mapper.annotation.Before;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * 描述:    cs_concern_obj 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2016年11月01日
 */
@Table(name = "cs_concern_obj")
public class CsConcernObj implements Serializable {
    /**
     * 自增ID
     */
    @Id
    @Column(name = "id")
    private Integer id;

    /**
     * 序号
     */
    
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    @Column(name = "UID")
    private String UID;

    /**
     * 内部序号
     */
    @Column(name = "PriPID")
    private String priPID;

    /**
     * 批次号
     */
    @Column(name = "BatchNO")
    private String batchNO;

    /**
     * 标识编码
     */
    @Column(name = "MarkNo")
    private String markNo;

    /**
     * 关注服务对象状态 0:无效 1：有效
     */
    @Column(name = "ConState")
    private String conState;

    /**
     * 审核状态0：未通过，1：通过，2：未审核，3审核退回
     */
    @Column(name = "CheckState")
    private String checkState;

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
     * 录入人ID
     */
    @Column(name = "ImportSetId")
    private String importSetId;

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
     * 操作人部门编码
     */
    @Column(name = "DeptCode")
    private String deptCode;

    /**
     * 审核意见
     */
    @Column(name = "CheckView")
    private String checkView;

    /**
     * 创建时间
     */
    @Column(name = "CreateTime")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date createTime;

    private static final long serialVersionUID = 1L;

    /**
     * 获取自增ID
     *
     * @return id - 自增ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置自增ID
     *
     * @param id 自增ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取序号
     *
     * @return UID - 序号
     */
    public String getUID() {
        return UID;
    }

    /**
     * 设置序号
     *
     * @param UID 序号
     */
    public void setUID(String UID) {
        this.UID = UID;
    }

    /**
     * 获取内部序号
     *
     * @return PriPID - 内部序号
     */
    public String getPriPID() {
        return priPID;
    }

    /**
     * 设置内部序号
     *
     * @param priPID 内部序号
     */
    public void setPriPID(String priPID) {
        this.priPID = priPID;
    }

    /**
     * 获取批次号
     *
     * @return BatchNO - 批次号
     */
    public String getBatchNO() {
        return batchNO;
    }

    /**
     * 设置批次号
     *
     * @param batchNO 批次号
     */
    public void setBatchNO(String batchNO) {
        this.batchNO = batchNO;
    }

    /**
     * 获取标识编码
     *
     * @return MarkNo - 标识编码
     */
    public String getMarkNo() {
        return markNo;
    }

    /**
     * 设置标识编码
     *
     * @param markNo 标识编码
     */
    public void setMarkNo(String markNo) {
        this.markNo = markNo;
    }

    /**
     * 获取关注服务对象状态 0:无效 1：有效
     *
     * @return ConState - 关注服务对象状态 0:无效 1：有效
     */
    public String getConState() {
        return conState;
    }

    /**
     * 设置关注服务对象状态 0:无效 1：有效
     *
     * @param conState 关注服务对象状态 0:无效 1：有效
     */
    public void setConState(String conState) {
        this.conState = conState;
    }

    /**
     * 获取审核状态0：未通过，1：通过，2：未审核，3审核退回
     *
     * @return CheckState - 审核状态0：未通过，1：通过，2：未审核，3审核退回
     */
    public String getCheckState() {
        return checkState;
    }

    /**
     * 设置审核状态0：未通过，1：通过，2：未审核，3审核退回
     *
     * @param checkState 审核状态0：未通过，1：通过，2：未审核，3审核退回
     */
    public void setCheckState(String checkState) {
        this.checkState = checkState;
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
     * 获取录入人ID
     *
     * @return ImportSetId - 录入人ID
     */
    public String getImportSetId() {
        return importSetId;
    }

    /**
     * 设置录入人ID
     *
     * @param importSetId 录入人ID
     */
    public void setImportSetId(String importSetId) {
        this.importSetId = importSetId;
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
     * 获取操作人部门编码
     *
     * @return DeptCode - 操作人部门编码
     */
    public String getDeptCode() {
        return deptCode;
    }

    /**
     * 设置操作人部门编码
     *
     * @param deptCode 操作人部门编码
     */
    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    /**
     * 获取审核意见
     *
     * @return CheckView - 审核意见
     */
    public String getCheckView() {
        return checkView;
    }

    /**
     * 设置审核意见
     *
     * @param checkView 审核意见
     */
    public void setCheckView(String checkView) {
        this.checkView = checkView;
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
}