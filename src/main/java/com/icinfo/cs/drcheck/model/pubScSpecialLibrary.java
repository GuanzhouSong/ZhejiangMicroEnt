/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.drcheck.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.icinfo.framework.mybatis.mapper.annotation.Before;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * 描述:    cs_pub_scspecial_library 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年04月19日
 */
@Table(name = "cs_pub_scspecial_library")
public class pubScSpecialLibrary implements Serializable {
    /**
     * 序号
     */
    @Id
    @Column(name = "id")
    private Integer id;

    /**
     * uuid
     */
    @Column(name = "UID")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    private String uid;

    /**
     * 主体身份代码(CA14)
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
     * 市场主体类型(CA16)
     */
    @Column(name = "EntType")
    private String entType;

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
     * 专项库编码
     */
    @Column(name = "SpecialCode")
    private String specialCode;

    @Column(name = "SpecialName")
    private String specialName;

    /**
     * 专项库是否有对应的许可证
     */
    @Column(name = "SpecialLicFlag")
    private String specialLicFlag;

    /**
     * 许可证名称
     */
    @Column(name = "LicName")
    private String licName;

    /**
     * 许可证编号
     */
    @Column(name = "LicNO")
    private String licNO;

    /**
     * 许可证核准日期
     */
    @Column(name = "LicApprDate")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date licApprDate;

    /**
     * 许可证有效截止日期
     */
    @Column(name = "LicSaveEndDate")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date licSaveEndDate;

    /**
     * 许可证发证机关
     */
    @Column(name = "LicSendDept")
    private String licSendDept;

    /**
     * 是否需要专业监管
     */
    @Column(name = "SuperviseFlag")
    private String superviseFlag;

    /**
     * 是否需要专业资格资质（否填写0，多个以逗号隔开）
     */
    @Column(name = "RightFlag")
    private String rightFlag;

    /**
     * 是否需要配备专家（组长）（否填写0，多个以逗号隔开）
     */
    @Column(name = "LeadFlag")
    private String leadFlag;

    /**
     * 设置人ID
     */
    @Column(name = "SetUserUid")
    private String setUserUid;

    /**
     * 设置人
     */
    @Column(name = "SetUserName")
    private String setUserName;

    /**
     * 设置日期
     */
    @Column(name = "SetTime")
    private Date setTime;

    /**
     * 设置人部门编码
     */
    @Column(name = "SetDeptcode")
    private String setDeptcode;

    /**
     * 设置人部门中文表述
     */
    @Column(name = "SetDeptName")
    private String setDeptName;
    
    /**
     * 数据来源
     */
    @Column(name = "ScPtype")
    private String scPtype; 
    
    /**
     * 有效无效
     */
    @Column(name = "IsScVlid")
    private String isScVlid;
    
    /**
     * 监管标签名称
     */
    @Column(name = "MarkName")
    private String markName;
    
    /**
     * 监管标签编码
     */
    @Column(name = "MarkCode")
    private String markCode;
    
    

    private static final long serialVersionUID = 1L;

    /**
     * 获取序号
     *
     * @return id - 序号
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置序号
     *
     * @param id 序号
     */
    public void setId(Integer id) {
        this.id = id;
    }
    
    
    public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	/**
     * 获取主体身份代码(CA14)
     *
     * @return PriPID - 主体身份代码(CA14)
     */
    public String getPriPID() {
        return priPID;
    }

    /**
     * 设置主体身份代码(CA14)
     *
     * @param priPID 主体身份代码(CA14)
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

    /**
     * 获取市场主体类型(CA16)
     *
     * @return EntType - 市场主体类型(CA16)
     */
    public String getEntType() {
        return entType;
    }

