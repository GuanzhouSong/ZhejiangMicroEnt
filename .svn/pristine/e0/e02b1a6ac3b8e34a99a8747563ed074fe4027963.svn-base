/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.depsyn.model;

import com.icinfo.framework.mybatis.mapper.annotation.Before;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 描述:    cs_depsyn_com_pun 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2016年12月12日
 */
@Table(name = "cs_depsyn_com_pun")
public class CsDepsynComPun implements Serializable {
    @Id
    @Column(name = "id")
    @Before
    private Integer id;

    /**
     * UUID
     */
    @Column(name = "UID")
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    private String UID;

    /**
     * 主体身份代码
     */
    @Column(name = "PriPID")
    private String priPID;

    /**
     * 名称
     */
    @Column(name = "ComName")
    private String comName;

    /**
     * 证件号码
     */
    @Column(name = "ComNO")
    private String comNO;

    /**
     * 提供方式
     */
    @Column(name = "ProType")
    private String proType;

    /**
     * 限制法律依据
     */
    @Column(name = "LimLegalBase")
    private String limLegalBase;

    /**
     * 
限制期限自
     */
    @Column(name = "ValFrom")
    private String valFrom;

    /**
     * 校验标志(0: 不通过, 1: 通过)
     */
    @Column(name = "ValFromState")
    private String valFromState;

    /**
     * 
限制期限至
     */
    @Column(name = "ValTo")
    private String valTo;

    /**
     * 校验标志(0: 不通过, 1: 通过)
     */
    @Column(name = "ValToState")
    private String valToState;

    /**
     * 信息发送部门名称
     */
    @Column(name = "SendDepName")
    private String sendDepName;

    /**
     * 信息接收部门名称
     */
    @Column(name = "RecvDepName")
    private String recvDepName;

    /**
     * 信息类型
     */
    @Column(name = "MsgType")
    private String msgType;

    /**
     * 错误代码
     */
    @Column(name = "ErrorCode")
    private String errorCode;

    /**
     * 录入人员编号
     */
    @Column(name = "InputPerID")
    private String inputPerID;

    /**
     * 录入人部门编码
     */
    @Column(name = "InputDepCode")
    private String inputDepCode;

    /**
     * 录入时间
     */
    @Column(name = "InputDate")
    private Date inputDate;

    /**
     * 年份
     */
    @Column(name = "Year")
    private String year;

    /**
     * 行政编码
     */
    @Column(name = "Adcode")
    private String adcode;

    /**
     * 法律描述
     */
    @Column(name = "LegalDesc")
    private String legalDesc;

    private static final long serialVersionUID = 1L;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取UUID
     *
     * @return UID - UUID
     */
    public String getUID() {
        return UID;
    }

    /**
     * 设置UUID
     *
     * @param UID UUID
     */
    public void setUID(String UID) {
        this.UID = UID;
    }

    /**
     * 获取主体身份代码
     *
     * @return PriPID - 主体身份代码
     */
    public String getPriPID() {
        return priPID;
    }

    /**
     * 设置主体身份代码
     *
     * @param priPID 主体身份代码
     */
    public void setPriPID(String priPID) {
        this.priPID = priPID;
    }

    /**
     * 获取名称
     *
     * @return ComName - 名称
     */
    public String getComName() {
        return comName;
    }

    /**
     * 设置名称
     *
     * @param comName 名称
     */
    public void setComName(String comName) {
        this.comName = comName;
    }

    /**
     * 获取证件号码
     *
     * @return ComNO - 证件号码
     */
    public String getComNO() {
        return comNO;
    }

    /**
     * 设置证件号码
     *
     * @param comNO 证件号码
     */
    public void setComNO(String comNO) {
        this.comNO = comNO;
    }

    /**
     * 获取提供方式
     *
     * @return ProType - 提供方式
     */
    public String getProType() {
        return proType;
    }

    /**
     * 设置提供方式
     *
     * @param proType 提供方式
     */
    public void setProType(String proType) {
        this.proType = proType;
    }

    /**
     * 获取限制法律依据
     *
     * @return LimLegalBase - 限制法律依据
     */
    public String getLimLegalBase() {
        return limLegalBase;
    }

