/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.sccheck.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.icinfo.framework.mybatis.mapper.annotation.Before;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * 描述:    cs_pub_scent_back 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年05月17日
 */
@Table(name = "cs_pub_scent_back")
public class PubScentBack implements Serializable {
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
     * 企业(机构)名称
     */
    @Column(name = "EntName")
    private String entName;

    /**
     * 注册号(CA15)
     */
    @Column(name = "RegNO")
    private String regNO;

    /**
     * 市场主体类型大类
     */
    @Column(name = "EntTypeCatg")
    private String entTypeCatg;

    /**
     * 登记机关(CA11)
     */
    @Column(name = "RegOrg")
    private String regOrg;

    /**
     * 属地监管工商所
     */
    @Column(name = "LocalAdm")
    private String localAdm;

    /**
     * 登记状态(CA19)
     */
    @Column(name = "RegState")
    private String regState;

    /**
     * 统一社会信用代码(CA91)
     */
    @Column(name = "UniCode")
    private String uniCode;

    /**
     * 登记机关名称
     */
    @Column(name = "RegOrgName")
    private String regOrgName;

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
     * 成立日期
     */
    @Column(name = "EstDate")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date estDate;

    /**
     * 专项库编码
     */
    @Column(name = "SpecialCode")
    private String specialCode;

    /**
     * 专修描述
     */
    @Column(name = "SpecialName")
    private String specialName;

    /**
     * 分类标签编码
     */
    @Column(name = "MarkCode")
    private String markCode;

    /**
     * 分类标签描述
     */
    @Column(name = "MarkName")
    private String markName;
    
    
    /**
     * 检查事项编码
     */
    @Column(name = "CheckCode")
    private String CheckCode;
    
    /**
     * 检查事项名称
     */
    @Column(name = "CheckName")
    private String checkName;
    
    

    /**
     * 上次检查日期
     */
    @Column(name = "LastCheckTime")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date lastCheckTime;
    
    /**
     * 专项库导入用户uid
     */
    @Column(name = "RelateUserUid")
    private String relateUserUid;
    
    /**
     * 时间戳
     */
    @Column(name = "SetTime")
    private Date setTime;
    
    /**
     * 跨部门专项库UID
     */
    @Column(name = "DrSpeaialUid")
    private String drSpeaialUid;
    
    /**
     * 检查机关编码
     */
    @Column(name = "CheckDeptCode")
    private String checkDeptCode;

    /**
     * 检查部门描述
     */
    @Column(name = "CheckDeptName")
    private String checkDeptName;

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

    public String getEntTypeCatg() {
		return entTypeCatg;
	}

	public void setEntTypeCatg(String entTypeCatg) {
		this.entTypeCatg = entTypeCatg;
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
     * 获取专项库编码
     *
     * @return SpecialCode - 专项库编码
     */
    public String getSpecialCode() {
        return specialCode;
    }

    /**
     * 设置专项库编码
     *
     * @param specialCode 专项库编码
     */
    public void setSpecialCode(String specialCode) {
        this.specialCode = specialCode;
    }

    /**
     * 获取专修描述
     *
     * @return SpecialName - 专修描述
     */
    public String getSpecialName() {
        return specialName;
    }

    /**
     * 设置专修描述
     *
     * @param specialName 专修描述
     */
    public void setSpecialName(String specialName) {
        this.specialName = specialName;
    }

    /**
     * 获取分类标签编码
     *
     * @return MarkCode - 分类标签编码
     */
    public String getMarkCode() {
        return markCode;
    }

    /**
     * 设置分类标签编码
     *
     * @param markCode 分类标签编码
     */
    public void setMarkCode(String markCode) {
        this.markCode = markCode;
    }

    /**
     * 获取分类标签描述
     *
     * @return MarkName - 分类标签描述
     */
    public String getMarkName() {
        return markName;
    }

    /**
     * 设置分类标签描述
     *
     * @param markName 分类标签描述
     */
    public void setMarkName(String markName) {
        this.markName = markName;
    }

    /**
     * 获取上次检查日期
     *
     * @return LastCheckTime - 上次检查日期
     */
    public Date getLastCheckTime() {
        return lastCheckTime;
    }

    /**
     * 设置上次检查日期
     *
     * @param lastCheckTime 上次检查日期
     */
    public void setLastCheckTime(Date lastCheckTime) {
        this.lastCheckTime = lastCheckTime;
    }

    /**
     * 获取时间戳
     *
     * @return SetTime - 时间戳
     */
    public Date getSetTime() {
        return setTime;
    }

    /**
     * 设置时间戳
     *
     * @param setTime 时间戳
     */
    public void setSetTime(Date setTime) {
        this.setTime = setTime;
    }

	public Date getEstDate() {
		return estDate;
	}

	public void setEstDate(Date estDate) {
		this.estDate = estDate;
	}

	public String getCheckCode() {
		return CheckCode;
	}

	public void setCheckCode(String checkCode) {
		CheckCode = checkCode;
	}

	public String getCheckName() {
		return checkName;
	}

	public void setCheckName(String checkName) {
		this.checkName = checkName;
	}

	public String getRelateUserUid() {
		return relateUserUid;
	}

	public void setRelateUserUid(String relateUserUid) {
		this.relateUserUid = relateUserUid;
	}

	public String getDrSpeaialUid() {
		return drSpeaialUid;
	}

	public void setDrSpeaialUid(String drSpeaialUid) {
		this.drSpeaialUid = drSpeaialUid;
	}

	public String getCheckDeptCode() {
		return checkDeptCode;
	}

	public void setCheckDeptCode(String checkDeptCode) {
		this.checkDeptCode = checkDeptCode;
	}

	public String getCheckDeptName() {
		return checkDeptName;
	}

	public void setCheckDeptName(String checkDeptName) {
		this.checkDeptName = checkDeptName;
	}
	
	
}