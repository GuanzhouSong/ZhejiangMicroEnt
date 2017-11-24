/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.dzdtinfo.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.icinfo.framework.mybatis.mapper.annotation.Before;

/**
 * 描述:    cs_pub_dz_dtinfo 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2016年10月18日
 */
@Table(name = "cs_pub_dz_dtinfo")
public class PubDzDtInfo implements Serializable {
    /**
     * 主键ID
     */
    @Id
    @Column(name = "id") 
    private Integer id;
    
    @Column(name = "ClaimUserId") 
    private String  claimUserId;
    
    @Column(name = "ReassignUserId") 
    private String  reassignUserId;
    
    
    @Column(name = "AcceptUserId") 
    private String  acceptUserId;
    

    /**
     * UID
     */
    @Column(name = "UID")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    private String uid;

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
     * 法定代表人
     */
    @Column(name = "LeRep")
    private String leRep;

    /**
     * 联系电话
     */
    @Column(name = "Tel")
    private String tel;

    /**
     * 成立日期
     */
    @Column(name = "EstDate")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date estDate;

    /**
     * 注册资本(金)
     */
    @Column(name = "RegCap")
    private BigDecimal regCap;

    /**
     * 住所
     */
    @Column(name = "Dom")
    private String dom;

    /**
     * 经营(驻在)期限至
     */
    @Column(name = "OpTo")
    private Date opTo;

    /**
     * 核准日期
     */
    @Column(name = "ApprDate")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date apprDate;

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
     * 住所所在行政区划(CA01)
     */
    @Column(name = "DomDistrict")
    private String domDistrict;

    /**
     * 乡镇街道
     */
    @Column(name = "Street")
    private String street;

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
     * 登记状态(CA19)
     */
    @Column(name = "RegState")
    private String regState;

    /**
     * 抽检部门
     */
    @Column(name = "CheckDep")
    private String checkDep;
    
    /**
     *审批部门名称
     */
    @Column(name = "CheckDepName")
    private String checkDepName;
    
    

    /**
     * 市场主体类型大类
     */
    @Column(name = "EntTypeCatg")
    private String entTypeCatg;

    /**
     * 市场主体类型(CA16)
     */
    @Column(name = "EntType")
    private String entType;

    /**
     * 地区
     */
    @Column(name = "Area")
    private String area;
    
    /**
    * 地区名称
    */
    @Column(name = "AreaName")
    private String areaName;
    
    
    

    /**
     * 企业登记事项 1：新设； 2：变更
     */
    @Column(name = "CheckRegType")
    private String checkRegType;

    /**
     * 分流状态 0：未分流； 1自动分流； 2：手动分流，3分流失败
     */
    @Column(name = "CheckPushType")
    private String checkPushType;

    /**
     * 分流日期
     */
    @Column(name = "CheckPushDate")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date checkPushDate;

    /**
     * 推送机关类型 1：审批； 2：属地； 3：同级
     */
    @Column(name = "CheckDeptType")
    private String checkDeptType;

    /**
     * 接收人帐号
     */
    @Column(name = "AcceptUser")
    private String acceptUser;

    /**
     * 接收人姓名
     */
    @Column(name = "AcceptName")
    private String acceptName;

    /**
     * 接收日期
     */
    @Column(name = "AcceptDate")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date acceptDate;

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
     * 重新指派类型 1：重新指派； 2：回退；
     */
    @Column(name = "ReassignType")
    private String reassignType;

    /**
     * 重新指派/回退备注
     */
    @Column(name = "ReassignRemark")
    private String reassignRemark;

    /**
     * 重新指派/回退执行部门名称
     */
    @Column(name = "ReassignDeptName")
    private String reassignDeptName;

    /**
     * 重新指派/回退理由（编码）
     */
    @Column(name = "ReassignCode")
    private String reassignCode;

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
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date claimDate;

    /**
     * 是否接收 1：是； 0：否；
     */
    @Column(name = "ReceiveState")
    private String receiveState;

