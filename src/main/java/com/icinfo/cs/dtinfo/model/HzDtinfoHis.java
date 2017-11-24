/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.dtinfo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.icinfo.framework.mybatis.mapper.annotation.Before;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * 描述:    cs_pub_hzdtinfo_his 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年06月20日
 */
@Table(name = "cs_pub_hzdtinfo_his")
public class HzDtinfoHis implements Serializable {
    @Id
    @Column(name = "id")
    private Integer id;
    
    /**
     * 唯一标识
     */
    @Column(name = "UID")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    private String UID;
    
    /**
     * 主体代码
     */
    @Column(name = "PriPID")
    private String priPID;
    
    /**
     * 统一社会信用代码
     */
    @Column(name = "UniSCID")
    private String uniSCID;
    
    /**
     * 企业名称
     */
    @Column(name = "EntName")
    private String entName;
    
    /**
     * 注册号
     */
    @Column(name = "RegNO")
    private String regNO;

    /**
     * 审批事项编码
     */
    @Column(name = "ExaCode")
    private String exaCode;

    /**
     * 审批事项名称
     */
    @Column(name = "ExaName")
    private String exaName;

    /**
     * 审批部门编码
     */
    @Column(name = "CheckDep")
    private String checkDep;
    
    /**
     * 内容
     */
    @Column(name = "Content")
    private String content;
    
    
    /**
     * 重新指派/回退帐号
     */
    @Column(name = "ReassignAccount")
    private String reassignAccount;

    /**
     * 重新指派/回退人姓名
     */
    @Column(name = "ReassignName")
    private String reassignName;

    /**
     * 重新指/回退派日期
     */
    @Column(name = "ReassignDate")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date reassignDate;
    
    /**
     * 重新指派/回退备注
     */
    @Column(name = "ReassignRemark")
    private String reassignRemark;
    
    /**
     * 操作类型 03认领 04 回退
     */
    @Column(name = "stateType")
    private String stateType;
    

    /**
     * 重新指派/回退执行部门名称
     */
    @Column(name = "ReassignDeptName")
    private String reassignDeptName;
    

    /**
     * 审批部门名称
     */
    @Column(name = "CheckDepName")
    private String checkDepName;

    /**
     * 推送日期
     */
    @Column(name = "CheckPushDate")
    private Date checkPushDate;

    /**
     * 认领账号
     */
    @Column(name = "ClaimCode")
    private String claimCode;

    /**
     * 认领名称
     */
    @Column(name = "ClaimName")
    private String claimName;

    /**
     * 认领日期
     */
    @Column(name = "ClaimDate")
    private Date claimDate;

    /**
     * 职能部门编码
     */
    @Column(name = "DutyDeptCode")
    private String dutyDeptCode;

    /**
     * 职能部门名称
     */
    @Column(name = "DutyDeptName")
    private String dutyDeptName;

    /**
     * 0-失败 1-成功
     */
    @Column(name = "IsMatch")
    private String isMatch;

    /**
     * 匹配信息
     */
    @Column(name = "MatchMsg")
    private String matchMsg;

    /**
     * 01-杭州 02-诸暨
     */
    @Column(name = "DistrictCode")
    private String districtCode;

    @Column(name = "DistrictName")
    private String districtName;
    
    /**
     * 企业登记事项
     */
    @Column(name = "CheckRegType")
    private String checkRegType;
    
    /**
     * 生成时间
     */
    @Column(name = "CreateTime")
    private Date createTime;
    
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
     * @return UID
     */
    public String getUID() {
        return UID;
    }

    /**
     * @param UID
     */
    public void setUID(String UID) {
        this.UID = UID;
    }

    /**
     * @return PriPID
     */
    public String getPriPID() {
        return priPID;
    }

    /**
     * @param priPID
     */
    public void setPriPID(String priPID) {
        this.priPID = priPID;
    }

    /**
     * @return UniSCID
     */
    public String getUniSCID() {
        return uniSCID;
    }

    /**
     * @param uniSCID
     */
    public void setUniSCID(String uniSCID) {
        this.uniSCID = uniSCID;
    }

    /**
     * @return EntName
     */
    public String getEntName() {
        return entName;
    }

    /**
     * @param entName
     */
    public void setEntName(String entName) {
        this.entName = entName;
    }

    /**
     * @return RegNO
     */
    public String getRegNO() {
        return regNO;
    }

    /**
     * @param regNO
     */
    public void setRegNO(String regNO) {
        this.regNO = regNO;
    }

    /**
     * 获取审批事项编码
     *
     * @return ExaCode - 审批事项编码
     */
    public String getExaCode() {
        return exaCode;
    }

    /**
     * 设置审批事项编码
     *
     * @param exaCode 审批事项编码
     */
    public void setExaCode(String exaCode) {
        this.exaCode = exaCode;
    }

    /**
     * 获取审批事项名称
     *
     * @return ExaName - 审批事项名称
     */
    public String getExaName() {
        return exaName;
    }

    /**
     * 设置审批事项名称
     *
     * @param exaName 审批事项名称
     */
    public void setExaName(String exaName) {
        this.exaName = exaName;
    }

    /**
     * 获取审批部门编码
     *
     * @return CheckDep - 审批部门编码
     */
    public String getCheckDep() {
        return checkDep;
    }

