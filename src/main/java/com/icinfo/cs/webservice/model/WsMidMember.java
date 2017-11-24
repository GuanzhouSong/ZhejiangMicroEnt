/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.webservice.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.icinfo.framework.mybatis.mapper.annotation.Before;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * 描述:    cs_mid_member 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年02月17日
 */
@Table(name = "cs_mid_member")
public class WsMidMember implements Serializable {
    @Id
    @Column(name = "id")
//    @Before
//    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    private Integer id;

    /**
     * 内部序号
     */
    @Column(name = "PriPID")
    private String priPID;

    /**
     * 证件名称
     */
    @Column(name = "CerType")
    private String cerType;

    /**
     * 证件号码
     */
    @Column(name = "CerNO")
    private String cerNO;

    /**
     * 职位（编码）
     */
    @Column(name = "Position")
    private String position;

    /**
     * 人员序号
     */
    @Column(name = "StaffNO")
    private String staffNO;

    /**
     * 姓名
     */
    @Column(name = "Name")
    private String name;

    /**
     * 国籍
     */
    @Column(name = "Country")
    private String country;

    /**
     * 性别
     */
    @Column(name = "Sex")
    private String sex;

    /**
     * 出生年月
     */
    @Column(name = "NatDate")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date natDate;

    /**
     * 民族
     */
    @Column(name = "Nation")
    private String nation;

    /**
     * 政治面貌
     */
    @Column(name = "PolStand")
    private String polStand;

    /**
     * 文化程度
     */
    @Column(name = "LiteDeg")
    private String liteDeg;

    /**
     * 技术职称
     */
    @Column(name = "Occupation")
    private String occupation;

    /**
     * 技术特长
     */
    @Column(name = "TechExpertise")
    private String techExpertise;

    /**
     * 健康状况
     */
    @Column(name = "Health")
    private String health;

    /**
     * 户籍地址
     */
    @Column(name = "RegPerResAddr")
    private String regPerResAddr;

    /**
     * 所属行政区划
     */
    @Column(name = "AddrDistrict")
    private String addrDistrict;

    /**
     * 电话
     */
    @Column(name = "Tel")
    private String tel;

    /**
     * 邮政编码
     */
    @Column(name = "PostalCode")
    private String postalCode;

    /**
     * 现住地址
     */
    @Column(name = "ResAdd")
    private String resAdd;

    /**
     * 社会职务
     */
    @Column(name = "SocPosition")
    private String socPosition;

    /**
     * 产生方式
     */
    @Column(name = "PosBrForm")
    private String posBrForm;

    /**
     * 时间戳
     */
    @Column(name = "CreateTime")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date createTime;

    /**
     * 职务
     */
    @Column(name = "PositionName")
    private String positionName;

    /**
     * 人员类型
     */
    @Column(name = "PerKind")
    private String perKind;

    /**
     * 简历
     */
    @Column(name = "Resu")
    private String resu;

    /**
     * 备注
     */
    @Column(name = "Remark")
    private String remark;

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
     * 获取证件名称
     *
     * @return CerType - 证件名称
     */
    public String getCerType() {
        return cerType;
    }

    /**
     * 设置证件名称
     *
     * @param cerType 证件名称
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
     * 获取职位（编码）
     *
     * @return Position - 职位（编码）
     */
    public String getPosition() {
        return position;
    }

    /**
     * 设置职位（编码）
     *
     * @param position 职位（编码）
     */
    public void setPosition(String position) {
        this.position = position;
    }

    /**
     * 获取人员序号
     *
     * @return StaffNO - 人员序号
     */
    public String getStaffNO() {
        return staffNO;
    }

    /**
     * 设置人员序号
     *
     * @param staffNO 人员序号
     */
    public void setStaffNO(String staffNO) {
        this.staffNO = staffNO;
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
     * 获取出生年月
     *
     * @return NatDate - 出生年月
     */
    public Date getNatDate() {
        return natDate;
    }

    /**
     * 设置出生年月
     *
     * @param natDate 出生年月
     */
    public void setNatDate(Date natDate) {
        this.natDate = natDate;
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
     * 获取技术职称
     *
     * @return Occupation - 技术职称
     */
    public String getOccupation() {
        return occupation;
    }

    /**
     * 设置技术职称
     *
     * @param occupation 技术职称
     */
    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    /**
     * 获取技术特长
     *
     * @return TechExpertise - 技术特长
     */
    public String getTechExpertise() {
        return techExpertise;
    }

    /**
     * 设置技术特长
     *
     * @param techExpertise 技术特长
     */
    public void setTechExpertise(String techExpertise) {
        this.techExpertise = techExpertise;
    }

    /**
     * 获取健康状况
     *
     * @return Health - 健康状况
     */
    public String getHealth() {
        return health;
    }

    /**
     * 设置健康状况
     *
     * @param health 健康状况
     */
    public void setHealth(String health) {
        this.health = health;
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
     * 获取所属行政区划
     *
     * @return AddrDistrict - 所属行政区划
     */
    public String getAddrDistrict() {
        return addrDistrict;
    }

    /**
     * 设置所属行政区划
     *
     * @param addrDistrict 所属行政区划
     */
    public void setAddrDistrict(String addrDistrict) {
        this.addrDistrict = addrDistrict;
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
     * 获取邮政编码
     *
     * @return PostalCode - 邮政编码
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * 设置邮政编码
     *
     * @param postalCode 邮政编码
     */
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    /**
     * 获取现住地址
     *
     * @return ResAdd - 现住地址
     */
    public String getResAdd() {
        return resAdd;
    }

    /**
     * 设置现住地址
     *
     * @param resAdd 现住地址
     */
    public void setResAdd(String resAdd) {
        this.resAdd = resAdd;
    }

    /**
     * 获取社会职务
     *
     * @return SocPosition - 社会职务
     */
    public String getSocPosition() {
        return socPosition;
    }

    /**
     * 设置社会职务
     *
     * @param socPosition 社会职务
     */
    public void setSocPosition(String socPosition) {
        this.socPosition = socPosition;
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
     * 获取职务
     *
     * @return PositionName - 职务
     */
    public String getPositionName() {
        return positionName;
    }

    /**
     * 设置职务
     *
     * @param positionName 职务
     */
    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    /**
     * 获取人员类型
     *
     * @return PerKind - 人员类型
     */
    public String getPerKind() {
        return perKind;
    }

    /**
     * 设置人员类型
     *
     * @param perKind 人员类型
     */
    public void setPerKind(String perKind) {
        this.perKind = perKind;
    }

    /**
     * 获取简历
     *
     * @return Resu - 简历
     */
    public String getResu() {
        return resu;
    }

    /**
     * 设置简历
     *
     * @param resu 简历
     */
    public void setResu(String resu) {
        this.resu = resu;
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
}