    /**
     * 是否认领 1：是； 0：否；
     */
    @Column(name = "ClaimState")
    private String claimState;

    /**
     * 是否个转企
     */
    @Column(name = "IsIndivid")
    private String isIndivid;

    /**
     * 行业代码
     */
    @Column(name = "IndustryCo")
    private String industryCo;

    /**
     * 是否终止：0,否；1，是
     */
    @Column(name = "checkStopState")
    private String checkStopState;

    /**
     * 时间戳
     */
    @Column(name = "CreateTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;

    /**
     * 经营方式
     */
    @Column(name = "OpFrom")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date opFrom;

    /**
     * 经营范围
     */
    @Column(name = "OpScope")
    private String opScope;
    
    
    /**
     * 职能部门名称
     */
    @Column(name = "DutyDeptName")
    private String dutyDeptName;
    
    
    /**
     * 职能部门编码
     */
    @Column(name = "DutyDeptCode")
    private String dutyDeptCode;
    
    /**
     * 对应部门名称
     */
    @Column(name = "DeptName")
    private String deptName;
    
    /**
     * 对应部门编码
     */
    @Column(name = "DeptCode")
    private String deptCode;
    
    

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
     * 获取统一社会信用代码
     *
     * @return UniSCID - 统一社会信用代码
     */
    public String getUniSCID() {
        return uniSCID;
    }

    /**
     * 设置统一社会信用代码
     *
     * @param uniSCID 统一社会信用代码
     */
    public void setUniSCID(String uniSCID) {
        this.uniSCID = uniSCID;
    }

    /**
     * 获取企业名称
     *
     * @return EntName - 企业名称
     */
    public String getEntName() {
        return entName;
    }

    /**
     * 设置企业名称
     *
     * @param entName 企业名称
     */
    public void setEntName(String entName) {
        this.entName = entName;
    }

    /**
     * 获取注册号
     *
     * @return RegNO - 注册号
     */
    public String getRegNO() {
        return regNO;
    }

    /**
     * 设置注册号
     *
     * @param regNO 注册号
     */
    public void setRegNO(String regNO) {
        this.regNO = regNO;
    }

    /**
     * 获取法定代表人
     *
     * @return LeRep - 法定代表人
     */
    public String getLeRep() {
        return leRep;
    }

    /**
     * 设置法定代表人
     *
     * @param leRep 法定代表人
     */
    public void setLeRep(String leRep) {
        this.leRep = leRep;
    }

    /**
     * 获取联系电话
     *
     * @return Tel - 联系电话
     */
    public String getTel() {
        return tel;
    }

    /**
     * 设置联系电话
     *
     * @param tel 联系电话
     */
    public void setTel(String tel) {
        this.tel = tel;
    }

    /**
     * 获取成立日期
     *
     * @return EstDate - 成立日期
     */
    public Date getEstDate() {
        return estDate;
    }

    /**
     * 设置成立日期
     *
     * @param estDate 成立日期
     */
    public void setEstDate(Date estDate) {
        this.estDate = estDate;
    }

    /**
     * 获取注册资本(金)
     *
     * @return RegCap - 注册资本(金)
     */
    public BigDecimal getRegCap() {
        return regCap;
    }

    /**
     * 设置注册资本(金)
     *
     * @param regCap 注册资本(金)
     */
    public void setRegCap(BigDecimal regCap) {
        this.regCap = regCap;
    }

    /**
     * 获取住所
     *
     * @return Dom - 住所
     */
    public String getDom() {
        return dom;
    }

    /**
     * 设置住所
     *
     * @param dom 住所
     */
    public void setDom(String dom) {
        this.dom = dom;
    }

    /**
     * 获取经营(驻在)期限至
     *
     * @return OpTo - 经营(驻在)期限至
     */
    public Date getOpTo() {
        return opTo;
    }

    /**
     * 设置经营(驻在)期限至
     *
     * @param opTo 经营(驻在)期限至
     */
    public void setOpTo(Date opTo) {
        this.opTo = opTo;
    }

    /**
     * 获取核准日期
     *
     * @return ApprDate - 核准日期
     */
    public Date getApprDate() {
        return apprDate;
    }

    /**
     * 设置核准日期
     *
     * @param apprDate 核准日期
     */
    public void setApprDate(Date apprDate) {
        this.apprDate = apprDate;
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
     * 获取住所所在行政区划(CA01)
     *
     * @return DomDistrict - 住所所在行政区划(CA01)
     */
    public String getDomDistrict() {
        return domDistrict;
    }

    /**
     * 设置住所所在行政区划(CA01)
     *
     * @param domDistrict 住所所在行政区划(CA01)
     */
    public void setDomDistrict(String domDistrict) {
        this.domDistrict = domDistrict;
    }

    /**
     * 获取乡镇街道
     *
     * @return Street - 乡镇街道
     */
    public String getStreet() {
        return street;
    }

    /**
     * 设置乡镇街道
     *
     * @param street 乡镇街道
     */
    public void setStreet(String street) {
        this.street = street;
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
     * 获取抽检部门
     *
     * @return CheckDep - 抽检部门
     */
    public String getCheckDep() {
        return checkDep;
    }

    /**
     * 设置抽检部门
     *
     * @param checkDep 抽检部门
     */
    public void setCheckDep(String checkDep) {
        this.checkDep = checkDep;
    }

    /**
     * 获取市场主体类型大类
     *
     * @return EntTypeCatg - 市场主体类型大类
     */
    public String getEntTypeCatg() {
        return entTypeCatg;
    }

    /**
     * 设置市场主体类型大类
     *
     * @param entTypeCatg 市场主体类型大类
     */
    public void setEntTypeCatg(String entTypeCatg) {
        this.entTypeCatg = entTypeCatg;
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
     * 获取地区
     *
     * @return Area - 地区
     */
    public String getArea() {
        return area;
    }

    /**
     * 设置地区
     *
     * @param area 地区
     */
    public void setArea(String area) {
        this.area = area;
    }

    /**
     * 获取企业登记事项 1：新设； 2：变更
     *
     * @return CheckRegType - 企业登记事项 1：新设； 2：变更
     */
    public String getCheckRegType() {
        return checkRegType;
    }

    /**
     * 设置企业登记事项 1：新设； 2：变更
     *
     * @param checkRegType 企业登记事项 1：新设； 2：变更
     */
    public void setCheckRegType(String checkRegType) {
        this.checkRegType = checkRegType;
    }

    /**
     * 获取分流状态 0：未分流； 1自动分流； 2：手动分流，3分流失败
     *
     * @return CheckPushType - 分流状态 0：未分流； 1自动分流； 2：手动分流，3分流失败
     */
    public String getCheckPushType() {
        return checkPushType;
    }

    /**
     * 设置分流状态 0：未分流； 1自动分流； 2：手动分流，3分流失败
     *
     * @param checkPushType 分流状态 0：未分流； 1自动分流； 2：手动分流，3分流失败
     */
    public void setCheckPushType(String checkPushType) {
        this.checkPushType = checkPushType;
    }

    /**
     * 获取分流日期
     *
     * @return CheckPushDate - 分流日期
     */
    public Date getCheckPushDate() {
        return checkPushDate;
    }

    /**
     * 设置分流日期
     *
     * @param checkPushDate 分流日期
     */
    public void setCheckPushDate(Date checkPushDate) {
        this.checkPushDate = checkPushDate;
    }

    /**
     * 获取推送机关类型 1：审批； 2：属地； 3：同级
     *
     * @return CheckDeptType - 推送机关类型 1：审批； 2：属地； 3：同级
     */
    public String getCheckDeptType() {
        return checkDeptType;
    }

    /**
     * 设置推送机关类型 1：审批； 2：属地； 3：同级
     *
     * @param checkDeptType 推送机关类型 1：审批； 2：属地； 3：同级
     */
    public void setCheckDeptType(String checkDeptType) {
        this.checkDeptType = checkDeptType;
    }

    /**
     * 获取接收人帐号
     *
     * @return AcceptUser - 接收人帐号
     */
    public String getAcceptUser() {
        return acceptUser;
    }

    /**
     * 设置接收人帐号
     *
     * @param acceptUser 接收人帐号
     */
    public void setAcceptUser(String acceptUser) {
        this.acceptUser = acceptUser;
    }

    /**
     * 获取接收人姓名
     *
     * @return AcceptName - 接收人姓名
     */
    public String getAcceptName() {
        return acceptName;
    }

    /**
     * 设置接收人姓名
     *
     * @param acceptName 接收人姓名
     */
    public void setAcceptName(String acceptName) {
        this.acceptName = acceptName;
    }

    /**
     * 获取接收日期
     *
     * @return AcceptDate - 接收日期
     */
    public Date getAcceptDate() {
        return acceptDate;
    }

    /**
     * 设置接收日期
     *
     * @param acceptDate 接收日期
     */
    public void setAcceptDate(Date acceptDate) {
        this.acceptDate = acceptDate;
    }

    /**
     * 获取重新指派/回退帐号
     *
     * @return ReassignAccount - 重新指派/回退帐号
     */
    public String getReassignAccount() {
        return reassignAccount;
    }

    /**
     * 设置重新指派/回退帐号
     *
     * @param reassignAccount 重新指派/回退帐号
     */
    public void setReassignAccount(String reassignAccount) {
        this.reassignAccount = reassignAccount;
    }

    /**
     * 获取重新指派/回退人姓名
     *
     * @return ReassignName - 重新指派/回退人姓名
     */
    public String getReassignName() {
        return reassignName;
    }

    /**
     * 设置重新指派/回退人姓名
     *
     * @param reassignName 重新指派/回退人姓名
     */
    public void setReassignName(String reassignName) {
        this.reassignName = reassignName;
    }

    /**
     * 获取重新指/回退派日期
     *
     * @return ReassignDate - 重新指/回退派日期
     */
    public Date getReassignDate() {
        return reassignDate;
    }

    /**
     * 设置重新指/回退派日期
     *
     * @param reassignDate 重新指/回退派日期
     */
    public void setReassignDate(Date reassignDate) {
        this.reassignDate = reassignDate;
    }

    /**
     * 获取重新指派类型 1：重新指派； 2：回退；
     *
     * @return ReassignType - 重新指派类型 1：重新指派； 2：回退；
     */
    public String getReassignType() {
        return reassignType;
    }

    /**
     * 设置重新指派类型 1：重新指派； 2：回退；
     *
     * @param reassignType 重新指派类型 1：重新指派； 2：回退；
     */
    public void setReassignType(String reassignType) {
        this.reassignType = reassignType;
    }

    /**
     * 获取重新指派/回退备注
     *
     * @return ReassignRemark - 重新指派/回退备注
     */
    public String getReassignRemark() {
        return reassignRemark;
    }

    /**
     * 设置重新指派/回退备注
     *
     * @param reassignRemark 重新指派/回退备注
     */
    public void setReassignRemark(String reassignRemark) {
        this.reassignRemark = reassignRemark;
    }

    /**
     * 获取重新指派/回退执行部门名称
     *
     * @return ReassignDeptName - 重新指派/回退执行部门名称
     */
    public String getReassignDeptName() {
        return reassignDeptName;
    }

    /**
     * 设置重新指派/回退执行部门名称
     *
     * @param reassignDeptName 重新指派/回退执行部门名称
     */
    public void setReassignDeptName(String reassignDeptName) {
        this.reassignDeptName = reassignDeptName;
    }

    /**
     * 获取重新指派/回退理由（编码）
     *
     * @return ReassignCode - 重新指派/回退理由（编码）
     */
    public String getReassignCode() {
        return reassignCode;
    }

    /**
     * 设置重新指派/回退理由（编码）
     *
     * @param reassignCode 重新指派/回退理由（编码）
     */
    public void setReassignCode(String reassignCode) {
        this.reassignCode = reassignCode;
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
     * 获取是否接收 1：是； 0：否；
     *
     * @return ReceiveState - 是否接收 1：是； 0：否；
     */
    public String getReceiveState() {
        return receiveState;
    }

    /**
     * 设置是否接收 1：是； 0：否；
     *
     * @param receiveState 是否接收 1：是； 0：否；
     */
    public void setReceiveState(String receiveState) {
        this.receiveState = receiveState;
    }

    /**
     * 获取是否认领 1：是； 0：否；
     *
     * @return ClaimState - 是否认领 1：是； 0：否；
     */
    public String getClaimState() {
        return claimState;
    }

    /**
     * 设置是否认领 1：是； 0：否；
     *
     * @param claimState 是否认领 1：是； 0：否；
     */
    public void setClaimState(String claimState) {
        this.claimState = claimState;
    }

    /**
     * 获取是否个转企
     *
     * @return IsIndivid - 是否个转企
     */
    public String getIsIndivid() {
        return isIndivid;
    }

    /**
     * 设置是否个转企
     *
     * @param isIndivid 是否个转企
     */
    public void setIsIndivid(String isIndivid) {
        this.isIndivid = isIndivid;
    }

    /**
     * 获取行业代码
     *
     * @return IndustryCo - 行业代码
     */
    public String getIndustryCo() {
        return industryCo;
    }

    /**
     * 设置行业代码
     *
     * @param industryCo 行业代码
     */
    public void setIndustryCo(String industryCo) {
        this.industryCo = industryCo;
    }

    /**
     * 获取是否终止：0,否；1，是
     *
     * @return checkStopState - 是否终止：0,否；1，是
     */
    public String getCheckStopState() {
        return checkStopState;
    }

    /**
     * 设置是否终止：0,否；1，是
     *
     * @param checkStopState 是否终止：0,否；1，是
     */
    public void setCheckStopState(String checkStopState) {
        this.checkStopState = checkStopState;
    }

    /**
     * 获取时间戳
     *
     * @return CreateTime - 时间戳
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置时间戳
     *
     * @param createTime 时间戳
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    

    public Date getOpFrom() {
		return opFrom;
	}

	public void setOpFrom(Date opFrom) {
		this.opFrom = opFrom;
	}

	/**
     * 获取经营范围
     *
     * @return OpScope - 经营范围
     */
    public String getOpScope() {
        return opScope;
    }

    /**
     * 设置经营范围
     *
     * @param opScope 经营范围
     */
    public void setOpScope(String opScope) {
        this.opScope = opScope;
    }
    
    public void setUid(String uid) {
		this.uid = uid;
	}  
     public String getUid() {
		return uid;
	}

	public String getCheckDepName() {
		return checkDepName;
	}

	public void setCheckDepName(String checkDepName) {
		this.checkDepName = checkDepName;
	}

	public String getDutyDeptName() {
		return dutyDeptName;
	}

	public void setDutyDeptName(String dutyDeptName) {
		this.dutyDeptName = dutyDeptName;
	}

	public String getDutyDeptCode() {
		return dutyDeptCode;
	}

	public void setDutyDeptCode(String dutyDeptCode) {
		this.dutyDeptCode = dutyDeptCode;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getDeptCode() {
		return deptCode;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}

	public String getClaimUserId() {
		return claimUserId;
	}

	public void setClaimUserId(String claimUserId) {
		this.claimUserId = claimUserId;
	}

	public String getReassignUserId() {
		return reassignUserId;
	}

	public void setReassignUserId(String reassignUserId) {
		this.reassignUserId = reassignUserId;
	}

	public String getAcceptUserId() {
		return acceptUserId;
	}

	public void setAcceptUserId(String acceptUserId) {
		this.acceptUserId = acceptUserId;
	}
}