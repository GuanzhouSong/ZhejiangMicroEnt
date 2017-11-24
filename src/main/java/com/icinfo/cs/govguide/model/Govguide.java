/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.govguide.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.icinfo.framework.mybatis.mapper.annotation.Before;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * 描述:  cs_govguide_set 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2016年10月19日
 */
@Table(name = "cs_govguide_set")
public class Govguide implements Serializable {
    /**
     * 自增ID
     */
    @Id
    @Column(name = "id")
    private Integer id;

    /**
     * 随机UUID
     */
    @Column(name = "UID")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    private String uid;

    /**
     * 注册号
     */
    @Column(name = "RegNo")
    private String regno;
    /**
     * 注册号
     */
    @Column(name = "PriPID")
    private String pripid;

    /**
     * 统一代码
     */
    @Column(name = "UniSCID")
    private String uniscid;

    /**
     * 企业名称
     */
    @Column(name = "EntName")
    private String entname;

    /**
     * 登记机关
     */
    @Column(name = "RegOrg")
    private String regorg;

    /**
     * 登记机关名称
     */
    @Column(name = "RegOrgName")
    private String regorgname;

    /**
     * 管辖单位
     */
    @Column(name = "LocalAdm")
    private String localadm;

    /**
     * 管辖单位名称
     */
    @Column(name = "LocalAdmName")
    private String localadmname;
    /**
     * 审核意见
     */
    @Column(name = "AuditRemark")
    private String auditremark;

    /**
     * 申请人
     */
    @Column(name = "ApplyMan")
    private String applyman;

    /**
     * 申请日期
     */
    @Column(name = "ApplyDate")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date applydate;

    /**
     * 有效状态：0有效1中止
     */
    @Column(name = "EfftStatus")
    private String efftstatus;

    /**
     * 审核状态 0未审核1同意行政指导2退回修改3取消行政指导
     */
    @Column(name = "AuditState")
    private String auditstate;

    /**
     * 行政指导项目1其他2股东出资提示3许可证即将到期4经营期限即将到期5长期不开展经营活动6清算
     */
    @Column(name = "AdminGuideItem")
    private String adminguideitem;

    /**
     * 补充说明
     */
    @Column(name = "AddRemark")
    private String addremark;

    /**
     * 开始日期
     */
    @Column(name = "StaDate")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date stadate;

    /**
     * 结束日期
     */
    @Column(name = "EndDate")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date enddate;

    /**
     * 出具日期
     */
    @Column(name = "ProDate")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date prodate;

    /**
     * 联系人
     */
    @Column(name = "LinkMan")
    private String linkman;

    /**
     * 联系电话
     */
    @Column(name = "Tel")
    private String tel;

    /**
     * 下达日期
     */
    @Column(name = "AssignDate")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date assigndate;

    /**
     * 审核人
     */
    @Column(name = "AuditName")
    private String auditname;

    /**
     * 审核日期
     */
    @Column(name = "AuditDate")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date auditdate;

    /**
     * 中止说明
     */
    @Column(name = "SusRemark")
    private String susremark;

    /**
     * 中止日期
     */
    @Column(name = "SusDate")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date susdate;

    /**
     * 申请中止人
     */
    @Column(name = "ApplySusMan")
    private String applysusman;

    /**
     * 申请中止日期
     */
    @Column(name = "ApplySusDate")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date applysusdate;

    /**
     * 创建时间
     */
    @Column(name = "OtherNoticeType")
    private String othernoticetype;
    /**
     *行政指导书文号
     */
    @Column(name = "PenDecNo")
    private String pendecno;
    /**
     *行政指导书文号 --年份
     */
    @Column(name = "SeqYear")
    private String seqyear;
    /**
     * 行政指导书内容
     */
    @Column(name = "AdminGuideCerContent")
    private String adminguidecercontent;

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
     * 获取随机UUID
     *
     * @return UID - 随机UUID
     */
    public String getUid() {
        return uid;
    }

    /**
     * 设置随机UUID
     *
     * @param uid 随机UUID
     */
    public void setUid(String uid) {
        this.uid = uid;
    }

    /**
     * 获取注册号
     *
     * @return RegNo - 注册号
     */
    public String getRegno() {
        return regno;
    }

    /**
     * 设置注册号
     *
     * @param regno 注册号
     */
    public void setRegno(String regno) {
        this.regno = regno;
    }

    public String getSeqyear() {
        return seqyear;
    }

    public void setSeqyear(String seqyear) {
        this.seqyear = seqyear;
    }

