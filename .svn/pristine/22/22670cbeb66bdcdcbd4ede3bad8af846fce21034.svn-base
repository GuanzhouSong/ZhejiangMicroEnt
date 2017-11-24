/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.party.model;

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
 * 描述:    cs_party_organize_info 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年08月18日
 */
@Table(name = "cs_party_organize_info")
public class PartyOrganizeInfo implements Serializable {
	
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
     * 党组织建制   1-党委  2-总支  3-支部
     */
    @Column(name = "PartyOrgType")
    private String partyOrgType;

    /**
     * 党组织全称
     */
    @Column(name = "PartyOrgName")
    private String partyOrgName;

    /**
     * 党组织分布类别  1-个体户党组织 2-企业党组织  3-农贸市场党组织 4-商品交易市场党组织
     */
    @Column(name = "PartyOrgDistributed")
    private String partyOrgDistributed;
    
    /**
     * 组建方式  单建-1 联建-2 ...
     */
    @Column(name = "PartyOrgBuildWay")
    private String partyOrgBuildWay;

    /**
     * 管辖单位编码
     */
    @Column(name = "LocalAdm")
    private String localAdm;

    /**
     * 管辖单位名称
     */
    @Column(name = "LocalAdmName")
    private String localAdmName;
    
    /**
     * 书记姓名
     */
    @Column(name = "SecretaryName")
    private String secretaryName;
    
    /**
     * 书记电话号码
     */
    @Column(name = "SecretaryTel")
    private String secretaryTel;
    
    /**
     * 党组织所在地
     */
    @Column(name = "PartyOrgLoc")
    private String partyOrgLoc;
    
    /**
     * 所在市
     */
    @Column(name = "LocCity")
    private String locCity;
    
    /**
     * 所在区县
     */
    @Column(name = "LocCounty")
    private String locCounty;
    
    /**
     * 党组织所在地
     */
    @Column(name = "LocStreet")
    private String locStreet;

    /**
     * 是否是联系点
     */
    @Column(name = "IsConnectionPoint")
    private String isConnectionPoint;

    /**
     * 备注
     */
    @Column(name = "Remark")
    private String remark;
    
    /**
     * 录入人姓名
     */
    @Column(name = "InputName")
    private String inputName;
    
    /**
     * 录入人部门编码
     */
    @Column(name = "InputDeptCode")
    private String inputDeptCode;
    
    /**
     * 录入状态  0-无效  1-有效  2-待入库
     */
    @Column(name = "InputState")
    private String inputState;

    /**
     * 录入日期
     */
    @Column(name = "InputDate")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date inputDate;
    
    /**
     * 创建时间
     */
    @Column(name = "CreateTime")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date createTime;
    
    /**
     * 修改时间
     */
    @Column(name = "ModifyTime")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date modifyTime;
    
    /**
     * 组建日期
     */
    @Column(name = "PartyOrgBuildDate")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date partyOrgBuildDate;
    
    /**
     * 企业主体代码
     */
    @Column(name = "CreateSelfEntID")
    private String createSelfEntID;
    
    @Column(name = "RegOrg")
    private String regOrg;
    
    @Column(name = "RegOrgName")
    private String regOrgName;
    
    @Column(name = "Areacode")
    private String areacode;

    private static final long serialVersionUID = 1L;

    public String getRegOrg() {
		return regOrg;
	}

	public void setRegOrg(String regOrg) {
		this.regOrg = regOrg;
	}

	public String getRegOrgName() {
		return regOrgName;
	}

	public void setRegOrgName(String regOrgName) {
		this.regOrgName = regOrgName;
	}

	public String getAreacode() {
		return areacode;
	}

	public void setAreacode(String areacode) {
		this.areacode = areacode;
	}

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
     * 获取党组织建制
     *
     * @return PartyOrgType - 党组织建制
     */
    public String getPartyOrgType() {
        return partyOrgType;
    }