    /**
     * 设置市场主体类型(CA16)
     *
     * @param entType 市场主体类型(CA16)
     */
    public void setEntType(String entType) {
        this.entType = entType;
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
     * @return SpecialName
     */
    public String getSpecialName() {
        return specialName;
    }

    /**
     * @param specialName
     */
    public void setSpecialName(String specialName) {
        this.specialName = specialName;
    }

    /**
     * 获取专项库是否有对应的许可证
     *
     * @return SpecialLicFlag - 专项库是否有对应的许可证
     */
    public String getSpecialLicFlag() {
        return specialLicFlag;
    }

    /**
     * 设置专项库是否有对应的许可证
     *
     * @param specialLicFlag 专项库是否有对应的许可证
     */
    public void setSpecialLicFlag(String specialLicFlag) {
        this.specialLicFlag = specialLicFlag;
    }

    /**
     * 获取许可证名称
     *
     * @return LicName - 许可证名称
     */
    public String getLicName() {
        return licName;
    }

    /**
     * 设置许可证名称
     *
     * @param licName 许可证名称
     */
    public void setLicName(String licName) {
        this.licName = licName;
    }

    /**
     * 获取许可证编号
     *
     * @return LicNO - 许可证编号
     */
    public String getLicNO() {
        return licNO;
    }

    /**
     * 设置许可证编号
     *
     * @param licNO 许可证编号
     */
    public void setLicNO(String licNO) {
        this.licNO = licNO;
    }

    /**
     * 获取许可证核准日期
     *
     * @return LicApprDate - 许可证核准日期
     */
    public Date getLicApprDate() {
        return licApprDate;
    }

    /**
     * 设置许可证核准日期
     *
     * @param licApprDate 许可证核准日期
     */
    public void setLicApprDate(Date licApprDate) {
        this.licApprDate = licApprDate;
    }

    /**
     * 获取许可证有效截止日期
     *
     * @return LicSaveEndDate - 许可证有效截止日期
     */
    public Date getLicSaveEndDate() {
        return licSaveEndDate;
    }

    /**
     * 设置许可证有效截止日期
     *
     * @param licSaveEndDate 许可证有效截止日期
     */
    public void setLicSaveEndDate(Date licSaveEndDate) {
        this.licSaveEndDate = licSaveEndDate;
    }

    /**
     * 获取许可证发证机关
     *
     * @return LicSendDept - 许可证发证机关
     */
    public String getLicSendDept() {
        return licSendDept;
    }

    /**
     * 设置许可证发证机关
     *
     * @param licSendDept 许可证发证机关
     */
    public void setLicSendDept(String licSendDept) {
        this.licSendDept = licSendDept;
    }

    /**
     * 获取是否需要专业监管
     *
     * @return SuperviseFlag - 是否需要专业监管
     */
    public String getSuperviseFlag() {
        return superviseFlag;
    }

    /**
     * 设置是否需要专业监管
     *
     * @param superviseFlag 是否需要专业监管
     */
    public void setSuperviseFlag(String superviseFlag) {
        this.superviseFlag = superviseFlag;
    }

    /**
     * 获取是否需要专业资格资质（否填写0，多个以逗号隔开）
     *
     * @return RightFlag - 是否需要专业资格资质（否填写0，多个以逗号隔开）
     */
    public String getRightFlag() {
        return rightFlag;
    }

    /**
     * 设置是否需要专业资格资质（否填写0，多个以逗号隔开）
     *
     * @param rightFlag 是否需要专业资格资质（否填写0，多个以逗号隔开）
     */
    public void setRightFlag(String rightFlag) {
        this.rightFlag = rightFlag;
    }

    /**
     * 获取是否需要配备专家（组长）（否填写0，多个以逗号隔开）
     *
     * @return LeadFlag - 是否需要配备专家（组长）（否填写0，多个以逗号隔开）
     */
    public String getLeadFlag() {
        return leadFlag;
    }

    /**
     * 设置是否需要配备专家（组长）（否填写0，多个以逗号隔开）
     *
     * @param leadFlag 是否需要配备专家（组长）（否填写0，多个以逗号隔开）
     */
    public void setLeadFlag(String leadFlag) {
        this.leadFlag = leadFlag;
    }

    /**
     * 获取设置人ID
     *
     * @return SetUserUid - 设置人ID
     */
    public String getSetUserUid() {
        return setUserUid;
    }

    /**
     * 设置设置人ID
     *
     * @param setUserUid 设置人ID
     */
    public void setSetUserUid(String setUserUid) {
        this.setUserUid = setUserUid;
    }

    /**
     * 获取设置人
     *
     * @return SetUserName - 设置人
     */
    public String getSetUserName() {
        return setUserName;
    }

    /**
     * 设置设置人
     *
     * @param setUserName 设置人
     */
    public void setSetUserName(String setUserName) {
        this.setUserName = setUserName;
    }

    /**
     * 获取设置日期
     *
     * @return SetTime - 设置日期
     */
    public Date getSetTime() {
        return setTime;
    }

    /**
     * 设置设置日期
     *
     * @param setTime 设置日期
     */
    public void setSetTime(Date setTime) {
        this.setTime = setTime;
    }

    /**
     * 获取设置人部门编码
     *
     * @return SetDeptcode - 设置人部门编码
     */
    public String getSetDeptcode() {
        return setDeptcode;
    }

    /**
     * 设置设置人部门编码
     *
     * @param setDeptcode 设置人部门编码
     */
    public void setSetDeptcode(String setDeptcode) {
        this.setDeptcode = setDeptcode;
    }

    /**
     * 获取设置人部门中文表述
     *
     * @return SetDeptName - 设置人部门中文表述
     */
    public String getSetDeptName() {
        return setDeptName;
    }

    /**
     * 设置设置人部门中文表述
     *
     * @param setDeptName 设置人部门中文表述
     */
    public void setSetDeptName(String setDeptName) {
        this.setDeptName = setDeptName;
    }

	public String getScPtype() {
		return scPtype;
	}

	public void setScPtype(String scPtype) {
		this.scPtype = scPtype;
	}

	public String getIsScVlid() {
		return isScVlid;
	}

	public void setIsScVlid(String isScVlid) {
		this.isScVlid = isScVlid;
	}

	public String getMarkName() {
		return markName;
	}

	public void setMarkName(String markName) {
		this.markName = markName;
	}

	public String getMarkCode() {
		return markCode;
	}

	public void setMarkCode(String markCode) {
		this.markCode = markCode;
	}
	
	
     
}