/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.es.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 描述:    cs_panorama_search 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2016年11月04日
 */
@Table(name = "cs_panorama_search")
public class PanoramaSearchBase implements Serializable {

    /**
     * 内部序号
     */
    @Column(name = "PriPID")
    private String priPID;

    /**
     * 企业名称（不分词）
     */
    @Column(name = "EntName")
    private String entName;

    /**
     * 企业名称（分词）
     */
    @Column(name = "EntNamePPL")
    private String entNamePPL;

    /**
     * 注册号
     */
    @Column(name = "RegNO")
    private String regNO;

    /**
     * 统一信用代码
     */
    @Column(name = "Uniscid")
    private String uniscid;

    /**
     * 法定代表人身份证号
     */
    @Column(name = "CerNO")
    private String cerNO;

    /**
     * 法定代表人
     */
    @Column(name = "LeRep")
    private String leRep;
    
    /**
     * 电话号
     */
    @Column(name = "Tel")
    private String tel;
    
    /**
     * 行业代码
     */
    @Column(name = "IndustryCo")
    private String industryCo;

    /**
     * 行业名称
     */
    @Column(name = "IndustryCoName")
    private String industryCoName;

    /**
     * 企业类型
     */
    @Column(name = "EntType")
    private String entType;

    /**
     * 企业类型名称
     */
    @Column(name = "EntTypeName")
    private String entTypeName;

    /**
     * 市场主体类型大类
     */
    @Column(name = "EntTypeCatg")
    private String entTypeCatg;

    /**
     * 市场主体类型大类名称
     */
    @Column(name = "EntTypeCatgName")
    private String entTypeCatgName;

    /**
     * 住所
     */
    @Column(name = "Dom")
    private String dom;

    /**
     * 管辖单位
     */
    @Column(name = "LocalAdm")
    private String localAdm;

    /**
     * 管辖单位名称
     */
    @Column(name = "LocalAdmName")
    private String localAdmName;

    /**
     * 登记机关
     */
    @Column(name = "RegOrg")
    private String regOrg;

    /**
     * 登记机关名称
     */
    @Column(name = "RegOrgName")
    private String regOrgName;

    /**
     * 抽检部门
     */
    @Column(name = "CheckDep")
    private String checkDep;

    /**
     * 抽检部门名称
     */
    @Column(name = "CheckDepName")
    private String checkDepName;

    /**
     * 委托机关
     */
    @Column(name = "DelegateOrg")
    private String delegateOrg;

    /**
     * 委托机关名称
     */
    @Column(name = "DelegateOrgName")
    private String delegateOrgName;

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
     * 属地机关
     */
    @Column(name = "LocalRegOrgCode")
    private String localRegOrgCode;

    /**
     * 属地机关名称
     */
    @Column(name = "LocalRegOrgCodeName")
    private String localRegOrgCodeName;

    /**
     * 经营范围
     */
    @Column(name = "OpScope")
    private String opScope;
    
    /**
     * 核准日期
     */
    @Column(name = "ApprDate")
    private Date apprDate;
    
    /**
     * 成立日期
     */
    @Column(name = "EstDate")
    private Date estDate;

    /**
     * 经营期限自
     */
    @Column(name = "OpFrom")
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date opFrom;

    /**
     * 经营期限至
     */
    @Column(name = "OpTo")
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date opTo;
    
    /**
     * 变更注销日期
     */
    @Column(name = "AltDate")
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date altDate;

    /**
     * 注册资本
     */
    @Column(name = "RegCap")
    private BigDecimal regCap;

    /**
     * 运营状态
     */
    @Column(name = "RegState")
    private String regState;

    /**
     * 个转企
     */
    @Column(name = "IsIndivid")
    private String isIndivid;
    
    /**
     * 联络员证件号
     */
    @Column(name = "LiaIDNum")
    private String liaIDNum;
    
    /**
     * 联络员证件类型
     */
    @Column(name = "LiaIDType")
    private String liaIDType;
    
    /**
     * 联络员姓名
     */
    @Column(name = "LiaName")
    private String liaName;
    