    /**
     * 设置党组织建制
     *
     * @param partyOrgType 党组织建制
     */
    public void setPartyOrgType(String partyOrgType) {
        this.partyOrgType = partyOrgType;
    }

    /**
     * 获取党组织全称
     *
     * @return PartyOrgName - 党组织全称
     */
    public String getPartyOrgName() {
        return partyOrgName;
    }

    /**
     * 设置党组织全称
     *
     * @param partyOrgName 党组织全称
     */
    public void setPartyOrgName(String partyOrgName) {
        this.partyOrgName = partyOrgName;
    }

    /**
     * 获取党组织分布类别
     *
     * @return PartyOrgDistributed - 党组织分布类别
     */
    public String getPartyOrgDistributed() {
        return partyOrgDistributed;
    }

    /**
     * 设置党组织分布类别
     *
     * @param partyOrgDistributed 党组织分布类别
     */
    public void setPartyOrgDistributed(String partyOrgDistributed) {
        this.partyOrgDistributed = partyOrgDistributed;
    }

    /**
     * 获取管辖单位编码
     *
     * @return LocalAdm - 管辖单位编码
     */
    public String getLocalAdm() {
        return localAdm;
    }

    /**
     * 设置管辖单位编码
     *
     * @param localAdm 管辖单位编码
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
     * 获取是否是联系点
     *
     * @return IsConnectionPoint - 是否是联系点
     */
    public String getIsConnectionPoint() {
        return isConnectionPoint;
    }

    /**
     * 设置是否是联系点
     *
     * @param isConnectionPoint 是否是联系点
     */
    public void setIsConnectionPoint(String isConnectionPoint) {
        this.isConnectionPoint = isConnectionPoint;
    }

    /**
     * 获取备注
     *
     * @return Remark - 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注
     *
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
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

	public String getPartyOrgBuildWay() {
		return partyOrgBuildWay;
	}

	public void setPartyOrgBuildWay(String partyOrgBuildWay) {
		this.partyOrgBuildWay = partyOrgBuildWay;
	}

	public String getInputName() {
		return inputName;
	}

	public void setInputName(String inputName) {
		this.inputName = inputName;
	}

	public String getInputDeptCode() {
		return inputDeptCode;
	}

	public void setInputDeptCode(String inputDeptCode) {
		this.inputDeptCode = inputDeptCode;
	}

	public String getInputState() {
		return inputState;
	}

	public void setInputState(String inputState) {
		this.inputState = inputState;
	}

	public Date getPartyOrgBuildDate() {
		return partyOrgBuildDate;
	}

	public void setPartyOrgBuildDate(Date partyOrgBuildDate) {
		this.partyOrgBuildDate = partyOrgBuildDate;
	}

	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	public Date getInputDate() {
		return inputDate;
	}

	public void setInputDate(Date inputDate) {
		this.inputDate = inputDate;
	}

	public String getCreateSelfEntID() {
		return createSelfEntID;
	}

	public void setCreateSelfEntID(String createSelfEntID) {
		this.createSelfEntID = createSelfEntID;
	}

	public String getSecretaryName() {
		return secretaryName;
	}

	public void setSecretaryName(String secretaryName) {
		this.secretaryName = secretaryName;
	}

	public String getSecretaryTel() {
		return secretaryTel;
	}

	public void setSecretaryTel(String secretaryTel) {
		this.secretaryTel = secretaryTel;
	}

	public String getPartyOrgLoc() {
		return partyOrgLoc;
	}

	public void setPartyOrgLoc(String partyOrgLoc) {
		this.partyOrgLoc = partyOrgLoc;
	}

	public String getLocCity() {
		return locCity;
	}

	public void setLocCity(String locCity) {
		this.locCity = locCity;
	}

	public String getLocCounty() {
		return locCounty;
	}

	public void setLocCounty(String locCounty) {
		this.locCounty = locCounty;
	}

	public String getLocStreet() {
		return locStreet;
	}

	public void setLocStreet(String locStreet) {
		this.locStreet = locStreet;
	}
	
       
}