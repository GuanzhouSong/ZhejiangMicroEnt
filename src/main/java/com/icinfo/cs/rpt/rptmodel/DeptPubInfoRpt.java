/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.rpt.rptmodel;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.icinfo.framework.mybatis.mapper.annotation.Before;

/**
 * 描述:    cs_rpt_public_info 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年08月10日
 */
@Table(name = "cs_rpt_public_info")
public class DeptPubInfoRpt implements Serializable {
    @Id
    @Column(name = "id")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    private Integer id;

    @Column(name = "areacode")
    private String areacode;

    @Column(name = "regorgCode")
    private String regorgCode;

    @Column(name = "localadmCode")
    private String localadmCode;

    @Column(name = "entTypeCatg")
    private String entTypeCatg;

    /**
     * 公示主体
     */
    @Column(name = "publicInfo")
    private Integer publicInfo;

    /**
     * 存续
     */
    @Column(name = "regstateK")
    private Integer regstateK;

    @Column(name = "regstateD")
    private Integer regstateD;

    @Column(name = "regstateC")
    private Integer regstateC;

    @Column(name = "regstateQ")
    private Integer regstateQ;

    @Column(name = "regstateXX")
    private Integer regstateXX;

    @Column(name = "altItemH")
    private Integer altItemH;

    @Column(name = "altItemT")
    private Integer altItemT;

    /**
     * 动产抵押户数
     */
    @Column(name = "mortH")
    private Integer mortH;

    /**
     * 动产抵押条数
     */
    @Column(name = "mortT")
    private Integer mortT;

    /**
     * 股权出质户数
     */
    @Column(name = "pledgeH")
    private Integer pledgeH;

    /**
     * 股权出质条数
     */
    @Column(name = "pledgeT")
    private Integer pledgeT;

    /**
     * 知识产权出质户数
     */
    @Column(name = "ippldgH")
    private Integer ippldgH;

    /**
     * 知识产权出质条数
     */
    @Column(name = "ippldgT")
    private Integer ippldgT;

    /**
     * 商标户数
     */
    @Column(name = "tmH")
    private Integer tmH;

    /**
     * 商标条数
     */
    @Column(name = "tmT")
    private Integer tmT;

    /**
     * 抽查检查户数
     */
    @Column(name = "spotcheckH")
    private Integer spotcheckH;

    /**
     * 抽查检查条数
     */
    @Column(name = "spotcheckT")
    private Integer spotcheckT;

    /**
     * 司法协助户数
     */
    @Column(name = "sfH")
    private Integer sfH;

    /**
     * 司法协助条数
     */
    @Column(name = "sfT")
    private Integer sfT;

    /**
     * 行政许可户数
     */
    @Column(name = "licenceH")
    private Integer licenceH;

    /**
     * 行政许可条数
     */
    @Column(name = "licenceT")
    private Integer licenceT;

    /**
     * 行政处罚户数
     */
    @Column(name = "punishH")
    private Integer punishH;

    /**
     * 行政处罚条数
     */
    @Column(name = "punishT")
    private Integer punishT;

    /**
     * 异常名录户数
     */
    @Column(name = "opanomlyH")
    private Integer opanomlyH;

    /**
     * 异常名录条数
     */
    @Column(name = "opanomlyT")
    private Integer opanomlyT;

    /**
     * 严重违法户数
     */
    @Column(name = "illDisHoneH")
    private Integer illDisHoneH;

    /**
     * 严重违法条数
     */
    @Column(name = "illDisHoneT")
    private Integer illDisHoneT;

    /**
     * 建议注销户数
     */
    @Column(name = "escH")
    private Integer escH;

    /**
     * 建议注销条数
     */
    @Column(name = "escT")
    private Integer escT;
    
    
    
    /**
     * 工商处罚户数
     */
    @Column(name = "caseH")
    private Integer caseH;

    /**
     * 工商处罚条数
     */
    @Column(name = "caseT")
    private Integer caseT;
    
    
    /**
     * 其他部门处罚户数
     */
    @Column(name = "otherpunishH")
    private Integer otherpunishH;

    /**
     * 其他部门处罚条数
     */
    @Column(name = "otherpunishT")
    private Integer otherpunishT;
    
    /**
     * 股东户数
     */
    @Column(name = "invH")
    private Integer invH;
    
    /**
     * 股东条数
     */
    @Column(name = "invT")
    private Integer invT;
    
    /**
     * 主要人员户数
     */
    @Column(name = "memH")
    private Integer memH;
    
    /**
     * 主要人员条数
     */
    @Column(name = "memT")
    private Integer memT;
    
    /**
     * 分支机构户数
     */
    @Column(name = "supH")
    private Integer supH;
    
