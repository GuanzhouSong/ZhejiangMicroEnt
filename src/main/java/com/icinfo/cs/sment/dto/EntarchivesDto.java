/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
 */
package com.icinfo.cs.sment.dto;

import java.math.BigDecimal;
import java.util.List;

import com.icinfo.cs.sment.model.Entarchives;
import com.icinfo.cs.sment.model.EntarchivesAdjust;
import com.icinfo.cs.sment.model.EntarchivesHelp;
import com.icinfo.cs.sment.model.EntarchivesOperate;

/**
 * 描述:   小微企业培育档案库 sm_bus_entarchives 对应的DTO类.<br>
 *
 * @author framework generator
 * @date 2017年04月27日
 */
public class EntarchivesDto extends Entarchives {

    private String                priPIDs;
    private Integer               operateYear;
    private Integer               helpYear;
    private EntarchivesOperate    entarchivesOperate;
    private List<EntarchivesHelp> entarchivesHelpList;
    private EntarchivesAdjust     entarchivesAdjust;
    private String                tsxzName;
    private String                kjfhyName;
    private String                kjdsyName;
    private String                XwqyyName;
    private String                qtName;
    private String                zckjName;
    
    //统计字段
    //培育库企业类型
    //1 初创型 2 成长型 3 领军型数量
    private Integer cultivationTypeCode1;
    private Integer cultivationTypeCode2;
    private Integer cultivationTypeCode3;
    
    //区域分类 
    private Integer tsxzCount;
    private Integer zckjCount;
    private Integer kjfhyCount;
    private Integer kjdsyCount;
    private Integer xwqyyCount;
    private Integer qtCount;
    private Integer wxzCount;
    
    //八大产业   信息经济产业  环保产业 旅游产业 金融产业 健康产业 时尚产业 高端装备制造产业 文化创意产业 未选择
    private Integer industryType1;
    private Integer industryType2;
    private Integer industryType3;
    private Integer industryType4;
    private Integer industryType5;
    private Integer industryType6;
    private Integer industryType7;
    private Integer industryType8;
    private Integer industryType9;
    
    //创业人群 毕业三年内大学生 高校科研院所专业技术人才  海外归国人才 返乡农民工 企业员工辞职创业 退役士兵 其他 未选择
    private Integer entCrowdCode1;
    private Integer entCrowdCode2;
    private Integer entCrowdCode3;
    private Integer entCrowdCode4;
    private Integer entCrowdCode5;
    private Integer entCrowdCode6;
    private Integer entCrowdCode7;
    private Integer entCrowdCode8;
    
    //成长轨迹
    private String year;
    //营业总收入
    private BigDecimal vendInc;
    //利润总额
    private BigDecimal proGro;
    //纳税总额
    private BigDecimal ratGro;


    public String getPriPIDs(){
        return priPIDs;
    }

    public void setPriPIDs(String priPIDs){
        this.priPIDs = priPIDs;
    }

    public EntarchivesOperate getEntarchivesOperate(){
        return entarchivesOperate;
    }

    public void setEntarchivesOperate(EntarchivesOperate entarchivesOperate){
        this.entarchivesOperate = entarchivesOperate;
    }

    public List<EntarchivesHelp> getEntarchivesHelpList(){
        return entarchivesHelpList;
    }

    public void setEntarchivesHelpList(List<EntarchivesHelp> entarchivesHelpList){
        this.entarchivesHelpList = entarchivesHelpList;
    }

    public EntarchivesAdjust getEntarchivesAdjust(){
        return entarchivesAdjust;
    }

    public void setEntarchivesAdjust(EntarchivesAdjust entarchivesAdjust){
        this.entarchivesAdjust = entarchivesAdjust;
    }

    public Integer getOperateYear(){
        return operateYear;
    }

    public void setOperateYear(Integer operateYear){
        this.operateYear = operateYear;
    }

    public Integer getHelpYear(){
        return helpYear;
    }

    public void setHelpYear(Integer helpYear){
        this.helpYear = helpYear;
    }

    public String getTsxzName(){
        return tsxzName;
    }

    public void setTsxzName(String tsxzName){
        this.tsxzName = tsxzName;
    }

    public String getKjfhyName(){
        return kjfhyName;
    }

    public void setKjfhyName(String kjfhyName){
        this.kjfhyName = kjfhyName;
    }

    public String getKjdsyName(){
        return kjdsyName;
    }

    public void setKjdsyName(String kjdsyName){
        this.kjdsyName = kjdsyName;
    }

    public String getQtName(){
        return qtName;
    }

    public void setQtName(String qtName){
        this.qtName = qtName;
    }

    
    public String getZckjName(){
        return zckjName;
    }

    
    public void setZckjName(String zckjName){
        this.zckjName = zckjName;
    }

	public Integer getCultivationTypeCode1() {
		return cultivationTypeCode1;
	}

	public void setCultivationTypeCode1(Integer cultivationTypeCode1) {
		this.cultivationTypeCode1 = cultivationTypeCode1;
	}

	public Integer getCultivationTypeCode2() {
		return cultivationTypeCode2;
	}

	public void setCultivationTypeCode2(Integer cultivationTypeCode2) {
		this.cultivationTypeCode2 = cultivationTypeCode2;
	}

	public Integer getCultivationTypeCode3() {
		return cultivationTypeCode3;
	}

