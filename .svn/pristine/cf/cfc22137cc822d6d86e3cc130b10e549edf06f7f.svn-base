/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.other.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.icinfo.framework.mybatis.mapper.annotation.Before;

/**
 * 描述:    cs_pub_justiceinfo 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2016年10月20日
 */
@Table(name = "cs_pub_justiceinfo")
public class PubJusticeInfo implements Serializable {
    /**
     * 自增主键ID
     */
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
     * 主体身份代码
     */
    @Column(name = "PriPID")
    private String priPID;

    /**
     * 司法协助公示信息类别：1：股权冻结信息、2：股东变更信息
     */
    @Column(name = "JusticeType")
    private String justiceType;
    /**
     * 录入部门id
     */
    @Column(name ="DeptCode")
    private  String deptCode;
    
    /**
     * 执行法院
     */
    @Column(name = "ExecutionCourt")
    private String executionCourt;

    /**
     * 执行裁定书文号
     */
    @Column(name = "ExeRulNum")
    private String exeRulNum;

    /**
     * 司法协助公示通知书文号
     */
    @Column(name = "BotRefNum")
    private String botRefNum;

    /**
     * 协助执行通知书文号
     */
    @Column(name = "ExecuteNo")
    private String executeNo;

    /**
     * 执行事项（CZ12股权冻结、强制转让执行事项代码）1：公示冻结股权、其他投资权益、2：续行冻结股权、其他投资权益、3：解除冻结股权、其他投资权益、4：强制转让被执行人股权，办理有限责任公司股东变更登记
     */
    @Column(name = "ExecuteItem")
    private String executeItem;

    /**
     * 被执行人
     */
    @Column(name = "Inv")
    private String inv;
    
    /**
     * 证件类型 ：1：居民身份证、2：外国(地区)护照、3：军官证、4：其他有效身份证件
     */
    @Column(name = "CerType")
    private String cerType;

    /**
     * 证件号码	
     */
    @Column(name = "CerNO")
    private String cerNO;

    /**
     * 被冻结股权所在市场主体名称	
     */
    @Column(name = "EntName")
    private String entName;

    /**
     * 被冻结股权所在市场主体统一代码
     */
    @Column(name = "UniSCID")
    private String uniSCID;
    
    /**
     * 注册号
     */
    @Transient
    private String regNO;

    /**
     * 有限责任公司股权数额、股份有限公司股权数额、企业其他投资权益数额、股权（其他投资权益）数额
     */
    @Column(name = "FroAm")
    private BigDecimal froAm;

    /**
     * 单位	
     */
    @Column(name = "FroAuth")
    private String froAuth;
    
    /**
     * 币种	
     */
    @Column(name = "RegCapCur")
    private String regCapCur;

    /**
     * 冻结期限
     */
    @Column(name = "FrozDeadline")
    private String frozDeadline;

    /**
     * 冻结期限自
     */
    @Column(name = "FroFrom")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date froFrom;

    /**
     * 冻结期限至	
     */
    @Column(name = "FroTo")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date froTo;
    
    /**
     * 冻结比例	
     */
    @Column(name = "FrozenProp")
    private BigDecimal frozenProp;
    
    /**
     * 冻结标志 1=全部股权冻结 2=部分股权冻结 9=其他	
     */
    @Column(name = "FrozSign")
    private String frozSign;

    /**
     * 解冻日期
     */
    @Column(name = "ThawDate")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date thawDate;
    
    /**
     * 解冻说明
     */
    @Column(name = "ThawComment")
    private String thawComment;

    /**
     * 失效日期	
     */
    @Column(name = "LoseEffDate")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date loseEffDate;

    /**
     * 失效原因（CZ14股权冻结失效原因代码）1：冻结期满且未续行冻结，自动失效。2：2014年11月30日前未设定期限的冻结，公示满2年，未续行冻结，自动失效。9：其他
     */
    @Column(name = "LoseEffRes")
    private String loseEffRes;

    /**
     * 公示日期	
     */
    @Column(name = "PublicDate")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date publicDate;

    /**
     * 股权冻结状态（CZ13股权冻结状态代码）1：冻结、2：解除冻结、3：失效
     */
    @Column(name = "FrozState")
    private String frozState;

    /**
     * 受让人
     */
    @Column(name = "AssInv")
    private String assInv;

    /**
     * 受让人证件类型： 1：居民身份证、2：外国(地区)护照、3：军官证、4：其他有效身份证件
     */
    @Column(name = "AssCerType")
    private String assCerType;

    /**
     * 受让人证件号码
     */
    @Column(name = "AssCerNO")
    private String assCerNO;