    /**
     * 获取统一代码
     *
     * @return UniSCID - 统一代码
     */
    public String getUniscid() {
        return uniscid;
    }

    /**
     * 设置统一代码
     *
     * @param uniscid 统一代码
     */
    public void setUniscid(String uniscid) {
        this.uniscid = uniscid;
    }

    /**
     * 获取企业名称
     *
     * @return EntName - 企业名称
     */
    public String getEntname() {
        return entname;
    }

    /**
     * 设置企业名称
     *
     * @param entname 企业名称
     */
    public void setEntname(String entname) {
        this.entname = entname;
    }

    /**
     * 获取登记机关
     *
     * @return RegOrg - 登记机关
     */
    public String getRegorg() {
        return regorg;
    }

    /**
     * 设置登记机关
     *
     * @param regorg 登记机关
     */
    public void setRegorg(String regorg) {
        this.regorg = regorg;
    }

    /**
     * 获取登记机关名称
     *
     * @return RegOrgName - 登记机关名称
     */
    public String getRegorgname() {
        return regorgname;
    }

    /**
     * 设置登记机关名称
     *
     * @param regorgname 登记机关名称
     */
    public void setRegorgname(String regorgname) {
        this.regorgname = regorgname;
    }

    /**
     * 获取管辖单位
     *
     * @return LocalAdm - 管辖单位
     */
    public String getLocaladm() {
        return localadm;
    }

    /**
     * 设置管辖单位
     *
     * @param localadm 管辖单位
     */
    public void setLocaladm(String localadm) {
        this.localadm = localadm;
    }

    /**
     * 获取管辖单位名称
     *
     * @return LocalAdmName - 管辖单位名称
     */
    public String getLocaladmname() {
        return localadmname;
    }

    /**
     * 设置管辖单位名称
     *
     * @param localadmname 管辖单位名称
     */
    public void setLocaladmname(String localadmname) {
        this.localadmname = localadmname;
    }

    /**
     * 获取申请人
     *
     * @return ApplyMan - 申请人
     */
    public String getApplyman() {
        return applyman;
    }

    public String getAuditremark() {
        return auditremark;
    }

    public void setAuditremark(String auditremark) {
        this.auditremark = auditremark;
    }

    /**
     * 设置申请人
     *
     * @param applyman 申请人
     */
    public void setApplyman(String applyman) {
        this.applyman = applyman;
    }

    /**
     * 获取申请日期
     *
     * @return ApplyDate - 申请日期
     */
    public Date getApplydate() {
        return applydate;
    }

    /**
     * 设置申请日期
     *
     * @param applydate 申请日期
     */
    public void setApplydate(Date applydate) {
        this.applydate = applydate;
    }

    /**
     * 获取有效状态：0有效1中止
     *
     * @return EfftStatus - 有效状态：0有效1中止
     */
    public String getEfftstatus() {
        return efftstatus;
    }

    /**
     * 设置有效状态：0有效1中止
     *
     * @param efftstatus 有效状态：0有效1中止
     */
    public void setEfftstatus(String efftstatus) {
        this.efftstatus = efftstatus;
    }

    /**
     * 获取审核状态 0未审核1同意行政指导2退回修改3取消行政指导
     *
     * @return AuditState - 审核状态 0未审核1同意行政指导2退回修改3取消行政指导
     */
    public String getAuditstate() {
        return auditstate;
    }

    /**
     * 设置审核状态 0未审核1同意行政指导2退回修改3取消行政指导
     *
     * @param auditstate 审核状态 0未审核1同意行政指导2退回修改3取消行政指导
     */
    public void setAuditstate(String auditstate) {
        this.auditstate = auditstate;
    }

    /**
     * 获取行政指导项目1其他2股东出资提示3许可证即将到期4经营期限即将到期5长期不开展经营活动6清算
     *
     * @return AdminGuideItem - 行政指导项目1其他2股东出资提示3许可证即将到期4经营期限即将到期5长期不开展经营活动6清算
     */
    public String getAdminguideitem() {
        return adminguideitem;
    }

    /**
     * 设置行政指导项目1其他2股东出资提示3许可证即将到期4经营期限即将到期5长期不开展经营活动6清算
     *
     * @param adminguideitem 行政指导项目1其他2股东出资提示3许可证即将到期4经营期限即将到期5长期不开展经营活动6清算
     */
    public void setAdminguideitem(String adminguideitem) {
        this.adminguideitem = adminguideitem;
    }