	public void setCultivationTypeCode3(Integer cultivationTypeCode3) {
		this.cultivationTypeCode3 = cultivationTypeCode3;
	}

	public Integer getTsxzCount() {
		return tsxzCount;
	}

	public void setTsxzCount(Integer tsxzCount) {
		this.tsxzCount = tsxzCount;
	}

	public Integer getZckjCount() {
		return zckjCount;
	}

	public void setZckjCount(Integer zckjCount) {
		this.zckjCount = zckjCount;
	}

	public Integer getKjfhyCount() {
		return kjfhyCount;
	}

	public void setKjfhyCount(Integer kjfhyCount) {
		this.kjfhyCount = kjfhyCount;
	}

	public Integer getKjdsyCount() {
		return kjdsyCount;
	}

	public void setKjdsyCount(Integer kjdsyCount) {
		this.kjdsyCount = kjdsyCount;
	}

	public Integer getQtCount() {
		return qtCount;
	}

	public void setQtCount(Integer qtCount) {
		this.qtCount = qtCount;
	}

	public Integer getWxzCount() {
		return wxzCount;
	}

	public void setWxzCount(Integer wxzCount) {
		this.wxzCount = wxzCount;
	}

	public Integer getIndustryType1() {
		return industryType1;
	}

	public void setIndustryType1(Integer industryType1) {
		this.industryType1 = industryType1;
	}

	public Integer getIndustryType2() {
		return industryType2;
	}

	public void setIndustryType2(Integer industryType2) {
		this.industryType2 = industryType2;
	}

	public Integer getIndustryType3() {
		return industryType3;
	}

	public void setIndustryType3(Integer industryType3) {
		this.industryType3 = industryType3;
	}

	public Integer getIndustryType4() {
		return industryType4;
	}

	public void setIndustryType4(Integer industryType4) {
		this.industryType4 = industryType4;
	}

	public Integer getIndustryType5() {
		return industryType5;
	}

	public void setIndustryType5(Integer industryType5) {
		this.industryType5 = industryType5;
	}

	public Integer getIndustryType6() {
		return industryType6;
	}

	public void setIndustryType6(Integer industryType6) {
		this.industryType6 = industryType6;
	}

	public Integer getIndustryType7() {
		return industryType7;
	}

	public void setIndustryType7(Integer industryType7) {
		this.industryType7 = industryType7;
	}

	public Integer getIndustryType8() {
		return industryType8;
	}

	public void setIndustryType8(Integer industryType8) {
		this.industryType8 = industryType8;
	}

	public Integer getIndustryType9() {
		return industryType9;
	}

	public void setIndustryType9(Integer industryType9) {
		this.industryType9 = industryType9;
	}

	public Integer getEntCrowdCode1() {
		return entCrowdCode1;
	}

	public void setEntCrowdCode1(Integer entCrowdCode1) {
		this.entCrowdCode1 = entCrowdCode1;
	}

	public Integer getEntCrowdCode2() {
		return entCrowdCode2;
	}

	public void setEntCrowdCode2(Integer entCrowdCode2) {
		this.entCrowdCode2 = entCrowdCode2;
	}

	public Integer getEntCrowdCode3() {
		return entCrowdCode3;
	}

	public void setEntCrowdCode3(Integer entCrowdCode3) {
		this.entCrowdCode3 = entCrowdCode3;
	}

	public Integer getEntCrowdCode4() {
		return entCrowdCode4;
	}

	public void setEntCrowdCode4(Integer entCrowdCode4) {
		this.entCrowdCode4 = entCrowdCode4;
	}

	public Integer getEntCrowdCode5() {
		return entCrowdCode5;
	}

	public void setEntCrowdCode5(Integer entCrowdCode5) {
		this.entCrowdCode5 = entCrowdCode5;
	}

	public Integer getEntCrowdCode6() {
		return entCrowdCode6;
	}

	public void setEntCrowdCode6(Integer entCrowdCode6) {
		this.entCrowdCode6 = entCrowdCode6;
	}

	public Integer getEntCrowdCode7() {
		return entCrowdCode7;
	}

	public void setEntCrowdCode7(Integer entCrowdCode7) {
		this.entCrowdCode7 = entCrowdCode7;
	}

	public Integer getEntCrowdCode8() {
		return entCrowdCode8;
	}

	public void setEntCrowdCode8(Integer entCrowdCode8) {
		this.entCrowdCode8 = entCrowdCode8;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public BigDecimal getVendInc() {
		return vendInc;
	}

	public void setVendInc(BigDecimal vendInc) {
		this.vendInc = vendInc;
	}

	public BigDecimal getProGro() {
		return proGro;
	}

	public void setProGro(BigDecimal proGro) {
		this.proGro = proGro;
	}

	public BigDecimal getRatGro() {
		return ratGro;
	}

	public void setRatGro(BigDecimal ratGro) {
		this.ratGro = ratGro;
	}
	
	public void setXwqyyName(String xwqyyName) {
		XwqyyName = xwqyyName;
	}
	public String getXwqyyName() {
		return XwqyyName;
	}
	
	public void setXwqyyCount(Integer xwqyyCount) {
		this.xwqyyCount = xwqyyCount;
	}
	public Integer getXwqyyCount() {
		return xwqyyCount;
	}
	
	
	
    
    

}