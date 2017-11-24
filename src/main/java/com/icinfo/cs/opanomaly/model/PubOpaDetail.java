/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.opanomaly.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.icinfo.framework.mybatis.mapper.annotation.Before;

/**
 * 描述:    cs_pub_opadetail 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2016年10月11日
 */
@Table(name = "cs_pub_opadetail")
public class PubOpaDetail implements Serializable {
    /**
     * 自增主键ID
     */
    @Id
    @Column(name = "id")
    private Integer id;

    /**
     * 主体身份代码
     */
    @Column(name = "PriPID")
    private String priPID;

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
     * 统一社会信用代码
     */
    @Column(name = "UniSCID")
    private String uniSCID;

    /**
     * 法定代表人
     */
    @Column(name = "LeRep")
    private String leRep;

    /**
     * 证件类型
     */
    @Column(name = "CerType")
    private String cerType;

    /**
     * 证件号码
     */
    @Column(name = "CerNO")
    private String cerNO;

    /**
     * 登记机关
     */
    @Column(name = "RegOrg")
    private String regOrg;

    /**
     * 属地监管工商所
     */
    @Column(name = "LocalAdm")
    private String localAdm;

    /**
     * 列入经营异常名录原因类型（中文名称）
     */
    @Column(name = "SpeCauseCN")
    private String speCauseCN;

    /**
     * 列入经营异常名录原因类型
     */
    @Column(name = "SpeCause")
    private String speCause;

    /**
     * 列入日期
     */
    @Column(name = "AbnTime")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date abnTime;

    /**
     * 列入决定机关
     */
    @Column(name = "DecOrg")
    private String decOrg;

    /**
     * 列入决定机关（中文名称）
     */
    @Column(name = "DecorgCN")
    private String decorgCN;

    /**
     * 是否移出/撤销（1：移出；2：撤销）
     */
    @Column(name = "IsMove")
    private String isMove;

    /**
     * 移出经营异常名录原因（中文名称）
     */
    @Column(name = "RemExcpresCN")
    private String remExcpresCN;

    /**
     * 移出经营异常名录原因
     */
    @Column(name = "RemExcpres")
    private String remExcpres;

    /**
     * 移出/撤销日期
     */
    @Column(name = "RemDate")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date remDate;

    /**
     * 移出/撤销决定机关（中文名称）
     */
    @Column(name = "ReDecOrgCN")
    private String reDecOrgCN;

    /**
     * 移出/撤销决定机关
     */
    @Column(name = "ReDecOrg")
    private String reDecOrg;

    /**
     * 移出/撤销事实和事由
     */
    @Column(name = "RemoveRea")
    private String removeRea;

    /**
     * 初审部门
     */
    @Column(name = "FirstDept")
    private String firstDept;

    /**
     * 初审人员
     */
    @Column(name = "FirstName")
    private String firstName;

    /**
     * 初审日期
     */
    @Column(name = "Firstdate")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date firstdate;

    /**
     * 初审意见
     */
    @Column(name = "FirstOpin")
    private String firstOpin;

    /**
     * 审核部门
     */
    @Column(name = "AuditDept")
    private String auditDept;

    /**
     * 审核人员
     */
    @Column(name = "AuditName")
    private String auditName;

    /**
     * 审核日期
     */
    @Column(name = "AuditDate")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date auditDate;

    /**
     * 审核意见
     */
    @Column(name = "AuditOpin")
    private String auditOpin;

    /**
     * 审核状态0：待审核1：同意移除2：不予移除
     */
    @Column(name = "AuditState")
    private String auditState;

    /**
     * 处罚文号 如：浙杭上工商移出【2014】第00001号
     */
    @Column(name = "PenDecNo")
    private String penDecNo;

    /**
     * 年度
     */
    @Column(name = "Year")
    private Integer year;

    /**
     * 序号年度
     */
    @Column(name = "SeqYear")
    private Integer seqYear;

    /**
     * 部门名称
     */
    @Column(name = "DeptName")
    private String deptName;

    /**
     * 上级机关名称
     */
    @Column(name = "DeptUpName")
    private String deptUpName;

    /**
     * 同级人民法院
     */
    @Column(name = "DeptSameCourt")
    private String deptSameCourt;