    /**
     * 联络员电话
     */
    @Column(name = "LiaTel")
    private String liaTel;
    

    private static final long serialVersionUID = 1L;


    /**
     * 获取内部序号
     *
     * @return PriPID - 内部序号
     */
    public String getPriPID() {
        return priPID;
    }

    /**
     * 设置内部序号
     *
     * @param priPID 内部序号
     */
    public void setPriPID(String priPID) {
        this.priPID = priPID;
    }

    /**
     * 获取企业名称（不分词）
     *
     * @return EntName - 企业名称（不分词）
     */
    public String getEntName() {
        return entName;
    }

    /**
     * 设置企业名称（不分词）
     *
     * @param entName 企业名称（不分词）
     */
    public void setEntName(String entName) {
        this.entName = entName;
    }

    /**
     * 获取企业名称（分词）
     *
     * @return EntNamePPL - 企业名称（分词）
     */
    public String getEntNamePPL() {
        return entNamePPL;
    }

    /**
     * 设置企业名称（分词）
     *
     * @param entNamePPL 企业名称（分词）
     */
    public void setEntNamePPL(String entNamePPL) {
        this.entNamePPL = entNamePPL;
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
     * 获取统一信用代码
     *
     * @return Uniscid - 统一信用代码
     */
    public String getUniscid() {
        return uniscid;
    }

    /**
     * 设置统一信用代码
     *
     * @param uniscid 统一信用代码
     */
    public void setUniscid(String uniscid) {
        this.uniscid = uniscid;
    }

    /**
     * 获取法定代表人身份证号
     *
     * @return CerNO - 法定代表人身份证号
     */
    public String getCerNO() {
        return cerNO;
    }

    /**
     * 设置法定代表人身份证号
     *
     * @param cerNO 法定代表人身份证号
     */
    public void setCerNO(String cerNO) {
        this.cerNO = cerNO;
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
     * 获取行业名称
     *
     * @return IndustryCoName - 行业名称
     */
    public String getIndustryCoName() {
        return industryCoName;
    }

    /**
     * 设置行业名称
     *
     * @param industryCoName 行业名称
     */
    public void setIndustryCoName(String industryCoName) {
        this.industryCoName = industryCoName;
    }

    /**
     * 获取企业类型
     *
     * @return EntType - 企业类型
     */
    public String getEntType() {
        return entType;
    }

    /**
     * 设置企业类型
     *
     * @param entType 企业类型
     */
    public void setEntType(String entType) {
        this.entType = entType;
    }

    /**
     * 获取企业类型名称
     *
     * @return EntTypeName - 企业类型名称
     */
    public String getEntTypeName() {
        return entTypeName;
    }

    /**
     * 设置企业类型名称
     *
     * @param entTypeName 企业类型名称
     */
    public void setEntTypeName(String entTypeName) {
        this.entTypeName = entTypeName;
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
     * 获取市场主体类型大类名称
     *
     * @return EntTypeCatgName - 市场主体类型大类名称
     */
    public String getEntTypeCatgName() {
        return entTypeCatgName;
    }

    /**
     * 设置市场主体类型大类名称
     *
     * @param entTypeCatgName 市场主体类型大类名称
     */
    public void setEntTypeCatgName(String entTypeCatgName) {
        this.entTypeCatgName = entTypeCatgName;
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
     * 获取管辖单位
     *
     * @return LocalAdm - 管辖单位
     */
    public String getLocalAdm() {
        return localAdm;
    }

    /**
     * 设置管辖单位
     *
     * @param localAdm 管辖单位
     */
    public void setLocalAdm(String localAdm) {
        this.localAdm = localAdm;
    }

    /**
     * 获取管辖单位名称
     *
     * @return LocalAdmName - 管辖单位名称
     */
    public String getLocalAdmName() {
        return localAdmName;
    }

    /**
     * 设置管辖单位名称
     *
     * @param localAdmName 管辖单位名称
     */
    public void setLocalAdmName(String localAdmName) {
        this.localAdmName = localAdmName;
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
     * 获取抽检部门名称
     *
     * @return CheckDepName - 抽检部门名称
     */
    public String getCheckDepName() {
        return checkDepName;
    }

    /**
     * 设置抽检部门名称
     *
     * @param checkDepName 抽检部门名称
     */
    public void setCheckDepName(String checkDepName) {
        this.checkDepName = checkDepName;
    }

    /**
     * 获取委托机关
     *
     * @return DelegateOrg - 委托机关
     */
    public String getDelegateOrg() {
        return delegateOrg;
    }

    /**
     * 设置委托机关
     *
     * @param delegateOrg 委托机关
     */
    public void setDelegateOrg(String delegateOrg) {
        this.delegateOrg = delegateOrg;
    }

    /**
     * 获取委托机关名称
     *
     * @return DelegateOrgName - 委托机关名称
     */
    public String getDelegateOrgName() {
        return delegateOrgName;
    }

    /**
     * 设置委托机关名称
     *
     * @param delegateOrgName 委托机关名称
     */
    public void setDelegateOrgName(String delegateOrgName) {
        this.delegateOrgName = delegateOrgName;
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
     * 获取核准日期
     *
     * @return Apprdate - 核准日期
     */
    public Date getApprDate() {
        return apprDate;
    }

    /**
     * 设置核准日期
     *
     * @param apprdate 核准日期
     */
    public void setApprDate(Date apprDate) {
        this.apprDate = apprDate;
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
     * 获取经营期限自
     *
     * @return OpFrom - 经营期限自
     */
    public Date getOpFrom() {
        return opFrom;
    }

    /**
     * 设置经营期限自
     *
     * @param opFrom 经营期限自
     */
    public void setOpFrom(Date opFrom) {
        this.opFrom = opFrom;
    }

    /**
     * 获取经营期限至
     *
     * @return OpTo - 经营期限至
     */
    public Date getOpTo() {
        return opTo;
    }

    /**
     * 设置经营期限至
     *
     * @param opTo 经营期限至
     */
    public void setOpTo(Date opTo) {
        this.opTo = opTo;
    }

    /**
     * 获取注册资本
     *
     * @return RegCap - 注册资本
     */
    public BigDecimal getRegCap() {
        return regCap;
    }

    /**
     * 设置注册资本
     *
     * @param regCap 注册资本
     */
    public void setRegCap(BigDecimal regCap) {
        this.regCap = regCap;
    }

    /**
     * 获取运营状态
     *
     * @return RegState - 运营状态
     */
    public String getRegState() {
        return regState;
    }

    /**
     * 设置运营状态
     *
     * @param regState 运营状态
     */
    public void setRegState(String regState) {
        this.regState = regState;
    }

    /**
     * 获取个转企
     *
     * @return IsIndivid - 个转企
     */
    public String getIsIndivid() {
        return isIndivid;
    }

    /**
     * 设置个转企
     *
     * @param isIndivid 个转企
     */
    public void setIsIndivid(String isIndivid) {
        this.isIndivid = isIndivid;
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



	public String getLiaIDNum() {
		return liaIDNum;
	}

	public void setLiaIDNum(String liaIDNum) {
		this.liaIDNum = liaIDNum;
	}

	public String getLiaIDType() {
		return liaIDType;
	}

	public void setLiaIDType(String liaIDType) {
		this.liaIDType = liaIDType;
	}

	public String getLiaName() {
		return liaName;
	}

	public void setLiaName(String liaName) {
		this.liaName = liaName;
	}

	public String getLiaTel() {
		return liaTel;
	}

	public void setLiaTel(String liaTel) {
		this.liaTel = liaTel;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getLocalRegOrgCode() {
		return localRegOrgCode;
	}

	public void setLocalRegOrgCode(String localRegOrgCode) {
		this.localRegOrgCode = localRegOrgCode;
	}

	public String getLocalRegOrgCodeName() {
		return localRegOrgCodeName;
	}

	public void setLocalRegOrgCodeName(String localRegOrgCodeName) {
		this.localRegOrgCodeName = localRegOrgCodeName;
	}

	public Date getAltDate() {
		return altDate;
	}

	public void setAltDate(Date altDate) {
		this.altDate = altDate;
	}

    
}