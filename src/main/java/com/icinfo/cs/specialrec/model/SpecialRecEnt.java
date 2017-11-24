/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.specialrec.model;

import com.icinfo.framework.mybatis.mapper.annotation.Before;
import java.io.Serializable;
import javax.persistence.*;

/**
 * 描述:    cs_special_rec_ent 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年11月01日
 */
@Table(name = "cs_special_rec_ent")
public class SpecialRecEnt implements Serializable {
    /**
     * 自增长序号
     */
    @Id
    @Column(name = "id")
    private Integer id;

    /**
     * 序号：UUID
     */
    @Column(name = "Uid")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    private String uid;

    /**
     * 任务表序号
     */
    @Column(name = "TaskUid")
    private String taskUid;

    /**
     * 主体身份代码
     */
    @Column(name = "PriPID")
    private String priPID;

    /**
     * 注册号(CA15)
     */
    @Column(name = "RegNO")
    private String regNO;

    /**
     * 统一社会信用代码(CA91)
     */
    @Column(name = "UniCode")
    private String uniCode;

    /**
     * 企业(机构)名称
     */
    @Column(name = "EntName")
    private String entName;

    /**
     * 企业大类
     */
    @Column(name = "EntTypeCatg")
    private String entTypeCatg;

    /**
     * 登记状态(CA19)
     */
    @Column(name = "RegState")
    private String regState;

    /**
     * 登记机关(CA11)
     */
    @Column(name = "RegOrg")
    private String regOrg;

    /**
     * 登记机关名称
     */
    @Column(name = "RegOrgName")
    private String regOrgName;

    /**
     * 属地监管工商所
     */
    @Column(name = "LocalAdm")
    private String localAdm;

    /**
     * 属地监管工商所名称
     */
    @Column(name = "LocalAdmName")
    private String localAdmName;

    /**
     * 责任区商圈
     */
    @Column(name = "SliceNO")
    private String sliceNO;

    /**
     * 责任区商圈名称
     */
    @Column(name = "SliceNOName")
    private String sliceNOName;

    /**
     * 经营范围
     */
    @Column(name = "Dom")
    private String dom;

    private static final long serialVersionUID = 1L;

    /**
     * 获取自增长序号
     *
     * @return id - 自增长序号
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置自增长序号
     *
     * @param id 自增长序号
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取序号：UUID
     *
     * @return Uid - 序号：UUID
     */
    public String getUid() {
        return uid;
    }

    /**
     * 设置序号：UUID
     *
     * @param uid 序号：UUID
     */
    public void setUid(String uid) {
        this.uid = uid;
    }

    /**
     * 获取任务表序号
     *
     * @return TaskUid - 任务表序号
     */
    public String getTaskUid() {
        return taskUid;
    }

    /**
     * 设置任务表序号
     *
     * @param taskUid 任务表序号
     */
    public void setTaskUid(String taskUid) {
        this.taskUid = taskUid;
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
     * 获取注册号(CA15)
     *
     * @return RegNO - 注册号(CA15)
     */
    public String getRegNO() {
        return regNO;
    }

    /**
     * 设置注册号(CA15)
     *
     * @param regNO 注册号(CA15)
     */
    public void setRegNO(String regNO) {
        this.regNO = regNO;
    }

    /**
     * 获取统一社会信用代码(CA91)
     *
     * @return UniCode - 统一社会信用代码(CA91)
     */
    public String getUniCode() {
        return uniCode;
    }

    /**
     * 设置统一社会信用代码(CA91)
     *
     * @param uniCode 统一社会信用代码(CA91)
     */
    public void setUniCode(String uniCode) {
        this.uniCode = uniCode;
    }

    /**
     * 获取企业(机构)名称
     *
     * @return EntName - 企业(机构)名称
     */
    public String getEntName() {
        return entName;
    }

    /**
     * 设置企业(机构)名称
     *
     * @param entName 企业(机构)名称
     */
    public void setEntName(String entName) {
        this.entName = entName;
    }

    /**
     * 获取企业大类
     *
     * @return EntTypeCatg - 企业大类
     */
    public String getEntTypeCatg() {
        return entTypeCatg;
    }

    /**
     * 设置企业大类
     *
     * @param entTypeCatg 企业大类
     */
    public void setEntTypeCatg(String entTypeCatg) {
        this.entTypeCatg = entTypeCatg;
    }

    /**
     * 获取登记状态(CA19)
     *
     * @return RegState - 登记状态(CA19)
     */
    public String getRegState() {
        return regState;
    }

    /**
     * 设置登记状态(CA19)
     *
     * @param regState 登记状态(CA19)
     */
    public void setRegState(String regState) {
        this.regState = regState;
    }

    /**
     * 获取登记机关(CA11)
     *
     * @return RegOrg - 登记机关(CA11)
     */
    public String getRegOrg() {
        return regOrg;
    }

    /**
     * 设置登记机关(CA11)
     *
     * @param regOrg 登记机关(CA11)
     */
    public void setRegOrg(String regOrg) {
        this.regOrg = regOrg;
    }

    /**
     * 获取登记机关名称
     *
     * @return RegOrgName - 登记机关名称
     */
    public String getRegOrgName() {
        return regOrgName;
    }

    /**
     * 设置登记机关名称
     *
     * @param regOrgName 登记机关名称
     */
    public void setRegOrgName(String regOrgName) {
        this.regOrgName = regOrgName;
    }

    /**
     * 获取属地监管工商所
     *
     * @return LocalAdm - 属地监管工商所
     */
    public String getLocalAdm() {
        return localAdm;
    }

    /**
     * 设置属地监管工商所
     *
     * @param localAdm 属地监管工商所
     */
    public void setLocalAdm(String localAdm) {
        this.localAdm = localAdm;
    }

    /**
     * 获取属地监管工商所名称
     *
     * @return LocalAdmName - 属地监管工商所名称
     */
    public String getLocalAdmName() {
        return localAdmName;
    }

    /**
     * 设置属地监管工商所名称
     *
     * @param localAdmName 属地监管工商所名称
     */
    public void setLocalAdmName(String localAdmName) {
        this.localAdmName = localAdmName;
    }

    /**
     * 获取责任区商圈
     *
     * @return SliceNO - 责任区商圈
     */
    public String getSliceNO() {
        return sliceNO;
    }

    /**
     * 设置责任区商圈
     *
     * @param sliceNO 责任区商圈
     */
    public void setSliceNO(String sliceNO) {
        this.sliceNO = sliceNO;
    }

    /**
     * 获取责任区商圈名称
     *
     * @return SliceNOName - 责任区商圈名称
     */
    public String getSliceNOName() {
        return sliceNOName;
    }

    /**
     * 设置责任区商圈名称
     *
     * @param sliceNOName 责任区商圈名称
     */
    public void setSliceNOName(String sliceNOName) {
        this.sliceNOName = sliceNOName;
    }

    /**
     * 获取经营范围
     *
     * @return Dom - 经营范围
     */
    public String getDom() {
        return dom;
    }

    /**
     * 设置经营范围
     *
     * @param dom 经营范围
     */
    public void setDom(String dom) {
        this.dom = dom;
    }
}