    /**
     * 同级人民政府
     */
    @Column(name = "DeptSameGov")
    private String deptSameGov;

    /**
     * 企业类型
     */
    @Column(name = "EntTypeCatg")
    private String entTypeCatg;

    /**
     * 时间戳
     */
    @Column(name = "CreateTime") 
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;

    /**
     * 主键UUID
     */
    @Column(name = "BusExcList")
    private String busExcList;

    private static final long serialVersionUID = 1L;

    /**
     * 获取自增主键ID
     *
     * @return id - 自增主键ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置自增主键ID
     *
     * @param id 自增主键ID
     */
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
     * 获取证件类型
     *
     * @return CerType - 证件类型
     */
    public String getCerType() {
        return cerType;
    }

    /**
     * 设置证件类型
     *
     * @param cerType 证件类型
     */
    public void setCerType(String cerType) {
        this.cerType = cerType;
    }

    /**
     * 获取证件号码
     *
     * @return CerNO - 证件号码
     */
    public String getCerNO() {
        return cerNO;
    }

    /**
     * 设置证件号码
     *
     * @param cerNO 证件号码
     */
    public void setCerNO(String cerNO) {
        this.cerNO = cerNO;
    }

    /**
     * 获取登记机关
     *
     * @return RegOrg - 登记机关
     */
    public String getRegOrg() {
        return regOrg;
    }

    /**
     * 设置登记机关
     *
     * @param regOrg 登记机关
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
     * 获取列入经营异常名录原因类型（中文名称）
     *
     * @return SpeCauseCN - 列入经营异常名录原因类型（中文名称）
     */
    public String getSpeCauseCN() {
        return speCauseCN;
    }

    /**
     * 设置列入经营异常名录原因类型（中文名称）
     *
     * @param speCauseCN 列入经营异常名录原因类型（中文名称）
     */
    public void setSpeCauseCN(String speCauseCN) {
        this.speCauseCN = speCauseCN;
    }

    /**
     * 获取列入经营异常名录原因类型
     *
     * @return SpeCause - 列入经营异常名录原因类型
     */
    public String getSpeCause() {
        return speCause;
    }

    /**
     * 设置列入经营异常名录原因类型
     *
     * @param speCause 列入经营异常名录原因类型
     */
    public void setSpeCause(String speCause) {
        this.speCause = speCause;
    }

    /**
     * 获取列入日期
     *
     * @return AbnTime - 列入日期
     */
    public Date getAbnTime() {
        return abnTime;
    }

    /**
     * 设置列入日期
     *
     * @param abnTime 列入日期
     */
    public void setAbnTime(Date abnTime) {
        this.abnTime = abnTime;
    }

    /**
     * 获取列入决定机关
     *
     * @return DecOrg - 列入决定机关
     */
    public String getDecOrg() {
        return decOrg;
    }

    /**
     * 设置列入决定机关
     *
     * @param decOrg 列入决定机关
     */
    public void setDecOrg(String decOrg) {
        this.decOrg = decOrg;
    }

    /**
     * 获取列入决定机关（中文名称）
     *
     * @return DecorgCN - 列入决定机关（中文名称）
     */
    public String getDecorgCN() {
        return decorgCN;
    }

    /**
     * 设置列入决定机关（中文名称）
     *
     * @param decorgCN 列入决定机关（中文名称）
     */
    public void setDecorgCN(String decorgCN) {
        this.decorgCN = decorgCN;
    }

    /**
     * 获取是否移出/撤销（1：移出；2：撤销）
     *
     * @return IsMove - 是否移出/撤销（1：移出；2：撤销）
     */
    public String getIsMove() {
        return isMove;
    }

    /**
     * 设置是否移出/撤销（1：移出；2：撤销）
     *
     * @param isMove 是否移出/撤销（1：移出；2：撤销）
     */
    public void setIsMove(String isMove) {
        this.isMove = isMove;
    }

    /**
     * 获取移出经营异常名录原因（中文名称）
     *
     * @return RemExcpresCN - 移出经营异常名录原因（中文名称）
     */
    public String getRemExcpresCN() {
        return remExcpresCN;
    }