    /**
     * 设置限制法律依据
     *
     * @param limLegalBase 限制法律依据
     */
    public void setLimLegalBase(String limLegalBase) {
        this.limLegalBase = limLegalBase;
    }

    /**
     * 获取
限制期限自
     *
     * @return ValFrom - 
限制期限自
     */
    public String getValFrom() {
        return valFrom;
    }

    /**
     * 设置
限制期限自
     *
     * @param valFrom 
限制期限自
     */
    public void setValFrom(String valFrom) {
        this.valFrom = valFrom;
    }

    /**
     * 获取校验标志(0: 不通过, 1: 通过)
     *
     * @return ValFromState - 校验标志(0: 不通过, 1: 通过)
     */
    public String getValFromState() {
        return valFromState;
    }

    /**
     * 设置校验标志(0: 不通过, 1: 通过)
     *
     * @param valFromState 校验标志(0: 不通过, 1: 通过)
     */
    public void setValFromState(String valFromState) {
        this.valFromState = valFromState;
    }

    /**
     * 获取
限制期限至
     *
     * @return ValTo - 
限制期限至
     */
    public String getValTo() {
        return valTo;
    }

    /**
     * 设置
限制期限至
     *
     * @param valTo 
限制期限至
     */
    public void setValTo(String valTo) {
        this.valTo = valTo;
    }

    /**
     * 获取校验标志(0: 不通过, 1: 通过)
     *
     * @return ValToState - 校验标志(0: 不通过, 1: 通过)
     */
    public String getValToState() {
        return valToState;
    }

    /**
     * 设置校验标志(0: 不通过, 1: 通过)
     *
     * @param valToState 校验标志(0: 不通过, 1: 通过)
     */
    public void setValToState(String valToState) {
        this.valToState = valToState;
    }

    /**
     * 获取信息发送部门名称
     *
     * @return SendDepName - 信息发送部门名称
     */
    public String getSendDepName() {
        return sendDepName;
    }

    /**
     * 设置信息发送部门名称
     *
     * @param sendDepName 信息发送部门名称
     */
    public void setSendDepName(String sendDepName) {
        this.sendDepName = sendDepName;
    }

    /**
     * 获取信息接收部门名称
     *
     * @return RecvDepName - 信息接收部门名称
     */
    public String getRecvDepName() {
        return recvDepName;
    }

    /**
     * 设置信息接收部门名称
     *
     * @param recvDepName 信息接收部门名称
     */
    public void setRecvDepName(String recvDepName) {
        this.recvDepName = recvDepName;
    }

    /**
     * 获取信息类型
     *
     * @return MsgType - 信息类型
     */
    public String getMsgType() {
        return msgType;
    }

    /**
     * 设置信息类型
     *
     * @param msgType 信息类型
     */
    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    /**
     * 获取错误代码
     *
     * @return ErrorCode - 错误代码
     */
    public String getErrorCode() {
        return errorCode;
    }

    /**
     * 设置错误代码
     *
     * @param errorCode 错误代码
     */
    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    /**
     * 获取录入人员编号
     *
     * @return InputPerID - 录入人员编号
     */
    public String getInputPerID() {
        return inputPerID;
    }

    /**
     * 设置录入人员编号
     *
     * @param inputPerID 录入人员编号
     */
    public void setInputPerID(String inputPerID) {
        this.inputPerID = inputPerID;
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
     * 获取年份
     *
     * @return Year - 年份
     */
    public String getYear() {
        return year;
    }

    /**
     * 设置年份
     *
     * @param year 年份
     */
    public void setYear(String year) {
        this.year = year;
    }

    /**
     * 获取行政编码
     *
     * @return Adcode - 行政编码
     */
    public String getAdcode() {
        return adcode;
    }

    /**
     * 设置行政编码
     *
     * @param adcode 行政编码
     */
    public void setAdcode(String adcode) {
        this.adcode = adcode;
    }

    /**
     * 获取法律描述
     *
     * @return LegalDesc - 法律描述
     */
    public String getLegalDesc() {
        return legalDesc;
    }

    /**
     * 设置法律描述
     *
     * @param legalDesc 法律描述
     */
    public void setLegalDesc(String legalDesc) {
        this.legalDesc = legalDesc;
    }
}