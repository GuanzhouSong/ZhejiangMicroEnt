/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.es.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.framework.mybatis.mapper.annotation.Before;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * 描述:    cs_pub_illdisdetail 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2016年11月10日
 */
@Table(name = "cs_pub_illdisdetail")
public class CsPubIlldisdetail implements Serializable {
    /**
     * 自增序号
     */
    @Id
    @Column(name = "id")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    private Integer id;

    /**
     * 严重违法失信ID
     */
    @Column(name = "Illid")
    private String illid;

    /**
     * 主体身份代码
     */
    @Column(name = "PriPID")
    private String priPID;

    /**
     * 企业（机构）名称
     */
    @Column(name = "EntName")
    private String entName;

    /**
     * 统一社会信用代码
     */
    @Column(name = "uniscid")
    private String uniscid;

    /**
     * 注册号
     */
    @Column(name = "RegNo")
    private String regNo;

    /**
     * 法定代表人/负责人人员姓名
     */
    @Column(name = "Name")
    private String name;

    /**
     * 法定代表人/负责人证件类型
     */
    @Column(name = "CerType")
    private String cerType;

    /**
     * 法定代表人/负责人证件号码
     */
    @Column(name = "CerNO")
    private String cerNO;

    /**
     * 列入事由/情形
     */
    @Column(name = "Serillrea")
    private String serillrea;

    /**
     * 列入事由/情形（中文名称）
     */
    @Column(name = "Serillrea_CN")
    private String serillrea_CN;

    /**
     * 列入日期
     */
    @Column(name = "AbnTime")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date abnTime;

    /**
     * 列入作出决定机关
     */
    @Column(name = "DeCorg")
    private String deCorg;

    /**
     * 列入作出决定机关（中文名称）
     */
    @Column(name = "DeCorg_CN")
    private String deCorg_CN;

    /**
     * 列入文号
     */
    @Column(name = "DeDocNum")
    private String deDocNum;

    /**
     * 移出事由
     */
    @Column(name = "PeMexcPrexs")
    private String peMexcPrexs;

    /**
     * 移出事由（中文名称）
     */
    @Column(name = "PeMexcPrexs_CN")
    private String peMexcPrexs_CN;

    /**
     * 移出日期
     */
    @Column(name = "RemDate")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date remDate;

    /**
     * 移出作出决定机关
     */
    @Column(name = "ReCorg")
    private String reCorg;

    /**
     * 移出作出决定机关（中文名称）
     */
    @Column(name = "ReCorg_CN")
    private String reCorg_CN;

    /**
     * 移出文号
     */
    @Column(name = "ReCorgNum")
    private String reCorgNum;