    /**
     * 分支机构条数
     */
    @Column(name = "supT")
    private Integer supT;
    
    
    /**
     * 清算户数
     */
    @Column(name = "liqH")
    private Integer liqH;
    
    /**
     * 清算条数
     */
    @Column(name = "liqT")
    private Integer liqT; 

    /**
     * 月度代码
     */
    @Column(name = "monthCode")
    private String monthCode;

    @Column(name = "updateTime")
    private Date updateTime;

    @Column(name = "ismonth")
    private Integer ismonth;
    
    /**
     * 外部门抽查检查户数
     */
    @Column(name = "spotcheckotherH")
    private Integer spotcheckotherH; 
    
    /**
     * 外部门抽查检查条数数
     */
    @Column(name = "spotcheckotherT")
    private Integer spotcheckotherT; 

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
     * @return areacode
     */
    public String getAreacode() {
        return areacode;
    }

    /**
     * @param areacode
     */
    public void setAreacode(String areacode) {
        this.areacode = areacode;
    }


    public String getRegorgCode() {
		return regorgCode;
	}

	public void setRegorgCode(String regorgCode) {
		this.regorgCode = regorgCode;
	}

	public String getLocaladmCode() {
		return localadmCode;
	}

	public void setLocaladmCode(String localadmCode) {
		this.localadmCode = localadmCode;
	}

	/**
     * @return entTypeCatg
     */
    public String getEntTypeCatg() {
        return entTypeCatg;
    }

    /**
     * @param entTypeCatg
     */
    public void setEntTypeCatg(String entTypeCatg) {
        this.entTypeCatg = entTypeCatg;
    }

    /**
     * 获取公示主体
     *
     * @return publicInfo - 公示主体
     */
    public Integer getPublicInfo() {
        return publicInfo;
    }

    /**
     * 设置公示主体
     *
     * @param publicInfo 公示主体
     */
    public void setPublicInfo(Integer publicInfo) {
        this.publicInfo = publicInfo;
    }

    /**
     * 获取存续
     *
     * @return regstateK - 存续
     */
    public Integer getRegstateK() {
        return regstateK;
    }

    /**
     * 设置存续
     *
     * @param regstateK 存续
     */
    public void setRegstateK(Integer regstateK) {
        this.regstateK = regstateK;
    }

    /**
     * @return regstateD
     */
    public Integer getRegstateD() {
        return regstateD;
    }

    /**
     * @param regstateD
     */
    public void setRegstateD(Integer regstateD) {
        this.regstateD = regstateD;
    }

    /**
     * @return regstateC
     */
    public Integer getRegstateC() {
        return regstateC;
    }

    /**
     * @param regstateC
     */
    public void setRegstateC(Integer regstateC) {
        this.regstateC = regstateC;
    }

    /**
     * @return regstateQ
     */
    public Integer getRegstateQ() {
        return regstateQ;
    }

    /**
     * @param regstateQ
     */
    public void setRegstateQ(Integer regstateQ) {
        this.regstateQ = regstateQ;
    }

    /**
     * @return regstateXX
     */
    public Integer getRegstateXX() {
        return regstateXX;
    }

    /**
     * @param regstateXX
     */
    public void setRegstateXX(Integer regstateXX) {
        this.regstateXX = regstateXX;
    }

    /**
     * @return altItemH
     */
    public Integer getAltItemH() {
        return altItemH;
    }

    /**
     * @param altItemH
     */
    public void setAltItemH(Integer altItemH) {
        this.altItemH = altItemH;
    }

    /**
     * @return altItemT
     */
    public Integer getAltItemT() {
        return altItemT;
    }

    /**
     * @param altItemT
     */
    public void setAltItemT(Integer altItemT) {
        this.altItemT = altItemT;
    }

    /**
     * 获取动产抵押户数
     *
     * @return mortH - 动产抵押户数
     */
    public Integer getMortH() {
        return mortH;
    }

    /**
     * 设置动产抵押户数
     *
     * @param mortH 动产抵押户数
     */
    public void setMortH(Integer mortH) {
        this.mortH = mortH;
    }

    /**
     * 获取动产抵押条数
     *
     * @return mortT - 动产抵押条数
     */
    public Integer getMortT() {
        return mortT;
    }

    /**
     * 设置动产抵押条数
     *
     * @param mortT 动产抵押条数
     */
    public void setMortT(Integer mortT) {
        this.mortT = mortT;
    }

    /**
     * 获取股权出质户数
     *
     * @return pledgeH - 股权出质户数
     */
    public Integer getPledgeH() {
        return pledgeH;
    }

    /**
     * 设置股权出质户数
     *
     * @param pledgeH 股权出质户数
     */
    public void setPledgeH(Integer pledgeH) {
        this.pledgeH = pledgeH;
    }