    /**
     * 获取补充说明
     *
     * @return AddRemark - 补充说明
     */
    public String getAddremark() {
        return addremark;
    }

    /**
     * 设置补充说明
     *
     * @param addremark 补充说明
     */
    public void setAddremark(String addremark) {
        this.addremark = addremark;
    }

    /**
     * 获取开始日期
     *
     * @return StaDate - 开始日期
     */
    public Date getStadate() {
        return stadate;
    }

    /**
     * 设置开始日期
     *
     * @param stadate 开始日期
     */
    public void setStadate(Date stadate) {
        this.stadate = stadate;
    }

    /**
     * 获取结束日期
     *
     * @return EndDate - 结束日期
     */
    public Date getEnddate() {
        return enddate;
    }

    /**
     * 设置结束日期
     *
     * @param enddate 结束日期
     */
    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    /**
     * 获取出具日期
     *
     * @return ProDate - 出具日期
     */
    public Date getProdate() {
        return prodate;
    }

    /**
     * 设置出具日期
     *
     * @param prodate 出具日期
     */
    public void setProdate(Date prodate) {
        this.prodate = prodate;
    }

    /**
     * 获取联系人
     *
     * @return LinkMan - 联系人
     */
    public String getLinkman() {
        return linkman;
    }

    /**
     * 设置联系人
     *
     * @param linkman 联系人
     */
    public void setLinkman(String linkman) {
        this.linkman = linkman;
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
     * 获取下达日期
     *
     * @return AssignDate - 下达日期
     */
    public Date getAssigndate() {
        return assigndate;
    }

    /**
     * 设置下达日期
     *
     * @param assigndate 下达日期
     */
    public void setAssigndate(Date assigndate) {
        this.assigndate = assigndate;
    }

    /**
     * 获取审核人
     *
     * @return AuditName - 审核人
     */
    public String getAuditname() {
        return auditname;
    }

    /**
     * 设置审核人
     *
     * @param auditname 审核人
     */
    public void setAuditname(String auditname) {
        this.auditname = auditname;
    }

    /**
     * 获取审核日期
     *
     * @return AuditDate - 审核日期
     */
    public Date getAuditdate() {
        return auditdate;
    }

    /**
     * 设置审核日期
     *
     * @param auditdate 审核日期
     */
    public void setAuditdate(Date auditdate) {
        this.auditdate = auditdate;
    }

    /**
     * 获取中止说明
     *
     * @return SusRemark - 中止说明
     */
    public String getSusremark() {
        return susremark;
    }

    /**
     * 设置中止说明
     *
     * @param susremark 中止说明
     */
    public void setSusremark(String susremark) {
        this.susremark = susremark;
    }

    /**
     * 获取中止日期
     *
     * @return SusDate - 中止日期
     */
    public Date getSusdate() {
        return susdate;
    }

    /**
     * 设置中止日期
     *
     * @param susdate 中止日期
     */
    public void setSusdate(Date susdate) {
        this.susdate = susdate;
    }

    /**
     * 获取申请中止人
     *
     * @return ApplySusMan - 申请中止人
     */
    public String getApplysusman() {
        return applysusman;
    }

    /**
     * 设置申请中止人
     *
     * @param applysusman 申请中止人
     */
    public void setApplysusman(String applysusman) {
        this.applysusman = applysusman;
    }

    /**
     * 获取申请中止日期
     *
     * @return ApplySusDate - 申请中止日期
     */
    public Date getApplysusdate() {
        return applysusdate;
    }

    /**
     * 设置申请中止日期
     *
     * @param applysusdate 申请中止日期
     */
    public void setApplysusdate(Date applysusdate) {
        this.applysusdate = applysusdate;
    }

    public String getOthernoticetype() {
        return othernoticetype;
    }

    public void setOthernoticetype(String othernoticetype) {
        this.othernoticetype = othernoticetype;
    }

    /**
     * 获取行政指导书内容
     *
     * @return AdminGuideCerContent - 行政指导书内容
     */
    public String getAdminguidecercontent() {
        return adminguidecercontent;
    }

    /**
     * 设置行政指导书内容
     *
     * @param adminguidecercontent 行政指导书内容
     */
    public void setAdminguidecercontent(String adminguidecercontent) {
        this.adminguidecercontent = adminguidecercontent;
    }

    public String getPripid() {
        return pripid;
    }

    public void setPripid(String pripid) {
        this.pripid = pripid;
    }

    public String getPendecno() {
        return pendecno;
    }

    public void setPendecno(String pendecno) {
        this.pendecno = pendecno;
    }
}