    /**
     * 时间戳
     */
    @Column(name = "CreateTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;

    private static final long serialVersionUID = 1L;

    /**
     * 获取自增序号
     *
     * @return id - 自增序号
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置自增序号
     *
     * @param id 自增序号
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取严重违法失信ID
     *
     * @return Illid - 严重违法失信ID
     */
    public String getIllid() {
        return illid;
    }

    /**
     * 设置严重违法失信ID
     *
     * @param illid 严重违法失信ID
     */
    public void setIllid(String illid) {
        this.illid = illid;
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
     * 获取企业（机构）名称
     *
     * @return EntName - 企业（机构）名称
     */
    public String getEntName() {
        return entName;
    }

    /**
     * 设置企业（机构）名称
     *
     * @param entName 企业（机构）名称
     */
    public void setEntName(String entName) {
        this.entName = entName;
    }

    /**
     * 获取统一社会信用代码
     *
     * @return uniscid - 统一社会信用代码
     */
    public String getUniscid() {
        return uniscid;
    }

    /**
     * 设置统一社会信用代码
     *
     * @param uniscid 统一社会信用代码
     */
    public void setUniscid(String uniscid) {
        this.uniscid = uniscid;
    }

    /**
     * 获取注册号
     *
     * @return RegNo - 注册号
     */
    public String getRegNo() {
        return regNo;
    }

    /**
     * 设置注册号
     *
     * @param regNo 注册号
     */
    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    /**
     * 获取法定代表人/负责人人员姓名
     *
     * @return Name - 法定代表人/负责人人员姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置法定代表人/负责人人员姓名
     *
     * @param name 法定代表人/负责人人员姓名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取法定代表人/负责人证件类型
     *
     * @return CerType - 法定代表人/负责人证件类型
     */
    public String getCerType() {
        return cerType;
    }

    /**
     * 设置法定代表人/负责人证件类型
     *
     * @param cerType 法定代表人/负责人证件类型
     */
    public void setCerType(String cerType) {
        this.cerType = cerType;
    }

    /**
     * 获取法定代表人/负责人证件号码
     *
     * @return CerNO - 法定代表人/负责人证件号码
     */
    public String getCerNO() {
        return cerNO;
    }

    /**
     * 设置法定代表人/负责人证件号码
     *
     * @param cerNO 法定代表人/负责人证件号码
     */
    public void setCerNO(String cerNO) {
        this.cerNO = cerNO;
    }

    /**
     * 获取列入事由/情形
     *
     * @return Serillrea - 列入事由/情形
     */
    public String getSerillrea() {
        return serillrea;
    }

    /**
     * 设置列入事由/情形
     *
     * @param serillrea 列入事由/情形
     */
    public void setSerillrea(String serillrea) {
        this.serillrea = serillrea;
    }

    /**
     * 获取列入事由/情形（中文名称）
     *
     * @return Serillrea_CN - 列入事由/情形（中文名称）
     */
    public String getSerillrea_CN() {
        return serillrea_CN;
    }

    /**
     * 设置列入事由/情形（中文名称）
     *
     * @param serillrea_CN 列入事由/情形（中文名称）
     */
    public void setSerillrea_CN(String serillrea_CN) {
        this.serillrea_CN = serillrea_CN;
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
     * 获取列入作出决定机关
     *
     * @return DeCorg - 列入作出决定机关
     */
    public String getDeCorg() {
        return deCorg;
    }

    /**
     * 设置列入作出决定机关
     *
     * @param deCorg 列入作出决定机关
     */
    public void setDeCorg(String deCorg) {
        this.deCorg = deCorg;
    }

    /**
     * 获取列入作出决定机关（中文名称）
     *
     * @return DeCorg_CN - 列入作出决定机关（中文名称）
     */
    public String getDeCorg_CN() {
        return deCorg_CN;
    }

    /**
     * 设置列入作出决定机关（中文名称）
     *
     * @param deCorg_CN 列入作出决定机关（中文名称）
     */
    public void setDeCorg_CN(String deCorg_CN) {
        this.deCorg_CN = deCorg_CN;
    }

    /**
     * 获取列入文号
     *
     * @return DeDocNum - 列入文号
     */
    public String getDeDocNum() {
        return deDocNum;
    }

    /**
     * 设置列入文号
     *
     * @param deDocNum 列入文号
     */
    public void setDeDocNum(String deDocNum) {
        this.deDocNum = deDocNum;
    }

    /**
     * 获取移出事由
     *
     * @return PeMexcPrexs - 移出事由
     */
    public String getPeMexcPrexs() {
        return peMexcPrexs;
    }

    /**
     * 设置移出事由
     *
     * @param peMexcPrexs 移出事由
     */
    public void setPeMexcPrexs(String peMexcPrexs) {
        this.peMexcPrexs = peMexcPrexs;
    }

    /**
     * 获取移出事由（中文名称）
     *
     * @return PeMexcPrexs_CN - 移出事由（中文名称）
     */
    public String getPeMexcPrexs_CN() {
        return peMexcPrexs_CN;
    }

    /**
     * 设置移出事由（中文名称）
     *
     * @param peMexcPrexs_CN 移出事由（中文名称）
     */
    public void setPeMexcPrexs_CN(String peMexcPrexs_CN) {
        this.peMexcPrexs_CN = peMexcPrexs_CN;
    }

    /**
     * 获取移出日期
     *
     * @return RemDate - 移出日期
     */
    public Date getRemDate() {
        return remDate;
    }

    /**
     * 设置移出日期
     *
     * @param remDate 移出日期
     */
    public void setRemDate(Date remDate) {
        this.remDate = remDate;
    }

    /**
     * 获取移出作出决定机关
     *
     * @return ReCorg - 移出作出决定机关
     */
    public String getReCorg() {
        return reCorg;
    }

    /**
     * 设置移出作出决定机关
     *
     * @param reCorg 移出作出决定机关
     */
    public void setReCorg(String reCorg) {
        this.reCorg = reCorg;
    }

    /**
     * 获取移出作出决定机关（中文名称）
     *
     * @return ReCorg_CN - 移出作出决定机关（中文名称）
     */
    public String getReCorg_CN() {
        return reCorg_CN;
    }

    /**
     * 设置移出作出决定机关（中文名称）
     *
     * @param reCorg_CN 移出作出决定机关（中文名称）
     */
    public void setReCorg_CN(String reCorg_CN) {
        this.reCorg_CN = reCorg_CN;
    }

    /**
     * 获取移出文号
     *
     * @return ReCorgNum - 移出文号
     */
    public String getReCorgNum() {
        return reCorgNum;
    }

    /**
     * 设置移出文号
     *
     * @param reCorgNum 移出文号
     */
    public void setReCorgNum(String reCorgNum) {
        this.reCorgNum = reCorgNum;
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
    
    public String getRemDateFom(){
    	try {
			return DateUtil.dateToString(this.remDate, "yyyy年MM月dd日");
		} catch (Exception e) {
			return "";
		}
    }
    
    public String getAbnTimeFom(){
    	try {
			return DateUtil.dateToString(this.abnTime, "yyyy年MM月dd日");
		} catch (Exception e) {
			return "";
		}
    }
}