/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.yr.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.icinfo.framework.mybatis.mapper.annotation.Before;

/**
 * 描述:    cs_foodstorage_info 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2016年09月26日
 */
@Table(name = "cs_foodstorage_info")
public class FoodstorageInfo implements Serializable {
    /**
     * 主键id
     */
    @Id
    @Column(name = "id")
    private Integer id;

    /**
     * 序号
     */
    @Column(name = "FsinfoID")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    private String fsinfoID;

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
     * 年度
     */
    @Column(name = "Year")
    private Integer year;

    /**
     * 注册号
     */
    @Column(name = "RegNO")
    private String regNO;

    /**
     * 法定代表人
     */
    @Column(name = "LeRep")
    private String leRep;

    /**
     * 法定代表人电话
     */
    @Column(name = "Tel")
    private String tel;

    /**
     * 仓库地址
     */
    @Column(name = "WareAddr")
    private String wareAddr;

    /**
     * 注册地址
     */
    @Column(name = "Addr")
    private String addr;

    /**
     * 仓库负责人
     */
    @Column(name = "Linkman")
    private String linkman;

    /**
     * 仓库负责人电话
     */
    @Column(name = "Linktel")
    private String linktel;

    /**
     * 仓储从业人员数
     */
    @Column(name = "EmpNum")
    private Integer empNum;

    /**
     * 仓库面积
     */
    @Column(name = "OpSpace")
    private BigDecimal opSpace;

    /**
     * 填写时间
     */
    @Column(name = "SetTime")
    private Date setTime;

    /**
     * 更新时间
     */
    @Column(name = "CreateTime")
    private Date createTime;

    /**
     * 状态：暂存1，提交2
     */
    @Column(name = "SubmitState")
    private String submitState;

    private static final long serialVersionUID = 1L;

    /**
     * 获取主键id
     *
     * @return id - 主键id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置主键id
     *
     * @param id 主键id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取序号
     *
     * @return FsinfoID - 序号
     */
    public String getFsinfoID() {
        return fsinfoID;
    }

    /**
     * 设置序号
     *
     * @param fsinfoID 序号
     */
    public void setFsinfoID(String fsinfoID) {
        this.fsinfoID = fsinfoID;
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
     * 获取法定代表人电话
     *
     * @return Tel - 法定代表人电话
     */
    public String getTel() {
        return tel;
    }

    /**
     * 设置法定代表人电话
     *
     * @param tel 法定代表人电话
     */
    public void setTel(String tel) {
        this.tel = tel;
    }

    /**
     * 获取仓库地址
     *
     * @return WareAddr - 仓库地址
     */
    public String getWareAddr() {
        return wareAddr;
    }

    /**
     * 设置仓库地址
     *
     * @param wareAddr 仓库地址
     */
    public void setWareAddr(String wareAddr) {
        this.wareAddr = wareAddr;
    }

    /**
     * 获取注册地址
     *
     * @return Addr - 注册地址
     */
    public String getAddr() {
        return addr;
    }

    /**
     * 设置注册地址
     *
     * @param addr 注册地址
     */
    public void setAddr(String addr) {
        this.addr = addr;
    }

    /**
     * 获取仓库负责人
     *
     * @return Linkman - 仓库负责人
     */
    public String getLinkman() {
        return linkman;
    }

    /**
     * 设置仓库负责人
     *
     * @param linkman 仓库负责人
     */
    public void setLinkman(String linkman) {
        this.linkman = linkman;
    }

    /**
     * 获取仓库负责人电话
     *
     * @return Linktel - 仓库负责人电话
     */
    public String getLinktel() {
        return linktel;
    }

    /**
     * 设置仓库负责人电话
     *
     * @param linktel 仓库负责人电话
     */
    public void setLinktel(String linktel) {
        this.linktel = linktel;
    }

    /**
     * 获取仓储从业人员数
     *
     * @return EmpNum - 仓储从业人员数
     */
    public Integer getEmpNum() {
        return empNum;
    }

    /**
     * 设置仓储从业人员数
     *
     * @param empNum 仓储从业人员数
     */
    public void setEmpNum(Integer empNum) {
        this.empNum = empNum;
    }

    /**
     * 获取仓库面积
     *
     * @return OpSpace - 仓库面积
     */
    public BigDecimal getOpSpace() {
        return opSpace;
    }

    /**
     * 设置仓库面积
     *
     * @param opSpace 仓库面积
     */
    public void setOpSpace(BigDecimal opSpace) {
        this.opSpace = opSpace;
    }

    /**
     * 获取填写时间
     *
     * @return SetTime - 填写时间
     */
    public Date getSetTime() {
        return setTime;
    }

    /**
     * 设置填写时间
     *
     * @param setTime 填写时间
     */
    public void setSetTime(Date setTime) {
        this.setTime = setTime;
    }

    /**
     * 获取更新时间
     *
     * @return CreateTime - 更新时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置更新时间
     *
     * @param createTime 更新时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取状态：暂存1，提交2
     *
     * @return SubmitState - 状态：暂存1，提交2
     */
    public String getSubmitState() {
        return submitState;
    }

    /**
     * 设置状态：暂存1，提交2
     *
     * @param submitState 状态：暂存1，提交2
     */
    public void setSubmitState(String submitState) {
        this.submitState = submitState;
    }
    
    @Override
   	public String toString() {
   		return "FoodstorageInfo [id=" + id + ", fsinfoID=" + fsinfoID + ", priPID="
   				+ priPID + ", entName=" + entName + ", year="
   				+ year + ", regNO=" + regNO + ", leRep="
   				+ leRep + ", tel=" + tel + ", wareAddr=" + wareAddr
   				+ ", addr=" + addr + ", linkman=" + linkman + ", linktel=" + linktel 
   				+ ", empNum=" + empNum + ", opSpace=" + opSpace + ""
   				+ ", setTime=" + setTime + ", createTime=" + createTime + ""
   				+ ", submitState=" + submitState + "]";
   	}
}