/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.supervise.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.icinfo.framework.mybatis.mapper.annotation.Before;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * 描述:    cs_supervise_obj 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2016年10月26日
 */
@Table(name = "cs_supervise_obj")
public class CsSuperviseObj implements Serializable {
    /**
     * 自增ID
     */
    @Id
    @Column(name = "id")
    private Integer id;

    /**
     * 序号
     */
    @Column(name = "UID")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
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
    @Column(name = "MarkCode")
    private String markCode;

    /**
     * 企业重点监管状态
     * 0 ： 失效
     * 1 ：有效
     */
    @Column(name = "SupState")
    private String supState;

    /**
     * 审核状态
     * 
     *  0 未通过
     *  1 通过
     *  2 未审核
	 *	3  审核退回
     */
    @Column(name = "SupCheckState")
    private String supCheckState;

    /**
     * 审核人
     */
    @Column(name = "CheckPer")
    private String checkPer;

    /**
     * 审核人ID
     */
    @Column(name = "CheckPerID")
    private String checkPerID;
    

    /**
     * 审核时间
     */
    @Column(name = "CheckDate")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date checkDate;
    
    /**
     * 审核意见
     */
    @Column(name="CheckAdv")
    private String checkAdv;

    /**
     * 录入人
     */
    @Column(name = "InputPer")
    private String inputPer;

    /**
     * 录入人ID
     */
    @Column(name = "InputPerID")
    private String inputPerID;

    /**
     * 录入时间
     */
    @Column(name = "InputDate")
    private Date inputDate;

    /**
     * 录入人部门编码
     */
    @Column(name = "InputDepCode")
    private String inputDepCode;

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
     * @return MarkCode - 标识编码
     */
    public String getMarkCode() {
        return markCode;
    }

    /**
     * 设置标识编码
     *
     * @param markCode 标识编码
     */
    public void setMarkCode(String markCode) {
        this.markCode = markCode;
    }

    /**
     * 获取企业重点监管状态
     *
     * @return SupState - 企业重点监管状态
     */
    public String getSupState() {
        return supState;
    }

    /**
     * 设置企业重点监管状态
     *
     * @param supState 企业重点监管状态
     */
    public void setSupState(String supState) {
        this.supState = supState;
    }

    /**
     * 获取审核状态
     *
     * @return SupCheckState - 审核状态
     */
    public String getSupCheckState() {
        return supCheckState;
    }

    /**
     * 设置审核状态
     *
     * @param supCheckState 审核状态
     */
    public void setSupCheckState(String supCheckState) {
        this.supCheckState = supCheckState;
    }

    /**
     * 获取审核人
     *
     * @return CheckPer - 审核人
     */
    public String getCheckPer() {
        return checkPer;
    }

    /**
     * 设置审核人
     *
     * @param checkPer 审核人
     */
    public void setCheckPer(String checkPer) {
        this.checkPer = checkPer;
    }

    /**
     * 获取审核人ID
     *
     * @return CheckPerID - 审核人ID
     */
    public String getCheckPerID() {
        return checkPerID;
    }

    /**
     * 设置审核人ID
     *
     * @param checkPerID 审核人ID
     */
    public void setCheckPerID(String checkPerID) {
        this.checkPerID = checkPerID;
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
     * 获取录入人
     *
     * @return InputPer - 录入人
     */
    public String getInputPer() {
        return inputPer;
    }

    /**
     * 设置录入人
     *
     * @param inputPer 录入人
     */
    public void setInputPer(String inputPer) {
        this.inputPer = inputPer;
    }

    /**
     * 获取录入人ID
     *
     * @return InputPerID - 录入人ID
     */
    public String getInputPerID() {
        return inputPerID;
    }

    /**
     * 设置录入人ID
     *
     * @param inputPerID 录入人ID
     */
    public void setInputPerID(String inputPerID) {
        this.inputPerID = inputPerID;
    }

    /**
     * 获取录入时间
     *
     * @return InputDate - 录入时间
     */
    public Date getInputDate() {
        return inputDate;
    }

    /**
     * 设置录入时间
     *
     * @param inputDate 录入时间
     */
    public void setInputDate(Date inputDate) {
        this.inputDate = inputDate;
    }

    /**
     * 获取录入人部门编码
     *
     * @return InputDepCode - 录入人部门编码
     */
    public String getInputDepCode() {
        return inputDepCode;
    }

    /**
     * 设置录入人部门编码
     *
     * @param inputDepCode 录入人部门编码
     */
    public void setInputDepCode(String inputDepCode) {
        this.inputDepCode = inputDepCode;
    }

	public String getCheckAdv() {
		return checkAdv;
	}

	public void setCheckAdv(String checkAdv) {
		this.checkAdv = checkAdv;
	}
    
    
}