/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.ext.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 描述:    cs_mid_lerep 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2016年08月29日
 */
@Table(name = "cs_mid_lerep")
public class MidLeRep implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -5870727773064055653L;

	/**
     * ID
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
     * 国籍
     */
    @Column(name = "Country")
    private String country;

    /**
     * 姓名
     */
    @Column(name = "Name")
    private String name;

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
     * 职务（编码）
     */
    @Column(name = "LeRepPos")
    private String leRepPos;

    /**
     * 产生方式
     */
    @Column(name = "PosBrForm")
    private String posBrForm;

    /**
     * 性别
     */
    @Column(name = "Sex")
    private String sex;

    /**
     * 电话
     */
    @Column(name = "Tel")
    private String tel;

    /**
     * 现居住地
     */
    @Column(name = "HouseAdd")
    private String houseAdd;

    /**
     * 户籍地址
     */
    @Column(name = "RegPerResAddr")
    private String regPerResAddr;

    /**
     * 任命单位
     */
    @Column(name = "AppoUnit")
    private String appoUnit;

    /**
     * 移动电话
     */
    @Column(name = "MobTel")
    private String mobTel;

    /**
     * 文化程度
     */
    @Column(name = "LiteDeg")
    private String liteDeg;

    /**
     * 政治面貌
     */
    @Column(name = "PolStand")
    private String polStand;

    /**
     * 民族
     */
    @Column(name = "Nation")
    private String nation;

    /**
     * createTime
     */
    @Column(name = "CreateTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8") 
    private Date createTime;
    
    /**
     * updateTime
     */
    @Column(name = "update_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8") 
    private Date updateTime;

    public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	/**
     * 获取ID
     *
     * @return id - ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置ID
     *
     * @param id ID
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
     * 获取国籍
     *
     * @return Country - 国籍
     */
    public String getCountry() {
        return country;
    }

    /**
     * 设置国籍
     *
     * @param country 国籍
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * 获取姓名
     *
     * @return Name - 姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置姓名
     *
     * @param name 姓名
     */
    public void setName(String name) {
        this.name = name;
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
     * 获取职务（编码）
     *
     * @return LeRepPos - 职务（编码）
     */
    public String getLeRepPos() {
        return leRepPos;
    }

    /**
     * 设置职务（编码）
     *
     * @param leRepPos 职务（编码）
     */
    public void setLeRepPos(String leRepPos) {
        this.leRepPos = leRepPos;
    }

    /**
     * 获取产生方式
     *
     * @return PosBrForm - 产生方式
     */
    public String getPosBrForm() {
        return posBrForm;
    }

    /**
     * 设置产生方式
     *
     * @param posBrForm 产生方式
     */
    public void setPosBrForm(String posBrForm) {
        this.posBrForm = posBrForm;
    }

    /**
     * 获取性别
     *
     * @return Sex - 性别
     */
    public String getSex() {
        return sex;
    }

    /**
     * 设置性别
     *
     * @param sex 性别
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * 获取电话
     *
     * @return Tel - 电话
     */
    public String getTel() {
        return tel;
    }

    /**
     * 设置电话
     *
     * @param tel 电话
     */
    public void setTel(String tel) {
        this.tel = tel;
    }

    /**
     * 获取现居住地
     *
     * @return HouseAdd - 现居住地
     */
    public String getHouseAdd() {
        return houseAdd;
    }

    /**
     * 设置现居住地
     *
     * @param houseAdd 现居住地
     */
    public void setHouseAdd(String houseAdd) {
        this.houseAdd = houseAdd;
    }

    /**
     * 获取户籍地址
     *
     * @return RegPerResAddr - 户籍地址
     */
    public String getRegPerResAddr() {
        return regPerResAddr;
    }

    /**
     * 设置户籍地址
     *
     * @param regPerResAddr 户籍地址
     */
    public void setRegPerResAddr(String regPerResAddr) {
        this.regPerResAddr = regPerResAddr;
    }

    /**
     * 获取任命单位
     *
     * @return AppoUnit - 任命单位
     */
    public String getAppoUnit() {
        return appoUnit;
    }

    /**
     * 设置任命单位
     *
     * @param appoUnit 任命单位
     */
    public void setAppoUnit(String appoUnit) {
        this.appoUnit = appoUnit;
    }

    /**
     * 获取移动电话
     *
     * @return MobTel - 移动电话
     */
    public String getMobTel() {
        return mobTel;
    }

    /**
     * 设置移动电话
     *
     * @param mobTel 移动电话
     */
    public void setMobTel(String mobTel) {
        this.mobTel = mobTel;
    }

    /**
     * 获取文化程度
     *
     * @return LiteDeg - 文化程度
     */
    public String getLiteDeg() {
        return liteDeg;
    }

    /**
     * 设置文化程度
     *
     * @param liteDeg 文化程度
     */
    public void setLiteDeg(String liteDeg) {
        this.liteDeg = liteDeg;
    }

    /**
     * 获取政治面貌
     *
     * @return PolStand - 政治面貌
     */
    public String getPolStand() {
        return polStand;
    }

    /**
     * 设置政治面貌
     *
     * @param polStand 政治面貌
     */
    public void setPolStand(String polStand) {
        this.polStand = polStand;
    }

    /**
     * 获取民族
     *
     * @return Nation - 民族
     */
    public String getNation() {
        return nation;
    }

    /**
     * 设置民族
     *
     * @param nation 民族
     */
    public void setNation(String nation) {
        this.nation = nation;
    }

    /**
     * 获取createTime
     *
     * @return CreateTime - createTime
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置createTime
     *
     * @param createTime createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}