    /**
     *  协助执行日期
     */
    @Column(name = "ExecuteDate")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date executeDate;

    /**
     * 录入人
     */
    @Column(name = "SetName")
    private String setName;

    /**
     * 录入日期	
     */
    @Column(name = "SetDate")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date setDate;

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
     * 经办人姓名
     */
    @Column(name = "OperatorName")
    private String operatorName;
    
    /**
     * 经办人电话
     */
    @Column(name = "OperatorTel")
    private String operatorTel;

    /**
     * 关联冻结数据JUSTICE_NO：解冻、失效、续冻时保存
     */
    @Column(name = "JusticeConNO")
    private String justiceConNO;
    
    /**
     * 数据来源
     */
    @Column(name = "DataFrom")
    private String dataFrom;
    
    /**
     * 冻结ID(用于数据交换)
     */
    @Column(name = "djid")
    private Integer djid;

    /**
     * 解冻续冻ID(用于数据交换)
     */
    @Column(name = "jdid")
    private Integer jdid;

    /**
     * 时间戳
     */
    @Column(name = "CreateTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;
    
    /**
     * 受让人类型
     */
    @Column(name = "AssInvType")
    private String assInvType;
    /**
     * 受让人照类型：5:营业执照
     */
    @Column(name = "AssBLicType")
    private String assBLicType;
    /**
     * 受让人证照号码
     */
    @Column(name = "AssBLicNO")
    private String assBLicNO;
    /**
     * 被执行人类型
     */
    @Column(name = "InvType")
    private String invType;
    /**
     * 证照类型:5.营业执照
     */
    @Column(name = "BLicType")
    private String bLicType;
    /**
     * 证照号码
     */
    @Column(name = "BLicNO")
    private String bLicNO;
    
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
     * 获取唯一标识
     *
     * @return UID - 唯一标识
     */
    public String getUID() {
        return UID;
    }

    /**
     * 设置唯一标识
     *
     * @param UID 唯一标识
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
     * 获取司法协助公示信息类别：1：股权冻结信息、2：股东变更信息
     *
     * @return JusticeType - 司法协助公示信息类别：1：股权冻结信息、2：股东变更信息
     */
    public String getJusticeType() {
        return justiceType;
    }

    /**
     * 设置司法协助公示信息类别：1：股权冻结信息、2：股东变更信息
     *
     * @param justiceType 司法协助公示信息类别：1：股权冻结信息、2：股东变更信息
     */
    public void setJusticeType(String justiceType) {
        this.justiceType = justiceType;
    }

    /**
     * 获取执行法院
     *
     * @return ExecutionCourt - 执行法院
     */
    public String getExecutionCourt() {
        return executionCourt;
    }

    /**
     * 设置执行法院
     *
     * @param executionCourt 执行法院
     */
    public void setExecutionCourt(String executionCourt) {
        this.executionCourt = executionCourt;
    }

    /**
     * 获取执行裁定书文号
     *
     * @return ExeRulNum - 执行裁定书文号
     */
    public String getExeRulNum() {
        return exeRulNum;
    }

    /**
     * 设置执行裁定书文号
     *
     * @param exeRulNum 执行裁定书文号
     */
    public void setExeRulNum(String exeRulNum) {
        this.exeRulNum = exeRulNum;
    }

    /**
     * 获取司法协助公示通知书文号
     *
     * @return BotRefNum - 司法协助公示通知书文号
     */
    public String getBotRefNum() {
        return botRefNum;
    }

    /**
     * 设置司法协助公示通知书文号
     *
     * @param botRefNum 司法协助公示通知书文号
     */
    public void setBotRefNum(String botRefNum) {
        this.botRefNum = botRefNum;
    }

    /**
     * 获取协助执行通知书文号
     *
     * @return ExecuteNo - 协助执行通知书文号
     */
    public String getExecuteNo() {
        return executeNo;
    }

    /**
     * 设置协助执行通知书文号
     *
     * @param executeNo 协助执行通知书文号
     */
    public void setExecuteNo(String executeNo) {
        this.executeNo = executeNo;
    }

    /**
     * 获取执行事项（CZ12股权冻结、强制转让执行事项代码）1：公示冻结股权、其他投资权益、2：续行冻结股权、其他投资权益、3：解除冻结股权、其他投资权益、4：强制转让被执行人股权，办理有限责任公司股东变更登记
     *
     * @return ExecuteItem - 执行事项（CZ12股权冻结、强制转让执行事项代码）1：公示冻结股权、其他投资权益、2：续行冻结股权、其他投资权益、3：解除冻结股权、其他投资权益、4：强制转让被执行人股权，办理有限责任公司股东变更登记
     */
    public String getExecuteItem() {
        return executeItem;
    }

    /**
     * 设置执行事项（CZ12股权冻结、强制转让执行事项代码）1：公示冻结股权、其他投资权益、2：续行冻结股权、其他投资权益、3：解除冻结股权、其他投资权益、4：强制转让被执行人股权，办理有限责任公司股东变更登记
     *
     * @param executeItem 执行事项（CZ12股权冻结、强制转让执行事项代码）1：公示冻结股权、其他投资权益、2：续行冻结股权、其他投资权益、3：解除冻结股权、其他投资权益、4：强制转让被执行人股权，办理有限责任公司股东变更登记
     */
    public void setExecuteItem(String executeItem) {
        this.executeItem = executeItem;
    }

    /**
     * 获取被执行人
     *
     * @return Inv - 被执行人
     */
    public String getInv() {
        return inv;
    }

    /**
     * 设置被执行人
     *
     * @param inv 被执行人
     */
    public void setInv(String inv) {
        this.inv = inv;
    }

    /**
     * 获取证件（证照）类型 ：1：居民身份证、2：外国(地区)护照、3：军官证、4：其他有效身份证件 5：营业执照 
     *
     * @return CerType - 证件（证照）类型 ：1：居民身份证、2：外国(地区)护照、3：军官证、4：其他有效身份证件 5：营业执照 
     */
    public String getCerType() {
        return cerType;
    }

    /**
     * 设置证件（证照）类型 ：1：居民身份证、2：外国(地区)护照、3：军官证、4：其他有效身份证件 5：营业执照 
     *
     * @param cerType 证件（证照）类型 ：1：居民身份证、2：外国(地区)护照、3：军官证、4：其他有效身份证件 5：营业执照 
     */
    public void setCerType(String cerType) {
        this.cerType = cerType;
    }

    /**
     * 获取证件（证照）号码	
     *
     * @return CerNO - 证件（证照）号码	
     */
    public String getCerNO() {
        return cerNO;
    }

    /**
     * 设置证件（证照）号码	
     *
     * @param cerNO 证件（证照）号码	
     */
    public void setCerNO(String cerNO) {
        this.cerNO = cerNO;
    }

    /**
     * 获取被冻结股权所在市场主体名称	
     *
     * @return EntName - 被冻结股权所在市场主体名称	
     */
    public String getEntName() {
        return entName;
    }

    /**
     * 设置被冻结股权所在市场主体名称	
     *
     * @param entName 被冻结股权所在市场主体名称	
     */
    public void setEntName(String entName) {
        this.entName = entName;
    }

    /**
     * 获取被冻结股权所在市场主体统一代码/注册号	
     *
     * @return UniSCID - 被冻结股权所在市场主体统一代码/注册号	
     */
    public String getUniSCID() {
        return uniSCID;
    }

    /**
     * 设置被冻结股权所在市场主体统一代码/注册号	
     *
     * @param uniSCID 被冻结股权所在市场主体统一代码/注册号	
     */
    public void setUniSCID(String uniSCID) {
        this.uniSCID = uniSCID;
    }

    /**
     * 获取有限责任公司股权数额、股份有限公司股权数额、企业其他投资权益数额、股权（其他投资权益）数额
     *
     * @return FroAm - 有限责任公司股权数额、股份有限公司股权数额、企业其他投资权益数额、股权（其他投资权益）数额
     */
    public BigDecimal getFroAm() {
        return froAm;
    }

    /**
     * 设置有限责任公司股权数额、股份有限公司股权数额、企业其他投资权益数额、股权（其他投资权益）数额
     *
     * @param froAm 有限责任公司股权数额、股份有限公司股权数额、企业其他投资权益数额、股权（其他投资权益）数额
     */
    public void setFroAm(BigDecimal froAm) {
        this.froAm = froAm;
    }

    /**
     * 获取单位	
     *
     * @return FroAuth - 单位	
     */
    public String getFroAuth() {
        return froAuth;
    }

    /**
     * 设置单位	
     *
     * @param froAuth 单位	
     */
    public void setFroAuth(String froAuth) {
        this.froAuth = froAuth;
    }

    /**
     * 获取冻结期限
     *
     * @return FrozDeadline - 冻结期限
     */
    public String getFrozDeadline() {
        return frozDeadline;
    }

    /**
     * 设置冻结期限
     *
     * @param frozDeadline 冻结期限
     */
    public void setFrozDeadline(String frozDeadline) {
        this.frozDeadline = frozDeadline;
    }

    /**
     * 获取冻结期限自
     *
     * @return FroFrom - 冻结期限自
     */
    public Date getFroFrom() {
        return froFrom;
    }

    /**
     * 设置冻结期限自
     *
     * @param froFrom 冻结期限自
     */
    public void setFroFrom(Date froFrom) {
        this.froFrom = froFrom;
    }

    /**
     * 获取冻结期限至	
     *
     * @return FroTo - 冻结期限至	
     */
    public Date getFroTo() {
        return froTo;
    }

    /**
     * 设置冻结期限至	
     *
     * @param froTo 冻结期限至	
     */
    public void setFroTo(Date froTo) {
        this.froTo = froTo;
    }

    /**
     * 获取解冻日期
     *
     * @return ThawDate - 解冻日期
     */
    public Date getThawDate() {
        return thawDate;
    }

    /**
     * 设置解冻日期
     *
     * @param thawDate 解冻日期
     */
    public void setThawDate(Date thawDate) {
        this.thawDate = thawDate;
    }

    /**
     * 获取失效日期	
     *
     * @return LoseEffDate - 失效日期	
     */
    public Date getLoseEffDate() {
        return loseEffDate;
    }

    /**
     * 设置失效日期	
     *
     * @param loseEffDate 失效日期	
     */
    public void setLoseEffDate(Date loseEffDate) {
        this.loseEffDate = loseEffDate;
    }

    /**
     * 获取失效原因（CZ14股权冻结失效原因代码）1：冻结期满且未续行冻结，自动失效。2：2014年11月30日前未设定期限的冻结，公示满2年，未续行冻结，自动失效。9：其他
     *
     * @return LoseEffRes - 失效原因（CZ14股权冻结失效原因代码）1：冻结期满且未续行冻结，自动失效。2：2014年11月30日前未设定期限的冻结，公示满2年，未续行冻结，自动失效。9：其他
     */
    public String getLoseEffRes() {
        return loseEffRes;
    }

    /**
     * 设置失效原因（CZ14股权冻结失效原因代码）1：冻结期满且未续行冻结，自动失效。2：2014年11月30日前未设定期限的冻结，公示满2年，未续行冻结，自动失效。9：其他
     *
     * @param loseEffRes 失效原因（CZ14股权冻结失效原因代码）1：冻结期满且未续行冻结，自动失效。2：2014年11月30日前未设定期限的冻结，公示满2年，未续行冻结，自动失效。9：其他
     */
    public void setLoseEffRes(String loseEffRes) {
        this.loseEffRes = loseEffRes;
    }

    /**
     * 获取公示日期	
     *
     * @return PublicDate - 公示日期	
     */
    public Date getPublicDate() {
        return publicDate;
    }

    /**
     * 设置公示日期	
     *
     * @param publicDate 公示日期	
     */
    public void setPublicDate(Date publicDate) {
        this.publicDate = publicDate;
    }

    /**
     * 获取股权冻结状态（CZ13股权冻结状态代码）1：冻结、2：解除冻结、3：失效
     *
     * @return FrozState - 股权冻结状态（CZ13股权冻结状态代码）1：冻结、2：解除冻结、3：失效
     */
    public String getFrozState() {
        return frozState;
    }

    /**
     * 设置股权冻结状态（CZ13股权冻结状态代码）1：冻结、2：解除冻结、3：失效
     *
     * @param frozState 股权冻结状态（CZ13股权冻结状态代码）1：冻结、2：解除冻结、3：失效
     */
    public void setFrozState(String frozState) {
        this.frozState = frozState;
    }

    /**
     * 获取受让人
     *
     * @return AssInv - 受让人
     */
    public String getAssInv() {
        return assInv;
    }

    /**
     * 设置受让人
     *
     * @param assInv 受让人
     */
    public void setAssInv(String assInv) {
        this.assInv = assInv;
    }

    /**
     * 获取受让人证件（证照）类型： 1：居民身份证、2：外国(地区)护照、3：军官证、4：其他有效身份证件 5：营业执照 
     *
     * @return AssCerType - 受让人证件（证照）类型： 1：居民身份证、2：外国(地区)护照、3：军官证、4：其他有效身份证件 5：营业执照 
     */
    public String getAssCerType() {
        return assCerType;
    }

    /**
     * 设置受让人证件（证照）类型： 1：居民身份证、2：外国(地区)护照、3：军官证、4：其他有效身份证件 5：营业执照 
     *
     * @param assCerType 受让人证件（证照）类型： 1：居民身份证、2：外国(地区)护照、3：军官证、4：其他有效身份证件 5：营业执照 
     */
    public void setAssCerType(String assCerType) {
        this.assCerType = assCerType;
    }

    /**
     * 获取受让人证件（证照）号码
     *
     * @return AssCerNO - 受让人证件（证照）号码
     */
    public String getAssCerNO() {
        return assCerNO;
    }

    /**
     * 设置受让人证件（证照）号码
     *
     * @param assCerNO 受让人证件（证照）号码
     */
    public void setAssCerNO(String assCerNO) {
        this.assCerNO = assCerNO;
    }

    /**
     * 获取 协助执行日期
     *
     * @return ExecuteDate -  协助执行日期
     */
    public Date getExecuteDate() {
        return executeDate;
    }

    /**
     * 设置 协助执行日期
     *
     * @param executeDate  协助执行日期
     */
    public void setExecuteDate(Date executeDate) {
        this.executeDate = executeDate;
    }

    /**
     * 获取录入人
     *
     * @return SetName - 录入人
     */
    public String getSetName() {
        return setName;
    }

    /**
     * 设置录入人
     *
     * @param setName 录入人
     */
    public void setSetName(String setName) {
        this.setName = setName;
    }

    /**
     * 获取录入日期	
     *
     * @return SetDate - 录入日期	
     */
    public Date getSetDate() {
        return setDate;
    }

    /**
     * 设置录入日期	
     *
     * @param setDate 录入日期	
     */
    public void setSetDate(Date setDate) {
        this.setDate = setDate;
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
  
    public String getDeptCode() {
		return deptCode;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}

	/**
     * 获取关联冻结数据JUSTICE_NO：解冻、失效、续冻时保存
     *
     * @return JusticeConNO - 关联冻结数据JUSTICE_NO：解冻、失效、续冻时保存
     */
    public String getJusticeConNO() {
        return justiceConNO;
    }

    /**
     * 设置关联冻结数据JUSTICE_NO：解冻、失效、续冻时保存
     *
     * @param justiceConNO 关联冻结数据JUSTICE_NO：解冻、失效、续冻时保存
     */
    public void setJusticeConNO(String justiceConNO) {
        this.justiceConNO = justiceConNO;
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

    public String getFrozStateName(){
    	if("1".equals(this.getFrozState()))
    		return "冻结";
    	if("2".equals(this.getFrozState()))
    		return "解除冻结";
    	if("3".equals(this.getFrozState()))
    		return "失效";
    	return null;
    }

	public String getRegNO() {
		return regNO;
	}

	public void setRegNO(String regNO) {
		this.regNO = regNO;
	}

	public BigDecimal getFrozenProp() {
		return frozenProp;
	}

	public void setFrozenProp(BigDecimal frozenProp) {
		this.frozenProp = frozenProp;
	}

	public String getFrozSign() {
		return frozSign;
	}

	public void setFrozSign(String frozSign) {
		this.frozSign = frozSign;
	}

	public String getOperatorName() {
		return operatorName;
	}

	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}

	public String getOperatorTel() {
		return operatorTel;
	}

	public void setOperatorTel(String operatorTel) {
		this.operatorTel = operatorTel;
	}

	public String getRegCapCur() {
		return regCapCur;
	}

	public void setRegCapCur(String regCapCur) {
		this.regCapCur = regCapCur;
	}

	public String getThawComment() {
		return thawComment;
	}

	public void setThawComment(String thawComment) {
		this.thawComment = thawComment;
	}

	public Integer getDjid() {
		return djid;
	}

	public void setDjid(Integer djid) {
		this.djid = djid;
	}

	public Integer getJdid() {
		return jdid;
	}

	public void setJdid(Integer jdid) {
		this.jdid = jdid;
	}

	public String getDataFrom() {
		return dataFrom;
	}

	public void setDataFrom(String dataFrom) {
		this.dataFrom = dataFrom;
	}

	public String getAssInvType() {
		return assInvType;
	}

	public void setAssInvType(String assInvType) {
		this.assInvType = assInvType;
	}

	public String getAssBLicType() {
		return assBLicType;
	}

	public void setAssBLicType(String assBLicType) {
		this.assBLicType = assBLicType;
	}

	public String getAssBLicNO() {
		return assBLicNO;
	}

	public void setAssBLicNO(String assBLicNO) {
		this.assBLicNO = assBLicNO;
	}

	public String getInvType() {
		return invType;
	}

	public void setInvType(String invType) {
		this.invType = invType;
	}

	public String getbLicType() {
		return bLicType;
	}

	public void setbLicType(String bLicType) {
		this.bLicType = bLicType;
	}

	public String getbLicNO() {
		return bLicNO;
	}

	public void setbLicNO(String bLicNO) {
		this.bLicNO = bLicNO;
	}
	
}