    /**
     * 设置移出经营异常名录原因（中文名称）
     *
     * @param remExcpresCN 移出经营异常名录原因（中文名称）
     */
    public void setRemExcpresCN(String remExcpresCN) {
        this.remExcpresCN = remExcpresCN;
    }

    /**
     * 获取移出经营异常名录原因
     *
     * @return RemExcpres - 移出经营异常名录原因
     */
    public String getRemExcpres() {
        return remExcpres;
    }

    /**
     * 设置移出经营异常名录原因
     *
     * @param remExcpres 移出经营异常名录原因
     */
    public void setRemExcpres(String remExcpres) {
        this.remExcpres = remExcpres;
    }

    /**
     * 获取移出/撤销日期
     *
     * @return RemDate - 移出/撤销日期
     */
    public Date getRemDate() {
        return remDate;
    }

    /**
     * 设置移出/撤销日期
     *
     * @param remDate 移出/撤销日期
     */
    public void setRemDate(Date remDate) {
        this.remDate = remDate;
    }

    /**
     * 获取移出/撤销决定机关（中文名称）
     *
     * @return ReDecOrgCN - 移出/撤销决定机关（中文名称）
     */
    public String getReDecOrgCN() {
        return reDecOrgCN;
    }

    /**
     * 设置移出/撤销决定机关（中文名称）
     *
     * @param reDecOrgCN 移出/撤销决定机关（中文名称）
     */
    public void setReDecOrgCN(String reDecOrgCN) {
        this.reDecOrgCN = reDecOrgCN;
    }

    /**
     * 获取移出/撤销决定机关
     *
     * @return ReDecOrg - 移出/撤销决定机关
     */
    public String getReDecOrg() {
        return reDecOrg;
    }

    /**
     * 设置移出/撤销决定机关
     *
     * @param reDecOrg 移出/撤销决定机关
     */
    public void setReDecOrg(String reDecOrg) {
        this.reDecOrg = reDecOrg;
    }

    /**
     * 获取移出/撤销事实和事由
     *
     * @return RemoveRea - 移出/撤销事实和事由
     */
    public String getRemoveRea() {
        return removeRea;
    }

    /**
     * 设置移出/撤销事实和事由
     *
     * @param removeRea 移出/撤销事实和事由
     */
    public void setRemoveRea(String removeRea) {
        this.removeRea = removeRea;
    }

    /**
     * 获取初审部门
     *
     * @return FirstDept - 初审部门
     */
    public String getFirstDept() {
        return firstDept;
    }

    /**
     * 设置初审部门
     *
     * @param firstDept 初审部门
     */
    public void setFirstDept(String firstDept) {
        this.firstDept = firstDept;
    }

    /**
     * 获取初审人员
     *
     * @return FirstName - 初审人员
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * 设置初审人员
     *
     * @param firstName 初审人员
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * 获取初审日期
     *
     * @return Firstdate - 初审日期
     */
    public Date getFirstdate() {
        return firstdate;
    }

    /**
     * 设置初审日期
     *
     * @param firstdate 初审日期
     */
    public void setFirstdate(Date firstdate) {
        this.firstdate = firstdate;
    }

    /**
     * 获取初审意见
     *
     * @return FirstOpin - 初审意见
     */
    public String getFirstOpin() {
        return firstOpin;
    }

    /**
     * 设置初审意见
     *
     * @param firstOpin 初审意见
     */
    public void setFirstOpin(String firstOpin) {
        this.firstOpin = firstOpin;
    }

    /**
     * 获取审核部门
     *
     * @return AuditDept - 审核部门
     */
    public String getAuditDept() {
        return auditDept;
    }

    /**
     * 设置审核部门
     *
     * @param auditDept 审核部门
     */
    public void setAuditDept(String auditDept) {
        this.auditDept = auditDept;
    }

    /**
     * 获取审核人员
     *
     * @return AuditName - 审核人员
     */
    public String getAuditName() {
        return auditName;
    }

    /**
     * 设置审核人员
     *
     * @param auditName 审核人员
     */
    public void setAuditName(String auditName) {
        this.auditName = auditName;
    }

    /**
     * 获取审核日期
     *
     * @return AuditDate - 审核日期
     */
    public Date getAuditDate() {
        return auditDate;
    }