    /**
     * 获取股权出质条数
     *
     * @return pledgeT - 股权出质条数
     */
    public Integer getPledgeT() {
        return pledgeT;
    }

    /**
     * 设置股权出质条数
     *
     * @param pledgeT 股权出质条数
     */
    public void setPledgeT(Integer pledgeT) {
        this.pledgeT = pledgeT;
    }

    /**
     * 获取知识产权出质户数
     *
     * @return ippldgH - 知识产权出质户数
     */
    public Integer getIppldgH() {
        return ippldgH;
    }

    /**
     * 设置知识产权出质户数
     *
     * @param ippldgH 知识产权出质户数
     */
    public void setIppldgH(Integer ippldgH) {
        this.ippldgH = ippldgH;
    }

    /**
     * 获取知识产权出质条数
     *
     * @return ippldgT - 知识产权出质条数
     */
    public Integer getIppldgT() {
        return ippldgT;
    }

    /**
     * 设置知识产权出质条数
     *
     * @param ippldgT 知识产权出质条数
     */
    public void setIppldgT(Integer ippldgT) {
        this.ippldgT = ippldgT;
    }

    /**
     * 获取商标户数
     *
     * @return tmH - 商标户数
     */
    public Integer getTmH() {
        return tmH;
    }

    /**
     * 设置商标户数
     *
     * @param tmH 商标户数
     */
    public void setTmH(Integer tmH) {
        this.tmH = tmH;
    }

    /**
     * 获取商标条数
     *
     * @return tmT - 商标条数
     */
    public Integer getTmT() {
        return tmT;
    }

    /**
     * 设置商标条数
     *
     * @param tmT 商标条数
     */
    public void setTmT(Integer tmT) {
        this.tmT = tmT;
    }

    /**
     * 获取抽查检查户数
     *
     * @return spotcheckH - 抽查检查户数
     */
    public Integer getSpotcheckH() {
        return spotcheckH;
    }

    /**
     * 设置抽查检查户数
     *
     * @param spotcheckH 抽查检查户数
     */
    public void setSpotcheckH(Integer spotcheckH) {
        this.spotcheckH = spotcheckH;
    }

    /**
     * 获取抽查检查条数
     *
     * @return spotcheckT - 抽查检查条数
     */
    public Integer getSpotcheckT() {
        return spotcheckT;
    }

    /**
     * 设置抽查检查条数
     *
     * @param spotcheckT 抽查检查条数
     */
    public void setSpotcheckT(Integer spotcheckT) {
        this.spotcheckT = spotcheckT;
    }

    /**
     * 获取司法协助户数
     *
     * @return sfH - 司法协助户数
     */
    public Integer getSfH() {
        return sfH;
    }

    /**
     * 设置司法协助户数
     *
     * @param sfH 司法协助户数
     */
    public void setSfH(Integer sfH) {
        this.sfH = sfH;
    }

    /**
     * 获取司法协助条数
     *
     * @return sfT - 司法协助条数
     */
    public Integer getSfT() {
        return sfT;
    }

    /**
     * 设置司法协助条数
     *
     * @param sfT 司法协助条数
     */
    public void setSfT(Integer sfT) {
        this.sfT = sfT;
    }

    /**
     * 获取行政许可户数
     *
     * @return licenceH - 行政许可户数
     */
    public Integer getLicenceH() {
        return licenceH;
    }

    /**
     * 设置行政许可户数
     *
     * @param licenceH 行政许可户数
     */
    public void setLicenceH(Integer licenceH) {
        this.licenceH = licenceH;
    }

    /**
     * 获取行政许可条数
     *
     * @return licenceT - 行政许可条数
     */
    public Integer getLicenceT() {
        return licenceT;
    }

    /**
     * 设置行政许可条数
     *
     * @param licenceT 行政许可条数
     */
    public void setLicenceT(Integer licenceT) {
        this.licenceT = licenceT;
    }

    /**
     * 获取行政处罚户数
     *
     * @return punishH - 行政处罚户数
     */
    public Integer getPunishH() {
        return punishH;
    }

    /**
     * 设置行政处罚户数
     *
     * @param punishH 行政处罚户数
     */
    public void setPunishH(Integer punishH) {
        this.punishH = punishH;
    }

    /**
     * 获取行政处罚条数
     *
     * @return punishT - 行政处罚条数
     */
    public Integer getPunishT() {
        return punishT;
    }

    /**
     * 设置行政处罚条数
     *
     * @param punishT 行政处罚条数
     */
    public void setPunishT(Integer punishT) {
        this.punishT = punishT;
    }

    /**
     * 获取异常名录户数
     *
     * @return opanomlyH - 异常名录户数
     */
    public Integer getOpanomlyH() {
        return opanomlyH;
    }