    /**
     * 设置审批部门编码
     *
     * @param checkDep 审批部门编码
     */
    public void setCheckDep(String checkDep) {
        this.checkDep = checkDep;
    }

    /**
     * 获取审批部门名称
     *
     * @return CheckDepName - 审批部门名称
     */
    public String getCheckDepName() {
        return checkDepName;
    }

    /**
     * 设置审批部门名称
     *
     * @param checkDepName 审批部门名称
     */
    public void setCheckDepName(String checkDepName) {
        this.checkDepName = checkDepName;
    }

    /**
     * 获取推送日期
     *
     * @return CheckPushDate - 推送日期
     */
    public Date getCheckPushDate() {
        return checkPushDate;
    }

    /**
     * 设置推送日期
     *
     * @param checkPushDate 推送日期
     */
    public void setCheckPushDate(Date checkPushDate) {
        this.checkPushDate = checkPushDate;
    }

    /**
     * 获取认领账号
     *
     * @return ClaimCode - 认领账号
     */
    public String getClaimCode() {
        return claimCode;
    }

    /**
     * 设置认领账号
     *
     * @param claimCode 认领账号
     */
    public void setClaimCode(String claimCode) {
        this.claimCode = claimCode;
    }

    /**
     * 获取认领名称
     *
     * @return ClaimName - 认领名称
     */
    public String getClaimName() {
        return claimName;
    }

    /**
     * 设置认领名称
     *
     * @param claimName 认领名称
     */
    public void setClaimName(String claimName) {
        this.claimName = claimName;
    }

    /**
     * 获取认领日期
     *
     * @return ClaimDate - 认领日期
     */
    public Date getClaimDate() {
        return claimDate;
    }

    /**
     * 设置认领日期
     *
     * @param claimDate 认领日期
     */
    public void setClaimDate(Date claimDate) {
        this.claimDate = claimDate;
    }

    /**
     * 获取职能部门编码
     *
     * @return DutyDeptCode - 职能部门编码
     */
    public String getDutyDeptCode() {
        return dutyDeptCode;
    }

    /**
     * 设置职能部门编码
     *
     * @param dutyDeptCode 职能部门编码
     */
    public void setDutyDeptCode(String dutyDeptCode) {
        this.dutyDeptCode = dutyDeptCode;
    }

    /**
     * 获取职能部门名称
     *
     * @return DutyDeptName - 职能部门名称
     */
    public String getDutyDeptName() {
        return dutyDeptName;
    }

    /**
     * 设置职能部门名称
     *
     * @param dutyDeptName 职能部门名称
     */
    public void setDutyDeptName(String dutyDeptName) {
        this.dutyDeptName = dutyDeptName;
    }

    /**
     * 获取0-失败 1-成功
     *
     * @return IsMatch - 0-失败 1-成功
     */
    public String getIsMatch() {
        return isMatch;
    }

    /**
     * 设置0-失败 1-成功
     *
     * @param isMatch 0-失败 1-成功
     */
    public void setIsMatch(String isMatch) {
        this.isMatch = isMatch;
    }

    /**
     * 获取匹配信息
     *
     * @return MatchMsg - 匹配信息
     */
    public String getMatchMsg() {
        return matchMsg;
    }

    /**
     * 设置匹配信息
     *
     * @param matchMsg 匹配信息
     */
    public void setMatchMsg(String matchMsg) {
        this.matchMsg = matchMsg;
    }

    /**
     * 获取0-杭州 1-诸暨
     *
     * @return DistrictCode - 0-杭州 1-诸暨
     */
    public String getDistrictCode() {
        return districtCode;
    }

    /**
     * 设置0-杭州 1-诸暨
     *
     * @param districtCode 0-杭州 1-诸暨
     */
    public void setDistrictCode(String districtCode) {
        this.districtCode = districtCode;
    }

    /**
     * @return DistrictName
     */
    public String getDistrictName() {
    	if(districtCode.equals("01")){
    		return "杭州";
    	}else if(districtCode.equals("02")){
    		return "诸暨";
    	}else{
    		return districtName;
    	}
    }

    /**
     * @param districtName
     */
    public void setDistrictName(String districtName) {
    	if(districtName.equals("01")){
    		this.districtName = "杭州";
    	}else if(districtName.equals("02")){
    		this.districtName = "诸暨";
    	}else{
    		this.districtName = null;
    	}
    }

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getCheckRegType() {
		return checkRegType;
	}

	public void setCheckRegType(String checkRegType) {
		this.checkRegType = checkRegType;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getReassignAccount() {
		return reassignAccount;
	}

	public void setReassignAccount(String reassignAccount) {
		this.reassignAccount = reassignAccount;
	}

	public String getReassignName() {
		return reassignName;
	}

	public void setReassignName(String reassignName) {
		this.reassignName = reassignName;
	}

	public Date getReassignDate() {
		return reassignDate;
	}

	public void setReassignDate(Date reassignDate) {
		this.reassignDate = reassignDate;
	}

	public String getReassignRemark() {
		return reassignRemark;
	}

	public void setReassignRemark(String reassignRemark) {
		this.reassignRemark = reassignRemark;
	}

	public String getReassignDeptName() {
		return reassignDeptName;
	}

	public void setReassignDeptName(String reassignDeptName) {
		this.reassignDeptName = reassignDeptName;
	}

	public String getStateType() {
		return stateType;
	}

	public void setStateType(String stateType) {
		this.stateType = stateType;
	} 
}