    /**
     * 设置审核日期
     *
     * @param auditDate 审核日期
     */
    public void setAuditDate(Date auditDate) {
        this.auditDate = auditDate;
    }

    /**
     * 获取审核意见
     *
     * @return AuditOpin - 审核意见
     */
    public String getAuditOpin() {
        return auditOpin;
    }

    /**
     * 设置审核意见
     *
     * @param auditOpin 审核意见
     */
    public void setAuditOpin(String auditOpin) {
        this.auditOpin = auditOpin;
    }

    /**
     * 获取审核状态0：待审核1：同意移除2：不予移除
     *
     * @return AuditState - 审核状态0：待审核1：同意移除2：不予移除
     */
    public String getAuditState() {
        return auditState;
    }

    /**
     * 设置审核状态0：待审核1：同意移除2：不予移除
     *
     * @param auditState 审核状态0：待审核1：同意移除2：不予移除
     */
    public void setAuditState(String auditState) {
        this.auditState = auditState;
    }

    /**
     * 获取处罚文号 如：浙杭上工商移出【2014】第00001号
     *
     * @return PenDecNo - 处罚文号 如：浙杭上工商移出【2014】第00001号
     */
    public String getPenDecNo() {
        return penDecNo;
    }

    /**
     * 设置处罚文号 如：浙杭上工商移出【2014】第00001号
     *
     * @param penDecNo 处罚文号 如：浙杭上工商移出【2014】第00001号
     */
    public void setPenDecNo(String penDecNo) {
        this.penDecNo = penDecNo;
    }

    /**
     * 获取年度
     *
     * @return Year - 年度
     */
    public Integer getYear() {
        return year;
    }

    /**
     * 设置年度
     *
     * @param year 年度
     */
    public void setYear(Integer year) {
        this.year = year;
    }

    /**
     * 获取序号年度
     *
     * @return SeqYear - 序号年度
     */
    public Integer getSeqYear() {
        return seqYear;
    }

    /**
     * 设置序号年度
     *
     * @param seqYear 序号年度
     */
    public void setSeqYear(Integer seqYear) {
        this.seqYear = seqYear;
    }

    /**
     * 获取部门名称
     *
     * @return DeptName - 部门名称
     */
    public String getDeptName() {
        return deptName;
    }

    /**
     * 设置部门名称
     *
     * @param deptName 部门名称
     */
    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    /**
     * 获取上级机关名称
     *
     * @return DeptUpName - 上级机关名称
     */
    public String getDeptUpName() {
        return deptUpName;
    }

    /**
     * 设置上级机关名称
     *
     * @param deptUpName 上级机关名称
     */
    public void setDeptUpName(String deptUpName) {
        this.deptUpName = deptUpName;
    }

    /**
     * 获取同级人民法院
     *
     * @return DeptSameCourt - 同级人民法院
     */
    public String getDeptSameCourt() {
        return deptSameCourt;
    }

    /**
     * 设置同级人民法院
     *
     * @param deptSameCourt 同级人民法院
     */
    public void setDeptSameCourt(String deptSameCourt) {
        this.deptSameCourt = deptSameCourt;
    }

    /**
     * 获取同级人民政府
     *
     * @return DeptSameGov - 同级人民政府
     */
    public String getDeptSameGov() {
        return deptSameGov;
    }

    /**
     * 设置同级人民政府
     *
     * @param deptSameGov 同级人民政府
     */
    public void setDeptSameGov(String deptSameGov) {
        this.deptSameGov = deptSameGov;
    }

    /**
     * 获取企业类型
     *
     * @return EntTypeCatg - 企业类型
     */
    public String getEntTypeCatg() {
        return entTypeCatg;
    }

    /**
     * 设置企业类型
     *
     * @param entTypeCatg 企业类型
     */
    public void setEntTypeCatg(String entTypeCatg) {
        this.entTypeCatg = entTypeCatg;
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

    /**
     * 获取主键UUID
     *
     * @return BusExcList - 主键UUID
     */
    public String getBusExcList() {
        return busExcList;
    }

    /**
     * 设置主键UUID
     *
     * @param busExcList 主键UUID
     */
    public void setBusExcList(String busExcList) {
        this.busExcList = busExcList;
    }
}