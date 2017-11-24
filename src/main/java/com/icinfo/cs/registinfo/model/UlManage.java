/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.registinfo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.icinfo.framework.mybatis.mapper.annotation.Before;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * 描述:    cs_ul_manage 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2016年09月09日
 */
@Table(name = "cs_ul_manage")
public class UlManage implements Serializable {
    @Id
    @Column(name = "id")
    private Integer id;

    /**
     * 主体身份代码
     */
    @Column(name = "PriPID")
    private String priPID;

    /**
     * 创建时间
     */
    @Column(name = "CreateTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;

    /**
     * 主体户口、无照的UUID
     */
    @Column(name = "UID")
    private String UID;

    /**
     * 处理措施（1行政告诫、2行政指导、3责令整改、4列入案源信息、5部门抄告抄送、6销户）
     */
    @Column(name = "DisposeWay")
    private String disposeWay;

    /**
     * 处理时间
     */
    @Column(name = "DisposeDate")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date disposeDate;

    /**
     * 经办人
     */
    @Column(name = "DisposeName")
    private String disposeName;
    /**
     * 销户事由
     */
    @Column(name = "LogoffReason")
    private String logoffReason;

    /**
     * 录入人
     */
    @Column(name = "InputName")
    private String inputName;
    /**
     * 情况说明
     */
    @Column(name = "Remark")
    private String remark;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    /**
     * 获取主体户口、无照的UUID
     *
     * @return UID - 主体户口、无照的UUID
     */
    public String getUID() {
        return UID;
    }

    /**
     * 设置主体户口、无照的UUID
     *
     * @param UID 主体户口、无照的UUID
     */
    public void setUID(String UID) {
        this.UID = UID;
    }

    /**
     * 获取处理措施（1行政告诫、2行政指导、3责令整改、4列入案源信息、5部门抄告抄送、6销户）
     *
     * @return DisposeWay - 处理措施（1行政告诫、2行政指导、3责令整改、4列入案源信息、5部门抄告抄送、6销户）
     */
    public String getDisposeWay() {
        return disposeWay;
    }

    /**
     * 设置处理措施（1行政告诫、2行政指导、3责令整改、4列入案源信息、5部门抄告抄送、6销户）
     *
     * @param disposeWay 处理措施（1行政告诫、2行政指导、3责令整改、4列入案源信息、5部门抄告抄送、6销户）
     */
    public void setDisposeWay(String disposeWay) {
        this.disposeWay = disposeWay;
    }

    /**
     * 获取处理时间
     *
     * @return DisposeDate - 处理时间
     */
    public Date getDisposeDate() {
        return disposeDate;
    }

    /**
     * 设置处理时间
     *
     * @param disposeDate 处理时间
     */
    public void setDisposeDate(Date disposeDate) {
        this.disposeDate = disposeDate;
    }

    /**
     * 获取经办人
     *
     * @return DisposeName - 经办人
     */
    public String getDisposeName() {
        return disposeName;
    }

    /**
     * 设置经办人
     *
     * @param disposeName 经办人
     */
    public void setDisposeName(String disposeName) {
        this.disposeName = disposeName;
    }

    /**
     * 获取情况说明
     *
     * @return Remark - 情况说明
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置情况说明
     *
     * @param remark 情况说明
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getInputName() {
        return inputName;
    }

    public void setInputName(String inputName) {
        this.inputName = inputName;
    }

    public String getLogoffReason() {
        return logoffReason;
    }

    public void setLogoffReason(String logoffReason) {
        this.logoffReason = logoffReason;
    }
}