    /**
     * 设置异常名录户数
     *
     * @param opanomlyH 异常名录户数
     */
    public void setOpanomlyH(Integer opanomlyH) {
        this.opanomlyH = opanomlyH;
    }

    /**
     * 获取异常名录条数
     *
     * @return opanomlyT - 异常名录条数
     */
    public Integer getOpanomlyT() {
        return opanomlyT;
    }

    /**
     * 设置异常名录条数
     *
     * @param opanomlyT 异常名录条数
     */
    public void setOpanomlyT(Integer opanomlyT) {
        this.opanomlyT = opanomlyT;
    }

    /**
     * 获取严重违法户数
     *
     * @return illDisHoneH - 严重违法户数
     */
    public Integer getIllDisHoneH() {
        return illDisHoneH;
    }

    /**
     * 设置严重违法户数
     *
     * @param illDisHoneH 严重违法户数
     */
    public void setIllDisHoneH(Integer illDisHoneH) {
        this.illDisHoneH = illDisHoneH;
    }

    /**
     * 获取严重违法条数
     *
     * @return illDisHoneT - 严重违法条数
     */
    public Integer getIllDisHoneT() {
        return illDisHoneT;
    }

    /**
     * 设置严重违法条数
     *
     * @param illDisHoneT 严重违法条数
     */
    public void setIllDisHoneT(Integer illDisHoneT) {
        this.illDisHoneT = illDisHoneT;
    }

    /**
     * 获取建议注销户数
     *
     * @return escH - 建议注销户数
     */
    public Integer getEscH() {
        return escH;
    }

    /**
     * 设置建议注销户数
     *
     * @param escH 建议注销户数
     */
    public void setEscH(Integer escH) {
        this.escH = escH;
    }

    /**
     * 获取建议注销条数
     *
     * @return escT - 建议注销条数
     */
    public Integer getEscT() {
        return escT;
    }

    /**
     * 设置建议注销条数
     *
     * @param escT 建议注销条数
     */
    public void setEscT(Integer escT) {
        this.escT = escT;
    }

    /**
     * 获取月度代码
     *
     * @return monthCode - 月度代码
     */
    public String getMonthCode() {
        return monthCode;
    }

    /**
     * 设置月度代码
     *
     * @param monthCode 月度代码
     */
    public void setMonthCode(String monthCode) {
        this.monthCode = monthCode;
    }

    /**
     * @return updateTime
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * @return ismonth
     */
    public Integer getIsmonth() {
        return ismonth;
    }

    /**
     * @param ismonth
     */
    public void setIsmonth(Integer ismonth) {
        this.ismonth = ismonth;
    }

	public Integer getCaseH() {
		return caseH;
	}

	public void setCaseH(Integer caseH) {
		this.caseH = caseH;
	}

	public Integer getCaseT() {
		return caseT;
	}

	public void setCaseT(Integer caseT) {
		this.caseT = caseT;
	}

	public Integer getOtherpunishH() {
		return otherpunishH;
	}

	public void setOtherpunishH(Integer otherpunishH) {
		this.otherpunishH = otherpunishH;
	}

	public Integer getOtherpunishT() {
		return otherpunishT;
	}

	public void setOtherpunishT(Integer otherpunishT) {
		this.otherpunishT = otherpunishT;
	}

	public Integer getInvH() {
		return invH;
	}

	public void setInvH(Integer invH) {
		this.invH = invH;
	}

	public Integer getInvT() {
		return invT;
	}

	public void setInvT(Integer invT) {
		this.invT = invT;
	}

	public Integer getMemH() {
		return memH;
	}

	public void setMemH(Integer memH) {
		this.memH = memH;
	}

	public Integer getMemT() {
		return memT;
	}

	public void setMemT(Integer memT) {
		this.memT = memT;
	}

	public Integer getSupH() {
		return supH;
	}

	public void setSupH(Integer supH) {
		this.supH = supH;
	}

	public Integer getSupT() {
		return supT;
	}

	public void setSupT(Integer supT) {
		this.supT = supT;
	}

	public Integer getLiqH() {
		return liqH;
	}

	public void setLiqH(Integer liqH) {
		this.liqH = liqH;
	}

	public Integer getLiqT() {
		return liqT;
	}

	public void setLiqT(Integer liqT) {
		this.liqT = liqT;
	}
	
	public void setSpotcheckotherH(Integer spotcheckotherH) {
		this.spotcheckotherH = spotcheckotherH;
	}
	public Integer getSpotcheckotherH() {
		return spotcheckotherH;
	}
	public void setSpotcheckotherT(Integer spotcheckotherT) {
		this.spotcheckotherT = spotcheckotherT;
	}
	public Integer getSpotcheckotherT() {
		return spotcheckotherT;
	}
}